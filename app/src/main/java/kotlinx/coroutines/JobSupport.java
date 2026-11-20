package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import coil3.network.HttpException;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.internal.ListClosed;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JobSupport implements Job {
    public static final /* synthetic */ long _parentHandle$volatile$FU$offset;
    public static final /* synthetic */ long _state$volatile$FU$offset;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AwaitContinuation extends CancellableContinuationImpl {
        public final JobSupport job;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(1, continuation);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final Throwable getContinuationCancellationCause(JobSupport jobSupport) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Finishing) || (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) == null) {
                return state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : jobSupport.getCancellationException();
            }
            return rootCause;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public final String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChildCompletion extends JobNode {
        public final ChildHandleNode child;
        public final JobSupport parent;
        public final Object proposedUpdate;
        public final Finishing state;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public final boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public final void invoke(Throwable th) {
            ChildHandleNode childHandleNode = this.child;
            ChildHandleNode childHandleNodeNextChild = JobSupport.nextChild(childHandleNode);
            JobSupport jobSupport = this.parent;
            Finishing finishing = this.state;
            Object obj = this.proposedUpdate;
            if (childHandleNodeNextChild == null || !jobSupport.tryWaitForChild(finishing, childHandleNodeNextChild, obj)) {
                finishing.list.addLast(new ListClosed(2), 2);
                ChildHandleNode childHandleNodeNextChild2 = JobSupport.nextChild(childHandleNode);
                if (childHandleNodeNextChild2 == null || !jobSupport.tryWaitForChild(finishing, childHandleNodeNextChild2, obj)) {
                    jobSupport.afterCompletion(jobSupport.finalizeFinishingState(finishing, obj));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Finishing implements Incomplete {
        public static final /* synthetic */ long _exceptionsHolder$volatile$FU$offset;
        public static final /* synthetic */ long _isCompleting$volatile$FU$offset;
        public static final /* synthetic */ long _rootCause$volatile$FU$offset;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile = 0;
        private volatile /* synthetic */ Object _rootCause$volatile;
        public final NodeList list;

        static {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            _isCompleting$volatile$FU$offset = unsafe.objectFieldOffset(Finishing.class.getDeclaredField("_isCompleting$volatile"));
            _rootCause$volatile$FU$offset = unsafe.objectFieldOffset(Finishing.class.getDeclaredField("_rootCause$volatile"));
            _exceptionsHolder$volatile$FU$offset = unsafe.objectFieldOffset(Finishing.class.getDeclaredField("_exceptionsHolder$volatile"));
        }

        public Finishing(NodeList nodeList, Throwable th) {
            this.list = nodeList;
            this._rootCause$volatile = th;
        }

        public final void addExceptionLocked(Throwable th) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(this, _rootCause$volatile$FU$offset, th);
                return;
            }
            if (th == rootCause) {
                return;
            }
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _exceptionsHolder$volatile$FU$offset;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (objectVolatile == null) {
                unsafe.putObjectVolatile(this, j, th);
                return;
            }
            if (!(objectVolatile instanceof Throwable)) {
                if (objectVolatile instanceof ArrayList) {
                    ((ArrayList) objectVolatile).add(th);
                    return;
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "State is ");
                    return;
                }
            }
            if (th == objectVolatile) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(objectVolatile);
            arrayList.add(th);
            unsafe.putObjectVolatile(this, j, arrayList);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return (Throwable) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _rootCause$volatile$FU$offset);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isCompleting() {
            return ArtificialStackFramesUnsafe.unsafe.getIntVolatile(this, _isCompleting$volatile$FU$offset) == 1;
        }

        public final ArrayList sealLocked(Throwable th) {
            ArrayList arrayList;
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _exceptionsHolder$volatile$FU$offset;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (objectVolatile == null) {
                arrayList = new ArrayList(4);
            } else if (objectVolatile instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(objectVolatile);
                arrayList = arrayList2;
            } else {
                if (!(objectVolatile instanceof ArrayList)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "State is ");
                    return null;
                }
                arrayList = (ArrayList) objectVolatile;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th != null && !th.equals(rootCause)) {
                arrayList.add(th);
            }
            unsafe.putObjectVolatile(this, j, AwaitKt.SEALED);
            return arrayList;
        }

        public final String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _exceptionsHolder$volatile$FU$offset) + ", list=" + this.list + ']';
        }
    }

    static {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        _state$volatile$FU$offset = unsafe.objectFieldOffset(JobSupport.class.getDeclaredField("_state$volatile"));
        _parentHandle$volatile$FU$offset = unsafe.objectFieldOffset(JobSupport.class.getDeclaredField("_parentHandle$volatile"));
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? AwaitKt.EMPTY_ACTIVE : AwaitKt.EMPTY_NEW;
    }

    public static ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String stateString(Object obj) {
        if (!(obj instanceof Finishing)) {
            if (obj instanceof Incomplete) {
                return ((Incomplete) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) obj;
        if (finishing.isCancelling()) {
            return "Cancelling";
        }
        return finishing.isCompleting() ? "Completing" : "Active";
    }

    public void afterResume(Object obj) {
        afterCompletion(obj);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(JobSupport jobSupport) {
        JobSupport jobSupport2;
        ChildHandleNode childHandleNode = new ChildHandleNode(jobSupport);
        childHandleNode.job = this;
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.isActive) {
                    while (true) {
                        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                        long j = _state$volatile$FU$offset;
                        jobSupport2 = this;
                        if (unsafe.compareAndSwapObject(jobSupport2, j, state$kotlinx_coroutines_core, childHandleNode)) {
                            break loop0;
                        }
                        if (unsafe.getObjectVolatile(jobSupport2, j) != state$kotlinx_coroutines_core) {
                            break;
                        }
                        this = jobSupport2;
                    }
                } else {
                    jobSupport2 = this;
                    jobSupport2.promoteEmptyToNodeList(empty);
                }
                this = jobSupport2;
            } else {
                jobSupport2 = this;
                boolean z = state$kotlinx_coroutines_core instanceof Incomplete;
                NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
                Throwable rootCause = null;
                if (!z) {
                    Object state$kotlinx_coroutines_core2 = jobSupport2.getState$kotlinx_coroutines_core();
                    CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core2 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core2 : null;
                    childHandleNode.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    return nonDisposableHandle;
                }
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    if (list.addLast(childHandleNode, 7)) {
                        break;
                    }
                    boolean zAddLast = list.addLast(childHandleNode, 3);
                    Object state$kotlinx_coroutines_core3 = jobSupport2.getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core3 instanceof Finishing) {
                        rootCause = ((Finishing) state$kotlinx_coroutines_core3).getRootCause();
                    } else {
                        CompletedExceptionally completedExceptionally2 = state$kotlinx_coroutines_core3 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core3 : null;
                        if (completedExceptionally2 != null) {
                            rootCause = completedExceptionally2.cause;
                        }
                    }
                    childHandleNode.invoke(rootCause);
                    if (zAddLast) {
                        break;
                    }
                    return nonDisposableHandle;
                }
                jobSupport2.promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                this = jobSupport2;
            }
        }
        return childHandleNode;
    }

    public Object await(ContinuationImpl continuationImpl) {
        return awaitInternal(continuationImpl);
    }

    public final Object awaitInternal(Continuation continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                }
                return AwaitKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        AwaitContinuation awaitContinuation = new AwaitContinuation(Okio__OkioKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        awaitContinuation.invokeOnCancellationImpl(new DisposeOnCancel((byte) 0, AwaitKt.invokeOnCompletion(this, true, new ResumeAwaitOnCompletion(awaitContinuation))));
        return awaitContinuation.getResult();
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003a A[PHI: r0
      0x003a: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v10 java.lang.Object) binds: [B:3:0x0008, B:16:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0058, B:31:0x0062, B:33:0x006b, B:34:0x006f), top: B:82:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062 A[Catch: all -> 0x005f, TRY_ENTER, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0058, B:31:0x0062, B:33:0x006b, B:34:0x006f), top: B:82:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x006b A[Catch: all -> 0x005f, TryCatch #0 {, blocks: (B:24:0x0049, B:26:0x0058, B:31:0x0062, B:33:0x006b, B:34:0x006f), top: B:82:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0092 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c7 A[LOOP:2: B:53:0x00ae->B:60:0x00c7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:80:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x003e, please report this as an issue */
    public final boolean cancelImpl$kotlinx_coroutines_core(Object obj) {
        JobSupport jobSupport;
        Throwable thCreateCauseException;
        Object state$kotlinx_coroutines_core;
        Throwable rootCause;
        Joiner joiner;
        Object objTryMakeCompleting;
        Incomplete incomplete;
        NodeList orPromoteCancellingList;
        Finishing finishing;
        Unsafe unsafe;
        long j;
        Object objTryMakeCompleting2 = AwaitKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core()) {
            do {
                Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                if (!(state$kotlinx_coroutines_core2 instanceof Incomplete) || ((state$kotlinx_coroutines_core2 instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core2).isCompleting())) {
                    objTryMakeCompleting2 = AwaitKt.COMPLETING_ALREADY;
                    break;
                }
                objTryMakeCompleting2 = tryMakeCompleting(state$kotlinx_coroutines_core2, new CompletedExceptionally(createCauseException(obj), false));
            } while (objTryMakeCompleting2 == AwaitKt.COMPLETING_RETRY);
            if (objTryMakeCompleting2 != AwaitKt.COMPLETING_WAITING_CHILDREN) {
                if (objTryMakeCompleting2 == AwaitKt.COMPLETING_ALREADY) {
                    thCreateCauseException = null;
                    loop1: while (true) {
                        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
                        if (state$kotlinx_coroutines_core instanceof Finishing) {
                            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                                if (thCreateCauseException == null) {
                                    thCreateCauseException = this.createCauseException(obj);
                                }
                                incomplete = (Incomplete) state$kotlinx_coroutines_core;
                                if (incomplete.isActive()) {
                                    orPromoteCancellingList = this.getOrPromoteCancellingList(incomplete);
                                    if (orPromoteCancellingList == null) {
                                        jobSupport = this;
                                    } else {
                                        finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                        while (true) {
                                            unsafe = ArtificialStackFramesUnsafe.unsafe;
                                            j = _state$volatile$FU$offset;
                                            jobSupport = this;
                                            if (unsafe.compareAndSwapObject(jobSupport, j, incomplete, finishing)) {
                                                jobSupport.notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                                objTryMakeCompleting = AwaitKt.COMPLETING_ALREADY;
                                            } else if (unsafe.getObjectVolatile(jobSupport, j) != incomplete) {
                                                this = jobSupport;
                                            }
                                        }
                                    }
                                    this = jobSupport;
                                } else {
                                    jobSupport = this;
                                    objTryMakeCompleting = jobSupport.tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false));
                                    if (objTryMakeCompleting != AwaitKt.COMPLETING_ALREADY) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(state$kotlinx_coroutines_core, "Cannot happen in ");
                                        return false;
                                    }
                                    if (objTryMakeCompleting != AwaitKt.COMPLETING_RETRY) {
                                        this = jobSupport;
                                    }
                                }
                            } else {
                                jobSupport = this;
                                objTryMakeCompleting = AwaitKt.TOO_LATE_TO_CANCEL;
                            }
                            objTryMakeCompleting2 = objTryMakeCompleting;
                            break;
                        }
                        synchronized (state$kotlinx_coroutines_core) {
                            if (ArtificialStackFramesUnsafe.unsafe.getObjectVolatile((Finishing) state$kotlinx_coroutines_core, Finishing._exceptionsHolder$volatile$FU$offset) == AwaitKt.SEALED) {
                                joiner = AwaitKt.TOO_LATE_TO_CANCEL;
                            } else {
                                boolean zIsCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                                if (thCreateCauseException == null) {
                                    thCreateCauseException = this.createCauseException(obj);
                                }
                                ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                                rootCause = zIsCancelling ? null : ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                                if (rootCause != null) {
                                    this.notifyCancelling(((Finishing) state$kotlinx_coroutines_core).list, rootCause);
                                }
                                joiner = AwaitKt.COMPLETING_ALREADY;
                            }
                        }
                        jobSupport = this;
                        objTryMakeCompleting2 = joiner;
                        break;
                    }
                }
                jobSupport = this;
                if (objTryMakeCompleting2 != AwaitKt.COMPLETING_ALREADY && objTryMakeCompleting2 != AwaitKt.COMPLETING_WAITING_CHILDREN) {
                    if (objTryMakeCompleting2 == AwaitKt.TOO_LATE_TO_CANCEL) {
                        return false;
                    }
                    jobSupport.afterCompletion(objTryMakeCompleting2);
                    return true;
                }
            }
        } else {
            if (objTryMakeCompleting2 == AwaitKt.COMPLETING_ALREADY) {
                thCreateCauseException = null;
                loop1: while (true) {
                    state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
                    if (state$kotlinx_coroutines_core instanceof Finishing) {
                        if (state$kotlinx_coroutines_core instanceof Incomplete) {
                            if (thCreateCauseException == null) {
                                thCreateCauseException = this.createCauseException(obj);
                            }
                            incomplete = (Incomplete) state$kotlinx_coroutines_core;
                            if (incomplete.isActive()) {
                                orPromoteCancellingList = this.getOrPromoteCancellingList(incomplete);
                                if (orPromoteCancellingList == null) {
                                    jobSupport = this;
                                } else {
                                    finishing = new Finishing(orPromoteCancellingList, thCreateCauseException);
                                    while (true) {
                                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                                        j = _state$volatile$FU$offset;
                                        jobSupport = this;
                                        if (unsafe.compareAndSwapObject(jobSupport, j, incomplete, finishing)) {
                                            jobSupport.notifyCancelling(orPromoteCancellingList, thCreateCauseException);
                                            objTryMakeCompleting = AwaitKt.COMPLETING_ALREADY;
                                        } else if (unsafe.getObjectVolatile(jobSupport, j) != incomplete) {
                                            this = jobSupport;
                                        }
                                    }
                                }
                                this = jobSupport;
                            } else {
                                jobSupport = this;
                                objTryMakeCompleting = jobSupport.tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false));
                                if (objTryMakeCompleting != AwaitKt.COMPLETING_ALREADY) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$3(state$kotlinx_coroutines_core, "Cannot happen in ");
                                    return false;
                                }
                                if (objTryMakeCompleting != AwaitKt.COMPLETING_RETRY) {
                                    this = jobSupport;
                                }
                            }
                        } else {
                            jobSupport = this;
                            objTryMakeCompleting = AwaitKt.TOO_LATE_TO_CANCEL;
                        }
                        objTryMakeCompleting2 = objTryMakeCompleting;
                        break;
                    }
                    synchronized (state$kotlinx_coroutines_core) {
                        if (ArtificialStackFramesUnsafe.unsafe.getObjectVolatile((Finishing) state$kotlinx_coroutines_core, Finishing._exceptionsHolder$volatile$FU$offset) == AwaitKt.SEALED) {
                            joiner = AwaitKt.TOO_LATE_TO_CANCEL;
                        } else {
                            boolean zIsCancelling2 = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                            if (thCreateCauseException == null) {
                                thCreateCauseException = this.createCauseException(obj);
                            }
                            ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                            if (zIsCancelling2) {
                            }
                            if (rootCause != null) {
                                this.notifyCancelling(((Finishing) state$kotlinx_coroutines_core).list, rootCause);
                            }
                            joiner = AwaitKt.COMPLETING_ALREADY;
                        }
                        jobSupport = this;
                        objTryMakeCompleting2 = joiner;
                        break;
                    }
                }
            }
            jobSupport = this;
            if (objTryMakeCompleting2 != AwaitKt.COMPLETING_ALREADY) {
                if (objTryMakeCompleting2 == AwaitKt.TOO_LATE_TO_CANCEL) {
                    return false;
                }
                jobSupport.afterCompletion(objTryMakeCompleting2);
                return true;
            }
        }
        return true;
    }

    public void cancelInternal(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _parentHandle$volatile$FU$offset);
        if (childHandle == null || childHandle == NonDisposableHandle.INSTANCE) {
            return z;
        }
        return childHandle.childCancelled(th) || z;
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core();
    }

    public final void completeStateFinalization(Incomplete incomplete, Object obj) {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = _parentHandle$volatile$FU$offset;
        ChildHandle childHandle = (ChildHandle) unsafe.getObjectVolatile(this, j);
        if (childHandle != null) {
            childHandle.dispose();
            unsafe.putObjectVolatile(this, j, NonDisposableHandle.INSTANCE);
        }
        HttpException httpException = null;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).invoke(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new HttpException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        NodeList list = incomplete.getList();
        if (list != null) {
            list.addLast(new ListClosed(1), 1);
            Object next = list.getNext();
            next.getClass();
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !nextNode.equals(list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof JobNode) {
                    try {
                        ((JobNode) nextNode).invoke(th);
                    } catch (Throwable th3) {
                        if (httpException != null) {
                            ResultKt.addSuppressed(httpException, th3);
                        } else {
                            httpException = new HttpException("Exception in completion handler " + nextNode + " for " + this, th3);
                        }
                    }
                }
            }
            if (httpException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(httpException);
            }
        }
    }

    public final Throwable createCauseException(Object obj) {
        Throwable rootCause;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        JobSupport jobSupport = (JobSupport) obj;
        Object state$kotlinx_coroutines_core = jobSupport.getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(state$kotlinx_coroutines_core, "Cannot be cancelling child in this state: ");
                return null;
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        return cancellationException == null ? new JobCancellationException("Parent job is ".concat(stateString(state$kotlinx_coroutines_core)), rootCause, jobSupport) : cancellationException;
    }

    public final Object finalizeFinishingState(Finishing finishing, Object obj) throws Throwable {
        Throwable th;
        JobSupport jobSupport;
        Finishing finishing2;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th2 = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (finishing) {
            try {
                finishing.isCancelling();
                ArrayList arrayListSealLocked = finishing.sealLocked(th2);
                Throwable finalRootCause = getFinalRootCause(finishing, arrayListSealLocked);
                if (finalRootCause != null) {
                    try {
                        if (arrayListSealLocked.size() > 1) {
                            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListSealLocked.size()));
                            int size = arrayListSealLocked.size();
                            int i = 0;
                            while (i < size) {
                                Object obj2 = arrayListSealLocked.get(i);
                                i++;
                                Throwable th3 = (Throwable) obj2;
                                if (th3 != finalRootCause && th3 != finalRootCause && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                                    ResultKt.addSuppressed(finalRootCause, th3);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                }
                if (finalRootCause != null && finalRootCause != th2) {
                    obj = new CompletedExceptionally(finalRootCause, false);
                }
                if (finalRootCause != null && (cancelParent(finalRootCause) || handleJobException(finalRootCause))) {
                    obj.getClass();
                    ArtificialStackFramesUnsafe.unsafe.compareAndSwapInt((CompletedExceptionally) obj, CompletedExceptionally._handled$volatile$FU$offset, 0, 1);
                }
                onCompletionInternal(obj);
                Object incompleteStateBox = obj instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj) : obj;
                while (true) {
                    Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                    long j = _state$volatile$FU$offset;
                    jobSupport = this;
                    finishing2 = finishing;
                    if (unsafe.compareAndSwapObject(jobSupport, j, finishing2, incompleteStateBox) || unsafe.getObjectVolatile(jobSupport, j) != finishing2) {
                        break;
                    }
                    this = jobSupport;
                    finishing = finishing2;
                }
                jobSupport.completeStateFinalization(finishing2, obj);
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(this, "Job is still new or active: ");
                return null;
            }
            String strConcat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
            return cancellationException == null ? new JobCancellationException(strConcat, rootCause, this) : cancellationException;
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(this, "Job is still new or active: ");
            return null;
        }
        if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
            return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new JobCancellationException(cancellationExceptionMessage(), th, this) : cancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return new LinesSequence((byte) 3, new JobSupport$children$1(null, this));
    }

    public Object getCompleted() {
        return getCompletedInternal$kotlinx_coroutines_core();
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This job has not completed yet");
            return null;
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return AwaitKt.unboxState(state$kotlinx_coroutines_core);
    }

    public final Throwable getFinalRootCause(Finishing finishing, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (finishing.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        do {
            if (i2 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i2);
            i2++;
        } while (((Throwable) obj) instanceof CancellationException);
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.$$INSTANCE;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return this instanceof CompletableDeferredImpl;
    }

    public final NodeList getOrPromoteCancellingList(Incomplete incomplete) {
        NodeList list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            promoteSingleToNodeList((JobNode) incomplete);
            return null;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(incomplete, "State should have list: ");
        return null;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(this, _state$volatile$FU$offset);
    }

    public boolean handleJobException(Throwable th) {
        return false;
    }

    public final void initParentJob(Job job) {
        long j = _parentHandle$volatile$FU$offset;
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
        if (job == null) {
            ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(this, j, nonDisposableHandle);
            return;
        }
        job.start();
        ChildHandle childHandleAttachChild = job.attachChild(this);
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        unsafe.putObjectVolatile(this, j, childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            unsafe.putObjectVolatile(this, j, nonDisposableHandle);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1 function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(z2, z ? new InvokeOnCancelling(function1) : new InvokeOnCompletion(function1));
    }

    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean z, JobNode jobNode) {
        JobSupport jobSupport;
        JobNode jobNode2;
        boolean zAddLast;
        jobNode.job = this;
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Empty)) {
                jobSupport = this;
                jobNode2 = jobNode;
                boolean z2 = state$kotlinx_coroutines_core instanceof Incomplete;
                NonDisposableHandle nonDisposableHandle = NonDisposableHandle.INSTANCE;
                if (z2) {
                    Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                    NodeList list = incomplete.getList();
                    if (list == null) {
                        jobSupport.promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                    } else {
                        if (jobNode2.getOnCancelling()) {
                            Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
                            Throwable rootCause = finishing != null ? finishing.getRootCause() : null;
                            if (rootCause == null) {
                                zAddLast = list.addLast(jobNode2, 5);
                            } else if (z) {
                                jobNode2.invoke(rootCause);
                                return nonDisposableHandle;
                            }
                        } else {
                            zAddLast = list.addLast(jobNode2, 1);
                        }
                        if (zAddLast) {
                            break;
                        }
                    }
                    this = jobSupport;
                    jobNode = jobNode2;
                } else if (z) {
                    Object state$kotlinx_coroutines_core2 = jobSupport.getState$kotlinx_coroutines_core();
                    CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core2 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core2 : null;
                    jobNode2.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                }
                return nonDisposableHandle;
            }
            Empty empty = (Empty) state$kotlinx_coroutines_core;
            if (empty.isActive) {
                while (true) {
                    Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                    long j = _state$volatile$FU$offset;
                    jobSupport = this;
                    jobNode2 = jobNode;
                    if (unsafe.compareAndSwapObject(jobSupport, j, state$kotlinx_coroutines_core, jobNode2)) {
                        break loop0;
                    }
                    if (unsafe.getObjectVolatile(jobSupport, j) != state$kotlinx_coroutines_core) {
                        break;
                    }
                    this = jobSupport;
                    jobNode = jobNode2;
                }
            } else {
                jobSupport = this;
                jobNode2 = jobNode;
                jobSupport.promoteEmptyToNodeList(empty);
            }
            this = jobSupport;
            jobNode = jobNode2;
        }
        return jobNode2;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return true;
        }
        return (state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public boolean isScopedCoroutine() {
        return this instanceof BlockingCoroutine;
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation continuation) {
        Object state$kotlinx_coroutines_core;
        Unit unit;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            boolean z = state$kotlinx_coroutines_core instanceof Incomplete;
            unit = Unit.INSTANCE;
            if (!z) {
                AwaitKt.ensureActive(continuation.getContext());
                return unit;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellationImpl(new DisposeOnCancel((byte) 0, AwaitKt.invokeOnCompletion(this, true, new ResumeOnCompletion(cancellableContinuationImpl))));
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (result != coroutineSingletons) {
            result = unit;
        }
        return result == coroutineSingletons ? result : unit;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == AwaitKt.COMPLETING_ALREADY) {
                return false;
            }
            if (objTryMakeCompleting == AwaitKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (objTryMakeCompleting == AwaitKt.COMPLETING_RETRY);
        afterCompletion(objTryMakeCompleting);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            if (objTryMakeCompleting == AwaitKt.COMPLETING_ALREADY) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
                throw new IllegalStateException(str, completedExceptionally != null ? completedExceptionally.cause : null);
            }
        } while (objTryMakeCompleting == AwaitKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    public String nameString$kotlinx_coroutines_core() {
        return getClass().getSimpleName();
    }

    public final void notifyCancelling(NodeList nodeList, Throwable th) {
        nodeList.addLast(new ListClosed(4), 4);
        Object next = nodeList.getNext();
        next.getClass();
        HttpException httpException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !nextNode.equals(nodeList); nextNode = nextNode.getNextNode()) {
            if ((nextNode instanceof JobNode) && ((JobNode) nextNode).getOnCancelling()) {
                try {
                    ((JobNode) nextNode).invoke(th);
                } catch (Throwable th2) {
                    if (httpException != null) {
                        ResultKt.addSuppressed(httpException, th2);
                    } else {
                        httpException = new HttpException("Exception in completion handler " + nextNode + " for " + this, th2);
                    }
                }
            }
        }
        if (httpException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(httpException);
        }
        cancelParent(th);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }

    public final void promoteEmptyToNodeList(Empty empty) {
        NodeList nodeList = new NodeList();
        Object inactiveNodeList = empty.isActive ? nodeList : new InactiveNodeList(nodeList);
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = _state$volatile$FU$offset;
            JobSupport jobSupport = this;
            Empty empty2 = empty;
            if (unsafe.compareAndSwapObject(jobSupport, j, empty2, inactiveNodeList) || unsafe.getObjectVolatile(jobSupport, j) != empty2) {
                return;
            }
            this = jobSupport;
            empty = empty2;
        }
    }

    public final void promoteSingleToNodeList(JobNode jobNode) {
        JobNode jobNode2;
        JobSupport jobSupport;
        NodeList nodeList = new NodeList();
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        unsafe.putObjectVolatile(nodeList, LockFreeLinkedListNode._prev$volatile$FU$offset, jobNode);
        long j = LockFreeLinkedListNode._next$volatile$FU$offset;
        unsafe.putObjectVolatile(nodeList, j, jobNode);
        loop0: while (true) {
            if (jobNode.getNext() != jobNode) {
                jobNode2 = jobNode;
                break;
            }
            while (true) {
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                jobNode2 = jobNode;
                if (unsafe2.compareAndSwapObject(jobNode2, LockFreeLinkedListNode._next$volatile$FU$offset, jobNode, nodeList)) {
                    nodeList.finishAdd(jobNode2);
                    break loop0;
                }
                jobSupport = this;
                jobNode = jobNode2;
                if (unsafe2.getObjectVolatile(jobNode2, j) != jobNode2) {
                    break;
                } else {
                    this = jobSupport;
                }
            }
            this = jobSupport;
        }
        LockFreeLinkedListNode nextNode = jobNode2.getNextNode();
        while (true) {
            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
            long j2 = _state$volatile$FU$offset;
            JobSupport jobSupport2 = this;
            if (unsafe3.compareAndSwapObject(jobSupport2, j2, jobNode2, nextNode) || unsafe3.getObjectVolatile(jobSupport2, j2) != jobNode2) {
                return;
            } else {
                this = jobSupport2;
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iStartInternal;
        do {
            iStartInternal = startInternal(getState$kotlinx_coroutines_core());
            if (iStartInternal == 0) {
                return false;
            }
        } while (iStartInternal != 1);
        return true;
    }

    public final int startInternal(Object obj) {
        Unsafe unsafe;
        Unsafe unsafe2;
        boolean z = obj instanceof Empty;
        long j = _state$volatile$FU$offset;
        if (z) {
            if (((Empty) obj).isActive) {
                return 0;
            }
            Empty empty = AwaitKt.EMPTY_ACTIVE;
            do {
                unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                if (unsafe2.compareAndSwapObject(this, _state$volatile$FU$offset, obj, empty)) {
                    onStart();
                    return 1;
                }
            } while (unsafe2.getObjectVolatile(this, j) == obj);
            return -1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        NodeList nodeList = ((InactiveNodeList) obj).list;
        do {
            unsafe = ArtificialStackFramesUnsafe.unsafe;
            if (unsafe.compareAndSwapObject(this, _state$volatile$FU$offset, obj, nodeList)) {
                onStart();
                return 1;
            }
        } while (unsafe.getObjectVolatile(this, j) == obj);
        return -1;
    }

    public final String toString() {
        return (nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}') + '@' + AwaitKt.getHexAddress(this);
    }

    public final Object tryMakeCompleting(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return AwaitKt.COMPLETING_ALREADY;
        }
        if ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) {
            JobSupport jobSupport = this;
            Incomplete incomplete = (Incomplete) obj;
            NodeList orPromoteCancellingList = jobSupport.getOrPromoteCancellingList(incomplete);
            if (orPromoteCancellingList == null) {
                return AwaitKt.COMPLETING_RETRY;
            }
            Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
            if (finishing == null) {
                finishing = new Finishing(orPromoteCancellingList, null);
            }
            Finishing finishing2 = finishing;
            synchronized (finishing2) {
                if (finishing2.isCompleting()) {
                    return AwaitKt.COMPLETING_ALREADY;
                }
                ArtificialStackFramesUnsafe.unsafe.putIntVolatile(finishing2, Finishing._isCompleting$volatile$FU$offset, 1);
                if (finishing2 != incomplete) {
                    while (true) {
                        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
                        long j = _state$volatile$FU$offset;
                        JobSupport jobSupport2 = jobSupport;
                        jobSupport = jobSupport2;
                        if (unsafe.compareAndSwapObject(jobSupport2, j, incomplete, finishing2)) {
                            break;
                        }
                        if (unsafe.getObjectVolatile(jobSupport, j) != incomplete) {
                            return AwaitKt.COMPLETING_RETRY;
                        }
                    }
                }
                boolean zIsCancelling = finishing2.isCancelling();
                CompletedExceptionally completedExceptionally = obj2 instanceof CompletedExceptionally ? (CompletedExceptionally) obj2 : null;
                if (completedExceptionally != null) {
                    finishing2.addExceptionLocked(completedExceptionally.cause);
                }
                Throwable rootCause = zIsCancelling ? null : finishing2.getRootCause();
                if (rootCause != null) {
                    jobSupport.notifyCancelling(orPromoteCancellingList, rootCause);
                }
                ChildHandleNode childHandleNodeNextChild = nextChild(orPromoteCancellingList);
                if (childHandleNodeNextChild != null && jobSupport.tryWaitForChild(finishing2, childHandleNodeNextChild, obj2)) {
                    return AwaitKt.COMPLETING_WAITING_CHILDREN;
                }
                orPromoteCancellingList.addLast(new ListClosed(2), 2);
                ChildHandleNode childHandleNodeNextChild2 = nextChild(orPromoteCancellingList);
                return (childHandleNodeNextChild2 == null || !jobSupport.tryWaitForChild(finishing2, childHandleNodeNextChild2, obj2)) ? jobSupport.finalizeFinishingState(finishing2, obj2) : AwaitKt.COMPLETING_WAITING_CHILDREN;
            }
        }
        Incomplete incomplete2 = (Incomplete) obj;
        Object incompleteStateBox = obj2 instanceof Incomplete ? new IncompleteStateBox((Incomplete) obj2) : obj2;
        while (true) {
            Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
            long j2 = _state$volatile$FU$offset;
            JobSupport jobSupport3 = this;
            if (unsafe2.compareAndSwapObject(jobSupport3, j2, incomplete2, incompleteStateBox)) {
                jobSupport3.onCompletionInternal(obj2);
                jobSupport3.completeStateFinalization(incomplete2, obj2);
                return obj2;
            }
            if (unsafe2.getObjectVolatile(jobSupport3, j2) != incomplete2) {
                return AwaitKt.COMPLETING_RETRY;
            }
            this = jobSupport3;
        }
    }

    public final boolean tryWaitForChild(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (AwaitKt.invokeOnCompletion(childHandleNode.childJob, false, new ChildCompletion(this, finishing, childHandleNode, obj)) == NonDisposableHandle.INSTANCE) {
            childHandleNode = nextChild(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 function1) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(function1));
    }

    public void onStart() {
    }

    public void afterCompletion(Object obj) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(HttpException httpException) {
        throw httpException;
    }

    public void onCompletionInternal(Object obj) {
    }
}
