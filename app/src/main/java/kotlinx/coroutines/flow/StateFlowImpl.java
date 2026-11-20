package kotlinx.coroutines.flow;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class StateFlowImpl extends AbstractSharedFlow implements MutableStateFlow, Flow, FusibleFlow {
    public static final /* synthetic */ long _state$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(StateFlowImpl.class.getDeclaredField("_state$volatile"));
    private volatile /* synthetic */ Object _state$volatile;
    public int sequence;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public FlowCollector L$0;
        public StateFlowSlot L$1;
        public Job L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            StateFlowImpl.this.collect(null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00d8 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:14:0x0032, B:28:0x006c, B:30:0x0076, B:33:0x007d, B:34:0x0081, B:36:0x0084, B:46:0x00a5, B:49:0x00b5, B:50:0x00d1, B:56:0x00e1, B:53:0x00d8, B:55:0x00de, B:38:0x008a, B:42:0x0091, B:21:0x0047, B:24:0x004f, B:27:0x005d), top: B:63:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:? A[LOOP:0: B:50:0x00d1->B:68:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00b4 -> B:28:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @Override // kotlinx.coroutines.flow.Flow
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean compareAndSet(Object obj, Object obj2) {
        Joiner joiner = CombineKt.NULL;
        if (obj == null) {
            obj = joiner;
        }
        if (obj2 == null) {
            obj2 = joiner;
        }
        return updateState(obj, obj2);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        setValue(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return (((i < 0 || i >= 2) && i != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? StateFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow) : this;
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Joiner joiner = CombineKt.NULL;
        Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _state$volatile$FU$offset);
        if (objectVolatile == joiner) {
            return null;
        }
        return objectVolatile;
    }

    public final void setValue(Object obj) {
        if (obj == null) {
            obj = CombineKt.NULL;
        }
        updateState(null, obj);
    }

    public final boolean updateState(Object obj, Object obj2) {
        int i;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        Joiner joiner;
        synchronized (this) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _state$volatile$FU$offset;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (obj != null && !Intrinsics.areEqual(objectVolatile, obj)) {
                return false;
            }
            if (Intrinsics.areEqual(objectVolatile, obj2)) {
                return true;
            }
            unsafe.putObjectVolatile(this, j, obj2);
            int i2 = this.sequence;
            if ((i2 & 1) != 0) {
                this.sequence = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.sequence = i3;
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArr2 = this.slots;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = (StateFlowSlot[]) abstractSharedFlowSlotArr2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            AtomicReference atomicReference = stateFlowSlot._state;
                            while (true) {
                                Object obj3 = atomicReference.get();
                                if (obj3 == null || obj3 == (joiner = StateFlowKt.PENDING)) {
                                    break;
                                }
                                Joiner joiner2 = StateFlowKt.NONE;
                                if (obj3 != joiner2) {
                                    do {
                                        if (atomicReference.compareAndSet(obj3, joiner2)) {
                                            ((CancellableContinuationImpl) obj3).resumeWith(Unit.INSTANCE);
                                            break;
                                        }
                                    } while (atomicReference.get() == obj3);
                                } else {
                                    do {
                                        if (atomicReference.compareAndSet(obj3, joiner)) {
                                            break;
                                        }
                                    } while (atomicReference.get() == obj3);
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.sequence;
                    if (i == i3) {
                        this.sequence = i3 + 1;
                        return true;
                    }
                    abstractSharedFlowSlotArr = this.slots;
                }
                abstractSharedFlowSlotArr2 = abstractSharedFlowSlotArr;
                i3 = i;
            }
        }
    }
}
