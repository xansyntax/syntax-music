package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
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
public final class TimePickerKt$ClockText$onClockTextClick$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $autoSwitch;
    public final /* synthetic */ MutableState $center$delegate;
    public final /* synthetic */ float $maxDist;
    public final /* synthetic */ MutableState $parentCenter$delegate;
    public final /* synthetic */ AnalogTimePickerState $state;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$ClockText$onClockTextClick$1$1$1(AnalogTimePickerState analogTimePickerState, float f, boolean z, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.$state = analogTimePickerState;
        this.$maxDist = f;
        this.$autoSwitch = z;
        this.$center$delegate = mutableState;
        this.$parentCenter$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TimePickerKt$ClockText$onClockTextClick$1$1$1(this.$state, this.$maxDist, this.$autoSwitch, this.$center$delegate, this.$parentCenter$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TimePickerKt$ClockText$onClockTextClick$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            MutableIntList mutableIntList = TimePickerKt.Minutes;
            MutableState mutableState = this.$center$delegate;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (((Offset) mutableState.getValue()).packedValue >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (((Offset) mutableState.getValue()).packedValue & 4294967295L));
            long j = ((IntOffset) this.$parentCenter$delegate.getValue()).packedValue;
            SnapSpec snapSpec = new SnapSpec(0);
            this.label = true;
            Object objM359onTapuYHVD98 = TimePickerKt.m359onTapuYHVD98(this.$state, fIntBitsToFloat, fIntBitsToFloat2, this.$maxDist, this.$autoSwitch, j, snapSpec, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM359onTapuYHVD98 == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
