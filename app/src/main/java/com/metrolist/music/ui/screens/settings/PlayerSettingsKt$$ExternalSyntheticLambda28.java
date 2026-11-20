package com.metrolist.music.ui.screens.settings;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.screens.StatsScreenKt$$ExternalSyntheticLambda7;
import com.yalantis.ucrop.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerSettingsKt$$ExternalSyntheticLambda28 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ PlayerSettingsKt$$ExternalSyntheticLambda28(boolean z, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String strM;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.Empty) {
                        objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda7(mutableState, (byte) 27);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    boolean z = this.f$0;
                    MenuKt.Switch(z, (Function1) objRememberedValue, null, Expect_jvmKt.rememberComposableLambda(2050414590, new PlayerSettingsKt$$ExternalSyntheticLambda14((byte) 21, z), gapComposer), false, null, gapComposer, 3120, 116);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z2 = this.f$0;
                    if (z2) {
                        gapComposer2.startReplaceGroup(-1243106188);
                        gapComposer2.end(false);
                        strM = (String) mutableState.getValue();
                    } else {
                        strM = Format$$ExternalSyntheticOutline0.m(gapComposer2, -1243105524, R.string.not_logged_in, gapComposer2, false);
                    }
                    TextKt.m352TextNvy7gAk(strM, ClipKt.alpha(Modifier.Companion.$$INSTANCE, z2 ? 1.0f : 0.5f), 0L, 0L, null, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262140);
                }
                break;
        }
        return unit;
    }
}
