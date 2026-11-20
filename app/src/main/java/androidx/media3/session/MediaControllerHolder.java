package androidx.media3.session;

import android.os.Handler;
import android.os.Looper;
import com.google.common.util.concurrent.AbstractFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerHolder extends AbstractFuture {
    public boolean accepted;
    public MediaController controller;
    public final Handler handler;

    public MediaControllerHolder(Looper looper) {
        this.handler = new Handler(looper);
    }
}
