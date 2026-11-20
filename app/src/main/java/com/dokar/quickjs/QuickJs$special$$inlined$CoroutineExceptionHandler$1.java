package com.dokar.quickjs;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickJs$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public final /* synthetic */ QuickJs this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJs$special$$inlined$CoroutineExceptionHandler$1(QuickJs quickJs) {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
        this.this$0 = quickJs;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        QuickJs quickJs = this.this$0;
        if (quickJs.evalException == null) {
            quickJs.evalException = th;
        }
    }
}
