package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CheckboxKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Function f$1;
    public final /* synthetic */ Modifier f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ byte f$6;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda1(boolean z, Function function, Modifier modifier, boolean z2, Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = function;
        this.f$2 = modifier;
        this.f$3 = z2;
        this.f$4 = obj;
        this.f$6 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        byte b2 = this.f$6;
        Object obj3 = this.f$4;
        Function function = this.f$1;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(b2 | 1);
                CardKt.Checkbox(this.f$0, (Function1) function, this.f$2, this.f$3, (CheckboxColors) obj3, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(b2 | 1);
                ScrimKt.RadioButton(this.f$0, (Function0) function, this.f$2, this.f$3, (RadioButtonColors) obj3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
