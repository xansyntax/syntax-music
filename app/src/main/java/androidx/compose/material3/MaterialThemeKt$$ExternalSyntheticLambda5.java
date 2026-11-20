package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MaterialThemeKt$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Typography f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ MaterialThemeKt$$ExternalSyntheticLambda5(Typography typography, Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = typography;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$1;
        Typography typography = this.f$0;
        byte b2 = 1;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    PrecisionPointer_androidKt.EnsurePrecisionPointerListenersRegistered(Expect_jvmKt.rememberComposableLambda(-241536773, new MaterialThemeKt$$ExternalSyntheticLambda5(typography, function2, b2), gapComposer), gapComposer, 6);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.ProvideTextStyle(typography.bodyLarge, function2, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
