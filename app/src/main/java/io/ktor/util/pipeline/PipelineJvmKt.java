package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0095\u0001\u0010\f\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002D\u0010\b\u001a@\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0003j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "TSubject", "TContext", "Lkotlin/Function3;", "Lio/ktor/util/pipeline/PipelineContext;", "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/util/pipeline/PipelineInterceptor;", "interceptor", "context", "subject", "continuation", "pipelineStartCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function3;Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PipelineJvmKt {
    public static final <TSubject, TContext> Object pipelineStartCoroutineUninterceptedOrReturn(Function3 function3, PipelineContext<TSubject, TContext> pipelineContext, TSubject tsubject, Continuation continuation) {
        function3.getClass();
        pipelineContext.getClass();
        tsubject.getClass();
        continuation.getClass();
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, function3);
        return function3.invoke(pipelineContext, tsubject, continuation);
    }
}
