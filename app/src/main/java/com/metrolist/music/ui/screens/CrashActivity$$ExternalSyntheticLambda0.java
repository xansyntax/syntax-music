package com.metrolist.music.ui.screens;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import coil3.ImageLoader$Builder$$ExternalSyntheticLambda1;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda16;
import com.metrolist.music.ui.theme.ThemeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CrashActivity$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ CrashActivity f$1;

    public /* synthetic */ CrashActivity$$ExternalSyntheticLambda0(String str, CrashActivity crashActivity, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = crashActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        CrashActivity crashActivity = this.f$1;
        String str = this.f$0;
        byte b2 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i = CrashActivity.$r8$clinit;
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    ThemeKt.m1515MetrolistThemeT042LqI(ImageKt.isSystemInDarkTheme(gapComposer), false, 0L, null, Expect_jvmKt.rememberComposableLambda(138546359, new CrashActivity$$ExternalSyntheticLambda0(str, crashActivity, b2), gapComposer), gapComposer, 24576, 14);
                }
                break;
            default:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                int i2 = CrashActivity.$r8$clinit;
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(1 & iIntValue2, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean zChangedInstance = gapComposer2.changedInstance(crashActivity);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ImageLoader$Builder$$ExternalSyntheticLambda1((byte) 13, crashActivity);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChangedInstance2 = gapComposer2.changedInstance(crashActivity) | gapComposer2.changed(str);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new QueueKt$$ExternalSyntheticLambda16(crashActivity, str, (byte) 3);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    AlbumScreenKt.CrashScreen(str, function0, (Function0) objRememberedValue2, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
