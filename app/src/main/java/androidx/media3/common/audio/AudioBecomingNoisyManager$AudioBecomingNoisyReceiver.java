package androidx.media3.common.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.Latch;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.exoplayer.ExoPlayerImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioBecomingNoisyManager$AudioBecomingNoisyReceiver extends BroadcastReceiver {
    public final SystemHandlerWrapper eventHandler;
    public final ExoPlayerImpl.ComponentListener listener;
    public final /* synthetic */ Latch this$0;

    public AudioBecomingNoisyManager$AudioBecomingNoisyReceiver(Latch latch, SystemHandlerWrapper systemHandlerWrapper, ExoPlayerImpl.ComponentListener componentListener) {
        this.this$0 = latch;
        this.eventHandler = systemHandlerWrapper;
        this.listener = componentListener;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.eventHandler.post(new ActivityCompat$$ExternalSyntheticLambda0((byte) 13, this));
        }
    }
}
