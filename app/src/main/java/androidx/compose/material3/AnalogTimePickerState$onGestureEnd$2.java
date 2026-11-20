package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnalogTimePickerState$onGestureEnd$2 extends SuspendLambda implements Function1 {
    public final /* synthetic */ AnimationSpec $animationSpec;
    public final /* synthetic */ float $end;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ AnalogTimePickerState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnalogTimePickerState$onGestureEnd$2(AnalogTimePickerState analogTimePickerState, float f, AnimationSpec animationSpec, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.this$0 = analogTimePickerState;
        this.$end = f;
        this.$animationSpec = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AnalogTimePickerState$onGestureEnd$2(this.this$0, this.$end, this.$animationSpec, continuation, (byte) 0);
            default:
                return new AnalogTimePickerState$onGestureEnd$2(this.this$0, this.$end, this.$animationSpec, continuation, (byte) 1);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
        }
        return ((AnalogTimePickerState$onGestureEnd$2) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        float f = this.$end;
        AnalogTimePickerState analogTimePickerState = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Animatable animatable = analogTimePickerState.anim;
                Float f2 = new Float(f);
                this.label = true;
                Object objAnimateTo$default = Animatable.animateTo$default(animatable, f2, this.$animationSpec, null, null, this, 12);
                return objAnimateTo$default == coroutineSingletons ? coroutineSingletons : objAnimateTo$default;
            default:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Animatable animatable2 = analogTimePickerState.anim;
                Float f3 = new Float(f);
                this.label = true;
                Object objAnimateTo$default2 = Animatable.animateTo$default(animatable2, f3, this.$animationSpec, null, null, this, 12);
                return objAnimateTo$default2 == coroutineSingletons ? coroutineSingletons : objAnimateTo$default2;
        }
    }
}
