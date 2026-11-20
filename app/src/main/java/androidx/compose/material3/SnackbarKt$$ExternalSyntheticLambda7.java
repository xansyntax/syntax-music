package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarKt$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ Function2 f$1;
    public final /* synthetic */ ComposableLambdaImpl f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ long f$5;
    public final /* synthetic */ long f$6;

    public /* synthetic */ SnackbarKt$$ExternalSyntheticLambda7(ComposableLambdaImpl composableLambdaImpl, Function2 function2, Function2 function3, TextStyle textStyle, long j, long j2, int i) {
        this.f$2 = composableLambdaImpl;
        this.f$1 = function2;
        this.f$3 = function3;
        this.f$4 = textStyle;
        this.f$5 = j;
        this.f$6 = j2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        switch (b) {
            case 0:
                Function2 function2 = (Function2) obj4;
                TextStyle textStyle = (TextStyle) obj3;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(1 & iIntValue, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    gapComposer.startReplaceGroup(-168956728);
                    gapComposer.startReplaceGroup(-942207887);
                    ScrimKt.m315LegacyOneRowSnackbarkKq0p4A(this.f$2, this.f$1, function2, textStyle, this.f$5, this.f$6, gapComposer, 0);
                    gapComposer.end(false);
                    gapComposer.end(false);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                ScrimKt.m315LegacyOneRowSnackbarkKq0p4A(this.f$2, this.f$1, (Function2) obj4, (TextStyle) obj3, this.f$5, this.f$6, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                com.metrolist.music.ui.component.MenuKt.m1487NewActionButtonWMdw5o4(this.f$1, (String) obj4, this.f$2, (Modifier) obj3, this.f$5, this.f$6, (Composer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ SnackbarKt$$ExternalSyntheticLambda7(Function2 function2, ComposableLambdaImpl composableLambdaImpl, Function2 function3, TextStyle textStyle, long j, long j2) {
        this.f$1 = function2;
        this.f$2 = composableLambdaImpl;
        this.f$3 = function3;
        this.f$4 = textStyle;
        this.f$5 = j;
        this.f$6 = j2;
    }

    public /* synthetic */ SnackbarKt$$ExternalSyntheticLambda7(Function2 function2, String str, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, long j, long j2, int i) {
        this.f$1 = function2;
        this.f$3 = str;
        this.f$2 = composableLambdaImpl;
        this.f$4 = modifier;
        this.f$5 = j;
        this.f$6 = j2;
    }
}
