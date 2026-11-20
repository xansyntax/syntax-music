package io.ktor.client.plugins.sse;

import io.ktor.util.logging.LoggerJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/sse/ServerSentEvent;", "cause", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$2", f = "DefaultClientSSESession.kt", l = {}, m = "invokeSuspend", v = 1)
public final class DefaultClientSSESession$_incoming$2 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;

    public DefaultClientSSESession$_incoming$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
        DefaultClientSSESession$_incoming$2 defaultClientSSESession$_incoming$2 = new DefaultClientSSESession$_incoming$2(continuation);
        defaultClientSSESession$_incoming$2.L$0 = th;
        return defaultClientSSESession$_incoming$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th = (Throwable) this.L$0;
        if (this.label != 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (th instanceof CancellationException) {
            return Unit.INSTANCE;
        }
        Logger logger = SSEKt.getLOGGER();
        if (!LoggerJvmKt.isTraceEnabled(logger)) {
            throw th;
        }
        logger.trace("Error during SSE session processing: " + th);
        throw th;
    }
}
