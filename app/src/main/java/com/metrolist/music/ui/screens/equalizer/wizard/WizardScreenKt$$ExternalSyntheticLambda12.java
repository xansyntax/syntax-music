package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WizardScreenKt$$ExternalSyntheticLambda12 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ WizardState f$0;

    public /* synthetic */ WizardScreenKt$$ExternalSyntheticLambda12(WizardState wizardState, byte b) {
        this.$r8$classId = b;
        this.f$0 = wizardState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        WizardState wizardState = this.f$0;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    TextKt.m352TextNvy7gAk(wizardState.error, null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return unit;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    int iOrdinal = wizardState.currentStep.ordinal();
                    if (iOrdinal == 0) {
                        i = 485352443;
                        i2 = R.string.wizard_select_model;
                    } else {
                        if (iOrdinal != 1) {
                            throw Format$$ExternalSyntheticOutline0.m(gapComposer2, 485349942, false);
                        }
                        i = 485355806;
                        i2 = R.string.wizard_select_profiles;
                    }
                    TextKt.m352TextNvy7gAk(Format$$ExternalSyntheticOutline0.m(gapComposer2, i, i2, gapComposer2, false), null, 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262142);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return unit;
        }
    }
}
