package androidx.compose.material3.internal;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ScrimKt;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.text.RegexKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 affixAlpha;
    public final ScrimKt labelPosition;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 labelProgress;
    public final float minimizedLabelHalfHeight;
    public final PaddingValues paddingValues;
    public final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 placeholderAlpha;
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, ScrimKt scrimKt, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, PaddingValues paddingValues, float f) {
        this.singleLine = z;
        this.labelPosition = scrimKt;
        this.labelProgress = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
        this.placeholderAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1;
        this.affixAlpha = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2;
        this.paddingValues = paddingValues;
        this.minimizedLabelHalfHeight = f;
    }

    public static int intrinsicWidth(List list, int i, Function2 function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj7 = list.get(i2);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj7), "TextField")) {
                int iIntValue = ((Number) function2.invoke(obj7, Integer.valueOf(i))).intValue();
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    obj = null;
                    if (i3 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i3);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj2), "Label")) {
                        break;
                    }
                    i3++;
                }
                Measurable measurable = (Measurable) obj2;
                int iIntValue2 = measurable != null ? ((Number) function2.invoke(measurable, Integer.valueOf(i))).intValue() : 0;
                int size3 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list.get(i4);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj3), "Trailing")) {
                        break;
                    }
                    i4++;
                }
                Measurable measurable2 = (Measurable) obj3;
                int iIntValue3 = measurable2 != null ? ((Number) function2.invoke(measurable2, Integer.valueOf(i))).intValue() : 0;
                int size4 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i5);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj4), "Prefix")) {
                        break;
                    }
                    i5++;
                }
                Measurable measurable3 = (Measurable) obj4;
                int iIntValue4 = measurable3 != null ? ((Number) function2.invoke(measurable3, Integer.valueOf(i))).intValue() : 0;
                int size5 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        obj5 = null;
                        break;
                    }
                    obj5 = list.get(i6);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj5), "Suffix")) {
                        break;
                    }
                    i6++;
                }
                Measurable measurable4 = (Measurable) obj5;
                int iIntValue5 = measurable4 != null ? ((Number) function2.invoke(measurable4, Integer.valueOf(i))).intValue() : 0;
                int size6 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size6) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i7);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj6), "Leading")) {
                        break;
                    }
                    i7++;
                }
                Measurable measurable5 = (Measurable) obj6;
                int iIntValue6 = measurable5 != null ? ((Number) function2.invoke(measurable5, Integer.valueOf(i))).intValue() : 0;
                int size7 = list.size();
                for (int i8 = 0; i8 < size7; i8++) {
                    Object obj8 = list.get(i8);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj8), "Hint")) {
                        obj = obj8;
                        break;
                    }
                }
                Measurable measurable6 = (Measurable) obj;
                int i9 = iIntValue4 + iIntValue5;
                return ConstraintsKt.m792constrainWidthK40F9xA(Math.max(iIntValue + i9, Math.max((measurable6 != null ? ((Number) function2.invoke(measurable6, Integer.valueOf(i))).intValue() : 0) + i9, iIntValue2)) + iIntValue6 + iIntValue3, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15));
            }
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
    }

    public static final int placeWithoutLabel$calculateVerticalPosition(TextFieldMeasurePolicy textFieldMeasurePolicy, int i, int i2, Placeable placeable) {
        return textFieldMeasurePolicy.singleLine ? Math.round(((i - placeable.height) / 2.0f) * 1.0f) : i2;
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc$1, reason: not valid java name */
    public final int m377calculateHeightmKXJcVc$1(Density density, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f) {
        PaddingValues paddingValues = this.paddingValues;
        return ConstraintsKt.m791constrainHeightK40F9xA(Math.max(i3, Math.max(i4, density.mo75roundToPx0680j_4(paddingValues.mo122calculateBottomPaddingD9Ej5fM() + paddingValues.mo125calculateTopPaddingD9Ej5fM() + CropImageView.DEFAULT_ASPECT_RATIO) + (i2 > 0 ? Math.max(density.mo75roundToPx0680j_4((this.minimizedLabelHalfHeight * 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO), LifecyclesKt.lerp(new CubicBezierEasing(0.3f, CropImageView.DEFAULT_ASPECT_RATIO, 0.8f, 0.15f).transform(f), 0, i2)) : 0) + RegexKt.maxOf(i, i7, i5, i6, LifecyclesKt.lerp(f, i2, 0)))) + i8, j);
    }

    public final int intrinsicHeight$1(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i, Function2 function2) {
        Object obj;
        int i2;
        int iIntValue;
        int iSubtractConstraintSafely;
        Object obj2;
        int iIntValue2;
        Object obj3;
        Object obj4;
        int i3;
        Object obj5;
        int i4;
        Object obj6;
        Object obj7;
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i5);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            i2 = i;
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(i2, measurable.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = ((Number) function2.invoke(measurable, Integer.valueOf(i2))).intValue();
        } else {
            i2 = i;
            iIntValue = 0;
            iSubtractConstraintSafely = i2;
        }
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i6);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
            i6++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(iSubtractConstraintSafely, measurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = ((Number) function2.invoke(measurable2, Integer.valueOf(i2))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i7);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj3), "Label")) {
                break;
            }
            i7++;
        }
        Object obj8 = (Measurable) obj3;
        int iIntValue3 = obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        int size4 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i8);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj4), "Prefix")) {
                break;
            }
            i8++;
        }
        Measurable measurable3 = (Measurable) obj4;
        if (measurable3 != null) {
            int iIntValue4 = ((Number) function2.invoke(measurable3, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(iSubtractConstraintSafely, measurable3.maxIntrinsicWidth(Integer.MAX_VALUE));
            i3 = iIntValue4;
        } else {
            i3 = 0;
        }
        int size5 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list.get(i9);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj5), "Suffix")) {
                break;
            }
            i9++;
        }
        Measurable measurable4 = (Measurable) obj5;
        if (measurable4 != null) {
            int iIntValue5 = ((Number) function2.invoke(measurable4, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = Icons$Filled.subtractConstraintSafely(iSubtractConstraintSafely, measurable4.maxIntrinsicWidth(Integer.MAX_VALUE));
            i4 = iIntValue5;
        } else {
            i4 = 0;
        }
        int size6 = list.size();
        for (int i10 = 0; i10 < size6; i10++) {
            Object obj9 = list.get(i10);
            if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj9), "TextField")) {
                int iIntValue6 = ((Number) function2.invoke(obj9, Integer.valueOf(iSubtractConstraintSafely))).intValue();
                int size7 = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i11);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj6), "Hint")) {
                        break;
                    }
                    i11++;
                }
                Object obj10 = (Measurable) obj6;
                int iIntValue7 = obj10 != null ? ((Number) function2.invoke(obj10, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
                int size8 = list.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i12);
                    if (Intrinsics.areEqual(Icons$Filled.getLayoutId((Measurable) obj7), "Supporting")) {
                        break;
                    }
                    i12++;
                }
                Object obj11 = (Measurable) obj7;
                return m377calculateHeightmKXJcVc$1(intrinsicMeasureScope, iIntValue6, iIntValue3, iIntValue, iIntValue2, i3, i4, iIntValue7, obj11 != null ? ((Number) function2.invoke(obj11, Integer.valueOf(i2))).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), this.labelProgress.invoke());
            }
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight$1(intrinsicMeasureScope, list, i, new ScrollState$$ExternalSyntheticLambda3((byte) 29));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(list, i, new Updater$$ExternalSyntheticLambda0((byte) 3));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(final MeasureScope measureScope, List list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Placeable placeable;
        Object obj5;
        int i;
        Object obj6;
        Object obj7;
        Placeable placeable2;
        int i2;
        Ref$ObjectRef ref$ObjectRef;
        int i3;
        float f;
        int i4;
        float fInvoke = this.labelProgress.invoke();
        PaddingValues paddingValues = this.paddingValues;
        final int iMo75roundToPx0680j_4 = measureScope.mo75roundToPx0680j_4(paddingValues.mo125calculateTopPaddingD9Ej5fM());
        int iMo75roundToPx0680j_5 = measureScope.mo75roundToPx0680j_4(paddingValues.mo122calculateBottomPaddingD9Ej5fM());
        long jM777copyZbe2FdA$default = Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 10, j);
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i5);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj), "Leading")) {
                break;
            }
            i5++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable placeableMo598measureBRTryo0 = measurable != null ? measurable.mo598measureBRTryo0(jM777copyZbe2FdA$default) : null;
        int i6 = placeableMo598measureBRTryo0 != null ? placeableMo598measureBRTryo0.width : 0;
        int iMax = Math.max(0, placeableMo598measureBRTryo0 != null ? placeableMo598measureBRTryo0.height : 0);
        int size2 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i7);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj2), "Trailing")) {
                break;
            }
            i7++;
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable placeableMo598measureBRTryo1 = measurable2 != null ? measurable2.mo598measureBRTryo0(ConstraintsKt.m794offsetNN6EwU$default(-i6, 0, 2, jM777copyZbe2FdA$default)) : null;
        int i8 = i6 + (placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.width : 0);
        int iMax2 = Math.max(iMax, placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.height : 0);
        int size3 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i9);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj3), "Prefix")) {
                break;
            }
            i9++;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable placeableMo598measureBRTryo2 = measurable3 != null ? measurable3.mo598measureBRTryo0(ConstraintsKt.m794offsetNN6EwU$default(-i8, 0, 2, jM777copyZbe2FdA$default)) : null;
        int i10 = i8 + (placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.width : 0);
        int iMax3 = Math.max(iMax2, placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.height : 0);
        int size4 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i11);
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj4), "Suffix")) {
                break;
            }
            i11++;
        }
        Measurable measurable4 = (Measurable) obj4;
        Placeable placeableMo598measureBRTryo3 = measurable4 != null ? measurable4.mo598measureBRTryo0(ConstraintsKt.m794offsetNN6EwU$default(-i10, 0, 2, jM777copyZbe2FdA$default)) : null;
        int i12 = i10 + (placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.width : 0);
        int iMax4 = Math.max(iMax3, placeableMo598measureBRTryo3 != null ? placeableMo598measureBRTryo3.height : 0);
        int size5 = list.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size5) {
                placeable = placeableMo598measureBRTryo3;
                obj5 = null;
                break;
            }
            obj5 = list.get(i13);
            placeable = placeableMo598measureBRTryo3;
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj5), "Label")) {
                break;
            }
            i13++;
            placeableMo598measureBRTryo3 = placeable;
        }
        Measurable measurable5 = (Measurable) obj5;
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        int i14 = -i12;
        ref$ObjectRef2.element = measurable5 != null ? measurable5.mo598measureBRTryo0(ConstraintsKt.m793offsetNN6EwU(i14, -iMo75roundToPx0680j_5, jM777copyZbe2FdA$default)) : null;
        int size6 = list.size();
        int i15 = 0;
        while (true) {
            if (i15 >= size6) {
                i = iMo75roundToPx0680j_5;
                obj6 = null;
                break;
            }
            obj6 = list.get(i15);
            i = iMo75roundToPx0680j_5;
            if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj6), "Supporting")) {
                break;
            }
            i15++;
            iMo75roundToPx0680j_5 = i;
        }
        Measurable measurable6 = (Measurable) obj6;
        int iMinIntrinsicHeight = measurable6 != null ? measurable6.minIntrinsicHeight(Constraints.m786getMinWidthimpl(j)) : 0;
        Placeable placeable3 = (Placeable) ref$ObjectRef2.element;
        int i16 = (placeable3 != null ? placeable3.height : 0) + iMo75roundToPx0680j_4;
        final Placeable placeable4 = placeableMo598measureBRTryo0;
        Placeable placeable5 = placeable;
        float f2 = fInvoke;
        Placeable placeable6 = placeable5;
        Measurable measurable7 = measurable6;
        long jM793offsetNN6EwU = ConstraintsKt.m793offsetNN6EwU(i14, ((-i16) - i) - iMinIntrinsicHeight, Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 11, j));
        int size7 = list.size();
        int i17 = 0;
        while (i17 < size7) {
            Measurable measurable8 = (Measurable) list.get(i17);
            if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable8), "TextField")) {
                Placeable placeableMo598measureBRTryo4 = measurable8.mo598measureBRTryo0(jM793offsetNN6EwU);
                long jM777copyZbe2FdA$default2 = Constraints.m777copyZbe2FdA$default(0, 0, 0, 0, 14, jM793offsetNN6EwU);
                int size8 = list.size();
                int i18 = 0;
                while (true) {
                    if (i18 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i18);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId((Measurable) obj7), "Hint")) {
                        break;
                    }
                    i18++;
                }
                Measurable measurable9 = (Measurable) obj7;
                Placeable placeableMo598measureBRTryo5 = measurable9 != null ? measurable9.mo598measureBRTryo0(jM777copyZbe2FdA$default2) : null;
                int iMax5 = Math.max(iMax4, Math.max(placeableMo598measureBRTryo4.height, placeableMo598measureBRTryo5 != null ? placeableMo598measureBRTryo5.height : 0) + i16 + i);
                int i19 = placeable4 != null ? placeable4.width : 0;
                int i20 = placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.width : 0;
                int i21 = placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.width : 0;
                int i22 = placeable6 != null ? placeable6.width : 0;
                int i23 = placeableMo598measureBRTryo4.width;
                Placeable placeable7 = (Placeable) ref$ObjectRef2.element;
                int i24 = i21 + i22;
                final int iM792constrainWidthK40F9xA = ConstraintsKt.m792constrainWidthK40F9xA(Math.max(i23 + i24, Math.max((placeableMo598measureBRTryo5 != null ? placeableMo598measureBRTryo5.width : 0) + i24, placeable7 != null ? placeable7.width : 0)) + i19 + i20, j);
                final Placeable placeableMo598measureBRTryo6 = measurable7 != null ? measurable7.mo598measureBRTryo0(Constraints.m777copyZbe2FdA$default(0, iM792constrainWidthK40F9xA, 0, 0, 9, ConstraintsKt.m794offsetNN6EwU$default(0, -iMax5, 1, jM777copyZbe2FdA$default))) : null;
                int i25 = placeableMo598measureBRTryo6 != null ? placeableMo598measureBRTryo6.height : 0;
                int i26 = placeableMo598measureBRTryo4.height;
                Placeable placeable8 = (Placeable) ref$ObjectRef2.element;
                int i27 = placeable8 != null ? placeable8.height : 0;
                int i28 = placeable4 != null ? placeable4.height : 0;
                int i29 = placeableMo598measureBRTryo1 != null ? placeableMo598measureBRTryo1.height : 0;
                int i30 = placeableMo598measureBRTryo2 != null ? placeableMo598measureBRTryo2.height : 0;
                final Placeable placeable9 = placeableMo598measureBRTryo2;
                if (placeable6 != null) {
                    i2 = placeable6.height;
                    placeable2 = placeableMo598measureBRTryo4;
                } else {
                    placeable2 = placeableMo598measureBRTryo4;
                    i2 = 0;
                }
                final Placeable placeable10 = placeable2;
                if (placeableMo598measureBRTryo5 != null) {
                    i3 = placeableMo598measureBRTryo5.height;
                    ref$ObjectRef = ref$ObjectRef2;
                } else {
                    ref$ObjectRef = r2;
                    i3 = 0;
                }
                if (placeableMo598measureBRTryo6 != null) {
                    f = f2;
                    i4 = placeableMo598measureBRTryo6.height;
                } else {
                    f = f2;
                    i4 = 0;
                }
                final int iM377calculateHeightmKXJcVc$1 = m377calculateHeightmKXJcVc$1(measureScope, i26, i27, i28, i29, i30, i2, i3, i4, j, f);
                final int i31 = iM377calculateHeightmKXJcVc$1 - i25;
                int size9 = list.size();
                int i32 = 0;
                while (i32 < size9) {
                    Measurable measurable10 = (Measurable) list.get(i32);
                    if (Intrinsics.areEqual(RulerKt.getLayoutId(measurable10), "Container")) {
                        final Placeable placeableMo598measureBRTryo7 = measurable10.mo598measureBRTryo0(ConstraintsKt.Constraints(iM792constrainWidthK40F9xA != Integer.MAX_VALUE ? iM792constrainWidthK40F9xA : 0, iM792constrainWidthK40F9xA, i31 != Integer.MAX_VALUE ? i31 : 0, i31));
                        final Placeable placeable11 = placeableMo598measureBRTryo1;
                        final Placeable placeable12 = placeableMo598measureBRTryo5;
                        final Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef;
                        final float f3 = f;
                        final Placeable placeable13 = placeable6;
                        return measureScope.layout(iM792constrainWidthK40F9xA, iM377calculateHeightmKXJcVc$1, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.material3.internal.TextFieldMeasurePolicy$$ExternalSyntheticLambda1
                            /* JADX WARN: Code duplicated, block: B:20:0x009a  */
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj8) {
                                byte b;
                                int i33;
                                int iMo75roundToPx0680j_6;
                                int i34;
                                Placeable placeable14;
                                int i35;
                                TextFieldMeasurePolicy textFieldMeasurePolicy = this;
                                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = textFieldMeasurePolicy.affixAlpha;
                                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1 = textFieldMeasurePolicy.placeholderAlpha;
                                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj8;
                                Ref$ObjectRef ref$ObjectRef4 = ref$ObjectRef3;
                                Object obj9 = ref$ObjectRef4.element;
                                int i36 = iM792constrainWidthK40F9xA;
                                int i37 = iM377calculateHeightmKXJcVc$1;
                                Placeable placeable15 = placeable10;
                                Placeable placeable16 = placeable12;
                                Placeable placeable17 = placeable4;
                                Placeable placeable18 = placeable11;
                                Placeable placeable19 = placeable9;
                                Placeable placeable20 = placeable13;
                                Placeable placeable21 = placeableMo598measureBRTryo7;
                                Placeable placeable22 = placeableMo598measureBRTryo6;
                                if (obj9 != null) {
                                    boolean z = textFieldMeasurePolicy.singleLine;
                                    int i38 = iMo75roundToPx0680j_4;
                                    if (z) {
                                        iMo75roundToPx0680j_6 = Math.round(((i31 - ((Placeable) obj9).height) / 2.0f) * 1.0f);
                                    } else {
                                        iMo75roundToPx0680j_6 = placementScope.mo75roundToPx0680j_4(textFieldMeasurePolicy.minimizedLabelHalfHeight) + i38;
                                    }
                                    Placeable placeable23 = (Placeable) ref$ObjectRef4.element;
                                    int i39 = placeable23.height + i38;
                                    LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                    ScrimKt scrimKt = textFieldMeasurePolicy.labelPosition;
                                    placementScope.place(placeable21, 0, 0, CropImageView.DEFAULT_ASPECT_RATIO);
                                    int i40 = i37 - (placeable22 != null ? placeable22.height : 0);
                                    if (placeable17 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable17, 0, Math.round(((i40 - placeable17.height) / 2.0f) * 1.0f));
                                    }
                                    float f4 = f3;
                                    int iLerp = LifecyclesKt.lerp(f4, iMo75roundToPx0680j_6, i38);
                                    if (layoutDirection == LayoutDirection.Ltr) {
                                        if (placeable17 != null) {
                                            i34 = placeable17.width;
                                        } else {
                                            i34 = 0;
                                        }
                                    } else if (placeable18 != null) {
                                        i34 = placeable18.width;
                                    } else {
                                        i34 = 0;
                                    }
                                    int i41 = i34;
                                    placementScope.place(placeable23, LifecyclesKt.lerp(f4, ((BiasAlignment.Horizontal) Icons$Filled.getExpandedAlignment(scrimKt)).align(placeable23.width, (i36 - (placeable17 != null ? placeable17.width : 0)) - (placeable18 != null ? placeable18.width : 0), layoutDirection) + i41, ((BiasAlignment.Horizontal) Icons$Filled.getMinimizedAlignment(scrimKt)).align(placeable23.width, (i36 - (placeable17 != null ? placeable17.width : 0)) - (placeable18 != null ? placeable18.width : 0), layoutDirection) + i41), iLerp, CropImageView.DEFAULT_ASPECT_RATIO);
                                    if (placeable19 != null) {
                                        placeable14 = placeable19;
                                        i35 = i39;
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable14, placeable17 != null ? placeable17.width : 0, i35, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, (byte) 7), 4);
                                    } else {
                                        placeable14 = placeable19;
                                        i35 = i39;
                                    }
                                    int i42 = (placeable17 != null ? placeable17.width : 0) + (placeable14 != null ? placeable14.width : 0);
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable15, i42, i35);
                                    if (placeable16 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable16, i42, i35, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, (byte) 8), 4);
                                    }
                                    if (placeable20 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable20, (i36 - (placeable18 != null ? placeable18.width : 0)) - placeable20.width, i35, new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, (byte) 4), 4);
                                    }
                                    if (placeable18 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable18, i36 - placeable18.width, Math.round(((i40 - placeable18.height) / 2.0f) * 1.0f));
                                    }
                                    if (placeable22 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable22, 0, i40);
                                    }
                                } else {
                                    float density = placementScope.getDensity();
                                    Placeable.PlacementScope.m619place70tqf50$default(placementScope, placeable21, 0L);
                                    int i43 = i37 - (placeable22 != null ? placeable22.height : 0);
                                    int iRoundToInt = MathKt.roundToInt(textFieldMeasurePolicy.paddingValues.mo125calculateTopPaddingD9Ej5fM() * density);
                                    if (placeable17 != null) {
                                        b = 0;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable17, 0, Math.round(((i43 - placeable17.height) / 2.0f) * 1.0f));
                                    } else {
                                        b = 0;
                                    }
                                    if (placeable19 != null) {
                                        i33 = iRoundToInt;
                                        placementScope = placementScope;
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable19, placeable17 != null ? placeable17.width : b, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i43, iRoundToInt, placeable19), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, b), 4);
                                    } else {
                                        i33 = iRoundToInt;
                                    }
                                    int i44 = (placeable17 != null ? placeable17.width : 0) + (placeable19 != null ? placeable19.width : 0);
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable15, i44, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i43, i33, placeable15));
                                    if (placeable16 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable16, i44, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i43, i33, placeable16), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, (byte) 5), 4);
                                    }
                                    if (placeable20 != null) {
                                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable20, (i36 - (placeable18 != null ? placeable18.width : 0)) - placeable20.width, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(textFieldMeasurePolicy, i43, i33, placeable20), new TextFieldMeasurePolicy$$ExternalSyntheticLambda5(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, (byte) 6), 4);
                                    }
                                    if (placeable18 != null) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable18, i36 - placeable18.width, Math.round(((i43 - placeable18.height) / 2.0f) * 1.0f));
                                    }
                                    if (placeable22 != 0) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable22, 0, i43);
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    i32++;
                    ref$ObjectRef = ref$ObjectRef;
                }
                throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
            }
            i17++;
            f2 = f2;
            placeable6 = placeable6;
            placeableMo598measureBRTryo2 = placeableMo598measureBRTryo2;
            measurable7 = measurable7;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$1("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicHeight$1(intrinsicMeasureScope, list, i, new Updater$$ExternalSyntheticLambda0((byte) 1));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return intrinsicWidth(list, i, new Updater$$ExternalSyntheticLambda0((byte) 2));
    }
}
