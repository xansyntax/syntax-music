package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.FeedbackEndpoint;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicShelfRenderer;
import com.metrolist.innertube.models.MusicShelfRendererKt;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoryPage {
    public final List sections;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:150:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:32:0x006e  */
        public static HistorySection fromMusicShelfRenderer(MusicShelfRenderer musicShelfRenderer) {
            ArrayList arrayList;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
            Runs runs;
            List list;
            Run run;
            String str;
            Album album;
            String thumbnailUrl;
            Badges badges;
            String str2;
            SongItem songItem;
            Menu.MenuRenderer menuRenderer;
            List list2;
            Object next;
            Menu.MenuRenderer.Item.MenuServiceItemRenderer menuServiceItemRenderer;
            NavigationEndpoint navigationEndpoint;
            FeedbackEndpoint feedbackEndpoint;
            Menu.MenuRenderer.Item.MenuServiceItemRenderer menuServiceItemRenderer2;
            Icon icon;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
            MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
            NavigationEndpoint navigationEndpoint2;
            Object next2;
            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer;
            Icon icon2;
            MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
            Runs runs2;
            List list3;
            Run run2;
            String str3;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
            Runs runs3;
            List list4;
            Run run3;
            BrowseEndpoint browseEndpoint;
            String str4;
            MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer4;
            Runs runs4;
            List list5;
            Menu.MenuRenderer menuRenderer2;
            List list6;
            Run run4;
            musicShelfRenderer.getClass();
            Runs runs5 = musicShelfRenderer.title;
            String str5 = (runs5 == null || (list6 = runs5.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list6)) == null) ? null : run4.text;
            str5.getClass();
            List list7 = musicShelfRenderer.contents;
            if (list7 != null) {
                ArrayList items = MusicShelfRendererKt.getItems(list7);
                ArrayList arrayList2 = new ArrayList();
                int size = items.size();
                int i = 0;
                while (i < size) {
                    Object obj = items.get(i);
                    i++;
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) obj;
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    Menu menu = musicResponsiveListItemRenderer.menu;
                    List list8 = musicResponsiveListItemRenderer.flexColumns;
                    PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer2 = menu.menuRenderer) == null) ? null : menuRenderer2.items);
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list8);
                    ArrayList arrayListSplitBySeparator = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer4 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs4 = musicResponsiveListItemFlexColumnRenderer4.text) == null || (list5 = runs4.runs) == null) ? null : CharsKt.splitBySeparator(list5);
                    String videoId = musicResponsiveListItemRenderer.getVideoId();
                    if (videoId == null || (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list8)) == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (str = run.text) == null) {
                        songItem = null;
                    } else {
                        ArrayList arrayListExtractArtists = PageHelper.extractArtists(arrayListSplitBySeparator != null ? (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator) : null);
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn4 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(3, list8);
                        if (flexColumn4 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn4.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null || (list4 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list4)) == null) {
                            album = null;
                        } else {
                            String str6 = run3.text;
                            NavigationEndpoint navigationEndpoint3 = run3.navigationEndpoint;
                            album = (navigationEndpoint3 == null || (browseEndpoint = navigationEndpoint3.browseEndpoint) == null || (str4 = browseEndpoint.browseId) == null) ? null : new Album(str6, str4);
                        }
                        List list9 = musicResponsiveListItemRenderer.fixedColumns;
                        Integer numM1883parseTime = (list9 == null || (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list9)) == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list3 = runs2.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list3)) == null || (str3 = run2.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str3);
                        String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                        if (thumbnailRenderer == null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                            songItem = null;
                        } else {
                            List list10 = musicResponsiveListItemRenderer.badges;
                            if (list10 != null) {
                                Iterator it = list10.iterator();
                                do {
                                    if (!it.hasNext()) {
                                        next2 = null;
                                        break;
                                    }
                                    next2 = it.next();
                                    musicInlineBadgeRenderer = ((Badges) next2).musicInlineBadgeRenderer;
                                } while (!Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon2 = musicInlineBadgeRenderer.icon) == null) ? null : icon2.iconType, "MUSIC_EXPLICIT_BADGE"));
                                badges = (Badges) next2;
                            } else {
                                badges = null;
                            }
                            boolean z = badges != null;
                            MusicResponsiveListItemRenderer.Overlay overlay = musicResponsiveListItemRenderer.overlay;
                            WatchEndpoint watchEndpoint = (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint2 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint2.watchEndpoint;
                            String str7 = libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken;
                            String str8 = libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken;
                            Menu menu2 = musicResponsiveListItemRenderer.menu;
                            if (menu2 == null || (menuRenderer = menu2.menuRenderer) == null || (list2 = menuRenderer.items) == null) {
                                str2 = null;
                            } else {
                                Iterator it2 = list2.iterator();
                                do {
                                    if (!it2.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it2.next();
                                    menuServiceItemRenderer2 = ((Menu.MenuRenderer.Item) next).menuServiceItemRenderer;
                                } while (!Intrinsics.areEqual((menuServiceItemRenderer2 == null || (icon = menuServiceItemRenderer2.icon) == null) ? null : icon.iconType, "REMOVE_FROM_HISTORY"));
                                Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next;
                                if (item == null || (menuServiceItemRenderer = item.menuServiceItemRenderer) == null || (navigationEndpoint = menuServiceItemRenderer.serviceEndpoint) == null || (feedbackEndpoint = navigationEndpoint.feedbackEndpoint) == null) {
                                    str2 = null;
                                } else {
                                    str2 = feedbackEndpoint.feedbackToken;
                                }
                            }
                            songItem = new SongItem(videoId, str, arrayListExtractArtists, album, numM1883parseTime, musicVideoType, null, null, thumbnailUrl, z, watchEndpoint, null, str7, str8, str2, musicResponsiveListItemRenderer.isEpisode(), null, 67776);
                        }
                    }
                    if (songItem != null) {
                        arrayList2.add(songItem);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            arrayList.getClass();
            return new HistorySection(str5, arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class HistorySection {
        public final List songs;
        public final String title;

        public HistorySection(String str, List list) {
            this.title = str;
            this.songs = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HistorySection)) {
                return false;
            }
            HistorySection historySection = (HistorySection) obj;
            return this.title.equals(historySection.title) && this.songs.equals(historySection.songs);
        }

        public final int hashCode() {
            return this.songs.hashCode() + (this.title.hashCode() * 31);
        }

        public final String toString() {
            return "HistorySection(title=" + this.title + ", songs=" + this.songs + ")";
        }
    }

    public HistoryPage(ArrayList arrayList) {
        this.sections = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HistoryPage) && Intrinsics.areEqual(this.sections, ((HistoryPage) obj).sections);
    }

    public final int hashCode() {
        List list = this.sections;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("HistoryPage(sections=", ")", this.sections);
    }
}
