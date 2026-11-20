package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.unit.IntOffset;
import coil3.size.SizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda46 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda46(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        MutableState mutableState2 = this.f$1;
        MutableState mutableState3 = this.f$0;
        switch (b) {
            case 0:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                LayoutCoordinates parentCoordinates = layoutCoordinates.getParentCoordinates();
                mutableState3.setValue(new IntOffset(parentCoordinates != null ? SizeKt.m866getCenterozmzZPI(parentCoordinates.mo603getSizeYbymL2g()) : 0L));
                mutableState2.setValue(RulerKt.boundsInParent(layoutCoordinates));
                mutableState.setValue(new Offset(((Rect) mutableState2.getValue()).m443getCenterF1C5BW0()));
                break;
            case 1:
                String str = (String) obj;
                str.getClass();
                mutableState2.setValue(str);
                mutableState.setValue(Boolean.TRUE);
                mutableState3.setValue(null);
                break;
            case 2:
                String str2 = (String) obj;
                str2.getClass();
                if (!str2.equals("custom_input")) {
                    mutableState.setValue(str2);
                    mutableState2.setValue(Boolean.FALSE);
                } else {
                    mutableState3.setValue(Boolean.TRUE);
                    mutableState2.setValue(Boolean.FALSE);
                }
                break;
            default:
                Boolean bool = (Boolean) obj;
                boolean zBooleanValue = bool.booleanValue();
                mutableState3.setValue(bool);
                if (!zBooleanValue) {
                    mutableState2.setValue("");
                    mutableState.setValue("");
                }
                break;
        }
        return unit;
    }
}
