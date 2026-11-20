package androidx.compose.runtime;

import androidx.compose.animation.core.MutationInterruptedException;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.sqlite.SQLite;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LaunchedEffectImpl implements RememberObserver, CoroutineExceptionHandler {
    public StandaloneCoroutine job;
    public final CoroutineContext parentCoroutineContext;
    public final ContextScope scope;
    public final Function2 task;

    public LaunchedEffectImpl(CoroutineContext coroutineContext, Function2 function2) {
        this.parentCoroutineContext = coroutineContext;
        this.task = function2;
        this.scope = AwaitKt.CoroutineScope(coroutineContext.plus(this));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return CoroutineExceptionHandler.Key.$$INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) throws Throwable {
        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) coroutineContext.get(CompositionErrorContextImpl.Key);
        if (compositionErrorContextImpl != null) {
            SQLite.tryAttachComposeStackTrace(new Recomposer$$ExternalSyntheticLambda6((Object) compositionErrorContextImpl, (Object) this, (byte) 24), th);
        }
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) this.parentCoroutineContext.get(CoroutineExceptionHandler.Key.$$INSTANCE);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.handleException(coroutineContext, th);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new MutationInterruptedException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancelInternal(new MutationInterruptedException());
        }
        this.job = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        StandaloneCoroutine standaloneCoroutine = this.job;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(AwaitKt.CancellationException("Old job was still running!", null));
        }
        this.job = AwaitKt.launch$default(this.scope, null, null, this.task, 3);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
