package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MarqueeModifierNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MarqueeModifierElement extends ModifierNodeElement {
    public final int initialDelayMillis;
    public final int iterations;
    public final MarqueeSpacing$Companion$$ExternalSyntheticLambda0 spacing;
    public final float velocity;

    public MarqueeModifierElement(int i, int i2, MarqueeSpacing$Companion$$ExternalSyntheticLambda0 marqueeSpacing$Companion$$ExternalSyntheticLambda0, float f) {
        this.iterations = i;
        this.initialDelayMillis = i2;
        this.spacing = marqueeSpacing$Companion$$ExternalSyntheticLambda0;
        this.velocity = f;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new MarqueeModifierNode(this.iterations, this.initialDelayMillis, this.spacing, this.velocity);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MarqueeModifierElement)) {
            return false;
        }
        MarqueeModifierElement marqueeModifierElement = (MarqueeModifierElement) obj;
        return this.iterations == marqueeModifierElement.iterations && this.initialDelayMillis == marqueeModifierElement.initialDelayMillis && Intrinsics.areEqual(this.spacing, marqueeModifierElement.spacing) && Dp.m796equalsimpl0(this.velocity, marqueeModifierElement.velocity);
    }

    public final int hashCode() {
        return Float.hashCode(this.velocity) + ((this.spacing.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.initialDelayMillis, IntIntPair$$ExternalSyntheticOutline0.m(1200, IntIntPair$$ExternalSyntheticOutline0.m(0, Integer.hashCode(this.iterations) * 31, 31), 31), 31)) * 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.velocity);
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.iterations, "MarqueeModifierElement(iterations=", ", animationMode=Immediately, delayMillis=1200, initialDelayMillis=", this.initialDelayMillis, ", spacing=");
        sbM3m.append(this.spacing);
        sbM3m.append(", velocity=");
        sbM3m.append(strM797toStringimpl);
        sbM3m.append(")");
        return sbM3m.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        MarqueeModifierNode marqueeModifierNode = (MarqueeModifierNode) node;
        marqueeModifierNode.spacing$delegate.setValue(this.spacing);
        marqueeModifierNode.animationMode$delegate.setValue(new MarqueeAnimationMode());
        int i = marqueeModifierNode.iterations;
        int i2 = this.iterations;
        int i3 = this.initialDelayMillis;
        float f = this.velocity;
        if (i == i2 && marqueeModifierNode.delayMillis == 1200 && marqueeModifierNode.initialDelayMillis == i3 && Dp.m796equalsimpl0(marqueeModifierNode.velocity, f)) {
            return;
        }
        marqueeModifierNode.iterations = i2;
        marqueeModifierNode.delayMillis = (short) 1200;
        marqueeModifierNode.initialDelayMillis = i3;
        marqueeModifierNode.velocity = f;
        marqueeModifierNode.restartAnimation();
    }
}
