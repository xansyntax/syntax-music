package io.ktor.client.statement;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$2$1", f = "HttpStatement.kt", l = {74}, m = "invokeSuspend", v = 1)
public final class HttpStatement$execute$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ HttpResponse $response;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpStatement$execute$2$1(Function2 function2, HttpResponse httpResponse, Continuation continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$response = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpStatement$execute$2$1(this.$block, this.$response, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpStatement$execute$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        Function2 function2 = this.$block;
        HttpResponse httpResponse = this.$response;
        this.label = 1;
        Object objInvoke = function2.invoke(httpResponse, this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
