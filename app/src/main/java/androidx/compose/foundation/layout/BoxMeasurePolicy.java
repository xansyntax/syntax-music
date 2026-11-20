package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.InlineClassHelperKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda20;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BoxMeasurePolicy implements MeasurePolicy {
    public final Alignment alignment;
    public final boolean propagateMinConstraints;

    public BoxMeasurePolicy(Alignment alignment, boolean z) {
        this.alignment = alignment;
        this.propagateMinConstraints = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return Intrinsics.areEqual(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.propagateMinConstraints) + (this.alignment.hashCode() * 31);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(final MeasureScope measureScope, List list, long j) {
        int iM786getMinWidthimpl;
        int iM785getMinHeightimpl;
        Placeable placeableMo598measureBRTryo0;
        boolean zIsEmpty = list.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (zIsEmpty) {
            return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 3));
        }
        long j2 = this.propagateMinConstraints ? j : j & (-8589934589L);
        if (list.size() == 1) {
            final Measurable measurable = (Measurable) list.get(0);
            Object parentData = measurable.getParentData();
            BoxChildDataNode boxChildDataNode = parentData instanceof BoxChildDataNode ? (BoxChildDataNode) parentData : null;
            if (boxChildDataNode != null ? boxChildDataNode.matchParentSize : false) {
                iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                int iM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(j);
                int iM785getMinHeightimpl2 = Constraints.m785getMinHeightimpl(j);
                if (!((iM785getMinHeightimpl2 >= 0) & (iM786getMinWidthimpl2 >= 0))) {
                    InlineClassHelperKt.throwIllegalArgumentException("width and height must be >= 0");
                }
                placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(ConstraintsKt.createConstraints(iM786getMinWidthimpl2, iM786getMinWidthimpl2, iM785getMinHeightimpl2, iM785getMinHeightimpl2));
            } else {
                placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j2);
                iM786getMinWidthimpl = Math.max(Constraints.m786getMinWidthimpl(j), placeableMo598measureBRTryo0.width);
                iM785getMinHeightimpl = Math.max(Constraints.m785getMinHeightimpl(j), placeableMo598measureBRTryo0.height);
            }
            final int i = iM785getMinHeightimpl;
            final int i2 = iM786getMinWidthimpl;
            final Placeable placeable = placeableMo598measureBRTryo0;
            return measureScope.layout(i2, i, emptyMap, new Function1() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    BoxKt.placeInBox((Placeable.PlacementScope) obj, placeable, measurable, measureScope.getLayoutDirection(), i2, i, this.alignment);
                    return Unit.INSTANCE;
                }
            });
        }
        Placeable[] placeableArr = new Placeable[list.size()];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = Constraints.m786getMinWidthimpl(j);
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = Constraints.m785getMinHeightimpl(j);
        int size = list.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable2 = (Measurable) list.get(i3);
            Object parentData2 = measurable2.getParentData();
            BoxChildDataNode boxChildDataNode2 = parentData2 instanceof BoxChildDataNode ? (BoxChildDataNode) parentData2 : null;
            if (boxChildDataNode2 != null ? boxChildDataNode2.matchParentSize : false) {
                z = true;
            } else {
                Placeable placeableMo598measureBRTryo1 = measurable2.mo598measureBRTryo0(j2);
                placeableArr[i3] = placeableMo598measureBRTryo1;
                ref$IntRef.element = Math.max(ref$IntRef.element, placeableMo598measureBRTryo1.width);
                ref$IntRef2.element = Math.max(ref$IntRef2.element, placeableMo598measureBRTryo1.height);
            }
        }
        if (z) {
            int i4 = ref$IntRef.element;
            int i5 = i4 != Integer.MAX_VALUE ? i4 : 0;
            int i6 = ref$IntRef2.element;
            long jConstraints = ConstraintsKt.Constraints(i5, i4, i6 != Integer.MAX_VALUE ? i6 : 0, i6);
            int size2 = list.size();
            for (int i7 = 0; i7 < size2; i7++) {
                Measurable measurable3 = (Measurable) list.get(i7);
                Object parentData3 = measurable3.getParentData();
                BoxChildDataNode boxChildDataNode3 = parentData3 instanceof BoxChildDataNode ? (BoxChildDataNode) parentData3 : null;
                if (boxChildDataNode3 != null ? boxChildDataNode3.matchParentSize : false) {
                    placeableArr[i7] = measurable3.mo598measureBRTryo0(jConstraints);
                }
            }
        }
        return measureScope.layout(ref$IntRef.element, ref$IntRef2.element, emptyMap, new SongMenuKt$$ExternalSyntheticLambda20(placeableArr, list, measureScope, ref$IntRef, ref$IntRef2, this, (byte) 1));
    }

    public final String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ")";
    }
}
