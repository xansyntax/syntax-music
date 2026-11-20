package io.ktor.websocket;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00019B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u0016028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006:"}, d2 = {"Lio/ktor/websocket/WebSocketWriter;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteWriteChannel;", "writeChannel", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "masking", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/websocket/ChannelConfig;", "queueConfig", "<init>", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;Lio/ktor/websocket/ChannelConfig;)V", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;ZLio/ktor/utils/io/pool/ObjectPool;)V", "buffer", "", "writeLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drainQueueAndDiscard", "()V", "Lio/ktor/websocket/Frame;", "firstMsg", "drainQueueAndSerialize", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frame", "send", "(Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Z", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/utils/io/pool/ObjectPool;", "getPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "Lkotlinx/coroutines/channels/Channel;", "", "queue", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Serializer;", "serializer", "Lio/ktor/websocket/Serializer;", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "Lkotlinx/coroutines/Job;", "writeLoopJob", "Lkotlinx/coroutines/Job;", "FlushRequest", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketWriter implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private boolean masking;
    private final ObjectPool<ByteBuffer> pool;
    private final Channel queue;
    private final Serializer serializer;
    private final ByteWriteChannel writeChannel;
    private final Job writeLoopJob;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/WebSocketWriter$FlushRequest;", "", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "complete", "()Z", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableJob;", "done", "Lkotlinx/coroutines/CompletableJob;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketWriter$drainQueueAndSerialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {142, 146, 160}, m = "drainQueueAndSerialize", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketWriter.this.drainQueueAndSerialize(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketWriter$flush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {180, 183, 188}, m = "flush", v = 1)
    public static final class C03791 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketWriter.this.flush(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketWriter$writeLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketWriter", f = "WebSocketWriter.kt", l = {61, 63, 80, 80, 80, 80}, m = "writeLoop", v = 1)
    public static final class C03801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03801(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketWriter.this.writeLoop(null, this);
        }
    }

    public WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool<ByteBuffer> objectPool, ChannelConfig channelConfig) {
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        objectPool.getClass();
        channelConfig.getClass();
        this.writeChannel = byteWriteChannel;
        this.coroutineContext = coroutineContext;
        this.masking = z;
        this.pool = objectPool;
        this.queue = WebSocketChannelsConfigKt.from(Channel.Factory, channelConfig);
        this.serializer = new Serializer();
        this.writeLoopJob = AwaitKt.launch(this, new CoroutineName("ws-writer"), CoroutineStart.ATOMIC, new WebSocketWriter$writeLoopJob$1(this, null));
    }

    private final void drainQueueAndDiscard() {
        this.queue.close(null);
        while (true) {
            try {
                Object objM1903getOrNullimpl = ChannelResult.m1903getOrNullimpl(this.queue.mo1861tryReceivePtdJZtk());
                if (objM1903getOrNullimpl == null) {
                    return;
                }
                if (!(objM1903getOrNullimpl instanceof Frame.Close) && !(objM1903getOrNullimpl instanceof Frame.Ping) && !(objM1903getOrNullimpl instanceof Frame.Pong)) {
                    if (objM1903getOrNullimpl instanceof FlushRequest) {
                        ((FlushRequest) objM1903getOrNullimpl).complete();
                    } else if (!(objM1903getOrNullimpl instanceof Frame.Text) && !(objM1903getOrNullimpl instanceof Frame.Binary)) {
                        throw new IllegalArgumentException("unknown message " + objM1903getOrNullimpl);
                    }
                }
            } catch (CancellationException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:57:0x010c A[PHI: r12 r13 r14
      0x010c: PHI (r12v4 kotlin.jvm.internal.Ref$ObjectRef) = (r12v6 kotlin.jvm.internal.Ref$ObjectRef), (r12v8 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:56:0x00fd, B:75:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x010c: PHI (r13v7 ??) = (r13v26 ??), (r13v27 ??) binds: [B:56:0x00fd, B:75:0x0161] A[DONT_GENERATE, DONT_INLINE]
      0x010c: PHI (r14v6 java.nio.ByteBuffer) = (r14v7 java.nio.ByteBuffer), (r14v8 java.nio.ByteBuffer) binds: [B:56:0x00fd, B:75:0x0161] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:60:0x0121  */
    /* JADX WARN: Code duplicated, block: B:63:0x012c  */
    /* JADX WARN: Code duplicated, block: B:73:0x015b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v7, types: [int] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x012a -> B:71:0x0154). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0130 -> B:71:0x0154). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x0136 -> B:71:0x0154). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x014c -> B:70:0x014f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object drainQueueAndSerialize(io.ktor.websocket.Frame r12, java.nio.ByteBuffer r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.drainQueueAndSerialize(io.ktor.websocket.Frame, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x008d A[Catch: all -> 0x0050, ChannelWriteException -> 0x0053, TryCatch #5 {ChannelWriteException -> 0x0053, all -> 0x0050, blocks: (B:15:0x0048, B:26:0x006e, B:30:0x0085, B:32:0x008d, B:34:0x0098, B:46:0x00c3, B:48:0x00c7, B:49:0x00ce, B:50:0x00e4, B:22:0x005e, B:25:0x0068), top: B:71:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c3 A[Catch: all -> 0x0050, ChannelWriteException -> 0x0053, TRY_ENTER, TryCatch #5 {ChannelWriteException -> 0x0053, all -> 0x0050, blocks: (B:15:0x0048, B:26:0x006e, B:30:0x0085, B:32:0x008d, B:34:0x0098, B:46:0x00c3, B:48:0x00c7, B:49:0x00ce, B:50:0x00e4, B:22:0x005e, B:25:0x0068), top: B:71:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c7 A[Catch: all -> 0x0050, ChannelWriteException -> 0x0053, TryCatch #5 {ChannelWriteException -> 0x0053, all -> 0x0050, blocks: (B:15:0x0048, B:26:0x006e, B:30:0x0085, B:32:0x008d, B:34:0x0098, B:46:0x00c3, B:48:0x00c7, B:49:0x00ce, B:50:0x00e4, B:22:0x005e, B:25:0x0068), top: B:71:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ab -> B:73:0x00b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c7 -> B:26:0x006e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object writeLoop(java.nio.ByteBuffer r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.WebSocketWriter.writeLoop(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:36:0x009e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ac, code lost:
    
        if (r7.await(r0) == r6) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object flush(Continuation continuation) throws Throwable {
        C03791 c03791;
        FlushRequest flushRequest;
        int i;
        FlushRequest flushRequest2;
        FlushRequest flushRequest3;
        Job job;
        FlushRequest flushRequest4;
        if (continuation instanceof C03791) {
            c03791 = (C03791) continuation;
            int i2 = c03791.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c03791.label = i2 - Integer.MIN_VALUE;
            } else {
                c03791 = new C03791(continuation);
            }
        } else {
            c03791 = new C03791(continuation);
        }
        Object obj = c03791.result;
        int i3 = c03791.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flushRequest = new FlushRequest((Job) getCoroutineContext().get(Job.Key.$$INSTANCE));
            i = 0;
            try {
                Channel channel = this.queue;
                c03791.L$0 = flushRequest;
                c03791.L$1 = flushRequest;
                c03791.I$0 = 0;
                c03791.label = 1;
                if (channel.send(flushRequest, c03791) != coroutineSingletons) {
                    flushRequest3 = flushRequest;
                }
            } catch (ClosedSendChannelException unused) {
                flushRequest2 = flushRequest;
                flushRequest2.complete();
                job = this.writeLoopJob;
                c03791.L$0 = flushRequest;
                c03791.L$1 = null;
                c03791.L$2 = null;
                c03791.I$0 = i;
                c03791.label = 2;
                if (job.join(c03791) != coroutineSingletons) {
                    flushRequest4 = flushRequest;
                    flushRequest3 = flushRequest4;
                    c03791.L$0 = null;
                    c03791.L$1 = null;
                    c03791.L$2 = null;
                    c03791.label = 3;
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
            i = c03791.I$0;
            flushRequest2 = (FlushRequest) c03791.L$1;
            flushRequest3 = (FlushRequest) c03791.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedSendChannelException unused2) {
                flushRequest = flushRequest3;
                flushRequest2.complete();
                job = this.writeLoopJob;
                c03791.L$0 = flushRequest;
                c03791.L$1 = null;
                c03791.L$2 = null;
                c03791.I$0 = i;
                c03791.label = 2;
                if (job.join(c03791) != coroutineSingletons) {
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
            flushRequest4 = (FlushRequest) c03791.L$0;
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
        c03791.L$0 = null;
        c03791.L$1 = null;
        c03791.L$2 = null;
        c03791.label = 3;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMasking() {
        return this.masking;
    }

    public final SendChannel getOutgoing() {
        return this.queue;
    }

    public final ObjectPool<ByteBuffer> getPool() {
        return this.pool;
    }

    public final Object send(Frame frame, Continuation continuation) {
        Object objSend = this.queue.send(frame, continuation);
        return objSend == CoroutineSingletons.COROUTINE_SUSPENDED ? objSend : Unit.INSTANCE;
    }

    public final void setMasking(boolean z) {
        this.masking = z;
    }

    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool objectPool, ChannelConfig channelConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteWriteChannel, coroutineContext, (i & 4) != 0 ? false : z, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool, (i & 16) != 0 ? ChannelConfig.INSTANCE.getUNLIMITED() : channelConfig);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ WebSocketWriter(ByteWriteChannel byteWriteChannel, CoroutineContext coroutineContext, boolean z, ObjectPool objectPool) {
        this(byteWriteChannel, coroutineContext, z, objectPool, null, 16, null);
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        objectPool.getClass();
    }
}
