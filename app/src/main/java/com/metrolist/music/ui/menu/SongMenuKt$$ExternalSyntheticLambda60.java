package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.SongEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda60 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SongEntity f$0;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda60(SongEntity songEntity, byte b) {
        this.$r8$classId = b;
        this.f$0 = songEntity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        SongEntity songEntity = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(songEntity);
                break;
            case 1:
                SongEntity songEntity2 = songEntity.toggleLike(true);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(songEntity2);
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(songEntity);
                break;
        }
        return unit;
    }
}
