package androidx.compose.runtime;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateKt__ProduceStateKt$produceState$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function2 $producer;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState $result;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SnapshotStateKt__ProduceStateKt$produceState$1$1(Function2 function2, MutableState mutableState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$producer = function2;
        this.$result = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$1 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, (byte) 0);
                snapshotStateKt__ProduceStateKt$produceState$1$1.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$1;
            case 1:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$2 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, (byte) 1);
                snapshotStateKt__ProduceStateKt$produceState$1$2.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$2;
            case 2:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, (byte) 2);
                snapshotStateKt__ProduceStateKt$produceState$1$3.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$3;
            default:
                SnapshotStateKt__ProduceStateKt$produceState$1$1 snapshotStateKt__ProduceStateKt$produceState$1$4 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(this.$producer, this.$result, continuation, (byte) 3);
                snapshotStateKt__ProduceStateKt$produceState$1$4.L$0 = obj;
                return snapshotStateKt__ProduceStateKt$produceState$1$4;
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((SnapshotStateKt__ProduceStateKt$produceState$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.$result;
        Function2 function2 = this.$producer;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl = new ProduceStateScopeImpl(mutableState, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = true;
                    return function2.invoke(produceStateScopeImpl, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl2 = new ProduceStateScopeImpl(mutableState, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = true;
                    return function2.invoke(produceStateScopeImpl2, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 2:
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl3 = new ProduceStateScopeImpl(mutableState, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = true;
                    return function2.invoke(produceStateScopeImpl3, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    ProduceStateScopeImpl produceStateScopeImpl4 = new ProduceStateScopeImpl(mutableState, ((CoroutineScope) this.L$0).getCoroutineContext());
                    this.label = true;
                    return function2.invoke(produceStateScopeImpl4, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
