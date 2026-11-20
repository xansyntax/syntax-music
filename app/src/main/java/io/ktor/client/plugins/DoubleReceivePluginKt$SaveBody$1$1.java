package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.Attributes;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DoubleReceivePluginKt$SaveBody$1$1", f = "SaveBody.kt", l = {45, 54}, m = "invokeSuspend", v = 1)
public final class DoubleReceivePluginKt$SaveBody$1$1 extends SuspendLambda implements Function3 {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public DoubleReceivePluginKt$SaveBody$1$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation continuation) {
        DoubleReceivePluginKt$SaveBody$1$1 doubleReceivePluginKt$SaveBody$1$1 = new DoubleReceivePluginKt$SaveBody$1$1(continuation);
        doubleReceivePluginKt$SaveBody$1$1.L$0 = pipelineContext;
        doubleReceivePluginKt$SaveBody$1$1.L$1 = httpResponse;
        return doubleReceivePluginKt$SaveBody$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Attributes attributes;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        HttpResponse httpResponse = (HttpResponse) this.L$1;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i != 0) {
                if (i == 1) {
                    attributes = (Attributes) this.L$3;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            HttpClientCall call = httpResponse.getCall();
            Attributes attributes2 = call.getAttributes();
            if (attributes2.contains(DoubleReceivePluginKt.SKIP_SAVE_BODY)) {
                Logger logger = DoubleReceivePluginKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    logger.trace("Skipping body saving for " + call.getRequest().getUrl());
                }
                return unit;
            }
            Logger logger2 = DoubleReceivePluginKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Saving body for " + call.getRequest().getUrl());
            }
            this.L$0 = pipelineContext;
            this.L$1 = httpResponse;
            this.L$2 = null;
            this.L$3 = attributes2;
            this.label = 1;
            obj = SavedCallKt.save(call, this);
            if (obj != coroutineSingletons) {
                attributes = attributes2;
            }
            HttpResponse response = ((HttpClientCall) obj).getResponse();
            DoubleReceivePluginKt.tryCancelBody(httpResponse, null);
            attributes.put(DoubleReceivePluginKt.RESPONSE_BODY_SAVED, unit);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 2;
            return pipelineContext.proceedWith(response, this) == coroutineSingletons ? coroutineSingletons : unit;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                DoubleReceivePluginKt.tryCancelBody(httpResponse, th);
                throw th2;
            }
        }
    }
}
