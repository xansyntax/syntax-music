package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "requestJob", "Lkotlinx/coroutines/Job;", "clientEngineJob", "", "attachToClientEngineJob", "(Lkotlinx/coroutines/CompletableJob;Lkotlinx/coroutines/Job;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestLifecycle", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestLifecycle", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestLifecycleKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestLifecycle");
    private static final ClientPlugin<Unit> HttpRequestLifecycle = CreatePluginUtilsKt.createClientPlugin("RequestLifecycle", new UserAgentKt$$ExternalSyntheticLambda0(9));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestLifecycle$lambda$0(ClientPluginBuilder clientPluginBuilder) {
        clientPluginBuilder.getClass();
        clientPluginBuilder.on(SetupRequestContext.INSTANCE, new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(clientPluginBuilder, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void attachToClientEngineJob(CompletableJob completableJob, Job job) {
        DisposableHandle disposableHandleInvokeOnCompletion = job.invokeOnCompletion(new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 4, completableJob));
        ((JobSupport) completableJob).invokeOnCompletion(new HttpTimeoutKt$$ExternalSyntheticLambda1((byte) 5, disposableHandleInvokeOnCompletion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit attachToClientEngineJob$lambda$0(CompletableJob completableJob, Throwable th) {
        if (th != null) {
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Cancelling request because engine Job failed with error", th);
            }
            ((JobSupport) completableJob).cancel(AwaitKt.CancellationException("Engine failed", th));
        } else {
            LOGGER.trace("Cancelling request because engine Job completed");
            ((JobImpl) completableJob).complete$1();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToClientEngineJob$lambda$1(DisposableHandle disposableHandle, Throwable th) {
        disposableHandle.dispose();
        return Unit.INSTANCE;
    }

    public static final ClientPlugin<Unit> getHttpRequestLifecycle() {
        return HttpRequestLifecycle;
    }
}
