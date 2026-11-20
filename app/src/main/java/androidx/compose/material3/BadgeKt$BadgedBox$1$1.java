package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentType;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BadgeKt$BadgedBox$1$1 implements MeasurePolicy {
    public static final BadgeKt$BadgedBox$1$1 INSTANCE = new BadgeKt$BadgedBox$1$1(0);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ BadgeKt$BadgedBox$1$1(byte b) {
        this.$r8$classId = b;
    }

    /* JADX WARN: Code duplicated, block: B:83:0x01ca A[PHI: r4 r6
      0x01ca: PHI (r4v24 int) = (r4v23 int), (r4v28 int), (r4v28 int) binds: [B:86:0x01e4, B:79:0x01bf, B:81:0x01c5] A[DONT_GENERATE, DONT_INLINE]
      0x01ca: PHI (r6v16 int) = (r6v15 int), (r6v21 int), (r6v21 int) binds: [B:86:0x01e4, B:79:0x01bf, B:81:0x01c5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        Object obj;
        Object obj2;
        int iMo75roundToPx0680j_4;
        int iMax;
        int i;
        int i2;
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        final byte b2 = 1;
        final byte b3 = 0;
        switch (b) {
            case 0:
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Measurable measurable = (Measurable) list.get(i3);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable), "badge")) {
                        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 11, j));
                        int size2 = list.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            Measurable measurable2 = (Measurable) list.get(i4);
                            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable2), LinkHeader.Parameters.Anchor)) {
                                Placeable placeableMo598measureBRTryo1 = measurable2.mo598measureBRTryo0(j);
                                HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.FirstBaseline;
                                int i5 = placeableMo598measureBRTryo1.get(horizontalAlignmentLine);
                                HorizontalAlignmentLine horizontalAlignmentLine2 = AlignmentLineKt.LastBaseline;
                                return measureScope.layout(placeableMo598measureBRTryo1.width, placeableMo598measureBRTryo1.height, MapsKt__MapsKt.mapOf(new Pair(horizontalAlignmentLine, Integer.valueOf(i5)), new Pair(horizontalAlignmentLine2, Integer.valueOf(placeableMo598measureBRTryo1.get(horizontalAlignmentLine2)))), new ZIndexNode$$ExternalSyntheticLambda0((Object) placeableMo598measureBRTryo0, (Object) placeableMo598measureBRTryo1, (byte) 9));
                            }
                        }
                        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
                    }
                }
                throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
            case 1:
                long j2 = j;
                int iMin = Math.min(Constraints.m784getMaxWidthimpl(j2), measureScope.mo75roundToPx0680j_4(600.0f));
                int size3 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 < size3) {
                        obj = list.get(i6);
                        if (!Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj), "action")) {
                            i6++;
                        }
                    } else {
                        obj = null;
                    }
                }
                Measurable measurable3 = (Measurable) obj;
                Placeable placeableMo598measureBRTryo2 = measurable3 != null ? measurable3.mo598measureBRTryo0(j2) : null;
                int size4 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 < size4) {
                        obj2 = list.get(i7);
                        if (!Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj2), "dismissAction")) {
                            i7++;
                        }
                    } else {
                        obj2 = null;
                    }
                }
                Measurable measurable4 = (Measurable) obj2;
                final Placeable placeableMo598measureBRTryo3 = measurable4 != null ? measurable4.mo598measureBRTryo0(j2) : null;
                int i8 = placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.width : 0;
                int i9 = placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.height : 0;
                int i10 = placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.width : 0;
                int i11 = placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.height : 0;
                int iMo75roundToPx0680j_5 = ((iMin - i8) - i10) - (i10 == 0 ? measureScope.mo75roundToPx0680j_4(8.0f) : 0);
                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j2);
                if (iMo75roundToPx0680j_5 < iM786getMinWidthimpl) {
                    iMo75roundToPx0680j_5 = iM786getMinWidthimpl;
                }
                int size5 = list.size();
                int i12 = 0;
                while (i12 < size5) {
                    Measurable measurable5 = (Measurable) list.get(i12);
                    int i13 = i9;
                    int i14 = size5;
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable5), ContentType.Text.TYPE)) {
                        int i15 = i11;
                        final Placeable placeableMo598measureBRTryo4 = measurable5.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, iMo75roundToPx0680j_5, 0, 0, 9, j2));
                        HorizontalAlignmentLine horizontalAlignmentLine3 = AlignmentLineKt.FirstBaseline;
                        int i16 = placeableMo598measureBRTryo4.get(horizontalAlignmentLine3);
                        int i17 = placeableMo598measureBRTryo4.get(AlignmentLineKt.LastBaseline);
                        final int i18 = iMin - i10;
                        final int i19 = i18 - i8;
                        if (i16 == i17 || !(i16 != Integer.MIN_VALUE && i17 != Integer.MIN_VALUE)) {
                            iMax = Math.max(measureScope.mo75roundToPx0680j_4(48.0f), Math.max(i13, i15));
                            iMo75roundToPx0680j_4 = (iMax - placeableMo598measureBRTryo4.height) / 2;
                            if (placeableMo598measureBRTryo2 == null || (i2 = placeableMo598measureBRTryo2.get(horizontalAlignmentLine3)) == Integer.MIN_VALUE) {
                                i = 0;
                            } else {
                                i = (i16 + iMo75roundToPx0680j_4) - i2;
                            }
                        } else {
                            iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(30.0f) - i16;
                            iMax = Math.max(measureScope.mo75roundToPx0680j_4(68.0f), placeableMo598measureBRTryo4.height + iMo75roundToPx0680j_4);
                            if (placeableMo598measureBRTryo2 != null) {
                                i = (iMax - placeableMo598measureBRTryo2.height) / 2;
                            } else {
                                i = 0;
                            }
                        }
                        final int i20 = i;
                        final int i21 = iMo75roundToPx0680j_4;
                        final int i22 = placeableMo598measureBRTryo3 != null ? (iMax - placeableMo598measureBRTryo3.height) / 2 : 0;
                        final Placeable placeable = placeableMo598measureBRTryo2;
                        return measureScope.layout(iMin, iMax, emptyMap, new Function1() { // from class: androidx.compose.material3.SnackbarKt$LegacyOneRowSnackbar$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj3) {
                                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj3;
                                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo598measureBRTryo4, 0, i21);
                                Placeable placeable2 = placeable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i19, i20);
                                }
                                Placeable placeable3 = placeableMo598measureBRTryo3;
                                if (placeable3 != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i18, i22);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    i12++;
                    i9 = i13;
                    j2 = j;
                    iMo75roundToPx0680j_5 = iMo75roundToPx0680j_5;
                    i11 = i11;
                    size5 = i14;
                }
                throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
            case 2:
                MutableIntList mutableIntList = TimePickerKt.Minutes;
                final int iMo75roundToPx0680j_6 = measureScope.mo75roundToPx0680j_4(4.0f);
                measureScope.mo75roundToPx0680j_4(16.0f);
                final ArrayList arrayList = new ArrayList(list.size());
                int size6 = list.size();
                int i23 = 0;
                while (i23 < size6) {
                    Measurable measurable6 = (Measurable) list.get(i23);
                    int iM784getMaxWidthimpl = (Constraints.m784getMaxWidthimpl(j) - iMo75roundToPx0680j_6) / 2;
                    if (iM784getMaxWidthimpl < 0) {
                        iM784getMaxWidthimpl = b3;
                    }
                    arrayList.add(measurable6.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, iM784getMaxWidthimpl, 0, 0, 8, j)));
                    i23++;
                    b3 = 0;
                }
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, new Function1() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        byte b4 = b2;
                        Unit unit = Unit.INSTANCE;
                        int i24 = iMo75roundToPx0680j_6;
                        ArrayList arrayList2 = arrayList;
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj3;
                        switch (b4) {
                            case 0:
                                placementScope.place((Placeable) arrayList2.get(0), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                placementScope.place((Placeable) arrayList2.get(1), 0, ((Placeable) arrayList2.get(0)).height + i24, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                placementScope.place((Placeable) arrayList2.get(0), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                placementScope.place((Placeable) arrayList2.get(1), ((Placeable) arrayList2.get(0)).width + i24, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit;
                    }
                });
            default:
                MutableIntList mutableIntList2 = TimePickerKt.Minutes;
                final int iMo75roundToPx0680j_7 = measureScope.mo75roundToPx0680j_4(4.0f);
                measureScope.mo75roundToPx0680j_4(8.0f);
                final ArrayList arrayList2 = new ArrayList(list.size());
                int size7 = list.size();
                for (int i24 = 0; i24 < size7; i24++) {
                    Measurable measurable7 = (Measurable) list.get(i24);
                    int iM783getMaxHeightimpl = (Constraints.m783getMaxHeightimpl(j) - iMo75roundToPx0680j_7) / 2;
                    arrayList2.add(measurable7.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, iM783getMaxHeightimpl < 0 ? 0 : iM783getMaxHeightimpl, 2, j)));
                }
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, new Function1() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        byte b4 = b3;
                        Unit unit = Unit.INSTANCE;
                        int i25 = iMo75roundToPx0680j_7;
                        ArrayList arrayList3 = arrayList2;
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj3;
                        switch (b4) {
                            case 0:
                                placementScope.place((Placeable) arrayList3.get(0), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                placementScope.place((Placeable) arrayList3.get(1), 0, ((Placeable) arrayList3.get(0)).height + i25, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                            default:
                                placementScope.place((Placeable) arrayList3.get(0), 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                placementScope.place((Placeable) arrayList3.get(1), ((Placeable) arrayList3.get(0)).width + i25, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                break;
                        }
                        return unit;
                    }
                });
        }
    }
}
