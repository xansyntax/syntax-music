package com.dokar.quickjs;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QuickJs$invokeAsyncFunction$job$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object[] $args;
    public final /* synthetic */ Function2 $block;
    public final /* synthetic */ long $rejectHandle;
    public final /* synthetic */ long $resolveHandle;
    public final /* synthetic */ QuickJs.EvaluationSession $session;
    public long J$0;
    public Object L$0;
    public Mutex L$1;
    public QuickJs L$2;
    public QuickJs.EvaluationSession L$3;
    public byte label;
    public final /* synthetic */ QuickJs this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickJs$invokeAsyncFunction$job$1(Function2 function2, Object[] objArr, QuickJs quickJs, QuickJs.EvaluationSession evaluationSession, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$args = objArr;
        this.this$0 = quickJs;
        this.$session = evaluationSession;
        this.$resolveHandle = j;
        this.$rejectHandle = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickJs$invokeAsyncFunction$job$1(this.$block, this.$args, this.this$0, this.$session, this.$resolveHandle, this.$rejectHandle, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((QuickJs$invokeAsyncFunction$job$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009b A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #2 {all -> 0x00b6, blocks: (B:29:0x0095, B:31:0x009b, B:34:0x00b2, B:38:0x00b9, B:39:0x00bc, B:33:0x00a3), top: B:64:0x0095, outer: #0, inners: #4 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Throwable th;
        QuickJs quickJs;
        long j;
        Object objInvoke;
        Mutex mutex2;
        QuickJs quickJs2;
        long j2;
        Object obj2;
        QuickJs.EvaluationSession evaluationSession;
        Mutex mutex3;
        QuickJs.EvaluationSession evaluationSession2;
        byte b = this.label;
        QuickJs.EvaluationSession evaluationSession3 = this.$session;
        QuickJs quickJs3 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = this.$block;
                Object[] objArr = this.$args;
                IntRange intRangeUntil = UuidKt.until(2, objArr.length);
                intRangeUntil.getClass();
                Object[] objArrCopyOfRange = intRangeUntil.isEmpty() ? ArraysKt.copyOfRange(objArr, 0, 0) : ArraysKt.copyOfRange(objArr, intRangeUntil.first, intRangeUntil.last + 1);
                this.label = (byte) 1;
                objInvoke = function2.invoke(objArrCopyOfRange, this);
                if (objInvoke == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            try {
                if (b == 1) {
                    ResultKt.throwOnFailure(obj);
                    objInvoke = obj;
                } else {
                    if (b != 2) {
                        if (b != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        long j3 = this.J$0;
                        QuickJs.EvaluationSession evaluationSession4 = this.L$3;
                        QuickJs quickJs4 = this.L$2;
                        mutex = this.L$1;
                        th = (Throwable) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        j = j3;
                        quickJs = quickJs4;
                        evaluationSession3 = evaluationSession4;
                        try {
                            if (!quickJs.isClosed()) {
                                QuickJs.EvaluationSession evaluationSession5 = quickJs.currentEvaluationSession;
                                quickJs.currentEvaluationSession = evaluationSession3;
                                try {
                                    quickJs.invokeJsFunction(quickJs.context, quickJs.globals, j, new Object[]{th});
                                    quickJs.currentEvaluationSession = evaluationSession5;
                                } catch (Throwable th2) {
                                    quickJs.currentEvaluationSession = evaluationSession5;
                                    throw th2;
                                }
                            }
                            mutex.unlock(null);
                            quickJs3.signalRuntimeProgress();
                            return Unit.INSTANCE;
                        } catch (Throwable th3) {
                            mutex.unlock(null);
                            throw th3;
                        }
                    }
                    long j4 = this.J$0;
                    evaluationSession = this.L$3;
                    quickJs2 = this.L$2;
                    mutex2 = this.L$1;
                    obj2 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    j2 = j4;
                }
                if (!quickJs2.isClosed()) {
                    evaluationSession2 = quickJs2.currentEvaluationSession;
                    quickJs2.currentEvaluationSession = evaluationSession;
                    try {
                        quickJs2.invokeJsFunction(quickJs2.context, quickJs2.globals, j2, new Object[]{obj2});
                        quickJs2.currentEvaluationSession = evaluationSession2;
                    } catch (Throwable th4) {
                        quickJs2.currentEvaluationSession = evaluationSession2;
                        throw th4;
                    }
                }
                mutex3.unlock(null);
                quickJs3.signalRuntimeProgress();
                return Unit.INSTANCE;
            } catch (Throwable th5) {
                mutex3.unlock(null);
                throw th5;
            }
            mutex3 = mutex2;
            mutex2 = quickJs3.jsMutex;
            long j5 = this.$resolveHandle;
            this.L$0 = objInvoke;
            this.L$1 = mutex2;
            this.L$2 = quickJs3;
            this.L$3 = evaluationSession3;
            this.J$0 = j5;
            this.label = (byte) 2;
            if (mutex2.lock(this) != coroutineSingletons) {
                quickJs2 = quickJs3;
                j2 = j5;
                obj2 = objInvoke;
                evaluationSession = evaluationSession3;
                mutex3 = mutex2;
                if (!quickJs2.isClosed()) {
                    evaluationSession2 = quickJs2.currentEvaluationSession;
                    quickJs2.currentEvaluationSession = evaluationSession;
                    quickJs2.invokeJsFunction(quickJs2.context, quickJs2.globals, j2, new Object[]{obj2});
                    quickJs2.currentEvaluationSession = evaluationSession2;
                }
                mutex3.unlock(null);
                quickJs3.signalRuntimeProgress();
                return Unit.INSTANCE;
            }
        } catch (Throwable th6) {
            mutex = quickJs3.jsMutex;
            this.L$0 = th6;
            this.L$1 = mutex;
            this.L$2 = quickJs3;
            this.L$3 = evaluationSession3;
            long j6 = this.$rejectHandle;
            this.J$0 = j6;
            this.label = (byte) 3;
            if (mutex.lock(this) != coroutineSingletons) {
                th = th6;
                quickJs = quickJs3;
                j = j6;
            }
            return coroutineSingletons;
        }
        return coroutineSingletons;
    }
}
