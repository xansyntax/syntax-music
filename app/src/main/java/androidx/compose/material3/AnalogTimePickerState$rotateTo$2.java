package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnalogTimePickerState$rotateTo$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ float $angle;
    public final /* synthetic */ boolean $animate;
    public final /* synthetic */ AnimationSpec $animationSpec;
    public byte label;
    public final /* synthetic */ AnalogTimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalogTimePickerState$rotateTo$2(AnalogTimePickerState analogTimePickerState, float f, boolean z, AnimationSpec animationSpec, Continuation continuation) {
        super(1, continuation);
        this.this$0 = analogTimePickerState;
        this.$angle = f;
        this.$animate = z;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AnalogTimePickerState$rotateTo$2(this.this$0, this.$angle, this.$animate, this.$animationSpec, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((AnalogTimePickerState$rotateTo$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        if (r0.snapTo(r1, r15) == r9) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AnalogTimePickerState analogTimePickerState = this.this$0;
        TimePickerState timePickerState = analogTimePickerState.state;
        byte b = this.label;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            int iMo241getSelectionyecRtBI = timePickerState.mo241getSelectionyecRtBI();
            float f = this.$angle;
            if (iMo241getSelectionyecRtBI == 0) {
                float f2 = ((((int) ((((double) f) + 1.8325957218792777d) / 0.5235987901687622d)) % 12) % 12) * 0.5235988f;
                analogTimePickerState.hourAngle = f2;
                timePickerState.setHourInput(((((int) ((((double) f2) + 1.8325957218792777d) / 0.5235987901687622d)) % 12) % 12) + (TimePickerKt.isPm(analogTimePickerState) ? 12 : 0));
            } else {
                float f3 = (((int) ((((double) f) + 1.6231562058117728d) / 0.10471975803375244d)) % 60) * 0.10471976f;
                analogTimePickerState.minuteAngle = f3;
                timePickerState.setMinuteInput(((int) ((((double) f3) + 1.6231562058117728d) / 0.10471975803375244d)) % 60);
            }
            boolean z = this.$animate;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (z) {
                float f4 = f + 1.5707964f;
                if (f4 < CropImageView.DEFAULT_ASPECT_RATIO) {
                    f4 += 6.2831855f;
                }
                float fEndValueForAnimation = analogTimePickerState.endValueForAnimation(f4);
                Animatable animatable = analogTimePickerState.anim;
                Float f5 = new Float(fEndValueForAnimation);
                this.label = (byte) 2;
                Object objAnimateTo$default = Animatable.animateTo$default(animatable, f5, this.$animationSpec, null, null, this, 12);
                if (objAnimateTo$default != coroutineSingletons) {
                    return objAnimateTo$default;
                }
            } else {
                Animatable animatable2 = analogTimePickerState.anim;
                float f6 = f + 1.5707964f;
                if (f6 < CropImageView.DEFAULT_ASPECT_RATIO) {
                    f6 += 6.2831855f;
                }
                Float f7 = new Float(f6);
                this.label = (byte) 1;
            }
            return coroutineSingletons;
        }
        if (b != 1) {
            if (b == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
