package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    public MeasureResult _measureResult;
    public final MutableObjectIntMap cachedAlignmentLinesMap;
    public final NodeCoordinator coordinator;
    public LinkedHashMap oldAlignmentLines;
    public long position = 0;
    public final LookaheadLayoutCoordinates lookaheadLayoutCoordinates = new LookaheadLayoutCoordinates(this);

    public LookaheadDelegate(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
        MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        this.cachedAlignmentLinesMap = new MutableObjectIntMap();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getChild() {
        NodeCoordinator nodeCoordinator = this.coordinator.wrapped;
        if (nodeCoordinator != null) {
            return nodeCoordinator.getLookaheadDelegate();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.coordinator.layoutNode.layoutDirection;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutNode getLayoutNode() {
        return this.coordinator.layoutNode;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final MeasureResult getMeasureResult$ui() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getParent() {
        NodeCoordinator nodeCoordinator = this.coordinator.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.getLookaheadDelegate();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        return this.coordinator.getParentData();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac */
    public final long mo654getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.layout.IntrinsicMeasureScope
    public final boolean isLookingAhead() {
        return true;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo602placeAtf8xVGno(long j, float f, Function1 function1) {
        m655placeSelfgyyYBs(j);
        if (this.isShallowPlacing) {
            return;
        }
        placeChildren();
    }

    public void placeChildren() {
        getMeasureResult$ui().placeChildren();
    }

    /* JADX INFO: renamed from: placeSelf--gyyYBs, reason: not valid java name */
    public final void m655placeSelfgyyYBs(long j) {
        if (!IntOffset.m804equalsimpl0(this.position, j)) {
            this.position = j;
            NodeCoordinator nodeCoordinator = this.coordinator;
            LookaheadPassDelegate lookaheadPassDelegate = nodeCoordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            LookaheadCapablePlaceable.invalidateAlignmentLinesFromPositionChange(nodeCoordinator);
        }
        if (this.isPlacingForAlignment) {
            return;
        }
        captureRulersIfNeeded$ui(getMeasureResult$ui());
    }

    /* JADX INFO: renamed from: positionIn-iSbpLlY$ui, reason: not valid java name */
    public final long m656positionIniSbpLlY$ui(LookaheadDelegate lookaheadDelegate, boolean z) {
        long jM806plusqkQi6aY = 0;
        while (!this.equals(lookaheadDelegate)) {
            if (!this.isPlacedUnderMotionFrameOfReference || !z) {
                jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(jM806plusqkQi6aY, this.position);
            }
            NodeCoordinator nodeCoordinator = this.coordinator.wrappedBy;
            nodeCoordinator.getClass();
            this = nodeCoordinator.getLookaheadDelegate();
            this.getClass();
        }
        return jM806plusqkQi6aY;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void replace$ui() {
        mo602placeAtf8xVGno(this.position, CropImageView.DEFAULT_ASPECT_RATIO, (Function1) null);
    }

    public final void set_measureResult(MeasureResult measureResult) {
        LinkedHashMap linkedHashMap;
        if (measureResult != null) {
            m617setMeasuredSizeozmzZPI((((long) measureResult.getHeight()) & 4294967295L) | (((long) measureResult.getWidth()) << 32));
        } else {
            m617setMeasuredSizeozmzZPI(0L);
        }
        if (!Intrinsics.areEqual(this._measureResult, measureResult) && measureResult != null && ((((linkedHashMap = this.oldAlignmentLines) != null && !linkedHashMap.isEmpty()) || !measureResult.getAlignmentLines().isEmpty()) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines))) {
            LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            lookaheadPassDelegate.alignmentLines.onAlignmentsChanged();
            LinkedHashMap linkedHashMap2 = this.oldAlignmentLines;
            if (linkedHashMap2 == null) {
                linkedHashMap2 = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap2;
            }
            linkedHashMap2.clear();
            linkedHashMap2.putAll(measureResult.getAlignmentLines());
        }
        this._measureResult = measureResult;
    }
}
