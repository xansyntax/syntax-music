package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface VideoSink {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class VideoSinkException extends Exception {
        public final Format format;

        public VideoSinkException(Exception exc, Format format) {
            super(exc);
            this.format = format;
        }
    }

    void allowReleaseFirstFrameBeforeStarted();

    void clearOutputSurfaceInfo();

    void flush(boolean z);

    Surface getInputSurface();

    boolean handleInputFrame(long j, MediaCodecVideoRenderer.AnonymousClass2 anonymousClass2);

    boolean initialize(Format format);

    boolean isEnded();

    boolean isInitialized();

    boolean isReady(boolean z);

    void join(boolean z);

    void onInputStreamChanged(Format format, long j, int i, List list);

    void redraw();

    void release();

    void render(long j, long j2);

    void setBufferTimestampAdjustmentUs(long j);

    void setChangeFrameRateStrategy(int i);

    void setListener(MediaCodecVideoRenderer.AnonymousClass1 anonymousClass1);

    void setOutputSurfaceInfo(Surface surface, Size size);

    void setPlaybackSpeed(float f);

    void setVideoEffects(List list);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void signalEndOfCurrentInputStream();

    void startRendering();

    void stopRendering();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Listener {
        public static final AnonymousClass1 NO_OP = new AnonymousClass1();

        /* JADX INFO: renamed from: androidx.media3.exoplayer.video.VideoSink$Listener$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class AnonymousClass1 implements Listener {
        }

        default void onFirstFrameRendered() {
        }

        default void onFrameAvailableForRendering() {
        }

        default void onFrameDropped() {
        }

        default void onVideoSizeChanged(VideoSize videoSize) {
        }
    }
}
