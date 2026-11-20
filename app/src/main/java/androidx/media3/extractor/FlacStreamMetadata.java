package androidx.media3.extractor;

import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Util;
import com.metrolist.music.recognition.VibraSignature;
import java.nio.ByteOrder;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlacStreamMetadata {
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    public final Metadata metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    public final CallbackWrapper seekTable;
    public final long totalSamples;

    public FlacStreamMetadata(byte[] bArr, int i) {
        VorbisBitArray vorbisBitArray = new VorbisBitArray(bArr, bArr.length);
        vorbisBitArray.setPosition(i * 8);
        this.minBlockSizeSamples = vorbisBitArray.readBits(16);
        this.maxBlockSizeSamples = vorbisBitArray.readBits(16);
        this.minFrameSize = vorbisBitArray.readBits(24);
        this.maxFrameSize = vorbisBitArray.readBits(24);
        int bits = vorbisBitArray.readBits(20);
        this.sampleRate = bits;
        this.sampleRateLookupKey = getSampleRateLookupKey(bits);
        this.channels = vorbisBitArray.readBits(3) + 1;
        int bits2 = vorbisBitArray.readBits(5) + 1;
        this.bitsPerSample = bits2;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(bits2);
        this.totalSamples = vorbisBitArray.readBitsToLong(36);
        this.seekTable = null;
        this.metadata = null;
    }

    public static int getBitsPerSampleLookupKey(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 20) {
            return 5;
        }
        if (i != 24) {
            return i != 32 ? -1 : 7;
        }
        return 6;
    }

    public static int getSampleRateLookupKey(int i) {
        switch (i) {
            case 8000:
                return 4;
            case VibraSignature.REQUIRED_SAMPLE_RATE /* 16000 */:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long getDurationUs() {
        long j = this.totalSamples;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / ((long) this.sampleRate);
    }

    public final Format getFormat(byte[] bArr, Metadata metadata) {
        bArr[4] = -128;
        int i = this.maxFrameSize;
        if (i <= 0) {
            i = -1;
        }
        Metadata metadata2 = this.metadata;
        if (metadata2 != null) {
            metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
        }
        Format.Builder builder = new Format.Builder();
        builder.sampleMimeType = MimeTypes.normalizeMimeType("audio/flac");
        builder.maxInputSize = i;
        builder.channelCount = this.channels;
        builder.sampleRate = this.sampleRate;
        String str = Util.DEVICE_DEBUG_INFO;
        builder.pcmEncoding = Util.getPcmEncoding(this.bitsPerSample, ByteOrder.LITTLE_ENDIAN);
        builder.initializationData = Collections.singletonList(bArr);
        builder.metadata = metadata;
        return new Format(builder);
    }

    public FlacStreamMetadata(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, CallbackWrapper callbackWrapper, Metadata metadata) {
        this.minBlockSizeSamples = i;
        this.maxBlockSizeSamples = i2;
        this.minFrameSize = i3;
        this.maxFrameSize = i4;
        this.sampleRate = i5;
        this.sampleRateLookupKey = getSampleRateLookupKey(i5);
        this.channels = i6;
        this.bitsPerSample = i7;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(i7);
        this.totalSamples = j;
        this.seekTable = callbackWrapper;
        this.metadata = metadata;
    }
}
