package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpTimeoutKt$applyRequestTimeout$killer$1", f = "HttpTimeout.kt", l = {183}, m = "invokeSuspend", v = 1)
public final class HttpTimeoutKt$applyRequestTimeout$killer$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Job $executionContext;
    final /* synthetic */ HttpRequestBuilder $request;
    final /* synthetic */ Long $requestTimeout;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTimeoutKt$applyRequestTimeout$killer$1(Long l, HttpRequestBuilder httpRequestBuilder, Job job, Continuation continuation) {
        super(2, continuation);
        this.$requestTimeout = l;
        this.$request = httpRequestBuilder;
        this.$executionContext = job;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HttpTimeoutKt$applyRequestTimeout$killer$1(this.$requestTimeout, this.$request, this.$executionContext, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HttpTimeoutKt$applyRequestTimeout$killer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Path.Companion companion = Duration.Companion;
            long duration = InstantKt.toDuration(this.$requestTimeout.longValue(), DurationUnit.MILLISECONDS);
            this.label = 1;
            Object objM1897delayVtjQ1oo = AwaitKt.m1897delayVtjQ1oo(duration, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1897delayVtjQ1oo == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpRequestTimeoutException httpRequestTimeoutException = new HttpRequestTimeoutException(this.$request);
        Logger logger = HttpTimeoutKt.LOGGER;
        HttpRequestBuilder httpRequestBuilder = this.$request;
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            logger.trace("Request timeout: " + httpRequestBuilder.getUrl());
        }
        Job job = this.$executionContext;
        String message = httpRequestTimeoutException.getMessage();
        message.getClass();
        job.cancel(AwaitKt.CancellationException(message, httpRequestTimeoutException));
        return Unit.INSTANCE;
    }
}
