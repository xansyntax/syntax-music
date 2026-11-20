package io.ktor.websocket;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001@B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020+0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020(008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020(048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001e\u0010<\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000309088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;Lio/ktor/websocket/WebSocketChannelsConfig;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lkotlinx/coroutines/CompletableJob;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "", "_outgoing", "", "lastOpcode", "I", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "Lkotlinx/coroutines/Job;", "writerJob", "Lkotlinx/coroutines/Job;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketCommon implements WebSocketSession {
    private final Channel _incoming;
    private final Channel _outgoing;
    private final CoroutineContext coroutineContext;
    private final ByteReadChannel input;
    private int lastOpcode;
    private boolean masking;
    private long maxFrameSize;
    private final ByteWriteChannel output;
    private final CompletableJob socketJob;
    private final Job writerJob;

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommon$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$1", f = "RawWebSocketCommon.kt", l = {101, 105, 110, 115}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RawWebSocketCommon.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0049 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00a4, EOFException | ClosedReceiveChannelException -> 0x00a4, CancellationException -> 0x00ae, TRY_ENTER, TryCatch #4 {CancellationException -> 0x00ae, blocks: (B:17:0x0036, B:27:0x0049, B:30:0x0067, B:32:0x0073, B:36:0x0085, B:35:0x007d, B:37:0x0088, B:24:0x0042), top: B:55:0x0009, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:29:0x0065  */
        /* JADX WARN: Code duplicated, block: B:30:0x0067 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00a4, EOFException | ClosedReceiveChannelException -> 0x00a4, CancellationException -> 0x00ae, PHI: r10
          0x0067: PHI (r10v13 java.lang.Object) = (r10v18 java.lang.Object), (r10v0 java.lang.Object) binds: [B:28:0x0063, B:24:0x0042] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {CancellationException -> 0x00ae, blocks: (B:17:0x0036, B:27:0x0049, B:30:0x0067, B:32:0x0073, B:36:0x0085, B:35:0x007d, B:37:0x0088, B:24:0x0042), top: B:55:0x0009, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0073 A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00a4, EOFException | ClosedReceiveChannelException -> 0x00a4, CancellationException -> 0x00ae, TryCatch #4 {CancellationException -> 0x00ae, blocks: (B:17:0x0036, B:27:0x0049, B:30:0x0067, B:32:0x0073, B:36:0x0085, B:35:0x007d, B:37:0x0088, B:24:0x0042), top: B:55:0x0009, outer: #1 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x007b  */
        /* JADX WARN: Code duplicated, block: B:35:0x007d A[Catch: all -> 0x003a, ProtocolViolationException -> 0x003c, FrameTooBigException -> 0x003f, EOFException | ClosedReceiveChannelException -> 0x00a4, EOFException | ClosedReceiveChannelException -> 0x00a4, CancellationException -> 0x00ae, TryCatch #4 {CancellationException -> 0x00ae, blocks: (B:17:0x0036, B:27:0x0049, B:30:0x0067, B:32:0x0073, B:36:0x0085, B:35:0x007d, B:37:0x0088, B:24:0x0042), top: B:55:0x0009, outer: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0096 -> B:27:0x0049). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 287
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/RawWebSocketCommon$FlushRequest;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "complete", "()Z", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "done", "Lkotlinx/coroutines/CompletableJob;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class FlushRequest {
        private final CompletableJob done;

        public FlushRequest(Job job) {
            this.done = new JobImpl(job);
        }

        public final Object await(Continuation continuation) {
            Object objJoin = ((JobSupport) this.done).join(continuation);
            return objJoin == CoroutineSingletons.COROUTINE_SUSPENDED ? objJoin : Unit.INSTANCE;
        }

        public final boolean complete() {
            return ((JobImpl) this.done).makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketCommon$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon", f = "RawWebSocketCommon.kt", l = {137, 140, 145}, m = "flush", v = 1)
    public static final class C03741 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03741(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RawWebSocketCommon.this.flush(this);
        }
    }

    public RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig) {
        byteReadChannel.getClass();
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        webSocketChannelsConfig.getClass();
        this.input = byteReadChannel;
        this.output = byteWriteChannel;
        this.maxFrameSize = j;
        this.masking = z;
        JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.socketJob = jobImpl;
        this.coroutineContext = coroutineContext.plus(jobImpl).plus(new CoroutineName("raw-ws"));
        Channel.Factory factory = Channel.Factory;
        this._incoming = WebSocketChannelsConfigKt.from(factory, webSocketChannelsConfig.getIncoming());
        this._outgoing = WebSocketChannelsConfigKt.from(factory, webSocketChannelsConfig.getOutgoing());
        CoroutineName coroutineName = new CoroutineName("ws-writer");
        RawWebSocketCommon$writerJob$1 rawWebSocketCommon$writerJob$1 = new RawWebSocketCommon$writerJob$1(this, null);
        CoroutineStart coroutineStart = CoroutineStart.ATOMIC;
        this.writerJob = AwaitKt.launch(this, coroutineName, coroutineStart, rawWebSocketCommon$writerJob$1);
        AwaitKt.launch(this, new CoroutineName("ws-reader"), coroutineStart, new AnonymousClass1(null));
        jobImpl.complete$1();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x009e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
    
        if (r7.await(r0) == r6) goto L40;
     */
    @Override // io.ktor.websocket.WebSocketSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object flush(Continuation continuation) throws Throwable {
        C03741 c03741;
        FlushRequest flushRequest;
        int i;
        FlushRequest flushRequest2;
        FlushRequest flushRequest3;
        Job job;
        FlushRequest flushRequest4;
        if (continuation instanceof C03741) {
            c03741 = (C03741) continuation;
            int i2 = c03741.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03741.label = i2 - Integer.MIN_VALUE;
            } else {
                c03741 = new C03741(continuation);
            }
        } else {
            c03741 = new C03741(continuation);
        }
        Object obj = c03741.result;
        int i3 = c03741.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flushRequest = new FlushRequest((Job) getCoroutineContext().get(Job.Key.$$INSTANCE));
            i = 0;
            try {
                Channel channel = this._outgoing;
                c03741.L$0 = flushRequest;
                c03741.L$1 = flushRequest;
                c03741.I$0 = 0;
                c03741.label = 1;
                if (channel.send(flushRequest, c03741) != coroutineSingletons) {
                    flushRequest3 = flushRequest;
                }
            } catch (ClosedSendChannelException unused) {
                flushRequest2 = flushRequest;
                flushRequest2.complete();
                job = this.writerJob;
                c03741.L$0 = flushRequest;
                c03741.L$1 = null;
                c03741.L$2 = null;
                c03741.I$0 = i;
                c03741.label = 2;
                if (job.join(c03741) != coroutineSingletons) {
                    flushRequest4 = flushRequest;
                    flushRequest3 = flushRequest4;
                    c03741.L$0 = null;
                    c03741.L$1 = null;
                    c03741.L$2 = null;
                    c03741.label = 3;
                }
            } catch (Throwable th) {
                th = th;
                flushRequest2 = flushRequest;
                flushRequest2.complete();
                throw th;
            }
            return coroutineSingletons;
        }
        if (i3 == 1) {
            i = c03741.I$0;
            flushRequest2 = (FlushRequest) c03741.L$1;
            flushRequest3 = (FlushRequest) c03741.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedSendChannelException unused2) {
                flushRequest = flushRequest3;
                flushRequest2.complete();
                job = this.writerJob;
                c03741.L$0 = flushRequest;
                c03741.L$1 = null;
                c03741.L$2 = null;
                c03741.I$0 = i;
                c03741.label = 2;
                if (job.join(c03741) != coroutineSingletons) {
                    flushRequest4 = flushRequest;
                    flushRequest3 = flushRequest4;
                }
                return coroutineSingletons;
            } catch (Throwable th2) {
                th = th2;
                flushRequest2.complete();
                throw th;
            }
        } else if (i3 == 2) {
            flushRequest4 = (FlushRequest) c03741.L$0;
            ResultKt.throwOnFailure(obj);
            flushRequest3 = flushRequest4;
        } else {
            if (i3 != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        c03741.L$0 = null;
        c03741.L$1 = null;
        c03741.L$2 = null;
        c03741.label = 3;
    }

    @Override // io.ktor.websocket.WebSocketSession, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public List<WebSocketExtension<?>> getExtensions() {
        return EmptyList.INSTANCE;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return this.masking;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel getOutgoing() {
        return this._outgoing;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation continuation) {
        return super.send(frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking = z;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated
    public void terminate() {
        getOutgoing().close(null);
        ((JobImpl) this.socketJob).complete$1();
    }

    public /* synthetic */ RawWebSocketCommon(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? 2147483647L : j, (i & 8) != 0 ? false : z, coroutineContext, webSocketChannelsConfig);
    }
}
