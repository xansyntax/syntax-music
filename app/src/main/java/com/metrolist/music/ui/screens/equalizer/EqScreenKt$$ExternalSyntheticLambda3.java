package com.metrolist.music.ui.screens.equalizer;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EqScreenKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ EQViewModel f$0;

    public /* synthetic */ EqScreenKt$$ExternalSyntheticLambda3(EQViewModel eQViewModel) {
        this.f$0 = eQViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        EQViewModel eQViewModel = this.f$0;
        Composer composer = (Composer) obj;
        Integer num = (Integer) obj2;
        switch (b) {
            case 0:
                int iIntValue = num.intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer.changedInstance(eQViewModel);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new EqScreenKt$$ExternalSyntheticLambda2(eQViewModel, (byte) 1);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    CardKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, EqScreenKt.lambda$1480777075, gapComposer, 805306368, 510);
                }
                break;
            default:
                num.getClass();
                EqScreenKt.EqScreen(eQViewModel, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }

    public /* synthetic */ EqScreenKt$$ExternalSyntheticLambda3(EQViewModel eQViewModel, int i) {
        this.f$0 = eQViewModel;
    }
}
