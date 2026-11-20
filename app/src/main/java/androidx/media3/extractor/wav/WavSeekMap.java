package androidx.media3.extractor.wav;

import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WavSeekMap implements SeekMap {
    public final long blockCount;
    public final long durationUs;
    public final long firstBlockPosition;
    public final int framesPerBlock;
    public final WavFormat wavFormat;

    public WavSeekMap(WavFormat wavFormat, int i, long j, long j2) {
        this.wavFormat = wavFormat;
        this.framesPerBlock = i;
        this.firstBlockPosition = j;
        long j3 = (j2 - j) / ((long) wavFormat.blockSize);
        this.blockCount = j3;
        this.durationUs = blockIndexToTimeUs(j3);
    }

    public final long blockIndexToTimeUs(long j) {
        long j2 = j * ((long) this.framesPerBlock);
        long j3 = this.wavFormat.frameRateHz;
        String str = Util.DEVICE_DEBUG_INFO;
        return Util.scaleLargeValue(j2, 1000000L, j3, RoundingMode.DOWN);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // androidx.media3.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j) {
        WavFormat wavFormat = this.wavFormat;
        long j2 = (((long) wavFormat.frameRateHz) * j) / (((long) this.framesPerBlock) * 1000000);
        long j3 = this.blockCount - 1;
        long jConstrainValue = Util.constrainValue(j2, 0L, j3);
        int i = wavFormat.blockSize;
        long j4 = this.firstBlockPosition;
        long jBlockIndexToTimeUs = blockIndexToTimeUs(jConstrainValue);
        SeekPoint seekPoint = new SeekPoint(jBlockIndexToTimeUs, (((long) i) * jConstrainValue) + j4);
        if (jBlockIndexToTimeUs >= j || jConstrainValue == j3) {
            return new SeekMap.SeekPoints(seekPoint, seekPoint);
        }
        long j5 = jConstrainValue + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(blockIndexToTimeUs(j5), (((long) i) * j5) + j4));
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean isSeekable() {
        return true;
    }
}
