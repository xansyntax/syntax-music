package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class DeepRecursiveScopeImpl implements Continuation {
    public Continuation cont;
    public JsonTreeReader$readDeepRecursive$1 function;
    public Object result;

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.cont = null;
        this.result = obj;
    }
}
