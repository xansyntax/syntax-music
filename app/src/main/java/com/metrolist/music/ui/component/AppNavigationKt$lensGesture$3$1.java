package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppNavigationKt$lensGesture$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ LensController $c;
    public final /* synthetic */ float $itemW;
    public final /* synthetic */ float $shown;
    public final /* synthetic */ float $v;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppNavigationKt$lensGesture$3$1(LensController lensController, float f, float f2, float f3, Continuation continuation) {
        super(2, continuation);
        this.$c = lensController;
        this.$shown = f;
        this.$v = f2;
        this.$itemW = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppNavigationKt$lensGesture$3$1(this.$c, this.$shown, this.$v, this.$itemW, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((AppNavigationKt$lensGesture$3$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        if (r7.snapTo(r1, r6) == r4) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.label;
        LensController lensController = this.$c;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable animatable = lensController.pos;
            Float f = new Float(this.$shown);
            this.label = (byte) 1;
            if (animatable.snapTo(f, this) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (b == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (b != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        Animatable animatable2 = lensController.stretch;
        Float f2 = new Float(UuidKt.coerceIn(Math.abs(this.$v) / (this.$itemW * 9.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1.0f));
        this.label = (byte) 2;
    }
}
