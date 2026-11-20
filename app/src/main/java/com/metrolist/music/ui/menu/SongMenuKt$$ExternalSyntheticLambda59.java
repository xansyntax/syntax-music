package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda59 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Song f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda59(Song song, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = song;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$1;
        Song song = this.f$0;
        switch (b) {
            case 0:
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(SongEntity.copy$default(song.song, null, 0, null, null, null, false, null, z ? null : LocalDateTime.now(), null, null, null, 0, false, false, false, null, 125820927));
                break;
            default:
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                SongEntity songEntityCopy$default = SongEntity.copy$default(song.song, null, 0, null, null, null, false, null, z ? LocalDateTime.now() : null, null, null, null, 0, false, false, false, null, 125820927);
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.update(songEntityCopy$default);
                break;
        }
        return unit;
    }
}
