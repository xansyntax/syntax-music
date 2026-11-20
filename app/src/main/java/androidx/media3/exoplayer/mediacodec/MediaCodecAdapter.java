package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.datastore.core.AtomicInt;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import com.materialkolor.quantize.QuantizerWu;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaCodecAdapter {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Factory {
        MediaCodecAdapter createAdapter(QuantizerWu quantizerWu);
    }

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void detachOutputSurface();

    void flush();

    ByteBuffer getInputBuffer(int i);

    ByteBuffer getOutputBuffer(int i);

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i, int i2, int i3, long j);

    void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2);

    default boolean registerOnBufferAvailableListener(AtomicInt atomicInt) {
        return false;
    }

    void release();

    void releaseOutputBuffer(int i);

    void releaseOutputBuffer(int i, long j);

    void setOnFrameRenderedListener(MediaCodecVideoRenderer.OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void setOutputSurface(Surface surface);

    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i);

    void subscribeToVendorParameters(ArrayList arrayList);

    void unsubscribeFromVendorParameters(ArrayList arrayList);

    default void useInputBuffer(ComponentActivity$$ExternalSyntheticLambda10 componentActivity$$ExternalSyntheticLambda10) {
        componentActivity$$ExternalSyntheticLambda10.run();
    }
}
