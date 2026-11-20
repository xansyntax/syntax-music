package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimePickerKt$$ExternalSyntheticLambda23 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ ComposableLambdaImpl f$2;

    public /* synthetic */ TimePickerKt$$ExternalSyntheticLambda23(Modifier modifier, float f, ComposableLambdaImpl composableLambdaImpl, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = modifier;
        this.f$1 = f;
        this.f$2 = composableLambdaImpl;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ComposableLambdaImpl composableLambdaImpl = this.f$2;
        float f = this.f$1;
        Modifier modifier = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                TimePickerKt.CircularLayout(modifier, f, composableLambdaImpl, composer, Stack.updateChangedFlags(385));
                break;
            default:
                ScrimKt.m320SingleChoiceSegmentedButtonRowuFdPcIQ(modifier, f, composableLambdaImpl, composer, Stack.updateChangedFlags(391));
                break;
        }
        return unit;
    }
}
