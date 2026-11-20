package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    public final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    public final MediaCodecBufferEnqueuer bufferEnqueuer;
    public final MediaCodec codec;
    public boolean codecReleased;
    public final LoudnessCodecController loudnessCodecController;
    public byte state = 0;

    public AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, MediaCodecBufferEnqueuer mediaCodecBufferEnqueuer, LoudnessCodecController loudnessCodecController) {
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback(handlerThread);
        this.bufferEnqueuer = mediaCodecBufferEnqueuer;
        this.loudnessCodecController = loudnessCodecController;
    }

    public static String createThreadLabel(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int dequeueInputBufferIndex() {
        this.bufferEnqueuer.maybeThrowException();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        synchronized (asynchronousMediaCodecCallback.lock) {
            try {
                asynchronousMediaCodecCallback.maybeThrowException();
                int i = -1;
                if (asynchronousMediaCodecCallback.pendingFlushCount > 0 || asynchronousMediaCodecCallback.shutDown) {
                    return -1;
                }
                GapBuffer gapBuffer = asynchronousMediaCodecCallback.availableInputBuffers;
                int i2 = gapBuffer.capacity;
                int i3 = gapBuffer.gapStart;
                if (!(i2 == i3)) {
                    if (i2 == i3) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    i = ((int[]) gapBuffer.buffer)[i2];
                    gapBuffer.capacity = (i2 + 1) & gapBuffer.gapEnd;
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        this.bufferEnqueuer.maybeThrowException();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        synchronized (asynchronousMediaCodecCallback.lock) {
            try {
                asynchronousMediaCodecCallback.maybeThrowException();
                if (asynchronousMediaCodecCallback.pendingFlushCount > 0 || asynchronousMediaCodecCallback.shutDown) {
                    return -1;
                }
                GapBuffer gapBuffer = asynchronousMediaCodecCallback.availableOutputBuffers;
                int i = gapBuffer.capacity;
                int i2 = gapBuffer.gapStart;
                if (i == i2) {
                    return -1;
                }
                if (i == i2) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i3 = ((int[]) gapBuffer.buffer)[i];
                gapBuffer.capacity = gapBuffer.gapEnd & (i + 1);
                if (i3 >= 0) {
                    asynchronousMediaCodecCallback.currentFormat.getClass();
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) asynchronousMediaCodecCallback.bufferInfos.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (i3 == -2) {
                    asynchronousMediaCodecCallback.currentFormat = (MediaFormat) asynchronousMediaCodecCallback.formats.remove();
                }
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void detachOutputSurface() {
        this.codec.detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        synchronized (asynchronousMediaCodecCallback.lock) {
            asynchronousMediaCodecCallback.pendingFlushCount++;
            Handler handler = asynchronousMediaCodecCallback.handler;
            String str = Util.DEVICE_DEBUG_INFO;
            handler.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 25, (Object) asynchronousMediaCodecCallback));
        }
        this.codec.start();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer getInputBuffer(int i) {
        return this.codec.getInputBuffer(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final ByteBuffer getOutputBuffer(int i) {
        return this.codec.getOutputBuffer(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        synchronized (asynchronousMediaCodecCallback.lock) {
            try {
                mediaFormat = asynchronousMediaCodecCallback.currentFormat;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public final void initialize(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        LoudnessCodecController loudnessCodecController;
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        HandlerThread handlerThread = asynchronousMediaCodecCallback.callbackThread;
        UtilsKt.checkState(asynchronousMediaCodecCallback.handler == null);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        MediaCodec mediaCodec = this.codec;
        mediaCodec.setCallback(asynchronousMediaCodecCallback, handler);
        asynchronousMediaCodecCallback.handler = handler;
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i);
        Trace.endSection();
        this.bufferEnqueuer.start();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (loudnessCodecController = this.loudnessCodecController) != null) {
            loudnessCodecController.addMediaCodec(mediaCodec);
        }
        this.state = (byte) 1;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void queueInputBuffer(int i, int i2, int i3, long j) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, cryptoInfo, j, i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final boolean registerOnBufferAvailableListener(AtomicInt atomicInt) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        synchronized (asynchronousMediaCodecCallback.lock) {
            asynchronousMediaCodecCallback.onBufferAvailableListener = atomicInt;
        }
        return true;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void release() {
        LoudnessCodecController loudnessCodecController;
        LoudnessCodecController loudnessCodecController2;
        try {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
                synchronized (asynchronousMediaCodecCallback.lock) {
                    asynchronousMediaCodecCallback.shutDown = true;
                    asynchronousMediaCodecCallback.callbackThread.quit();
                    asynchronousMediaCodecCallback.flushInternal();
                }
            }
            this.state = (byte) 2;
            if (this.codecReleased) {
                return;
            }
            try {
                int i = Build.VERSION.SDK_INT;
                if (i >= 30 && i < 33) {
                    this.codec.stop();
                }
            } finally {
                if (Build.VERSION.SDK_INT >= 35 && (loudnessCodecController2 = this.loudnessCodecController) != null) {
                    loudnessCodecController2.removeMediaCodec(this.codec);
                }
                this.codec.release();
                this.codecReleased = true;
            }
        } catch (Throwable th) {
            if (!this.codecReleased) {
                try {
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30 && i2 < 33) {
                        this.codec.stop();
                    }
                } finally {
                    if (Build.VERSION.SDK_INT >= 35 && (loudnessCodecController = this.loudnessCodecController) != null) {
                        loudnessCodecController.removeMediaCodec(this.codec);
                    }
                    this.codec.release();
                    this.codecReleased = true;
                }
            }
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void releaseOutputBuffer(int i) {
        this.codec.releaseOutputBuffer(i, false);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void setOnFrameRenderedListener(MediaCodecVideoRenderer.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.codec.setOnFrameRenderedListener(new SynchronousMediaCodecAdapter$$ExternalSyntheticLambda0(this, onFrameRenderedListener, (byte) 1), handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void setOutputSurface(Surface surface) {
        this.codec.setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void setParameters(Bundle bundle) {
        this.bufferEnqueuer.setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void setVideoScalingMode(int i) {
        this.codec.setVideoScalingMode(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void subscribeToVendorParameters(ArrayList arrayList) {
        this.codec.subscribeToVendorParameters(arrayList);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void unsubscribeFromVendorParameters(ArrayList arrayList) {
        this.codec.unsubscribeFromVendorParameters(arrayList);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void useInputBuffer(ComponentActivity$$ExternalSyntheticLambda10 componentActivity$$ExternalSyntheticLambda10) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        ComponentActivity$$ExternalSyntheticLambda10 componentActivity$$ExternalSyntheticLambda11 = new ComponentActivity$$ExternalSyntheticLambda10(this, componentActivity$$ExternalSyntheticLambda10, (byte) 24);
        synchronized (asynchronousMediaCodecCallback.lock) {
            asynchronousMediaCodecCallback.maybeThrowException();
            componentActivity$$ExternalSyntheticLambda11.run();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void releaseOutputBuffer(int i, long j) {
        this.codec.releaseOutputBuffer(i, j);
    }
}
