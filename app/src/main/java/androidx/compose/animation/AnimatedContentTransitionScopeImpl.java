package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.IntrinsicSizeModifier;
import androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl implements AnimatedContentTransitionScope {
    public Alignment contentAlignment;
    public final ParcelableSnapshotMutableState measuredSize$delegate = Stack.mutableStateOf$default(new IntSize(0));
    public final MutableScatterMap targetSizeMap;
    public final Transition transition;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002¨\u0006\u0004"}, d2 = {"androidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierElement", "S", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierNode;", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class SizeModifierElement<S> extends ModifierNodeElement {
        public final AnimatedContentTransitionScopeImpl scope;
        public final Transition.DeferredAnimation sizeAnimation;
        public final MutableState sizeTransform;

        public SizeModifierElement(Transition.DeferredAnimation deferredAnimation, MutableState mutableState, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = mutableState;
            this.scope = animatedContentTransitionScopeImpl;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            return new SizeModifierNode(this.sizeAnimation, this.sizeTransform, this.scope);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SizeModifierElement)) {
                return false;
            }
            SizeModifierElement sizeModifierElement = (SizeModifierElement) obj;
            return Intrinsics.areEqual(sizeModifierElement.sizeAnimation, this.sizeAnimation) && sizeModifierElement.sizeTransform.equals(this.sizeTransform);
        }

        public final int hashCode() {
            int iHashCode = this.scope.hashCode() * 31;
            Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
            return this.sizeTransform.hashCode() + ((iHashCode + (deferredAnimation != null ? deferredAnimation.hashCode() : 0)) * 31);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(Modifier.Node node) {
            SizeModifierNode sizeModifierNode = (SizeModifierNode) node;
            sizeModifierNode.sizeAnimation = this.sizeAnimation;
            sizeModifierNode.sizeTransform = this.sizeTransform;
            sizeModifierNode.scope = this.scope;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SizeModifierNode extends IntrinsicSizeModifier {
        public Placeable approachPlaceable;
        public final AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0 approachPlacementBlock;
        public long approachSize;
        public long lastSize;
        public Placeable lookaheadPlaceable;
        public final AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0 lookaheadPlacementBlock;
        public long lookaheadSize;
        public AnimatedContentTransitionScopeImpl scope;
        public Transition.DeferredAnimation sizeAnimation;
        public MutableState sizeTransform;

        public SizeModifierNode(Transition.DeferredAnimation deferredAnimation, MutableState mutableState, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            super((byte) 1);
            this.sizeAnimation = deferredAnimation;
            this.sizeTransform = mutableState;
            this.scope = animatedContentTransitionScopeImpl;
            this.lookaheadSize = 0L;
            this.approachSize = 0L;
            this.lookaheadPlacementBlock = new AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0(this, (byte) 1);
            this.approachPlacementBlock = new AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0(this, (byte) 2);
            this.lastSize = -9223372034707292160L;
        }

        @Override // androidx.compose.foundation.layout.IntrinsicSizeModifier, androidx.compose.ui.node.LayoutModifierNode
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            long j2;
            Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
            if (measureScope.isLookingAhead()) {
                j2 = (((long) placeableMo598measureBRTryo0.width) << 32) | (((long) placeableMo598measureBRTryo0.height) & 4294967295L);
            } else {
                Transition.DeferredAnimation deferredAnimation = this.sizeAnimation;
                int i = placeableMo598measureBRTryo0.width;
                if (deferredAnimation == null) {
                    j2 = (((long) i) << 32) | (((long) placeableMo598measureBRTryo0.height) & 4294967295L);
                    this.lastSize = j2;
                } else {
                    long j3 = (((long) placeableMo598measureBRTryo0.height) & 4294967295L) | (((long) i) << 32);
                    Transition.DeferredAnimation.DeferredAnimationData deferredAnimationDataAnimate = deferredAnimation.animate(new AnimatedContentTransitionScopeImpl$SizeModifierNode$$ExternalSyntheticLambda0(this, j3), null, null, new ScrimKt$$ExternalSyntheticLambda1((Object) this, j3, (byte) 1));
                    j2 = ((IntSize) deferredAnimationDataAnimate.getValue()).packedValue;
                    this.lastSize = ((IntSize) deferredAnimationDataAnimate.getValue()).packedValue;
                }
            }
            boolean zIsLookingAhead = measureScope.isLookingAhead();
            EmptyMap emptyMap = EmptyMap.INSTANCE;
            if (zIsLookingAhead) {
                this.lookaheadPlaceable = placeableMo598measureBRTryo0;
                this.lookaheadSize = j2;
                return measureScope.layout((int) (j2 >> 32), (int) (j2 & 4294967295L), emptyMap, this.lookaheadPlacementBlock);
            }
            this.approachPlaceable = placeableMo598measureBRTryo0;
            this.approachSize = j2;
            return measureScope.layout((int) (j2 >> 32), (int) (j2 & 4294967295L), emptyMap, this.approachPlacementBlock);
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onReset() {
            this.lastSize = -9223372034707292160L;
        }
    }

    public AnimatedContentTransitionScopeImpl(Transition transition, Alignment alignment) {
        this.transition = transition;
        this.contentAlignment = alignment;
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.targetSizeMap = new MutableScatterMap();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    @Override // androidx.compose.animation.core.Transition.Segment
    public final Object getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ChildData implements ParentDataModifier {
        public final ParcelableSnapshotMutableState isPendingTarget$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
        public final ParcelableSnapshotMutableState isTarget$delegate;

        public ChildData(boolean z) {
            this.isTarget$delegate = Stack.mutableStateOf$default(Boolean.valueOf(z));
        }

        @Override // androidx.compose.ui.layout.ParentDataModifier
        public final Object modifyParentData() {
            return this;
        }
    }
}
