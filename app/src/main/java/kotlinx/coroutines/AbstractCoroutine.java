package kotlinx.coroutines;

import _COROUTINE.ArtificialStackFramesUnsafe;
import coil3.network.HttpException;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.internal.InlineList;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractCoroutine extends JobSupport implements Continuation, CoroutineScope {
    public final CoroutineContext context;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z) {
        super(z);
        initParentJob((Job) coroutineContext.get(Job.Key.$$INSTANCE));
        this.context = coroutineContext.plus(this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final String cancellationExceptionMessage() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(HttpException httpException) {
        AwaitKt.handleCoroutineException(this.context, httpException);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            onCompleted(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, ArtificialStackFramesUnsafe.unsafe.getIntVolatile(completedExceptionally, CompletedExceptionally._handled$volatile$FU$offset) == 1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
        if (thM1866exceptionOrNullimpl != null) {
            obj = new CompletedExceptionally(thM1866exceptionOrNullimpl, false);
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(obj);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == AwaitKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public final void start(CoroutineStart coroutineStart, AbstractCoroutine abstractCoroutine, Function2 function2) {
        Object objInvoke;
        int iOrdinal = coroutineStart.ordinal();
        Unit unit = Unit.INSTANCE;
        if (iOrdinal == 0) {
            try {
                InlineList.resumeCancellableWithInternal(unit, Okio__OkioKt.intercepted(Okio__OkioKt.createCoroutineUnintercepted(abstractCoroutine, this, function2)));
                return;
            } catch (Throwable th) {
                StringsKt__IndentKt.dispatcherFailure(th, this);
                throw null;
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                function2.getClass();
                Okio__OkioKt.intercepted(Okio__OkioKt.createCoroutineUnintercepted(abstractCoroutine, this, function2)).resumeWith(unit);
                return;
            }
            if (iOrdinal != 3) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
            try {
                CoroutineContext coroutineContext = this.context;
                Object objUpdateThreadContext = InlineList.updateThreadContext(coroutineContext, null);
                try {
                    if (function2 instanceof BaseContinuationImpl) {
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
                        objInvoke = function2.invoke(abstractCoroutine, this);
                    } else {
                        objInvoke = Okio__OkioKt.wrapWithContinuationImpl(function2, abstractCoroutine, this);
                    }
                    InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    if (objInvoke != CoroutineSingletons.COROUTINE_SUSPENDED) {
                        resumeWith(objInvoke);
                    }
                } catch (Throwable th2) {
                    InlineList.restoreThreadContext(coroutineContext, objUpdateThreadContext);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                if (th instanceof DispatchException) {
                    th = ((DispatchException) th).cause;
                }
                resumeWith(new Result.Failure(th));
            }
        }
    }

    public void onCompleted(Object obj) {
    }

    public void onCancelled(Throwable th, boolean z) {
    }
}
