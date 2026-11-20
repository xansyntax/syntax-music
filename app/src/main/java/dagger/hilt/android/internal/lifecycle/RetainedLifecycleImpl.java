package dagger.hilt.android.internal.lifecycle;

import android.os.Looper;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.text.HexFormatKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RetainedLifecycleImpl {
    public final HashSet listeners = new HashSet();

    public final void dispatchOnCleared() {
        if (HexFormatKt.mainThread == null) {
            HexFormatKt.mainThread = Looper.getMainLooper().getThread();
        }
        if (Thread.currentThread() != HexFormatKt.mainThread) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Must be called on the Main thread.");
            return;
        }
        Iterator it = this.listeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }
}
