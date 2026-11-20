package io.ktor.client.plugins.observer;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverConfig$responseHandler$1", f = "ResponseObserver.kt", l = {}, m = "invokeSuspend", v = 1)
public final class ResponseObserverConfig$responseHandler$1 extends SuspendLambda implements Function2 {
    int label;

    public ResponseObserverConfig$responseHandler$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ResponseObserverConfig$responseHandler$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation continuation) {
        return ((ResponseObserverConfig$responseHandler$1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
