package com.metrolist.innertube.pages;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaylistPage {
    public final String continuation;
    public final PlaylistItem playlist;
    public final List songs;
    public final String songsContinuation;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        public static SongItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
            Runs runs;
            List list;
            Run run;
            String str;
            Album album;
            String thumbnailUrl;
            Badges badges;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint;
            Object next;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            Icon icon;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
            Runs runs2;
            List list2;
            Run run2;
            String str2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            List list3;
            Run run3;
            BrowseEndpoint browseEndpoint;
            String str3;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            Menu.MenuRenderer menuRenderer;
            musicResponsiveListItemRenderer.getClass();
            List list4 = musicResponsiveListItemRenderer.flexColumns;
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = musicResponsiveListItemRenderer.menu;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list4);
            List list5 = (flexColumn2 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null) ? null : runs4.runs;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list4);
            if (flexColumn3 != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn3.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str = run.text) != null) {
                if (list5 == null) {
                    Timber.Forest.getClass();
                    ConnectionPool.w(new Object[0]);
                }
                ArrayList arrayListExtractArtists = PageHelper.extractArtists(list5);
                String videoId = musicResponsiveListItemRenderer.getVideoId();
                if (videoId != null) {
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list4);
                    if (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null || (list3 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                        album = null;
                    } else {
                        String str4 = run3.text;
                        NavigationEndpoint navigationEndpoint2 = run3.navigationEndpoint;
                        album = (navigationEndpoint2 == null || (browseEndpoint = navigationEndpoint2.browseEndpoint) == null || (str3 = browseEndpoint.browseId) == null) ? null : new Album(str4, str3);
                    }
                    List list6 = musicResponsiveListItemRenderer.fixedColumns;
                    Integer numM1883parseTime = (list6 == null || (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list6)) == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list2 = runs2.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null || (str2 = run2.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str2);
                    String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                    ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                    if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                        List list7 = musicResponsiveListItemRenderer.badges;
                        if (list7 != null) {
                            Iterator it = list7.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                            } while (!Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon = musicInlineBadgeRenderer.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE"));
                            badges = (Badges) next;
                        } else {
                            badges = null;
                        }
                        boolean z = badges != null;
                        MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
                        WatchEndpoint watchEndpoint = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint.watchEndpoint;
                        String playlistSetVideoId = musicResponsiveListItemRenderer.getPlaylistSetVideoId();
                        if (playlistSetVideoId != null) {
                            return new SongItem(videoId, str, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z, watchEndpoint, playlistSetVideoId, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 82112);
                        }
                    }
                }
            }
            return null;
        }

        public static Artist ownerFromDetailSubtitle(List list) {
            List list2;
            Run run;
            List list3 = list != null ? (List) CollectionsKt.getOrNull(1, CharsKt.splitBySeparator(list)) : null;
            Artist artist = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list3));
            if (artist != null) {
                return artist;
            }
            if (list3 != null && (list2 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list3))) != null && (run = (Run) CollectionsKt.firstOrNull(list2)) != null) {
                if (run.navigationEndpoint != null || StringsKt.isBlank(run.text)) {
                    run = null;
                }
                if (run != null) {
                    return new Artist(StringsKt.trim(run.text).toString(), null);
                }
            }
            return null;
        }
    }

    public PlaylistPage(PlaylistItem playlistItem, List list, String str, String str2) {
        list.getClass();
        this.playlist = playlistItem;
        this.songs = list;
        this.songsContinuation = str;
        this.continuation = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaylistPage)) {
            return false;
        }
        PlaylistPage playlistPage = (PlaylistPage) obj;
        return this.playlist.equals(playlistPage.playlist) && Intrinsics.areEqual(this.songs, playlistPage.songs) && Intrinsics.areEqual(this.songsContinuation, playlistPage.songsContinuation) && Intrinsics.areEqual(this.continuation, playlistPage.continuation);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.playlist.hashCode() * 31, 31, this.songs);
        String str = this.songsContinuation;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.continuation;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaylistPage(playlist=");
        sb.append(this.playlist);
        sb.append(", songs=");
        sb.append(this.songs);
        sb.append(", songsContinuation=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.songsContinuation, ", continuation=", this.continuation, ")");
    }
}
