package androidx.compose.material3;

import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Modifier f$1;
    public final /* synthetic */ Function f$2;
    public final /* synthetic */ byte f$4;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda4(SnackbarHostState snackbarHostState, Modifier modifier, Function3 function3, int i, int i2) {
        this.f$0 = snackbarHostState;
        this.f$1 = modifier;
        this.f$2 = function3;
        this.f$4 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function function = this.f$2;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                ScrimKt.SnackbarHost((SnackbarHostState) obj3, this.f$1, (Function3) function, (Composer) obj, iUpdateChangedFlags, this.f$4);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                ContextMenuUiKt.ContextMenuColumnBuilder(this.f$1, (ContextMenuColors) obj3, (Function1) function, (Composer) obj, iUpdateChangedFlags2, this.f$4);
                break;
        }
        return unit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda4(Modifier modifier, ContextMenuColors contextMenuColors, Function1 function1, int i, int i2) {
        this.f$1 = modifier;
        this.f$0 = contextMenuColors;
        this.f$2 = function1;
        this.f$4 = i2;
    }
}
