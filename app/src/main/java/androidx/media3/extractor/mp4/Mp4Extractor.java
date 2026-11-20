package androidx.media3.extractor.mp4;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Latch;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box$ContainerBox;
import androidx.media3.container.Mp4Box$LeafBox;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.MpegAudioUtil$Header;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.metadata.MotionPhotoMetadata;
import androidx.media3.extractor.metadata.ThumbnailMetadata;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.extractor.text.CueDecoder;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp4Extractor implements Extractor {
    public long[][] accumulatedSampleSizes;
    public ParsableByteArray atomData;
    public final ParsableByteArray atomHeader;
    public int atomHeaderBytesRead;
    public long atomSize;
    public int atomType;
    public long axteAtomOffset;
    public final ArrayDeque containerAtoms;
    public ExtractorOutput extractorOutput;
    public int fileType;
    public final int flags;
    public boolean isSampleDependedOn;
    public RegularImmutableList lastSniffFailures;
    public boolean moovAtomProcessed;
    public MotionPhotoMetadata motionPhotoMetadata;
    public final ParsableByteArray nalPrefix;
    public final ParsableByteArray nalStartCode;
    public final boolean omitTrackSampleTable;
    public int parserState;
    public boolean readingAuxiliaryTracks;
    public int sampleBytesRead;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public long sampleOffsetForAuxiliaryTracks;
    public int sampleTrackIndex;
    public final ParsableByteArray scratch;
    public boolean seekToAxteAtom;
    public boolean seenFtypAtom;
    public final SefReader sefReader;
    public final ArrayList slowMotionMetadataEntries;
    public final CueDecoder subtitleParserFactory;
    public Mp4Track[] tracks;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Mp4SeekMap implements SeekMap {
        public final long durationUs;
        public final int firstVideoTrackIndex;
        public final Mp4Track[] tracks;

        public Mp4SeekMap(long j, Mp4Track[] mp4TrackArr, int i) {
            this.durationUs = j;
            this.tracks = mp4TrackArr;
            this.firstVideoTrackIndex = i;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long getDurationUs() {
            return this.durationUs;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x005f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:29:0x0061  */
        /* JADX WARN: Code duplicated, block: B:31:0x0072  */
        /* JADX WARN: Code duplicated, block: B:34:0x0079  */
        /* JADX WARN: Code duplicated, block: B:37:0x0083  */
        /* JADX WARN: Code duplicated, block: B:39:0x0089  */
        /* JADX WARN: Code duplicated, block: B:42:0x0090  */
        /* JADX WARN: Code duplicated, block: B:43:0x0097  */
        /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:49:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:53:0x009c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:55:0x009c A[SYNTHETIC] */
        @Override // androidx.media3.extractor.SeekMap
        public final SeekMap.SeekPoints getSeekPoints(long j) {
            long j2;
            long j3;
            long jMin;
            long j4;
            int i;
            long jMin2;
            TrackSampleTable trackSampleTable;
            long[] jArr;
            int indexOfEarlierOrEqualSynchronizationSample;
            int indexOfEarlierOrEqualSynchronizationSample2;
            int indexOfLaterOrEqualSynchronizationSample;
            Mp4Track[] mp4TrackArr = this.tracks;
            int length = mp4TrackArr.length;
            SeekPoint seekPoint = SeekPoint.START;
            if (length == 0) {
                return new SeekMap.SeekPoints(seekPoint, seekPoint);
            }
            int i2 = this.firstVideoTrackIndex;
            if (i2 != -1) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr[i2].sampleTable;
                int indexOfEarlierOrEqualSynchronizationSample3 = trackSampleTable2.getIndexOfEarlierOrEqualSynchronizationSample(j);
                if (indexOfEarlierOrEqualSynchronizationSample3 == -1) {
                    indexOfEarlierOrEqualSynchronizationSample3 = trackSampleTable2.getIndexOfLaterOrEqualSynchronizationSample(j);
                }
                long[] jArr2 = trackSampleTable2.offsets;
                long[] jArr3 = trackSampleTable2.timestampsUs;
                if (indexOfEarlierOrEqualSynchronizationSample3 == -1) {
                    return new SeekMap.SeekPoints(seekPoint, seekPoint);
                }
                j3 = jArr3[indexOfEarlierOrEqualSynchronizationSample3];
                j2 = jArr2[indexOfEarlierOrEqualSynchronizationSample3];
                if (j3 < j && indexOfEarlierOrEqualSynchronizationSample3 < trackSampleTable2.sampleCount - 1 && (indexOfLaterOrEqualSynchronizationSample = trackSampleTable2.getIndexOfLaterOrEqualSynchronizationSample(j)) != -1 && indexOfLaterOrEqualSynchronizationSample != indexOfEarlierOrEqualSynchronizationSample3) {
                    j4 = jArr3[indexOfLaterOrEqualSynchronizationSample];
                    jMin = jArr2[indexOfLaterOrEqualSynchronizationSample];
                }
                jMin2 = j2;
                for (i = 0; i < mp4TrackArr.length; i++) {
                    if (i != i2) {
                        trackSampleTable = mp4TrackArr[i].sampleTable;
                        jArr = trackSampleTable.offsets;
                        indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j3);
                        if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                            indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j3);
                        }
                        if (indexOfEarlierOrEqualSynchronizationSample != -1) {
                            jMin2 = Math.min(jArr[indexOfEarlierOrEqualSynchronizationSample], jMin2);
                        }
                        if (j4 == -9223372036854775807L) {
                            indexOfEarlierOrEqualSynchronizationSample2 = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j4);
                            if (indexOfEarlierOrEqualSynchronizationSample2 == -1) {
                                indexOfEarlierOrEqualSynchronizationSample2 = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j4);
                            }
                            if (indexOfEarlierOrEqualSynchronizationSample2 == -1) {
                                jMin = Math.min(jArr[indexOfEarlierOrEqualSynchronizationSample2], jMin);
                            }
                        }
                    }
                }
                SeekPoint seekPoint2 = new SeekPoint(j3, jMin2);
                return j4 == -9223372036854775807L ? new SeekMap.SeekPoints(seekPoint2, seekPoint2) : new SeekMap.SeekPoints(seekPoint2, new SeekPoint(j4, jMin));
            }
            j2 = Long.MAX_VALUE;
            j3 = j;
            jMin = -1;
            j4 = -9223372036854775807L;
            jMin2 = j2;
            while (i < mp4TrackArr.length) {
                if (i != i2) {
                    trackSampleTable = mp4TrackArr[i].sampleTable;
                    jArr = trackSampleTable.offsets;
                    indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j3);
                    if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                        indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j3);
                    }
                    if (indexOfEarlierOrEqualSynchronizationSample != -1) {
                        jMin2 = Math.min(jArr[indexOfEarlierOrEqualSynchronizationSample], jMin2);
                    }
                    if (j4 == -9223372036854775807L) {
                        indexOfEarlierOrEqualSynchronizationSample2 = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j4);
                        if (indexOfEarlierOrEqualSynchronizationSample2 == -1) {
                            indexOfEarlierOrEqualSynchronizationSample2 = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j4);
                        }
                        if (indexOfEarlierOrEqualSynchronizationSample2 == -1) {
                            jMin = Math.min(jArr[indexOfEarlierOrEqualSynchronizationSample2], jMin);
                        }
                    }
                }
            }
            SeekPoint seekPoint3 = new SeekPoint(j3, jMin2);
            if (j4 == -9223372036854775807L) {
            }
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Mp4Track {
        public Format pendingFormat;
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;
        public final TrueHdSampleRechunker trueHdSampleRechunker;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput;
            this.trueHdSampleRechunker = "audio/true-hd".equals(track.format.sampleMimeType) ? new TrueHdSampleRechunker() : null;
        }
    }

    public Mp4Extractor(int i, CueDecoder cueDecoder) {
        this.subtitleParserFactory = cueDecoder;
        this.flags = i;
        this.omitTrackSampleTable = (i & 256) != 0;
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        this.lastSniffFailures = RegularImmutableList.EMPTY;
        this.parserState = (i & 4) != 0 ? 3 : 0;
        this.sefReader = new SefReader();
        this.slowMotionMetadataEntries = new ArrayList();
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque();
        this.nalStartCode = new ParsableByteArray(OpusUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(6);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.tracks = new Mp4Track[0];
    }

    @Override // androidx.media3.extractor.Extractor
    public final List getSniffFailureDetails() {
        return this.lastSniffFailures;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        if ((this.flags & 16) == 0) {
            extractorOutput = new Latch(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
    }

    /* JADX WARN: Code duplicated, block: B:164:0x0311  */
    /* JADX WARN: Code duplicated, block: B:165:0x0321  */
    /* JADX WARN: Code duplicated, block: B:174:0x033c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0342  */
    /* JADX WARN: Code duplicated, block: B:179:0x035d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0366  */
    /* JADX WARN: Code duplicated, block: B:20:0x006e  */
    /* JADX WARN: Code duplicated, block: B:264:0x0134 A[EDGE_INSN: B:264:0x0134->B:74:0x0134 BREAK  A[LOOP:9: B:62:0x0102->B:72:0x012c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:72:0x012c A[LOOP:9: B:62:0x0102->B:72:0x012c, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void processAtomEnded$1(long j) {
        int i;
        ArrayList arrayList;
        Metadata mdtaFromMeta;
        boolean z;
        ArrayDeque arrayDeque;
        boolean z2;
        Metadata udta;
        long[][] jArr;
        String str;
        int i2;
        long j2;
        int i3;
        Metadata metadata;
        ArrayList arrayList2;
        Metadata metadata2;
        Metadata metadata3;
        Metadata metadata4;
        ArrayList arrayList3;
        int i4;
        int i5;
        int i6;
        int i7;
        Metadata.Entry entry;
        Metadata.Entry entry2;
        Metadata.Entry entry3;
        int i8;
        while (true) {
            ArrayDeque arrayDeque2 = this.containerAtoms;
            int i9 = 0;
            if (arrayDeque2.isEmpty() || ((Mp4Box$ContainerBox) arrayDeque2.peek()).endPosition != j) {
                break;
            }
            Mp4Box$ContainerBox mp4Box$ContainerBox = (Mp4Box$ContainerBox) arrayDeque2.pop();
            if (mp4Box$ContainerBox.flags == 1836019574) {
                Mp4Box$ContainerBox containerBoxOfType = mp4Box$ContainerBox.getContainerBoxOfType(1835365473);
                ArrayList arrayList4 = new ArrayList();
                boolean z3 = this.omitTrackSampleTable;
                long j3 = 0;
                int i10 = this.flags;
                if (containerBoxOfType != null) {
                    mdtaFromMeta = BoxParser.parseMdtaFromMeta(containerBoxOfType);
                    if (this.readingAuxiliaryTracks) {
                        mdtaFromMeta.getClass();
                        Metadata.Entry[] entryArr = mdtaFromMeta.entries;
                        int length = entryArr.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                entry2 = null;
                                break;
                            }
                            Metadata.Entry entry4 = entryArr[i11];
                            if (MdtaMetadataEntry.class.isAssignableFrom(entry4.getClass())) {
                                entry2 = (Metadata.Entry) MdtaMetadataEntry.class.cast(entry4);
                                if (!((MdtaMetadataEntry) entry2).key.equals("auxiliary.tracks.interleaved")) {
                                    entry2 = null;
                                }
                            } else {
                                entry2 = null;
                            }
                            if (entry2 != null) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry2;
                        if (mdtaMetadataEntry != null && mdtaMetadataEntry.value[0] == 0) {
                            this.sampleOffsetForAuxiliaryTracks = this.axteAtomOffset + 16;
                        }
                        int length2 = entryArr.length;
                        int i12 = 0;
                        while (true) {
                            if (i12 >= length2) {
                                entry3 = null;
                                break;
                            }
                            Metadata.Entry entry5 = entryArr[i12];
                            if (MdtaMetadataEntry.class.isAssignableFrom(entry5.getClass())) {
                                entry3 = (Metadata.Entry) MdtaMetadataEntry.class.cast(entry5);
                                if (!((MdtaMetadataEntry) entry3).key.equals("auxiliary.tracks.map")) {
                                    entry3 = null;
                                }
                            } else {
                                entry3 = null;
                            }
                            if (entry3 != null) {
                                break;
                            } else {
                                i12++;
                            }
                        }
                        MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry3;
                        mdtaMetadataEntry2.getClass();
                        ArrayList auxiliaryTrackTypesFromMap = mdtaMetadataEntry2.getAuxiliaryTrackTypesFromMap();
                        ArrayList arrayList5 = new ArrayList(auxiliaryTrackTypesFromMap.size());
                        for (int i13 = 0; i13 < auxiliaryTrackTypesFromMap.size(); i13++) {
                            int iIntValue = ((Integer) auxiliaryTrackTypesFromMap.get(i13)).intValue();
                            if (iIntValue == 0) {
                                i8 = 1;
                            } else if (iIntValue != 1) {
                                i8 = 3;
                                if (iIntValue != 2) {
                                    i8 = iIntValue != 3 ? 0 : 4;
                                }
                            } else {
                                i8 = 2;
                            }
                            arrayList5.add(Integer.valueOf(i8));
                        }
                        i = 0;
                        arrayList = arrayList5;
                    } else {
                        if (mdtaFromMeta == null || (i10 & 64) == 0) {
                            i = 0;
                        } else {
                            Metadata.Entry[] entryArr2 = mdtaFromMeta.entries;
                            int length3 = entryArr2.length;
                            int i14 = 0;
                            while (true) {
                                if (i14 >= length3) {
                                    i = i9;
                                    entry = null;
                                    break;
                                }
                                Metadata.Entry entry6 = entryArr2[i14];
                                if (MdtaMetadataEntry.class.isAssignableFrom(entry6.getClass())) {
                                    entry = (Metadata.Entry) MdtaMetadataEntry.class.cast(entry6);
                                    i = i9;
                                    if (!((MdtaMetadataEntry) entry).key.equals("auxiliary.tracks.offset")) {
                                    }
                                    if (entry != null) {
                                        break;
                                    }
                                    i14++;
                                    i9 = i;
                                } else {
                                    i = i9;
                                }
                                entry = null;
                                if (entry != null) {
                                    break;
                                    break;
                                } else {
                                    i14++;
                                    i9 = i;
                                }
                            }
                            MdtaMetadataEntry mdtaMetadataEntry3 = (MdtaMetadataEntry) entry;
                            if (mdtaMetadataEntry3 != null) {
                                long unsignedLongToLong = new ParsableByteArray(mdtaMetadataEntry3.value).readUnsignedLongToLong();
                                if (unsignedLongToLong > 0) {
                                    this.axteAtomOffset = unsignedLongToLong;
                                    this.seekToAxteAtom = true;
                                    arrayDeque = arrayDeque2;
                                    z2 = true;
                                    z = z3;
                                }
                                arrayDeque.clear();
                                this.moovAtomProcessed = z2;
                                if (this.seekToAxteAtom && !z) {
                                    this.parserState = 2;
                                }
                            }
                        }
                        arrayList = arrayList4;
                    }
                } else {
                    i = 0;
                    arrayList = arrayList4;
                    mdtaFromMeta = null;
                }
                ArrayList arrayList6 = new ArrayList();
                boolean z4 = this.fileType == 1 ? 1 : i;
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                Mp4Box$LeafBox leafBoxOfType = mp4Box$ContainerBox.getLeafBoxOfType(1969517665);
                if (leafBoxOfType != null) {
                    udta = BoxParser.parseUdta(leafBoxOfType);
                    gaplessInfoHolder.setFromMetadata(udta);
                } else {
                    udta = null;
                }
                Mp4Box$LeafBox leafBoxOfType2 = mp4Box$ContainerBox.getLeafBoxOfType(1836476516);
                leafBoxOfType2.getClass();
                Metadata.Entry[] entryArr3 = new Metadata.Entry[1];
                entryArr3[i] = BoxParser.parseMvhd(leafBoxOfType2.data);
                Metadata metadata5 = new Metadata(entryArr3);
                Metadata metadata6 = udta;
                ArrayList traks = BoxParser.parseTraks(mp4Box$ContainerBox, gaplessInfoHolder, -9223372036854775807L, null, (i10 & 1) != 0 ? 1 : i, z4, new Format$$ExternalSyntheticLambda1((byte) 17), this.omitTrackSampleTable);
                if (this.readingAuxiliaryTracks) {
                    boolean z5 = arrayList.size() == traks.size() ? 1 : i;
                    Locale locale = Locale.US;
                    UtilsKt.checkState(IntIntPair$$ExternalSyntheticOutline0.m(arrayList.size(), "The number of auxiliary track types from metadata (", ") is not same as the number of auxiliary tracks (", traks.size(), ")"), z5);
                }
                String containerMimeType = Sniffer.getContainerMimeType(traks);
                int i15 = i;
                int i16 = i15;
                long j4 = -9223372036854775807L;
                int size = -1;
                while (i15 < traks.size()) {
                    TrackSampleTable trackSampleTable = (TrackSampleTable) traks.get(i15);
                    int i17 = trackSampleTable.sampleCount;
                    ArrayDeque arrayDeque3 = arrayDeque2;
                    long[] jArr2 = trackSampleTable.timestampsUs;
                    Track track = trackSampleTable.track;
                    if (i17 == 0) {
                        arrayList = arrayList;
                        str = containerMimeType;
                        i2 = i15;
                        arrayList3 = arrayList6;
                        metadata3 = metadata6;
                        metadata4 = metadata5;
                    } else {
                        str = containerMimeType;
                        ExtractorOutput extractorOutput = this.extractorOutput;
                        int i18 = i16 + 1;
                        int i19 = track.type;
                        ArrayList arrayList7 = arrayList6;
                        Format format = track.format;
                        TrackOutput trackOutputTrack = extractorOutput.track(i16, i19);
                        Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, trackOutputTrack);
                        long j5 = track.durationUs;
                        if (j5 == -9223372036854775807L) {
                            j5 = trackSampleTable.durationUs;
                        }
                        trackOutputTrack.durationUs(j5);
                        long jMax = Math.max(j4, j5);
                        String str2 = format.sampleMimeType;
                        String str3 = format.sampleMimeType;
                        boolean zEquals = "audio/true-hd".equals(str2);
                        int i20 = trackSampleTable.maximumSize;
                        int i21 = zEquals ? i20 * 16 : i20 + 30;
                        Format.Builder builderBuildUpon = format.buildUpon();
                        builderBuildUpon.maxInputSize = i21;
                        if (i19 == 2) {
                            int i22 = format.roleFlags;
                            if ((i10 & 8) != 0) {
                                i22 |= size == -1 ? 1 : 2;
                            }
                            int i23 = i22;
                            if (this.readingAuxiliaryTracks) {
                                i7 = i23 | 32768;
                                builderBuildUpon.auxiliaryTrackType = ((Integer) arrayList.get(i15)).intValue();
                            } else {
                                i7 = i23;
                            }
                            builderBuildUpon.roleFlags = i7;
                        } else {
                            arrayList = arrayList;
                        }
                        int[] iArr = trackSampleTable.syncSampleIndices;
                        boolean z6 = trackSampleTable.hasOnlySyncSamples;
                        if (!MimeTypes.isVideo(str3) || jArr2.length <= 0) {
                            i2 = i15;
                        } else {
                            int iMin = Math.min(z6 ? trackSampleTable.sampleCount : iArr.length, 20);
                            UtilsKt.checkState(j5 != -9223372036854775807L ? 1 : i);
                            i2 = i15;
                            long jMin = Math.min(j5, 10000000L);
                            int i24 = i;
                            int i25 = i24;
                            int i26 = -1;
                            while (i24 < iMin) {
                                int i27 = z6 ? i24 : iArr[i24];
                                long j6 = jArr2[i27];
                                if (j6 > jMin) {
                                    break;
                                }
                                if (j6 >= 0) {
                                    i6 = iMin;
                                    int i28 = trackSampleTable.sizes[i27];
                                    if (i28 > i25) {
                                        i25 = i28;
                                        i26 = i27;
                                    }
                                } else {
                                    i6 = iMin;
                                }
                                i24++;
                                iMin = i6;
                            }
                            if (i26 != -1) {
                                j2 = jArr2[i26];
                            }
                            if (j2 != -9223372036854775807L) {
                                ThumbnailMetadata thumbnailMetadata = new ThumbnailMetadata(j2);
                                i3 = 1;
                                Metadata.Entry[] entryArr4 = new Metadata.Entry[1];
                                entryArr4[i] = thumbnailMetadata;
                                metadata = new Metadata(entryArr4);
                            } else {
                                i3 = 1;
                                metadata = null;
                            }
                            if (i19 == i3 && (i4 = gaplessInfoHolder.encoderDelay) != -1 && (i5 = gaplessInfoHolder.encoderPadding) != -1) {
                                builderBuildUpon.encoderDelay = i4;
                                builderBuildUpon.encoderPadding = i5;
                            }
                            Metadata metadata7 = format.metadata;
                            arrayList2 = this.slowMotionMetadataEntries;
                            if (arrayList2.isEmpty()) {
                                metadata2 = null;
                            } else {
                                metadata2 = new Metadata(arrayList2);
                            }
                            metadata3 = metadata6;
                            metadata4 = metadata5;
                            Sniffer.setFormatMetadata(i19, mdtaFromMeta, builderBuildUpon, metadata7, metadata2, metadata3, metadata4, metadata);
                            builderBuildUpon.containerMimeType = MimeTypes.normalizeMimeType(str);
                            if (Objects.equals(str3, "audio/mpeg")) {
                                mp4Track.pendingFormat = new Format(builderBuildUpon);
                            } else {
                                Format$$ExternalSyntheticOutline0.m(builderBuildUpon, mp4Track.trackOutput);
                            }
                            if (i19 == 2 && size == -1) {
                                size = arrayList7.size();
                            }
                            arrayList3 = arrayList7;
                            arrayList3.add(mp4Track);
                            i16 = i18;
                            j4 = jMax;
                        }
                        j2 = -9223372036854775807L;
                        if (j2 != -9223372036854775807L) {
                            ThumbnailMetadata thumbnailMetadata2 = new ThumbnailMetadata(j2);
                            i3 = 1;
                            Metadata.Entry[] entryArr5 = new Metadata.Entry[1];
                            entryArr5[i] = thumbnailMetadata2;
                            metadata = new Metadata(entryArr5);
                        } else {
                            i3 = 1;
                            metadata = null;
                        }
                        if (i19 == i3) {
                            builderBuildUpon.encoderDelay = i4;
                            builderBuildUpon.encoderPadding = i5;
                        }
                        Metadata metadata8 = format.metadata;
                        arrayList2 = this.slowMotionMetadataEntries;
                        if (arrayList2.isEmpty()) {
                            metadata2 = null;
                        } else {
                            metadata2 = new Metadata(arrayList2);
                        }
                        metadata3 = metadata6;
                        metadata4 = metadata5;
                        Sniffer.setFormatMetadata(i19, mdtaFromMeta, builderBuildUpon, metadata8, metadata2, metadata3, metadata4, metadata);
                        builderBuildUpon.containerMimeType = MimeTypes.normalizeMimeType(str);
                        if (Objects.equals(str3, "audio/mpeg")) {
                            mp4Track.pendingFormat = new Format(builderBuildUpon);
                        } else {
                            Format$$ExternalSyntheticOutline0.m(builderBuildUpon, mp4Track.trackOutput);
                        }
                        if (i19 == 2) {
                            size = arrayList7.size();
                        }
                        arrayList3 = arrayList7;
                        arrayList3.add(mp4Track);
                        i16 = i18;
                        j4 = jMax;
                    }
                    arrayList6 = arrayList3;
                    metadata6 = metadata3;
                    metadata5 = metadata4;
                    arrayDeque2 = arrayDeque3;
                    traks = traks;
                    z3 = z3;
                    arrayList = arrayList;
                    i15 = i2 + 1;
                    containerMimeType = str;
                }
                arrayDeque = arrayDeque2;
                z = z3;
                int i29 = -1;
                boolean z7 = true;
                Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList6.toArray(new Mp4Track[i]);
                this.tracks = mp4TrackArr;
                if (z) {
                    jArr = null;
                } else {
                    jArr = new long[mp4TrackArr.length][];
                    int[] iArr2 = new int[mp4TrackArr.length];
                    long[] jArr3 = new long[mp4TrackArr.length];
                    boolean[] zArr = new boolean[mp4TrackArr.length];
                    for (int i30 = 0; i30 < mp4TrackArr.length; i30++) {
                        jArr[i30] = new long[mp4TrackArr[i30].sampleTable.sampleCount];
                        jArr3[i30] = mp4TrackArr[i30].sampleTable.timestampsUs[0];
                    }
                    int i31 = 0;
                    while (i31 < mp4TrackArr.length) {
                        long j7 = Long.MAX_VALUE;
                        int i32 = i29;
                        for (int i33 = 0; i33 < mp4TrackArr.length; i33++) {
                            if (!zArr[i33]) {
                                long j8 = jArr3[i33];
                                if (j8 <= j7) {
                                    i32 = i33;
                                    j7 = j8;
                                }
                            }
                        }
                        int i34 = iArr2[i32];
                        long[] jArr4 = jArr[i32];
                        jArr4[i34] = j3;
                        TrackSampleTable trackSampleTable2 = mp4TrackArr[i32].sampleTable;
                        boolean z8 = z7;
                        int[] iArr3 = iArr2;
                        j3 += (long) trackSampleTable2.sizes[i34];
                        int i35 = i34 + 1;
                        iArr3[i32] = i35;
                        if (i35 < jArr4.length) {
                            jArr3[i32] = trackSampleTable2.timestampsUs[i35];
                        } else {
                            zArr[i32] = z8;
                            i31++;
                        }
                        iArr2 = iArr3;
                        z7 = z8;
                        i29 = -1;
                    }
                }
                z2 = z7;
                this.accumulatedSampleSizes = jArr;
                this.extractorOutput.endTracks();
                this.extractorOutput.seekMap(new Mp4SeekMap(j4, this.tracks, size));
                arrayDeque.clear();
                this.moovAtomProcessed = z2;
                if (this.seekToAxteAtom) {
                }
            } else if (!arrayDeque2.isEmpty()) {
                ((Mp4Box$ContainerBox) arrayDeque2.peek()).containerChildren.add(mp4Box$ContainerBox);
            }
        }
        if (this.parserState != 2) {
            this.parserState = 0;
            this.atomHeaderBytesRead = 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:121:0x024f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0255  */
    /* JADX WARN: Code duplicated, block: B:26:0x008d  */
    /* JADX WARN: Code duplicated, block: B:282:0x056d  */
    /* JADX WARN: Code duplicated, block: B:283:0x0579  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        char c;
        char c2;
        int i;
        int i2;
        int i3;
        int iNumberOfBytesInNalUnitHeader;
        int i4;
        long j;
        long j2;
        long position;
        long j3;
        ParsableByteArray parsableByteArray;
        int i5;
        char c3;
        boolean z;
        boolean z2;
        Mp4Box$ContainerBox mp4Box$ContainerBox;
        if (!this.omitTrackSampleTable || !this.moovAtomProcessed) {
            while (true) {
                int i6 = this.parserState;
                ArrayDeque arrayDeque = this.containerAtoms;
                int i7 = this.flags;
                ParsableByteArray parsableByteArray2 = this.scratch;
                int i8 = 4;
                int i9 = 0;
                char c4 = 2;
                if (i6 == 0) {
                    int i10 = this.atomHeaderBytesRead;
                    ParsableByteArray parsableByteArray3 = this.atomHeader;
                    if (i10 == 0) {
                        if (extractorInput.readFully(parsableByteArray3.data, 0, 8, true)) {
                            this.atomHeaderBytesRead = 8;
                            parsableByteArray3.setPosition(0);
                            this.atomSize = parsableByteArray3.readUnsignedInt();
                            this.atomType = parsableByteArray3.readInt();
                        } else if (this.fileType == 2 && (i7 & 2) != 0) {
                            TrackOutput trackOutputTrack = this.extractorOutput.track(0, 4);
                            MotionPhotoMetadata motionPhotoMetadata = this.motionPhotoMetadata;
                            Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                            Format.Builder builder = new Format.Builder();
                            builder.metadata = metadata;
                            Format$$ExternalSyntheticOutline0.m(builder, trackOutputTrack);
                            this.extractorOutput.endTracks();
                            this.extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
                            return -1;
                        }
                    }
                    long j4 = this.atomSize;
                    if (j4 == 1) {
                        extractorInput.readFully(parsableByteArray3.data, 8, 8);
                        this.atomHeaderBytesRead += 8;
                        this.atomSize = parsableByteArray3.readUnsignedLongToLong();
                    } else if (j4 == 0) {
                        long length = extractorInput.getLength();
                        if (length == -1 && (mp4Box$ContainerBox = (Mp4Box$ContainerBox) arrayDeque.peek()) != null) {
                            length = mp4Box$ContainerBox.endPosition;
                        }
                        if (length != -1) {
                            this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
                        }
                    }
                    long j5 = this.atomSize;
                    int i11 = this.atomHeaderBytesRead;
                    long j6 = i11;
                    if (j5 < j6) {
                        if (this.atomType != 1718773093 || i11 != 8) {
                            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
                        }
                        this.atomSize = j6;
                    }
                    int i12 = this.atomType;
                    if (i12 == 1836019574 || i12 == 1953653099 || i12 == 1835297121 || i12 == 1835626086 || i12 == 1937007212 || i12 == 1701082227 || i12 == 1835365473 || i12 == 1635284069) {
                        long position2 = extractorInput.getPosition();
                        long j7 = this.atomSize;
                        long j8 = this.atomHeaderBytesRead;
                        long j9 = (position2 + j7) - j8;
                        if (j7 != j8 && this.atomType == 1835365473) {
                            parsableByteArray2.reset(8);
                            extractorInput.peekFully(parsableByteArray2.data, 0, 8);
                            BoxParser.maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray2);
                            extractorInput.skipFully(parsableByteArray2.position);
                            extractorInput.resetPeekPosition();
                        }
                        arrayDeque.push(new Mp4Box$ContainerBox(this.atomType, j9));
                        if (this.atomSize == this.atomHeaderBytesRead) {
                            processAtomEnded$1(j9);
                        } else {
                            this.parserState = 0;
                            this.atomHeaderBytesRead = 0;
                        }
                    } else if (i12 == 1835296868 || i12 == 1836476516 || i12 == 1751411826 || i12 == 1937011556 || i12 == 1937011827 || i12 == 1937011571 || i12 == 1668576371 || i12 == 1701606260 || i12 == 1937011555 || i12 == 1937011578 || i12 == 1937013298 || i12 == 1937007471 || i12 == 1668232756 || i12 == 1953196132 || i12 == 1718909296 || i12 == 1969517665 || i12 == 1801812339 || i12 == 1768715124) {
                        UtilsKt.checkState(i11 == 8);
                        UtilsKt.checkState(this.atomSize <= 2147483647L);
                        ParsableByteArray parsableByteArray4 = new ParsableByteArray((int) this.atomSize);
                        System.arraycopy(parsableByteArray3.data, 0, parsableByteArray4.data, 0, 8);
                        this.atomData = parsableByteArray4;
                        this.parserState = 1;
                    } else {
                        long position3 = extractorInput.getPosition();
                        long j10 = this.atomHeaderBytesRead;
                        long j11 = position3 - j10;
                        if (this.atomType == 1836086884) {
                            this.motionPhotoMetadata = new MotionPhotoMetadata(0L, j11, -9223372036854775807L, j11 + j10, this.atomSize - j10);
                        }
                        this.atomData = null;
                        this.parserState = 1;
                    }
                } else {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return 0;
                            }
                            SefReader sefReader = this.sefReader;
                            ArrayList arrayList = sefReader.dataReferences;
                            byte b = sefReader.readerState;
                            if (b != 0) {
                                if (b != 1) {
                                    short s = 2817;
                                    short s2 = 2816;
                                    short s3 = 2192;
                                    if (b == 2) {
                                        long length2 = extractorInput.getLength();
                                        int i13 = sefReader.tailLength - 20;
                                        ParsableByteArray parsableByteArray5 = new ParsableByteArray(i13);
                                        extractorInput.readFully(parsableByteArray5.data, 0, i13);
                                        int i14 = 0;
                                        while (i14 < i13 / 12) {
                                            parsableByteArray5.skipBytes(2);
                                            short littleEndianShort = parsableByteArray5.readLittleEndianShort();
                                            if (littleEndianShort != s3 && littleEndianShort != s2 && littleEndianShort != s && littleEndianShort != 2819) {
                                                if (littleEndianShort != 2820) {
                                                    parsableByteArray5.skipBytes(8);
                                                    parsableByteArray = parsableByteArray5;
                                                }
                                                i14++;
                                                parsableByteArray5 = parsableByteArray;
                                                s = 2817;
                                                s3 = 2192;
                                                s2 = 2816;
                                            }
                                            parsableByteArray = parsableByteArray5;
                                            arrayList.add(new SefReader.DataReference((length2 - ((long) sefReader.tailLength)) - ((long) parsableByteArray5.readLittleEndianInt()), parsableByteArray.readLittleEndianInt()));
                                            i14++;
                                            parsableByteArray5 = parsableByteArray;
                                            s = 2817;
                                            s3 = 2192;
                                            s2 = 2816;
                                        }
                                        if (arrayList.isEmpty()) {
                                            positionHolder.position = 0L;
                                            j3 = 0;
                                        } else {
                                            sefReader.readerState = (byte) 3;
                                            j3 = ((SefReader.DataReference) arrayList.get(0)).startOffset;
                                            positionHolder.position = j3;
                                        }
                                        j = j3;
                                    } else {
                                        if (b != 3) {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                            return 0;
                                        }
                                        long position4 = extractorInput.getPosition();
                                        int length3 = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - ((long) sefReader.tailLength));
                                        ParsableByteArray parsableByteArray6 = new ParsableByteArray(length3);
                                        extractorInput.readFully(parsableByteArray6.data, 0, length3);
                                        int i15 = 0;
                                        while (i15 < arrayList.size()) {
                                            SefReader.DataReference dataReference = (SefReader.DataReference) arrayList.get(i15);
                                            int i16 = i9;
                                            parsableByteArray6.setPosition((int) (dataReference.startOffset - position4));
                                            parsableByteArray6.skipBytes(i8);
                                            int littleEndianInt = parsableByteArray6.readLittleEndianInt();
                                            Charset charset = StandardCharsets.UTF_8;
                                            int i17 = i16;
                                            String string = parsableByteArray6.readString(littleEndianInt, charset);
                                            switch (string.hashCode()) {
                                                case -1711564334:
                                                    if (!string.equals("SlowMotion_Data")) {
                                                        i5 = -1;
                                                    } else {
                                                        i5 = i17;
                                                    }
                                                    break;
                                                case -1332107749:
                                                    if (!string.equals("Super_SlowMotion_Edit_Data")) {
                                                        i5 = -1;
                                                    } else {
                                                        i5 = 1;
                                                    }
                                                    break;
                                                case -1251387154:
                                                    if (!string.equals("Super_SlowMotion_Data")) {
                                                        i5 = -1;
                                                    } else {
                                                        i5 = 2;
                                                    }
                                                    break;
                                                case -830665521:
                                                    if (!string.equals("Super_SlowMotion_Deflickering_On")) {
                                                        i5 = -1;
                                                    } else {
                                                        i5 = 3;
                                                    }
                                                    break;
                                                case 1760745220:
                                                    if (!string.equals("Super_SlowMotion_BGM")) {
                                                        i5 = -1;
                                                    } else {
                                                        i5 = 4;
                                                    }
                                                    break;
                                                default:
                                                    i5 = -1;
                                                    break;
                                            }
                                            switch (i5) {
                                                case 0:
                                                    c3 = 2192;
                                                    break;
                                                case 1:
                                                    c3 = 2819;
                                                    break;
                                                case 2:
                                                    c3 = 2816;
                                                    break;
                                                case 3:
                                                    c3 = 2820;
                                                    break;
                                                case 4:
                                                    c3 = 2817;
                                                    break;
                                                default:
                                                    throw ParserException.createForMalformedContainer(null, "Invalid SEF name");
                                            }
                                            int i18 = dataReference.size - (littleEndianInt + 8);
                                            if (c3 == 2192) {
                                                ArrayList arrayList2 = new ArrayList();
                                                List listSplitToList = SefReader.ASTERISK_SPLITTER.splitToList(parsableByteArray6.readString(i18, charset));
                                                int i19 = i17;
                                                while (i19 < listSplitToList.size()) {
                                                    List listSplitToList2 = SefReader.COLON_SPLITTER.splitToList((CharSequence) listSplitToList.get(i19));
                                                    if (listSplitToList2.size() != 3) {
                                                        throw ParserException.createForMalformedContainer(null, null);
                                                    }
                                                    try {
                                                        arrayList2.add(new SlowMotionData.Segment(1 << (Integer.parseInt((String) listSplitToList2.get(2)) - 1), Long.parseLong((String) listSplitToList2.get(i17)), Long.parseLong((String) listSplitToList2.get(1))));
                                                        i19++;
                                                        i17 = 0;
                                                    } catch (NumberFormatException e) {
                                                        throw ParserException.createForMalformedContainer(e, null);
                                                    }
                                                }
                                                this.slowMotionMetadataEntries.add(new SlowMotionData(arrayList2));
                                            } else if (c3 != 2816 && c3 != 2817 && c3 != 2819 && c3 != 2820) {
                                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                                return i17;
                                            }
                                            i15++;
                                            i9 = 0;
                                            i8 = 4;
                                        }
                                        positionHolder.position = 0L;
                                        i4 = 1;
                                        j2 = 0;
                                        j = 0;
                                    }
                                    if (j == j2) {
                                        return i4;
                                    }
                                    this.parserState = 0;
                                    this.atomHeaderBytesRead = 0;
                                    return i4;
                                }
                                ParsableByteArray parsableByteArray7 = new ParsableByteArray(8);
                                extractorInput.readFully(parsableByteArray7.data, 0, 8);
                                sefReader.tailLength = parsableByteArray7.readLittleEndianInt() + 8;
                                if (parsableByteArray7.readInt() != 1397048916) {
                                    positionHolder.position = 0L;
                                    position = 0;
                                } else {
                                    position = extractorInput.getPosition() - ((long) (sefReader.tailLength - 12));
                                    positionHolder.position = position;
                                    sefReader.readerState = (byte) 2;
                                }
                                j = position;
                                i4 = 1;
                            } else {
                                long length4 = extractorInput.getLength();
                                long j12 = (length4 == -1 || length4 < 8) ? 0L : length4 - 8;
                                positionHolder.position = j12;
                                i4 = 1;
                                sefReader.readerState = (byte) 1;
                                j = j12;
                            }
                            j2 = 0;
                            if (j == j2) {
                                return i4;
                            }
                            this.parserState = 0;
                            this.atomHeaderBytesRead = 0;
                            return i4;
                        }
                        long position5 = extractorInput.getPosition();
                        int i20 = this.sampleTrackIndex;
                        if (i20 == -1) {
                            boolean z3 = true;
                            int i21 = 0;
                            int i22 = -1;
                            int i23 = -1;
                            boolean z4 = true;
                            long j13 = Long.MAX_VALUE;
                            long j14 = Long.MAX_VALUE;
                            long j15 = Long.MAX_VALUE;
                            while (true) {
                                Mp4Track[] mp4TrackArr = this.tracks;
                                if (i21 >= mp4TrackArr.length) {
                                    break;
                                }
                                Mp4Track mp4Track = mp4TrackArr[i21];
                                int i24 = mp4Track.sampleIndex;
                                TrackSampleTable trackSampleTable = mp4Track.sampleTable;
                                char c5 = c4;
                                if (i24 != trackSampleTable.sampleCount) {
                                    long j16 = trackSampleTable.offsets[i24];
                                    long[][] jArr = this.accumulatedSampleSizes;
                                    jArr.getClass();
                                    long j17 = jArr[i21][i24];
                                    long j18 = j16 - position5;
                                    boolean z5 = j18 < 0 || j18 >= 262144;
                                    if ((!z5 && z3) || (z5 == z3 && j18 < j15)) {
                                        z3 = z5;
                                        i23 = i21;
                                        j15 = j18;
                                        j14 = j17;
                                    }
                                    if (j17 < j13) {
                                        z4 = z5;
                                        i22 = i21;
                                        j13 = j17;
                                    }
                                }
                                i21++;
                                c4 = c5;
                            }
                            c = c4;
                            i20 = (j13 == Long.MAX_VALUE || !z4 || j14 < j13 + 10485760) ? i23 : i22;
                            this.sampleTrackIndex = i20;
                            if (i20 == -1) {
                                return -1;
                            }
                        } else {
                            c = 2;
                        }
                        Mp4Track mp4Track2 = this.tracks[i20];
                        TrackOutput trackOutput = mp4Track2.trackOutput;
                        TrackSampleTable trackSampleTable2 = mp4Track2.sampleTable;
                        Track track = mp4Track2.track;
                        int i25 = mp4Track2.sampleIndex;
                        long[] jArr2 = trackSampleTable2.offsets;
                        int[] iArr = trackSampleTable2.sizes;
                        long j19 = jArr2[i25] + this.sampleOffsetForAuxiliaryTracks;
                        int i26 = iArr[i25];
                        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track2.trueHdSampleRechunker;
                        long j20 = (j19 - position5) + ((long) this.sampleBytesRead);
                        if (j20 < 0 || j20 >= 262144) {
                            positionHolder.position = j19;
                            return 1;
                        }
                        boolean z6 = track.sampleTransformation;
                        int i27 = track.nalUnitLengthFieldLength;
                        Format format = track.format;
                        if (z6) {
                            j20 += 8;
                            i26 -= 8;
                        }
                        int i28 = i26;
                        extractorInput.skipFully((int) j20);
                        String str = format.sampleMimeType;
                        String str2 = format.sampleMimeType;
                        if (!Objects.equals(str, "video/avc") ? !Objects.equals(str2, "video/hevc") || (i7 & 128) == 0 : (i7 & 32) == 0) {
                            c2 = 1;
                            this.isSampleDependedOn = true;
                        } else {
                            c2 = 1;
                        }
                        if (i27 != 0) {
                            ParsableByteArray parsableByteArray8 = this.nalPrefix;
                            byte[] bArr = parsableByteArray8.data;
                            bArr[0] = 0;
                            bArr[c2] = 0;
                            bArr[c] = 0;
                            int i29 = 4 - i27;
                            int i30 = i28 + i29;
                            while (this.sampleBytesWritten < i30) {
                                int i31 = this.sampleCurrentNalBytesRemaining;
                                if (i31 == 0) {
                                    if (this.isSampleDependedOn || OpusUtil.numberOfBytesInNalUnitHeader(format) + i27 > iArr[i25] - this.sampleBytesRead) {
                                        i3 = i27;
                                        iNumberOfBytesInNalUnitHeader = 0;
                                    } else {
                                        iNumberOfBytesInNalUnitHeader = OpusUtil.numberOfBytesInNalUnitHeader(format);
                                        i3 = i27 + iNumberOfBytesInNalUnitHeader;
                                    }
                                    extractorInput.readFully(bArr, i29, i3);
                                    i2 = i30;
                                    this.sampleBytesRead += i3;
                                    parsableByteArray8.setPosition(0);
                                    int i32 = parsableByteArray8.readInt();
                                    if (i32 < 0) {
                                        throw ParserException.createForMalformedContainer(null, "Invalid NAL length");
                                    }
                                    this.sampleCurrentNalBytesRemaining = i32 - iNumberOfBytesInNalUnitHeader;
                                    ParsableByteArray parsableByteArray9 = this.nalStartCode;
                                    parsableByteArray9.setPosition(0);
                                    int i33 = iNumberOfBytesInNalUnitHeader;
                                    trackOutput.sampleData(4, parsableByteArray9);
                                    this.sampleBytesWritten += 4;
                                    if (i33 > 0) {
                                        trackOutput.sampleData(i33, parsableByteArray8);
                                        this.sampleBytesWritten += i33;
                                        if (OpusUtil.isDependedOn(bArr, i33, format)) {
                                            this.isSampleDependedOn = true;
                                        }
                                    }
                                } else {
                                    i2 = i30;
                                    int iSampleData = trackOutput.sampleData((DataReader) extractorInput, i31, false);
                                    this.sampleBytesRead += iSampleData;
                                    this.sampleBytesWritten += iSampleData;
                                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                                }
                                i30 = i2;
                            }
                            i = i30;
                        } else {
                            if ("audio/ac4".equals(str2)) {
                                if (this.sampleBytesWritten == 0) {
                                    AacUtil.getAc4SampleHeader(i28, parsableByteArray2);
                                    trackOutput.sampleData(7, parsableByteArray2);
                                    this.sampleBytesWritten += 7;
                                }
                                i28 += 7;
                            } else if (mp4Track2.pendingFormat != null && Objects.equals(str2, "audio/mpeg")) {
                                Format format2 = mp4Track2.pendingFormat;
                                parsableByteArray2.reset(4);
                                extractorInput.peekFully(parsableByteArray2.data, 0, 4);
                                extractorInput.resetPeekPosition();
                                MpegAudioUtil$Header mpegAudioUtil$Header = new MpegAudioUtil$Header();
                                TrackOutput trackOutput2 = mp4Track2.trackOutput;
                                if (mpegAudioUtil$Header.setForHeaderData(parsableByteArray2.readInt()) && !Objects.equals(format2.sampleMimeType, mpegAudioUtil$Header.mimeType)) {
                                    Format.Builder builderBuildUpon = format2.buildUpon();
                                    String str3 = mpegAudioUtil$Header.mimeType;
                                    str3.getClass();
                                    builderBuildUpon.sampleMimeType = MimeTypes.normalizeMimeType(str3);
                                    format2 = new Format(builderBuildUpon);
                                }
                                trackOutput2.format(format2);
                                mp4Track2.pendingFormat = null;
                            } else if (trueHdSampleRechunker != null) {
                                trueHdSampleRechunker.startSample(extractorInput);
                            }
                            while (true) {
                                int i34 = this.sampleBytesWritten;
                                if (i34 >= i28) {
                                    break;
                                }
                                int iSampleData2 = trackOutput.sampleData((DataReader) extractorInput, i28 - i34, false);
                                this.sampleBytesRead += iSampleData2;
                                this.sampleBytesWritten += iSampleData2;
                                this.sampleCurrentNalBytesRemaining -= iSampleData2;
                            }
                            i = i28;
                        }
                        long j21 = trackSampleTable2.timestampsUs[i25];
                        int i35 = trackSampleTable2.flags[i25];
                        if (!this.isSampleDependedOn) {
                            i35 |= 67108864;
                        }
                        int i36 = i35;
                        if (trueHdSampleRechunker != null) {
                            trueHdSampleRechunker.sampleMetadata(trackOutput, j21, i36, i, 0, null);
                            if (i25 + 1 == trackSampleTable2.sampleCount) {
                                trueHdSampleRechunker.outputPendingSampleMetadata(trackOutput, null);
                            }
                        } else {
                            trackOutput.sampleMetadata(j21, i36, i, 0, null);
                        }
                        mp4Track2.sampleIndex++;
                        this.sampleTrackIndex = -1;
                        this.sampleBytesRead = 0;
                        this.sampleBytesWritten = 0;
                        this.sampleCurrentNalBytesRemaining = 0;
                        this.isSampleDependedOn = false;
                        return 0;
                    }
                    long j22 = this.atomSize - ((long) this.atomHeaderBytesRead);
                    long position6 = extractorInput.getPosition() + j22;
                    ParsableByteArray parsableByteArray10 = this.atomData;
                    if (parsableByteArray10 != null) {
                        extractorInput.readFully(parsableByteArray10.data, this.atomHeaderBytesRead, (int) j22);
                        if (this.atomType == 1718909296) {
                            this.seenFtypAtom = true;
                            parsableByteArray10.setPosition(8);
                            int i37 = parsableByteArray10.readInt();
                            int i38 = i37 != 1751476579 ? i37 != 1903435808 ? 0 : 1 : 2;
                            if (i38 == 0) {
                                parsableByteArray10.skipBytes(4);
                                do {
                                    if (parsableByteArray10.bytesLeft() <= 0) {
                                        i38 = 0;
                                        break;
                                    }
                                    int i39 = parsableByteArray10.readInt();
                                    i38 = i39 != 1751476579 ? i39 != 1903435808 ? 0 : 1 : 2;
                                } while (i38 == 0);
                            }
                            this.fileType = i38;
                        } else if (!arrayDeque.isEmpty()) {
                            ((Mp4Box$ContainerBox) arrayDeque.peek()).leafChildren.add(new Mp4Box$LeafBox(this.atomType, parsableByteArray10));
                        }
                    } else {
                        if (!this.seenFtypAtom && this.atomType == 1835295092) {
                            this.fileType = 1;
                        }
                        if (j22 < 262144) {
                            extractorInput.skipFully((int) j22);
                        } else {
                            positionHolder.position = extractorInput.getPosition() + j22;
                            z = true;
                        }
                        processAtomEnded$1(position6);
                        if (this.seekToAxteAtom) {
                            this.readingAuxiliaryTracks = true;
                            positionHolder.position = this.axteAtomOffset;
                            this.seekToAxteAtom = false;
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if (z2 && this.parserState != 2) {
                            return 1;
                        }
                    }
                    z = false;
                    processAtomEnded$1(position6);
                    if (this.seekToAxteAtom) {
                        this.readingAuxiliaryTracks = true;
                        positionHolder.position = this.axteAtomOffset;
                        this.seekToAxteAtom = false;
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.isSampleDependedOn = false;
        this.moovAtomProcessed = false;
        if (j == 0) {
            if (this.parserState != 3) {
                this.parserState = 0;
                this.atomHeaderBytesRead = 0;
                return;
            } else {
                SefReader sefReader = this.sefReader;
                sefReader.dataReferences.clear();
                sefReader.readerState = (byte) 0;
                this.slowMotionMetadataEntries.clear();
                return;
            }
        }
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j2);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j2);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
            TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.foundSyncframe = false;
                trueHdSampleRechunker.chunkSampleCount = 0;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        RegularImmutableList regularImmutableListOf;
        SniffFailure sniffFailureSniffInternal = Sniffer.sniffInternal(extractorInput, false, (this.flags & 2) != 0);
        if (sniffFailureSniffInternal != null) {
            regularImmutableListOf = ImmutableList.of((Object) sniffFailureSniffInternal);
        } else {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            regularImmutableListOf = RegularImmutableList.EMPTY;
        }
        this.lastSniffFailures = regularImmutableListOf;
        return sniffFailureSniffInternal == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
