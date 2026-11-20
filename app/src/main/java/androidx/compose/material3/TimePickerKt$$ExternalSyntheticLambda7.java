package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TimePickerState f$0;
    public final /* synthetic */ TimePickerColors f$1;
    public final /* synthetic */ int f$3;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda7(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = timePickerState;
        this.f$1 = timePickerColors;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        TimePickerColors timePickerColors = this.f$1;
        TimePickerState timePickerState = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                TimePickerKt.VerticalClockDisplay(timePickerState, timePickerColors, composer, Stack.updateChangedFlags(i | 1));
                break;
            case 1:
                TimePickerKt.HorizontalClockDisplay(timePickerState, timePickerColors, composer, Stack.updateChangedFlags(i | 1));
                break;
            default:
                TimePickerKt.ClockDisplayNumbers(timePickerState, timePickerColors, composer, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }
}
