package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import coil3.util.UtilsKt;
import java.math.RoundingMode;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.time.InstantParseResult;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WavExtractor implements Extractor {
    public ExtractorOutput extractorOutput;
    public OutputWriter outputWriter;
    public TrackOutput trackOutput;
    public int state = 0;
    public long rf64SampleDataSize = -1;
    public int dataStartPosition = -1;
    public long dataEndPosition = -1;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ImaAdPcmOutputWriter implements OutputWriter {
        public static final int[] INDEX_TABLE = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] STEP_TABLE = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final ParsableByteArray decodedData;
        public final ExtractorOutput extractorOutput;
        public final Format format;
        public final int framesPerBlock;
        public final byte[] inputData;
        public long outputFrameCount;
        public int pendingInputBytes;
        public int pendingOutputBytes;
        public long startTimeUs;
        public final int targetSampleSizeFrames;
        public final TrackOutput trackOutput;
        public final WavFormat wavFormat;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat) throws ParserException {
            this.extractorOutput = extractorOutput;
            this.trackOutput = trackOutput;
            this.wavFormat = wavFormat;
            int i = wavFormat.frameRateHz;
            int iMax = Math.max(1, i / 10);
            this.targetSampleSizeFrames = iMax;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat.extraData);
            parsableByteArray.readLittleEndianUnsignedShort();
            int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.framesPerBlock = littleEndianUnsignedShort;
            int i2 = wavFormat.numChannels;
            int i3 = wavFormat.blockSize;
            int i4 = (((i3 - (i2 * 4)) * 8) / (wavFormat.bitsPerSample * i2)) + 1;
            if (littleEndianUnsignedShort != i4) {
                throw ParserException.createForMalformedContainer(null, "Expected frames per block: " + i4 + "; got: " + littleEndianUnsignedShort);
            }
            int iCeilDivide = Util.ceilDivide(iMax, littleEndianUnsignedShort);
            this.inputData = new byte[iCeilDivide * i3];
            this.decodedData = new ParsableByteArray(littleEndianUnsignedShort * 2 * i2 * iCeilDivide);
            int i5 = ((i3 * i) * 8) / littleEndianUnsignedShort;
            Format.Builder builder = new Format.Builder();
            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/raw");
            builder.averageBitrate = i5;
            builder.peakBitrate = i5;
            builder.maxInputSize = iMax * 2 * i2;
            builder.channelCount = i2;
            builder.sampleRate = i;
            builder.pcmEncoding = 2;
            this.format = new Format(builder);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void init(int i, long j) {
            WavSeekMap wavSeekMap = new WavSeekMap(this.wavFormat, this.framesPerBlock, i, j);
            this.extractorOutput.seekMap(wavSeekMap);
            Format format = this.format;
            TrackOutput trackOutput = this.trackOutput;
            trackOutput.format(format);
            trackOutput.durationUs(wavSeekMap.durationUs);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void reset(long j) {
            this.pendingInputBytes = 0;
            this.startTimeUs = j;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004a  */
        /* JADX WARN: Code duplicated, block: B:19:0x004f  */
        /* JADX WARN: Code duplicated, block: B:22:0x0054  */
        /* JADX WARN: Code duplicated, block: B:25:0x00a3  */
        /* JADX WARN: Code duplicated, block: B:27:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:28:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:31:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:37:0x0135  */
        /* JADX WARN: Code duplicated, block: B:43:0x0045 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x010b A[EDGE_INSN: B:47:0x010b->B:35:0x010b BREAK  A[LOOP:1: B:17:0x004b->B:34:0x0101], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:51:0x00cd A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:8:0x0027  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003c -> B:4:0x0020). Please report as a decompilation issue!!! */
        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final boolean sampleData(ExtractorInput extractorInput, long j) {
            byte[] bArr;
            int i;
            int i2;
            int i3;
            ParsableByteArray parsableByteArray;
            int i4;
            int i5;
            int i6;
            byte[] bArr2;
            int i7;
            int i8;
            int iConstrainValue;
            int iMin;
            int[] iArr;
            int i9;
            int i10;
            int i11;
            byte b;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18 = this.pendingOutputBytes;
            WavFormat wavFormat = this.wavFormat;
            int i19 = i18 / (wavFormat.numChannels * 2);
            int i20 = this.targetSampleSizeFrames;
            int i21 = this.framesPerBlock;
            int iCeilDivide = Util.ceilDivide(i20 - i19, i21);
            int i22 = wavFormat.blockSize;
            int i23 = iCeilDivide * i22;
            boolean z = j == 0;
            while (true) {
                bArr = this.inputData;
                if (z && (i16 = this.pendingInputBytes) < i23) {
                    i17 = extractorInput.read(bArr, this.pendingInputBytes, (int) Math.min(i23 - i16, j));
                    if (i17 == -1) {
                        break;
                    }
                    this.pendingInputBytes += i17;
                    bArr = this.inputData;
                    if (z) {
                    }
                }
                i = this.pendingInputBytes / i22;
                if (i > 0) {
                    i3 = 0;
                    while (true) {
                        parsableByteArray = this.decodedData;
                        if (i3 < i) {
                            break;
                        }
                        i5 = 0;
                        while (true) {
                            i6 = wavFormat.numChannels;
                            if (i5 < i6) {
                                bArr2 = parsableByteArray.data;
                                int i24 = (i5 * 4) + (i3 * i22);
                                i7 = (i6 * 4) + i24;
                                i8 = (i22 / i6) - 4;
                                iConstrainValue = (short) ((bArr[i24] & 255) | ((bArr[i24 + 1] & 255) << 8));
                                int i25 = i;
                                iMin = Math.min(bArr[i24 + 2] & 255, 88);
                                iArr = STEP_TABLE;
                                i9 = iArr[iMin];
                                i10 = ((i3 * i21 * i6) + i5) * 2;
                                bArr2[i10] = (byte) (iConstrainValue & 255);
                                bArr2[i10 + 1] = (byte) (iConstrainValue >> 8);
                                int i26 = i3;
                                i11 = 0;
                                while (i11 < i8 * 2) {
                                    b = bArr[((i11 / 8) * i6 * 4) + i7 + ((i11 / 2) % 4)];
                                    i12 = i11;
                                    i13 = b & 255;
                                    if (i12 % 2 == 0) {
                                        i14 = b & 15;
                                    } else {
                                        i14 = i13 >> 4;
                                    }
                                    i15 = ((((i14 & 7) * 2) + 1) * i9) >> 3;
                                    if ((i14 & 8) != 0) {
                                        i15 = -i15;
                                    }
                                    iConstrainValue = Util.constrainValue(iConstrainValue + i15, -32768, 32767);
                                    i10 = (i6 * 2) + i10;
                                    bArr2[i10] = (byte) (iConstrainValue & 255);
                                    bArr2[i10 + 1] = (byte) (iConstrainValue >> 8);
                                    iMin = Util.constrainValue(iMin + INDEX_TABLE[i14], 0, 88);
                                    i9 = iArr[iMin];
                                    i11 = i12 + 1;
                                }
                                i5++;
                                i = i25;
                                i3 = i26;
                            }
                        }
                        i3++;
                    }
                    int i27 = i;
                    int i28 = i21 * i27 * 2 * wavFormat.numChannels;
                    parsableByteArray.setPosition(0);
                    parsableByteArray.setLimit(i28);
                    this.pendingInputBytes -= i27 * i22;
                    int i29 = parsableByteArray.limit;
                    this.trackOutput.sampleData(i29, parsableByteArray);
                    i4 = this.pendingOutputBytes + i29;
                    this.pendingOutputBytes = i4;
                    if (i4 / (wavFormat.numChannels * 2) >= i20) {
                        writeSampleMetadata(i20);
                    }
                }
                if (z && (i2 = this.pendingOutputBytes / (wavFormat.numChannels * 2)) > 0) {
                    writeSampleMetadata(i2);
                }
                return z;
            }
            while (true) {
                bArr = this.inputData;
                if (z) {
                }
                i = this.pendingInputBytes / i22;
                if (i > 0) {
                    i3 = 0;
                    while (true) {
                        parsableByteArray = this.decodedData;
                        if (i3 < i) {
                            break;
                            break;
                        }
                        i5 = 0;
                        while (true) {
                            i6 = wavFormat.numChannels;
                            if (i5 < i6) {
                                bArr2 = parsableByteArray.data;
                                int i210 = (i5 * 4) + (i3 * i22);
                                i7 = (i6 * 4) + i210;
                                i8 = (i22 / i6) - 4;
                                iConstrainValue = (short) ((bArr[i210] & 255) | ((bArr[i210 + 1] & 255) << 8));
                                int i211 = i;
                                iMin = Math.min(bArr[i210 + 2] & 255, 88);
                                iArr = STEP_TABLE;
                                i9 = iArr[iMin];
                                i10 = ((i3 * i21 * i6) + i5) * 2;
                                bArr2[i10] = (byte) (iConstrainValue & 255);
                                bArr2[i10 + 1] = (byte) (iConstrainValue >> 8);
                                int i212 = i3;
                                i11 = 0;
                                while (i11 < i8 * 2) {
                                    b = bArr[((i11 / 8) * i6 * 4) + i7 + ((i11 / 2) % 4)];
                                    i12 = i11;
                                    i13 = b & 255;
                                    if (i12 % 2 == 0) {
                                        i14 = b & 15;
                                    } else {
                                        i14 = i13 >> 4;
                                    }
                                    i15 = ((((i14 & 7) * 2) + 1) * i9) >> 3;
                                    if ((i14 & 8) != 0) {
                                        i15 = -i15;
                                    }
                                    iConstrainValue = Util.constrainValue(iConstrainValue + i15, -32768, 32767);
                                    i10 = (i6 * 2) + i10;
                                    bArr2[i10] = (byte) (iConstrainValue & 255);
                                    bArr2[i10 + 1] = (byte) (iConstrainValue >> 8);
                                    iMin = Util.constrainValue(iMin + INDEX_TABLE[i14], 0, 88);
                                    i9 = iArr[iMin];
                                    i11 = i12 + 1;
                                }
                                i5++;
                                i = i211;
                                i3 = i212;
                            }
                        }
                        i3++;
                    }
                    int i213 = i;
                    int i214 = i21 * i213 * 2 * wavFormat.numChannels;
                    parsableByteArray.setPosition(0);
                    parsableByteArray.setLimit(i214);
                    this.pendingInputBytes -= i213 * i22;
                    int i215 = parsableByteArray.limit;
                    this.trackOutput.sampleData(i215, parsableByteArray);
                    i4 = this.pendingOutputBytes + i215;
                    this.pendingOutputBytes = i4;
                    if (i4 / (wavFormat.numChannels * 2) >= i20) {
                        writeSampleMetadata(i20);
                    }
                }
                if (z) {
                    writeSampleMetadata(i2);
                }
                return z;
                this.pendingInputBytes += i17;
            }
        }

        public final void writeSampleMetadata(int i) {
            long j = this.startTimeUs;
            long j2 = this.outputFrameCount;
            WavFormat wavFormat = this.wavFormat;
            long j3 = wavFormat.frameRateHz;
            String str = Util.DEVICE_DEBUG_INFO;
            long jScaleLargeValue = j + Util.scaleLargeValue(j2, 1000000L, j3, RoundingMode.DOWN);
            int i2 = i * 2 * wavFormat.numChannels;
            this.trackOutput.sampleMetadata(jScaleLargeValue, 1, i2, this.pendingOutputBytes - i2, null);
            this.outputFrameCount += (long) i;
            this.pendingOutputBytes -= i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface OutputWriter {
        void init(int i, long j);

        void reset(long j);

        boolean sampleData(ExtractorInput extractorInput, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PassthroughOutputWriter implements OutputWriter {
        public final ExtractorOutput extractorOutput;
        public final Format format;
        public long outputFrameCount;
        public int pendingOutputBytes;
        public long startTimeUs;
        public final int targetSampleSizeBytes;
        public final TrackOutput trackOutput;
        public final WavFormat wavFormat;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput, TrackOutput trackOutput, WavFormat wavFormat, String str, int i) throws ParserException {
            this.extractorOutput = extractorOutput;
            this.trackOutput = trackOutput;
            this.wavFormat = wavFormat;
            int i2 = wavFormat.numChannels;
            int i3 = wavFormat.frameRateHz;
            int i4 = (wavFormat.bitsPerSample * i2) / 8;
            int i5 = wavFormat.blockSize;
            if (i5 != i4) {
                throw ParserException.createForMalformedContainer(null, "Expected block size: " + i4 + "; got: " + i5);
            }
            int i6 = i3 * i4;
            int i7 = i6 * 8;
            int iMax = Math.max(i4, i6 / 10);
            this.targetSampleSizeBytes = iMax;
            Format.Builder builder = new Format.Builder();
            builder.containerMimeType = MimeTypes.normalizeMimeType("audio/wav");
            builder.sampleMimeType = MimeTypes.normalizeMimeType(str);
            builder.averageBitrate = i7;
            builder.peakBitrate = i7;
            builder.maxInputSize = iMax;
            builder.channelCount = i2;
            builder.sampleRate = i3;
            builder.pcmEncoding = i;
            this.format = new Format(builder);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void init(int i, long j) {
            WavSeekMap wavSeekMap = new WavSeekMap(this.wavFormat, 1, i, j);
            this.extractorOutput.seekMap(wavSeekMap);
            Format format = this.format;
            TrackOutput trackOutput = this.trackOutput;
            trackOutput.format(format);
            trackOutput.durationUs(wavSeekMap.durationUs);
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final void reset(long j) {
            this.startTimeUs = j;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0L;
        }

        @Override // androidx.media3.extractor.wav.WavExtractor.OutputWriter
        public final boolean sampleData(ExtractorInput extractorInput, long j) {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.pendingOutputBytes) < (i2 = this.targetSampleSizeBytes)) {
                int iSampleData = this.trackOutput.sampleData((DataReader) extractorInput, (int) Math.min(i2 - i, j2), true);
                if (iSampleData == -1) {
                    j2 = 0;
                } else {
                    this.pendingOutputBytes += iSampleData;
                    j2 -= (long) iSampleData;
                }
            }
            WavFormat wavFormat = this.wavFormat;
            int i3 = wavFormat.blockSize;
            int i4 = this.pendingOutputBytes / i3;
            if (i4 > 0) {
                long j3 = this.startTimeUs;
                long j4 = this.outputFrameCount;
                long j5 = wavFormat.frameRateHz;
                String str = Util.DEVICE_DEBUG_INFO;
                long jScaleLargeValue = j3 + Util.scaleLargeValue(j4, 1000000L, j5, RoundingMode.DOWN);
                int i5 = i4 * i3;
                int i6 = this.pendingOutputBytes - i5;
                this.trackOutput.sampleMetadata(jScaleLargeValue, 1, i5, i6, null);
                this.outputFrameCount += (long) i4;
                this.pendingOutputBytes = i6;
            }
            return j2 <= 0;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        this.trackOutput = extractorOutput.track(0, 1);
        extractorOutput.endTracks();
    }

    /* JADX WARN: Code duplicated, block: B:82:0x021e  */
    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        byte[] bArr;
        int i;
        this.trackOutput.getClass();
        String str = Util.DEVICE_DEBUG_INFO;
        int i2 = this.state;
        int pcmEncoding = 4;
        if (i2 == 0) {
            UtilsKt.checkState(extractorInput.getPosition() == 0);
            int i3 = this.dataStartPosition;
            if (i3 != -1) {
                extractorInput.skipFully(i3);
                this.state = 4;
                return 0;
            }
            if (!WavHeaderReader.checkFileType(extractorInput)) {
                throw ParserException.createForMalformedContainer(null, "Unsupported or unrecognized wav file type.");
            }
            extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
            this.state = 1;
            return 0;
        }
        long littleEndianLong = -1;
        if (i2 == 1) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(8);
            InstantParseResult.Success successPeek = InstantParseResult.Success.peek(extractorInput, parsableByteArray);
            if (successPeek.nanosecondsOfSecond != 1685272116) {
                extractorInput.resetPeekPosition();
            } else {
                extractorInput.advancePeekPosition(8);
                parsableByteArray.setPosition(0);
                extractorInput.peekFully(parsableByteArray.data, 0, 8);
                littleEndianLong = parsableByteArray.readLittleEndianLong();
                extractorInput.skipFully(((int) successPeek.epochSeconds) + 8);
            }
            this.rf64SampleDataSize = littleEndianLong;
            this.state = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return 0;
                }
                UtilsKt.checkState(this.dataEndPosition != -1);
                long position = this.dataEndPosition - extractorInput.getPosition();
                OutputWriter outputWriter = this.outputWriter;
                outputWriter.getClass();
                return outputWriter.sampleData(extractorInput, position) ? -1 : 0;
            }
            extractorInput.resetPeekPosition();
            InstantParseResult.Success successSkipToChunk = WavHeaderReader.skipToChunk(1684108385, extractorInput, new ParsableByteArray(8));
            extractorInput.skipFully(8);
            Pair pairCreate = Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(successSkipToChunk.epochSeconds));
            this.dataStartPosition = ((Long) pairCreate.first).intValue();
            long jLongValue = ((Long) pairCreate.second).longValue();
            long j = this.rf64SampleDataSize;
            if (j != -1 && jLongValue == 4294967295L) {
                jLongValue = j;
            }
            this.dataEndPosition = ((long) this.dataStartPosition) + jLongValue;
            long length = extractorInput.getLength();
            if (length != -1 && this.dataEndPosition > length) {
                Log.w("WavExtractor", "Data exceeds input length: " + this.dataEndPosition + ", " + length);
                this.dataEndPosition = length;
            }
            OutputWriter outputWriter2 = this.outputWriter;
            outputWriter2.getClass();
            outputWriter2.init(this.dataStartPosition, this.dataEndPosition);
            this.state = 4;
            return 0;
        }
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(16);
        long j2 = WavHeaderReader.skipToChunk(1718449184, extractorInput, parsableByteArray2).epochSeconds;
        UtilsKt.checkState(j2 >= 16);
        extractorInput.peekFully(parsableByteArray2.data, 0, 16);
        parsableByteArray2.setPosition(0);
        int littleEndianUnsignedShort = parsableByteArray2.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort2 = parsableByteArray2.readLittleEndianUnsignedShort();
        int littleEndianUnsignedIntToInt = parsableByteArray2.readLittleEndianUnsignedIntToInt();
        parsableByteArray2.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedShort3 = parsableByteArray2.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort4 = parsableByteArray2.readLittleEndianUnsignedShort();
        int i4 = ((int) j2) - 16;
        if (i4 > 0) {
            bArr = new byte[i4];
            extractorInput.peekFully(bArr, 0, i4);
            if (littleEndianUnsignedShort == 65534 && i4 == 24) {
                ParsableByteArray parsableByteArray3 = new ParsableByteArray(bArr);
                parsableByteArray3.readLittleEndianUnsignedShort();
                int littleEndianUnsignedShort5 = parsableByteArray3.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort5 != 0 && littleEndianUnsignedShort5 != littleEndianUnsignedShort4) {
                    throw ParserException.createForUnsupportedContainerFeature("validBits ( " + littleEndianUnsignedShort5 + ")  != bitsPerSample( " + littleEndianUnsignedShort4 + ") are not supported");
                }
                int littleEndianUnsignedIntToInt2 = parsableByteArray3.readLittleEndianUnsignedIntToInt();
                if ((littleEndianUnsignedIntToInt2 >> 18) != 0) {
                    throw ParserException.createForUnsupportedContainerFeature("invalid channel mask " + littleEndianUnsignedIntToInt2);
                }
                if (littleEndianUnsignedIntToInt2 != 0 && Integer.bitCount(littleEndianUnsignedIntToInt2) != littleEndianUnsignedShort2) {
                    throw ParserException.createForUnsupportedContainerFeature("invalid number of channels (" + Integer.bitCount(littleEndianUnsignedIntToInt2) + ") in channel mask " + littleEndianUnsignedIntToInt2);
                }
                littleEndianUnsignedShort = parsableByteArray3.readLittleEndianUnsignedShort();
                byte[] bArr2 = new byte[14];
                parsableByteArray3.readBytes(bArr2, 0, 14);
                if (!Arrays.equals(bArr2, WavHeaderReader.WAVEEXT_SUBFORMAT) && !Arrays.equals(bArr2, WavHeaderReader.AMBISONIC_SUBFORMAT)) {
                    throw ParserException.createForUnsupportedContainerFeature("invalid wav format extension guid");
                }
            }
        } else {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
        WavFormat wavFormat = new WavFormat();
        wavFormat.numChannels = littleEndianUnsignedShort2;
        wavFormat.frameRateHz = littleEndianUnsignedIntToInt;
        wavFormat.blockSize = littleEndianUnsignedShort3;
        wavFormat.bitsPerSample = littleEndianUnsignedShort4;
        wavFormat.extraData = bArr;
        if (littleEndianUnsignedShort == 17) {
            this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, wavFormat);
        } else if (littleEndianUnsignedShort == 6) {
            this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavFormat, "audio/g711-alaw", -1);
        } else if (littleEndianUnsignedShort == 7) {
            this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavFormat, "audio/g711-mlaw", -1);
        } else {
            if (littleEndianUnsignedShort == 1) {
                pcmEncoding = Util.getPcmEncoding(littleEndianUnsignedShort4, ByteOrder.LITTLE_ENDIAN);
                i = pcmEncoding;
            } else {
                if (littleEndianUnsignedShort != 3) {
                    if (littleEndianUnsignedShort == 65534) {
                        pcmEncoding = Util.getPcmEncoding(littleEndianUnsignedShort4, ByteOrder.LITTLE_ENDIAN);
                        i = pcmEncoding;
                    }
                } else if (littleEndianUnsignedShort4 == 32) {
                    i = pcmEncoding;
                }
                i = 0;
            }
            if (i == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + littleEndianUnsignedShort);
            }
            this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, wavFormat, "audio/raw", i);
        }
        this.state = 3;
        return 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void seek(long j, long j2) {
        this.state = j == 0 ? 0 : 4;
        OutputWriter outputWriter = this.outputWriter;
        if (outputWriter != null) {
            outputWriter.reset(j2);
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) {
        return WavHeaderReader.checkFileType(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }
}
