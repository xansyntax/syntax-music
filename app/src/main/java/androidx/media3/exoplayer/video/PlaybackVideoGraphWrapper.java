package androidx.media3.exoplayer.video;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Trace;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.metrolist.music.db.DatabaseDao_Impl;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackVideoGraphWrapper {
    public final SystemClock clock;
    public final Context context;
    public Pair currentSurfaceAndSize;
    public final DefaultVideoSink defaultVideoSink;
    public final long earlyThresholdToDropInputUs;
    public final boolean enablePlaylistMode;
    public SystemHandlerWrapper handler;
    public final SparseArray inputVideoSinks;
    public long lastOutputFramePresentationTimeUs;
    public final CopyOnWriteArraySet listeners;
    public int pendingFlushCount;
    public TimedValueQueue pendingStreamChanges = new TimedValueQueue((byte) 0);
    public byte state;
    public int totalVideoInputCount;
    public final VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster;
    public final ReflectiveSingleInputVideoGraphFactory videoGraphFactory;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public boolean built;
        public final Context context;
        public boolean enablePlaylistMode;
        public final VideoFrameReleaseControl videoFrameReleaseControl;
        public ReflectiveSingleInputVideoGraphFactory videoGraphFactory;
        public long lateThresholdToDropInputUs = 15000;
        public final VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = new VideoFrameReleaseEarlyTimeForecaster();
        public SystemClock clock = SystemClock.DEFAULT;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.context = context.getApplicationContext();
            this.videoFrameReleaseControl = videoFrameReleaseControl;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReflectiveDefaultVideoFrameProcessorFactory {
        static {
            DatabaseDao_Impl.AnonymousClass17.memoize(new MediaSessionImpl$$ExternalSyntheticLambda15((byte) 4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ReflectiveSingleInputVideoGraphFactory {
        public final ReflectiveDefaultVideoFrameProcessorFactory videoFrameProcessorFactory = new ReflectiveDefaultVideoFrameProcessorFactory();

        public final void create() {
            try {
                ((ReflectiveSingleInputVideoGraphFactory) Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(ReflectiveDefaultVideoFrameProcessorFactory.class).newInstance(this.videoFrameProcessorFactory)).create();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class StreamChangeInfo {
    }

    public PlaybackVideoGraphWrapper(Builder builder) {
        this.context = builder.context;
        ReflectiveSingleInputVideoGraphFactory reflectiveSingleInputVideoGraphFactory = builder.videoGraphFactory;
        reflectiveSingleInputVideoGraphFactory.getClass();
        this.videoGraphFactory = reflectiveSingleInputVideoGraphFactory;
        this.inputVideoSinks = new SparseArray();
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        RegularImmutableList regularImmutableList = RegularImmutableList.EMPTY;
        this.enablePlaylistMode = builder.enablePlaylistMode;
        SystemClock systemClock = builder.clock;
        this.clock = systemClock;
        long j = builder.lateThresholdToDropInputUs;
        this.earlyThresholdToDropInputUs = j != -9223372036854775807L ? -j : -9223372036854775807L;
        VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = builder.videoFrameReleaseEarlyTimeForecaster;
        this.videoFrameReleaseEarlyTimeForecaster = videoFrameReleaseEarlyTimeForecaster;
        this.defaultVideoSink = new DefaultVideoSink(builder.videoFrameReleaseControl, videoFrameReleaseEarlyTimeForecaster, systemClock);
        this.listeners = new CopyOnWriteArraySet();
        new Format(new Format.Builder());
        this.lastOutputFramePresentationTimeUs = -9223372036854775807L;
        this.totalVideoInputCount = -1;
        this.state = (byte) 0;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InputVideoSink implements VideoSink {
        public int consecutiveDroppedFrames;
        public long inputBufferTimestampAdjustmentUs;
        public Format inputFormat;
        public ImmutableList videoEffects;

        public InputVideoSink(Context context) {
            Util.isFrameDropAllowedOnSurfaceInput(context);
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            this.videoEffects = RegularImmutableList.EMPTY;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void allowReleaseFirstFrameBeforeStarted() {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.pendingStreamChanges.size() == 0) {
                playbackVideoGraphWrapper.defaultVideoSink.allowReleaseFirstFrameBeforeStarted();
                return;
            }
            TimedValueQueue timedValueQueue = new TimedValueQueue((byte) 0);
            if (playbackVideoGraphWrapper.pendingStreamChanges.size() <= 0) {
                playbackVideoGraphWrapper.pendingStreamChanges = timedValueQueue;
            } else {
                ((StreamChangeInfo) playbackVideoGraphWrapper.pendingStreamChanges.pollFirst()).getClass();
                throw null;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void clearOutputSurfaceInfo() {
            int i = Size.UNKNOWN.width;
            PlaybackVideoGraphWrapper.this.currentSurfaceAndSize = null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void flush(boolean z) {
            TimedValueQueue timedValueQueue;
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            DefaultVideoSink defaultVideoSink = playbackVideoGraphWrapper.defaultVideoSink;
            if (playbackVideoGraphWrapper.state == 1) {
                playbackVideoGraphWrapper.pendingFlushCount++;
                defaultVideoSink.flush(z);
                while (true) {
                    int size = playbackVideoGraphWrapper.pendingStreamChanges.size();
                    timedValueQueue = playbackVideoGraphWrapper.pendingStreamChanges;
                    if (size <= 1) {
                        break;
                    } else {
                        timedValueQueue.pollFirst();
                    }
                }
                if (timedValueQueue.size() == 1) {
                    ((StreamChangeInfo) playbackVideoGraphWrapper.pendingStreamChanges.pollFirst()).getClass();
                    throw null;
                }
                playbackVideoGraphWrapper.lastOutputFramePresentationTimeUs = -9223372036854775807L;
                SystemHandlerWrapper systemHandlerWrapper = playbackVideoGraphWrapper.handler;
                systemHandlerWrapper.getClass();
                systemHandlerWrapper.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 29, (Object) playbackVideoGraphWrapper));
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final Surface getInputSurface() {
            UtilsKt.checkState(false);
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean handleInputFrame(long j, MediaCodecVideoRenderer.AnonymousClass2 anonymousClass2) {
            int i;
            UtilsKt.checkState(false);
            long j2 = j + this.inputBufferTimestampAdjustmentUs;
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster = playbackVideoGraphWrapper.videoFrameReleaseEarlyTimeForecaster;
            long j3 = videoFrameReleaseEarlyTimeForecaster.lastFramePresentationTimeUs;
            long j4 = j3 == -9223372036854775807L ? -9223372036854775807L : (long) (((j2 - j3) * videoFrameReleaseEarlyTimeForecaster.derivativeOfEarlyTime) + videoFrameReleaseEarlyTimeForecaster.lastFrameEarlyUs);
            if (j4 != -9223372036854775807L) {
                long j5 = playbackVideoGraphWrapper.earlyThresholdToDropInputUs;
                if (j5 != -9223372036854775807L && j4 < j5 && (i = this.consecutiveDroppedFrames) < 2) {
                    this.consecutiveDroppedFrames = i + 1;
                    MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                    MediaCodecAdapter mediaCodecAdapter = anonymousClass2.val$codec;
                    int i2 = anonymousClass2.val$bufferIndex;
                    Trace.beginSection("dropVideoBuffer");
                    mediaCodecAdapter.releaseOutputBuffer(i2);
                    Trace.endSection();
                    mediaCodecVideoRenderer.updateDroppedBufferCounters(0, 1);
                    return true;
                }
            }
            int i3 = playbackVideoGraphWrapper.totalVideoInputCount;
            if (i3 == -1 || i3 != 0) {
                return false;
            }
            throw null;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x003f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0042 A[Catch: GlException -> 0x0036, TryCatch #0 {GlException -> 0x0036, blocks: (B:14:0x0026, B:17:0x002e, B:25:0x003c, B:28:0x0042, B:30:0x0046, B:37:0x0059, B:40:0x0060, B:45:0x0082, B:35:0x0051), top: B:50:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x0046 A[Catch: GlException -> 0x0036, TryCatch #0 {GlException -> 0x0036, blocks: (B:14:0x0026, B:17:0x002e, B:25:0x003c, B:28:0x0042, B:30:0x0046, B:37:0x0059, B:40:0x0060, B:45:0x0082, B:35:0x0051), top: B:50:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x004d  */
        /* JADX WARN: Code duplicated, block: B:34:0x004f A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:35:0x0051 A[Catch: GlException -> 0x0036, TryCatch #0 {GlException -> 0x0036, blocks: (B:14:0x0026, B:17:0x002e, B:25:0x003c, B:28:0x0042, B:30:0x0046, B:37:0x0059, B:40:0x0060, B:45:0x0082, B:35:0x0051), top: B:50:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0059 A[Catch: GlException -> 0x0036, TryCatch #0 {GlException -> 0x0036, blocks: (B:14:0x0026, B:17:0x002e, B:25:0x003c, B:28:0x0042, B:30:0x0046, B:37:0x0059, B:40:0x0060, B:45:0x0082, B:35:0x0051), top: B:50:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x007b  */
        /* JADX WARN: Code duplicated, block: B:43:0x007e  */
        /* JADX WARN: Code duplicated, block: B:45:0x0082 A[Catch: GlException -> 0x0036, TRY_LEAVE, TryCatch #0 {GlException -> 0x0036, blocks: (B:14:0x0026, B:17:0x002e, B:25:0x003c, B:28:0x0042, B:30:0x0046, B:37:0x0059, B:40:0x0060, B:45:0x0082, B:35:0x0051), top: B:50:0x0026 }] */
        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean initialize(Format format) throws VideoSink.VideoSinkException {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            boolean zIsExtensionSupported = true;
            UtilsKt.checkState(playbackVideoGraphWrapper.state == 0);
            ColorInfo colorInfo = format.colorInfo;
            if (colorInfo == null || !colorInfo.isDataSpaceValid()) {
                colorInfo = ColorInfo.SDR_BT709_LIMITED;
            }
            int i = colorInfo.colorTransfer;
            if (i == 7) {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 34) {
                        if (i == 6) {
                            if (Build.VERSION.SDK_INT >= 33 || !GlUtil.isExtensionSupported("EGL_EXT_gl_colorspace_bt2020_pq")) {
                                zIsExtensionSupported = false;
                            }
                        } else if (i == 7) {
                            zIsExtensionSupported = GlUtil.isExtensionSupported("EGL_EXT_gl_colorspace_bt2020_hlg");
                        }
                        if (zIsExtensionSupported && Build.VERSION.SDK_INT >= 29) {
                            Locale locale = Locale.US;
                            Log.w("PlaybackVidGraphWrapper", "Color transfer " + i + " is not supported. Falling back to OpenGl tone mapping.");
                            ColorInfo colorInfo2 = ColorInfo.SDR_BT709_LIMITED;
                        } else if (i != 2 || i == 10) {
                            ColorInfo colorInfo3 = ColorInfo.SDR_BT709_LIMITED;
                        }
                    } else {
                        if (!(i2 >= 33 && GlUtil.isExtensionSupported("EGL_EXT_gl_colorspace_bt2020_pq"))) {
                            if (i == 6) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    zIsExtensionSupported = false;
                                } else {
                                    zIsExtensionSupported = false;
                                }
                            } else if (i == 7) {
                                zIsExtensionSupported = GlUtil.isExtensionSupported("EGL_EXT_gl_colorspace_bt2020_hlg");
                            }
                            if (zIsExtensionSupported) {
                                if (i != 2) {
                                    ColorInfo colorInfo4 = ColorInfo.SDR_BT709_LIMITED;
                                } else {
                                    ColorInfo colorInfo5 = ColorInfo.SDR_BT709_LIMITED;
                                }
                            } else if (i != 2) {
                                ColorInfo colorInfo6 = ColorInfo.SDR_BT709_LIMITED;
                            } else {
                                ColorInfo colorInfo7 = ColorInfo.SDR_BT709_LIMITED;
                            }
                        }
                    }
                } catch (GlUtil.GlException e) {
                    throw new VideoSink.VideoSinkException(e, format);
                }
            } else {
                if (i == 6) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        zIsExtensionSupported = false;
                    } else {
                        zIsExtensionSupported = false;
                    }
                } else if (i == 7) {
                    zIsExtensionSupported = GlUtil.isExtensionSupported("EGL_EXT_gl_colorspace_bt2020_hlg");
                }
                if (zIsExtensionSupported) {
                    if (i != 2) {
                        ColorInfo colorInfo8 = ColorInfo.SDR_BT709_LIMITED;
                    } else {
                        ColorInfo colorInfo9 = ColorInfo.SDR_BT709_LIMITED;
                    }
                } else if (i != 2) {
                    ColorInfo colorInfo10 = ColorInfo.SDR_BT709_LIMITED;
                } else {
                    ColorInfo colorInfo11 = ColorInfo.SDR_BT709_LIMITED;
                }
            }
            SystemClock systemClock = playbackVideoGraphWrapper.clock;
            Looper looperMyLooper = Looper.myLooper();
            looperMyLooper.getClass();
            playbackVideoGraphWrapper.handler = systemClock.createHandler(looperMyLooper, null);
            playbackVideoGraphWrapper.videoGraphFactory.create();
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean isEnded() {
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean isInitialized() {
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean isReady(boolean z) {
            return PlaybackVideoGraphWrapper.this.defaultVideoSink.videoFrameReleaseControl.isReady(false);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void join(boolean z) {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.enablePlaylistMode) {
                playbackVideoGraphWrapper.defaultVideoSink.join(z);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void onInputStreamChanged(Format format, long j, int i, List list) {
            UtilsKt.checkState(false);
            this.videoEffects = ImmutableList.copyOf((Collection) list);
            this.inputFormat = format;
            Format.Builder builderBuildUpon = format.buildUpon();
            ColorInfo colorInfo = format.colorInfo;
            if (colorInfo == null || !colorInfo.isDataSpaceValid()) {
                colorInfo = ColorInfo.SDR_BT709_LIMITED;
            }
            builderBuildUpon.colorInfo = colorInfo;
            new Format(builderBuildUpon);
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void release() {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.state == 2) {
                return;
            }
            SystemHandlerWrapper systemHandlerWrapper = playbackVideoGraphWrapper.handler;
            if (systemHandlerWrapper != null) {
                systemHandlerWrapper.handler.removeCallbacksAndMessages(null);
            }
            playbackVideoGraphWrapper.currentSurfaceAndSize = null;
            playbackVideoGraphWrapper.state = (byte) 2;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void render(long j, long j2) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.render(j + this.inputBufferTimestampAdjustmentUs, j2);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setBufferTimestampAdjustmentUs(long j) {
            this.inputBufferTimestampAdjustmentUs = j;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setChangeFrameRateStrategy(int i) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.setChangeFrameRateStrategy(i);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setOutputSurfaceInfo(Surface surface, Size size) {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            Pair pair = playbackVideoGraphWrapper.currentSurfaceAndSize;
            if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) playbackVideoGraphWrapper.currentSurfaceAndSize.second).equals(size)) {
                return;
            }
            playbackVideoGraphWrapper.currentSurfaceAndSize = Pair.create(surface, size);
            int i = size.width;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setPlaybackSpeed(float f) {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            playbackVideoGraphWrapper.videoFrameReleaseEarlyTimeForecaster.setPlaybackSpeed(f);
            playbackVideoGraphWrapper.defaultVideoSink.setPlaybackSpeed(f);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setVideoEffects(List list) {
            if (this.videoEffects.equals(list)) {
                return;
            }
            this.videoEffects = ImmutableList.copyOf((Collection) list);
            Format format = this.inputFormat;
            if (format == null) {
                return;
            }
            Format.Builder builderBuildUpon = format.buildUpon();
            ColorInfo colorInfo = format.colorInfo;
            if (colorInfo == null || !colorInfo.isDataSpaceValid()) {
                colorInfo = ColorInfo.SDR_BT709_LIMITED;
            }
            builderBuildUpon.colorInfo = colorInfo;
            new Format(builderBuildUpon);
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
            PlaybackVideoGraphWrapper.this.defaultVideoSink.videoFrameMetadataListener = videoFrameMetadataListener;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void signalEndOfCurrentInputStream() {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.lastOutputFramePresentationTimeUs >= -9223372036854775807L) {
                playbackVideoGraphWrapper.defaultVideoSink.signalEndOfCurrentInputStream();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void startRendering() {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.enablePlaylistMode) {
                playbackVideoGraphWrapper.defaultVideoSink.startRendering();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void stopRendering() {
            PlaybackVideoGraphWrapper playbackVideoGraphWrapper = PlaybackVideoGraphWrapper.this;
            if (playbackVideoGraphWrapper.enablePlaylistMode) {
                playbackVideoGraphWrapper.defaultVideoSink.stopRendering();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void redraw() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void setListener(MediaCodecVideoRenderer.AnonymousClass1 anonymousClass1) {
        }
    }
}
