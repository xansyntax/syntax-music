package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.Expect_jvmKt;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda26;
import io.ktor.http.MimesKt$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PrivacySettingsKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MimesKt$$ExternalSyntheticLambda0 f$1;

    public /* synthetic */ PrivacySettingsKt$$ExternalSyntheticLambda1(byte b, MimesKt$$ExternalSyntheticLambda0 mimesKt$$ExternalSyntheticLambda0, boolean z) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = mimesKt$$ExternalSyntheticLambda0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Composer composer = (Composer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        switch (b) {
            case 0:
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    boolean z = this.f$0;
                    MenuKt.Switch(z, this.f$1, null, Expect_jvmKt.rememberComposableLambda(714385793, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 6, z), gapComposer), false, null, gapComposer, 3072, 116);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    boolean z2 = this.f$0;
                    MenuKt.Switch(z2, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-962016619, new SongMenuKt$$ExternalSyntheticLambda26((byte) 24, z2), gapComposer2), false, null, gapComposer2, 3072, 116);
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) composer;
                if (!gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    boolean z3 = this.f$0;
                    MenuKt.Switch(z3, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-2111757587, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 8, z3), gapComposer3), false, null, gapComposer3, 3072, 116);
                }
                break;
            case 3:
                GapComposer gapComposer4 = (GapComposer) composer;
                if (!gapComposer4.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    boolean z4 = this.f$0;
                    MenuKt.Switch(z4, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1485726652, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 7, z4), gapComposer4), false, null, gapComposer4, 3072, 116);
                }
                break;
            case 4:
                GapComposer gapComposer5 = (GapComposer) composer;
                if (!gapComposer5.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    boolean z5 = this.f$0;
                    MenuKt.Switch(z5, this.f$1, null, Expect_jvmKt.rememberComposableLambda(295494524, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 10, z5), gapComposer5), false, null, gapComposer5, 3072, 116);
                }
                break;
            case 5:
                GapComposer gapComposer6 = (GapComposer) composer;
                if (!gapComposer6.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                } else {
                    boolean z6 = this.f$0;
                    MenuKt.Switch(z6, this.f$1, null, Expect_jvmKt.rememberComposableLambda(1848581885, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 9, z6), gapComposer6), false, null, gapComposer6, 3072, 116);
                }
                break;
            case 6:
                GapComposer gapComposer7 = (GapComposer) composer;
                if (!gapComposer7.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                } else {
                    boolean z7 = this.f$0;
                    MenuKt.Switch(z7, this.f$1, null, Expect_jvmKt.rememberComposableLambda(-1952376633, new PlayerSettingsKt$$ExternalSyntheticLambda92((byte) 11, z7), gapComposer7), false, null, gapComposer7, 3072, 116);
                }
                break;
            case 7:
                GapComposer gapComposer8 = (GapComposer) composer;
                if (!gapComposer8.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer8.skipToGroupEnd();
                } else {
                    MenuKt.Switch(this.f$0, this.f$1, null, null, false, null, gapComposer8, 0, 124);
                }
                break;
            default:
                GapComposer gapComposer9 = (GapComposer) composer;
                if (!gapComposer9.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer9.skipToGroupEnd();
                } else {
                    MenuKt.Switch(this.f$0, this.f$1, null, null, false, null, gapComposer9, 0, 124);
                }
                break;
        }
        return unit;
    }
}
