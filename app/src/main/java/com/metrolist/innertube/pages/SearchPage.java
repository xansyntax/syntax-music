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
public final class SearchPage {
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:125:0x0161  */
    /* JADX WARN: Code duplicated, block: B:130:0x0174  */
    /* JADX WARN: Code duplicated, block: B:132:0x0178  */
    /* JADX WARN: Code duplicated, block: B:136:0x0182  */
    /* JADX WARN: Code duplicated, block: B:139:0x018c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0197  */
    /* JADX WARN: Code duplicated, block: B:144:0x019e  */
    /* JADX WARN: Code duplicated, block: B:150:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:153:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:155:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:166:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:167:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:198:0x0247 A[PHI: r1
      0x0247: PHI (r1v95 java.lang.String) = (r1v72 java.lang.String), (r1v74 java.lang.String), (r1v78 java.lang.String), (r1v104 java.lang.String) binds: [B:204:0x0254, B:218:0x0270, B:235:0x029a, B:196:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:239:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:250:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:252:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:258:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:260:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:263:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:267:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:270:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:272:0x0304  */
    /* JADX WARN: Code duplicated, block: B:275:0x030b  */
    /* JADX WARN: Code duplicated, block: B:281:0x0317  */
    /* JADX WARN: Code duplicated, block: B:282:0x031a  */
    /* JADX WARN: Code duplicated, block: B:407:0x0485  */
    /* JADX WARN: Code duplicated, block: B:724:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:729:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00e2 A[PHI: r1
      0x00e2: PHI (r1v129 java.lang.String) = (r1v106 java.lang.String), (r1v108 java.lang.String), (r1v112 java.lang.String), (r1v138 java.lang.String) binds: [B:78:0x00ef, B:92:0x010b, B:109:0x0135, B:70:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:731:? A[LOOP:4: B:268:0x02f3->B:731:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static YTItem toYTItem(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, List list) {
        BrowseEndpoint browseEndpoint;
        String str;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        List list2;
        Run run;
        String str2;
        String thumbnailUrl;
        Menu.MenuRenderer menuRenderer;
        List list3;
        Object next;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
        NavigationEndpoint navigationEndpoint;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
        Icon icon;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint2;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
        Runs runs2;
        List list4;
        Run run2;
        BrowseEndpoint browseEndpoint2;
        String str3;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
        Runs runs3;
        List list5;
        Run run3;
        String str4;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
        Runs runs4;
        List list6;
        Run run4;
        String str5;
        String thumbnailUrl2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
        NavigationEndpoint navigationEndpoint3;
        WatchEndpoint watchEndpoint;
        Menu.MenuRenderer menuRenderer2;
        List list7;
        Object next2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
        NavigationEndpoint navigationEndpoint4;
        WatchEndpoint watchEndpoint2;
        Object next3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
        NavigationEndpoint navigationEndpoint5;
        WatchEndpoint watchEndpoint3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
        Icon icon2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
        Icon icon3;
        List list8;
        Run run5;
        BrowseEndpoint browseEndpoint3;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint4;
        String str6;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
        NavigationEndpoint navigationEndpoint6;
        String str7;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer5;
        Runs runs5;
        List list9;
        Run run6;
        String str8;
        String thumbnailUrl3;
        Icon icon4;
        Run run7;
        String str9;
        BrowseEndpoint browseEndpoint5;
        String str10;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn3;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer6;
        Runs runs6;
        List list10;
        Run run8;
        String str11;
        String thumbnailUrl4;
        WatchEndpoint watchEndpoint4;
        Menu.MenuRenderer menuRenderer3;
        List list11;
        Object next4;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
        NavigationEndpoint navigationEndpoint7;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
        Icon icon5;
        Menu.MenuRenderer menuRenderer4;
        List list12;
        Object next5;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
        NavigationEndpoint navigationEndpoint8;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
        Icon icon6;
        BrowseEndpoint browseEndpoint6;
        String str12;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn4;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer7;
        Runs runs7;
        List list13;
        Run run9;
        String str13;
        String thumbnailUrl5;
        Menu.MenuRenderer menuRenderer5;
        List list14;
        Object next6;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer11;
        NavigationEndpoint navigationEndpoint9;
        WatchEndpoint watchEndpoint5;
        Object next7;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer12;
        NavigationEndpoint navigationEndpoint10;
        WatchEndpoint watchEndpoint6;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer13;
        Icon icon7;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer14;
        Icon icon8;
        String str14;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer8;
        Runs runs8;
        List list15;
        Run run10;
        NavigationEndpoint navigationEndpoint11;
        WatchEndpoint watchEndpoint7;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer4;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content4;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer4;
        NavigationEndpoint navigationEndpoint12;
        WatchEndpoint watchEndpoint8;
        WatchEndpoint watchEndpoint9;
        String str15;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn5;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer9;
        Runs runs9;
        List list16;
        Run run11;
        String str16;
        Album album;
        Integer numExtractDuration;
        String musicVideoType;
        String thumbnailUrl6;
        boolean z;
        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
        String str17;
        Icon icon9;
        NavigationEndpoint navigationEndpoint13;
        Album album2;
        BrowseEndpoint browseEndpoint7;
        String str18;
        Menu.MenuRenderer menuRenderer6;
        Album album3;
        String str19;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer10;
        Runs runs10;
        List list17;
        Run run12;
        NavigationEndpoint navigationEndpoint14;
        WatchEndpoint watchEndpoint10;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer5;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content5;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer5;
        NavigationEndpoint navigationEndpoint15;
        WatchEndpoint watchEndpoint11;
        WatchEndpoint watchEndpoint12;
        String str20;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn6;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer11;
        Runs runs11;
        List list18;
        Run run13;
        String str21;
        List list19;
        Integer numM1883parseTime;
        String thumbnailUrl7;
        Badges badges;
        boolean z2;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer6;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content6;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer6;
        NavigationEndpoint navigationEndpoint16;
        WatchEndpoint watchEndpoint13;
        Iterator it;
        Object next8;
        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2;
        String str22;
        Icon icon10;
        Run run14;
        String str23;
        List list20;
        Run run15;
        Run run16;
        BrowseEndpoint browseEndpoint8;
        String str24;
        BrowseEndpoint browseEndpoint9;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
        Menu.MenuRenderer menuRenderer7;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer12;
        Runs runs12;
        List list21;
        musicResponsiveListItemRenderer.getClass();
        MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData = musicResponsiveListItemRenderer.playlistItemData;
        List list22 = musicResponsiveListItemRenderer.badges;
        MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
        ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
        NavigationEndpoint navigationEndpoint17 = musicResponsiveListItemRenderer.navigationEndpoint;
        Menu menu = musicResponsiveListItemRenderer.menu;
        List list23 = musicResponsiveListItemRenderer.flexColumns;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn7 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list23);
        Object obj = null;
        List listSplitBySeparator = (flexColumn7 == null || (musicResponsiveListItemFlexColumnRenderer12 = flexColumn7.musicResponsiveListItemFlexColumnRenderer) == null || (runs12 = musicResponsiveListItemFlexColumnRenderer12.text) == null || (list21 = runs12.runs) == null) ? null : CharsKt.splitBySeparator(list21);
        EmptyList emptyList = EmptyList.INSTANCE;
        if (listSplitBySeparator == null) {
            listSplitBySeparator = emptyList;
        }
        if (musicResponsiveListItemRenderer.isEpisode()) {
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer7 = menu.menuRenderer) == null) ? null : menuRenderer7.items);
            Iterator it2 = listSplitBySeparator.iterator();
            int i = 0;
            loop0: while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                List list24 = (List) it2.next();
                if (list24 == null || !list24.isEmpty()) {
                    Iterator it3 = list24.iterator();
                    while (it3.hasNext()) {
                        NavigationEndpoint navigationEndpoint18 = ((Run) it3.next()).navigationEndpoint;
                        if (Intrinsics.areEqual((navigationEndpoint18 == null || (browseEndpoint9 = navigationEndpoint18.browseEndpoint) == null || (browseEndpointContextSupportedConfigs2 = browseEndpoint9.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE")) {
                            break loop0;
                        }
                    }
                }
                i++;
            }
            if (i >= 0 && (run16 = (Run) CollectionsKt.firstOrNull((List) listSplitBySeparator.get(i))) != null) {
                String str25 = run16.text;
                NavigationEndpoint navigationEndpoint19 = run16.navigationEndpoint;
                album3 = (navigationEndpoint19 == null || (browseEndpoint8 = navigationEndpoint19.browseEndpoint) == null || (str24 = browseEndpoint8.browseId) == null) ? null : new Album(str25, str24);
            }
            String str26 = (i <= 0 || (list20 = (List) CollectionsKt.getOrNull(i - 1, listSplitBySeparator)) == null || (run15 = (Run) CollectionsKt.firstOrNull(list20)) == null) ? null : run15.text;
            if (playlistItemData == null || (str19 = playlistItemData.videoId) == null) {
                str19 = (navigationEndpoint17 == null || (watchEndpoint12 = navigationEndpoint17.watchEndpoint) == null) ? null : watchEndpoint12.videoId;
                if (str19 != null) {
                    str20 = str19;
                    flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                    if (flexColumn6 != null && (musicResponsiveListItemFlexColumnRenderer11 = flexColumn6.musicResponsiveListItemFlexColumnRenderer) != null && (runs11 = musicResponsiveListItemFlexColumnRenderer11.text) != null && (list18 = runs11.runs) != null && (run13 = (Run) CollectionsKt.firstOrNull(list18)) != null && (str21 = run13.text) != null) {
                        list19 = (List) CollectionsKt.lastOrNull(listSplitBySeparator);
                        if (list19 != null || (run14 = (Run) CollectionsKt.firstOrNull(list19)) == null || (str23 = run14.text) == null) {
                            numM1883parseTime = null;
                        } else {
                            numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str23);
                        }
                        if (thumbnailRenderer != null && (thumbnailUrl7 = thumbnailRenderer.getThumbnailUrl()) != null) {
                            if (list22 != null) {
                                it = list22.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next8 = null;
                                        break;
                                    }
                                    next8 = it.next();
                                    musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                    if (musicInlineBadgeRenderer2 != null || (icon10 = musicInlineBadgeRenderer2.icon) == null) {
                                        str22 = null;
                                    } else {
                                        str22 = icon10.iconType;
                                    }
                                } while (!Intrinsics.areEqual(str22, "MUSIC_EXPLICIT_BADGE"));
                                badges = (Badges) next8;
                            } else {
                                badges = null;
                            }
                            if (badges != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            return new EpisodeItem(str20, str21, null, album3, numM1883parseTime, str26, thumbnailUrl7, z2, (overlay != null || (musicItemThumbnailOverlayRenderer6 = overlay.musicItemThumbnailOverlayRenderer) == null || (content6 = musicItemThumbnailOverlayRenderer6.content) == null || (musicPlayButtonRenderer6 = content6.musicPlayButtonRenderer) == null || (navigationEndpoint16 = musicPlayButtonRenderer6.playNavigationEndpoint) == null || (watchEndpoint13 = navigationEndpoint16.watchEndpoint) == null) ? navigationEndpoint17 != null ? navigationEndpoint17.watchEndpoint : null : watchEndpoint13, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                        }
                    }
                } else {
                    str19 = (overlay == null || (musicItemThumbnailOverlayRenderer5 = overlay.musicItemThumbnailOverlayRenderer) == null || (content5 = musicItemThumbnailOverlayRenderer5.content) == null || (musicPlayButtonRenderer5 = content5.musicPlayButtonRenderer) == null || (navigationEndpoint15 = musicPlayButtonRenderer5.playNavigationEndpoint) == null || (watchEndpoint11 = navigationEndpoint15.watchEndpoint) == null) ? null : watchEndpoint11.videoId;
                    if (str19 != null) {
                        str20 = str19;
                        flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                        if (flexColumn6 != null) {
                            list19 = (List) CollectionsKt.lastOrNull(listSplitBySeparator);
                            if (list19 != null) {
                                numM1883parseTime = null;
                            } else {
                                numM1883parseTime = null;
                            }
                            if (thumbnailRenderer != null) {
                                if (list22 != null) {
                                    it = list22.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next8 = null;
                                            break;
                                        }
                                        next8 = it.next();
                                        musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                        if (musicInlineBadgeRenderer2 != null) {
                                            str22 = null;
                                        } else {
                                            str22 = null;
                                        }
                                    } while (!Intrinsics.areEqual(str22, "MUSIC_EXPLICIT_BADGE"));
                                    badges = (Badges) next8;
                                } else {
                                    badges = null;
                                }
                                if (badges != null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (overlay != null) {
                                }
                                return new EpisodeItem(str20, str21, null, album3, numM1883parseTime, str26, thumbnailUrl7, z2, (overlay != null || (musicItemThumbnailOverlayRenderer6 = overlay.musicItemThumbnailOverlayRenderer) == null || (content6 = musicItemThumbnailOverlayRenderer6.content) == null || (musicPlayButtonRenderer6 = content6.musicPlayButtonRenderer) == null || (navigationEndpoint16 = musicPlayButtonRenderer6.playNavigationEndpoint) == null || (watchEndpoint13 = navigationEndpoint16.watchEndpoint) == null) ? navigationEndpoint17 != null ? navigationEndpoint17.watchEndpoint : null : watchEndpoint13, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                            }
                        }
                    } else {
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn8 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                        str19 = (flexColumn8 == null || (musicResponsiveListItemFlexColumnRenderer10 = flexColumn8.musicResponsiveListItemFlexColumnRenderer) == null || (runs10 = musicResponsiveListItemFlexColumnRenderer10.text) == null || (list17 = runs10.runs) == null || (run12 = (Run) CollectionsKt.firstOrNull(list17)) == null || (navigationEndpoint14 = run12.navigationEndpoint) == null || (watchEndpoint10 = navigationEndpoint14.watchEndpoint) == null) ? null : watchEndpoint10.videoId;
                        if (str19 != null) {
                            str20 = str19;
                            flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                            if (flexColumn6 != null) {
                                list19 = (List) CollectionsKt.lastOrNull(listSplitBySeparator);
                                if (list19 != null) {
                                    numM1883parseTime = null;
                                } else {
                                    numM1883parseTime = null;
                                }
                                if (thumbnailRenderer != null) {
                                    if (list22 != null) {
                                        it = list22.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next8 = null;
                                                break;
                                            }
                                            next8 = it.next();
                                            musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                            if (musicInlineBadgeRenderer2 != null) {
                                                str22 = null;
                                            } else {
                                                str22 = null;
                                            }
                                        } while (!Intrinsics.areEqual(str22, "MUSIC_EXPLICIT_BADGE"));
                                        badges = (Badges) next8;
                                    } else {
                                        badges = null;
                                    }
                                    if (badges != null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (overlay != null) {
                                    }
                                    return new EpisodeItem(str20, str21, null, album3, numM1883parseTime, str26, thumbnailUrl7, z2, (overlay != null || (musicItemThumbnailOverlayRenderer6 = overlay.musicItemThumbnailOverlayRenderer) == null || (content6 = musicItemThumbnailOverlayRenderer6.content) == null || (musicPlayButtonRenderer6 = content6.musicPlayButtonRenderer) == null || (navigationEndpoint16 = musicPlayButtonRenderer6.playNavigationEndpoint) == null || (watchEndpoint13 = navigationEndpoint16.watchEndpoint) == null) ? navigationEndpoint17 != null ? navigationEndpoint17.watchEndpoint : null : watchEndpoint13, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                                }
                            }
                        }
                    }
                }
            } else {
                str20 = str19;
                flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                if (flexColumn6 != null) {
                    list19 = (List) CollectionsKt.lastOrNull(listSplitBySeparator);
                    if (list19 != null) {
                        numM1883parseTime = null;
                    } else {
                        numM1883parseTime = null;
                    }
                    if (thumbnailRenderer != null) {
                        if (list22 != null) {
                            it = list22.iterator();
                            do {
                                if (it.hasNext()) {
                                    next8 = null;
                                    break;
                                }
                                next8 = it.next();
                                musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                if (musicInlineBadgeRenderer2 != null) {
                                    str22 = null;
                                } else {
                                    str22 = null;
                                }
                            } while (!Intrinsics.areEqual(str22, "MUSIC_EXPLICIT_BADGE"));
                            badges = (Badges) next8;
                        } else {
                            badges = null;
                        }
                        if (badges != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (overlay != null) {
                        }
                        return new EpisodeItem(str20, str21, null, album3, numM1883parseTime, str26, thumbnailUrl7, z2, (overlay != null || (musicItemThumbnailOverlayRenderer6 = overlay.musicItemThumbnailOverlayRenderer) == null || (content6 = musicItemThumbnailOverlayRenderer6.content) == null || (musicPlayButtonRenderer6 = content6.musicPlayButtonRenderer) == null || (navigationEndpoint16 = musicPlayButtonRenderer6.playNavigationEndpoint) == null || (watchEndpoint13 = navigationEndpoint16.watchEndpoint) == null) ? navigationEndpoint17 != null ? navigationEndpoint17.watchEndpoint : null : watchEndpoint13, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                    }
                }
            }
        } else if (musicResponsiveListItemRenderer.isSong()) {
            Set set2 = PageHelper.LIBRARY_ADD_ICONS;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems2 = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer6 = menu.menuRenderer) == null) ? null : menuRenderer6.items);
            List listDrop = CollectionsKt.drop(list23, 1);
            ArrayList arrayList = new ArrayList();
            Iterator it4 = listDrop.iterator();
            while (it4.hasNext()) {
                Runs runs13 = ((MusicResponsiveListItemRenderer.FlexColumn) it4.next()).musicResponsiveListItemFlexColumnRenderer.text;
                List list25 = runs13 != null ? runs13.runs : null;
                if (list25 == null) {
                    list25 = emptyList;
                }
                CollectionsKt__MutableCollectionsKt.addAll(list25, arrayList);
            }
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(arrayList);
            List list26 = arrayListExtractArtists.isEmpty() ? list : arrayListExtractArtists;
            Run run17 = (Run) CollectionsKt.firstOrNull((List) PageHelper.extractRuns("MUSIC_PAGE_TYPE_ALBUM", list23));
            if (playlistItemData == null || (str14 = playlistItemData.videoId) == null) {
                str14 = (navigationEndpoint17 == null || (watchEndpoint9 = navigationEndpoint17.watchEndpoint) == null) ? null : watchEndpoint9.videoId;
                if (str14 != null) {
                    str15 = str14;
                    flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                    if (flexColumn5 != null && (musicResponsiveListItemFlexColumnRenderer9 = flexColumn5.musicResponsiveListItemFlexColumnRenderer) != null && (runs9 = musicResponsiveListItemFlexColumnRenderer9.text) != null && (list16 = runs9.runs) != null && (run11 = (Run) CollectionsKt.firstOrNull(list16)) != null && (str16 = run11.text) != null) {
                        if (run17 != null) {
                            String str27 = run17.text;
                            navigationEndpoint13 = run17.navigationEndpoint;
                            if (navigationEndpoint13 != null || (browseEndpoint7 = navigationEndpoint13.browseEndpoint) == null || (str18 = browseEndpoint7.browseId) == null) {
                                album2 = null;
                            } else {
                                album2 = new Album(str27, str18);
                            }
                            album = album2;
                        } else {
                            album = null;
                        }
                        numExtractDuration = PageHelper.extractDuration(arrayList);
                        musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        if (thumbnailRenderer != null && (thumbnailUrl6 = thumbnailRenderer.getThumbnailUrl()) != null) {
                            if (list22 != null) {
                                for (Object obj2 : list22) {
                                    musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                    if (musicInlineBadgeRenderer != null || (icon9 = musicInlineBadgeRenderer.icon) == null) {
                                        str17 = null;
                                    } else {
                                        str17 = icon9.iconType;
                                    }
                                    if (Intrinsics.areEqual(str17, "MUSIC_EXPLICIT_BADGE")) {
                                        obj = obj2;
                                        break;
                                    }
                                }
                                obj = (Badges) obj;
                            }
                            if (obj != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            return new SongItem(str15, str16, list26, album, numExtractDuration, musicVideoType, null, null, thumbnailUrl6, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 85184);
                        }
                    }
                } else {
                    str14 = (overlay == null || (musicItemThumbnailOverlayRenderer4 = overlay.musicItemThumbnailOverlayRenderer) == null || (content4 = musicItemThumbnailOverlayRenderer4.content) == null || (musicPlayButtonRenderer4 = content4.musicPlayButtonRenderer) == null || (navigationEndpoint12 = musicPlayButtonRenderer4.playNavigationEndpoint) == null || (watchEndpoint8 = navigationEndpoint12.watchEndpoint) == null) ? null : watchEndpoint8.videoId;
                    if (str14 != null) {
                        str15 = str14;
                        flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                        if (flexColumn5 != null) {
                            if (run17 != null) {
                                String str28 = run17.text;
                                navigationEndpoint13 = run17.navigationEndpoint;
                                if (navigationEndpoint13 != null) {
                                    album2 = null;
                                } else {
                                    album2 = null;
                                }
                                album = album2;
                            } else {
                                album = null;
                            }
                            numExtractDuration = PageHelper.extractDuration(arrayList);
                            musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                            if (thumbnailRenderer != null) {
                                if (list22 != null) {
                                    while (r2.hasNext()) {
                                        musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                        if (musicInlineBadgeRenderer != null) {
                                            str17 = null;
                                        } else {
                                            str17 = null;
                                        }
                                        if (Intrinsics.areEqual(str17, "MUSIC_EXPLICIT_BADGE")) {
                                            obj = obj2;
                                            break;
                                        }
                                    }
                                    obj = (Badges) obj;
                                }
                                if (obj != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                return new SongItem(str15, str16, list26, album, numExtractDuration, musicVideoType, null, null, thumbnailUrl6, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 85184);
                            }
                        }
                    } else {
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn9 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                        str14 = (flexColumn9 == null || (musicResponsiveListItemFlexColumnRenderer8 = flexColumn9.musicResponsiveListItemFlexColumnRenderer) == null || (runs8 = musicResponsiveListItemFlexColumnRenderer8.text) == null || (list15 = runs8.runs) == null || (run10 = (Run) CollectionsKt.firstOrNull(list15)) == null || (navigationEndpoint11 = run10.navigationEndpoint) == null || (watchEndpoint7 = navigationEndpoint11.watchEndpoint) == null) ? null : watchEndpoint7.videoId;
                        if (str14 != null) {
                            str15 = str14;
                            flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                            if (flexColumn5 != null) {
                                if (run17 != null) {
                                    String str29 = run17.text;
                                    navigationEndpoint13 = run17.navigationEndpoint;
                                    if (navigationEndpoint13 != null) {
                                        album2 = null;
                                    } else {
                                        album2 = null;
                                    }
                                    album = album2;
                                } else {
                                    album = null;
                                }
                                numExtractDuration = PageHelper.extractDuration(arrayList);
                                musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                                if (thumbnailRenderer != null) {
                                    if (list22 != null) {
                                        while (r2.hasNext()) {
                                            musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                            if (musicInlineBadgeRenderer != null) {
                                                str17 = null;
                                            } else {
                                                str17 = null;
                                            }
                                            if (Intrinsics.areEqual(str17, "MUSIC_EXPLICIT_BADGE")) {
                                                obj = obj2;
                                                break;
                                            }
                                        }
                                        obj = (Badges) obj;
                                    }
                                    if (obj != null) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    return new SongItem(str15, str16, list26, album, numExtractDuration, musicVideoType, null, null, thumbnailUrl6, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 85184);
                                }
                            }
                        }
                    }
                }
            } else {
                str15 = str14;
                flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                if (flexColumn5 != null) {
                    if (run17 != null) {
                        String str210 = run17.text;
                        navigationEndpoint13 = run17.navigationEndpoint;
                        if (navigationEndpoint13 != null) {
                            album2 = null;
                        } else {
                            album2 = null;
                        }
                        album = album2;
                    } else {
                        album = null;
                    }
                    numExtractDuration = PageHelper.extractDuration(arrayList);
                    musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                    if (thumbnailRenderer != null) {
                        if (list22 != null) {
                            while (r2.hasNext()) {
                                musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                if (musicInlineBadgeRenderer != null) {
                                    str17 = null;
                                } else {
                                    str17 = null;
                                }
                                if (Intrinsics.areEqual(str17, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            obj = (Badges) obj;
                        }
                        if (obj != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return new SongItem(str15, str16, list26, album, numExtractDuration, musicVideoType, null, null, thumbnailUrl6, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 85184);
                    }
                }
            }
        } else if (musicResponsiveListItemRenderer.isArtist()) {
            if (navigationEndpoint17 != null && (browseEndpoint6 = navigationEndpoint17.browseEndpoint) != null && (str12 = browseEndpoint6.browseId) != null && (flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23)) != null && (musicResponsiveListItemFlexColumnRenderer7 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) != null && (runs7 = musicResponsiveListItemFlexColumnRenderer7.text) != null && (list13 = runs7.runs) != null && (run9 = (Run) CollectionsKt.firstOrNull(list13)) != null && (str13 = run9.text) != null && thumbnailRenderer != null && (thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl()) != null && menu != null && (menuRenderer5 = menu.menuRenderer) != null && (list14 = menuRenderer5.items) != null) {
                Iterator it5 = list14.iterator();
                do {
                    if (!it5.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it5.next();
                    menuNavigationItemRenderer14 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                } while (!Intrinsics.areEqual((menuNavigationItemRenderer14 == null || (icon8 = menuNavigationItemRenderer14.icon) == null) ? null : icon8.iconType, "MUSIC_SHUFFLE"));
                Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next6;
                if (item != null && (menuNavigationItemRenderer11 = item.menuNavigationItemRenderer) != null && (navigationEndpoint9 = menuNavigationItemRenderer11.navigationEndpoint) != null && (watchEndpoint5 = navigationEndpoint9.watchPlaylistEndpoint) != null) {
                    Iterator it6 = menuRenderer5.items.iterator();
                    do {
                        if (!it6.hasNext()) {
                            next7 = null;
                            break;
                        }
                        next7 = it6.next();
                        menuNavigationItemRenderer13 = ((Menu.MenuRenderer.Item) next7).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer13 == null || (icon7 = menuNavigationItemRenderer13.icon) == null) ? null : icon7.iconType, "MIX"));
                    Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next7;
                    if (item2 != null && (menuNavigationItemRenderer12 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint10 = menuNavigationItemRenderer12.navigationEndpoint) != null && (watchEndpoint6 = navigationEndpoint10.watchPlaylistEndpoint) != null) {
                        return new ArtistItem(str12, str13, thumbnailUrl5, (String) null, (WatchEndpoint) null, watchEndpoint5, watchEndpoint6, 152);
                    }
                }
            }
        } else if (musicResponsiveListItemRenderer.isUserChannel()) {
            if (navigationEndpoint17 != null && (browseEndpoint5 = navigationEndpoint17.browseEndpoint) != null && (str10 = browseEndpoint5.browseId) != null && (flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23)) != null && (musicResponsiveListItemFlexColumnRenderer6 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) != null && (runs6 = musicResponsiveListItemFlexColumnRenderer6.text) != null && (list10 = runs6.runs) != null && (run8 = (Run) CollectionsKt.firstOrNull(list10)) != null && (str11 = run8.text) != null && thumbnailRenderer != null && (thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl()) != null) {
                if (menu == null || (menuRenderer4 = menu.menuRenderer) == null || (list12 = menuRenderer4.items) == null) {
                    watchEndpoint4 = null;
                } else {
                    Iterator it7 = list12.iterator();
                    do {
                        if (!it7.hasNext()) {
                            next5 = null;
                            break;
                        }
                        next5 = it7.next();
                        menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon6 = menuNavigationItemRenderer10.icon) == null) ? null : icon6.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next5;
                    if (item3 == null || (menuNavigationItemRenderer9 = item3.menuNavigationItemRenderer) == null || (navigationEndpoint8 = menuNavigationItemRenderer9.navigationEndpoint) == null) {
                        watchEndpoint4 = null;
                    } else {
                        watchEndpoint4 = navigationEndpoint8.watchPlaylistEndpoint;
                    }
                }
                if (menu != null && (menuRenderer3 = menu.menuRenderer) != null && (list11 = menuRenderer3.items) != null) {
                    Iterator it8 = list11.iterator();
                    do {
                        if (!it8.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it8.next();
                        menuNavigationItemRenderer8 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer8 == null || (icon5 = menuNavigationItemRenderer8.icon) == null) ? null : icon5.iconType, "MIX"));
                    Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next4;
                    if (item4 != null && (menuNavigationItemRenderer7 = item4.menuNavigationItemRenderer) != null && (navigationEndpoint7 = menuNavigationItemRenderer7.navigationEndpoint) != null) {
                        obj = navigationEndpoint7.watchPlaylistEndpoint;
                    }
                }
                return new ArtistItem(str10, str11, thumbnailUrl4, (String) null, (WatchEndpoint) null, watchEndpoint4, (WatchEndpoint) obj, 24);
            }
        } else if (!musicResponsiveListItemRenderer.isAlbum()) {
            if (Intrinsics.areEqual((navigationEndpoint17 == null || (browseEndpoint3 = navigationEndpoint17.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint3.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PLAYLIST")) {
                if (navigationEndpoint17 != null && (browseEndpoint2 = navigationEndpoint17.browseEndpoint) != null && (str3 = browseEndpoint2.browseId) != null) {
                    String strRemovePrefix = StringsKt.removePrefix(str3, "VL");
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn10 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23);
                    if (flexColumn10 != null && (musicResponsiveListItemFlexColumnRenderer3 = flexColumn10.musicResponsiveListItemFlexColumnRenderer) != null && (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) != null && (list5 = runs3.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list5)) != null && (str4 = run3.text) != null) {
                        Set set3 = PageHelper.LIBRARY_ADD_ICONS;
                        List listDrop2 = CollectionsKt.drop(list23, 1);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it9 = listDrop2.iterator();
                        while (it9.hasNext()) {
                            Runs runs14 = ((MusicResponsiveListItemRenderer.FlexColumn) it9.next()).musicResponsiveListItemFlexColumnRenderer.text;
                            List list27 = runs14 != null ? runs14.runs : null;
                            if (list27 == null) {
                                list27 = emptyList;
                            }
                            CollectionsKt__MutableCollectionsKt.addAll(list27, arrayList2);
                        }
                        Artist artist = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(arrayList2));
                        if (artist == null) {
                            List list28 = (List) CollectionsKt.lastOrNull(CollectionsKt.dropLast(1, listSplitBySeparator));
                            Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list28));
                            if (artist2 != null) {
                                artist = artist2;
                            } else {
                                if (list28 != null && (list8 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list28))) != null && (run5 = (Run) CollectionsKt.firstOrNull(list8)) != null) {
                                    if (run5.navigationEndpoint != null || StringsKt.isBlank(run5.text)) {
                                        run5 = null;
                                    }
                                    if (run5 != null) {
                                        artist2 = new Artist(StringsKt.trim(run5.text).toString(), null);
                                        artist = artist2;
                                    }
                                }
                                artist = null;
                            }
                        }
                        Artist artist3 = artist;
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn11 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list23);
                        if (flexColumn11 != null && (musicResponsiveListItemFlexColumnRenderer4 = flexColumn11.musicResponsiveListItemFlexColumnRenderer) != null && (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) != null && (list6 = runs4.runs) != null && (run4 = (Run) CollectionsKt.lastOrNull(list6)) != null && (str5 = run4.text) != null && thumbnailRenderer != null && (thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl()) != null && overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint3 = musicPlayButtonRenderer2.playNavigationEndpoint) != null && (watchEndpoint = navigationEndpoint3.watchPlaylistEndpoint) != null && menu != null && (menuRenderer2 = menu.menuRenderer) != null && (list7 = menuRenderer2.items) != null) {
                            Iterator it10 = list7.iterator();
                            do {
                                if (!it10.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it10.next();
                                menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon3 = menuNavigationItemRenderer6.icon) == null) ? null : icon3.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next2;
                            if (item5 != null && (menuNavigationItemRenderer3 = item5.menuNavigationItemRenderer) != null && (navigationEndpoint4 = menuNavigationItemRenderer3.navigationEndpoint) != null && (watchEndpoint2 = navigationEndpoint4.watchPlaylistEndpoint) != null) {
                                Iterator it11 = menuRenderer2.items.iterator();
                                do {
                                    if (!it11.hasNext()) {
                                        next3 = null;
                                        break;
                                    }
                                    next3 = it11.next();
                                    menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon2 = menuNavigationItemRenderer5.icon) == null) ? null : icon2.iconType, "MIX"));
                                Menu.MenuRenderer.Item item6 = (Menu.MenuRenderer.Item) next3;
                                if (item6 != null && (menuNavigationItemRenderer4 = item6.menuNavigationItemRenderer) != null && (navigationEndpoint5 = menuNavigationItemRenderer4.navigationEndpoint) != null && (watchEndpoint3 = navigationEndpoint5.watchPlaylistEndpoint) != null) {
                                    return new PlaylistItem(strRemovePrefix, str4, artist3, str5, thumbnailUrl2, watchEndpoint, watchEndpoint2, watchEndpoint3, false, (String) null, (String) null, 3840);
                                }
                            }
                        }
                    }
                }
            } else if (musicResponsiveListItemRenderer.isPodcast() && navigationEndpoint17 != null && (browseEndpoint = navigationEndpoint17.browseEndpoint) != null && (str = browseEndpoint.browseId) != null && (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23)) != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list2 = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list2)) != null && (str2 = run.text) != null) {
                Set set4 = PageHelper.LIBRARY_ADD_ICONS;
                List listDrop3 = CollectionsKt.drop(list23, 1);
                ArrayList arrayList3 = new ArrayList();
                Iterator it12 = listDrop3.iterator();
                while (it12.hasNext()) {
                    Runs runs15 = ((MusicResponsiveListItemRenderer.FlexColumn) it12.next()).musicResponsiveListItemFlexColumnRenderer.text;
                    List list29 = runs15 != null ? runs15.runs : null;
                    if (list29 == null) {
                        list29 = emptyList;
                    }
                    CollectionsKt__MutableCollectionsKt.addAll(list29, arrayList3);
                }
                Artist artist4 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(arrayList3));
                MusicResponsiveListItemRenderer.FlexColumn flexColumn12 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list23);
                String str30 = (flexColumn12 == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn12.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list4 = runs2.runs) == null || (run2 = (Run) CollectionsKt.lastOrNull(list4)) == null) ? null : run2.text;
                if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                    WatchEndpoint watchEndpoint14 = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint2.watchPlaylistEndpoint;
                    if (menu != null && (menuRenderer = menu.menuRenderer) != null && (list3 = menuRenderer.items) != null) {
                        Iterator it13 = list3.iterator();
                        do {
                            if (!it13.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it13.next();
                            menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon = menuNavigationItemRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item7 = (Menu.MenuRenderer.Item) next;
                        if (item7 != null && (menuNavigationItemRenderer = item7.menuNavigationItemRenderer) != null && (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) != null) {
                            obj = navigationEndpoint.watchPlaylistEndpoint;
                        }
                    }
                    return new PodcastItem(str, str2, artist4, str30, thumbnailUrl, watchEndpoint14, obj, null, null, null, 896);
                }
            }
        } else if (navigationEndpoint17 != null && (browseEndpoint4 = navigationEndpoint17.browseEndpoint) != null && (str6 = browseEndpoint4.browseId) != null && overlay != null && (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) != null && (content3 = musicItemThumbnailOverlayRenderer3.content) != null && (musicPlayButtonRenderer3 = content3.musicPlayButtonRenderer) != null && (navigationEndpoint6 = musicPlayButtonRenderer3.playNavigationEndpoint) != null) {
            WatchEndpoint watchEndpoint15 = navigationEndpoint6.watchEndpoint;
            if (watchEndpoint15 == null) {
                watchEndpoint15 = navigationEndpoint6.watchPlaylistEndpoint;
            }
            if (watchEndpoint15 != null && (str7 = watchEndpoint15.playlistId) != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list23)) != null && (musicResponsiveListItemFlexColumnRenderer5 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs5 = musicResponsiveListItemFlexColumnRenderer5.text) != null && (list9 = runs5.runs) != null && (run6 = (Run) CollectionsKt.firstOrNull(list9)) != null && (str8 = run6.text) != null) {
                Set set5 = PageHelper.LIBRARY_ADD_ICONS;
                ArrayList arrayListExtractArtists2 = PageHelper.extractArtists((List) CollectionsKt.getOrNull(1, listSplitBySeparator));
                List list30 = (List) CollectionsKt.getOrNull(2, listSplitBySeparator);
                Integer intOrNull = (list30 == null || (run7 = (Run) CollectionsKt.firstOrNull(list30)) == null || (str9 = run7.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str9);
                if (thumbnailRenderer != null && (thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl()) != null) {
                    if (list22 != null) {
                        for (Object obj3 : list22) {
                            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer3 = ((Badges) obj3).musicInlineBadgeRenderer;
                            if (Intrinsics.areEqual((musicInlineBadgeRenderer3 == null || (icon4 = musicInlineBadgeRenderer3.icon) == null) ? null : icon4.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                obj = obj3;
                                break;
                            }
                        }
                        obj = (Badges) obj;
                    }
                    return new AlbumItem(str6, str7, str8, arrayListExtractArtists2, intOrNull, thumbnailUrl3, obj != null, 4);
                }
            }
        }
        return null;
    }
}
