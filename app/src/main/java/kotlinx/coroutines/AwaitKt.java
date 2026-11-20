package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import com.google.common.base.Joiner;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.LockSupport;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlinx.coroutines.AwaitAll.AwaitAllNode;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;
import okio.Path;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AwaitKt {
    public static final Joiner CLOSED_EMPTY;
    public static final Joiner COMPLETING_ALREADY;
    public static final Joiner COMPLETING_RETRY;
    public static final Joiner COMPLETING_WAITING_CHILDREN;
    public static final Joiner DISPOSED_TASK;
    public static final Joiner RESUME_TOKEN;
    public static final Joiner SEALED;
    public static final Joiner TOO_LATE_TO_CANCEL;
    public static final Empty EMPTY_NEW = new Empty(false);
    public static final Empty EMPTY_ACTIVE = new Empty(true);

    static {
        byte b = 5;
        RESUME_TOKEN = new Joiner("RESUME_TOKEN", b);
        DISPOSED_TASK = new Joiner("REMOVED_TASK", b);
        CLOSED_EMPTY = new Joiner("CLOSED_EMPTY", b);
        COMPLETING_ALREADY = new Joiner("COMPLETING_ALREADY", b);
        COMPLETING_WAITING_CHILDREN = new Joiner("COMPLETING_WAITING_CHILDREN", b);
        COMPLETING_RETRY = new Joiner("COMPLETING_RETRY", b);
        TOO_LATE_TO_CANCEL = new Joiner("TOO_LATE_TO_CANCEL", b);
        SEALED = new Joiner("SEALED", b);
    }

    public static final CancellationException CancellationException(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static CompletableDeferredImpl CompletableDeferred$default() {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(true);
        completableDeferredImpl.initParentJob(null);
        return completableDeferredImpl;
    }

    public static final ContextScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.$$INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(Job$default());
        }
        return new ContextScope(coroutineContext);
    }

    public static JobImpl Job$default() {
        return new JobImpl(null);
    }

    public static final ContextScope MainScope() {
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return new ContextScope(StringsKt__IndentKt.plus(supervisorJobImplSupervisorJob$default, MainDispatcherLoader.dispatcher));
    }

    public static SupervisorJobImpl SupervisorJob$default() {
        return new SupervisorJobImpl(null);
    }

    public static DeferredCoroutine async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        DeferredCoroutine deferredCoroutine = new DeferredCoroutine(newCoroutineContext(coroutineScope, coroutineContext), true);
        deferredCoroutine.start(CoroutineStart.DEFAULT, deferredCoroutine, function2);
        return deferredCoroutine;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object awaitAll(List list, SuspendLambda suspendLambda) {
        if (list.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        Deferred[] deferredArr = (Deferred[]) list.toArray(new Deferred[0]);
        AwaitAll awaitAll = new AwaitAll(deferredArr);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(suspendLambda));
        cancellableContinuationImpl.initCancellability();
        int length = deferredArr.length;
        AwaitAll.AwaitAllNode[] awaitAllNodeArr = new AwaitAll.AwaitAllNode[length];
        for (int i = 0; i < length; i++) {
            JobImpl jobImpl = deferredArr[i];
            jobImpl.start();
            AwaitAll.AwaitAllNode awaitAllNode = awaitAll.new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.handle = invokeOnCompletion(jobImpl, true, awaitAllNode);
            awaitAllNodeArr[i] = awaitAllNode;
        }
        AwaitAll.DisposeHandlersOnCancel disposeHandlersOnCancel = new AwaitAll.DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i2 = 0; i2 < length; i2++) {
            AwaitAll.AwaitAllNode awaitAllNode2 = awaitAllNodeArr[i2];
            awaitAllNode2.getClass();
            ArtificialStackFramesUnsafe.unsafe.putObjectVolatile(awaitAllNode2, AwaitAll.AwaitAllNode._disposer$volatile$FU$offset, disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.getState$kotlinx_coroutines_core() instanceof NotCompleted) {
            cancellableContinuationImpl.invokeOnCancellationImpl(disposeHandlersOnCancel);
        } else {
            disposeHandlersOnCancel.disposeAll();
        }
        return cancellableContinuationImpl.getResult();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void awaitCancellation(ContinuationImpl continuationImpl) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        if (continuationImpl instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuationImpl;
            int i = delayKt$awaitCancellation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i - Integer.MIN_VALUE;
            } else {
                delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuationImpl);
            }
        } else {
            delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuationImpl);
        }
        Object obj = delayKt$awaitCancellation$1.result;
        int i2 = delayKt$awaitCancellation$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            delayKt$awaitCancellation$1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(delayKt$awaitCancellation$1));
            cancellableContinuationImpl.initCancellability();
            if (cancellableContinuationImpl.getResult() == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            ResultKt.throwOnFailure(obj);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$3(coroutineScope, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final Object coroutineScope(Function2 function2, Continuation continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, continuation.getContext());
        return Okio__OkioKt.startUndispatched(scopeCoroutine, true, scopeCoroutine, function2);
    }

    public static final Object delay(long j, Continuation continuation) {
        if (j > 0) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(continuation));
            cancellableContinuationImpl.initCancellability();
            if (j < Long.MAX_VALUE) {
                getDelay(cancellableContinuationImpl.context).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return result;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m1897delayVtjQ1oo(long j, SuspendLambda suspendLambda) {
        Object objDelay = delay(m1898toDelayMillisLRDsOJo(j), suspendLambda);
        return objDelay == CoroutineSingletons.COROUTINE_SUSPENDED ? objDelay : Unit.INSTANCE;
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        Boolean bool = Boolean.FALSE;
        byte b = 9;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, new CombinedContext$$ExternalSyntheticLambda0(b))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, new CombinedContext$$ExternalSyntheticLambda0(b))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        CombinedContext$$ExternalSyntheticLambda0 combinedContext$$ExternalSyntheticLambda0 = new CombinedContext$$ExternalSyntheticLambda0((byte) 10);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, combinedContext$$ExternalSyntheticLambda0);
        Object objFold = coroutineContext2;
        if (zBooleanValue2) {
            objFold = coroutineContext2.fold(emptyCoroutineContext, new CombinedContext$$ExternalSyntheticLambda0((byte) 11));
        }
        return coroutineContext3.plus((CoroutineContext) objFold);
    }

    public static final Delay getDelay(CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor$Key.$$INSTANCE);
        Delay delay = element instanceof Delay ? (Delay) element : null;
        return delay == null ? DefaultExecutorKt.DefaultDelay : delay;
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(coroutineContext, "Current context doesn't contain Job in it: ");
        return null;
    }

    public static final CancellableContinuationImpl getOrCreateCancellableContinuation(Continuation continuation) {
        Unsafe unsafe;
        CancellableContinuationImpl cancellableContinuationImpl;
        CancellableContinuationImpl cancellableContinuationImpl2;
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl(1, continuation);
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Joiner joiner = InlineList.REUSABLE_CLAIMED;
        long j = DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset;
        loop0: while (true) {
            unsafe = ArtificialStackFramesUnsafe.unsafe;
            Object objectVolatile = unsafe.getObjectVolatile(dispatchedContinuation, j);
            cancellableContinuationImpl = null;
            if (objectVolatile == null) {
                unsafe.putObjectVolatile(dispatchedContinuation, j, joiner);
                cancellableContinuationImpl2 = null;
                break;
            }
            if (objectVolatile instanceof CancellableContinuationImpl) {
                do {
                    unsafe = ArtificialStackFramesUnsafe.unsafe;
                    if (unsafe.compareAndSwapObject(dispatchedContinuation, DispatchedContinuation._reusableCancellableContinuation$volatile$FU$offset, objectVolatile, joiner)) {
                        cancellableContinuationImpl2 = (CancellableContinuationImpl) objectVolatile;
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(dispatchedContinuation, j) == objectVolatile);
            } else if (objectVolatile != joiner && !(objectVolatile instanceof Throwable)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(objectVolatile, "Inconsistent state ");
                return null;
            }
        }
        if (cancellableContinuationImpl2 != null) {
            long j2 = CancellableContinuationImpl._state$volatile$FU$offset;
            Object objectVolatile2 = unsafe.getObjectVolatile(cancellableContinuationImpl2, j2);
            if (!(objectVolatile2 instanceof CompletedContinuation) || ((CompletedContinuation) objectVolatile2).idempotentResume == null) {
                unsafe.putIntVolatile(cancellableContinuationImpl2, CancellableContinuationImpl._decisionAndIndex$volatile$FU$offset, 536870911);
                unsafe.putObjectVolatile(cancellableContinuationImpl2, j2, Active.INSTANCE);
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                cancellableContinuationImpl2.detachChild$kotlinx_coroutines_core();
            }
            if (cancellableContinuationImpl != null) {
                return cancellableContinuationImpl;
            }
        }
        return new CancellableContinuationImpl(2, continuation);
    }

    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th) {
        if (th instanceof DispatchException) {
            th = ((DispatchException) th).cause;
        }
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.Key.$$INSTANCE);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            } else {
                InlineList.handleUncaughtCoroutineException(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                ResultKt.addSuppressed(runtimeException, th);
                th = runtimeException;
            }
            InlineList.handleUncaughtCoroutineException(coroutineContext, th);
        }
    }

    public static final DisposableHandle invokeOnCompletion(Job job, boolean z, JobNode jobNode) {
        if (job instanceof JobSupport) {
            return ((JobSupport) job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode);
        }
        return job.invokeOnCompletion(jobNode.getOnCancelling(), z, new JobKt__JobKt$invokeOnCompletion$1(1, jobNode, JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, (byte) 0));
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final StandaloneCoroutine launch(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        CoroutineContext coroutineContextNewCoroutineContext = newCoroutineContext(coroutineScope, coroutineContext);
        coroutineStart.getClass();
        StandaloneCoroutine lazyStandaloneCoroutine = coroutineStart == CoroutineStart.LAZY ? new LazyStandaloneCoroutine(coroutineContextNewCoroutineContext, function2) : new StandaloneCoroutine(coroutineContextNewCoroutineContext, true);
        lazyStandaloneCoroutine.start(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static StandaloneCoroutine launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextFoldCopies = foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return (coroutineContextFoldCopies == defaultScheduler || coroutineContextFoldCopies.get(ContinuationInterceptor$Key.$$INSTANCE) != null) ? coroutineContextFoldCopies : coroutineContextFoldCopies.plus(defaultScheduler);
    }

    public static final Object recoverResult(Object obj) {
        return obj instanceof CompletedExceptionally ? ResultKt.createFailure(((CompletedExceptionally) obj).cause) : obj;
    }

    public static final Object runBlockingK(CoroutineContext coroutineContext, Function2 function2) throws Throwable {
        EventLoop eventLoop$kotlinx_coroutines_core;
        CoroutineContext coroutineContextFoldCopies;
        long jProcessNextEvent;
        CoroutineContext.Key key = ContinuationInterceptor$Key.$$INSTANCE;
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContext.get(key);
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher == null) {
            eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
            coroutineContextFoldCopies = foldCopies(emptyCoroutineContext, coroutineContext.plus(eventLoop$kotlinx_coroutines_core), true);
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            if (coroutineContextFoldCopies != defaultScheduler && coroutineContextFoldCopies.get(key) == null) {
                coroutineContextFoldCopies = coroutineContextFoldCopies.plus(defaultScheduler);
            }
        } else {
            eventLoop$kotlinx_coroutines_core = (EventLoop) ThreadLocalEventLoop.ref.get();
            coroutineContextFoldCopies = foldCopies(emptyCoroutineContext, coroutineContext, true);
            DefaultScheduler defaultScheduler2 = Dispatchers.Default;
            if (coroutineContextFoldCopies != defaultScheduler2 && coroutineContextFoldCopies.get(key) == null) {
                coroutineContextFoldCopies = coroutineContextFoldCopies.plus(defaultScheduler2);
            }
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContextFoldCopies, Thread.currentThread(), eventLoop$kotlinx_coroutines_core);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        EventLoop eventLoop = blockingCoroutine.eventLoop;
        if (eventLoop != null) {
            int i = EventLoop.$r8$clinit;
            eventLoop.incrementUseCount(false);
        }
        while (true) {
            if (eventLoop != null) {
                try {
                    jProcessNextEvent = eventLoop.processNextEvent();
                } catch (Throwable th) {
                    if (eventLoop != null) {
                        int i2 = EventLoop.$r8$clinit;
                        eventLoop.decrementUseCount(false);
                    }
                    throw th;
                }
            } else {
                jProcessNextEvent = Long.MAX_VALUE;
            }
            if (blockingCoroutine.isCompleted()) {
                break;
            }
            LockSupport.parkNanos(blockingCoroutine, jProcessNextEvent);
            if (Thread.interrupted()) {
                blockingCoroutine.cancelImpl$kotlinx_coroutines_core(new InterruptedException());
            }
        }
        if (eventLoop != null) {
            int i3 = EventLoop.$r8$clinit;
            eventLoop.decrementUseCount(false);
        }
        Object objUnboxState = unboxState(blockingCoroutine.getState$kotlinx_coroutines_core());
        CompletedExceptionally completedExceptionally = objUnboxState instanceof CompletedExceptionally ? (CompletedExceptionally) objUnboxState : null;
        if (completedExceptionally == null) {
            return objUnboxState;
        }
        throw completedExceptionally.cause;
    }

    public static final Object setupTimeout(TimeoutCoroutine timeoutCoroutine, Function2 function2) {
        invokeOnCompletion(timeoutCoroutine, true, new DisposeOnCompletion(getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.context)));
        return Okio__OkioKt.startUndispatched(timeoutCoroutine, false, timeoutCoroutine, function2);
    }

    public static final String toDebugString(Continuation continuation) {
        Object failure;
        if (continuation instanceof DispatchedContinuation) {
            return ((DispatchedContinuation) continuation).toString();
        }
        try {
            failure = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m1866exceptionOrNullimpl(failure) != null) {
            failure = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) failure;
    }

    /* JADX INFO: renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m1898toDelayMillisLRDsOJo(long j) {
        Path.Companion companion = Duration.Companion;
        boolean z = j > 0;
        if (z) {
            return Duration.m1887getInWholeMillisecondsimpl(Duration.m1890plusLRDsOJo(j, InstantKt.toDuration(999999L, DurationUnit.NANOSECONDS)));
        }
        if (!z) {
            return 0L;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return 0L;
    }

    public static final Object unboxState(Object obj) {
        IncompleteStateBox incompleteStateBox = obj instanceof IncompleteStateBox ? (IncompleteStateBox) obj : null;
        return incompleteStateBox != null ? incompleteStateBox.state : obj;
    }

    public static final UndispatchedCoroutine updateUndispatchedCompletion(Continuation continuation, CoroutineContext coroutineContext, Object obj) {
        UndispatchedCoroutine undispatchedCoroutine = null;
        if ((continuation instanceof CoroutineStackFrame) && coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
            CoroutineStackFrame callerFrame = (CoroutineStackFrame) continuation;
            while (!(callerFrame instanceof DispatchedCoroutine) && (callerFrame = callerFrame.getCallerFrame()) != null) {
                if (callerFrame instanceof UndispatchedCoroutine) {
                    undispatchedCoroutine = (UndispatchedCoroutine) callerFrame;
                    break;
                }
            }
            if (undispatchedCoroutine != null) {
                undispatchedCoroutine.saveThreadContext(coroutineContext, obj);
            }
        }
        return undispatchedCoroutine;
    }

    public static final Object withContext(CoroutineContext coroutineContext, Function2 function2, Continuation continuation) {
        Unsafe unsafe;
        long j;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, new CombinedContext$$ExternalSyntheticLambda0((byte) 9))).booleanValue() ? context.plus(coroutineContext) : foldCopies(context, coroutineContext, false);
        ensureActive(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, coroutineContextPlus);
            return Okio__OkioKt.startUndispatched(scopeCoroutine, true, scopeCoroutine, function2);
        }
        ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
        if (Intrinsics.areEqual(coroutineContextPlus.get(continuationInterceptor$Key), context.get(continuationInterceptor$Key))) {
            UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(continuation, coroutineContextPlus);
            CoroutineContext coroutineContext2 = undispatchedCoroutine.context;
            Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext2, null);
            try {
                return Okio__OkioKt.startUndispatched(undispatchedCoroutine, true, undispatchedCoroutine, function2);
            } finally {
                InlineList.restoreThreadContext(coroutineContext2, objUpdateThreadContext);
            }
        }
        DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(continuation, coroutineContextPlus);
        try {
            InlineList.resumeCancellableWithInternal(Unit.INSTANCE, Okio__OkioKt.intercepted(Okio__OkioKt.createCoroutineUnintercepted(dispatchedCoroutine, dispatchedCoroutine, function2)));
            do {
                unsafe = ArtificialStackFramesUnsafe.unsafe;
                j = DispatchedCoroutine._decision$volatile$FU$offset;
                int intVolatile = unsafe.getIntVolatile(dispatchedCoroutine, j);
                if (intVolatile != 0) {
                    if (intVolatile != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Already suspended");
                        return null;
                    }
                    Object objUnboxState = unboxState(dispatchedCoroutine.getState$kotlinx_coroutines_core());
                    if (objUnboxState instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) objUnboxState).cause;
                    }
                    return objUnboxState;
                }
            } while (!unsafe.compareAndSwapInt(dispatchedCoroutine, j, 0, 1));
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        } catch (Throwable th) {
            StringsKt__IndentKt.dispatcherFailure(th, dispatchedCoroutine);
            throw null;
        }
    }

    public static final Object withTimeout(long j, Function2 function2, ContinuationImpl continuationImpl) {
        if (j > 0) {
            return setupTimeout(new TimeoutCoroutine(j, continuationImpl), function2);
        }
        throw new TimeoutCancellationException("Timed out immediately", null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object withTimeoutOrNull(long j, Function2 function2, ContinuationImpl continuationImpl) {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        Ref$ObjectRef ref$ObjectRef;
        if (continuationImpl instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuationImpl;
            int i = timeoutKt$withTimeoutOrNull$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i - Integer.MIN_VALUE;
            } else {
                timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuationImpl);
            }
        } else {
            timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuationImpl);
        }
        Object obj = timeoutKt$withTimeoutOrNull$1.result;
        int i2 = timeoutKt$withTimeoutOrNull$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (j > 0) {
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                try {
                    timeoutKt$withTimeoutOrNull$1.L$1 = ref$ObjectRef2;
                    timeoutKt$withTimeoutOrNull$1.label = 1;
                    TimeoutCoroutine timeoutCoroutine = new TimeoutCoroutine(j, timeoutKt$withTimeoutOrNull$1);
                    ref$ObjectRef2.element = timeoutCoroutine;
                    Object obj2 = setupTimeout(timeoutCoroutine, function2);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    return obj2 == coroutineSingletons ? coroutineSingletons : obj2;
                } catch (TimeoutCancellationException e) {
                    e = e;
                    ref$ObjectRef = ref$ObjectRef2;
                }
            }
            return null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ref$ObjectRef = timeoutKt$withTimeoutOrNull$1.L$1;
        try {
            ResultKt.throwOnFailure(obj);
            return obj;
        } catch (TimeoutCancellationException e2) {
            e = e2;
        }
        if (e.coroutine != ref$ObjectRef.element) {
            throw e;
        }
        return null;
    }

    /* JADX INFO: renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final Object m1899withTimeoutOrNullKLykuaI(long j, Function2 function2, ContinuationImpl continuationImpl) {
        return withTimeoutOrNull(m1898toDelayMillisLRDsOJo(j), function2, continuationImpl);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object yield(Continuation continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        ensureActive(context);
        Continuation continuationIntercepted = Okio__OkioKt.intercepted(continuation);
        DispatchedContinuation dispatchedContinuation = continuationIntercepted instanceof DispatchedContinuation ? (DispatchedContinuation) continuationIntercepted : null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Unit unit = Unit.INSTANCE;
        if (dispatchedContinuation == null) {
            obj = unit;
        } else {
            CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.dispatcher;
            if (InlineList.safeIsDispatchNeeded(coroutineDispatcher, context)) {
                dispatchedContinuation._state = unit;
                dispatchedContinuation.resumeMode = 1;
                coroutineDispatcher.dispatchYield(context, dispatchedContinuation);
            } else {
                YieldContext yieldContext = new YieldContext(YieldContext.Key);
                CoroutineContext coroutineContextPlus = context.plus(yieldContext);
                dispatchedContinuation._state = unit;
                dispatchedContinuation.resumeMode = 1;
                coroutineDispatcher.dispatchYield(coroutineContextPlus, dispatchedContinuation);
                if (yieldContext.dispatcherWasUnconfined) {
                    EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core();
                    ArrayDeque arrayDeque = eventLoop$kotlinx_coroutines_core.unconfinedQueue;
                    if (!(arrayDeque != null ? arrayDeque.isEmpty() : true)) {
                        if (eventLoop$kotlinx_coroutines_core.useCount >= 4294967296L) {
                            dispatchedContinuation._state = unit;
                            dispatchedContinuation.resumeMode = 1;
                            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
                        } else {
                            eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
                            try {
                                dispatchedContinuation.run();
                                do {
                                } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
                            } catch (Throwable th) {
                                try {
                                    dispatchedContinuation.handleFatalException$kotlinx_coroutines_core(th);
                                } catch (Throwable th2) {
                                    eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                                    throw th2;
                                }
                            }
                            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
                        }
                    }
                    obj = unit;
                }
            }
            obj = coroutineSingletons;
        }
        return obj == coroutineSingletons ? obj : unit;
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }
}
