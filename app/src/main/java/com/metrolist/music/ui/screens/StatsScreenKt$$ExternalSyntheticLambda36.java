package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.screens.playlist.TopPlaylistScreenKt;
import com.metrolist.music.ui.utils.AppBarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda36 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda36(NavHostController navHostController, MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        MutableState mutableState2 = this.f$1;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    navHostController.navigateUp();
                } else {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                }
                break;
            case 1:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    navHostController.navigateUp();
                } else {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                }
                break;
            case 2:
                if (!((Boolean) mutableState2.getValue()).booleanValue() && !TopPlaylistScreenKt.AutoPlaylistScreen$lambda$16(mutableState)) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            case 3:
                if (!((Boolean) mutableState2.getValue()).booleanValue() && !TopPlaylistScreenKt.CachePlaylistScreen$lambda$7(mutableState)) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            case 4:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    navHostController.navigateUp();
                } else {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                }
                break;
            case 5:
                if (!((Boolean) mutableState2.getValue()).booleanValue() && !TopPlaylistScreenKt.OnlinePlaylistScreen$lambda$20(mutableState)) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            case 6:
                if (!((Boolean) mutableState2.getValue()).booleanValue() && !TopPlaylistScreenKt.TopPlaylistScreen$lambda$15(mutableState)) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            default:
                if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                    navHostController.navigateUp();
                } else {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(new TextFieldValue(7, 0L, (String) null));
                }
                break;
        }
        return unit;
    }
}
