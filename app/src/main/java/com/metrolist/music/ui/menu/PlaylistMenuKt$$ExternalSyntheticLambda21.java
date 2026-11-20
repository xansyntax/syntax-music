package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlaylistMenuKt$$ExternalSyntheticLambda21 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Playlist f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ PlaylistMenuKt$$ExternalSyntheticLambda21(Playlist playlist, String str, byte b) {
        this.$r8$classId = b;
        this.f$0 = playlist;
        this.f$1 = str;
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
                musicDatabase.$$delegate_0.update(PlaylistEntity.copy$default(playlist.playlist, this.f$1, null, LocalDateTime.now(), false, null, null, null, null, null, null, false, 16365));
                break;
            case 1:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                PlaylistEntity playlistEntityCopy$default = PlaylistEntity.copy$default(playlist.playlist, null, null, null, false, null, null, null, this.f$1, null, null, false, 15871);
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(playlistEntityCopy$default);
                break;
            case 2:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                PlaylistEntity playlistEntityCopy$default2 = PlaylistEntity.copy$default(playlist.playlist, null, null, null, false, null, null, null, this.f$1, null, null, false, 15871);
                musicDatabase3.getClass();
                musicDatabase3.$$delegate_0.update(playlistEntityCopy$default2);
                break;
            default:
                MusicDatabase musicDatabase4 = (MusicDatabase) obj;
                PlaylistEntity playlistEntityCopy$default3 = PlaylistEntity.copy$default(playlist.playlist, null, null, null, false, null, null, null, this.f$1, null, null, false, 15871);
                musicDatabase4.getClass();
                musicDatabase4.$$delegate_0.update(playlistEntityCopy$default3);
                break;
        }
        return unit;
    }
}
