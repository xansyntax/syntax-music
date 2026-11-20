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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 1328)
@DebugMetadata(c = "com.metrolist.music.utils.potoken.PoTokenGenerator$clearGenerator$2$1", f = "PoTokenGenerator.kt", l = {}, m = "invokeSuspend", v = 2)
public final class PoTokenGenerator$clearGenerator$2$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ PoTokenGenerator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoTokenGenerator$clearGenerator$2$1(PoTokenGenerator poTokenGenerator, Continuation continuation) {
        super(2, continuation);
        this.this$0 = poTokenGenerator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PoTokenGenerator$clearGenerator$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PoTokenGenerator$clearGenerator$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        PoTokenWebView poTokenWebView = this.this$0.webPoTokenGenerator;
        if (poTokenWebView == null) {
            return null;
        }
        poTokenWebView.close();
        return Unit.INSTANCE;
    }
}
