package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.WavyProgressIndicatorKt;
import androidx.compose.ui.unit.Dp;
import com.metrolist.music.constants.DimensionsKt;
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
public final class MiniPlayerKt$NewMiniPlayer$2$1$1$4$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ float $adjustedDragAmount;
    public final /* synthetic */ Animatable $offsetXAnimatable;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(Animatable animatable, float f, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$offsetXAnimatable = animatable;
        this.$adjustedDragAmount = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        float f = this.$adjustedDragAmount;
        Animatable animatable = this.$offsetXAnimatable;
        switch (b) {
            case 0:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f, continuation, (byte) 0);
            case 1:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f, continuation, (byte) 1);
            case 2:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f, continuation, (byte) 2);
            case 3:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f, continuation, (byte) 3);
            default:
                return new MiniPlayerKt$NewMiniPlayer$2$1$1$4$1(animatable, f, continuation, (byte) 4);
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
        }
        return ((MiniPlayerKt$NewMiniPlayer$2$1$1$4$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Animatable animatable = this.$offsetXAnimatable;
        Unit unit = Unit.INSTANCE;
        float f = this.$adjustedDragAmount;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    Float f2 = new Float(((Number) animatable.getValue()).floatValue() + f);
                    this.label = true;
                    return animatable.snapTo(f2, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                boolean z2 = this.label;
                if (z2) {
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Float f3 = new Float(f);
                Animatable animatable2 = this.$offsetXAnimatable;
                TweenSpec tweenSpec = ((Number) animatable2.getValue()).floatValue() < f ? WavyProgressIndicatorKt.IncreasingAmplitudeAnimationSpec : WavyProgressIndicatorKt.DecreasingAmplitudeAnimationSpec;
                this.label = true;
                return Animatable.animateTo$default(animatable2, f3, tweenSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
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
                Dp dp = new Dp(f);
                SpringSpec springSpec = DimensionsKt.NavigationBarAnimationSpec;
                this.label = true;
                return Animatable.animateTo$default(this.$offsetXAnimatable, dp, springSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            case 3:
                boolean z4 = this.label;
                if (z4) {
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Float f4 = new Float(f);
                SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.6f, 900.0f, null, 4);
                this.label = true;
                return Animatable.animateTo$default(this.$offsetXAnimatable, f4, springSpecSpring$default, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z5 = this.label;
                if (!z5) {
                    ResultKt.throwOnFailure(obj);
                    Float f5 = new Float(((Number) animatable.getValue()).floatValue() + f);
                    this.label = true;
                    return animatable.snapTo(f5, this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z5) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
