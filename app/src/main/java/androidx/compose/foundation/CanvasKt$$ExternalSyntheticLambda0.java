package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CanvasKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Modifier f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ CanvasKt$$ExternalSyntheticLambda0(Modifier modifier, Function1 function1, int i) {
        this.f$0 = modifier;
        this.f$1 = function1;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$2;
        Modifier modifier = this.f$0;
        Function1 function1 = this.f$1;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                num.intValue();
                ImageKt.Canvas(Stack.updateChangedFlags(i | 1), composer, modifier, function1);
                break;
            default:
                num.getClass();
                AndroidView_androidKt.AndroidView(Stack.updateChangedFlags(i | 1), composer, modifier, function1);
                break;
        }
        return unit;
    }

    public /* synthetic */ CanvasKt$$ExternalSyntheticLambda0(Function1 function1, Modifier modifier, int i) {
        this.f$1 = function1;
        this.f$0 = modifier;
        this.f$2 = i;
    }
}
