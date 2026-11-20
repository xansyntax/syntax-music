package kotlinx.coroutines.sync;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import com.google.common.base.Joiner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectImplementation;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class SemaphoreAndMutexImpl {
    public static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$volatile$FU;
    public static final /* synthetic */ long _availablePermits$volatile$FU$offset;
    public static final /* synthetic */ AtomicLongFieldUpdater deqIdx$volatile$FU;
    public static final /* synthetic */ AtomicLongFieldUpdater enqIdx$volatile$FU;
    public static final /* synthetic */ long head$volatile$FU$offset;
    public static final /* synthetic */ long tail$volatile$FU$offset;
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    public final ListItemKt$$ExternalSyntheticLambda17 onCancellationRelease;
    public final int permits;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        head$volatile$FU$offset = unsafe.objectFieldOffset(SemaphoreAndMutexImpl.class.getDeclaredField("head$volatile"));
        deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
        tail$volatile$FU$offset = unsafe.objectFieldOffset(SemaphoreAndMutexImpl.class.getDeclaredField("tail$volatile"));
        enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
        _availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
        _availablePermits$volatile$FU$offset = unsafe.objectFieldOffset(SemaphoreAndMutexImpl.class.getDeclaredField("_availablePermits$volatile"));
    }

    public SemaphoreAndMutexImpl(int i) {
        this.permits = i;
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Semaphore should have at least 1 permit, but had "));
            throw null;
        }
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "The number of acquired permits should be in 0.."));
            throw null;
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i;
        this.onCancellationRelease = new ListItemKt$$ExternalSyntheticLambda17((byte) 25, (Object) this);
    }

    public final Object acquire(ContinuationImpl continuationImpl) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int andDecrement;
        int i;
        do {
            atomicIntegerFieldUpdater = _availablePermits$volatile$FU;
            andDecrement = atomicIntegerFieldUpdater.getAndDecrement(this);
            i = this.permits;
        } while (andDecrement > i);
        Unit unit = Unit.INSTANCE;
        if (andDecrement <= 0) {
            CancellableContinuationImpl orCreateCancellableContinuation = AwaitKt.getOrCreateCancellableContinuation(Okio__OkioKt.intercepted(continuationImpl));
            try {
                if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                    while (true) {
                        int andDecrement2 = atomicIntegerFieldUpdater.getAndDecrement(this);
                        if (andDecrement2 <= i) {
                            if (andDecrement2 > 0) {
                                orCreateCancellableContinuation.resume(unit, this.onCancellationRelease);
                                break;
                            }
                            if (addAcquireToQueue(orCreateCancellableContinuation)) {
                                break;
                            }
                        }
                    }
                }
                Object result = orCreateCancellableContinuation.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
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
        }
        return unit;
    }

    public final boolean addAcquireToQueue(Waiter waiter) {
        Object objFindSegmentInternal;
        Unsafe unsafe;
        SemaphoreAndMutexImpl semaphoreAndMutexImpl = this;
        Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
        long j = tail$volatile$FU$offset;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) unsafe2.getObjectVolatile(semaphoreAndMutexImpl, j);
        long andIncrement = enqIdx$volatile$FU.getAndIncrement(semaphoreAndMutexImpl);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        long j2 = andIncrement / ((long) SemaphoreKt.SEGMENT_SIZE);
        loop0: while (true) {
            objFindSegmentInternal = InlineList.findSegmentInternal(semaphoreSegment, j2, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                break;
            }
            Segment segmentM1905getSegmentimpl = InlineList.m1905getSegmentimpl(objFindSegmentInternal);
            while (true) {
                Segment segment = (Segment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(semaphoreAndMutexImpl, j);
                if (segment.id >= segmentM1905getSegmentimpl.id) {
                    semaphoreAndMutexImpl = this;
                    break loop0;
                }
                if (!segmentM1905getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    semaphoreAndMutexImpl = this;
                    if (unsafe.compareAndSwapObject(semaphoreAndMutexImpl, tail$volatile$FU$offset, segment, segmentM1905getSegmentimpl)) {
                        if (!segment.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment.remove();
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(semaphoreAndMutexImpl, j) == segment);
                if (segmentM1905getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    segmentM1905getSegmentimpl.remove();
                }
            }
            semaphoreAndMutexImpl = this;
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) InlineList.m1905getSegmentimpl(objFindSegmentInternal);
        AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.acquirers;
        int i = (int) (andIncrement % ((long) SemaphoreKt.SEGMENT_SIZE));
        while (!atomicReferenceArray.compareAndSet(i, null, waiter)) {
            if (atomicReferenceArray.get(i) != null) {
                Joiner joiner = SemaphoreKt.PERMIT;
                Joiner joiner2 = SemaphoreKt.TAKEN;
                while (!atomicReferenceArray.compareAndSet(i, joiner, joiner2)) {
                    if (atomicReferenceArray.get(i) != joiner) {
                        return false;
                    }
                }
                ((CancellableContinuation) waiter).resume(Unit.INSTANCE, semaphoreAndMutexImpl.onCancellationRelease);
                return true;
            }
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i);
        return true;
    }

    public final void release() {
        Unsafe unsafe;
        long j;
        int intVolatile;
        int i;
        Object objFindSegmentInternal;
        boolean z;
        Unsafe unsafe2;
        do {
            int andIncrement = _availablePermits$volatile$FU.getAndIncrement(this);
            int i2 = this.permits;
            if (andIncrement >= i2) {
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    j = _availablePermits$volatile$FU$offset;
                    intVolatile = unsafe.getIntVolatile(this, j);
                    i = this.permits;
                    if (intVolatile <= i) {
                        break;
                    }
                } while (!unsafe.compareAndSwapInt(this, j, intVolatile, i));
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(i2, "The number of released permits cannot be greater than ");
                return;
            }
            if (andIncrement >= 0) {
                return;
            }
            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
            long j2 = head$volatile$FU$offset;
            SemaphoreSegment semaphoreSegment = (SemaphoreSegment) unsafe3.getObjectVolatile(this, j2);
            long andIncrement2 = deqIdx$volatile$FU.getAndIncrement(this);
            long j3 = andIncrement2 / ((long) SemaphoreKt.SEGMENT_SIZE);
            SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
            while (true) {
                objFindSegmentInternal = InlineList.findSegmentInternal(semaphoreSegment, j3, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
                if (!InlineList.m1906isClosedimpl(objFindSegmentInternal)) {
                    Segment segmentM1905getSegmentimpl = InlineList.m1905getSegmentimpl(objFindSegmentInternal);
                    while (true) {
                        Segment segment = (Segment) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, j2);
                        if (segment.id >= segmentM1905getSegmentimpl.id) {
                            break;
                        }
                        if (!segmentM1905getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        do {
                            unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                            if (unsafe2.compareAndSwapObject(this, head$volatile$FU$offset, segment, segmentM1905getSegmentimpl)) {
                                if (!segment.decPointers$kotlinx_coroutines_core()) {
                                    break;
                                }
                                segment.remove();
                                break;
                            }
                        } while (unsafe2.getObjectVolatile(this, j2) == segment);
                        if (segmentM1905getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            segmentM1905getSegmentimpl.remove();
                        }
                    }
                } else {
                    break;
                }
            }
            SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) InlineList.m1905getSegmentimpl(objFindSegmentInternal);
            AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.acquirers;
            semaphoreSegment2.cleanPrev();
            z = false;
            if (semaphoreSegment2.id <= j3) {
                int i3 = (int) (andIncrement2 % ((long) SemaphoreKt.SEGMENT_SIZE));
                Object andSet = atomicReferenceArray.getAndSet(i3, SemaphoreKt.PERMIT);
                if (andSet == null) {
                    int i4 = SemaphoreKt.MAX_SPIN_CYCLES;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= i4) {
                            Joiner joiner = SemaphoreKt.PERMIT;
                            Joiner joiner2 = SemaphoreKt.BROKEN;
                            do {
                                if (atomicReferenceArray.compareAndSet(i3, joiner, joiner2)) {
                                    z = true;
                                    break;
                                }
                            } while (atomicReferenceArray.get(i3) == joiner);
                            z = !z;
                            break;
                        }
                        if (atomicReferenceArray.get(i3) == SemaphoreKt.TAKEN) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                } else if (andSet != SemaphoreKt.CANCELLED) {
                    boolean z2 = andSet instanceof CancellableContinuation;
                    Unit unit = Unit.INSTANCE;
                    if (z2) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                        Joiner joinerTryResume = cancellableContinuation.tryResume(unit, this.onCancellationRelease);
                        if (joinerTryResume != null) {
                            cancellableContinuation.completeResume(joinerTryResume);
                            z = true;
                            break;
                            break;
                        }
                    } else if (!(andSet instanceof SelectImplementation)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(andSet, "unexpected: ");
                        return;
                    } else if (((SelectImplementation) andSet).trySelectInternal(this, unit) == 0) {
                        z = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z);
    }
}
