package kotlinx.coroutines.selects;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectImplementation implements CancelHandler, Waiter {
    public static final /* synthetic */ long state$volatile$FU$offset = ArtificialStackFramesUnsafe.unsafe.objectFieldOffset(SelectImplementation.class.getDeclaredField("state$volatile"));
    public final CoroutineContext context;
    public Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = SelectKt.STATE_REG;
    public ArrayList clauses = new ArrayList(2);
    public int indexInSegment = -1;
    public Object internalResult = SelectKt.NO_RESULT;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClauseData {
        public final SuspendLambda block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3 onCancellationConstructor;
        public final Object param;
        public final Function3 processResFunc;
        public final Function3 regFunc;

        public ClauseData(Object obj, Function3 function3, Function3 function4, Object obj2, SuspendLambda suspendLambda, Function3 function5) {
            this.clauseObject = obj;
            this.regFunc = function3;
            this.processResFunc = function4;
            this.param = obj2;
            this.block = suspendLambda;
            this.onCancellationConstructor = function5;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, SelectImplementation.this.context);
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectImplementation.this.doSelectSuspend(this);
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    public final Object complete(ContinuationImpl continuationImpl) {
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = state$volatile$FU$offset;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        objectVolatile.getClass();
        ClauseData clauseData = (ClauseData) objectVolatile;
        Object obj = clauseData.param;
        Object obj2 = this.internalResult;
        ArrayList arrayList = this.clauses;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                ClauseData clauseData2 = (ClauseData) obj3;
                if (clauseData2 != clauseData) {
                    clauseData2.dispose();
                }
            }
            ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(this, j, SelectKt.STATE_COMPLETED);
            this.internalResult = SelectKt.NO_RESULT;
            this.clauses = null;
        }
        Object objInvoke = clauseData.processResFunc.invoke(clauseData.clauseObject, obj, obj2);
        Continuation continuation = clauseData.block;
        return obj == SelectKt.PARAM_CLAUSE_0 ? ((Function1) continuation).invoke(continuationImpl) : ((Function2) continuation).invoke(objInvoke, continuationImpl);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    public final Object doSelectSuspend(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        CancellableContinuationImpl cancellableContinuationImpl;
        Unsafe unsafe;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj2 = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        Object obj3 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            anonymousClass2.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(anonymousClass2));
            cancellableContinuationImpl2.initCancellability();
            loop0: while (true) {
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                long j = state$volatile$FU$offset;
                Object objectVolatile = unsafe2.getObjectVolatile(this, j);
                obj = Unit.INSTANCE;
                CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
                Joiner joiner = SelectKt.STATE_REG;
                if (objectVolatile == joiner) {
                    CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
                    while (true) {
                        Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
                        cancellableContinuationImpl = cancellableContinuationImpl4;
                        if (unsafe3.compareAndSwapObject(this, state$volatile$FU$offset, objectVolatile, cancellableContinuationImpl4)) {
                            cancellableContinuationImpl.invokeOnCancellationImpl(this);
                            break loop0;
                        }
                        if (unsafe3.getObjectVolatile(this, j) != objectVolatile) {
                            break;
                        }
                        cancellableContinuationImpl4 = cancellableContinuationImpl;
                    }
                    cancellableContinuationImpl2 = cancellableContinuationImpl;
                } else {
                    cancellableContinuationImpl = cancellableContinuationImpl3;
                    if (!(objectVolatile instanceof List)) {
                        if (!(objectVolatile instanceof ClauseData)) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "unexpected state: ");
                            return null;
                        }
                        ClauseData clauseData = (ClauseData) objectVolatile;
                        Object obj4 = this.internalResult;
                        Function3 function3 = clauseData.onCancellationConstructor;
                        cancellableContinuationImpl.resume(obj, function3 != null ? (Function3) function3.invoke(this, clauseData.param, obj4) : null);
                        break;
                    }
                    do {
                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe.compareAndSwapObject(this, state$volatile$FU$offset, objectVolatile, joiner)) {
                            Iterator it = ((Iterable) objectVolatile).iterator();
                            while (it.hasNext()) {
                                ClauseData clauseDataFindClause = findClause(it.next());
                                clauseDataFindClause.getClass();
                                clauseDataFindClause.disposableHandleOrSegment = null;
                                clauseDataFindClause.indexInSegment = -1;
                                register(clauseDataFindClause, true);
                            }
                            break;
                        }
                    } while (unsafe.getObjectVolatile(this, j) == objectVolatile);
                    cancellableContinuationImpl2 = cancellableContinuationImpl;
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == obj3) {
                obj = result;
            }
            if (obj != obj3) {
            }
        }
        if (i2 != 1) {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj2);
                return obj2;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj2);
        anonymousClass2.label = 2;
        Object objComplete = complete(anonymousClass2);
        return objComplete == obj3 ? obj3 : objComplete;
    }

    public final ClauseData findClause(Object obj) {
        Object obj2;
        ArrayList arrayList = this.clauses;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        do {
            if (i >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList.get(i);
            i++;
        } while (((ClauseData) obj2).clauseObject != obj);
        ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Clause with object ", obj, " is not found");
        return null;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public final void invoke(Throwable th) {
        SelectImplementation selectImplementation;
        while (true) {
            Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
            long j = state$volatile$FU$offset;
            Object objectVolatile = unsafe.getObjectVolatile(this, j);
            if (objectVolatile == SelectKt.STATE_COMPLETED) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                selectImplementation = this;
                if (unsafe2.compareAndSwapObject(selectImplementation, state$volatile$FU$offset, objectVolatile, SelectKt.STATE_CANCELLED)) {
                    ArrayList arrayList = selectImplementation.clauses;
                    if (arrayList == null) {
                        return;
                    }
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((ClauseData) obj).dispose();
                    }
                    selectImplementation.internalResult = SelectKt.NO_RESULT;
                    selectImplementation.clauses = null;
                    return;
                }
                if (unsafe2.getObjectVolatile(selectImplementation, j) != objectVolatile) {
                    break;
                } else {
                    this = selectImplementation;
                }
            }
            this = selectImplementation;
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = i;
    }

    public final void register(ClauseData clauseData, boolean z) {
        Object obj = clauseData.clauseObject;
        Unsafe unsafe = ArtificialStackFramesUnsafe.unsafe;
        long j = state$volatile$FU$offset;
        if (unsafe.getObjectVolatile(this, j) instanceof ClauseData) {
            return;
        }
        if (!z) {
            ArrayList arrayList = this.clauses;
            arrayList.getClass();
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    if (((ClauseData) obj2).clauseObject == obj) {
                        PathKt$$ExternalSyntheticBUOutline0.m$2(obj, "Cannot use select clauses on the same object: ");
                        return;
                    }
                }
            }
        }
        clauseData.regFunc.invoke(obj, this, clauseData.param);
        if (this.internalResult != SelectKt.NO_RESULT) {
            ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(this, j, clauseData);
            return;
        }
        if (!z) {
            ArrayList arrayList2 = this.clauses;
            arrayList2.getClass();
            arrayList2.add(clauseData);
        }
        clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
        clauseData.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    public final int trySelectInternal(Object obj, Object obj2) {
        SelectImplementation selectImplementation;
        Unsafe unsafe;
        Unsafe unsafe2;
        while (true) {
            Unsafe unsafe3 = ArtificialStackFramesUnsafe.unsafe;
            long j = state$volatile$FU$offset;
            Object objectVolatile = unsafe3.getObjectVolatile(this, j);
            if (objectVolatile instanceof CancellableContinuation) {
                ClauseData clauseDataFindClause = this.findClause(obj);
                if (clauseDataFindClause != null) {
                    Function3 function3 = clauseDataFindClause.onCancellationConstructor;
                    Function3 function4 = function3 != null ? (Function3) function3.invoke(this, clauseDataFindClause.param, obj2) : null;
                    while (true) {
                        Unsafe unsafe4 = ArtificialStackFramesUnsafe.unsafe;
                        selectImplementation = this;
                        if (unsafe4.compareAndSwapObject(selectImplementation, state$volatile$FU$offset, objectVolatile, clauseDataFindClause)) {
                            CancellableContinuation cancellableContinuation = (CancellableContinuation) objectVolatile;
                            selectImplementation.internalResult = obj2;
                            Joiner joinerTryResume = cancellableContinuation.tryResume(Unit.INSTANCE, function4);
                            if (joinerTryResume == null) {
                                selectImplementation.internalResult = SelectKt.NO_RESULT;
                                return 2;
                            }
                            cancellableContinuation.completeResume(joinerTryResume);
                            return 0;
                        }
                        if (unsafe4.getObjectVolatile(selectImplementation, j) != objectVolatile) {
                            break;
                        }
                        this = selectImplementation;
                    }
                } else {
                    continue;
                }
            } else {
                selectImplementation = this;
                if (Intrinsics.areEqual(objectVolatile, SelectKt.STATE_COMPLETED) || (objectVolatile instanceof ClauseData)) {
                    return 3;
                }
                if (Intrinsics.areEqual(objectVolatile, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (Intrinsics.areEqual(objectVolatile, SelectKt.STATE_REG)) {
                    List listListOf = CollectionsKt__IterablesKt.listOf(obj);
                    do {
                        unsafe2 = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe2.compareAndSwapObject(selectImplementation, state$volatile$FU$offset, objectVolatile, listListOf)) {
                            return 1;
                        }
                    } while (unsafe2.getObjectVolatile(selectImplementation, j) == objectVolatile);
                } else {
                    if (!(objectVolatile instanceof List)) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "Unexpected state: ");
                        return 0;
                    }
                    ArrayList arrayListPlus = CollectionsKt.plus(obj, (Collection) objectVolatile);
                    do {
                        unsafe = ArtificialStackFramesUnsafe.unsafe;
                        if (unsafe.compareAndSwapObject(selectImplementation, state$volatile$FU$offset, objectVolatile, arrayListPlus)) {
                            return 1;
                        }
                    } while (unsafe.getObjectVolatile(selectImplementation, j) == objectVolatile);
                }
            }
            this = selectImplementation;
        }
    }
}
