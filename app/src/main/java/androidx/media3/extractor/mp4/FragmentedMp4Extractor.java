package androidx.media3.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Latch;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Format$$ExternalSyntheticLambda1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4Box$ContainerBox;
import androidx.media3.container.Mp4Box$LeafBox;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.CueDecoder;
import coil3.network.NetworkHeaders;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.music.playback.StreamUrlCache;
import io.ktor.websocket.ControlFramesKt;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentedMp4Extractor implements Extractor {
    public static final Format EMSG_FORMAT;
    public static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public ParsableByteArray atomData;
    public int atomHeaderBytesRead;
    public long atomSize;
    public int atomType;
    public TrackOutput[] ceaTrackOutputs;
    public final NetworkHeaders.Builder chunkIndexMerger;
    public final List closedCaptionFormats;
    public TrackBundle currentTrackBundle;
    public long durationUs;
    public TrackOutput[] emsgTrackOutputs;
    public long endOfMdatPosition;
    public ExtractorOutput extractorOutput;
    public final int flags;
    public boolean haveOutputSeekMap;
    public boolean isSampleDependedOn;
    public RegularImmutableList lastSniffFailures;
    public byte parserState;
    public int pendingMetadataSampleBytes;
    public long pendingSeekTimeUs;
    public boolean processSeiNalUnitPayload;
    public final RulerTrackingMap reorderingBufferQueue;
    public int sampleBytesWritten;
    public int sampleCurrentNalBytesRemaining;
    public int sampleSize;
    public final ParsableByteArray scratch;
    public final byte[] scratchBytes;
    public long seekPositionBeforeSidxProcessing;
    public long segmentIndexEarliestPresentationTimeUs;
    public final CueDecoder subtitleParserFactory;
    public boolean upfrontSidxScanComplete;
    public final WeakCache eventMessageEncoder = new WeakCache((byte) 28);
    public final ParsableByteArray atomHeader = new ParsableByteArray(16);
    public final ParsableByteArray nalStartCode = new ParsableByteArray(OpusUtil.NAL_START_CODE);
    public final ParsableByteArray nalPrefix = new ParsableByteArray(6);
    public final ParsableByteArray nalUnitWithoutHeaderBuffer = new ParsableByteArray();
    public final ArrayDeque containerAtoms = new ArrayDeque();
    public final ArrayDeque pendingMetadataSampleInfos = new ArrayDeque();
    public final SparseArray trackBundles = new SparseArray();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MetadataSampleInfo {
        public final boolean sampleTimeIsRelative;
        public final long sampleTimeUs;
        public final int size;

        public MetadataSampleInfo(int i, long j, boolean z) {
            this.sampleTimeUs = j;
            this.sampleTimeIsRelative = z;
            this.size = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TrackBundle {
        public final Format baseFormat;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public boolean currentlyInFragment;
        public DefaultSampleValues defaultSampleValues;
        public int firstSampleToOutputIndex;
        public TrackSampleTable moovSampleTable;
        public final TrackOutput output;
        public final TrackFragment fragment = new TrackFragment();
        public final ParsableByteArray scratch = new ParsableByteArray();
        public final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        public final ParsableByteArray defaultInitializationVector = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues, Format format) {
            this.output = trackOutput;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            this.baseFormat = format;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues;
            trackOutput.format(format);
            resetFragmentInfo();
        }

        public final int getCurrentSampleFlags() {
            int i;
            if (this.currentlyInFragment) {
                i = this.fragment.sampleIsSyncFrameTable[this.currentSampleIndex] ? 1 : 0;
            } else {
                i = this.moovSampleTable.flags[this.currentSampleIndex];
            }
            return getEncryptionBoxIfEncrypted() != null ? 1073741824 | i : i;
        }

        public final TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            if (!this.currentlyInFragment) {
                return null;
            }
            TrackFragment trackFragment = this.fragment;
            DefaultSampleValues defaultSampleValues = trackFragment.header;
            String str = Util.DEVICE_DEBUG_INFO;
            int i = defaultSampleValues.sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.moovSampleTable.track.sampleDescriptionEncryptionBoxes[i];
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
                return null;
            }
            return trackEncryptionBox;
        }

        public final boolean next() {
            this.currentSampleIndex++;
            if (!this.currentlyInFragment) {
                return false;
            }
            int i = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i;
            int[] iArr = this.fragment.trunLength;
            int i2 = this.currentTrackRunIndex;
            if (i != iArr[i2]) {
                return true;
            }
            this.currentTrackRunIndex = i2 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public final int outputSampleEncryptionData(int i, int i2) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            int length = encryptionBoxIfEncrypted.perSampleIvSize;
            TrackFragment trackFragment = this.fragment;
            if (length != 0) {
                parsableByteArray = trackFragment.sampleEncryptionData;
            } else {
                byte[] bArr = encryptionBoxIfEncrypted.defaultInitializationVector;
                String str = Util.DEVICE_DEBUG_INFO;
                int length2 = bArr.length;
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                parsableByteArray2.reset(bArr, length2);
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean z = trackFragment.definesEncryptionData && trackFragment.sampleHasSubsampleEncryptionTable[this.currentSampleIndex];
            boolean z2 = z || i2 != 0;
            ParsableByteArray parsableByteArray3 = this.encryptionSignalByte;
            parsableByteArray3.data[0] = (byte) ((z2 ? 128 : 0) | length);
            parsableByteArray3.setPosition(0);
            TrackOutput trackOutput = this.output;
            trackOutput.sampleData(parsableByteArray3, 1, 1);
            trackOutput.sampleData(parsableByteArray, length, 1);
            if (!z2) {
                return length + 1;
            }
            ParsableByteArray parsableByteArray4 = this.scratch;
            if (!z) {
                parsableByteArray4.reset(8);
                byte[] bArr2 = parsableByteArray4.data;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = 0;
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                trackOutput.sampleData(parsableByteArray4, 8, 1);
                return length + 9;
            }
            ParsableByteArray parsableByteArray5 = trackFragment.sampleEncryptionData;
            int unsignedShort = parsableByteArray5.readUnsignedShort();
            parsableByteArray5.skipBytes(-2);
            int i3 = (unsignedShort * 6) + 2;
            if (i2 != 0) {
                parsableByteArray4.reset(i3);
                byte[] bArr3 = parsableByteArray4.data;
                parsableByteArray5.readBytes(bArr3, 0, i3);
                int i4 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i4 >> 8) & 255);
                bArr3[3] = (byte) (i4 & 255);
            } else {
                parsableByteArray4 = parsableByteArray5;
            }
            trackOutput.sampleData(parsableByteArray4, i3, 1);
            return length + 1 + i3;
        }

        public final void resetFragmentInfo() {
            TrackFragment trackFragment = this.fragment;
            trackFragment.trunCount = 0;
            trackFragment.nextFragmentDecodeTime = 0L;
            trackFragment.nextFragmentDecodeTimeIncludesMoov = false;
            trackFragment.definesEncryptionData = false;
            trackFragment.sampleEncryptionDataNeedsFill = false;
            trackFragment.trackEncryptionBox = null;
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
            this.currentlyInFragment = false;
        }
    }

    static {
        Format.Builder builder = new Format.Builder();
        builder.sampleMimeType = MimeTypes.normalizeMimeType("application/x-emsg");
        EMSG_FORMAT = new Format(builder);
    }

    public FragmentedMp4Extractor(CueDecoder cueDecoder, int i, RegularImmutableList regularImmutableList) {
        this.subtitleParserFactory = cueDecoder;
        this.flags = i;
        this.closedCaptionFormats = Collections.unmodifiableList(regularImmutableList);
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        this.lastSniffFailures = RegularImmutableList.EMPTY;
        this.durationUs = -9223372036854775807L;
        this.pendingSeekTimeUs = -9223372036854775807L;
        this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.emsgTrackOutputs = new TrackOutput[0];
        this.ceaTrackOutputs = new TrackOutput[0];
        this.reorderingBufferQueue = new RulerTrackingMap(new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0((byte) 21, (Object) this));
        this.chunkIndexMerger = new NetworkHeaders.Builder((byte) 3);
        this.seekPositionBeforeSidxProcessing = -1L;
    }

    public static DrmInitData getDrmInitDataFromAtoms(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            Mp4Box$LeafBox mp4Box$LeafBox = (Mp4Box$LeafBox) arrayList.get(i);
            if (mp4Box$LeafBox.flags == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = mp4Box$LeafBox.data.data;
                StreamUrlCache psshAtom = Sniffer.parsePsshAtom(bArr);
                UUID uuid = psshAtom == null ? null : (UUID) psshAtom.currentTimeMillis;
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new DrmInitData.SchemeData(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList2.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void parseSenc(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int i2 = parsableByteArray.readInt();
        byte[] bArr = BoxParser.opusMagic;
        if ((i2 & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (i2 & 2) != 0;
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (unsignedIntToInt == 0) {
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, trackFragment.sampleCount, false);
            return;
        }
        int i3 = trackFragment.sampleCount;
        ParsableByteArray parsableByteArray2 = trackFragment.sampleEncryptionData;
        if (unsignedIntToInt != i3) {
            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(unsignedIntToInt, "Senc sample count ", " is different from fragment sample count");
            sbM2m.append(trackFragment.sampleCount);
            throw ParserException.createForMalformedContainer(null, sbM2m.toString());
        }
        Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, z);
        parsableByteArray2.reset(parsableByteArray.bytesLeft());
        trackFragment.definesEncryptionData = true;
        trackFragment.sampleEncryptionDataNeedsFill = true;
        parsableByteArray.readBytes(parsableByteArray2.data, 0, parsableByteArray2.limit);
        parsableByteArray2.setPosition(0);
        trackFragment.sampleEncryptionDataNeedsFill = false;
    }

    public static Pair parseSidx(long j, ParsableByteArray parsableByteArray) throws ParserException {
        long unsignedLongToLong;
        long unsignedLongToLong2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        long unsignedInt = parsableByteArray2.readUnsignedInt();
        if (fullBoxVersion == 0) {
            unsignedLongToLong = parsableByteArray2.readUnsignedInt();
            unsignedLongToLong2 = parsableByteArray2.readUnsignedInt();
        } else {
            unsignedLongToLong = parsableByteArray2.readUnsignedLongToLong();
            unsignedLongToLong2 = parsableByteArray2.readUnsignedLongToLong();
        }
        long j2 = unsignedLongToLong2 + j;
        String str = Util.DEVICE_DEBUG_INFO;
        long jScaleLargeValue = Util.scaleLargeValue(unsignedLongToLong, 1000000L, unsignedInt, RoundingMode.DOWN);
        parsableByteArray2.skipBytes(2);
        int unsignedShort = parsableByteArray2.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        long[] jArr3 = new long[unsignedShort];
        long j3 = j2;
        long j4 = jScaleLargeValue;
        int i = 0;
        while (i < unsignedShort) {
            int i2 = parsableByteArray2.readInt();
            if ((Integer.MIN_VALUE & i2) != 0) {
                throw ParserException.createForMalformedContainer(null, "Unhandled indirect reference");
            }
            long unsignedInt2 = parsableByteArray2.readUnsignedInt();
            iArr[i] = i2 & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            unsignedLongToLong += unsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jScaleLargeValue2 = Util.scaleLargeValue(unsignedLongToLong, 1000000L, unsignedInt, RoundingMode.DOWN);
            jArr4[i] = jScaleLargeValue2 - jArr5[i];
            parsableByteArray2.skipBytes(4);
            j3 += (long) iArr[i];
            i++;
            unsignedShort = unsignedShort;
            parsableByteArray2 = parsableByteArray;
            j4 = jScaleLargeValue2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jScaleLargeValue), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    public final void enterReadingAtomHeaderState() {
        this.parserState = (byte) 0;
        this.atomHeaderBytesRead = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final List getSniffFailureDetails() {
        return this.lastSniffFailures;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        int i;
        int i2 = this.flags;
        if ((i2 & 32) == 0) {
            extractorOutput = new Latch(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
        enterReadingAtomHeaderState();
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.emsgTrackOutputs = trackOutputArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            trackOutputArr[0] = this.extractorOutput.track(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(i, this.emsgTrackOutputs);
        this.emsgTrackOutputs = trackOutputArr2;
        for (TrackOutput trackOutput : trackOutputArr2) {
            trackOutput.format(EMSG_FORMAT);
        }
        List list = this.closedCaptionFormats;
        this.ceaTrackOutputs = new TrackOutput[list.size()];
        while (i4 < this.ceaTrackOutputs.length) {
            TrackOutput trackOutputTrack = this.extractorOutput.track(i3, 3);
            trackOutputTrack.format((Format) list.get(i4));
            this.ceaTrackOutputs[i4] = trackOutputTrack;
            i4++;
            i3++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:272:0x066b  */
    public final void processAtomEnded(long j) throws ParserException {
        Metadata metadata;
        int i;
        long j2;
        DefaultSampleValues defaultSampleValues;
        int i2;
        DefaultSampleValues defaultSampleValues2;
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i4;
        int i5;
        byte[] bArr;
        int i6;
        boolean z;
        int i7;
        boolean z2;
        while (true) {
            ArrayDeque arrayDeque = this.containerAtoms;
            if (arrayDeque.isEmpty() || ((Mp4Box$ContainerBox) arrayDeque.peek()).endPosition != j) {
                break;
            }
            Mp4Box$ContainerBox mp4Box$ContainerBox = (Mp4Box$ContainerBox) arrayDeque.pop();
            int i8 = mp4Box$ContainerBox.flags;
            ArrayList arrayList4 = mp4Box$ContainerBox.containerChildren;
            ArrayList arrayList5 = mp4Box$ContainerBox.leafChildren;
            int i9 = this.flags;
            int i10 = 12;
            SparseArray sparseArray = this.trackBundles;
            if (i8 == 1836019574) {
                DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(arrayList5);
                Mp4Box$ContainerBox containerBoxOfType = mp4Box$ContainerBox.getContainerBoxOfType(1836475768);
                containerBoxOfType.getClass();
                SparseArray sparseArray2 = new SparseArray();
                ArrayList arrayList6 = containerBoxOfType.leafChildren;
                int size = arrayList6.size();
                int i11 = 0;
                long unsignedInt = -9223372036854775807L;
                while (i11 < size) {
                    Mp4Box$LeafBox mp4Box$LeafBox = (Mp4Box$LeafBox) arrayList6.get(i11);
                    int i12 = mp4Box$LeafBox.flags;
                    ParsableByteArray parsableByteArray = mp4Box$LeafBox.data;
                    if (i12 == 1953654136) {
                        parsableByteArray.setPosition(i10);
                        arrayList = arrayList6;
                        Pair pairCreate = Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (DefaultSampleValues) pairCreate.second);
                    } else {
                        arrayList = arrayList6;
                        if (i12 == 1835362404) {
                            parsableByteArray.setPosition(8);
                            unsignedInt = BoxParser.parseFullBoxVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                        }
                    }
                    i11++;
                    arrayList6 = arrayList;
                    i10 = 12;
                }
                int i13 = 0;
                Mp4Box$ContainerBox containerBoxOfType2 = mp4Box$ContainerBox.getContainerBoxOfType(1835365473);
                Metadata mdtaFromMeta = containerBoxOfType2 != null ? BoxParser.parseMdtaFromMeta(containerBoxOfType2) : null;
                GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
                Mp4Box$LeafBox leafBoxOfType = mp4Box$ContainerBox.getLeafBoxOfType(1969517665);
                if (leafBoxOfType != null) {
                    Metadata udta = BoxParser.parseUdta(leafBoxOfType);
                    gaplessInfoHolder.setFromMetadata(udta);
                    metadata = udta;
                } else {
                    metadata = null;
                }
                Mp4Box$LeafBox leafBoxOfType2 = mp4Box$ContainerBox.getLeafBoxOfType(1836476516);
                leafBoxOfType2.getClass();
                Metadata metadata2 = new Metadata(BoxParser.parseMvhd(leafBoxOfType2.data));
                ArrayList traks = BoxParser.parseTraks(mp4Box$ContainerBox, gaplessInfoHolder, unsignedInt, drmInitDataFromAtoms, (i9 & 16) != 0, false, new Format$$ExternalSyntheticLambda1(this), false);
                int size2 = traks.size();
                if (sparseArray.size() == 0) {
                    String containerMimeType = Sniffer.getContainerMimeType(traks);
                    int i14 = 0;
                    while (i14 < size2) {
                        TrackSampleTable trackSampleTable = (TrackSampleTable) traks.get(i14);
                        Track track = trackSampleTable.track;
                        ExtractorOutput extractorOutput = this.extractorOutput;
                        int i15 = track.type;
                        int i16 = track.id;
                        String str = containerMimeType;
                        Format format = track.format;
                        long j3 = track.durationUs;
                        TrackOutput trackOutputTrack = extractorOutput.track(i14, i15);
                        trackOutputTrack.durationUs(j3);
                        int i17 = i14;
                        Format.Builder builderBuildUpon = format.buildUpon();
                        ArrayList arrayList7 = traks;
                        builderBuildUpon.containerMimeType = MimeTypes.normalizeMimeType(str);
                        if (i15 == 1) {
                            int i18 = gaplessInfoHolder.encoderDelay;
                            i = size2;
                            j2 = j3;
                            if (i18 != -1 && (i2 = gaplessInfoHolder.encoderPadding) != -1) {
                                builderBuildUpon.encoderDelay = i18;
                                builderBuildUpon.encoderPadding = i2;
                            }
                        } else {
                            i = size2;
                            j2 = j3;
                        }
                        Sniffer.setFormatMetadata(i15, mdtaFromMeta, builderBuildUpon, format.metadata, metadata, metadata2);
                        if (sparseArray2.size() == 1) {
                            defaultSampleValues = (DefaultSampleValues) sparseArray2.valueAt(i13);
                        } else {
                            defaultSampleValues = (DefaultSampleValues) sparseArray2.get(i16);
                            defaultSampleValues.getClass();
                        }
                        sparseArray.put(i16, new TrackBundle(trackOutputTrack, trackSampleTable, defaultSampleValues, new Format(builderBuildUpon)));
                        this.durationUs = Math.max(this.durationUs, j2);
                        i14 = i17 + 1;
                        containerMimeType = str;
                        traks = arrayList7;
                        size2 = i;
                        i13 = 0;
                    }
                    this.extractorOutput.endTracks();
                } else {
                    ArrayList arrayList8 = traks;
                    UtilsKt.checkState(sparseArray.size() == size2);
                    int i19 = 0;
                    while (i19 < size2) {
                        ArrayList arrayList9 = arrayList8;
                        TrackSampleTable trackSampleTable2 = (TrackSampleTable) arrayList9.get(i19);
                        int i20 = trackSampleTable2.track.id;
                        TrackBundle trackBundle = (TrackBundle) sparseArray.get(i20);
                        if (sparseArray2.size() == 1) {
                            defaultSampleValues2 = (DefaultSampleValues) sparseArray2.valueAt(0);
                        } else {
                            defaultSampleValues2 = (DefaultSampleValues) sparseArray2.get(i20);
                            defaultSampleValues2.getClass();
                        }
                        trackBundle.moovSampleTable = trackSampleTable2;
                        trackBundle.defaultSampleValues = defaultSampleValues2;
                        trackBundle.output.format(trackBundle.baseFormat);
                        trackBundle.resetFragmentInfo();
                        i19++;
                        arrayList8 = arrayList9;
                    }
                }
            } else if (i8 == 1836019558) {
                int size3 = arrayList4.size();
                int i21 = 0;
                while (i21 < size3) {
                    Mp4Box$ContainerBox mp4Box$ContainerBox2 = (Mp4Box$ContainerBox) arrayList4.get(i21);
                    if (mp4Box$ContainerBox2.flags == 1953653094) {
                        Mp4Box$LeafBox leafBoxOfType3 = mp4Box$ContainerBox2.getLeafBoxOfType(1952868452);
                        ArrayList arrayList10 = mp4Box$ContainerBox2.leafChildren;
                        leafBoxOfType3.getClass();
                        ParsableByteArray parsableByteArray2 = leafBoxOfType3.data;
                        parsableByteArray2.setPosition(8);
                        int i22 = parsableByteArray2.readInt();
                        byte[] bArr2 = BoxParser.opusMagic;
                        TrackBundle trackBundle2 = (TrackBundle) sparseArray.get(parsableByteArray2.readInt());
                        if (trackBundle2 == null) {
                            size3 = size3;
                            trackBundle2 = null;
                        } else {
                            TrackFragment trackFragment = trackBundle2.fragment;
                            if ((i22 & 1) != 0) {
                                long unsignedLongToLong = parsableByteArray2.readUnsignedLongToLong();
                                trackFragment.dataPosition = unsignedLongToLong;
                                trackFragment.auxiliaryDataPosition = unsignedLongToLong;
                            }
                            DefaultSampleValues defaultSampleValues3 = trackBundle2.defaultSampleValues;
                            trackFragment.header = new DefaultSampleValues((i22 & 2) != 0 ? parsableByteArray2.readInt() - 1 : defaultSampleValues3.sampleDescriptionIndex, (i22 & 8) != 0 ? parsableByteArray2.readInt() : defaultSampleValues3.duration, (i22 & 16) != 0 ? parsableByteArray2.readInt() : defaultSampleValues3.size, (i22 & 32) != 0 ? parsableByteArray2.readInt() : defaultSampleValues3.flags);
                        }
                        if (trackBundle2 != null) {
                            TrackFragment trackFragment2 = trackBundle2.fragment;
                            long j4 = trackFragment2.nextFragmentDecodeTime;
                            boolean z3 = trackFragment2.nextFragmentDecodeTimeIncludesMoov;
                            trackBundle2.resetFragmentInfo();
                            trackBundle2.currentlyInFragment = true;
                            Mp4Box$LeafBox leafBoxOfType4 = mp4Box$ContainerBox2.getLeafBoxOfType(1952867444);
                            if (leafBoxOfType4 == null || (i9 & 2) != 0) {
                                trackFragment2.nextFragmentDecodeTime = j4;
                                trackFragment2.nextFragmentDecodeTimeIncludesMoov = z3;
                            } else {
                                ParsableByteArray parsableByteArray3 = leafBoxOfType4.data;
                                parsableByteArray3.setPosition(8);
                                trackFragment2.nextFragmentDecodeTime = BoxParser.parseFullBoxVersion(parsableByteArray3.readInt()) == 1 ? parsableByteArray3.readUnsignedLongToLong() : parsableByteArray3.readUnsignedInt();
                                trackFragment2.nextFragmentDecodeTimeIncludesMoov = true;
                            }
                            int size4 = arrayList10.size();
                            int i23 = 0;
                            int i24 = 0;
                            int i25 = 0;
                            while (true) {
                                i5 = 1953658222;
                                if (i23 >= size4) {
                                    break;
                                }
                                Mp4Box$LeafBox mp4Box$LeafBox2 = (Mp4Box$LeafBox) arrayList10.get(i23);
                                int i26 = i21;
                                if (mp4Box$LeafBox2.flags == 1953658222) {
                                    ParsableByteArray parsableByteArray4 = mp4Box$LeafBox2.data;
                                    parsableByteArray4.setPosition(12);
                                    int unsignedIntToInt = parsableByteArray4.readUnsignedIntToInt();
                                    if (unsignedIntToInt > 0) {
                                        i25 += unsignedIntToInt;
                                        i24++;
                                    }
                                }
                                i23++;
                                i21 = i26;
                            }
                            i3 = i21;
                            trackBundle2.currentTrackRunIndex = 0;
                            trackBundle2.currentSampleInTrackRun = 0;
                            trackBundle2.currentSampleIndex = 0;
                            trackFragment2.trunCount = i24;
                            trackFragment2.sampleCount = i25;
                            if (trackFragment2.trunLength.length < i24) {
                                trackFragment2.trunDataPosition = new long[i24];
                                trackFragment2.trunLength = new int[i24];
                            }
                            if (trackFragment2.sampleSizeTable.length < i25) {
                                int i27 = (i25 * ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE) / 100;
                                trackFragment2.sampleSizeTable = new int[i27];
                                trackFragment2.samplePresentationTimesUs = new long[i27];
                                trackFragment2.sampleIsSyncFrameTable = new boolean[i27];
                                trackFragment2.sampleHasSubsampleEncryptionTable = new boolean[i27];
                            }
                            int i28 = 0;
                            int i29 = 0;
                            int i30 = 0;
                            while (true) {
                                long j5 = 0;
                                if (i28 >= size4) {
                                    arrayList2 = arrayList4;
                                    arrayList3 = arrayList5;
                                    i4 = i9;
                                    Track track2 = trackBundle2.moovSampleTable.track;
                                    DefaultSampleValues defaultSampleValues4 = trackFragment2.header;
                                    defaultSampleValues4.getClass();
                                    TrackEncryptionBox trackEncryptionBox = track2.sampleDescriptionEncryptionBoxes[defaultSampleValues4.sampleDescriptionIndex];
                                    Mp4Box$LeafBox leafBoxOfType5 = mp4Box$ContainerBox2.getLeafBoxOfType(1935763834);
                                    if (leafBoxOfType5 != null) {
                                        trackEncryptionBox.getClass();
                                        ParsableByteArray parsableByteArray5 = leafBoxOfType5.data;
                                        short s = trackEncryptionBox.perSampleIvSize;
                                        parsableByteArray5.setPosition(8);
                                        int i31 = parsableByteArray5.readInt();
                                        byte[] bArr3 = BoxParser.opusMagic;
                                        if ((i31 & 1) == 1) {
                                            parsableByteArray5.skipBytes(8);
                                        }
                                        int unsignedByte = parsableByteArray5.readUnsignedByte();
                                        int unsignedIntToInt2 = parsableByteArray5.readUnsignedIntToInt();
                                        if (unsignedIntToInt2 > trackFragment2.sampleCount) {
                                            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(unsignedIntToInt2, "Saiz sample count ", " is greater than fragment sample count");
                                            sbM2m.append(trackFragment2.sampleCount);
                                            throw ParserException.createForMalformedContainer(null, sbM2m.toString());
                                        }
                                        if (unsignedByte == 0) {
                                            boolean[] zArr = trackFragment2.sampleHasSubsampleEncryptionTable;
                                            i6 = 0;
                                            for (int i32 = 0; i32 < unsignedIntToInt2; i32++) {
                                                int unsignedByte2 = parsableByteArray5.readUnsignedByte();
                                                i6 += unsignedByte2;
                                                zArr[i32] = unsignedByte2 > s;
                                            }
                                            z = false;
                                        } else {
                                            boolean z4 = unsignedByte > s;
                                            i6 = unsignedByte * unsignedIntToInt2;
                                            z = false;
                                            Arrays.fill(trackFragment2.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt2, z4);
                                        }
                                        Arrays.fill(trackFragment2.sampleHasSubsampleEncryptionTable, unsignedIntToInt2, trackFragment2.sampleCount, z);
                                        if (i6 > 0) {
                                            trackFragment2.sampleEncryptionData.reset(i6);
                                            trackFragment2.definesEncryptionData = true;
                                            trackFragment2.sampleEncryptionDataNeedsFill = true;
                                        }
                                    }
                                    Mp4Box$LeafBox leafBoxOfType6 = mp4Box$ContainerBox2.getLeafBoxOfType(1935763823);
                                    if (leafBoxOfType6 != null) {
                                        ParsableByteArray parsableByteArray6 = leafBoxOfType6.data;
                                        parsableByteArray6.setPosition(8);
                                        int i33 = parsableByteArray6.readInt();
                                        byte[] bArr4 = BoxParser.opusMagic;
                                        if ((i33 & 1) == 1) {
                                            parsableByteArray6.skipBytes(8);
                                        }
                                        int unsignedIntToInt3 = parsableByteArray6.readUnsignedIntToInt();
                                        if (unsignedIntToInt3 != 1) {
                                            throw ParserException.createForMalformedContainer(null, "Unexpected saio entry count: " + unsignedIntToInt3);
                                        }
                                        trackFragment2.auxiliaryDataPosition += BoxParser.parseFullBoxVersion(i33) == 0 ? parsableByteArray6.readUnsignedInt() : parsableByteArray6.readUnsignedLongToLong();
                                    }
                                    Mp4Box$LeafBox leafBoxOfType7 = mp4Box$ContainerBox2.getLeafBoxOfType(1936027235);
                                    if (leafBoxOfType7 != null) {
                                        parseSenc(leafBoxOfType7.data, 0, trackFragment2);
                                    }
                                    String str2 = trackEncryptionBox != null ? trackEncryptionBox.schemeType : null;
                                    ParsableByteArray parsableByteArray7 = null;
                                    ParsableByteArray parsableByteArray8 = null;
                                    for (int i34 = 0; i34 < arrayList10.size(); i34++) {
                                        Mp4Box$LeafBox mp4Box$LeafBox3 = (Mp4Box$LeafBox) arrayList10.get(i34);
                                        ParsableByteArray parsableByteArray9 = mp4Box$LeafBox3.data;
                                        int i35 = mp4Box$LeafBox3.flags;
                                        if (i35 == 1935828848) {
                                            parsableByteArray9.setPosition(12);
                                            if (parsableByteArray9.readInt() == 1936025959) {
                                                parsableByteArray7 = parsableByteArray9;
                                            }
                                        } else if (i35 == 1936158820) {
                                            parsableByteArray9.setPosition(12);
                                            if (parsableByteArray9.readInt() == 1936025959) {
                                                parsableByteArray8 = parsableByteArray9;
                                            }
                                        }
                                    }
                                    if (parsableByteArray7 != null && parsableByteArray8 != null) {
                                        parsableByteArray7.setPosition(8);
                                        int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray7.readInt());
                                        parsableByteArray7.skipBytes(4);
                                        if (fullBoxVersion == 1) {
                                            parsableByteArray7.skipBytes(4);
                                        }
                                        if (parsableByteArray7.readInt() != 1) {
                                            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
                                        }
                                        parsableByteArray8.setPosition(8);
                                        int fullBoxVersion2 = BoxParser.parseFullBoxVersion(parsableByteArray8.readInt());
                                        parsableByteArray8.skipBytes(4);
                                        if (fullBoxVersion2 == 1) {
                                            if (parsableByteArray8.readUnsignedInt() == 0) {
                                                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
                                            }
                                        } else if (fullBoxVersion2 >= 2) {
                                            parsableByteArray8.skipBytes(4);
                                        }
                                        if (parsableByteArray8.readUnsignedInt() != 1) {
                                            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
                                        }
                                        parsableByteArray8.skipBytes(1);
                                        int unsignedByte3 = parsableByteArray8.readUnsignedByte();
                                        int i36 = (unsignedByte3 & 240) >> 4;
                                        int i37 = unsignedByte3 & 15;
                                        boolean z5 = parsableByteArray8.readUnsignedByte() == 1;
                                        if (z5) {
                                            int unsignedByte4 = parsableByteArray8.readUnsignedByte();
                                            byte[] bArr5 = new byte[16];
                                            parsableByteArray8.readBytes(bArr5, 0, 16);
                                            if (unsignedByte4 == 0) {
                                                int unsignedByte5 = parsableByteArray8.readUnsignedByte();
                                                byte[] bArr6 = new byte[unsignedByte5];
                                                parsableByteArray8.readBytes(bArr6, 0, unsignedByte5);
                                                bArr = bArr6;
                                            } else {
                                                bArr = null;
                                            }
                                            trackFragment2.definesEncryptionData = true;
                                            trackFragment2.trackEncryptionBox = new TrackEncryptionBox(z5, str2, unsignedByte4, bArr5, i36, i37, bArr);
                                        }
                                    }
                                    int size5 = arrayList10.size();
                                    for (int i38 = 0; i38 < size5; i38++) {
                                        Mp4Box$LeafBox mp4Box$LeafBox4 = (Mp4Box$LeafBox) arrayList10.get(i38);
                                        if (mp4Box$LeafBox4.flags == 1970628964) {
                                            ParsableByteArray parsableByteArray10 = mp4Box$LeafBox4.data;
                                            parsableByteArray10.setPosition(8);
                                            byte[] bArr7 = this.scratchBytes;
                                            parsableByteArray10.readBytes(bArr7, 0, 16);
                                            if (Arrays.equals(bArr7, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
                                                parseSenc(parsableByteArray10, 16, trackFragment2);
                                            }
                                        }
                                    }
                                    break;
                                }
                                Mp4Box$LeafBox mp4Box$LeafBox5 = (Mp4Box$LeafBox) arrayList10.get(i28);
                                if (mp4Box$LeafBox5.flags == i5) {
                                    int i39 = i29 + 1;
                                    ParsableByteArray parsableByteArray11 = mp4Box$LeafBox5.data;
                                    parsableByteArray11.setPosition(8);
                                    int i40 = parsableByteArray11.readInt();
                                    byte[] bArr8 = BoxParser.opusMagic;
                                    Track track3 = trackBundle2.moovSampleTable.track;
                                    DefaultSampleValues defaultSampleValues5 = trackFragment2.header;
                                    String str3 = Util.DEVICE_DEBUG_INFO;
                                    trackFragment2.trunLength[i29] = parsableByteArray11.readUnsignedIntToInt();
                                    long[] jArr = trackFragment2.trunDataPosition;
                                    i7 = i9;
                                    long j6 = trackFragment2.dataPosition;
                                    jArr[i29] = j6;
                                    if ((i40 & 1) != 0) {
                                        jArr[i29] = j6 + ((long) parsableByteArray11.readInt());
                                    }
                                    boolean z6 = (i40 & 4) != 0;
                                    int i41 = defaultSampleValues5.flags;
                                    if (z6) {
                                        i41 = parsableByteArray11.readInt();
                                    }
                                    boolean z7 = (i40 & 256) != 0;
                                    boolean z8 = z6;
                                    boolean z9 = (i40 & 512) != 0;
                                    boolean z10 = (i40 & 1024) != 0;
                                    boolean z11 = (i40 & 2048) != 0;
                                    boolean z12 = z10;
                                    long[] jArr2 = track3.editListDurations;
                                    int i42 = i41;
                                    long[] jArr3 = track3.editListMediaTimes;
                                    if (jArr2 == null || jArr2.length != 1 || jArr3 == null) {
                                        z2 = z7;
                                    } else {
                                        long j7 = jArr2[0];
                                        if (j7 == 0) {
                                            z2 = z7;
                                        } else {
                                            z2 = z7;
                                            long j8 = track3.movieTimescale;
                                            RoundingMode roundingMode = RoundingMode.DOWN;
                                            if (Util.scaleLargeValue(j7, 1000000L, j8, roundingMode) + Util.scaleLargeValue(jArr3[0], 1000000L, track3.timescale, roundingMode) >= track3.durationUs) {
                                            }
                                        }
                                        j5 = jArr3[0];
                                    }
                                    int[] iArr = trackFragment2.sampleSizeTable;
                                    long[] jArr4 = trackFragment2.samplePresentationTimesUs;
                                    boolean z13 = z2;
                                    boolean[] zArr2 = trackFragment2.sampleIsSyncFrameTable;
                                    boolean z14 = track3.type == 2 && (i7 & 1) != 0;
                                    int i43 = trackFragment2.trunLength[i29] + i30;
                                    int i44 = i30;
                                    long j9 = track3.timescale;
                                    boolean z15 = z11;
                                    long j10 = trackFragment2.nextFragmentDecodeTime;
                                    int i45 = i44;
                                    while (i45 < i43) {
                                        int i46 = z13 ? parsableByteArray11.readInt() : defaultSampleValues5.duration;
                                        boolean z16 = z15;
                                        if (i46 < 0) {
                                            throw ParserException.createForMalformedContainer(null, "Unexpected negative value: " + i46);
                                        }
                                        int i47 = z9 ? parsableByteArray11.readInt() : defaultSampleValues5.size;
                                        if (i47 < 0) {
                                            throw ParserException.createForMalformedContainer(null, "Unexpected negative value: " + i47);
                                        }
                                        int i48 = z12 ? parsableByteArray11.readInt() : (i45 == 0 && z8) ? i42 : defaultSampleValues5.flags;
                                        int i49 = i43;
                                        long[] jArr5 = jArr4;
                                        long jScaleLargeValue = Util.scaleLargeValue((((long) (z16 ? parsableByteArray11.readInt() : 0)) + j10) - j5, 1000000L, j9, RoundingMode.DOWN);
                                        jArr5[i45] = jScaleLargeValue;
                                        if (!trackFragment2.nextFragmentDecodeTimeIncludesMoov) {
                                            jArr5[i45] = jScaleLargeValue + trackBundle2.moovSampleTable.durationUs;
                                        }
                                        iArr[i45] = i47;
                                        zArr2[i45] = ((i48 >> 16) & 1) == 0 && (!z14 || i45 == 0);
                                        j10 += (long) i46;
                                        i45++;
                                        z15 = z16;
                                        z14 = z14;
                                        jArr4 = jArr5;
                                        i43 = i49;
                                    }
                                    trackFragment2.nextFragmentDecodeTime = j10;
                                    i29 = i39;
                                    i30 = i43;
                                } else {
                                    i7 = i9;
                                }
                                i28++;
                                arrayList4 = arrayList4;
                                arrayList5 = arrayList5;
                                i9 = i7;
                                size4 = size4;
                                i5 = 1953658222;
                            }
                        } else {
                            i3 = i21;
                            arrayList2 = arrayList4;
                            arrayList3 = arrayList5;
                            i4 = i9;
                        }
                    } else {
                        size3 = size3;
                        i3 = i21;
                        arrayList2 = arrayList4;
                        arrayList3 = arrayList5;
                        i4 = i9;
                    }
                    i21 = i3 + 1;
                    size3 = size3;
                    arrayList4 = arrayList2;
                    arrayList5 = arrayList3;
                    i9 = i4;
                }
                DrmInitData drmInitDataFromAtoms2 = getDrmInitDataFromAtoms(arrayList5);
                if (drmInitDataFromAtoms2 != null) {
                    int size6 = sparseArray.size();
                    for (int i50 = 0; i50 < size6; i50++) {
                        TrackBundle trackBundle3 = (TrackBundle) sparseArray.valueAt(i50);
                        Track track4 = trackBundle3.moovSampleTable.track;
                        DefaultSampleValues defaultSampleValues6 = trackBundle3.fragment.header;
                        String str4 = Util.DEVICE_DEBUG_INFO;
                        TrackEncryptionBox trackEncryptionBox2 = track4.sampleDescriptionEncryptionBoxes[defaultSampleValues6.sampleDescriptionIndex];
                        DrmInitData drmInitDataCopyWithSchemeType = drmInitDataFromAtoms2.copyWithSchemeType(trackEncryptionBox2 != null ? trackEncryptionBox2.schemeType : null);
                        Format.Builder builderBuildUpon2 = trackBundle3.baseFormat.buildUpon();
                        builderBuildUpon2.drmInitData = drmInitDataCopyWithSchemeType;
                        trackBundle3.output.format(new Format(builderBuildUpon2));
                    }
                }
                if (this.pendingSeekTimeUs != -9223372036854775807L) {
                    int size7 = sparseArray.size();
                    for (int i51 = 0; i51 < size7; i51++) {
                        TrackBundle trackBundle4 = (TrackBundle) sparseArray.valueAt(i51);
                        long j11 = this.pendingSeekTimeUs;
                        int i52 = trackBundle4.currentSampleIndex;
                        while (true) {
                            TrackFragment trackFragment3 = trackBundle4.fragment;
                            if (i52 >= trackFragment3.sampleCount || trackFragment3.samplePresentationTimesUs[i52] > j11) {
                                break;
                            }
                            if (trackFragment3.sampleIsSyncFrameTable[i52]) {
                                trackBundle4.firstSampleToOutputIndex = i52;
                            }
                            i52++;
                        }
                    }
                    this.pendingSeekTimeUs = -9223372036854775807L;
                }
            } else if (!arrayDeque.isEmpty()) {
                ((Mp4Box$ContainerBox) arrayDeque.peek()).containerChildren.add(mp4Box$ContainerBox);
            }
        }
        enterReadingAtomHeaderState();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:105:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:116:0x0236  */
    /* JADX WARN: Code duplicated, block: B:139:0x0281  */
    /* JADX WARN: Code duplicated, block: B:140:0x0283  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        RulerTrackingMap rulerTrackingMap;
        ParsableByteArray parsableByteArray;
        ArrayDeque arrayDeque;
        int i;
        TrackBundle trackBundle;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        String nalStructureMimeType;
        int iSampleData;
        int i6;
        int iOutputSampleEncryptionData;
        String nullTerminatedString;
        String nullTerminatedString2;
        long jScaleLargeValue;
        long unsignedInt;
        long j;
        int i7;
        ExtractorInput extractorInput2 = extractorInput;
        while (true) {
            byte b = this.parserState;
            ArrayDeque arrayDeque2 = this.containerAtoms;
            rulerTrackingMap = this.reorderingBufferQueue;
            parsableByteArray = this.scratch;
            NetworkHeaders.Builder builder = this.chunkIndexMerger;
            SparseArray sparseArray = this.trackBundles;
            int i8 = 1;
            if (b != 0) {
                arrayDeque = this.pendingMetadataSampleInfos;
                i = this.flags;
                if (b != 1) {
                    long j2 = Long.MAX_VALUE;
                    if (b != 2) {
                        trackBundle = this.currentTrackBundle;
                        if (trackBundle != null) {
                            i2 = 1;
                            i3 = 8;
                            i4 = 0;
                            break;
                        }
                        int size = sparseArray.size();
                        TrackBundle trackBundle2 = null;
                        int i9 = 0;
                        while (i9 < size) {
                            TrackBundle trackBundle3 = (TrackBundle) sparseArray.valueAt(i9);
                            boolean z2 = trackBundle3.currentlyInFragment;
                            int i10 = i8;
                            TrackFragment trackFragment = trackBundle3.fragment;
                            if ((z2 || trackBundle3.currentSampleIndex != trackBundle3.moovSampleTable.sampleCount) && (!z2 || trackBundle3.currentTrackRunIndex != trackFragment.trunCount)) {
                                long j3 = !z2 ? trackBundle3.moovSampleTable.offsets[trackBundle3.currentSampleIndex] : trackFragment.trunDataPosition[trackBundle3.currentTrackRunIndex];
                                if (j3 < j2) {
                                    j2 = j3;
                                    trackBundle2 = trackBundle3;
                                }
                            }
                            i9++;
                            i8 = i10;
                        }
                        i2 = i8;
                        i3 = 8;
                        i4 = 0;
                        if (trackBundle2 != null) {
                            int position = (int) ((!trackBundle2.currentlyInFragment ? trackBundle2.moovSampleTable.offsets[trackBundle2.currentSampleIndex] : trackBundle2.fragment.trunDataPosition[trackBundle2.currentTrackRunIndex]) - extractorInput2.getPosition());
                            if (position < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                position = 0;
                            }
                            extractorInput2.skipFully(position);
                            this.currentTrackBundle = trackBundle2;
                            trackBundle = trackBundle2;
                            break;
                        }
                        int position2 = (int) (this.endOfMdatPosition - extractorInput2.getPosition());
                        if (position2 < 0) {
                            throw ParserException.createForMalformedContainer(null, "Offset to end of mdat was negative.");
                        }
                        extractorInput2.skipFully(position2);
                        enterReadingAtomHeaderState();
                    } else {
                        int size2 = sparseArray.size();
                        TrackBundle trackBundle4 = null;
                        for (int i11 = 0; i11 < size2; i11++) {
                            TrackFragment trackFragment2 = ((TrackBundle) sparseArray.valueAt(i11)).fragment;
                            if (trackFragment2.sampleEncryptionDataNeedsFill) {
                                long j4 = trackFragment2.auxiliaryDataPosition;
                                if (j4 < j2) {
                                    trackBundle4 = (TrackBundle) sparseArray.valueAt(i11);
                                    j2 = j4;
                                }
                            }
                        }
                        if (trackBundle4 == null) {
                            this.parserState = (byte) 3;
                        } else {
                            int position3 = (int) (j2 - extractorInput2.getPosition());
                            if (position3 < 0) {
                                throw ParserException.createForMalformedContainer(null, "Offset to encryption data was negative.");
                            }
                            extractorInput2.skipFully(position3);
                            TrackFragment trackFragment3 = trackBundle4.fragment;
                            ParsableByteArray parsableByteArray2 = trackFragment3.sampleEncryptionData;
                            extractorInput2.readFully(parsableByteArray2.data, 0, parsableByteArray2.limit);
                            parsableByteArray2.setPosition(0);
                            trackFragment3.sampleEncryptionDataNeedsFill = false;
                        }
                    }
                } else {
                    int i12 = (int) (this.atomSize - ((long) this.atomHeaderBytesRead));
                    ParsableByteArray parsableByteArray3 = this.atomData;
                    if (parsableByteArray3 != null) {
                        extractorInput2.readFully(parsableByteArray3.data, 8, i12);
                        int i13 = this.atomType;
                        Mp4Box$LeafBox mp4Box$LeafBox = new Mp4Box$LeafBox(i13, parsableByteArray3);
                        if (!arrayDeque2.isEmpty()) {
                            ((Mp4Box$ContainerBox) arrayDeque2.peek()).leafChildren.add(mp4Box$LeafBox);
                        } else if (i13 == 1936286840) {
                            Pair sidx = parseSidx(extractorInput2.getPosition(), parsableByteArray3);
                            builder.add((ChunkIndex) sidx.second);
                            LinkedHashMap linkedHashMap = builder.data;
                            this.segmentIndexEarliestPresentationTimeUs = ((Long) sidx.first).longValue();
                            if (this.upfrontSidxScanComplete) {
                                i7 = 1;
                            } else {
                                i7 = 1;
                                this.extractorOutput.seekMap(linkedHashMap.size() == 1 ? (SeekMap) sidx.second : builder.merge());
                                this.haveOutputSeekMap = true;
                            }
                            if ((i & 256) != 0 && !this.upfrontSidxScanComplete && linkedHashMap.size() > i7) {
                                this.seekPositionBeforeSidxProcessing = extractorInput2.getPosition();
                            }
                        } else if (i13 == 1701671783 && this.emsgTrackOutputs.length != 0) {
                            parsableByteArray3.setPosition(8);
                            int fullBoxVersion = BoxParser.parseFullBoxVersion(parsableByteArray3.readInt());
                            long j5 = -9223372036854775807L;
                            if (fullBoxVersion == 0) {
                                nullTerminatedString = parsableByteArray3.readNullTerminatedString();
                                nullTerminatedString.getClass();
                                nullTerminatedString2 = parsableByteArray3.readNullTerminatedString();
                                nullTerminatedString2.getClass();
                                long unsignedInt2 = parsableByteArray3.readUnsignedInt();
                                long unsignedInt3 = parsableByteArray3.readUnsignedInt();
                                RoundingMode roundingMode = RoundingMode.DOWN;
                                long jScaleLargeValue2 = Util.scaleLargeValue(unsignedInt3, 1000000L, unsignedInt2, roundingMode);
                                long j6 = this.segmentIndexEarliestPresentationTimeUs;
                                long j7 = j6 != -9223372036854775807L ? j6 + jScaleLargeValue2 : -9223372036854775807L;
                                jScaleLargeValue = Util.scaleLargeValue(parsableByteArray3.readUnsignedInt(), 1000L, unsignedInt2, roundingMode);
                                unsignedInt = parsableByteArray3.readUnsignedInt();
                                j5 = jScaleLargeValue2;
                                j = j7;
                            } else if (fullBoxVersion != 1) {
                                Format$$ExternalSyntheticOutline0.m(fullBoxVersion, "Skipping unsupported emsg version: ", "FragmentedMp4Extractor");
                            } else {
                                long unsignedInt4 = parsableByteArray3.readUnsignedInt();
                                long unsignedLongToLong = parsableByteArray3.readUnsignedLongToLong();
                                RoundingMode roundingMode2 = RoundingMode.DOWN;
                                long jScaleLargeValue3 = Util.scaleLargeValue(unsignedLongToLong, 1000000L, unsignedInt4, roundingMode2);
                                jScaleLargeValue = Util.scaleLargeValue(parsableByteArray3.readUnsignedInt(), 1000L, unsignedInt4, roundingMode2);
                                unsignedInt = parsableByteArray3.readUnsignedInt();
                                nullTerminatedString = parsableByteArray3.readNullTerminatedString();
                                nullTerminatedString.getClass();
                                nullTerminatedString2 = parsableByteArray3.readNullTerminatedString();
                                nullTerminatedString2.getClass();
                                j = jScaleLargeValue3;
                            }
                            byte[] bArr = new byte[parsableByteArray3.bytesLeft()];
                            parsableByteArray3.readBytes(bArr, 0, parsableByteArray3.bytesLeft());
                            WeakCache weakCache = this.eventMessageEncoder;
                            DataOutputStream dataOutputStream = (DataOutputStream) weakCache.referenceQueue;
                            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) weakCache.values;
                            byteArrayOutputStream.reset();
                            try {
                                dataOutputStream.writeBytes(nullTerminatedString);
                                dataOutputStream.writeByte(0);
                                dataOutputStream.writeBytes(nullTerminatedString2);
                                dataOutputStream.writeByte(0);
                                dataOutputStream.writeLong(jScaleLargeValue);
                                dataOutputStream.writeLong(unsignedInt);
                                dataOutputStream.write(bArr);
                                dataOutputStream.flush();
                                ParsableByteArray parsableByteArray4 = new ParsableByteArray(byteArrayOutputStream.toByteArray());
                                int iBytesLeft = parsableByteArray4.bytesLeft();
                                for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                                    parsableByteArray4.setPosition(0);
                                    trackOutput.sampleData(iBytesLeft, parsableByteArray4);
                                }
                                if (j == -9223372036854775807L) {
                                    arrayDeque.addLast(new MetadataSampleInfo(iBytesLeft, j5, true));
                                    this.pendingMetadataSampleBytes += iBytesLeft;
                                } else if (arrayDeque.isEmpty()) {
                                    for (TrackOutput trackOutput2 : this.emsgTrackOutputs) {
                                        trackOutput2.sampleMetadata(j, 1, iBytesLeft, 0, null);
                                    }
                                } else {
                                    arrayDeque.addLast(new MetadataSampleInfo(iBytesLeft, j, false));
                                    this.pendingMetadataSampleBytes += iBytesLeft;
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        extractorInput2 = extractorInput;
                    } else {
                        extractorInput2.skipFully(i12);
                    }
                    processAtomEnded(extractorInput2.getPosition());
                }
            } else {
                int i14 = this.atomHeaderBytesRead;
                ParsableByteArray parsableByteArray5 = this.atomHeader;
                if (i14 == 0) {
                    if (!extractorInput2.readFully(parsableByteArray5.data, 0, 8, true)) {
                        long j8 = this.seekPositionBeforeSidxProcessing;
                        if (j8 == -1) {
                            rulerTrackingMap.flushQueueDownToSize(0);
                            return -1;
                        }
                        positionHolder.position = j8;
                        this.seekPositionBeforeSidxProcessing = -1L;
                        this.extractorOutput.seekMap(builder.merge());
                        this.upfrontSidxScanComplete = true;
                        return 1;
                    }
                    this.atomHeaderBytesRead = 8;
                    parsableByteArray5.setPosition(0);
                    this.atomSize = parsableByteArray5.readUnsignedInt();
                    this.atomType = parsableByteArray5.readInt();
                }
                long j9 = this.atomSize;
                if (j9 == 1) {
                    extractorInput2.readFully(parsableByteArray5.data, 8, 8);
                    this.atomHeaderBytesRead += 8;
                    this.atomSize = parsableByteArray5.readUnsignedLongToLong();
                } else if (j9 == 0) {
                    long length = extractorInput2.getLength();
                    if (length == -1 && !arrayDeque2.isEmpty()) {
                        length = ((Mp4Box$ContainerBox) arrayDeque2.peek()).endPosition;
                    }
                    if (length != -1) {
                        this.atomSize = (length - extractorInput2.getPosition()) + ((long) this.atomHeaderBytesRead);
                    }
                }
                long j10 = this.atomSize;
                int i15 = this.atomHeaderBytesRead;
                long j11 = i15;
                if (j10 < j11) {
                    if (this.atomType != 1718773093 || i15 != 8) {
                        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
                    }
                    this.atomSize = j11;
                    j10 = j11;
                }
                if (this.seekPositionBeforeSidxProcessing != -1) {
                    if (this.atomType == 1936286840) {
                        parsableByteArray.reset((int) j10);
                        System.arraycopy(parsableByteArray5.data, 0, parsableByteArray.data, 0, 8);
                        extractorInput2.readFully(parsableByteArray.data, 8, (int) (this.atomSize - ((long) this.atomHeaderBytesRead)));
                        builder.add((ChunkIndex) parseSidx(extractorInput2.getPeekPosition(), parsableByteArray).second);
                    } else {
                        extractorInput2.skipFully((int) (j10 - j11), true);
                    }
                    enterReadingAtomHeaderState();
                } else {
                    long position4 = extractorInput2.getPosition() - ((long) this.atomHeaderBytesRead);
                    int i16 = this.atomType;
                    if ((i16 == 1836019558 || i16 == 1835295092) && !this.haveOutputSeekMap) {
                        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position4));
                        this.haveOutputSeekMap = true;
                    }
                    if (this.atomType == 1836019558) {
                        int size3 = sparseArray.size();
                        for (int i17 = 0; i17 < size3; i17++) {
                            TrackFragment trackFragment4 = ((TrackBundle) sparseArray.valueAt(i17)).fragment;
                            trackFragment4.getClass();
                            trackFragment4.auxiliaryDataPosition = position4;
                            trackFragment4.dataPosition = position4;
                        }
                    }
                    int i18 = this.atomType;
                    if (i18 == 1835295092) {
                        this.currentTrackBundle = null;
                        this.endOfMdatPosition = position4 + this.atomSize;
                        this.parserState = (byte) 2;
                    } else if (i18 == 1836019574 || i18 == 1953653099 || i18 == 1835297121 || i18 == 1835626086 || i18 == 1937007212 || i18 == 1836019558 || i18 == 1953653094 || i18 == 1836475768 || i18 == 1701082227 || i18 == 1835365473) {
                        long position5 = extractorInput2.getPosition();
                        long j12 = this.atomSize;
                        long j13 = (position5 + j12) - 8;
                        if (j12 != this.atomHeaderBytesRead && this.atomType == 1835365473) {
                            parsableByteArray.reset(8);
                            extractorInput2.peekFully(parsableByteArray.data, 0, 8);
                            BoxParser.maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
                            extractorInput2.skipFully(parsableByteArray.position);
                            extractorInput2.resetPeekPosition();
                        }
                        arrayDeque2.push(new Mp4Box$ContainerBox(this.atomType, j13));
                        if (this.atomSize == this.atomHeaderBytesRead) {
                            processAtomEnded(j13);
                        } else {
                            enterReadingAtomHeaderState();
                        }
                    } else if (i18 == 1751411826 || i18 == 1835296868 || i18 == 1836476516 || i18 == 1936286840 || i18 == 1937011556 || i18 == 1937011827 || i18 == 1668576371 || i18 == 1937011555 || i18 == 1937011578 || i18 == 1937013298 || i18 == 1937007471 || i18 == 1668232756 || i18 == 1937011571 || i18 == 1952867444 || i18 == 1952868452 || i18 == 1953196132 || i18 == 1953654136 || i18 == 1953658222 || i18 == 1886614376 || i18 == 1935763834 || i18 == 1935763823 || i18 == 1936027235 || i18 == 1970628964 || i18 == 1935828848 || i18 == 1936158820 || i18 == 1701606260 || i18 == 1835362404 || i18 == 1701671783 || i18 == 1969517665 || i18 == 1801812339 || i18 == 1768715124) {
                        if (this.atomHeaderBytesRead != 8) {
                            throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
                        }
                        if (this.atomSize > 2147483647L) {
                            throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        ParsableByteArray parsableByteArray6 = new ParsableByteArray((int) this.atomSize);
                        System.arraycopy(parsableByteArray5.data, 0, parsableByteArray6.data, 0, 8);
                        this.atomData = parsableByteArray6;
                        this.parserState = (byte) 1;
                    } else {
                        if (this.atomSize > 2147483647L) {
                            throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
                        }
                        this.atomData = null;
                        this.parserState = (byte) 1;
                    }
                }
            }
        }
        TrackOutput trackOutput3 = trackBundle.output;
        TrackFragment trackFragment5 = trackBundle.fragment;
        if (this.parserState == 3) {
            this.sampleSize = !trackBundle.currentlyInFragment ? trackBundle.moovSampleTable.sizes[trackBundle.currentSampleIndex] : trackFragment5.sampleSizeTable[trackBundle.currentSampleIndex];
            Format format = trackBundle.moovSampleTable.track.format;
            this.isSampleDependedOn = ((!Objects.equals(format.sampleMimeType, "video/avc") ? !(!Objects.equals(format.sampleMimeType, "video/hevc") || (i & 128) == 0) : (i & 64) != 0) ? i4 : i2) ^ 1;
            if (trackBundle.currentSampleIndex < trackBundle.firstSampleToOutputIndex) {
                extractorInput2.skipFully(this.sampleSize);
                TrackEncryptionBox encryptionBoxIfEncrypted = trackBundle.getEncryptionBoxIfEncrypted();
                if (encryptionBoxIfEncrypted != null) {
                    ParsableByteArray parsableByteArray7 = trackFragment5.sampleEncryptionData;
                    short s = encryptionBoxIfEncrypted.perSampleIvSize;
                    if (s != 0) {
                        parsableByteArray7.skipBytes(s);
                    }
                    int i19 = trackBundle.currentSampleIndex;
                    if (trackFragment5.definesEncryptionData && trackFragment5.sampleHasSubsampleEncryptionTable[i19]) {
                        parsableByteArray7.skipBytes(parsableByteArray7.readUnsignedShort() * 6);
                    }
                }
                if (!trackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = (byte) 3;
                return i4;
            }
            if (trackBundle.moovSampleTable.track.sampleTransformation == i2) {
                this.sampleSize -= 8;
                extractorInput2.skipFully(i3);
            }
            boolean zEquals = "audio/ac4".equals(trackBundle.moovSampleTable.track.format.sampleMimeType);
            int i20 = this.sampleSize;
            if (zEquals) {
                this.sampleBytesWritten = trackBundle.outputSampleEncryptionData(i20, 7);
                AacUtil.getAc4SampleHeader(this.sampleSize, parsableByteArray);
                trackOutput3.sampleData(7, parsableByteArray);
                iOutputSampleEncryptionData = this.sampleBytesWritten + 7;
                this.sampleBytesWritten = iOutputSampleEncryptionData;
                i6 = i4;
            } else {
                i6 = i4;
                iOutputSampleEncryptionData = trackBundle.outputSampleEncryptionData(i20, i6);
                this.sampleBytesWritten = iOutputSampleEncryptionData;
            }
            this.sampleSize += iOutputSampleEncryptionData;
            this.parserState = (byte) 4;
            this.sampleCurrentNalBytesRemaining = i6;
        }
        TrackSampleTable trackSampleTable = trackBundle.moovSampleTable;
        Track track = trackSampleTable.track;
        long j14 = !trackBundle.currentlyInFragment ? trackSampleTable.timestampsUs[trackBundle.currentSampleIndex] : trackFragment5.samplePresentationTimesUs[trackBundle.currentSampleIndex];
        int i21 = track.nalUnitLengthFieldLength;
        Format format2 = track.format;
        if (i21 == 0) {
            trackBundle = trackBundle;
            while (true) {
                int i22 = this.sampleBytesWritten;
                int i23 = this.sampleSize;
                if (i22 >= i23) {
                    break;
                }
                this.sampleBytesWritten += trackOutput3.sampleData((DataReader) extractorInput2, i23 - i22, false);
            }
        } else {
            ParsableByteArray parsableByteArray8 = this.nalPrefix;
            byte[] bArr2 = parsableByteArray8.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[r13] = 0;
            int i24 = 4 - i21;
            while (true) {
                trackBundle = trackBundle;
                if (this.sampleBytesWritten < this.sampleSize) {
                    int i25 = this.sampleCurrentNalBytesRemaining;
                    if (i25 == 0) {
                        if (this.ceaTrackOutputs.length > 0 || !this.isSampleDependedOn) {
                            int iNumberOfBytesInNalUnitHeader = OpusUtil.numberOfBytesInNalUnitHeader(format2);
                            if (i21 + iNumberOfBytesInNalUnitHeader <= this.sampleSize - this.sampleBytesWritten) {
                                i5 = iNumberOfBytesInNalUnitHeader;
                            } else {
                                i5 = 0;
                            }
                        } else {
                            i5 = 0;
                        }
                        extractorInput2.readFully(bArr2, i24, i21 + i5);
                        parsableByteArray8.setPosition(0);
                        int i26 = parsableByteArray8.readInt();
                        if (i26 < 0) {
                            throw ParserException.createForMalformedContainer(null, "Invalid NAL length");
                        }
                        this.sampleCurrentNalBytesRemaining = i26 - i5;
                        ParsableByteArray parsableByteArray9 = this.nalStartCode;
                        int i27 = i21;
                        parsableByteArray9.setPosition(0);
                        trackOutput3.sampleData(4, parsableByteArray9);
                        this.sampleBytesWritten += 4;
                        this.sampleSize += i24;
                        if (this.ceaTrackOutputs.length > 0 && i5 > 0 && (nalStructureMimeType = OpusUtil.getNalStructureMimeType(format2)) != null) {
                            switch (nalStructureMimeType) {
                                case "video/hevc":
                                    if (((bArr2[4] & 126) >> 1) == 39) {
                                        z = true;
                                        break;
                                    } else {
                                        z = false;
                                        break;
                                    }
                                    break;
                                case "video/avc":
                                    if ((bArr2[4] & 31) == 6) {
                                        z = true;
                                        break;
                                    } else {
                                        z = false;
                                        break;
                                    }
                                    break;
                                case "video/vvc":
                                    if (((bArr2[5] & 248) >> 3) == 23) {
                                        z = true;
                                        break;
                                    } else {
                                        z = false;
                                        break;
                                    }
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                        } else {
                            z = false;
                        }
                        this.processSeiNalUnitPayload = z;
                        trackOutput3.sampleData(i5, parsableByteArray8);
                        this.sampleBytesWritten += i5;
                        if (i5 > 0 && !this.isSampleDependedOn && OpusUtil.isDependedOn(bArr2, i5, format2)) {
                            this.isSampleDependedOn = true;
                        }
                        i21 = i27;
                    } else {
                        int i28 = i21;
                        if (this.processSeiNalUnitPayload) {
                            ParsableByteArray parsableByteArray10 = this.nalUnitWithoutHeaderBuffer;
                            parsableByteArray10.reset(i25);
                            extractorInput2.readFully(parsableByteArray10.data, 0, this.sampleCurrentNalBytesRemaining);
                            trackOutput3.sampleData(this.sampleCurrentNalBytesRemaining, parsableByteArray10);
                            int i29 = this.sampleCurrentNalBytesRemaining;
                            int iUnescapeStream = OpusUtil.unescapeStream(parsableByteArray10.data, parsableByteArray10.limit);
                            parsableByteArray10.setPosition(0);
                            parsableByteArray10.setLimit(iUnescapeStream);
                            int i30 = format2.maxNumReorderSamples;
                            if (i30 == -1) {
                                if (rulerTrackingMap.size != 0) {
                                    rulerTrackingMap.setMaxSize(0);
                                }
                            } else if (rulerTrackingMap.size != i30) {
                                rulerTrackingMap.setMaxSize(i30);
                            }
                            rulerTrackingMap.add(j14, parsableByteArray10);
                            if ((trackBundle.getCurrentSampleFlags() & 4) != 0) {
                                rulerTrackingMap.flushQueueDownToSize(0);
                            }
                            iSampleData = i29;
                        } else {
                            iSampleData = trackOutput3.sampleData((DataReader) extractorInput2, i25, false);
                        }
                        this.sampleBytesWritten += iSampleData;
                        this.sampleCurrentNalBytesRemaining -= iSampleData;
                        i21 = i28;
                        parsableByteArray8 = parsableByteArray8;
                    }
                }
            }
        }
        int currentSampleFlags = trackBundle.getCurrentSampleFlags();
        if (!this.isSampleDependedOn) {
            currentSampleFlags |= 67108864;
        }
        int i31 = currentSampleFlags;
        TrackEncryptionBox encryptionBoxIfEncrypted2 = trackBundle.getEncryptionBoxIfEncrypted();
        trackOutput3.sampleMetadata(j14, i31, this.sampleSize, 0, encryptionBoxIfEncrypted2 != null ? encryptionBoxIfEncrypted2.cryptoData : null);
        while (!arrayDeque.isEmpty()) {
            MetadataSampleInfo metadataSampleInfo = (MetadataSampleInfo) arrayDeque.removeFirst();
            this.pendingMetadataSampleBytes -= metadataSampleInfo.size;
            long j15 = metadataSampleInfo.sampleTimeUs;
            if (metadataSampleInfo.sampleTimeIsRelative) {
                j15 += j14;
            }
            long j16 = j15;
            for (TrackOutput trackOutput4 : this.emsgTrackOutputs) {
                trackOutput4.sampleMetadata(j16, 1, metadataSampleInfo.size, this.pendingMetadataSampleBytes, null);
            }
        }
        if (!trackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = (byte) 3;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        SparseArray sparseArray = this.trackBundles;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((TrackBundle) sparseArray.valueAt(i)).resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        ((PriorityQueue) this.reorderingBufferQueue.layoutNodes).clear();
        this.pendingSeekTimeUs = j2;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        RegularImmutableList regularImmutableListOf;
        SniffFailure sniffFailureSniffInternal = Sniffer.sniffInternal(extractorInput, true, false);
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
