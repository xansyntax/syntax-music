package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.sqlite.SQLite;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ CompositionErrorContextImpl $traceContext$inlined;
    public final /* synthetic */ RememberedCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(CompositionErrorContextImpl compositionErrorContextImpl, RememberedCoroutineScope rememberedCoroutineScope) {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
        this.$traceContext$inlined = compositionErrorContextImpl;
        this.this$0 = rememberedCoroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) throws Throwable {
        CompositionErrorContextImpl compositionErrorContextImpl = this.$traceContext$inlined;
        RememberedCoroutineScope rememberedCoroutineScope = this.this$0;
        SQLite.tryAttachComposeStackTrace(new Recomposer$$ExternalSyntheticLambda6((Object) compositionErrorContextImpl, (Object) rememberedCoroutineScope, (byte) 24), th);
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) rememberedCoroutineScope.parentContext.get(CoroutineExceptionHandler.Key.$$INSTANCE);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.handleException(coroutineContext, th);
    }
}
