package androidx.compose.animation;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AnimatedContentTransitionScopeImpl.SizeModifierNode f$0;

    public /* synthetic */ AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0(AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode, long j) {
        this.$r8$classId = (byte) 0;
        this.f$0 = sizeModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        State state;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode = this.f$0;
        switch (b) {
            case 0:
                Transition.Segment segment = (Transition.Segment) obj;
                if (!Intrinsics.areEqual(segment.getInitialState(), sizeModifierNode.scope.getInitialState()) && (state = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getInitialState())) != null) {
                    long j = ((IntSize) state.getValue()).packedValue;
                }
                State state2 = (State) sizeModifierNode.scope.targetSizeMap.get(segment.getTargetState());
                if (state2 != null) {
                    long j2 = ((IntSize) state2.getValue()).packedValue;
                }
                if (((SizeTransformImpl) sizeModifierNode.sizeTransform.getValue()) == null) {
                    return ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
                }
                Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
                return ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, new IntSize(4294967297L), 1);
            case 1:
                Placeable placeable = sizeModifierNode.lookaheadPlaceable;
                placeable.getClass();
                Placeable.PlacementScope.m619place70tqf50$default((Placeable.PlacementScope) obj, placeable, sizeModifierNode.scope.contentAlignment.mo397alignKFBX0sM((((long) placeable.width) << 32) | (4294967295L & ((long) placeable.height)), sizeModifierNode.lookaheadSize, LayoutDirection.Ltr));
                return unit;
            default:
                Placeable placeable2 = sizeModifierNode.approachPlaceable;
                placeable2.getClass();
                Placeable.PlacementScope.m619place70tqf50$default((Placeable.PlacementScope) obj, placeable2, sizeModifierNode.scope.contentAlignment.mo397alignKFBX0sM((((long) placeable2.width) << 32) | (4294967295L & ((long) placeable2.height)), sizeModifierNode.approachSize, LayoutDirection.Ltr));
                return unit;
        }
    }

    public /* synthetic */ AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0(AnimatedContentTransitionScopeImpl.SizeModifierNode sizeModifierNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = sizeModifierNode;
    }
}
