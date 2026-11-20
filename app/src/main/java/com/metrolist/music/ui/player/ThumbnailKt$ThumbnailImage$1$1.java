package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TweenSpec;
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
public final class ThumbnailKt$ThumbnailImage$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Animatable $settle;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThumbnailKt$ThumbnailImage$1$1(Animatable animatable, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$settle = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 0);
            case 1:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 1);
            case 2:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 2);
            case 3:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 3);
            case 4:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 4);
            default:
                return new ThumbnailKt$ThumbnailImage$1$1(this.$settle, continuation, (byte) 5);
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
        }
        return ((ThumbnailKt$ThumbnailImage$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
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
                Float f = new Float(1.0f);
                TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(220, 0, null, 6);
                this.label = true;
                return Animatable.animateTo$default(this.$settle, f, tweenSpecTween$default, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            case 1:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    Float f2 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.label = true;
                    return Animatable.animateTo$default(this.$settle, f2, null, null, null, this, 14) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
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
                Float f3 = new Float(1.0f);
                TweenSpec tweenSpecTween$default2 = ArcSplineKt.tween$default(520, 0, EasingKt.FastOutSlowInEasing, 2);
                this.label = true;
                return Animatable.animateTo$default(this.$settle, f3, tweenSpecTween$default2, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
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
                Float f4 = new Float(1.0f);
                TweenSpec tweenSpec = new TweenSpec(420, 330, EasingKt.FastOutSlowInEasing);
                this.label = true;
                return Animatable.animateTo$default(this.$settle, f4, tweenSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
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
                Float f5 = new Float(1.0f);
                TweenSpec tweenSpecTween$default3 = ArcSplineKt.tween$default(360, 420, null, 4);
                this.label = true;
                return Animatable.animateTo$default(this.$settle, f5, tweenSpecTween$default3, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            default:
                boolean z6 = this.label;
                if (z6) {
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Float f6 = new Float(1.0f);
                SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.55f, 500.0f, null, 4);
                this.label = true;
                return Animatable.animateTo$default(this.$settle, f6, springSpecSpring$default, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
        }
    }
}
