package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ProducerCoroutine extends AbstractCoroutine implements ProducerScope, Channel {
    public final BufferedChannel _channel;

    public ProducerCoroutine(CoroutineContext coroutineContext, BufferedChannel bufferedChannel) {
        super(coroutineContext, true);
        this._channel = bufferedChannel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancelInternal(CancellationException cancellationException) {
        this._channel.closeOrCancelImpl(cancellationException, true);
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        return this._channel.closeOrCancelImpl(th, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveOrNull() {
        return this._channel.getOnReceiveOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        return this._channel.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 function1) {
        this._channel.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return this._channel.isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        return this._channel.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return bufferedChannel.new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(Object obj) {
        return this._channel.offer(obj);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (this._channel.closeOrCancelImpl(th, false) || z) {
            return;
        }
        AwaitKt.handleCoroutineException(this.context, th);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        this._channel.close(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object poll() {
        return this._channel.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) {
        return this._channel.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo1860receiveCatchingJP2dKIU(Continuation continuation) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return BufferedChannel.m1900receiveCatchingJP2dKIU$suspendImpl(bufferedChannel, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveOrNull(Continuation continuation) {
        BufferedChannel bufferedChannel = this._channel;
        bufferedChannel.getClass();
        return ReceiveChannel.receiveOrNull$suspendImpl(bufferedChannel, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) {
        return this._channel.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo1861tryReceivePtdJZtk() {
        return this._channel.mo1861tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo1712trySendJP2dKIU(Object obj) {
        return this._channel.mo1712trySendJP2dKIU(obj);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final /* synthetic */ boolean cancel(Throwable th) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }
}
