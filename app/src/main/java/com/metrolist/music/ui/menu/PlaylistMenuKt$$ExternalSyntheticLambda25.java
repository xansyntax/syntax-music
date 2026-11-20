package com.metrolist.music.ui.menu;

import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistMenuKt$$ExternalSyntheticLambda25 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Playlist f$0;

    public /* synthetic */ PlaylistMenuKt$$ExternalSyntheticLambda25(Playlist playlist, byte b) {
        this.$r8$classId = b;
        this.f$0 = playlist;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Playlist playlist = this.f$0;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                DatabaseDao databaseDao = musicDatabase.$$delegate_0;
                PlaylistEntity playlistEntity = playlist.playlist;
                if (playlistEntity.bookmarkedAt != null) {
                    databaseDao.update(playlistEntity.toggleLike());
                }
                databaseDao.delete(playlist.playlist);
                break;
            case 1:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(PlaylistEntity.copy$default(playlist.playlist, null, null, null, false, null, null, null, null, null, null, false, 15871));
                break;
            default:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                musicDatabase3.getClass();
                musicDatabase3.$$delegate_0.update(PlaylistEntity.copy$default(playlist.playlist, null, null, null, false, null, null, null, null, null, null, false, 15871));
                break;
        }
        return unit;
    }
}
