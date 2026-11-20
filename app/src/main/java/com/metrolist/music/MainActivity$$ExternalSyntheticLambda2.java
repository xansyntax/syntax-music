package com.metrolist.music;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavHostController;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.kugou.KuGouKt$$ExternalSyntheticLambda0;
import com.metrolist.music.ui.utils.AppBarKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda2(NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00c3  */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                int i = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "history");
                break;
            case 1:
                FragmentManager.AnonymousClass1 anonymousClass1 = navHostController.onBackPressedCallback;
                if (navHostController.enableOnBackPressedCallback) {
                    z = navHostController.getDestinationCountOnBackStack() > 1;
                }
                anonymousClass1.setEnabled(z);
                break;
            case 2:
                int i2 = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "stats");
                break;
            case 3:
                int i3 = MainActivity.$r8$clinit;
                navHostController.navigate("recognition", new KuGouKt$$ExternalSyntheticLambda0((byte) 22));
                break;
            case 4:
                int i4 = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "settings");
                break;
            case 5:
                int i5 = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "listen_together_from_topbar");
                break;
            case 6:
                int i6 = MainActivity.$r8$clinit;
                navHostController.navigate("recognition", new KuGouKt$$ExternalSyntheticLambda0((byte) 21));
                break;
            case 7:
                int i7 = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "settings");
                break;
            case 8:
                int i8 = MainActivity.$r8$clinit;
                NavHostController.navigate$default(navHostController, "settings");
                break;
            case 9:
                NavHostController.navigate$default(navHostController, "online_playlist/SE");
                break;
            case 10:
                NavHostController.navigate$default(navHostController, "online_playlist/RDPN");
                break;
            case 11:
                navHostController.navigateUp();
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                AppBarKt.backToMain(navHostController);
                break;
            case 13:
                navHostController.navigateUp();
                break;
            case 14:
                AppBarKt.backToMain(navHostController);
                break;
            case 15:
                NavHostController.navigate$default(navHostController, "recognition");
                break;
            case 16:
                NavHostController.navigate$default(navHostController, "youtube_browse/FEmusic_library_non_music_audio_list");
                break;
            case 17:
                NavHostController.navigate$default(navHostController, "account");
                break;
            case 18:
                NavHostController.navigate$default(navHostController, "online_playlist/SE");
                break;
            case 19:
                NavHostController.navigate$default(navHostController, "mood_and_genres");
                break;
            case 20:
                NavHostController.navigate$default(navHostController, "settings/integrations/listen_together");
                break;
            case 21:
                navHostController.popBackStack();
                break;
            case 22:
                navHostController.navigateUp();
                break;
            case 23:
                NavHostController.navigate$default(navHostController, "auto_playlist/liked");
                break;
            case 24:
                NavHostController.navigate$default(navHostController, "auto_playlist/uploaded");
                break;
            case 25:
                NavHostController.navigate$default(navHostController, "auto_playlist/downloaded");
                break;
            case 26:
                NavHostController.navigate$default(navHostController, "auto_playlist/liked");
                break;
            case 27:
                NavHostController.navigate$default(navHostController, "cache_playlist/cached");
                break;
            case 28:
                NavHostController.navigate$default(navHostController, "cache_playlist/cached");
                break;
            default:
                NavHostController.navigate$default(navHostController, "auto_playlist/downloaded");
                break;
        }
        return unit;
    }
}
