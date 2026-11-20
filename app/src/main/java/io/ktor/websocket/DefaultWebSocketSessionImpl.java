package io.ktor.websocket;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentType;
import io.ktor.util.cio.ChannelIOException;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.io.Sink;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\"\u0010\u0017J&\u0010'\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0082@¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010\u0019J\"\u00101\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u00100\u001a\u00020/H\u0082@¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b5\u00104R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020#078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020/0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020/0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR\u001e\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020/0I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020/0\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001e\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR$\u0010W\u001a\u00020)2\u0006\u0010S\u001a\u00020)8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010+\"\u0004\bU\u0010VR$\u0010\\\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010\u0005\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010^\u001a\u0004\b_\u0010Y\"\u0004\b`\u0010[R*\u0010\u0006\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00048\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010^\u001a\u0004\ba\u0010Y\"\u0004\bb\u0010[R\"\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"Lio/ktor/websocket/DefaultWebSocketSessionImpl;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lio/ktor/websocket/WebSocketSession;", "raw", "", "pingIntervalMillis", "timeoutMillis", "Lio/ktor/websocket/ChannelConfig;", "incomingFramesConfig", "outgoingFramesConfig", "<init>", "(Lio/ktor/websocket/WebSocketSession;JJLio/ktor/websocket/ChannelConfig;Lio/ktor/websocket/ChannelConfig;)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "", "start", "(Ljava/util/List;)V", "", ContentType.Message.TYPE, "goingAway", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/websocket/Frame$Ping;", "ponger", "Lkotlinx/coroutines/Job;", "runIncomingProcessor", "(Lkotlinx/coroutines/channels/SendChannel;)Lkotlinx/coroutines/Job;", "runOutgoingProcessor", "()Lkotlinx/coroutines/Job;", "outgoingProcessorLoop", "Lio/ktor/websocket/CloseReason;", "reason", "", "exception", "sendCloseSequence", "(Lio/ktor/websocket/CloseReason;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "tryClose", "()Z", "runOrCancelPinger", "Lkotlinx/io/Sink;", "packet", "Lio/ktor/websocket/Frame;", "frame", "checkMaxFrameSize", "(Lkotlinx/io/Sink;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIncomingExtensions", "(Lio/ktor/websocket/Frame;)Lio/ktor/websocket/Frame;", "processOutgoingExtensions", "Lio/ktor/websocket/WebSocketSession;", "Lkotlinx/coroutines/CompletableDeferred;", "closeReasonRef", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/CompletableJob;", "context", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/Channel;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "outgoingToBeProcessed", "", "_extensions", "Ljava/util/List;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "getExtensions", "()Ljava/util/List;", "extensions", "value", "getMasking", "setMasking", "(Z)V", "masking", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "newValue", "J", "getPingIntervalMillis", "setPingIntervalMillis", "getTimeoutMillis", "setTimeoutMillis", "Lkotlinx/coroutines/Deferred;", "closeReason", "Lkotlinx/coroutines/Deferred;", "getCloseReason", "()Lkotlinx/coroutines/Deferred;", "Companion", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultWebSocketSessionImpl implements DefaultWebSocketSession, WebSocketSession {
    private final List<WebSocketExtension<?>> _extensions;
    private final Deferred closeReason;
    private final CompletableDeferred closeReasonRef;
    private volatile /* synthetic */ int closed;
    private final CompletableJob context;
    private final CoroutineContext coroutineContext;
    private final Channel filtered;
    private final Channel outgoingToBeProcessed;
    private long pingIntervalMillis;
    volatile /* synthetic */ Object pinger;
    private final WebSocketSession raw;
    private volatile /* synthetic */ int started;
    private long timeoutMillis;
    private static final Frame.Pong EmptyPong = new Frame.Pong(new byte[0], NonDisposableHandle.INSTANCE);
    static final /* synthetic */ AtomicReferenceFieldUpdater pinger$FU = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "closed");
    private static final /* synthetic */ AtomicIntegerFieldUpdater started$FU = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$checkMaxFrameSize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {414}, m = "checkMaxFrameSize", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.checkMaxFrameSize(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {338, 342, 352}, m = "outgoingProcessorLoop", v = 1)
    public static final class C03691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03691(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.outgoingProcessorLoop(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", l = {460, 256, 311, 262, 264, 267, 282, 297, 311, 311, 311, 311}, m = "invokeSuspend", v = 1)
    public static final class C03701 extends SuspendLambda implements Function2 {
        final /* synthetic */ SendChannel $ponger;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03701(SendChannel sendChannel, Continuation continuation) {
            super(2, continuation);
            this.$ponger = sendChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03701 c03701 = DefaultWebSocketSessionImpl.this.new C03701(this.$ponger, continuation);
            c03701.L$0 = obj;
            return c03701;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:108:0x03d2 A[Catch: all -> 0x03b5, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:110:0x03e0 A[Catch: all -> 0x03b5, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:112:0x040b  */
        /* JADX WARN: Code duplicated, block: B:113:0x040d A[Catch: all -> 0x03b5, TRY_LEAVE, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:116:0x043e  */
        /* JADX WARN: Code duplicated, block: B:119:0x044d A[Catch: all -> 0x03b5, TRY_ENTER, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:121:0x0451 A[Catch: all -> 0x03b5, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:124:0x0457 A[Catch: all -> 0x03b5, TryCatch #16 {all -> 0x03b5, blocks: (B:96:0x0391, B:108:0x03d2, B:110:0x03e0, B:113:0x040d, B:119:0x044d, B:121:0x0451, B:122:0x0453, B:124:0x0457, B:125:0x045d), top: B:227:0x0391 }] */
        /* JADX WARN: Code duplicated, block: B:127:0x047a A[Catch: all -> 0x0584, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0584, blocks: (B:117:0x0447, B:127:0x047a, B:143:0x0534), top: B:209:0x0447 }] */
        /* JADX WARN: Code duplicated, block: B:134:0x04b4  */
        /* JADX WARN: Code duplicated, block: B:140:0x04d3  */
        /* JADX WARN: Code duplicated, block: B:148:0x055f  */
        /* JADX WARN: Code duplicated, block: B:223:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:225:0x047e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x025d  */
        /* JADX WARN: Code duplicated, block: B:48:0x025f  */
        /* JADX WARN: Code duplicated, block: B:54:0x028a  */
        /* JADX WARN: Code duplicated, block: B:57:0x02ab  */
        /* JADX WARN: Code duplicated, block: B:87:0x0365  */
        /* JADX WARN: Code duplicated, block: B:99:0x03a9 A[PHI: r2 r8 r13 r16 r17
          0x03a9: PHI (r2v48 kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator) = 
          (r2v46 kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator)
          (r2v51 kotlinx.coroutines.channels.BufferedChannel$BufferedChannelIterator)
         binds: [B:111:0x0409, B:97:0x03a5] A[DONT_GENERATE, DONT_INLINE]
          0x03a9: PHI (r8v56 kotlinx.coroutines.channels.SendChannel) = (r8v55 kotlinx.coroutines.channels.SendChannel), (r8v61 kotlinx.coroutines.channels.SendChannel) binds: [B:111:0x0409, B:97:0x03a5] A[DONT_GENERATE, DONT_INLINE]
          0x03a9: PHI (r13v23 kotlin.jvm.internal.Ref$ObjectRef) = (r13v21 kotlin.jvm.internal.Ref$ObjectRef), (r13v25 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:111:0x0409, B:97:0x03a5] A[DONT_GENERATE, DONT_INLINE]
          0x03a9: PHI (r16v23 kotlin.Unit) = (r16v22 kotlin.Unit), (r16v25 kotlin.Unit) binds: [B:111:0x0409, B:97:0x03a5] A[DONT_GENERATE, DONT_INLINE]
          0x03a9: PHI (r17v11 java.lang.String) = (r17v10 java.lang.String), (r17v13 java.lang.String) binds: [B:111:0x0409, B:97:0x03a5] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x014e: MOVE (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:30:0x014c */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x03c4 -> B:150:0x0568). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0470 -> B:151:0x0577). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x055f -> B:149:0x0562). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                Method dump skipped, instruction units count: 1792
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.C03701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1", f = "DefaultWebSocketSession.kt", l = {321, 333, 333, 333, 325, 333, 333, 329, 333, 333}, m = "invokeSuspend", v = 1)
    public static final class C03711 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        public C03711(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DefaultWebSocketSessionImpl.this.new C03711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:63:0x0165 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x0166 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v16, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1] */
        /* JADX WARN: Type inference failed for: r11v18, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v2, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v21 */
        /* JADX WARN: Type inference failed for: r11v28, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r11v3 */
        /* JADX WARN: Type inference failed for: r11v30, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v35 */
        /* JADX WARN: Type inference failed for: r11v36 */
        /* JADX WARN: Type inference failed for: r11v9 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v2, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r8v5, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v7, types: [io.ktor.websocket.DefaultWebSocketSessionImpl$runOutgoingProcessor$1, kotlin.coroutines.Continuation] */
        /* JADX WARN: Type inference failed for: r8v8 */
        /* JADX WARN: Type inference failed for: r8v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r8;
            Throwable th;
            ?? r9;
            WebSocketSession webSocketSession;
            ?? r10;
            WebSocketSession webSocketSession2;
            ?? r11;
            int i = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    try {
                        switch (i) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                DefaultWebSocketSessionImpl defaultWebSocketSessionImpl = DefaultWebSocketSessionImpl.this;
                                this.label = 1;
                                if (defaultWebSocketSessionImpl.outgoingProcessorLoop(this) != coroutineSingletons) {
                                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                                    WebSocketSession webSocketSession3 = DefaultWebSocketSessionImpl.this.raw;
                                    this.label = 2;
                                    this = WebSocketSessionKt.close$default(webSocketSession3, null, this, 1, null);
                                    if (this != coroutineSingletons) {
                                        return unit;
                                    }
                                }
                                return coroutineSingletons;
                            case 1:
                                ResultKt.throwOnFailure(obj);
                                DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                                WebSocketSession webSocketSession4 = DefaultWebSocketSessionImpl.this.raw;
                                this.label = 2;
                                this = WebSocketSessionKt.close$default(webSocketSession4, null, this, 1, null);
                                if (this != coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                return unit;
                            case 2:
                                ResultKt.throwOnFailure(obj);
                                return unit;
                            case 3:
                            case 4:
                            case 6:
                            case 7:
                                ResultKt.throwOnFailure(obj);
                                return unit;
                            case 5:
                                ResultKt.throwOnFailure(obj);
                                r10 = this;
                                DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                                webSocketSession2 = DefaultWebSocketSessionImpl.this.raw;
                                r10.L$0 = null;
                                r10.label = 6;
                                if (WebSocketSessionKt.close$default(webSocketSession2, null, r10, 1, null) != coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                return unit;
                            case 8:
                                ResultKt.throwOnFailure(obj);
                                this = this;
                                DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                                WebSocketSession webSocketSession5 = DefaultWebSocketSessionImpl.this.raw;
                                r11.L$0 = null;
                                r11.L$1 = unit;
                                r11.label = 9;
                                if (WebSocketSessionKt.close$default(webSocketSession5, null, r11, 1, null) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                return unit;
                            case 9:
                                Unit unit2 = (Unit) this.L$1;
                                ResultKt.throwOnFailure(obj);
                                return unit2;
                            case 10:
                                Throwable th2 = (Throwable) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th2;
                            default:
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        r8 = this;
                        th = th;
                        r9 = r8;
                        DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                        webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                        r9.L$0 = th;
                        r9.label = 10;
                        if (WebSocketSessionKt.close$default(webSocketSession, null, r9, 1, null) != coroutineSingletons) {
                            throw th;
                        }
                    }
                } catch (ChannelIOException unused) {
                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                    WebSocketSession webSocketSession6 = DefaultWebSocketSessionImpl.this.raw;
                    this.label = 7;
                    if (WebSocketSessionKt.close$default(webSocketSession6, null, this, 1, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (CancellationException unused2) {
                    DefaultWebSocketSessionImpl defaultWebSocketSessionImpl2 = DefaultWebSocketSessionImpl.this;
                    CloseReason closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
                    this.L$0 = null;
                    this.label = 5;
                    r8 = this;
                    try {
                        Object objSendCloseSequence$default = DefaultWebSocketSessionImpl.sendCloseSequence$default(defaultWebSocketSessionImpl2, closeReason, null, r8, 2, null);
                        r10 = r8;
                        if (objSendCloseSequence$default != coroutineSingletons) {
                            DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                            webSocketSession2 = DefaultWebSocketSessionImpl.this.raw;
                            r10.L$0 = null;
                            r10.label = 6;
                            if (WebSocketSessionKt.close$default(webSocketSession2, null, r10, 1, null) != coroutineSingletons) {
                                return unit;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        r9 = r8;
                        DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                        webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                        r9.L$0 = th;
                        r9.label = 10;
                        if (WebSocketSessionKt.close$default(webSocketSession, null, r9, 1, null) != coroutineSingletons) {
                            throw th;
                        }
                    }
                } catch (ClosedReceiveChannelException unused3) {
                    ?? r12 = this;
                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                    WebSocketSession webSocketSession7 = DefaultWebSocketSessionImpl.this.raw;
                    r12.label = 4;
                    if (WebSocketSessionKt.close$default(webSocketSession7, null, r12, 1, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (ClosedSendChannelException unused4) {
                    ?? r13 = this;
                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                    WebSocketSession webSocketSession8 = DefaultWebSocketSessionImpl.this.raw;
                    r13.label = 3;
                    if (WebSocketSessionKt.close$default(webSocketSession8, null, r13, 1, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } catch (Throwable th5) {
                    DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel(AwaitKt.CancellationException("Failed to send frame", th5));
                    WebSocketSession webSocketSession9 = DefaultWebSocketSessionImpl.this.raw;
                    this.L$0 = null;
                    this.label = 8;
                    Object objCloseExceptionally = WebSocketSessionKt.closeExceptionally(webSocketSession9, th5, this);
                    r11 = this;
                    if (objCloseExceptionally != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
            } catch (Throwable th6) {
                r9 = this;
                th = th6;
                DefaultWebSocketSessionImpl.this.outgoingToBeProcessed.cancel((CancellationException) null);
                webSocketSession = DefaultWebSocketSessionImpl.this.raw;
                r9.L$0 = th;
                r9.label = 10;
                if (WebSocketSessionKt.close$default(webSocketSession, null, r9, 1, null) != coroutineSingletons) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$sendCloseSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl", f = "DefaultWebSocketSession.kt", l = {367}, m = "sendCloseSequence", v = 1)
    public static final class C03721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03721(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultWebSocketSessionImpl.this.sendCloseSequence(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.DefaultWebSocketSessionImpl$start$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$start$2", f = "DefaultWebSocketSession.kt", l = {214, 215}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Job $incomingJob;
        final /* synthetic */ Job $outgoingJob;
        int label;
        final /* synthetic */ DefaultWebSocketSessionImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Job job, Job job2, DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, Continuation continuation) {
            super(2, continuation);
            this.$incomingJob = job;
            this.$outgoingJob = job2;
            this.this$0 = defaultWebSocketSessionImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$incomingJob, this.$outgoingJob, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        
            if (r6.join(r5) == r4) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$incomingJob;
                this.label = 1;
                if (job.join(this) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            ((JobSupport) this.this$0.context).cancel(null);
            return Unit.INSTANCE;
            Job job2 = this.$outgoingJob;
            this.label = 2;
        }
    }

    public DefaultWebSocketSessionImpl(WebSocketSession webSocketSession, long j, long j2, ChannelConfig channelConfig, ChannelConfig channelConfig2) {
        webSocketSession.getClass();
        channelConfig.getClass();
        channelConfig2.getClass();
        this.raw = webSocketSession;
        this.pinger = null;
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
        this.closeReasonRef = completableDeferredImplCompletableDeferred$default;
        JobImpl jobImplJob$default = AwaitKt.Job$default();
        this.context = jobImplJob$default;
        this.coroutineContext = webSocketSession.getCoroutineContext().minusKey(Job.Key.$$INSTANCE).plus(jobImplJob$default).plus(new CoroutineName("ws-default"));
        Channel.Factory factory = Channel.Factory;
        this.filtered = WebSocketChannelsConfigKt.from(factory, channelConfig);
        this.outgoingToBeProcessed = WebSocketChannelsConfigKt.from(factory, channelConfig2);
        this.closed = 0;
        this._extensions = new ArrayList();
        this.started = 0;
        this.pingIntervalMillis = j;
        this.timeoutMillis = j2;
        this.closeReason = completableDeferredImplCompletableDeferred$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object checkMaxFrameSize(Sink sink, Frame frame, Continuation continuation) throws FrameTooBigException {
        AnonymousClass1 anonymousClass1;
        int i;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int length = frame.getData().length + (sink != null ? BytePacketBuilderKt.getSize(sink) : 0);
            if (length <= getMaxFrameSize()) {
                return Unit.INSTANCE;
            }
            if (sink != null) {
                sink.close();
            }
            CloseReason.Codes codes = CloseReason.Codes.TOO_BIG;
            StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(length, "Frame is too big: ", ". Max size is ");
            sbM2m.append(getMaxFrameSize());
            CloseReason closeReason = new CloseReason(codes, sbM2m.toString());
            anonymousClass1.L$0 = null;
            anonymousClass1.L$1 = null;
            anonymousClass1.I$0 = length;
            anonymousClass1.label = 1;
            Object objClose = WebSocketSessionKt.close(this, closeReason, anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objClose == coroutineSingletons) {
                return coroutineSingletons;
            }
            i = length;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
        }
        throw new FrameTooBigException(i, null, 2, null);
    }

    public static /* synthetic */ Object goingAway$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Server is going down";
        }
        return defaultWebSocketSessionImpl.goingAway(str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0053 A[PHI: r0 r1 r13 r14
      0x0053: PHI (r0v3 io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) = 
      (r0v7 io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1)
      (r0v2 io.ktor.websocket.DefaultWebSocketSessionImpl$outgoingProcessorLoop$1)
     binds: [B:22:0x006d, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r1v1 kotlinx.coroutines.channels.ChannelIterator) = (r1v18 kotlinx.coroutines.channels.ChannelIterator), (r1v19 kotlinx.coroutines.channels.ChannelIterator) binds: [B:22:0x006d, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r13v2 'this' io.ktor.websocket.DefaultWebSocketSessionImpl) = 
      (r13v9 'this' io.ktor.websocket.DefaultWebSocketSessionImpl)
      (r13v0 'this' io.ktor.websocket.DefaultWebSocketSessionImpl A[IMMUTABLE_TYPE, THIS])
     binds: [B:22:0x006d, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0053: PHI (r14v4 java.lang.Object) = (r14v13 java.lang.Object), (r14v1 java.lang.Object) binds: [B:22:0x006d, B:18:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00de -> B:14:0x003a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object outgoingProcessorLoop(kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl.outgoingProcessorLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame processIncomingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processIncomingFrame(frame);
        }
        return frame;
    }

    private final Frame processOutgoingExtensions(Frame frame) {
        Iterator<T> it = getExtensions().iterator();
        while (it.hasNext()) {
            frame = ((WebSocketExtension) it.next()).processOutgoingFrame(frame);
        }
        return frame;
    }

    private final Job runIncomingProcessor(SendChannel ponger) {
        return AwaitKt.launch$default(this, DefaultWebSocketSessionKt.IncomingProcessorCoroutineName.plus(Dispatchers.Unconfined), null, new C03701(ponger, null), 2);
    }

    private final void runOrCancelPinger() {
        DefaultWebSocketSessionImpl defaultWebSocketSessionImpl;
        SendChannel sendChannelPinger;
        long pingIntervalMillis = getPingIntervalMillis();
        if (this.closed == 0 && pingIntervalMillis > 0) {
            defaultWebSocketSessionImpl = this;
            sendChannelPinger = PingPongKt.pinger(defaultWebSocketSessionImpl, this.raw.getOutgoing(), pingIntervalMillis, getTimeoutMillis(), new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null));
        } else {
            defaultWebSocketSessionImpl = this;
            sendChannelPinger = null;
        }
        SendChannel sendChannel = (SendChannel) pinger$FU.getAndSet(defaultWebSocketSessionImpl, sendChannelPinger);
        if (sendChannel != null) {
            sendChannel.close(null);
        }
        if (sendChannelPinger != null) {
            sendChannelPinger.mo1712trySendJP2dKIU(EmptyPong);
        }
        if (defaultWebSocketSessionImpl.closed == 0 || sendChannelPinger == null) {
            return;
        }
        defaultWebSocketSessionImpl.runOrCancelPinger();
    }

    private final Job runOutgoingProcessor() {
        return AwaitKt.launch(this, DefaultWebSocketSessionKt.OutgoingProcessorCoroutineName.plus(Dispatchers.Unconfined), CoroutineStart.UNDISPATCHED, new C03711(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object sendCloseSequence(CloseReason closeReason, Throwable th, Continuation continuation) {
        C03721 c03721;
        if (continuation instanceof C03721) {
            c03721 = (C03721) continuation;
            int i = c03721.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03721.label = i - Integer.MIN_VALUE;
            } else {
                c03721 = new C03721(continuation);
            }
        } else {
            c03721 = new C03721(continuation);
        }
        Object obj = c03721.result;
        int i2 = c03721.label;
        Unit unit = Unit.INSTANCE;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (tryClose()) {
                    Logger logger = DefaultWebSocketSessionKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Sending Close Sequence for session " + this + " with reason " + closeReason + " and exception " + th);
                    }
                    ((JobImpl) this.context).complete$1();
                    if (closeReason == null) {
                        closeReason = new CloseReason(CloseReason.Codes.NORMAL, "");
                    }
                    runOrCancelPinger();
                    if (closeReason.getCode() != CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) {
                        SendChannel outgoing = this.raw.getOutgoing();
                        Frame.Close close = new Frame.Close(closeReason);
                        c03721.L$0 = null;
                        c03721.L$1 = th;
                        c03721.L$2 = closeReason;
                        c03721.label = 1;
                        Object objSend = outgoing.send(close, c03721);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objSend == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                return unit;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            closeReason = (CloseReason) c03721.L$2;
            th = (Throwable) c03721.L$1;
            ResultKt.throwOnFailure(obj);
            ((CompletableDeferredImpl) this.closeReasonRef).makeCompleting$kotlinx_coroutines_core(closeReason);
            if (th != null) {
                this.outgoingToBeProcessed.close(th);
                this.filtered.close(th);
            }
            return unit;
        } catch (Throwable th2) {
            ((CompletableDeferredImpl) this.closeReasonRef).makeCompleting$kotlinx_coroutines_core(closeReason);
            if (th != null) {
                this.outgoingToBeProcessed.close(th);
                this.filtered.close(th);
            }
            throw th2;
        }
    }

    public static /* synthetic */ Object sendCloseSequence$default(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, CloseReason closeReason, Throwable th, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        return defaultWebSocketSessionImpl.sendCloseSequence(closeReason, th, continuation);
    }

    private final boolean tryClose() {
        return closed$FU.compareAndSet(this, 0, 1);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation continuation) {
        Object objFlush = this.raw.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public Deferred getCloseReason() {
        return this.closeReason;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession, io.ktor.websocket.WebSocketSession, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return this._extensions;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel getIncoming() {
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.raw.getMasking();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.raw.getMaxFrameSize();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel getOutgoing() {
        return this.outgoingToBeProcessed;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public final Object goingAway(String str, Continuation continuation) {
        Object objSendCloseSequence$default = sendCloseSequence$default(this, new CloseReason(CloseReason.Codes.GOING_AWAY, str), null, continuation, 2, null);
        return objSendCloseSequence$default == CoroutineSingletons.COROUTINE_SUSPENDED ? objSendCloseSequence$default : Unit.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation continuation) {
        return super.send(frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.raw.setMasking(z);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.raw.setMaxFrameSize(j);
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setPingIntervalMillis(long j) {
        this.pingIntervalMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void setTimeoutMillis(long j) {
        this.timeoutMillis = j;
        runOrCancelPinger();
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        List<? extends WebSocketExtension<?>> list;
        negotiatedExtensions.getClass();
        if (!started$FU.compareAndSet(this, 0, 1)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("WebSocket session ", this, " is already started.");
            return;
        }
        Logger logger = DefaultWebSocketSessionKt.getLOGGER();
        if (LoggerJvmKt.isTraceEnabled(logger)) {
            StringBuilder sb = new StringBuilder("Starting default WebSocketSession(");
            sb.append(this);
            sb.append(") with negotiated extensions: ");
            list = negotiatedExtensions;
            sb.append(CollectionsKt.joinToString$default(list, null, null, null, null, 63));
            logger.trace(sb.toString());
        } else {
            list = negotiatedExtensions;
        }
        this._extensions.addAll(list);
        runOrCancelPinger();
        AwaitKt.launch$default(this, null, null, new AnonymousClass2(runIncomingProcessor(PingPongKt.ponger(this, getOutgoing())), runOutgoingProcessor(), this, null), 3);
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated
    public void terminate() {
        ((JobSupport) this.context).cancel(null);
        AwaitKt.cancel(this.raw, (CancellationException) null);
    }
}
