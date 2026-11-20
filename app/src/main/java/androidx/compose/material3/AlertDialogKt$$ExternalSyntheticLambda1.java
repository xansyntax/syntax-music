package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ComposableLambdaImpl f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda1(ComposableLambdaImpl composableLambdaImpl, Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = composableLambdaImpl;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$1;
        ComposableLambdaImpl composableLambdaImpl = this.f$0;
        byte b2 = 1;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                    return unit;
                }
                float f = ((Dp) gapComposer.consume(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize)).value;
                if (Float.isNaN(f)) {
                    f = 0.0f;
                }
                PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                Dp dp = new Dp((8.0f - ((f - ButtonDefaults.m250getMinHeightD9Ej5fM()) + CropImageView.DEFAULT_ASPECT_RATIO)) + CropImageView.DEFAULT_ASPECT_RATIO);
                Dp dp2 = new Dp(CropImageView.DEFAULT_ASPECT_RATIO);
                Dp dp3 = new Dp(8.0f);
                if (dp2.compareTo(dp3) > 0) {
                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Cannot coerce value to an empty range: maximum ", dp3, " is less than minimum ", dp2, 46);
                    return null;
                }
                if (dp.compareTo(dp2) < 0) {
                    dp = dp2;
                } else if (dp.compareTo(dp3) > 0) {
                    dp = dp3;
                }
                AlertDialogKt.m238AlertDialogFlowRowixp7dh8(dp.value, Expect_jvmKt.rememberComposableLambda(-459506658, new AlertDialogKt$$ExternalSyntheticLambda1(composableLambdaImpl, function2, b2), gapComposer), gapComposer, 384);
                return unit;
            default:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    composableLambdaImpl.invoke((Object) gapComposer2, (Object) 0);
                    if (function2 == null) {
                        gapComposer2.startReplaceGroup(-1102003461);
                    } else {
                        gapComposer2.startReplaceGroup(795735494);
                        function2.invoke(gapComposer2, 0);
                    }
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }
}
