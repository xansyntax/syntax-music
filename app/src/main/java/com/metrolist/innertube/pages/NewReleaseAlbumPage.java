package com.metrolist.innertube.pages;

import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicTwoRowItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NewReleaseAlbumPage {
    public static AlbumItem fromMusicTwoRowItemRenderer(MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
        String str;
        MusicResponsiveListItemRenderer.Overlay overlay;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        String str2;
        List list;
        Run run;
        String str3;
        Icon icon;
        List list2;
        Run run2;
        String str4;
        musicTwoRowItemRenderer.getClass();
        Runs runs = musicTwoRowItemRenderer.subtitle;
        BrowseEndpoint browseEndpoint = musicTwoRowItemRenderer.navigationEndpoint.browseEndpoint;
        Object obj = null;
        if (browseEndpoint != null && (str = browseEndpoint.browseId) != null && (overlay = musicTwoRowItemRenderer.thumbnailOverlay) != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) != null && (watchEndpoint = navigationEndpoint.watchPlaylistEndpoint) != null && (str2 = watchEndpoint.playlistId) != null && (list = musicTwoRowItemRenderer.title.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str3 = run.text) != null) {
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(runs != null ? runs.runs : null);
            Integer intOrNull = (runs == null || (list2 = runs.runs) == null || (run2 = (Run) CollectionsKt.lastOrNull(list2)) == null || (str4 = run2.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str4);
            String thumbnailUrl = musicTwoRowItemRenderer.thumbnailRenderer.getThumbnailUrl();
            if (thumbnailUrl != null) {
                List list3 = musicTwoRowItemRenderer.subtitleBadges;
                if (list3 != null) {
                    for (Object obj2 : list3) {
                        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                        if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon = musicInlineBadgeRenderer.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                            obj = obj2;
                            break;
                        }
                    }
                    obj = (Badges) obj;
                }
                return new AlbumItem(str, str2, str3, arrayListExtractArtists, intOrNull, thumbnailUrl, obj != null, 4);
            }
        }
        return null;
    }
}
