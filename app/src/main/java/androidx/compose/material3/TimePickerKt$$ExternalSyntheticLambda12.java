package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda12 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TimePickerState f$0;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda12(TimePickerState timePickerState, byte b) {
        this.$r8$classId = b;
        this.f$0 = timePickerState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        TimePickerState timePickerState = this.f$0;
        switch (b) {
            case 0:
                if (timePickerState instanceof AnalogTimePickerState) {
                    ((AnalogTimePickerState) timePickerState).setDialFocusable(true);
                }
                break;
            case 1:
                if (TimePickerKt.isPm(timePickerState) && TimePickerKt.isValidHour(timePickerState, timePickerState.getHourInput())) {
                    timePickerState.setHour(timePickerState.getHour() - 12);
                }
                break;
            default:
                if (!TimePickerKt.isPm(timePickerState) && TimePickerKt.isValidHour(timePickerState, timePickerState.getHourInput())) {
                    timePickerState.setHour(timePickerState.getHour() + 12);
                }
                break;
        }
        return unit;
    }
}
