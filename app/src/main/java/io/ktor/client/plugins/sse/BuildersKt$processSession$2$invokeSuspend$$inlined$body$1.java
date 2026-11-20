package io.ktor.client.plugins.sse;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2$invokeSuspend$$inlined$body$1", f = "builders.kt", l = {250}, m = "invokeSuspend", v = 1)
public final class BuildersKt$processSession$2$invokeSuspend$$inlined$body$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ HttpResponse $response;
    final /* synthetic */ CompletableDeferred $sessionDeferred$inlined;
    int I$0;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$processSession$2$invokeSuspend$$inlined$body$1(HttpResponse httpResponse, Continuation continuation, CompletableDeferred completableDeferred) {
        super(2, continuation);
        this.$response = httpResponse;
        this.$sessionDeferred$inlined = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BuildersKt$processSession$2$invokeSuspend$$inlined$body$1(this.$response, continuation, this.$sessionDeferred$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BuildersKt$processSession$2$invokeSuspend$$inlined$body$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$response.getCall();
            Intrinsics.throwUndefinedForReified();
            throw null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        this.$response.getCall();
        Intrinsics.throwUndefinedForReified();
        throw null;
    }
}
