package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListItemKt$$ExternalSyntheticLambda18 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda18(long j, int i) {
        this.$r8$classId = (byte) 0;
        this.f$0 = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                ListItemKt.m302OverlineDecoratorrcwGITA(this.f$0, (Composer) obj, Stack.updateChangedFlags(1));
                break;
            case 1:
                DrawScope drawScope = (DrawScope) obj;
                drawScope.getClass();
                DrawScope.m543drawCircleVaOC9Bg$default(drawScope, this.f$0, drawScope.mo81toPx0680j_4(4.0f), ((Offset) obj2).packedValue, null, 0, 120);
                break;
            case 2:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.skip_next, 0, gapComposer), (String) null, SizeKt.m151size3ABfNKs(companion, 26.0f), this.f$0, gapComposer, 440, 0);
                }
                break;
            case 3:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.fullscreen, 0, gapComposer2), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), this.f$0, gapComposer2, 440, 0);
                }
                break;
            default:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    IconKt.m290Iconww6aTOc(IntMath.painterResource(R.drawable.more_horiz, 0, gapComposer3), (String) null, SizeKt.m151size3ABfNKs(companion, 24.0f), this.f$0, gapComposer3, 440, 0);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ ListItemKt$$ExternalSyntheticLambda18(long j, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
    }
}
