package com.metrolist.music.discord;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordGateway$startHeartbeat$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $jittered;
    public long J$0;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ DiscordGateway this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordGateway$startHeartbeat$1(DiscordGateway discordGateway, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = discordGateway;
        this.$jittered = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DiscordGateway$startHeartbeat$1 discordGateway$startHeartbeat$1 = new DiscordGateway$startHeartbeat$1(this.this$0, this.$jittered, continuation);
        discordGateway$startHeartbeat$1.L$0 = obj;
        return discordGateway$startHeartbeat$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DiscordGateway$startHeartbeat$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0095  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003b -> B:16:0x003e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            boolean r3 = r9.label
            r4 = 1
            if (r3 == 0) goto L1c
            if (r3 != r4) goto L15
            long r5 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L3e
        L15:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0.m$2(r9)
            r9 = 0
            return r9
        L1c:
            kotlin.ResultKt.throwOnFailure(r10)
            long r5 = java.lang.System.currentTimeMillis()
        L23:
            boolean r10 = kotlinx.coroutines.AwaitKt.isActive(r1)
            if (r10 == 0) goto La1
            com.metrolist.music.discord.DiscordGateway r10 = r9.this$0
            boolean r10 = r10.isOpen
            if (r10 == 0) goto La1
            long r7 = r9.$jittered
            r9.L$0 = r1
            r9.J$0 = r5
            r9.label = r4
            java.lang.Object r10 = kotlinx.coroutines.AwaitKt.delay(r7, r9)
            if (r10 != r2) goto L3e
            return r2
        L3e:
            boolean r10 = kotlinx.coroutines.AwaitKt.isActive(r1)
            if (r10 == 0) goto La1
            com.metrolist.music.discord.DiscordGateway r10 = r9.this$0
            boolean r10 = r10.isOpen
            if (r10 != 0) goto L4b
            goto La1
        L4b:
            com.metrolist.music.discord.DiscordGateway r10 = r9.this$0
            java.util.concurrent.atomic.AtomicLong r10 = r10.lastAckAtMs
            long r7 = r10.get()
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            java.lang.String r3 = "DiscordSvc"
            if (r10 >= 0) goto L7c
            okhttp3.ConnectionPool r10 = timber.log.Timber.Forest
            r10.tag(r3)
            long r1 = r9.$jittered
            java.lang.Long r10 = new java.lang.Long
            r10.<init>(r1)
            java.lang.Object[] r10 = new java.lang.Object[]{r10}
            okhttp3.ConnectionPool.w(r10)
            com.metrolist.music.discord.DiscordGateway r9 = r9.this$0
            okhttp3.WebSocket r9 = r9.webSocket
            if (r9 == 0) goto La1
            java.lang.String r10 = "heartbeat timeout"
            okhttp3.internal.ws.RealWebSocket r9 = (okhttp3.internal.ws.RealWebSocket) r9
            r1 = 4000(0xfa0, float:5.605E-42)
            r9.close(r1, r10)
            goto La1
        L7c:
            long r5 = java.lang.System.currentTimeMillis()
            com.metrolist.music.discord.DiscordGateway r10 = r9.this$0
            int r7 = r10._currentSeq     // Catch: java.lang.Throwable -> L89
            r10.heartbeat(r7)     // Catch: java.lang.Throwable -> L89
            r7 = r0
            goto L8f
        L89:
            r10 = move-exception
            kotlin.Result$Failure r7 = new kotlin.Result$Failure
            r7.<init>(r10)
        L8f:
            java.lang.Throwable r10 = kotlin.Result.m1866exceptionOrNullimpl(r7)
            if (r10 == 0) goto L23
            okhttp3.ConnectionPool r10 = timber.log.Timber.Forest
            r10.tag(r3)
            r10 = 0
            java.lang.Object[] r10 = new java.lang.Object[r10]
            okhttp3.ConnectionPool.w$1(r10)
            goto L23
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.discord.DiscordGateway$startHeartbeat$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
