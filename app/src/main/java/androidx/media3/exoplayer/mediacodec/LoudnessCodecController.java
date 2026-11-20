package androidx.media3.exoplayer.mediacodec;

import android.media.LoudnessCodecController$OnLoudnessCodecUpdateListener;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import coil3.util.UtilsKt;
import com.google.common.util.concurrent.DirectExecutor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoudnessCodecController implements MediaCodecAdapter {
    public final /* synthetic */ byte $r8$classId;
    public Object loudnessCodecController;
    public final Object mediaCodecs;

    public LoudnessCodecController(MediaCodec mediaCodec, LoudnessCodecController loudnessCodecController) {
        this.$r8$classId = (byte) 1;
        this.mediaCodecs = mediaCodec;
        this.loudnessCodecController = loudnessCodecController;
        if (Build.VERSION.SDK_INT < 35 || loudnessCodecController == null) {
            return;
        }
        loudnessCodecController.addMediaCodec(mediaCodec);
    }

    public void addMediaCodec(MediaCodec mediaCodec) {
        android.media.LoudnessCodecController loudnessCodecController = (android.media.LoudnessCodecController) this.loudnessCodecController;
        if (loudnessCodecController == null || loudnessCodecController.addMediaCodec(mediaCodec)) {
            UtilsKt.checkState(((HashSet) this.mediaCodecs).add(mediaCodec));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        return ((MediaCodec) this.mediaCodecs).dequeueInputBuffer(0L);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = ((MediaCodec) this.mediaCodecs).dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void detachOutputSurface() {
        ((MediaCodec) this.mediaCodecs).detachOutputSurface();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void flush() {
        ((MediaCodec) this.mediaCodecs).flush();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer getInputBuffer(int i) {
        return ((MediaCodec) this.mediaCodecs).getInputBuffer(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public ByteBuffer getOutputBuffer(int i) {
        return ((MediaCodec) this.mediaCodecs).getOutputBuffer(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        return ((MediaCodec) this.mediaCodecs).getOutputFormat();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j) {
        ((MediaCodec) this.mediaCodecs).queueInputBuffer(i, 0, i2, j, i3);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2) {
        ((MediaCodec) this.mediaCodecs).queueSecureInputBuffer(i, 0, cryptoInfo.frameworkCryptoInfo, j, i2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public final void release() {
        byte b = this.$r8$classId;
        Object obj = this.mediaCodecs;
        switch (b) {
            case 0:
                ((HashSet) obj).clear();
                android.media.LoudnessCodecController loudnessCodecController = (android.media.LoudnessCodecController) this.loudnessCodecController;
                if (loudnessCodecController != null) {
                    loudnessCodecController.close();
                    return;
                }
                return;
            default:
                LoudnessCodecController loudnessCodecController2 = (LoudnessCodecController) this.loudnessCodecController;
                MediaCodec mediaCodec = (MediaCodec) obj;
                try {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 30 && i < 33) {
                        mediaCodec.stop();
                        break;
                    }
                    return;
                } finally {
                    if (Build.VERSION.SDK_INT >= 35 && loudnessCodecController2 != null) {
                        loudnessCodecController2.removeMediaCodec(mediaCodec);
                    }
                    mediaCodec.release();
                }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void releaseOutputBuffer(int i) {
        ((MediaCodec) this.mediaCodecs).releaseOutputBuffer(i, false);
    }

    public void removeMediaCodec(MediaCodec mediaCodec) {
        android.media.LoudnessCodecController loudnessCodecController;
        if (!((HashSet) this.mediaCodecs).remove(mediaCodec) || (loudnessCodecController = (android.media.LoudnessCodecController) this.loudnessCodecController) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void setAudioSessionId(int i) {
        android.media.LoudnessCodecController loudnessCodecController = (android.media.LoudnessCodecController) this.loudnessCodecController;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.loudnessCodecController = null;
        }
        android.media.LoudnessCodecController loudnessCodecControllerCreate = android.media.LoudnessCodecController.create(i, DirectExecutor.INSTANCE, new AnonymousClass1());
        this.loudnessCodecController = loudnessCodecControllerCreate;
        Iterator it = ((HashSet) this.mediaCodecs).iterator();
        while (it.hasNext()) {
            if (!loudnessCodecControllerCreate.addMediaCodec((MediaCodec) it.next())) {
                it.remove();
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void setOnFrameRenderedListener(MediaCodecVideoRenderer.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        ((MediaCodec) this.mediaCodecs).setOnFrameRenderedListener(new SynchronousMediaCodecAdapter$$ExternalSyntheticLambda0(this, onFrameRenderedListener, (byte) 0), handler);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void setOutputSurface(Surface surface) {
        ((MediaCodec) this.mediaCodecs).setOutputSurface(surface);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void setParameters(Bundle bundle) {
        ((MediaCodec) this.mediaCodecs).setParameters(bundle);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void setVideoScalingMode(int i) {
        ((MediaCodec) this.mediaCodecs).setVideoScalingMode(i);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void subscribeToVendorParameters(ArrayList arrayList) {
        ((MediaCodec) this.mediaCodecs).subscribeToVendorParameters(arrayList);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void unsubscribeFromVendorParameters(ArrayList arrayList) {
        ((MediaCodec) this.mediaCodecs).unsubscribeFromVendorParameters(arrayList);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter
    public void releaseOutputBuffer(int i, long j) {
        ((MediaCodec) this.mediaCodecs).releaseOutputBuffer(i, j);
    }

    public LoudnessCodecController() {
        this.$r8$classId = (byte) 0;
        this.mediaCodecs = new HashSet();
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.mediacodec.LoudnessCodecController$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements LoudnessCodecController$OnLoudnessCodecUpdateListener {
        public final Bundle onLoudnessCodecUpdate(MediaCodec mediaCodec, Bundle bundle) {
            return bundle;
        }
    }
}
