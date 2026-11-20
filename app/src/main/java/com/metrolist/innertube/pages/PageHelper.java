package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.FeedbackEndpoint;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.ToggledServiceEndpoint;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PageHelper {
    public static final LinkedHashSet ALL_LIBRARY_ICONS;
    public static final Set LIBRARY_ADD_ICONS;
    public static final Set LIBRARY_SAVED_ICONS;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LibraryFeedbackTokens {
        public final String addToken;
        public final String removeToken;

        public LibraryFeedbackTokens(String str, String str2) {
            this.addToken = str;
            this.removeToken = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LibraryFeedbackTokens)) {
                return false;
            }
            LibraryFeedbackTokens libraryFeedbackTokens = (LibraryFeedbackTokens) obj;
            return Intrinsics.areEqual(this.addToken, libraryFeedbackTokens.addToken) && Intrinsics.areEqual(this.removeToken, libraryFeedbackTokens.removeToken);
        }

        public final int hashCode() {
            String str = this.addToken;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.removeToken;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("LibraryFeedbackTokens(addToken=", this.addToken, ", removeToken=", this.removeToken, ")");
        }
    }

    static {
        Set set = ArraysKt.toSet(new String[]{"LIBRARY_ADD", "BOOKMARK_BORDER"});
        LIBRARY_ADD_ICONS = set;
        Set set2 = ArraysKt.toSet(new String[]{"LIBRARY_SAVED", "BOOKMARK", "LIBRARY_REMOVE"});
        LIBRARY_SAVED_ICONS = set2;
        ALL_LIBRARY_ICONS = SetsKt.plus(set, (Iterable) set2);
    }

    public static ArrayList extractArtists(List list) {
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (Run run : list) {
            NavigationEndpoint navigationEndpoint = run.navigationEndpoint;
            String str = run.text;
            Artist artist = null;
            if (navigationEndpoint != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null) {
                String str2 = browseEndpoint.browseId;
                BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs;
                String str3 = (browseEndpointContextSupportedConfigs == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType;
                if (!StringsKt.isBlank(str) && (Intrinsics.areEqual(str3, "MUSIC_PAGE_TYPE_ARTIST") || Intrinsics.areEqual(str3, "MUSIC_PAGE_TYPE_LIBRARY_ARTIST") || Intrinsics.areEqual(str3, "MUSIC_PAGE_TYPE_USER_CHANNEL") || (str3 == null && StringsKt__StringsJVMKt.startsWith(str2, "UC", false)))) {
                    artist = new Artist(StringsKt.trim(str).toString(), str2);
                }
            }
            if (artist != null) {
                arrayList.add(artist);
            }
        }
        return arrayList;
    }

    public static Integer extractDuration(ArrayList arrayList) {
        Integer numM1883parseTime;
        int size = arrayList.size();
        int i = 0;
        do {
            numM1883parseTime = null;
            if (i >= size) {
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            String string = StringsKt.trim(((Run) obj).text).toString();
            Pattern patternCompile = Pattern.compile("\\d{1,2}[:.,]\\d{2}(?:[:.,]\\d{2})?");
            patternCompile.getClass();
            string.getClass();
            if (!patternCompile.matcher(string).matches()) {
                string = null;
            }
            if (string != null) {
                numM1883parseTime = StringsKt__IndentKt.m1883parseTime(string);
            }
        } while (numM1883parseTime == null);
        return numM1883parseTime;
    }

    public static LibraryFeedbackTokens extractLibraryTokensFromMenuItems(List list) {
        FeedbackEndpoint feedbackEndpoint;
        if (list == null) {
            return new LibraryFeedbackTokens(null, null);
        }
        Iterator it = list.iterator();
        String str = null;
        String str2 = null;
        while (it.hasNext()) {
            Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer = ((Menu.MenuRenderer.Item) it.next()).toggleMenuServiceItemRenderer;
            if (toggleMenuServiceRenderer != null) {
                String str3 = toggleMenuServiceRenderer.defaultIcon.iconType;
                if (!Intrinsics.areEqual(str3, "KEEP") && !Intrinsics.areEqual(str3, "KEEP_OFF") && isLibraryIcon(str3)) {
                    FeedbackEndpoint feedbackEndpoint2 = toggleMenuServiceRenderer.defaultServiceEndpoint.feedbackEndpoint;
                    String str4 = feedbackEndpoint2 != null ? feedbackEndpoint2.feedbackToken : null;
                    ToggledServiceEndpoint toggledServiceEndpoint = toggleMenuServiceRenderer.toggledServiceEndpoint;
                    String str5 = (toggledServiceEndpoint == null || (feedbackEndpoint = toggledServiceEndpoint.feedbackEndpoint) == null) ? null : feedbackEndpoint.feedbackToken;
                    if (CollectionsKt.contains(LIBRARY_ADD_ICONS, str3)) {
                        if (str == null) {
                            str = str4;
                        }
                        if (str2 == null) {
                            str2 = str5;
                        }
                    } else if (CollectionsKt.contains(LIBRARY_SAVED_ICONS, str3)) {
                        if (str2 == null) {
                            str2 = str4;
                        }
                        if (str == null) {
                            str = str5;
                        }
                    }
                }
            }
        }
        return new LibraryFeedbackTokens(str, str2);
    }

    public static ArrayList extractRuns(String str, List list) {
        List<Run> list2;
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        String str2;
        WatchEndpoint watchEndpoint;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs.WatchEndpointMusicConfig watchEndpointMusicConfig;
        list.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Runs runs = ((MusicResponsiveListItemRenderer.FlexColumn) it.next()).musicResponsiveListItemFlexColumnRenderer.text;
            if (runs != null && (list2 = runs.runs) != null) {
                for (Run run : list2) {
                    NavigationEndpoint navigationEndpoint = run.navigationEndpoint;
                    if (navigationEndpoint == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null || (watchEndpointMusicSupportedConfigs = watchEndpoint.watchEndpointMusicSupportedConfigs) == null || (watchEndpointMusicConfig = watchEndpointMusicSupportedConfigs.watchEndpointMusicConfig) == null || (str2 = watchEndpointMusicConfig.musicVideoType) == null) {
                        if (navigationEndpoint != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null && (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) != null && (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) != null) {
                            str2 = browseEndpointContextMusicConfig.pageType;
                        }
                    }
                    if (StringsKt.contains(str2, str, false)) {
                        arrayList.add(run);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isLibraryIcon(String str) {
        return (str == null || str.equals("KEEP") || str.equals("KEEP_OFF") || (!ALL_LIBRARY_ICONS.contains(str) && !StringsKt__StringsJVMKt.startsWith(str, "LIBRARY_", false))) ? false : true;
    }
}
