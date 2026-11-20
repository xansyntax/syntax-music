package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeMeasuringIntrinsics$IntrinsicMinMax;
import androidx.compose.ui.node.NodeMeasuringIntrinsics$IntrinsicWidthHeight;
import androidx.compose.ui.unit.Constraints;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {
    public final /* synthetic */ byte $r8$classId;
    public final Measurable measurable;
    public final Enum minMax;
    public final Enum widthHeight;

    public /* synthetic */ DefaultIntrinsicMeasurable(Measurable measurable, Enum r2, Enum r3, byte b) {
        this.$r8$classId = b;
        this.measurable = measurable;
        this.minMax = r2;
        this.widthHeight = r3;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.getParentData();
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0, reason: not valid java name */
    public final Placeable mo598measureBRTryo0(long j) {
        byte b = this.$r8$classId;
        Enum r1 = this.minMax;
        Enum r2 = this.widthHeight;
        Measurable measurable = this.measurable;
        switch (b) {
            case 0:
                IntrinsicWidthHeight intrinsicWidthHeight = (IntrinsicWidthHeight) r2;
                IntrinsicMinMax intrinsicMinMax = (IntrinsicMinMax) r1;
                IntrinsicMinMax intrinsicMinMax2 = IntrinsicMinMax.Max;
                if (intrinsicWidthHeight == IntrinsicWidthHeight.Width) {
                    return new FixedSizeIntrinsicsPlaceable(intrinsicMinMax == intrinsicMinMax2 ? measurable.maxIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)) : measurable.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)), Constraints.m779getHasBoundedHeightimpl(j) ? Constraints.m783getMaxHeightimpl(j) : 32767, (byte) 0);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m780getHasBoundedWidthimpl(j) ? Constraints.m784getMaxWidthimpl(j) : 32767, intrinsicMinMax == intrinsicMinMax2 ? measurable.maxIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)) : measurable.minIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)), (byte) 0);
            case 1:
                MeasuringIntrinsics$IntrinsicWidthHeight measuringIntrinsics$IntrinsicWidthHeight = (MeasuringIntrinsics$IntrinsicWidthHeight) r2;
                MeasuringIntrinsics$IntrinsicMinMax measuringIntrinsics$IntrinsicMinMax = (MeasuringIntrinsics$IntrinsicMinMax) r1;
                MeasuringIntrinsics$IntrinsicMinMax measuringIntrinsics$IntrinsicMinMax2 = MeasuringIntrinsics$IntrinsicMinMax.Max;
                if (measuringIntrinsics$IntrinsicWidthHeight == MeasuringIntrinsics$IntrinsicWidthHeight.Width) {
                    return new FixedSizeIntrinsicsPlaceable(measuringIntrinsics$IntrinsicMinMax == measuringIntrinsics$IntrinsicMinMax2 ? measurable.maxIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)) : measurable.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)), Constraints.m779getHasBoundedHeightimpl(j) ? Constraints.m783getMaxHeightimpl(j) : 32767, (byte) 1);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m780getHasBoundedWidthimpl(j) ? Constraints.m784getMaxWidthimpl(j) : 32767, measuringIntrinsics$IntrinsicMinMax == measuringIntrinsics$IntrinsicMinMax2 ? measurable.maxIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)) : measurable.minIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)), (byte) 1);
            default:
                NodeMeasuringIntrinsics$IntrinsicWidthHeight nodeMeasuringIntrinsics$IntrinsicWidthHeight = (NodeMeasuringIntrinsics$IntrinsicWidthHeight) r2;
                NodeMeasuringIntrinsics$IntrinsicMinMax nodeMeasuringIntrinsics$IntrinsicMinMax = (NodeMeasuringIntrinsics$IntrinsicMinMax) r1;
                NodeMeasuringIntrinsics$IntrinsicMinMax nodeMeasuringIntrinsics$IntrinsicMinMax2 = NodeMeasuringIntrinsics$IntrinsicMinMax.Max;
                if (nodeMeasuringIntrinsics$IntrinsicWidthHeight == NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width) {
                    return new FixedSizeIntrinsicsPlaceable(nodeMeasuringIntrinsics$IntrinsicMinMax == nodeMeasuringIntrinsics$IntrinsicMinMax2 ? measurable.maxIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)) : measurable.minIntrinsicWidth(Constraints.m783getMaxHeightimpl(j)), Constraints.m779getHasBoundedHeightimpl(j) ? Constraints.m783getMaxHeightimpl(j) : 32767, (byte) 2);
                }
                return new FixedSizeIntrinsicsPlaceable(Constraints.m780getHasBoundedWidthimpl(j) ? Constraints.m784getMaxWidthimpl(j) : 32767, nodeMeasuringIntrinsics$IntrinsicMinMax == nodeMeasuringIntrinsics$IntrinsicMinMax2 ? measurable.maxIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)) : measurable.minIntrinsicHeight(Constraints.m784getMaxWidthimpl(j)), (byte) 2);
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.measurable.minIntrinsicWidth(i);
    }
}
