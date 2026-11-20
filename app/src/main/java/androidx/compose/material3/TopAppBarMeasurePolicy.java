package androidx.compose.material3;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarMeasurePolicy implements MeasurePolicy {
    public final PaddingValues contentPadding;
    public final float height;
    public final FloatProducer scrolledOffset;

    public TopAppBarMeasurePolicy(FloatProducer floatProducer, float f, PaddingValues paddingValues) {
        this.scrolledOffset = floatProducer;
        this.height = f;
        this.contentPadding = paddingValues;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.height);
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).maxIntrinsicHeight(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).maxIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        return Math.max(iMo75roundToPx0680j_4, numValueOf != null ? numValueOf.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int size = list.size();
        int iMaxIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMaxIntrinsicWidth += ((Measurable) list.get(i2)).maxIntrinsicWidth(i);
        }
        return iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, final long j) {
        int iM784getMaxWidthimpl;
        int i;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = (Measurable) list.get(i2);
            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable), "navigationIcon")) {
                final Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 14, j));
                int size2 = list.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = (Measurable) list.get(i3);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable2), "actionIcons")) {
                        final Placeable placeableMo598measureBRTryo1 = measurable2.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 14, j));
                        LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                        PaddingValues paddingValues = this.contentPadding;
                        float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues, layoutDirection);
                        float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues, measureScope.getLayoutDirection());
                        int iMax = Math.max(measureScope.mo75roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeableMo598measureBRTryo0.width);
                        if (Constraints.m784getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
                        } else {
                            int iM784getMaxWidthimpl2 = (((Constraints.m784getMaxWidthimpl(j) - iMax) - placeableMo598measureBRTryo1.width) - measureScope.mo75roundToPx0680j_4(fCalculateStartPadding)) - measureScope.mo75roundToPx0680j_4(fCalculateEndPadding);
                            iM784getMaxWidthimpl = iM784getMaxWidthimpl2 < 0 ? 0 : iM784getMaxWidthimpl2;
                        }
                        int i4 = iM784getMaxWidthimpl;
                        int size3 = list.size();
                        int i5 = 0;
                        while (i5 < size3) {
                            Measurable measurable3 = (Measurable) list.get(i5);
                            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable3), LinkHeader.Parameters.Title)) {
                                final Placeable placeableMo598measureBRTryo2 = measurable3.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, i4, 0, 0, 12, j));
                                HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.LastBaseline;
                                final int i6 = placeableMo598measureBRTryo2.get(horizontalAlignmentLine) != Integer.MIN_VALUE ? placeableMo598measureBRTryo2.get(horizontalAlignmentLine) : 0;
                                float fInvoke = this.scrolledOffset.invoke();
                                int iRoundToInt = Float.isNaN(fInvoke) ? 0 : MathKt.roundToInt(fInvoke);
                                final int iMax2 = Math.max(measureScope.mo75roundToPx0680j_4(this.height), placeableMo598measureBRTryo2.height) + measureScope.mo75roundToPx0680j_4(paddingValues.mo125calculateTopPaddingD9Ej5fM()) + measureScope.mo75roundToPx0680j_4(paddingValues.mo122calculateBottomPaddingD9Ej5fM());
                                if (Constraints.m783getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                                    i = iMax2;
                                } else {
                                    int i7 = iRoundToInt + iMax2;
                                    i = i7 >= 0 ? i7 : 0;
                                }
                                int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(paddingValues.mo125calculateTopPaddingD9Ej5fM());
                                int iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(paddingValues.mo122calculateBottomPaddingD9Ej5fM());
                                final int iMo75roundToPx0680j_6 = measureScope.mo75roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValues, measureScope.getLayoutDirection()));
                                final int iMo75roundToPx0680j_7 = measureScope.mo75roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValues, measureScope.getLayoutDirection()));
                                final int i8 = (iMo75roundToPx0680j_4 + i) - iMo75roundToPx0680j_5;
                                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), i, EmptyMap.INSTANCE, new Function1(iMo75roundToPx0680j_6, i8, placeableMo598measureBRTryo2, placeableMo598measureBRTryo1, j, iMo75roundToPx0680j_7, this, i6, iMax2) { // from class: androidx.compose.material3.TopAppBarMeasurePolicy$$ExternalSyntheticLambda0
                                    public final /* synthetic */ int f$1;
                                    public final /* synthetic */ int f$2;
                                    public final /* synthetic */ Placeable f$3;
                                    public final /* synthetic */ Placeable f$4;
                                    public final /* synthetic */ long f$5;
                                    public final /* synthetic */ int f$6;

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        int iM784getMaxWidthimpl3;
                                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                                        Placeable placeable = this.f$0;
                                        int i9 = placeable.height;
                                        int i10 = this.f$2;
                                        int i11 = this.f$1;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i11, (i10 - i9) / 2);
                                        int iMax3 = Math.max(placementScope.mo75roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), placeable.width);
                                        Placeable placeable2 = this.f$4;
                                        int i12 = placeable2.width;
                                        Placeable placeable3 = this.f$3;
                                        int i13 = placeable3.width;
                                        long j2 = this.f$5;
                                        int iRound = Math.round((1.0f - 1.0f) * ((Constraints.m784getMaxWidthimpl(j2) - i13) / 2.0f));
                                        if (iRound >= iMax3) {
                                            if (placeable3.width + iRound > Constraints.m784getMaxWidthimpl(j2) - i12) {
                                                iM784getMaxWidthimpl3 = (Constraints.m784getMaxWidthimpl(j2) - i12) - (placeable3.width + iRound);
                                            }
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iRound, (i10 - placeable3.height) / 2);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (Constraints.m784getMaxWidthimpl(j2) - placeable2.width) - this.f$6, (i10 - placeable2.height) / 2);
                                            return Unit.INSTANCE;
                                        }
                                        iM784getMaxWidthimpl3 = iMax3 - iRound;
                                        iRound += iM784getMaxWidthimpl3 + i11;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iRound, (i10 - placeable3.height) / 2);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (Constraints.m784getMaxWidthimpl(j2) - placeable2.width) - this.f$6, (i10 - placeable2.height) / 2);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            i5++;
                            this = this;
                        }
                        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
                    }
                    i3++;
                    this = this;
                }
                throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
            }
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        Integer numValueOf;
        int iMo75roundToPx0680j_4 = intrinsicMeasureScope.mo75roundToPx0680j_4(this.height);
        if (!list.isEmpty()) {
            numValueOf = Integer.valueOf(((Measurable) list.get(0)).minIntrinsicHeight(i));
            int i2 = 1;
            int size = list.size() - 1;
            if (1 <= size) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((Measurable) list.get(i2)).minIntrinsicHeight(i));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i2 == size) {
                        break;
                    }
                    i2++;
                }
            }
        } else {
            numValueOf = null;
        }
        return Math.max(iMo75roundToPx0680j_4, numValueOf != null ? numValueOf.intValue() : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        int size = list.size();
        int iMinIntrinsicWidth = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iMinIntrinsicWidth += ((Measurable) list.get(i2)).minIntrinsicWidth(i);
        }
        return iMinIntrinsicWidth;
    }
}
