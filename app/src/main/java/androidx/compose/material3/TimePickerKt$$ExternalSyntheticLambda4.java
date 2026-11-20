package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ AnalogTimePickerState f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ TimePickerColors f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ int f$5;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda4(Modifier modifier, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, boolean z, int i) {
        this.$r8$classId = (byte) 2;
        this.f$1 = modifier;
        this.f$0 = analogTimePickerState;
        this.f$2 = timePickerColors;
        this.f$3 = z;
        this.f$5 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$5;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                TimePickerKt.VerticalTimePicker(Stack.updateChangedFlags(i | 1), this.f$0, this.f$2, (Composer) obj, this.f$1, this.f$3);
                break;
            case 1:
                ((Integer) obj2).getClass();
                TimePickerKt.HorizontalTimePicker(Stack.updateChangedFlags(i | 1), this.f$0, this.f$2, (Composer) obj, this.f$1, this.f$3);
                break;
            default:
                ((Integer) obj2).intValue();
                TimePickerKt.ClockFace(Stack.updateChangedFlags(i | 1), this.f$0, this.f$2, (Composer) obj, this.f$1, this.f$3);
                break;
        }
        return unit;
    }

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda4(AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = analogTimePickerState;
        this.f$1 = modifier;
        this.f$2 = timePickerColors;
        this.f$3 = z;
        this.f$5 = i;
    }
}
