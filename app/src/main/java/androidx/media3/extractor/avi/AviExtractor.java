package androidx.media3.extractor.avi;

import androidx.compose.runtime.Latch;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Ac4Util$SyncFrameInfo;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.CueDecoder;
import com.google.common.collect.ImmutableList;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AviExtractor implements Extractor {
    public AviMainHeaderChunk aviHeader;
    public final Ac4Util$SyncFrameInfo chunkHeaderHolder;
    public ChunkReader[] chunkReaders;
    public ChunkReader currentChunkReader;
    public long durationUs;
    public ExtractorOutput extractorOutput;
    public int hdrlSize;
    public int idx1BodySize;
    public long moviEnd;
    public long moviStart;
    public final boolean parseSubtitlesDuringExtraction;
    public long pendingReposition;
    public final ParsableByteArray scratch;
    public boolean seekMapHasBeenOutput;
    public byte state;
    public final CueDecoder subtitleParserFactory;

    public AviExtractor(int i, CueDecoder cueDecoder) {
        this.subtitleParserFactory = cueDecoder;
        this.parseSubtitlesDuringExtraction = (i & 1) == 0;
        this.scratch = new ParsableByteArray(12);
        this.chunkHeaderHolder = new Ac4Util$SyncFrameInfo();
        this.extractorOutput = new CueDecoder((byte) 9);
        this.chunkReaders = new ChunkReader[0];
        this.moviStart = -1L;
        this.moviEnd = -1L;
        this.hdrlSize = -1;
        this.durationUs = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.state = (byte) 0;
        if (this.parseSubtitlesDuringExtraction) {
            extractorOutput = new Latch(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
        this.pendingReposition = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:175:0x039c  */
    /* JADX WARN: Code duplicated, block: B:65:0x010b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0114  */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        boolean z;
        ChunkReader chunkReader;
        int i;
        ChunkReader chunkReader2;
        if (this.pendingReposition != -1) {
            long position = extractorInput.getPosition();
            long j = this.pendingReposition;
            if (j < position || j > 262144 + position) {
                positionHolder.position = j;
                z = true;
            } else {
                extractorInput.skipFully((int) (j - position));
                z = false;
            }
        } else {
            z = false;
        }
        this.pendingReposition = -1L;
        if (z) {
            return 1;
        }
        byte b = this.state;
        int i2 = 4;
        ChunkReader chunkReader3 = null;
        Ac4Util$SyncFrameInfo ac4Util$SyncFrameInfo = this.chunkHeaderHolder;
        ParsableByteArray parsableByteArray = this.scratch;
        switch (b) {
            case 0:
                if (!sniff(extractorInput)) {
                    throw ParserException.createForMalformedContainer(null, "AVI Header List not found");
                }
                extractorInput.skipFully(12);
                this.state = (byte) 1;
                return 0;
            case 1:
                extractorInput.readFully(parsableByteArray.data, 0, 12);
                parsableByteArray.setPosition(0);
                ac4Util$SyncFrameInfo.sampleRate = parsableByteArray.readLittleEndianInt();
                ac4Util$SyncFrameInfo.frameSize = parsableByteArray.readLittleEndianInt();
                ac4Util$SyncFrameInfo.sampleCount = 0;
                if (ac4Util$SyncFrameInfo.sampleRate != 1414744396) {
                    throw ParserException.createForMalformedContainer(null, "LIST expected, found: " + ac4Util$SyncFrameInfo.sampleRate);
                }
                int littleEndianInt = parsableByteArray.readLittleEndianInt();
                ac4Util$SyncFrameInfo.sampleCount = littleEndianInt;
                if (littleEndianInt == 1819436136) {
                    this.hdrlSize = ac4Util$SyncFrameInfo.frameSize;
                    this.state = (byte) 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer(null, "hdrl expected, found: " + ac4Util$SyncFrameInfo.sampleCount);
            case 2:
                int i3 = this.hdrlSize - 4;
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(i3);
                extractorInput.readFully(parsableByteArray2.data, 0, i3);
                ListChunk from = ListChunk.parseFrom(1819436136, parsableByteArray2);
                int i4 = from.type;
                if (i4 != 1819436136) {
                    throw ParserException.createForMalformedContainer(null, "Unexpected header list type " + i4);
                }
                AviMainHeaderChunk aviMainHeaderChunk = (AviMainHeaderChunk) from.getChild(AviMainHeaderChunk.class);
                if (aviMainHeaderChunk == null) {
                    throw ParserException.createForMalformedContainer(null, "AviHeader not found");
                }
                this.aviHeader = aviMainHeaderChunk;
                this.durationUs = ((long) aviMainHeaderChunk.totalFrames) * ((long) aviMainHeaderChunk.frameDurationUs);
                ArrayList arrayList = new ArrayList();
                ImmutableList.Itr itrListIterator = from.children.listIterator(0);
                int i5 = 0;
                while (itrListIterator.hasNext()) {
                    AviChunk aviChunk = (AviChunk) itrListIterator.next();
                    if (aviChunk.getType() == 1819440243) {
                        ListChunk listChunk = (ListChunk) aviChunk;
                        int i6 = i5 + 1;
                        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.getChild(AviStreamHeaderChunk.class);
                        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.getChild(StreamFormatChunk.class);
                        if (aviStreamHeaderChunk == null) {
                            Log.w("AviExtractor", "Missing Stream Header");
                        } else if (streamFormatChunk == null) {
                            Log.w("AviExtractor", "Missing Stream Format");
                        } else {
                            long j2 = aviStreamHeaderChunk.length;
                            long j3 = 1000000 * ((long) aviStreamHeaderChunk.scale);
                            long j4 = aviStreamHeaderChunk.rate;
                            String str = Util.DEVICE_DEBUG_INFO;
                            long jScaleLargeValue = Util.scaleLargeValue(j2, j3, j4, RoundingMode.DOWN);
                            Format format = streamFormatChunk.format;
                            Format.Builder builderBuildUpon = format.buildUpon();
                            builderBuildUpon.id = Integer.toString(i5);
                            int i7 = aviStreamHeaderChunk.suggestedBufferSize;
                            if (i7 != 0) {
                                builderBuildUpon.maxInputSize = i7;
                            }
                            StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.getChild(StreamNameChunk.class);
                            if (streamNameChunk != null) {
                                builderBuildUpon.label = streamNameChunk.name;
                            }
                            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
                            if (trackType == 1 || trackType == 2) {
                                TrackOutput trackOutputTrack = this.extractorOutput.track(i5, trackType);
                                trackOutputTrack.format(new Format(builderBuildUpon));
                                trackOutputTrack.durationUs(jScaleLargeValue);
                                this.durationUs = Math.max(this.durationUs, jScaleLargeValue);
                                chunkReader = new ChunkReader(i5, aviStreamHeaderChunk, trackOutputTrack);
                            }
                            if (chunkReader != null) {
                                arrayList.add(chunkReader);
                            }
                            i5 = i6;
                        }
                        chunkReader = null;
                        if (chunkReader != null) {
                            arrayList.add(chunkReader);
                        }
                        i5 = i6;
                    }
                }
                this.chunkReaders = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
                this.extractorOutput.endTracks();
                this.state = (byte) 3;
                return 0;
            case 3:
                if (this.moviStart != -1) {
                    long position2 = extractorInput.getPosition();
                    long j5 = this.moviStart;
                    if (position2 != j5) {
                        this.pendingReposition = j5;
                        return 0;
                    }
                }
                extractorInput.peekFully(parsableByteArray.data, 0, 12);
                extractorInput.resetPeekPosition();
                parsableByteArray.setPosition(0);
                ac4Util$SyncFrameInfo.sampleRate = parsableByteArray.readLittleEndianInt();
                ac4Util$SyncFrameInfo.frameSize = parsableByteArray.readLittleEndianInt();
                ac4Util$SyncFrameInfo.sampleCount = 0;
                int littleEndianInt2 = parsableByteArray.readLittleEndianInt();
                int i8 = ac4Util$SyncFrameInfo.sampleRate;
                if (i8 == 1179011410) {
                    extractorInput.skipFully(12);
                    return 0;
                }
                if (i8 != 1414744396 || littleEndianInt2 != 1769369453) {
                    this.pendingReposition = extractorInput.getPosition() + ((long) ac4Util$SyncFrameInfo.frameSize) + 8;
                    return 0;
                }
                long position3 = extractorInput.getPosition();
                this.moviStart = position3;
                this.moviEnd = position3 + ((long) ac4Util$SyncFrameInfo.frameSize) + 8;
                if (!this.seekMapHasBeenOutput) {
                    AviMainHeaderChunk aviMainHeaderChunk2 = this.aviHeader;
                    aviMainHeaderChunk2.getClass();
                    if ((aviMainHeaderChunk2.flags & 16) == 16) {
                        this.state = (byte) 4;
                        this.pendingReposition = this.moviEnd;
                        return 0;
                    }
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                    this.seekMapHasBeenOutput = true;
                }
                this.pendingReposition = extractorInput.getPosition() + 12;
                this.state = (byte) 6;
                return 0;
            case 4:
                extractorInput.readFully(parsableByteArray.data, 0, 8);
                parsableByteArray.setPosition(0);
                int littleEndianInt3 = parsableByteArray.readLittleEndianInt();
                int littleEndianInt4 = parsableByteArray.readLittleEndianInt();
                if (littleEndianInt3 != 829973609) {
                    this.pendingReposition = extractorInput.getPosition() + ((long) littleEndianInt4);
                    return 0;
                }
                this.state = (byte) 5;
                this.idx1BodySize = littleEndianInt4;
                return 0;
            case 5:
                ParsableByteArray parsableByteArray3 = new ParsableByteArray(this.idx1BodySize);
                extractorInput.readFully(parsableByteArray3.data, 0, this.idx1BodySize);
                long j6 = 0;
                if (parsableByteArray3.bytesLeft() >= 16) {
                    int i9 = parsableByteArray3.position;
                    parsableByteArray3.skipBytes(8);
                    long littleEndianInt5 = parsableByteArray3.readLittleEndianInt();
                    long j7 = this.moviStart;
                    j6 = littleEndianInt5 <= j7 ? j7 + 8 : 0L;
                    parsableByteArray3.setPosition(i9);
                }
                while (parsableByteArray3.bytesLeft() >= 16) {
                    int littleEndianInt6 = parsableByteArray3.readLittleEndianInt();
                    int littleEndianInt7 = parsableByteArray3.readLittleEndianInt();
                    long littleEndianInt8 = ((long) parsableByteArray3.readLittleEndianInt()) + j6;
                    parsableByteArray3.skipBytes(i2);
                    ChunkReader[] chunkReaderArr = this.chunkReaders;
                    int length = chunkReaderArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            chunkReader2 = chunkReaderArr[i10];
                            if (chunkReader2.chunkId != littleEndianInt6 && chunkReader2.alternativeChunkId != littleEndianInt6) {
                                i10++;
                            }
                        } else {
                            chunkReader2 = null;
                        }
                    }
                    if (chunkReader2 != null) {
                        boolean z2 = (littleEndianInt7 & 16) == 16;
                        if (chunkReader2.firstIndexChunkOffset == -1) {
                            chunkReader2.firstIndexChunkOffset = littleEndianInt8;
                        }
                        if (z2) {
                            int i11 = chunkReader2.indexSize;
                            int[] iArrCopyOf = chunkReader2.keyFrameIndices;
                            if (i11 == iArrCopyOf.length) {
                                long[] jArr = chunkReader2.keyFrameOffsets;
                                chunkReader2.keyFrameOffsets = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                                int[] iArr = chunkReader2.keyFrameIndices;
                                iArrCopyOf = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
                                chunkReader2.keyFrameIndices = iArrCopyOf;
                            }
                            long[] jArr2 = chunkReader2.keyFrameOffsets;
                            int i12 = chunkReader2.indexSize;
                            jArr2[i12] = littleEndianInt8;
                            iArrCopyOf[i12] = chunkReader2.indexChunkCount;
                            chunkReader2.indexSize = i12 + 1;
                        }
                        chunkReader2.indexChunkCount++;
                    }
                    i2 = 4;
                }
                for (ChunkReader chunkReader4 : this.chunkReaders) {
                    chunkReader4.keyFrameOffsets = Arrays.copyOf(chunkReader4.keyFrameOffsets, chunkReader4.indexSize);
                    chunkReader4.keyFrameIndices = Arrays.copyOf(chunkReader4.keyFrameIndices, chunkReader4.indexSize);
                    if ((chunkReader4.chunkId & 1651965952) == 1651965952 && chunkReader4.streamHeaderChunk.sampleSize != 0 && (i = chunkReader4.indexSize) > 0) {
                        chunkReader4.chunkCount = i;
                    }
                }
                this.seekMapHasBeenOutput = true;
                int length2 = this.chunkReaders.length;
                ExtractorOutput extractorOutput = this.extractorOutput;
                long j8 = this.durationUs;
                if (length2 == 0) {
                    extractorOutput.seekMap(new SeekMap.Unseekable(j8));
                } else {
                    extractorOutput.seekMap(new SeekMap.Unseekable(this, j8, (byte) 2));
                }
                this.state = (byte) 6;
                this.pendingReposition = this.moviStart;
                return 0;
            case 6:
                if (extractorInput.getPosition() >= this.moviEnd) {
                    return -1;
                }
                ChunkReader chunkReader5 = this.currentChunkReader;
                if (chunkReader5 != null) {
                    TrackOutput trackOutput = chunkReader5.trackOutput;
                    int i13 = chunkReader5.bytesRemainingInCurrentChunk;
                    int iSampleData = i13 - trackOutput.sampleData((DataReader) extractorInput, i13, false);
                    chunkReader5.bytesRemainingInCurrentChunk = iSampleData;
                    boolean z3 = iSampleData == 0;
                    if (z3) {
                        if (chunkReader5.currentChunkSize > 0) {
                            int i14 = chunkReader5.currentChunkIndex;
                            trackOutput.sampleMetadata((chunkReader5.durationUs * ((long) i14)) / ((long) chunkReader5.chunkCount), Arrays.binarySearch(chunkReader5.keyFrameIndices, i14) >= 0 ? 1 : 0, chunkReader5.currentChunkSize, 0, null);
                        }
                        chunkReader5.currentChunkIndex++;
                    }
                    if (z3) {
                        this.currentChunkReader = null;
                    }
                    return 0;
                }
                if ((extractorInput.getPosition() & 1) == 1) {
                    extractorInput.skipFully(1);
                }
                extractorInput.peekFully(parsableByteArray.data, 0, 12);
                parsableByteArray.setPosition(0);
                int littleEndianInt9 = parsableByteArray.readLittleEndianInt();
                if (littleEndianInt9 == 1414744396) {
                    parsableByteArray.setPosition(8);
                    extractorInput.skipFully(parsableByteArray.readLittleEndianInt() == 1769369453 ? 12 : 8);
                    extractorInput.resetPeekPosition();
                    return 0;
                }
                int littleEndianInt10 = parsableByteArray.readLittleEndianInt();
                if (littleEndianInt9 == 1263424842) {
                    this.pendingReposition = extractorInput.getPosition() + ((long) littleEndianInt10) + 8;
                    return 0;
                }
                extractorInput.skipFully(8);
                extractorInput.resetPeekPosition();
                for (ChunkReader chunkReader6 : this.chunkReaders) {
                    if (chunkReader6.chunkId == littleEndianInt9 || chunkReader6.alternativeChunkId == littleEndianInt9) {
                        chunkReader3 = chunkReader6;
                        if (chunkReader3 == null) {
                            this.pendingReposition = extractorInput.getPosition() + ((long) littleEndianInt10);
                            return 0;
                        }
                        chunkReader3.currentChunkSize = littleEndianInt10;
                        chunkReader3.bytesRemainingInCurrentChunk = littleEndianInt10;
                        this.currentChunkReader = chunkReader3;
                        return 0;
                    }
                }
                if (chunkReader3 == null) {
                    this.pendingReposition = extractorInput.getPosition() + ((long) littleEndianInt10);
                    return 0;
                }
                chunkReader3.currentChunkSize = littleEndianInt10;
                chunkReader3.bytesRemainingInCurrentChunk = littleEndianInt10;
                this.currentChunkReader = chunkReader3;
                return 0;
            default:
                throw new AssertionError();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.pendingReposition = -1L;
        this.currentChunkReader = null;
        for (ChunkReader chunkReader : this.chunkReaders) {
            if (chunkReader.indexSize == 0) {
                chunkReader.currentChunkIndex = 0;
            } else {
                chunkReader.currentChunkIndex = chunkReader.keyFrameIndices[Util.binarySearchFloor(chunkReader.keyFrameOffsets, j, true)];
            }
        }
        if (j != 0) {
            this.state = (byte) 6;
        } else if (this.chunkReaders.length == 0) {
            this.state = (byte) 0;
        } else {
            this.state = (byte) 3;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.scratch;
        extractorInput.peekFully(parsableByteArray.data, 0, 12);
        parsableByteArray.setPosition(0);
        if (parsableByteArray.readLittleEndianInt() == 1179011410) {
            parsableByteArray.skipBytes(4);
            if (parsableByteArray.readLittleEndianInt() == 541677121) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
