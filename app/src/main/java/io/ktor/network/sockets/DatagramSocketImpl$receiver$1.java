package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/network/sockets/Datagram;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.network.sockets.DatagramSocketImpl$receiver$1", f = "DatagramSocketImpl.kt", l = {52, 52}, m = "invokeSuspend", v = 1)
public final class DatagramSocketImpl$receiver$1 extends SuspendLambda implements Function2 {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DatagramSocketImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatagramSocketImpl$receiver$1(DatagramSocketImpl datagramSocketImpl, Continuation continuation) {
        super(2, continuation);
        this.this$0 = datagramSocketImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DatagramSocketImpl$receiver$1 datagramSocketImpl$receiver$1 = new DatagramSocketImpl$receiver$1(this.this$0, continuation);
        datagramSocketImpl$receiver$1.L$0 = obj;
        return datagramSocketImpl$receiver$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((DatagramSocketImpl$receiver$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0026 A[Catch: ClosedChannelException | IOException -> 0x0048, ClosedChannelException | IOException -> 0x0048, TRY_ENTER, TryCatch #0 {ClosedChannelException | IOException -> 0x0048, blocks: (B:6:0x0011, B:14:0x0026, B:14:0x0026, B:17:0x003b, B:17:0x003b, B:11:0x001f, B:11:0x001f), top: B:22:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x003b A[Catch: ClosedChannelException | IOException -> 0x0048, ClosedChannelException | IOException -> 0x0048, PHI: r1 r7
      0x003b: PHI (r1v1 kotlinx.coroutines.channels.SendChannel) = (r1v3 kotlinx.coroutines.channels.SendChannel), (r1v5 kotlinx.coroutines.channels.SendChannel) binds: [B:15:0x0038, B:11:0x001f] A[DONT_GENERATE, DONT_INLINE]
      0x003b: PHI (r7v1 java.lang.Object) = (r7v4 java.lang.Object), (r7v0 java.lang.Object) binds: [B:15:0x0038, B:11:0x001f] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {ClosedChannelException | IOException -> 0x0048, blocks: (B:6:0x0011, B:14:0x0026, B:14:0x0026, B:17:0x003b, B:17:0x003b, B:11:0x001f, B:11:0x001f), top: B:22:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0045 -> B:14:0x0026). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L15
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L48
            goto L26
        L15:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r6)
            return r2
        L1b:
            java.lang.Object r1 = r6.L$1
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            goto L3b
        L23:
            kotlin.ResultKt.throwOnFailure(r7)
        L26:
            r1 = r0
            kotlinx.coroutines.channels.ProducerCoroutine r1 = (kotlinx.coroutines.channels.ProducerCoroutine) r1     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r1.getClass()     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            io.ktor.network.sockets.DatagramSocketImpl r7 = r6.this$0     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r6.L$1 = r1     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r6.label = r4     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            java.lang.Object r7 = io.ktor.network.sockets.DatagramSocketImpl.access$receiveImpl(r7, r6)     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            if (r7 != r5) goto L3b
            goto L47
        L3b:
            r6.L$0 = r0     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r6.L$1 = r2     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            r6.label = r3     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            java.lang.Object r7 = r1.send(r7, r6)     // Catch: java.lang.Throwable -> L48 java.lang.Throwable -> L48
            if (r7 != r5) goto L26
        L47:
            return r5
        L48:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl$receiver$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
