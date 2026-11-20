package com.metrolist.innertube.pages;

import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicTwoRowItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RelatedPage {
    public final ArrayList albums;
    public final ArrayList artists;
    public final ArrayList playlists;
    public final ArrayList songs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        public static SongItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
            Runs runs;
            List list;
            Run run;
            String str;
            Album album;
            String thumbnailUrl;
            Icon icon;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
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
            List list4;
            Menu.MenuRenderer menuRenderer;
            musicResponsiveListItemRenderer.getClass();
            List list5 = musicResponsiveListItemRenderer.flexColumns;
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = musicResponsiveListItemRenderer.menu;
            Object obj = null;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list5);
            ArrayList arrayListSplitBySeparator = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null || (list4 = runs4.runs) == null) ? null : CharsKt.splitBySeparator(list4);
            String videoId = musicResponsiveListItemRenderer.getVideoId();
            if (videoId != null && (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list5)) != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str = run.text) != null) {
                ArrayList arrayListExtractArtists = PageHelper.extractArtists(arrayListSplitBySeparator != null ? (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator) : null);
                MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list5);
                if (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null || (list3 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                    album = null;
                } else {
                    String str4 = run3.text;
                    NavigationEndpoint navigationEndpoint = run3.navigationEndpoint;
                    album = (navigationEndpoint == null || (browseEndpoint = navigationEndpoint.browseEndpoint) == null || (str3 = browseEndpoint.browseId) == null) ? null : new Album(str4, str3);
                }
                List list6 = musicResponsiveListItemRenderer.fixedColumns;
                Integer numM1883parseTime = (list6 == null || (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list6)) == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list2 = runs2.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null || (str2 = run2.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str2);
                String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                    List list7 = musicResponsiveListItemRenderer.badges;
                    if (list7 != null) {
                        for (Object obj2 : list7) {
                            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                            if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon = musicInlineBadgeRenderer.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                obj = obj2;
                                break;
                            }
                        }
                        obj = (Badges) obj;
                    }
                    return new SongItem(videoId, str, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, obj != null, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 85184);
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:163:0x0200  */
        /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
        /* JADX WARN: Multi-variable type inference failed */
        public static YTItem fromMusicTwoRowItemRenderer(MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
            BrowseEndpoint browseEndpoint;
            String str;
            List list;
            Run run;
            String str2;
            Menu.MenuRenderer menuRenderer;
            List list2;
            Object next;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
            NavigationEndpoint navigationEndpoint;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
            Icon icon;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint2;
            List list3;
            Run run2;
            String str3;
            List list4;
            Run run3;
            String str4;
            String thumbnailUrl;
            Menu.MenuRenderer menuRenderer2;
            List list5;
            Object next2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
            NavigationEndpoint navigationEndpoint3;
            WatchEndpoint watchEndpoint;
            Object next3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
            NavigationEndpoint navigationEndpoint4;
            WatchEndpoint watchEndpoint2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
            Icon icon2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
            Icon icon3;
            String str5;
            Run run4;
            String str6;
            String str7;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint5;
            WatchEndpoint watchEndpoint3;
            Menu.MenuRenderer menuRenderer3;
            List list6;
            Object next4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
            NavigationEndpoint navigationEndpoint6;
            WatchEndpoint watchEndpoint4;
            Object next5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
            NavigationEndpoint navigationEndpoint7;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
            Icon icon4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
            Icon icon5;
            List list7;
            Object objPrevious;
            List list8;
            Run run5;
            List list9;
            String str8;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
            NavigationEndpoint navigationEndpoint8;
            WatchEndpoint watchEndpoint5;
            String str9;
            List list10;
            Run run6;
            String str10;
            Icon icon6;
            List list11;
            Run run7;
            String str11;
            Artist artist;
            Menu.MenuRenderer menuRenderer4;
            List list12;
            Object next6;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer11;
            NavigationEndpoint navigationEndpoint9;
            BrowseEndpoint browseEndpoint2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer12;
            Icon icon7;
            musicTwoRowItemRenderer.getClass();
            MusicResponsiveListItemRenderer.Overlay overlay = musicTwoRowItemRenderer.thumbnailOverlay;
            ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer.thumbnailRenderer;
            Runs runs = musicTwoRowItemRenderer.title;
            NavigationEndpoint navigationEndpoint10 = musicTwoRowItemRenderer.navigationEndpoint;
            Menu menu = musicTwoRowItemRenderer.menu;
            Runs runs2 = musicTwoRowItemRenderer.subtitle;
            Object obj = null;
            if (musicTwoRowItemRenderer.isAlbum()) {
                BrowseEndpoint browseEndpoint3 = navigationEndpoint10.browseEndpoint;
                if (browseEndpoint3 != null && (str8 = browseEndpoint3.browseId) != null && overlay != null && (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) != null && (content3 = musicItemThumbnailOverlayRenderer3.content) != null && (musicPlayButtonRenderer3 = content3.musicPlayButtonRenderer) != null && (navigationEndpoint8 = musicPlayButtonRenderer3.playNavigationEndpoint) != null && (watchEndpoint5 = navigationEndpoint8.watchPlaylistEndpoint) != null && (str9 = watchEndpoint5.playlistId) != null && (list10 = runs.runs) != null && (run6 = (Run) CollectionsKt.firstOrNull(list10)) != null && (str10 = run6.text) != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(runs2 != null ? runs2.runs : null);
                    boolean zIsEmpty = arrayListExtractArtists.isEmpty();
                    List listListOfNotNull = arrayListExtractArtists;
                    if (zIsEmpty) {
                        if (menu == null || (menuRenderer4 = menu.menuRenderer) == null || (list12 = menuRenderer4.items) == null) {
                            artist = null;
                        } else {
                            Iterator it = list12.iterator();
                            do {
                                if (!it.hasNext()) {
                                    next6 = null;
                                    break;
                                }
                                next6 = it.next();
                                menuNavigationItemRenderer12 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer12 == null || (icon7 = menuNavigationItemRenderer12.icon) == null) ? null : icon7.iconType, "ARTIST"));
                            Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next6;
                            if (item == null || (menuNavigationItemRenderer11 = item.menuNavigationItemRenderer) == null || (navigationEndpoint9 = menuNavigationItemRenderer11.navigationEndpoint) == null || (browseEndpoint2 = navigationEndpoint9.browseEndpoint) == null) {
                                artist = null;
                            } else {
                                if (!browseEndpoint2.isArtistEndpoint() && !StringsKt__StringsJVMKt.startsWith(browseEndpoint2.browseId, "UC", false)) {
                                    browseEndpoint2 = null;
                                }
                                if (browseEndpoint2 != null) {
                                    artist = new Artist("", browseEndpoint2.browseId);
                                } else {
                                    artist = null;
                                }
                            }
                        }
                        listListOfNotNull = CollectionsKt__IterablesKt.listOfNotNull(artist);
                    }
                    List list13 = listListOfNotNull;
                    Integer intOrNull = (runs2 == null || (list11 = runs2.runs) == null || (run7 = (Run) CollectionsKt.lastOrNull(list11)) == null || (str11 = run7.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str11);
                    String thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl2 != null) {
                        List list14 = musicTwoRowItemRenderer.subtitleBadges;
                        if (list14 != null) {
                            for (Object obj2 : list14) {
                                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon6 = musicInlineBadgeRenderer.icon) == null) ? null : icon6.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            obj = (Badges) obj;
                        }
                        return new AlbumItem(str8, str9, str10, list13, intOrNull, thumbnailUrl2, obj != null, 4);
                    }
                }
            } else if (musicTwoRowItemRenderer.isPlaylist()) {
                BrowseEndpoint browseEndpoint4 = navigationEndpoint10.browseEndpoint;
                if (browseEndpoint4 != null && (str5 = browseEndpoint4.browseId) != null) {
                    String strRemovePrefix = StringsKt.removePrefix(str5, "VL");
                    List list15 = runs.runs;
                    if (list15 != null && (run4 = (Run) CollectionsKt.firstOrNull(list15)) != null && (str6 = run4.text) != null) {
                        Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                        Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(runs2 != null ? runs2.runs : null));
                        if (artist2 == null) {
                            List list16 = (runs2 == null || (list9 = runs2.runs) == null) ? null : (List) CollectionsKt.lastOrNull(CharsKt.splitBySeparator(list9));
                            Artist artist3 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list16));
                            if (artist3 != null) {
                                artist2 = artist3;
                            } else {
                                if (list16 != null && (list8 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list16))) != null && (run5 = (Run) CollectionsKt.firstOrNull(list8)) != null) {
                                    if (run5.navigationEndpoint != null || StringsKt.isBlank(run5.text)) {
                                        run5 = null;
                                    }
                                    if (run5 != null) {
                                        artist3 = new Artist(StringsKt.trim(run5.text).toString(), null);
                                        artist2 = artist3;
                                    }
                                }
                                artist2 = null;
                            }
                        }
                        Artist artist4 = artist2;
                        if (runs2 == null || (list7 = runs2.runs) == null) {
                            str7 = null;
                        } else {
                            ListIterator listIterator = list7.listIterator(list7.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    objPrevious = null;
                                    break;
                                }
                                objPrevious = listIterator.previous();
                                Run run8 = (Run) objPrevious;
                                String str12 = run8.text;
                                for (int i = 0; i < str12.length(); i++) {
                                    if (Character.isDigit(str12.charAt(i))) {
                                        if (!StringsKt.contains(run8.text, "view", true)) {
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                            Run run9 = (Run) objPrevious;
                            if (run9 != null) {
                                str7 = run9.text;
                            } else {
                                str7 = null;
                            }
                        }
                        String thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl3 != null && overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint5 = musicPlayButtonRenderer2.playNavigationEndpoint) != null && (watchEndpoint3 = navigationEndpoint5.watchPlaylistEndpoint) != null && menu != null && (menuRenderer3 = menu.menuRenderer) != null && (list6 = menuRenderer3.items) != null) {
                            Iterator it2 = list6.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next4 = null;
                                    break;
                                }
                                next4 = it2.next();
                                menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon5 = menuNavigationItemRenderer10.icon) == null) ? null : icon5.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next4;
                            if (item2 != null && (menuNavigationItemRenderer7 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint6 = menuNavigationItemRenderer7.navigationEndpoint) != null && (watchEndpoint4 = navigationEndpoint6.watchPlaylistEndpoint) != null) {
                                Iterator it3 = menuRenderer3.items.iterator();
                                do {
                                    if (!it3.hasNext()) {
                                        next5 = null;
                                        break;
                                    }
                                    next5 = it3.next();
                                    menuNavigationItemRenderer9 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer9 == null || (icon4 = menuNavigationItemRenderer9.icon) == null) ? null : icon4.iconType, "MIX"));
                                Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next5;
                                if (item3 != null && (menuNavigationItemRenderer8 = item3.menuNavigationItemRenderer) != null && (navigationEndpoint7 = menuNavigationItemRenderer8.navigationEndpoint) != null) {
                                    obj = navigationEndpoint7.watchPlaylistEndpoint;
                                }
                                return new PlaylistItem(strRemovePrefix, str6, artist4, str7, thumbnailUrl3, watchEndpoint3, watchEndpoint4, (WatchEndpoint) obj, false, (String) null, (String) null, 3840);
                            }
                        }
                    }
                }
            } else if (musicTwoRowItemRenderer.isArtist()) {
                BrowseEndpoint browseEndpoint5 = navigationEndpoint10.browseEndpoint;
                if (browseEndpoint5 != null && (str3 = browseEndpoint5.browseId) != null && (list4 = runs.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str4 = run3.text) != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null && menu != null && (menuRenderer2 = menu.menuRenderer) != null && (list5 = menuRenderer2.items) != null) {
                    Iterator it4 = list5.iterator();
                    do {
                        if (!it4.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it4.next();
                        menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon3 = menuNavigationItemRenderer6.icon) == null) ? null : icon3.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next2;
                    if (item4 != null && (menuNavigationItemRenderer3 = item4.menuNavigationItemRenderer) != null && (navigationEndpoint3 = menuNavigationItemRenderer3.navigationEndpoint) != null && (watchEndpoint = navigationEndpoint3.watchPlaylistEndpoint) != null) {
                        Iterator it5 = menuRenderer2.items.iterator();
                        do {
                            if (!it5.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it5.next();
                            menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon2 = menuNavigationItemRenderer5.icon) == null) ? null : icon2.iconType, "MIX"));
                        Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next3;
                        if (item5 != null && (menuNavigationItemRenderer4 = item5.menuNavigationItemRenderer) != null && (navigationEndpoint4 = menuNavigationItemRenderer4.navigationEndpoint) != null && (watchEndpoint2 = navigationEndpoint4.watchPlaylistEndpoint) != null) {
                            return new ArtistItem(str3, str4, thumbnailUrl, (String) null, (WatchEndpoint) null, watchEndpoint, watchEndpoint2, 152);
                        }
                    }
                }
            } else if (musicTwoRowItemRenderer.isPodcast() && (browseEndpoint = navigationEndpoint10.browseEndpoint) != null && (str = browseEndpoint.browseId) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str2 = run.text) != null) {
                Artist artist5 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs2 != null ? runs2.runs : null));
                String str13 = (runs2 == null || (list3 = runs2.runs) == null || (run2 = (Run) CollectionsKt.lastOrNull(list3)) == null) ? null : run2.text;
                String thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl();
                WatchEndpoint watchEndpoint6 = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint2.watchPlaylistEndpoint;
                if (menu != null && (menuRenderer = menu.menuRenderer) != null && (list2 = menuRenderer.items) != null) {
                    Iterator it6 = list2.iterator();
                    do {
                        if (!it6.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it6.next();
                        menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon = menuNavigationItemRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item6 = (Menu.MenuRenderer.Item) next;
                    if (item6 != null && (menuNavigationItemRenderer = item6.menuNavigationItemRenderer) != null && (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) != null) {
                        obj = navigationEndpoint.watchPlaylistEndpoint;
                    }
                }
                return new PodcastItem(str, str2, artist5, str13, thumbnailUrl4, watchEndpoint6, obj, null, null, null, 896);
            }
            return null;
        }
    }

    public RelatedPage(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.songs = arrayList;
        this.albums = arrayList2;
        this.artists = arrayList3;
        this.playlists = arrayList4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelatedPage)) {
            return false;
        }
        RelatedPage relatedPage = (RelatedPage) obj;
        return this.songs.equals(relatedPage.songs) && this.albums.equals(relatedPage.albums) && this.artists.equals(relatedPage.artists) && this.playlists.equals(relatedPage.playlists);
    }

    public final int hashCode() {
        return this.playlists.hashCode() + ((this.artists.hashCode() + ((this.albums.hashCode() + (this.songs.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RelatedPage(songs=" + this.songs + ", albums=" + this.albums + ", artists=" + this.artists + ", playlists=" + this.playlists + ")";
    }
}
