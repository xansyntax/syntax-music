package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.ZIndexNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$SliderImpl$3$1 implements MeasurePolicy {
    public final /* synthetic */ byte $r8$classId = 0;
    public final Object $state;

    public SliderKt$SliderImpl$3$1(SliderState sliderState, MutableState mutableState) {
        this.$state = sliderState;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        int i;
        int iRoundToInt;
        final int i2;
        int iMax;
        int i3;
        byte b = this.$r8$classId;
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        switch (b) {
            case 0:
                SliderState sliderState = (SliderState) this.$state;
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    Measurable measurable = (Measurable) list.get(i4);
                    if (RulerKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                        final Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
                        int size2 = list.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            Measurable measurable2 = (Measurable) list.get(i5);
                            if (RulerKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                                boolean zIsVertical = sliderState.isVertical();
                                int i6 = sliderState.steps;
                                float[] fArr = sliderState.tickFractions;
                                boolean z = true;
                                final Placeable placeableMo598measureBRTryo1 = zIsVertical ? measurable2.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 14, ConstraintsKt.m794offsetNN6EwU$default(0, -placeableMo598measureBRTryo0.height, 1, j))) : measurable2.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 11, ConstraintsKt.m794offsetNN6EwU$default(-placeableMo598measureBRTryo0.width, 0, 2, j)));
                                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                                float coercedValueAsFraction = sliderState.getCoercedValueAsFraction();
                                fArr.getClass();
                                if (!Intrinsics.areEqual(coercedValueAsFraction, fArr.length == 0 ? null : Float.valueOf(fArr[0])) && !Intrinsics.areEqual(coercedValueAsFraction, ArraysKt.lastOrNull(fArr))) {
                                    z = false;
                                }
                                int i7 = placeableMo598measureBRTryo1.get(SliderKt.CornerSizeAlignmentLine);
                                int i8 = i7 != Integer.MIN_VALUE ? i7 : 0;
                                int i9 = placeableMo598measureBRTryo0.width;
                                int i10 = placeableMo598measureBRTryo0.height;
                                boolean zIsVertical2 = sliderState.isVertical();
                                int i11 = placeableMo598measureBRTryo1.width;
                                int i12 = placeableMo598measureBRTryo1.height;
                                if (zIsVertical2) {
                                    iMax = Math.max(i11, i9);
                                    i3 = i10 + i12;
                                    i = (iMax - placeableMo598measureBRTryo1.width) / 2;
                                    int i13 = i10 / 2;
                                    iRoundToInt = (iMax - placeableMo598measureBRTryo0.width) / 2;
                                    ref$IntRef.element = (i13 - (placeableMo598measureBRTryo0.height / 2)) + ((i6 <= 0 || z) ? MathKt.roundToInt(i12 * coercedValueAsFraction) : MathKt.roundToInt((i12 - (i8 * 2)) * coercedValueAsFraction) + i8);
                                    i2 = i13;
                                } else {
                                    int i14 = i9 + i11;
                                    int iMax2 = Math.max(i12, i10);
                                    i = i9 / 2;
                                    int i15 = (iMax2 - placeableMo598measureBRTryo1.height) / 2;
                                    iRoundToInt = (((i6 <= 0 || z) ? MathKt.roundToInt(placeableMo598measureBRTryo1.width * coercedValueAsFraction) : MathKt.roundToInt((placeableMo598measureBRTryo1.width - (i8 * 2)) * coercedValueAsFraction) + i8) + i) - (placeableMo598measureBRTryo0.width / 2);
                                    ref$IntRef.element = (iMax2 - placeableMo598measureBRTryo0.height) / 2;
                                    i2 = i15;
                                    iMax = i14;
                                    i3 = iMax2;
                                }
                                final int i16 = iRoundToInt;
                                final int i17 = i;
                                sliderState.totalWidth$delegate.setIntValue(iMax);
                                sliderState.totalHeight$delegate.setIntValue(i3);
                                return measureScope.layout(iMax, i3, emptyMap, new Function1() { // from class: androidx.compose.material3.SliderKt$SliderImpl$3$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo598measureBRTryo1, i17, i2);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo598measureBRTryo0, i16, ref$IntRef.element);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
                    }
                }
                throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
            default:
                return measureScope.layout(Constraints.m784getMaxWidthimpl(j), Constraints.m783getMaxHeightimpl(j), emptyMap, new ZIndexNode$$ExternalSyntheticLambda0(list, this, (byte) 3));
        }
    }

    public SliderKt$SliderImpl$3$1(Function0 function0) {
        this.$state = function0;
    }
}
