package io.ktor.websocket;

import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import dagger.hilt.EntryPoints;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 >*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001>B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0017\u001a\u00020\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\n0\u0015H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\b\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00028\u0000H\u0096A¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096A¢\u0006\u0004\b\u001d\u0010\u001cJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0096\u0003¢\u0006\u0004\b#\u0010$J \u0010'\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&H\u0096\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010'\u001a\u00020\nH\u0097\u0001¢\u0006\u0004\b'\u0010)J\u001a\u0010'\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0097\u0001¢\u0006\u0004\b'\u0010\u0014J\u0012\u0010*\u001a\u0004\u0018\u00018\u0000H\u0097\u0001¢\u0006\u0004\b*\u0010 J\u0012\u0010+\u001a\u0004\u0018\u00018\u0000H\u0097A¢\u0006\u0004\b+\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R\u0014\u0010-\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R&\u00103\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000/8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b4\u0010.R\u0014\u00105\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b5\u0010.R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00108R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000068VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b<\u00108¨\u0006?"}, d2 = {"Lio/ktor/websocket/BoundedChannel;", "T", "Lkotlinx/coroutines/channels/Channel;", "", "capacity", "delegate", "<init>", "(ILkotlinx/coroutines/channels/Channel;)V", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "offer", "(Ljava/lang/Object;)Z", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "()V", "poll", "receiveOrNull", "Lkotlinx/coroutines/channels/Channel;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "isClosedForReceive", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "getOnReceiveOrNull", "onReceiveOrNull", "Companion", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BoundedChannel<T> implements Channel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel delegate;

    public /* synthetic */ BoundedChannel(int i, Channel channel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? INSTANCE.createDelegate(i) : channel);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated
    public /* synthetic */ boolean cancel(Throwable cause) {
        return this.delegate.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this.delegate.close(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceive() {
        return this.delegate.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveCatching() {
        return this.delegate.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 getOnReceiveOrNull() {
        return this.delegate.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 getOnSend() {
        return this.delegate.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1 handler) {
        handler.getClass();
        this.delegate.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return this.delegate.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.delegate.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return this.delegate.iterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated
    public boolean offer(T element) {
        return this.delegate.offer(element);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated
    public T poll() {
        return (T) this.delegate.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation continuation) {
        return this.delegate.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo1860receiveCatchingJP2dKIU(Continuation continuation) {
        return this.delegate.mo1860receiveCatchingJP2dKIU(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated
    public Object receiveOrNull(Continuation continuation) {
        return this.delegate.receiveOrNull(continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(T t, Continuation continuation) {
        return this.delegate.send(t, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo1861tryReceivePtdJZtk() {
        return this.delegate.mo1861tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo1712trySendJP2dKIU(T element) {
        Object objMo1712trySendJP2dKIU = this.delegate.mo1712trySendJP2dKIU(element);
        if ((objMo1712trySendJP2dKIU instanceof ChannelResult.Failed) && !(objMo1712trySendJP2dKIU instanceof ChannelResult.Closed)) {
            close(new ChannelOverflowException("Channel overflowed"));
        }
        return objMo1712trySendJP2dKIU;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/websocket/BoundedChannel$Companion;", "", "<init>", "()V", "T", "", "capacity", "Lkotlinx/coroutines/channels/Channel;", "createDelegate", "(I)Lkotlinx/coroutines/channels/Channel;", "ktor-websockets"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit createDelegate$lambda$0(Ref$ObjectRef ref$ObjectRef, Object obj) {
            Object obj2 = ref$ObjectRef.element;
            if (obj2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
                throw null;
            }
            if (!((Channel) obj2).isClosedForSend()) {
                Object obj3 = ref$ObjectRef.element;
                if (obj3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channel");
                    throw null;
                }
                ((Channel) obj3).close(new ChannelOverflowException("Channel overflowed"));
            }
            return Unit.INSTANCE;
        }

        public final <T> Channel createDelegate(int capacity) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            BufferedChannel bufferedChannelChannel = EntryPoints.Channel(capacity, BufferOverflow.DROP_OLDEST, new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 6));
            ref$ObjectRef.element = bufferedChannelChannel;
            return bufferedChannelChannel;
        }

        private Companion() {
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public void cancel(CancellationException cause) {
        this.delegate.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated
    public /* synthetic */ void cancel() {
        this.delegate.cancel();
    }

    public BoundedChannel(int i, Channel channel) {
        channel.getClass();
        this.delegate = channel;
    }
}
