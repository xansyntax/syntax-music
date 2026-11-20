package com.metrolist.innertube.pages;

import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
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
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SearchSuggestionPage {
    /* JADX WARN: Code duplicated, block: B:142:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:425:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:502:0x05be  */
    /* JADX WARN: Multi-variable type inference failed */
    public static YTItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
        MusicResponsiveListItemRenderer.FlexColumn flexColumn;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        List list;
        BrowseEndpoint browseEndpoint;
        String str;
        Menu.MenuRenderer menuRenderer;
        List list2;
        Object next;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        String str2;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
        Runs runs2;
        List list3;
        Run run;
        String str3;
        String thumbnailUrl;
        Icon icon;
        Run run2;
        String str4;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
        Icon icon2;
        BrowseEndpoint browseEndpoint2;
        String str5;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn3;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
        Runs runs3;
        List list4;
        Run run3;
        String str6;
        String thumbnailUrl2;
        WatchEndpoint watchEndpoint2;
        Menu.MenuRenderer menuRenderer2;
        List list5;
        Object next2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
        NavigationEndpoint navigationEndpoint2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
        Icon icon3;
        Menu.MenuRenderer menuRenderer3;
        List list6;
        Object next3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
        NavigationEndpoint navigationEndpoint3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
        Icon icon4;
        BrowseEndpoint browseEndpoint3;
        String str7;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn4;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
        Runs runs4;
        List list7;
        Run run4;
        String str8;
        String thumbnailUrl3;
        WatchEndpoint watchEndpoint3;
        Menu.MenuRenderer menuRenderer4;
        List list8;
        Object next4;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
        NavigationEndpoint navigationEndpoint4;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
        Icon icon5;
        Menu.MenuRenderer menuRenderer5;
        List list9;
        Object next5;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
        NavigationEndpoint navigationEndpoint5;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
        Icon icon6;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn5;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer5;
        Runs runs5;
        List list10;
        Run run5;
        String str9;
        Album album;
        String thumbnailUrl4;
        Icon icon7;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer6;
        Runs runs6;
        List list11;
        Run run6;
        BrowseEndpoint browseEndpoint4;
        String str10;
        BrowseEndpoint browseEndpoint5;
        String str11;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer7;
        Runs runs7;
        List list12;
        Run run7;
        String str12;
        Artist artist;
        String thumbnailUrl5;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint6;
        WatchEndpoint watchEndpoint4;
        Menu.MenuRenderer menuRenderer6;
        List list13;
        Object next6;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer11;
        NavigationEndpoint navigationEndpoint7;
        WatchEndpoint watchEndpoint5;
        Object next7;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer12;
        NavigationEndpoint navigationEndpoint8;
        WatchEndpoint watchEndpoint6;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer13;
        Icon icon8;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer14;
        Icon icon9;
        List list14;
        Run run8;
        List list15;
        Run run9;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer8;
        Runs runs8;
        List list16;
        BrowseEndpoint browseEndpoint6;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn6;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer9;
        Runs runs9;
        List list17;
        Run run10;
        String str13;
        Album album2;
        String thumbnailUrl6;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
        NavigationEndpoint navigationEndpoint9;
        List list18;
        Run run11;
        List list19;
        Run run12;
        String str14;
        List list20;
        Run run13;
        BrowseEndpoint browseEndpoint7;
        List list21;
        Run run14;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer10;
        Runs runs10;
        List list22;
        BrowseEndpoint browseEndpoint8;
        String str15;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn7;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer11;
        Runs runs11;
        List list23;
        Run run15;
        String str16;
        String thumbnailUrl7;
        Menu.MenuRenderer menuRenderer7;
        List list24;
        Object next8;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer15;
        NavigationEndpoint navigationEndpoint10;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer16;
        Icon icon10;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
        NavigationEndpoint navigationEndpoint11;
        List list25;
        Run run16;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer12;
        Runs runs12;
        List list26;
        musicResponsiveListItemRenderer.getClass();
        List list27 = musicResponsiveListItemRenderer.badges;
        MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
        NavigationEndpoint navigationEndpoint12 = musicResponsiveListItemRenderer.navigationEndpoint;
        ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
        Menu menu = musicResponsiveListItemRenderer.menu;
        List list28 = musicResponsiveListItemRenderer.flexColumns;
        Object obj = null;
        if (musicResponsiveListItemRenderer.isPodcast()) {
            MusicResponsiveListItemRenderer.FlexColumn flexColumn8 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list28);
            ArrayList arrayListSplitBySeparator = (flexColumn8 == null || (musicResponsiveListItemFlexColumnRenderer12 = flexColumn8.musicResponsiveListItemFlexColumnRenderer) == null || (runs12 = musicResponsiveListItemFlexColumnRenderer12.text) == null || (list26 = runs12.runs) == null) ? null : CharsKt.splitBySeparator(list26);
            if (navigationEndpoint12 != null && (browseEndpoint8 = navigationEndpoint12.browseEndpoint) != null && (str15 = browseEndpoint8.browseId) != null && (flexColumn7 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer11 = flexColumn7.musicResponsiveListItemFlexColumnRenderer) != null && (runs11 = musicResponsiveListItemFlexColumnRenderer11.text) != null && (list23 = runs11.runs) != null && (run15 = (Run) CollectionsKt.firstOrNull(list23)) != null && (str16 = run15.text) != null) {
                Artist artist2 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(arrayListSplitBySeparator != null ? (List) CollectionsKt.getOrNull(0, arrayListSplitBySeparator) : null));
                String str17 = (arrayListSplitBySeparator == null || (list25 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator)) == null || (run16 = (Run) CollectionsKt.firstOrNull(list25)) == null) ? null : run16.text;
                if (thumbnailRenderer != null && (thumbnailUrl7 = thumbnailRenderer.getThumbnailUrl()) != null) {
                    WatchEndpoint watchEndpoint7 = (overlay == null || (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) == null || (content3 = musicItemThumbnailOverlayRenderer3.content) == null || (musicPlayButtonRenderer3 = content3.musicPlayButtonRenderer) == null || (navigationEndpoint11 = musicPlayButtonRenderer3.playNavigationEndpoint) == null) ? null : navigationEndpoint11.watchPlaylistEndpoint;
                    if (menu != null && (menuRenderer7 = menu.menuRenderer) != null && (list24 = menuRenderer7.items) != null) {
                        Iterator it = list24.iterator();
                        do {
                            if (!it.hasNext()) {
                                next8 = null;
                                break;
                            }
                            next8 = it.next();
                            menuNavigationItemRenderer16 = ((Menu.MenuRenderer.Item) next8).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer16 == null || (icon10 = menuNavigationItemRenderer16.icon) == null) ? null : icon10.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next8;
                        if (item != null && (menuNavigationItemRenderer15 = item.menuNavigationItemRenderer) != null && (navigationEndpoint10 = menuNavigationItemRenderer15.navigationEndpoint) != null) {
                            obj = navigationEndpoint10.watchPlaylistEndpoint;
                        }
                    }
                    return new PodcastItem(str15, str16, artist2, str17, thumbnailUrl7, watchEndpoint7, obj, null, null, null, 896);
                }
            }
        } else if (musicResponsiveListItemRenderer.isEpisode()) {
            MusicResponsiveListItemRenderer.FlexColumn flexColumn9 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list28);
            ArrayList arrayListSplitBySeparator2 = (flexColumn9 == null || (musicResponsiveListItemFlexColumnRenderer10 = flexColumn9.musicResponsiveListItemFlexColumnRenderer) == null || (runs10 = musicResponsiveListItemFlexColumnRenderer10.text) == null || (list22 = runs10.runs) == null) ? null : CharsKt.splitBySeparator(list22);
            boolean zAreEqual = Intrinsics.areEqual((arrayListSplitBySeparator2 == null || (list21 = (List) CollectionsKt.getOrNull(0, arrayListSplitBySeparator2)) == null || (run14 = (Run) CollectionsKt.firstOrNull(list21)) == null) ? null : run14.text, "Episode");
            int i = zAreEqual ? 2 : 1;
            String videoId = musicResponsiveListItemRenderer.getVideoId();
            if (videoId != null && (flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer9 = flexColumn6.musicResponsiveListItemFlexColumnRenderer) != null && (runs9 = musicResponsiveListItemFlexColumnRenderer9.text) != null && (list17 = runs9.runs) != null && (run10 = (Run) CollectionsKt.firstOrNull(list17)) != null && (str13 = run10.text) != null) {
                if (arrayListSplitBySeparator2 == null || (list20 = (List) CollectionsKt.getOrNull(i, arrayListSplitBySeparator2)) == null || (run13 = (Run) CollectionsKt.firstOrNull(list20)) == null) {
                    album2 = null;
                } else {
                    NavigationEndpoint navigationEndpoint13 = run13.navigationEndpoint;
                    if ((navigationEndpoint13 != null ? navigationEndpoint13.browseEndpoint : null) == null) {
                        run13 = null;
                    }
                    if (run13 != null) {
                        String str18 = run13.text;
                        NavigationEndpoint navigationEndpoint14 = run13.navigationEndpoint;
                        String str19 = (navigationEndpoint14 == null || (browseEndpoint7 = navigationEndpoint14.browseEndpoint) == null) ? null : browseEndpoint7.browseId;
                        str19.getClass();
                        album2 = new Album(str18, str19);
                    } else {
                        album2 = null;
                    }
                }
                Integer numM1883parseTime = (arrayListSplitBySeparator2 == null || (list19 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator2)) == null || (run12 = (Run) CollectionsKt.firstOrNull(list19)) == null || (str14 = run12.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str14);
                String str20 = (arrayListSplitBySeparator2 == null || (list18 = (List) CollectionsKt.getOrNull(zAreEqual ? 1 : 0, arrayListSplitBySeparator2)) == null || (run11 = (Run) CollectionsKt.firstOrNull(list18)) == null) ? null : run11.text;
                if (thumbnailRenderer != null && (thumbnailUrl6 = thumbnailRenderer.getThumbnailUrl()) != null) {
                    if (overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint9 = musicPlayButtonRenderer2.playNavigationEndpoint) != null) {
                        obj = navigationEndpoint9.watchEndpoint;
                    }
                    return new EpisodeItem(videoId, str13, null, album2, numM1883parseTime, str20, thumbnailUrl6, false, obj, null, null, 6272);
                }
            }
        } else if (Intrinsics.areEqual((navigationEndpoint12 == null || (browseEndpoint6 = navigationEndpoint12.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint6.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PLAYLIST")) {
            MusicResponsiveListItemRenderer.FlexColumn flexColumn10 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list28);
            ArrayList arrayListSplitBySeparator3 = (flexColumn10 == null || (musicResponsiveListItemFlexColumnRenderer8 = flexColumn10.musicResponsiveListItemFlexColumnRenderer) == null || (runs8 = musicResponsiveListItemFlexColumnRenderer8.text) == null || (list16 = runs8.runs) == null) ? null : CharsKt.splitBySeparator(list16);
            if (navigationEndpoint12 != null && (browseEndpoint5 = navigationEndpoint12.browseEndpoint) != null && (str11 = browseEndpoint5.browseId) != null) {
                String strRemovePrefix = StringsKt.removePrefix(str11, "VL");
                MusicResponsiveListItemRenderer.FlexColumn flexColumn11 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28);
                if (flexColumn11 != null && (musicResponsiveListItemFlexColumnRenderer7 = flexColumn11.musicResponsiveListItemFlexColumnRenderer) != null && (runs7 = musicResponsiveListItemFlexColumnRenderer7.text) != null && (list12 = runs7.runs) != null && (run7 = (Run) CollectionsKt.firstOrNull(list12)) != null && (str12 = run7.text) != null) {
                    List list29 = arrayListSplitBySeparator3 != null ? (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator3) : null;
                    Artist artist3 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list29));
                    if (artist3 != null) {
                        artist = artist3;
                    } else {
                        if (list29 != null && (list15 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list29))) != null && (run9 = (Run) CollectionsKt.firstOrNull(list15)) != null) {
                            if (run9.navigationEndpoint != null || StringsKt.isBlank(run9.text)) {
                                run9 = null;
                            }
                            if (run9 != null) {
                                artist3 = new Artist(StringsKt.trim(run9.text).toString(), null);
                                artist = artist3;
                            }
                        }
                        artist = null;
                    }
                    String str21 = (arrayListSplitBySeparator3 == null || (list14 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator3)) == null || (run8 = (Run) CollectionsKt.firstOrNull(list14)) == null) ? null : run8.text;
                    if (thumbnailRenderer != null && (thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl()) != null && overlay != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint6 = musicPlayButtonRenderer.playNavigationEndpoint) != null && (watchEndpoint4 = navigationEndpoint6.watchPlaylistEndpoint) != null && menu != null && (menuRenderer6 = menu.menuRenderer) != null && (list13 = menuRenderer6.items) != null) {
                        Iterator it2 = list13.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next6 = null;
                                break;
                            }
                            next6 = it2.next();
                            menuNavigationItemRenderer14 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer14 == null || (icon9 = menuNavigationItemRenderer14.icon) == null) ? null : icon9.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next6;
                        if (item2 != null && (menuNavigationItemRenderer11 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint7 = menuNavigationItemRenderer11.navigationEndpoint) != null && (watchEndpoint5 = navigationEndpoint7.watchPlaylistEndpoint) != null) {
                            Iterator it3 = menuRenderer6.items.iterator();
                            do {
                                if (!it3.hasNext()) {
                                    next7 = null;
                                    break;
                                }
                                next7 = it3.next();
                                menuNavigationItemRenderer13 = ((Menu.MenuRenderer.Item) next7).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer13 == null || (icon8 = menuNavigationItemRenderer13.icon) == null) ? null : icon8.iconType, "MIX"));
                            Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next7;
                            if (item3 != null && (menuNavigationItemRenderer12 = item3.menuNavigationItemRenderer) != null && (navigationEndpoint8 = menuNavigationItemRenderer12.navigationEndpoint) != null && (watchEndpoint6 = navigationEndpoint8.watchPlaylistEndpoint) != null) {
                                return new PlaylistItem(strRemovePrefix, str12, artist, str21, thumbnailUrl5, watchEndpoint4, watchEndpoint5, watchEndpoint6, false, (String) null, (String) null, 3840);
                            }
                        }
                    }
                }
            }
        } else if (musicResponsiveListItemRenderer.isSong()) {
            List listDrop = CollectionsKt.drop(list28, 1);
            ArrayList arrayList = new ArrayList();
            Iterator it4 = listDrop.iterator();
            while (it4.hasNext()) {
                Runs runs13 = ((MusicResponsiveListItemRenderer.FlexColumn) it4.next()).musicResponsiveListItemFlexColumnRenderer.text;
                List list30 = runs13 != null ? runs13.runs : null;
                if (list30 == null) {
                    list30 = EmptyList.INSTANCE;
                }
                CollectionsKt__MutableCollectionsKt.addAll(list30, arrayList);
            }
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(arrayList);
            String videoId2 = musicResponsiveListItemRenderer.getVideoId();
            if (videoId2 != null && (flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer5 = flexColumn5.musicResponsiveListItemFlexColumnRenderer) != null && (runs5 = musicResponsiveListItemFlexColumnRenderer5.text) != null && (list10 = runs5.runs) != null && (run5 = (Run) CollectionsKt.firstOrNull(list10)) != null && (str9 = run5.text) != null) {
                MusicResponsiveListItemRenderer.FlexColumn flexColumn12 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list28);
                if (flexColumn12 == null || (musicResponsiveListItemFlexColumnRenderer6 = flexColumn12.musicResponsiveListItemFlexColumnRenderer) == null || (runs6 = musicResponsiveListItemFlexColumnRenderer6.text) == null || (list11 = runs6.runs) == null || (run6 = (Run) CollectionsKt.firstOrNull(list11)) == null) {
                    album = null;
                } else {
                    String str22 = run6.text;
                    NavigationEndpoint navigationEndpoint15 = run6.navigationEndpoint;
                    album = (navigationEndpoint15 == null || (browseEndpoint4 = navigationEndpoint15.browseEndpoint) == null || (str10 = browseEndpoint4.browseId) == null) ? null : new Album(str22, str10);
                }
                Integer numExtractDuration = PageHelper.extractDuration(arrayList);
                String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                if (thumbnailRenderer != null && (thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl()) != null) {
                    if (list27 != null) {
                        for (Object obj2 : list27) {
                            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                            if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon7 = musicInlineBadgeRenderer.icon) == null) ? null : icon7.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                obj = obj2;
                                break;
                            }
                        }
                        obj = (Badges) obj;
                    }
                    return new SongItem(videoId2, str9, arrayListExtractArtists, album, numExtractDuration, musicVideoType, null, null, thumbnailUrl4, obj != null, null, null, null, null, null, false, null, 130240);
                }
            }
        } else if (musicResponsiveListItemRenderer.isArtist()) {
            if (navigationEndpoint12 != null && (browseEndpoint3 = navigationEndpoint12.browseEndpoint) != null && (str7 = browseEndpoint3.browseId) != null && (flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer4 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) != null && (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) != null && (list7 = runs4.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list7)) != null && (str8 = run4.text) != null && thumbnailRenderer != null && (thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl()) != null) {
                if (menu == null || (menuRenderer5 = menu.menuRenderer) == null || (list9 = menuRenderer5.items) == null) {
                    watchEndpoint3 = null;
                } else {
                    Iterator it5 = list9.iterator();
                    do {
                        if (!it5.hasNext()) {
                            next5 = null;
                            break;
                        }
                        next5 = it5.next();
                        menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon6 = menuNavigationItemRenderer10.icon) == null) ? null : icon6.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next5;
                    if (item4 == null || (menuNavigationItemRenderer9 = item4.menuNavigationItemRenderer) == null || (navigationEndpoint5 = menuNavigationItemRenderer9.navigationEndpoint) == null) {
                        watchEndpoint3 = null;
                    } else {
                        watchEndpoint3 = navigationEndpoint5.watchPlaylistEndpoint;
                    }
                }
                if (menu != null && (menuRenderer4 = menu.menuRenderer) != null && (list8 = menuRenderer4.items) != null) {
                    Iterator it6 = list8.iterator();
                    do {
                        if (!it6.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it6.next();
                        menuNavigationItemRenderer8 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer8 == null || (icon5 = menuNavigationItemRenderer8.icon) == null) ? null : icon5.iconType, "MIX"));
                    Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next4;
                    if (item5 != null && (menuNavigationItemRenderer7 = item5.menuNavigationItemRenderer) != null && (navigationEndpoint4 = menuNavigationItemRenderer7.navigationEndpoint) != null) {
                        obj = navigationEndpoint4.watchPlaylistEndpoint;
                    }
                }
                return new ArtistItem(str7, str8, thumbnailUrl3, (String) null, (WatchEndpoint) null, watchEndpoint3, (WatchEndpoint) obj, 152);
            }
        } else if (musicResponsiveListItemRenderer.isUserChannel()) {
            if (navigationEndpoint12 != null && (browseEndpoint2 = navigationEndpoint12.browseEndpoint) != null && (str5 = browseEndpoint2.browseId) != null && (flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer3 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) != null && (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) != null && (list4 = runs3.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str6 = run3.text) != null && thumbnailRenderer != null && (thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl()) != null) {
                if (menu == null || (menuRenderer3 = menu.menuRenderer) == null || (list6 = menuRenderer3.items) == null) {
                    watchEndpoint2 = null;
                } else {
                    Iterator it7 = list6.iterator();
                    do {
                        if (!it7.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it7.next();
                        menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon4 = menuNavigationItemRenderer6.icon) == null) ? null : icon4.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item6 = (Menu.MenuRenderer.Item) next3;
                    if (item6 == null || (menuNavigationItemRenderer5 = item6.menuNavigationItemRenderer) == null || (navigationEndpoint3 = menuNavigationItemRenderer5.navigationEndpoint) == null) {
                        watchEndpoint2 = null;
                    } else {
                        watchEndpoint2 = navigationEndpoint3.watchPlaylistEndpoint;
                    }
                }
                if (menu != null && (menuRenderer2 = menu.menuRenderer) != null && (list5 = menuRenderer2.items) != null) {
                    Iterator it8 = list5.iterator();
                    do {
                        if (!it8.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it8.next();
                        menuNavigationItemRenderer4 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer4 == null || (icon3 = menuNavigationItemRenderer4.icon) == null) ? null : icon3.iconType, "MIX"));
                    Menu.MenuRenderer.Item item7 = (Menu.MenuRenderer.Item) next2;
                    if (item7 != null && (menuNavigationItemRenderer3 = item7.menuNavigationItemRenderer) != null && (navigationEndpoint2 = menuNavigationItemRenderer3.navigationEndpoint) != null) {
                        obj = navigationEndpoint2.watchPlaylistEndpoint;
                    }
                }
                return new ArtistItem(str5, str6, thumbnailUrl2, (String) null, (WatchEndpoint) null, watchEndpoint2, (WatchEndpoint) obj, 152);
            }
        } else if (musicResponsiveListItemRenderer.isAlbum() && (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list28)) != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list = runs.runs) != null) {
            ArrayList arrayListSplitBySeparator4 = CharsKt.splitBySeparator(list);
            if (navigationEndpoint12 != null && (browseEndpoint = navigationEndpoint12.browseEndpoint) != null && (str = browseEndpoint.browseId) != null && menu != null && (menuRenderer = menu.menuRenderer) != null && (list2 = menuRenderer.items) != null) {
                Iterator it9 = list2.iterator();
                do {
                    if (!it9.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it9.next();
                    menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon2 = menuNavigationItemRenderer2.icon) == null) ? null : icon2.iconType, "MUSIC_SHUFFLE"));
                Menu.MenuRenderer.Item item8 = (Menu.MenuRenderer.Item) next;
                if (item8 != null && (menuNavigationItemRenderer = item8.menuNavigationItemRenderer) != null && (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) != null && (watchEndpoint = navigationEndpoint.watchPlaylistEndpoint) != null && (str2 = watchEndpoint.playlistId) != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list28)) != null && (musicResponsiveListItemFlexColumnRenderer2 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) != null && (list3 = runs2.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list3)) != null && (str3 = run.text) != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists2 = PageHelper.extractArtists((List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator4));
                    List list31 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator4);
                    Integer intOrNull = (list31 == null || (run2 = (Run) CollectionsKt.firstOrNull(list31)) == null || (str4 = run2.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str4);
                    if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                        if (list27 != null) {
                            for (Object obj3 : list27) {
                                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2 = ((Badges) obj3).musicInlineBadgeRenderer;
                                if (Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon = musicInlineBadgeRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj3;
                                    break;
                                }
                            }
                            obj = (Badges) obj;
                        }
                        return new AlbumItem(str, str2, str3, arrayListExtractArtists2, intOrNull, thumbnailUrl, obj != null, 4);
                    }
                }
            }
        }
        return null;
    }
}
