package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContextMenu_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextFieldSelectionManager f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ContextMenu_androidKt$$ExternalSyntheticLambda0(TextFieldSelectionManager textFieldSelectionManager, ComposableLambdaImpl composableLambdaImpl, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = textFieldSelectionManager;
        this.f$1 = composableLambdaImpl;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        TextFieldSelectionManager textFieldSelectionManager = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                BasicTextKt.ContextMenuArea(textFieldSelectionManager, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
            default:
                BasicTextKt.CommonContextMenuArea(textFieldSelectionManager, composableLambdaImpl, composer, Stack.updateChangedFlags(i | 1));
                break;
        }
        return unit;
    }
}
