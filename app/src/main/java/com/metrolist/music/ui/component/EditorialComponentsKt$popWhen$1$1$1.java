package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
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
public final class EditorialComponentsKt$popWhen$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $active;
    public final /* synthetic */ Object $first;
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Animatable $scale;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorialComponentsKt$popWhen$1$1$1(boolean z, Animatable animatable, Animatable animatable2, Continuation continuation) {
        super(2, continuation);
        this.$active = z;
        this.$scale = animatable;
        this.$first = animatable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new EditorialComponentsKt$popWhen$1$1$1((boolean[]) this.$first, this.$active, this.$scale, continuation);
            default:
                return new EditorialComponentsKt$popWhen$1$1$1(this.$active, this.$scale, (Animatable) this.$first, continuation);
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
        return ((EditorialComponentsKt$popWhen$1$1$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
    
        if (r0 == r8) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
    
        if (r0 == r8) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        float f;
        int i2;
        Object objAnimateTo$default;
        Object objAnimateTo$default2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.$active;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Object obj2 = this.$first;
        switch (b) {
            case 0:
                byte b2 = this.label;
                if (b2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean[] zArr = (boolean[]) obj2;
                    if (zArr[0]) {
                        zArr[0] = false;
                        return unit;
                    }
                    if (!z) {
                        return unit;
                    }
                    Float f2 = new Float(1.3f);
                    TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(90, 0, null, 6);
                    this.label = (byte) 1;
                    if (Animatable.animateTo$default(this.$scale, f2, tweenSpecTween$default, null, null, this, 12) != coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (b2 != 1) {
                    if (b2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                Float f3 = new Float(1.0f);
                SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(0.35f, 500.0f, null, 4);
                this.label = (byte) 2;
                if (Animatable.animateTo$default(this.$scale, f3, springSpecSpring$default, null, null, this, 12) != coroutineSingletons) {
                    return unit;
                }
                return coroutineSingletons;
            default:
                byte b3 = this.label;
                if (b3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z) {
                        Float f4 = new Float(1.0f);
                        TweenSpec tweenSpecTween$default2 = ArcSplineKt.tween$default(200, 0, null, 6);
                        this.label = (byte) 1;
                        i2 = 200;
                        if (Animatable.animateTo$default(this.$scale, f4, tweenSpecTween$default2, null, null, this, 12) != coroutineSingletons) {
                            Float f5 = new Float(1.0f);
                            TweenSpec tweenSpecTween$default3 = ArcSplineKt.tween$default(i2, 0, null, 6);
                            this.label = (byte) 2;
                            objAnimateTo$default = Animatable.animateTo$default((Animatable) obj2, f5, tweenSpecTween$default3, null, null, this, 12);
                        }
                        break;
                    } else {
                        i = 200;
                        Float f6 = new Float(CropImageView.DEFAULT_ASPECT_RATIO);
                        TweenSpec tweenSpecTween$default4 = ArcSplineKt.tween$default(200, 0, null, 6);
                        this.label = (byte) 3;
                        f = 0.0f;
                        if (Animatable.animateTo$default((Animatable) obj2, f6, tweenSpecTween$default4, null, null, this, 12) != coroutineSingletons) {
                            Float f7 = new Float(f);
                            TweenSpec tweenSpecTween$default5 = ArcSplineKt.tween$default(i, 0, null, 6);
                            this.label = (byte) 4;
                            objAnimateTo$default2 = Animatable.animateTo$default(this.$scale, f7, tweenSpecTween$default5, null, null, this, 12);
                        }
                        break;
                    }
                    return coroutineSingletons;
                }
                if (b3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 200;
                    Float f8 = new Float(1.0f);
                    TweenSpec tweenSpecTween$default6 = ArcSplineKt.tween$default(i2, 0, null, 6);
                    this.label = (byte) 2;
                    objAnimateTo$default = Animatable.animateTo$default((Animatable) obj2, f8, tweenSpecTween$default6, null, null, this, 12);
                    break;
                } else {
                    if (b3 != 2) {
                        if (b3 == 3) {
                            ResultKt.throwOnFailure(obj);
                            i = 200;
                            f = CropImageView.DEFAULT_ASPECT_RATIO;
                            Float f9 = new Float(f);
                            TweenSpec tweenSpecTween$default7 = ArcSplineKt.tween$default(i, 0, null, 6);
                            this.label = (byte) 4;
                            objAnimateTo$default2 = Animatable.animateTo$default(this.$scale, f9, tweenSpecTween$default7, null, null, this, 12);
                            break;
                        } else {
                            if (b3 != 4) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                            objAnimateTo$default2 = obj;
                        }
                        return unit;
                    }
                    ResultKt.throwOnFailure(obj);
                    objAnimateTo$default = obj;
                }
                return unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorialComponentsKt$popWhen$1$1$1(boolean[] zArr, boolean z, Animatable animatable, Continuation continuation) {
        super(2, continuation);
        this.$first = zArr;
        this.$active = z;
        this.$scale = animatable;
    }
}
