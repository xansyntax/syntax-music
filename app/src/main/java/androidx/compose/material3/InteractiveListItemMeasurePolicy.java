package androidx.compose.material3;

import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InteractiveListItemMeasurePolicy implements MultiContentMeasurePolicy {
    public final Alignment.Vertical verticalAlignment;
    public final float verticalPadding;

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1(2, Measurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((Measurable) obj).maxIntrinsicHeight(((Number) obj2).intValue()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class C00311 extends FunctionReferenceImpl implements Function2 {
        public static final C00311 INSTANCE = new C00311(2, Measurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((Measurable) obj).maxIntrinsicWidth(((Number) obj2).intValue()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class C00321 extends FunctionReferenceImpl implements Function2 {
        public static final C00321 INSTANCE = new C00321(2, Measurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((Measurable) obj).minIntrinsicHeight(((Number) obj2).intValue()));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.InteractiveListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final /* synthetic */ class C00331 extends FunctionReferenceImpl implements Function2 {
        public static final C00331 INSTANCE = new C00331(2, Measurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return Integer.valueOf(((Measurable) obj).minIntrinsicWidth(((Number) obj2).intValue()));
        }
    }

    public InteractiveListItemMeasurePolicy(Alignment.Vertical vertical, float f) {
        this.verticalAlignment = vertical;
        this.verticalPadding = f;
    }

    public static int calculateIntrinsicWidth(ArrayList arrayList, int i, Function2 function2) {
        List list = (List) arrayList.get(0);
        List list2 = (List) arrayList.get(1);
        List list3 = (List) arrayList.get(2);
        List list4 = (List) arrayList.get(3);
        List list5 = (List) arrayList.get(4);
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list);
        int iIntValue = measurable != null ? ((Number) function2.invoke(measurable, Integer.valueOf(i))).intValue() : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list2);
        int iIntValue2 = measurable2 != null ? ((Number) function2.invoke(measurable2, Integer.valueOf(i))).intValue() : 0;
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list3);
        int iIntValue3 = measurable3 != null ? ((Number) function2.invoke(measurable3, Integer.valueOf(i))).intValue() : 0;
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list4);
        int iIntValue4 = measurable4 != null ? ((Number) function2.invoke(measurable4, Integer.valueOf(i))).intValue() : 0;
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list5);
        int iIntValue5 = measurable5 != null ? ((Number) function2.invoke(measurable5, Integer.valueOf(i))).intValue() : 0;
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
        return Constraints.m780getHasBoundedWidthimpl(jConstraints$default) ? Constraints.m784getMaxWidthimpl(jConstraints$default) : Math.max(iIntValue5, Math.max(iIntValue3, iIntValue4)) + iIntValue + iIntValue2;
    }

    /* JADX INFO: renamed from: calculateHeight-vnELnnM, reason: not valid java name */
    public final int m292calculateHeightvnELnnM(Density density, int i, int i2, int i3, int i4, int i5, long j, int i6) {
        float f;
        int iM785getMinHeightimpl;
        int iMax = Math.max(i, Math.max(i5 + i3 + i4, i2));
        if (i6 == 1) {
            f = 56.0f;
        } else {
            f = i6 == 2 ? 72.0f : 88.0f;
        }
        float f2 = ((Dp) UuidKt.coerceAtLeast(new Dp((f - this.verticalPadding) + CropImageView.DEFAULT_ASPECT_RATIO), new Dp(CropImageView.DEFAULT_ASPECT_RATIO))).value;
        if (Constraints.m785getMinHeightimpl(j) == 0) {
            int iMo75roundToPx0680j_4 = density.mo75roundToPx0680j_4(f2);
            iM785getMinHeightimpl = Constraints.m783getMaxHeightimpl(j);
            if (iMo75roundToPx0680j_4 < 0) {
                iMo75roundToPx0680j_4 = 0;
            }
            if (iMo75roundToPx0680j_4 <= iM785getMinHeightimpl) {
                iM785getMinHeightimpl = iMo75roundToPx0680j_4;
            }
        } else {
            iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
        }
        return ConstraintsKt.m791constrainHeightK40F9xA(iMax, ConstraintsKt.Constraints(Constraints.m786getMinWidthimpl(j), Constraints.m784getMaxWidthimpl(j), iM785getMinHeightimpl, Constraints.m783getMaxHeightimpl(j)));
    }

    public final int calculateIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, ArrayList arrayList, int i, Function2 function2) {
        int iSubtractConstraintSafely;
        int i2;
        int i3;
        int i4;
        List list = (List) arrayList.get(0);
        List list2 = (List) arrayList.get(1);
        List list3 = (List) arrayList.get(2);
        List list4 = (List) arrayList.get(3);
        List list5 = (List) arrayList.get(4);
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list);
        if (measurable != null) {
            int iIntValue = ((Number) function2.invoke(measurable, Integer.valueOf(i))).intValue();
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(i, measurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            i2 = iIntValue;
        } else {
            iSubtractConstraintSafely = i;
            i2 = 0;
        }
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list2);
        if (measurable2 != null) {
            int iIntValue2 = ((Number) function2.invoke(measurable2, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(iSubtractConstraintSafely, measurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            i3 = iIntValue2;
        } else {
            i3 = 0;
        }
        Object obj = (Measurable) CollectionsKt.firstOrNull(list3);
        int iIntValue3 = obj != null ? ((Number) function2.invoke(obj, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        Object obj2 = (Measurable) CollectionsKt.firstOrNull(list4);
        int iIntValue4 = obj2 != null ? ((Number) function2.invoke(obj2, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        Object obj3 = (Measurable) CollectionsKt.firstOrNull(list5);
        int iIntValue5 = obj3 != null ? ((Number) function2.invoke(obj3, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        boolean z = iIntValue4 > intrinsicMeasureScope.mo74roundToPxR2X_6o(IntMath.getSp(30));
        boolean z2 = iIntValue3 > 0;
        boolean z3 = iIntValue4 > 0;
        if ((z2 && z3) || z) {
            i4 = 3;
        } else {
            i4 = (z2 || z3) ? 2 : 1;
        }
        return m292calculateHeightvnELnnM(intrinsicMeasureScope, i2, i3, iIntValue3, iIntValue4, iIntValue5, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), i4);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, (ArrayList) list, i, AnonymousClass1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return calculateIntrinsicWidth((ArrayList) list, i, C00311.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo121measure3p2s80s(MeasureScope measureScope, List list, long j) {
        int i;
        ArrayList arrayList = (ArrayList) list;
        List list2 = (List) arrayList.get(0);
        List list3 = (List) arrayList.get(1);
        List list4 = (List) arrayList.get(2);
        List list5 = (List) arrayList.get(3);
        List list6 = (List) arrayList.get(4);
        long jM777copyZbe2FdA$default = Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 10, j);
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list2);
        Placeable placeableMo598measureBRTryo0 = measurable != null ? measurable.mo598measureBRTryo0(jM777copyZbe2FdA$default) : null;
        int i2 = placeableMo598measureBRTryo0 != null ? placeableMo598measureBRTryo0.width : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list3);
        Placeable placeableMo598measureBRTryo1 = measurable2 != null ? measurable2.mo598measureBRTryo0(ConstraintsKt.m794offsetNN6EwU$default(-i2, 0, 2, jM777copyZbe2FdA$default)) : null;
        int i3 = i2 + (placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.width : 0);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list4);
        Placeable placeableMo598measureBRTryo2 = measurable3 != null ? measurable3.mo598measureBRTryo0(ConstraintsKt.m794offsetNN6EwU$default(-i3, 0, 2, jM777copyZbe2FdA$default)) : null;
        int i4 = placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.height : 0;
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list6);
        Placeable placeableMo598measureBRTryo3 = measurable4 != null ? measurable4.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(-i3, -i4, jM777copyZbe2FdA$default)) : null;
        int i5 = i4 + (placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.height : 0);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list5);
        final Placeable placeableMo598measureBRTryo4 = measurable5 != null ? measurable5.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(-i3, -i5, jM777copyZbe2FdA$default)) : null;
        boolean z = (placeableMo598measureBRTryo4 == null || placeableMo598measureBRTryo4.get(AlignmentLineKt.FirstBaseline) == placeableMo598measureBRTryo4.get(AlignmentLineKt.LastBaseline)) ? false : true;
        boolean z2 = placeableMo598measureBRTryo2 != null;
        boolean z3 = placeableMo598measureBRTryo4 != null;
        if ((z2 && z3) || z) {
            i = 3;
        } else {
            i = (z2 || z3) ? 2 : 1;
        }
        int iM784getMaxWidthimpl = Constraints.m780getHasBoundedWidthimpl(j) ? Constraints.m784getMaxWidthimpl(j) : Math.max(placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.width : 0, Math.max(placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.width : 0, placeableMo598measureBRTryo4 != null ? placeableMo598measureBRTryo4.width : 0)) + (placeableMo598measureBRTryo0 != null ? placeableMo598measureBRTryo0.width : 0) + (placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.width : 0);
        final int iM292calculateHeightvnELnnM = m292calculateHeightvnELnnM(measureScope, placeableMo598measureBRTryo0 != null ? placeableMo598measureBRTryo0.height : 0, placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.height : 0, placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.height : 0, placeableMo598measureBRTryo4 != null ? placeableMo598measureBRTryo4.height : 0, placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.height : 0, j, i);
        final Placeable placeable = placeableMo598measureBRTryo3;
        final Placeable placeable2 = placeableMo598measureBRTryo0;
        final int i6 = iM784getMaxWidthimpl;
        final Placeable placeable3 = placeableMo598measureBRTryo1;
        final Placeable placeable4 = placeableMo598measureBRTryo2;
        return measureScope.layout(iM784getMaxWidthimpl, iM292calculateHeightvnELnnM, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.InteractiveListItemMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Alignment.Vertical vertical = this.verticalAlignment;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                Placeable placeable5 = placeable2;
                int i7 = iM292calculateHeightvnELnnM;
                if (placeable5 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, 0, vertical.align(placeable5.height, i7));
                }
                int i8 = placeable5 != null ? placeable5.width : 0;
                Placeable placeable6 = placeable;
                int i9 = placeable6 != null ? placeable6.height : 0;
                Placeable placeable7 = placeable4;
                int i10 = i9 + (placeable7 != null ? placeable7.height : 0);
                Placeable placeable8 = placeableMo598measureBRTryo4;
                int iAlign = vertical.align(i10 + (placeable8 != null ? placeable8.height : 0), i7);
                if (placeable7 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, i8, iAlign);
                }
                int i11 = iAlign + (placeable7 != null ? placeable7.height : 0);
                if (placeable6 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, i8, i11);
                }
                int i12 = i11 + (placeable6 != null ? placeable6.height : 0);
                if (placeable8 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, i8, i12);
                }
                Placeable placeable9 = placeable3;
                if (placeable9 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, i6 - placeable9.width, vertical.align(placeable9.height, i7));
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, (ArrayList) list, i, C00321.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return calculateIntrinsicWidth((ArrayList) list, i, C00331.INSTANCE);
    }
}
