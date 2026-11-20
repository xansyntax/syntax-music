package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextFieldDefaults$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ TextFieldDefaults$$ExternalSyntheticLambda1(Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$0;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        int i = iIntValue & 17;
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, i != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    function2.invoke(gapComposer, 0);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, i != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    function2.invoke(gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
