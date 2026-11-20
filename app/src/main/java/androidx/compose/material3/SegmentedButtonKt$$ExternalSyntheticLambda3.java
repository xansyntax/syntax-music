package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SegmentedButtonKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;
    public final /* synthetic */ PaddingValues f$2;

    public /* synthetic */ SegmentedButtonKt$$ExternalSyntheticLambda3(Function2 function2, ComposableLambdaImpl composableLambdaImpl, PaddingValues paddingValues) {
        this.f$0 = function2;
        this.f$1 = composableLambdaImpl;
        this.f$2 = paddingValues;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PaddingValues paddingValues = this.f$2;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        Function2 function2 = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ScrimKt.SegmentedButtonContent(function2, composableLambdaImpl, paddingValues, gapComposer, 0);
                }
                break;
            default:
                num.getClass();
                ScrimKt.SegmentedButtonContent(function2, composableLambdaImpl, paddingValues, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ SegmentedButtonKt$$ExternalSyntheticLambda3(Function2 function2, ComposableLambdaImpl composableLambdaImpl, PaddingValues paddingValues, int i) {
        this.f$0 = function2;
        this.f$1 = composableLambdaImpl;
        this.f$2 = paddingValues;
    }
}
