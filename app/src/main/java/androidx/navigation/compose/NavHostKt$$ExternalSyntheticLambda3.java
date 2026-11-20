package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import coil3.util.FileSystemsKt;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardScreenKt;
import com.metrolist.music.ui.screens.equalizer.wizard.WizardState;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class NavHostKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ Function1 f$5;
    public final /* synthetic */ Function1 f$6;
    public final /* synthetic */ Function f$7;
    public final /* synthetic */ int f$9;

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda3(WizardState wizardState, Function0 function0, Function1 function1, Function1 function2, Function1 function3, Function0 function4, Function0 function5, Function0 function6, int i) {
        this.$r8$classId = (byte) 3;
        this.f$0 = wizardState;
        this.f$1 = function0;
        this.f$4 = function1;
        this.f$5 = function2;
        this.f$6 = function3;
        this.f$2 = function4;
        this.f$3 = function5;
        this.f$7 = function6;
        this.f$9 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$9;
        Function function = this.f$7;
        Object obj3 = this.f$3;
        Object obj4 = this.f$2;
        Object obj5 = this.f$1;
        Object obj6 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                FileSystemsKt.NavHost((NavHostController) obj6, (NavGraph) obj5, (Modifier) obj4, (Alignment) obj3, this.f$4, this.f$5, this.f$6, (Function1) function, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                FileSystemsKt.NavHost((NavHostController) obj6, (NavGraph) obj5, (Modifier) obj4, (Alignment) obj3, this.f$4, this.f$5, this.f$6, (Function1) function, (Composer) obj, iUpdateChangedFlags2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(i | 1);
                FileSystemsKt.NavHost((NavHostController) obj6, (NavGraph) obj5, (Modifier) obj4, (Alignment) obj3, this.f$4, this.f$5, this.f$6, (Function1) function, (Composer) obj, iUpdateChangedFlags3);
                break;
            default:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(i | 1);
                WizardScreenKt.WizardScreenContent((WizardState) obj6, (Function0) obj5, this.f$4, this.f$5, this.f$6, (Function0) obj4, (Function0) obj3, (Function0) function, (Composer) obj, iUpdateChangedFlags4);
                break;
        }
        return unit;
    }

    public /* synthetic */ NavHostKt$$ExternalSyntheticLambda3(NavHostController navHostController, NavGraph navGraph, Modifier modifier, Alignment alignment, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = navGraph;
        this.f$2 = modifier;
        this.f$3 = alignment;
        this.f$4 = function1;
        this.f$5 = function2;
        this.f$6 = function3;
        this.f$7 = function4;
        this.f$9 = i;
    }
}
