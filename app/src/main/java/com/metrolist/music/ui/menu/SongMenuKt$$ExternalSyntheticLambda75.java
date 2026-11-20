package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.playback.MusicService;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda75 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song f$0;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda75(Song song, byte b) {
        this.$r8$classId = b;
        this.f$0 = song;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Song song = this.f$0;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(SongEntity.toggleLibrary$default(song.song));
                break;
            case 1:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                boolean z = MusicService.isRunning;
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(SongEntity.copy$default(song.song, null, 0, null, null, null, false, null, null, LocalDateTime.now(), null, null, 0, false, false, false, null, 134201343));
                break;
            case 2:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                SongEntity songEntity = SongEntity.toggleLibrary$default(song.song);
                musicDatabase3.getClass();
                musicDatabase3.$$delegate_0.update(songEntity);
                break;
            case 3:
                ((MusicDatabase) obj).delete(song.song);
                break;
            default:
                ((MusicDatabase) obj).delete(song.song);
                break;
        }
        return Unit.INSTANCE;
    }
}
