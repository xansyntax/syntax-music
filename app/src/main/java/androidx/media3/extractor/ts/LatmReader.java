package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.navigation.NavOptions;
import coil3.util.UtilsKt;
import java.util.Collections;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LatmReader implements ElementaryStreamReader {
    public int audioMuxVersionA;
    public int bytesRead;
    public int channelCount;
    public String codecs;
    public Format format;
    public String formatId;
    public int frameLengthType;
    public final String language;
    public int numSubframes;
    public long otherDataLenBits;
    public boolean otherDataPresent;
    public TrackOutput output;
    public final int roleFlags;
    public final VorbisBitArray sampleBitArray;
    public final ParsableByteArray sampleDataBuffer;
    public long sampleDurationUs;
    public int sampleRateHz;
    public int sampleSize;
    public short secondHeaderByte;
    public byte state;
    public boolean streamMuxRead;
    public long timeUs;

    public LatmReader(String str, int i) {
        this.language = str;
        this.roleFlags = i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.sampleDataBuffer = parsableByteArray;
        byte[] bArr = parsableByteArray.data;
        this.sampleBitArray = new VorbisBitArray(bArr, bArr.length);
        this.timeUs = -9223372036854775807L;
    }

    /* JADX WARN: Type inference failed for: r1v31, types: [int, short] */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        int bits;
        boolean bit;
        this.output.getClass();
        while (parsableByteArray.bytesLeft() > 0) {
            byte b = this.state;
            if (b != 0) {
                if (b != 1) {
                    ParsableByteArray parsableByteArray2 = this.sampleDataBuffer;
                    VorbisBitArray vorbisBitArray = this.sampleBitArray;
                    if (b == 2) {
                        int unsignedByte = ((this.secondHeaderByte & (-225)) << 8) | parsableByteArray.readUnsignedByte();
                        this.sampleSize = unsignedByte;
                        if (unsignedByte > parsableByteArray2.data.length) {
                            parsableByteArray2.reset(unsignedByte);
                            byte[] bArr = parsableByteArray2.data;
                            vorbisBitArray.reset(bArr, bArr.length);
                        }
                        this.bytesRead = 0;
                        this.state = (byte) 3;
                    } else {
                        if (b != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                            return;
                        }
                        int iMin = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                        parsableByteArray.readBytes(vorbisBitArray.data, this.bytesRead, iMin);
                        int i = this.bytesRead + iMin;
                        this.bytesRead = i;
                        if (i == this.sampleSize) {
                            vorbisBitArray.setPosition(0);
                            if (vorbisBitArray.readBit()) {
                                if (this.streamMuxRead) {
                                }
                                this.state = (byte) 0;
                            } else {
                                this.streamMuxRead = true;
                                int bits2 = vorbisBitArray.readBits(1);
                                int bits3 = bits2 == 1 ? vorbisBitArray.readBits(1) : 0;
                                this.audioMuxVersionA = bits3;
                                if (bits3 != 0) {
                                    throw ParserException.createForMalformedContainer(null, null);
                                }
                                if (bits2 == 1) {
                                    vorbisBitArray.readBits((vorbisBitArray.readBits(2) + 1) * 8);
                                }
                                if (!vorbisBitArray.readBit()) {
                                    throw ParserException.createForMalformedContainer(null, null);
                                }
                                this.numSubframes = vorbisBitArray.readBits(6);
                                int bits4 = vorbisBitArray.readBits(4);
                                int bits5 = vorbisBitArray.readBits(3);
                                if (bits4 != 0 || bits5 != 0) {
                                    throw ParserException.createForMalformedContainer(null, null);
                                }
                                if (bits2 == 0) {
                                    int position = vorbisBitArray.getPosition();
                                    int iBitsLeft = vorbisBitArray.bitsLeft();
                                    NavOptions.Builder audioSpecificConfig = AacUtil.parseAudioSpecificConfig(vorbisBitArray, true);
                                    this.codecs = audioSpecificConfig.popUpToRoute;
                                    this.sampleRateHz = audioSpecificConfig.enterAnim;
                                    this.channelCount = audioSpecificConfig.exitAnim;
                                    int iBitsLeft2 = iBitsLeft - vorbisBitArray.bitsLeft();
                                    vorbisBitArray.setPosition(position);
                                    byte[] bArr2 = new byte[(iBitsLeft2 + 7) / 8];
                                    vorbisBitArray.readBits(bArr2, iBitsLeft2);
                                    Format.Builder builder = new Format.Builder();
                                    builder.id = this.formatId;
                                    builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                    builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/mp4a-latm");
                                    builder.codecs = this.codecs;
                                    builder.channelCount = this.channelCount;
                                    builder.sampleRate = this.sampleRateHz;
                                    builder.initializationData = Collections.singletonList(bArr2);
                                    builder.language = this.language;
                                    builder.roleFlags = this.roleFlags;
                                    Format format = new Format(builder);
                                    if (!format.equals(this.format)) {
                                        this.format = format;
                                        this.sampleDurationUs = 1024000000 / ((long) format.sampleRate);
                                        this.output.format(format);
                                    }
                                } else {
                                    int bits6 = vorbisBitArray.readBits((vorbisBitArray.readBits(2) + 1) * 8);
                                    int iBitsLeft3 = vorbisBitArray.bitsLeft();
                                    NavOptions.Builder audioSpecificConfig2 = AacUtil.parseAudioSpecificConfig(vorbisBitArray, true);
                                    this.codecs = audioSpecificConfig2.popUpToRoute;
                                    this.sampleRateHz = audioSpecificConfig2.enterAnim;
                                    this.channelCount = audioSpecificConfig2.exitAnim;
                                    vorbisBitArray.skipBits(bits6 - (iBitsLeft3 - vorbisBitArray.bitsLeft()));
                                }
                                int bits7 = vorbisBitArray.readBits(3);
                                this.frameLengthType = bits7;
                                if (bits7 == 0) {
                                    vorbisBitArray.skipBits(8);
                                } else if (bits7 == 1) {
                                    vorbisBitArray.skipBits(9);
                                } else if (bits7 == 3 || bits7 == 4 || bits7 == 5) {
                                    vorbisBitArray.skipBits(6);
                                } else {
                                    if (bits7 != 6 && bits7 != 7) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                        return;
                                    }
                                    vorbisBitArray.skipBits(1);
                                }
                                boolean bit2 = vorbisBitArray.readBit();
                                this.otherDataPresent = bit2;
                                this.otherDataLenBits = 0L;
                                if (bit2) {
                                    if (bits2 == 1) {
                                        this.otherDataLenBits = vorbisBitArray.readBits((vorbisBitArray.readBits(2) + 1) * 8);
                                    } else {
                                        do {
                                            bit = vorbisBitArray.readBit();
                                            this.otherDataLenBits = (this.otherDataLenBits << 8) + ((long) vorbisBitArray.readBits(8));
                                        } while (bit);
                                    }
                                }
                                if (vorbisBitArray.readBit()) {
                                    vorbisBitArray.skipBits(8);
                                }
                            }
                            if (this.audioMuxVersionA != 0) {
                                throw ParserException.createForMalformedContainer(null, null);
                            }
                            if (this.numSubframes != 0) {
                                throw ParserException.createForMalformedContainer(null, null);
                            }
                            if (this.frameLengthType != 0) {
                                throw ParserException.createForMalformedContainer(null, null);
                            }
                            int i2 = 0;
                            do {
                                bits = vorbisBitArray.readBits(8);
                                i2 += bits;
                            } while (bits == 255);
                            int position2 = vorbisBitArray.getPosition();
                            if ((position2 & 7) == 0) {
                                parsableByteArray2.setPosition(position2 >> 3);
                            } else {
                                vorbisBitArray.readBits(parsableByteArray2.data, i2 * 8);
                                parsableByteArray2.setPosition(0);
                            }
                            this.output.sampleData(i2, parsableByteArray2);
                            UtilsKt.checkState(this.timeUs != -9223372036854775807L);
                            this.output.sampleMetadata(this.timeUs, 1, i2, 0, null);
                            this.timeUs += this.sampleDurationUs;
                            if (this.otherDataPresent) {
                                vorbisBitArray.skipBits((int) this.otherDataLenBits);
                            }
                            this.state = (byte) 0;
                        } else {
                            continue;
                        }
                    }
                } else {
                    ?? unsignedByte2 = parsableByteArray.readUnsignedByte();
                    if ((unsignedByte2 & 224) == 224) {
                        this.secondHeaderByte = unsignedByte2;
                        this.state = (byte) 2;
                    } else if (unsignedByte2 != 86) {
                        this.state = (byte) 0;
                    }
                }
            } else if (parsableByteArray.readUnsignedByte() == 86) {
                this.state = (byte) 1;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        this.output = extractorOutput.track(trackIdGenerator.trackId, 1);
        trackIdGenerator.maybeThrowUninitializedError();
        this.formatId = trackIdGenerator.formatId;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.timeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.state = (byte) 0;
        this.timeUs = -9223372036854775807L;
        this.streamMuxRead = false;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
    }
}
