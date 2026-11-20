package androidx.compose.material3;

import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipKt$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Function2 f$1;

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda13(long j, Function2 function2, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
        this.f$1 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function2 function2 = this.f$1;
        long j = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), function2, gapComposer, 8);
                }
                break;
            case 1:
                int iIntValue2 = num.intValue();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    Stack.CompositionLocalProvider(Fragment$5$$ExternalSyntheticOutline0.m(j, ContentColorKt.LocalContentColor), function2, gapComposer2, 8);
                }
                break;
            case 2:
                num.getClass();
                ListItemKt.m303SupportingDecoratorrcwGITA(j, function2, composer, Stack.updateChangedFlags(1));
                break;
            case 3:
                int iIntValue3 = num.intValue();
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    Icons$Filled.m369DecorationIv8Zu3U(j, function2, gapComposer3, 0);
                }
                break;
            case 4:
                int iIntValue4 = num.intValue();
                GapComposer gapComposer4 = (GapComposer) composer;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    Icons$Filled.m369DecorationIv8Zu3U(j, function2, gapComposer4, 0);
                }
                break;
            default:
                num.getClass();
                Icons$Filled.m369DecorationIv8Zu3U(j, function2, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipKt$$ExternalSyntheticLambda13(long j, Function2 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = j;
        this.f$1 = function2;
    }
}
