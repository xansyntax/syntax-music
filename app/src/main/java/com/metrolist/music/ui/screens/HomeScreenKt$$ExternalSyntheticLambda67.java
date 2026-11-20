package com.metrolist.music.ui.screens;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.BrowseEndpoint;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda67 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ BrowseEndpoint f$0;
    public final /* synthetic */ NavHostController f$1;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda67(BrowseEndpoint browseEndpoint, NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = browseEndpoint;
        this.f$1 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$1;
        BrowseEndpoint browseEndpoint = this.f$0;
        switch (b) {
            case 0:
                if (!Intrinsics.areEqual(browseEndpoint.browseId, "FEmusic_moods_and_genres")) {
                    String str = browseEndpoint.params;
                    String str2 = browseEndpoint.browseId;
                    if (str == null) {
                        Format$$ExternalSyntheticOutline0.m("browse/", str2, navHostController);
                    } else {
                        NavHostController.navigate$default(navHostController, "youtube_browse/" + str2 + "?params=" + str);
                    }
                } else {
                    NavHostController.navigate$default(navHostController, "mood_and_genres");
                }
                break;
            default:
                String str3 = browseEndpoint.browseId;
                if (Intrinsics.areEqual(str3, "FEmusic_moods_and_genres")) {
                    NavHostController.navigate$default(navHostController, "mood_and_genres");
                } else if (StringsKt__StringsJVMKt.startsWith(str3, "FEmusic_library_non_music_audio", false) || StringsKt__StringsJVMKt.startsWith(str3, "FEmusic_non_music_audio", false)) {
                    NavHostController.navigate$default(navHostController, "youtube_browse/".concat(str3));
                } else {
                    String str4 = browseEndpoint.params;
                    if (str4 == null) {
                        NavHostController.navigate$default(navHostController, "browse/".concat(str3));
                    } else {
                        NavHostController.navigate$default(navHostController, "youtube_browse/" + str3 + "?params=" + str4);
                    }
                }
                break;
        }
        return unit;
    }
}
