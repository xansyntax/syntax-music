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
import com.metrolist.innertube.models.DefaultServiceEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicCarouselShelfRenderer;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicShelfRenderer;
import com.metrolist.innertube.models.MusicShelfRendererKt;
import com.metrolist.innertube.models.MusicTwoRowItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SectionListRenderer;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistPage {
    public final ArtistItem artist;
    public final String description;
    public final List descriptionRuns;
    public final boolean isSubscribed;
    public final String monthlyListenerCount;
    public final List sections;
    public final String subscriberCountText;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:108:0x0120  */
        /* JADX WARN: Code duplicated, block: B:119:0x013a  */
        /* JADX WARN: Code duplicated, block: B:121:0x013e  */
        /* JADX WARN: Code duplicated, block: B:134:0x0162 A[PHI: r4
          0x0162: PHI (r4v8 java.lang.Integer) = (r4v7 java.lang.Integer), (r4v17 java.lang.Integer) binds: [B:118:0x0138, B:133:0x015e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:138:0x016d  */
        /* JADX WARN: Code duplicated, block: B:143:0x0179  */
        /* JADX WARN: Code duplicated, block: B:146:0x0183  */
        /* JADX WARN: Code duplicated, block: B:148:0x018e  */
        /* JADX WARN: Code duplicated, block: B:151:0x0195  */
        /* JADX WARN: Code duplicated, block: B:157:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:160:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:162:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:179:0x019f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:66:0x00c0 A[PHI: r7
          0x00c0: PHI (r7v26 java.lang.String) = (r7v3 java.lang.String), (r7v5 java.lang.String), (r7v9 java.lang.String), (r7v29 java.lang.String) binds: [B:73:0x00ce, B:87:0x00ea, B:104:0x0114, B:64:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
        public static SongItem fromMusicResponsiveListItemRenderer(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            Album album;
            Integer numM1883parseTime;
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
            Integer num;
            String musicVideoType;
            ThumbnailRenderer thumbnailRenderer;
            String thumbnailUrl;
            List list3;
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
            List list4;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            List list5;
            Run run3;
            String str5;
            Menu.MenuRenderer menuRenderer;
            Object next2;
            Run run4;
            String str6;
            Run run5;
            String str7;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            List list6;
            Run run6;
            BrowseEndpoint browseEndpoint;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer5;
            Runs runs5;
            List list7 = musicResponsiveListItemRenderer.flexColumns;
            MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list7);
            WatchEndpoint watchEndpoint4 = null;
            List list8 = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer5 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs5 = musicResponsiveListItemFlexColumnRenderer5.text) == null) ? null : runs5.runs;
            ArrayList arrayListSplitBySeparator = list8 != null ? CharsKt.splitBySeparator(list8) : null;
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(list8);
            MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.lastOrNull(list7);
            if (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null || (list6 = runs4.runs) == null || (run6 = (Run) CollectionsKt.firstOrNull(list6)) == null) {
                album = null;
            } else {
                NavigationEndpoint navigationEndpoint4 = run6.navigationEndpoint;
                album = ((navigationEndpoint4 == null || (browseEndpoint = navigationEndpoint4.browseEndpoint) == null) ? null : browseEndpoint.browseId) != null ? new Album(run6.text, navigationEndpoint4.browseEndpoint.browseId) : null;
            }
            if (arrayListSplitBySeparator != null) {
                Iterator it2 = CollectionsKt.drop(arrayListSplitBySeparator, 1).iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    run5 = (Run) CollectionsKt.firstOrNull((List) next2);
                } while (((run5 == null || (str7 = run5.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str7)) == null);
                List list9 = (List) next2;
                if (list9 == null || (run4 = (Run) CollectionsKt.firstOrNull(list9)) == null || (str6 = run4.text) == null) {
                    numM1883parseTime = null;
                } else {
                    numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str6);
                }
            } else {
                numM1883parseTime = null;
            }
            Set set = PageHelper.LIBRARY_ADD_ICONS;
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
                        if (numM1883parseTime != null) {
                            num = numM1883parseTime;
                        } else {
                            list4 = musicResponsiveListItemRenderer.fixedColumns;
                            if (list4 != null || (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list4)) == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null || (list5 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list5)) == null || (str5 = run3.text) == null) {
                                num = null;
                            } else {
                                numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str5);
                                num = numM1883parseTime;
                            }
                        }
                        musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                        if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                            list3 = musicResponsiveListItemRenderer.badges;
                            if (list3 != null) {
                                it = list3.iterator();
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
                            return new SongItem(str2, str3, arrayListExtractArtists, album, num, musicVideoType, null, null, thumbnailUrl, z, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 116928);
                        }
                    }
                } else {
                    str = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint2.watchEndpoint) == null) ? null : watchEndpoint2.videoId;
                    if (str != null) {
                        str2 = str;
                        flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                        if (flexColumn != null) {
                            if (numM1883parseTime != null) {
                                num = numM1883parseTime;
                            } else {
                                list4 = musicResponsiveListItemRenderer.fixedColumns;
                                if (list4 != null) {
                                }
                                num = null;
                            }
                            musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                            thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                            if (thumbnailRenderer != null) {
                                list3 = musicResponsiveListItemRenderer.badges;
                                if (list3 != null) {
                                    it = list3.iterator();
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
                                return new SongItem(str2, str3, arrayListExtractArtists, album, num, musicVideoType, null, null, thumbnailUrl, z2, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 116928);
                            }
                        }
                    } else {
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn5 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                        str = (flexColumn5 == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn5.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (navigationEndpoint = run.navigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) ? null : watchEndpoint.videoId;
                        if (str != null) {
                            str2 = str;
                            flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                            if (flexColumn != null) {
                                if (numM1883parseTime != null) {
                                    num = numM1883parseTime;
                                } else {
                                    list4 = musicResponsiveListItemRenderer.fixedColumns;
                                    if (list4 != null) {
                                    }
                                    num = null;
                                }
                                musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                                thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                                if (thumbnailRenderer != null) {
                                    list3 = musicResponsiveListItemRenderer.badges;
                                    if (list3 != null) {
                                        it = list3.iterator();
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
                                    return new SongItem(str2, str3, arrayListExtractArtists, album, num, musicVideoType, null, null, thumbnailUrl, z3, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 116928);
                                }
                            }
                        }
                    }
                }
            } else {
                str2 = str;
                flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                if (flexColumn != null) {
                    if (numM1883parseTime != null) {
                        num = numM1883parseTime;
                    } else {
                        list4 = musicResponsiveListItemRenderer.fixedColumns;
                        if (list4 != null) {
                        }
                        num = null;
                    }
                    musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                    thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                    if (thumbnailRenderer != null) {
                        list3 = musicResponsiveListItemRenderer.badges;
                        if (list3 != null) {
                            it = list3.iterator();
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
                        return new SongItem(str2, str3, arrayListExtractArtists, album, num, musicVideoType, null, null, thumbnailUrl, z4, watchEndpoint4, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 116928);
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:311:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:457:0x055e  */
        /* JADX WARN: Code duplicated, block: B:462:0x0577  */
        /* JADX WARN: Code duplicated, block: B:464:0x057b  */
        /* JADX WARN: Code duplicated, block: B:465:0x0582  */
        /* JADX WARN: Code duplicated, block: B:86:0x0110  */
        /* JADX WARN: Code duplicated, block: B:89:0x011c  */
        public static ArtistSection fromSectionListRendererContent(SectionListRenderer.Content content) {
            MusicCarouselShelfRenderer.Header header;
            MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
            Runs runs;
            List list;
            Run run;
            String str;
            Button.ButtonRenderer buttonRenderer;
            NavigationEndpoint navigationEndpoint;
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
            Object objFromMusicResponsiveListItemRenderer;
            BrowseEndpoint browseEndpoint;
            String str2;
            List list2;
            Run run2;
            String str3;
            WatchEndpoint watchEndpoint;
            Menu.MenuRenderer menuRenderer;
            List list3;
            Object next;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
            NavigationEndpoint navigationEndpoint2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
            Icon icon;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint3;
            List list4;
            Run run3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer2;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer2;
            NavigationEndpoint navigationEndpoint4;
            WatchEndpoint watchEndpoint2;
            String str4;
            List list5;
            Run run4;
            String str5;
            List list6;
            Run run5;
            String str6;
            List list7;
            Run run6;
            String str7;
            String thumbnailUrl;
            String str8;
            Menu.MenuRenderer menuRenderer2;
            List list8;
            Object next2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
            NavigationEndpoint navigationEndpoint5;
            WatchEndpoint watchEndpoint3;
            Object next3;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
            NavigationEndpoint navigationEndpoint6;
            WatchEndpoint watchEndpoint4;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
            Icon icon2;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
            Icon icon3;
            Menu.MenuRenderer menuRenderer3;
            List list9;
            Object next4;
            Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer;
            DefaultServiceEndpoint defaultServiceEndpoint;
            DefaultServiceEndpoint.SubscribeEndpoint subscribeEndpoint;
            List list10;
            Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer2;
            Icon icon4;
            String str9;
            Run run7;
            String str10;
            Artist artist;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer3;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content4;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer3;
            NavigationEndpoint navigationEndpoint7;
            WatchEndpoint watchEndpoint5;
            Menu.MenuRenderer menuRenderer4;
            List list11;
            Object next5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer7;
            NavigationEndpoint navigationEndpoint8;
            WatchEndpoint watchEndpoint6;
            Object next6;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer8;
            NavigationEndpoint navigationEndpoint9;
            WatchEndpoint watchEndpoint7;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer9;
            Icon icon5;
            Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer10;
            Icon icon6;
            List list12;
            Run run8;
            String str11;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer4;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content5;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer4;
            NavigationEndpoint navigationEndpoint10;
            String str12;
            List list13;
            Run run9;
            String str13;
            Badges badges;
            Object next7;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            Icon icon7;
            List list14;
            Run run10;
            String str14;
            String str15;
            List list15;
            Run run11;
            String str16;
            Integer numM1883parseTime;
            Badges badges2;
            Object next8;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2;
            Icon icon8;
            Run run12;
            String str17;
            String str18;
            List list16;
            Run run13;
            NavigationEndpoint navigationEndpoint11;
            List list17;
            Run run14;
            content.getClass();
            MusicShelfRenderer musicShelfRenderer = content.musicShelfRenderer;
            BrowseEndpoint browseEndpoint2 = null;
            if (musicShelfRenderer != null) {
                Runs runs2 = musicShelfRenderer.title;
                if (runs2 == null || (list17 = runs2.runs) == null || (run14 = (Run) CollectionsKt.firstOrNull(list17)) == null || (str18 = run14.text) == null) {
                    str18 = "";
                }
                List list18 = musicShelfRenderer.contents;
                if (list18 != null) {
                    ArrayList items = MusicShelfRendererKt.getItems(list18);
                    ArrayList arrayList = new ArrayList();
                    int size = items.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = items.get(i);
                        i++;
                        SongItem songItemFromMusicResponsiveListItemRenderer = fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj);
                        if (songItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList.add(songItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        if (runs2 != null && (list16 = runs2.runs) != null && (run13 = (Run) CollectionsKt.firstOrNull(list16)) != null && (navigationEndpoint11 = run13.navigationEndpoint) != null) {
                            browseEndpoint2 = navigationEndpoint11.browseEndpoint;
                        }
                        return new ArtistSection(str18, arrayList, browseEndpoint2);
                    }
                }
            } else {
                MusicCarouselShelfRenderer musicCarouselShelfRenderer = content.musicCarouselShelfRenderer;
                if (musicCarouselShelfRenderer != null && (header = musicCarouselShelfRenderer.header) != null && (musicCarouselShelfBasicHeaderRenderer = header.musicCarouselShelfBasicHeaderRenderer) != null && (runs = musicCarouselShelfBasicHeaderRenderer.title) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str = run.text) != null) {
                    List<MusicCarouselShelfRenderer.Content> list19 = musicCarouselShelfRenderer.contents;
                    ArrayList arrayList2 = new ArrayList();
                    for (MusicCarouselShelfRenderer.Content content6 : list19) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = content6.musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            boolean zIsSong = musicTwoRowItemRenderer.isSong();
                            List list20 = musicTwoRowItemRenderer.subtitleBadges;
                            MusicResponsiveListItemRenderer.Overlay overlay = musicTwoRowItemRenderer.thumbnailOverlay;
                            NavigationEndpoint navigationEndpoint12 = musicTwoRowItemRenderer.navigationEndpoint;
                            Menu menu = musicTwoRowItemRenderer.menu;
                            ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer.thumbnailRenderer;
                            Runs runs3 = musicTwoRowItemRenderer.title;
                            Runs runs4 = musicTwoRowItemRenderer.subtitle;
                            if (zIsSong) {
                                List list21 = runs4 != null ? runs4.runs : null;
                                ArrayList arrayListSplitBySeparator = CharsKt.splitBySeparator(list21 == null ? EmptyList.INSTANCE : list21);
                                WatchEndpoint watchEndpoint8 = navigationEndpoint12.watchEndpoint;
                                if (watchEndpoint8 == null || (str15 = watchEndpoint8.videoId) == null || (list15 = runs3.runs) == null || (run11 = (Run) CollectionsKt.firstOrNull(list15)) == null || (str16 = run11.text) == null) {
                                    objFromMusicResponsiveListItemRenderer = null;
                                } else {
                                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(list21);
                                    List list22 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator);
                                    if (list22 == null || (run12 = (Run) CollectionsKt.firstOrNull(list22)) == null) {
                                        numM1883parseTime = null;
                                    } else {
                                        if (run12.navigationEndpoint != null) {
                                            run12 = null;
                                        }
                                        if (run12 == null || (str17 = run12.text) == null) {
                                            numM1883parseTime = null;
                                        } else {
                                            numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str17);
                                        }
                                    }
                                    String musicVideoType = musicTwoRowItemRenderer.getMusicVideoType();
                                    String thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                                    if (thumbnailUrl2 == null) {
                                        objFromMusicResponsiveListItemRenderer = null;
                                    } else {
                                        if (list20 != null) {
                                            Iterator it = list20.iterator();
                                            do {
                                                if (!it.hasNext()) {
                                                    next8 = null;
                                                    break;
                                                }
                                                next8 = it.next();
                                                musicInlineBadgeRenderer2 = ((Badges) next8).musicInlineBadgeRenderer;
                                            } while (!Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon8 = musicInlineBadgeRenderer2.icon) == null) ? null : icon8.iconType, "MUSIC_EXPLICIT_BADGE"));
                                            badges2 = (Badges) next8;
                                        } else {
                                            badges2 = null;
                                        }
                                        objFromMusicResponsiveListItemRenderer = new SongItem(str15, str16, arrayListExtractArtists, null, numM1883parseTime, musicVideoType, null, null, thumbnailUrl2, badges2 != null, null, null, null, null, null, false, null, 130240);
                                    }
                                }
                            } else if (musicTwoRowItemRenderer.isAlbum()) {
                                BrowseEndpoint browseEndpoint3 = navigationEndpoint12.browseEndpoint;
                                if (browseEndpoint3 == null || (str11 = browseEndpoint3.browseId) == null || overlay == null || (musicItemThumbnailOverlayRenderer4 = overlay.musicItemThumbnailOverlayRenderer) == null || (content5 = musicItemThumbnailOverlayRenderer4.content) == null || (musicPlayButtonRenderer4 = content5.musicPlayButtonRenderer) == null || (navigationEndpoint10 = musicPlayButtonRenderer4.playNavigationEndpoint) == null) {
                                    objFromMusicResponsiveListItemRenderer = null;
                                } else {
                                    WatchEndpoint watchEndpoint9 = navigationEndpoint10.watchEndpoint;
                                    if (watchEndpoint9 == null) {
                                        watchEndpoint9 = navigationEndpoint10.watchPlaylistEndpoint;
                                    }
                                    if (watchEndpoint9 == null || (str12 = watchEndpoint9.playlistId) == null || (list13 = runs3.runs) == null || (run9 = (Run) CollectionsKt.firstOrNull(list13)) == null || (str13 = run9.text) == null) {
                                        objFromMusicResponsiveListItemRenderer = null;
                                    } else {
                                        Integer intOrNull = (runs4 == null || (list14 = runs4.runs) == null || (run10 = (Run) CollectionsKt.lastOrNull(list14)) == null || (str14 = run10.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str14);
                                        String thumbnailUrl3 = thumbnailRenderer.getThumbnailUrl();
                                        if (thumbnailUrl3 == null) {
                                            objFromMusicResponsiveListItemRenderer = null;
                                        } else {
                                            if (list20 != null) {
                                                Iterator it2 = list20.iterator();
                                                do {
                                                    if (!it2.hasNext()) {
                                                        next7 = null;
                                                        break;
                                                    }
                                                    next7 = it2.next();
                                                    musicInlineBadgeRenderer = ((Badges) next7).musicInlineBadgeRenderer;
                                                } while (!Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon7 = musicInlineBadgeRenderer.icon) == null) ? null : icon7.iconType, "MUSIC_EXPLICIT_BADGE"));
                                                badges = (Badges) next7;
                                            } else {
                                                badges = null;
                                            }
                                            objFromMusicResponsiveListItemRenderer = new AlbumItem(str11, str12, str13, (List) null, intOrNull, thumbnailUrl3, badges != null, 4);
                                        }
                                    }
                                }
                            } else if (musicTwoRowItemRenderer.isPlaylist()) {
                                BrowseEndpoint browseEndpoint4 = navigationEndpoint12.browseEndpoint;
                                if (browseEndpoint4 == null || (str9 = browseEndpoint4.browseId) == null) {
                                    objFromMusicResponsiveListItemRenderer = null;
                                } else {
                                    String strRemovePrefix = StringsKt.removePrefix(str9, "VL");
                                    List list23 = runs3.runs;
                                    if (list23 == null || (run7 = (Run) CollectionsKt.firstOrNull(list23)) == null || (str10 = run7.text) == null) {
                                        objFromMusicResponsiveListItemRenderer = null;
                                    } else {
                                        List list24 = runs4 != null ? runs4.runs : null;
                                        Artist artist2 = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list24));
                                        if (artist2 != null) {
                                            artist = artist2;
                                        } else {
                                            if (list24 != null && (list12 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list24))) != null && (run8 = (Run) CollectionsKt.firstOrNull(list12)) != null) {
                                                if (run8.navigationEndpoint != null || StringsKt.isBlank(run8.text)) {
                                                    run8 = null;
                                                }
                                                if (run8 != null) {
                                                    artist2 = new Artist(StringsKt.trim(run8.text).toString(), null);
                                                    artist = artist2;
                                                }
                                            }
                                            artist = null;
                                        }
                                        String thumbnailUrl4 = thumbnailRenderer.getThumbnailUrl();
                                        if (thumbnailUrl4 == null || overlay == null || (musicItemThumbnailOverlayRenderer3 = overlay.musicItemThumbnailOverlayRenderer) == null || (content4 = musicItemThumbnailOverlayRenderer3.content) == null || (musicPlayButtonRenderer3 = content4.musicPlayButtonRenderer) == null || (navigationEndpoint7 = musicPlayButtonRenderer3.playNavigationEndpoint) == null || (watchEndpoint5 = navigationEndpoint7.watchPlaylistEndpoint) == null || menu == null || (menuRenderer4 = menu.menuRenderer) == null || (list11 = menuRenderer4.items) == null) {
                                            objFromMusicResponsiveListItemRenderer = null;
                                        } else {
                                            Iterator it3 = list11.iterator();
                                            do {
                                                if (!it3.hasNext()) {
                                                    next5 = null;
                                                    break;
                                                }
                                                next5 = it3.next();
                                                menuNavigationItemRenderer10 = ((Menu.MenuRenderer.Item) next5).menuNavigationItemRenderer;
                                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer10 == null || (icon6 = menuNavigationItemRenderer10.icon) == null) ? null : icon6.iconType, "MUSIC_SHUFFLE"));
                                            Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next5;
                                            if (item == null || (menuNavigationItemRenderer7 = item.menuNavigationItemRenderer) == null || (navigationEndpoint8 = menuNavigationItemRenderer7.navigationEndpoint) == null || (watchEndpoint6 = navigationEndpoint8.watchPlaylistEndpoint) == null) {
                                                objFromMusicResponsiveListItemRenderer = null;
                                            } else {
                                                Iterator it4 = list11.iterator();
                                                do {
                                                    if (!it4.hasNext()) {
                                                        next6 = null;
                                                        break;
                                                    }
                                                    next6 = it4.next();
                                                    menuNavigationItemRenderer9 = ((Menu.MenuRenderer.Item) next6).menuNavigationItemRenderer;
                                                } while (!Intrinsics.areEqual((menuNavigationItemRenderer9 == null || (icon5 = menuNavigationItemRenderer9.icon) == null) ? null : icon5.iconType, "MIX"));
                                                Menu.MenuRenderer.Item item2 = (Menu.MenuRenderer.Item) next6;
                                                if (item2 == null || (menuNavigationItemRenderer8 = item2.menuNavigationItemRenderer) == null || (navigationEndpoint9 = menuNavigationItemRenderer8.navigationEndpoint) == null || (watchEndpoint7 = navigationEndpoint9.watchPlaylistEndpoint) == null) {
                                                    objFromMusicResponsiveListItemRenderer = null;
                                                } else {
                                                    objFromMusicResponsiveListItemRenderer = new PlaylistItem(strRemovePrefix, str10, artist, (String) null, thumbnailUrl4, watchEndpoint5, watchEndpoint6, watchEndpoint7, false, (String) null, (String) null, 3840);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (musicTwoRowItemRenderer.isArtist()) {
                                BrowseEndpoint browseEndpoint5 = navigationEndpoint12.browseEndpoint;
                                if (browseEndpoint5 == null || (str6 = browseEndpoint5.browseId) == null || (list7 = runs3.runs) == null || (run6 = (Run) CollectionsKt.lastOrNull(list7)) == null || (str7 = run6.text) == null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                                    objFromMusicResponsiveListItemRenderer = null;
                                } else {
                                    if (menu == null || (menuRenderer3 = menu.menuRenderer) == null || (list9 = menuRenderer3.items) == null) {
                                        str8 = null;
                                    } else {
                                        Iterator it5 = list9.iterator();
                                        do {
                                            if (!it5.hasNext()) {
                                                next4 = null;
                                                break;
                                            }
                                            next4 = it5.next();
                                            toggleMenuServiceRenderer2 = ((Menu.MenuRenderer.Item) next4).toggleMenuServiceItemRenderer;
                                        } while (!Intrinsics.areEqual((toggleMenuServiceRenderer2 == null || (icon4 = toggleMenuServiceRenderer2.defaultIcon) == null) ? null : icon4.iconType, "SUBSCRIBE"));
                                        Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) next4;
                                        if (item3 == null || (toggleMenuServiceRenderer = item3.toggleMenuServiceItemRenderer) == null || (defaultServiceEndpoint = toggleMenuServiceRenderer.defaultServiceEndpoint) == null || (subscribeEndpoint = defaultServiceEndpoint.subscribeEndpoint) == null || (list10 = subscribeEndpoint.channelIds) == null) {
                                            str8 = null;
                                        } else {
                                            str8 = (String) CollectionsKt.firstOrNull(list10);
                                        }
                                    }
                                    if (menu == null || (menuRenderer2 = menu.menuRenderer) == null || (list8 = menuRenderer2.items) == null) {
                                        objFromMusicResponsiveListItemRenderer = null;
                                    } else {
                                        Iterator it6 = list8.iterator();
                                        do {
                                            if (!it6.hasNext()) {
                                                next2 = null;
                                                break;
                                            }
                                            next2 = it6.next();
                                            menuNavigationItemRenderer6 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer6 == null || (icon3 = menuNavigationItemRenderer6.icon) == null) ? null : icon3.iconType, "MUSIC_SHUFFLE"));
                                        Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next2;
                                        if (item4 == null || (menuNavigationItemRenderer3 = item4.menuNavigationItemRenderer) == null || (navigationEndpoint5 = menuNavigationItemRenderer3.navigationEndpoint) == null || (watchEndpoint3 = navigationEndpoint5.watchPlaylistEndpoint) == null) {
                                            objFromMusicResponsiveListItemRenderer = null;
                                        } else {
                                            Iterator it7 = list8.iterator();
                                            do {
                                                if (!it7.hasNext()) {
                                                    next3 = null;
                                                    break;
                                                }
                                                next3 = it7.next();
                                                menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) next3).menuNavigationItemRenderer;
                                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon2 = menuNavigationItemRenderer5.icon) == null) ? null : icon2.iconType, "MIX"));
                                            Menu.MenuRenderer.Item item5 = (Menu.MenuRenderer.Item) next3;
                                            if (item5 == null || (menuNavigationItemRenderer4 = item5.menuNavigationItemRenderer) == null || (navigationEndpoint6 = menuNavigationItemRenderer4.navigationEndpoint) == null || (watchEndpoint4 = navigationEndpoint6.watchPlaylistEndpoint) == null) {
                                                objFromMusicResponsiveListItemRenderer = null;
                                            } else {
                                                objFromMusicResponsiveListItemRenderer = new ArtistItem(str6, str7, thumbnailUrl, str8, (WatchEndpoint) null, watchEndpoint3, watchEndpoint4, 144);
                                            }
                                        }
                                    }
                                }
                            } else if (musicTwoRowItemRenderer.isEpisode()) {
                                if (overlay == null || (musicItemThumbnailOverlayRenderer2 = overlay.musicItemThumbnailOverlayRenderer) == null || (content3 = musicItemThumbnailOverlayRenderer2.content) == null || (musicPlayButtonRenderer2 = content3.musicPlayButtonRenderer) == null || (navigationEndpoint4 = musicPlayButtonRenderer2.playNavigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint4.watchEndpoint) == null || (str4 = watchEndpoint2.videoId) == null || (list5 = runs3.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list5)) == null || (str5 = run4.text) == null) {
                                    objFromMusicResponsiveListItemRenderer = null;
                                } else {
                                    Artist artist3 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs4 != null ? runs4.runs : null));
                                    String thumbnailUrl5 = thumbnailRenderer.getThumbnailUrl();
                                    if (thumbnailUrl5 == null) {
                                        objFromMusicResponsiveListItemRenderer = null;
                                    } else {
                                        objFromMusicResponsiveListItemRenderer = new EpisodeItem(str4, str5, artist3, null, null, (runs4 == null || (list6 = runs4.runs) == null || (run5 = (Run) CollectionsKt.lastOrNull(list6)) == null) ? null : run5.text, thumbnailUrl5, false, new WatchEndpoint(62, str4, null, null), null, null, 7832);
                                    }
                                }
                            } else if (!musicTwoRowItemRenderer.isPodcast() || (browseEndpoint = navigationEndpoint12.browseEndpoint) == null || (str2 = browseEndpoint.browseId) == null || (list2 = runs3.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null || (str3 = run2.text) == null) {
                                objFromMusicResponsiveListItemRenderer = null;
                            } else {
                                Artist artist4 = (Artist) CollectionsKt.firstOrNull(PodcastPage.Companion.extractPodcastByline(runs4 != null ? runs4.runs : null));
                                String str19 = (runs4 == null || (list4 = runs4.runs) == null || (run3 = (Run) CollectionsKt.lastOrNull(list4)) == null) ? null : run3.text;
                                String thumbnailUrl6 = thumbnailRenderer.getThumbnailUrl();
                                WatchEndpoint watchEndpoint10 = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content2 = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content2.musicPlayButtonRenderer) == null || (navigationEndpoint3 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint3.watchPlaylistEndpoint;
                                if (menu == null || (menuRenderer = menu.menuRenderer) == null || (list3 = menuRenderer.items) == null) {
                                    watchEndpoint = null;
                                } else {
                                    Iterator it8 = list3.iterator();
                                    do {
                                        if (!it8.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it8.next();
                                        menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                                    } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon = menuNavigationItemRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_SHUFFLE"));
                                    Menu.MenuRenderer.Item item6 = (Menu.MenuRenderer.Item) next;
                                    if (item6 == null || (menuNavigationItemRenderer = item6.menuNavigationItemRenderer) == null || (navigationEndpoint2 = menuNavigationItemRenderer.navigationEndpoint) == null) {
                                        watchEndpoint = null;
                                    } else {
                                        watchEndpoint = navigationEndpoint2.watchPlaylistEndpoint;
                                    }
                                }
                                objFromMusicResponsiveListItemRenderer = new PodcastItem(str2, str3, artist4, str19, thumbnailUrl6, watchEndpoint10, watchEndpoint, null, null, null, 896);
                            }
                            if (objFromMusicResponsiveListItemRenderer == null) {
                                musicResponsiveListItemRenderer = content6.musicResponsiveListItemRenderer;
                                if (musicResponsiveListItemRenderer != null) {
                                    objFromMusicResponsiveListItemRenderer = fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer);
                                } else {
                                    objFromMusicResponsiveListItemRenderer = null;
                                }
                            }
                        } else {
                            musicResponsiveListItemRenderer = content6.musicResponsiveListItemRenderer;
                            if (musicResponsiveListItemRenderer != null) {
                                objFromMusicResponsiveListItemRenderer = fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer);
                            } else {
                                objFromMusicResponsiveListItemRenderer = null;
                            }
                        }
                        Object obj2 = objFromMusicResponsiveListItemRenderer;
                        if (obj2 != null) {
                            arrayList2.add(obj2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        arrayList2 = null;
                    }
                    if (arrayList2 != null) {
                        Button button = header.musicCarouselShelfBasicHeaderRenderer.moreContentButton;
                        if (button != null && (buttonRenderer = button.buttonRenderer) != null && (navigationEndpoint = buttonRenderer.navigationEndpoint) != null) {
                            browseEndpoint2 = navigationEndpoint.browseEndpoint;
                        }
                        return new ArtistSection(str, arrayList2, browseEndpoint2);
                    }
                }
            }
            return null;
        }
    }

    public ArtistPage(ArtistItem artistItem, List list, String str, String str2, String str3, List list2, boolean z) {
        this.artist = artistItem;
        this.sections = list;
        this.description = str;
        this.subscriberCountText = str2;
        this.monthlyListenerCount = str3;
        this.descriptionRuns = list2;
        this.isSubscribed = z;
    }

    public static ArtistPage copy$default(ArtistPage artistPage, List list) {
        ArtistItem artistItem = artistPage.artist;
        String str = artistPage.description;
        String str2 = artistPage.subscriberCountText;
        String str3 = artistPage.monthlyListenerCount;
        List list2 = artistPage.descriptionRuns;
        boolean z = artistPage.isSubscribed;
        artistPage.getClass();
        list.getClass();
        return new ArtistPage(artistItem, list, str, str2, str3, list2, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistPage)) {
            return false;
        }
        ArtistPage artistPage = (ArtistPage) obj;
        return this.artist.equals(artistPage.artist) && this.sections.equals(artistPage.sections) && Intrinsics.areEqual(this.description, artistPage.description) && Intrinsics.areEqual(this.subscriberCountText, artistPage.subscriberCountText) && Intrinsics.areEqual(this.monthlyListenerCount, artistPage.monthlyListenerCount) && Intrinsics.areEqual(this.descriptionRuns, artistPage.descriptionRuns) && this.isSubscribed == artistPage.isSubscribed;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.artist.hashCode() * 31, 31, this.sections);
        String str = this.description;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subscriberCountText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.monthlyListenerCount;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List list = this.descriptionRuns;
        return Boolean.hashCode(this.isSubscribed) + ((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ArtistPage(artist=");
        sb.append(this.artist);
        sb.append(", sections=");
        sb.append(this.sections);
        sb.append(", description=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.description, ", subscriberCountText=", this.subscriberCountText, ", monthlyListenerCount=");
        sb.append(this.monthlyListenerCount);
        sb.append(", descriptionRuns=");
        sb.append(this.descriptionRuns);
        sb.append(", isSubscribed=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.isSubscribed, ")");
    }
}
