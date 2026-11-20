package io.ktor.websocket;

import dagger.hilt.EntryPoints;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Pong;", "outgoing", "Lio/ktor/websocket/Frame$Ping;", "ponger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame;", "", "periodMillis", "timeoutMillis", "Lkotlin/Function2;", "Lio/ktor/websocket/CloseReason;", "Lkotlin/coroutines/Continuation;", "", "", "onTimeout", "pinger", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/SendChannel;JJLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/CoroutineName;", "PongerCoroutineName", "Lkotlinx/coroutines/CoroutineName;", "PingerCoroutineName", "ktor-websockets"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PingPongKt {
    private static final CoroutineName PongerCoroutineName = new CoroutineName("ws-ponger");
    private static final CoroutineName PingerCoroutineName = new CoroutineName("ws-pinger");

    /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$pinger$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1", f = "PingPong.kt", l = {68, 77, 99}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Channel $channel;
        final /* synthetic */ Function2 $onTimeout;
        final /* synthetic */ SendChannel $outgoing;
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ long $timeoutMillis;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$pinger$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$2", f = "PingPong.kt", l = {70}, m = "invokeSuspend", v = 1)
        public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
            final /* synthetic */ Channel $channel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Channel channel, Continuation continuation) {
                super(2, continuation);
                this.$channel = channel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass2(this.$channel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objReceive;
                CoroutineSingletons coroutineSingletons;
                int i = this.label;
                if (i != 0 && i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                do {
                    Channel channel = this.$channel;
                    this.label = 1;
                    objReceive = channel.receive(this);
                    coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                } while (objReceive != coroutineSingletons);
                return coroutineSingletons;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Function2 function2, Channel channel, SendChannel sendChannel, Continuation continuation) {
            super(2, continuation);
            this.$periodMillis = j;
            this.$timeoutMillis = j2;
            this.$onTimeout = function2;
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$periodMillis, this.$timeoutMillis, this.$onTimeout, this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0097  */
        /* JADX WARN: Code duplicated, block: B:25:0x0098  */
        /* JADX WARN: Code duplicated, block: B:28:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d0 A[Catch: ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, PHI: r0 r6 r13
          0x00d0: PHI (r0v9 byte[]) = (r0v7 byte[]), (r0v17 byte[]) binds: [B:27:0x00cd, B:13:0x0037] A[DONT_GENERATE, DONT_INLINE]
          0x00d0: PHI (r6v9 kotlin.random.Random) = (r6v5 kotlin.random.Random), (r6v13 kotlin.random.Random) binds: [B:27:0x00cd, B:13:0x0037] A[DONT_GENERATE, DONT_INLINE]
          0x00d0: PHI (r13v7 java.lang.Object) = (r13v5 java.lang.Object), (r13v0 java.lang.Object) binds: [B:27:0x00cd, B:13:0x0037] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, blocks: (B:8:0x0020, B:13:0x0037, B:13:0x0037, B:13:0x0037, B:13:0x0037, B:29:0x00d0, B:29:0x00d0, B:29:0x00d0, B:29:0x00d0, B:31:0x00d4, B:31:0x00d4, B:31:0x00d4, B:31:0x00d4, B:22:0x0080, B:22:0x0080, B:22:0x0080, B:22:0x0080, B:26:0x0099, B:26:0x0099, B:26:0x0099, B:26:0x0099, B:16:0x0044, B:16:0x0044, B:16:0x0044, B:16:0x0044), top: B:38:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00d4 A[Catch: ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, TRY_LEAVE, TryCatch #0 {ClosedByteChannelException | CancellationException | ClosedReceiveChannelException | ClosedSendChannelException -> 0x00fb, blocks: (B:8:0x0020, B:13:0x0037, B:13:0x0037, B:13:0x0037, B:13:0x0037, B:29:0x00d0, B:29:0x00d0, B:29:0x00d0, B:29:0x00d0, B:31:0x00d4, B:31:0x00d4, B:31:0x00d4, B:31:0x00d4, B:22:0x0080, B:22:0x0080, B:22:0x0080, B:22:0x0080, B:26:0x0099, B:26:0x0099, B:26:0x0099, B:26:0x0099, B:16:0x0044, B:16:0x0044, B:16:0x0044, B:16:0x0044), top: B:38:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00f9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00cd -> B:29:0x00d0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.PingPongKt$ponger$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.PingPongKt$ponger$1", f = "PingPong.kt", l = {121, 33}, m = "invokeSuspend", v = 1)
    public static final class C03731 extends SuspendLambda implements Function2 {
        final /* synthetic */ Channel $channel;
        final /* synthetic */ SendChannel $outgoing;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03731(Channel channel, SendChannel sendChannel, Continuation continuation) {
            super(2, continuation);
            this.$channel = channel;
            this.$outgoing = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C03731(this.$channel, this.$outgoing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x008a  */
        /* JADX WARN: Code duplicated, block: B:22:0x008b  */
        /* JADX WARN: Code duplicated, block: B:25:0x009c A[Catch: all -> 0x0037, TRY_LEAVE, TryCatch #0 {all -> 0x0037, blocks: (B:7:0x002c, B:19:0x006c, B:23:0x0094, B:25:0x009c, B:14:0x005a, B:18:0x0065), top: B:37:0x0008, outer: #2 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x00d5 A[Catch: ClosedSendChannelException -> 0x00df, TRY_ENTER, TRY_LEAVE, TryCatch #2 {ClosedSendChannelException -> 0x00df, blocks: (B:28:0x00d5, B:32:0x00db, B:33:0x00de, B:17:0x0061, B:7:0x002c, B:19:0x006c, B:23:0x0094, B:25:0x009c, B:14:0x005a, B:18:0x0065, B:30:0x00d9), top: B:37:0x0008, inners: #0, #1 }] */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00d2, code lost:
        
            if (r10.send(r11, r14) == r5) goto L27;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d2 -> B:8:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ReceiveChannel receiveChannel;
            SendChannel sendChannel;
            int i;
            int i2;
            int i3;
            SendChannel sendChannel2;
            ChannelIterator channelIterator;
            int i4;
            int i5;
            int i6;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator;
            ChannelIterator it;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator2;
            Object objHasNext;
            ChannelIterator channelIterator2;
            int i7 = this.label;
            int i8 = 2;
            DisposableHandle disposableHandle = null;
            boolean z = false;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i7 == 0) {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel = this.$channel;
                        sendChannel = this.$outgoing;
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        it = receiveChannel.iterator();
                        this.L$0 = null;
                        this.L$1 = sendChannel;
                        this.L$2 = receiveChannel;
                        this.L$3 = null;
                        this.L$4 = it;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.I$2 = i3;
                        this.label = 1;
                        bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
                        objHasNext = bufferedChannelIterator2.hasNext(this);
                        if (objHasNext == coroutineSingletons) {
                            sendChannel2 = sendChannel;
                            obj = objHasNext;
                            int i9 = i3;
                            channelIterator = bufferedChannelIterator2;
                            i6 = i9;
                            int i10 = i2;
                            i4 = i;
                            i5 = i10;
                            if (!((Boolean) obj).booleanValue()) {
                                receiveChannel.cancel((CancellationException) null);
                                return Unit.INSTANCE;
                            }
                            bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                            Frame.Ping ping = (Frame.Ping) bufferedChannelIterator.next();
                            DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                            Frame.Pong pong = new Frame.Pong(ping.getData(), disposableHandle, i8, (DefaultConstructorMarker) (z ? 1 : 0));
                            this.L$0 = null;
                            this.L$1 = sendChannel2;
                            this.L$2 = receiveChannel;
                            this.L$3 = null;
                            this.L$4 = bufferedChannelIterator;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.I$0 = i4;
                            this.I$1 = i5;
                            this.I$2 = i6;
                            this.I$3 = 0;
                            this.label = 2;
                        }
                        channelIterator2 = bufferedChannelIterator;
                        return coroutineSingletons;
                    }
                    if (i7 == 1) {
                        i6 = this.I$2;
                        i5 = this.I$1;
                        i4 = this.I$0;
                        channelIterator = (ChannelIterator) this.L$4;
                        receiveChannel = (ReceiveChannel) this.L$2;
                        sendChannel2 = (SendChannel) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel.cancel((CancellationException) null);
                            return Unit.INSTANCE;
                        }
                        bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                        Frame.Ping ping2 = (Frame.Ping) bufferedChannelIterator.next();
                        DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                        Frame.Pong pong2 = new Frame.Pong(ping2.getData(), disposableHandle, i8, (DefaultConstructorMarker) (z ? 1 : 0));
                        this.L$0 = null;
                        this.L$1 = sendChannel2;
                        this.L$2 = receiveChannel;
                        this.L$3 = null;
                        this.L$4 = bufferedChannelIterator;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i4;
                        this.I$1 = i5;
                        this.I$2 = i6;
                        this.I$3 = 0;
                        this.label = 2;
                    } else {
                        if (i7 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        i6 = this.I$2;
                        i5 = this.I$1;
                        i4 = this.I$0;
                        ChannelIterator channelIterator3 = (ChannelIterator) this.L$4;
                        receiveChannel = (ReceiveChannel) this.L$2;
                        sendChannel2 = (SendChannel) this.L$1;
                        ResultKt.throwOnFailure(obj);
                        channelIterator2 = channelIterator3;
                    }
                    channelIterator2 = bufferedChannelIterator;
                    ChannelIterator channelIterator4 = channelIterator2;
                    i3 = i6;
                    it = channelIterator4;
                    int i11 = i4;
                    i2 = i5;
                    i = i11;
                    sendChannel = sendChannel2;
                    this.L$0 = null;
                    this.L$1 = sendChannel;
                    this.L$2 = receiveChannel;
                    this.L$3 = null;
                    this.L$4 = it;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.I$0 = i;
                    this.I$1 = i2;
                    this.I$2 = i3;
                    this.label = 1;
                    bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
                    objHasNext = bufferedChannelIterator2.hasNext(this);
                    if (objHasNext == coroutineSingletons) {
                        sendChannel2 = sendChannel;
                        obj = objHasNext;
                        int i12 = i3;
                        channelIterator = bufferedChannelIterator2;
                        i6 = i12;
                        int i13 = i2;
                        i4 = i;
                        i5 = i13;
                        if (!((Boolean) obj).booleanValue()) {
                            receiveChannel.cancel((CancellationException) null);
                            return Unit.INSTANCE;
                        }
                        bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                        Frame.Ping ping3 = (Frame.Ping) bufferedChannelIterator.next();
                        DefaultWebSocketSessionKt.getLOGGER().trace("Received ping message, sending pong message");
                        Frame.Pong pong3 = new Frame.Pong(ping3.getData(), disposableHandle, i8, (DefaultConstructorMarker) (z ? 1 : 0));
                        this.L$0 = null;
                        this.L$1 = sendChannel2;
                        this.L$2 = receiveChannel;
                        this.L$3 = null;
                        this.L$4 = bufferedChannelIterator;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = i4;
                        this.I$1 = i5;
                        this.I$2 = i6;
                        this.I$3 = 0;
                        this.label = 2;
                    }
                    channelIterator2 = bufferedChannelIterator;
                    return coroutineSingletons;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CharsKt.cancelConsumed(receiveChannel, th);
                        throw th2;
                    }
                }
            } catch (ClosedSendChannelException unused) {
            }
        }
    }

    public static final SendChannel pinger(CoroutineScope coroutineScope, SendChannel sendChannel, long j, long j2, Function2 function2) {
        coroutineScope.getClass();
        sendChannel.getClass();
        function2.getClass();
        JobImpl jobImplJob$default = AwaitKt.Job$default();
        BufferedChannel bufferedChannelChannel$default = EntryPoints.Channel$default(Integer.MAX_VALUE, 6, null);
        AwaitKt.launch$default(coroutineScope, StringsKt__IndentKt.plus(jobImplJob$default, PingerCoroutineName), null, new AnonymousClass1(j, j2, function2, bufferedChannelChannel$default, sendChannel, null), 2);
        CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        element.getClass();
        ((Job) element).invokeOnCompletion(new PingPongKt$$ExternalSyntheticLambda0((byte) 0, (Object) jobImplJob$default));
        return bufferedChannelChannel$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit pinger$lambda$0(CompletableJob completableJob, Throwable th) {
        ((JobSupport) completableJob).cancel(null);
        return Unit.INSTANCE;
    }

    public static final SendChannel ponger(CoroutineScope coroutineScope, SendChannel sendChannel) {
        coroutineScope.getClass();
        sendChannel.getClass();
        BufferedChannel bufferedChannelChannel$default = EntryPoints.Channel$default(5, 6, null);
        AwaitKt.launch$default(coroutineScope, PongerCoroutineName, null, new C03731(bufferedChannelChannel$default, sendChannel, null), 2);
        return bufferedChannelChannel$default;
    }
}
