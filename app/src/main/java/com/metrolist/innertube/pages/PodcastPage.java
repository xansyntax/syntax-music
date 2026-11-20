package com.metrolist.innertube.pages;

import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicMultiRowListItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PodcastPage {
    public final String continuation;
    public final ArrayList episodes;
    public final boolean isChannelSubscribed;
    public final PodcastItem podcast;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Companion {
        /* JADX WARN: Code duplicated, block: B:75:0x00f9  */
        public static List extractPodcastArtists(MusicMultiRowListItemRenderer musicMultiRowListItemRenderer, List list) {
            Menu.MenuRenderer menuRenderer;
            List list2;
            NavigationEndpoint navigationEndpoint;
            BrowseEndpoint browseEndpoint;
            Artist artist;
            List list3;
            Run run;
            NavigationEndpoint navigationEndpoint2;
            BrowseEndpoint browseEndpoint2;
            musicMultiRowListItemRenderer.getClass();
            Runs runs = musicMultiRowListItemRenderer.secondarySubtitle;
            Runs runs2 = musicMultiRowListItemRenderer.secondSubtitle;
            List list4 = runs2 != null ? runs2.runs : null;
            EmptyList emptyList = EmptyList.INSTANCE;
            if (list4 == null) {
                list4 = emptyList;
            }
            List list5 = runs != null ? runs.runs : null;
            if (list5 == null) {
                list5 = emptyList;
            }
            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) list5, (Collection) list4);
            if (list == null) {
                list = emptyList;
            }
            ArrayList arrayListPlus2 = CollectionsKt.plus((Iterable) list, (Collection) arrayListPlus);
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(arrayListPlus2);
            if (arrayListExtractArtists.isEmpty()) {
                arrayListExtractArtists = new ArrayList();
                int size = arrayListPlus2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListPlus2.get(i);
                    i++;
                    Run run2 = (Run) obj;
                    if (StringsKt.isBlank(run2.text) || (navigationEndpoint2 = run2.navigationEndpoint) == null || (browseEndpoint2 = navigationEndpoint2.browseEndpoint) == null || !browseEndpoint2.isPodcastEndpoint()) {
                        run2 = null;
                    }
                    Artist artist2 = run2 != null ? new Artist(StringsKt.trim(run2.text).toString(), null) : null;
                    if (artist2 != null) {
                        arrayListExtractArtists.add(artist2);
                    }
                }
            }
            if (!arrayListExtractArtists.isEmpty()) {
                return arrayListExtractArtists;
            }
            Menu menu = musicMultiRowListItemRenderer.menu;
            if (menu != null && (menuRenderer = menu.menuRenderer) != null && (list2 = menuRenderer.items) != null && !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer = ((Menu.MenuRenderer.Item) it.next()).menuNavigationItemRenderer;
                    if (menuNavigationItemRenderer != null && (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null && browseEndpoint.isPodcastEndpoint()) {
                        Iterator it2 = CollectionsKt__IterablesKt.listOf((Object[]) new Runs[]{runs2, runs}).iterator();
                        do {
                            if (!it2.hasNext()) {
                                artist = null;
                                break;
                            }
                            Runs runs3 = (Runs) it2.next();
                            if (runs3 == null || (list3 = runs3.runs) == null || (run = (Run) CollectionsKt.singleOrNull(list3)) == null) {
                                artist = null;
                            } else {
                                if (run.navigationEndpoint != null || StringsKt.isBlank(run.text)) {
                                    run = null;
                                }
                                if (run != null) {
                                    artist = new Artist(StringsKt.trim(run.text).toString(), null);
                                } else {
                                    artist = null;
                                }
                            }
                        } while (artist == null);
                        List listListOf = artist != null ? CollectionsKt__IterablesKt.listOf(artist) : null;
                        if (listListOf == null) {
                            break;
                        }
                        return listListOf;
                    }
                }
            }
            return emptyList;
        }

        public static List extractPodcastByline(List list) {
            Run run;
            List list2;
            Object next;
            NavigationEndpoint navigationEndpoint;
            BrowseEndpoint browseEndpoint;
            ArrayList arrayListExtractArtists = PageHelper.extractArtists(list);
            if (!arrayListExtractArtists.isEmpty()) {
                return arrayListExtractArtists;
            }
            List listListOf = null;
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Run run2 = (Run) next;
                    if (!StringsKt.isBlank(run2.text) && (navigationEndpoint = run2.navigationEndpoint) != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null && browseEndpoint.isPodcastEndpoint()) {
                        break;
                    }
                }
                run = (Run) next;
            } else {
                run = null;
            }
            if (run != null) {
                return CollectionsKt__IterablesKt.listOf(new Artist(StringsKt.trim(run.text).toString(), null));
            }
            Run run3 = (list == null || (list2 = (List) CollectionsKt.firstOrNull((List) CharsKt.splitBySeparator(list))) == null) ? null : (Run) CollectionsKt.firstOrNull(list2);
            if (run3 != null) {
                if (StringsKt.isBlank(run3.text) || run3.navigationEndpoint != null) {
                    run3 = null;
                }
                if (run3 != null) {
                    listListOf = CollectionsKt__IterablesKt.listOf(new Artist(StringsKt.trim(run3.text).toString(), null));
                }
            }
            return listListOf == null ? EmptyList.INSTANCE : listListOf;
        }

        public static EpisodeItem fromMusicMultiRowListItemRenderer(MusicMultiRowListItemRenderer musicMultiRowListItemRenderer, PodcastItem podcastItem) {
            WatchEndpoint watchEndpoint;
            String str;
            Runs runs;
            List list;
            Run run;
            String str2;
            String thumbnailUrl;
            List list2;
            Run run2;
            List list3;
            Run run3;
            String str3;
            Menu.MenuRenderer menuRenderer;
            List list4;
            musicMultiRowListItemRenderer.getClass();
            NavigationEndpoint navigationEndpoint = musicMultiRowListItemRenderer.onTap;
            Runs runs2 = musicMultiRowListItemRenderer.subtitle;
            ArrayList arrayListSplitBySeparator = (runs2 == null || (list4 = runs2.runs) == null) ? null : CharsKt.splitBySeparator(list4);
            Set set = PageHelper.LIBRARY_ADD_ICONS;
            Menu menu = musicMultiRowListItemRenderer.menu;
            PageHelper.LibraryFeedbackTokens libraryFeedbackTokensExtractLibraryTokensFromMenuItems = PageHelper.extractLibraryTokensFromMenuItems((menu == null || (menuRenderer = menu.menuRenderer) == null) ? null : menuRenderer.items);
            if (navigationEndpoint != null && (watchEndpoint = navigationEndpoint.watchEndpoint) != null && (str = watchEndpoint.videoId) != null && (runs = musicMultiRowListItemRenderer.title) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str2 = run.text) != null) {
                Artist artist = podcastItem != null ? podcastItem.author : null;
                Album album = podcastItem != null ? new Album(podcastItem.title, podcastItem.id) : null;
                Integer numM1883parseTime = (arrayListSplitBySeparator == null || (list3 = (List) CollectionsKt.lastOrNull(arrayListSplitBySeparator)) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null || (str3 = run3.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str3);
                String str4 = (arrayListSplitBySeparator == null || (list2 = (List) CollectionsKt.firstOrNull((List) arrayListSplitBySeparator)) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null) ? null : run2.text;
                ThumbnailRenderer thumbnailRenderer = musicMultiRowListItemRenderer.thumbnail;
                if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                    return new EpisodeItem(str, str2, artist, album, numM1883parseTime, str4, thumbnailUrl, false, navigationEndpoint.watchEndpoint, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.addToken, libraryFeedbackTokensExtractLibraryTokensFromMenuItems.removeToken, 6144);
                }
            }
            return null;
        }
    }

    public PodcastPage(PodcastItem podcastItem, ArrayList arrayList, String str, boolean z) {
        this.podcast = podcastItem;
        this.episodes = arrayList;
        this.continuation = str;
        this.isChannelSubscribed = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PodcastPage)) {
            return false;
        }
        PodcastPage podcastPage = (PodcastPage) obj;
        return this.podcast.equals(podcastPage.podcast) && this.episodes.equals(podcastPage.episodes) && Intrinsics.areEqual(this.continuation, podcastPage.continuation) && this.isChannelSubscribed == podcastPage.isChannelSubscribed;
    }

    public final int hashCode() {
        int iHashCode = (this.episodes.hashCode() + (this.podcast.hashCode() * 31)) * 31;
        String str = this.continuation;
        return Boolean.hashCode(this.isChannelSubscribed) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "PodcastPage(podcast=" + this.podcast + ", episodes=" + this.episodes + ", continuation=" + this.continuation + ", isChannelSubscribed=" + this.isChannelSubscribed + ")";
    }
}
