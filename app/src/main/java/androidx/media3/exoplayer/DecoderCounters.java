package androidx.media3.exoplayer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedInputBufferCount;
    public int droppedToKeyframeCount;
    public int maxConsecutiveDroppedBufferCount;
    public int queuedInputBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;
    public long totalVideoFrameProcessingOffsetUs;
    public int videoFrameProcessingOffsetCount;

    public final String toString() {
        int i = this.decoderInitCount;
        int i2 = this.decoderReleaseCount;
        int i3 = this.queuedInputBufferCount;
        int i4 = this.skippedInputBufferCount;
        int i5 = this.renderedOutputBufferCount;
        int i6 = this.skippedOutputBufferCount;
        int i7 = this.droppedBufferCount;
        int i8 = this.droppedInputBufferCount;
        int i9 = this.maxConsecutiveDroppedBufferCount;
        int i10 = this.droppedToKeyframeCount;
        long j = this.totalVideoFrameProcessingOffsetUs;
        int i11 = this.videoFrameProcessingOffsetCount;
        String str = Util.DEVICE_DEBUG_INFO;
        Locale locale = Locale.US;
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", i2, "\n queuedInputBuffers=");
        sbM3m.append(i3);
        sbM3m.append("\n skippedInputBuffers=");
        sbM3m.append(i4);
        sbM3m.append("\n renderedOutputBuffers=");
        sbM3m.append(i5);
        sbM3m.append("\n skippedOutputBuffers=");
        sbM3m.append(i6);
        sbM3m.append("\n droppedBuffers=");
        sbM3m.append(i7);
        sbM3m.append("\n droppedInputBuffers=");
        sbM3m.append(i8);
        sbM3m.append("\n maxConsecutiveDroppedBuffers=");
        sbM3m.append(i9);
        sbM3m.append("\n droppedToKeyframeEvents=");
        sbM3m.append(i10);
        sbM3m.append("\n totalVideoFrameProcessingOffsetUs=");
        sbM3m.append(j);
        sbM3m.append("\n videoFrameProcessingOffsetCount=");
        sbM3m.append(i11);
        sbM3m.append("\n}");
        return sbM3m.toString();
    }
}
