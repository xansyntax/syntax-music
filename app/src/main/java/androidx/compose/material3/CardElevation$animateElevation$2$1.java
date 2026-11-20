package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.ui.unit.Dp;
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
public final class CardElevation$animateElevation$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $animatable;
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Interaction $interaction;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float $target;
    public byte label;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardElevation$animateElevation$2$1(Animatable animatable, float f, boolean z, Object obj, Interaction interaction, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.this$0 = obj;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj2 = this.this$0;
        switch (b) {
            case 0:
                return new CardElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, (CardElevation) obj2, this.$interaction, continuation, (byte) 0);
            case 1:
                return new CardElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, (ButtonElevation) obj2, this.$interaction, continuation, (byte) 1);
            default:
                return new CardElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, (ToggleButtonElevation) obj2, this.$interaction, continuation, (byte) 2);
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
        return ((CardElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Interaction interaction = this.$interaction;
        boolean z = this.$enabled;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Animatable animatable = this.$animatable;
        float f = this.$target;
        Interaction dragInteraction$Start = null;
        switch (b) {
            case 0:
                CardElevation cardElevation = (CardElevation) this.this$0;
                byte b2 = this.label;
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                    return unit;
                }
                if (z) {
                    float f2 = ((Dp) animatable.targetValue$delegate.getValue()).value;
                    if (Dp.m796equalsimpl0(f2, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new PressInteraction.Press(0L);
                    } else if (Dp.m796equalsimpl0(f2, cardElevation.hoveredElevation)) {
                        dragInteraction$Start = new HoverInteraction$Enter();
                    } else if (Dp.m796equalsimpl0(f2, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new FocusInteraction.Focus();
                    } else if (Dp.m796equalsimpl0(f2, cardElevation.draggedElevation)) {
                        dragInteraction$Start = new DragInteraction$Start();
                    }
                    this.label = (byte) 2;
                    if (ElevationKt.m367animateElevationrAjV9yQ(animatable, f, dragInteraction$Start, interaction, this) != coroutineSingletons) {
                        return unit;
                    }
                } else {
                    Dp dp = new Dp(f);
                    this.label = (byte) 1;
                    if (animatable.snapTo(dp, this) != coroutineSingletons) {
                        return unit;
                    }
                }
                return coroutineSingletons;
            case 1:
                byte b3 = this.label;
                if (b3 != 0) {
                    if (b3 == 1 || b3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                    return unit;
                }
                if (z) {
                    float f3 = ((Dp) animatable.targetValue$delegate.getValue()).value;
                    if (Dp.m796equalsimpl0(f3, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new PressInteraction.Press(0L);
                    } else if (Dp.m796equalsimpl0(f3, 1.0f)) {
                        dragInteraction$Start = new HoverInteraction$Enter();
                    } else if (Dp.m796equalsimpl0(f3, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new FocusInteraction.Focus();
                    }
                    this.label = (byte) 2;
                    if (ElevationKt.m367animateElevationrAjV9yQ(animatable, f, dragInteraction$Start, interaction, this) != coroutineSingletons) {
                        return unit;
                    }
                } else {
                    Dp dp2 = new Dp(f);
                    this.label = (byte) 1;
                    if (animatable.snapTo(dp2, this) != coroutineSingletons) {
                        return unit;
                    }
                }
                return coroutineSingletons;
            default:
                byte b4 = this.label;
                if (b4 != 0) {
                    if (b4 == 1 || b4 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (Dp.m796equalsimpl0(((Dp) animatable.targetValue$delegate.getValue()).value, f)) {
                    return unit;
                }
                if (z) {
                    float f4 = ((Dp) animatable.targetValue$delegate.getValue()).value;
                    if (Dp.m796equalsimpl0(f4, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new PressInteraction.Press(0L);
                    } else if (Dp.m796equalsimpl0(f4, 1.0f)) {
                        dragInteraction$Start = new HoverInteraction$Enter();
                    } else if (Dp.m796equalsimpl0(f4, CropImageView.DEFAULT_ASPECT_RATIO)) {
                        dragInteraction$Start = new FocusInteraction.Focus();
                    }
                    this.label = (byte) 2;
                    if (ElevationKt.m367animateElevationrAjV9yQ(animatable, f, dragInteraction$Start, interaction, this) != coroutineSingletons) {
                        return unit;
                    }
                } else {
                    Dp dp3 = new Dp(f);
                    this.label = (byte) 1;
                    if (animatable.snapTo(dp3, this) != coroutineSingletons) {
                        return unit;
                    }
                }
                return coroutineSingletons;
        }
    }
}
