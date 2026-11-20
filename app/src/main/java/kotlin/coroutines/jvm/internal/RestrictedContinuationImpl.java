package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(Continuation continuation) {
        super(continuation);
        if (continuation == null || continuation.getContext() == EmptyCoroutineContext.INSTANCE) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
