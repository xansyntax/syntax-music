package com.metrolist.music.ui.menu;

import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.PodcastEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$SongMenu$14$1$5$1$8$4$1$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PodcastEntity f$0;

    public /* synthetic */ SongMenuKt$SongMenu$14$1$5$1$8$4$1$1$$ExternalSyntheticLambda0(PodcastEntity podcastEntity, byte b) {
        this.$r8$classId = b;
        this.f$0 = podcastEntity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                PodcastEntity podcastEntity = this.f$0.toggleBookmark();
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(podcastEntity);
                break;
            default:
                PodcastEntity podcastEntityCopy$default = PodcastEntity.copy$default(this.f$0, null, null, null, null, null, null, 479);
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(podcastEntityCopy$default);
                break;
        }
        return unit;
    }
}
