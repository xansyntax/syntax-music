package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.WeakCache;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final AndroidPaint innerBoundsPaint;
    public LookaheadDelegateImpl lookaheadDelegate;
    public final TailModifierNode tail;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LookaheadDelegateImpl extends LookaheadDelegate {
        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
            LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines;
            if (!lookaheadPassDelegate.duringAlignmentLinesQuery) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                if (layoutNodeLayoutDelegate.layoutState == LayoutNode.LayoutState.LookaheadMeasuring) {
                    lookaheadAlignmentLines.usedByModifierMeasurement = true;
                    if (lookaheadAlignmentLines.dirty) {
                        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
                    }
                } else {
                    lookaheadAlignmentLines.usedByModifierLayout = true;
                }
            }
            LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            Boolean boolValueOf = lookaheadDelegateImpl != null ? Boolean.valueOf(lookaheadDelegateImpl.isPlacingForAlignment) : null;
            LookaheadDelegateImpl lookaheadDelegateImpl2 = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegateImpl2 != null) {
                lookaheadDelegateImpl2.isPlacingForAlignment = true;
            }
            lookaheadPassDelegate.layoutChildren();
            LookaheadDelegateImpl lookaheadDelegateImpl3 = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegateImpl3 != null) {
                lookaheadDelegateImpl3.isPlacingForAlignment = boolValueOf != null ? boolValueOf.booleanValue() : false;
            }
            Integer num = (Integer) lookaheadAlignmentLines.alignmentLineMap.get(alignmentLine);
            int iIntValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            this.cachedAlignmentLinesMap.set(iIntValue, alignmentLine);
            return iIntValue;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicHeight(int i) {
            WeakCache orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
            return measurePolicyState.maxIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int maxIntrinsicWidth(int i) {
            WeakCache orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
            return measurePolicyState.maxIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public final Placeable mo598measureBRTryo0(long j) {
            m618setMeasurementConstraintsBRTryo0(j);
            NodeCoordinator nodeCoordinator = this.coordinator;
            MutableVector mutableVector = nodeCoordinator.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LookaheadPassDelegate lookaheadPassDelegate = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate.getClass();
                lookaheadPassDelegate.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
            LayoutNode layoutNode = nodeCoordinator.layoutNode;
            set_measureResult(layoutNode.measurePolicy.mo13measure3p2s80s(this, layoutNode.getChildLookaheadMeasurables$ui(), j));
            return this;
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicHeight(int i) {
            WeakCache orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
            return measurePolicyState.minIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public final int minIntrinsicWidth(int i) {
            WeakCache orCreateIntrinsicsPolicy = this.coordinator.layoutNode.getOrCreateIntrinsicsPolicy();
            MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
            LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
            return measurePolicyState.minIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui(), i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public final void placeChildren() {
            LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            lookaheadPassDelegate.onNodePlaced$ui();
        }
    }

    static {
        AndroidPaint androidPaintPaint = ColorKt.Paint();
        androidPaintPaint.m464setColor8_81llA(-281474976710656L);
        androidPaintPaint.setStrokeWidth(1.0f);
        androidPaintPaint.m468setStylek9PVt8s(1);
        innerBoundsPaint = androidPaintPaint;
    }

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        TailModifierNode tailModifierNode = new TailModifierNode();
        tailModifierNode.aggregateChildKindSet = 0;
        this.tail = tailModifierNode;
        tailModifierNode.coordinator = this;
        this.lookaheadDelegate = layoutNode.lookaheadRoot != null ? new LookaheadDelegateImpl(this) : null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int calculateAlignmentLine(AlignmentLine alignmentLine) throws Throwable {
        LookaheadDelegateImpl lookaheadDelegateImpl = this.lookaheadDelegate;
        if (lookaheadDelegateImpl != null) {
            return lookaheadDelegateImpl.calculateAlignmentLine(alignmentLine);
        }
        MeasurePassDelegate measurePassDelegate = this.layoutNode.layoutDelegate.measurePassDelegate;
        LookaheadAlignmentLines lookaheadAlignmentLines = measurePassDelegate.alignmentLines;
        if (!measurePassDelegate.duringAlignmentLinesQuery) {
            if (measurePassDelegate.layoutNodeLayoutDelegate.layoutState == LayoutNode.LayoutState.Measuring) {
                lookaheadAlignmentLines.usedByModifierMeasurement = true;
                if (lookaheadAlignmentLines.dirty) {
                    measurePassDelegate.layoutPending = true;
                    measurePassDelegate.layoutPendingForAlignment = true;
                }
            } else {
                lookaheadAlignmentLines.usedByModifierLayout = true;
            }
        }
        InnerNodeCoordinator innerCoordinator = measurePassDelegate.getInnerCoordinator();
        boolean z = innerCoordinator.isPlacingForAlignment;
        innerCoordinator.isPlacingForAlignment = true;
        measurePassDelegate.layoutChildren();
        innerCoordinator.isPlacingForAlignment = z;
        Integer num = (Integer) lookaheadAlignmentLines.alignmentLineMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void ensureLookaheadDelegateCreated() {
        if (this.lookaheadDelegate == null) {
            this.lookaheadDelegate = new LookaheadDelegateImpl(this);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0061  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0073 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.NodeCoordinator
    /* JADX INFO: renamed from: hitTestChild-qzLsGqo, reason: not valid java name */
    public final void mo647hitTestChildqzLsGqo(NodeCoordinator.HitTestSource hitTestSource, long j, HitTestResult hitTestResult, int i, boolean z) {
        int i2;
        boolean z2;
        Object[] objArr;
        int i3;
        LayoutNode layoutNode;
        long jM640findBestHitDistancefn2tFes;
        LayoutNode layoutNode2 = this.layoutNode;
        boolean z3 = false;
        if (hitTestSource.shouldHitTestChildren(layoutNode2)) {
            if (!m677withinLayerBoundsk4lQ0M(j)) {
                i2 = i;
                if (i2 == 1 && (Float.floatToRawIntBits(m665distanceInMinimumTouchTargettz77jQw(j, m667getMinimumTouchTargetSizeNHjbRc())) & Integer.MAX_VALUE) < 2139095040) {
                    z2 = false;
                }
                if (z3) {
                    int i4 = hitTestResult.hitDepth;
                    MutableVector zSortedChildren = layoutNode2.getZSortedChildren();
                    objArr = zSortedChildren.content;
                    i3 = zSortedChildren.size - 1;
                    while (i3 >= 0) {
                        layoutNode = (LayoutNode) objArr[i3];
                        if (layoutNode.isPlaced()) {
                            hitTestSource.mo638childHitTestqzLsGqo(layoutNode, j, hitTestResult, i2, z2);
                            jM640findBestHitDistancefn2tFes = hitTestResult.m640findBestHitDistancefn2tFes();
                            if (HitTestResultKt.m642getDistanceimpl(jM640findBestHitDistancefn2tFes) >= CropImageView.DEFAULT_ASPECT_RATIO && HitTestResultKt.m644isInLayerimpl(jM640findBestHitDistancefn2tFes) && !HitTestResultKt.m643isInExpandedBoundsimpl(jM640findBestHitDistancefn2tFes) && !hitTestSource.shareWithSiblings(hitTestResult, layoutNode)) {
                                break;
                            }
                        }
                        i3--;
                        i2 = i;
                    }
                    hitTestResult.hitDepth = i4;
                }
            }
            i2 = i;
            z2 = z;
            z3 = true;
            if (z3) {
                int i5 = hitTestResult.hitDepth;
                MutableVector zSortedChildren2 = layoutNode2.getZSortedChildren();
                objArr = zSortedChildren2.content;
                i3 = zSortedChildren2.size - 1;
                while (i3 >= 0) {
                    layoutNode = (LayoutNode) objArr[i3];
                    if (layoutNode.isPlaced()) {
                        hitTestSource.mo638childHitTestqzLsGqo(layoutNode, j, hitTestResult, i2, z2);
                        jM640findBestHitDistancefn2tFes = hitTestResult.m640findBestHitDistancefn2tFes();
                        if (HitTestResultKt.m642getDistanceimpl(jM640findBestHitDistancefn2tFes) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                            continue;
                        }
                    }
                    i3--;
                    i2 = i;
                }
                hitTestResult.hitDepth = i5;
            }
        }
        i2 = i;
        z2 = z;
        if (z3) {
            int i6 = hitTestResult.hitDepth;
            MutableVector zSortedChildren3 = layoutNode2.getZSortedChildren();
            objArr = zSortedChildren3.content;
            i3 = zSortedChildren3.size - 1;
            while (i3 >= 0) {
                layoutNode = (LayoutNode) objArr[i3];
                if (layoutNode.isPlaced()) {
                    hitTestSource.mo638childHitTestqzLsGqo(layoutNode, j, hitTestResult, i2, z2);
                    jM640findBestHitDistancefn2tFes = hitTestResult.m640findBestHitDistancefn2tFes();
                    if (HitTestResultKt.m642getDistanceimpl(jM640findBestHitDistancefn2tFes) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        continue;
                    }
                }
                i3--;
                i2 = i;
            }
            hitTestResult.hitDepth = i6;
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        WeakCache orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
        return measurePolicyState.maxIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        WeakCache orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
        return measurePolicyState.maxIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo598measureBRTryo0(long j) {
        m618setMeasurementConstraintsBRTryo0(j);
        LayoutNode layoutNode = this.layoutNode;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.measuredByParent = LayoutNode.UsageByParent.NotUsed;
        }
        setMeasureResult$ui(layoutNode.measurePolicy.mo13measure3p2s80s(this, layoutNode.getChildMeasurables$ui(), j));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        WeakCache orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
        return measurePolicyState.minIntrinsicHeight((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        WeakCache orCreateIntrinsicsPolicy = this.layoutNode.getOrCreateIntrinsicsPolicy();
        MeasurePolicy measurePolicyState = orCreateIntrinsicsPolicy.getMeasurePolicyState();
        LayoutNode layoutNode = (LayoutNode) orCreateIntrinsicsPolicy.values;
        return measurePolicyState.minIntrinsicWidth((NodeCoordinator) layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui(), i);
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo602placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        m673placeSelfMLgxB_4(j, f, function1, null);
        if (this.isShallowPlacing) {
            return;
        }
        this.layoutNode.layoutDelegate.measurePassDelegate.onNodePlaced$ui();
    }
}
