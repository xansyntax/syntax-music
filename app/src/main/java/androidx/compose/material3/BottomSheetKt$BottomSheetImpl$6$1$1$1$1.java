package androidx.compose.material3;

import androidx.compose.runtime.DerivedSnapshotState;
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
public final class BottomSheetKt$BottomSheetImpl$6$1$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SheetState $state;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetKt$BottomSheetImpl$6$1$1$1$1(SheetState sheetState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$state = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        SheetState sheetState = this.$state;
        switch (b) {
            case 0:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 0);
            case 1:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 1);
            case 2:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 2);
            case 3:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 3);
            case 4:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 4);
            case 5:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 5);
            case 6:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 6);
            case 7:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 7);
            case 8:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 8);
            case 9:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 9);
            default:
                return new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, continuation, (byte) 10);
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
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
        return ((BottomSheetKt$BottomSheetImpl$6$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objAnimateTo$material3;
        Object objAnimateTo$material4;
        byte b = this.$r8$classId;
        SheetValue sheetValue = SheetValue.Expanded;
        Unit unit = Unit.INSTANCE;
        SheetState sheetState = this.$state;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.label = true;
                if (!((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue() || (objAnimateTo$material3 = sheetState.animateTo$material3(sheetValue, sheetState.showMotionSpec, this)) != coroutineSingletons) {
                    objAnimateTo$material3 = unit;
                }
                return objAnimateTo$material3 == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.partialExpand(this) == coroutineSingletons ? coroutineSingletons : unit;
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
                    this.label = true;
                    return sheetState.hide(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.show(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 4:
                boolean z5 = this.label;
                if (z5) {
                    if (z5) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.label = true;
                if (!((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue() || (objAnimateTo$material4 = sheetState.animateTo$material3(sheetValue, sheetState.showMotionSpec, this)) != coroutineSingletons) {
                    objAnimateTo$material4 = unit;
                }
                return objAnimateTo$material4 == coroutineSingletons ? coroutineSingletons : unit;
            case 5:
                boolean z6 = this.label;
                if (!z6) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.partialExpand(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z6) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 6:
                boolean z7 = this.label;
                if (!z7) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.hide(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z7) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 7:
                boolean z8 = this.label;
                if (z8) {
                    if (z8) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((SheetValue) ((DerivedSnapshotState) sheetState.anchoredDraggableState.tail).getValue()) != SheetValue.Hidden) {
                    return unit;
                }
                this.label = true;
                return sheetState.show(this) == coroutineSingletons ? coroutineSingletons : unit;
            case 8:
                boolean z9 = this.label;
                if (!z9) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.hide(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z9) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 9:
                boolean z10 = this.label;
                if (!z10) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.partialExpand(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z10) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z11 = this.label;
                if (!z11) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return sheetState.hide(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z11) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
