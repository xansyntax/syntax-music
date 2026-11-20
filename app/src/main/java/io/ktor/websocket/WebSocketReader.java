package io.ktor.websocket;

import io.ktor.util.NIOKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperations_jvmKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00011B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB!\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020*0-8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lio/ktor/websocket/WebSocketReader;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteReadChannel;", "byteChannel", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "maxFrameSize", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/websocket/ChannelConfig;", "queueConfig", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;JLio/ktor/utils/io/pool/ObjectPool;Lio/ktor/websocket/ChannelConfig;)V", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/CoroutineContext;J)V", "buffer", "", "readLoop", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseLoop", "handleFrameIfProduced", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "J", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "Lio/ktor/websocket/WebSocketReader$State;", "state", "Lio/ktor/websocket/WebSocketReader$State;", "Lio/ktor/websocket/FrameParser;", "frameParser", "Lio/ktor/websocket/FrameParser;", "Lio/ktor/websocket/SimpleFrameCollector;", "collector", "Lio/ktor/websocket/SimpleFrameCollector;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "queue", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "State", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebSocketReader implements CoroutineScope {
    private final ByteReadChannel byteChannel;
    private final SimpleFrameCollector collector;
    private final CoroutineContext coroutineContext;
    private final FrameParser frameParser;
    private long maxFrameSize;
    private final Channel queue;
    private State state;

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketReader$1", f = "WebSocketReader.kt", l = {53}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ ObjectPool<ByteBuffer> $pool;
        Object L$0;
        int label;
        final /* synthetic */ WebSocketReader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObjectPool<ByteBuffer> objectPool, WebSocketReader webSocketReader, Continuation continuation) {
            super(2, continuation);
            this.$pool = objectPool;
            this.this$0 = webSocketReader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$pool, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [int] */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ?? r0 = this.label;
            try {
                if (r0 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ByteBuffer byteBufferBorrow = this.$pool.borrow();
                    WebSocketReader webSocketReader = this.this$0;
                    this.L$0 = byteBufferBorrow;
                    this.label = 1;
                    Object loop = webSocketReader.readLoop(byteBufferBorrow, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    r0 = byteBufferBorrow;
                    if (loop == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (r0 != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ByteBuffer byteBuffer = (ByteBuffer) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r0 = byteBuffer;
                }
            } catch (ClosedChannelException unused) {
            } catch (FrameTooBigException e) {
                this.this$0.queue.close(e);
            } catch (IOException e2) {
                Channel channel = this.this$0.queue;
                CancellationException cancellationException = new CancellationException(String.valueOf(e2));
                cancellationException.initCause(e2);
                channel.cancel(cancellationException);
            } catch (ProtocolViolationException e3) {
                this.this$0.queue.close(e3);
            } catch (CancellationException e4) {
                this.this$0.queue.cancel(e4);
            } finally {
                this.$pool.recycle(r0);
                this.this$0.queue.close(null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", "", "<init>", "(Ljava/lang/String;I)V", "HEADER", "BODY", "CLOSED", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum State {
        HEADER,
        BODY,
        CLOSED;

        private static final /* synthetic */ EnumEntries $ENTRIES = CollectionsKt__IterablesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketReader$handleFrameIfProduced$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {134}, m = "handleFrameIfProduced", v = 1)
    public static final class C03761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03761(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketReader.this.handleFrameIfProduced(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketReader$parseLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {109, 118}, m = "parseLoop", v = 1)
    public static final class C03771 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03771(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketReader.this.parseLoop(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.websocket.WebSocketReader$readLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.WebSocketReader", f = "WebSocketReader.kt", l = {85, 91}, m = "readLoop", v = 1)
    public static final class C03781 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03781(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebSocketReader.this.readLoop(null, this);
        }
    }

    public WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, long j, ObjectPool<ByteBuffer> objectPool, ChannelConfig channelConfig) {
        byteReadChannel.getClass();
        coroutineContext.getClass();
        objectPool.getClass();
        channelConfig.getClass();
        this.byteChannel = byteReadChannel;
        this.coroutineContext = coroutineContext;
        this.maxFrameSize = j;
        this.state = State.HEADER;
        this.frameParser = new FrameParser();
        this.collector = new SimpleFrameCollector();
        this.queue = WebSocketChannelsConfigKt.from(Channel.Factory, channelConfig);
        AwaitKt.launch(this, new CoroutineName("ws-reader"), CoroutineStart.ATOMIC, new AnonymousClass1(objectPool, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object handleFrameIfProduced(Continuation continuation) {
        C03761 c03761;
        if (continuation instanceof C03761) {
            c03761 = (C03761) continuation;
            int i = c03761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03761.label = i - Integer.MIN_VALUE;
            } else {
                c03761 = new C03761(continuation);
            }
        } else {
            c03761 = new C03761(continuation);
        }
        Object obj = c03761.result;
        int i2 = c03761.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.collector.getHasRemaining()) {
                this.state = this.frameParser.getFrameType() == FrameType.CLOSE ? State.CLOSED : State.HEADER;
                FrameParser frameParser = this.frameParser;
                Frame frameByType = Frame.INSTANCE.byType(frameParser.getFin(), frameParser.getFrameType(), NIOKt.moveToByteArray(this.collector.take(frameParser.getMaskKey())), frameParser.getRsv1(), frameParser.getRsv2(), frameParser.getRsv3());
                Channel channel = this.queue;
                c03761.L$0 = null;
                c03761.label = 1;
                Object objSend = channel.send(frameByType, c03761);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objSend == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.frameParser.bodyComplete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object parseLoop(ByteBuffer byteBuffer, Continuation continuation) throws FrameTooBigException {
        C03771 c03771;
        if (continuation instanceof C03771) {
            c03771 = (C03771) continuation;
            int i = c03771.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03771.label = i - Integer.MIN_VALUE;
            } else {
                c03771 = new C03771(continuation);
            }
        } else {
            c03771 = new C03771(continuation);
        }
        Object obj = c03771.result;
        int i2 = c03771.label;
        if (i2 != 0) {
            if (i2 != 1 && i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            byteBuffer = (ByteBuffer) c03771.L$0;
        }
        ResultKt.throwOnFailure(obj);
        while (true) {
            boolean zHasRemaining = byteBuffer.hasRemaining();
            Unit unit = Unit.INSTANCE;
            if (zHasRemaining) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
                Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i3 == 1) {
                    this.frameParser.frame(byteBuffer);
                    if (this.frameParser.getBodyReady()) {
                        this.state = State.BODY;
                        if (this.frameParser.getLength() > 2147483647L || this.frameParser.getLength() > this.maxFrameSize) {
                            break;
                        }
                        this.collector.start((int) this.frameParser.getLength(), byteBuffer);
                        c03771.L$0 = byteBuffer;
                        c03771.label = 1;
                        if (handleFrameIfProduced(c03771) == obj2) {
                            return obj2;
                        }
                    }
                } else {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            return unit;
                        }
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    this.collector.handle(byteBuffer);
                    c03771.L$0 = byteBuffer;
                    c03771.label = 2;
                    if (handleFrameIfProduced(c03771) == obj2) {
                        return obj2;
                    }
                }
            }
            return unit;
        }
        throw new FrameTooBigException(this.frameParser.getLength(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056 A[PHI: r6 r7
      0x0056: PHI (r6v1 java.nio.ByteBuffer) = (r6v3 java.nio.ByteBuffer), (r6v6 java.nio.ByteBuffer) binds: [B:20:0x0053, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0056: PHI (r7v2 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:20:0x0053, B:15:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (parseLoop(r6, r0) == r4) goto L27;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x006f -> B:28:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readLoop(ByteBuffer byteBuffer, Continuation continuation) {
        C03781 c03781;
        if (continuation instanceof C03781) {
            c03781 = (C03781) continuation;
            int i = c03781.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03781.label = i - Integer.MIN_VALUE;
            } else {
                c03781 = new C03781(continuation);
            }
        } else {
            c03781 = new C03781(continuation);
        }
        Object available = c03781.result;
        int i2 = c03781.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(available);
            byteBuffer.clear();
            if (this.state != State.CLOSED) {
                ByteReadChannel byteReadChannel = this.byteChannel;
                c03781.L$0 = byteBuffer;
                c03781.label = 1;
                available = ByteReadChannelOperations_jvmKt.readAvailable(byteReadChannel, byteBuffer, c03781);
                if (available != obj) {
                    if (((Number) available).intValue() == -1) {
                        this.state = State.CLOSED;
                    } else {
                        byteBuffer.flip();
                        c03781.L$0 = byteBuffer;
                        c03781.label = 2;
                    }
                }
                return obj;
            }
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            byteBuffer = (ByteBuffer) c03781.L$0;
            ResultKt.throwOnFailure(available);
            if (((Number) available).intValue() == -1) {
                this.state = State.CLOSED;
            } else {
                byteBuffer.flip();
                c03781.L$0 = byteBuffer;
                c03781.label = 2;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        byteBuffer = (ByteBuffer) c03781.L$0;
        ResultKt.throwOnFailure(available);
        byteBuffer.compact();
        if (this.state != State.CLOSED) {
            ByteReadChannel byteReadChannel2 = this.byteChannel;
            c03781.L$0 = byteBuffer;
            c03781.label = 1;
            available = ByteReadChannelOperations_jvmKt.readAvailable(byteReadChannel2, byteBuffer, c03781);
            if (available != obj) {
                if (((Number) available).intValue() == -1) {
                    this.state = State.CLOSED;
                } else {
                    byteBuffer.flip();
                    c03781.L$0 = byteBuffer;
                    c03781.label = 2;
                }
            }
            return obj;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final ReceiveChannel getIncoming() {
        return this.queue;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final void setMaxFrameSize(long j) {
        this.maxFrameSize = j;
    }

    public /* synthetic */ WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, long j, ObjectPool objectPool, ChannelConfig channelConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, coroutineContext, j, (i & 8) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool, (i & 16) != 0 ? ChannelConfig.INSTANCE.getUNLIMITED() : channelConfig);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ WebSocketReader(ByteReadChannel byteReadChannel, CoroutineContext coroutineContext, long j) {
        this(byteReadChannel, coroutineContext, j, null, null, 24, null);
        byteReadChannel.getClass();
        coroutineContext.getClass();
    }
}
