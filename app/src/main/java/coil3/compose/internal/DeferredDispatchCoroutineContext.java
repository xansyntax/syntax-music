package coil3.compose.internal;

import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeferredDispatchCoroutineContext implements CoroutineContext {
    public final CoroutineContext delegate;

    public DeferredDispatchCoroutineContext(CoroutineContext coroutineContext) {
        this.delegate = coroutineContext;
    }

    public final boolean equals(Object obj) {
        return Intrinsics.areEqual(this.delegate, obj);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return this.delegate.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.delegate.get(key);
    }

    public final int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        CoroutineContext coroutineContextMinusKey = this.delegate.minusKey(key);
        int i = UtilsKt.$r8$clinit;
        ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
        CoroutineContext.Element element = get(continuationInterceptor$Key);
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        CoroutineContext.Element element2 = coroutineContextMinusKey.get(continuationInterceptor$Key);
        CoroutineDispatcher coroutineDispatcher2 = element2 instanceof CoroutineDispatcher ? (CoroutineDispatcher) element2 : null;
        if ((coroutineDispatcher instanceof DeferredDispatchCoroutineDispatcher) && coroutineDispatcher != coroutineDispatcher2) {
            ((DeferredDispatchCoroutineDispatcher) coroutineDispatcher)._unconfined$volatile = 0;
        }
        return new DeferredDispatchCoroutineContext(coroutineContextMinusKey);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextPlus = this.delegate.plus(coroutineContext);
        int i = UtilsKt.$r8$clinit;
        ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
        CoroutineContext.Element element = get(continuationInterceptor$Key);
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        CoroutineContext.Element element2 = coroutineContextPlus.get(continuationInterceptor$Key);
        CoroutineDispatcher coroutineDispatcher2 = element2 instanceof CoroutineDispatcher ? (CoroutineDispatcher) element2 : null;
        if ((coroutineDispatcher instanceof DeferredDispatchCoroutineDispatcher) && coroutineDispatcher != coroutineDispatcher2) {
            ((DeferredDispatchCoroutineDispatcher) coroutineDispatcher)._unconfined$volatile = 0;
        }
        return new DeferredDispatchCoroutineContext(coroutineContextPlus);
    }

    public final String toString() {
        return "ForwardingCoroutineContext(delegate=" + this.delegate + ")";
    }
}
