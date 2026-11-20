package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/sse/ServerSentEvent;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1", f = "DefaultClientSSESession.kt", l = {56, 62, 66}, m = "invokeSuspend", v = 1)
public final class DefaultClientSSESession$_incoming$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultClientSSESession$_incoming$1(DefaultClientSSESession defaultClientSSESession, Continuation continuation) {
        super(2, continuation);
        this.this$0 = defaultClientSSESession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$1 = new DefaultClientSSESession$_incoming$1(this.this$0, continuation);
        defaultClientSSESession$_incoming$1.L$0 = obj;
        return defaultClientSSESession$_incoming$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((DefaultClientSSESession$_incoming$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x0055 A[PHI: r8
      0x0055: PHI (r8v8 java.lang.Object) = (r8v15 java.lang.Object), (r8v0 java.lang.Object) binds: [B:18:0x0052, B:11:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0068 -> B:15:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0078 -> B:15:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008d -> B:15:0x0036). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a4 -> B:13:0x002a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L15
            goto L27
        L15:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r7)
            return r5
        L1b:
            java.lang.Object r1 = r7.L$1
            io.ktor.sse.ServerSentEvent r1 = (io.ktor.sse.ServerSentEvent) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L36
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L27:
            kotlin.ResultKt.throwOnFailure(r8)
        L2a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            kotlin.coroutines.CoroutineContext r8 = r8.getCoroutineContext()
            boolean r8 = kotlinx.coroutines.AwaitKt.isActive(r8)
            if (r8 == 0) goto La7
        L36:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            kotlin.coroutines.CoroutineContext r8 = r8.getCoroutineContext()
            boolean r8 = kotlinx.coroutines.AwaitKt.isActive(r8)
            if (r8 == 0) goto L90
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            io.ktor.utils.io.ByteReadChannel r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getInput$p(r8)
            r7.L$0 = r0
            r7.L$1 = r5
            r7.label = r4
            java.lang.Object r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$tryParseEvent(r8, r1, r7)
            if (r8 != r6) goto L55
            goto La6
        L55:
            io.ktor.sse.ServerSentEvent r8 = (io.ktor.sse.ServerSentEvent) r8
            if (r8 != 0) goto L5a
            goto L90
        L5a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r7.this$0
            boolean r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isCommentsEvent(r1, r8)
            if (r1 == 0) goto L6a
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r7.this$0
            boolean r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowCommentEvents$p(r1)
            if (r1 == 0) goto L36
        L6a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r7.this$0
            boolean r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isRetryEvent(r1, r8)
            if (r1 == 0) goto L7a
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r7.this$0
            boolean r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowRetryEvents$p(r1)
            if (r1 == 0) goto L36
        L7a:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r7.this$0
            io.ktor.client.plugins.sse.BodyBuffer r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getBodyBuffer$p(r1)
            r1.appendEvent(r8)
            r7.L$0 = r0
            r7.L$1 = r5
            r7.label = r3
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r6) goto L36
            goto La6
        L90:
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            boolean r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getNeedToReconnect$p(r8)
            if (r8 == 0) goto La7
            io.ktor.client.plugins.sse.DefaultClientSSESession r8 = r7.this$0
            r7.L$0 = r0
            r7.L$1 = r5
            r7.label = r2
            java.lang.Object r8 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$doReconnection(r8, r7)
            if (r8 != r6) goto L2a
        La6:
            return r6
        La7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
