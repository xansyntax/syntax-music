package io.ktor.websocket;

import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001e\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010<\u001a\u00020;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010A\u001a\u00020@8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lio/ktor/websocket/RawWebSocketJvm;", "Lio/ktor/websocket/WebSocketSession;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "maxFrameSize", "", "masking", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/websocket/WebSocketChannelsConfig;", "channelsConfig", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/nio/ByteBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/CoroutineContext;Lio/ktor/websocket/WebSocketChannelsConfig;Lio/ktor/utils/io/pool/ObjectPool;)V", "", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "terminate", "()V", "Lkotlinx/coroutines/CompletableJob;", "socketJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "filtered", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "", "Lio/ktor/websocket/WebSocketExtension;", "getExtensions", "()Ljava/util/List;", "extensions", "<set-?>", "maxFrameSize$delegate", "Lkotlin/properties/ReadWriteProperty;", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "masking$delegate", "getMasking", "()Z", "setMasking", "(Z)V", "Lio/ktor/websocket/WebSocketWriter;", "writer", "Lio/ktor/websocket/WebSocketWriter;", "getWriter$ktor_websockets", "()Lio/ktor/websocket/WebSocketWriter;", "Lio/ktor/websocket/WebSocketReader;", "reader", "Lio/ktor/websocket/WebSocketReader;", "getReader$ktor_websockets", "()Lio/ktor/websocket/WebSocketReader;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RawWebSocketJvm implements WebSocketSession {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(RawWebSocketJvm.class, "maxFrameSize", "getMaxFrameSize()J", 0), new MutablePropertyReference1Impl(RawWebSocketJvm.class, "masking", "getMasking()Z", 0)};
    private final CoroutineContext coroutineContext;
    private final Channel filtered;

    /* JADX INFO: renamed from: masking$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty masking;

    /* JADX INFO: renamed from: maxFrameSize$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty maxFrameSize;
    private final WebSocketReader reader;
    private final CompletableJob socketJob;
    private final WebSocketWriter writer;

    /* JADX INFO: renamed from: io.ktor.websocket.RawWebSocketJvm$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.websocket.RawWebSocketJvm$1", f = "RawWebSocketJvm.kt", l = {108, 109}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RawWebSocketJvm.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0053  */
        /* JADX WARN: Code duplicated, block: B:27:0x0054 A[Catch: all -> 0x001a, CancellationException -> 0x001c, ProtocolViolationException -> 0x001f, FrameTooBigException -> 0x0022, Merged into TryCatch #4 {all -> 0x008b, FrameTooBigException -> 0x0022, CancellationException -> 0x001c, ProtocolViolationException -> 0x001f, all -> 0x001a, blocks: (B:33:0x0081, B:36:0x008d, B:37:0x009b, B:38:0x00bf, B:7:0x0015, B:24:0x0044, B:27:0x0054, B:29:0x005c, B:20:0x002f, B:23:0x0036), top: B:44:0x0007 }, PHI: r0 r7
          0x0054: PHI (r0v14 kotlinx.coroutines.channels.ChannelIterator) = (r0v27 kotlinx.coroutines.channels.ChannelIterator), (r0v28 kotlinx.coroutines.channels.ChannelIterator) binds: [B:25:0x0051, B:20:0x002f] A[DONT_GENERATE, DONT_INLINE]
          0x0054: PHI (r7v10 java.lang.Object) = (r7v17 java.lang.Object), (r7v0 java.lang.Object) binds: [B:25:0x0051, B:20:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:29:0x005c A[Catch: all -> 0x001a, CancellationException -> 0x001c, ProtocolViolationException -> 0x001f, FrameTooBigException -> 0x0022, Merged into TryCatch #4 {all -> 0x008b, FrameTooBigException -> 0x0022, CancellationException -> 0x001c, ProtocolViolationException -> 0x001f, all -> 0x001a, blocks: (B:33:0x0081, B:36:0x008d, B:37:0x009b, B:38:0x00bf, B:7:0x0015, B:24:0x0044, B:27:0x0054, B:29:0x005c, B:20:0x002f, B:23:0x0036), top: B:44:0x0007 }, TRY_LEAVE] */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
        
            if (r5.send(r7, r6) == r4) goto L31;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0074 -> B:8:0x0018). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator channelIterator;
            BufferedChannel.BufferedChannelIterator bufferedChannelIterator;
            ChannelIterator it;
            ChannelIterator channelIterator2;
            int i = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    it = RawWebSocketJvm.this.getReader().getIncoming().iterator();
                    this.L$0 = it;
                    this.L$1 = null;
                    this.label = 1;
                    BufferedChannel.BufferedChannelIterator bufferedChannelIterator2 = (BufferedChannel.BufferedChannelIterator) it;
                    obj = bufferedChannelIterator2.hasNext(this);
                    channelIterator = bufferedChannelIterator2;
                    if (obj == coroutineSingletons) {
                        if (((Boolean) obj).booleanValue()) {
                            bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                            Frame frame = (Frame) bufferedChannelIterator.next();
                            Channel channel = RawWebSocketJvm.this.filtered;
                            this.L$0 = bufferedChannelIterator;
                            this.L$1 = null;
                            this.label = 2;
                        }
                        return Unit.INSTANCE;
                    }
                    channelIterator2 = bufferedChannelIterator;
                    return coroutineSingletons;
                }
                if (i == 1) {
                    ChannelIterator channelIterator3 = (ChannelIterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channelIterator = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                        bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                        Frame frame2 = (Frame) bufferedChannelIterator.next();
                        Channel channel2 = RawWebSocketJvm.this.filtered;
                        this.L$0 = bufferedChannelIterator;
                        this.L$1 = null;
                        this.label = 2;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ChannelIterator channelIterator4 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelIterator2 = channelIterator4;
                channelIterator2 = bufferedChannelIterator;
                it = channelIterator2;
                this.L$0 = it;
                this.L$1 = null;
                this.label = 1;
                BufferedChannel.BufferedChannelIterator bufferedChannelIterator3 = (BufferedChannel.BufferedChannelIterator) it;
                obj = bufferedChannelIterator3.hasNext(this);
                channelIterator = bufferedChannelIterator3;
                if (obj == coroutineSingletons) {
                    if (((Boolean) obj).booleanValue()) {
                        bufferedChannelIterator = (BufferedChannel.BufferedChannelIterator) channelIterator;
                        Frame frame3 = (Frame) bufferedChannelIterator.next();
                        Channel channel3 = RawWebSocketJvm.this.filtered;
                        this.L$0 = bufferedChannelIterator;
                        this.L$1 = null;
                        this.label = 2;
                    }
                    return Unit.INSTANCE;
                }
                channelIterator2 = bufferedChannelIterator;
                return coroutineSingletons;
            } catch (FrameTooBigException e) {
                RawWebSocketJvm.this.getOutgoing().mo1712trySendJP2dKIU(new Frame.Close(CloseReason.INSTANCE.truncated(CloseReason.Codes.TOO_BIG, e.getMessage())));
                RawWebSocketJvm.this.filtered.close(e);
            } catch (CancellationException e2) {
                RawWebSocketJvm.this.getReader().getIncoming().cancel(e2);
            } catch (ProtocolViolationException e3) {
                RawWebSocketJvm.this.getOutgoing().mo1712trySendJP2dKIU(new Frame.Close(CloseReason.INSTANCE.truncated(CloseReason.Codes.PROTOCOL_ERROR, e3.getMessage())));
                RawWebSocketJvm.this.filtered.close(e3);
            } catch (Throwable th) {
                RawWebSocketJvm.this.filtered.close(th);
            } finally {
                RawWebSocketJvm.this.filtered.close(null);
            }
        }
    }

    public RawWebSocketJvm(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, ObjectPool<ByteBuffer> objectPool) {
        byteReadChannel.getClass();
        byteWriteChannel.getClass();
        coroutineContext.getClass();
        webSocketChannelsConfig.getClass();
        objectPool.getClass();
        JobImpl jobImpl = new JobImpl((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.socketJob = jobImpl;
        this.coroutineContext = coroutineContext.plus(jobImpl).plus(new CoroutineName("raw-ws"));
        this.filtered = WebSocketChannelsConfigKt.from(Channel.Factory, webSocketChannelsConfig.getIncoming());
        final Long lValueOf = Long.valueOf(j);
        this.maxFrameSize = new ObservableProperty(lValueOf) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Long oldValue, Long newValue) {
                property.getClass();
                long jLongValue = newValue.longValue();
                oldValue.longValue();
                this.getReader().setMaxFrameSize(jLongValue);
            }
        };
        final Boolean boolValueOf = Boolean.valueOf(z);
        this.masking = new ObservableProperty(boolValueOf) { // from class: io.ktor.websocket.RawWebSocketJvm$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
                property.getClass();
                boolean zBooleanValue = newValue.booleanValue();
                oldValue.getClass();
                this.getWriter().setMasking(zBooleanValue);
            }
        };
        this.writer = new WebSocketWriter(byteWriteChannel, getCoroutineContext(), z, objectPool, webSocketChannelsConfig.getOutgoing());
        this.reader = new WebSocketReader(byteReadChannel, getCoroutineContext(), j, objectPool, webSocketChannelsConfig.getIncoming());
        AwaitKt.launch$default(this, null, null, new AnonymousClass1(null), 3);
        jobImpl.complete$1();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation continuation) throws Throwable {
        Object objFlush = this.writer.flush(continuation);
        return objFlush == CoroutineSingletons.COROUTINE_SUSPENDED ? objFlush : Unit.INSTANCE;
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
        return this.filtered;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public boolean getMasking() {
        return ((Boolean) this.masking.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return ((Number) this.maxFrameSize.getValue(this, $$delegatedProperties[0])).longValue();
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel getOutgoing() {
        return this.writer.getOutgoing();
    }

    /* JADX INFO: renamed from: getReader$ktor_websockets, reason: from getter */
    public final WebSocketReader getReader() {
        return this.reader;
    }

    /* JADX INFO: renamed from: getWriter$ktor_websockets, reason: from getter */
    public final WebSocketWriter getWriter() {
        return this.writer;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public /* bridge */ Object send(Frame frame, Continuation continuation) {
        return super.send(frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMasking(boolean z) {
        this.masking.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        this.maxFrameSize.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    @Override // io.ktor.websocket.WebSocketSession
    @Deprecated
    public void terminate() {
        getOutgoing().close(null);
        ((JobImpl) this.socketJob).complete$1();
    }

    public /* synthetic */ RawWebSocketJvm(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, boolean z, CoroutineContext coroutineContext, WebSocketChannelsConfig webSocketChannelsConfig, ObjectPool objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteReadChannel, byteWriteChannel, (i & 4) != 0 ? 2147483647L : j, (i & 8) != 0 ? false : z, coroutineContext, webSocketChannelsConfig, (i & 64) != 0 ? ByteBufferPoolKt.getKtorDefaultPool() : objectPool);
    }
}
