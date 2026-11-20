package androidx.compose.foundation.layout;

import android.view.View;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.CardKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SheetWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.layout.LayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OffsetKt {
    public static final Arrangement$End$1 End;
    public static final Arrangement$End$1 Left;
    public static final Arrangement$End$1 Right;
    public static final Arrangement$End$1 Start;
    public static final Arrangement$Top$1 Top = new Arrangement$Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        public final /* synthetic */ byte $r8$classId = 0;

        @Override // androidx.compose.foundation.layout.Arrangement$Vertical
        public final void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            int i2 = 0;
            switch (this.$r8$classId) {
                case 0:
                    int length = iArr.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < length) {
                        int i5 = iArr[i2];
                        iArr2[i3] = i4;
                        i4 += i5;
                        i2++;
                        i3++;
                    }
                    break;
                default:
                    int i6 = 0;
                    for (int i7 : iArr) {
                        i6 += i7;
                    }
                    int length2 = iArr.length;
                    int i8 = i - i6;
                    int i9 = 0;
                    while (i2 < length2) {
                        int i10 = iArr[i2];
                        iArr2[i9] = i8;
                        i8 += i10;
                        i2++;
                        i9++;
                    }
                    break;
            }
        }

        public final String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "Arrangement#Top";
                default:
                    return "Arrangement#Bottom";
            }
        }
    };
    public static final FlowRowOverflow Center = new FlowRowOverflow(1);
    public static final FlowRowOverflow SpaceBetween = new FlowRowOverflow(2);
    public static final FixedIntInsets EmptyWindowInsets = new FixedIntInsets();
    public static final OffsetKt$$ExternalSyntheticLambda0 statusBarsLambda = new OffsetKt$$ExternalSyntheticLambda0(11);
    public static final OffsetKt$$ExternalSyntheticLambda0 imeLambda = new OffsetKt$$ExternalSyntheticLambda0(12);

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.layout.Arrangement$End$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.layout.Arrangement$End$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.layout.Arrangement$End$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.layout.Arrangement$End$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.foundation.layout.Arrangement$Top$1] */
    static {
        final byte b = 1;
        Left = new Arrangement$Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
            @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
            public final void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                byte b2 = b;
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i2 = 0;
                switch (b2) {
                    case 0:
                        if (layoutDirection == layoutDirection2) {
                            int i3 = 0;
                            for (int i4 : iArr) {
                                i3 += i4;
                            }
                            int i5 = i - i3;
                            int length = iArr.length;
                            int i6 = 0;
                            while (i2 < length) {
                                int i7 = iArr[i2];
                                iArr2[i6] = i5;
                                i5 += i7;
                                i2++;
                                i6++;
                            }
                        } else {
                            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                                int i8 = iArr[length2];
                                iArr2[length2] = i2;
                                i2 += i8;
                            }
                        }
                        break;
                    case 1:
                        int length3 = iArr.length;
                        int i9 = 0;
                        int i10 = 0;
                        while (i2 < length3) {
                            int i11 = iArr[i2];
                            iArr2[i9] = i10;
                            i10 += i11;
                            i2++;
                            i9++;
                        }
                        break;
                    case 2:
                        int i12 = 0;
                        for (int i13 : iArr) {
                            i12 += i13;
                        }
                        int i14 = i - i12;
                        int length4 = iArr.length;
                        int i15 = 0;
                        while (i2 < length4) {
                            int i16 = iArr[i2];
                            iArr2[i15] = i14;
                            i14 += i16;
                            i2++;
                            i15++;
                        }
                        break;
                    default:
                        if (layoutDirection == layoutDirection2) {
                            int length5 = iArr.length;
                            int i17 = 0;
                            int i18 = 0;
                            while (i2 < length5) {
                                int i19 = iArr[i2];
                                iArr2[i17] = i18;
                                i18 += i19;
                                i2++;
                                i17++;
                            }
                        } else {
                            int length6 = iArr.length;
                            int i20 = 0;
                            while (i2 < length6) {
                                i20 += iArr[i2];
                                i2++;
                            }
                            int i21 = i - i20;
                            for (int length7 = iArr.length - 1; -1 < length7; length7--) {
                                int i22 = iArr[length7];
                                iArr2[length7] = i21;
                                i21 += i22;
                            }
                        }
                        break;
                }
            }

            public final String toString() {
                switch (b) {
                    case 0:
                        return "Arrangement#End";
                    case 1:
                        return "AbsoluteArrangement#Left";
                    case 2:
                        return "AbsoluteArrangement#Right";
                    default:
                        return "Arrangement#Start";
                }
            }
        };
        final byte b2 = 2;
        Right = new Arrangement$Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
            @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
            public final void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                byte b3 = b2;
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i2 = 0;
                switch (b3) {
                    case 0:
                        if (layoutDirection == layoutDirection2) {
                            int i3 = 0;
                            for (int i4 : iArr) {
                                i3 += i4;
                            }
                            int i5 = i - i3;
                            int length = iArr.length;
                            int i6 = 0;
                            while (i2 < length) {
                                int i7 = iArr[i2];
                                iArr2[i6] = i5;
                                i5 += i7;
                                i2++;
                                i6++;
                            }
                        } else {
                            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                                int i8 = iArr[length2];
                                iArr2[length2] = i2;
                                i2 += i8;
                            }
                        }
                        break;
                    case 1:
                        int length3 = iArr.length;
                        int i9 = 0;
                        int i10 = 0;
                        while (i2 < length3) {
                            int i11 = iArr[i2];
                            iArr2[i9] = i10;
                            i10 += i11;
                            i2++;
                            i9++;
                        }
                        break;
                    case 2:
                        int i12 = 0;
                        for (int i13 : iArr) {
                            i12 += i13;
                        }
                        int i14 = i - i12;
                        int length4 = iArr.length;
                        int i15 = 0;
                        while (i2 < length4) {
                            int i16 = iArr[i2];
                            iArr2[i15] = i14;
                            i14 += i16;
                            i2++;
                            i15++;
                        }
                        break;
                    default:
                        if (layoutDirection == layoutDirection2) {
                            int length5 = iArr.length;
                            int i17 = 0;
                            int i18 = 0;
                            while (i2 < length5) {
                                int i19 = iArr[i2];
                                iArr2[i17] = i18;
                                i18 += i19;
                                i2++;
                                i17++;
                            }
                        } else {
                            int length6 = iArr.length;
                            int i20 = 0;
                            while (i2 < length6) {
                                i20 += iArr[i2];
                                i2++;
                            }
                            int i21 = i - i20;
                            for (int length7 = iArr.length - 1; -1 < length7; length7--) {
                                int i22 = iArr[length7];
                                iArr2[length7] = i21;
                                i21 += i22;
                            }
                        }
                        break;
                }
            }

            public final String toString() {
                switch (b2) {
                    case 0:
                        return "Arrangement#End";
                    case 1:
                        return "AbsoluteArrangement#Left";
                    case 2:
                        return "AbsoluteArrangement#Right";
                    default:
                        return "Arrangement#Start";
                }
            }
        };
        final byte b3 = 3;
        Start = new Arrangement$Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
            @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
            public final void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                byte b4 = b3;
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i2 = 0;
                switch (b4) {
                    case 0:
                        if (layoutDirection == layoutDirection2) {
                            int i3 = 0;
                            for (int i4 : iArr) {
                                i3 += i4;
                            }
                            int i5 = i - i3;
                            int length = iArr.length;
                            int i6 = 0;
                            while (i2 < length) {
                                int i7 = iArr[i2];
                                iArr2[i6] = i5;
                                i5 += i7;
                                i2++;
                                i6++;
                            }
                        } else {
                            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                                int i8 = iArr[length2];
                                iArr2[length2] = i2;
                                i2 += i8;
                            }
                        }
                        break;
                    case 1:
                        int length3 = iArr.length;
                        int i9 = 0;
                        int i10 = 0;
                        while (i2 < length3) {
                            int i11 = iArr[i2];
                            iArr2[i9] = i10;
                            i10 += i11;
                            i2++;
                            i9++;
                        }
                        break;
                    case 2:
                        int i12 = 0;
                        for (int i13 : iArr) {
                            i12 += i13;
                        }
                        int i14 = i - i12;
                        int length4 = iArr.length;
                        int i15 = 0;
                        while (i2 < length4) {
                            int i16 = iArr[i2];
                            iArr2[i15] = i14;
                            i14 += i16;
                            i2++;
                            i15++;
                        }
                        break;
                    default:
                        if (layoutDirection == layoutDirection2) {
                            int length5 = iArr.length;
                            int i17 = 0;
                            int i18 = 0;
                            while (i2 < length5) {
                                int i19 = iArr[i2];
                                iArr2[i17] = i18;
                                i18 += i19;
                                i2++;
                                i17++;
                            }
                        } else {
                            int length6 = iArr.length;
                            int i20 = 0;
                            while (i2 < length6) {
                                i20 += iArr[i2];
                                i2++;
                            }
                            int i21 = i - i20;
                            for (int length7 = iArr.length - 1; -1 < length7; length7--) {
                                int i22 = iArr[length7];
                                iArr2[length7] = i21;
                                i21 += i22;
                            }
                        }
                        break;
                }
            }

            public final String toString() {
                switch (b3) {
                    case 0:
                        return "Arrangement#End";
                    case 1:
                        return "AbsoluteArrangement#Left";
                    case 2:
                        return "AbsoluteArrangement#Right";
                    default:
                        return "Arrangement#Start";
                }
            }
        };
        final byte b4 = 0;
        End = new Arrangement$Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
            @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
            public final void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                byte b5 = b4;
                LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
                int i2 = 0;
                switch (b5) {
                    case 0:
                        if (layoutDirection == layoutDirection2) {
                            int i3 = 0;
                            for (int i4 : iArr) {
                                i3 += i4;
                            }
                            int i5 = i - i3;
                            int length = iArr.length;
                            int i6 = 0;
                            while (i2 < length) {
                                int i7 = iArr[i2];
                                iArr2[i6] = i5;
                                i5 += i7;
                                i2++;
                                i6++;
                            }
                        } else {
                            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                                int i8 = iArr[length2];
                                iArr2[length2] = i2;
                                i2 += i8;
                            }
                        }
                        break;
                    case 1:
                        int length3 = iArr.length;
                        int i9 = 0;
                        int i10 = 0;
                        while (i2 < length3) {
                            int i11 = iArr[i2];
                            iArr2[i9] = i10;
                            i10 += i11;
                            i2++;
                            i9++;
                        }
                        break;
                    case 2:
                        int i12 = 0;
                        for (int i13 : iArr) {
                            i12 += i13;
                        }
                        int i14 = i - i12;
                        int length4 = iArr.length;
                        int i15 = 0;
                        while (i2 < length4) {
                            int i16 = iArr[i2];
                            iArr2[i15] = i14;
                            i14 += i16;
                            i2++;
                            i15++;
                        }
                        break;
                    default:
                        if (layoutDirection == layoutDirection2) {
                            int length5 = iArr.length;
                            int i17 = 0;
                            int i18 = 0;
                            while (i2 < length5) {
                                int i19 = iArr[i2];
                                iArr2[i17] = i18;
                                i18 += i19;
                                i2++;
                                i17++;
                            }
                        } else {
                            int length6 = iArr.length;
                            int i20 = 0;
                            while (i2 < length6) {
                                i20 += iArr[i2];
                                i2++;
                            }
                            int i21 = i - i20;
                            for (int length7 = iArr.length - 1; -1 < length7; length7--) {
                                int i22 = iArr[length7];
                                iArr2[length7] = i21;
                                i21 += i22;
                            }
                        }
                        break;
                }
            }

            public final String toString() {
                switch (b4) {
                    case 0:
                        return "Arrangement#End";
                    case 1:
                        return "AbsoluteArrangement#Left";
                    case 2:
                        return "AbsoluteArrangement#Right";
                    default:
                        return "Arrangement#Start";
                }
            }
        };
    }

    public static final void BoxWithConstraints(Modifier modifier, Alignment alignment, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        int i3;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(380139498);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= gapComposer.changed(alignment) ? 32 : 16;
        }
        int i5 = i3 | 384;
        if ((i & 3072) == 0) {
            i5 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 1171) != 1170)) {
            if (i4 != 0) {
                alignment = Alignment.Companion.TopStart;
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            boolean zChanged = gapComposer.changed(measurePolicyMaybeCachedBoxMeasurePolicy) | ((i5 & 7168) == 2048);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new ButtonKt$$ExternalSyntheticLambda1(measurePolicyMaybeCachedBoxMeasurePolicy, composableLambdaImpl, (byte) 5);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            RulerKt.SubcomposeLayout(modifier, (Function2) objRememberedValue, gapComposer, i5 & 14, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        Alignment alignment2 = alignment;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BoxWithConstraintsKt$$ExternalSyntheticLambda1(modifier, alignment2, composableLambdaImpl, i, i2);
        }
    }

    public static final void FlowRow(Modifier modifier, Arrangement$Horizontal arrangement$Horizontal, Arrangement$Vertical arrangement$Vertical, FlowRowOverflow flowRowOverflow, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i) {
        int i2;
        FlowRowOverflow flowRowOverflow2;
        boolean z;
        Object obj;
        BiasAlignment.Vertical vertical = Alignment.Companion.Top;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1956591841);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(arrangement$Horizontal) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(arrangement$Vertical) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(vertical) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(Integer.MAX_VALUE) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(Integer.MAX_VALUE) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            flowRowOverflow2 = flowRowOverflow;
            i2 |= gapComposer.changed(flowRowOverflow2) ? 1048576 : 524288;
        } else {
            flowRowOverflow2 = flowRowOverflow;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 4793491) != 4793490)) {
            int i4 = i3 & 3670016;
            boolean z2 = i4 == 1048576;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
            Object obj2 = objRememberedValue;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                flowRowOverflow2.getClass();
                FlowLayoutOverflowState flowLayoutOverflowState = new FlowLayoutOverflowState();
                gapComposer.updateRememberedValue(flowLayoutOverflowState);
                obj2 = flowLayoutOverflowState;
            }
            FlowLayoutOverflowState flowLayoutOverflowState2 = (FlowLayoutOverflowState) obj2;
            int i5 = i3 >> 3;
            boolean zChanged = ((((i5 & 896) ^ 384) > 256 && gapComposer.changed(vertical)) || (i5 & 384) == 256) | ((((i5 & 14) ^ 6) > 4 && gapComposer.changed(arrangement$Horizontal)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && gapComposer.changed(arrangement$Vertical)) || (i5 & 48) == 32) | ((((i5 & 7168) ^ 3072) > 2048 && gapComposer.changed(Integer.MAX_VALUE)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && gapComposer.changed(Integer.MAX_VALUE)) || (i5 & 24576) == 16384) | gapComposer.changed(flowLayoutOverflowState2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(arrangement$Horizontal, arrangement$Vertical, arrangement$Horizontal.mo112getSpacingD9Ej5fM(), new CrossAxisAlignment$VerticalCrossAxisAlignment(), arrangement$Vertical.mo112getSpacingD9Ej5fM(), flowLayoutOverflowState2);
                gapComposer.updateRememberedValue(flowMeasurePolicy);
                objRememberedValue2 = flowMeasurePolicy;
            }
            FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue2;
            boolean z3 = (i4 == 1048576) | ((i3 & 29360128) == 8388608) | ((i3 & 458752) == 131072);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (z3 || objRememberedValue3 == neverEqualPolicy) {
                ArrayList arrayList = new ArrayList();
                z = true;
                arrayList.add(new ComposableLambdaImpl(true, -1192950673, new CardKt$$ExternalSyntheticLambda1(composableLambdaImpl, true ? 1 : 0)));
                flowRowOverflow.getClass();
                gapComposer.updateRememberedValue(arrayList);
                obj = arrayList;
            } else {
                z = true;
                obj = objRememberedValue3;
            }
            ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(z, 1271844412, new LayoutKt$$ExternalSyntheticLambda0((List) obj, (byte) 0));
            boolean zChanged2 = gapComposer.changed(flowMeasurePolicy2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            Object obj3 = objRememberedValue4;
            if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                MultiContentMeasurePolicyImpl multiContentMeasurePolicyImpl = new MultiContentMeasurePolicyImpl(flowMeasurePolicy2);
                gapComposer.updateRememberedValue(multiContentMeasurePolicyImpl);
                obj3 = multiContentMeasurePolicyImpl;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) obj3;
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl2, gapComposer, true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4(modifier, arrangement$Horizontal, arrangement$Vertical, flowRowOverflow, composableLambdaImpl, i);
        }
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static PaddingValuesImpl m127PaddingValuesYgX7TsA$default(int i, float f) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        return new PaddingValuesImpl(f, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static PaddingValuesImpl m128PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        return new PaddingValuesImpl(f, f2, f3, f4);
    }

    public static final void Spacer(Composer composer, Modifier modifier) {
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.INSTANCE;
        GapComposer gapComposer = (GapComposer) composer;
        int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
        Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifier);
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        gapComposer.startReusableNode();
        if (gapComposer.inserting) {
            gapComposer.createNode(LayoutNode.Constructor);
        } else {
            gapComposer.useNode();
        }
        Stack.m390setimpl(gapComposer, spacerMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
        Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
        Stack.m389reconcileimpl(gapComposer);
        Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
        Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
        gapComposer.end(true);
    }

    /* JADX INFO: renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static FixedDpInsets m129WindowInsetsa9UjIt4$default(float f, float f2, int i) {
        float f3 = (i & 1) != 0 ? 0.0f : 80.0f;
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 8) != 0) {
            f2 = 0.0f;
        }
        return new FixedDpInsets(f3, f, f2);
    }

    public static final InsetsPaddingValues asPaddingValues(WindowInsets windowInsets, Composer composer) {
        return new InsetsPaddingValues(windowInsets, (Density) ((GapComposer) composer).consume(CompositionLocalsKt.LocalDensity));
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo124calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo123calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo123calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo124calculateRightPaddingu2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m130constructorimpl(long j, LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return ConstraintsKt.Constraints(layoutOrientation == layoutOrientation2 ? Constraints.m786getMinWidthimpl(j) : Constraints.m785getMinHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m784getMaxWidthimpl(j) : Constraints.m783getMaxHeightimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m785getMinHeightimpl(j) : Constraints.m786getMinWidthimpl(j), layoutOrientation == layoutOrientation2 ? Constraints.m783getMaxHeightimpl(j) : Constraints.m784getMaxWidthimpl(j));
    }

    public static final Modifier consumeWindowInsets(Modifier modifier, SheetWindowInsets sheetWindowInsets) {
        return modifier.then(new UnionInsetsConsumingModifierElement(sheetWindowInsets));
    }

    public static WindowInsetsHolder current(Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
        WindowInsetsHolder orCreateFor = getOrCreateFor(view);
        boolean zChangedInstance = gapComposer.changedInstance(orCreateFor) | gapComposer.changedInstance(view);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
            objRememberedValue = new BackHandlerKt$$ExternalSyntheticLambda2(orCreateFor, view, (byte) 21);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Stack.DisposableEffect(orCreateFor, (Function1) objRememberedValue, gapComposer);
        return orCreateFor;
    }

    public static WindowInsetsHolder getOrCreateFor(View view) {
        WindowInsetsHolder windowInsetsHolder;
        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
        synchronized (weakHashMap) {
            try {
                Object windowInsetsHolder2 = weakHashMap.get(view);
                if (windowInsetsHolder2 == null) {
                    windowInsetsHolder2 = new WindowInsetsHolder(view);
                    weakHashMap.put(view, windowInsetsHolder2);
                }
                windowInsetsHolder = (WindowInsetsHolder) windowInsetsHolder2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return windowInsetsHolder;
    }

    public static final RowColumnParentData getRowColumnParentData(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        return rowColumnParentData != null ? rowColumnParentData.weight : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public static final Modifier height() {
        return new IntrinsicHeightElement();
    }

    /* JADX INFO: renamed from: isSatisfiedBy-NN6Ew-U, reason: not valid java name */
    public static final boolean m132isSatisfiedByNN6EwU(int i, int i2, long j) {
        int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
        if (i > Constraints.m784getMaxWidthimpl(j) || iM786getMinWidthimpl > i) {
            return false;
        }
        return i2 <= Constraints.m783getMaxHeightimpl(j) && Constraints.m785getMinHeightimpl(j) <= i2;
    }

    public static final MeasureResult measure(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8) {
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        List list2 = list;
        long j = i5;
        int i13 = i7 - i6;
        int[] iArr2 = new int[i13];
        int i14 = i6;
        int iMax = 0;
        int i15 = 0;
        int i16 = 0;
        int iMin = 0;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        while (i14 < i7) {
            Measurable measurable = (Measurable) list2.get(i14);
            float weight = getWeight(getRowColumnParentData(measurable));
            if (weight > CropImageView.DEFAULT_ASPECT_RATIO) {
                f2 += weight;
                i15++;
                i10 = i14;
            } else {
                int i17 = i3 - i16;
                Placeable placeableMo598measureBRTryo0 = placeableArr[i14];
                if (placeableMo598measureBRTryo0 == null) {
                    if (i3 == Integer.MAX_VALUE) {
                        i10 = i14;
                        i11 = i15;
                        i12 = Integer.MAX_VALUE;
                    } else {
                        i10 = i14;
                        i11 = i15;
                        i12 = i17 < 0 ? 0 : i17;
                    }
                    placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(rowColumnMeasurePolicy.mo119createConstraintsxF2OJ5Q(0, i12, i4, false));
                } else {
                    i10 = i14;
                    i11 = i15;
                }
                Placeable placeable = placeableMo598measureBRTryo0;
                int iMainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable);
                int iCrossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable);
                iArr2[i10 - i6] = iMainAxisSize;
                int i18 = i17 - iMainAxisSize;
                if (i18 < 0) {
                    i18 = 0;
                }
                iMin = Math.min(i5, i18);
                i16 += iMainAxisSize + iMin;
                iMax = Math.max(iMax, iCrossAxisSize);
                placeableArr[i10] = placeable;
                i15 = i11;
            }
            i14 = i10 + 1;
            j = j;
        }
        long j2 = j;
        int i19 = i15;
        if (i19 == 0) {
            i16 -= iMin;
            i9 = 0;
        } else {
            long j3 = ((long) (i19 - 1)) * j2;
            long jRound = ((long) ((i3 != Integer.MAX_VALUE ? i3 : i) - i16)) - j3;
            if (jRound < 0) {
                jRound = 0;
            }
            float f3 = jRound / f2;
            for (int i20 = i6; i20 < i7; i20++) {
                jRound -= (long) Math.round(getWeight(getRowColumnParentData((Measurable) list2.get(i20))) * f3);
            }
            int i21 = i6;
            int i22 = iMax;
            int i23 = 0;
            while (i21 < i7) {
                if (placeableArr[i21] == null) {
                    Measurable measurable2 = (Measurable) list2.get(i21);
                    f = f3;
                    RowColumnParentData rowColumnParentData = getRowColumnParentData(measurable2);
                    float weight2 = getWeight(rowColumnParentData);
                    if (weight2 <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        InlineClassHelperKt.throwIllegalStateException("All weights <= 0 should have placeables");
                    }
                    int iSignum = Long.signum(jRound);
                    long j4 = jRound - ((long) iSignum);
                    int iMax2 = Math.max(0, Math.round(weight2 * f) + iSignum);
                    Placeable placeableMo598measureBRTryo1 = measurable2.mo598measureBRTryo0(rowColumnMeasurePolicy.mo119createConstraintsxF2OJ5Q((!(rowColumnParentData != null ? rowColumnParentData.fill : true) || iMax2 == Integer.MAX_VALUE) ? 0 : iMax2, iMax2, i4, true));
                    int iMainAxisSize2 = rowColumnMeasurePolicy.mainAxisSize(placeableMo598measureBRTryo1);
                    int iCrossAxisSize2 = rowColumnMeasurePolicy.crossAxisSize(placeableMo598measureBRTryo1);
                    iArr2[i21 - i6] = iMainAxisSize2;
                    i23 += iMainAxisSize2;
                    int iMax3 = Math.max(i22, iCrossAxisSize2);
                    placeableArr[i21] = placeableMo598measureBRTryo1;
                    i22 = iMax3;
                    jRound = j4;
                } else {
                    f = f3;
                }
                i21++;
                list2 = list;
                f3 = f;
            }
            i9 = (int) (((long) i23) + j3);
            int i24 = i3 - i16;
            if (i9 < 0) {
                i9 = 0;
            }
            if (i9 > i24) {
                i9 = i24;
            }
            iMax = i22;
        }
        int i25 = i9 + i16;
        if (i25 < 0) {
            i25 = 0;
        }
        int iMax4 = Math.max(i25, i);
        int iMax5 = Math.max(iMax, Math.max(i2, 0));
        int[] iArr3 = new int[i13];
        rowColumnMeasurePolicy.populateMainAxisPositions(iMax4, iArr2, iArr3, measureScope);
        return rowColumnMeasurePolicy.placeHelper(placeableArr, measureScope, iArr3, iMax4, iMax5, iArr, i8, i6, i7);
    }

    public static final Modifier offset(Modifier modifier, Function1 function1) {
        return modifier.then(new OffsetPxElement(function1, new CodecsKt$$ExternalSyntheticLambda0(function1, (byte) 7)));
    }

    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m133offsetVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new OffsetElement(f, f2, new OffsetKt$$ExternalSyntheticLambda0((byte) 0)));
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier modifier, Function1 function1) {
        return modifier.then(new ConsumedInsetsModifierElement(function1));
    }

    /* JADX INFO: renamed from: only-bOOhFvg, reason: not valid java name */
    public static final LimitInsets m134onlybOOhFvg(WindowInsets windowInsets, int i) {
        return new LimitInsets(windowInsets, i);
    }

    public static final Modifier padding(Modifier modifier, PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new OffsetKt$$ExternalSyntheticLambda0((byte) 6)));
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m135padding3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new PaddingElement(f, f, f, f, new OffsetKt$$ExternalSyntheticLambda0((byte) 8)));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m136paddingVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, new OffsetKt$$ExternalSyntheticLambda0((byte) 7)));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static Modifier m137paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return m136paddingVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m138paddingqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, new OffsetKt$$ExternalSyntheticLambda0((byte) 9)));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static Modifier m139paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        return m138paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    public static void placeCenter$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = (i - i3) / 2.0f;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = Math.round(f);
                f += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = Math.round(f);
            f += i7;
        }
    }

    public static void placeSpaceBetween$foundation_layout(int i, int[] iArr, int[] iArr2, boolean z) {
        if (iArr.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float fMax = (i - i3) / Math.max(iArr.length - 1, 1);
        float f = (z && iArr.length == 1) ? fMax : CropImageView.DEFAULT_ASPECT_RATIO;
        if (z) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i5 = iArr[length];
                iArr2[length] = Math.round(f);
                f += i5 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i6 = 0;
        while (i2 < length2) {
            int i7 = iArr[i2];
            iArr2[i6] = Math.round(f);
            f += i7 + fMax;
            i2++;
            i6++;
        }
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m140plusgK_yJZ4(int i, int i2) {
        return i | i2;
    }

    /* JADX INFO: renamed from: spacedBy-0680j_4, reason: not valid java name */
    public static Arrangement$SpacedAligned m141spacedBy0680j_4(float f) {
        return new Arrangement$SpacedAligned(f, true, new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 5));
    }

    /* JADX INFO: renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m142toBoxConstraintsOenEA2s(long j) {
        return ConstraintsKt.Constraints(Constraints.m786getMinWidthimpl(j), Constraints.m784getMaxWidthimpl(j), Constraints.m785getMinHeightimpl(j), Constraints.m783getMaxHeightimpl(j));
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static ValueInsets valueInsetsIgnoringVisibility(int i, String str) {
        return new ValueInsets(new InsetsValues(0, 0, 0, 0), str);
    }

    public static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public static final Modifier width(Modifier modifier, IntrinsicSize intrinsicSize) {
        return modifier.then(new IntrinsicWidthElement(intrinsicSize));
    }

    public static final Modifier windowInsetsPadding(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new InsetsPaddingModifierElement(windowInsets));
    }

    public int align$foundation_layout(int i, int i2, LayoutDirection layoutDirection) {
        return Math.round((1.0f - 1.0f) * ((i - i2) / 2.0f));
    }

    public static final Modifier windowInsetsPadding(Modifier modifier, Function1 function1) {
        return modifier.then(new SystemInsetsPaddingModifierElement(function1));
    }

    public static final void FlowRow(Modifier modifier, Arrangement$Horizontal arrangement$Horizontal, Arrangement$Vertical arrangement$Vertical, Alignment.Vertical vertical, int i, int i2, final ComposableLambdaImpl composableLambdaImpl, Composer composer, final int i3, final int i4) {
        int i5;
        final Modifier modifier2;
        final Arrangement$Horizontal arrangement$Horizontal2;
        final Arrangement$Vertical arrangement$Vertical2;
        final int i6;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-1303174015);
        int i7 = i4 & 1;
        if (i7 != 0) {
            i5 = i3 | 6;
        } else {
            i5 = (gapComposer.changed(modifier) ? 4 : 2) | i3;
        }
        int i8 = i4 & 2;
        if (i8 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= gapComposer.changed(arrangement$Horizontal) ? 32 : 16;
        }
        int i9 = i4 & 4;
        if (i9 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= gapComposer.changed(arrangement$Vertical) ? 256 : 128;
        }
        int i10 = i5 | 224256;
        if (gapComposer.shouldExecute(i10 & 1, (599187 & i10) != 599186)) {
            if (i7 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i8 != 0) {
                arrangement$Horizontal = Start;
            }
            if (i9 != 0) {
                arrangement$Vertical = Top;
            }
            Arrangement$Vertical arrangement$Vertical3 = arrangement$Vertical;
            vertical = Alignment.Companion.Top;
            int i11 = (i10 & 14) | 1572864 | (i10 & 112) | (i10 & 896) | 12807168;
            Arrangement$Horizontal arrangement$Horizontal3 = arrangement$Horizontal;
            FlowRow(modifier3, arrangement$Horizontal3, arrangement$Vertical3, FlowRowOverflow.Clip, composableLambdaImpl, gapComposer, i11);
            i = Integer.MAX_VALUE;
            i6 = Integer.MAX_VALUE;
            arrangement$Vertical2 = arrangement$Vertical3;
            arrangement$Horizontal2 = arrangement$Horizontal3;
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            arrangement$Horizontal2 = arrangement$Horizontal;
            arrangement$Vertical2 = arrangement$Vertical;
            i6 = i2;
        }
        final Alignment.Vertical vertical2 = vertical;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final int i12 = i;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    OffsetKt.FlowRow(modifier2, arrangement$Horizontal2, arrangement$Vertical2, vertical2, i12, i6, composableLambdaImpl, (Composer) obj, Stack.updateChangedFlags(i3 | 1), i4);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
