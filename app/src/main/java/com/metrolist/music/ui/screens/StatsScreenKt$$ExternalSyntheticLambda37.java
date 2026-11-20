package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.utils.AppBarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsScreenKt$$ExternalSyntheticLambda37 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ StatsScreenKt$$ExternalSyntheticLambda37(NavHostController navHostController, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            case 1:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            case 2:
                mutableState.setValue(Boolean.FALSE);
                NavHostController.navigate$default(navHostController, "eq_wizard");
                break;
            case 3:
                NavHostController.navigate$default(navHostController, "top_playlist/" + mutableState.getValue());
                break;
            case 4:
                NavHostController.navigate$default(navHostController, "top_playlist/" + mutableState.getValue());
                break;
            case 5:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
            default:
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    AppBarKt.backToMain(navHostController);
                }
                break;
        }
        return unit;
    }
}
