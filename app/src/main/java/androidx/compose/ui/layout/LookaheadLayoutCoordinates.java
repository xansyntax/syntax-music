package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {
    public final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m615getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        return Offset.m438minusMKHz9U(mo605localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, 0L), lookaheadDelegate.coordinator.mo605localPositionOfS_NoaFU(rootLookaheadDelegate.coordinator, 0L));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached$1()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinator = this.lookaheadDelegate.coordinator.wrappedBy;
        if (nodeCoordinator == null || (lookaheadDelegate = nodeCoordinator.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (!isAttached$1()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinator = ((NodeCoordinator) this.lookaheadDelegate.coordinator.layoutNode.nodes.outerCoordinator).wrappedBy;
        if (nodeCoordinator == null || (lookaheadDelegate = nodeCoordinator.getLookaheadDelegate()) == null) {
            return null;
        }
        return lookaheadDelegate.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo603getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return (((long) lookaheadDelegate.width) << 32) | (((long) lookaheadDelegate.height) & 4294967295L);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached$1() {
        return this.lookaheadDelegate.coordinator.getTail().isAttached;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        return this.lookaheadDelegate.coordinator.localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public final long mo604localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        return mo605localPositionOfS_NoaFU(layoutCoordinates, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-S_NoaFU */
    public final long mo605localPositionOfS_NoaFU(LayoutCoordinates layoutCoordinates, long j) {
        boolean z = layoutCoordinates instanceof LookaheadLayoutCoordinates;
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (!z) {
            LookaheadDelegate rootLookaheadDelegate = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
            LayoutCoordinates layoutCoordinates2 = rootLookaheadDelegate.coordinator;
            long jMo605localPositionOfS_NoaFU = mo605localPositionOfS_NoaFU(rootLookaheadDelegate.lookaheadLayoutCoordinates, j);
            long j2 = rootLookaheadDelegate.position;
            long jM438minusMKHz9U = Offset.m438minusMKHz9U(jMo605localPositionOfS_NoaFU, (4294967295L & ((long) Float.floatToRawIntBits((int) (j2 & 4294967295L)))) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32));
            LayoutCoordinates parentCoordinates = layoutCoordinates2.getParentCoordinates();
            if (parentCoordinates != null) {
                layoutCoordinates2 = parentCoordinates;
            }
            return Offset.m439plusMKHz9U(jM438minusMKHz9U, ((NodeCoordinator) layoutCoordinates2).mo605localPositionOfS_NoaFU(layoutCoordinates, 0L));
        }
        LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinates) layoutCoordinates).lookaheadDelegate;
        NodeCoordinator nodeCoordinator = lookaheadDelegate2.coordinator;
        nodeCoordinator.onCoordinatesUsed$ui();
        LookaheadDelegate lookaheadDelegate3 = lookaheadDelegate.coordinator.findCommonAncestor$ui(nodeCoordinator).getLookaheadDelegate();
        if (lookaheadDelegate3 != null) {
            long jM805minusqkQi6aY = IntOffset.m805minusqkQi6aY(IntOffset.m806plusqkQi6aY(lookaheadDelegate2.m656positionIniSbpLlY$ui(lookaheadDelegate3, false), SQLite.m847roundk4lQ0M(j)), lookaheadDelegate.m656positionIniSbpLlY$ui(lookaheadDelegate3, false));
            return (((long) Float.floatToRawIntBits((int) (jM805minusqkQi6aY >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jM805minusqkQi6aY & 4294967295L))) & 4294967295L);
        }
        LookaheadDelegate rootLookaheadDelegate2 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(IntOffset.m806plusqkQi6aY(lookaheadDelegate2.m656positionIniSbpLlY$ui(rootLookaheadDelegate2, false), rootLookaheadDelegate2.position), SQLite.m847roundk4lQ0M(j));
        LookaheadDelegate rootLookaheadDelegate3 = RulerKt.getRootLookaheadDelegate(lookaheadDelegate);
        long jM805minusqkQi6aY2 = IntOffset.m805minusqkQi6aY(jM806plusqkQi6aY, IntOffset.m806plusqkQi6aY(lookaheadDelegate.m656positionIniSbpLlY$ui(rootLookaheadDelegate3, false), rootLookaheadDelegate3.position));
        long jFloatToRawIntBits = Float.floatToRawIntBits((int) (jM805minusqkQi6aY2 >> 32));
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits((int) (jM805minusqkQi6aY2 & 4294967295L))) & 4294967295L;
        NodeCoordinator nodeCoordinator2 = rootLookaheadDelegate3.coordinator.wrappedBy;
        nodeCoordinator2.getClass();
        NodeCoordinator nodeCoordinator3 = rootLookaheadDelegate2.coordinator.wrappedBy;
        nodeCoordinator3.getClass();
        return nodeCoordinator2.mo605localPositionOfS_NoaFU(nodeCoordinator3, jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public final long mo606localToRootMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo606localToRootMKHz9U(Offset.m439plusMKHz9U(j, m615getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public final long mo607localToScreenMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo607localToScreenMKHz9U(Offset.m439plusMKHz9U(j, m615getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public final long mo608localToWindowMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo608localToWindowMKHz9U(Offset.m439plusMKHz9U(j, m615getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public final long mo609screenToLocalMKHz9U(long j) {
        return Offset.m439plusMKHz9U(this.lookaheadDelegate.coordinator.mo609screenToLocalMKHz9U(j), m615getLookaheadOffsetF1C5BW0());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public final void mo610transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        this.lookaheadDelegate.coordinator.mo610transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformToScreen-58bKbWc */
    public final void mo611transformToScreen58bKbWc(float[] fArr) {
        this.lookaheadDelegate.coordinator.mo611transformToScreen58bKbWc(fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public final long mo612windowToLocalMKHz9U(long j) {
        return Offset.m439plusMKHz9U(this.lookaheadDelegate.coordinator.mo612windowToLocalMKHz9U(j), m615getLookaheadOffsetF1C5BW0());
    }
}
