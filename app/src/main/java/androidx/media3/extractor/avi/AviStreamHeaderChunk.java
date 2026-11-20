package androidx.media3.extractor.avi;

import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AviStreamHeaderChunk implements AviChunk {
    public final int length;
    public final int rate;
    public final int sampleSize;
    public final int scale;
    public final int streamType;
    public final int suggestedBufferSize;

    public AviStreamHeaderChunk(int i, int i2, int i3, int i4, int i5, int i6) {
        this.streamType = i;
        this.scale = i2;
        this.rate = i3;
        this.length = i4;
        this.suggestedBufferSize = i5;
        this.sampleSize = i6;
    }

    public final int getTrackType() {
        int i = this.streamType;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        Log.w("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(i));
        return -1;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1752331379;
    }
}
