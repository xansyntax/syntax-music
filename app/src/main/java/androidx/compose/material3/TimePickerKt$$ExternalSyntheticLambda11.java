package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda11 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ TimePickerState f$1;
    public final /* synthetic */ TimeInputColors f$2;
    public final /* synthetic */ int f$4;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda11(Modifier modifier, TimePickerState timePickerState, TimeInputColors timeInputColors, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = timePickerState;
        this.f$2 = timeInputColors;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$4;
        TimeInputColors timeInputColors = this.f$2;
        TimePickerState timePickerState = this.f$1;
        Modifier modifier = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                TimePickerKt.VerticalPeriodToggle(modifier, timePickerState, timeInputColors, composer, Stack.updateChangedFlags(i | 1));
                break;
            default:
                TimePickerKt.HorizontalPeriodToggle(modifier, timePickerState, timeInputColors, composer, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }
}
