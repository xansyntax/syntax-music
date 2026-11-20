package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFramesUnsafe;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.network.HttpException;
import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadContextElement;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InlineList {
    public static final Joiner CLOSED;
    public static final Joiner NO_THREAD_ELEMENTS;
    public static final Joiner REUSABLE_CLAIMED;
    public static final Joiner UNDEFINED;
    public static final CombinedContext$$ExternalSyntheticLambda0 countAll = new CombinedContext$$ExternalSyntheticLambda0(14);
    public static final CombinedContext$$ExternalSyntheticLambda0 findOne = new CombinedContext$$ExternalSyntheticLambda0(15);
    public static final CombinedContext$$ExternalSyntheticLambda0 updateState = new CombinedContext$$ExternalSyntheticLambda0(16);

    static {
        byte b = 5;
        CLOSED = new Joiner("CLOSED", b);
        UNDEFINED = new Joiner("UNDEFINED", b);
        REUSABLE_CLAIMED = new Joiner("REUSABLE_CLAIMED", b);
        NO_THREAD_ELEMENTS = new Joiner("NO_THREAD_ELEMENTS", b);
    }

    public static final void callUndeliveredElement(Function1 function1, Object obj, CoroutineContext coroutineContext) {
        HttpException httpExceptionCallUndeliveredElementCatchingException = callUndeliveredElementCatchingException(function1, obj, null);
        if (httpExceptionCallUndeliveredElementCatchingException != null) {
            AwaitKt.handleCoroutineException(coroutineContext, httpExceptionCallUndeliveredElementCatchingException);
        }
    }

    public static final HttpException callUndeliveredElementCatchingException(Function1 function1, Object obj, HttpException httpException) {
        try {
            function1.invoke(obj);
            return httpException;
        } catch (Throwable th) {
            if (httpException != null && httpException.getCause() != th) {
                ResultKt.addSuppressed(httpException, th);
                return httpException;
            }
            return new HttpException("Exception in undelivered element handler for " + obj, th);
        }
    }

    public static final void checkParallelism(int i) {
        if (i >= 1) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected positive parallelism level, but got "));
    }

    public static final Object findSegmentInternal(Segment segment, long j, Function2 function2) {
        Unsafe unsafe;
        long j2;
        while (true) {
            Segment segment2 = segment;
            while (true) {
                if (segment2.id >= j && !segment2.isRemoved()) {
                    return segment2;
                }
                Object objectVolatile = ArtificialStackFramesUnsafe.unsafe.getObjectVolatile(segment2, ConcurrentLinkedListNode._next$volatile$FU$offset);
                Joiner joiner = CLOSED;
                if (objectVolatile == joiner) {
                    return joiner;
                }
                segment = (Segment) ((ConcurrentLinkedListNode) objectVolatile);
                if (segment != null) {
                    break;
                }
                Segment segment3 = (Segment) function2.invoke(Long.valueOf(segment2.id + 1), segment2);
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    j2 = ConcurrentLinkedListNode._next$volatile$FU$offset;
                    if (unsafe.compareAndSwapObject(segment2, j2, (Object) null, segment3)) {
                        if (segment2.isRemoved()) {
                            segment2.remove();
                        }
                        segment2 = segment3;
                        break;
                    }
                } while (unsafe.getObjectVolatile(segment2, j2) == null);
            }
        }
    }

    /* JADX INFO: renamed from: getSegment-impl, reason: not valid java name */
    public static final Segment m1905getSegmentimpl(Object obj) {
        if (obj != CLOSED) {
            return (Segment) obj;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Does not contain segment");
        return null;
    }

    public static final void handleUncaughtCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        Throwable runtimeException;
        Iterator it = CoroutineExceptionHandlerImplKt.platformExceptionHandlers.iterator();
        while (it.hasNext()) {
            try {
                ((CoroutineExceptionHandler) it.next()).handleException(coroutineContext, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    ResultKt.addSuppressed(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            ResultKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m1906isClosedimpl(Object obj) {
        return obj == CLOSED;
    }

    /* JADX INFO: renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m1907plusFjFbRPM(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (!(obj instanceof ThreadState)) {
            Object objFold = coroutineContext.fold(null, findOne);
            objFold.getClass();
            ((ThreadContextElement) objFold).restoreThreadContext(obj);
            return;
        }
        ThreadState threadState = (ThreadState) obj;
        ThreadContextElement[] threadContextElementArr = threadState.elements;
        int length = threadContextElementArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            ThreadContextElement threadContextElement = threadContextElementArr[length];
            threadContextElement.getClass();
            threadContextElement.restoreThreadContext(threadState.values[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    public static final void resumeCancellableWithInternal(Object obj, Continuation continuation) throws DispatchException {
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
        Object completedExceptionally = thM1866exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM1866exceptionOrNullimpl, false);
        if (safeIsDispatchNeeded(coroutineDispatcher, continuationImpl.getContext())) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            safeDispatch(coroutineDispatcher, continuationImpl.getContext(), dispatchedContinuation);
            return;
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
            dispatchedContinuation._state = completedExceptionally;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            Job job = (Job) continuationImpl.getContext().get(Job.Key.$$INSTANCE);
            if (job == null || job.isActive()) {
                Object obj2 = dispatchedContinuation.countOrElement;
                CoroutineContext context = continuationImpl.getContext();
                Object objUpdateThreadContext = updateThreadContext(context, obj2);
                UndispatchedCoroutine undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != NO_THREAD_ELEMENTS ? AwaitKt.updateUndispatchedCompletion(continuationImpl, context, objUpdateThreadContext) : null;
                try {
                    continuationImpl.resumeWith(obj);
                    if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                        restoreThreadContext(context, objUpdateThreadContext);
                    }
                } catch (Throwable th) {
                    if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                        restoreThreadContext(context, objUpdateThreadContext);
                    }
                    throw th;
                }
            } else {
                dispatchedContinuation.resumeWith(ResultKt.createFailure(job.getCancellationException()));
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th2);
            } finally {
                eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            }
        }
    }

    public static final void safeDispatch(CoroutineDispatcher coroutineDispatcher, CoroutineContext coroutineContext, Runnable runnable) throws DispatchException {
        try {
            coroutineDispatcher.dispatch(coroutineContext, runnable);
        } catch (Throwable th) {
            throw new DispatchException(th, coroutineDispatcher, coroutineContext);
        }
    }

    public static final boolean safeIsDispatchNeeded(CoroutineDispatcher coroutineDispatcher, CoroutineContext coroutineContext) throws DispatchException {
        try {
            return coroutineDispatcher.isDispatchNeeded(coroutineContext);
        } catch (Throwable th) {
            throw new DispatchException(th, coroutineDispatcher, coroutineContext);
        }
    }

    public static final long systemProp(String str, long j, long j2, long j3) {
        String property;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, property);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int systemProp$default(int i, int i2, String str) {
        return (int) systemProp(str, i, 1L, (i2 & 8) != 0 ? Integer.MAX_VALUE : 2097150);
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, countAll);
        objFold.getClass();
        return objFold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        return obj instanceof Integer ? coroutineContext.fold(new ThreadState(((Number) obj).intValue(), coroutineContext), updateState) : ((ThreadContextElement) obj).updateThreadContext();
    }
}
