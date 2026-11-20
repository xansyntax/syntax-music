package com.metrolist.music.ui.screens;

import androidx.compose.material3.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.component.MenuKt;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda40;
import com.metrolist.music.ui.player.QueueKt$$ExternalSyntheticLambda39;
import com.metrolist.music.ui.screens.playlist.LocalPlaylistScreenKt;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda19 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ NavHostController f$3;
    public final /* synthetic */ MutableState f$4;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda19(MutableState mutableState, MutableState mutableState2, NavHostController navHostController, Function0 function0, MutableState mutableState3) {
        this.$r8$classId = (byte) 3;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = navHostController;
        this.f$0 = function0;
        this.f$4 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        byte b2 = 5;
        MutableState mutableState = this.f$4;
        NavHostController navHostController = this.f$3;
        MutableState mutableState2 = this.f$2;
        MutableState mutableState3 = this.f$1;
        Unit unit = Unit.INSTANCE;
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        boolean z = false;
        byte b3 = 1;
        switch (b) {
            case 0:
                Composer composer = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                } else if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    gapComposer.startReplaceGroup(1005415964);
                    boolean zChanged = gapComposer.changed(mutableState3) | gapComposer.changed(mutableState2) | gapComposer.changedInstance(navHostController);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController, mutableState3, mutableState2, z ? 1 : 0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    boolean zChanged2 = gapComposer.changed(mutableState3) | gapComposer.changedInstance(navHostController);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController, mutableState3, (byte) 0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    MenuKt.IconButton(function0, (Function0) objRememberedValue2, null, false, null, null, AlbumScreenKt.lambda$1209447248, gapComposer, 1572864);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(1005099113);
                    CardKt.IconButton(this.f$0, null, false, null, null, AlbumScreenKt.f301lambda$1235774137, gapComposer, 1572864, 62);
                    gapComposer.end(false);
                }
                break;
            case 1:
                Composer composer2 = (Composer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                if (!gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    gapComposer2.skipToGroupEnd();
                } else if (!AlbumScreenKt.HistoryScreen$lambda$4(mutableState)) {
                    gapComposer2.startReplaceGroup(1642991908);
                    boolean zChanged3 = gapComposer2.changed(mutableState3) | gapComposer2.changed(mutableState2) | gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                        objRememberedValue3 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController, mutableState3, mutableState2, b3);
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1 = (Function0) objRememberedValue3;
                    boolean zChanged4 = gapComposer2.changed(mutableState3) | gapComposer2.changedInstance(navHostController);
                    Object objRememberedValue4 = gapComposer2.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController, mutableState3, (byte) 1);
                        gapComposer2.updateRememberedValue(objRememberedValue4);
                    }
                    MenuKt.IconButton(function1, (Function0) objRememberedValue4, null, false, null, null, AlbumScreenKt.lambda$1171625681, gapComposer2, 1572864);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(1642711854);
                    CardKt.IconButton(this.f$0, null, false, null, null, AlbumScreenKt.lambda$1749869448, gapComposer2, 1572864, 62);
                    gapComposer2.end(false);
                }
                break;
            case 2:
                Composer composer3 = (Composer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer3;
                if (!gapComposer3.shouldExecute(1 & iIntValue3, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                } else if (!LocalPlaylistScreenKt.LocalPlaylistScreen$lambda$21(mutableState)) {
                    gapComposer3.startReplaceGroup(-1242737555);
                    boolean zChanged5 = gapComposer3.changed(mutableState3) | gapComposer3.changed(mutableState2) | gapComposer3.changedInstance(navHostController);
                    Object objRememberedValue5 = gapComposer3.rememberedValue();
                    if (zChanged5 || objRememberedValue5 == neverEqualPolicy) {
                        objRememberedValue5 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController, mutableState3, mutableState2, (byte) 4);
                        gapComposer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function2 = (Function0) objRememberedValue5;
                    boolean zChanged6 = gapComposer3.changed(mutableState3) | gapComposer3.changedInstance(navHostController);
                    Object objRememberedValue6 = gapComposer3.rememberedValue();
                    if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new StatsScreenKt$$ExternalSyntheticLambda37(navHostController, mutableState3, (byte) 5);
                        gapComposer3.updateRememberedValue(objRememberedValue6);
                    }
                    MenuKt.IconButton(function2, (Function0) objRememberedValue6, null, false, null, null, TopPlaylistScreenKt.lambda$932517776, gapComposer3, 1572864);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(-1243047121);
                    CardKt.IconButton(this.f$0, null, false, null, null, TopPlaylistScreenKt.f395lambda$1816829767, gapComposer3, 1572870, 62);
                    gapComposer3.end(false);
                }
                break;
            default:
                Composer composer4 = (Composer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) composer4;
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    MutableState mutableState4 = this.f$1;
                    boolean zChanged7 = gapComposer4.changed(mutableState4);
                    MutableState mutableState5 = this.f$2;
                    boolean zChanged8 = zChanged7 | gapComposer4.changed(mutableState5);
                    NavHostController navHostController2 = this.f$3;
                    boolean zChangedInstance = zChanged8 | gapComposer4.changedInstance(navHostController2);
                    Object objRememberedValue7 = gapComposer4.rememberedValue();
                    MutableState mutableState6 = this.f$4;
                    if (zChangedInstance || objRememberedValue7 == neverEqualPolicy) {
                        SongMenuKt$$ExternalSyntheticLambda40 songMenuKt$$ExternalSyntheticLambda40 = new SongMenuKt$$ExternalSyntheticLambda40(this.f$0, (Object) navHostController2, mutableState4, (Object) mutableState5, (Object) mutableState6, (byte) 24);
                        gapComposer4.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda40);
                        objRememberedValue7 = songMenuKt$$ExternalSyntheticLambda40;
                    }
                    Function0 function3 = (Function0) objRememberedValue7;
                    boolean zChanged9 = gapComposer4.changed(mutableState4) | gapComposer4.changedInstance(navHostController2);
                    Object objRememberedValue8 = gapComposer4.rememberedValue();
                    Object obj3 = objRememberedValue8;
                    if (zChanged9 || objRememberedValue8 == neverEqualPolicy) {
                        StatsScreenKt$$ExternalSyntheticLambda36 statsScreenKt$$ExternalSyntheticLambda36 = new StatsScreenKt$$ExternalSyntheticLambda36(navHostController2, mutableState4, mutableState6, b2);
                        gapComposer4.updateRememberedValue(statsScreenKt$$ExternalSyntheticLambda36);
                        obj3 = statsScreenKt$$ExternalSyntheticLambda36;
                    }
                    MenuKt.IconButton(function3, (Function0) obj3, null, false, null, null, Expect_jvmKt.rememberComposableLambda(-315178712, new QueueKt$$ExternalSyntheticLambda39(mutableState6, (byte) 14), gapComposer4), gapComposer4, 1572864);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda19(Function0 function0, MutableState mutableState, MutableState mutableState2, NavHostController navHostController, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
        this.f$3 = navHostController;
        this.f$4 = mutableState3;
    }
}
