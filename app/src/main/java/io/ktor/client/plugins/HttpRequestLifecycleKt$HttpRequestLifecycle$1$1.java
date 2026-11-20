package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.SupervisorJobImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", "", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "proceed", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestLifecycleKt$HttpRequestLifecycle$1$1", f = "HttpRequestLifecycle.kt", l = {29}, m = "invokeSuspend", v = 1)
public final class HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ ClientPluginBuilder<Unit> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(ClientPluginBuilder<Unit> clientPluginBuilder, Continuation continuation) {
        super(3, continuation);
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, Function1 function1, Continuation continuation) {
        HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 httpRequestLifecycleKt$HttpRequestLifecycle$1$1 = new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(this.$this_createClientPlugin, continuation);
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$0 = httpRequestBuilder;
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$1 = function1;
        return httpRequestLifecycleKt$HttpRequestLifecycle$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CompletableJob completableJob;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        Function1 function1 = (Function1) this.L$1;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            completableJob = (CompletableJob) this.L$2;
            try {
                ResultKt.throwOnFailure(obj);
                ((JobImpl) completableJob).complete$1();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                try {
                    ((JobImpl) completableJob).completeExceptionally(th);
                    throw th;
                } catch (Throwable th2) {
                    ((JobImpl) completableJob).complete$1();
                    throw th2;
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        SupervisorJobImpl supervisorJobImpl = new SupervisorJobImpl(httpRequestBuilder.getExecutionContext());
        CoroutineContext.Element element = this.$this_createClientPlugin.getClient().getCoroutineContext().get(Job.Key.$$INSTANCE);
        element.getClass();
        HttpRequestLifecycleKt.attachToClientEngineJob(supervisorJobImpl, (Job) element);
        try {
            httpRequestBuilder.setExecutionContext$ktor_client_core(supervisorJobImpl);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = supervisorJobImpl;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objInvoke == coroutineSingletons) {
                return coroutineSingletons;
            }
            completableJob = supervisorJobImpl;
            ((JobImpl) completableJob).complete$1();
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            th = th3;
            completableJob = supervisorJobImpl;
            ((JobImpl) completableJob).completeExceptionally(th);
            throw th;
        }
    }
}
