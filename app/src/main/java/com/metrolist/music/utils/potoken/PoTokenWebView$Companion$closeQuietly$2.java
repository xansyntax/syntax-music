package com.metrolist.music.utils.potoken;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
@DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenWebView$Companion$closeQuietly$2", f = "PoTokenWebView.kt", l = {}, m = "invokeSuspend", v = 2)
public final class PoTokenWebView$Companion$closeQuietly$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ PoTokenWebView $potWv;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenWebView$Companion$closeQuietly$2(PoTokenWebView poTokenWebView, Continuation continuation) {
        super(2, continuation);
        this.$potWv = poTokenWebView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PoTokenWebView$Companion$closeQuietly$2(this.$potWv, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PoTokenWebView$Companion$closeQuietly$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.$potWv.initResumed.set(true);
        this.$potWv.close();
        return Unit.INSTANCE;
    }
}
