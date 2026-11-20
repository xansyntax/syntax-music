package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.ripple.RippleModifierNode;
import androidx.compose.material3.ripple.RippleNodeConfiguration;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public final boolean bounded;
    public MotionScheme cachedMotionScheme;
    public RippleConfiguration cachedRippleConfiguration;
    public RippleNodeConfiguration cachedRippleNodeConfiguration;
    public RippleThemeConfiguration cachedRippleThemeConfiguration;
    public final DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0 calculateRippleNodeConfiguration;
    public final RippleNodeFactory$create$colorProducer$1 color;
    public final boolean enableFocusIndication;
    public final InteractionSource interactionSource;
    public final float radius;
    public RippleModifierNode rippleNode;
    public final boolean enablePressIndication = true;
    public final boolean enableHoverIndication = true;
    public final boolean enableDragIndication = true;
    public final RippleNodeFactory$create$colorProducer$1 calculateColor = new RippleNodeFactory$create$colorProducer$1((byte) 1, this);

    public DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z, float f, RippleNodeFactory$create$colorProducer$1 rippleNodeFactory$create$colorProducer$1, Shape shape, boolean z2) {
        this.interactionSource = interactionSource;
        this.bounded = z;
        this.radius = f;
        this.color = rippleNodeFactory$create$colorProducer$1;
        this.enableFocusIndication = z2;
        new RippleNodeFactory$create$colorProducer$1((byte) 3, this);
        new RippleNodeFactory$create$colorProducer$1((byte) 2, this);
        this.calculateRippleNodeConfiguration = new DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0(this, (byte) 1);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        HitTestResultKt.observeReads(this, new DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0(this, (byte) 0));
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        HitTestResultKt.observeReads(this, new DelegatingThemeAwareRippleNode$$ExternalSyntheticLambda0(this, (byte) 0));
    }
}
