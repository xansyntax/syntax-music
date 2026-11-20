package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda10;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.room.TransactionExecutor$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioRendererEventListener$EventDispatcher {
    public final Handler handler;
    public final ExoPlayerImpl.ComponentListener listener;

    public AudioRendererEventListener$EventDispatcher(Handler handler, ExoPlayerImpl.ComponentListener componentListener, byte b) {
        switch (b) {
            case 1:
                if (componentListener != null) {
                    handler.getClass();
                } else {
                    handler = null;
                }
                this.handler = handler;
                this.listener = componentListener;
                break;
            default:
                this.handler = handler;
                this.listener = componentListener;
                break;
        }
    }

    public void disabled(DecoderCounters decoderCounters) {
        synchronized (decoderCounters) {
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new ComponentActivity$$ExternalSyntheticLambda10(this, decoderCounters, (byte) 19));
        }
    }

    public void videoSizeChanged(VideoSize videoSize) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new TransactionExecutor$$ExternalSyntheticLambda0((Object) this, (Object) videoSize, (byte) 2));
        }
    }
}
