package com.metrolist.music.viewmodels;

import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.ArtistEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StatsViewModel$1$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ArtistEntity f$0;
    public final /* synthetic */ ArtistPage f$1;

    public /* synthetic */ StatsViewModel$1$1$$ExternalSyntheticLambda0(ArtistEntity artistEntity, ArtistPage artistPage, byte b) {
        this.$r8$classId = b;
        this.f$0 = artistEntity;
        this.f$1 = artistPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ArtistPage artistPage = this.f$1;
        ArtistEntity artistEntity = this.f$0;
        MusicDatabase musicDatabase = (MusicDatabase) obj;
        switch (b) {
            case 0:
                musicDatabase.getClass();
                musicDatabase.update(artistEntity, artistPage);
                break;
            case 1:
                musicDatabase.getClass();
                musicDatabase.update(artistEntity, artistPage);
                break;
            default:
                musicDatabase.getClass();
                musicDatabase.update(artistEntity, artistPage);
                break;
        }
        return unit;
    }
}
