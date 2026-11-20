package com.metrolist.music.viewmodels;

import com.metrolist.music.db.entities.ArtistEntity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalPlaylistViewModel$playlistSongs$2$3$1 implements Function1 {
    public static final LocalPlaylistViewModel$playlistSongs$2$3$1 INSTANCE = new LocalPlaylistViewModel$playlistSongs$2$3$1();

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ArtistEntity artistEntity = (ArtistEntity) obj;
        artistEntity.getClass();
        return artistEntity.name;
    }
}
