package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import coil3.util.FileSystemsKt;
import com.google.protobuf.ArrayDecoders$Registers;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowMeasurePolicy implements MultiContentMeasurePolicy, RowColumnMeasurePolicy {
    public final CrossAxisAlignment$VerticalCrossAxisAlignment crossAxisAlignment;
    public final float crossAxisArrangementSpacing;
    public final Arrangement$Horizontal horizontalArrangement;
    public final float mainAxisSpacing;
    public final FlowLayoutOverflowState overflow;
    public final Arrangement$Vertical verticalArrangement;

    public FlowMeasurePolicy(Arrangement$Horizontal arrangement$Horizontal, Arrangement$Vertical arrangement$Vertical, float f, CrossAxisAlignment$VerticalCrossAxisAlignment crossAxisAlignment$VerticalCrossAxisAlignment, float f2, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.horizontalArrangement = arrangement$Horizontal;
        this.verticalArrangement = arrangement$Vertical;
        this.mainAxisSpacing = f;
        this.crossAxisAlignment = crossAxisAlignment$VerticalCrossAxisAlignment;
        this.crossAxisArrangementSpacing = f2;
        this.overflow = flowLayoutOverflowState;
    }

    public static int intrinsicCrossAxisSize(List list, int i, int i2, int i3, FlowLayoutOverflowState flowLayoutOverflowState) {
        long jM1constructorimpl = IntIntPair.m1constructorimpl(0, 0);
        if (!list.isEmpty()) {
            int i4 = Integer.MAX_VALUE;
            ArrayDecoders$Registers arrayDecoders$Registers = new ArrayDecoders$Registers(flowLayoutOverflowState, ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), i2, i3);
            Measurable measurable = (Measurable) CollectionsKt.getOrNull(0, list);
            int iMinIntrinsicHeight = measurable != null ? measurable.minIntrinsicHeight(i) : 0;
            int iMinIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(iMinIntrinsicHeight) : 0;
            boolean z = true;
            if (list.size() <= 1) {
                z = false;
            }
            int i5 = 0;
            if (arrayDecoders$Registers.m913getWrapInfoOpUlnko(z, 0, IntIntPair.m1constructorimpl(i, Integer.MAX_VALUE), measurable == null ? null : new IntIntPair(IntIntPair.m1constructorimpl(iMinIntrinsicWidth, iMinIntrinsicHeight)), 0, 0, 0, false, false).isLastItemInContainer) {
                flowLayoutOverflowState.getClass();
                jM1constructorimpl = jM1constructorimpl;
            } else {
                int size = list.size();
                int i6 = i;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i9 < size) {
                    int i12 = i6 - iMinIntrinsicWidth;
                    i9++;
                    int iMax = Math.max(i8, iMinIntrinsicHeight);
                    Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(i9, list);
                    iMinIntrinsicHeight = measurable2 != null ? measurable2.minIntrinsicHeight(i) : 0;
                    int iMinIntrinsicWidth2 = measurable2 != null ? measurable2.minIntrinsicWidth(iMinIntrinsicHeight) + i2 : 0;
                    int i13 = i9 - i11;
                    int i14 = i7;
                    int i15 = iMinIntrinsicWidth2;
                    FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko = arrayDecoders$Registers.m913getWrapInfoOpUlnko(i9 + 2 < list.size() ? z : false, i13, IntIntPair.m1constructorimpl(i12, i4), measurable2 == null ? null : new IntIntPair(IntIntPair.m1constructorimpl(iMinIntrinsicWidth2, iMinIntrinsicHeight)), i14, i5, iMax, false, false);
                    if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko.isLastItemInLine) {
                        int i16 = iMax + i3 + i5;
                        arrayDecoders$Registers.getWrapEllipsisInfo(flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko, measurable2 != null, i14, i16, i12, i13);
                        int i17 = i15 - i2;
                        i7 = i14 + 1;
                        if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko.isLastItemInContainer) {
                            i10 = i9;
                            i5 = i16;
                            break;
                        }
                        i6 = i;
                        i11 = i9;
                        iMinIntrinsicWidth = i17;
                        i5 = i16;
                        i8 = 0;
                    } else {
                        iMinIntrinsicWidth = i15;
                        i6 = i12;
                        i7 = i14;
                        i8 = iMax;
                    }
                    i10 = i9;
                    i4 = Integer.MAX_VALUE;
                    z = true;
                }
                jM1constructorimpl = IntIntPair.m1constructorimpl(i5 - i3, i10);
            }
        }
        return (int) (jM1constructorimpl >> 32);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* JADX INFO: renamed from: createConstraints-xF2OJ5Q */
    public final long mo119createConstraintsxF2OJ5Q(int i, int i2, int i3, boolean z) {
        RowMeasurePolicy rowMeasurePolicy = RowKt.DefaultRowMeasurePolicy;
        return !z ? ConstraintsKt.Constraints(i, i2, 0, i3) : FileSystemsKt.m880fitPrioritizingWidthZbe2FdA(i, i2, 0, i3);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int crossAxisSize(Placeable placeable) {
        return placeable.getMeasuredHeight();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) obj;
        return this.horizontalArrangement.equals(flowMeasurePolicy.horizontalArrangement) && this.verticalArrangement.equals(flowMeasurePolicy.verticalArrangement) && Dp.m796equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && this.crossAxisAlignment.equals(flowMeasurePolicy.crossAxisAlignment) && Dp.m796equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && Intrinsics.areEqual(this.overflow, flowMeasurePolicy.overflow);
    }

    public final int hashCode() {
        return this.overflow.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Integer.MAX_VALUE, IntIntPair$$ExternalSyntheticOutline0.m(Integer.MAX_VALUE, IntIntPair$$ExternalSyntheticOutline0.m(this.crossAxisArrangementSpacing, IntIntPair$$ExternalSyntheticOutline0.m(-1.0f, IntIntPair$$ExternalSyntheticOutline0.m(this.mainAxisSpacing, (this.verticalArrangement.hashCode() + ((this.horizontalArrangement.hashCode() + (Boolean.hashCode(true) * 31)) * 31)) * 31, 31), 31), 31), 31), 31);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final int mainAxisSize(Placeable placeable) {
        return placeable.getMeasuredWidth();
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        List list2 = (List) CollectionsKt.getOrNull(1, list);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, list);
        Measurable measurable2 = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13);
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        flowLayoutOverflowState.m120setOverflowMeasurableshBUhpc$foundation_layout(measurable, measurable2, jConstraints$default);
        List list4 = (List) CollectionsKt.firstOrNull(list);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo75roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo75roundToPx0680j_4(this.crossAxisArrangementSpacing), flowLayoutOverflowState);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        List list2 = (List) CollectionsKt.getOrNull(1, list);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, list);
        this.overflow.m120setOverflowMeasurableshBUhpc$foundation_layout(measurable, list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null, ConstraintsKt.Constraints$default(0, 0, 0, i, 7));
        List list4 = (List) CollectionsKt.firstOrNull(list);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.mainAxisSpacing);
        int size = list4.size();
        int i2 = 0;
        int iMax = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int iMaxIntrinsicWidth = ((Measurable) list4.get(i2)).maxIntrinsicWidth(i) + iMo75roundToPx0680j_4;
            int i5 = i2 + 1;
            if (i5 - i3 == Integer.MAX_VALUE || i5 == list4.size()) {
                iMax = Math.max(iMax, (i4 + iMaxIntrinsicWidth) - iMo75roundToPx0680j_4);
                i3 = i2;
                i4 = 0;
            } else {
                i4 += iMaxIntrinsicWidth;
            }
            i2 = i5;
        }
        return iMax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult mo121measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Measurable measurable;
        Placeable placeable;
        IntIntPair intIntPair;
        FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfo;
        int i;
        char c;
        Measurable measurable2;
        Placeable placeable2;
        IntIntPair intIntPair2;
        IntIntPair intIntPair3;
        FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfo2;
        long jM1constructorimpl;
        long jM1constructorimpl2;
        Placeable placeableMo598measureBRTryo0;
        boolean zIsEmpty = ((ArrayList) list).isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (!zIsEmpty) {
            int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
            FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
            if (iM783getMaxHeightimpl != 0) {
                List list2 = (List) CollectionsKt.first(list);
                if (list2.isEmpty()) {
                    return measureScope.layout(0, 0, emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 5));
                }
                List list3 = (List) CollectionsKt.getOrNull(1, list);
                Measurable measurable3 = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
                List list4 = (List) CollectionsKt.getOrNull(2, list);
                Measurable measurable4 = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
                list2.size();
                flowLayoutOverflowState.getClass();
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                long jM130constructorimpl = OffsetKt.m130constructorimpl(j, layoutOrientation);
                long jM142toBoxConstraintsOenEA2s = OffsetKt.m142toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(0, Constraints.m784getMaxWidthimpl(jM130constructorimpl), (10 & 4) != 0 ? Constraints.m785getMinHeightimpl(jM130constructorimpl) : 0, Constraints.m783getMaxHeightimpl(jM130constructorimpl)));
                if (measurable3 != null) {
                    if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable3)) == CropImageView.DEFAULT_ASPECT_RATIO) {
                        OffsetKt.getRowColumnParentData(measurable3);
                        Placeable placeableMo598measureBRTryo1 = measurable3.mo598measureBRTryo0(jM142toBoxConstraintsOenEA2s);
                        placeableMo598measureBRTryo1.getMeasuredWidth();
                        placeableMo598measureBRTryo1.getMeasuredHeight();
                        placeableMo598measureBRTryo1.getMeasuredWidth();
                        placeableMo598measureBRTryo1.getMeasuredHeight();
                    } else {
                        measurable3.minIntrinsicHeight(measurable3.minIntrinsicWidth(Integer.MAX_VALUE));
                    }
                }
                if (measurable4 != null) {
                    if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable4)) == CropImageView.DEFAULT_ASPECT_RATIO) {
                        OffsetKt.getRowColumnParentData(measurable4);
                        Placeable placeableMo598measureBRTryo2 = measurable4.mo598measureBRTryo0(jM142toBoxConstraintsOenEA2s);
                        placeableMo598measureBRTryo2.getMeasuredWidth();
                        placeableMo598measureBRTryo2.getMeasuredHeight();
                        placeableMo598measureBRTryo2.getMeasuredWidth();
                        placeableMo598measureBRTryo2.getMeasuredHeight();
                    } else {
                        measurable4.minIntrinsicHeight(measurable4.minIntrinsicWidth(Integer.MAX_VALUE));
                    }
                }
                Iterator it = list2.iterator();
                long jM130constructorimpl2 = OffsetKt.m130constructorimpl(j, layoutOrientation);
                MutableVector mutableVector = new MutableVector(new MeasureResult[16]);
                int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(jM130constructorimpl2);
                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(jM130constructorimpl2);
                int iM783getMaxHeightimpl2 = Constraints.m783getMaxHeightimpl(jM130constructorimpl2);
                MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
                MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap();
                ArrayList arrayList = new ArrayList();
                int iCeil = (int) Math.ceil(measureScope.mo81toPx0680j_4(this.mainAxisSpacing));
                int iCeil2 = (int) Math.ceil(measureScope.mo81toPx0680j_4(this.crossAxisArrangementSpacing));
                long jConstraints = ConstraintsKt.Constraints(0, iM784getMaxWidthimpl, 0, iM783getMaxHeightimpl2);
                long jM142toBoxConstraintsOenEA2s2 = OffsetKt.m142toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(0, Constraints.m784getMaxWidthimpl(jConstraints), (10 & 4) != 0 ? Constraints.m785getMinHeightimpl(jConstraints) : 0, Constraints.m783getMaxHeightimpl(jConstraints)));
                if (it.hasNext()) {
                    try {
                        measurable = (Measurable) it.next();
                    } catch (IndexOutOfBoundsException unused) {
                        measurable = null;
                    }
                } else {
                    measurable = null;
                }
                if (measurable != null) {
                    if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable)) == CropImageView.DEFAULT_ASPECT_RATIO) {
                        OffsetKt.getRowColumnParentData(measurable);
                        placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(jM142toBoxConstraintsOenEA2s2);
                        jM1constructorimpl2 = IntIntPair.m1constructorimpl(placeableMo598measureBRTryo0.getMeasuredWidth(), placeableMo598measureBRTryo0.getMeasuredHeight());
                    } else {
                        int iMinIntrinsicWidth = measurable.minIntrinsicWidth(Integer.MAX_VALUE);
                        Measurable measurable5 = measurable;
                        jM1constructorimpl2 = IntIntPair.m1constructorimpl(iMinIntrinsicWidth, measurable5.minIntrinsicHeight(iMinIntrinsicWidth));
                        measurable = measurable5;
                        placeableMo598measureBRTryo0 = null;
                    }
                    intIntPair = new IntIntPair(jM1constructorimpl2);
                    placeable = placeableMo598measureBRTryo0;
                } else {
                    it = it;
                    placeable = null;
                    intIntPair = null;
                }
                Placeable placeable3 = placeable;
                Integer numValueOf = intIntPair != null ? Integer.valueOf((int) (intIntPair.packedValue >> 32)) : null;
                Integer numValueOf2 = intIntPair != null ? Integer.valueOf((int) (intIntPair.packedValue & 4294967295L)) : null;
                int[] iArr = new int[16];
                int[] iArr2 = new int[16];
                MutableIntSet mutableIntSet = new MutableIntSet();
                Integer num = numValueOf2;
                FlowLayoutOverflowState flowLayoutOverflowState2 = this.overflow;
                ArrayDecoders$Registers arrayDecoders$Registers = new ArrayDecoders$Registers(flowLayoutOverflowState2, jM130constructorimpl2, iCeil, iCeil2);
                IntIntPair intIntPair4 = intIntPair;
                FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko = arrayDecoders$Registers.m913getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m1constructorimpl(iM784getMaxWidthimpl, iM783getMaxHeightimpl2), intIntPair4, 0, 0, 0, false, false);
                if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko.isLastItemInContainer) {
                    flowLayoutBuildingBlocks$WrapInfo = flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko;
                    arrayDecoders$Registers.getWrapEllipsisInfo(flowLayoutBuildingBlocks$WrapInfo, intIntPair4 != null, -1, 0, iM784getMaxWidthimpl, 0);
                } else {
                    flowLayoutBuildingBlocks$WrapInfo = flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko;
                }
                Measurable measurable6 = measurable;
                FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfo3 = flowLayoutBuildingBlocks$WrapInfo;
                int[] iArrCopyOf = iArr2;
                int[] iArrCopyOf2 = iArr;
                int i2 = iM783getMaxHeightimpl2;
                int i3 = iM784getMaxWidthimpl;
                Integer numValueOf3 = numValueOf;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (!flowLayoutBuildingBlocks$WrapInfo3.isLastItemInContainer && measurable6 != null) {
                    numValueOf3.getClass();
                    int iIntValue = numValueOf3.intValue();
                    num.getClass();
                    int iIntValue2 = num.intValue();
                    long j2 = jConstraints;
                    int i12 = i8 + iIntValue;
                    int iMax = Math.max(i4, iIntValue2);
                    int i13 = i3 - iIntValue;
                    int i14 = i5 + 1;
                    flowLayoutOverflowState2.getClass();
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(measurable6);
                    mutableIntObjectMap2.set(i5, placeable3);
                    measurable6.getParentData();
                    int i15 = i14 - i9;
                    if (it.hasNext()) {
                        try {
                            measurable2 = (Measurable) it.next();
                        } catch (IndexOutOfBoundsException unused2) {
                            measurable2 = null;
                        }
                    } else {
                        measurable2 = null;
                    }
                    if (measurable2 != null) {
                        if (OffsetKt.getWeight(OffsetKt.getRowColumnParentData(measurable2)) == CropImageView.DEFAULT_ASPECT_RATIO) {
                            OffsetKt.getRowColumnParentData(measurable2);
                            Placeable placeableMo598measureBRTryo3 = measurable2.mo598measureBRTryo0(jM142toBoxConstraintsOenEA2s2);
                            jM1constructorimpl = IntIntPair.m1constructorimpl(placeableMo598measureBRTryo3.getMeasuredWidth(), placeableMo598measureBRTryo3.getMeasuredHeight());
                            placeable2 = placeableMo598measureBRTryo3;
                        } else {
                            int iMinIntrinsicWidth2 = measurable2.minIntrinsicWidth(Integer.MAX_VALUE);
                            long jM1constructorimpl3 = IntIntPair.m1constructorimpl(iMinIntrinsicWidth2, measurable2.minIntrinsicHeight(iMinIntrinsicWidth2));
                            placeable2 = null;
                            jM1constructorimpl = jM1constructorimpl3;
                        }
                        intIntPair2 = new IntIntPair(jM1constructorimpl);
                    } else {
                        arrayList2 = arrayList2;
                        i14 = i14;
                        iM786getMinWidthimpl = iM786getMinWidthimpl;
                        placeable2 = null;
                        intIntPair2 = null;
                    }
                    numValueOf3 = intIntPair2 != null ? Integer.valueOf(((int) (intIntPair2.packedValue >> 32)) + iCeil) : null;
                    Integer numValueOf4 = intIntPair2 != null ? Integer.valueOf((int) (intIntPair2.packedValue & 4294967295L)) : null;
                    boolean zHasNext = it.hasNext();
                    int i16 = i10;
                    long jM1constructorimpl4 = IntIntPair.m1constructorimpl(i13, i2);
                    if (intIntPair2 == null) {
                        intIntPair3 = null;
                    } else {
                        numValueOf3.getClass();
                        int iIntValue3 = numValueOf3.intValue();
                        numValueOf4.getClass();
                        intIntPair3 = new IntIntPair(IntIntPair.m1constructorimpl(iIntValue3, numValueOf4.intValue()));
                    }
                    FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko2 = arrayDecoders$Registers.m913getWrapInfoOpUlnko(zHasNext, i15, jM1constructorimpl4, intIntPair3, i16, i11, iMax, false, false);
                    if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko2.isLastItemInLine) {
                        int iMin = Math.min(Math.max(iM786getMinWidthimpl, i12), iM784getMaxWidthimpl);
                        int i17 = i11 + iMax;
                        flowLayoutBuildingBlocks$WrapInfo2 = flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko2;
                        arrayDecoders$Registers.getWrapEllipsisInfo(flowLayoutBuildingBlocks$WrapInfo2, intIntPair2 != null, i16, i17, i13, i15);
                        int i18 = i6 + 1;
                        if (iArrCopyOf.length < i18) {
                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i18, (iArrCopyOf.length * 3) / 2));
                        }
                        iArrCopyOf[i6] = iMax;
                        i6++;
                        i2 = (i2 - i17) - iCeil2;
                        int i19 = i7 + 1;
                        if (iArrCopyOf2.length < i19) {
                            iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, Math.max(i19, (iArrCopyOf2.length * 3) / 2));
                        }
                        iArrCopyOf2[i7] = i14;
                        i7++;
                        i10 = i16 + 1;
                        i11 = i17 + iCeil2;
                        i9 = i14;
                        numValueOf3 = numValueOf3 != null ? Integer.valueOf(numValueOf3.intValue() - iCeil) : null;
                        iM786getMinWidthimpl = iMin;
                        i13 = iM784getMaxWidthimpl;
                        i4 = 0;
                        i12 = 0;
                    } else {
                        flowLayoutBuildingBlocks$WrapInfo2 = flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko2;
                        i10 = i16;
                        i4 = iMax;
                    }
                    measurable6 = measurable2;
                    i3 = i13;
                    flowLayoutBuildingBlocks$WrapInfo3 = flowLayoutBuildingBlocks$WrapInfo2;
                    iM786getMinWidthimpl = iM786getMinWidthimpl;
                    placeable3 = placeable2;
                    i5 = i14;
                    arrayList = arrayList2;
                    i8 = i12;
                    num = numValueOf4;
                    jConstraints = j2;
                }
                ArrayList arrayList3 = arrayList;
                long j3 = jConstraints;
                int i20 = iM786getMinWidthimpl;
                int size = arrayList3.size();
                Placeable[] placeableArr = new Placeable[size];
                for (int i21 = 0; i21 < size; i21++) {
                    placeableArr[i21] = mutableIntObjectMap2.get(i21);
                }
                int[] iArr3 = new int[i7];
                int[] iArr4 = new int[i7];
                final MeasureScope measureScope2 = measureScope;
                MeasureScope measureScope3 = new MeasureScope() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$subMeasureScope$1
                    @Override // androidx.compose.ui.unit.Density
                    public final float getDensity() {
                        return measureScope2.getDensity();
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public final float getFontScale() {
                        return measureScope2.getFontScale();
                    }

                    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
                    public final LayoutDirection getLayoutDirection() {
                        return measureScope2.getLayoutDirection();
                    }
                };
                int iMax2 = i20;
                int[] iArr5 = iArrCopyOf2;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                while (i23 < i7) {
                    int i25 = iArr5[i23];
                    if (i23 < 0 || i23 >= i6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                        return null;
                    }
                    int iM783getMaxHeightimpl3 = iArrCopyOf[i23];
                    if (mutableIntSet.contains(i23)) {
                        c = 65535;
                    } else {
                        c = 65535;
                        iM783getMaxHeightimpl3 = Constraints.m783getMaxHeightimpl(j3) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Constraints.m783getMaxHeightimpl(j3) - i24;
                    }
                    int[] iArr6 = iArr5;
                    ArrayList arrayList4 = arrayList3;
                    int i26 = i6;
                    MeasureScope measureScope4 = measureScope3;
                    int i27 = iMax2;
                    MeasureResult measureResultMeasure = OffsetKt.measure(this, i27, Constraints.m785getMinHeightimpl(j3), Constraints.m784getMaxWidthimpl(j3), iM783getMaxHeightimpl3, iCeil, measureScope4, arrayList4, placeableArr, i22, i25, iArr3, i23);
                    int width = measureResultMeasure.getWidth();
                    int height = measureResultMeasure.getHeight();
                    iArr4[i23] = height;
                    i24 += height;
                    iMax2 = Math.max(i27, width);
                    mutableVector.add(measureResultMeasure);
                    i23++;
                    measureScope3 = measureScope4;
                    i22 = i25;
                    measureScope2 = measureScope;
                    iArr5 = iArr6;
                    i6 = i26;
                    iArrCopyOf = iArrCopyOf;
                    i7 = i7;
                    mutableIntSet = mutableIntSet;
                    arrayList3 = arrayList4;
                }
                MeasureScope measureScope5 = measureScope2;
                int i28 = iMax2;
                if (mutableVector.size == 0) {
                    i28 = 0;
                    i = 0;
                } else {
                    i = i24;
                }
                Arrangement$Vertical arrangement$Vertical = this.verticalArrangement;
                int iMo75roundToPx0680j_4 = ((mutableVector.size - 1) * measureScope5.mo75roundToPx0680j_4(arrangement$Vertical.mo112getSpacingD9Ej5fM())) + i;
                int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(jM130constructorimpl2);
                int iM783getMaxHeightimpl4 = Constraints.m783getMaxHeightimpl(jM130constructorimpl2);
                if (iMo75roundToPx0680j_4 < iM785getMinHeightimpl) {
                    iMo75roundToPx0680j_4 = iM785getMinHeightimpl;
                }
                if (iMo75roundToPx0680j_4 <= iM783getMaxHeightimpl4) {
                    iM783getMaxHeightimpl4 = iMo75roundToPx0680j_4;
                }
                arrangement$Vertical.arrange(measureScope5, iM783getMaxHeightimpl4, iArr4, iArr3);
                int iM786getMinWidthimpl2 = Constraints.m786getMinWidthimpl(jM130constructorimpl2);
                int iM784getMaxWidthimpl2 = Constraints.m784getMaxWidthimpl(jM130constructorimpl2);
                if (i28 < iM786getMinWidthimpl2) {
                    i28 = iM786getMinWidthimpl2;
                }
                if (i28 <= iM784getMaxWidthimpl2) {
                    iM784getMaxWidthimpl2 = i28;
                }
                return measureScope5.layout(iM784getMaxWidthimpl2, iM783getMaxHeightimpl4, emptyMap, new ScrollState$$ExternalSyntheticLambda0((byte) 12, mutableVector));
            }
            flowLayoutOverflowState.getClass();
        }
        return measureScope.layout(0, 0, emptyMap, new OffsetKt$$ExternalSyntheticLambda0((byte) 4));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        List list2 = (List) CollectionsKt.getOrNull(1, list);
        Measurable measurable = list2 != null ? (Measurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(2, list);
        Measurable measurable2 = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13);
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        flowLayoutOverflowState.m120setOverflowMeasurableshBUhpc$foundation_layout(measurable, measurable2, jConstraints$default);
        List list4 = (List) CollectionsKt.firstOrNull(list);
        if (list4 == null) {
            list4 = EmptyList.INSTANCE;
        }
        return intrinsicCrossAxisSize(list4, i, intrinsicMeasureScope.mo75roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo75roundToPx0680j_4(this.crossAxisArrangementSpacing), flowLayoutOverflowState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int[] iArr;
        FlowLayoutOverflowState flowLayoutOverflowState;
        List list2;
        long jM1constructorimpl;
        int i2;
        int i3 = i;
        int i4 = 1;
        List list3 = (List) CollectionsKt.getOrNull(1, list);
        Measurable measurable = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        char c = 2;
        List list4 = (List) CollectionsKt.getOrNull(2, list);
        int i5 = 0;
        this.overflow.m120setOverflowMeasurableshBUhpc$foundation_layout(measurable, list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null, ConstraintsKt.Constraints$default(0, 0, 0, i3, 7));
        List list5 = (List) CollectionsKt.firstOrNull(list);
        if (list5 == null) {
            list5 = EmptyList.INSTANCE;
        }
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.mainAxisSpacing);
        int iMo75roundToPx0680j_5 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.crossAxisArrangementSpacing);
        long jM1constructorimpl2 = IntIntPair.m1constructorimpl(0, 0);
        if (list5.isEmpty()) {
            return 0;
        }
        int size = list5.size();
        int[] iArr2 = new int[size];
        int size2 = list5.size();
        int[] iArr3 = new int[size2];
        int size3 = list5.size();
        int i6 = 0;
        while (i6 < size3) {
            Measurable measurable2 = (Measurable) list5.get(i6);
            char c2 = c;
            int iMinIntrinsicWidth = measurable2.minIntrinsicWidth(i3);
            iArr2[i6] = iMinIntrinsicWidth;
            iArr3[i6] = measurable2.minIntrinsicHeight(iMinIntrinsicWidth);
            i6++;
            c = c2;
        }
        int size4 = list5.size();
        FlowLayoutOverflowState flowLayoutOverflowState2 = this.overflow;
        if (Integer.MAX_VALUE < size4) {
            flowLayoutOverflowState2.getClass();
        }
        if (Integer.MAX_VALUE >= list5.size()) {
            flowLayoutOverflowState2.getClass();
        }
        int iMin = Math.min(Integer.MAX_VALUE, list5.size());
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += iArr2[i8];
        }
        int size5 = ((list5.size() - 1) * iMo75roundToPx0680j_4) + i7;
        if (size2 == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return 0;
        }
        int i9 = iArr3[0];
        int i10 = size2 - 1;
        if (1 <= i10) {
            int i11 = 1;
            while (true) {
                int i12 = iArr3[i11];
                if (i9 < i12) {
                    i9 = i12;
                }
                if (i11 == i10) {
                    break;
                }
                i11++;
            }
        }
        if (size == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1();
            return 0;
        }
        int i13 = iArr2[i5];
        int i14 = size - 1;
        if (1 <= i14) {
            int i15 = 1;
            while (true) {
                int i16 = iArr2[i15];
                if (i13 < i16) {
                    i13 = i16;
                }
                if (i15 == i14) {
                    break;
                }
                i15++;
            }
        }
        int i17 = size5;
        while (i13 <= i17 && i9 != i3) {
            int i18 = (i13 + i17) / 2;
            if (list5.isEmpty()) {
                list2 = list5;
                iArr2 = iArr2;
                jM1constructorimpl = jM1constructorimpl2;
                iArr = iArr3;
                flowLayoutOverflowState = flowLayoutOverflowState2;
            } else {
                int i19 = i5;
                iArr = iArr3;
                flowLayoutOverflowState = flowLayoutOverflowState2;
                ArrayDecoders$Registers arrayDecoders$Registers = new ArrayDecoders$Registers(flowLayoutOverflowState, ConstraintsKt.Constraints(i19, i18, i19, Integer.MAX_VALUE), iMo75roundToPx0680j_4, iMo75roundToPx0680j_5);
                Measurable measurable3 = (Measurable) CollectionsKt.getOrNull(i19, list5);
                int i20 = measurable3 != null ? iArr[i19] : i19;
                int i21 = measurable3 != null ? iArr2[i19] : 0;
                int i22 = 0;
                if (arrayDecoders$Registers.m913getWrapInfoOpUlnko(list5.size() > i4 ? i4 : 0, 0, IntIntPair.m1constructorimpl(i18, Integer.MAX_VALUE), measurable3 == null ? null : new IntIntPair(IntIntPair.m1constructorimpl(i21, i20)), 0, 0, 0, false, false).isLastItemInContainer) {
                    flowLayoutOverflowState.getClass();
                    list2 = list5;
                    jM1constructorimpl = jM1constructorimpl2;
                } else {
                    int size6 = list5.size();
                    int i23 = i18;
                    int i24 = i21;
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = 0;
                    int i29 = i20;
                    int i30 = 0;
                    while (true) {
                        if (i28 >= size6) {
                            list2 = list5;
                            break;
                        }
                        int i31 = i23 - i24;
                        int i32 = size6;
                        int i33 = i28 + 1;
                        int iMax = Math.max(i26, i29);
                        Measurable measurable4 = (Measurable) CollectionsKt.getOrNull(i33, list5);
                        i29 = measurable4 != null ? iArr[i33] : 0;
                        int i34 = measurable4 != null ? iArr2[i33] + iMo75roundToPx0680j_4 : 0;
                        list2 = list5;
                        int i35 = i33 - i27;
                        int i36 = i25;
                        FlowLayoutBuildingBlocks$WrapInfo flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko = arrayDecoders$Registers.m913getWrapInfoOpUlnko(i28 + 2 < list2.size(), i35, IntIntPair.m1constructorimpl(i31, Integer.MAX_VALUE), measurable4 == null ? null : new IntIntPair(IntIntPair.m1constructorimpl(i34, i29)), i36, i22, iMax, false, false);
                        if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko.isLastItemInLine) {
                            int i37 = iMax + iMo75roundToPx0680j_5 + i22;
                            arrayDecoders$Registers.getWrapEllipsisInfo(flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko, measurable4 != null, i36, i37, i31, i35);
                            int i38 = i34 - iMo75roundToPx0680j_4;
                            i25 = i36 + 1;
                            if (flowLayoutBuildingBlocks$WrapInfoM913getWrapInfoOpUlnko.isLastItemInContainer) {
                                i22 = i37;
                                i30 = i33;
                                break;
                            }
                            i24 = i38;
                            i23 = i18;
                            i22 = i37;
                            i2 = i33;
                            i26 = 0;
                        } else {
                            i24 = i34;
                            i23 = i31;
                            i25 = i36;
                            i26 = iMax;
                            i2 = i27;
                        }
                        i27 = i2;
                        size6 = i32;
                        i28 = i33;
                        i30 = i28;
                        list5 = list2;
                    }
                    jM1constructorimpl = IntIntPair.m1constructorimpl(i22 - iMo75roundToPx0680j_5, i30);
                }
            }
            i9 = (int) (jM1constructorimpl >> 32);
            int i39 = (int) (jM1constructorimpl & 4294967295L);
            i3 = i;
            if (i9 > i3 || i39 < iMin) {
                i13 = i18 + 1;
                if (i13 > i17) {
                    return i13;
                }
            } else {
                if (i9 >= i3) {
                    return i18;
                }
                i17 = i18 - 1;
            }
            size5 = i18;
            iArr2 = iArr2;
            flowLayoutOverflowState2 = flowLayoutOverflowState;
            iArr3 = iArr;
            list5 = list2;
            i4 = 1;
            i5 = 0;
        }
        return size5;
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final MeasureResult placeHelper(final Placeable[] placeableArr, MeasureScope measureScope, final int[] iArr, int i, final int i2, final int[] iArr2, final int i3, final int i4, final int i5) {
        final LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return measureScope.layout(i, i2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.layout.FlowLineMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                OffsetKt offsetKt;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int[] iArr3 = iArr2;
                int i6 = iArr3 != null ? iArr3[i3] : 0;
                int i7 = i4;
                for (int i8 = i7; i8 < i5; i8++) {
                    Placeable placeable = placeableArr[i8];
                    placeable.getClass();
                    Object parentData = placeable.getParentData();
                    RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
                    if (rowColumnParentData == null || (offsetKt = rowColumnParentData.crossAxisAlignment) == null) {
                        offsetKt = this.crossAxisAlignment;
                    }
                    placementScope.place(placeable, iArr[i8 - i7], offsetKt.align$foundation_layout(i2, placeable.getMeasuredHeight(), layoutDirection) + i6, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public final void populateMainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.horizontalArrangement.arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
    }

    public final String toString() {
        return "FlowMeasurePolicy(isHorizontal=true, horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + Dp.m797toStringimpl(this.mainAxisSpacing) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.m797toStringimpl(this.crossAxisArrangementSpacing) + ", maxItemsInMainAxis=2147483647, maxLines=2147483647, overflow=" + this.overflow + ")";
    }
}
