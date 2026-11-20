package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.VorbisBitArray;
import androidx.navigation.NavOptions;
import coil3.util.UtilsKt;
import io.ktor.client.utils.CIOKt;
import io.ktor.network.sockets.DatagramKt;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DtsReader implements ElementaryStreamReader {
    public int bytesRead;
    public Format format;
    public String formatId;
    public int frameType;
    public final ParsableByteArray headerScratchBytes;
    public final String language;
    public TrackOutput output;
    public final int roleFlags;
    public long sampleDurationUs;
    public int sampleSize;
    public int syncBytes;
    public byte state = 0;
    public long timeUs = -9223372036854775807L;
    public final AtomicInteger uhdAudioChunkId = new AtomicInteger();
    public int extensionSubstreamHeaderSize = -1;
    public int uhdHeaderSize = -1;

    public DtsReader(String str, int i, int i2) {
        this.headerScratchBytes = new ParsableByteArray(new byte[i2]);
        this.language = str;
        this.roleFlags = i;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void consume(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3;
        int i4;
        int bits;
        int bits2;
        int bits3;
        int i5;
        long jScaleLargeValue;
        int i6;
        long j;
        int i7;
        int i8;
        int i9;
        this.output.getClass();
        while (parsableByteArray.bytesLeft() > 0) {
            byte b3 = this.state;
            ParsableByteArray parsableByteArray2 = this.headerScratchBytes;
            switch (b3) {
                case 0:
                    while (parsableByteArray.bytesLeft() > 0) {
                        int i10 = this.syncBytes << 8;
                        this.syncBytes = i10;
                        int unsignedByte = i10 | parsableByteArray.readUnsignedByte();
                        this.syncBytes = unsignedByte;
                        int frameType = AacUtil.getFrameType(unsignedByte);
                        this.frameType = frameType;
                        if (frameType != 0) {
                            byte[] bArr = parsableByteArray2.data;
                            int i11 = this.syncBytes;
                            bArr[0] = (byte) ((i11 >> 24) & 255);
                            bArr[1] = (byte) ((i11 >> 16) & 255);
                            bArr[2] = (byte) ((i11 >> 8) & 255);
                            bArr[3] = (byte) (i11 & 255);
                            this.bytesRead = 4;
                            this.syncBytes = 0;
                            if (frameType != 3 && frameType != 4) {
                                if (frameType == 1) {
                                    this.state = (byte) 1;
                                } else {
                                    this.state = (byte) 2;
                                }
                            }
                            this.state = (byte) 4;
                        }
                        break;
                    }
                    break;
                case 1:
                    if (continueRead$3(parsableByteArray, parsableByteArray2.data, 18)) {
                        byte[] bArr2 = parsableByteArray2.data;
                        if (this.format == null) {
                            String str = this.formatId;
                            VorbisBitArray normalizedFrame = AacUtil.getNormalizedFrame(bArr2);
                            normalizedFrame.skipBits(60);
                            int i12 = AacUtil.CHANNELS_BY_AMODE[normalizedFrame.readBits(6)];
                            int i13 = AacUtil.SAMPLE_RATE_BY_SFREQ[normalizedFrame.readBits(4)];
                            int bits4 = normalizedFrame.readBits(5);
                            int i14 = bits4 >= 29 ? -1 : (AacUtil.TWICE_BITRATE_KBPS_BY_RATE[bits4] * CIOKt.DEFAULT_HTTP_POOL_SIZE) / 2;
                            normalizedFrame.skipBits(10);
                            int i15 = i12 + (normalizedFrame.readBits(2) > 0 ? 1 : 0);
                            Format.Builder builder = new Format.Builder();
                            builder.id = str;
                            builder.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
                            builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/vnd.dts");
                            builder.averageBitrate = i14;
                            builder.channelCount = i15;
                            builder.sampleRate = i13;
                            builder.drmInitData = null;
                            builder.language = this.language;
                            builder.roleFlags = this.roleFlags;
                            Format format = new Format(builder);
                            this.format = format;
                            this.output.format(format);
                        }
                        this.sampleSize = AacUtil.getDtsFrameSize(bArr2);
                        byte b4 = bArr2[0];
                        if (b4 != -2) {
                            if (b4 == -1) {
                                i = (bArr2[4] & 7) << 4;
                                b2 = bArr2[7];
                            } else if (b4 != 31) {
                                i = (bArr2[4] & 1) << 6;
                                b = bArr2[5];
                            } else {
                                i = (bArr2[5] & 7) << 4;
                                b2 = bArr2[6];
                            }
                            i2 = b2 & 60;
                            this.sampleDurationUs = StringsKt__IndentKt.checkedCast(Util.sampleCountToDurationUs(this.format.sampleRate, (((i2 >> 2) | i) + 1) * 32));
                            parsableByteArray2.setPosition(0);
                            this.output.sampleData(18, parsableByteArray2);
                            this.state = (byte) 6;
                        } else {
                            i = (bArr2[5] & 1) << 6;
                            b = bArr2[4];
                        }
                        i2 = b & 252;
                        this.sampleDurationUs = StringsKt__IndentKt.checkedCast(Util.sampleCountToDurationUs(this.format.sampleRate, (((i2 >> 2) | i) + 1) * 32));
                        parsableByteArray2.setPosition(0);
                        this.output.sampleData(18, parsableByteArray2);
                        this.state = (byte) 6;
                        break;
                    }
                    break;
                case 2:
                    if (continueRead$3(parsableByteArray, parsableByteArray2.data, 7)) {
                        VorbisBitArray normalizedFrame2 = AacUtil.getNormalizedFrame(parsableByteArray2.data);
                        normalizedFrame2.skipBits(42);
                        this.extensionSubstreamHeaderSize = normalizedFrame2.readBits(normalizedFrame2.readBit() ? 12 : 8) + 1;
                        this.state = (byte) 3;
                    }
                    break;
                case 3:
                    int i16 = 8;
                    if (continueRead$3(parsableByteArray, parsableByteArray2.data, this.extensionSubstreamHeaderSize)) {
                        VorbisBitArray normalizedFrame3 = AacUtil.getNormalizedFrame(parsableByteArray2.data);
                        normalizedFrame3.skipBits(40);
                        int bits5 = normalizedFrame3.readBits(2);
                        if (normalizedFrame3.readBit()) {
                            i3 = 20;
                            i4 = 12;
                        } else {
                            i3 = 16;
                            i4 = 8;
                        }
                        normalizedFrame3.skipBits(i4);
                        int bits6 = normalizedFrame3.readBits(i3) + 1;
                        boolean bit = normalizedFrame3.readBit();
                        if (bit) {
                            bits = normalizedFrame3.readBits(2);
                            bits2 = (normalizedFrame3.readBits(3) + 1) * 512;
                            if (normalizedFrame3.readBit()) {
                                normalizedFrame3.skipBits(36);
                            }
                            int bits7 = normalizedFrame3.readBits(3) + 1;
                            int bits8 = normalizedFrame3.readBits(3) + 1;
                            if (bits7 != 1 || bits8 != 1) {
                                throw ParserException.createForUnsupportedContainerFeature("Multiple audio presentations or assets not supported");
                            }
                            int i17 = bits5 + 1;
                            int bits9 = normalizedFrame3.readBits(i17);
                            int i18 = 0;
                            while (i18 < i17) {
                                if (((bits9 >> i18) & 1) == 1) {
                                    normalizedFrame3.skipBits(i16);
                                }
                                i18++;
                                i16 = 8;
                            }
                            if (normalizedFrame3.readBit()) {
                                normalizedFrame3.skipBits(2);
                                int bits10 = (normalizedFrame3.readBits(2) + 1) << 2;
                                int bits11 = normalizedFrame3.readBits(2) + 1;
                                for (int i19 = 0; i19 < bits11; i19++) {
                                    normalizedFrame3.skipBits(bits10);
                                }
                            }
                        } else {
                            bits = -1;
                            bits2 = 0;
                        }
                        normalizedFrame3.skipBits(i3);
                        normalizedFrame3.skipBits(12);
                        if (bit) {
                            if (normalizedFrame3.readBit()) {
                                normalizedFrame3.skipBits(4);
                            }
                            if (normalizedFrame3.readBit()) {
                                normalizedFrame3.skipBits(24);
                            }
                            if (normalizedFrame3.readBit()) {
                                normalizedFrame3.skipBytes(normalizedFrame3.readBits(10) + 1);
                            }
                            normalizedFrame3.skipBits(5);
                            i5 = AacUtil.SAMPLE_RATE_BY_INDEX[normalizedFrame3.readBits(4)];
                            bits3 = normalizedFrame3.readBits(8) + 1;
                        } else {
                            bits3 = -1;
                            i5 = -2147483647;
                        }
                        if (bit) {
                            if (bits == 0) {
                                i6 = 32000;
                            } else if (bits == 1) {
                                i6 = 44100;
                            } else {
                                if (bits != 2) {
                                    throw ParserException.createForMalformedContainer(null, "Unsupported reference clock code in DTS HD header: " + bits);
                                }
                                i6 = 48000;
                            }
                            String str2 = Util.DEVICE_DEBUG_INFO;
                            jScaleLargeValue = Util.scaleLargeValue(bits2, 1000000L, i6, RoundingMode.DOWN);
                        } else {
                            jScaleLargeValue = -9223372036854775807L;
                        }
                        updateFormatWithDtsHeaderInfo(new NavOptions.Builder("audio/vnd.dts.hd;profile=lbr", bits3, i5, bits6, jScaleLargeValue));
                        this.sampleSize = bits6;
                        this.sampleDurationUs = jScaleLargeValue == -9223372036854775807L ? 0L : jScaleLargeValue;
                        parsableByteArray2.setPosition(0);
                        this.output.sampleData(this.extensionSubstreamHeaderSize, parsableByteArray2);
                        this.state = (byte) 6;
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    if (continueRead$3(parsableByteArray, parsableByteArray2.data, 6)) {
                        VorbisBitArray normalizedFrame4 = AacUtil.getNormalizedFrame(parsableByteArray2.data);
                        normalizedFrame4.skipBits(32);
                        int unsignedVarInt = AacUtil.parseUnsignedVarInt(normalizedFrame4, AacUtil.UHD_HEADER_SIZE_LENGTH_TABLE) + 1;
                        this.uhdHeaderSize = unsignedVarInt;
                        int i20 = this.bytesRead;
                        if (i20 > unsignedVarInt) {
                            int i21 = i20 - unsignedVarInt;
                            this.bytesRead = i20 - i21;
                            parsableByteArray.setPosition(parsableByteArray.position - i21);
                        }
                        this.state = (byte) 5;
                    }
                    break;
                case 5:
                    if (continueRead$3(parsableByteArray, parsableByteArray2.data, this.uhdHeaderSize)) {
                        byte[] bArr3 = parsableByteArray2.data;
                        VorbisBitArray normalizedFrame5 = AacUtil.getNormalizedFrame(bArr3);
                        int i22 = normalizedFrame5.readBits(32) == 1078008818 ? 1 : 0;
                        int unsignedVarInt2 = AacUtil.parseUnsignedVarInt(normalizedFrame5, AacUtil.UHD_FTOC_PAYLOAD_LENGTH_TABLE);
                        int i23 = unsignedVarInt2 + 1;
                        if (i22 == 0) {
                            j = -9223372036854775807L;
                            i7 = -2147483647;
                        } else {
                            if (!normalizedFrame5.readBit()) {
                                throw ParserException.createForUnsupportedContainerFeature("Only supports full channel mask-based audio presentation");
                            }
                            int i24 = unsignedVarInt2 - 1;
                            int i25 = ((bArr3[i24] << 8) & DatagramKt.MAX_DATAGRAM_SIZE) | (bArr3[unsignedVarInt2] & 255);
                            String str3 = Util.DEVICE_DEBUG_INFO;
                            int i26 = 65535;
                            for (int i27 = 0; i27 < i24; i27++) {
                                int unsignedInt = Byte.toUnsignedInt(bArr3[i27]);
                                int i28 = (((i26 >> 12) & 255) ^ (unsignedInt >> 4)) & 255;
                                int i29 = (i26 << 4) & DatagramKt.MAX_DATAGRAM_SIZE;
                                int[] iArr = Util.CRC16_BYTES_MSBF;
                                int i30 = (iArr[i28] ^ i29) & DatagramKt.MAX_DATAGRAM_SIZE;
                                i26 = (((i30 << 4) & DatagramKt.MAX_DATAGRAM_SIZE) ^ iArr[(((i30 >> 12) & 255) ^ (unsignedInt & 15)) & 255]) & DatagramKt.MAX_DATAGRAM_SIZE;
                            }
                            if (i25 != i26) {
                                throw ParserException.createForMalformedContainer(null, "CRC check failed");
                            }
                            int bits12 = normalizedFrame5.readBits(2);
                            if (bits12 == 0) {
                                i8 = 512;
                            } else if (bits12 == 1) {
                                i8 = 480;
                            } else {
                                if (bits12 != 2) {
                                    throw ParserException.createForMalformedContainer(null, "Unsupported base duration index in DTS UHD header: " + bits12);
                                }
                                i8 = 384;
                            }
                            int bits13 = (normalizedFrame5.readBits(3) + 1) * i8;
                            int bits14 = normalizedFrame5.readBits(2);
                            if (bits14 == 0) {
                                i9 = 32000;
                            } else if (bits14 == 1) {
                                i9 = 44100;
                            } else {
                                if (bits14 != 2) {
                                    throw ParserException.createForMalformedContainer(null, "Unsupported clock rate index in DTS UHD header: " + bits14);
                                }
                                i9 = 48000;
                            }
                            if (normalizedFrame5.readBit()) {
                                normalizedFrame5.skipBits(36);
                            }
                            int bits15 = (1 << normalizedFrame5.readBits(2)) * i9;
                            long jScaleLargeValue2 = Util.scaleLargeValue(bits13, 1000000L, i9, RoundingMode.DOWN);
                            i7 = bits15;
                            j = jScaleLargeValue2;
                        }
                        int unsignedVarInt3 = 0;
                        for (int i31 = 0; i31 < i22; i31++) {
                            unsignedVarInt3 += AacUtil.parseUnsignedVarInt(normalizedFrame5, AacUtil.UHD_METADATA_CHUNK_SIZE_LENGTH_TABLE);
                        }
                        AtomicInteger atomicInteger = this.uhdAudioChunkId;
                        if (i22 != 0) {
                            atomicInteger.set(AacUtil.parseUnsignedVarInt(normalizedFrame5, AacUtil.UHD_AUDIO_CHUNK_ID_LENGTH_TABLE));
                        }
                        int unsignedVarInt4 = unsignedVarInt3 + (atomicInteger.get() != 0 ? AacUtil.parseUnsignedVarInt(normalizedFrame5, AacUtil.UHD_AUDIO_CHUNK_SIZE_LENGTH_TABLE) : 0) + i23;
                        NavOptions.Builder builder2 = new NavOptions.Builder("audio/vnd.dts.uhd;profile=p2", 2, i7, unsignedVarInt4, j);
                        if (this.frameType == 3) {
                            updateFormatWithDtsHeaderInfo(builder2);
                        }
                        this.sampleSize = unsignedVarInt4;
                        this.sampleDurationUs = j == -9223372036854775807L ? 0L : j;
                        parsableByteArray2.setPosition(0);
                        this.output.sampleData(this.uhdHeaderSize, parsableByteArray2);
                        this.state = (byte) 6;
                    } else {
                        continue;
                    }
                    break;
                case 6:
                    int iMin = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
                    this.output.sampleData(iMin, parsableByteArray);
                    int i32 = this.bytesRead + iMin;
                    this.bytesRead = i32;
                    if (i32 == this.sampleSize) {
                        UtilsKt.checkState(this.timeUs != -9223372036854775807L);
                        this.output.sampleMetadata(this.timeUs, this.frameType == 4 ? 0 : 1, this.sampleSize, 0, null);
                        this.timeUs += this.sampleDurationUs;
                        this.state = (byte) 0;
                    }
                    break;
                default:
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
            }
        }
    }

    public final boolean continueRead$3(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int iMin = Math.min(parsableByteArray.bytesLeft(), i - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, iMin);
        int i2 = this.bytesRead + iMin;
        this.bytesRead = i2;
        return i2 == i;
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
        this.timeUs = j;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void seek() {
        this.state = (byte) 0;
        this.bytesRead = 0;
        this.syncBytes = 0;
        this.timeUs = -9223372036854775807L;
        this.uhdAudioChunkId.set(0);
    }

    public final void updateFormatWithDtsHeaderInfo(NavOptions.Builder builder) {
        int i = builder.enterAnim;
        String str = builder.popUpToRoute;
        int i2 = builder.exitAnim;
        if (i == -2147483647 || i2 == -1) {
            return;
        }
        Format format = this.format;
        if (format != null && i2 == format.channelCount && i == format.sampleRate && str.equals(format.sampleMimeType)) {
            return;
        }
        Format format2 = this.format;
        Format.Builder builder2 = format2 == null ? new Format.Builder() : format2.buildUpon();
        builder2.id = this.formatId;
        builder2.containerMimeType = MimeTypes.normalizeMimeType("video/mp2t");
        builder2.sampleMimeType = MimeTypes.normalizeMimeType(str);
        builder2.channelCount = i2;
        builder2.sampleRate = i;
        builder2.language = this.language;
        builder2.roleFlags = this.roleFlags;
        Format format3 = new Format(builder2);
        this.format = format3;
        this.output.format(format3);
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public final void packetFinished(boolean z) {
    }
}
