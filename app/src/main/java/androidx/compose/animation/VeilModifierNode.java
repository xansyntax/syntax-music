package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeCoordinator;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Lazy;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VeilModifierNode extends Modifier.Node implements DrawModifierNode {
    public EnterTransitionImpl enter;
    public ExitTransitionImpl exit;
    public SharedMutableTransformState mutableTransformState;
    public Transition.DeferredAnimation veilAnimation;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        long jFloatToRawIntBits;
        layoutNodeDrawScope.drawContent();
        Transition.DeferredAnimation deferredAnimation = this.veilAnimation;
        ScrollState$$ExternalSyntheticLambda0 scrollState$$ExternalSyntheticLambda0 = new ScrollState$$ExternalSyntheticLambda0((byte) 6, this);
        SharedMutableTransformState sharedMutableTransformState = this.mutableTransformState;
        Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate = deferredAnimation.animate(scrollState$$ExternalSyntheticLambda0, sharedMutableTransformState.isHandoffActive() ? new Color(sharedMutableTransformState.lastVeil) : null, null, new CallsKt$await$2$1((byte) 2, this));
        SharedMutableTransformState sharedMutableTransformState2 = this.mutableTransformState;
        long j = ((Color) deferredAnimationDataAnimate.getValue()).value;
        TransformScopeImpl transformScopeImpl = sharedMutableTransformState2.transformScope;
        Lazy lazy = sharedMutableTransformState2.catchUpVeil$delegate;
        sharedMutableTransformState2.activeTransitionVeil = j;
        boolean z = sharedMutableTransformState2.isMutating() && transformScopeImpl.isVeilMutated();
        MutationPhase mutationPhase = MutationPhase.MutatingCatchingUp;
        if (z && sharedMutableTransformState2.getMutationPhase$animation() == mutationPhase && ((Animatable) lazy.getValue()).isRunning()) {
            j = ((Color) ((Animatable) lazy.getValue()).getValue()).value;
        } else if (z && (sharedMutableTransformState2.getMutationPhase$animation() == mutationPhase || sharedMutableTransformState2.getMutationPhase$animation() == MutationPhase.Mutating)) {
            j = ((Color) transformScopeImpl._veil.getValue()).value;
        }
        long j2 = j;
        if (sharedMutableTransformState2.isMutating()) {
            sharedMutableTransformState2.lastVeil = j2;
        }
        if (Color.m481getAlphaimpl(j2) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        VeilConfig veilConfig = this.enter.config.veil;
        if (veilConfig == null) {
            veilConfig = this.exit.config.veil;
        }
        if (veilConfig == null || !veilConfig.matchParentSize) {
            DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, j2, 0L, 0L, CropImageView.DEFAULT_ASPECT_RATIO, 0, 126);
            return;
        }
        NodeCoordinator nodeCoordinatorRequireLayoutCoordinates = HitTestResultKt.requireLayoutCoordinates(this);
        LayoutCoordinates parentLayoutCoordinates = nodeCoordinatorRequireLayoutCoordinates.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            long j3 = ((NodeCoordinator) parentLayoutCoordinates).measuredSize;
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits((int) (j3 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j3 & 4294967295L))) & 4294967295L);
        } else {
            jFloatToRawIntBits = 0;
        }
        LayoutCoordinates parentLayoutCoordinates2 = nodeCoordinatorRequireLayoutCoordinates.getParentLayoutCoordinates();
        DrawScope.m550drawRectnJ9OG0$default(layoutNodeDrawScope, j2, (parentLayoutCoordinates2 != null ? ((NodeCoordinator) parentLayoutCoordinates2).mo605localPositionOfS_NoaFU(nodeCoordinatorRequireLayoutCoordinates, 0L) : 0L) ^ (-9223372034707292160L), jFloatToRawIntBits, CropImageView.DEFAULT_ASPECT_RATIO, 0, 120);
    }
}
