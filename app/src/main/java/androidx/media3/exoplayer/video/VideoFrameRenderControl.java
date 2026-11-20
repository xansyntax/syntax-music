package androidx.media3.exoplayer.video;

import android.os.SystemClock;
import android.os.Trace;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.internal.EocdRecord;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VideoFrameRenderControl {
    public final WeakCache frameRenderer;
    public long lastPresentationTimeUs;
    public long latestInputPresentationTimeUs;
    public long latestOutputPresentationTimeUs;
    public long outputStreamStartPositionUs;
    public VideoSize outputVideoSize;
    public final LongArrayQueue presentationTimestampsUs;
    public final VideoFrameReleaseControl videoFrameReleaseControl;
    public final VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster;
    public final EocdRecord videoFrameReleaseInfo = new EocdRecord();
    public final TimedValueQueue videoSizes = new TimedValueQueue((byte) 0);
    public final TimedValueQueue streamStartPositionsUs = new TimedValueQueue((byte) 0);

    public VideoFrameRenderControl(WeakCache weakCache, VideoFrameReleaseControl videoFrameReleaseControl, VideoFrameReleaseEarlyTimeForecaster videoFrameReleaseEarlyTimeForecaster) {
        this.frameRenderer = weakCache;
        this.videoFrameReleaseControl = videoFrameReleaseControl;
        this.videoFrameReleaseEarlyTimeForecaster = videoFrameReleaseEarlyTimeForecaster;
        LongArrayQueue longArrayQueue = new LongArrayQueue();
        int iHighestOneBit = Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16;
        longArrayQueue.headIndex = 0;
        longArrayQueue.tailIndex = -1;
        longArrayQueue.size = 0;
        longArrayQueue.data = new long[iHighestOneBit];
        longArrayQueue.wrapAroundMask = iHighestOneBit - 1;
        this.presentationTimestampsUs = longArrayQueue;
        this.latestInputPresentationTimeUs = -9223372036854775807L;
        this.outputVideoSize = VideoSize.UNKNOWN;
        this.latestOutputPresentationTimeUs = -9223372036854775807L;
        this.lastPresentationTimeUs = -9223372036854775807L;
    }

    public final void render(long j, long j2) {
        final WeakCache weakCache = this.frameRenderer;
        DefaultVideoSink defaultVideoSink = (DefaultVideoSink) weakCache.referenceQueue;
        while (true) {
            LongArrayQueue longArrayQueue = this.presentationTimestampsUs;
            int i = longArrayQueue.size;
            if (i == 0) {
                return;
            }
            if (i == 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
                return;
            }
            long j3 = ((long[]) longArrayQueue.data)[longArrayQueue.headIndex];
            Long l = (Long) this.streamStartPositionsUs.pollFloor(j3);
            VideoFrameReleaseControl videoFrameReleaseControl = this.videoFrameReleaseControl;
            if (l != null && l.longValue() != this.outputStreamStartPositionUs) {
                this.outputStreamStartPositionUs = l.longValue();
                videoFrameReleaseControl.onStreamChanged(2);
            }
            long j4 = this.outputStreamStartPositionUs;
            VideoFrameReleaseControl videoFrameReleaseControl2 = this.videoFrameReleaseControl;
            EocdRecord eocdRecord = this.videoFrameReleaseInfo;
            int frameReleaseAction = videoFrameReleaseControl2.getFrameReleaseAction(j3, j, j2, j4, false, false, eocdRecord);
            if (frameReleaseAction != 5 && frameReleaseAction != 4) {
                this.videoFrameReleaseEarlyTimeForecaster.onVideoFrameProcessed(j3, eocdRecord.entryCount);
            }
            final byte b = 0;
            final byte b2 = 1;
            if (frameReleaseAction == 0 || frameReleaseAction == 1) {
                this.latestOutputPresentationTimeUs = j3;
                boolean z = frameReleaseAction == 0;
                long jRemove = longArrayQueue.remove();
                VideoSize videoSize = (VideoSize) this.videoSizes.pollFloor(jRemove);
                if (videoSize != null && !videoSize.equals(VideoSize.UNKNOWN) && !videoSize.equals(this.outputVideoSize)) {
                    this.outputVideoSize = videoSize;
                    Format.Builder builder = new Format.Builder();
                    builder.width = videoSize.width;
                    builder.height = videoSize.height;
                    builder.sampleMimeType = MimeTypes.normalizeMimeType("video/raw");
                    weakCache.values = new Format(builder);
                    defaultVideoSink.listenerExecutor.execute(new ComponentActivity$$ExternalSyntheticLambda10(weakCache, videoSize, (byte) 29));
                }
                long jNanoTime = z ? System.nanoTime() : eocdRecord.centralDirectoryOffset;
                b2 = videoFrameReleaseControl.firstFrameState == 3 ? (byte) 0 : (byte) 1;
                videoFrameReleaseControl.firstFrameState = 3;
                videoFrameReleaseControl.clock.getClass();
                videoFrameReleaseControl.lastReleaseRealtimeUs = Util.msToUs(SystemClock.elapsedRealtime());
                if (b2 != 0 && defaultVideoSink.outputSurface != null) {
                    defaultVideoSink.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.DefaultVideoSink$FrameRendererImpl$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            byte b3 = b;
                            WeakCache weakCache2 = weakCache;
                            switch (b3) {
                                case 0:
                                    ((DefaultVideoSink) weakCache2.referenceQueue).listener.onFirstFrameRendered();
                                    break;
                                default:
                                    ((DefaultVideoSink) weakCache2.referenceQueue).listener.onFrameDropped();
                                    break;
                            }
                        }
                    });
                }
                Format format = (Format) weakCache.values;
                defaultVideoSink.videoFrameMetadataListener.onVideoFrameAboutToBeRendered(jRemove, jNanoTime, format == null ? new Format(new Format.Builder()) : format, null);
                MediaCodecVideoRenderer.AnonymousClass2 anonymousClass2 = (MediaCodecVideoRenderer.AnonymousClass2) defaultVideoSink.videoFrameHandlers.remove();
                MediaCodecVideoRenderer.this.renderOutputBufferV21(anonymousClass2.val$codec, anonymousClass2.val$bufferIndex, jNanoTime);
            } else if (frameReleaseAction == 2 || frameReleaseAction == 3) {
                this.latestOutputPresentationTimeUs = j3;
                longArrayQueue.remove();
                defaultVideoSink.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.exoplayer.video.DefaultVideoSink$FrameRendererImpl$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        byte b3 = b2;
                        WeakCache weakCache2 = weakCache;
                        switch (b3) {
                            case 0:
                                ((DefaultVideoSink) weakCache2.referenceQueue).listener.onFirstFrameRendered();
                                break;
                            default:
                                ((DefaultVideoSink) weakCache2.referenceQueue).listener.onFrameDropped();
                                break;
                        }
                    }
                });
                MediaCodecVideoRenderer.AnonymousClass2 anonymousClass3 = (MediaCodecVideoRenderer.AnonymousClass2) defaultVideoSink.videoFrameHandlers.remove();
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                MediaCodecAdapter mediaCodecAdapter = anonymousClass3.val$codec;
                int i2 = anonymousClass3.val$bufferIndex;
                Trace.beginSection("dropVideoBuffer");
                mediaCodecAdapter.releaseOutputBuffer(i2);
                Trace.endSection();
                mediaCodecVideoRenderer.updateDroppedBufferCounters(0, 1);
            } else {
                if (frameReleaseAction != 4) {
                    if (frameReleaseAction == 5) {
                        return;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2(String.valueOf(frameReleaseAction));
                    return;
                }
                this.latestOutputPresentationTimeUs = j3;
            }
        }
    }
}
