package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.InlineList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DispatchedTaskKt {
    public static final <T> void resume(DispatchedTask dispatchedTask, Continuation continuation, boolean z) {
        Object objTakeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        Object failure = exceptionalResult$kotlinx_coroutines_core != null ? new Result.Failure(exceptionalResult$kotlinx_coroutines_core) : dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        if (!z) {
            continuation.resumeWith(failure);
            return;
        }
        continuation.getClass();
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        ContinuationImpl continuationImpl = dispatchedContinuation.continuation;
        Object obj = dispatchedContinuation.countOrElement;
        CoroutineContext context = continuationImpl.getContext();
        Object objUpdateThreadContext = InlineList.updateThreadContext(context, obj);
        UndispatchedCoroutine undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != InlineList.NO_THREAD_ELEMENTS ? AwaitKt.updateUndispatchedCompletion(continuationImpl, context, objUpdateThreadContext) : null;
        try {
            continuationImpl.resumeWith(failure);
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                InlineList.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }
}
