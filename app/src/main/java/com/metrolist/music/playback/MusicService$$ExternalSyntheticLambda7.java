package com.metrolist.music.playback;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SongEntity;
import java.time.LocalDateTime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicService$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongEntity f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ MusicService$$ExternalSyntheticLambda7(SongEntity songEntity, boolean z, byte b) {
        this.$r8$classId = b;
        this.f$0 = songEntity;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                SongEntity songEntity = this.f$0;
                boolean z = this.f$1;
                MusicDatabase musicDatabase = (MusicDatabase) obj;
                boolean z2 = MusicService.isRunning;
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(SongEntity.copy$default(songEntity, null, 0, null, null, null, false, null, z ? null : LocalDateTime.now(), null, null, null, 0, false, false, false, null, 125820927));
                break;
            case 1:
                SongEntity songEntity2 = this.f$0;
                boolean z3 = this.f$1;
                MusicDatabase musicDatabase2 = (MusicDatabase) obj;
                musicDatabase2.getClass();
                musicDatabase2.$$delegate_0.upsert(SongEntity.copy$default(songEntity2, null, 0, null, null, null, false, null, null, null, null, null, 0, z3, false, false, null, 133693439));
                break;
            default:
                MusicDatabase musicDatabase3 = (MusicDatabase) obj;
                SongEntity songEntityCopy$default = SongEntity.copy$default(this.f$0, null, 0, null, null, null, false, null, this.f$1 ? null : LocalDateTime.now(), null, null, null, 0, false, false, false, null, 134209535);
                musicDatabase3.getClass();
                musicDatabase3.$$delegate_0.update(songEntityCopy$default);
                break;
        }
        return Unit.INSTANCE;
    }
}
