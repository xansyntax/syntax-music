package com.metrolist.innertube.pages;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Button;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicCarouselShelfRenderer;
import com.metrolist.innertube.models.MusicMultiRowListItemRenderer;
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
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HomePage {
    public final List chips;
    public final String continuation;
    public final List sections;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Chip {
        public final BrowseEndpoint deselectEndPoint;
        public final BrowseEndpoint endpoint;
        public final String title;

        public Chip(String str, BrowseEndpoint browseEndpoint, BrowseEndpoint browseEndpoint2) {
            str.getClass();
            this.title = str;
            this.endpoint = browseEndpoint;
            this.deselectEndPoint = browseEndpoint2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Chip)) {
                return false;
            }
            Chip chip = (Chip) obj;
            return Intrinsics.areEqual(this.title, chip.title) && Intrinsics.areEqual(this.endpoint, chip.endpoint) && Intrinsics.areEqual(this.deselectEndPoint, chip.deselectEndPoint);
        }

        public final int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            BrowseEndpoint browseEndpoint = this.endpoint;
            int iHashCode2 = (iHashCode + (browseEndpoint == null ? 0 : browseEndpoint.hashCode())) * 31;
            BrowseEndpoint browseEndpoint2 = this.deselectEndPoint;
            return iHashCode2 + (browseEndpoint2 != null ? browseEndpoint2.hashCode() : 0);
        }

        public final String toString() {
            return "Chip(title=" + this.title + ", endpoint=" + this.endpoint + ", deselectEndPoint=" + this.deselectEndPoint + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Section {
        public final BrowseEndpoint endpoint;
        public final List items;
        public final String label;
        public final String thumbnail;
        public final String title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public abstract class Companion {
            /* JADX WARN: Code duplicated, block: B:424:0x052b  */
            /* JADX WARN: Code duplicated, block: B:592:0x0785  */
            /* JADX WARN: Code duplicated, block: B:605:0x07c9  */
            /* JADX WARN: Code duplicated, block: B:648:0x0851  */
            public static Section fromMusicCarouselShelfRenderer(MusicCarouselShelfRenderer musicCarouselShelfRenderer) {
                Button.ButtonRenderer buttonRenderer;
                NavigationEndpoint navigationEndpoint;
                List list;
                Run run;
                MusicResponsiveListItemRenderer.FlexColumn flexColumn;
                MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
                Runs runs;
                List list2;
                MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
                MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
                Runs runs2;
                List list3;
                Run run2;
                String str;
                Album album;
                String thumbnailUrl;
                Badges badges;
                SongItem songItem;
                Object next;
                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
                Icon icon;
                Run run3;
                String str2;
                Run run4;
                BrowseEndpoint browseEndpoint;
                EpisodeItem episodeItem;
                WatchEndpoint watchEndpoint;
                String str3;
                Runs runs3;
                List list4;
                Run run5;
                String str4;
                String thumbnailUrl2;
                List list5;
                Run run6;
                List list6;
                Run run7;
                String str5;
                Menu.MenuRenderer menuRenderer;
                List list7;
                Run run8;
                Album album2;
                boolean z;
                Object episodeItem2;
                Icon icon2;
                List list8;
                Run run9;
                List list9;
                Run run10;
                String str6;
                BrowseEndpoint browseEndpoint2;
                String str7;
                List list10;
                Object next2;
                BrowseEndpoint browseEndpoint3;
                Menu.MenuRenderer menuRenderer2;
                List list11;
                Run run11;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
                NavigationEndpoint navigationEndpoint2;
                WatchEndpoint watchEndpoint2;
                String str8;
                Run run12;
                String str9;
                WatchEndpoint watchEndpoint3;
                Menu.MenuRenderer menuRenderer3;
                List list12;
                Object next3;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
                NavigationEndpoint navigationEndpoint3;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
                Icon icon3;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
                NavigationEndpoint navigationEndpoint4;
                String str10;
                Run run13;
                String str11;
                String thumbnailUrl3;
                Menu.MenuRenderer menuRenderer4;
                List list13;
                Object next4;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
                NavigationEndpoint navigationEndpoint5;
                WatchEndpoint watchEndpoint4;
                Object next5;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
                NavigationEndpoint navigationEndpoint6;
                WatchEndpoint watchEndpoint5;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
                Icon icon4;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
                Icon icon5;
                String str12;
                Run run14;
                String str13;
                Artist artist;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
                NavigationEndpoint navigationEndpoint7;
                WatchEndpoint watchEndpoint6;
                Menu.MenuRenderer menuRenderer5;
                List list14;
                Object next6;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
                NavigationEndpoint navigationEndpoint8;
                WatchEndpoint watchEndpoint7;
                Object next7;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
                NavigationEndpoint navigationEndpoint9;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
                Icon icon6;
                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
                Icon icon7;
                List list15;
                Run run15;
                String str14;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer4;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content4;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer4;
                NavigationEndpoint navigationEndpoint10;
                WatchEndpoint watchEndpoint8;
                String str15;
                Run run16;
                String str16;
                Badges badges2;
                Object next8;
                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2;
                Icon icon8;
                Object obj;
                List list16;
                Run run17;
                String str17;
                String str18;
                Object next9;
                Album album3;
                boolean z2;
                Icon icon9;
                BrowseEndpoint browseEndpoint4;
                String str19;
                BrowseEndpoint browseEndpoint5;
                String str20;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer5;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content5;
                MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer5;
                NavigationEndpoint navigationEndpoint11;
                BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
                Run run18;
                MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
                Runs runs4;
                List list17;
                Run run19;
                musicCarouselShelfRenderer.getClass();
                List list18 = musicCarouselShelfRenderer.contents;
                MusicCarouselShelfRenderer.Header header = musicCarouselShelfRenderer.header;
                String str21 = (header == null || (musicCarouselShelfBasicHeaderRenderer = header.musicCarouselShelfBasicHeaderRenderer) == null || (runs4 = musicCarouselShelfBasicHeaderRenderer.title) == null || (list17 = runs4.runs) == null || (run19 = (Run) CollectionsKt.firstOrNull(list17)) == null) ? null : run19.text;
                ConnectionPool connectionPool = Timber.Forest;
                list18.size();
                connectionPool.getClass();
                ConnectionPool.d(new Object[0]);
                if (str21 == null) {
                    ConnectionPool.d(new Object[0]);
                    return null;
                }
                if (!list18.isEmpty()) {
                    Iterator it = list18.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        if (((MusicCarouselShelfRenderer.Content) it.next()).musicTwoRowItemRenderer != null && (i = i + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                if (!list18.isEmpty()) {
                    Iterator it2 = list18.iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        if (((MusicCarouselShelfRenderer.Content) it2.next()).musicMultiRowListItemRenderer != null && (i2 = i2 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                if (!list18.isEmpty()) {
                    Iterator it3 = list18.iterator();
                    int i3 = 0;
                    while (it3.hasNext()) {
                        if (((MusicCarouselShelfRenderer.Content) it3.next()).musicResponsiveListItemRenderer != null && (i3 = i3 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator it4 = list18.iterator();
                while (it4.hasNext()) {
                    MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((MusicCarouselShelfRenderer.Content) it4.next()).musicTwoRowItemRenderer;
                    if (musicTwoRowItemRenderer != null) {
                        arrayList2.add(musicTwoRowItemRenderer);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = (MusicTwoRowItemRenderer) obj2;
                    Runs runs5 = musicTwoRowItemRenderer2.title;
                    List list19 = musicTwoRowItemRenderer2.subtitleBadges;
                    Menu menu = musicTwoRowItemRenderer2.menu;
                    ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer2.thumbnailRenderer;
                    MusicResponsiveListItemRenderer.Overlay overlay = musicTwoRowItemRenderer2.thumbnailOverlay;
                    Runs runs6 = musicTwoRowItemRenderer2.subtitle;
                    List list20 = list18;
                    NavigationEndpoint navigationEndpoint12 = musicTwoRowItemRenderer2.navigationEndpoint;
                    List list21 = runs5.runs;
                    List list22 = runs5.runs;
                    if (list21 != null && (run18 = (Run) CollectionsKt.firstOrNull(list21)) != null) {
                        String str22 = run18.text;
                    }
                    BrowseEndpoint browseEndpoint6 = navigationEndpoint12.browseEndpoint;
                    WatchEndpoint watchEndpoint9 = navigationEndpoint12.watchEndpoint;
                    ArrayList arrayList4 = arrayList2;
                    if (browseEndpoint6 != null && (browseEndpointContextSupportedConfigs = browseEndpoint6.browseEndpointContextSupportedConfigs) != null) {
                        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig;
                    }
                    if (!musicTwoRowItemRenderer2.isSong() && !musicTwoRowItemRenderer2.isAlbum() && !musicTwoRowItemRenderer2.isPlaylist() && !musicTwoRowItemRenderer2.isArtist() && !musicTwoRowItemRenderer2.isPodcast() && !musicTwoRowItemRenderer2.isEpisode()) {
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (musicTwoRowItemRenderer2.isEpisode()) {
                        if (overlay != null && (musicItemThumbnailOverlayRenderer5 = overlay.musicItemThumbnailOverlayRenderer) != null && (content5 = musicItemThumbnailOverlayRenderer5.content) != null && (musicPlayButtonRenderer5 = content5.musicPlayButtonRenderer) != null && (navigationEndpoint11 = musicPlayButtonRenderer5.playNavigationEndpoint) != null) {
                            WatchEndpoint watchEndpoint10 = navigationEndpoint11.watchEndpoint;
                        }
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                    }
                    if (musicTwoRowItemRenderer2.isSong()) {
                        if (runs6 != null && (list16 = runs6.runs) != null && list22 != null && (run17 = (Run) CollectionsKt.firstOrNull(list22)) != null && (str17 = run17.text) != null && watchEndpoint9 != null && (str18 = watchEndpoint9.videoId) != null) {
                            ArrayList arrayListExtractArtists = PageHelper.extractArtists(list16);
                            Iterator it5 = list16.iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    next9 = null;
                                    break;
                                }
                                next9 = it5.next();
                                NavigationEndpoint navigationEndpoint13 = ((Run) next9).navigationEndpoint;
                                if (navigationEndpoint13 != null && (browseEndpoint5 = navigationEndpoint13.browseEndpoint) != null && (str20 = browseEndpoint5.browseId) != null && StringsKt__StringsJVMKt.startsWith(str20, "MPREb_", false)) {
                                    break;
                                }
                            }
                            Run run20 = (Run) next9;
                            if (run20 != null) {
                                String str23 = run20.text;
                                NavigationEndpoint navigationEndpoint14 = run20.navigationEndpoint;
                                album3 = (navigationEndpoint14 == null || (browseEndpoint4 = navigationEndpoint14.browseEndpoint) == null || (str19 = browseEndpoint4.browseId) == null) ? null : new Album(str23, str19);
                            } else {
                                album3 = null;
                            }
                            String thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl();
                            if (thumbnailUrl4 != null) {
                                if (list19 != null && !list19.isEmpty()) {
                                    Iterator it6 = list19.iterator();
                                    while (true) {
                                        if (!it6.hasNext()) {
                                            z2 = false;
                                            break;
                                        }
                                        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer3 = ((Badges) it6.next()).musicInlineBadgeRenderer;
                                        if (Intrinsics.areEqual((musicInlineBadgeRenderer3 == null || (icon9 = musicInlineBadgeRenderer3.icon) == null) ? null : icon9.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                } else {
                                    z2 = false;
                                    break;
                                }
                                episodeItem2 = new SongItem(str18, str17, arrayListExtractArtists, album3, null, null, null, null, thumbnailUrl4, z2, null, null, null, null, null, false, null, 130272);
                                obj = episodeItem2;
                            }
                        }
                        obj = null;
                    } else if (musicTwoRowItemRenderer2.isAlbum()) {
                        if (browseEndpoint6 != null && (str14 = browseEndpoint6.browseId) != null && overlay != null && (musicItemThumbnailOverlayRenderer4 = overlay.musicItemThumbnailOverlayRenderer) != null && (content4 = musicItemThumbnailOverlayRenderer4.content) != null && (musicPlayButtonRenderer4 = content4.musicPlayButtonRenderer) != null && (navigationEndpoint10 = musicPlayButtonRenderer4.playNavigationEndpoint) != null && (watchEndpoint8 = navigationEndpoint10.watchPlaylistEndpoint) != null && (str15 = watchEndpoint8.playlistId) != null && list22 != null && (run16 = (Run) CollectionsKt.firstOrNull(list22)) != null && (str16 = run16.text) != null) {
                            Set set = PageHelper.LIBRARY_ADD_ICONS;
                            ArrayList arrayListExtractArtists2 = PageHelper.extractArtists(runs6 != null ? runs6.runs : null);
                            String thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl();
                            if (thumbnailUrl5 != null) {
                                if (list19 != null) {
                                    Iterator it7 = list19.iterator();
                                    do {
                                        if (!it7.hasNext()) {
                                            next8 = null;
                                            break;
                                        }
                                        next8 = it7.next();
                                        musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                    } while (!Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon8 = musicInlineBadgeRenderer2.icon) == null) ? null : icon8.iconType, "MUSIC_EXPLICIT_BADGE"));
                                    badges2 = (Badges) next8;
                                } else {
                                    badges2 = null;
                                }
                                episodeItem2 = new AlbumItem(str14, str15, str16, arrayListExtractArtists2, (Integer) null, thumbnailUrl5, badges2 != null, 4);
                                obj = episodeItem2;
                            }
                        }
                        obj = null;
                    } else if (musicTwoRowItemRenderer2.isPlaylist()) {
                        if (browseEndpoint6 != null && (str12 = browseEndpoint6.browseId) != null) {
                            String strRemovePrefix = StringsKt.removePrefix(str12, "VL");
                            if (list22 != null && (run14 = (Run) CollectionsKt.firstOrNull(list22)) != null && (str13 = run14.text) != null) {
                                List list23 = runs6 != null ? runs6.runs : null;
                                Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list23));
                                if (artist2 != null) {
                                    artist = artist2;
                                } else {
                                    if (list23 != null && (list15 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list23))) != null && (run15 = (Run) CollectionsKt.firstOrNull(list15)) != null) {
                                        if (run15.navigationEndpoint != null || StringsKt.isBlank(run15.text)) {
                                            run15 = null;
                                        }
                                        if (run15 != null) {
                                            artist2 = new Artist(StringsKt.trim(run15.text).toString(), null);
                                            artist = artist2;
                                        }
                                    }
                                    artist = null;
                                }
                                String thumbnailUrl6 = thumbnailRenderer.getThumbnailUrl();
                                if (thumbnailUrl6 != null && overlay != null && (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) != null && (content3 = musicItemThumbnailOverlayRenderer3.content) != null && (musicPlayButtonRenderer3 = content3.musicPlayButtonRenderer) != null && (navigationEndpoint7 = musicPlayButtonRenderer3.playNavigationEndpoint) != null && (watchEndpoint6 = navigationEndpoint7.watchPlaylistEndpoint) != null && menu != null && (menuRenderer5 = menu.menuRenderer) != null && (list14 = menuRenderer5.items) != null) {
                                    Iterator it8 = list14.iterator();
                                    do {
                                        if (!it8.hasNext()) {
                                            next6 = null;
                                            break;
                                        }
                                        next6 = it8.next();
                                        menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon7 = menuNavigationItemRenderer10.icon) == null) ? null : icon7.iconType, "MUSIC_SHUFFLE"));
                                    Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next6;
                                    if (item != null && (menuNavigationItemRenderer7 = item.menuNavigationItemRenderer) != null && (navigationEndpoint8 = menuNavigationItemRenderer7.navigationEndpoint) != null && (watchEndpoint7 = navigationEndpoint8.watchPlaylistEndpoint) != null) {
                                        Iterator it9 = list14.iterator();
                                        do {
                                            if (!it9.hasNext()) {
                                                next7 = null;
                                                break;
                                            }
                                            next7 = it9.next();
                                            menuNavigationItemRenderer9 = ((Menu.MenuRenderer.Item) next7).menuNavigationItemRenderer;
                                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer9 == null || (icon6 = menuNavigationItemRenderer9.icon) == null) ? null : icon6.iconType, "MIX"));
                                        Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next7;
                                        episodeItem2 = new PlaylistItem(strRemovePrefix, str13, artist, (String) null, thumbnailUrl6, watchEndpoint6, watchEndpoint7, (item2 == null || (menuNavigationItemRenderer8 = item2.menuNavigationItemRenderer) == null || (navigationEndpoint9 = menuNavigationItemRenderer8.navigationEndpoint) == null) ? null : navigationEndpoint9.watchPlaylistEndpoint, false, (String) null, (String) null, 3840);
                                        obj = episodeItem2;
                                    }
                                }
                            }
                        }
                        obj = null;
                    } else if (musicTwoRowItemRenderer2.isArtist()) {
                        if (browseEndpoint6 != null && (str10 = browseEndpoint6.browseId) != null && list22 != null && (run13 = (Run) CollectionsKt.lastOrNull(list22)) != null && (str11 = run13.text) != null && (thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl()) != null && menu != null && (menuRenderer4 = menu.menuRenderer) != null && (list13 = menuRenderer4.items) != null) {
                            Iterator it10 = list13.iterator();
                            do {
                                if (!it10.hasNext()) {
                                    next4 = null;
                                    break;
                                }
                                next4 = it10.next();
                                menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon5 = menuNavigationItemRenderer6.icon) == null) ? null : icon5.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next4;
                            if (item3 != null && (menuNavigationItemRenderer3 = item3.menuNavigationItemRenderer) != null && (navigationEndpoint5 = menuNavigationItemRenderer3.navigationEndpoint) != null && (watchEndpoint4 = navigationEndpoint5.watchPlaylistEndpoint) != null) {
                                Iterator it11 = list13.iterator();
                                do {
                                    if (!it11.hasNext()) {
                                        next5 = null;
                                        break;
                                    }
                                    next5 = it11.next();
                                    menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon4 = menuNavigationItemRenderer5.icon) == null) ? null : icon4.iconType, "MIX"));
                                Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next5;
                                if (item4 != null && (menuNavigationItemRenderer4 = item4.menuNavigationItemRenderer) != null && (navigationEndpoint6 = menuNavigationItemRenderer4.navigationEndpoint) != null && (watchEndpoint5 = navigationEndpoint6.watchPlaylistEndpoint) != null) {
                                    episodeItem2 = new ArtistItem(str10, str11, thumbnailUrl3, (String) null, (WatchEndpoint) null, watchEndpoint4, watchEndpoint5, 152);
                                    obj = episodeItem2;
                                }
                            }
                        }
                        obj = null;
                    } else if (!musicTwoRowItemRenderer2.isPodcast()) {
                        if (musicTwoRowItemRenderer2.isEpisode()) {
                            String str24 = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint2.watchEndpoint) == null) ? null : watchEndpoint2.videoId;
                            String str25 = (list22 == null || (run11 = (Run) CollectionsKt.firstOrNull(list22)) == null) ? null : run11.text;
                            String thumbnailUrl7 = thumbnailRenderer.getThumbnailUrl();
                            if (str24 == null || str25 == null || thumbnailUrl7 == null) {
                                Timber.Forest.getClass();
                                ConnectionPool.d(new Object[0]);
                            } else {
                                ArrayList arrayListSplitBySeparator = (runs6 == null || (list11 = runs6.runs) == null) ? null : CharsKt.splitBySeparator(list11);
                                Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                                PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer2 = menu.menuRenderer) == null) ? null : menuRenderer2.items);
                                if (runs6 == null || (list10 = runs6.runs) == null) {
                                    run8 = null;
                                } else {
                                    Iterator it12 = list10.iterator();
                                    while (true) {
                                        if (!it12.hasNext()) {
                                            next2 = null;
                                            break;
                                        }
                                        next2 = it12.next();
                                        NavigationEndpoint navigationEndpoint15 = ((Run) next2).navigationEndpoint;
                                        if (navigationEndpoint15 != null && (browseEndpoint3 = navigationEndpoint15.browseEndpoint) != null && browseEndpoint3.isPodcastEndpoint()) {
                                            break;
                                        }
                                    }
                                    run8 = (Run) next2;
                                }
                                if (run8 != null) {
                                    String str26 = run8.text;
                                    NavigationEndpoint navigationEndpoint16 = run8.navigationEndpoint;
                                    album2 = (navigationEndpoint16 == null || (browseEndpoint2 = navigationEndpoint16.browseEndpoint) == null || (str7 = browseEndpoint2.browseId) == null) ? null : new Album(str26, str7);
                                } else {
                                    album2 = null;
                                }
                                Timber.Forest.getClass();
                                ConnectionPool.d(new Object[0]);
                                Artist artist3 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs6 != null ? runs6.runs : null));
                                Integer numM1883parseTime = (arrayListSplitBySeparator == null || (list9 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator)) == null || (run10 = (Run) CollectionsKt.firstOrNull(list9)) == null || (str6 = run10.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str6);
                                String str27 = (arrayListSplitBySeparator == null || (list8 = (List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator)) == null || (run9 = (Run) CollectionsKt.firstOrNull(list8)) == null) ? null : run9.text;
                                if (list19 != null && !list19.isEmpty()) {
                                    Iterator it13 = list19.iterator();
                                    while (true) {
                                        if (!it13.hasNext()) {
                                            z = false;
                                            break;
                                        }
                                        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer4 = ((Badges) it13.next()).musicInlineBadgeRenderer;
                                        if (Intrinsics.areEqual((musicInlineBadgeRenderer4 == null || (icon2 = musicInlineBadgeRenderer4.icon) == null) ? null : icon2.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                            z = true;
                                            break;
                                        }
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                                episodeItem2 = new EpisodeItem(str24, str25, artist3, album2, numM1883parseTime, str27, thumbnailUrl7, z, overlay.musicItemThumbnailOverlayRenderer.content.musicPlayButtonRenderer.playNavigationEndpoint.watchEndpoint, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                                obj = episodeItem2;
                            }
                        }
                        obj = null;
                    } else if (browseEndpoint6 == null || (str8 = browseEndpoint6.browseId) == null || list22 == null || (run12 = (Run) CollectionsKt.firstOrNull(list22)) == null || (str9 = run12.text) == null) {
                        obj = null;
                    } else {
                        Artist artist4 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs6 != null ? runs6.runs : null));
                        String thumbnailUrl8 = thumbnailRenderer.getThumbnailUrl();
                        WatchEndpoint watchEndpoint11 = (overlay == null || (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) == null || (content2 = musicItemThumbnailOverlayRenderer2.content) == null || (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) == null || (navigationEndpoint4 = musicPlayButtonRenderer2.playNavigationEndpoint) == null) ? null : navigationEndpoint4.watchPlaylistEndpoint;
                        if (menu == null || (menuRenderer3 = menu.menuRenderer) == null || (list12 = menuRenderer3.items) == null) {
                            watchEndpoint3 = null;
                        } else {
                            Iterator it14 = list12.iterator();
                            do {
                                if (!it14.hasNext()) {
                                    next3 = null;
                                    break;
                                }
                                next3 = it14.next();
                                menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon3 = menuNavigationItemRenderer2.icon) == null) ? null : icon3.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next3;
                            if (item5 == null || (menuNavigationItemRenderer = item5.menuNavigationItemRenderer) == null || (navigationEndpoint3 = menuNavigationItemRenderer.navigationEndpoint) == null) {
                                watchEndpoint3 = null;
                            } else {
                                watchEndpoint3 = navigationEndpoint3.watchPlaylistEndpoint;
                            }
                        }
                        episodeItem2 = new PodcastItem(str8, str9, artist4, null, thumbnailUrl8, watchEndpoint11, watchEndpoint3, null, null, null, 896);
                        obj = episodeItem2;
                    }
                    if (obj != null) {
                        arrayList3.add(obj);
                    }
                    list18 = list20;
                    arrayList2 = arrayList4;
                    str21 = str21;
                }
                List list24 = list18;
                String str28 = str21;
                arrayList.addAll(arrayList3);
                ArrayList arrayList5 = new ArrayList();
                Iterator it15 = list24.iterator();
                while (it15.hasNext()) {
                    MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = ((MusicCarouselShelfRenderer.Content) it15.next()).musicMultiRowListItemRenderer;
                    if (musicMultiRowListItemRenderer != null) {
                        arrayList5.add(musicMultiRowListItemRenderer);
                    }
                }
                ArrayList arrayList6 = new ArrayList();
                int size2 = arrayList5.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj3 = arrayList5.get(i5);
                    i5++;
                    MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2 = (MusicMultiRowListItemRenderer) obj3;
                    Runs runs7 = musicMultiRowListItemRenderer2.subtitle;
                    NavigationEndpoint navigationEndpoint17 = musicMultiRowListItemRenderer2.onTap;
                    ArrayList arrayListSplitBySeparator2 = (runs7 == null || (list7 = runs7.runs) == null) ? null : CharsKt.splitBySeparator(list7);
                    Set set3 = PageHelper.LIBRARY_ADD_ICONS;
                    Menu menu2 = musicMultiRowListItemRenderer2.menu;
                    PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems2 = PageHelper.extractLibraryTokensFromMenuItems((menu2 == null || (menuRenderer = menu2.menuRenderer) == null) ? null : menuRenderer.items);
                    if (navigationEndpoint17 == null || (watchEndpoint = navigationEndpoint17.watchEndpoint) == null || (str3 = watchEndpoint.videoId) == null || (runs3 = musicMultiRowListItemRenderer2.title) == null || (list4 = runs3.runs) == null || (run5 = (Run) CollectionsKt.firstOrNull(list4)) == null || (str4 = run5.text) == null) {
                        episodeItem = null;
                    } else {
                        Integer numM1883parseTime2 = (arrayListSplitBySeparator2 == null || (list6 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator2)) == null || (run7 = (Run) CollectionsKt.firstOrNull(list6)) == null || (str5 = run7.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str5);
                        String str29 = (arrayListSplitBySeparator2 == null || (list5 = (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator2)) == null || (run6 = (Run) CollectionsKt.firstOrNull(list5)) == null) ? null : run6.text;
                        ThumbnailRenderer thumbnailRenderer2 = musicMultiRowListItemRenderer2.thumbnail;
                        if (thumbnailRenderer2 == null || (thumbnailUrl2 = thumbnailRenderer2.getThumbnailUrl()) == null) {
                            episodeItem = null;
                        } else {
                            episodeItem = new EpisodeItem(str3, str4, null, null, numM1883parseTime2, str29, thumbnailUrl2, false, navigationEndpoint17.watchEndpoint, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, 6144);
                        }
                    }
                    if (episodeItem != null) {
                        arrayList6.add(episodeItem);
                    }
                }
                arrayList.addAll(arrayList6);
                ArrayList arrayList7 = new ArrayList();
                Iterator it16 = list24.iterator();
                while (it16.hasNext()) {
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicCarouselShelfRenderer.Content) it16.next()).musicResponsiveListItemRenderer;
                    if (musicResponsiveListItemRenderer != null) {
                        arrayList7.add(musicResponsiveListItemRenderer);
                    }
                }
                ArrayList arrayList8 = new ArrayList();
                int size3 = arrayList7.size();
                int i6 = 0;
                while (i6 < size3) {
                    Object obj4 = arrayList7.get(i6);
                    i6++;
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = (MusicResponsiveListItemRenderer) obj4;
                    boolean zIsSong = musicResponsiveListItemRenderer2.isSong();
                    List list25 = musicResponsiveListItemRenderer2.flexColumns;
                    if (!zIsSong || (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list25)) == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list2 = runs.runs) == null) {
                        songItem = null;
                    } else {
                        ArrayList arrayListSplitBySeparator3 = CharsKt.splitBySeparator(list2);
                        String videoId = musicResponsiveListItemRenderer2.getVideoId();
                        if (videoId != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list25)) != null && (musicResponsiveListItemFlexColumnRenderer2 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) != null && (list3 = runs2.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list3)) != null && (str = run2.text) != null) {
                            Set set4 = PageHelper.LIBRARY_ADD_ICONS;
                            ArrayList arrayListExtractArtists3 = PageHelper.extractArtists((List) CollectionsKt.getOrNull(0, arrayListSplitBySeparator3));
                            List list26 = (List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator3);
                            if (list26 == null || (run4 = (Run) CollectionsKt.firstOrNull(list26)) == null) {
                                album = null;
                            } else {
                                NavigationEndpoint navigationEndpoint18 = run4.navigationEndpoint;
                                if ((navigationEndpoint18 != null ? navigationEndpoint18.browseEndpoint : null) == null) {
                                    run4 = null;
                                }
                                if (run4 != null) {
                                    String str30 = run4.text;
                                    NavigationEndpoint navigationEndpoint19 = run4.navigationEndpoint;
                                    String str31 = (navigationEndpoint19 == null || (browseEndpoint = navigationEndpoint19.browseEndpoint) == null) ? null : browseEndpoint.browseId;
                                    str31.getClass();
                                    album = new Album(str30, str31);
                                } else {
                                    album = null;
                                }
                            }
                            List list27 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator3);
                            Integer numM1883parseTime3 = (list27 == null || (run3 = (Run) CollectionsKt.firstOrNull(list27)) == null || (str2 = run3.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str2);
                            ThumbnailRenderer thumbnailRenderer3 = musicResponsiveListItemRenderer2.thumbnail;
                            if (thumbnailRenderer3 != null && (thumbnailUrl = thumbnailRenderer3.getThumbnailUrl()) != null) {
                                List list28 = musicResponsiveListItemRenderer2.badges;
                                if (list28 != null) {
                                    Iterator it17 = list28.iterator();
                                    do {
                                        if (!it17.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it17.next();
                                        musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                                    } while (!Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon = musicInlineBadgeRenderer.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE"));
                                    badges = (Badges) next;
                                } else {
                                    badges = null;
                                }
                                songItem = new SongItem(videoId, str, arrayListExtractArtists3, album, numM1883parseTime3, null, null, null, thumbnailUrl, badges != null, null, null, null, null, null, musicResponsiveListItemRenderer2.isEpisode(), null, 97504);
                            }
                        }
                        songItem = null;
                    }
                    if (songItem != null) {
                        arrayList8.add(songItem);
                    }
                }
                arrayList.addAll(arrayList8);
                if (!arrayList.isEmpty()) {
                    int size4 = arrayList.size();
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 < size4) {
                        Object obj5 = arrayList.get(i7);
                        i7++;
                        if ((((YTItem) obj5) instanceof PodcastItem) && (i8 = i8 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    int size5 = arrayList.size();
                    int i9 = 0;
                    int i10 = 0;
                    while (i9 < size5) {
                        Object obj6 = arrayList.get(i9);
                        i9++;
                        if ((((YTItem) obj6) instanceof EpisodeItem) && (i10 = i10 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    int size6 = arrayList.size();
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < size6) {
                        Object obj7 = arrayList.get(i11);
                        i11++;
                        if ((((YTItem) obj7) instanceof SongItem) && (i12 = i12 + 1) < 0) {
                            CollectionsKt__IterablesKt.throwCountOverflow();
                            throw null;
                        }
                    }
                }
                ConnectionPool connectionPool2 = Timber.Forest;
                arrayList.size();
                connectionPool2.getClass();
                ConnectionPool.d(new Object[0]);
                if (arrayList.isEmpty()) {
                    ConnectionPool.d(new Object[0]);
                    return null;
                }
                MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer2 = header.musicCarouselShelfBasicHeaderRenderer;
                MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer3 = header.musicCarouselShelfBasicHeaderRenderer;
                Runs runs8 = musicCarouselShelfBasicHeaderRenderer2.strapline;
                String str32 = (runs8 == null || (list = runs8.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null) ? null : run.text;
                ThumbnailRenderer thumbnailRenderer4 = musicCarouselShelfBasicHeaderRenderer3.thumbnail;
                String thumbnailUrl9 = thumbnailRenderer4 != null ? thumbnailRenderer4.getThumbnailUrl() : null;
                Button button = musicCarouselShelfBasicHeaderRenderer3.moreContentButton;
                return new Section(str28, str32, thumbnailUrl9, (button == null || (buttonRenderer = button.buttonRenderer) == null || (navigationEndpoint = buttonRenderer.navigationEndpoint) == null) ? null : navigationEndpoint.browseEndpoint, arrayList);
            }
        }

        public Section(String str, String str2, String str3, BrowseEndpoint browseEndpoint, List list) {
            this.title = str;
            this.label = str2;
            this.thumbnail = str3;
            this.endpoint = browseEndpoint;
            this.items = list;
        }

        public static Section copy$default(Section section, List list) {
            return new Section(section.title, section.label, section.thumbnail, section.endpoint, list);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Section)) {
                return false;
            }
            Section section = (Section) obj;
            return this.title.equals(section.title) && Intrinsics.areEqual(this.label, section.label) && Intrinsics.areEqual(this.thumbnail, section.thumbnail) && Intrinsics.areEqual(this.endpoint, section.endpoint) && this.items.equals(section.items);
        }

        public final int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.label;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.thumbnail;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            BrowseEndpoint browseEndpoint = this.endpoint;
            return this.items.hashCode() + ((iHashCode3 + (browseEndpoint != null ? browseEndpoint.hashCode() : 0)) * 31);
        }

        public final String toString() {
            StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Section(title=", this.title, ", label=", this.label, ", thumbnail=");
            sbM.append(this.thumbnail);
            sbM.append(", endpoint=");
            sbM.append(this.endpoint);
            sbM.append(", items=");
            sbM.append(this.items);
            sbM.append(")");
            return sbM.toString();
        }
    }

    public HomePage(List list, List list2, String str) {
        this.chips = list;
        this.sections = list2;
        this.continuation = str;
    }

    public static HomePage copy$default(HomePage homePage, List list, ArrayList arrayList, int i) {
        if ((i & 1) != 0) {
            list = homePage.chips;
        }
        return new HomePage(list, arrayList, homePage.continuation);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomePage)) {
            return false;
        }
        HomePage homePage = (HomePage) obj;
        return Intrinsics.areEqual(this.chips, homePage.chips) && this.sections.equals(homePage.sections) && Intrinsics.areEqual(this.continuation, homePage.continuation);
    }

    public final int hashCode() {
        List list = this.chips;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((list == null ? 0 : list.hashCode()) * 31, 31, this.sections);
        String str = this.continuation;
        return iM + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HomePage(chips=");
        sb.append(this.chips);
        sb.append(", sections=");
        sb.append(this.sections);
        sb.append(", continuation=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.continuation, ")");
    }
}
