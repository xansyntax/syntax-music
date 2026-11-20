package androidx.compose.material3;

import androidx.collection.MutableIntList;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import com.metrolist.music.ui.component.AppNavigationKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$10;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$9;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda7(SelectableChipColors selectableChipColors, boolean z, boolean z2, ComposableLambdaImpl composableLambdaImpl, TextStyle textStyle, Function2 function2, Arrangement$Horizontal arrangement$Horizontal, PaddingValues paddingValues) {
        this.f$0 = selectableChipColors;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$3 = composableLambdaImpl;
        this.f$4 = textStyle;
        this.f$5 = function2;
        this.f$9 = arrangement$Horizontal;
        this.f$10 = paddingValues;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final boolean z = true;
        Object obj3 = this.f$10;
        Object obj4 = this.f$9;
        Object obj5 = this.f$4;
        Object obj6 = this.f$5;
        Object obj7 = this.f$3;
        Object obj8 = this.f$0;
        switch (b) {
            case 0:
                SelectableChipColors selectableChipColors = (SelectableChipColors) obj8;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj7;
                TextStyle textStyle = (TextStyle) obj5;
                Function2 function2 = (Function2) obj6;
                Arrangement$Horizontal arrangement$Horizontal = (Arrangement$Horizontal) obj4;
                PaddingValues paddingValues = (PaddingValues) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean z2 = this.f$1;
                    boolean z3 = this.f$2;
                    ChipKt.m274AnimatingChipContentlRyMtFw(composableLambdaImpl, textStyle, z2 ? !z3 ? selectableChipColors.labelColor : selectableChipColors.selectedLabelColor : selectableChipColors.disabledLabelColor, function2, z2 ? !z3 ? selectableChipColors.leadingIconColor : selectableChipColors.selectedLeadingIconColor : selectableChipColors.disabledLeadingIconColor, z2 ? !z3 ? selectableChipColors.trailingIconColor : selectableChipColors.selectedTrailingIconColor : selectableChipColors.disabledTrailingIconColor, arrangement$Horizontal, paddingValues, CardKt.m272valueyDoVZcs(5, gapComposer), CardKt.m272valueyDoVZcs(4, gapComposer), CardKt.m272valueyDoVZcs(1, gapComposer), CardKt.m272valueyDoVZcs(3, gapComposer), gapComposer, 0);
                }
                break;
            case 1:
                FocusRequester focusRequester = (FocusRequester) obj8;
                FocusRequester focusRequester2 = (FocusRequester) obj7;
                AnalogTimePickerState analogTimePickerState = (AnalogTimePickerState) obj5;
                FocusOwner focusOwner = (FocusOwner) obj6;
                final FocusRequester focusRequester3 = (FocusRequester) obj4;
                final FocusRequester focusRequester4 = (FocusRequester) obj3;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                MutableIntList mutableIntList = TimePickerKt.ExtraHours;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    int i = mutableIntList._size;
                    int i2 = 0;
                    while (i2 < i) {
                        int i3 = mutableIntList.get(i2);
                        int i4 = i2 + 12;
                        boolean z4 = z;
                        if (i2 != 0) {
                            z = false;
                        }
                        final boolean z5 = i2 == mutableIntList._size + (-1) ? z4 : false;
                        boolean zChanged = gapComposer2.changed(i4);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        Unit unit2 = unit;
                        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TimePickerKt$$ExternalSyntheticLambda36((byte) 2, i4);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierFocusRequester = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = SemanticsModifierKt.semantics(modifierFocusRequester, false, (Function1) objRememberedValue).then(z ? FocusTraversalKt.focusRequester(modifierFocusRequester, focusRequester) : modifierFocusRequester);
                        if (z5) {
                            modifierFocusRequester = FocusTraversalKt.focusRequester(modifierFocusRequester, focusRequester2);
                        }
                        Modifier modifierThen2 = modifierThen.then(modifierFocusRequester);
                        boolean zChanged2 = gapComposer2.changed(z) | gapComposer2.changed(z5);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda52
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj9) {
                                    FocusProperties focusProperties = (FocusProperties) obj9;
                                    if (z) {
                                        focusProperties.setPrevious(focusRequester3);
                                    }
                                    if (z5) {
                                        focusProperties.setNext(focusRequester4);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        TimePickerKt.ClockText(FocusTraversalKt.focusProperties(modifierThen2, (Function1) objRememberedValue2), analogTimePickerState, i3, this.f$1, focusOwner, this.f$2, gapComposer2, 0);
                        i2++;
                        i = i;
                        z = z4;
                        unit = unit2;
                    }
                }
                break;
            default:
                ((Integer) obj2).getClass();
                AppNavigationKt.AppNavigationBar((List) obj8, (String) obj7, (Function2) obj6, (Modifier) obj5, this.f$1, this.f$2, (Function0) obj4, (Function0) obj3, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda7(FocusRequester focusRequester, FocusRequester focusRequester2, AnalogTimePickerState analogTimePickerState, boolean z, FocusOwner focusOwner, boolean z2, FocusRequester focusRequester3, FocusRequester focusRequester4) {
        this.f$0 = focusRequester;
        this.f$3 = focusRequester2;
        this.f$4 = analogTimePickerState;
        this.f$1 = z;
        this.f$5 = focusOwner;
        this.f$2 = z2;
        this.f$9 = focusRequester3;
        this.f$10 = focusRequester4;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda7(List list, String str, Function2 function2, Modifier modifier, boolean z, boolean z2, Function0 function0, Function0 function1, int i) {
        this.f$0 = list;
        this.f$3 = str;
        this.f$5 = function2;
        this.f$4 = modifier;
        this.f$1 = z;
        this.f$2 = z2;
        this.f$9 = function0;
        this.f$10 = function1;
    }
}
