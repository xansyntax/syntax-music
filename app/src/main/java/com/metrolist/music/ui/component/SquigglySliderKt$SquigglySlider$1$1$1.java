package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda1;
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
public final class SquigglySliderKt$SquigglySlider$1$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $heightFraction$delegate;
    public final /* synthetic */ MutableState $isDragging$delegate;
    public final /* synthetic */ boolean $isPlaying;
    public float F$0;
    public int I$0;
    public int I$1;
    public long J$0;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquigglySliderKt$SquigglySlider$1$1$1(boolean z, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, Continuation continuation) {
        super(2, continuation);
        this.$isPlaying = z;
        this.$isDragging$delegate = mutableState;
        this.$heightFraction$delegate = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SquigglySliderKt$SquigglySlider$1$1$1(this.$isPlaying, this.$isDragging$delegate, this.$heightFraction$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SquigglySliderKt$SquigglySlider$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0095, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r10, r11, r1, null, r12, r14, 4) == r7) goto L32;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        long j;
        float f;
        int i2;
        byte b = this.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (b != 0) {
            if (b == 1) {
                j = this.J$0;
                i2 = this.I$1;
                f = this.F$0;
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        i = (!this.$isPlaying || ((Boolean) this.$isDragging$delegate.getValue()).booleanValue()) ? 1 : 0;
        float f2 = i != 0 ? CropImageView.DEFAULT_ASPECT_RATIO : 1.0f;
        int i3 = i != 0 ? 150 : 200;
        j = i != 0 ? 0L : 30L;
        this.I$0 = i;
        this.F$0 = f2;
        this.I$1 = i3;
        this.J$0 = j;
        this.label = (byte) 1;
        if (AwaitKt.delay(j, this) != coroutineSingletons) {
            f = f2;
            i2 = i3;
        }
        return coroutineSingletons;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.$heightFraction$delegate;
        Animatable animatableAnimatable$default = ArcSplineKt.Animatable$default(parcelableSnapshotMutableFloatState.getFloatValue());
        Float f3 = new Float(f);
        TweenSpec tweenSpecTween$default = ArcSplineKt.tween$default(i2, 0, EasingKt.LinearEasing, 2);
        PlayerKt$$ExternalSyntheticLambda1 playerKt$$ExternalSyntheticLambda1 = new PlayerKt$$ExternalSyntheticLambda1(parcelableSnapshotMutableFloatState, (byte) 4);
        this.I$0 = i;
        this.F$0 = f;
        this.I$1 = i2;
        this.J$0 = j;
        this.label = (byte) 2;
    }
}
