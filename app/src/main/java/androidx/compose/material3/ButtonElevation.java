package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ButtonElevation {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && (obj instanceof ButtonElevation) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(1.0f, 1.0f) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final int hashCode() {
        return Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) + IntIntPair$$ExternalSyntheticOutline0.m(1.0f, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) * 31, 31), 31), 31);
    }

    public final AnimationState shadowElevation$material3(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Composer composer, int i) {
        Animatable animatable;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
        }
        SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
        boolean z2 = true;
        boolean z3 = (((i & 112) ^ 48) > 32 && gapComposer.changed(mutableInteractionSourceImpl)) || (i & 48) == 32;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z3 || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new CardElevation$animateElevation$1$1(mutableInteractionSourceImpl, snapshotStateList, null, (byte) 1);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue2);
        Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
        float f = CropImageView.DEFAULT_ASPECT_RATIO;
        if (z && !(interaction instanceof PressInteraction.Press) && (interaction instanceof HoverInteraction$Enter)) {
            f = 1.0f;
        }
        float f2 = f;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == neverEqualPolicy) {
            objRememberedValue3 = new Animatable(new Dp(f2), ArcSplineKt.DpToVector, (Object) null, 12);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Animatable animatable2 = (Animatable) objRememberedValue3;
        Dp dp = new Dp(f2);
        boolean zChangedInstance = gapComposer.changedInstance(animatable2) | gapComposer.changed(f2) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(z)) || (i & 6) == 4);
        if ((((i & 896) ^ 384) <= 256 || !gapComposer.changed(this)) && (i & 384) != 256) {
            z2 = false;
        }
        boolean zChangedInstance2 = zChangedInstance | z2 | gapComposer.changedInstance(interaction);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
            animatable = animatable2;
            CardElevation$animateElevation$2$1 cardElevation$animateElevation$2$1 = new CardElevation$animateElevation$2$1(animatable, f2, z, this, interaction, null, (byte) 1);
            gapComposer.updateRememberedValue(cardElevation$animateElevation$2$1);
            objRememberedValue4 = cardElevation$animateElevation$2$1;
        } else {
            animatable = animatable2;
        }
        Stack.LaunchedEffect(gapComposer, dp, (Function2) objRememberedValue4);
        return animatable.internalState;
    }
}
