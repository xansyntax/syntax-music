package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.math.IntMath;
import com.metrolist.music.recognition.VibraSignature;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MpeghReader implements ElementaryStreamReader {
    public boolean configFound;
    public boolean dataPending;
    public int flags;
    public String formatId;
    public int frameBytes;
    public TrackOutput output;
    public int payloadBytesRead;
    public int syncBytes;
    public int truncationSamples;
    public byte state = 0;
    public final ParsableByteArray headerScratchBytes = new ParsableByteArray(new byte[15], 2);
    public final VorbisBitArray headerScratchBits = new VorbisBitArray();
    public final ParsableByteArray dataScratchBytes = new ParsableByteArray();
    public final MpeghUtil$MhasPacketHeader header = new MpeghUtil$MhasPacketHeader();
    public int samplingRate = -2147483647;
    public int standardFrameLength = -1;
    public long mainStreamLabel = -1;
    public boolean rapPending = true;
    public boolean headerDataFinished = true;
    public double timeUs = -9.223372036854776E18d;
    public double timeUsPending = -9.223372036854776E18d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:155:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:157:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:159:0x02db  */
    /* JADX WARN: Code duplicated, block: B:162:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:189:0x03b8  */
    /* JADX WARN: Instruction removed from duplicated block: B:155:0x02c0, please report this as an issue */
    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        byte b;
        int bits;
        int bits2;
        int i2;
        char c;
        byte[] bArr;
        long j;
        long j2;
        RegularImmutableList regularImmutableListOf;
        int bits3;
        long j3;
        boolean z;
        int i3;
        this.output.getClass();
        while (parsableByteArray.bytesLeft() > 0) {
            byte b2 = this.state;
            int i4 = 8;
            int i5 = 3;
            int i6 = 1;
            if (b2 != 0) {
                ParsableByteArray parsableByteArray2 = this.dataScratchBytes;
                MpeghUtil$MhasPacketHeader mpeghUtil$MhasPacketHeader = this.header;
                if (b2 == 1) {
                    int iBytesLeft = parsableByteArray.bytesLeft();
                    ParsableByteArray parsableByteArray3 = this.headerScratchBytes;
                    int iMin = Math.min(iBytesLeft, parsableByteArray3.bytesLeft());
                    parsableByteArray.readBytes(parsableByteArray3.data, parsableByteArray3.position, iMin);
                    parsableByteArray3.skipBytes(iMin);
                    if (parsableByteArray3.bytesLeft() == 0) {
                        int i7 = parsableByteArray3.limit;
                        byte[] bArr2 = parsableByteArray3.data;
                        VorbisBitArray vorbisBitArray = this.headerScratchBits;
                        vorbisBitArray.reset(bArr2, i7);
                        vorbisBitArray.getBytePosition();
                        int escapedIntValue = IntMath.readEscapedIntValue(vorbisBitArray, 3, 8, 8);
                        mpeghUtil$MhasPacketHeader.packetType = escapedIntValue;
                        if (escapedIntValue != -1) {
                            UtilsKt.checkArgument(Math.max(Math.max(2, 8), 32) <= 63);
                            Math.addExact(Math.addExact(3L, 255L), 4294967296L);
                            if (vorbisBitArray.bitsLeft() < 2) {
                                j3 = -1;
                            } else {
                                long bitsToLong = vorbisBitArray.readBitsToLong(2);
                                if (bitsToLong == 3) {
                                    if (vorbisBitArray.bitsLeft() >= 8) {
                                        long bitsToLong2 = vorbisBitArray.readBitsToLong(8);
                                        bitsToLong += bitsToLong2;
                                        if (bitsToLong2 == 255) {
                                            if (vorbisBitArray.bitsLeft() >= 32) {
                                                bitsToLong = vorbisBitArray.readBitsToLong(32) + bitsToLong;
                                            }
                                        }
                                    }
                                    j3 = -1;
                                }
                                j3 = bitsToLong;
                            }
                            mpeghUtil$MhasPacketHeader.packetLabel = j3;
                            if (j3 == -1) {
                                z = false;
                            } else {
                                if (j3 > 16) {
                                    throw ParserException.createForUnsupportedContainerFeature("Contains sub-stream with an invalid packet label " + mpeghUtil$MhasPacketHeader.packetLabel);
                                }
                                if (j3 == 0) {
                                    int i8 = mpeghUtil$MhasPacketHeader.packetType;
                                    if (i8 == 1) {
                                        throw ParserException.createForMalformedContainer(null, "Mpegh3daConfig packet with invalid packet label 0");
                                    }
                                    if (i8 == 2) {
                                        throw ParserException.createForMalformedContainer(null, "Mpegh3daFrame packet with invalid packet label 0");
                                    }
                                    if (i8 == 17) {
                                        throw ParserException.createForMalformedContainer(null, "AudioTruncation packet with invalid packet label 0");
                                    }
                                }
                                int escapedIntValue2 = IntMath.readEscapedIntValue(vorbisBitArray, 11, 24, 24);
                                mpeghUtil$MhasPacketHeader.packetLength = escapedIntValue2;
                                if (escapedIntValue2 != -1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            i3 = 0;
                            this.payloadBytesRead = 0;
                            this.frameBytes = mpeghUtil$MhasPacketHeader.packetLength + i7 + this.frameBytes;
                        } else {
                            i3 = 0;
                        }
                        if (z) {
                            parsableByteArray3.setPosition(i3);
                            this.output.sampleData(parsableByteArray3.limit, parsableByteArray3);
                            parsableByteArray3.reset(2);
                            parsableByteArray2.reset(mpeghUtil$MhasPacketHeader.packetLength);
                            this.headerDataFinished = true;
                            this.state = (byte) 2;
                        } else {
                            int i9 = parsableByteArray3.limit;
                            if (i9 < 15) {
                                parsableByteArray3.setLimit(i9 + 1);
                                this.headerDataFinished = false;
                            }
                        }
                    } else {
                        this.headerDataFinished = false;
                    }
                } else {
                    if (b2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m();
                        return;
                    }
                    int i10 = mpeghUtil$MhasPacketHeader.packetType;
                    if (i10 == 1 || i10 == 17) {
                        int i11 = parsableByteArray.position;
                        int iMin2 = Math.min(parsableByteArray.bytesLeft(), parsableByteArray2.bytesLeft());
                        parsableByteArray.readBytes(parsableByteArray2.data, parsableByteArray2.position, iMin2);
                        parsableByteArray2.skipBytes(iMin2);
                        parsableByteArray.setPosition(i11);
                    }
                    int iMin3 = Math.min(parsableByteArray.bytesLeft(), mpeghUtil$MhasPacketHeader.packetLength - this.payloadBytesRead);
                    this.output.sampleData(iMin3, parsableByteArray);
                    int i12 = this.payloadBytesRead + iMin3;
                    this.payloadBytesRead = i12;
                    if (i12 != mpeghUtil$MhasPacketHeader.packetLength) {
                        continue;
                    } else {
                        int i13 = mpeghUtil$MhasPacketHeader.packetType;
                        if (i13 == 1) {
                            byte[] bArr3 = parsableByteArray2.data;
                            VorbisBitArray vorbisBitArray2 = new VorbisBitArray(bArr3, bArr3.length);
                            int bits4 = vorbisBitArray2.readBits(8);
                            int bits5 = vorbisBitArray2.readBits(5);
                            if (bits5 != 31) {
                                switch (bits5) {
                                    case 0:
                                        bits2 = 96000;
                                        break;
                                    case 1:
                                        bits2 = 88200;
                                        break;
                                    case 2:
                                        bits2 = 64000;
                                        break;
                                    case 3:
                                        bits2 = 48000;
                                        break;
                                    case 4:
                                        bits2 = 44100;
                                        break;
                                    case 5:
                                        bits2 = 32000;
                                        break;
                                    case 6:
                                        bits2 = 24000;
                                        break;
                                    case 7:
                                        bits2 = 22050;
                                        break;
                                    case 8:
                                        bits2 = VibraSignature.REQUIRED_SAMPLE_RATE;
                                        break;
                                    case 9:
                                        bits2 = 12000;
                                        break;
                                    case 10:
                                        bits2 = 11025;
                                        break;
                                    case 11:
                                        bits2 = 8000;
                                        break;
                                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                                        bits2 = 7350;
                                        break;
                                    case 13:
                                    case 14:
                                    default:
                                        throw ParserException.createForUnsupportedContainerFeature("Unsupported sampling rate index " + bits5);
                                    case 15:
                                        bits2 = 57600;
                                        break;
                                    case 16:
                                        bits2 = 51200;
                                        break;
                                    case 17:
                                        bits2 = 40000;
                                        break;
                                    case 18:
                                        bits2 = 38400;
                                        break;
                                    case 19:
                                        bits2 = 34150;
                                        break;
                                    case 20:
                                        bits2 = 28800;
                                        break;
                                    case 21:
                                        bits2 = 25600;
                                        break;
                                    case 22:
                                        bits2 = 20000;
                                        break;
                                    case 23:
                                        bits2 = 19200;
                                        break;
                                    case 24:
                                        bits2 = 17075;
                                        break;
                                    case 25:
                                        bits2 = 14400;
                                        break;
                                    case 26:
                                        bits2 = 12800;
                                        break;
                                    case 27:
                                        bits2 = 9600;
                                        break;
                                }
                            } else {
                                bits2 = vorbisBitArray2.readBits(24);
                            }
                            int bits6 = vorbisBitArray2.readBits(3);
                            if (bits6 == 0) {
                                i2 = 768;
                            } else if (bits6 == 1) {
                                i2 = 1024;
                            } else if (bits6 == 2 || bits6 == 3) {
                                i2 = 2048;
                            } else {
                                if (bits6 != 4) {
                                    throw ParserException.createForUnsupportedContainerFeature("Unsupported coreSbrFrameLengthIndex " + bits6);
                                }
                                i2 = 4096;
                            }
                            int i14 = i2;
                            if (bits6 == 0 || bits6 == 1) {
                                c = 0;
                            } else if (bits6 == 2) {
                                c = 2;
                            } else if (bits6 == 3) {
                                c = 3;
                            } else {
                                if (bits6 != 4) {
                                    throw ParserException.createForUnsupportedContainerFeature("Unsupported coreSbrFrameLengthIndex " + bits6);
                                }
                                c = 1;
                            }
                            vorbisBitArray2.skipBits(2);
                            IntMath.skipSpeakerConfig3d(vorbisBitArray2);
                            int bits7 = vorbisBitArray2.readBits(5);
                            int i15 = 0;
                            int escapedIntValue3 = 0;
                            while (true) {
                                int i16 = i6;
                                int i17 = 16;
                                if (i15 < bits7 + 1) {
                                    int bits8 = vorbisBitArray2.readBits(3);
                                    escapedIntValue3 = IntMath.readEscapedIntValue(vorbisBitArray2, 5, 8, 16) + 1 + escapedIntValue3;
                                    if ((bits8 == 0 || bits8 == 2) && vorbisBitArray2.readBit()) {
                                        IntMath.skipSpeakerConfig3d(vorbisBitArray2);
                                    }
                                    i15++;
                                    i6 = i16;
                                } else {
                                    int escapedIntValue4 = IntMath.readEscapedIntValue(vorbisBitArray2, 4, 8, 16) + 1;
                                    vorbisBitArray2.skipBit();
                                    int i18 = 0;
                                    while (true) {
                                        double d = 2.0d;
                                        if (i18 < escapedIntValue4) {
                                            int bits9 = vorbisBitArray2.readBits(2);
                                            if (bits9 == 0) {
                                                vorbisBitArray2.skipBits(i5);
                                                if (vorbisBitArray2.readBit()) {
                                                    vorbisBitArray2.skipBits(13);
                                                }
                                                if (c > 0) {
                                                    IntMath.skipSbrConfig(vorbisBitArray2);
                                                }
                                            } else if (bits9 == i16) {
                                                vorbisBitArray2.skipBits(i5);
                                                boolean bit = vorbisBitArray2.readBit();
                                                if (bit) {
                                                    vorbisBitArray2.skipBits(13);
                                                }
                                                if (bit) {
                                                    vorbisBitArray2.skipBit();
                                                }
                                                if (c > 0) {
                                                    IntMath.skipSbrConfig(vorbisBitArray2);
                                                    bits3 = vorbisBitArray2.readBits(2);
                                                } else {
                                                    bits3 = 0;
                                                }
                                                if (bits3 > 0) {
                                                    vorbisBitArray2.skipBits(6);
                                                    int bits10 = vorbisBitArray2.readBits(2);
                                                    vorbisBitArray2.skipBits(4);
                                                    if (vorbisBitArray2.readBit()) {
                                                        vorbisBitArray2.skipBits(5);
                                                    }
                                                    if (bits3 == 2 || bits3 == i5) {
                                                        vorbisBitArray2.skipBits(6);
                                                    }
                                                    if (bits10 == 2) {
                                                        vorbisBitArray2.skipBit();
                                                    }
                                                }
                                                int iFloor = ((int) Math.floor(Math.log(escapedIntValue3 - 1) / Math.log(2.0d))) + 1;
                                                int bits11 = vorbisBitArray2.readBits(2);
                                                if (bits11 > 0 && vorbisBitArray2.readBit()) {
                                                    vorbisBitArray2.skipBits(iFloor);
                                                }
                                                if (vorbisBitArray2.readBit()) {
                                                    vorbisBitArray2.skipBits(iFloor);
                                                }
                                                if (c == 0 && bits11 == 0) {
                                                    vorbisBitArray2.skipBit();
                                                }
                                            } else if (bits9 == i5) {
                                                IntMath.readEscapedIntValue(vorbisBitArray2, 4, i4, i17);
                                                int escapedIntValue5 = IntMath.readEscapedIntValue(vorbisBitArray2, 4, i4, i17);
                                                if (vorbisBitArray2.readBit()) {
                                                    IntMath.readEscapedIntValue(vorbisBitArray2, i4, i17, 0);
                                                }
                                                vorbisBitArray2.skipBit();
                                                if (escapedIntValue5 > 0) {
                                                    vorbisBitArray2.skipBits(escapedIntValue5 * 8);
                                                }
                                            }
                                            i18++;
                                            i4 = 8;
                                            i5 = 3;
                                            i17 = 16;
                                            i16 = 1;
                                        } else {
                                            if (vorbisBitArray2.readBit()) {
                                                int i19 = 8;
                                                int escapedIntValue6 = IntMath.readEscapedIntValue(vorbisBitArray2, 2, 4, 8) + 1;
                                                int i20 = 0;
                                                bArr = null;
                                                while (i20 < escapedIntValue6) {
                                                    int escapedIntValue7 = IntMath.readEscapedIntValue(vorbisBitArray2, 4, i19, 16);
                                                    int escapedIntValue8 = IntMath.readEscapedIntValue(vorbisBitArray2, 4, i19, 16);
                                                    if (escapedIntValue7 == 7) {
                                                        int bits12 = vorbisBitArray2.readBits(4) + 1;
                                                        vorbisBitArray2.skipBits(4);
                                                        byte[] bArr4 = new byte[bits12];
                                                        for (int i21 = 0; i21 < bits12; i21++) {
                                                            bArr4[i21] = (byte) vorbisBitArray2.readBits(i19);
                                                        }
                                                        bArr = bArr4;
                                                    } else {
                                                        vorbisBitArray2.skipBits(escapedIntValue8 * i19);
                                                    }
                                                    i20++;
                                                    i19 = 8;
                                                }
                                            } else {
                                                bArr = null;
                                            }
                                            switch (bits2) {
                                                case 14700:
                                                case VibraSignature.REQUIRED_SAMPLE_RATE /* 16000 */:
                                                    d = 3.0d;
                                                    this.samplingRate = (int) (((double) bits2) * d);
                                                    this.standardFrameLength = (int) (((double) i14) * d);
                                                    j = this.mainStreamLabel;
                                                    j2 = mpeghUtil$MhasPacketHeader.packetLabel;
                                                    if (j != j2) {
                                                        this.mainStreamLabel = j2;
                                                        String strConcat = bits4 != -1 ? "mhm1".concat(String.format(".%02X", Integer.valueOf(bits4))) : "mhm1";
                                                        if (bArr != null || bArr.length <= 0) {
                                                            regularImmutableListOf = null;
                                                        } else {
                                                            regularImmutableListOf = ImmutableList.of((Object) Util.EMPTY_BYTE_ARRAY, (Object) bArr);
                                                        }
                                                        Format.Builder builder = new Format.Builder();
                                                        builder.id = this.formatId;
                                                        builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                                        builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/mhm1");
                                                        builder.sampleRate = this.samplingRate;
                                                        builder.codecs = strConcat;
                                                        builder.initializationData = regularImmutableListOf;
                                                        this.output.format(new Format(builder));
                                                    }
                                                    b = 1;
                                                    this.configFound = true;
                                                    break;
                                                case 22050:
                                                case 24000:
                                                    this.samplingRate = (int) (((double) bits2) * d);
                                                    this.standardFrameLength = (int) (((double) i14) * d);
                                                    j = this.mainStreamLabel;
                                                    j2 = mpeghUtil$MhasPacketHeader.packetLabel;
                                                    if (j != j2) {
                                                        this.mainStreamLabel = j2;
                                                        if (bits4 != -1) {
                                                        }
                                                        if (bArr != null) {
                                                            regularImmutableListOf = null;
                                                        } else {
                                                            regularImmutableListOf = null;
                                                        }
                                                        Format.Builder builder2 = new Format.Builder();
                                                        builder2.id = this.formatId;
                                                        builder2.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                                        builder2.sampleMimeType = MimeTypes.normalizeMimeType("audio/mhm1");
                                                        builder2.sampleRate = this.samplingRate;
                                                        builder2.codecs = strConcat;
                                                        builder2.initializationData = regularImmutableListOf;
                                                        this.output.format(new Format(builder2));
                                                    }
                                                    b = 1;
                                                    this.configFound = true;
                                                    break;
                                                case 29400:
                                                case 32000:
                                                case 58800:
                                                case 64000:
                                                    d = 1.5d;
                                                    this.samplingRate = (int) (((double) bits2) * d);
                                                    this.standardFrameLength = (int) (((double) i14) * d);
                                                    j = this.mainStreamLabel;
                                                    j2 = mpeghUtil$MhasPacketHeader.packetLabel;
                                                    if (j != j2) {
                                                        this.mainStreamLabel = j2;
                                                        if (bits4 != -1) {
                                                        }
                                                        if (bArr != null) {
                                                            regularImmutableListOf = null;
                                                        } else {
                                                            regularImmutableListOf = null;
                                                        }
                                                        Format.Builder builder3 = new Format.Builder();
                                                        builder3.id = this.formatId;
                                                        builder3.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                                        builder3.sampleMimeType = MimeTypes.normalizeMimeType("audio/mhm1");
                                                        builder3.sampleRate = this.samplingRate;
                                                        builder3.codecs = strConcat;
                                                        builder3.initializationData = regularImmutableListOf;
                                                        this.output.format(new Format(builder3));
                                                    }
                                                    b = 1;
                                                    this.configFound = true;
                                                    break;
                                                case 44100:
                                                case 48000:
                                                case 88200:
                                                case 96000:
                                                    d = 1.0d;
                                                    this.samplingRate = (int) (((double) bits2) * d);
                                                    this.standardFrameLength = (int) (((double) i14) * d);
                                                    j = this.mainStreamLabel;
                                                    j2 = mpeghUtil$MhasPacketHeader.packetLabel;
                                                    if (j != j2) {
                                                        this.mainStreamLabel = j2;
                                                        if (bits4 != -1) {
                                                        }
                                                        if (bArr != null) {
                                                            regularImmutableListOf = null;
                                                        } else {
                                                            regularImmutableListOf = null;
                                                        }
                                                        Format.Builder builder4 = new Format.Builder();
                                                        builder4.id = this.formatId;
                                                        builder4.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                                                        builder4.sampleMimeType = MimeTypes.normalizeMimeType("audio/mhm1");
                                                        builder4.sampleRate = this.samplingRate;
                                                        builder4.codecs = strConcat;
                                                        builder4.initializationData = regularImmutableListOf;
                                                        this.output.format(new Format(builder4));
                                                    }
                                                    b = 1;
                                                    this.configFound = true;
                                                    break;
                                                default:
                                                    throw ParserException.createForUnsupportedContainerFeature("Unsupported sampling rate " + bits2);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            if (i13 == 17) {
                                byte[] bArr5 = parsableByteArray2.data;
                                VorbisBitArray vorbisBitArray3 = new VorbisBitArray(bArr5, bArr5.length);
                                if (vorbisBitArray3.readBit()) {
                                    vorbisBitArray3.skipBits(2);
                                    bits = vorbisBitArray3.readBits(13);
                                } else {
                                    bits = 0;
                                }
                                this.truncationSamples = bits;
                            } else if (i13 == 2) {
                                if (this.configFound) {
                                    this.rapPending = false;
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                double d2 = (((double) (this.standardFrameLength - this.truncationSamples)) * 1000000.0d) / ((double) this.samplingRate);
                                long jRound = Math.round(this.timeUs);
                                if (this.dataPending) {
                                    this.dataPending = false;
                                    this.timeUs = this.timeUsPending;
                                } else {
                                    this.timeUs += d2;
                                }
                                this.output.sampleMetadata(jRound, i, this.frameBytes, 0, null);
                                this.configFound = false;
                                this.truncationSamples = 0;
                                this.frameBytes = 0;
                            }
                            b = 1;
                        }
                        this.state = b;
                    }
                }
            } else {
                int i22 = this.flags;
                if ((i22 & 2) == 0) {
                    parsableByteArray.setPosition(parsableByteArray.limit);
                } else {
                    if ((i22 & 4) == 0) {
                        while (true) {
                            if (parsableByteArray.bytesLeft() > 0) {
                                int i23 = this.syncBytes << 8;
                                this.syncBytes = i23;
                                int unsignedByte = i23 | parsableByteArray.readUnsignedByte();
                                this.syncBytes = unsignedByte;
                                if ((unsignedByte & 16777215) == 12583333) {
                                    parsableByteArray.setPosition(parsableByteArray.position - 3);
                                    this.syncBytes = 0;
                                }
                            }
                        }
                    }
                    this.state = (byte) 1;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        trackIdGenerator.maybeThrowUninitializedError();
        this.formatId = trackIdGenerator.formatId;
        trackIdGenerator.maybeThrowUninitializedError();
        this.output = extractorOutput.track(trackIdGenerator.trackId, 1);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetStarted(int i, long j) {
        this.flags = i;
        if (!this.rapPending && (this.frameBytes != 0 || !this.headerDataFinished)) {
            this.dataPending = true;
        }
        if (j != -9223372036854775807L) {
            if (this.dataPending) {
                this.timeUsPending = j;
            } else {
                this.timeUs = j;
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.state = (byte) 0;
        this.syncBytes = 0;
        this.headerScratchBytes.reset(2);
        this.payloadBytesRead = 0;
        this.frameBytes = 0;
        this.samplingRate = -2147483647;
        this.standardFrameLength = -1;
        this.truncationSamples = 0;
        this.mainStreamLabel = -1L;
        this.configFound = false;
        this.dataPending = false;
        this.headerDataFinished = true;
        this.rapPending = true;
        this.timeUs = -9.223372036854776E18d;
        this.timeUsPending = -9.223372036854776E18d;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
    }
}
