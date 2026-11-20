package androidx.compose.animation.core;

import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda13;
import androidx.compose.material3.ripple.AndroidRippleNode;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Transition$animateTo$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId = 2;
    public float F$0;
    public /* synthetic */ Object L$0;
    public boolean label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transition$animateTo$1$1$1(AndroidRippleNode androidRippleNode, float f, AnimationSpec animationSpec, Continuation continuation) {
        super(2, continuation);
        this.L$0 = androidRippleNode;
        this.F$0 = f;
        this.this$0 = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                Transition$animateTo$1$1$1 transition$animateTo$1$1$1 = new Transition$animateTo$1$1$1((Transition) obj2, continuation);
                transition$animateTo$1$1$1.L$0 = obj;
                return transition$animateTo$1$1$1;
            case 1:
                return new Transition$animateTo$1$1$1((AndroidRippleNode) this.L$0, this.F$0, (AnimationSpec) obj2, continuation);
            default:
                return new Transition$animateTo$1$1$1((Animatable) this.L$0, (Density) obj2, this.F$0, continuation);
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
        }
        return ((Transition$animateTo$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        float durationScale;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        byte b2 = 1;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    coroutineScope = coroutineScope2;
                    durationScale = ArcSplineKt.getDurationScale(coroutineScope2.getCoroutineContext());
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    durationScale = this.F$0;
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (AwaitKt.isActive(coroutineScope)) {
                    BottomSheetKt$$ExternalSyntheticLambda13 bottomSheetKt$$ExternalSyntheticLambda13 = new BottomSheetKt$$ExternalSyntheticLambda13((Transition) obj2, durationScale, b2);
                    this.L$0 = coroutineScope;
                    this.F$0 = durationScale;
                    this.label = true;
                    if (Stack.getMonotonicFrameClock(getContext()).withFrameNanos(bottomSheetKt$$ExternalSyntheticLambda13, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    return Animatable.animateTo$default(((AndroidRippleNode) this.L$0).animatedAlpha, new Float(this.F$0), (AnimationSpec) obj2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Animatable animatable = (Animatable) this.L$0;
                Dp dp = new Dp((((Dp) animatable.getValue()).value - ((Density) obj2).mo77toDpu2uoSUM(this.F$0)) + CropImageView.DEFAULT_ASPECT_RATIO);
                this.label = true;
                return animatable.snapTo(dp, this) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transition$animateTo$1$1$1(Transition transition, Continuation continuation) {
        super(2, continuation);
        this.this$0 = transition;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transition$animateTo$1$1$1(Animatable animatable, Density density, float f, Continuation continuation) {
        super(2, continuation);
        this.L$0 = animatable;
        this.this$0 = density;
        this.F$0 = f;
    }
}
