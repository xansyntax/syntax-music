package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnchoredDraggableDefaults {
    public static final byte $stable;
    public static final TweenSpec SnapAnimationSpec = ArcSplineKt.tween$default(0, 0, null, 7);
    public static final BorderKt$$ExternalSyntheticLambda1 PositionalThreshold = new BorderKt$$ExternalSyntheticLambda1((byte) 20);

    static {
        ArcSplineKt.exponentialDecay$default(3);
        $stable = (byte) 8;
    }

    public static SnapFlingBehavior flingBehavior(NodeChain nodeChain, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, Composer composer, int i, int i2) {
        if ((i2 & 4) != 0) {
            finiteAnimationSpec = SnapAnimationSpec;
        }
        GapComposer gapComposer = (GapComposer) composer;
        Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        byte b = 0;
        boolean zChanged = ((((i & 112) ^ 48) > 32 && gapComposer.changed(function1)) || (i & 48) == 32) | ((((i & 14) ^ 6) > 4 && gapComposer.changed(nodeChain)) || (i & 6) == 4) | gapComposer.changed(density) | gapComposer.changed(finiteAnimationSpec);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new SnapFlingBehavior(new AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1(nodeChain, function1, new SheetDefaultsKt$$ExternalSyntheticLambda0(density, (byte) 1), b), ScrollableKt.NoOpDecayAnimationSpec, finiteAnimationSpec);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (SnapFlingBehavior) objRememberedValue;
    }
}
