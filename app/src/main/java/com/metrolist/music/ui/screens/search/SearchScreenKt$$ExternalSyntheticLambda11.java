package com.metrolist.music.ui.screens.search;

import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.utils.AppBarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchScreenKt$$ExternalSyntheticLambda11 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ SearchScreenKt$$ExternalSyntheticLambda11(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                navHostController.navigateUp();
                break;
            case 1:
                NavHostController.navigate$default(navHostController, "auto_playlist/uploaded");
                break;
            case 2:
                NavHostController.navigate$default(navHostController, "online_playlist/SE");
                break;
            case 3:
                NavHostController.navigate$default(navHostController, "online_playlist/RDPN");
                break;
            case 4:
                navHostController.navigateUp();
                break;
            case 5:
                AppBarKt.backToMain(navHostController);
                break;
            case 6:
                navHostController.navigateUp();
                break;
            case 7:
                AppBarKt.backToMain(navHostController);
                break;
            case 8:
                NavHostController.navigate$default(navHostController, "recognition_history");
                break;
            case 9:
                navHostController.navigateUp();
                break;
            case 10:
                NavHostController.navigate$default(navHostController, "recognition");
                break;
            case 11:
                NavHostController.navigate$default(navHostController, "recognition");
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                navHostController.navigateUp();
                break;
            case 13:
                navHostController.navigateUp();
                break;
            case 14:
                NavHostController.navigate$default(navHostController, "settings/appearance/theme");
                break;
            case 15:
                NavHostController.navigate$default(navHostController, "settings/content/romanization");
                break;
            case 16:
                NavHostController.navigate$default(navHostController, "settings/appearance");
                break;
            case 17:
                NavHostController.navigate$default(navHostController, "settings/backup_restore");
                break;
            case 18:
                NavHostController.navigate$default(navHostController, "settings/about");
                break;
            case 19:
                NavHostController.navigate$default(navHostController, "settings/player");
                break;
            case 20:
                NavHostController.navigate$default(navHostController, "settings/content");
                break;
            case 21:
                NavHostController.navigate$default(navHostController, "settings/ai");
                break;
            case 22:
                NavHostController.navigate$default(navHostController, "settings/android_auto");
                break;
            case 23:
                NavHostController.navigate$default(navHostController, "settings/privacy");
                break;
            case 24:
                NavHostController.navigate$default(navHostController, "settings/storage");
                break;
            case 25:
                navHostController.navigateUp();
                break;
            case 26:
                NavHostController.navigate$default(navHostController, "settings/integrations/discord");
                break;
            default:
                NavHostController.navigate$default(navHostController, "settings/integrations/lastfm");
                break;
        }
        return unit;
    }
}
