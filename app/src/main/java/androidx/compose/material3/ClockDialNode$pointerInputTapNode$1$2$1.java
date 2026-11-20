package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import com.yalantis.ucrop.view.CropImageView;
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
public final class ClockDialNode$pointerInputTapNode$1$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Offset $it;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ ClockDialNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClockDialNode$pointerInputTapNode$1$2$1(ClockDialNode clockDialNode, Offset offset, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = clockDialNode;
        this.$it = offset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Offset offset = this.$it;
        ClockDialNode clockDialNode = this.this$0;
        switch (b) {
            case 0:
                return new ClockDialNode$pointerInputTapNode$1$2$1(clockDialNode, offset, continuation, (byte) 0);
            default:
                return new ClockDialNode$pointerInputTapNode$1$2$1(clockDialNode, offset, continuation, (byte) 1);
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
        return ((ClockDialNode$pointerInputTapNode$1$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ClockDialNode clockDialNode = this.this$0;
        Offset offset = this.$it;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    AnalogTimePickerState analogTimePickerState = clockDialNode.state;
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (offset.packedValue >> 32));
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (offset.packedValue & 4294967295L));
                    float maxDist = clockDialNode.getMaxDist();
                    boolean z2 = clockDialNode.autoSwitchToMinute;
                    long j = ((IntOffset) clockDialNode.center$delegate.getValue()).packedValue;
                    AnimationSpec animationSpec = clockDialNode.animationSpec;
                    this.label = true;
                    if (TimePickerKt.m359onTapuYHVD98(analogTimePickerState, fIntBitsToFloat, fIntBitsToFloat2, maxDist, z2, j, animationSpec, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            default:
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = clockDialNode.center$delegate;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    clockDialNode.offsetX = Float.intBitsToFloat((int) (offset.packedValue >> 32)) + clockDialNode.offsetX;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (offset.packedValue & 4294967295L)) + clockDialNode.offsetY;
                    clockDialNode.offsetY = fIntBitsToFloat3;
                    AnalogTimePickerState analogTimePickerState2 = clockDialNode.state;
                    float f = fIntBitsToFloat3 - ((int) (((IntOffset) parcelableSnapshotMutableState.getValue()).packedValue & 4294967295L));
                    float f2 = clockDialNode.offsetX - ((int) (((IntOffset) parcelableSnapshotMutableState.getValue()).packedValue >> 32));
                    MutableIntList mutableIntList = TimePickerKt.Minutes;
                    float fAtan2 = ((float) Math.atan2(f, f2)) - 1.5707964f;
                    if (fAtan2 < CropImageView.DEFAULT_ASPECT_RATIO) {
                        fAtan2 += 6.2831855f;
                    }
                    float f3 = fAtan2;
                    AnimationSpec animationSpec2 = clockDialNode.animationSpec;
                    this.label = true;
                    analogTimePickerState2.userOverride.value = Boolean.FALSE;
                    Object objMutate = analogTimePickerState2.mutex.mutate(MutatePriority.UserInput, new AnalogTimePickerState$rotateTo$2(analogTimePickerState2, f3, false, animationSpec2, null), this);
                    if (objMutate != coroutineSingletons) {
                        objMutate = unit;
                    }
                    if (objMutate == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                TimePickerKt.m357moveSelectord3b8Pxo(clockDialNode.state, clockDialNode.offsetX, clockDialNode.offsetY, clockDialNode.getMaxDist(), ((IntOffset) parcelableSnapshotMutableState.getValue()).packedValue);
                return unit;
        }
    }
}
