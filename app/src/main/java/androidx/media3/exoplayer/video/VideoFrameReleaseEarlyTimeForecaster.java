package androidx.media3.exoplayer.video;

import android.util.Range;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoFrameReleaseEarlyTimeForecaster {
    public double derivativeOfEarlyTime;
    public Range derivativeOfEarlyTimeRange;
    public long lastFrameEarlyUs;
    public long lastFramePresentationTimeUs;

    public VideoFrameReleaseEarlyTimeForecaster() {
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d));
        this.derivativeOfEarlyTimeRange = range;
        this.derivativeOfEarlyTime = ((Double) range.getUpper()).doubleValue();
        this.lastFramePresentationTimeUs = -9223372036854775807L;
        this.lastFrameEarlyUs = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    public final void onVideoFrameProcessed(long j, long j2) {
        double dDoubleValue;
        UtilsKt.checkArgument(j != -9223372036854775807L);
        UtilsKt.checkArgument(j2 != -9223372036854775807L);
        long j3 = this.lastFramePresentationTimeUs;
        if (j3 != -9223372036854775807L) {
            long j4 = this.lastFrameEarlyUs;
            if (j4 == -9223372036854775807L || j == j3) {
                dDoubleValue = ((Double) this.derivativeOfEarlyTimeRange.getUpper()).doubleValue();
            } else {
                dDoubleValue = (j2 - j4) / (j - j3);
            }
        } else {
            dDoubleValue = ((Double) this.derivativeOfEarlyTimeRange.getUpper()).doubleValue();
        }
        this.derivativeOfEarlyTime = (((Double) this.derivativeOfEarlyTimeRange.clamp(Double.valueOf(dDoubleValue))).doubleValue() * 0.20000000298023224d) + (this.derivativeOfEarlyTime * 0.800000011920929d);
        this.lastFramePresentationTimeUs = j;
        this.lastFrameEarlyUs = j2;
    }

    public final void reset() {
        this.derivativeOfEarlyTime = ((Double) this.derivativeOfEarlyTimeRange.getUpper()).doubleValue();
        this.lastFramePresentationTimeUs = -9223372036854775807L;
        this.lastFrameEarlyUs = -9223372036854775807L;
    }

    public final void setPlaybackSpeed(float f) {
        UtilsKt.checkArgument(f > CropImageView.DEFAULT_ASPECT_RATIO);
        this.derivativeOfEarlyTimeRange = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / ((double) f)));
        reset();
    }
}
