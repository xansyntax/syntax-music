package com.metrolist.music.ui.component;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryKt$$ExternalSyntheticLambda8 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Playlist f$0;
    public final /* synthetic */ NavHostController f$1;

    public /* synthetic */ LibraryKt$$ExternalSyntheticLambda8(byte b, NavHostController navHostController, Playlist playlist) {
        this.$r8$classId = b;
        this.f$0 = playlist;
        this.f$1 = navHostController;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        String str2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        NavHostController navHostController = this.f$1;
        Playlist playlist = this.f$0;
        switch (b) {
            case 0:
                PlaylistEntity playlistEntity = playlist.playlist;
                if (playlistEntity.isEditable || playlist.songCount != 0 || (str = playlistEntity.browseId) == null) {
                    Format$$ExternalSyntheticOutline0.m("local_playlist/", playlistEntity.id, navHostController);
                } else {
                    NavHostController.navigate$default(navHostController, "online_playlist/".concat(str));
                }
                break;
            default:
                PlaylistEntity playlistEntity2 = playlist.playlist;
                if (playlistEntity2.isEditable || playlist.songCount != 0 || (str2 = playlistEntity2.browseId) == null) {
                    Format$$ExternalSyntheticOutline0.m("local_playlist/", playlistEntity2.id, navHostController);
                } else {
                    NavHostController.navigate$default(navHostController, "online_playlist/".concat(str2));
                }
                break;
        }
        return unit;
    }
}
