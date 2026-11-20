package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "request", "Lio/ktor/client/request/HttpRequest;", "cause"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$4", f = "HttpCallValidator.kt", l = {156}, m = "invokeSuspend", v = 1)
public final class HttpCallValidatorKt$HttpCallValidator$2$4 extends SuspendLambda implements Function3 {
    final /* synthetic */ List<HandlerWrapper> $callExceptionHandlers;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidatorKt$HttpCallValidator$2$4(List<? extends HandlerWrapper> list, Continuation continuation) {
        super(3, continuation);
        this.$callExceptionHandlers = list;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequest httpRequest, Throwable th, Continuation continuation) {
        HttpCallValidatorKt$HttpCallValidator$2$4 httpCallValidatorKt$HttpCallValidator$2$4 = new HttpCallValidatorKt$HttpCallValidator$2$4(this.$callExceptionHandlers, continuation);
        httpCallValidatorKt$HttpCallValidator$2$4.L$0 = httpRequest;
        httpCallValidatorKt$HttpCallValidator$2$4.L$1 = th;
        return httpCallValidatorKt$HttpCallValidator$2$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpRequest httpRequest = (HttpRequest) this.L$0;
        Throwable th = (Throwable) this.L$1;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Throwable th2 = (Throwable) this.L$2;
            ResultKt.throwOnFailure(obj);
            return th2;
        }
        ResultKt.throwOnFailure(obj);
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        List<HandlerWrapper> list = this.$callExceptionHandlers;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = thUnwrapCancellationException;
        this.label = 1;
        Object objHttpCallValidator$lambda$0$processException = HttpCallValidatorKt.HttpCallValidator$lambda$0$processException(list, thUnwrapCancellationException, httpRequest, this);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objHttpCallValidator$lambda$0$processException == coroutineSingletons ? coroutineSingletons : thUnwrapCancellationException;
    }
}
