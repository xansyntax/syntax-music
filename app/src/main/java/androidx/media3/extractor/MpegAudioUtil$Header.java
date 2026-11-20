package androidx.media3.extractor;

import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MpegAudioUtil$Header {
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    public final boolean setForHeaderData(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.version = i2;
        this.mimeType = AacUtil.MIME_TYPE_BY_LAYER[3 - i3];
        int i6 = AacUtil.SAMPLING_RATE_V1[i5];
        this.sampleRate = i6;
        if (i2 == 2) {
            i6 /= 2;
            this.sampleRate = i6;
        } else if (i2 == 0) {
            i6 /= 4;
            this.sampleRate = i6;
        }
        int i7 = (i >>> 9) & 1;
        int i8 = 1152;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    Path$$ExternalSyntheticBUOutline0.m();
                    return false;
                }
                i8 = 384;
            }
        } else if (i2 != 3) {
            i8 = 576;
        }
        this.samplesPerFrame = i8;
        if (i3 == 3) {
            int i9 = i2 == 3 ? AacUtil.BITRATE_V1_L1[i4 - 1] : AacUtil.BITRATE_V2_L1[i4 - 1];
            this.bitrate = i9;
            this.frameSize = (((i9 * 12) / i6) + i7) * 4;
        } else {
            if (i2 == 3) {
                int i10 = i3 == 2 ? AacUtil.BITRATE_V1_L2[i4 - 1] : AacUtil.BITRATE_V1_L3[i4 - 1];
                this.bitrate = i10;
                this.frameSize = ((i10 * 144) / i6) + i7;
            } else {
                int i11 = AacUtil.BITRATE_V2[i4 - 1];
                this.bitrate = i11;
                this.frameSize = (((i3 == 1 ? 72 : 144) * i11) / i6) + i7;
            }
        }
        this.channels = ((i >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
