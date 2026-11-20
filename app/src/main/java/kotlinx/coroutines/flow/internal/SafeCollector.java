package kotlinx.coroutines.flow.internal;

import io.ktor.http.URLParserKt$$ExternalSyntheticLambda0;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class SafeCollector extends ContinuationImpl implements FlowCollector {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector collector;
    public Continuation completion_;
    public CoroutineContext lastEmissionContext;

    public SafeCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new CombinedContext$$ExternalSyntheticLambda0((byte) 13))).intValue();
    }

    public final Object emit(Continuation continuation, Object obj) {
        CoroutineContext context = continuation.getContext();
        AwaitKt.ensureActive(context);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (coroutineContext instanceof DownstreamExceptionContext) {
                throw new IllegalStateException(StringsKt__IndentKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((DownstreamExceptionContext) coroutineContext).e + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) context.fold(0, new URLParserKt$$ExternalSyntheticLambda0((byte) 11, this))).intValue() != this.collectContextSize) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.collectContext + ",\n\t\tbut emission happened in " + context + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.lastEmissionContext = context;
        }
        this.completion_ = continuation;
        Function3 function3 = SafeCollectorKt.emitFun;
        FlowCollector flowCollector = this.collector;
        flowCollector.getClass();
        Object objInvoke = function3.invoke(flowCollector, obj, this);
        if (!Intrinsics.areEqual(objInvoke, CoroutineSingletons.COROUTINE_SUSPENDED)) {
            this.completion_ = null;
        }
        return objInvoke;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.completion_;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.INSTANCE : coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(obj);
        if (thM1866exceptionOrNullimpl != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(getContext(), thM1866exceptionOrNullimpl);
        }
        Continuation continuation = this.completion_;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        try {
            Object objEmit = emit(continuation, obj);
            return objEmit == CoroutineSingletons.COROUTINE_SUSPENDED ? objEmit : Unit.INSTANCE;
        } catch (Throwable th) {
            this.lastEmissionContext = new DownstreamExceptionContext(continuation.getContext(), th);
            throw th;
        }
    }
}
