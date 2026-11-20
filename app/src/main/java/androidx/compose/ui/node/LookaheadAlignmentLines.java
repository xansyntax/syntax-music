package androidx.compose.ui.node;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.sqlite.SQLite;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadAlignmentLines {
    public final /* synthetic */ byte $r8$classId;
    public final AlignmentLinesOwner alignmentLinesOwner;
    public boolean previousUsedDuringParentLayout;
    public AlignmentLinesOwner queryOwner;
    public boolean usedByModifierLayout;
    public boolean usedByModifierMeasurement;
    public boolean usedDuringParentLayout;
    public boolean usedDuringParentMeasurement;
    public boolean dirty = true;
    public final HashMap alignmentLineMap = new HashMap();

    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner, byte b) {
        this.$r8$classId = b;
        this.alignmentLinesOwner = alignmentLinesOwner;
    }

    public final void addAlignmentLine(AlignmentLine alignmentLine, int i, NodeCoordinator nodeCoordinator) {
        float f = i;
        long jFloatToRawIntBits = ((long) Float.floatToRawIntBits(f)) << 32;
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(f)) & 4294967295L;
        while (true) {
            long jM439plusMKHz9U = jFloatToRawIntBits | jFloatToRawIntBits2;
            do {
                switch (this.$r8$classId) {
                    case 0:
                        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
                        lookaheadDelegate.getClass();
                        long j = lookaheadDelegate.position;
                        jM439plusMKHz9U = Offset.m439plusMKHz9U((((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j >> 32))) << 32), jM439plusMKHz9U);
                        break;
                    default:
                        OwnedLayer ownedLayer = nodeCoordinator.layer;
                        if (ownedLayer != null) {
                            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = (GraphicsLayerOwnerLayer) ownedLayer;
                            float[] fArrM705getMatrixsQKQjiQ = graphicsLayerOwnerLayer.m705getMatrixsQKQjiQ();
                            if (!graphicsLayerOwnerLayer.isIdentity) {
                                jM439plusMKHz9U = Matrix.m508mapMKHz9U(jM439plusMKHz9U, fArrM705getMatrixsQKQjiQ);
                            }
                        }
                        jM439plusMKHz9U = SQLite.m846plusNvtHpc(jM439plusMKHz9U, nodeCoordinator.position);
                        break;
                }
                nodeCoordinator = nodeCoordinator.wrappedBy;
                nodeCoordinator.getClass();
                if (nodeCoordinator.equals(this.alignmentLinesOwner.getInnerCoordinator())) {
                    int iRound = Math.round(alignmentLine instanceof HorizontalAlignmentLine ? Float.intBitsToFloat((int) (jM439plusMKHz9U & 4294967295L)) : Float.intBitsToFloat((int) (jM439plusMKHz9U >> 32)));
                    HashMap map = this.alignmentLineMap;
                    if (map.containsKey(alignmentLine)) {
                        int iIntValue = ((Number) MapsKt__MapsKt.getValue(map, alignmentLine)).intValue();
                        HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.FirstBaseline;
                        iRound = ((Number) alignmentLine.merger.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iRound))).intValue();
                    }
                    map.put(alignmentLine, Integer.valueOf(iRound));
                    return;
                }
            } while (!getAlignmentLinesMap(nodeCoordinator).containsKey(alignmentLine));
            float positionFor = getPositionFor(nodeCoordinator, alignmentLine);
            long jFloatToRawIntBits3 = Float.floatToRawIntBits(positionFor);
            long jFloatToRawIntBits4 = Float.floatToRawIntBits(positionFor);
            jFloatToRawIntBits = jFloatToRawIntBits3 << 32;
            jFloatToRawIntBits2 = jFloatToRawIntBits4 & 4294967295L;
        }
    }

    public final Map getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        switch (this.$r8$classId) {
            case 0:
                LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
                lookaheadDelegate.getClass();
                return lookaheadDelegate.getMeasureResult$ui().getAlignmentLines();
            default:
                return nodeCoordinator.getMeasureResult$ui().getAlignmentLines();
        }
    }

    public final int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        switch (this.$r8$classId) {
            case 0:
                LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
                lookaheadDelegate.getClass();
                return lookaheadDelegate.get(alignmentLine);
            default:
                return nodeCoordinator.get(alignmentLine);
        }
    }

    public final boolean getQueried$ui() {
        return this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout;
    }

    public final boolean getRequired$ui() {
        recalculateQueryOwner();
        return this.queryOwner != null;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        AlignmentLinesOwner parentAlignmentLinesOwner = alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null) {
            return;
        }
        if (this.usedDuringParentMeasurement) {
            parentAlignmentLinesOwner.requestMeasure();
        } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
            parentAlignmentLinesOwner.requestLayout();
        }
        if (this.usedByModifierMeasurement) {
            alignmentLinesOwner.requestMeasure();
        }
        if (this.usedByModifierLayout) {
            alignmentLinesOwner.requestLayout();
        }
        parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
    }

    public final void recalculate() {
        HashMap map = this.alignmentLineMap;
        map.clear();
        TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2((byte) 24, this);
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        alignmentLinesOwner.forEachChildAlignmentLinesOwner(textKt$$ExternalSyntheticLambda2);
        map.putAll(getAlignmentLinesMap(alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        LookaheadAlignmentLines alignmentLines;
        LookaheadAlignmentLines alignmentLines2;
        boolean queried$ui = getQueried$ui();
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        if (!queried$ui) {
            AlignmentLinesOwner parentAlignmentLinesOwner = alignmentLinesOwner.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner == null) {
                return;
            }
            alignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines().queryOwner;
            if (alignmentLinesOwner == null || !alignmentLinesOwner.getAlignmentLines().getQueried$ui()) {
                AlignmentLinesOwner alignmentLinesOwner2 = this.queryOwner;
                if (alignmentLinesOwner2 == null || alignmentLinesOwner2.getAlignmentLines().getQueried$ui()) {
                    return;
                }
                AlignmentLinesOwner parentAlignmentLinesOwner2 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                if (parentAlignmentLinesOwner2 != null && (alignmentLines2 = parentAlignmentLinesOwner2.getAlignmentLines()) != null) {
                    alignmentLines2.recalculateQueryOwner();
                }
                AlignmentLinesOwner parentAlignmentLinesOwner3 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                alignmentLinesOwner = (parentAlignmentLinesOwner3 == null || (alignmentLines = parentAlignmentLinesOwner3.getAlignmentLines()) == null) ? null : alignmentLines.queryOwner;
            }
        }
        this.queryOwner = alignmentLinesOwner;
    }
}
