package com.metrolist.innertubex.cipher;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService$createSolver$nSolver$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $hasNFunction;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ QuickJsEngine $solverEngine;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubeCipherService$createSolver$nSolver$1(boolean z, QuickJsEngine quickJsEngine, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$hasNFunction = z;
        this.$solverEngine = quickJsEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$1 = new YouTubeCipherService$createSolver$nSolver$1(this.$hasNFunction, this.$solverEngine, continuation, (byte) 0);
                youTubeCipherService$createSolver$nSolver$1.L$0 = obj;
                return youTubeCipherService$createSolver$nSolver$1;
            default:
                YouTubeCipherService$createSolver$nSolver$1 youTubeCipherService$createSolver$nSolver$2 = new YouTubeCipherService$createSolver$nSolver$1(this.$hasNFunction, this.$solverEngine, continuation, (byte) 1);
                youTubeCipherService$createSolver$nSolver$2.L$0 = obj;
                return youTubeCipherService$createSolver$nSolver$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = (String) obj;
        Continuation continuation = (Continuation) obj2;
        switch (b) {
            case 0:
                break;
        }
        return ((YouTubeCipherService$createSolver$nSolver$1) create(str, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        QuickJsEngine quickJsEngine = this.$solverEngine;
        boolean z = this.$hasNFunction;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                String str = (String) this.L$0;
                boolean z2 = this.label;
                try {
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return (String) obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        this.L$0 = null;
                        this.label = true;
                        obj = quickJsEngine.callFunction("_solveN", str, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        return (String) obj;
                    }
                    return null;
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused) {
                }
                break;
            default:
                String str2 = (String) this.L$0;
                boolean z3 = this.label;
                try {
                    if (z3) {
                        if (z3) {
                            ResultKt.throwOnFailure(obj);
                            return (String) obj;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        this.L$0 = null;
                        this.label = true;
                        obj = quickJsEngine.callFunction("_solveSig", str2, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        return (String) obj;
                    }
                    return null;
                } catch (CancellationException e2) {
                    throw e2;
                } catch (Exception unused2) {
                }
                break;
        }
    }
}
