package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
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
public final class AlbumPage {
    public final AlbumItem album;
    public final List otherVersions;
    public final List songs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:106:0x012e  */
        /* JADX WARN: Code duplicated, block: B:110:0x0136  */
        /* JADX WARN: Code duplicated, block: B:112:0x0141  */
        /* JADX WARN: Code duplicated, block: B:114:0x014a  */
        /* JADX WARN: Code duplicated, block: B:129:0x0176  */
        /* JADX WARN: Code duplicated, block: B:133:0x017f  */
        /* JADX WARN: Code duplicated, block: B:149:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:153:0x01b7 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:154:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:155:0x01bd  */
        /* JADX WARN: Code duplicated, block: B:159:0x01c6  */
        /* JADX WARN: Code duplicated, block: B:162:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:164:0x01db  */
        /* JADX WARN: Code duplicated, block: B:167:0x01e2  */
        /* JADX WARN: Code duplicated, block: B:173:0x01f0  */
        /* JADX WARN: Code duplicated, block: B:174:0x01f3  */
        /* JADX WARN: Code duplicated, block: B:184:0x01eb A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:185:? A[LOOP:1: B:160:0x01ca->B:185:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:47:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:63:0x00c6 A[PHI: r6
          0x00c6: PHI (r6v32 java.lang.String) = (r6v8 java.lang.String), (r6v11 java.lang.String), (r6v15 java.lang.String), (r6v41 java.lang.String) binds: [B:70:0x00d4, B:85:0x00f2, B:102:0x011c, B:61:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9, types: [java.util.ArrayList] */
        public static SongItem getSong(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, AlbumItem albumItem) {
            ?? r14;
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
            Run run2;
            String str3;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            Album album;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
            Runs runs2;
            List list2;
            Run run3;
            BrowseEndpoint browseEndpoint;
            Album album2;
            List list3;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            List list4;
            Run run4;
            String str4;
            Integer numM1883parseTime;
            ThumbnailRenderer thumbnailRenderer;
            String thumbnailUrl;
            List list5;
            boolean z;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            String str5;
            Icon icon;
            String str6;
            List list6;
            String str7;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            Menu.MenuRenderer menuRenderer;
            musicResponsiveListItemRenderer.getClass();
            List list7 = musicResponsiveListItemRenderer.flexColumns;
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = musicResponsiveListItemRenderer.menu;
            Object obj = null;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list7);
            List list8 = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null) ? null : runs4.runs;
            ?? ExtractArtists = PageHelper.extractArtists(list8);
            boolean zIsEmpty = ExtractArtists.isEmpty();
            List list9 = EmptyList.INSTANCE;
            if (zIsEmpty) {
                if ((albumItem == null || (str7 = albumItem.playlistId) == null || !StringsKt__StringsJVMKt.startsWith(str7, "OLAK", false)) && (albumItem == null || (str6 = albumItem.browseId) == null || !StringsKt__StringsJVMKt.startsWith(str6, "FEmusic_library_privately_owned_release_detail", false))) {
                    ExtractArtists = list9;
                } else {
                    if (list8 == null || (list6 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list8))) == null) {
                        ExtractArtists = 0;
                    } else {
                        ArrayList arrayListOddElements = CharsKt.oddElements(list6);
                        ExtractArtists = new ArrayList();
                        int size = arrayListOddElements.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayListOddElements.get(i);
                            i++;
                            Run run5 = (Run) obj2;
                            String string = StringsKt.trim(run5.text).toString();
                            if (string.length() <= 0 || run5.navigationEndpoint != null) {
                                string = null;
                            }
                            Artist artist = string != null ? new Artist(string, null) : null;
                            if (artist != null) {
                                ExtractArtists.add(artist);
                            }
                        }
                    }
                    if (ExtractArtists == 0) {
                        ExtractArtists = list9;
                    }
                }
            }
            if (ExtractArtists.isEmpty()) {
                List list10 = albumItem != null ? albumItem.artists : null;
                if (list10 != null) {
                    list9 = list10;
                }
                r14 = list9;
            } else {
                r14 = ExtractArtists;
            }
            MusicResponsiveListItemRenderer.PlaylistItemData playlistItemData = musicResponsiveListItemRenderer.playlistItemData;
            if (playlistItemData == null || (str = playlistItemData.videoId) == null) {
                NavigationEndpoint navigationEndpoint3 = musicResponsiveListItemRenderer.navigationEndpoint;
                str = (navigationEndpoint3 == null || (watchEndpoint3 = navigationEndpoint3.watchEndpoint) == null) ? null : watchEndpoint3.videoId;
                if (str != null) {
                    str2 = str;
                    run2 = (Run) CollectionsKt.firstOrNull((List) PageHelper.extractRuns("MUSIC_VIDEO", list7));
                    if (run2 != null && (str3 = run2.text) != null) {
                        if (albumItem != null) {
                            album = new Album(albumItem.title, albumItem.browseId);
                        } else {
                            flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list7);
                            if (flexColumn != null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list2 = runs2.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list2)) == null) {
                                album = null;
                            } else {
                                String str8 = run3.text;
                                NavigationEndpoint navigationEndpoint4 = run3.navigationEndpoint;
                                String str9 = (navigationEndpoint4 == null || (browseEndpoint = navigationEndpoint4.browseEndpoint) == null) ? null : browseEndpoint.browseId;
                                str9.getClass();
                                album = new Album(str8, str9);
                            }
                            album.getClass();
                        }
                        album2 = album;
                        list3 = musicResponsiveListItemRenderer.fixedColumns;
                        if (list3 != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list3)) != null && (musicResponsiveListItemFlexColumnRenderer3 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) != null && (list4 = runs3.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str4 = run4.text) != null && (numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str4)) != null) {
                            String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                            thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                            if (thumbnailRenderer != null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                                if (albumItem != null) {
                                    thumbnailUrl = albumItem.thumbnail;
                                } else {
                                    thumbnailUrl = null;
                                }
                                thumbnailUrl.getClass();
                            }
                            String str10 = thumbnailUrl;
                            list5 = musicResponsiveListItemRenderer.badges;
                            if (list5 != null) {
                                for (Object obj3 : list5) {
                                    musicInlineBadgeRenderer = ((Badges) obj3).musicInlineBadgeRenderer;
                                    if (musicInlineBadgeRenderer != null || (icon = musicInlineBadgeRenderer.icon) == null) {
                                        str5 = null;
                                    } else {
                                        str5 = icon.iconType;
                                    }
                                    if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                        obj = obj3;
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
                            return new SongItem(str2, str3, r14, album2, numM1883parseTime, musicVideoType, null, null, str10, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                        }
                    }
                } else {
                    MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
                    str = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint2.watchEndpoint) == null) ? null : watchEndpoint2.videoId;
                    if (str != null) {
                        str2 = str;
                        run2 = (Run) CollectionsKt.firstOrNull((List) PageHelper.extractRuns("MUSIC_VIDEO", list7));
                        if (run2 != null) {
                            if (albumItem != null) {
                                album = new Album(albumItem.title, albumItem.browseId);
                            } else {
                                flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list7);
                                if (flexColumn != null) {
                                    album = null;
                                } else {
                                    album = null;
                                }
                                album.getClass();
                            }
                            album2 = album;
                            list3 = musicResponsiveListItemRenderer.fixedColumns;
                            if (list3 != null) {
                                String musicVideoType2 = musicResponsiveListItemRenderer.getMusicVideoType();
                                thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                                if (thumbnailRenderer != null) {
                                    if (albumItem != null) {
                                        thumbnailUrl = albumItem.thumbnail;
                                    } else {
                                        thumbnailUrl = null;
                                    }
                                    thumbnailUrl.getClass();
                                } else {
                                    if (albumItem != null) {
                                        thumbnailUrl = albumItem.thumbnail;
                                    } else {
                                        thumbnailUrl = null;
                                    }
                                    thumbnailUrl.getClass();
                                }
                                String str11 = thumbnailUrl;
                                list5 = musicResponsiveListItemRenderer.badges;
                                if (list5 != null) {
                                    while (r0.hasNext()) {
                                        musicInlineBadgeRenderer = ((Badges) obj3).musicInlineBadgeRenderer;
                                        if (musicInlineBadgeRenderer != null) {
                                            str5 = null;
                                        } else {
                                            str5 = null;
                                        }
                                        if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                            obj = obj3;
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
                                return new SongItem(str2, str3, r14, album2, numM1883parseTime, musicVideoType2, null, null, str11, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                            }
                        }
                    } else {
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list7);
                        str = (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (navigationEndpoint = run.navigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) ? null : watchEndpoint.videoId;
                        if (str != null) {
                            str2 = str;
                            run2 = (Run) CollectionsKt.firstOrNull((List) PageHelper.extractRuns("MUSIC_VIDEO", list7));
                            if (run2 != null) {
                                if (albumItem != null) {
                                    album = new Album(albumItem.title, albumItem.browseId);
                                } else {
                                    flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list7);
                                    if (flexColumn != null) {
                                        album = null;
                                    } else {
                                        album = null;
                                    }
                                    album.getClass();
                                }
                                album2 = album;
                                list3 = musicResponsiveListItemRenderer.fixedColumns;
                                if (list3 != null) {
                                    String musicVideoType3 = musicResponsiveListItemRenderer.getMusicVideoType();
                                    thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                                    if (thumbnailRenderer != null) {
                                        if (albumItem != null) {
                                            thumbnailUrl = albumItem.thumbnail;
                                        } else {
                                            thumbnailUrl = null;
                                        }
                                        thumbnailUrl.getClass();
                                    } else {
                                        if (albumItem != null) {
                                            thumbnailUrl = albumItem.thumbnail;
                                        } else {
                                            thumbnailUrl = null;
                                        }
                                        thumbnailUrl.getClass();
                                    }
                                    String str12 = thumbnailUrl;
                                    list5 = musicResponsiveListItemRenderer.badges;
                                    if (list5 != null) {
                                        while (r0.hasNext()) {
                                            musicInlineBadgeRenderer = ((Badges) obj3).musicInlineBadgeRenderer;
                                            if (musicInlineBadgeRenderer != null) {
                                                str5 = null;
                                            } else {
                                                str5 = null;
                                            }
                                            if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                                obj = obj3;
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
                                    return new SongItem(str2, str3, r14, album2, numM1883parseTime, musicVideoType3, null, null, str12, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                                }
                            }
                        }
                    }
                }
            } else {
                str2 = str;
                run2 = (Run) CollectionsKt.firstOrNull((List) PageHelper.extractRuns("MUSIC_VIDEO", list7));
                if (run2 != null) {
                    if (albumItem != null) {
                        album = new Album(albumItem.title, albumItem.browseId);
                    } else {
                        flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list7);
                        if (flexColumn != null) {
                            album = null;
                        } else {
                            album = null;
                        }
                        album.getClass();
                    }
                    album2 = album;
                    list3 = musicResponsiveListItemRenderer.fixedColumns;
                    if (list3 != null) {
                        String musicVideoType4 = musicResponsiveListItemRenderer.getMusicVideoType();
                        thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                        if (thumbnailRenderer != null) {
                            if (albumItem != null) {
                                thumbnailUrl = albumItem.thumbnail;
                            } else {
                                thumbnailUrl = null;
                            }
                            thumbnailUrl.getClass();
                        } else {
                            if (albumItem != null) {
                                thumbnailUrl = albumItem.thumbnail;
                            } else {
                                thumbnailUrl = null;
                            }
                            thumbnailUrl.getClass();
                        }
                        String str13 = thumbnailUrl;
                        list5 = musicResponsiveListItemRenderer.badges;
                        if (list5 != null) {
                            while (r0.hasNext()) {
                                musicInlineBadgeRenderer = ((Badges) obj3).musicInlineBadgeRenderer;
                                if (musicInlineBadgeRenderer != null) {
                                    str5 = null;
                                } else {
                                    str5 = null;
                                }
                                if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                    obj = obj3;
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
                        return new SongItem(str2, str3, r14, album2, numM1883parseTime, musicVideoType4, null, null, str13, z, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                    }
                }
            }
            return null;
        }
    }

    public AlbumPage(AlbumItem albumItem, List list, List list2) {
        albumItem.getClass();
        this.album = albumItem;
        this.songs = list;
        this.otherVersions = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumPage)) {
            return false;
        }
        AlbumPage albumPage = (AlbumPage) obj;
        return Intrinsics.areEqual(this.album, albumPage.album) && this.songs.equals(albumPage.songs) && this.otherVersions.equals(albumPage.otherVersions);
    }

    public final int hashCode() {
        return this.otherVersions.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.album.hashCode() * 31, 31, this.songs);
    }

    public final String toString() {
        return "AlbumPage(album=" + this.album + ", songs=" + this.songs + ", otherVersions=" + this.otherVersions + ")";
    }
}
