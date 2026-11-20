package androidx.compose.runtime;

import androidx.compose.animation.core.MutationInterruptedException;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RememberedCoroutineScope implements CoroutineScope, RememberObserver {
    public static final CancelledCoroutineContext CancelledCoroutineContext = new CancelledCoroutineContext();
    public volatile CoroutineContext _coroutineContext;
    public final RememberedCoroutineScope lock = this;
    public final CoroutineContext parentContext;

    public RememberedCoroutineScope(CoroutineContext coroutineContext) {
        this.parentContext = coroutineContext;
    }

    public final void cancelIfCreated() {
        synchronized (this.lock) {
            try {
                CoroutineContext coroutineContext = this._coroutineContext;
                if (coroutineContext == null) {
                    this._coroutineContext = CancelledCoroutineContext;
                } else {
                    AwaitKt.cancel(coroutineContext, new MutationInterruptedException());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        CoroutineContext coroutineContextPlus;
        CoroutineContext coroutineContext = this._coroutineContext;
        if (coroutineContext == null || coroutineContext == CancelledCoroutineContext) {
            CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) this.parentContext.get(CompositionErrorContextImpl.Key);
            CoroutineContext rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 = compositionErrorContextImpl != null ? new RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(compositionErrorContextImpl, this) : EmptyCoroutineContext.INSTANCE;
            synchronized (this.lock) {
                try {
                    CoroutineContext coroutineContext2 = this._coroutineContext;
                    if (coroutineContext2 == null) {
                        CoroutineContext coroutineContext3 = this.parentContext;
                        coroutineContextPlus = coroutineContext3.plus(new JobImpl((Job) coroutineContext3.get(Job.Key.$$INSTANCE))).plus(EmptyCoroutineContext.INSTANCE).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                    } else if (coroutineContext2 == CancelledCoroutineContext) {
                        CoroutineContext coroutineContext4 = this.parentContext;
                        JobImpl jobImpl = new JobImpl((Job) coroutineContext4.get(Job.Key.$$INSTANCE));
                        jobImpl.cancelImpl$kotlinx_coroutines_core(new MutationInterruptedException());
                        coroutineContextPlus = coroutineContext4.plus(jobImpl).plus(EmptyCoroutineContext.INSTANCE).plus(rememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1);
                    } else {
                        coroutineContextPlus = coroutineContext2;
                    }
                    this._coroutineContext = coroutineContextPlus;
                } catch (Throwable th) {
                    throw th;
                }
            }
            coroutineContext = coroutineContextPlus;
        }
        coroutineContext.getClass();
        return coroutineContext;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
