package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.Modifier;
import com.metrolist.music.MainActivityKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.player.MiniPlayerKt$$ExternalSyntheticLambda17;
import com.metrolist.music.ui.screens.settings.PlayerSettingsKt$$ExternalSyntheticLambda92;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WizardScreenKt$$ExternalSyntheticLambda16 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Function f$2;

    public /* synthetic */ WizardScreenKt$$ExternalSyntheticLambda16(boolean z, boolean z2, Function0 function0) {
        this.$r8$classId = (byte) 0;
        this.f$0 = z;
        this.f$1 = z2;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function function = this.f$2;
        switch (b) {
            case 0:
                Function0 function0 = (Function0) function;
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    float fMo122calculateBottomPaddingD9Ej5fM = OffsetKt.asPaddingValues((WindowInsets) gapComposer.consume(MainActivityKt.LocalPlayerAwareWindowInsets), gapComposer).mo122calculateBottomPaddingD9Ej5fM();
                    boolean z = this.f$0;
                    boolean z2 = this.f$1;
                    CardKt.Button(function0, SizeKt.m145height3ABfNKs(OffsetKt.m138paddingqDBjuR0(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16.0f, 16.0f, 16.0f, fMo122calculateBottomPaddingD9Ej5fM + 16.0f + CropImageView.DEFAULT_ASPECT_RATIO), 56.0f), z && !z2, null, null, null, null, null, null, Expect_jvmKt.rememberComposableLambda(-970103746, new MiniPlayerKt$$ExternalSyntheticLambda17((byte) 3, z2), gapComposer), gapComposer, 805306368, 504);
                }
                break;
            case 1:
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0 = (MimesKt$$ExternalSyntheticLambda0) function;
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z3 = this.f$0;
                    MenuKt.Switch(z3, mimesKt$$ExternalSyntheticLambda0, null, Expect_jvmKt.rememberComposableLambda(-1278837736, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 17, z3), gapComposer2), this.f$1, null, gapComposer2, 3072, 100);
                }
                break;
            default:
                MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda1 = (MimesKt$$ExternalSyntheticLambda0) function;
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    boolean z4 = this.f$0;
                    MenuKt.Switch(z4, mimesKt$$ExternalSyntheticLambda1, null, Expect_jvmKt.rememberComposableLambda(-298086954, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 18, z4), gapComposer3), this.f$1, null, gapComposer3, 3072, 100);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ WizardScreenKt$$ExternalSyntheticLambda16(boolean z, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, boolean z2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$2 = mimesKt$$ExternalSyntheticLambda0;
        this.f$1 = z2;
    }
}
