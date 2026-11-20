package com.metrolist.innertubex.cipher;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EjsChallengeSolver$dispose$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public Mutex L$0;
    public EjsChallengeSolver L$1;
    public byte label;
    public final /* synthetic */ EjsChallengeSolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EjsChallengeSolver$dispose$2(EjsChallengeSolver ejsChallengeSolver, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = ejsChallengeSolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        EjsChallengeSolver ejsChallengeSolver = this.this$0;
        switch (b) {
            case 0:
                return new EjsChallengeSolver$dispose$2(ejsChallengeSolver, continuation, (byte) 0);
            default:
                return new EjsChallengeSolver$dispose$2(ejsChallengeSolver, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((EjsChallengeSolver$dispose$2) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        Mutex mutex3;
        Throwable th2;
        Mutex mutex4;
        EjsChallengeSolver ejsChallengeSolver;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        EjsChallengeSolver ejsChallengeSolver2 = this.this$0;
        switch (b) {
            case 0:
                byte b2 = this.label;
                try {
                    if (b2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = ejsChallengeSolver2.operationMutex;
                        this.L$0 = mutex;
                        this.L$1 = ejsChallengeSolver2;
                        this.label = (byte) 1;
                        if (mutex.lock(this) != coroutineSingletons) {
                        }
                        return coroutineSingletons;
                    }
                    if (b2 != 1) {
                        if (b2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        mutex2 = this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            mutex2.unlock(null);
                            return unit;
                        } catch (Throwable th3) {
                            th = th3;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    ejsChallengeSolver2 = this.L$1;
                    Mutex mutex5 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex5;
                    StandaloneCoroutine standaloneCoroutine = ejsChallengeSolver2.idleJob;
                    if (standaloneCoroutine != null) {
                        standaloneCoroutine.cancel(null);
                    }
                    ejsChallengeSolver2.idleJob = null;
                    ejsChallengeSolver2.solvedChallenges.clear();
                    this.L$0 = mutex;
                    this.L$1 = null;
                    this.label = (byte) 2;
                    if (ejsChallengeSolver2.releaseRuntime(this) != coroutineSingletons) {
                        mutex2 = mutex;
                        mutex2.unlock(null);
                        return unit;
                    }
                    return coroutineSingletons;
                } catch (Throwable th4) {
                    Mutex mutex6 = mutex;
                    th = th4;
                    mutex2 = mutex6;
                    mutex2.unlock(null);
                    throw th;
                }
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = (byte) 1;
                    if (AwaitKt.delay(20000L, this) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b3 != 1) {
                    if (b3 != 2) {
                        if (b3 != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ejsChallengeSolver = this.L$1;
                        mutex4 = this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ejsChallengeSolver.idleJob = null;
                            mutex4.unlock(null);
                            return unit;
                        } catch (Throwable th5) {
                            th2 = th5;
                            mutex4.unlock(null);
                            throw th2;
                        }
                    }
                    ejsChallengeSolver2 = this.L$1;
                    Mutex mutex7 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex3 = mutex7;
                    try {
                        AwaitKt.ensureActive(getContext());
                        this.L$0 = mutex3;
                        this.L$1 = ejsChallengeSolver2;
                        this.label = (byte) 3;
                        JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                        if (ejsChallengeSolver2.releaseRuntime(this) != coroutineSingletons) {
                            mutex4 = mutex3;
                            ejsChallengeSolver = ejsChallengeSolver2;
                            ejsChallengeSolver.idleJob = null;
                            mutex4.unlock(null);
                            return unit;
                        }
                        return coroutineSingletons;
                    } catch (Throwable th6) {
                        Mutex mutex8 = mutex3;
                        th2 = th6;
                        mutex4 = mutex8;
                        mutex4.unlock(null);
                        throw th2;
                    }
                }
                ResultKt.throwOnFailure(obj);
                mutex3 = ejsChallengeSolver2.operationMutex;
                this.L$0 = mutex3;
                this.L$1 = ejsChallengeSolver2;
                this.label = (byte) 2;
                if (mutex3.lock(this) != coroutineSingletons) {
                    AwaitKt.ensureActive(getContext());
                    this.L$0 = mutex3;
                    this.L$1 = ejsChallengeSolver2;
                    this.label = (byte) 3;
                    JsonImpl jsonImpl2 = EjsChallengeSolver.payloadJson;
                    if (ejsChallengeSolver2.releaseRuntime(this) != coroutineSingletons) {
                        mutex4 = mutex3;
                        ejsChallengeSolver = ejsChallengeSolver2;
                        ejsChallengeSolver.idleJob = null;
                        mutex4.unlock(null);
                        return unit;
                    }
                }
                return coroutineSingletons;
        }
    }
}
