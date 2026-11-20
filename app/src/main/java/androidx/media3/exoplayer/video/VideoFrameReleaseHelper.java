package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.Choreographer$VsyncCallback;
import android.view.Display;
import android.view.Surface;
import androidx.core.os.BuildCompat;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda3;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoFrameReleaseHelper {
    public int changeFrameRateStrategy;
    public final Context context;
    public float formatFrameRate;
    public long frameIndex;
    public final FixedFrameRateEstimator frameRateEstimator;
    public long lastAdjustedFrameIndex;
    public long lastAdjustedPresentationTimeUs;
    public long lastAdjustedReleaseTimeNs;
    public long lastVsyncHysteresisOffsetNs;
    public long pendingLastAdjustedFrameIndex;
    public long pendingLastAdjustedReleaseTimeNs;
    public long pendingLastPresentationTimeUs;
    public long pendingVsyncHysteresisOffsetNs;
    public float playbackSpeed;
    public boolean started;
    public Surface surface;
    public float surfaceMediaFrameRate;
    public float surfacePlaybackFrameRate;
    public VSyncSampler vsyncSampler;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VSyncSamplerBase extends VSyncSampler implements Choreographer.FrameCallback {
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            this.choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            long refreshRate;
            if (i == 0) {
                this.choreographer.postFrameCallback(this);
                Display display = this.displayManager.getDisplay(0);
                if (display != null) {
                    refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
                } else {
                    Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
                    refreshRate = -9223372036854775807L;
                }
                this.vsyncDurationNs = refreshRate;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseHelper.VSyncSampler
        public final void register() {
            long refreshRate;
            this.displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper(null));
            this.choreographer.postFrameCallback(this);
            Display display = this.displayManager.getDisplay(0);
            if (display != null) {
                refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            } else {
                Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
                refreshRate = -9223372036854775807L;
            }
            this.vsyncDurationNs = refreshRate;
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseHelper.VSyncSampler
        public final void unregister() {
            this.displayManager.unregisterDisplayListener(this);
            this.choreographer.removeFrameCallback(this);
            this.sampledVsyncTimeNs = -9223372036854775807L;
            this.vsyncDurationNs = -9223372036854775807L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VSyncSamplerV33 extends VSyncSampler implements Choreographer$VsyncCallback {
        public final Handler handler;

        public VSyncSamplerV33(Choreographer choreographer, DisplayManager displayManager) {
            super(choreographer, displayManager);
            this.handler = Util.createHandlerForCurrentLooper(null);
        }

        public final /* synthetic */ void lambda$onVsync$0() {
            this.choreographer.postVsyncCallback(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            if (i == 0) {
                this.choreographer.postVsyncCallback(this);
            }
        }

        public final void onVsync(Choreographer.FrameData frameData) {
            this.sampledVsyncTimeNs = frameData.getFrameTimeNanos();
            Choreographer.FrameTimeline[] frameTimelines = frameData.getFrameTimelines();
            byte b = 1;
            if (frameTimelines.length >= 2) {
                long expectedPresentationTimeNanos = frameTimelines[1].getExpectedPresentationTimeNanos() - frameTimelines[0].getExpectedPresentationTimeNanos();
                this.vsyncDurationNs = expectedPresentationTimeNanos != 0 ? expectedPresentationTimeNanos : -9223372036854775807L;
            } else {
                this.vsyncDurationNs = -9223372036854775807L;
            }
            this.handler.postDelayed(new MediaSessionService$$ExternalSyntheticLambda3(b, this), 500L);
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseHelper.VSyncSampler
        public final void register() {
            this.displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper(null));
            this.choreographer.postVsyncCallback(this);
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameReleaseHelper.VSyncSampler
        public final void unregister() {
            this.displayManager.unregisterDisplayListener(this);
            this.handler.removeCallbacksAndMessages(null);
            this.choreographer.removeVsyncCallback(this);
            this.sampledVsyncTimeNs = -9223372036854775807L;
            this.vsyncDurationNs = -9223372036854775807L;
        }
    }

    public VideoFrameReleaseHelper(Context context) {
        this.context = context;
        FixedFrameRateEstimator fixedFrameRateEstimator = new FixedFrameRateEstimator();
        fixedFrameRateEstimator.currentMatcher = new FixedFrameRateEstimator.Matcher();
        fixedFrameRateEstimator.candidateMatcher = new FixedFrameRateEstimator.Matcher();
        fixedFrameRateEstimator.lastFramePresentationTimeNs = -9223372036854775807L;
        this.frameRateEstimator = fixedFrameRateEstimator;
        this.formatFrameRate = -1.0f;
        this.playbackSpeed = 1.0f;
        this.changeFrameRateStrategy = 0;
    }

    public final void clearSurfaceFrameRate() {
        Surface surface;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.surface) == null || this.changeFrameRateStrategy == Integer.MIN_VALUE || this.surfacePlaybackFrameRate == CropImageView.DEFAULT_ASPECT_RATIO || !surface.isValid()) {
            return;
        }
        this.surfacePlaybackFrameRate = CropImageView.DEFAULT_ASPECT_RATIO;
        BuildCompat.Api30Impl.setSurfaceFrameRate(this.surface, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final void resetAdjustment() {
        this.frameIndex = 0L;
        this.lastAdjustedFrameIndex = -1L;
        this.pendingLastAdjustedFrameIndex = -1L;
        this.lastVsyncHysteresisOffsetNs = 0L;
        this.pendingVsyncHysteresisOffsetNs = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    public final void updateSurfaceMediaFrameRate() {
        float f;
        float f2;
        if (Build.VERSION.SDK_INT < 30 || this.surface == null) {
            return;
        }
        FixedFrameRateEstimator fixedFrameRateEstimator = this.frameRateEstimator;
        if (!fixedFrameRateEstimator.currentMatcher.isSynced()) {
            f = this.formatFrameRate;
        } else if (fixedFrameRateEstimator.currentMatcher.isSynced()) {
            FixedFrameRateEstimator.Matcher matcher = fixedFrameRateEstimator.currentMatcher;
            long j = matcher.matchingFrameCount;
            f = (float) (1.0E9d / (j != 0 ? matcher.matchingFrameDurationSumNs / j : 0L));
        } else {
            f = -1.0f;
        }
        float f3 = this.surfaceMediaFrameRate;
        if (f == f3) {
            return;
        }
        if (f != -1.0f && f3 != -1.0f) {
            if (fixedFrameRateEstimator.currentMatcher.isSynced()) {
                if ((fixedFrameRateEstimator.currentMatcher.isSynced() ? fixedFrameRateEstimator.currentMatcher.matchingFrameDurationSumNs : -9223372036854775807L) >= 5000000000L) {
                    f2 = 0.1f;
                } else {
                    f2 = 1.0f;
                }
            } else {
                f2 = 1.0f;
            }
            if (Math.abs(f - this.surfaceMediaFrameRate) < f2) {
                return;
            }
        } else if (f == -1.0f && fixedFrameRateEstimator.framesWithoutSyncCount < 30) {
            return;
        }
        this.surfaceMediaFrameRate = f;
        updateSurfacePlaybackFrameRate(false);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    public final void updateSurfacePlaybackFrameRate(boolean z) {
        Surface surface;
        float f;
        if (Build.VERSION.SDK_INT < 30 || (surface = this.surface) == null || this.changeFrameRateStrategy == Integer.MIN_VALUE || !surface.isValid()) {
            return;
        }
        if (this.started) {
            float f2 = this.surfaceMediaFrameRate;
            if (f2 != -1.0f) {
                f = f2 * this.playbackSpeed;
            } else {
                f = CropImageView.DEFAULT_ASPECT_RATIO;
            }
        } else {
            f = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        if (z || this.surfacePlaybackFrameRate != f) {
            this.surfacePlaybackFrameRate = f;
            BuildCompat.Api30Impl.setSurfaceFrameRate(this.surface, f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class VSyncSampler implements DisplayManager.DisplayListener {
        public final Choreographer choreographer;
        public final DisplayManager displayManager;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;
        public volatile long vsyncDurationNs = -9223372036854775807L;

        public VSyncSampler(Choreographer choreographer, DisplayManager displayManager) {
            this.choreographer = choreographer;
            this.displayManager = displayManager;
        }

        public abstract void register();

        public abstract void unregister();

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    }
}
