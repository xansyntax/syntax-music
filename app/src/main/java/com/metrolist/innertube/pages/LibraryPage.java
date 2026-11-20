package com.metrolist.innertube.pages;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
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
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryPage {
    public final String continuation;
    public final boolean isUploaded;
    public final List items;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion {
        /* JADX WARN: Code duplicated, block: B:215:0x027f  */
        /* JADX WARN: Code duplicated, block: B:292:0x0348  */
        public static YTItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, boolean z) {
            BrowseEndpoint browseEndpoint;
            String str;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
            Runs runs;
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
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
            Runs runs2;
            List list3;
            Run run2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            Menu.MenuRenderer menuRenderer2;
            BrowseEndpoint browseEndpoint2;
            String str3;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            List list4;
            Run run3;
            String str4;
            WatchEndpoint watchEndpoint;
            Menu.MenuRenderer menuRenderer3;
            List list5;
            Object next2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
            NavigationEndpoint navigationEndpoint3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
            Icon icon2;
            Menu.MenuRenderer menuRenderer4;
            List list6;
            Object next3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
            NavigationEndpoint navigationEndpoint4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
            Icon icon3;
            BrowseEndpoint browseEndpoint3;
            String str5;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer5;
            Runs runs5;
            List list7;
            Run run4;
            String str6;
            String thumbnailUrl;
            WatchEndpoint watchEndpoint2;
            Menu.MenuRenderer menuRenderer5;
            List list8;
            Object next4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
            NavigationEndpoint navigationEndpoint5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
            Icon icon4;
            Menu.MenuRenderer menuRenderer6;
            List list9;
            Object next5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
            NavigationEndpoint navigationEndpoint6;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
            Icon icon5;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn4;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer6;
            Runs runs6;
            List list10;
            Run run5;
            String str7;
            Album album;
            String thumbnailUrl2;
            String str8;
            List listExtractArtists;
            List list11;
            Iterable iterableExtractArtists;
            Badges badges;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint7;
            Object next6;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            Icon icon6;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn5;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer7;
            Runs runs7;
            List list12;
            Run run6;
            String str9;
            Menu.MenuRenderer menuRenderer7;
            List list13;
            NavigationEndpoint navigationEndpoint8;
            NavigationEndpoint.ConfirmDialogEndpoint confirmDialogEndpoint;
            NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogContent confirmDialogContent;
            NavigationEndpoint.ConfirmDialogEndpoint.ConfirmDialogRenderer confirmDialogRenderer;
            NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButton confirmButton;
            NavigationEndpoint.ConfirmDialogEndpoint.ConfirmButtonRenderer confirmButtonRenderer;
            NavigationEndpoint.ConfirmDialogEndpoint.ConfirmCommand confirmCommand;
            NavigationEndpoint.DeletePrivatelyOwnedEntityCommand deletePrivatelyOwnedEntityCommand;
            BrowseEndpoint browseEndpoint4;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer8;
            Runs runs8;
            List list14;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer9;
            Runs runs9;
            Menu.MenuRenderer menuRenderer8;
            musicResponsiveListItemRenderer.getClass();
            MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
            NavigationEndpoint navigationEndpoint9 = musicResponsiveListItemRenderer.navigationEndpoint;
            ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
            List list15 = musicResponsiveListItemRenderer.flexColumns;
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = musicResponsiveListItemRenderer.menu;
            WatchEndpoint watchEndpoint3 = null;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer8 = menu.menuRenderer) == null) ? null : menuRenderer8.items);
            if (musicResponsiveListItemRenderer.isSong()) {
                String videoId = musicResponsiveListItemRenderer.getVideoId();
                if (videoId != null && (flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list15)) != null && (musicResponsiveListItemFlexColumnRenderer6 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) != null && (runs6 = musicResponsiveListItemFlexColumnRenderer6.text) != null && (list10 = runs6.runs) != null && (run5 = (Run) CollectionsKt.firstOrNull(list10)) != null && (str7 = run5.text) != null) {
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn6 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list15);
                    List list16 = (flexColumn6 == null || (musicResponsiveListItemFlexColumnRenderer9 = flexColumn6.musicResponsiveListItemFlexColumnRenderer) == null || (runs9 = musicResponsiveListItemFlexColumnRenderer9.text) == null) ? null : runs9.runs;
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn7 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list15);
                    Run run7 = (flexColumn7 == null || (musicResponsiveListItemFlexColumnRenderer8 = flexColumn7.musicResponsiveListItemFlexColumnRenderer) == null || (runs8 = musicResponsiveListItemFlexColumnRenderer8.text) == null || (list14 = runs8.runs) == null) ? null : (Run) CollectionsKt.firstOrNull(list14);
                    if (run7 != null) {
                        NavigationEndpoint navigationEndpoint10 = run7.navigationEndpoint;
                        String str10 = (navigationEndpoint10 == null || (browseEndpoint4 = navigationEndpoint10.browseEndpoint) == null) ? null : browseEndpoint4.browseId;
                        String str11 = run7.text;
                        if (str10 == null) {
                            str10 = "";
                        }
                        album = new Album(str11, str10);
                    } else {
                        album = null;
                    }
                    if (thumbnailRenderer != null && (thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl()) != null) {
                        if (menu != null && (menuRenderer7 = menu.menuRenderer) != null && (list13 = menuRenderer7.items) != null) {
                            Iterator it = list13.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str8 = null;
                                    break;
                                }
                                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer11 = ((Menu.MenuRenderer.Item) it.next()).menuNavigationItemRenderer;
                                String str12 = (menuNavigationItemRenderer11 == null || (navigationEndpoint8 = menuNavigationItemRenderer11.navigationEndpoint) == null || (confirmDialogEndpoint = navigationEndpoint8.confirmDialogEndpoint) == null || (confirmDialogContent = confirmDialogEndpoint.content) == null || (confirmDialogRenderer = confirmDialogContent.confirmDialogRenderer) == null || (confirmButton = confirmDialogRenderer.confirmButton) == null || (confirmButtonRenderer = confirmButton.buttonRenderer) == null || (confirmCommand = confirmButtonRenderer.command) == null || (deletePrivatelyOwnedEntityCommand = confirmCommand.musicDeletePrivatelyOwnedEntityCommand) == null) ? null : deletePrivatelyOwnedEntityCommand.entityId;
                                if (str12 != null) {
                                    str8 = str12;
                                    break;
                                }
                            }
                        } else {
                            str8 = null;
                            break;
                        }
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        if (z || str8 != null) {
                            if (list16 == null || (list11 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list16))) == null) {
                                listExtractArtists = null;
                            } else {
                                ArrayList arrayListOddElements = CharsKt.oddElements(list11);
                                ArrayList arrayList = new ArrayList();
                                int size = arrayListOddElements.size();
                                int i = 0;
                                while (i < size) {
                                    Object obj = arrayListOddElements.get(i);
                                    i++;
                                    Run run8 = (Run) obj;
                                    if (run8.navigationEndpoint == null) {
                                        String string = StringsKt.trim(run8.text).toString();
                                        if (string.length() <= 0) {
                                            string = null;
                                        }
                                        iterableExtractArtists = CollectionsKt__IterablesKt.listOfNotNull(string != null ? new Artist(string, null) : null);
                                    } else {
                                        Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                                        iterableExtractArtists = PageHelper.extractArtists(CollectionsKt__IterablesKt.listOf(run8));
                                    }
                                    CollectionsKt__MutableCollectionsKt.addAll(iterableExtractArtists, arrayList);
                                }
                                listExtractArtists = arrayList;
                            }
                            if (listExtractArtists == null) {
                                listExtractArtists = EmptyList.INSTANCE;
                            }
                        } else {
                            listExtractArtists = PageHelper.extractArtists(list16);
                        }
                        List list17 = listExtractArtists;
                        List list18 = musicResponsiveListItemRenderer.fixedColumns;
                        Integer numM1883parseTime = (list18 == null || (flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list18)) == null || (musicResponsiveListItemFlexColumnRenderer7 = flexColumn5.musicResponsiveListItemFlexColumnRenderer) == null || (runs7 = musicResponsiveListItemFlexColumnRenderer7.text) == null || (list12 = runs7.runs) == null || (run6 = (Run) CollectionsKt.firstOrNull(list12)) == null || (str9 = run6.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str9);
                        String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        List list19 = musicResponsiveListItemRenderer.badges;
                        if (list19 != null) {
                            Iterator it2 = list19.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next6 = null;
                                    break;
                                }
                                next6 = it2.next();
                                musicInlineBadgeRenderer = ((Badges) next6).musicInlineBadgeRenderer;
                            } while (!Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon6 = musicInlineBadgeRenderer.icon) == null) ? null : icon6.iconType, "MUSIC_EXPLICIT_BADGE"));
                            badges = (Badges) next6;
                        } else {
                            badges = null;
                        }
                        boolean z2 = badges != null;
                        if (overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint7 = musicPlayButtonRenderer2.playNavigationEndpoint) != null) {
                            watchEndpoint3 = navigationEndpoint7.watchEndpoint;
                        }
                        return new SongItem(videoId, str7, list17, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl2, z2, watchEndpoint3, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), str8, 18624);
                    }
                }
            } else if (musicResponsiveListItemRenderer.isArtist()) {
                if (navigationEndpoint9 != null && (browseEndpoint3 = navigationEndpoint9.browseEndpoint) != null && (str5 = browseEndpoint3.browseId) != null && (flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list15)) != null && (musicResponsiveListItemFlexColumnRenderer5 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) != null && (runs5 = musicResponsiveListItemFlexColumnRenderer5.text) != null && (list7 = runs5.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list7)) != null && (str6 = run4.text) != null && thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                    if (menu == null || (menuRenderer6 = menu.menuRenderer) == null || (list9 = menuRenderer6.items) == null) {
                        watchEndpoint2 = null;
                    } else {
                        Iterator it3 = list9.iterator();
                        do {
                            if (!it3.hasNext()) {
                                next5 = null;
                                break;
                            }
                            next5 = it3.next();
                            menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon5 = menuNavigationItemRenderer10.icon) == null) ? null : icon5.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next5;
                        if (item == null || (menuNavigationItemRenderer9 = item.menuNavigationItemRenderer) == null || (navigationEndpoint6 = menuNavigationItemRenderer9.navigationEndpoint) == null) {
                            watchEndpoint2 = null;
                        } else {
                            watchEndpoint2 = navigationEndpoint6.watchPlaylistEndpoint;
                        }
                    }
                    if (menu != null && (menuRenderer5 = menu.menuRenderer) != null && (list8 = menuRenderer5.items) != null) {
                        Iterator it4 = list8.iterator();
                        do {
                            if (!it4.hasNext()) {
                                next4 = null;
                                break;
                            }
                            next4 = it4.next();
                            menuNavigationItemRenderer8 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer8 == null || (icon4 = menuNavigationItemRenderer8.icon) == null) ? null : icon4.iconType, "MIX"));
                        Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next4;
                        if (item2 != null && (menuNavigationItemRenderer7 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint5 = menuNavigationItemRenderer7.navigationEndpoint) != null) {
                            watchEndpoint3 = navigationEndpoint5.watchPlaylistEndpoint;
                        }
                    }
                    return new ArtistItem(str5, str6, thumbnailUrl, (String) null, (WatchEndpoint) null, watchEndpoint2, watchEndpoint3, 152);
                }
            } else if (musicResponsiveListItemRenderer.isUserChannel()) {
                if (navigationEndpoint9 != null && (browseEndpoint2 = navigationEndpoint9.browseEndpoint) != null && (str3 = browseEndpoint2.browseId) != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list15)) != null && (musicResponsiveListItemFlexColumnRenderer4 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) != null && (list4 = runs4.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str4 = run3.text) != null) {
                    String thumbnailUrl3 = thumbnailRenderer != null ? thumbnailRenderer.getThumbnailUrl() : null;
                    if (menu == null || (menuRenderer4 = menu.menuRenderer) == null || (list6 = menuRenderer4.items) == null) {
                        watchEndpoint = null;
                    } else {
                        Iterator it5 = list6.iterator();
                        do {
                            if (!it5.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it5.next();
                            menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon3 = menuNavigationItemRenderer6.icon) == null) ? null : icon3.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next3;
                        if (item3 == null || (menuNavigationItemRenderer5 = item3.menuNavigationItemRenderer) == null || (navigationEndpoint4 = menuNavigationItemRenderer5.navigationEndpoint) == null) {
                            watchEndpoint = null;
                        } else {
                            watchEndpoint = navigationEndpoint4.watchPlaylistEndpoint;
                        }
                    }
                    if (menu != null && (menuRenderer3 = menu.menuRenderer) != null && (list5 = menuRenderer3.items) != null) {
                        Iterator it6 = list5.iterator();
                        do {
                            if (!it6.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it6.next();
                            menuNavigationItemRenderer4 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer4 == null || (icon2 = menuNavigationItemRenderer4.icon) == null) ? null : icon2.iconType, "MIX"));
                        Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next2;
                        if (item4 != null && (menuNavigationItemRenderer3 = item4.menuNavigationItemRenderer) != null && (navigationEndpoint3 = menuNavigationItemRenderer3.navigationEndpoint) != null) {
                            watchEndpoint3 = navigationEndpoint3.watchPlaylistEndpoint;
                        }
                    }
                    return new ArtistItem(str3, str4, thumbnailUrl3, (String) null, (WatchEndpoint) null, watchEndpoint, watchEndpoint3, 152);
                }
            } else if (musicResponsiveListItemRenderer.isPodcast()) {
                PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems2 = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer2 = menu.menuRenderer) == null) ? null : menuRenderer2.items);
                if (navigationEndpoint9 != null && (browseEndpoint = navigationEndpoint9.browseEndpoint) != null && (str = browseEndpoint.browseId) != null && (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list15)) != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str2 = run.text) != null) {
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn8 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list15);
                    Artist artist = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline((flexColumn8 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn8.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null) ? null : runs3.runs));
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn9 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list15);
                    String str13 = (flexColumn9 == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn9.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list3 = runs2.runs) == null || (run2 = (Run) CollectionsKt.lastOrNull(list3)) == null) ? null : run2.text;
                    String thumbnailUrl4 = thumbnailRenderer != null ? thumbnailRenderer.getThumbnailUrl() : null;
                    WatchEndpoint watchEndpoint4 = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint2.watchPlaylistEndpoint;
                    if (menu != null && (menuRenderer = menu.menuRenderer) != null && (list2 = menuRenderer.items) != null) {
                        Iterator it7 = list2.iterator();
                        do {
                            if (!it7.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it7.next();
                            menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon = menuNavigationItemRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next;
                        if (item5 != null && (menuNavigationItemRenderer = item5.menuNavigationItemRenderer) != null && (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) != null) {
                            watchEndpoint3 = navigationEndpoint.watchPlaylistEndpoint;
                        }
                    }
                    return new PodcastItem(str, str2, artist, str13, thumbnailUrl4, watchEndpoint4, watchEndpoint3, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, 512);
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:144:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:170:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:307:0x0361  */
        /* JADX WARN: Multi-variable type inference failed */
        public static YTItem fromMusicTwoRowItemRenderer(MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint;
            WatchEndpoint watchEndpoint;
            String str;
            List list;
            Run run;
            String str2;
            Album album;
            boolean z;
            Icon icon;
            List list2;
            Run run2;
            String str3;
            List list3;
            Run run3;
            String str4;
            BrowseEndpoint browseEndpoint;
            List list4;
            Menu.MenuRenderer menuRenderer;
            String str5;
            List list5;
            Run run4;
            String str6;
            Menu.MenuRenderer menuRenderer2;
            List list6;
            Object next;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
            NavigationEndpoint navigationEndpoint2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
            Icon icon2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint3;
            List list7;
            Run run5;
            Menu.MenuRenderer menuRenderer3;
            String str7;
            List list8;
            Run run6;
            String str8;
            WatchEndpoint watchEndpoint2;
            Menu.MenuRenderer menuRenderer4;
            List list9;
            Object next2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
            NavigationEndpoint navigationEndpoint4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
            Icon icon3;
            Menu.MenuRenderer menuRenderer5;
            List list10;
            Object next3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
            NavigationEndpoint navigationEndpoint5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
            Icon icon4;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
            String str9;
            List list11;
            Run run7;
            String str10;
            String thumbnailUrl;
            Menu.MenuRenderer menuRenderer6;
            List list12;
            Object next4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
            NavigationEndpoint navigationEndpoint6;
            WatchEndpoint watchEndpoint3;
            Object next5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
            NavigationEndpoint navigationEndpoint7;
            WatchEndpoint watchEndpoint4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
            Icon icon5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
            Icon icon6;
            String str11;
            Run run8;
            String str12;
            Artist artist;
            WatchEndpoint watchEndpoint5;
            WatchEndpoint watchEndpoint6;
            Menu.MenuRenderer menuRenderer7;
            List list13;
            Icon icon7;
            Menu.MenuRenderer menuRenderer8;
            List list14;
            Object next6;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer11;
            NavigationEndpoint navigationEndpoint8;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer12;
            Icon icon8;
            Menu.MenuRenderer menuRenderer9;
            List list15;
            Object next7;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer13;
            NavigationEndpoint navigationEndpoint9;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer14;
            Icon icon9;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
            NavigationEndpoint navigationEndpoint10;
            List list16;
            Run run9;
            List list17;
            Run run10;
            String str13;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer4;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content4;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer4;
            NavigationEndpoint navigationEndpoint11;
            WatchEndpoint watchEndpoint7;
            String str14;
            List list18;
            Run run11;
            String str15;
            Icon icon10;
            List list19;
            Run run12;
            String str16;
            musicTwoRowItemRenderer.getClass();
            List list20 = musicTwoRowItemRenderer.subtitleBadges;
            MusicResponsiveListItemRenderer.Overlay overlay = musicTwoRowItemRenderer.thumbnailOverlay;
            NavigationEndpoint navigationEndpoint12 = musicTwoRowItemRenderer.navigationEndpoint;
            ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer.thumbnailRenderer;
            Runs runs = musicTwoRowItemRenderer.title;
            Runs runs2 = musicTwoRowItemRenderer.subtitle;
            Menu menu = musicTwoRowItemRenderer.menu;
            Object obj = null;
            if (musicTwoRowItemRenderer.isAlbum()) {
                BrowseEndpoint browseEndpoint2 = navigationEndpoint12.browseEndpoint;
                if (browseEndpoint2 != null && (str13 = browseEndpoint2.browseId) != null && overlay != null && (musicItemThumbnailOverlayRenderer4 = overlay.musicItemThumbnailOverlayRenderer) != null && (content4 = musicItemThumbnailOverlayRenderer4.content) != null && (musicPlayButtonRenderer4 = content4.musicPlayButtonRenderer) != null && (navigationEndpoint11 = musicPlayButtonRenderer4.playNavigationEndpoint) != null && (watchEndpoint7 = navigationEndpoint11.watchPlaylistEndpoint) != null && (str14 = watchEndpoint7.playlistId) != null && (list18 = runs.runs) != null && (run11 = (Run) CollectionsKt.firstOrNull(list18)) != null && (str15 = run11.text) != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(runs2 != null ? runs2.runs : null);
                    Integer intOrNull = (runs2 == null || (list19 = runs2.runs) == null || (run12 = (Run) CollectionsKt.lastOrNull(list19)) == null || (str16 = run12.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str16);
                    String thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl2 != null) {
                        if (list20 != null) {
                            for (Object obj2 : list20) {
                                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon10 = musicInlineBadgeRenderer.icon) == null) ? null : icon10.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj2;
                                    break;
                                }
                            }
                            obj = (Badges) obj;
                        }
                        return new AlbumItem(str13, str14, str15, arrayListExtractArtists, intOrNull, thumbnailUrl2, obj != null, 4);
                    }
                }
            } else if (musicTwoRowItemRenderer.isPlaylist()) {
                BrowseEndpoint browseEndpoint3 = navigationEndpoint12.browseEndpoint;
                if (browseEndpoint3 != null && (str11 = browseEndpoint3.browseId) != null) {
                    String strRemovePrefix = StringsKt.removePrefix(str11, "VL");
                    List list21 = runs.runs;
                    if (list21 != null && (run8 = (Run) CollectionsKt.firstOrNull(list21)) != null && (str12 = run8.text) != null) {
                        List list22 = runs2 != null ? runs2.runs : null;
                        Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list22));
                        if (artist2 != null) {
                            artist = artist2;
                        } else {
                            if (list22 != null && (list17 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list22))) != null && (run10 = (Run) CollectionsKt.firstOrNull(list17)) != null) {
                                if (run10.navigationEndpoint != null || StringsKt.isBlank(run10.text)) {
                                    run10 = null;
                                }
                                if (run10 != null) {
                                    artist2 = new Artist(StringsKt.trim(run10.text).toString(), null);
                                    artist = artist2;
                                }
                            }
                            artist = null;
                        }
                        String str17 = (runs2 == null || (list16 = runs2.runs) == null || (run9 = (Run) CollectionsKt.lastOrNull(list16)) == null) ? null : run9.text;
                        String thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl3 != null) {
                            WatchEndpoint watchEndpoint8 = (overlay == null || (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) == null || (content3 = musicItemThumbnailOverlayRenderer3.content) == null || (musicPlayButtonRenderer3 = content3.musicPlayButtonRenderer) == null || (navigationEndpoint10 = musicPlayButtonRenderer3.playNavigationEndpoint) == null) ? null : navigationEndpoint10.watchPlaylistEndpoint;
                            if (menu == null || (menuRenderer9 = menu.menuRenderer) == null || (list15 = menuRenderer9.items) == null) {
                                watchEndpoint5 = null;
                            } else {
                                Iterator it = list15.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        next7 = null;
                                        break;
                                    }
                                    next7 = it.next();
                                    menuNavigationItemRenderer14 = ((Menu.MenuRenderer.Item) next7).menuNavigationItemRenderer;
                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer14 == null || (icon9 = menuNavigationItemRenderer14.icon) == null) ? null : icon9.iconType, "MUSIC_SHUFFLE"));
                                Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next7;
                                if (item == null || (menuNavigationItemRenderer13 = item.menuNavigationItemRenderer) == null || (navigationEndpoint9 = menuNavigationItemRenderer13.navigationEndpoint) == null) {
                                    watchEndpoint5 = null;
                                } else {
                                    watchEndpoint5 = navigationEndpoint9.watchPlaylistEndpoint;
                                }
                            }
                            if (menu == null || (menuRenderer8 = menu.menuRenderer) == null || (list14 = menuRenderer8.items) == null) {
                                watchEndpoint6 = null;
                            } else {
                                Iterator it2 = list14.iterator();
                                do {
                                    if (!it2.hasNext()) {
                                        next6 = null;
                                        break;
                                    }
                                    next6 = it2.next();
                                    menuNavigationItemRenderer12 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer12 == null || (icon8 = menuNavigationItemRenderer12.icon) == null) ? null : icon8.iconType, "MIX"));
                                Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next6;
                                if (item2 == null || (menuNavigationItemRenderer11 = item2.menuNavigationItemRenderer) == null || (navigationEndpoint8 = menuNavigationItemRenderer11.navigationEndpoint) == null) {
                                    watchEndpoint6 = null;
                                } else {
                                    watchEndpoint6 = navigationEndpoint8.watchPlaylistEndpoint;
                                }
                            }
                            if (menu != null && (menuRenderer7 = menu.menuRenderer) != null && (list13 = menuRenderer7.items) != null) {
                                for (Object obj3 : list13) {
                                    Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer15 = ((Menu.MenuRenderer.Item) obj3).menuNavigationItemRenderer;
                                    if (Intrinsics.areEqual((menuNavigationItemRenderer15 == null || (icon7 = menuNavigationItemRenderer15.icon) == null) ? null : icon7.iconType, "EDIT")) {
                                        obj = obj3;
                                        break;
                                    }
                                }
                                obj = (Menu.MenuRenderer.Item) obj;
                            }
                            return new PlaylistItem(strRemovePrefix, str12, artist, str17, thumbnailUrl3, watchEndpoint8, watchEndpoint5, watchEndpoint6, obj != null, (String) null, (String) null, 3584);
                        }
                    }
                }
            } else if (musicTwoRowItemRenderer.isArtist()) {
                BrowseEndpoint browseEndpoint4 = navigationEndpoint12.browseEndpoint;
                if (browseEndpoint4 != null && (str9 = browseEndpoint4.browseId) != null && (list11 = runs.runs) != null && (run7 = (Run) CollectionsKt.lastOrNull(list11)) != null && (str10 = run7.text) != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null && menu != null && (menuRenderer6 = menu.menuRenderer) != null && (list12 = menuRenderer6.items) != null) {
                    Iterator it3 = list12.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it3.next();
                        menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon6 = menuNavigationItemRenderer10.icon) == null) ? null : icon6.iconType, "MUSIC_SHUFFLE"));
                    Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next4;
                    if (item3 != null && (menuNavigationItemRenderer7 = item3.menuNavigationItemRenderer) != null && (navigationEndpoint6 = menuNavigationItemRenderer7.navigationEndpoint) != null && (watchEndpoint3 = navigationEndpoint6.watchPlaylistEndpoint) != null) {
                        Iterator it4 = menuRenderer6.items.iterator();
                        do {
                            if (!it4.hasNext()) {
                                next5 = null;
                                break;
                            }
                            next5 = it4.next();
                            menuNavigationItemRenderer9 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer9 == null || (icon5 = menuNavigationItemRenderer9.icon) == null) ? null : icon5.iconType, "MIX"));
                        Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next5;
                        if (item4 != null && (menuNavigationItemRenderer8 = item4.menuNavigationItemRenderer) != null && (navigationEndpoint7 = menuNavigationItemRenderer8.navigationEndpoint) != null && (watchEndpoint4 = navigationEndpoint7.watchPlaylistEndpoint) != null) {
                            return new ArtistItem(str9, str10, thumbnailUrl, (String) null, (WatchEndpoint) null, watchEndpoint3, watchEndpoint4, 152);
                        }
                    }
                }
            } else {
                BrowseEndpoint browseEndpoint5 = navigationEndpoint12.browseEndpoint;
                BrowseEndpoint browseEndpoint6 = navigationEndpoint12.browseEndpoint;
                if (Intrinsics.areEqual((browseEndpoint5 == null || (browseEndpointContextSupportedConfigs = browseEndpoint5.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_USER_CHANNEL")) {
                    if (browseEndpoint6 != null && (str7 = browseEndpoint6.browseId) != null && (list8 = runs.runs) != null && (run6 = (Run) CollectionsKt.firstOrNull(list8)) != null && (str8 = run6.text) != null) {
                        String thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl();
                        if (menu == null || (menuRenderer5 = menu.menuRenderer) == null || (list10 = menuRenderer5.items) == null) {
                            watchEndpoint2 = null;
                        } else {
                            Iterator it5 = list10.iterator();
                            do {
                                if (!it5.hasNext()) {
                                    next3 = null;
                                    break;
                                }
                                next3 = it5.next();
                                menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon4 = menuNavigationItemRenderer6.icon) == null) ? null : icon4.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next3;
                            if (item5 == null || (menuNavigationItemRenderer5 = item5.menuNavigationItemRenderer) == null || (navigationEndpoint5 = menuNavigationItemRenderer5.navigationEndpoint) == null) {
                                watchEndpoint2 = null;
                            } else {
                                watchEndpoint2 = navigationEndpoint5.watchPlaylistEndpoint;
                            }
                        }
                        if (menu != null && (menuRenderer4 = menu.menuRenderer) != null && (list9 = menuRenderer4.items) != null) {
                            Iterator it6 = list9.iterator();
                            do {
                                if (!it6.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it6.next();
                                menuNavigationItemRenderer4 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer4 == null || (icon3 = menuNavigationItemRenderer4.icon) == null) ? null : icon3.iconType, "MIX"));
                            Menu.MenuRenderer.Item item6 = (Menu.MenuRenderer.Item) next2;
                            if (item6 != null && (menuNavigationItemRenderer3 = item6.menuNavigationItemRenderer) != null && (navigationEndpoint4 = menuNavigationItemRenderer3.navigationEndpoint) != null) {
                                obj = navigationEndpoint4.watchPlaylistEndpoint;
                            }
                        }
                        return new ArtistItem(str7, str8, thumbnailUrl4, (String) null, (WatchEndpoint) null, watchEndpoint2, (WatchEndpoint) obj, 152);
                    }
                } else if (musicTwoRowItemRenderer.isPodcast()) {
                    Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                    PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer3 = menu.menuRenderer) == null) ? null : menuRenderer3.items);
                    if (browseEndpoint6 != null && (str5 = browseEndpoint6.browseId) != null && (list5 = runs.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list5)) != null && (str6 = run4.text) != null) {
                        Artist artist3 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs2 != null ? runs2.runs : null));
                        String str18 = (runs2 == null || (list7 = runs2.runs) == null || (run5 = (Run) CollectionsKt.lastOrNull(list7)) == null) ? null : run5.text;
                        String thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl();
                        WatchEndpoint watchEndpoint9 = (overlay == null || (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) == null || (content2 = musicItemThumbnailOverlayRenderer2.content) == null || (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) == null || (navigationEndpoint3 = musicPlayButtonRenderer2.playNavigationEndpoint) == null) ? null : navigationEndpoint3.watchPlaylistEndpoint;
                        if (menu != null && (menuRenderer2 = menu.menuRenderer) != null && (list6 = menuRenderer2.items) != null) {
                            Iterator it7 = list6.iterator();
                            do {
                                if (!it7.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it7.next();
                                menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon2 = menuNavigationItemRenderer2.icon) == null) ? null : icon2.iconType, "MUSIC_SHUFFLE"));
                            Menu.MenuRenderer.Item item7 = (Menu.MenuRenderer.Item) next;
                            if (item7 != null && (menuNavigationItemRenderer = item7.menuNavigationItemRenderer) != null && (navigationEndpoint2 = menuNavigationItemRenderer.navigationEndpoint) != null) {
                                obj = navigationEndpoint2.watchPlaylistEndpoint;
                            }
                        }
                        return new PodcastItem(str5, str6, artist3, str18, thumbnailUrl5, watchEndpoint9, obj, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, 512);
                    }
                } else if (musicTwoRowItemRenderer.isEpisode() || musicTwoRowItemRenderer.isSong()) {
                    Set set3 = PageHelper.LIBRARY_ADD_ICONS;
                    PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems2 = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
                    if (overlay != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) != null && (watchEndpoint = navigationEndpoint.watchEndpoint) != null && (str = watchEndpoint.videoId) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str2 = run.text) != null) {
                        ArrayList arrayListSplitBySeparator = (runs2 == null || (list4 = runs2.runs) == null) ? null : CharsKt.splitBySeparator(list4);
                        ArrayList arrayListExtractArtists2 = PageHelper.extractArtists(arrayListSplitBySeparator != null ? (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator) : null);
                        if (arrayListSplitBySeparator == null || (list3 = (List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator)) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                            album = null;
                        } else {
                            String str19 = run3.text;
                            NavigationEndpoint navigationEndpoint13 = run3.navigationEndpoint;
                            if (navigationEndpoint13 == null || (browseEndpoint = navigationEndpoint13.browseEndpoint) == null || (str4 = browseEndpoint.browseId) == null) {
                                str4 = "";
                            }
                            album = new Album(str19, str4);
                        }
                        Integer numM1883parseTime = (arrayListSplitBySeparator == null || (list2 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator)) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null || (str3 = run2.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str3);
                        String thumbnailUrl6 = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl6 != null) {
                            if (list20 == null || list20.isEmpty()) {
                                z = false;
                            } else {
                                Iterator it8 = list20.iterator();
                                while (it8.hasNext()) {
                                    Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2 = ((Badges) it8.next()).musicInlineBadgeRenderer;
                                    if (Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon = musicInlineBadgeRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                        z = true;
                                    }
                                }
                                z = false;
                            }
                            return new SongItem(str, str2, arrayListExtractArtists2, album, numM1883parseTime, null, null, null, thumbnailUrl6, z, musicItemThumbnailOverlayRenderer.content.musicPlayButtonRenderer.playNavigationEndpoint.watchEndpoint, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems2.removeToken, null, musicTwoRowItemRenderer.isEpisode(), null, 84192);
                        }
                    }
                }
            }
            return null;
        }
    }

    public LibraryPage(String str, List list, boolean z) {
        this.items = list;
        this.continuation = str;
        this.isUploaded = z;
    }

    public static LibraryPage copy$default(LibraryPage libraryPage, List list, boolean z, int i) {
        if ((i & 1) != 0) {
            list = libraryPage.items;
        }
        String str = (i & 2) != 0 ? libraryPage.continuation : null;
        if ((i & 4) != 0) {
            z = libraryPage.isUploaded;
        }
        libraryPage.getClass();
        list.getClass();
        return new LibraryPage(str, list, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryPage)) {
            return false;
        }
        LibraryPage libraryPage = (LibraryPage) obj;
        return Intrinsics.areEqual(this.items, libraryPage.items) && Intrinsics.areEqual(this.continuation, libraryPage.continuation) && this.isUploaded == libraryPage.isUploaded;
    }

    public final int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        String str = this.continuation;
        return Boolean.hashCode(this.isUploaded) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryPage(items=");
        sb.append(this.items);
        sb.append(", continuation=");
        sb.append(this.continuation);
        sb.append(", isUploaded=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.isUploaded, ")");
    }
}
