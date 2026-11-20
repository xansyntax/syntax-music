package com.metrolist.music.ui.screens.playlist;

import androidx.navigation.NavHostController;
import com.metrolist.innertube.models.Artist;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LocalPlaylistScreenKt$$ExternalSyntheticLambda44 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Artist f$0;
    public final /* synthetic */ NavHostController f$1;

    public /* synthetic */ LocalPlaylistScreenKt$$ExternalSyntheticLambda44(Artist artist, NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.f$0 = artist;
        this.f$1 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$1;
        Artist artist = this.f$0;
        switch (b) {
            case 0:
                String str = artist.id;
                if (str != null) {
                    NavHostController.navigate$default(navHostController, "artist/".concat(str));
                }
                break;
            default:
                String str2 = artist.id;
                if (str2 != null) {
                    NavHostController.navigate$default(navHostController, "artist/".concat(str2));
                }
                break;
        }
        return unit;
    }
}
