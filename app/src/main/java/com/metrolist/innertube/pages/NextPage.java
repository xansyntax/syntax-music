package com.metrolist.innertube.pages;

import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistPanelVideoRenderer;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.Thumbnail;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NextPage {
    /* JADX WARN: Code duplicated, block: B:20:0x0036 A[PHI: r6
      0x0036: PHI (r6v1 java.lang.String) = (r6v0 java.lang.String), (r6v21 java.lang.String) binds: [B:13:0x0028, B:18:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:? A[LOOP:0: B:65:0x00bd->B:85:?, LOOP_END, SYNTHETIC] */
    public static SongItem fromPlaylistPanelVideoRenderer(PlaylistPanelVideoRenderer playlistPanelVideoRenderer) {
        List list;
        String str;
        Runs runs;
        List list2;
        Run run;
        String str2;
        ArrayList arrayListExtractArtists;
        List list3;
        Album album;
        Runs runs2;
        List list4;
        Run run2;
        String str3;
        Integer numM1883parseTime;
        String musicVideoType;
        Thumbnail thumbnail;
        String str4;
        List list5;
        Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
        String str5;
        Icon icon;
        Run run3;
        BrowseEndpoint browseEndpoint;
        Menu.MenuRenderer menuRenderer;
        playlistPanelVideoRenderer.getClass();
        NavigationEndpoint navigationEndpoint = playlistPanelVideoRenderer.navigationEndpoint;
        Runs runs3 = playlistPanelVideoRenderer.longBylineText;
        Object obj = null;
        if (runs3 != null && (list = runs3.runs) != null) {
            ArrayList arrayListSplitBySeparator = CharsKt.splitBySeparator(list);
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = playlistPanelVideoRenderer.menu;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            String str6 = playlistPanelVideoRenderer.videoId;
            if (str6 != null) {
                str = str6;
                runs = playlistPanelVideoRenderer.title;
                if (runs != null && (list2 = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list2)) != null && (str2 = run.text) != null) {
                    arrayListExtractArtists = PageHelper.extractArtists(list);
                    list3 = (List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator);
                    if (list3 != null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                        album = null;
                    } else {
                        NavigationEndpoint navigationEndpoint2 = run3.navigationEndpoint;
                        if ((navigationEndpoint2 != null ? navigationEndpoint2.browseEndpoint : null) == null) {
                            run3 = null;
                        }
                        if (run3 != null) {
                            String str7 = run3.text;
                            NavigationEndpoint navigationEndpoint3 = run3.navigationEndpoint;
                            String str8 = (navigationEndpoint3 == null || (browseEndpoint = navigationEndpoint3.browseEndpoint) == null) ? null : browseEndpoint.browseId;
                            str8.getClass();
                            album = new Album(str7, str8);
                        } else {
                            album = null;
                        }
                    }
                    runs2 = playlistPanelVideoRenderer.lengthText;
                    if (runs2 != null && (list4 = runs2.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str3 = run2.text) != null && (numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str3)) != null) {
                        musicVideoType = navigationEndpoint.getMusicVideoType();
                        thumbnail = (Thumbnail) CollectionsKt.lastOrNull(playlistPanelVideoRenderer.thumbnail.thumbnails);
                        if (thumbnail != null && (str4 = thumbnail.url) != null) {
                            list5 = playlistPanelVideoRenderer.badges;
                            if (list5 != null) {
                                for (Object obj2 : list5) {
                                    musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                    if (musicInlineBadgeRenderer != null || (icon = musicInlineBadgeRenderer.icon) == null) {
                                        str5 = null;
                                    } else {
                                        str5 = icon.iconType;
                                    }
                                    if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                        obj = obj2;
                                        break;
                                    }
                                }
                                obj = (Badges) obj;
                            }
                            return new SongItem(str, str2, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, str4, obj != null, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                        }
                    }
                }
            } else {
                WatchEndpoint watchEndpoint = navigationEndpoint.watchEndpoint;
                str6 = watchEndpoint != null ? watchEndpoint.videoId : null;
                if (str6 != null) {
                    str = str6;
                    runs = playlistPanelVideoRenderer.title;
                    if (runs != null) {
                        arrayListExtractArtists = PageHelper.extractArtists(list);
                        list3 = (List) CollectionsKt.getOrNull(1, arrayListSplitBySeparator);
                        if (list3 != null) {
                            album = null;
                        } else {
                            album = null;
                        }
                        runs2 = playlistPanelVideoRenderer.lengthText;
                        if (runs2 != null) {
                            musicVideoType = navigationEndpoint.getMusicVideoType();
                            thumbnail = (Thumbnail) CollectionsKt.lastOrNull(playlistPanelVideoRenderer.thumbnail.thumbnails);
                            if (thumbnail != null) {
                                list5 = playlistPanelVideoRenderer.badges;
                                if (list5 != null) {
                                    while (r0.hasNext()) {
                                        musicInlineBadgeRenderer = ((Badges) obj2).musicInlineBadgeRenderer;
                                        if (musicInlineBadgeRenderer != null) {
                                            str5 = null;
                                        } else {
                                            str5 = null;
                                        }
                                        if (Intrinsics.areEqual(str5, "MUSIC_EXPLICIT_BADGE")) {
                                            obj = obj2;
                                            break;
                                        }
                                    }
                                    obj = (Badges) obj;
                                }
                                return new SongItem(str, str2, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, str4, obj != null, null, null, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, null, false, null, 117952);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
