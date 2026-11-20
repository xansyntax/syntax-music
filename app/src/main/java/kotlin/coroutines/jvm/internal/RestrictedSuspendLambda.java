package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase {
    private final int arity;

    public RestrictedSuspendLambda(int i, Continuation continuation) {
        super(continuation);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        Reflection.factory.getClass();
        return ReflectionFactory.renderLambdaToString(this);
    }
}
