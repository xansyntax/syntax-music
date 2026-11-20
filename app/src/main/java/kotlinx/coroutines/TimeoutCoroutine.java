package kotlinx.coroutines;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeoutCoroutine extends ScopeCoroutine implements Runnable {
    public final long time;

    public TimeoutCoroutine(long j, ContinuationImpl continuationImpl) {
        super(continuationImpl, continuationImpl.getContext());
        this.time = j;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport
    public final String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.time + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        CoroutineContext coroutineContext = this.context;
        AwaitKt.getDelay(coroutineContext);
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        String str = coroutineName != null ? coroutineName.name : null;
        String strM = IntIntPair$$ExternalSyntheticOutline0.m(this.time, "Timed out waiting for ", " ms");
        if (str != null) {
            StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Coroutine \"", str, "\" ");
            if (strM.length() > 0) {
                strM = Character.toLowerCase(strM.charAt(0)) + strM.substring(1);
            }
            sbM4m.append(strM);
            strM = sbM4m.toString();
        }
        cancelImpl$kotlinx_coroutines_core(new TimeoutCancellationException(strM, this));
    }
}
