package com.metrolist.music.ui.screens.playlist;

import com.metrolist.music.db.entities.ArtistEntity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1 implements Function1 {
    public static final CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1 INSTANCE = new CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1(0);
    public static final CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1 INSTANCE$1 = new CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ CachePlaylistScreenKt$CachePlaylistScreen$sortedSongs$1$sorted$3$1(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ArtistEntity artistEntity = (ArtistEntity) obj;
                artistEntity.getClass();
                return artistEntity.name;
            default:
                return Float.valueOf(((Number) obj).floatValue());
        }
    }
}
