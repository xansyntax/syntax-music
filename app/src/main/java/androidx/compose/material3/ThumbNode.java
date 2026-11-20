package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.InlineClassHelperKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda48;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    public FiniteAnimationSpec animationSpec;
    public boolean checked;
    public float initialOffset;
    public float initialSize;
    public InteractionSource interactionSource;
    public boolean isPressed;
    public Animatable offsetAnim;
    public Animatable sizeAnim;

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f;
        byte b = 0;
        byte b2 = 1;
        boolean z = (measurable.maxIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)) == 0 || measurable.maxIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)) == 0) ? false : true;
        if (this.isPressed) {
            f = 28.0f;
        } else {
            f = (z || this.checked) ? 24.0f : 16.0f;
        }
        float fMo81toPx0680j_4 = measureScope.mo81toPx0680j_4(f);
        Animatable animatable = this.sizeAnim;
        int iFloatValue = (int) (animatable != null ? ((Number) animatable.getValue()).floatValue() : fMo81toPx0680j_4);
        if (!((iFloatValue >= 0) & (iFloatValue >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
        }
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.createConstraints(iFloatValue, iFloatValue, iFloatValue, iFloatValue));
        float fMo81toPx0680j_5 = measureScope.mo81toPx0680j_4((((32.0f - measureScope.mo77toDpu2uoSUM(fMo81toPx0680j_4)) + CropImageView.DEFAULT_ASPECT_RATIO) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO);
        float fMo81toPx0680j_6 = measureScope.mo81toPx0680j_4(24.0f);
        boolean z2 = this.isPressed;
        if (z2 && this.checked) {
            fMo81toPx0680j_5 = fMo81toPx0680j_6 - measureScope.mo81toPx0680j_4(2.0f);
        } else if (z2 && !this.checked) {
            fMo81toPx0680j_5 = measureScope.mo81toPx0680j_4(2.0f);
        } else if (this.checked) {
            fMo81toPx0680j_5 = fMo81toPx0680j_6;
        }
        Animatable animatable2 = this.sizeAnim;
        Continuation continuation = null;
        Float f2 = animatable2 != null ? (Float) animatable2.targetValue$delegate.getValue() : null;
        if (f2 == null || f2.floatValue() != fMo81toPx0680j_4) {
            AwaitKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, fMo81toPx0680j_4, continuation, b), 3);
        }
        Animatable animatable3 = this.offsetAnim;
        Float f3 = animatable3 != null ? (Float) animatable3.targetValue$delegate.getValue() : null;
        if (f3 == null || f3.floatValue() != fMo81toPx0680j_5) {
            AwaitKt.launch$default(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, fMo81toPx0680j_5, continuation, b2), 3);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = fMo81toPx0680j_4;
            this.initialOffset = fMo81toPx0680j_5;
        }
        return measureScope.layout(iFloatValue, iFloatValue, EmptyMap.INSTANCE, new MainActivity$$ExternalSyntheticLambda48(placeableMo598measureBRTryo0, this, fMo81toPx0680j_5));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        AwaitKt.launch$default(getCoroutineScope(), null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 11), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        this.offsetAnim = null;
        this.sizeAnim = null;
        this.initialSize = Float.NaN;
        this.initialOffset = Float.NaN;
    }
}
