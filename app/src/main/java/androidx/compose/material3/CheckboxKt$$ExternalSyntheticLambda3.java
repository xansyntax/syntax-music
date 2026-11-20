package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CheckboxKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function0 f$6;
    public final /* synthetic */ int f$8;

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda3(int i, CheckboxColors checkboxColors, Modifier modifier, ToggleableState toggleableState, Function0 function0, boolean z) {
        this.f$0 = modifier;
        this.f$1 = z;
        this.f$2 = toggleableState;
        this.f$3 = checkboxColors;
        this.f$6 = function0;
        this.f$8 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        int i = this.f$8;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Object obj5 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                CardKt.CheckboxImpl(iUpdateChangedFlags, (CheckboxColors) obj3, (Composer) obj, (Modifier) obj5, (ToggleableState) obj4, this.f$6, this.f$1);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                TimePickerKt.ToggleItem(this.f$1, this.f$6, (TimeInputColors) obj5, (Shape) obj4, (ComposableLambdaImpl) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(196609);
                int i2 = this.f$8;
                boolean z = this.f$1;
                Function0 function0 = this.f$6;
                TimePickerKt.m356TimeSelectoriO60bNI((Modifier) obj5, i2, (TimePickerState) obj4, z ? 1 : 0, (TimeInputColors) obj3, function0, (Composer) obj, iUpdateChangedFlags3);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda3(Modifier modifier, int i, TimePickerState timePickerState, int i2, TimeInputColors timeInputColors, Function0 function0, int i3) {
        this.f$0 = modifier;
        this.f$8 = i;
        this.f$2 = timePickerState;
        this.f$1 = i2;
        this.f$3 = timeInputColors;
        this.f$6 = function0;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda3(boolean z, Function0 function0, TimeInputColors timeInputColors, Shape shape, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.f$1 = z;
        this.f$6 = function0;
        this.f$0 = timeInputColors;
        this.f$2 = shape;
        this.f$3 = composableLambdaImpl;
        this.f$8 = i;
    }
}
