package com.metrolist.music.utils.potoken;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/metrolist/music/utils/potoken/PoTokenWebView$special$$inlined$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PoTokenWebView$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ PoTokenWebView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenWebView$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, PoTokenWebView poTokenWebView) {
        super(key);
        this.this$0 = poTokenWebView;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        this.this$0.onInitializationErrorCloseAndCancel(exception);
    }
}
