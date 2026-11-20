package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MutableLiveData extends LiveData {
    public final void setValue(Object obj) {
        ArchTaskExecutor.getInstance().getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot invoke setValue on a background thread");
            return;
        }
        this.mData = obj;
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            SafeIterableMap safeIterableMap = this.mObservers;
            SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
            iteratorWithAdditions.mBeforeStart = true;
            safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }
}
