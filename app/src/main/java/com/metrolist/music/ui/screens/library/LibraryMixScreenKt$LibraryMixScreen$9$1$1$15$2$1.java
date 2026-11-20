package com.metrolist.music.ui.screens.library;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.navigation.NavHostController;
import com.metrolist.music.db.entities.Album;
import com.metrolist.music.db.entities.Artist;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1 implements Function0 {
    public final /* synthetic */ LocalItem $item;
    public final /* synthetic */ NavHostController $navController;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(NavHostController navHostController, LocalItem localItem, byte b) {
        this.$r8$classId = b;
        this.$navController = navHostController;
        this.$item = localItem;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String str;
        String str2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LocalItem localItem = this.$item;
        NavHostController navHostController = this.$navController;
        switch (b) {
            case 0:
                Playlist playlist = (Playlist) localItem;
                PlaylistEntity playlistEntity = playlist.playlist;
                if (playlistEntity.isEditable || playlist.songCount != 0 || (str = playlistEntity.browseId) == null) {
                    Format$$ExternalSyntheticOutline0.m("local_playlist/", playlistEntity.id, navHostController);
                } else {
                    NavHostController.navigate$default(navHostController, "online_playlist/".concat(str));
                }
                break;
            case 1:
                Format$$ExternalSyntheticOutline0.m("album/", ((Album) localItem).album.id, navHostController);
                break;
            case 2:
                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem).artist.id, navHostController);
                break;
            case 3:
                Playlist playlist2 = (Playlist) localItem;
                PlaylistEntity playlistEntity2 = playlist2.playlist;
                if (playlistEntity2.isEditable || playlist2.songCount != 0 || (str2 = playlistEntity2.browseId) == null) {
                    Format$$ExternalSyntheticOutline0.m("local_playlist/", playlistEntity2.id, navHostController);
                } else {
                    NavHostController.navigate$default(navHostController, "online_playlist/".concat(str2));
                }
                break;
            case 4:
                Format$$ExternalSyntheticOutline0.m("artist/", ((Artist) localItem).artist.id, navHostController);
                break;
            default:
                Format$$ExternalSyntheticOutline0.m("album/", ((Album) localItem).album.id, navHostController);
                break;
        }
        return unit;
    }

    public /* synthetic */ LibraryMixScreenKt$LibraryMixScreen$9$1$1$15$2$1(LocalItem localItem, NavHostController navHostController, byte b) {
        this.$r8$classId = b;
        this.$item = localItem;
        this.$navController = navHostController;
    }
}
