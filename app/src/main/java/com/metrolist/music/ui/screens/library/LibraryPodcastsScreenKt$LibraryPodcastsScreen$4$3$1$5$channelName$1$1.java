package com.metrolist.music.ui.screens.library;

import com.metrolist.music.db.entities.ArtistEntity;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryPodcastsScreenKt$LibraryPodcastsScreen$4$3$1$5$channelName$1$1 implements Function1 {
    public static final LibraryPodcastsScreenKt$LibraryPodcastsScreen$4$3$1$5$channelName$1$1 INSTANCE = new LibraryPodcastsScreenKt$LibraryPodcastsScreen$4$3$1$5$channelName$1$1();

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ArtistEntity artistEntity = (ArtistEntity) obj;
        artistEntity.getClass();
        return artistEntity.name;
    }
}
