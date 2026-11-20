package com.metrolist.innertube.pages;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicTwoRowItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistItemsPage {
    public final String continuation;
    public final List items;
    public final String title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:109:0x011a  */
        /* JADX WARN: Code duplicated, block: B:112:0x0123  */
        /* JADX WARN: Code duplicated, block: B:117:0x012f  */
        /* JADX WARN: Code duplicated, block: B:120:0x0139  */
        /* JADX WARN: Code duplicated, block: B:122:0x0144  */
        /* JADX WARN: Code duplicated, block: B:125:0x014b  */
        /* JADX WARN: Code duplicated, block: B:131:0x0159  */
        /* JADX WARN: Code duplicated, block: B:134:0x015f  */
        /* JADX WARN: Code duplicated, block: B:136:0x0163  */
        /* JADX WARN: Code duplicated, block: B:148:0x0155 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:42:0x0078 A[PHI: r6
          0x0078: PHI (r6v26 java.lang.String) = (r6v3 java.lang.String), (r6v5 java.lang.String), (r6v9 java.lang.String), (r6v35 java.lang.String) binds: [B:49:0x0086, B:63:0x00a2, B:80:0x00cc, B:40:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:84:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:96:0x00f4  */
        public static SongItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            Album album;
            String str;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
            Runs runs;
            List list;
            Run run;
            NavigationEndpoint navigationEndpoint;
            WatchEndpoint watchEndpoint;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint2;
            WatchEndpoint watchEndpoint2;
            WatchEndpoint watchEndpoint3;
            String str2;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
            Runs runs2;
            List list2;
            Run run2;
            String str3;
            List list3;
            Integer numM1883parseTime;
            String musicVideoType;
            ThumbnailRenderer thumbnailRenderer;
            String thumbnailUrl;
            List list4;
            Badges badges;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint3;
            Iterator it;
            Object next;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            String str4;
            Icon icon;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            List list5;
            Run run3;
            String str5;
            Menu.MenuRenderer menuRenderer;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            List list6;
            Run run4;
            BrowseEndpoint browseEndpoint;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer5;
            Runs runs5;
            musicResponsiveListItemRenderer.getClass();
            MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            List list7 = musicResponsiveListItemRenderer.flexColumns;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list7);
            WatchEndpoint watchEndpoint4 = null;
            ArrayList arrayListExtractArtists = PageHelper.extractArtists((flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer5 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs5 = musicResponsiveListItemFlexColumnRenderer5.text) == null) ? null : runs5.runs);
            MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.lastOrNull(list7);
            if (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null || (list6 = runs4.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list6)) == null) {
                album = null;
            } else {
                NavigationEndpoint navigationEndpoint4 = run4.navigationEndpoint;
                album = ((navigationEndpoint4 == null || (browseEndpoint = navigationEndpoint4.browseEndpoint) == null) ? null : browseEndpoint.browseId) != null ? new Album(run4.text, navigationEndpoint4.browseEndpoint.browseId) : null;
            }
            Menu menu = musicResponsiveListItemRenderer.menu;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData = musicResponsiveListItemRenderer.playlistItemData;
            if (playlistItemData == null || (str = playlistItemData.videoId) == null) {
                NavigationEndpoint navigationEndpoint5 = musicResponsiveListItemRenderer.navigationEndpoint;
                str = (navigationEndpoint5 == null || (watchEndpoint3 = navigationEndpoint5.watchEndpoint) == null) ? null : watchEndpoint3.videoId;
                if (str != null) {
                    str2 = str;
                    flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                    if (flexColumn != null && (musicResponsiveListItemFlexColumnRenderer2 = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) != null && (list2 = runs2.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list2)) != null && (str3 = run2.text) != null) {
                        list3 = musicResponsiveListItemRenderer.fixedColumns;
                        if (list3 != null || (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list3)) == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null || (list5 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list5)) == null || (str5 = run3.text) == null) {
                            numM1883parseTime = null;
                        } else {
                            numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str5);
                        }
                        musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                        if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                            list4 = musicResponsiveListItemRenderer.badges;
                            if (list4 != null) {
                                it = list4.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                    musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                                    if (musicInlineBadgeRenderer != null || (icon = musicInlineBadgeRenderer.icon) == null) {
                                        str4 = null;
                                    } else {
                                        str4 = icon.iconType;
                                    }
                                } while (!Intrinsics.areEqual(str4, "MUSIC_EXPLICIT_BADGE"));
                                badges = (Badges) next;
                            } else {
                                badges = null;
                            }
                            boolean z = badges != null;
                            if (overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint3 = musicPlayButtonRenderer2.playNavigationEndpoint) != null) {
                                watchEndpoint4 = navigationEndpoint3.watchEndpoint;
                            }
                            return new SongItem(str2, str3, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 84160);
                        }
                    }
                } else {
                    str = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint2.watchEndpoint) == null) ? null : watchEndpoint2.videoId;
                    if (str != null) {
                        str2 = str;
                        flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                        if (flexColumn != null) {
                            list3 = musicResponsiveListItemRenderer.fixedColumns;
                            if (list3 != null) {
                                numM1883parseTime = null;
                            } else {
                                numM1883parseTime = null;
                            }
                            musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                            thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                            if (thumbnailRenderer != null) {
                                list4 = musicResponsiveListItemRenderer.badges;
                                if (list4 != null) {
                                    it = list4.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                                        if (musicInlineBadgeRenderer != null) {
                                            str4 = null;
                                        } else {
                                            str4 = null;
                                        }
                                    } while (!Intrinsics.areEqual(str4, "MUSIC_EXPLICIT_BADGE"));
                                    badges = (Badges) next;
                                } else {
                                    badges = null;
                                }
                                boolean z2 = badges != null;
                                if (overlay != null) {
                                    watchEndpoint4 = navigationEndpoint3.watchEndpoint;
                                }
                                return new SongItem(str2, str3, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z2, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 84160);
                            }
                        }
                    } else {
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                        str = (flexColumn5 == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn5.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (navigationEndpoint = run.navigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) ? null : watchEndpoint.videoId;
                        if (str != null) {
                            str2 = str;
                            flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                            if (flexColumn != null) {
                                list3 = musicResponsiveListItemRenderer.fixedColumns;
                                if (list3 != null) {
                                    numM1883parseTime = null;
                                } else {
                                    numM1883parseTime = null;
                                }
                                musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                                thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                                if (thumbnailRenderer != null) {
                                    list4 = musicResponsiveListItemRenderer.badges;
                                    if (list4 != null) {
                                        it = list4.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                next = null;
                                                break;
                                            }
                                            next = it.next();
                                            musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                                            if (musicInlineBadgeRenderer != null) {
                                                str4 = null;
                                            } else {
                                                str4 = null;
                                            }
                                        } while (!Intrinsics.areEqual(str4, "MUSIC_EXPLICIT_BADGE"));
                                        badges = (Badges) next;
                                    } else {
                                        badges = null;
                                    }
                                    boolean z3 = badges != null;
                                    if (overlay != null) {
                                        watchEndpoint4 = navigationEndpoint3.watchEndpoint;
                                    }
                                    return new SongItem(str2, str3, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z3, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 84160);
                                }
                            }
                        }
                    }
                }
            } else {
                str2 = str;
                flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                if (flexColumn != null) {
                    list3 = musicResponsiveListItemRenderer.fixedColumns;
                    if (list3 != null) {
                        numM1883parseTime = null;
                    } else {
                        numM1883parseTime = null;
                    }
                    musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                    thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                    if (thumbnailRenderer != null) {
                        list4 = musicResponsiveListItemRenderer.badges;
                        if (list4 != null) {
                            it = list4.iterator();
                            do {
                                if (it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                musicInlineBadgeRenderer = ((Badges) next).musicInlineBadgeRenderer;
                                if (musicInlineBadgeRenderer != null) {
                                    str4 = null;
                                } else {
                                    str4 = null;
                                }
                            } while (!Intrinsics.areEqual(str4, "MUSIC_EXPLICIT_BADGE"));
                            badges = (Badges) next;
                        } else {
                            badges = null;
                        }
                        boolean z4 = badges != null;
                        if (overlay != null) {
                            watchEndpoint4 = navigationEndpoint3.watchEndpoint;
                        }
                        return new SongItem(str2, str3, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z4, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, musicResponsiveListItemRenderer.isEpisode(), null, 84160);
                    }
                }
            }
            return null;
        }

        public static YTItem fromMusicTwoRowItemRenderer(MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
            BrowseEndpoint browseEndpoint;
            String str;
            Run run;
            String str2;
            Artist artist;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint;
            WatchEndpoint watchEndpoint;
            Menu.MenuRenderer menuRenderer;
            List list;
            Object next;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
            NavigationEndpoint navigationEndpoint2;
            WatchEndpoint watchEndpoint2;
            Object next2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
            NavigationEndpoint navigationEndpoint3;
            WatchEndpoint watchEndpoint3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
            Icon icon;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
            Icon icon2;
            List list2;
            Run run2;
            List list3;
            Run run3;
            Run run4;
            String str3;
            WatchEndpoint watchEndpoint4;
            String str4;
            String str5;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint4;
            String str6;
            List list4;
            Run run5;
            String str7;
            Icon icon3;
            List list5;
            Run run6;
            String str8;
            musicTwoRowItemRenderer.getClass();
            Menu menu = musicTwoRowItemRenderer.menu;
            MusicResponsiveListItemRenderer.Overlay overlay = musicTwoRowItemRenderer.thumbnailOverlay;
            ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer.thumbnailRenderer;
            Runs runs = musicTwoRowItemRenderer.title;
            Runs runs2 = musicTwoRowItemRenderer.subtitle;
            NavigationEndpoint navigationEndpoint5 = musicTwoRowItemRenderer.navigationEndpoint;
            Object obj = null;
            if (musicTwoRowItemRenderer.isAlbum()) {
                BrowseEndpoint browseEndpoint2 = navigationEndpoint5.browseEndpoint;
                if (browseEndpoint2 != null && (str5 = browseEndpoint2.browseId) != null && overlay != null && (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) != null && (content2 = musicItemThumbnailOverlayRenderer2.content) != null && (musicPlayButtonRenderer2 = content2.musicPlayButtonRenderer) != null && (navigationEndpoint4 = musicPlayButtonRenderer2.playNavigationEndpoint) != null) {
                    WatchEndpoint watchEndpoint5 = navigationEndpoint4.watchEndpoint;
                    if (watchEndpoint5 == null) {
                        watchEndpoint5 = navigationEndpoint4.watchPlaylistEndpoint;
                    }
                    if (watchEndpoint5 != null && (str6 = watchEndpoint5.playlistId) != null && (list4 = runs.runs) != null && (run5 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str7 = run5.text) != null) {
                        Integer intOrNull = (runs2 == null || (list5 = runs2.runs) == null || (run6 = (Run) CollectionsKt.lastOrNull(list5)) == null || (str8 = run6.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str8);
                        String thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl != null) {
                            List list6 = musicTwoRowItemRenderer.subtitleBadges;
                            if (list6 != null) {
                                for (Object obj2 : list6) {
                                    Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                    if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon3 = musicInlineBadgeRenderer.icon) == null) ? null : icon3.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                        obj = obj2;
                                        break;
                                    }
                                }
                                obj = (Badges) obj;
                            }
                            return new AlbumItem(str5, str6, str7, (List) null, intOrNull, thumbnailUrl, obj != null, 4);
                        }
                    }
                }
            } else if (musicTwoRowItemRenderer.isSong()) {
                List list7 = runs.runs;
                if (list7 != null && (run4 = (Run) CollectionsKt.firstOrNull(list7)) != null && (str3 = run4.text) != null && (watchEndpoint4 = navigationEndpoint5.watchEndpoint) != null && (str4 = watchEndpoint4.videoId) != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(runs2 != null ? runs2.runs : null);
                    String musicVideoType = musicTwoRowItemRenderer.getMusicVideoType();
                    String thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl2 != null) {
                        return new SongItem(str4, str3, arrayListExtractArtists, null, null, musicVideoType, null, null, thumbnailUrl2, false, navigationEndpoint5.watchEndpoint, null, null, null, null, false, null, 129728);
                    }
                }
            } else if (musicTwoRowItemRenderer.isPlaylist() && (browseEndpoint = navigationEndpoint5.browseEndpoint) != null && (str = browseEndpoint.browseId) != null) {
                String strRemovePrefix = StringsKt.removePrefix(str, "VL");
                List list8 = runs.runs;
                if (list8 != null && (run = (Run) CollectionsKt.firstOrNull(list8)) != null && (str2 = run.text) != null) {
                    List list9 = runs2 != null ? runs2.runs : null;
                    Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list9));
                    if (artist2 != null) {
                        artist = artist2;
                    } else {
                        if (list9 != null && (list3 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list9))) != null && (run3 = (Run) CollectionsKt.firstOrNull(list3)) != null) {
                            if (run3.navigationEndpoint != null || StringsKt.isBlank(run3.text)) {
                                run3 = null;
                            }
                            if (run3 != null) {
                                artist2 = new Artist(StringsKt.trim(run3.text).toString(), null);
                                artist = artist2;
                            }
                        }
                        artist = null;
                    }
                    String str9 = (runs2 == null || (list2 = runs2.runs) == null || (run2 = (Run) CollectionsKt.getOrNull(4, list2)) == null) ? null : run2.text;
                    String thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl();
                    if (thumbnailUrl3 != null && overlay != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) != null && (watchEndpoint = navigationEndpoint.watchPlaylistEndpoint) != null && menu != null && (menuRenderer = menu.menuRenderer) != null && (list = menuRenderer.items) != null) {
                        Iterator it = list.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            menuNavigationItemRenderer4 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer4 == null || (icon2 = menuNavigationItemRenderer4.icon) == null) ? null : icon2.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next;
                        if (item != null && (menuNavigationItemRenderer = item.menuNavigationItemRenderer) != null && (navigationEndpoint2 = menuNavigationItemRenderer.navigationEndpoint) != null && (watchEndpoint2 = navigationEndpoint2.watchPlaylistEndpoint) != null) {
                            Iterator it2 = menuRenderer.items.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                                menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer3 == null || (icon = menuNavigationItemRenderer3.icon) == null) ? null : icon.iconType, "MIX"));
                            Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next2;
                            if (item2 != null && (menuNavigationItemRenderer2 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint3 = menuNavigationItemRenderer2.navigationEndpoint) != null && (watchEndpoint3 = navigationEndpoint3.watchPlaylistEndpoint) != null) {
                                return new PlaylistItem(strRemovePrefix, str2, artist, str9, thumbnailUrl3, watchEndpoint, watchEndpoint2, watchEndpoint3, false, (String) null, (String) null, 3840);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    public ArtistItemsPage(String str, String str2, List list) {
        str.getClass();
        this.title = str;
        this.items = list;
        this.continuation = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistItemsPage)) {
            return false;
        }
        ArtistItemsPage artistItemsPage = (ArtistItemsPage) obj;
        return Intrinsics.areEqual(this.title, artistItemsPage.title) && this.items.equals(artistItemsPage.items) && Intrinsics.areEqual(this.continuation, artistItemsPage.continuation);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.items);
        String str = this.continuation;
        return iM + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ArtistItemsPage(title=");
        sb.append(this.title);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(", continuation=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.continuation, ")");
    }
}
