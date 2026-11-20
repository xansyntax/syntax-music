package com.metrolist.music.ui.player;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListScope$items$1;
import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.runtime.Stack;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavType;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.metrolist.music.db.entities.LocalItem;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.screens.AlbumScreenKt;
import com.metrolist.music.viewmodels.CommunityPlaylistItem;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda4(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                List list = (List) obj;
                list.getClass();
                return Stack.toMutableStateList(list);
            case 1:
                ((AnimatedContentTransitionScope) obj).getClass();
                return CrossfadeKt.togetherWith(EnterExitTransitionKt.fadeIn$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3), EnterExitTransitionKt.fadeOut$default(null, CropImageView.DEFAULT_ASPECT_RATIO, 3));
            case 2:
                MediaItem mediaItem = (MediaItem) obj;
                mediaItem.getClass();
                String str = mediaItem.mediaId;
                return str.length() == 0 ? IntIntPair$$ExternalSyntheticOutline0.m(mediaItem.hashCode(), "unknown_") : str;
            case 3:
                PlaylistItem playlistItem = (PlaylistItem) obj;
                playlistItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("account_playlist_", playlistItem.id);
            case 4:
                AlbumItem albumItem = (AlbumItem) obj;
                albumItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("account_album_", albumItem.id);
            case 5:
                ArtistItem artistItem = (ArtistItem) obj;
                artistItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("account_artist_", artistItem.id);
            case 6:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 7:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 8:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 9:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 10:
                ((LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl) obj).getClass();
                return new GridItemSpan(DatabaseDao_Impl.AnonymousClass17.GridItemSpan(LazyGridSpanLayoutProvider.LazyGridItemSpanScopeImpl.maxLineSpan));
            case 11:
                AlbumItem albumItem2 = (AlbumItem) obj;
                albumItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("album_other_", albumItem2.id);
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                List list2 = (List) obj;
                list2.getClass();
                return Stack.toMutableStateList(list2);
            case 13:
                YTItem yTItem = (YTItem) obj;
                yTItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("browse_", yTItem.getId());
            case 14:
                ((YTItem) obj).getClass();
                return "grid_item";
            case 15:
                SongItem songItem = (SongItem) obj;
                songItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("charts_video_", songItem.id);
            case 16:
                List list3 = (List) obj;
                list3.getClass();
                return Stack.toMutableStateList(list3);
            case 17:
                LocalItem localItem = (LocalItem) obj;
                localItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_keep_listening_", localItem.getId());
            case 18:
                ((CommunityPlaylistItem) obj).getClass();
                return "community_playlist";
            case 19:
                PodcastItem podcastItem = (PodcastItem) obj;
                podcastItem.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_saved_podcast_", podcastItem.id);
            case 20:
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                lazyListIntervalContent.getClass();
                lazyListIntervalContent.items(5, null, LazyListScope$items$1.INSTANCE, AlbumScreenKt.f318lambda$2067670785);
                return unit;
            case 21:
                YTItem yTItem2 = (YTItem) obj;
                yTItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_chip_section_", yTItem2.getId());
            case 22:
                Song song = (Song) obj;
                song.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_forgotten_", song.song.id);
            case 23:
                LazyListIntervalContent lazyListIntervalContent2 = (LazyListIntervalContent) obj;
                lazyListIntervalContent2.getClass();
                lazyListIntervalContent2.items(4, null, LazyListScope$items$1.INSTANCE, AlbumScreenKt.f316lambda$1946897265);
                return unit;
            case 24:
                PodcastItem podcastItem2 = (PodcastItem) obj;
                podcastItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_featured_podcast_", podcastItem2.id);
            case 25:
                PlaylistItem playlistItem2 = (PlaylistItem) obj;
                playlistItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_account_playlist_", playlistItem2.id);
            case 26:
                YTItem yTItem3 = (YTItem) obj;
                yTItem3.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_similar_", yTItem3.getId());
            case 27:
                SongItem songItem2 = (SongItem) obj;
                songItem2.getClass();
                return Fragment$5$$ExternalSyntheticOutline0.m("home_episode_later_", songItem2.id);
            case 28:
                MoodAndGenres.Item item = (MoodAndGenres.Item) obj;
                item.getClass();
                String str2 = item.title;
                BrowseEndpoint browseEndpoint = item.endpoint;
                return str2 + "_" + browseEndpoint.browseId + "_" + browseEndpoint.params;
            default:
                NavArgumentBuilder navArgumentBuilder = (NavArgumentBuilder) obj;
                navArgumentBuilder.getClass();
                navArgumentBuilder.builder.cipherSuites = NavType.StringType;
                return unit;
        }
    }
}
