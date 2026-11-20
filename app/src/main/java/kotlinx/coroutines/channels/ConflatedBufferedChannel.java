package kotlinx.coroutines.channels;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.network.HttpException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.selects.SelectImplementation;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ConflatedBufferedChannel extends BufferedChannel {
    public final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1 function1) {
        super(i, function1);
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m("This implementation does not support suspension for senders, use ", Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName(), " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Buffered channel capacity must be at least 1, but ", " was specified"));
        throw null;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void registerSelectForSend(SelectImplementation selectImplementation, Object obj) {
        Object objM1904trySendImplMj0NB7M = m1904trySendImplMj0NB7M(obj, false);
        if (!(objM1904trySendImplMj0NB7M instanceof ChannelResult.Failed)) {
            selectImplementation.internalResult = Unit.INSTANCE;
        } else if (objM1904trySendImplMj0NB7M instanceof ChannelResult.Closed) {
            selectImplementation.internalResult = BufferedChannelKt.CHANNEL_CLOSED;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unreachable");
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) throws Throwable {
        HttpException httpExceptionCallUndeliveredElementCatchingException;
        if (!(m1904trySendImplMj0NB7M(obj, true) instanceof ChannelResult.Closed)) {
            return Unit.INSTANCE;
        }
        Function1 function1 = this.onUndeliveredElement;
        if (function1 == null || (httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, obj, null)) == null) {
            throw getSendException();
        }
        ResultKt.addSuppressed(httpExceptionCallUndeliveredElementCatchingException, getSendException());
        throw httpExceptionCallUndeliveredElementCatchingException;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo1712trySendJP2dKIU(Object obj) {
        return m1904trySendImplMj0NB7M(obj, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    public final Object m1904trySendImplMj0NB7M(Object obj, boolean z) {
        Function1 function1;
        HttpException httpExceptionCallUndeliveredElementCatchingException;
        BufferOverflow bufferOverflow = this.onBufferOverflow;
        BufferOverflow bufferOverflow2 = BufferOverflow.DROP_LATEST;
        Unit unit = Unit.INSTANCE;
        Waiter waiter = null;
        if (bufferOverflow == bufferOverflow2) {
            Object objMo1712trySendJP2dKIU = super.mo1712trySendJP2dKIU(obj);
            if (!(objMo1712trySendJP2dKIU instanceof ChannelResult.Failed) || (objMo1712trySendJP2dKIU instanceof ChannelResult.Closed)) {
                return objMo1712trySendJP2dKIU;
            }
            if (z && (function1 = this.onUndeliveredElement) != null && (httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, obj, null)) != null) {
                throw httpExceptionCallUndeliveredElementCatchingException;
            }
        } else {
            Object obj2 = obj;
            Object obj3 = BufferedChannelKt.BUFFERED;
            ChannelSegment channelSegment = (ChannelSegment) BufferedChannel.sendSegment$volatile$FU.get(this);
            while (true) {
                long andIncrement = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                long j = 1152921504606846975L & andIncrement;
                boolean zIsClosed = isClosed(andIncrement, false);
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = i;
                long j3 = j / j2;
                Waiter waiter2 = waiter;
                int i2 = (int) (j % j2);
                if (channelSegment.id != j3) {
                    ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j3, channelSegment);
                    if (channelSegmentFindSegmentSend != null) {
                        channelSegment = channelSegmentFindSegmentSend;
                    } else if (zIsClosed) {
                        return new ChannelResult.Closed(getSendException());
                    }
                    waiter = waiter2;
                }
                int iUpdateCellSend = updateCellSend(channelSegment, i2, obj2, j, obj3, zIsClosed);
                if (iUpdateCellSend == 0) {
                    channelSegment.cleanPrev();
                    return unit;
                }
                if (iUpdateCellSend != 1) {
                    if (iUpdateCellSend == 2) {
                        if (!zIsClosed) {
                            Waiter waiter3 = obj3 instanceof Waiter ? (Waiter) obj3 : waiter2;
                            if (waiter3 != null) {
                                waiter3.invokeOnCancellation(channelSegment, i2 + i);
                            }
                            dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * j2) + ((long) i2));
                            break;
                        }
                        channelSegment.onSlotCleaned();
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (iUpdateCellSend == 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                        return waiter2;
                    }
                    if (iUpdateCellSend == 4) {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    obj2 = obj;
                    waiter = waiter2;
                } else {
                    break;
                }
            }
        }
        return unit;
    }
}
