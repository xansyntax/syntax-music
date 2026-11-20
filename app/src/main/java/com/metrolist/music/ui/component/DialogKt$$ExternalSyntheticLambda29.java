package com.metrolist.music.ui.component;

import androidx.compose.foundation.layout.FlowRowScopeInstance;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogKt$$ExternalSyntheticLambda29 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function3 f$0;
    public final /* synthetic */ FlowRowScopeInstance f$1;

    public /* synthetic */ DialogKt$$ExternalSyntheticLambda29(Function3 function3, FlowRowScopeInstance flowRowScopeInstance, byte b) {
        this.$r8$classId = b;
        this.f$0 = function3;
        this.f$1 = flowRowScopeInstance;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        FlowRowScopeInstance flowRowScopeInstance = this.f$1;
        Function3 function3 = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.ProvideTextStyle(TextStyle.m750copyp1EtxEg$default(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge, 0L, 0L, FontWeight.Bold, null, null, null, 0L, 0L, null, null, 16777211), Expect_jvmKt.rememberComposableLambda(-1491035507, new DialogKt$$ExternalSyntheticLambda29(function3, flowRowScopeInstance, b2), gapComposer), gapComposer, 48);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    function3.invoke(flowRowScopeInstance, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
