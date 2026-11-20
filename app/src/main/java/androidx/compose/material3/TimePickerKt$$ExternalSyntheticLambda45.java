package androidx.compose.material3;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.ClosedFloatRange;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda45 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda45(CoroutineScope coroutineScope, AnalogTimePickerState analogTimePickerState, float f, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = (byte) 0;
        this.f$0 = coroutineScope;
        this.f$1 = analogTimePickerState;
        this.f$2 = f;
        this.f$3 = mutableState;
        this.f$4 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.f$4;
        Object obj3 = this.f$3;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                AwaitKt.launch$default((CoroutineScope) obj5, null, null, new TimePickerKt$ClockText$onClockTextClick$1$1$1((AnalogTimePickerState) obj4, this.f$2, ((Boolean) obj).booleanValue(), (MutableState) obj3, (MutableState) obj2, null), 3);
                break;
            case 1:
                long jLongValue = ((Long) obj).longValue();
                Object obj6 = ((Ref$ObjectRef) obj5).element;
                obj6.getClass();
                ArcSplineKt.doAnimationFrameWithScale((AnimationScope) obj6, jLongValue, this.f$2, (Animation) obj4, (AnimationState) obj3, (Function1) obj2);
                break;
            default:
                Function0 function0 = (Function0) obj2;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (((Offset) obj).packedValue >> 32)) / ((int) (((SuspendingPointerInputModifierNodeImpl) ((PointerInputScope) obj5)).boundsSize >> 32));
                float f = this.f$2;
                ((Function1) obj3).invoke(Float.valueOf(UuidKt.coerceIn(fIntBitsToFloat * f, CropImageView.DEFAULT_ASPECT_RATIO, f) + ((ClosedFloatRange) obj4)._start));
                if (function0 != null) {
                    function0.invoke();
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda45(Object obj, float f, Object obj2, Object obj3, Function function, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = f;
        this.f$1 = obj2;
        this.f$3 = obj3;
        this.f$4 = function;
    }
}
