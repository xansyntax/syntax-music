package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CardElevation {
    public final float defaultElevation;
    public final float draggedElevation;
    public final float hoveredElevation;

    public CardElevation(float f, float f2, float f3) {
        this.defaultElevation = f;
        this.hoveredElevation = f2;
        this.draggedElevation = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CardElevation)) {
            return false;
        }
        CardElevation cardElevation = (CardElevation) obj;
        return Dp.m796equalsimpl0(this.defaultElevation, cardElevation.defaultElevation) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(this.hoveredElevation, cardElevation.hoveredElevation) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final int hashCode() {
        return Float.hashCode(CropImageView.DEFAULT_ASPECT_RATIO) + IntIntPair$$ExternalSyntheticOutline0.m(this.hoveredElevation, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, Float.hashCode(this.defaultElevation) * 31, 31), 31), 31);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0080  */
    public final State shadowElevation$material3(boolean z, MutableInteractionSourceImpl mutableInteractionSourceImpl, Composer composer, int i) {
        Animatable animatable;
        State state;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(-1763481333);
        float f = this.defaultElevation;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (mutableInteractionSourceImpl == null) {
            gapComposer.startReplaceGroup(167726411);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(new Dp(f));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            state = (MutableState) objRememberedValue;
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(167799447);
            gapComposer.end(false);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Fragment$5$$ExternalSyntheticOutline0.m(gapComposer);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue2;
            boolean z2 = true;
            boolean z3 = (((i & 112) ^ 48) > 32 && gapComposer.changed(mutableInteractionSourceImpl)) || (i & 48) == 32;
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new CardElevation$animateElevation$1$1(mutableInteractionSourceImpl, snapshotStateList, null, (byte) 0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
            Interaction interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
            if (!z || (interaction instanceof PressInteraction.Press)) {
                f = 0.0f;
            } else if (interaction instanceof HoverInteraction$Enter) {
                f = this.hoveredElevation;
            } else if (interaction instanceof FocusInteraction.Focus) {
                f = 0.0f;
            } else if (interaction instanceof DragInteraction$Start) {
                f = this.draggedElevation;
            }
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new Animatable(new Dp(f), ArcSplineKt.DpToVector, (Object) null, 12);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Animatable animatable2 = (Animatable) objRememberedValue4;
            Dp dp = new Dp(f);
            boolean zChangedInstance = gapComposer.changedInstance(animatable2) | gapComposer.changed(f) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(z)) || (i & 6) == 4);
            if ((((i & 896) ^ 384) <= 256 || !gapComposer.changed(this)) && (i & 384) != 256) {
                z2 = false;
            }
            boolean zChangedInstance2 = zChangedInstance | z2 | gapComposer.changedInstance(interaction);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                animatable = animatable2;
                CardElevation$animateElevation$2$1 cardElevation$animateElevation$2$1 = new CardElevation$animateElevation$2$1(animatable, f, z, this, interaction, null, (byte) 0);
                gapComposer.updateRememberedValue(cardElevation$animateElevation$2$1);
                objRememberedValue5 = cardElevation$animateElevation$2$1;
            } else {
                animatable = animatable2;
            }
            Stack.LaunchedEffect(gapComposer, dp, (Function2) objRememberedValue5);
            state = animatable.internalState;
        }
        gapComposer.end(false);
        return state;
    }
}
