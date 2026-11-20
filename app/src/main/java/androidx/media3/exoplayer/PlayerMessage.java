package androidx.media3.exoplayer;

import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Log;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlayerMessage {
    public boolean isCanceled;
    public boolean isSent;
    public Looper looper;
    public final int mediaItemIndex;
    public Object payload;
    public long positionMs = -9223372036854775807L;
    public final ExoPlayerImplInternal sender;
    public final Target target;
    public final Timeline timeline;
    public byte type;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Target {
        void handleMessage(int i, Object obj);
    }

    public PlayerMessage(ExoPlayerImplInternal exoPlayerImplInternal, Target target, Timeline timeline, int i, Looper looper) {
        this.sender = exoPlayerImplInternal;
        this.target = target;
        this.timeline = timeline;
        this.looper = looper;
        this.mediaItemIndex = i;
    }

    public final synchronized void cancel() {
        UtilsKt.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
    }

    public final synchronized void markAsProcessed(boolean z) {
        notifyAll();
    }

    public final void send() {
        UtilsKt.checkState(!this.isSent);
        this.isSent = true;
        ExoPlayerImplInternal exoPlayerImplInternal = this.sender;
        if (!exoPlayerImplInternal.releasedOnApplicationThread && exoPlayerImplInternal.playbackLooper.getThread().isAlive()) {
            exoPlayerImplInternal.handler.obtainMessage(14, this).sendToTarget();
        } else {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            markAsProcessed(false);
        }
    }
}
