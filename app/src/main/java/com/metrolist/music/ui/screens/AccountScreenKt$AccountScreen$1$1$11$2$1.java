package com.metrolist.music.ui.screens;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.ArtistItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccountScreenKt$AccountScreen$1$1$11$2$1 implements Function0 {
    public final /* synthetic */ ArtistItem $item;
    public final /* synthetic */ NavHostController $navController;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ AccountScreenKt$AccountScreen$1$1$11$2$1(NavHostController navHostController, ArtistItem artistItem, byte b) {
        this.$r8$classId = b;
        this.$navController = navHostController;
        this.$item = artistItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArtistItem artistItem = this.$item;
        NavHostController navHostController = this.$navController;
        switch (b) {
            case 0:
                Format$$ExternalSyntheticOutline0.m("artist/", artistItem.id, navHostController);
                break;
            case 1:
                Format$$ExternalSyntheticOutline0.m("artist/", artistItem.id, navHostController);
                break;
            default:
                Format$$ExternalSyntheticOutline0.m("artist/", artistItem.id, navHostController);
                break;
        }
        return unit;
    }
}
