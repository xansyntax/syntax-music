package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemClock {
    public static final SystemClock DEFAULT = new SystemClock();

    public final SystemHandlerWrapper createHandler(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }
}
