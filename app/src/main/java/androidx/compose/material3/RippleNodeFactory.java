package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RippleNodeFactory implements IndicationNodeFactory {
    public final boolean bounded;
    public final long color;
    public final boolean enableFocusIndication;
    public final Shape focusRingShape;
    public final float radius;

    public RippleNodeFactory(boolean z, float f, long j, Shape shape, boolean z2) {
        if (shape == null) {
            Dp dp = Dp.m796equalsimpl0(f, Float.NaN) ? null : new Dp(f);
            shape = dp != null ? RoundedCornerShapeKt.m185RoundedCornerShape0680j_4(dp.value) : null;
            if (shape == null) {
                shape = ColorKt.RectangleShape;
            }
        }
        this.bounded = z;
        this.radius = f;
        this.color = j;
        this.focusRingShape = shape;
        this.enableFocusIndication = z2;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final DelegatableNode create(InteractionSource interactionSource) {
        return new DelegatingThemeAwareRippleNode(interactionSource, this.bounded, this.radius, new RippleNodeFactory$create$colorProducer$1((byte) 0, this), this.focusRingShape, this.enableFocusIndication);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeFactory)) {
            return false;
        }
        RippleNodeFactory rippleNodeFactory = (RippleNodeFactory) obj;
        return this.bounded == rippleNodeFactory.bounded && Dp.m796equalsimpl0(this.radius, rippleNodeFactory.radius) && ULong.m1869equalsimpl0(this.color, rippleNodeFactory.color) && this.focusRingShape.equals(rippleNodeFactory.focusRingShape) && this.enableFocusIndication == rippleNodeFactory.enableFocusIndication;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public final int hashCode() {
        return Boolean.hashCode(true) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.focusRingShape.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.radius, Boolean.hashCode(this.bounded) * 31, 961), 31, this.color)) * 31, true, 31), this.enableFocusIndication, 31), true, 31);
    }
}
