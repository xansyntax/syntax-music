package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SliderDefaults$Track$4$1 implements Function3 {
    public static final SliderDefaults$Track$4$1 INSTANCE = new SliderDefaults$Track$4$1(0);
    public static final SliderDefaults$Track$4$1 INSTANCE$1 = new SliderDefaults$Track$4$1(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ SliderDefaults$Track$4$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                long j = ((Offset) obj2).packedValue;
                long j2 = ((Color) obj3).value;
                SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                SliderDefaults.m329drawStopIndicatorx3O1jOs((DrawScope) obj, j, j2);
                break;
            default:
                long j3 = ((Offset) obj2).packedValue;
                long j4 = ((Color) obj3).value;
                SliderDefaults sliderDefaults2 = SliderDefaults.INSTANCE;
                SliderDefaults.m329drawStopIndicatorx3O1jOs((DrawScope) obj, j3, j4);
                break;
        }
        return unit;
    }
}
