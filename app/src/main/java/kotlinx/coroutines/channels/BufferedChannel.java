package kotlinx.coroutines.channels;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import coil3.network.HttpException;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class BufferedChannel implements Channel {
    public static final /* synthetic */ long _closeCause$volatile$FU$offset;
    public static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU;
    public static final /* synthetic */ long bufferEnd$volatile$FU$offset;
    public static final /* synthetic */ long bufferEndSegment$volatile$FU$offset;
    public static final /* synthetic */ long closeHandler$volatile$FU$offset;
    public static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU;
    public static final /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile$FU$offset;
    public static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU;
    public static final /* synthetic */ long receiveSegment$volatile$FU$offset;
    public static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU;
    public static final /* synthetic */ long receivers$volatile$FU$offset;
    public static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU;
    public static final /* synthetic */ long sendSegment$volatile$FU$offset;
    public static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ long sendersAndCloseStatus$volatile$FU$offset;
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    public final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final Function1 onUndeliveredElement;
    public final ListItemKt$$ExternalSyntheticLambda17 onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class BufferedChannelIterator implements ChannelIterator, Waiter {
        public CancellableContinuationImpl continuation;
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        public final Object hasNext(ContinuationImpl continuationImpl) {
            ChannelSegment channelSegmentFindSegmentReceive;
            Boolean bool;
            Object obj = this.receiveResult;
            boolean z = true;
            if (obj == BufferedChannelKt.NO_RECEIVE_RESULT || obj == BufferedChannelKt.CHANNEL_CLOSED) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.receiveSegment$volatile$FU;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
                while (true) {
                    byte b = 0;
                    if (bufferedChannel.isClosedForReceive()) {
                        this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                        Throwable closeCause = bufferedChannel.getCloseCause();
                        if (closeCause == null) {
                            z = false;
                            break;
                        }
                        int i = StackTraceRecoveryKt.$r8$clinit;
                        throw closeCause;
                    }
                    long andIncrement = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel);
                    long j = BufferedChannelKt.SEGMENT_SIZE;
                    long j2 = andIncrement / j;
                    int i2 = (int) (andIncrement % j);
                    if (channelSegment.id != j2) {
                        channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment);
                        if (channelSegmentFindSegmentReceive == null) {
                            continue;
                        }
                    } else {
                        channelSegmentFindSegmentReceive = channelSegment;
                    }
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i2, andIncrement, null);
                    Joiner joiner = BufferedChannelKt.SUSPEND;
                    BufferedChannel$$ExternalSyntheticLambda1 bufferedChannel$$ExternalSyntheticLambda1 = null;
                    if (objUpdateCellReceive == joiner) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unreachable");
                        return null;
                    }
                    Joiner joiner2 = BufferedChannelKt.FAILED;
                    if (objUpdateCellReceive != joiner2) {
                        if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                            channelSegmentFindSegmentReceive.cleanPrev();
                            this.receiveResult = objUpdateCellReceive;
                            break;
                        }
                        BufferedChannel bufferedChannel2 = BufferedChannel.this;
                        CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(continuationImpl));
                        try {
                            this.continuation = orCreateCancellableContinuation;
                            Object objUpdateCellReceive2 = bufferedChannel2.updateCellReceive(channelSegmentFindSegmentReceive, i2, andIncrement, this);
                            Function1 function1 = bufferedChannel2.onUndeliveredElement;
                            if (objUpdateCellReceive2 != joiner) {
                                if (objUpdateCellReceive2 == joiner2) {
                                    if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegmentFindSegmentReceive.cleanPrev();
                                    }
                                    ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel2);
                                    while (true) {
                                        if (bufferedChannel2.isClosedForReceive()) {
                                            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
                                            cancellableContinuationImpl.getClass();
                                            this.continuation = null;
                                            this.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
                                            Throwable closeCause2 = bufferedChannel.getCloseCause();
                                            if (closeCause2 != null) {
                                                cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause2));
                                                break;
                                            }
                                            cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                                            break;
                                        }
                                        long andIncrement2 = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel2);
                                        long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                        long j4 = andIncrement2 / j3;
                                        int i3 = (int) (andIncrement2 % j3);
                                        if (channelSegment2.id != j4) {
                                            ChannelSegment channelSegmentFindSegmentReceive2 = bufferedChannel2.findSegmentReceive(j4, channelSegment2);
                                            if (channelSegmentFindSegmentReceive2 != null) {
                                                channelSegment2 = channelSegmentFindSegmentReceive2;
                                            }
                                        }
                                        Object objUpdateCellReceive3 = bufferedChannel2.updateCellReceive(channelSegment2, i3, andIncrement2, this);
                                        if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND) {
                                            invokeOnCancellation(channelSegment2, i3);
                                            break;
                                        }
                                        if (objUpdateCellReceive3 == BufferedChannelKt.FAILED) {
                                            if (andIncrement2 < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                                                channelSegment2.cleanPrev();
                                            }
                                        } else {
                                            if (objUpdateCellReceive3 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                throw new IllegalStateException("unexpected");
                                            }
                                            channelSegment2.cleanPrev();
                                            this.receiveResult = objUpdateCellReceive3;
                                            this.continuation = null;
                                            bool = Boolean.TRUE;
                                            if (function1 != null) {
                                                bufferedChannel$$ExternalSyntheticLambda1 = new BufferedChannel$$ExternalSyntheticLambda1(function1, objUpdateCellReceive3, b);
                                            }
                                        }
                                    }
                                } else {
                                    channelSegmentFindSegmentReceive.cleanPrev();
                                    this.receiveResult = objUpdateCellReceive2;
                                    this.continuation = null;
                                    bool = Boolean.TRUE;
                                    if (function1 != null) {
                                        bufferedChannel$$ExternalSyntheticLambda1 = new BufferedChannel$$ExternalSyntheticLambda1(function1, objUpdateCellReceive2, b);
                                    }
                                }
                                orCreateCancellableContinuation.resume(bool, bufferedChannel$$ExternalSyntheticLambda1);
                                break;
                            }
                            invokeOnCancellation(channelSegmentFindSegmentReceive, i2);
                            return orCreateCancellableContinuation.getResult();
                        } catch (Throwable th) {
                            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw th;
                        }
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegmentFindSegmentReceive.cleanPrev();
                    }
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            return Boolean.valueOf(z);
        }

        @Override // kotlinx.coroutines.Waiter
        public final void invokeOnCancellation(Segment segment, int i) {
            CancellableContinuationImpl cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        public final Object next() throws Throwable {
            Object obj = this.receiveResult;
            Joiner joiner = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (obj == joiner) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("`hasNext()` has not been invoked");
                return null;
            }
            this.receiveResult = joiner;
            if (obj != BufferedChannelKt.CHANNEL_CLOSED) {
                return obj;
            }
            Throwable receiveException = BufferedChannel.this.getReceiveException();
            int i = StackTraceRecoveryKt.$r8$clinit;
            throw receiveException;
        }
    }

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        sendersAndCloseStatus$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("sendersAndCloseStatus$volatile"));
        receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
        receivers$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("receivers$volatile"));
        bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
        bufferEnd$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("bufferEnd$volatile"));
        completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
        completedExpandBuffersAndPauseFlag$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("completedExpandBuffersAndPauseFlag$volatile"));
        sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
        sendSegment$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("sendSegment$volatile"));
        receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
        receiveSegment$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("receiveSegment$volatile"));
        bufferEndSegment$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("bufferEndSegment$volatile"));
        _closeCause$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("_closeCause$volatile"));
        closeHandler$volatile$FU$offset = unsafe.objectFieldOffset(BufferedChannel.class.getDeclaredField("closeHandler$volatile"));
    }

    public BufferedChannel(int i, Function1 function1) {
        long j;
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Invalid channel capacity: ", ", should be >=0"));
            throw null;
        }
        ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
        if (i != 0) {
            j = i != Integer.MAX_VALUE ? i : Long.MAX_VALUE;
        } else {
            j = 0;
        }
        this.bufferEnd$volatile = j;
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment channelSegment2 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment2;
        this.receiveSegment$volatile = channelSegment2;
        if (isRendezvousOrUnlimited()) {
            channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
            channelSegment2.getClass();
        }
        this.bufferEndSegment$volatile = channelSegment2;
        this.onUndeliveredElementReceiveCancellationConstructor = function1 != null ? new ListItemKt$$ExternalSyntheticLambda17((byte) 23, (Object) this) : null;
        this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    public static Object m1900receiveCatchingJP2dKIU$suspendImpl(BufferedChannel bufferedChannel, Continuation continuation) {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        ChannelSegment channelSegment;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i = bufferedChannel$receiveCatching$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
            }
        } else {
            bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        }
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$2 = bufferedChannel$receiveCatching$1;
        Object obj = bufferedChannel$receiveCatching$2.result;
        int i2 = bufferedChannel$receiveCatching$2.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return ((ChannelResult) obj).holder;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        ChannelSegment channelSegment2 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(bufferedChannel, receiveSegment$volatile$FU$offset);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(bufferedChannel);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i3 = (int) (andIncrement % j);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i3, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                return null;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return objUpdateCellReceive;
                }
                bufferedChannel$receiveCatching$2.label = 1;
                Object objM1901receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel2.m1901receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i3, andIncrement, bufferedChannel$receiveCatching$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objM1901receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutineSingletons ? coroutineSingletons : objM1901receiveCatchingOnNoWaiterSuspendGKJJFZk;
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
            channelSegment2 = channelSegment;
        }
        return new ChannelResult.Closed(bufferedChannel.getCloseCause());
    }

    public final boolean bufferOrRendezvousSend(long j) {
        return j < getBufferEndCounter() || j < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public final boolean closeOrCancelImpl(Throwable th, boolean z) {
        boolean z2;
        Unsafe unsafe;
        long j;
        long longVolatile;
        long j2;
        Object objectVolatile;
        Unsafe unsafe2;
        Unsafe unsafe3;
        long j3;
        long longVolatile2;
        Unsafe unsafe4;
        long j4;
        long longVolatile3;
        if (z) {
            do {
                unsafe4 = ArtificialStackFramesUnsafe.unsafe;
                j4 = sendersAndCloseStatus$volatile$FU$offset;
                longVolatile3 = unsafe4.getLongVolatile(this, j4);
                if (((int) (longVolatile3 >> 60)) != 0) {
                    break;
                }
                ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
            } while (!unsafe4.compareAndSwapLong(this, j4, longVolatile3, (longVolatile3 & 1152921504606846975L) + 1152921504606846976L));
        }
        Joiner joiner = BufferedChannelKt.NO_CLOSE_CAUSE;
        while (true) {
            Unsafe unsafe5 = ArtificialStackFramesUnsafe.unsafe;
            long j5 = _closeCause$volatile$FU$offset;
            if (unsafe5.compareAndSwapObject(this, j5, joiner, th)) {
                z2 = true;
                break;
            }
            if (unsafe5.getObjectVolatile(this, j5) != joiner) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                j3 = sendersAndCloseStatus$volatile$FU$offset;
                longVolatile2 = unsafe3.getLongVolatile(this, j3);
            } while (!unsafe3.compareAndSwapLong(this, j3, longVolatile2, (longVolatile2 & 1152921504606846975L) + 3458764513820540928L));
        } else {
            do {
                unsafe = ArtificialStackFramesUnsafe.unsafe;
                j = sendersAndCloseStatus$volatile$FU$offset;
                longVolatile = unsafe.getLongVolatile(this, j);
                int i = (int) (longVolatile >> 60);
                if (i == 0) {
                    j2 = (longVolatile & 1152921504606846975L) + 2305843009213693952L;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j2 = (longVolatile & 1152921504606846975L) + 3458764513820540928L;
                }
            } while (!unsafe.compareAndSwapLong(this, j, longVolatile, j2));
        }
        isClosedForSend();
        if (z2) {
            loop3: while (true) {
                Unsafe unsafe6 = ArtificialStackFramesUnsafe.unsafe;
                long j6 = closeHandler$volatile$FU$offset;
                objectVolatile = unsafe6.getObjectVolatile(this, j6);
                Joiner joiner2 = objectVolatile == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                do {
                    unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe2.compareAndSwapObject(this, closeHandler$volatile$FU$offset, objectVolatile, joiner2)) {
                        break loop3;
                    }
                } while (unsafe2.getObjectVolatile(this, j6) == objectVolatile);
            }
            if (objectVolatile != null) {
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, objectVolatile);
                ((Function1) objectVolatile).invoke(getCloseCause());
                return z2;
            }
        }
        return z2;
    }

    public final ChannelSegment completeClose(long j) {
        ConcurrentLinkedListNode concurrentLinkedListNode;
        long j2;
        Unsafe unsafe;
        long j3;
        Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
        Object objectVolatile = unsafe2.getObjectVolatile(this, bufferEndSegment$volatile$FU$offset);
        ChannelSegment channelSegment = (ChannelSegment) unsafe2.getObjectVolatile(this, sendSegment$volatile$FU$offset);
        if (channelSegment.id > ((ChannelSegment) objectVolatile).id) {
            objectVolatile = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) unsafe2.getObjectVolatile(this, receiveSegment$volatile$FU$offset);
        if (channelSegment2.id > ((ChannelSegment) objectVolatile).id) {
            objectVolatile = channelSegment2;
        }
        ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) objectVolatile;
        loop0: while (true) {
            concurrentLinkedListNode = concurrentLinkedListNode2;
            while (true) {
                int i = ConcurrentLinkedListNode.$r8$clinit;
                concurrentLinkedListNode.getClass();
                Object objectVolatile2 = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(concurrentLinkedListNode, ConcurrentLinkedListNode._next$volatile$FU$offset);
                Joiner joiner = InlineList.CLOSED;
                if (objectVolatile2 == joiner) {
                    break loop0;
                }
                concurrentLinkedListNode2 = (ConcurrentLinkedListNode) objectVolatile2;
                if (concurrentLinkedListNode2 == null) {
                    do {
                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                        j3 = ConcurrentLinkedListNode._next$volatile$FU$offset;
                        if (unsafe.compareAndSwapObject(concurrentLinkedListNode, j3, (Object) null, joiner)) {
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(concurrentLinkedListNode, j3) == null);
                }
            }
        }
        ChannelSegment channelSegment3 = (ChannelSegment) concurrentLinkedListNode;
        if (isConflatedDropOldest()) {
            ChannelSegment channelSegment4 = channelSegment3;
            loop3: while (true) {
                int i2 = BufferedChannelKt.SEGMENT_SIZE - 1;
                while (true) {
                    if (-1 < i2) {
                        j2 = (channelSegment4.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i2);
                        if (j2 >= getReceiversCounter$kotlinx_coroutines_core()) {
                            while (true) {
                                Object state$kotlinx_coroutines_core = channelSegment4.getState$kotlinx_coroutines_core(i2);
                                if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                                        break;
                                    }
                                    break loop3;
                                }
                                if (channelSegment4.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    channelSegment4.onSlotCleaned();
                                    break;
                                }
                            }
                            i2--;
                        }
                    } else {
                        channelSegment4 = (ChannelSegment) ((ConcurrentLinkedListNode) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(channelSegment4, ConcurrentLinkedListNode._prev$volatile$FU$offset));
                        if (channelSegment4 == null) {
                        }
                    }
                    j2 = -1;
                    break;
                }
            }
            if (j2 != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(j2);
            }
        }
        Object objM1907plusFjFbRPM = null;
        loop6: for (ChannelSegment channelSegment5 = channelSegment3; channelSegment5 != null; channelSegment5 = (ChannelSegment) ((ConcurrentLinkedListNode) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(channelSegment5, ConcurrentLinkedListNode._prev$volatile$FU$offset))) {
            for (int i3 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i3; i3--) {
                if ((channelSegment5.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i3) < j) {
                    break loop6;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment5.getState$kotlinx_coroutines_core(i3);
                    if (state$kotlinx_coroutines_core2 != null && state$kotlinx_coroutines_core2 != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core2 instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core2 instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment5.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM1907plusFjFbRPM = InlineList.m1907plusFjFbRPM(objM1907plusFjFbRPM, state$kotlinx_coroutines_core2);
                                channelSegment5.onCancelledRequest(i3, true);
                                break;
                            }
                        } else {
                            if (channelSegment5.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                                objM1907plusFjFbRPM = InlineList.m1907plusFjFbRPM(objM1907plusFjFbRPM, ((WaiterEB) state$kotlinx_coroutines_core2).waiter);
                                channelSegment5.onCancelledRequest(i3, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment5.casState$kotlinx_coroutines_core(i3, state$kotlinx_coroutines_core2, BufferedChannelKt.CHANNEL_CLOSED)) {
                            channelSegment5.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
        }
        if (objM1907plusFjFbRPM != null) {
            if (!(objM1907plusFjFbRPM instanceof ArrayList)) {
                resumeWaiterOnClosedChannel((Waiter) objM1907plusFjFbRPM, true);
                return channelSegment3;
            }
            ArrayList arrayList = (ArrayList) objM1907plusFjFbRPM;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), true);
            }
        }
        return channelSegment3;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        HttpException httpExceptionCallUndeliveredElementCatchingException;
        ChannelSegment channelSegment = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, receiveSegment$volatile$FU$offset);
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j2 = receivers$volatile$FU$offset;
            long longVolatile = unsafe.getLongVolatile(this, j2);
            if (j < Math.max(((long) this.capacity) + longVolatile, this.getBufferEndCounter())) {
                return;
            }
            this = this;
            if (unsafe.compareAndSwapLong(this, j2, longVolatile, 1 + longVolatile)) {
                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                long j4 = longVolatile / j3;
                int i = (int) (longVolatile % j3);
                if (channelSegment.id != j4) {
                    ChannelSegment channelSegmentFindSegmentReceive = this.findSegmentReceive(j4, channelSegment);
                    if (channelSegmentFindSegmentReceive != null) {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                }
                ChannelSegment channelSegment2 = channelSegment;
                Object objUpdateCellReceive = this.updateCellReceive(channelSegment2, i, longVolatile, null);
                if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                    channelSegment2.cleanPrev();
                    Function1 function1 = this.onUndeliveredElement;
                    if (function1 != null && (httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, objUpdateCellReceive, null)) != null) {
                        throw httpExceptionCallUndeliveredElementCatchingException;
                    }
                } else if (longVolatile < this.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                channelSegment = channelSegment2;
            }
        }
    }

    public final void expandBuffer() {
        Object objFindSegmentInternal;
        Unsafe unsafe;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
        long j = bufferEndSegment$volatile$FU$offset;
        ChannelSegment channelSegment = (ChannelSegment) unsafe2.getObjectVolatile(this, j);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            long j2 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j2 && channelSegment.getNext() != null) {
                    moveSegmentBufferEndToSpecifiedOrLast(j2, channelSegment);
                }
                incCompletedExpandBufferAttempts(1L);
                return;
            }
            if (channelSegment.id != j2) {
                BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
                while (true) {
                    objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
                    if (!InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                        Segment segmentM1905getSegmentimpl = InlineList.m1905getSegmentimpl(objFindSegmentInternal);
                        while (true) {
                            Segment segment = (Segment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, j);
                            if (segment.id >= segmentM1905getSegmentimpl.id) {
                                break;
                            }
                            if (!segmentM1905getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                                break;
                            }
                            do {
                                unsafe = ArtificialStackFramesUnsafe.unsafe;
                                if (unsafe.compareAndSwapObject(this, bufferEndSegment$volatile$FU$offset, segment, segmentM1905getSegmentimpl)) {
                                    if (!segment.decPointers$kotlinx_coroutines_core()) {
                                        break;
                                    }
                                    segment.remove();
                                    break;
                                }
                            } while (unsafe.getObjectVolatile(this, j) == segment);
                            if (segmentM1905getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM1905getSegmentimpl.remove();
                            }
                        }
                    } else {
                        break;
                    }
                }
                ChannelSegment channelSegment2 = null;
                if (InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                    isClosedForSend();
                    moveSegmentBufferEndToSpecifiedOrLast(j2, channelSegment);
                    incCompletedExpandBufferAttempts(1L);
                } else {
                    ChannelSegment channelSegment3 = (ChannelSegment) InlineList.m1905getSegmentimpl(objFindSegmentInternal);
                    long j3 = channelSegment3.id;
                    if (j3 > j2) {
                        long j4 = ((long) BufferedChannelKt.SEGMENT_SIZE) * j3;
                        if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapLong(this, bufferEnd$volatile$FU$offset, 1 + andIncrement, j4)) {
                            incCompletedExpandBufferAttempts(j4 - andIncrement);
                        } else {
                            incCompletedExpandBufferAttempts(1L);
                        }
                    } else {
                        channelSegment2 = channelSegment3;
                    }
                }
                if (channelSegment2 == null) {
                    continue;
                } else {
                    channelSegment = channelSegment2;
                }
            }
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            boolean z = state$kotlinx_coroutines_core instanceof Waiter;
            long j5 = receivers$volatile$FU$offset;
            if (!z || andIncrement < ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, j5) || !channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                while (true) {
                    Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core2 instanceof Waiter) {
                        if (andIncrement < ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, j5)) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, new WaiterEB((Waiter) state$kotlinx_coroutines_core2))) {
                                incCompletedExpandBufferAttempts(1L);
                                return;
                            }
                        } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.RESUMING_BY_EB)) {
                            if (!tryResumeSender(state$kotlinx_coroutines_core2, channelSegment, i)) {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                                channelSegment.onSlotCleaned();
                                break;
                            } else {
                                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                                incCompletedExpandBufferAttempts(1L);
                                return;
                            }
                        }
                    } else {
                        if (state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_SEND) {
                            break;
                        }
                        if (state$kotlinx_coroutines_core2 == null) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.IN_BUFFER)) {
                                incCompletedExpandBufferAttempts(1L);
                                return;
                            }
                        } else if (state$kotlinx_coroutines_core2 == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core2 == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                            incCompletedExpandBufferAttempts(1L);
                            return;
                        } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_RCV) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(state$kotlinx_coroutines_core2, "Unexpected cell state: ");
                            return;
                        }
                    }
                }
                incCompletedExpandBufferAttempts(1L);
            } else if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                incCompletedExpandBufferAttempts(1L);
                return;
            } else {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                channelSegment.onSlotCleaned();
                incCompletedExpandBufferAttempts(1L);
            }
        }
    }

    public final ChannelSegment findSegmentReceive(long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        ChannelSegment channelSegment2;
        Unsafe unsafe;
        long j2;
        long longVolatile;
        Unsafe unsafe2;
        ChannelSegment channelSegment3 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (!InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM1905getSegmentimpl = InlineList.m1905getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                    long j3 = receiveSegment$volatile$FU$offset;
                    Segment segment = (Segment) unsafe3.getObjectVolatile(this, j3);
                    if (segment.id >= segmentM1905getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM1905getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe2.compareAndSwapObject(this, receiveSegment$volatile$FU$offset, segment, segmentM1905getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (unsafe2.getObjectVolatile(this, j3) == segment);
                    if (segmentM1905getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM1905getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
            isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
                return null;
            }
        } else {
            ChannelSegment channelSegment4 = (ChannelSegment) InlineList.m1905getSegmentimpl(objFindSegmentInternal);
            long j4 = channelSegment4.id;
            if (isRendezvousOrUnlimited() || j > getBufferEndCounter() / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
                channelSegment2 = channelSegment4;
                break;
            }
            loop3: while (true) {
                Unsafe unsafe4 = ArtificialStackFramesUnsafe.unsafe;
                long j5 = bufferEndSegment$volatile$FU$offset;
                Segment segment2 = (Segment) unsafe4.getObjectVolatile(this, j5);
                if (segment2.id >= j4 || !channelSegment4.tryIncPointers$kotlinx_coroutines_core()) {
                    channelSegment2 = channelSegment4;
                    break;
                }
                while (true) {
                    Unsafe unsafe5 = ArtificialStackFramesUnsafe.unsafe;
                    channelSegment2 = channelSegment4;
                    if (unsafe5.compareAndSwapObject(this, bufferEndSegment$volatile$FU$offset, segment2, channelSegment4)) {
                        if (!segment2.decPointers$kotlinx_coroutines_core()) {
                            break loop3;
                        }
                        segment2.remove();
                        break loop3;
                    }
                    if (unsafe5.getObjectVolatile(this, j5) != segment2) {
                        break;
                    }
                    channelSegment4 = channelSegment2;
                }
                if (channelSegment2.decPointers$kotlinx_coroutines_core()) {
                    channelSegment2.remove();
                }
                channelSegment4 = channelSegment2;
            }
            if (j4 <= j) {
                return channelSegment2;
            }
            long j6 = j4 * ((long) BufferedChannelKt.SEGMENT_SIZE);
            do {
                unsafe = ArtificialStackFramesUnsafe.unsafe;
                j2 = receivers$volatile$FU$offset;
                longVolatile = unsafe.getLongVolatile(this, j2);
                if (longVolatile >= j6) {
                    break;
                }
            } while (!unsafe.compareAndSwapLong(this, j2, longVolatile, j6));
            if (j4 * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
        }
        return null;
    }

    public final ChannelSegment findSegmentSend(long j, ChannelSegment channelSegment) {
        Object objFindSegmentInternal;
        ChannelSegment channelSegment2;
        long j2;
        Unsafe unsafe;
        BufferedChannel bufferedChannel = this;
        ChannelSegment channelSegment3 = BufferedChannelKt.NULL_SEGMENT;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.INSTANCE;
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(channelSegment, j, bufferedChannelKt$createSegmentFunction$1);
            if (!InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM1905getSegmentimpl = InlineList.m1905getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    long j3 = sendSegment$volatile$FU$offset;
                    Segment segment = (Segment) unsafe2.getObjectVolatile(bufferedChannel, j3);
                    if (segment.id >= segmentM1905getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM1905getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    do {
                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe.compareAndSwapObject(bufferedChannel, sendSegment$volatile$FU$offset, segment, segmentM1905getSegmentimpl)) {
                            if (!segment.decPointers$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            segment.remove();
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(bufferedChannel, j3) == segment);
                    if (segmentM1905getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM1905getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        ChannelSegment channelSegment4 = null;
        if (InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
            bufferedChannel.isClosedForSend();
            if (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE) >= bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment channelSegment5 = (ChannelSegment) InlineList.m1905getSegmentimpl(objFindSegmentInternal);
        long j4 = channelSegment5.id;
        if (j4 <= j) {
            return channelSegment5;
        }
        long j5 = j4 * ((long) BufferedChannelKt.SEGMENT_SIZE);
        while (true) {
            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
            long j6 = sendersAndCloseStatus$volatile$FU$offset;
            long longVolatile = unsafe3.getLongVolatile(bufferedChannel, j6);
            long j7 = 1152921504606846975L & longVolatile;
            if (j7 >= j5) {
                channelSegment2 = channelSegment4;
                j2 = j4;
                break;
            }
            channelSegment2 = channelSegment4;
            j2 = j4;
            if (unsafe3.compareAndSwapLong(bufferedChannel, j6, longVolatile, j7 + (((long) ((int) (longVolatile >> 60))) << 60))) {
                break;
            }
            bufferedChannel = this;
            channelSegment4 = channelSegment2;
            j4 = j2;
        }
        if (j2 * ((long) BufferedChannelKt.SEGMENT_SIZE) >= getReceiversCounter$kotlinx_coroutines_core()) {
            return channelSegment2;
        }
        channelSegment5.cleanPrev();
        return channelSegment2;
    }

    public final long getBufferEndCounter() {
        return ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, bufferEnd$volatile$FU$offset);
    }

    public final Throwable getCloseCause() {
        return (Throwable) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _closeCause$volatile$FU$offset);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceive$1);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceive$2);
        return new Dispatcher(this, bufferedChannel$onReceive$1, bufferedChannel$onReceive$2, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveCatching$1);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveCatching$2);
        return new Dispatcher(this, bufferedChannel$onReceiveCatching$1, bufferedChannel$onReceiveCatching$2, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveOrNull$1);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, bufferedChannel$onReceiveOrNull$2);
        return new Dispatcher(this, bufferedChannel$onReceiveOrNull$1, bufferedChannel$onReceiveOrNull$2, this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, BufferedChannel$onSend$1.INSTANCE);
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, BufferedChannel$onSend$2.INSTANCE);
        return new SelectClause2Impl();
    }

    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException("Channel was closed") : closeCause;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, receivers$volatile$FU$offset);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException("Channel was closed") : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, sendersAndCloseStatus$volatile$FU$offset) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = receiveSegment$volatile$FU$offset;
            ChannelSegment channelSegmentFindSegmentReceive = (ChannelSegment) unsafe.getObjectVolatile(this, j);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = receiversCounter$kotlinx_coroutines_core / ((long) i);
            if (channelSegmentFindSegmentReceive.id == j2 || (channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegmentFindSegmentReceive)) != null) {
                channelSegmentFindSegmentReceive.cleanPrev();
                int i2 = (int) (receiversCounter$kotlinx_coroutines_core % ((long) i));
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegmentFindSegmentReceive.getState$kotlinx_coroutines_core(i2);
                    if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                            if (state$kotlinx_coroutines_core != BufferedChannelKt.INTERRUPTED_SEND && state$kotlinx_coroutines_core != BufferedChannelKt.CHANNEL_CLOSED && state$kotlinx_coroutines_core != BufferedChannelKt.DONE_RCV && state$kotlinx_coroutines_core != BufferedChannelKt.POISONED) {
                                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB) {
                                    if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_RCV || receiversCounter$kotlinx_coroutines_core != getReceiversCounter$kotlinx_coroutines_core()) {
                                        break;
                                        break;
                                    }
                                    return true;
                                }
                                return true;
                            }
                            break;
                            break;
                            break;
                            break;
                        }
                        return true;
                    }
                    if (channelSegmentFindSegmentReceive.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        break;
                    }
                }
                ArtificialStackFramesUnsafe.unsafe.compareAndSwapLong(this, receivers$volatile$FU$offset, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            } else if (((ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, j)).id < j2) {
                return false;
            }
        }
    }

    public final void incCompletedExpandBufferAttempts(long j) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, j) & 4611686018427387904L) != 0) {
            while ((ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, completedExpandBuffersAndPauseFlag$volatile$FU$offset) & 4611686018427387904L) != 0) {
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 function1) {
        while (true) {
            BufferedChannel bufferedChannel = this;
            if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapObject(bufferedChannel, closeHandler$volatile$FU$offset, (Object) null, function1)) {
                return;
            }
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = closeHandler$volatile$FU$offset;
            if (unsafe.getObjectVolatile(bufferedChannel, j) != null) {
                while (true) {
                    Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(bufferedChannel, j);
                    Joiner joiner = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
                    if (objectVolatile != joiner) {
                        if (objectVolatile == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Another handler was already registered and successfully invoked");
                            return;
                        } else {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "Another handler is already registered: ");
                            return;
                        }
                    }
                    Joiner joiner2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                    do {
                        if (ArtificialStackFramesUnsafe.unsafe.compareAndSwapObject(bufferedChannel, closeHandler$volatile$FU$offset, joiner, joiner2)) {
                            function1.invoke(bufferedChannel.getCloseCause());
                            return;
                        }
                    } while (ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(bufferedChannel, j) == joiner);
                }
            } else {
                this = bufferedChannel;
            }
        }
    }

    public final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i != 0 && i != 1) {
            if (i == 2) {
                completeClose(j & 1152921504606846975L);
                if (!z || !hasElements$kotlinx_coroutines_core()) {
                }
            } else {
                if (i != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "unexpected close status: "));
                    return false;
                }
                ChannelSegment channelSegmentCompleteClose = completeClose(j & 1152921504606846975L);
                HttpException httpExceptionCallUndeliveredElementCatchingException = null;
                Object objM1907plusFjFbRPM = null;
                loop0: do {
                    AtomicReferenceArray atomicReferenceArray = channelSegmentCompleteClose.data;
                    for (int i2 = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i2; i2--) {
                        long j2 = (channelSegmentCompleteClose.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i2);
                        while (true) {
                            Object state$kotlinx_coroutines_core = channelSegmentCompleteClose.getState$kotlinx_coroutines_core(i2);
                            if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV) {
                                break loop0;
                            }
                            Joiner joiner = BufferedChannelKt.BUFFERED;
                            Function1 function1 = this.onUndeliveredElement;
                            if (state$kotlinx_coroutines_core != joiner) {
                                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER && state$kotlinx_coroutines_core != null) {
                                    if (!(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                                        Joiner joiner2 = BufferedChannelKt.RESUMING_BY_EB;
                                        if (state$kotlinx_coroutines_core == joiner2 || state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_RCV) {
                                            break loop0;
                                        }
                                        if (state$kotlinx_coroutines_core != joiner2) {
                                            break;
                                        }
                                    } else {
                                        if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                            break loop0;
                                        }
                                        Waiter waiter = state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : (Waiter) state$kotlinx_coroutines_core;
                                        if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED)) {
                                            if (function1 != null) {
                                                httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, atomicReferenceArray.get(i2 * 2), httpExceptionCallUndeliveredElementCatchingException);
                                            }
                                            objM1907plusFjFbRPM = InlineList.m1907plusFjFbRPM(objM1907plusFjFbRPM, waiter);
                                            channelSegmentCompleteClose.setElementLazy(i2, null);
                                            channelSegmentCompleteClose.onSlotCleaned();
                                            break;
                                        }
                                    }
                                } else {
                                    if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED)) {
                                        channelSegmentCompleteClose.onSlotCleaned();
                                        break;
                                    }
                                }
                            } else {
                                if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    break loop0;
                                }
                                if (channelSegmentCompleteClose.casState$kotlinx_coroutines_core(i2, state$kotlinx_coroutines_core, BufferedChannelKt.CHANNEL_CLOSED)) {
                                    if (function1 != null) {
                                        httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, atomicReferenceArray.get(i2 * 2), httpExceptionCallUndeliveredElementCatchingException);
                                    }
                                    channelSegmentCompleteClose.setElementLazy(i2, null);
                                    channelSegmentCompleteClose.onSlotCleaned();
                                    break;
                                }
                            }
                        }
                    }
                    channelSegmentCompleteClose = (ChannelSegment) ((ConcurrentLinkedListNode) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(channelSegmentCompleteClose, ConcurrentLinkedListNode._prev$volatile$FU$offset));
                } while (channelSegmentCompleteClose != null);
                if (objM1907plusFjFbRPM != null) {
                    if (objM1907plusFjFbRPM instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objM1907plusFjFbRPM;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            resumeWaiterOnClosedChannel((Waiter) arrayList.get(size), false);
                        }
                    } else {
                        resumeWaiterOnClosedChannel((Waiter) objM1907plusFjFbRPM, false);
                    }
                }
                if (httpExceptionCallUndeliveredElementCatchingException != null) {
                    throw httpExceptionCallUndeliveredElementCatchingException;
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return isClosed(ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, sendersAndCloseStatus$volatile$FU$offset), true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return isClosed(ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, sendersAndCloseStatus$volatile$FU$offset), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    public final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    public final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment channelSegment) {
        BufferedChannel bufferedChannel;
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            ChannelSegment channelSegment4 = channelSegment;
            while (channelSegment4.isRemoved() && (channelSegment2 = (ChannelSegment) channelSegment4.getNext()) != null) {
                channelSegment4 = channelSegment2;
            }
            while (true) {
                Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                long j2 = bufferEndSegment$volatile$FU$offset;
                Segment segment = (Segment) unsafe.getObjectVolatile(this, j2);
                if (segment.id >= channelSegment4.id) {
                    return;
                }
                if (!channelSegment4.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (true) {
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    bufferedChannel = this;
                    if (unsafe2.compareAndSwapObject(bufferedChannel, bufferEndSegment$volatile$FU$offset, segment, channelSegment4)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                            return;
                        }
                        return;
                    } else if (unsafe2.getObjectVolatile(bufferedChannel, j2) != segment) {
                        break;
                    } else {
                        this = bufferedChannel;
                    }
                }
                if (channelSegment4.decPointers$kotlinx_coroutines_core()) {
                    channelSegment4.remove();
                }
                this = bufferedChannel;
            }
            channelSegment = channelSegment4;
        }
    }

    public final Object onClosedSend(Object obj, Continuation continuation) {
        HttpException httpExceptionCallUndeliveredElementCatchingException;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        Function1 function1 = this.onUndeliveredElement;
        if (function1 == null || (httpExceptionCallUndeliveredElementCatchingException = InlineList.callUndeliveredElementCatchingException(function1, obj, null)) == null) {
            cancellableContinuationImpl.resumeWith(new Result.Failure(getSendException()));
        } else {
            ResultKt.addSuppressed(httpExceptionCallUndeliveredElementCatchingException, getSendException());
            cancellableContinuationImpl.resumeWith(new Result.Failure(httpExceptionCallUndeliveredElementCatchingException));
        }
        Object result = cancellableContinuationImpl.getResult();
        return result == CoroutineSingletons.COROUTINE_SUSPENDED ? result : Unit.INSTANCE;
    }

    public final void onClosedSendOnNoWaiterSuspend(Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
        Function1 function1 = this.onUndeliveredElement;
        if (function1 != null) {
            InlineList.callUndeliveredElement(function1, obj, cancellableContinuationImpl.context);
        }
        cancellableContinuationImpl.resumeWith(new Result.Failure(getSendException()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.CancellableContinuationImpl] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation continuation) {
        ChannelSegment channelSegment;
        Throwable th;
        ?? r1;
        CancellableContinuationImpl cancellableContinuationImpl;
        BufferedChannel$bindCancellationFun$2 bufferedChannel$bindCancellationFun$2;
        ChannelSegment channelSegment2;
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        ?? r2 = receiveSegment$volatile$FU$offset;
        ChannelSegment channelSegment3 = (ChannelSegment) unsafe.getObjectVolatile(this, (long) r2);
        while (!this.isClosedForReceive()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (channelSegment3.id != j2) {
                ChannelSegment channelSegmentFindSegmentReceive = this.findSegmentReceive(j2, channelSegment3);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment3;
            }
            BufferedChannel bufferedChannel = this;
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, null);
            Joiner joiner = BufferedChannelKt.SUSPEND;
            BufferedChannel$bindCancellationFun$2 bufferedChannel$bindCancellationFun$3 = null;
            if (objUpdateCellReceive == joiner) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                return null;
            }
            Joiner joiner2 = BufferedChannelKt.FAILED;
            if (objUpdateCellReceive == joiner2) {
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                this = bufferedChannel;
                channelSegment3 = channelSegment;
            } else {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return objUpdateCellReceive;
                }
                CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(continuation));
                try {
                    Object objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, orCreateCancellableContinuation);
                    try {
                        if (objUpdateCellReceive2 == joiner) {
                            orCreateCancellableContinuation.invokeOnCancellation(channelSegment, i);
                        } else {
                            Function1 function1 = bufferedChannel.onUndeliveredElement;
                            try {
                                if (objUpdateCellReceive2 == joiner2) {
                                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment.cleanPrev();
                                    }
                                    ChannelSegment channelSegment4 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(bufferedChannel, (long) r2);
                                    while (true) {
                                        if (bufferedChannel.isClosedForReceive()) {
                                            orCreateCancellableContinuation.resumeWith(new Result.Failure(bufferedChannel.getReceiveException()));
                                        } else {
                                            CancellableContinuationImpl cancellableContinuationImpl2 = orCreateCancellableContinuation;
                                            try {
                                                long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(bufferedChannel);
                                                long j3 = BufferedChannelKt.SEGMENT_SIZE;
                                                long j4 = andIncrement2 / j3;
                                                int i2 = (int) (andIncrement2 % j3);
                                                if (channelSegment4.id != j4) {
                                                    try {
                                                        ChannelSegment channelSegmentFindSegmentReceive2 = bufferedChannel.findSegmentReceive(j4, channelSegment4);
                                                        if (channelSegmentFindSegmentReceive2 == null) {
                                                            orCreateCancellableContinuation = cancellableContinuationImpl2;
                                                        } else {
                                                            channelSegment2 = channelSegmentFindSegmentReceive2;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        r1 = cancellableContinuationImpl2;
                                                        r1.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                                        throw th;
                                                    }
                                                } else {
                                                    channelSegment2 = channelSegment4;
                                                }
                                                BufferedChannel bufferedChannel2 = bufferedChannel;
                                                objUpdateCellReceive2 = bufferedChannel2.updateCellReceive(channelSegment2, i2, andIncrement2, cancellableContinuationImpl2);
                                                bufferedChannel = bufferedChannel2;
                                                ChannelSegment channelSegment5 = channelSegment2;
                                                cancellableContinuationImpl = cancellableContinuationImpl2;
                                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                                    cancellableContinuationImpl.invokeOnCancellation(channelSegment5, i2);
                                                } else if (objUpdateCellReceive2 == BufferedChannelKt.FAILED) {
                                                    if (andIncrement2 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                                        channelSegment5.cleanPrev();
                                                    }
                                                    channelSegment4 = channelSegment5;
                                                    orCreateCancellableContinuation = cancellableContinuationImpl;
                                                } else {
                                                    if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    channelSegment5.cleanPrev();
                                                    if (function1 != null) {
                                                        bufferedChannel$bindCancellationFun$2 = new BufferedChannel$bindCancellationFun$2(3, bufferedChannel, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 0);
                                                        bufferedChannel$bindCancellationFun$3 = bufferedChannel$bindCancellationFun$2;
                                                    }
                                                    cancellableContinuationImpl.resume(objUpdateCellReceive2, bufferedChannel$bindCancellationFun$3);
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                r2 = cancellableContinuationImpl2;
                                                th = th;
                                                r1 = r2;
                                                r1.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                                                throw th;
                                            }
                                        }
                                    }
                                } else {
                                    cancellableContinuationImpl = orCreateCancellableContinuation;
                                    channelSegment.cleanPrev();
                                    if (function1 != null) {
                                        bufferedChannel$bindCancellationFun$2 = new BufferedChannel$bindCancellationFun$2(3, bufferedChannel, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 0);
                                        bufferedChannel$bindCancellationFun$3 = bufferedChannel$bindCancellationFun$2;
                                    }
                                    cancellableContinuationImpl.resume(objUpdateCellReceive2, bufferedChannel$bindCancellationFun$3);
                                }
                                return cancellableContinuationImpl.getResult();
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        cancellableContinuationImpl = orCreateCancellableContinuation;
                        return cancellableContinuationImpl.getResult();
                    } catch (Throwable th5) {
                        th = th5;
                        r1 = orCreateCancellableContinuation;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r2 = orCreateCancellableContinuation;
                }
            }
        }
        Throwable receiveException = this.getReceiveException();
        int i3 = StackTraceRecoveryKt.$r8$clinit;
        throw receiveException;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    public final Object mo1860receiveCatchingJP2dKIU(Continuation continuation) {
        return m1900receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX INFO: renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    public final Object m1901receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment channelSegment, int i, long j, ContinuationImpl continuationImpl) {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        ChannelResult channelResult;
        BufferedChannel$bindCancellationFun$2 bufferedChannel$bindCancellationFun$2;
        if (continuationImpl instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuationImpl;
            int i2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i2 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuationImpl);
            }
        } else {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuationImpl);
        }
        Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        int i3 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        BufferedChannel$bindCancellationFun$2 bufferedChannel$bindCancellationFun$3 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
            CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
            try {
                ReceiveCatching receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
                Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, receiveCatching);
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                    receiveCatching.invokeOnCancellation(channelSegment, i);
                } else {
                    Object obj = BufferedChannelKt.FAILED;
                    Function1 function1 = this.onUndeliveredElement;
                    if (objUpdateCellReceive == obj) {
                        if (j < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, receiveSegment$volatile$FU$offset);
                        while (true) {
                            if (isClosedForReceive()) {
                                orCreateCancellableContinuation.resumeWith(new ChannelResult(new ChannelResult.Closed(getCloseCause())));
                            } else {
                                long andIncrement = receivers$volatile$FU.getAndIncrement(this);
                                long j2 = BufferedChannelKt.SEGMENT_SIZE;
                                long j3 = andIncrement / j2;
                                int i4 = (int) (andIncrement % j2);
                                if (channelSegment2.id != j3) {
                                    ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j3, channelSegment2);
                                    if (channelSegmentFindSegmentReceive != null) {
                                        channelSegment2 = channelSegmentFindSegmentReceive;
                                    }
                                }
                                Object objUpdateCellReceive2 = updateCellReceive(channelSegment2, i4, andIncrement, receiveCatching);
                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                    receiveCatching.invokeOnCancellation(channelSegment2, i4);
                                } else if (objUpdateCellReceive2 == BufferedChannelKt.FAILED) {
                                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegment2.cleanPrev();
                                    }
                                } else {
                                    if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegment2.cleanPrev();
                                    channelResult = new ChannelResult(objUpdateCellReceive2);
                                    if (function1 != null) {
                                        bufferedChannel$bindCancellationFun$2 = new BufferedChannel$bindCancellationFun$2(3, this, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 2);
                                        bufferedChannel$bindCancellationFun$3 = bufferedChannel$bindCancellationFun$2;
                                    }
                                    orCreateCancellableContinuation.resume(channelResult, bufferedChannel$bindCancellationFun$3);
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        channelResult = new ChannelResult(objUpdateCellReceive);
                        if (function1 != null) {
                            bufferedChannel$bindCancellationFun$2 = new BufferedChannel$bindCancellationFun$2(3, this, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 2);
                            bufferedChannel$bindCancellationFun$3 = bufferedChannel$bindCancellationFun$2;
                        }
                        orCreateCancellableContinuation.resume(channelResult, bufferedChannel$bindCancellationFun$3);
                    }
                }
                result = orCreateCancellableContinuation.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(result);
        }
        return ((ChannelResult) result).holder;
    }

    public final void registerSelectForReceive(SelectImplementation selectImplementation) {
        ChannelSegment channelSegment;
        SelectImplementation selectImplementation2;
        ChannelSegment channelSegment2 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, receiveSegment$volatile$FU$offset);
        while (!this.isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentReceive = this.findSegmentReceive(j2, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object objUpdateCellReceive = this.updateCellReceive(channelSegment, i, andIncrement, selectImplementation);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                if (selectImplementation == 0) {
                    selectImplementation2 = null;
                }
                if (selectImplementation2 == null) {
                    selectImplementation2 = selectImplementation;
                    return;
                }
                selectImplementation2 = selectImplementation;
                selectImplementation2.disposableHandleOrSegment = channelSegment2;
                selectImplementation2.indexInSegment = i;
                return;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                    return;
                } else {
                    channelSegment2.cleanPrev();
                    selectImplementation.internalResult = objUpdateCellReceive;
                    return;
                }
            }
            if (andIncrement < this.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            this = this;
            selectImplementation = selectImplementation;
        }
        selectImplementation.internalResult = BufferedChannelKt.CHANNEL_CLOSED;
    }

    public void registerSelectForSend(SelectImplementation selectImplementation, Object obj) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, sendSegment$volatile$FU$offset);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosed = this.isClosed(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = i;
            long j3 = j / j2;
            int i2 = (int) (j % j2);
            long j4 = channelSegment2.id;
            Function1 function1 = this.onUndeliveredElement;
            if (j4 != j3) {
                ChannelSegment channelSegmentFindSegmentSend = this.findSegmentSend(j3, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosed) {
                    if (function1 != null) {
                        InlineList.callUndeliveredElement(function1, obj, selectImplementation.context);
                    }
                    selectImplementation.internalResult = BufferedChannelKt.CHANNEL_CLOSED;
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel = this;
            SelectImplementation selectImplementation2 = selectImplementation;
            Object obj2 = obj;
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, obj2, j, selectImplementation2, zIsClosed);
            channelSegment2 = channelSegment;
            Unit unit = Unit.INSTANCE;
            if (iUpdateCellSend == 0) {
                channelSegment2.cleanPrev();
                selectImplementation2.internalResult = unit;
                return;
            }
            if (iUpdateCellSend == 1) {
                selectImplementation2.internalResult = unit;
                return;
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosed) {
                    channelSegment2.onSlotCleaned();
                    if (function1 != null) {
                        InlineList.callUndeliveredElement(function1, obj2, selectImplementation2.context);
                    }
                    selectImplementation2.internalResult = BufferedChannelKt.CHANNEL_CLOSED;
                    return;
                }
                Waiter waiter = selectImplementation2 != null ? selectImplementation2 : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment2, i2 + i);
                    return;
                }
                return;
            }
            if (iUpdateCellSend == 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                return;
            }
            if (iUpdateCellSend == 4) {
                if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                if (function1 != null) {
                    InlineList.callUndeliveredElement(function1, obj2, selectImplementation2.context);
                }
                selectImplementation2.internalResult = BufferedChannelKt.CHANNEL_CLOSED;
                return;
            }
            if (iUpdateCellSend == 5) {
                channelSegment2.cleanPrev();
            }
            this = bufferedChannel;
            obj = obj2;
            selectImplementation = selectImplementation2;
        }
    }

    public final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof CancellableContinuation) {
            ((Continuation) waiter).resumeWith(new Result.Failure(z ? getReceiveException() : getSendException()));
            return;
        }
        if (waiter instanceof ReceiveCatching) {
            ((ReceiveCatching) waiter).cont.resumeWith(new ChannelResult(new ChannelResult.Closed(getCloseCause())));
            return;
        }
        if (!(waiter instanceof BufferedChannelIterator)) {
            if (waiter instanceof SelectImplementation) {
                ((SelectImplementation) waiter).trySelectInternal(this, BufferedChannelKt.CHANNEL_CLOSED);
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(waiter, "Unexpected waiter: ");
                return;
            }
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
        CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.continuation;
        cancellableContinuationImpl.getClass();
        bufferedChannelIterator.continuation = null;
        bufferedChannelIterator.receiveResult = BufferedChannelKt.CHANNEL_CLOSED;
        Throwable closeCause = BufferedChannel.this.getCloseCause();
        if (closeCause == null) {
            cancellableContinuationImpl.resumeWith(Boolean.FALSE);
        } else {
            cancellableContinuationImpl.resumeWith(new Result.Failure(closeCause));
        }
    }

    /* JADX WARN: Code duplicated, block: B:88:0x0162  */
    /* JADX WARN: Code duplicated, block: B:90:0x0165 A[RETURN] */
    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(Object obj, Continuation continuation) {
        Unit unit;
        Object result;
        CoroutineSingletons coroutineSingletons;
        int i;
        BufferedChannel bufferedChannel = this;
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = sendSegment$volatile$FU$offset;
        ChannelSegment channelSegment = (ChannelSegment) unsafe.getObjectVolatile(bufferedChannel, j);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(bufferedChannel);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zIsClosed = bufferedChannel.isClosed(andIncrement, false);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = i2;
            long j4 = j2 / j3;
            int i3 = (int) (j2 % j3);
            long j5 = channelSegment.id;
            CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            unit = Unit.INSTANCE;
            if (j5 != j4) {
                ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j4, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosed) {
                    Object objOnClosedSend = onClosedSend(obj, continuation);
                    if (objOnClosedSend == coroutineSingletons2) {
                        return objOnClosedSend;
                    }
                }
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i3, obj, j2, null, zIsClosed);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return unit;
            }
            if (iUpdateCellSend != 1) {
                if (iUpdateCellSend == 2) {
                    if (!zIsClosed) {
                        break;
                    }
                    channelSegment.onSlotCleaned();
                    Object objOnClosedSend2 = onClosedSend(obj, continuation);
                    if (objOnClosedSend2 == coroutineSingletons2) {
                        return objOnClosedSend2;
                    }
                } else if (iUpdateCellSend == 3) {
                    CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(continuation));
                    try {
                        int iUpdateCellSend2 = updateCellSend(channelSegment, i3, obj, j2, orCreateCancellableContinuation, false);
                        if (iUpdateCellSend2 != 0) {
                            if (iUpdateCellSend2 == 1) {
                                coroutineSingletons2 = coroutineSingletons2;
                                orCreateCancellableContinuation.resumeWith(unit);
                            } else if (iUpdateCellSend2 != 2) {
                                if (iUpdateCellSend2 != 4) {
                                    String str = "unexpected";
                                    if (iUpdateCellSend2 != 5) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegment.cleanPrev();
                                    ChannelSegment channelSegment2 = (ChannelSegment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, j);
                                    while (true) {
                                        long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                        long j6 = andIncrement2 & 1152921504606846975L;
                                        boolean zIsClosed2 = isClosed(andIncrement2, false);
                                        int i4 = BufferedChannelKt.SEGMENT_SIZE;
                                        atomicLongFieldUpdater = atomicLongFieldUpdater;
                                        long j7 = i4;
                                        coroutineSingletons2 = coroutineSingletons2;
                                        long j8 = j6 / j7;
                                        int i5 = (int) (j6 % j7);
                                        if (channelSegment2.id != j8) {
                                            ChannelSegment channelSegmentFindSegmentSend2 = findSegmentSend(j8, channelSegment2);
                                            if (channelSegmentFindSegmentSend2 != null) {
                                                i = i5;
                                                channelSegment2 = channelSegmentFindSegmentSend2;
                                            } else if (zIsClosed2) {
                                            }
                                        } else {
                                            i = i5;
                                        }
                                        int iUpdateCellSend3 = updateCellSend(channelSegment2, i, obj, j6, orCreateCancellableContinuation, zIsClosed2);
                                        if (iUpdateCellSend3 == 0) {
                                            channelSegment2.cleanPrev();
                                        } else if (iUpdateCellSend3 != 1) {
                                            if (iUpdateCellSend3 == 2) {
                                                if (!zIsClosed2) {
                                                    orCreateCancellableContinuation.invokeOnCancellation(channelSegment2, i + i4);
                                                    break;
                                                }
                                                channelSegment2.onSlotCleaned();
                                            } else {
                                                if (iUpdateCellSend3 == 3) {
                                                    throw new IllegalStateException(str);
                                                }
                                                if (iUpdateCellSend3 != 4) {
                                                    if (iUpdateCellSend3 == 5) {
                                                        channelSegment2.cleanPrev();
                                                    }
                                                    str = str;
                                                } else if (j6 < getReceiversCounter$kotlinx_coroutines_core()) {
                                                    channelSegment2.cleanPrev();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    coroutineSingletons2 = coroutineSingletons2;
                                    if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                        channelSegment.cleanPrev();
                                    }
                                }
                                onClosedSendOnNoWaiterSuspend(obj, orCreateCancellableContinuation);
                                break;
                            } else {
                                coroutineSingletons2 = coroutineSingletons2;
                                orCreateCancellableContinuation.invokeOnCancellation(channelSegment, i3 + i2);
                            }
                            result = orCreateCancellableContinuation.getResult();
                            coroutineSingletons = coroutineSingletons2;
                            if (result != coroutineSingletons) {
                                result = unit;
                            }
                            if (result == coroutineSingletons) {
                                return result;
                            }
                        } else {
                            coroutineSingletons2 = coroutineSingletons2;
                            channelSegment.cleanPrev();
                        }
                        orCreateCancellableContinuation.resumeWith(unit);
                        result = orCreateCancellableContinuation.getResult();
                        coroutineSingletons = coroutineSingletons2;
                        if (result != coroutineSingletons) {
                            result = unit;
                        }
                        if (result == coroutineSingletons) {
                            return result;
                        }
                    } catch (Throwable th) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th;
                    }
                } else if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    bufferedChannel = this;
                } else {
                    if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object objOnClosedSend3 = onClosedSend(obj, continuation);
                    if (objOnClosedSend3 == coroutineSingletons2) {
                        return objOnClosedSend3;
                    }
                }
            } else {
                break;
            }
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        int longVolatile = (int) (unsafe.getLongVolatile(this, sendersAndCloseStatus$volatile$FU$offset) >> 60);
        if (longVolatile == 2) {
            sb.append("closed,");
        } else if (longVolatile == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        int i = 0;
        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new ChannelSegment[]{unsafe.getObjectVolatile(this, receiveSegment$volatile$FU$offset), unsafe.getObjectVolatile(this, sendSegment$volatile$FU$offset), unsafe.getObjectVolatile(this, bufferEndSegment$volatile$FU$offset)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            for (int i3 = i; i3 < i2; i3++) {
                long j3 = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i3);
                if (j3 >= sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                Object obj2 = channelSegment.data.get(i3 * 2);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    string = (sendersCounter$kotlinx_coroutines_core > j3 || j3 >= receiversCounter$kotlinx_coroutines_core) ? (receiversCounter$kotlinx_coroutines_core > j3 || j3 >= sendersCounter$kotlinx_coroutines_core) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof SelectImplementation) {
                    string = (sendersCounter$kotlinx_coroutines_core > j3 || j3 >= receiversCounter$kotlinx_coroutines_core) ? (receiversCounter$kotlinx_coroutines_core > j3 || j3 >= sendersCounter$kotlinx_coroutines_core) ? "select" : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    string = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    string = "EB(" + state$kotlinx_coroutines_core + ')';
                } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else {
                    if (state$kotlinx_coroutines_core != null && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.IN_BUFFER) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.DONE_RCV) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.POISONED) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.INTERRUPTED_RCV) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.INTERRUPTED_SEND) && !state$kotlinx_coroutines_core.equals(BufferedChannelKt.CHANNEL_CLOSED)) {
                        string = state$kotlinx_coroutines_core.toString();
                    }
                }
                if (obj2 != null) {
                    sb.append("(" + string + ',' + obj2 + "),");
                } else {
                    sb.append(string + ',');
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getNext();
            if (channelSegment == null) {
                break;
            }
            i = 0;
        }
        if (StringsKt.last(sb) == ',') {
            sb.deleteCharAt(sb.length() - 1).getClass();
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    public final Object mo1861tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long longVolatile = unsafe.getLongVolatile(this, receivers$volatile$FU$offset);
        long longVolatile2 = unsafe.getLongVolatile(this, sendersAndCloseStatus$volatile$FU$offset);
        if (isClosed(longVolatile2, true)) {
            return new ChannelResult.Closed(getCloseCause());
        }
        long j = longVolatile2 & 1152921504606846975L;
        ChannelResult.Failed failed = ChannelResult.failed;
        if (longVolatile >= j) {
            return failed;
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) unsafe.getObjectVolatile(this, receiveSegment$volatile$FU$offset);
        while (!this.isClosedForReceive()) {
            long andIncrement = receivers$volatile$FU.getAndIncrement(this);
            long j2 = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = andIncrement / j2;
            int i = (int) (andIncrement % j2);
            if (channelSegment2.id != j3) {
                ChannelSegment channelSegmentFindSegmentReceive = this.findSegmentReceive(j3, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel = this;
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, obj);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment2, i);
                }
                bufferedChannel.waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment2.onSlotCleaned();
                return failed;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment2.cleanPrev();
                    return objUpdateCellReceive;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                return null;
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            this = bufferedChannel;
        }
        return new ChannelResult.Closed(this.getCloseCause());
    }

    public final boolean tryResumeReceiver(Object obj, Object obj2) throws DispatchException {
        byte b = 0;
        if (obj instanceof SelectImplementation) {
            return ((SelectImplementation) obj).trySelectInternal(this, obj2) == 0;
        }
        boolean z = obj instanceof ReceiveCatching;
        Function1 function1 = this.onUndeliveredElement;
        Function3 bufferedChannel$bindCancellationFun$2 = null;
        if (z) {
            CancellableContinuationImpl cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            ChannelResult channelResult = new ChannelResult(obj2);
            if (function1 != null) {
                bufferedChannel$bindCancellationFun$2 = new BufferedChannel$bindCancellationFun$2(3, this, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 2);
            }
            ChannelSegment channelSegment = BufferedChannelKt.NULL_SEGMENT;
            Joiner joinerTryResume = cancellableContinuationImpl.tryResume(channelResult, bufferedChannel$bindCancellationFun$2);
            if (joinerTryResume == null) {
                return false;
            }
            cancellableContinuationImpl.completeResume(joinerTryResume);
            return true;
        }
        if (!(obj instanceof BufferedChannelIterator)) {
            if (!(obj instanceof CancellableContinuation)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(obj, "Unexpected receiver type: ");
                return false;
            }
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            bufferedChannel$bindCancellationFun$2 = function1 != null ? new BufferedChannel$bindCancellationFun$2(3, this, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, (byte) 0) : null;
            ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
            Joiner joinerTryResume2 = cancellableContinuation.tryResume(obj2, bufferedChannel$bindCancellationFun$2);
            if (joinerTryResume2 == null) {
                return false;
            }
            cancellableContinuation.completeResume(joinerTryResume2);
            return true;
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) obj;
        CancellableContinuationImpl cancellableContinuationImpl2 = bufferedChannelIterator.continuation;
        cancellableContinuationImpl2.getClass();
        bufferedChannelIterator.continuation = null;
        bufferedChannelIterator.receiveResult = obj2;
        Boolean bool = Boolean.TRUE;
        Function1 function2 = BufferedChannel.this.onUndeliveredElement;
        bufferedChannel$bindCancellationFun$2 = function2 != null ? new BufferedChannel$$ExternalSyntheticLambda1(function2, obj2, b) : null;
        ChannelSegment channelSegment3 = BufferedChannelKt.NULL_SEGMENT;
        Joiner joinerTryResume3 = cancellableContinuationImpl2.tryResume(bool, bufferedChannel$bindCancellationFun$2);
        if (joinerTryResume3 == null) {
            return false;
        }
        cancellableContinuationImpl2.completeResume(joinerTryResume3);
        return true;
    }

    public final boolean tryResumeSender(Object obj, ChannelSegment channelSegment, int i) {
        TrySelectDetailedResult trySelectDetailedResult;
        boolean z = obj instanceof CancellableContinuation;
        Unit unit = Unit.INSTANCE;
        if (z) {
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            ChannelSegment channelSegment2 = BufferedChannelKt.NULL_SEGMENT;
            Joiner joinerTryResume = cancellableContinuation.tryResume(unit, null);
            if (joinerTryResume == null) {
                return false;
            }
            cancellableContinuation.completeResume(joinerTryResume);
            return true;
        }
        if (!(obj instanceof SelectImplementation)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(obj, "Unexpected waiter: ");
            return false;
        }
        int iTrySelectInternal = ((SelectImplementation) obj).trySelectInternal(this, unit);
        TrySelectDetailedResult trySelectDetailedResult2 = TrySelectDetailedResult.SUCCESSFUL;
        TrySelectDetailedResult trySelectDetailedResult3 = TrySelectDetailedResult.REREGISTER;
        if (iTrySelectInternal == 0) {
            trySelectDetailedResult = trySelectDetailedResult2;
        } else if (iTrySelectInternal == 1) {
            trySelectDetailedResult = trySelectDetailedResult3;
        } else if (iTrySelectInternal == 2) {
            trySelectDetailedResult = TrySelectDetailedResult.CANCELLED;
        } else {
            if (iTrySelectInternal != 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(iTrySelectInternal, "Unexpected internal result: ");
                return false;
            }
            trySelectDetailedResult = TrySelectDetailedResult.ALREADY_SELECTED;
        }
        if (trySelectDetailedResult == trySelectDetailedResult3) {
            channelSegment.setElementLazy(i, null);
        }
        return trySelectDetailedResult == trySelectDetailedResult2;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo1712trySendJP2dKIU(Object obj) {
        BufferedChannel bufferedChannel = this;
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long longVolatile = unsafe.getLongVolatile(bufferedChannel, sendersAndCloseStatus$volatile$FU$offset);
        long j = 1152921504606846975L;
        boolean z = bufferedChannel.isClosed(longVolatile, false) ? false : !bufferedChannel.bufferOrRendezvousSend(longVolatile & 1152921504606846975L);
        ChannelResult.Failed failed = ChannelResult.failed;
        if (z) {
            return failed;
        }
        Object obj2 = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment = (ChannelSegment) unsafe.getObjectVolatile(bufferedChannel, sendSegment$volatile$FU$offset);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j2 = andIncrement & j;
            boolean zIsClosed = bufferedChannel.isClosed(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = i;
            long j4 = j2 / j3;
            int i2 = (int) (j2 % j3);
            if (channelSegment.id != j4) {
                ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j4, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else {
                    if (zIsClosed) {
                        return new ChannelResult.Closed(bufferedChannel.getSendException());
                    }
                    j = 1152921504606846975L;
                }
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, obj, j2, obj2, zIsClosed);
            Unit unit = Unit.INSTANCE;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return unit;
            }
            if (iUpdateCellSend == 1) {
                return unit;
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosed) {
                    channelSegment.onSlotCleaned();
                    return new ChannelResult.Closed(getSendException());
                }
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    waiter.invokeOnCancellation(channelSegment, i2 + i);
                }
                channelSegment.onSlotCleaned();
                return failed;
            }
            if (iUpdateCellSend == 3) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("unexpected");
                return null;
            }
            if (iUpdateCellSend == 4) {
                if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return new ChannelResult.Closed(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            j = 1152921504606846975L;
            bufferedChannel = this;
        }
    }

    public final Object updateCellReceive(ChannelSegment channelSegment, int i, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        AtomicReferenceArray atomicReferenceArray = channelSegment.data;
        long j2 = sendersAndCloseStatus$volatile$FU$offset;
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, j2) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            Object obj2 = atomicReferenceArray.get(i * 2);
            channelSegment.setElementLazy(i, null);
            return obj2;
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core2 == null || state$kotlinx_coroutines_core2 == BufferedChannelKt.IN_BUFFER) {
                if (j < (ArtificialStackFramesUnsafe.unsafe.getLongVolatile(this, j2) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core2 != BufferedChannelKt.BUFFERED) {
                Joiner joiner = BufferedChannelKt.INTERRUPTED_SEND;
                if (state$kotlinx_coroutines_core2 == joiner) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 == BufferedChannelKt.POISONED) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 == BufferedChannelKt.CHANNEL_CLOSED) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.RESUMING_BY_RCV)) {
                    boolean z = state$kotlinx_coroutines_core2 instanceof WaiterEB;
                    if (z) {
                        state$kotlinx_coroutines_core2 = ((WaiterEB) state$kotlinx_coroutines_core2).waiter;
                    }
                    if (tryResumeSender(state$kotlinx_coroutines_core2, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        expandBuffer();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        channelSegment.setElementLazy(i, null);
                        return obj3;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, joiner);
                    channelSegment.onSlotCleaned();
                    if (z) {
                        expandBuffer();
                    }
                    return BufferedChannelKt.FAILED;
                }
            } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core2, BufferedChannelKt.DONE_RCV)) {
                expandBuffer();
                Object obj4 = atomicReferenceArray.get(i * 2);
                channelSegment.setElementLazy(i, null);
                return obj4;
            }
        }
    }

    public final int updateCellSend(ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        channelSegment.setElementLazy(i, obj);
        if (z) {
            return updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.setElementLazy(i, null);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                return 0;
            }
            Joiner joiner = BufferedChannelKt.INTERRUPTED_RCV;
            if (channelSegment.data.getAndSet((i * 2) + 1, joiner) == joiner) {
                return 5;
            }
            channelSegment.onCancelledRequest(i, true);
            return 5;
        }
        return updateCellSendSlow(channelSegment, i, obj, j, obj2, z);
    }

    public final int updateCellSendSlow(ChannelSegment channelSegment, int i, Object obj, long j, Object obj2, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onSlotCleaned();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    Joiner joiner = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core == joiner) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        channelSegment.setElementLazy(i, null);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.CHANNEL_CLOSED) {
                        channelSegment.setElementLazy(i, null);
                        isClosedForSend();
                        return 4;
                    }
                    channelSegment.setElementLazy(i, null);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, obj)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        return 0;
                    }
                    if (channelSegment.data.getAndSet((i * 2) + 1, joiner) != joiner) {
                        channelSegment.onCancelledRequest(i, true);
                    }
                    return 5;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        BufferedChannel bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (bufferedChannel.getBufferEndCounter() <= j) {
            bufferedChannel = this;
        }
        int i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        int i2 = 0;
        while (true) {
            long j2 = completedExpandBuffersAndPauseFlag$volatile$FU$offset;
            if (i2 < i) {
                long bufferEndCounter = bufferedChannel.getBufferEndCounter();
                if (bufferEndCounter == (ArtificialStackFramesUnsafe.unsafe.getLongVolatile(bufferedChannel, j2) & 4611686018427387903L) && bufferEndCounter == bufferedChannel.getBufferEndCounter()) {
                    return;
                } else {
                    i2++;
                }
            } else {
                while (true) {
                    Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                    long longVolatile = unsafe.getLongVolatile(bufferedChannel, j2);
                    if (unsafe.compareAndSwapLong(bufferedChannel, completedExpandBuffersAndPauseFlag$volatile$FU$offset, longVolatile, 4611686018427387904L + (longVolatile & 4611686018427387903L))) {
                        break;
                    } else {
                        bufferedChannel = this;
                    }
                }
                while (true) {
                    long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
                    Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                    long longVolatile2 = unsafe2.getLongVolatile(bufferedChannel, j2);
                    long j3 = longVolatile2 & 4611686018427387903L;
                    boolean z = (longVolatile2 & 4611686018427387904L) != 0;
                    if (bufferEndCounter2 == j3 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                        break;
                    }
                    if (z) {
                        bufferedChannel = this;
                    } else {
                        bufferedChannel = this;
                        unsafe2.compareAndSwapLong(bufferedChannel, completedExpandBuffersAndPauseFlag$volatile$FU$offset, longVolatile2, j3 + 4611686018427387904L);
                    }
                }
                while (true) {
                    Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                    long longVolatile3 = unsafe3.getLongVolatile(bufferedChannel, j2);
                    if (unsafe3.compareAndSwapLong(bufferedChannel, completedExpandBuffersAndPauseFlag$volatile$FU$offset, longVolatile3, longVolatile3 & 4611686018427387903L)) {
                        return;
                    } else {
                        bufferedChannel = this;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        closeOrCancelImpl(cancellationException, true);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        closeOrCancelImpl(new CancellationException("Channel was cancelled"), true);
    }
}
