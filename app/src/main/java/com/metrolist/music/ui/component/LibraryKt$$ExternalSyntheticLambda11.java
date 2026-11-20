package com.metrolist.music.ui.component;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.entities.Artist;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda11 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;
    public final /* synthetic */ Artist f$1;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda11(NavHostController navHostController, Artist artist, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = artist;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Artist artist = this.f$1;
        NavHostController navHostController = this.f$0;
        switch (b) {
            case 0:
                str = artist.artist.id;
                break;
            default:
                str = artist.artist.id;
                break;
        }
        Format$$ExternalSyntheticOutline0.m("artist/", str, navHostController);
        return unit;
    }
}
