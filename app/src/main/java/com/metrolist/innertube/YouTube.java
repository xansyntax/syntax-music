package com.metrolist.innertube;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.palette.graphics.ColorCutQuantizer;
import coil3.memory.RealStrongMemoryCache;
import coil3.network.HttpException;
import com.metrolist.innertube.models.AccountInfo;
import com.metrolist.innertube.models.AlbumItem;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.AutomixPreviewVideoRenderer;
import com.metrolist.innertube.models.AvatarStackViewModel;
import com.metrolist.innertube.models.Badges;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.Button;
import com.metrolist.innertube.models.ContinuationKt;
import com.metrolist.innertube.models.DefaultServiceEndpoint;
import com.metrolist.innertube.models.DescriptionWrapper;
import com.metrolist.innertube.models.EpisodeItem;
import com.metrolist.innertube.models.FacepileWrapper;
import com.metrolist.innertube.models.FeedbackEndpoint;
import com.metrolist.innertube.models.GridRenderer;
import com.metrolist.innertube.models.Icon;
import com.metrolist.innertube.models.ItemSectionRenderer;
import com.metrolist.innertube.models.Menu;
import com.metrolist.innertube.models.MusicCardShelfRenderer;
import com.metrolist.innertube.models.MusicCarouselShelfRenderer;
import com.metrolist.innertube.models.MusicDescriptionShelfRenderer;
import com.metrolist.innertube.models.MusicDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicEditablePlaylistDetailHeaderRenderer;
import com.metrolist.innertube.models.MusicMultiRowListItemRenderer;
import com.metrolist.innertube.models.MusicNavigationButtonRenderer;
import com.metrolist.innertube.models.MusicPlaylistShelfRenderer;
import com.metrolist.innertube.models.MusicQueueRenderer;
import com.metrolist.innertube.models.MusicResponsiveHeaderRenderer;
import com.metrolist.innertube.models.MusicResponsiveListItemRenderer;
import com.metrolist.innertube.models.MusicShelfRenderer;
import com.metrolist.innertube.models.MusicShelfRendererKt;
import com.metrolist.innertube.models.MusicTwoRowItemRenderer;
import com.metrolist.innertube.models.NavigationEndpoint;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.PlaylistPanelRenderer;
import com.metrolist.innertube.models.PlaylistPanelVideoRenderer;
import com.metrolist.innertube.models.PodcastItem;
import com.metrolist.innertube.models.Run;
import com.metrolist.innertube.models.Runs;
import com.metrolist.innertube.models.SearchSuggestions;
import com.metrolist.innertube.models.SearchSuggestionsSectionRenderer;
import com.metrolist.innertube.models.SectionListRenderer;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.SubscriptionButton;
import com.metrolist.innertube.models.Tabs;
import com.metrolist.innertube.models.Thumbnail;
import com.metrolist.innertube.models.ThumbnailRenderer;
import com.metrolist.innertube.models.Thumbnails;
import com.metrolist.innertube.models.ToggledServiceEndpoint;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.models.YTItem;
import com.metrolist.innertube.models.response.AccountMenuResponse;
import com.metrolist.innertube.models.response.BrowseResponse;
import com.metrolist.innertube.models.response.CreatePlaylistResponse;
import com.metrolist.innertube.models.response.EditPlaylistResponse;
import com.metrolist.innertube.models.response.FeedbackResponse;
import com.metrolist.innertube.models.response.GetQueueResponse;
import com.metrolist.innertube.models.response.GetSearchSuggestionsResponse;
import com.metrolist.innertube.models.response.GetTranscriptResponse;
import com.metrolist.innertube.models.response.NextResponse;
import com.metrolist.innertube.models.response.SearchResponse;
import com.metrolist.innertube.pages.AlbumPage;
import com.metrolist.innertube.pages.ArtistItemsContinuationPage;
import com.metrolist.innertube.pages.ArtistItemsPage;
import com.metrolist.innertube.pages.ArtistPage;
import com.metrolist.innertube.pages.ArtistSection;
import com.metrolist.innertube.pages.BrowseResult;
import com.metrolist.innertube.pages.ChartsPage;
import com.metrolist.innertube.pages.ExplorePage;
import com.metrolist.innertube.pages.HistoryPage;
import com.metrolist.innertube.pages.HomePage;
import com.metrolist.innertube.pages.LibraryContinuationPage;
import com.metrolist.innertube.pages.LibraryPage;
import com.metrolist.innertube.pages.MoodAndGenres;
import com.metrolist.innertube.pages.NewReleaseAlbumPage;
import com.metrolist.innertube.pages.NextPage;
import com.metrolist.innertube.pages.NextResult;
import com.metrolist.innertube.pages.PageHelper;
import com.metrolist.innertube.pages.PlaylistContinuationPage;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.innertube.pages.PodcastPage;
import com.metrolist.innertube.pages.RelatedPage;
import com.metrolist.innertube.pages.SearchPage;
import com.metrolist.innertube.pages.SearchResult;
import com.metrolist.innertube.pages.SearchSuggestionPage;
import com.metrolist.innertube.pages.SearchSummary;
import com.metrolist.innertube.pages.SearchSummaryPage;
import com.metrolist.innertubex.InnerTube$getQueue$2;
import com.metrolist.innertubex.InnerTube$getTranscript$2;
import com.metrolist.innertubex.models.YouTubeClient;
import com.metrolist.music.App;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.HttpClientKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.random.Random;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.RegexKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.json.Json;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTube {
    public static final YouTube INSTANCE = new YouTube();
    public static final List SUPPORTED_UPLOAD_TYPES;
    public static final InnerTube innerTube;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SearchFilter {
        public final String value;

        public /* synthetic */ SearchFilter(String str) {
            this.value = str;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof SearchFilter) {
                return this.value.equals(((SearchFilter) obj).value);
            }
            return false;
        }

        public final int hashCode() {
            return this.value.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("SearchFilter(value=", this.value, ")");
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.YouTube$createPlaylist$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTube.this.createPlaylist(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.YouTube$getChannelId$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00811 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C00811(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTube.this.getChannelId(null, this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.innertube.YouTube$resolveArtistIds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00821 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C00821(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return YouTube.this.resolveArtistIds(null, this);
        }
    }

    static {
        InnerTube innerTube2 = new InnerTube();
        innerTube2.httpClient = HttpClientKt.HttpClient(OkHttp.INSTANCE, new InnerTube$$ExternalSyntheticLambda0(innerTube2, (byte) 0));
        innerTube2.innerTubeX = new com.metrolist.innertubex.InnerTube(innerTube2.httpClient);
        innerTube = innerTube2;
        SUPPORTED_UPLOAD_TYPES = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"mp3", "m4a", "wma", "flac", "ogg"});
    }

    public static final ArrayList artist_gIAlu_s$lambda$0$mapRuns(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Run run = (Run) it.next();
            arrayList.add(new Run(run.text, run.navigationEndpoint));
        }
        return arrayList;
    }

    public static YTItem convertMusicTwoRowItem(MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
        BrowseEndpoint browseEndpoint;
        String str;
        MusicResponsiveListItemRenderer.Overlay overlay;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        String str2;
        List list;
        Run run;
        String str3;
        boolean z;
        Icon icon;
        List list2;
        Run run2;
        String str4;
        List list3;
        List list4;
        Run run3;
        String str5;
        String str6;
        boolean z2;
        Icon icon2;
        try {
            boolean zIsSong = musicTwoRowItemRenderer.isSong();
            List list5 = musicTwoRowItemRenderer.subtitleBadges;
            ThumbnailRenderer thumbnailRenderer = musicTwoRowItemRenderer.thumbnailRenderer;
            NavigationEndpoint navigationEndpoint2 = musicTwoRowItemRenderer.navigationEndpoint;
            Runs runs = musicTwoRowItemRenderer.title;
            Runs runs2 = musicTwoRowItemRenderer.subtitle;
            if (zIsSong) {
                if (runs2 != null && (list3 = runs2.runs) != null && (list4 = runs.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list4)) != null && (str5 = run3.text) != null) {
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(list3);
                    WatchEndpoint watchEndpoint2 = navigationEndpoint2.watchEndpoint;
                    if (watchEndpoint2 != null && (str6 = watchEndpoint2.videoId) != null) {
                        if (arrayListExtractArtists.isEmpty()) {
                            ConnectionPool connectionPool = Timber.Forest;
                            list3.size();
                            connectionPool.getClass();
                            ConnectionPool.w(new Object[0]);
                        }
                        String thumbnailUrl = thumbnailRenderer.getThumbnailUrl();
                        if (thumbnailUrl != null) {
                            String musicVideoType = musicTwoRowItemRenderer.getMusicVideoType();
                            if (list5 == null || list5.isEmpty()) {
                                z2 = false;
                            } else {
                                Iterator it = list5.iterator();
                                while (it.hasNext()) {
                                    Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) it.next()).musicInlineBadgeRenderer;
                                    if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon2 = musicInlineBadgeRenderer.icon) == null) ? null : icon2.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                        z2 = true;
                                    }
                                }
                                z2 = false;
                            }
                            return new SongItem(str6, str5, arrayListExtractArtists, null, null, musicVideoType, null, null, thumbnailUrl, z2, null, null, null, null, null, false, null, 130264);
                        }
                    }
                }
            } else if (musicTwoRowItemRenderer.isAlbum() && (browseEndpoint = navigationEndpoint2.browseEndpoint) != null && (str = browseEndpoint.browseId) != null && (overlay = musicTwoRowItemRenderer.thumbnailOverlay) != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) != null && (watchEndpoint = navigationEndpoint.watchPlaylistEndpoint) != null && (str2 = watchEndpoint.playlistId) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str3 = run.text) != null) {
                Set set = PageHelper.LIBRARY_ADD_ICONS;
                ArrayList arrayListExtractArtists2 = PageHelper.extractArtists(runs2 != null ? runs2.runs : null);
                Integer intOrNull = (runs2 == null || (list2 = runs2.runs) == null || (run2 = (Run) CollectionsKt.lastOrNull(list2)) == null || (str4 = run2.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str4);
                String thumbnailUrl2 = thumbnailRenderer.getThumbnailUrl();
                if (thumbnailUrl2 != null) {
                    if (list5 == null || list5.isEmpty()) {
                        z = false;
                    } else {
                        Iterator it2 = list5.iterator();
                        while (it2.hasNext()) {
                            Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer2 = ((Badges) it2.next()).musicInlineBadgeRenderer;
                            if (Intrinsics.areEqual((musicInlineBadgeRenderer2 == null || (icon = musicInlineBadgeRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                z = true;
                            }
                        }
                        z = false;
                    }
                    return new AlbumItem(str, str2, str3, arrayListExtractArtists2, intOrNull, thumbnailUrl2, z, 4);
                }
            }
            return null;
        } catch (Exception e) {
            String message = e.getMessage();
            Json.Default r3 = Json.Default;
            r3.getClass();
            System.out.println((Object) ("Error converting two row item: " + message + "\n" + r3.encodeToString(MusicTwoRowItemRenderer.INSTANCE.serializer(), musicTwoRowItemRenderer)));
            return null;
        }
    }

    public static SongItem convertToChartItem(MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
        MusicResponsiveListItemRenderer.FlexColumn flexColumn;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn2;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
        Runs runs2;
        List list;
        Run run;
        String thumbnailUrl;
        boolean z;
        List list2;
        Run run2;
        List list3;
        Run run3;
        String str;
        Icon icon;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
        try {
            List list4 = musicResponsiveListItemRenderer.flexColumns;
            if (list4.size() >= 3 && musicResponsiveListItemRenderer.getVideoId() != null && (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(0, list4)) != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list4)) != null && (musicResponsiveListItemFlexColumnRenderer2 = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null) {
                String str2 = run.text;
                String str3 = !StringsKt.isBlank(str2) ? str2 : null;
                if (str3 != null) {
                    Set set = PageHelper.LIBRARY_ADD_ICONS;
                    ArrayList arrayListExtractArtists = PageHelper.extractArtists(runs2.runs);
                    if (arrayListExtractArtists.isEmpty()) {
                        ConnectionPool connectionPool = Timber.Forest;
                        musicResponsiveListItemRenderer.getVideoId();
                        connectionPool.getClass();
                        ConnectionPool.w(new Object[0]);
                    }
                    MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(2, list4);
                    Runs runs3 = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null) ? null : musicResponsiveListItemFlexColumnRenderer3.text;
                    String videoId = musicResponsiveListItemRenderer.getVideoId();
                    videoId.getClass();
                    ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer.thumbnail;
                    if (thumbnailRenderer != null && (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) != null) {
                        String musicVideoType = musicResponsiveListItemRenderer.getMusicVideoType();
                        List list5 = musicResponsiveListItemRenderer.badges;
                        if (list5 != null && !list5.isEmpty()) {
                            Iterator it = list5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                Badges.MusicInlineBadgeRenderer musicInlineBadgeRenderer = ((Badges) it.next()).musicInlineBadgeRenderer;
                                if (Intrinsics.areEqual((musicInlineBadgeRenderer == null || (icon = musicInlineBadgeRenderer.icon) == null) ? null : icon.iconType, "MUSIC_EXPLICIT_BADGE")) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            z = false;
                            break;
                        }
                        return new SongItem(videoId, str3, arrayListExtractArtists, null, null, musicVideoType, (runs3 == null || (list3 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null || (str = run3.text) == null) ? null : StringsKt__StringsJVMKt.toIntOrNull(10, str), (runs3 == null || (list2 = runs3.runs) == null || (run2 = (Run) CollectionsKt.getOrNull(1, list2)) == null) ? null : run2.text, thumbnailUrl, z, null, null, null, null, null, false, null, 130072);
                    }
                }
            }
            return null;
        } catch (Exception e) {
            String message = e.getMessage();
            Json.Default r3 = Json.Default;
            r3.getClass();
            System.out.println((Object) ("Error converting chart item: " + message + "\n" + r3.encodeToString(MusicResponsiveListItemRenderer.INSTANCE.serializer(), musicResponsiveListItemRenderer)));
            return null;
        }
    }

    public static RealStrongMemoryCache extractionTransport() {
        RealStrongMemoryCache realStrongMemoryCache;
        InnerTube innerTube2 = innerTube;
        synchronized (innerTube2) {
            realStrongMemoryCache = new RealStrongMemoryCache(innerTube2.innerTubeX, innerTube2.httpClient, innerTube2.transportGeneration);
        }
        return realStrongMemoryCache;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ba  */
    public static ArrayList groupItemsByType(List list) {
        SearchSummary searchSummary;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            YTItem yTItem = (YTItem) obj;
            if (yTItem != null) {
                String str = "Episodes";
                if (!(yTItem instanceof EpisodeItem)) {
                    if (yTItem instanceof PodcastItem) {
                        str = "Podcasts";
                    } else if (yTItem instanceof AlbumItem) {
                        str = "Albums";
                    } else if (yTItem instanceof ArtistItem) {
                        str = ((ArtistItem) yTItem).isProfile ? "Profiles" : "Artists";
                    } else if (yTItem instanceof PlaylistItem) {
                        str = "Playlists";
                    } else if (yTItem instanceof SongItem) {
                        SongItem songItem = (SongItem) yTItem;
                        if (!songItem.isEpisode) {
                            str = songItem.isVideoSong() ? "Videos" : "Songs";
                        }
                    }
                }
                Object arrayList = linkedHashMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(str, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return null;
        }
        List<String> listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new String[]{"Songs", "Videos", "Albums", "Artists", "Playlists", "Podcasts", "Episodes", "Profiles", "Other"});
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : listListOf) {
            List list2 = (List) linkedHashMap.get(str2);
            if (list2 == null) {
                searchSummary = null;
            } else {
                if (list2.isEmpty()) {
                    list2 = null;
                }
                if (list2 != null) {
                    searchSummary = new SearchSummary(str2, list2);
                } else {
                    searchSummary = null;
                }
            }
            if (searchSummary != null) {
                arrayList2.add(searchSummary);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: home-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m987home0E7RQCE$default(String str, String str2, SuspendLambda suspendLambda, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return INSTANCE.m1009home0E7RQCE(str, str2, suspendLambda);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00a9  */
    public static final void newEpisodes_IoAF18A$lambda$0$processShelf(ArrayList arrayList, MusicShelfRenderer musicShelfRenderer) {
        Runs runs;
        List list;
        Run run;
        String str;
        Integer numM1883parseTime;
        String thumbnailUrl;
        Object objPrevious;
        Run run2;
        String str2;
        Run run3;
        String str3;
        List list2;
        WatchEndpoint watchEndpoint;
        List list3 = musicShelfRenderer.contents;
        if (list3 != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = ((MusicShelfRenderer.Content) it.next()).musicMultiRowListItemRenderer;
                if (musicMultiRowListItemRenderer != null) {
                    arrayList2.add(musicMultiRowListItemRenderer);
                }
            }
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2 = (MusicMultiRowListItemRenderer) obj;
                NavigationEndpoint navigationEndpoint = musicMultiRowListItemRenderer2.onTap;
                if (((navigationEndpoint == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) ? null : watchEndpoint.videoId) != null && (runs = musicMultiRowListItemRenderer2.title) != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str = run.text) != null) {
                    Runs runs2 = musicMultiRowListItemRenderer2.subtitle;
                    ArrayList arrayListSplitBySeparator = (runs2 == null || (list2 = runs2.runs) == null) ? null : CharsKt.splitBySeparator(list2);
                    if (arrayListSplitBySeparator != null) {
                        ListIterator listIterator = arrayListSplitBySeparator.listIterator(arrayListSplitBySeparator.size());
                        do {
                            if (!listIterator.hasPrevious()) {
                                objPrevious = null;
                                break;
                            } else {
                                objPrevious = listIterator.previous();
                                run3 = (Run) CollectionsKt.firstOrNull((List) objPrevious);
                            }
                        } while (((run3 == null || (str3 = run3.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str3)) == null);
                        List list4 = (List) objPrevious;
                        if (list4 == null || (run2 = (Run) CollectionsKt.firstOrNull(list4)) == null || (str2 = run2.text) == null) {
                            numM1883parseTime = null;
                        } else {
                            numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str2);
                        }
                    } else {
                        numM1883parseTime = null;
                    }
                    Runs runs3 = musicShelfRenderer.title;
                    List listExtractPodcastArtists = PodcastPage.Companion.extractPodcastArtists(musicMultiRowListItemRenderer2, runs3 != null ? runs3.runs : null);
                    String str4 = musicMultiRowListItemRenderer2.onTap.watchEndpoint.videoId;
                    ThumbnailRenderer thumbnailRenderer = musicMultiRowListItemRenderer2.thumbnail;
                    if (thumbnailRenderer == null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                        thumbnailUrl = "";
                    }
                    arrayList.add(new SongItem(str4, str, listExtractPodcastArtists, null, numM1883parseTime, null, null, null, thumbnailUrl, false, null, null, null, null, null, true, null, 98016));
                }
            }
        }
    }

    /* JADX INFO: renamed from: queue-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Serializable m989queue0E7RQCE$default(List list, SuspendLambda suspendLambda) {
        return INSTANCE.m1029queue0E7RQCE(list, null, suspendLambda);
    }

    public static final Artist resolveArtistIds$resolve(Artist artist, Map map) {
        String str;
        return (artist.id != null || (str = (String) map.get(artist.name)) == null) ? artist : Artist.copy$default(artist, str);
    }

    /* JADX INFO: renamed from: search-MVsJJCw$default, reason: not valid java name */
    public static /* synthetic */ Object m990searchMVsJJCw$default(String str, String str2, SuspendLambda suspendLambda) {
        return INSTANCE.m1039searchMVsJJCw(str, str2, false, suspendLambda);
    }

    public static void setAuthUser(String str) {
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default;
        str.getClass();
        InnerTube innerTube2 = innerTube;
        innerTube2.getClass();
        com.metrolist.innertubex.InnerTube innerTube3 = innerTube2.innerTubeX;
        innerTube3.getClass();
        do {
            sessionSnapshot = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube3.session.get();
            sessionSnapshotCopy$default = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, null, com.metrolist.innertubex.InnerTube.sanitizeAuthUser(str), null, null, false, false, 0L, 503);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                return;
            }
        } while (!innerTube3.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
    }

    public static void setCookie(String str) throws IOException {
        String strSanitizeCookieString;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default;
        com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
        if (str != null) {
            innerTube2.getClass();
            strSanitizeCookieString = HexFormatKt.sanitizeCookieString(str);
        } else {
            strSanitizeCookieString = null;
        }
        String str2 = strSanitizeCookieString;
        do {
            sessionSnapshot = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube2.session.get();
            sessionSnapshotCopy$default = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, null, null, str2, com.metrolist.innertubex.InnerTube.resolveSapisidValue(str2), false, false, 0L, 463);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                return;
            }
        } while (!innerTube2.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
    }

    public static void setDataSyncId(String str) {
        com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
        while (true) {
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube2.session.get();
            String str2 = str;
            com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, null, str2, null, null, null, false, false, 0L, 507);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot) || innerTube2.publishSession(sessionSnapshot, sessionSnapshotCopy$default)) {
                return;
            } else {
                str = str2;
            }
        }
    }

    public static void setVisitorData(String str) throws IOException {
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot;
        com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshotCopy$default;
        com.metrolist.innertubex.InnerTube innerTube2 = innerTube.innerTubeX;
        do {
            sessionSnapshot = (com.metrolist.innertubex.InnerTube.SessionSnapshot) innerTube2.session.get();
            sessionSnapshotCopy$default = com.metrolist.innertubex.InnerTube.SessionSnapshot.copy$default(sessionSnapshot, null, HexFormatKt.sanitizeVisitorData(str), null, null, null, null, false, false, 0L, 509);
            if (sessionSnapshotCopy$default.equals(sessionSnapshot)) {
                return;
            }
        } while (!innerTube2.publishSession(sessionSnapshot, sessionSnapshotCopy$default));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r7 == r5) goto L28;
     */
    /* JADX INFO: renamed from: accountInfo-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m991accountInfoIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$accountInfo$1 youTube$accountInfo$1;
        TypeReference typeReferenceTypeOf;
        AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header.ActiveAccountHeaderRenderer activeAccountHeaderRenderer;
        if (continuationImpl instanceof YouTube$accountInfo$1) {
            youTube$accountInfo$1 = (YouTube$accountInfo$1) continuationImpl;
            int i = youTube$accountInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$accountInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$accountInfo$1 = new YouTube$accountInfo$1(this, continuationImpl);
            }
        } else {
            youTube$accountInfo$1 = new YouTube$accountInfo$1(this, continuationImpl);
        }
        Object objAccountMenu = youTube$accountInfo$1.result;
        int i2 = youTube$accountInfo$1.label;
        AccountInfo accountInfo = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objAccountMenu);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$accountInfo$1.label = 1;
                    objAccountMenu = innerTube2.accountMenu(youTubeClient, youTube$accountInfo$1);
                    if (objAccountMenu == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objAccountMenu);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objAccountMenu);
                }
                if (objAccountMenu == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.AccountMenuResponse");
                }
                AccountMenuResponse.Action.OpenPopupAction.Popup.MultiPageMenuRenderer.Header header = ((AccountMenuResponse.Action) ((AccountMenuResponse) objAccountMenu).actions.get(0)).openPopupAction.popup.multiPageMenuRenderer.header;
                if (header != null && (activeAccountHeaderRenderer = header.activeAccountHeaderRenderer) != null) {
                    accountInfo = activeAccountHeaderRenderer.toAccountInfo();
                }
                accountInfo.getClass();
                return accountInfo;
                typeReferenceTypeOf = Reflection.typeOf(AccountMenuResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objAccountMenu).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AccountMenuResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$accountInfo$1.label = 2;
            objAccountMenu = call.bodyNullable(typeInfo, youTube$accountInfo$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r6 == r4) goto L27;
     */
    /* JADX INFO: renamed from: accountsList-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m992accountsListIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$accountsList$1 youTube$accountsList$1;
        Json.Default r7;
        if (continuationImpl instanceof YouTube$accountsList$1) {
            youTube$accountsList$1 = (YouTube$accountsList$1) continuationImpl;
            int i = youTube$accountsList$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$accountsList$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$accountsList$1 = new YouTube$accountsList$1(this, continuationImpl);
            }
        } else {
            youTube$accountsList$1 = new YouTube$accountsList$1(this, continuationImpl);
        }
        Object objBodyAsText$default = youTube$accountsList$1.result;
        int i2 = youTube$accountsList$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    r7 = youTube$accountsList$1.L$1;
                    ResultKt.throwOnFailure(objBodyAsText$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    r7 = youTube$accountsList$1.L$1;
                    ResultKt.throwOnFailure(objBodyAsText$default);
                }
                return RegexKt.extractYouTubeAccounts(r7.parseToJsonElement((String) objBodyAsText$default));
            }
            ResultKt.throwOnFailure(objBodyAsText$default);
            Json.Default r6 = Json.Default;
            InnerTube innerTube2 = innerTube;
            youTube$accountsList$1.L$1 = r6;
            youTube$accountsList$1.label = 1;
            Object objAccountsList = innerTube2.accountsList(youTube$accountsList$1);
            if (objAccountsList != coroutineSingletons) {
                r7 = r6;
                objBodyAsText$default = objAccountsList;
            }
            return coroutineSingletons;
            youTube$accountsList$1.L$1 = r7;
            youTube$accountsList$1.label = 2;
            objBodyAsText$default = HttpResponseKt.bodyAsText$default((HttpResponse) objBodyAsText$default, null, youTube$accountsList$1, 1, null);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: addEpisodeToSavedEpisodes-gIAlu-s, reason: not valid java name */
    public final Object m993addEpisodeToSavedEpisodesgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$addEpisodeToSavedEpisodes$1 youTube$addEpisodeToSavedEpisodes$1;
        if (continuationImpl instanceof YouTube$addEpisodeToSavedEpisodes$1) {
            youTube$addEpisodeToSavedEpisodes$1 = (YouTube$addEpisodeToSavedEpisodes$1) continuationImpl;
            int i = youTube$addEpisodeToSavedEpisodes$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$addEpisodeToSavedEpisodes$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$addEpisodeToSavedEpisodes$1 = new YouTube$addEpisodeToSavedEpisodes$1(this, continuationImpl);
            }
        } else {
            youTube$addEpisodeToSavedEpisodes$1 = new YouTube$addEpisodeToSavedEpisodes$1(this, continuationImpl);
        }
        Object objAddToPlaylist = youTube$addEpisodeToSavedEpisodes$1.result;
        int i2 = youTube$addEpisodeToSavedEpisodes$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAddToPlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$addEpisodeToSavedEpisodes$1.label = 1;
                objAddToPlaylist = innerTube2.addToPlaylist(youTubeClient, "SE", str, youTube$addEpisodeToSavedEpisodes$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAddToPlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAddToPlaylist);
            }
            return (HttpResponse) objAddToPlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r6 == r5) goto L36;
     */
    /* JADX INFO: renamed from: addSongToLibrary-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m994addSongToLibrarygIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$addSongToLibrary$1 youTube$addSongToLibrary$1;
        Object objM1024next0E7RQCE;
        Object next;
        Object objM1006feedbackgIAlus;
        if (continuationImpl instanceof YouTube$addSongToLibrary$1) {
            youTube$addSongToLibrary$1 = (YouTube$addSongToLibrary$1) continuationImpl;
            int i = youTube$addSongToLibrary$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$addSongToLibrary$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$addSongToLibrary$1 = new YouTube$addSongToLibrary$1(this, continuationImpl);
            }
        } else {
            youTube$addSongToLibrary$1 = new YouTube$addSongToLibrary$1(this, continuationImpl);
        }
        Object obj = youTube$addSongToLibrary$1.result;
        int i2 = youTube$addSongToLibrary$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                WatchEndpoint watchEndpoint = new WatchEndpoint(62, str, null, null);
                youTube$addSongToLibrary$1.L$0 = str;
                youTube$addSongToLibrary$1.L$1 = this;
                youTube$addSongToLibrary$1.label = 1;
                objM1024next0E7RQCE = m1024next0E7RQCE(watchEndpoint, null, youTube$addSongToLibrary$1);
                if (objM1024next0E7RQCE == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                this = youTube$addSongToLibrary$1.L$1;
                str = youTube$addSongToLibrary$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1006feedbackgIAlus = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1006feedbackgIAlus);
            Boolean bool = (Boolean) objM1006feedbackgIAlus;
            bool.getClass();
            return bool;
            ResultKt.throwOnFailure(objM1024next0E7RQCE);
            Iterator it = ((NextResult) objM1024next0E7RQCE).items.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((SongItem) next).id, str));
            SongItem songItem = (SongItem) next;
            if (songItem == null) {
                throw new Exception("Song not found in next response");
            }
            String str2 = songItem.libraryAddToken;
            if (str2 == null) {
                throw new Exception("Add to library token not available");
            }
            List listListOf = CollectionsKt__IterablesKt.listOf(str2);
            youTube$addSongToLibrary$1.L$0 = null;
            youTube$addSongToLibrary$1.L$1 = null;
            youTube$addSongToLibrary$1.label = 2;
            objM1006feedbackgIAlus = this.m1006feedbackgIAlus(listListOf, youTube$addSongToLibrary$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: addToPlaylist-0E7RQCE, reason: not valid java name */
    public final Object m995addToPlaylist0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        YouTube$addToPlaylist$1 youTube$addToPlaylist$1;
        if (continuationImpl instanceof YouTube$addToPlaylist$1) {
            youTube$addToPlaylist$1 = (YouTube$addToPlaylist$1) continuationImpl;
            int i = youTube$addToPlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$addToPlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$addToPlaylist$1 = new YouTube$addToPlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$addToPlaylist$1 = new YouTube$addToPlaylist$1(this, continuationImpl);
        }
        Object objAddToPlaylist = youTube$addToPlaylist$1.result;
        int i2 = youTube$addToPlaylist$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAddToPlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$addToPlaylist$1.label = 1;
                objAddToPlaylist = innerTube2.addToPlaylist(youTubeClient, str, str2, youTube$addToPlaylist$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objAddToPlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objAddToPlaylist);
            }
            return (HttpResponse) objAddToPlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01db  */
    /* JADX WARN: Code duplicated, block: B:115:0x01eb A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0202  */
    /* JADX WARN: Code duplicated, block: B:150:0x024a  */
    /* JADX WARN: Code duplicated, block: B:172:0x028c  */
    /* JADX WARN: Code duplicated, block: B:196:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:222:0x0318  */
    /* JADX WARN: Code duplicated, block: B:225:0x032c A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:228:0x033f  */
    /* JADX WARN: Code duplicated, block: B:230:0x0348  */
    /* JADX WARN: Code duplicated, block: B:233:0x0351 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:251:0x0393 A[EDGE_INSN: B:251:0x0393->B:252:0x0394 BREAK  A[LOOP:3: B:243:0x0371->B:316:?]] */
    /* JADX WARN: Code duplicated, block: B:253:0x0396 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:255:0x039a A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:264:0x03bc A[Catch: all -> 0x0432, EDGE_INSN: B:264:0x03bc->B:265:0x03c4 BREAK  A[LOOP:0: B:259:0x03a5->B:303:?], TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:267:0x03cc A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:288:0x041e  */
    /* JADX WARN: Code duplicated, block: B:290:0x0421  */
    /* JADX WARN: Code duplicated, block: B:291:0x0422  */
    /* JADX WARN: Code duplicated, block: B:293:0x042a A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00cd A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:15:0x0037, B:229:0x0341, B:231:0x0349, B:233:0x0351, B:235:0x0355, B:237:0x035e, B:239:0x0366, B:253:0x0396, B:255:0x039a, B:258:0x03a1, B:259:0x03a5, B:261:0x03ab, B:264:0x03bc, B:265:0x03c4, B:267:0x03cc, B:269:0x03d0, B:271:0x03d4, B:273:0x03dc, B:275:0x03e0, B:277:0x03e4, B:278:0x03ed, B:280:0x03f3, B:282:0x03fd, B:283:0x0401, B:285:0x040c, B:287:0x041a, B:292:0x0423, B:242:0x036d, B:243:0x0371, B:245:0x0377, B:247:0x0387, B:249:0x038b, B:20:0x0053, B:39:0x00cd, B:42:0x00df, B:44:0x00e3, B:46:0x00e7, B:48:0x00eb, B:50:0x00ef, B:52:0x00f7, B:54:0x00fb, B:56:0x00ff, B:58:0x0103, B:60:0x010a, B:62:0x0115, B:64:0x011d, B:66:0x0124, B:70:0x013e, B:72:0x0146, B:74:0x014e, B:76:0x0152, B:78:0x015b, B:80:0x0163, B:82:0x0167, B:84:0x016b, B:86:0x0174, B:88:0x018a, B:90:0x018e, B:92:0x0192, B:94:0x019a, B:96:0x019e, B:98:0x01a2, B:100:0x01a6, B:102:0x01aa, B:104:0x01b2, B:106:0x01b6, B:108:0x01ba, B:110:0x01c9, B:112:0x01d7, B:114:0x01dc, B:115:0x01eb, B:117:0x01f1, B:119:0x01f5, B:121:0x01f9, B:123:0x0204, B:125:0x0209, B:127:0x020d, B:129:0x0211, B:131:0x0219, B:133:0x021d, B:135:0x0221, B:137:0x0225, B:139:0x0229, B:141:0x0231, B:143:0x0235, B:145:0x0239, B:147:0x023d, B:149:0x0245, B:151:0x024c, B:153:0x025b, B:155:0x025f, B:157:0x0263, B:159:0x0267, B:161:0x026b, B:163:0x0273, B:165:0x0277, B:167:0x027b, B:169:0x027f, B:173:0x028e, B:175:0x029a, B:177:0x029e, B:179:0x02a2, B:181:0x02a6, B:183:0x02aa, B:185:0x02b2, B:187:0x02b6, B:189:0x02ba, B:191:0x02be, B:193:0x02c6, B:195:0x02ca, B:197:0x02d3, B:199:0x02df, B:201:0x02e3, B:203:0x02e7, B:205:0x02eb, B:207:0x02ef, B:209:0x02f7, B:211:0x02fb, B:213:0x02ff, B:215:0x0303, B:217:0x0307, B:219:0x030b, B:221:0x0313, B:223:0x031a, B:225:0x032c, B:293:0x042a, B:294:0x0431, B:23:0x0065, B:30:0x009d, B:34:0x00af, B:26:0x0075), top: B:298:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:59:0x0108  */
    /* JADX WARN: Code duplicated, block: B:65:0x0122  */
    /* JADX WARN: Code duplicated, block: B:68:0x0139  */
    /* JADX WARN: Code duplicated, block: B:69:0x013c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0159  */
    /* JADX WARN: Code duplicated, block: B:85:0x0173  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.metrolist.innertube.YouTube, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.metrolist.innertube.models.Artist, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.metrolist.innertube.models.Artist] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.metrolist.innertube.YouTube] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.metrolist.innertube.models.Thumbnail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [kotlin.reflect.KType] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX INFO: renamed from: album-0E7RQCE, reason: not valid java name */
    public final Object m996album0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$album$1 youTube$album$1;
        AlbumItem albumItem;
        CoroutineSingletons coroutineSingletons;
        String str2;
        Object obj;
        boolean z2;
        ?? TypeOf;
        Object objBodyNullable;
        ?? r3;
        boolean z3;
        ?? r1;
        BrowseResponse browseResponse;
        BrowseResponse.Contents contents;
        BrowseResponse.Header header;
        BrowseResponse.Microformat microformat;
        ?? SubstringAfterLast;
        ?? r19;
        Tabs.Tab tab;
        ?? r20;
        Tabs.Tab tab2;
        ?? intOrNull;
        Tabs.Tab tab3;
        ?? r22;
        AlbumItem albumItem2;
        ?? r6;
        List list;
        Object objM997albumSongs0E7RQCE;
        Object obj2;
        BrowseResponse browseResponse2;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        SectionListRenderer.Content content2;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        Thumbnails thumbnails;
        List list3;
        Thumbnail thumbnail;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content3;
        SectionListRenderer sectionListRenderer2;
        List list4;
        SectionListRenderer.Content content4;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer2;
        Runs runs;
        List list5;
        Run run;
        String str3;
        Tabs.Tab.TabRenderer tabRenderer3;
        Tabs.Tab.TabRenderer.Content content5;
        SectionListRenderer sectionListRenderer3;
        List list6;
        SectionListRenderer.Content content6;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer3;
        Runs runs2;
        List list7;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        List list8;
        Tabs.Tab tab4;
        Tabs.Tab.TabRenderer tabRenderer4;
        Tabs.Tab.TabRenderer.Content content7;
        SectionListRenderer sectionListRenderer4;
        List list9;
        SectionListRenderer.Content content8;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer4;
        Runs runs3;
        List list10;
        Run run2;
        BrowseResponse.Microformat.MicroformatDataRenderer microformatDataRenderer;
        String str4;
        ?? r18;
        List list11;
        ?? r110;
        ArrayList arrayListExtractArtists;
        ?? r21;
        List list12;
        ?? intOrNull2;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer2;
        ?? r4;
        ?? arrayList;
        Tabs tabs;
        List list13;
        Tabs.Tab tab5;
        Tabs.Tab.TabRenderer tabRenderer5;
        Tabs.Tab.TabRenderer.Content content9;
        SectionListRenderer sectionListRenderer5;
        List list14;
        SectionListRenderer.Content content10;
        MusicShelfRenderer musicShelfRenderer;
        List list15;
        Thumbnails thumbnails2;
        List list16;
        Run run3;
        String str5;
        Run run4;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        Menu menu;
        Menu.MenuRenderer menuRenderer;
        List list17;
        Menu.MenuRenderer.TopLevelButton topLevelButton;
        Menu.MenuRenderer.TopLevelButton.ButtonRenderer buttonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        ?? r2;
        SongItem songItem;
        ?? r5;
        BrowseResponse.SecondaryContents secondaryContents;
        ?? arrayList2;
        ?? r12;
        SectionListRenderer sectionListRenderer6;
        List list18;
        SectionListRenderer.Content content11;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer;
        List list19;
        List list20;
        List list21;
        ?? r7;
        YouTube youTube = this;
        if (continuationImpl instanceof YouTube$album$1) {
            youTube$album$1 = (YouTube$album$1) continuationImpl;
            int i = youTube$album$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$album$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$album$1 = new YouTube$album$1(youTube, continuationImpl);
            }
        } else {
            youTube$album$1 = new YouTube$album$1(youTube, continuationImpl);
        }
        YouTube$album$1 youTube$album$2 = youTube$album$1;
        Object obj3 = youTube$album$2.result;
        int i2 = youTube$album$2.label;
        EmptyList emptyList = EmptyList.INSTANCE;
        int i3 = 0;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    albumItem = null;
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    coroutineSingletons = coroutineSingletons2;
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$album$2.L$0 = str;
                    youTube$album$2.L$1 = youTube;
                    youTube$album$2.Z$0 = z;
                    youTube$album$2.label = 1;
                    Object objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, null, null, false, youTube$album$2, 28);
                    if (objBrowse$default != coroutineSingletons) {
                        str2 = str;
                        obj = objBrowse$default;
                        z2 = z;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    boolean z4 = youTube$album$2.Z$0;
                    YouTube youTube2 = youTube$album$2.L$1;
                    str2 = youTube$album$2.L$0;
                    ResultKt.throwOnFailure(obj3);
                    z2 = z4;
                    youTube = youTube2;
                    coroutineSingletons = coroutineSingletons2;
                    obj = obj3;
                    albumItem = null;
                } else {
                    if (i2 == 2) {
                        z3 = youTube$album$2.Z$0;
                        YouTube youTube3 = youTube$album$2.L$1;
                        str2 = youTube$album$2.L$0;
                        ResultKt.throwOnFailure(obj3);
                        objBodyNullable = obj3;
                        r1 = 0;
                        r3 = youTube3;
                        coroutineSingletons = coroutineSingletons2;
                        if (objBodyNullable != null) {
                            r1 = albumItem;
                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                        }
                        r1 = albumItem;
                        browseResponse = (BrowseResponse) objBodyNullable;
                        contents = browseResponse.contents;
                        header = browseResponse.header;
                        if (StringsKt.contains(str2, "FEmusic_library_privately_owned_release_detail", false)) {
                            if (header != null || (musicDetailHeaderRenderer = header.musicDetailHeaderRenderer) == null || (menu = musicDetailHeaderRenderer.menu) == null || (menuRenderer = menu.menuRenderer) == null || (list17 = menuRenderer.topLevelButtons) == null || (topLevelButton = (Menu.MenuRenderer.TopLevelButton) CollectionsKt.firstOrNull(list17)) == null || (buttonRenderer = topLevelButton.buttonRenderer) == null || (navigationEndpoint = buttonRenderer.navigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchPlaylistEndpoint) == null) {
                                r18 = r1;
                            } else {
                                r18 = watchEndpoint.playlistId;
                            }
                            r18.getClass();
                            list11 = header.musicDetailHeaderRenderer.title.runs;
                            if (list11 != null || (run4 = (Run) CollectionsKt.firstOrNull(list11)) == null) {
                                r110 = r1;
                            } else {
                                r110 = run4.text;
                            }
                            r110.getClass();
                            Set set = PageHelper.LIBRARY_ADD_ICONS;
                            arrayListExtractArtists = PageHelper.extractArtists(header.musicDetailHeaderRenderer.subtitle.runs);
                            if (arrayListExtractArtists.isEmpty()) {
                                r21 = r1;
                            } else {
                                r21 = arrayListExtractArtists;
                            }
                            list12 = header.musicDetailHeaderRenderer.subtitle.runs;
                            if (list12 != null || (run3 = (Run) CollectionsKt.lastOrNull(list12)) == null || (str5 = run3.text) == null) {
                                intOrNull2 = r1;
                            } else {
                                intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull(10, str5);
                            }
                            musicThumbnailRenderer2 = header.musicDetailHeaderRenderer.thumbnail.croppedSquareThumbnailRenderer;
                            if (musicThumbnailRenderer2 != null || (thumbnails2 = musicThumbnailRenderer2.thumbnail) == null || (list16 = thumbnails2.thumbnails) == null) {
                                r4 = r1;
                            } else {
                                r4 = (Thumbnail) CollectionsKt.lastOrNull(list16);
                            }
                            r4.getClass();
                            AlbumItem albumItem3 = new AlbumItem(str2, (String) r18, (String) r110, (List) r21, (Integer) intOrNull2, r4.url, false, 4);
                            if (contents != null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list13 = tabs.tabs) == null || (tab5 = (Tabs.Tab) CollectionsKt.firstOrNull(list13)) == null || (tabRenderer5 = tab5.tabRenderer) == null || (content9 = tabRenderer5.content) == null || (sectionListRenderer5 = content9.sectionListRenderer) == null || (list14 = sectionListRenderer5.contents) == null || (content10 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list14)) == null || (musicShelfRenderer = content10.musicShelfRenderer) == null || (list15 = musicShelfRenderer.contents) == null) {
                                arrayList = r1;
                            } else {
                                ArrayList items = MusicShelfRendererKt.getItems(list15);
                                arrayList = new ArrayList();
                                int size = items.size();
                                while (i3 < size) {
                                    Object obj4 = items.get(i3);
                                    i3++;
                                    SongItem song = AlbumPage.Companion.getSong((MusicResponsiveListItemRenderer) obj4, albumItem3);
                                    if (song != null) {
                                        arrayList.add(song);
                                    }
                                }
                            }
                            arrayList.getClass();
                            return new AlbumPage(albumItem3, new ArrayList((Collection) arrayList), emptyList);
                        }
                        String str6 = str2;
                        microformat = browseResponse.microformat;
                        if (microformat != null || (microformatDataRenderer = microformat.microformatDataRenderer) == null || (str4 = microformatDataRenderer.urlCanonical) == null) {
                            SubstringAfterLast = r1;
                        } else {
                            SubstringAfterLast = StringsKt.substringAfterLast('=', str4, str4);
                        }
                        SubstringAfterLast.getClass();
                        if (contents != null || (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) == null || (list8 = twoColumnBrowseResultsRenderer.tabs) == null || (tab4 = (Tabs.Tab) CollectionsKt.firstOrNull(list8)) == null || (tabRenderer4 = tab4.tabRenderer) == null || (content7 = tabRenderer4.content) == null || (sectionListRenderer4 = content7.sectionListRenderer) == null || (list9 = sectionListRenderer4.contents) == null || (content8 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list9)) == null || (musicResponsiveHeaderRenderer4 = content8.musicResponsiveHeaderRenderer) == null || (runs3 = musicResponsiveHeaderRenderer4.title) == null || (list10 = runs3.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list10)) == null) {
                            r19 = r1;
                        } else {
                            r19 = run2.text;
                        }
                        r19.getClass();
                        tab = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                        if (tab != null || (tabRenderer3 = tab.tabRenderer) == null || (content5 = tabRenderer3.content) == null || (sectionListRenderer3 = content5.sectionListRenderer) == null || (list6 = sectionListRenderer3.contents) == null || (content6 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list6)) == null || (musicResponsiveHeaderRenderer3 = content6.musicResponsiveHeaderRenderer) == null || (runs2 = musicResponsiveHeaderRenderer3.straplineTextOne) == null || (list7 = runs2.runs) == null) {
                            r20 = r1;
                        } else {
                            ArrayList arrayListExtractArtists2 = PageHelper.extractArtists(list7);
                            if (arrayListExtractArtists2.isEmpty()) {
                                r20 = r1;
                            } else {
                                r20 = arrayListExtractArtists2;
                            }
                        }
                        tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                        if (tab2 != null || (tabRenderer2 = tab2.tabRenderer) == null || (content3 = tabRenderer2.content) == null || (sectionListRenderer2 = content3.sectionListRenderer) == null || (list4 = sectionListRenderer2.contents) == null || (content4 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list4)) == null || (musicResponsiveHeaderRenderer2 = content4.musicResponsiveHeaderRenderer) == null || (runs = musicResponsiveHeaderRenderer2.subtitle) == null || (list5 = runs.runs) == null || (run = (Run) CollectionsKt.lastOrNull(list5)) == null || (str3 = run.text) == null) {
                            intOrNull = r1;
                        } else {
                            intOrNull = StringsKt__StringsJVMKt.toIntOrNull(10, str3);
                        }
                        tab3 = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                        if (tab3 != null || (tabRenderer = tab3.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null || (list2 = sectionListRenderer.contents) == null || (content2 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list2)) == null || (musicResponsiveHeaderRenderer = content2.musicResponsiveHeaderRenderer) == null || (thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) == null || (thumbnails = musicThumbnailRenderer.thumbnail) == null || (list3 = thumbnails.thumbnails) == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull(list3)) == null) {
                            r22 = r1;
                        } else {
                            r22 = thumbnail.url;
                        }
                        r22.getClass();
                        albumItem2 = new AlbumItem(str6, (String) SubstringAfterLast, (String) r19, (List) r20, (Integer) intOrNull, (String) r22, false, 4);
                        r6 = SubstringAfterLast;
                        if (z3) {
                            youTube$album$2.L$0 = r1;
                            youTube$album$2.L$1 = r1;
                            youTube$album$2.L$3 = albumItem2;
                            youTube$album$2.L$4 = browseResponse;
                            youTube$album$2.Z$0 = z3;
                            youTube$album$2.label = 3;
                            objM997albumSongs0E7RQCE = r3.m997albumSongs0E7RQCE(r6, albumItem2, youTube$album$2);
                            if (objM997albumSongs0E7RQCE != coroutineSingletons) {
                                obj2 = objM997albumSongs0E7RQCE;
                                browseResponse2 = browseResponse;
                                r7 = r1;
                            }
                            return coroutineSingletons;
                        }
                        list = emptyList;
                        r2 = r1;
                        songItem = (SongItem) CollectionsKt.firstOrNull(list);
                        if (songItem != null || (list21 = songItem.artists) == null || (r5 = (Artist) CollectionsKt.firstOrNull(list21)) == 0 || StringsKt.isBlank(r5.name)) {
                            r5 = r2;
                            break;
                        }
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                Artist artist = (Artist) CollectionsKt.firstOrNull(((SongItem) it.next()).artists);
                                if (!Intrinsics.areEqual((Object) (artist != null ? artist.name : r2), r5.name)) {
                                    r5 = r2;
                                    break;
                                }
                            }
                        }
                        if (r5 != 0) {
                            list20 = albumItem2.artists;
                            if (list20 == null && !list20.isEmpty()) {
                                Iterator it2 = list20.iterator();
                                do {
                                    if (!it2.hasNext()) {
                                        albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                                        break;
                                    }
                                } while (!Intrinsics.areEqual(((Artist) it2.next()).name, r5.name));
                            } else {
                                albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                                break;
                            }
                        }
                        secondaryContents = browseResponse.contents.twoColumnBrowseResultsRenderer.secondaryContents;
                        if (secondaryContents != null || (sectionListRenderer6 = secondaryContents.sectionListRenderer) == null || (list18 = sectionListRenderer6.contents) == null || (content11 = (SectionListRenderer.Content) CollectionsKt.getOrNull(1, list18)) == null || (musicCarouselShelfRenderer = content11.musicCarouselShelfRenderer) == null || (list19 = musicCarouselShelfRenderer.contents) == null) {
                            arrayList2 = r2;
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it3 = list19.iterator();
                            while (it3.hasNext()) {
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((MusicCarouselShelfRenderer.Content) it3.next()).musicTwoRowItemRenderer;
                                if (musicTwoRowItemRenderer != null) {
                                    arrayList3.add(musicTwoRowItemRenderer);
                                }
                            }
                            arrayList2 = new ArrayList();
                            int size2 = arrayList3.size();
                            while (i3 < size2) {
                                Object obj5 = arrayList3.get(i3);
                                i3++;
                                AlbumItem albumItemFromMusicTwoRowItemRenderer = NewReleaseAlbumPage.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj5);
                                if (albumItemFromMusicTwoRowItemRenderer != null) {
                                    arrayList2.add(albumItemFromMusicTwoRowItemRenderer);
                                }
                            }
                        }
                        if (arrayList2 == 0) {
                            r12 = emptyList;
                        } else {
                            r12 = arrayList2;
                        }
                        return new AlbumPage(albumItem2, list, r12);
                    }
                    if (i2 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    browseResponse2 = youTube$album$2.L$4;
                    AlbumItem albumItem4 = youTube$album$2.L$3;
                    ResultKt.throwOnFailure(obj3);
                    albumItem2 = albumItem4;
                    obj2 = ((Result) obj3).value;
                    r7 = 0;
                }
                ResultKt.throwOnFailure(obj2);
                browseResponse = browseResponse2;
                r2 = r7;
                list = (List) obj2;
                songItem = (SongItem) CollectionsKt.firstOrNull(list);
                if (songItem != null) {
                    r5 = r2;
                    break;
                }
                r5 = r2;
                break;
                if (r5 != 0) {
                    list20 = albumItem2.artists;
                    if (list20 == null) {
                        albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                        break;
                    }
                    albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                    break;
                }
                secondaryContents = browseResponse.contents.twoColumnBrowseResultsRenderer.secondaryContents;
                if (secondaryContents != null) {
                    arrayList2 = r2;
                } else {
                    arrayList2 = r2;
                }
                if (arrayList2 == 0) {
                    r12 = emptyList;
                } else {
                    r12 = arrayList2;
                }
                return new AlbumPage(albumItem2, list, r12);
                TypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                TypeOf = albumItem;
            }
            HttpClientCall call = ((HttpResponse) obj).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) TypeOf);
            youTube$album$2.L$0 = str2;
            youTube$album$2.L$1 = youTube;
            youTube$album$2.L$3 = albumItem;
            youTube$album$2.Z$0 = z2;
            youTube$album$2.label = 2;
            objBodyNullable = call.bodyNullable(typeInfo, youTube$album$2);
            if (objBodyNullable != coroutineSingletons) {
                boolean z5 = z2;
                r3 = youTube;
                z3 = z5;
                if (objBodyNullable != null) {
                    r1 = albumItem;
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                r1 = albumItem;
                browseResponse = (BrowseResponse) objBodyNullable;
                contents = browseResponse.contents;
                header = browseResponse.header;
                if (StringsKt.contains(str2, "FEmusic_library_privately_owned_release_detail", false)) {
                    if (header != null) {
                        r18 = r1;
                    } else {
                        r18 = r1;
                    }
                    r18.getClass();
                    list11 = header.musicDetailHeaderRenderer.title.runs;
                    if (list11 != null) {
                        r110 = r1;
                    } else {
                        r110 = r1;
                    }
                    r110.getClass();
                    Set set2 = PageHelper.LIBRARY_ADD_ICONS;
                    arrayListExtractArtists = PageHelper.extractArtists(header.musicDetailHeaderRenderer.subtitle.runs);
                    if (arrayListExtractArtists.isEmpty()) {
                        r21 = arrayListExtractArtists;
                    } else {
                        r21 = r1;
                    }
                    list12 = header.musicDetailHeaderRenderer.subtitle.runs;
                    if (list12 != null) {
                        intOrNull2 = r1;
                    } else {
                        intOrNull2 = r1;
                    }
                    musicThumbnailRenderer2 = header.musicDetailHeaderRenderer.thumbnail.croppedSquareThumbnailRenderer;
                    if (musicThumbnailRenderer2 != null) {
                        r4 = r1;
                    } else {
                        r4 = r1;
                    }
                    r4.getClass();
                    AlbumItem albumItem5 = new AlbumItem(str2, (String) r18, (String) r110, (List) r21, (Integer) intOrNull2, r4.url, false, 4);
                    if (contents != null) {
                        arrayList = r1;
                    } else {
                        arrayList = r1;
                    }
                    arrayList.getClass();
                    return new AlbumPage(albumItem5, new ArrayList((Collection) arrayList), emptyList);
                }
                String str7 = str2;
                microformat = browseResponse.microformat;
                if (microformat != null) {
                    SubstringAfterLast = r1;
                } else {
                    SubstringAfterLast = r1;
                }
                SubstringAfterLast.getClass();
                if (contents != null) {
                    r19 = r1;
                } else {
                    r19 = r1;
                }
                r19.getClass();
                tab = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                if (tab != null) {
                    r20 = r1;
                } else {
                    r20 = r1;
                }
                tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                if (tab2 != null) {
                    intOrNull = r1;
                } else {
                    intOrNull = r1;
                }
                tab3 = (Tabs.Tab) CollectionsKt.firstOrNull(contents.twoColumnBrowseResultsRenderer.tabs);
                if (tab3 != null) {
                    r22 = r1;
                } else {
                    r22 = r1;
                }
                r22.getClass();
                albumItem2 = new AlbumItem(str7, (String) SubstringAfterLast, (String) r19, (List) r20, (Integer) intOrNull, (String) r22, false, 4);
                r6 = SubstringAfterLast;
                if (z3) {
                    youTube$album$2.L$0 = r1;
                    youTube$album$2.L$1 = r1;
                    youTube$album$2.L$3 = albumItem2;
                    youTube$album$2.L$4 = browseResponse;
                    youTube$album$2.Z$0 = z3;
                    youTube$album$2.label = 3;
                    objM997albumSongs0E7RQCE = r3.m997albumSongs0E7RQCE(r6, albumItem2, youTube$album$2);
                    if (objM997albumSongs0E7RQCE != coroutineSingletons) {
                        obj2 = objM997albumSongs0E7RQCE;
                        browseResponse2 = browseResponse;
                        r7 = r1;
                        ResultKt.throwOnFailure(obj2);
                        browseResponse = browseResponse2;
                        r2 = r7;
                        list = (List) obj2;
                    }
                } else {
                    list = emptyList;
                    r2 = r1;
                }
                songItem = (SongItem) CollectionsKt.firstOrNull(list);
                if (songItem != null) {
                    r5 = r2;
                    break;
                }
                r5 = r2;
                break;
                if (r5 != 0) {
                    list20 = albumItem2.artists;
                    if (list20 == null) {
                        albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                        break;
                    }
                    albumItem2 = AlbumItem.copy$default(albumItem2, CollectionsKt__IterablesKt.listOf((Object) r5));
                    break;
                }
                secondaryContents = browseResponse.contents.twoColumnBrowseResultsRenderer.secondaryContents;
                if (secondaryContents != null) {
                    arrayList2 = r2;
                } else {
                    arrayList2 = r2;
                }
                if (arrayList2 == 0) {
                    r12 = emptyList;
                } else {
                    r12 = arrayList2;
                }
                return new AlbumPage(albumItem2, list, r12);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x020d  */
    /* JADX WARN: Code duplicated, block: B:106:0x0211  */
    /* JADX WARN: Code duplicated, block: B:109:0x0219 A[Catch: all -> 0x023c, TryCatch #1 {all -> 0x023c, blocks: (B:16:0x0049, B:90:0x01d3, B:92:0x01d9, B:94:0x01e1, B:96:0x01e5, B:98:0x01e9, B:100:0x01f8, B:102:0x0208, B:107:0x0212, B:109:0x0219, B:111:0x021d, B:113:0x0221, B:74:0x0160, B:77:0x0168, B:81:0x01a0, B:85:0x01b1, B:116:0x0230, B:117:0x0235, B:21:0x006d, B:24:0x0080, B:42:0x00ef, B:44:0x00f5, B:46:0x00f9, B:48:0x00fd, B:50:0x0101, B:52:0x0105, B:55:0x0110, B:57:0x0114, B:66:0x0127, B:68:0x0137, B:70:0x0145, B:71:0x0149, B:60:0x011a, B:62:0x011e, B:118:0x0236, B:119:0x023b, B:27:0x008a, B:34:0x00cb, B:38:0x00dc, B:30:0x0097), top: B:125:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0226  */
    /* JADX WARN: Code duplicated, block: B:116:0x0230 A[Catch: all -> 0x023c, TryCatch #1 {all -> 0x023c, blocks: (B:16:0x0049, B:90:0x01d3, B:92:0x01d9, B:94:0x01e1, B:96:0x01e5, B:98:0x01e9, B:100:0x01f8, B:102:0x0208, B:107:0x0212, B:109:0x0219, B:111:0x021d, B:113:0x0221, B:74:0x0160, B:77:0x0168, B:81:0x01a0, B:85:0x01b1, B:116:0x0230, B:117:0x0235, B:21:0x006d, B:24:0x0080, B:42:0x00ef, B:44:0x00f5, B:46:0x00f9, B:48:0x00fd, B:50:0x0101, B:52:0x0105, B:55:0x0110, B:57:0x0114, B:66:0x0127, B:68:0x0137, B:70:0x0145, B:71:0x0149, B:60:0x011a, B:62:0x011e, B:118:0x0236, B:119:0x023b, B:27:0x008a, B:34:0x00cb, B:38:0x00dc, B:30:0x0097), top: B:125:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:136:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x0197  */
    /* JADX WARN: Code duplicated, block: B:80:0x0198  */
    /* JADX WARN: Code duplicated, block: B:88:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d3 A[Catch: all -> 0x023c, TryCatch #1 {all -> 0x023c, blocks: (B:16:0x0049, B:90:0x01d3, B:92:0x01d9, B:94:0x01e1, B:96:0x01e5, B:98:0x01e9, B:100:0x01f8, B:102:0x0208, B:107:0x0212, B:109:0x0219, B:111:0x021d, B:113:0x0221, B:74:0x0160, B:77:0x0168, B:81:0x01a0, B:85:0x01b1, B:116:0x0230, B:117:0x0235, B:21:0x006d, B:24:0x0080, B:42:0x00ef, B:44:0x00f5, B:46:0x00f9, B:48:0x00fd, B:50:0x0101, B:52:0x0105, B:55:0x0110, B:57:0x0114, B:66:0x0127, B:68:0x0137, B:70:0x0145, B:71:0x0149, B:60:0x011a, B:62:0x011e, B:118:0x0236, B:119:0x023b, B:27:0x008a, B:34:0x00cb, B:38:0x00dc, B:30:0x0097), top: B:125:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d9 A[Catch: all -> 0x023c, TryCatch #1 {all -> 0x023c, blocks: (B:16:0x0049, B:90:0x01d3, B:92:0x01d9, B:94:0x01e1, B:96:0x01e5, B:98:0x01e9, B:100:0x01f8, B:102:0x0208, B:107:0x0212, B:109:0x0219, B:111:0x021d, B:113:0x0221, B:74:0x0160, B:77:0x0168, B:81:0x01a0, B:85:0x01b1, B:116:0x0230, B:117:0x0235, B:21:0x006d, B:24:0x0080, B:42:0x00ef, B:44:0x00f5, B:46:0x00f9, B:48:0x00fd, B:50:0x0101, B:52:0x0105, B:55:0x0110, B:57:0x0114, B:66:0x0127, B:68:0x0137, B:70:0x0145, B:71:0x0149, B:60:0x011a, B:62:0x011e, B:118:0x0236, B:119:0x023b, B:27:0x008a, B:34:0x00cb, B:38:0x00dc, B:30:0x0097), top: B:125:0x0033 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x01cc -> B:89:0x01d1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: renamed from: albumSongs-0E7RQCE, reason: not valid java name */
    public final java.lang.Object m997albumSongs0E7RQCE(java.lang.String r27, com.metrolist.innertube.models.AlbumItem r28, kotlin.coroutines.jvm.internal.ContinuationImpl r29) {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.metrolist.innertube.YouTube.m997albumSongs0E7RQCE(java.lang.String, com.metrolist.innertube.models.AlbumItem, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r13 == r12) goto L32;
     */
    /* JADX INFO: renamed from: artist-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m998artistgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$artist$1 youTube$artist$1;
        String str2;
        TypeReference typeReferenceTypeOf;
        ArrayList arrayListArtist_gIAlu_s$lambda$0$mapRuns;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer;
        Runs runs;
        List list;
        String str3;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer;
        Runs runs2;
        List list2;
        Run run;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer;
        Runs runs3;
        List list3;
        Run run2;
        String thumbnailUrl;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer2;
        ThumbnailRenderer thumbnailRenderer2;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer2;
        String str4;
        WatchEndpoint watchEndpoint;
        Tabs tabs;
        List list4;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list5;
        SectionListRenderer.Content content2;
        MusicShelfRenderer musicShelfRenderer;
        List list6;
        MusicShelfRenderer.Content content3;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        NavigationEndpoint navigationEndpoint;
        ArrayList arrayList;
        ArrayList arrayList2;
        String strJoinToString$default;
        String str5;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer2;
        SubscriptionButton subscriptionButton;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer;
        Runs runs4;
        List list7;
        Run run3;
        String str6;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer3;
        SubscriptionButton subscriptionButton2;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer2;
        Runs runs5;
        List list8;
        Run run4;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer4;
        Runs runs6;
        List list9;
        Run run5;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer5;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2 subscriptionButton3;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer.SubscriptionButton2.SubscribeButtonRenderer subscribeButtonRenderer3;
        Runs runs7;
        List list10;
        Run run6;
        Tabs tabs2;
        List list11;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content4;
        SectionListRenderer sectionListRenderer2;
        List list12;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer6;
        Button button;
        Button.ButtonRenderer buttonRenderer;
        NavigationEndpoint navigationEndpoint2;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer7;
        Button button2;
        Button.ButtonRenderer buttonRenderer2;
        NavigationEndpoint navigationEndpoint3;
        Tabs tabs3;
        List list13;
        Tabs.Tab tab3;
        Tabs.Tab.TabRenderer tabRenderer3;
        Tabs.Tab.TabRenderer.Content content5;
        SectionListRenderer sectionListRenderer3;
        List list14;
        SectionListRenderer.Content content6;
        MusicShelfRenderer musicShelfRenderer2;
        List list15;
        MusicShelfRenderer.Content content7;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2;
        MusicResponsiveListItemRenderer.Overlay overlay;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content8;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint4;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer8;
        SubscriptionButton subscriptionButton4;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer4;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer9;
        ThumbnailRenderer thumbnailRenderer3;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer3;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer10;
        Runs runs8;
        List list16;
        Run run7;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer3;
        SubscriptionButton subscriptionButton5;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer5;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer4;
        SubscriptionButton subscriptionButton6;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer6;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer11;
        SubscriptionButton subscriptionButton7;
        SubscriptionButton.SubscribeButtonRenderer subscribeButtonRenderer7;
        SectionListRenderer sectionListRenderer4;
        List list17;
        Object next;
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer;
        Runs runs9;
        List list18;
        if (continuationImpl instanceof YouTube$artist$1) {
            youTube$artist$1 = (YouTube$artist$1) continuationImpl;
            int i = youTube$artist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$artist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$artist$1 = new YouTube$artist$1(this, continuationImpl);
            }
        } else {
            youTube$artist$1 = new YouTube$artist$1(this, continuationImpl);
        }
        YouTube$artist$1 youTube$artist$2 = youTube$artist$1;
        Object objBrowse$default = youTube$artist$2.result;
        int i2 = youTube$artist$2.label;
        boolean zBooleanValue = false;
        byte b = 1;
        String str7 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$artist$2.L$0 = str;
                    youTube$artist$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, null, null, false, youTube$artist$2, 28);
                    if (objBrowse$default != coroutineSingletons) {
                        str2 = str;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    str2 = youTube$artist$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    str2 = youTube$artist$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                String str8 = str2;
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.Contents contents = browseResponse.contents;
                BrowseResponse.Header header = browseResponse.header;
                if (contents != null && (sectionListRenderer4 = contents.sectionListRenderer) != null && (list17 = sectionListRenderer4.contents) != null) {
                    Iterator it = list17.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (((SectionListRenderer.Content) next).musicDescriptionShelfRenderer == null);
                    SectionListRenderer.Content content9 = (SectionListRenderer.Content) next;
                    if (content9 == null || (musicDescriptionShelfRenderer = content9.musicDescriptionShelfRenderer) == null || (runs9 = musicDescriptionShelfRenderer.description) == null || (list18 = runs9.runs) == null || (arrayListArtist_gIAlu_s$lambda$0$mapRuns = artist_gIAlu_s$lambda$0$mapRuns(list18)) == null) {
                        if (header != null) {
                            arrayListArtist_gIAlu_s$lambda$0$mapRuns = null;
                        } else {
                            arrayListArtist_gIAlu_s$lambda$0$mapRuns = null;
                        }
                    }
                } else if (header != null || (musicImmersiveHeaderRenderer = header.musicImmersiveHeaderRenderer) == null || (runs = musicImmersiveHeaderRenderer.description) == null || (list = runs.runs) == null) {
                    arrayListArtist_gIAlu_s$lambda$0$mapRuns = null;
                } else {
                    arrayListArtist_gIAlu_s$lambda$0$mapRuns = artist_gIAlu_s$lambda$0$mapRuns(list);
                }
                Boolean boolValueOf = (header == null || (musicImmersiveHeaderRenderer11 = header.musicImmersiveHeaderRenderer) == null || (subscriptionButton7 = musicImmersiveHeaderRenderer11.subscriptionButton) == null || (subscribeButtonRenderer7 = subscriptionButton7.subscribeButtonRenderer) == null) ? null : Boolean.valueOf(subscribeButtonRenderer7.subscribed);
                Boolean boolValueOf2 = (header == null || (musicVisualHeaderRenderer4 = header.musicVisualHeaderRenderer) == null || (subscriptionButton6 = musicVisualHeaderRenderer4.subscriptionButton) == null || (subscribeButtonRenderer6 = subscriptionButton6.subscribeButtonRenderer) == null) ? null : Boolean.valueOf(subscribeButtonRenderer6.subscribed);
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                } else if (boolValueOf2 != null) {
                    zBooleanValue = boolValueOf2.booleanValue();
                }
                boolean z = zBooleanValue;
                String str9 = (header == null || (musicVisualHeaderRenderer3 = header.musicVisualHeaderRenderer) == null || (subscriptionButton5 = musicVisualHeaderRenderer3.subscriptionButton) == null || (subscribeButtonRenderer5 = subscriptionButton5.subscribeButtonRenderer) == null) ? null : subscribeButtonRenderer5.channelId;
                if (header == null || (musicImmersiveHeaderRenderer10 = header.musicImmersiveHeaderRenderer) == null || (runs8 = musicImmersiveHeaderRenderer10.title) == null || (list16 = runs8.runs) == null || (run7 = (Run) CollectionsKt.firstOrNull(list16)) == null || (str3 = run7.text) == null) {
                    if (header == null || (musicVisualHeaderRenderer = header.musicVisualHeaderRenderer) == null || (runs3 = musicVisualHeaderRenderer.title) == null || (list3 = runs3.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                        str3 = (header == null || (musicHeaderRenderer = header.musicHeaderRenderer) == null || (runs2 = musicHeaderRenderer.title) == null || (list2 = runs2.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list2)) == null) ? null : run.text;
                        str3.getClass();
                    } else {
                        str3 = run2.text;
                    }
                }
                if (header == null || (musicImmersiveHeaderRenderer9 = header.musicImmersiveHeaderRenderer) == null || (thumbnailRenderer3 = musicImmersiveHeaderRenderer9.thumbnail) == null || (musicThumbnailRenderer3 = thumbnailRenderer3.musicThumbnailRenderer) == null || (thumbnailUrl = musicThumbnailRenderer3.getThumbnailUrl()) == null) {
                    thumbnailUrl = (header == null || (musicVisualHeaderRenderer2 = header.musicVisualHeaderRenderer) == null || (thumbnailRenderer2 = musicVisualHeaderRenderer2.foregroundThumbnail) == null || (musicThumbnailRenderer2 = thumbnailRenderer2.musicThumbnailRenderer) == null) ? null : musicThumbnailRenderer2.getThumbnailUrl();
                    if (thumbnailUrl == null) {
                        thumbnailUrl = (header == null || (musicDetailHeaderRenderer = header.musicDetailHeaderRenderer) == null || (thumbnailRenderer = musicDetailHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) == null) ? null : musicThumbnailRenderer.getThumbnailUrl();
                    }
                }
                if (header == null || (musicImmersiveHeaderRenderer8 = header.musicImmersiveHeaderRenderer) == null || (subscriptionButton4 = musicImmersiveHeaderRenderer8.subscriptionButton) == null || (subscribeButtonRenderer4 = subscriptionButton4.subscribeButtonRenderer) == null || (str4 = subscribeButtonRenderer4.channelId) == null) {
                    str4 = str9;
                }
                WatchEndpoint watchEndpoint2 = (contents == null || (tabs3 = contents.singleColumnBrowseResultsRenderer) == null || (list13 = tabs3.tabs) == null || (tab3 = (Tabs.Tab) CollectionsKt.firstOrNull(list13)) == null || (tabRenderer3 = tab3.tabRenderer) == null || (content5 = tabRenderer3.content) == null || (sectionListRenderer3 = content5.sectionListRenderer) == null || (list14 = sectionListRenderer3.contents) == null || (content6 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list14)) == null || (musicShelfRenderer2 = content6.musicShelfRenderer) == null || (list15 = musicShelfRenderer2.contents) == null || (content7 = (MusicShelfRenderer.Content) CollectionsKt.firstOrNull(list15)) == null || (musicResponsiveListItemRenderer2 = content7.musicResponsiveListItemRenderer) == null || (overlay = musicResponsiveListItemRenderer2.overlay) == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content8 = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content8.musicPlayButtonRenderer) == null || (navigationEndpoint4 = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint4.watchEndpoint;
                if (header != null && (musicImmersiveHeaderRenderer7 = header.musicImmersiveHeaderRenderer) != null && (button2 = musicImmersiveHeaderRenderer7.playButton) != null && (buttonRenderer2 = button2.buttonRenderer) != null && (navigationEndpoint3 = buttonRenderer2.navigationEndpoint) != null && (watchEndpoint = navigationEndpoint3.watchEndpoint) != null) {
                    watchEndpoint = watchEndpoint;
                } else if (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list4 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list4)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null || (list5 = sectionListRenderer.contents) == null || (content2 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list5)) == null || (musicShelfRenderer = content2.musicShelfRenderer) == null || (list6 = musicShelfRenderer.contents) == null || (content3 = (MusicShelfRenderer.Content) CollectionsKt.firstOrNull(list6)) == null || (musicResponsiveListItemRenderer = content3.musicResponsiveListItemRenderer) == null || (navigationEndpoint = musicResponsiveListItemRenderer.navigationEndpoint) == null) {
                    watchEndpoint = null;
                } else {
                    WatchEndpoint watchEndpoint3 = navigationEndpoint.watchPlaylistEndpoint;
                    watchEndpoint = watchEndpoint3;
                }
                ArtistItem artistItem = new ArtistItem(str8, str3, thumbnailUrl, str4, watchEndpoint2, watchEndpoint, (header == null || (musicImmersiveHeaderRenderer6 = header.musicImmersiveHeaderRenderer) == null || (button = musicImmersiveHeaderRenderer6.startRadioButton) == null || (buttonRenderer = button.buttonRenderer) == null || (navigationEndpoint2 = buttonRenderer.navigationEndpoint) == null) ? null : navigationEndpoint2.watchEndpoint, 128);
                if (contents == null || (tabs2 = contents.singleColumnBrowseResultsRenderer) == null || (list11 = tabs2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(list11)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (content4 = tabRenderer2.content) == null || (sectionListRenderer2 = content4.sectionListRenderer) == null || (list12 = sectionListRenderer2.contents) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = list12.iterator();
                    while (it2.hasNext()) {
                        ArtistSection artistSectionFromSectionListRendererContent = ArtistPage.Companion.fromSectionListRendererContent((SectionListRenderer.Content) it2.next());
                        if (artistSectionFromSectionListRendererContent != null) {
                            arrayList3.add(artistSectionFromSectionListRendererContent);
                        }
                    }
                    arrayList = arrayList3;
                }
                arrayList.getClass();
                if (arrayListArtist_gIAlu_s$lambda$0$mapRuns != null) {
                    arrayList2 = arrayListArtist_gIAlu_s$lambda$0$mapRuns;
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, "", null, null, new YouTube$$ExternalSyntheticLambda2(b), 30);
                } else {
                    arrayList2 = arrayListArtist_gIAlu_s$lambda$0$mapRuns;
                    strJoinToString$default = null;
                }
                if (header == null || (musicImmersiveHeaderRenderer5 = header.musicImmersiveHeaderRenderer) == null || (subscriptionButton3 = musicImmersiveHeaderRenderer5.subscriptionButton2) == null || (subscribeButtonRenderer3 = subscriptionButton3.subscribeButtonRenderer) == null || (runs7 = subscribeButtonRenderer3.subscriberCountWithSubscribeText) == null || (list10 = runs7.runs) == null || (run6 = (Run) CollectionsKt.firstOrNull(list10)) == null || (str6 = run6.text) == null) {
                    if (header != null && (musicImmersiveHeaderRenderer3 = header.musicImmersiveHeaderRenderer) != null && (subscriptionButton2 = musicImmersiveHeaderRenderer3.subscriptionButton) != null && (subscribeButtonRenderer2 = subscriptionButton2.subscribeButtonRenderer) != null && (runs5 = subscribeButtonRenderer2.longSubscriberCountText) != null && (list8 = runs5.runs) != null && (run4 = (Run) CollectionsKt.firstOrNull(list8)) != null) {
                        str6 = run4.text;
                    } else if (header == null || (musicImmersiveHeaderRenderer2 = header.musicImmersiveHeaderRenderer) == null || (subscriptionButton = musicImmersiveHeaderRenderer2.subscriptionButton) == null || (subscribeButtonRenderer = subscriptionButton.subscribeButtonRenderer) == null || (runs4 = subscribeButtonRenderer.shortSubscriberCountText) == null || (list7 = runs4.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list7)) == null) {
                        str5 = null;
                    } else {
                        str6 = run3.text;
                    }
                    str5 = str6;
                } else {
                    str5 = str6;
                }
                if (header != null && (musicImmersiveHeaderRenderer4 = header.musicImmersiveHeaderRenderer) != null && (runs6 = musicImmersiveHeaderRenderer4.monthlyListenerCount) != null && (list9 = runs6.runs) != null && (run5 = (Run) CollectionsKt.firstOrNull(list9)) != null) {
                    str7 = run5.text;
                }
                return new ArtistPage(artistItem, arrayList, strJoinToString$default, str5, str7, arrayList2, z);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$artist$2.L$0 = str2;
            youTube$artist$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$artist$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.util.List] */
    /* JADX INFO: renamed from: artistItems-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m999artistItemsgIAlus(BrowseEndpoint browseEndpoint, ContinuationImpl continuationImpl) {
        YouTube$artistItems$1 youTube$artistItems$1;
        TypeReference typeReferenceTypeOf;
        List list;
        List list2;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer;
        Runs runs;
        List list3;
        Run run;
        String str;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer2;
        Runs runs2;
        List list4;
        Run run2;
        List list5;
        Run run3;
        String str2;
        YTItem yTItemFromMusicResponsiveListItemRenderer;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
        Runs runs3;
        List list6;
        Run run4;
        GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer;
        Runs runs4;
        List list7;
        Run run5;
        Tabs tabs;
        List list8;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list9;
        if (continuationImpl instanceof YouTube$artistItems$1) {
            youTube$artistItems$1 = (YouTube$artistItems$1) continuationImpl;
            int i = youTube$artistItems$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$artistItems$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$artistItems$1 = new YouTube$artistItems$1(this, continuationImpl);
            }
        } else {
            youTube$artistItems$1 = new YouTube$artistItems$1(this, continuationImpl);
        }
        YouTube$artistItems$1 youTube$artistItems$2 = youTube$artistItems$1;
        Object objBrowse$default = youTube$artistItems$2.result;
        int i2 = youTube$artistItems$2.label;
        int i3 = 0;
        String continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    String str3 = browseEndpoint.browseId;
                    String str4 = browseEndpoint.params;
                    youTube$artistItems$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str3, str4, null, false, youTube$artistItems$2, 24);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.Header header = browseResponse.header;
                BrowseResponse.Contents contents = browseResponse.contents;
                SectionListRenderer.Content content2 = (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list8 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list8)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null || (list9 = sectionListRenderer.contents) == null) ? null : (SectionListRenderer.Content) CollectionsKt.firstOrNull(list9);
                GridRenderer gridRenderer = content2 != null ? content2.gridRenderer : null;
                MusicCarouselShelfRenderer musicCarouselShelfRenderer = content2 != null ? content2.musicCarouselShelfRenderer : null;
                MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = content2 != null ? content2.musicPlaylistShelfRenderer : null;
                MusicShelfRenderer musicShelfRenderer = content2 != null ? content2.musicShelfRenderer : null;
                String str5 = "";
                if (gridRenderer != null) {
                    GridRenderer.Header header2 = gridRenderer.header;
                    String str6 = (header2 == null || (gridHeaderRenderer = header2.gridHeaderRenderer) == null || (runs4 = gridHeaderRenderer.title) == null || (list7 = runs4.runs) == null || (run5 = (Run) CollectionsKt.firstOrNull(list7)) == null) ? null : run5.text;
                    if (str6 != null) {
                        str5 = str6;
                    }
                    List list10 = gridRenderer.items;
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list10.iterator();
                    while (it.hasNext()) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                        YTItem yTItemFromMusicTwoRowItemRenderer = musicTwoRowItemRenderer != null ? ArtistItemsPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer) : null;
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    List list11 = gridRenderer.continuations;
                    return new ArtistItemsPage(str5, list11 != null ? ContinuationKt.getContinuation(list11) : null, arrayList);
                }
                if (musicCarouselShelfRenderer != null) {
                    MusicCarouselShelfRenderer.Header header3 = musicCarouselShelfRenderer.header;
                    String str7 = (header3 == null || (musicCarouselShelfBasicHeaderRenderer = header3.musicCarouselShelfBasicHeaderRenderer) == null || (runs3 = musicCarouselShelfBasicHeaderRenderer.title) == null || (list6 = runs3.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list6)) == null) ? null : run4.text;
                    if (str7 != null) {
                        str5 = str7;
                    }
                    List<MusicCarouselShelfRenderer.Content> list12 = musicCarouselShelfRenderer.contents;
                    ArrayList arrayList2 = new ArrayList();
                    for (MusicCarouselShelfRenderer.Content content3 : list12) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = content3.musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer2 == null || (yTItemFromMusicResponsiveListItemRenderer = ArtistItemsPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer2)) == null) {
                            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = content3.musicResponsiveListItemRenderer;
                            yTItemFromMusicResponsiveListItemRenderer = musicResponsiveListItemRenderer != null ? ArtistItemsPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer) : null;
                        }
                        if (yTItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    return new ArtistItemsPage(str5, null, arrayList2);
                }
                ?? arrayList3 = EmptyList.INSTANCE;
                if (musicShelfRenderer == null) {
                    if (header != null && (musicHeaderRenderer = header.musicHeaderRenderer) != null && (runs = musicHeaderRenderer.title) != null && (list3 = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list3)) != null && (str = run.text) != null) {
                        str5 = str;
                    }
                    if (musicPlaylistShelfRenderer != null && (list2 = musicPlaylistShelfRenderer.contents) != null) {
                        ArrayList items = MusicShelfRendererKt.getItems(list2);
                        arrayList3 = new ArrayList();
                        int size = items.size();
                        while (i3 < size) {
                            Object obj = items.get(i3);
                            i3++;
                            SongItem songItemFromMusicResponsiveListItemRenderer = ArtistItemsPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj);
                            if (songItemFromMusicResponsiveListItemRenderer != null) {
                                arrayList3.add(songItemFromMusicResponsiveListItemRenderer);
                            }
                        }
                    }
                    if (musicPlaylistShelfRenderer != null && (list = musicPlaylistShelfRenderer.contents) != null) {
                        continuation = MusicShelfRendererKt.getContinuation(list);
                    }
                    return new ArtistItemsPage(str5, continuation, arrayList3);
                }
                Runs runs5 = musicShelfRenderer.title;
                if (runs5 != null && (list5 = runs5.runs) != null && (run3 = (Run) CollectionsKt.firstOrNull(list5)) != null && (str2 = run3.text) != null) {
                    str5 = str2;
                } else if (header != null && (musicHeaderRenderer2 = header.musicHeaderRenderer) != null && (runs2 = musicHeaderRenderer2.title) != null && (list4 = runs2.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list4)) != null) {
                    str5 = run2.text;
                }
                List list13 = musicShelfRenderer.contents;
                if (list13 != null) {
                    ArrayList items2 = MusicShelfRendererKt.getItems(list13);
                    arrayList3 = new ArrayList();
                    int size2 = items2.size();
                    while (i3 < size2) {
                        Object obj2 = items2.get(i3);
                        i3++;
                        SongItem songItemFromMusicResponsiveListItemRenderer2 = ArtistItemsPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2);
                        if (songItemFromMusicResponsiveListItemRenderer2 != null) {
                            arrayList3.add(songItemFromMusicResponsiveListItemRenderer2);
                        }
                    }
                }
                List list14 = musicShelfRenderer.continuations;
                return new ArtistItemsPage(str5, list14 != null ? ContinuationKt.getContinuation(list14) : null, arrayList3);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$artistItems$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$artistItems$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v8, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.util.List] */
    /* JADX INFO: renamed from: artistItemsContinuation-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1000artistItemsContinuationgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$artistItemsContinuation$1 youTube$artistItemsContinuation$1;
        TypeReference typeReferenceTypeOf;
        ?? arrayList;
        BrowseResponse.ResponseAction responseAction;
        BrowseResponse.ResponseAction.ContinuationItems continuationItems;
        List list;
        List list2;
        if (continuationImpl instanceof YouTube$artistItemsContinuation$1) {
            youTube$artistItemsContinuation$1 = (YouTube$artistItemsContinuation$1) continuationImpl;
            int i = youTube$artistItemsContinuation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$artistItemsContinuation$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$artistItemsContinuation$1 = new YouTube$artistItemsContinuation$1(this, continuationImpl);
            }
        } else {
            youTube$artistItemsContinuation$1 = new YouTube$artistItemsContinuation$1(this, continuationImpl);
        }
        YouTube$artistItemsContinuation$1 youTube$artistItemsContinuation$2 = youTube$artistItemsContinuation$1;
        Object objBrowse$default = youTube$artistItemsContinuation$2.result;
        int i2 = youTube$artistItemsContinuation$2.label;
        int i3 = 0;
        String continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$artistItemsContinuation$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, null, null, str, false, youTube$artistItemsContinuation$2, 22);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.ContinuationContents continuationContents = browseResponse.continuationContents;
                if ((continuationContents != null ? continuationContents.gridContinuation : null) != null) {
                    BrowseResponse.ContinuationContents.GridContinuation gridContinuation = continuationContents.gridContinuation;
                    List list3 = gridContinuation.items;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                        YTItem yTItemFromMusicTwoRowItemRenderer = musicTwoRowItemRenderer != null ? ArtistItemsPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer) : null;
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList2.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    if (!arrayList2.isEmpty() && (list2 = gridContinuation.continuations) != null) {
                        continuation = ContinuationKt.getContinuation(list2);
                    }
                    return new ArtistItemsContinuationPage(arrayList2, continuation);
                }
                if ((continuationContents != null ? continuationContents.musicPlaylistShelfContinuation : null) != null) {
                    BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation = continuationContents.musicPlaylistShelfContinuation;
                    ArrayList items = MusicShelfRendererKt.getItems(musicPlaylistShelfContinuation.contents);
                    ArrayList arrayList3 = new ArrayList();
                    int size = items.size();
                    while (i3 < size) {
                        Object obj = items.get(i3);
                        i3++;
                        SongItem songItemFromMusicResponsiveListItemRenderer = ArtistItemsPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj);
                        if (songItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList3.add(songItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    if (!arrayList3.isEmpty() && (list = musicPlaylistShelfContinuation.continuations) != null) {
                        continuation = ContinuationKt.getContinuation(list);
                    }
                    return new ArtistItemsContinuationPage(arrayList3, continuation);
                }
                List list4 = browseResponse.onResponseReceivedActions;
                List list5 = (list4 == null || (responseAction = (BrowseResponse.ResponseAction) CollectionsKt.firstOrNull(list4)) == null || (continuationItems = responseAction.appendContinuationItemsAction) == null) ? null : continuationItems.continuationItems;
                if (list5 != null) {
                    ArrayList items2 = MusicShelfRendererKt.getItems(list5);
                    arrayList = new ArrayList();
                    int size2 = items2.size();
                    while (i3 < size2) {
                        Object obj2 = items2.get(i3);
                        i3++;
                        SongItem songItemFromMusicResponsiveListItemRenderer2 = ArtistItemsPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2);
                        if (songItemFromMusicResponsiveListItemRenderer2 != null) {
                            arrayList.add(songItemFromMusicResponsiveListItemRenderer2);
                        }
                    }
                } else {
                    arrayList = EmptyList.INSTANCE;
                }
                if (!arrayList.isEmpty() && list5 != null) {
                    continuation = MusicShelfRendererKt.getContinuation(list5);
                }
                return new ArtistItemsContinuationPage(arrayList, continuation);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$artistItemsContinuation$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$artistItemsContinuation$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x018e A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0192 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0198  */
    /* JADX WARN: Code duplicated, block: B:120:0x019b  */
    /* JADX WARN: Code duplicated, block: B:121:0x019c A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01a0 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x01a6 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:127:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f8 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x01fc A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0202  */
    /* JADX WARN: Code duplicated, block: B:156:0x0205  */
    /* JADX WARN: Code duplicated, block: B:157:0x0206 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x020a A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0210 A[Catch: all -> 0x02cc, TryCatch #1 {all -> 0x02cc, blocks: (B:13:0x002a, B:42:0x009a, B:44:0x00a0, B:46:0x00a4, B:48:0x00a8, B:50:0x00b0, B:52:0x00b4, B:54:0x00b8, B:56:0x00bc, B:58:0x00c0, B:60:0x00c4, B:62:0x00c8, B:64:0x00cc, B:66:0x00d0, B:68:0x00d8, B:73:0x00e0, B:74:0x00e9, B:76:0x00ef, B:79:0x00fd, B:81:0x0101, B:83:0x0105, B:85:0x0109, B:87:0x010d, B:89:0x0115, B:91:0x0119, B:92:0x0126, B:94:0x012c, B:96:0x0136, B:97:0x013a, B:99:0x0146, B:101:0x0154, B:103:0x015a, B:104:0x015e, B:201:0x02b4, B:106:0x0167, B:107:0x0172, B:109:0x0178, B:111:0x0182, B:113:0x0188, B:129:0x01b1, B:115:0x018e, B:117:0x0192, B:121:0x019c, B:123:0x01a0, B:125:0x01a6, B:130:0x01b5, B:132:0x01b9, B:134:0x01bd, B:136:0x01c1, B:138:0x01c5, B:140:0x01cd, B:142:0x01d1, B:143:0x01dc, B:145:0x01e2, B:147:0x01ec, B:149:0x01f2, B:165:0x021b, B:151:0x01f8, B:153:0x01fc, B:157:0x0206, B:159:0x020a, B:161:0x0210, B:166:0x021f, B:168:0x0229, B:170:0x022d, B:172:0x0231, B:174:0x0239, B:176:0x023d, B:178:0x0241, B:179:0x024a, B:181:0x0250, B:183:0x025a, B:184:0x025e, B:186:0x026a, B:188:0x0278, B:190:0x027d, B:191:0x0283, B:193:0x0287, B:195:0x0299, B:197:0x02a7, B:198:0x02ab, B:206:0x02be, B:207:0x02c4, B:208:0x02cb, B:18:0x0037, B:34:0x0076, B:38:0x0088, B:21:0x003e, B:23:0x0046, B:25:0x004e, B:30:0x005c), top: B:214:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0216  */
    /* JADX WARN: Code duplicated, block: B:163:0x0218  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
    
        if (r12 == r11) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX INFO: renamed from: browse-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1001browse0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        YouTube$browse$1 youTube$browse$1;
        int i;
        ?? r6;
        ?? r13;
        TypeReference typeReferenceTypeOf;
        BrowseResult.Item item;
        ?? arrayList;
        List list;
        Run run;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        YTItem yTItemFromMusicResponsiveListItemRenderer;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        YTItem yTItemFromMusicResponsiveListItemRenderer2;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
        Runs runs;
        List list2;
        Run run2;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2;
        YTItem yTItemFromMusicResponsiveListItemRenderer3;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2;
        YTItem yTItemFromMusicResponsiveListItemRenderer4;
        GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer;
        Runs runs2;
        List list3;
        Run run3;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer;
        Runs runs3;
        List list4;
        Run run4;
        Tabs tabs;
        List list5;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        if (continuationImpl instanceof YouTube$browse$1) {
            youTube$browse$1 = (YouTube$browse$1) continuationImpl;
            int i2 = youTube$browse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                youTube$browse$1.label = i2 - Integer.MIN_VALUE;
            } else {
                youTube$browse$1 = new YouTube$browse$1(this, continuationImpl);
            }
        } else {
            youTube$browse$1 = new YouTube$browse$1(this, continuationImpl);
        }
        YouTube$browse$1 youTube$browse$2 = youTube$browse$1;
        Object objBrowse$default = youTube$browse$2.result;
        int i3 = youTube$browse$2.label;
        List list6 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    if (StringsKt__StringsJVMKt.startsWith(str, "FEmusic_library", false) || str.equals("VLSE") || str.equals("VLRDPN")) {
                        i = 1;
                        r6 = 1;
                    } else {
                        i = 1;
                        r6 = 0;
                    }
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$browse$2.I$0 = r6;
                    youTube$browse$2.label = i;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, str2, null, r6, youTube$browse$2, 8);
                    if (objBrowse$default != coroutineSingletons) {
                        r13 = r6;
                    }
                    return coroutineSingletons;
                }
                if (i3 == 1) {
                    int i4 = youTube$browse$2.I$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                    r13 = i4;
                } else {
                    if (i3 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.Contents contents = browseResponse.contents;
                List<SectionListRenderer.Content> list7 = (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list5 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list5)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null) ? null : sectionListRenderer.contents;
                BrowseResponse.Header header = browseResponse.header;
                String str3 = (header == null || (musicHeaderRenderer = header.musicHeaderRenderer) == null || (runs3 = musicHeaderRenderer.title) == null || (list4 = runs3.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list4)) == null) ? null : run4.text;
                List list8 = EmptyList.INSTANCE;
                if (list7 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (SectionListRenderer.Content content2 : list7) {
                        GridRenderer gridRenderer = content2.gridRenderer;
                        MusicShelfRenderer musicShelfRenderer = content2.musicShelfRenderer;
                        MusicCarouselShelfRenderer musicCarouselShelfRenderer = content2.musicCarouselShelfRenderer;
                        if (gridRenderer != null) {
                            GridRenderer.Header header2 = gridRenderer.header;
                            String str4 = (header2 == null || (gridHeaderRenderer = header2.gridHeaderRenderer) == null || (runs2 = gridHeaderRenderer.title) == null || (list3 = runs2.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list3)) == null) ? null : run3.text;
                            List list9 = content2.gridRenderer.items;
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = list9.iterator();
                            while (it.hasNext()) {
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                                if (musicTwoRowItemRenderer != null) {
                                    arrayList3.add(musicTwoRowItemRenderer);
                                }
                            }
                            ArrayList arrayList4 = new ArrayList();
                            int size = arrayList3.size();
                            int i5 = 0;
                            while (i5 < size) {
                                Object obj = arrayList3.get(i5);
                                i5++;
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = (MusicTwoRowItemRenderer) obj;
                                YTItem yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer2);
                                if (yTItemFromMusicTwoRowItemRenderer == null) {
                                    yTItemFromMusicTwoRowItemRenderer = RelatedPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer2);
                                }
                                if (yTItemFromMusicTwoRowItemRenderer != null) {
                                    arrayList4.add(yTItemFromMusicTwoRowItemRenderer);
                                }
                            }
                            item = new BrowseResult.Item(str4, arrayList4);
                        } else if (musicCarouselShelfRenderer != null) {
                            ArrayList arrayList5 = new ArrayList();
                            for (MusicCarouselShelfRenderer.Content content3 : musicCarouselShelfRenderer.contents) {
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer3 = content3.musicTwoRowItemRenderer;
                                if (musicTwoRowItemRenderer3 == null) {
                                    musicMultiRowListItemRenderer2 = content3.musicMultiRowListItemRenderer;
                                    if (musicMultiRowListItemRenderer2 != null) {
                                        yTItemFromMusicResponsiveListItemRenderer3 = PodcastPage.Companion.fromMusicMultiRowListItemRenderer(musicMultiRowListItemRenderer2, null);
                                    } else {
                                        yTItemFromMusicResponsiveListItemRenderer3 = null;
                                    }
                                    if (yTItemFromMusicResponsiveListItemRenderer3 == null) {
                                        musicResponsiveListItemRenderer2 = content3.musicResponsiveListItemRenderer;
                                        if (musicResponsiveListItemRenderer2 != null) {
                                            yTItemFromMusicResponsiveListItemRenderer4 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer2, false);
                                            if (yTItemFromMusicResponsiveListItemRenderer4 == null) {
                                                yTItemFromMusicResponsiveListItemRenderer3 = RelatedPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer2);
                                            } else {
                                                yTItemFromMusicResponsiveListItemRenderer3 = yTItemFromMusicResponsiveListItemRenderer4;
                                            }
                                        } else {
                                            yTItemFromMusicResponsiveListItemRenderer3 = null;
                                        }
                                    }
                                } else {
                                    yTItemFromMusicResponsiveListItemRenderer3 = LibraryPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer3);
                                    if (yTItemFromMusicResponsiveListItemRenderer3 == null) {
                                        yTItemFromMusicResponsiveListItemRenderer3 = RelatedPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer3);
                                    }
                                    if (yTItemFromMusicResponsiveListItemRenderer3 == null) {
                                        musicMultiRowListItemRenderer2 = content3.musicMultiRowListItemRenderer;
                                        if (musicMultiRowListItemRenderer2 != null) {
                                            yTItemFromMusicResponsiveListItemRenderer3 = PodcastPage.Companion.fromMusicMultiRowListItemRenderer(musicMultiRowListItemRenderer2, null);
                                        } else {
                                            yTItemFromMusicResponsiveListItemRenderer3 = null;
                                        }
                                        if (yTItemFromMusicResponsiveListItemRenderer3 == null) {
                                            musicResponsiveListItemRenderer2 = content3.musicResponsiveListItemRenderer;
                                            if (musicResponsiveListItemRenderer2 != null) {
                                                yTItemFromMusicResponsiveListItemRenderer4 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer2, false);
                                                if (yTItemFromMusicResponsiveListItemRenderer4 == null) {
                                                    yTItemFromMusicResponsiveListItemRenderer3 = RelatedPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer2);
                                                } else {
                                                    yTItemFromMusicResponsiveListItemRenderer3 = yTItemFromMusicResponsiveListItemRenderer4;
                                                }
                                            } else {
                                                yTItemFromMusicResponsiveListItemRenderer3 = null;
                                            }
                                        }
                                    }
                                }
                                if (yTItemFromMusicResponsiveListItemRenderer3 != null) {
                                    arrayList5.add(yTItemFromMusicResponsiveListItemRenderer3);
                                }
                            }
                            MusicCarouselShelfRenderer.Header header3 = musicCarouselShelfRenderer.header;
                            String str5 = (header3 == null || (musicCarouselShelfBasicHeaderRenderer = header3.musicCarouselShelfBasicHeaderRenderer) == null || (runs = musicCarouselShelfBasicHeaderRenderer.title) == null || (list2 = runs.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null) ? null : run2.text;
                            List<MusicCarouselShelfRenderer.Content> list10 = musicCarouselShelfRenderer.contents;
                            ArrayList arrayList6 = new ArrayList();
                            for (MusicCarouselShelfRenderer.Content content4 : list10) {
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer4 = content4.musicTwoRowItemRenderer;
                                if (musicTwoRowItemRenderer4 == null) {
                                    musicMultiRowListItemRenderer = content4.musicMultiRowListItemRenderer;
                                    if (musicMultiRowListItemRenderer != null) {
                                        yTItemFromMusicResponsiveListItemRenderer = PodcastPage.Companion.fromMusicMultiRowListItemRenderer(musicMultiRowListItemRenderer, null);
                                    } else {
                                        yTItemFromMusicResponsiveListItemRenderer = null;
                                    }
                                    if (yTItemFromMusicResponsiveListItemRenderer == null) {
                                        musicResponsiveListItemRenderer = content4.musicResponsiveListItemRenderer;
                                        if (musicResponsiveListItemRenderer != null) {
                                            yTItemFromMusicResponsiveListItemRenderer2 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer, false);
                                            if (yTItemFromMusicResponsiveListItemRenderer2 == null) {
                                                yTItemFromMusicResponsiveListItemRenderer = RelatedPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer);
                                            } else {
                                                yTItemFromMusicResponsiveListItemRenderer = yTItemFromMusicResponsiveListItemRenderer2;
                                            }
                                        } else {
                                            yTItemFromMusicResponsiveListItemRenderer = null;
                                        }
                                    }
                                } else {
                                    yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer4);
                                    if (yTItemFromMusicResponsiveListItemRenderer == null) {
                                        yTItemFromMusicResponsiveListItemRenderer = RelatedPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer4);
                                    }
                                    if (yTItemFromMusicResponsiveListItemRenderer == null) {
                                        musicMultiRowListItemRenderer = content4.musicMultiRowListItemRenderer;
                                        if (musicMultiRowListItemRenderer != null) {
                                            yTItemFromMusicResponsiveListItemRenderer = PodcastPage.Companion.fromMusicMultiRowListItemRenderer(musicMultiRowListItemRenderer, null);
                                        } else {
                                            yTItemFromMusicResponsiveListItemRenderer = null;
                                        }
                                        if (yTItemFromMusicResponsiveListItemRenderer == null) {
                                            musicResponsiveListItemRenderer = content4.musicResponsiveListItemRenderer;
                                            if (musicResponsiveListItemRenderer != null) {
                                                yTItemFromMusicResponsiveListItemRenderer2 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer, false);
                                                if (yTItemFromMusicResponsiveListItemRenderer2 == null) {
                                                    yTItemFromMusicResponsiveListItemRenderer = RelatedPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer);
                                                } else {
                                                    yTItemFromMusicResponsiveListItemRenderer = yTItemFromMusicResponsiveListItemRenderer2;
                                                }
                                            } else {
                                                yTItemFromMusicResponsiveListItemRenderer = null;
                                            }
                                        }
                                    }
                                }
                                if (yTItemFromMusicResponsiveListItemRenderer != null) {
                                    arrayList6.add(yTItemFromMusicResponsiveListItemRenderer);
                                }
                            }
                            item = new BrowseResult.Item(str5, arrayList6);
                        } else if (musicShelfRenderer != null) {
                            Runs runs4 = musicShelfRenderer.title;
                            String str6 = (runs4 == null || (list = runs4.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null) ? null : run.text;
                            List list11 = musicShelfRenderer.contents;
                            if (list11 != null) {
                                ArrayList arrayList7 = new ArrayList();
                                Iterator it2 = list11.iterator();
                                while (it2.hasNext()) {
                                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer3 = ((MusicShelfRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                                    if (musicResponsiveListItemRenderer3 != null) {
                                        arrayList7.add(musicResponsiveListItemRenderer3);
                                    }
                                }
                                arrayList = new ArrayList();
                                int size2 = arrayList7.size();
                                int i6 = 0;
                                while (i6 < size2) {
                                    Object obj2 = arrayList7.get(i6);
                                    i6++;
                                    YTItem yTItemFromMusicResponsiveListItemRenderer5 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2, false);
                                    if (yTItemFromMusicResponsiveListItemRenderer5 != null) {
                                        arrayList.add(yTItemFromMusicResponsiveListItemRenderer5);
                                    }
                                }
                            } else {
                                arrayList = list8;
                            }
                            item = new BrowseResult.Item(str6, arrayList);
                        } else {
                            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = content2.musicPlaylistShelfRenderer;
                            if (musicPlaylistShelfRenderer != null) {
                                ArrayList items = MusicShelfRendererKt.getItems(musicPlaylistShelfRenderer.contents);
                                ArrayList arrayList8 = new ArrayList();
                                int size3 = items.size();
                                int i7 = 0;
                                while (i7 < size3) {
                                    Object obj3 = items.get(i7);
                                    i7++;
                                    YTItem yTItemFromMusicResponsiveListItemRenderer6 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj3, false);
                                    if (yTItemFromMusicResponsiveListItemRenderer6 != null) {
                                        arrayList8.add(yTItemFromMusicResponsiveListItemRenderer6);
                                    }
                                }
                                item = new BrowseResult.Item(null, arrayList8);
                            } else {
                                item = null;
                            }
                        }
                        if (item != null) {
                            arrayList2.add(item);
                        }
                    }
                    list6 = arrayList2;
                }
                if (list6 != null) {
                    list8 = list6;
                }
                return new BrowseResult(str3, list8);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$browse$2.I$0 = r13;
            youTube$browse$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$browse$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r6 == r4) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createPlaylist(String str, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object objCreatePlaylist = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objCreatePlaylist);
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                anonymousClass1.label = 1;
                objCreatePlaylist = innerTube.createPlaylist(youTubeClient, str, anonymousClass1);
                if (objCreatePlaylist != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objCreatePlaylist);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objCreatePlaylist);
            }
            if (objCreatePlaylist != null) {
                return ((CreatePlaylistResponse) objCreatePlaylist).playlistId;
            }
            PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type com.metrolist.innertube.models.response.CreatePlaylistResponse");
            return null;
            typeReferenceTypeOf = Reflection.typeOf(CreatePlaylistResponse.class);
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        HttpClientCall call = ((HttpResponse) objCreatePlaylist).getCall();
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CreatePlaylistResponse.class);
        TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
        anonymousClass1.label = 2;
        objCreatePlaylist = call.bodyNullable(typeInfo, anonymousClass1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: deletePlaylist-gIAlu-s, reason: not valid java name */
    public final Object m1002deletePlaylistgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$deletePlaylist$1 youTube$deletePlaylist$1;
        if (continuationImpl instanceof YouTube$deletePlaylist$1) {
            youTube$deletePlaylist$1 = (YouTube$deletePlaylist$1) continuationImpl;
            int i = youTube$deletePlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$deletePlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$deletePlaylist$1 = new YouTube$deletePlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$deletePlaylist$1 = new YouTube$deletePlaylist$1(this, continuationImpl);
        }
        Object objDeletePlaylist = youTube$deletePlaylist$1.result;
        int i2 = youTube$deletePlaylist$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objDeletePlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$deletePlaylist$1.label = 1;
                objDeletePlaylist = innerTube2.deletePlaylist(youTubeClient, str, youTube$deletePlaylist$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDeletePlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objDeletePlaylist);
            }
            return (HttpResponse) objDeletePlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: deleteUploadedSong-gIAlu-s, reason: not valid java name */
    public final Serializable m1003deleteUploadedSonggIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$deleteUploadedSong$1 youTube$deleteUploadedSong$1;
        if (continuationImpl instanceof YouTube$deleteUploadedSong$1) {
            youTube$deleteUploadedSong$1 = (YouTube$deleteUploadedSong$1) continuationImpl;
            int i = youTube$deleteUploadedSong$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$deleteUploadedSong$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$deleteUploadedSong$1 = new YouTube$deleteUploadedSong$1(this, continuationImpl);
            }
        } else {
            youTube$deleteUploadedSong$1 = new YouTube$deleteUploadedSong$1(this, continuationImpl);
        }
        Object obj = youTube$deleteUploadedSong$1.result;
        int i2 = youTube$deleteUploadedSong$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                InnerTube innerTube2 = innerTube;
                youTube$deleteUploadedSong$1.label = 1;
                Object objDeletePrivatelyOwnedEntity = innerTube2.deletePrivatelyOwnedEntity(str, youTube$deleteUploadedSong$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDeletePrivatelyOwnedEntity == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Boolean.TRUE;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0179 A[Catch: all -> 0x01eb, TryCatch #1 {all -> 0x01eb, blocks: (B:13:0x002e, B:31:0x0084, B:33:0x008a, B:35:0x008e, B:37:0x0092, B:39:0x0096, B:41:0x009a, B:44:0x00a4, B:46:0x00a8, B:54:0x00b8, B:55:0x00c1, B:57:0x00c7, B:59:0x00d1, B:60:0x00d5, B:62:0x00e0, B:136:0x01db, B:66:0x00f3, B:68:0x00ff, B:70:0x0103, B:72:0x0107, B:74:0x010b, B:76:0x0113, B:78:0x0117, B:80:0x011f, B:82:0x0123, B:84:0x0127, B:87:0x012d, B:90:0x0135, B:91:0x013d, B:93:0x0143, B:95:0x0152, B:97:0x0156, B:102:0x0160, B:104:0x0164, B:106:0x016c, B:108:0x0170, B:127:0x01a4, B:129:0x01ae, B:134:0x01bb, B:111:0x0179, B:113:0x017d, B:115:0x0185, B:117:0x0189, B:119:0x018d, B:121:0x0191, B:123:0x0199, B:125:0x019d, B:137:0x01e0, B:49:0x00ae, B:51:0x00b2, B:138:0x01e3, B:139:0x01ea, B:17:0x0038, B:23:0x0062, B:27:0x0074, B:20:0x003f), top: B:145:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        if (r0 == r14) goto L29;
     */
    /* JADX INFO: renamed from: episodesForLater-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1004episodesForLaterIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$episodesForLater$1 youTube$episodesForLater$1;
        TypeReference typeReferenceTypeOf;
        List list;
        MusicShelfRenderer musicShelfRenderer;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        List list2;
        Run run;
        String str;
        List list3;
        Integer num;
        MusicResponsiveListItemRenderer.FlexColumn flexColumn;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
        Runs runs2;
        List list4;
        Run run2;
        String str2;
        SongItem songItem;
        String thumbnailUrl;
        Object next;
        Run run3;
        String str3;
        Run run4;
        String str4;
        MusicResponsiveListItemRenderer.FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer3;
        Runs runs3;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        BrowseResponse.SecondaryContents secondaryContents;
        SectionListRenderer sectionListRenderer;
        List list5;
        if (continuationImpl instanceof YouTube$episodesForLater$1) {
            youTube$episodesForLater$1 = (YouTube$episodesForLater$1) continuationImpl;
            int i = youTube$episodesForLater$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$episodesForLater$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$episodesForLater$1 = new YouTube$episodesForLater$1(this, continuationImpl);
            }
        } else {
            youTube$episodesForLater$1 = new YouTube$episodesForLater$1(this, continuationImpl);
        }
        YouTube$episodesForLater$1 youTube$episodesForLater$2 = youTube$episodesForLater$1;
        Object objBrowse$default = youTube$episodesForLater$2.result;
        int i2 = youTube$episodesForLater$2.label;
        int i3 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$episodesForLater$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "VLSE", null, null, true, youTube$episodesForLater$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                SectionListRenderer.Content content = (contents == null || (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) == null || (secondaryContents = twoColumnBrowseResultsRenderer.secondaryContents) == null || (sectionListRenderer = secondaryContents.sectionListRenderer) == null || (list5 = sectionListRenderer.contents) == null) ? null : (SectionListRenderer.Content) CollectionsKt.firstOrNull(list5);
                if (content == null || (musicPlaylistShelfRenderer = content.musicPlaylistShelfRenderer) == null || (list = musicPlaylistShelfRenderer.contents) == null) {
                    list = (content == null || (musicShelfRenderer = content.musicShelfRenderer) == null) ? null : musicShelfRenderer.contents;
                }
                if (list == null) {
                    return EmptyList.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it.next()).musicResponsiveListItemRenderer;
                    if (musicResponsiveListItemRenderer != null) {
                        arrayList.add(musicResponsiveListItemRenderer);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = (MusicResponsiveListItemRenderer) obj;
                    String videoId = musicResponsiveListItemRenderer2.getVideoId();
                    List list6 = musicResponsiveListItemRenderer2.flexColumns;
                    if (videoId == null) {
                        songItem = null;
                    } else {
                        String playlistSetVideoId = musicResponsiveListItemRenderer2.getPlaylistSetVideoId();
                        MusicResponsiveListItemRenderer.FlexColumn flexColumn2 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list6);
                        if (flexColumn2 == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn2.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list2 = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list2)) == null || (str = run.text) == null) {
                            songItem = null;
                        } else {
                            MusicResponsiveListItemRenderer.FlexColumn flexColumn3 = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.getOrNull(1, list6);
                            List list7 = (flexColumn3 == null || (musicResponsiveListItemFlexColumnRenderer3 = flexColumn3.musicResponsiveListItemFlexColumnRenderer) == null || (runs3 = musicResponsiveListItemFlexColumnRenderer3.text) == null) ? null : runs3.runs;
                            ArrayList arrayListSplitBySeparator = list7 != null ? CharsKt.splitBySeparator(list7) : null;
                            if (arrayListSplitBySeparator != null) {
                                Iterator it2 = CollectionsKt.drop(arrayListSplitBySeparator, 1).iterator();
                                do {
                                    if (!it2.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it2.next();
                                    run4 = (Run) CollectionsKt.firstOrNull((List) next);
                                } while (((run4 == null || (str4 = run4.text) == null) ? null : StringsKt__IndentKt.m1883parseTime(str4)) == null);
                                List list8 = (List) next;
                                if (list8 == null || (run3 = (Run) CollectionsKt.firstOrNull(list8)) == null || (str3 = run3.text) == null || (numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str3)) == null) {
                                    list3 = musicResponsiveListItemRenderer2.fixedColumns;
                                    if (list3 != null || (flexColumn = (MusicResponsiveListItemRenderer.FlexColumn) CollectionsKt.firstOrNull(list3)) == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list4 = runs2.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list4)) == null || (str2 = run2.text) == null) {
                                        num = null;
                                    } else {
                                        Integer numM1883parseTime = StringsKt__IndentKt.m1883parseTime(str2);
                                        num = numM1883parseTime;
                                    }
                                } else {
                                    num = numM1883parseTime;
                                }
                            } else {
                                list3 = musicResponsiveListItemRenderer2.fixedColumns;
                                if (list3 != null) {
                                }
                                num = null;
                            }
                            List listExtractPodcastByline = PodcastPage.Companion.extractPodcastByline(list7);
                            ThumbnailRenderer thumbnailRenderer = musicResponsiveListItemRenderer2.thumbnail;
                            if (thumbnailRenderer == null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                                thumbnailUrl = "";
                            }
                            songItem = new SongItem(videoId, str, listExtractPodcastByline, null, num, null, null, null, thumbnailUrl, false, null, playlistSetVideoId, null, null, null, true, null, 95968);
                        }
                    }
                    if (songItem != null) {
                        arrayList2.add(songItem);
                    }
                }
                return arrayList2;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$episodesForLater$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$episodesForLater$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:154:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:88:0x011f  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX INFO: renamed from: explore-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1005exploreIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$explore$1 youTube$explore$1;
        TypeReference typeReferenceTypeOf;
        ArrayList arrayList;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        Object next;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer;
        List list3;
        MoodAndGenres.Item item;
        Run run;
        String str;
        MusicNavigationButtonRenderer.Solid solid;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer2;
        MusicCarouselShelfRenderer.Header header;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
        Button button;
        Button.ButtonRenderer buttonRenderer;
        NavigationEndpoint navigationEndpoint;
        BrowseEndpoint browseEndpoint;
        Tabs tabs2;
        List list4;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content2;
        SectionListRenderer sectionListRenderer2;
        List list5;
        Object next2;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer3;
        List list6;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer4;
        MusicCarouselShelfRenderer.Header header2;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer2;
        Button button2;
        Button.ButtonRenderer buttonRenderer2;
        NavigationEndpoint navigationEndpoint2;
        BrowseEndpoint browseEndpoint2;
        if (continuationImpl instanceof YouTube$explore$1) {
            youTube$explore$1 = (YouTube$explore$1) continuationImpl;
            int i = youTube$explore$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$explore$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$explore$1 = new YouTube$explore$1(this, continuationImpl);
            }
        } else {
            youTube$explore$1 = new YouTube$explore$1(this, continuationImpl);
        }
        YouTube$explore$1 youTube$explore$2 = youTube$explore$1;
        Object objBrowse$default = youTube$explore$2.result;
        int i2 = youTube$explore$2.label;
        int i3 = 0;
        List list7 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$explore$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_explore", null, null, false, youTube$explore$2, 28);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents == null || (tabs2 = contents.singleColumnBrowseResultsRenderer) == null || (list4 = tabs2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(list4)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (content2 = tabRenderer2.content) == null || (sectionListRenderer2 = content2.sectionListRenderer) == null || (list5 = sectionListRenderer2.contents) == null) {
                    arrayList = null;
                } else {
                    Iterator it = list5.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        musicCarouselShelfRenderer4 = ((SectionListRenderer.Content) next2).musicCarouselShelfRenderer;
                    } while (!Intrinsics.areEqual((musicCarouselShelfRenderer4 == null || (header2 = musicCarouselShelfRenderer4.header) == null || (musicCarouselShelfBasicHeaderRenderer2 = header2.musicCarouselShelfBasicHeaderRenderer) == null || (button2 = musicCarouselShelfBasicHeaderRenderer2.moreContentButton) == null || (buttonRenderer2 = button2.buttonRenderer) == null || (navigationEndpoint2 = buttonRenderer2.navigationEndpoint) == null || (browseEndpoint2 = navigationEndpoint2.browseEndpoint) == null) ? null : browseEndpoint2.browseId, "FEmusic_new_releases_albums"));
                    SectionListRenderer.Content content3 = (SectionListRenderer.Content) next2;
                    if (content3 == null || (musicCarouselShelfRenderer3 = content3.musicCarouselShelfRenderer) == null || (list6 = musicCarouselShelfRenderer3.contents) == null) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = list6.iterator();
                        while (it2.hasNext()) {
                            MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((MusicCarouselShelfRenderer.Content) it2.next()).musicTwoRowItemRenderer;
                            if (musicTwoRowItemRenderer != null) {
                                arrayList2.add(musicTwoRowItemRenderer);
                            }
                        }
                        arrayList = new ArrayList();
                        int size = arrayList2.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj = arrayList2.get(i4);
                            i4++;
                            AlbumItem albumItemFromMusicTwoRowItemRenderer = NewReleaseAlbumPage.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                            if (albumItemFromMusicTwoRowItemRenderer != null) {
                                arrayList.add(albumItemFromMusicTwoRowItemRenderer);
                            }
                        }
                    }
                }
                List list8 = EmptyList.INSTANCE;
                List list9 = arrayList;
                if (arrayList == null) {
                    list9 = list8;
                }
                if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null) {
                    Iterator it3 = list2.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it3.next();
                        musicCarouselShelfRenderer2 = ((SectionListRenderer.Content) next).musicCarouselShelfRenderer;
                    } while (!Intrinsics.areEqual((musicCarouselShelfRenderer2 == null || (header = musicCarouselShelfRenderer2.header) == null || (musicCarouselShelfBasicHeaderRenderer = header.musicCarouselShelfBasicHeaderRenderer) == null || (button = musicCarouselShelfBasicHeaderRenderer.moreContentButton) == null || (buttonRenderer = button.buttonRenderer) == null || (navigationEndpoint = buttonRenderer.navigationEndpoint) == null || (browseEndpoint = navigationEndpoint.browseEndpoint) == null) ? null : browseEndpoint.browseId, "FEmusic_moods_and_genres"));
                    SectionListRenderer.Content content4 = (SectionListRenderer.Content) next;
                    if (content4 != null && (musicCarouselShelfRenderer = content4.musicCarouselShelfRenderer) != null && (list3 = musicCarouselShelfRenderer.contents) != null) {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it4 = list3.iterator();
                        while (it4.hasNext()) {
                            MusicNavigationButtonRenderer musicNavigationButtonRenderer = ((MusicCarouselShelfRenderer.Content) it4.next()).musicNavigationButtonRenderer;
                            if (musicNavigationButtonRenderer != null) {
                                arrayList3.add(musicNavigationButtonRenderer);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList();
                        int size2 = arrayList3.size();
                        while (i3 < size2) {
                            Object obj2 = arrayList3.get(i3);
                            i3++;
                            MusicNavigationButtonRenderer musicNavigationButtonRenderer2 = (MusicNavigationButtonRenderer) obj2;
                            musicNavigationButtonRenderer2.getClass();
                            List list10 = musicNavigationButtonRenderer2.buttonText.runs;
                            if (list10 == null || (run = (Run) CollectionsKt.firstOrNull(list10)) == null || (str = run.text) == null || (solid = musicNavigationButtonRenderer2.solid) == null) {
                                item = null;
                            } else {
                                long j = solid.leftStripeColor;
                                BrowseEndpoint browseEndpoint3 = musicNavigationButtonRenderer2.clickCommand.browseEndpoint;
                                if (browseEndpoint3 == null) {
                                    item = null;
                                } else {
                                    item = new MoodAndGenres.Item(str, j, browseEndpoint3);
                                }
                            }
                            if (item != null) {
                                arrayList4.add(item);
                            }
                        }
                        list7 = arrayList4;
                    }
                }
                if (list7 != null) {
                    list8 = list7;
                }
                return new ExplorePage(list9, list8);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$explore$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$explore$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        if (r6 == r5) goto L26;
     */
    /* JADX INFO: renamed from: feedback-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1006feedbackgIAlus(List list, ContinuationImpl continuationImpl) {
        YouTube$feedback$1 youTube$feedback$1;
        if (continuationImpl instanceof YouTube$feedback$1) {
            youTube$feedback$1 = (YouTube$feedback$1) continuationImpl;
            int i = youTube$feedback$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$feedback$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$feedback$1 = new YouTube$feedback$1(this, continuationImpl);
            }
        } else {
            youTube$feedback$1 = new YouTube$feedback$1(this, continuationImpl);
        }
        Object objFeedback = youTube$feedback$1.result;
        int i2 = youTube$feedback$1.label;
        boolean z = false;
        TypeReference typeReferenceTypeOf = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objFeedback);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$feedback$1.label = 1;
                    objFeedback = innerTube2.feedback(youTubeClient, list, youTube$feedback$1);
                    if (objFeedback == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objFeedback);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objFeedback);
                }
                if (objFeedback == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.FeedbackResponse");
                }
                List list2 = ((FeedbackResponse) objFeedback).feedbackResponses;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        if (!((FeedbackResponse.Status) it.next()).isProcessed) {
                        }
                    }
                    z = true;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
                typeReferenceTypeOf = Reflection.typeOf(FeedbackResponse.class);
            } catch (Throwable unused) {
            }
            HttpClientCall call = ((HttpResponse) objFeedback).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FeedbackResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$feedback$1.label = 2;
            objFeedback = call.bodyNullable(typeInfo, youTube$feedback$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getChannelId(String str, ContinuationImpl continuationImpl) {
        C00811 c00811;
        Object objM998artistgIAlus;
        String str2;
        if (continuationImpl instanceof C00811) {
            c00811 = (C00811) continuationImpl;
            int i = c00811.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00811.label = i - Integer.MIN_VALUE;
            } else {
                c00811 = new C00811(continuationImpl);
            }
        } else {
            c00811 = new C00811(continuationImpl);
        }
        Object obj = c00811.result;
        int i2 = c00811.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c00811.label = 1;
            objM998artistgIAlus = m998artistgIAlus(str, c00811);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM998artistgIAlus == obj2) {
                return obj2;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM998artistgIAlus = ((Result) obj).value;
        }
        return ((objM998artistgIAlus instanceof Result.Failure) || (str2 = ((ArtistPage) objM998artistgIAlus).artist.channelId) == null) ? "" : str2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:
    
        if (r14 == r12) goto L31;
     */
    /* JADX INFO: renamed from: getChartsPage-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1007getChartsPagegIAlus(ContinuationImpl continuationImpl) {
        YouTube$getChartsPage$1 youTube$getChartsPage$1;
        TypeReference typeReferenceTypeOf;
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation;
        List list;
        Tabs tabs;
        List list2;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List<SectionListRenderer.Content> list3;
        GridRenderer.Header header;
        GridRenderer.Header.GridHeaderRenderer gridHeaderRenderer;
        Runs runs;
        List list4;
        Run run;
        String str;
        YTItem yTItemConvertMusicTwoRowItem;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
        Runs runs2;
        List list5;
        Run run2;
        String str2;
        Object objConvertMusicTwoRowItem;
        if (continuationImpl instanceof YouTube$getChartsPage$1) {
            youTube$getChartsPage$1 = (YouTube$getChartsPage$1) continuationImpl;
            int i = youTube$getChartsPage$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$getChartsPage$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$getChartsPage$1 = new YouTube$getChartsPage$1(this, continuationImpl);
            }
        } else {
            youTube$getChartsPage$1 = new YouTube$getChartsPage$1(this, continuationImpl);
        }
        YouTube$getChartsPage$1 youTube$getChartsPage$2 = youTube$getChartsPage$1;
        Object objBrowse$default = youTube$getChartsPage$2.result;
        int i2 = youTube$getChartsPage$2.label;
        String continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$getChartsPage$2.L$1 = this;
                    youTube$getChartsPage$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_charts", "ggMGCgQIgAQ%3D", null, false, youTube$getChartsPage$2, 16);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    this = youTube$getChartsPage$2.L$1;
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    this = youTube$getChartsPage$2.L$1;
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                ArrayList arrayList = new ArrayList();
                BrowseResponse.Contents contents = browseResponse.contents;
                if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list2 = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list2)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list3 = sectionListRenderer.contents) != null) {
                    for (SectionListRenderer.Content content2 : list3) {
                        MusicCarouselShelfRenderer musicCarouselShelfRenderer = content2.musicCarouselShelfRenderer;
                        if (musicCarouselShelfRenderer != null) {
                            MusicCarouselShelfRenderer.Header header2 = musicCarouselShelfRenderer.header;
                            if (header2 != null && (musicCarouselShelfBasicHeaderRenderer = header2.musicCarouselShelfBasicHeaderRenderer) != null && (runs2 = musicCarouselShelfBasicHeaderRenderer.title) != null && (list5 = runs2.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list5)) != null && (str2 = run2.text) != null) {
                                List<MusicCarouselShelfRenderer.Content> list6 = musicCarouselShelfRenderer.contents;
                                ArrayList arrayList2 = new ArrayList();
                                for (MusicCarouselShelfRenderer.Content content3 : list6) {
                                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = content3.musicResponsiveListItemRenderer;
                                    if (musicResponsiveListItemRenderer != null) {
                                        this.getClass();
                                        objConvertMusicTwoRowItem = convertToChartItem(musicResponsiveListItemRenderer);
                                    } else {
                                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = content3.musicTwoRowItemRenderer;
                                        if (musicTwoRowItemRenderer != null) {
                                            this.getClass();
                                            objConvertMusicTwoRowItem = convertMusicTwoRowItem(musicTwoRowItemRenderer);
                                        } else {
                                            objConvertMusicTwoRowItem = null;
                                        }
                                    }
                                    if (objConvertMusicTwoRowItem != null) {
                                        arrayList2.add(objConvertMusicTwoRowItem);
                                    }
                                }
                                ArrayList arrayListFilterNotNull = CollectionsKt.filterNotNull(arrayList2);
                                if (!arrayListFilterNotNull.isEmpty()) {
                                    this.getClass();
                                    arrayList.add(new ChartsPage.ChartSection(str2, arrayListFilterNotNull, StringsKt.contains(str2, "Trending", true) ? ChartsPage.ChartType.TRENDING : StringsKt.contains(str2, "Top", true) ? ChartsPage.ChartType.TOP : ChartsPage.ChartType.GENRE));
                                }
                            }
                        }
                        GridRenderer gridRenderer = content2.gridRenderer;
                        if (gridRenderer != null && (header = gridRenderer.header) != null && (gridHeaderRenderer = header.gridHeaderRenderer) != null && (runs = gridHeaderRenderer.title) != null && (list4 = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list4)) != null && (str = run.text) != null) {
                            List list7 = gridRenderer.items;
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = list7.iterator();
                            while (it.hasNext()) {
                                MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                                if (musicTwoRowItemRenderer2 != null) {
                                    this.getClass();
                                    yTItemConvertMusicTwoRowItem = convertMusicTwoRowItem(musicTwoRowItemRenderer2);
                                } else {
                                    yTItemConvertMusicTwoRowItem = null;
                                }
                                if (yTItemConvertMusicTwoRowItem != null) {
                                    arrayList3.add(yTItemConvertMusicTwoRowItem);
                                }
                            }
                            ArrayList arrayListFilterNotNull2 = CollectionsKt.filterNotNull(arrayList3);
                            if (!arrayListFilterNotNull2.isEmpty()) {
                                arrayList.add(new ChartsPage.ChartSection(str, arrayListFilterNotNull2, ChartsPage.ChartType.NEW_RELEASES));
                            }
                        }
                    }
                }
                BrowseResponse.ContinuationContents continuationContents = browseResponse.continuationContents;
                if (continuationContents != null && (sectionListContinuation = continuationContents.sectionListContinuation) != null && (list = sectionListContinuation.continuations) != null) {
                    continuation = ContinuationKt.getContinuation(list);
                }
                return new ChartsPage(continuation, arrayList);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$getChartsPage$2.L$1 = this;
            youTube$getChartsPage$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$getChartsPage$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: getMediaInfo-gIAlu-s, reason: not valid java name */
    public final Object m1008getMediaInfogIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$getMediaInfo$1 youTube$getMediaInfo$1;
        if (continuationImpl instanceof YouTube$getMediaInfo$1) {
            youTube$getMediaInfo$1 = (YouTube$getMediaInfo$1) continuationImpl;
            int i = youTube$getMediaInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$getMediaInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$getMediaInfo$1 = new YouTube$getMediaInfo$1(this, continuationImpl);
            }
        } else {
            youTube$getMediaInfo$1 = new YouTube$getMediaInfo$1(this, continuationImpl);
        }
        Object obj = youTube$getMediaInfo$1.result;
        int i2 = youTube$getMediaInfo$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).value;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            InnerTube innerTube2 = innerTube;
            youTube$getMediaInfo$1.label = 1;
            Object objM985getMediaInfogIAlus = innerTube2.m985getMediaInfogIAlus(str, youTube$getMediaInfo$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return objM985getMediaInfogIAlus == coroutineSingletons ? coroutineSingletons : objM985getMediaInfogIAlus;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
    
        if (r2 == r15) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.metrolist.innertube.YouTube] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Iterable, java.util.List] */
    /* JADX INFO: renamed from: home-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1009home0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        YouTube$home$1 youTube$home$1;
        Object objM1010homeContinuationgIAlus;
        TypeReference typeReferenceTypeOf;
        ?? arrayList;
        SectionListRenderer.Header header;
        SectionListRenderer.Header.ChipCloudRenderer chipCloudRenderer;
        List<SectionListRenderer.Header.ChipCloudRenderer.Chip> list;
        HomePage.Chip chip;
        List list2;
        Run run;
        String str3;
        List list3;
        List list4;
        Tabs tabs;
        List list5;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        Tabs tabs2;
        List list6;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content2;
        SectionListRenderer sectionListRenderer;
        List list7;
        if (continuationImpl instanceof YouTube$home$1) {
            youTube$home$1 = (YouTube$home$1) continuationImpl;
            int i = youTube$home$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$home$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$home$1 = new YouTube$home$1(this, continuationImpl);
            }
        } else {
            youTube$home$1 = new YouTube$home$1(this, continuationImpl);
        }
        YouTube$home$1 youTube$home$2 = youTube$home$1;
        Object objBrowse$default = youTube$home$2.result;
        int i2 = youTube$home$2.label;
        ArrayList arrayList2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objBrowse$default);
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                if (str != null) {
                    youTube$home$2.label = 1;
                    objM1010homeContinuationgIAlus = m1010homeContinuationgIAlus(str, youTube$home$2);
                    if (objM1010homeContinuationgIAlus == coroutineSingletons) {
                    }
                    ResultKt.throwOnFailure(objM1010homeContinuationgIAlus);
                    return (HomePage) objM1010homeContinuationgIAlus;
                }
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$home$2.label = 2;
                objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_home", str2, null, false, youTube$home$2, 24);
                if (objBrowse$default != coroutineSingletons) {
                    HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
                    ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
                    typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
                    TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                    youTube$home$2.label = 3;
                    objBrowse$default = call.bodyNullable(typeInfo, youTube$home$2);
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(objBrowse$default);
                objM1010homeContinuationgIAlus = ((Result) objBrowse$default).value;
                ResultKt.throwOnFailure(objM1010homeContinuationgIAlus);
                return (HomePage) objM1010homeContinuationgIAlus;
            }
            if (i2 == 2) {
                ResultKt.throwOnFailure(objBrowse$default);
                HttpClientCall call2 = ((HttpResponse) objBrowse$default).getCall();
                ClassReference orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                TypeInfo typeInfo2 = new TypeInfo((KClass<?>) orCreateKotlinClass2, false, (KType) typeReferenceTypeOf);
                youTube$home$2.label = 3;
                objBrowse$default = call2.bodyNullable(typeInfo2, youTube$home$2);
            } else {
                if (i2 != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objBrowse$default);
            }
            if (objBrowse$default == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
            }
            BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            String continuation = (contents == null || (tabs2 = contents.singleColumnBrowseResultsRenderer) == null || (list6 = tabs2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(list6)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (content2 = tabRenderer2.content) == null || (sectionListRenderer = content2.sectionListRenderer) == null || (list7 = sectionListRenderer.continuations) == null) ? null : ContinuationKt.getContinuation(list7);
            SectionListRenderer sectionListRenderer2 = (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list5 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list5)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null) ? null : content.sectionListRenderer;
            if (sectionListRenderer2 != null && (list4 = sectionListRenderer2.contents) != null) {
                list4.size();
            }
            ConnectionPool.d(new Object[0]);
            if (sectionListRenderer2 == null || (list3 = sectionListRenderer2.contents) == null) {
                arrayList = EmptyList.INSTANCE;
            } else {
                arrayList = new ArrayList();
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    MusicCarouselShelfRenderer musicCarouselShelfRenderer = ((SectionListRenderer.Content) it.next()).musicCarouselShelfRenderer;
                    if (musicCarouselShelfRenderer != null) {
                        arrayList.add(musicCarouselShelfRenderer);
                    }
                }
            }
            ConnectionPool connectionPool = Timber.Forest;
            arrayList.size();
            connectionPool.getClass();
            ConnectionPool.d(new Object[0]);
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                HomePage.Section sectionFromMusicCarouselShelfRenderer = HomePage.Section.Companion.fromMusicCarouselShelfRenderer((MusicCarouselShelfRenderer) it2.next());
                if (sectionFromMusicCarouselShelfRenderer != null) {
                    arrayList3.add(sectionFromMusicCarouselShelfRenderer);
                }
            }
            ArrayList arrayList4 = new ArrayList(arrayList3);
            ConnectionPool connectionPool2 = Timber.Forest;
            arrayList4.size();
            connectionPool2.getClass();
            ConnectionPool.d(new Object[0]);
            if (sectionListRenderer2 != null && (header = sectionListRenderer2.header) != null && (chipCloudRenderer = header.chipCloudRenderer) != null && (list = chipCloudRenderer.chips) != null) {
                ArrayList arrayList5 = new ArrayList();
                for (SectionListRenderer.Header.ChipCloudRenderer.Chip chip2 : list) {
                    chip2.getClass();
                    SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer chipCloudChipRenderer = chip2.chipCloudChipRenderer;
                    Runs runs = chipCloudChipRenderer.text;
                    if (runs == null || (list2 = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list2)) == null || (str3 = run.text) == null) {
                        chip = null;
                    } else {
                        NavigationEndpoint navigationEndpoint = chipCloudChipRenderer.navigationEndpoint;
                        BrowseEndpoint browseEndpoint = navigationEndpoint != null ? navigationEndpoint.browseEndpoint : null;
                        NavigationEndpoint navigationEndpoint2 = chipCloudChipRenderer.onDeselectedCommand;
                        chip = new HomePage.Chip(str3, browseEndpoint, navigationEndpoint2 != null ? navigationEndpoint2.browseEndpoint : null);
                    }
                    if (chip != null) {
                        arrayList5.add(chip);
                    }
                }
                arrayList2 = arrayList5;
            }
            ConnectionPool connectionPool3 = Timber.Forest;
            if (arrayList2 != null) {
                arrayList2.size();
            }
            connectionPool3.getClass();
            ConnectionPool.d(new Object[0]);
            return new HomePage(arrayList2, arrayList4, continuation);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v16, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r12v20, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: homeContinuation-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1010homeContinuationgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$homeContinuation$1 youTube$homeContinuation$1;
        TypeReference typeReferenceTypeOf;
        ?? arrayList;
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation;
        List list;
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation2;
        List list2;
        if (continuationImpl instanceof YouTube$homeContinuation$1) {
            youTube$homeContinuation$1 = (YouTube$homeContinuation$1) continuationImpl;
            int i = youTube$homeContinuation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$homeContinuation$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$homeContinuation$1 = new YouTube$homeContinuation$1(this, continuationImpl);
            }
        } else {
            youTube$homeContinuation$1 = new YouTube$homeContinuation$1(this, continuationImpl);
        }
        YouTube$homeContinuation$1 youTube$homeContinuation$2 = youTube$homeContinuation$1;
        Object objBrowse$default = youTube$homeContinuation$2.result;
        int i2 = youTube$homeContinuation$2.label;
        int i3 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$homeContinuation$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, null, null, str, false, youTube$homeContinuation$2, 22);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.ContinuationContents continuationContents = ((BrowseResponse) objBrowse$default).continuationContents;
                String continuation = (continuationContents == null || (sectionListContinuation2 = continuationContents.sectionListContinuation) == null || (list2 = sectionListContinuation2.continuations) == null) ? null : ContinuationKt.getContinuation(list2);
                if (continuationContents == null || (sectionListContinuation = continuationContents.sectionListContinuation) == null || (list = sectionListContinuation.contents) == null) {
                    arrayList = 0;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MusicCarouselShelfRenderer musicCarouselShelfRenderer = ((SectionListRenderer.Content) it.next()).musicCarouselShelfRenderer;
                        if (musicCarouselShelfRenderer != null) {
                            arrayList2.add(musicCarouselShelfRenderer);
                        }
                    }
                    arrayList = new ArrayList();
                    int size = arrayList2.size();
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        HomePage.Section sectionFromMusicCarouselShelfRenderer = HomePage.Section.Companion.fromMusicCarouselShelfRenderer((MusicCarouselShelfRenderer) obj);
                        if (sectionFromMusicCarouselShelfRenderer != null) {
                            arrayList.add(sectionFromMusicCarouselShelfRenderer);
                        }
                    }
                }
                if (arrayList == 0) {
                    arrayList = EmptyList.INSTANCE;
                }
                return new HomePage(null, arrayList, continuation);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$homeContinuation$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$homeContinuation$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0138 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0142 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0155 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x015f A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0172 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x017c A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x018a A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x019b A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x01b5 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x01cd A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01da A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x01ec A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0202 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0207  */
    /* JADX WARN: Code duplicated, block: B:157:0x020f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x0211 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0215  */
    /* JADX WARN: Code duplicated, block: B:161:0x0216  */
    /* JADX WARN: Code duplicated, block: B:165:0x0226 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0240 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0258 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x025d  */
    /* JADX WARN: Code duplicated, block: B:178:0x0262 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x026d A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x01b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x0230 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:? A[LOOP:8: B:113:0x0159->B:231:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:? A[LOOP:9: B:103:0x013c->B:234:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0090 A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00af A[Catch: all -> 0x0275, TryCatch #0 {all -> 0x0275, blocks: (B:14:0x0030, B:34:0x0090, B:36:0x009c, B:38:0x00a0, B:40:0x00a4, B:53:0x00c4, B:55:0x00c8, B:57:0x00cc, B:59:0x00d0, B:61:0x00d4, B:62:0x00d8, B:64:0x00de, B:66:0x00e9, B:68:0x00ed, B:70:0x00f1, B:72:0x00f5, B:76:0x00fc, B:79:0x0103, B:80:0x0107, B:82:0x010d, B:84:0x0117, B:86:0x011b, B:90:0x0121, B:93:0x0127, B:95:0x012b, B:100:0x0134, B:110:0x0151, B:120:0x016e, B:130:0x018a, B:131:0x0195, B:133:0x019b, B:135:0x01a5, B:136:0x01a9, B:138:0x01b5, B:140:0x01c3, B:141:0x01c7, B:143:0x01cd, B:145:0x01d3, B:179:0x0267, B:147:0x01da, B:149:0x01ec, B:151:0x01fa, B:152:0x01fe, B:154:0x0202, B:156:0x0208, B:158:0x0211, B:162:0x0217, B:163:0x0220, B:165:0x0226, B:167:0x0230, B:168:0x0234, B:170:0x0240, B:172:0x024e, B:173:0x0252, B:175:0x0258, B:177:0x025e, B:178:0x0262, B:122:0x0172, B:123:0x0176, B:125:0x017c, B:112:0x0155, B:113:0x0159, B:115:0x015f, B:102:0x0138, B:103:0x013c, B:105:0x0142, B:44:0x00af, B:46:0x00b3, B:48:0x00b7, B:180:0x026d, B:181:0x0274, B:19:0x003e, B:25:0x0067, B:29:0x0079, B:22:0x0048), top: B:185:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code duplicated, block: B:91:0x0124  */
    /* JADX WARN: Code duplicated, block: B:96:0x012e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0131  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v30 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX INFO: renamed from: library-0E7RQCE, reason: not valid java name */
    public final Object m1011library0E7RQCE(String str, int i, ContinuationImpl continuationImpl) {
        YouTube$library$1 youTube$library$1;
        ?? r0;
        TypeReference typeReferenceTypeOf;
        String str2;
        ?? r15;
        BrowseResponse.Contents contents;
        boolean zStartsWith;
        Tabs.Tab tab;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        List list;
        List list2;
        SectionListRenderer.Content content;
        List list3;
        Iterator it;
        GridRenderer gridRenderer;
        GridRenderer gridRenderer2;
        Iterator it2;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer2;
        Iterator it3;
        MusicShelfRenderer musicShelfRenderer;
        LibraryPage libraryPage;
        List list4;
        ArrayList arrayList;
        Iterator it4;
        ArrayList arrayList2;
        int size;
        int i2;
        List list5;
        String continuation;
        YTItem yTItemFromMusicResponsiveListItemRenderer;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        ArrayList items;
        ArrayList arrayList3;
        int size2;
        int i3;
        List list6;
        String continuation2;
        YTItem yTItemFromMusicResponsiveListItemRenderer2;
        ArrayList arrayList4;
        Iterator it5;
        ArrayList arrayList5;
        int size3;
        int i4;
        List list7;
        String continuation3;
        YTItem yTItemFromMusicTwoRowItemRenderer;
        MusicTwoRowItemRenderer musicTwoRowItemRenderer;
        ItemSectionRenderer itemSectionRenderer;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content2;
        SectionListRenderer sectionListRenderer;
        List list8;
        Object next;
        Tabs tabs;
        List list9;
        if (continuationImpl instanceof YouTube$library$1) {
            youTube$library$1 = (YouTube$library$1) continuationImpl;
            int i5 = youTube$library$1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                youTube$library$1.label = i5 - Integer.MIN_VALUE;
            } else {
                youTube$library$1 = new YouTube$library$1(this, continuationImpl);
            }
        } else {
            youTube$library$1 = new YouTube$library$1(this, continuationImpl);
        }
        YouTube$library$1 youTube$library$2 = youTube$library$1;
        Object objBrowse$default = youTube$library$2.result;
        int i6 = youTube$library$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i6 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$library$2.L$0 = str;
                    ?? r1 = i;
                    youTube$library$2.I$0 = r1;
                    youTube$library$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, null, null, true, youTube$library$2, 12);
                    r0 = r1;
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i6 == 1) {
                    boolean z = youTube$library$2.I$0;
                    String str3 = youTube$library$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                    r0 = z;
                    str = str3;
                } else {
                    if (i6 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    boolean z2 = youTube$library$2.I$0;
                    str2 = youTube$library$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                    r15 = z2;
                }
                if (objBrowse$default != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                contents = ((BrowseResponse) objBrowse$default).contents;
                zStartsWith = StringsKt__StringsJVMKt.startsWith(str2, "FEmusic_library_privately_owned", false);
                if (contents != null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list9 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.getOrNull(r15, list9)) == null) {
                    if (contents != null || (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) == null || (list = twoColumnBrowseResultsRenderer.tabs) == null) {
                        tab = null;
                    } else {
                        tab = (Tabs.Tab) CollectionsKt.getOrNull(r15, list);
                    }
                }
                list2 = EmptyList.INSTANCE;
                if (tab != null || (tabRenderer = tab.tabRenderer) == null || (content2 = tabRenderer.content) == null || (sectionListRenderer = content2.sectionListRenderer) == null || (list8 = sectionListRenderer.contents) == null) {
                    content = null;
                } else {
                    Iterator it6 = list8.iterator();
                    loop0: while (true) {
                        if (!it6.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it6.next();
                        SectionListRenderer.Content content3 = (SectionListRenderer.Content) next;
                        if (content3.gridRenderer != null || content3.musicShelfRenderer != null || content3.musicPlaylistShelfRenderer != null) {
                            break;
                        }
                        ItemSectionRenderer itemSectionRenderer2 = content3.itemSectionRenderer;
                        List<ItemSectionRenderer.Content> list10 = itemSectionRenderer2 != null ? itemSectionRenderer2.contents : null;
                        if (list10 == null) {
                            list10 = list2;
                        }
                        if (!list10.isEmpty()) {
                            for (ItemSectionRenderer.Content content4 : list10) {
                                if (content4.gridRenderer != null || content4.musicShelfRenderer != null || content4.musicPlaylistShelfRenderer != null) {
                                    break loop0;
                                    break loop0;
                                    break loop0;
                                }
                            }
                        }
                    }
                    content = (SectionListRenderer.Content) next;
                }
                if (content != null || (itemSectionRenderer = content.itemSectionRenderer) == null) {
                    list3 = null;
                } else {
                    list3 = itemSectionRenderer.contents;
                }
                if (list3 == null) {
                    list3 = list2;
                }
                if (content != null || (gridRenderer = content.gridRenderer) == null) {
                    it = list3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            gridRenderer = null;
                            break;
                        }
                        gridRenderer2 = ((ItemSectionRenderer.Content) it.next()).gridRenderer;
                        if (gridRenderer2 != null) {
                            gridRenderer = gridRenderer2;
                            break;
                        }
                    }
                }
                if (content != null || (musicPlaylistShelfRenderer = content.musicPlaylistShelfRenderer) == null) {
                    it2 = list3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            musicPlaylistShelfRenderer = null;
                            break;
                        }
                        musicPlaylistShelfRenderer2 = ((ItemSectionRenderer.Content) it2.next()).musicPlaylistShelfRenderer;
                        if (musicPlaylistShelfRenderer2 != null) {
                            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer2;
                            break;
                        }
                    }
                }
                if (content == null || (musicShelfRenderer = content.musicShelfRenderer) == null) {
                    it3 = list3.iterator();
                    do {
                        if (!it3.hasNext()) {
                            musicShelfRenderer = null;
                            break;
                        }
                        musicShelfRenderer = ((ItemSectionRenderer.Content) it3.next()).musicShelfRenderer;
                    } while (musicShelfRenderer == null);
                }
                if (gridRenderer != null) {
                    List list11 = gridRenderer.items;
                    arrayList4 = new ArrayList();
                    it5 = list11.iterator();
                    while (it5.hasNext()) {
                        musicTwoRowItemRenderer = ((GridRenderer.Item) it5.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList4.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList5 = new ArrayList();
                    size3 = arrayList4.size();
                    i4 = 0;
                    while (i4 < size3) {
                        Object obj = arrayList4.get(i4);
                        i4++;
                        yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList5.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    list7 = gridRenderer.continuations;
                    if (list7 != null) {
                        continuation3 = ContinuationKt.getContinuation(list7);
                    } else {
                        continuation3 = null;
                    }
                    libraryPage = new LibraryPage(continuation3, arrayList5, false);
                } else if (musicPlaylistShelfRenderer != null) {
                    items = MusicShelfRendererKt.getItems(musicPlaylistShelfRenderer.contents);
                    arrayList3 = new ArrayList();
                    size2 = items.size();
                    i3 = 0;
                    while (i3 < size2) {
                        Object obj2 = items.get(i3);
                        i3++;
                        yTItemFromMusicResponsiveListItemRenderer2 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2, zStartsWith);
                        if (yTItemFromMusicResponsiveListItemRenderer2 != null) {
                            arrayList3.add(yTItemFromMusicResponsiveListItemRenderer2);
                        }
                    }
                    list6 = musicPlaylistShelfRenderer.continuations;
                    if (list6 != null) {
                        continuation2 = ContinuationKt.getContinuation(list6);
                    } else {
                        continuation2 = null;
                    }
                    libraryPage = new LibraryPage(continuation2, arrayList3, false);
                } else if (musicShelfRenderer != null) {
                    list4 = musicShelfRenderer.contents;
                    if (list4 == null) {
                        list2 = list4;
                    }
                    arrayList = new ArrayList();
                    it4 = list2.iterator();
                    while (it4.hasNext()) {
                        musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it4.next()).musicResponsiveListItemRenderer;
                        if (musicResponsiveListItemRenderer != null) {
                            arrayList.add(musicResponsiveListItemRenderer);
                        }
                    }
                    arrayList2 = new ArrayList();
                    size = arrayList.size();
                    i2 = 0;
                    while (i2 < size) {
                        Object obj3 = arrayList.get(i2);
                        i2++;
                        yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj3, zStartsWith);
                        if (yTItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    list5 = musicShelfRenderer.continuations;
                    if (list5 != null) {
                        continuation = ContinuationKt.getContinuation(list5);
                    } else {
                        continuation = null;
                    }
                    libraryPage = new LibraryPage(continuation, arrayList2, false);
                } else {
                    libraryPage = new LibraryPage(null, list2, false);
                }
                return LibraryPage.copy$default(libraryPage, null, zStartsWith, 3);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$library$2.L$0 = str;
            youTube$library$2.I$0 = r0;
            youTube$library$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$library$2);
            if (objBrowse$default != coroutineSingletons) {
                ?? r13 = r0;
                str2 = str;
                r15 = r13 == true ? 1 : 0;
                if (objBrowse$default != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                contents = ((BrowseResponse) objBrowse$default).contents;
                zStartsWith = StringsKt__StringsJVMKt.startsWith(str2, "FEmusic_library_privately_owned", false);
                if (contents != null) {
                    if (contents != null) {
                        tab = null;
                    } else {
                        tab = null;
                    }
                } else if (contents != null) {
                    tab = null;
                } else {
                    tab = null;
                }
                list2 = EmptyList.INSTANCE;
                if (tab != null) {
                    content = null;
                } else {
                    content = null;
                }
                if (content != null) {
                    list3 = null;
                } else {
                    list3 = null;
                }
                if (list3 == null) {
                    list3 = list2;
                }
                if (content != null) {
                    it = list3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            gridRenderer = null;
                            break;
                        }
                        gridRenderer2 = ((ItemSectionRenderer.Content) it.next()).gridRenderer;
                        if (gridRenderer2 != null) {
                            gridRenderer = gridRenderer2;
                            break;
                        }
                    }
                } else {
                    it = list3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            gridRenderer = null;
                            break;
                        }
                        gridRenderer2 = ((ItemSectionRenderer.Content) it.next()).gridRenderer;
                        if (gridRenderer2 != null) {
                            gridRenderer = gridRenderer2;
                            break;
                        }
                    }
                }
                if (content != null) {
                    it2 = list3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            musicPlaylistShelfRenderer = null;
                            break;
                        }
                        musicPlaylistShelfRenderer2 = ((ItemSectionRenderer.Content) it2.next()).musicPlaylistShelfRenderer;
                        if (musicPlaylistShelfRenderer2 != null) {
                            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer2;
                            break;
                        }
                    }
                } else {
                    it2 = list3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            musicPlaylistShelfRenderer = null;
                            break;
                        }
                        musicPlaylistShelfRenderer2 = ((ItemSectionRenderer.Content) it2.next()).musicPlaylistShelfRenderer;
                        if (musicPlaylistShelfRenderer2 != null) {
                            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer2;
                            break;
                        }
                    }
                }
                if (content == null) {
                    it3 = list3.iterator();
                    do {
                        if (!it3.hasNext()) {
                            musicShelfRenderer = null;
                            break;
                        }
                        musicShelfRenderer = ((ItemSectionRenderer.Content) it3.next()).musicShelfRenderer;
                    } while (musicShelfRenderer == null);
                } else {
                    it3 = list3.iterator();
                    do {
                        if (!it3.hasNext()) {
                            musicShelfRenderer = null;
                            break;
                        }
                        musicShelfRenderer = ((ItemSectionRenderer.Content) it3.next()).musicShelfRenderer;
                    } while (musicShelfRenderer == null);
                }
                if (gridRenderer != null) {
                    List list12 = gridRenderer.items;
                    arrayList4 = new ArrayList();
                    it5 = list12.iterator();
                    while (it5.hasNext()) {
                        musicTwoRowItemRenderer = ((GridRenderer.Item) it5.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList4.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList5 = new ArrayList();
                    size3 = arrayList4.size();
                    i4 = 0;
                    while (i4 < size3) {
                        Object obj4 = arrayList4.get(i4);
                        i4++;
                        yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj4);
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList5.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    list7 = gridRenderer.continuations;
                    if (list7 != null) {
                        continuation3 = ContinuationKt.getContinuation(list7);
                    } else {
                        continuation3 = null;
                    }
                    libraryPage = new LibraryPage(continuation3, arrayList5, false);
                } else if (musicPlaylistShelfRenderer != null) {
                    items = MusicShelfRendererKt.getItems(musicPlaylistShelfRenderer.contents);
                    arrayList3 = new ArrayList();
                    size2 = items.size();
                    i3 = 0;
                    while (i3 < size2) {
                        Object obj5 = items.get(i3);
                        i3++;
                        yTItemFromMusicResponsiveListItemRenderer2 = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj5, zStartsWith);
                        if (yTItemFromMusicResponsiveListItemRenderer2 != null) {
                            arrayList3.add(yTItemFromMusicResponsiveListItemRenderer2);
                        }
                    }
                    list6 = musicPlaylistShelfRenderer.continuations;
                    if (list6 != null) {
                        continuation2 = ContinuationKt.getContinuation(list6);
                    } else {
                        continuation2 = null;
                    }
                    libraryPage = new LibraryPage(continuation2, arrayList3, false);
                } else if (musicShelfRenderer != null) {
                    list4 = musicShelfRenderer.contents;
                    if (list4 == null) {
                        list2 = list4;
                    }
                    arrayList = new ArrayList();
                    it4 = list2.iterator();
                    while (it4.hasNext()) {
                        musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it4.next()).musicResponsiveListItemRenderer;
                        if (musicResponsiveListItemRenderer != null) {
                            arrayList.add(musicResponsiveListItemRenderer);
                        }
                    }
                    arrayList2 = new ArrayList();
                    size = arrayList.size();
                    i2 = 0;
                    while (i2 < size) {
                        Object obj6 = arrayList.get(i2);
                        i2++;
                        yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj6, zStartsWith);
                        if (yTItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    list5 = musicShelfRenderer.continuations;
                    if (list5 != null) {
                        continuation = ContinuationKt.getContinuation(list5);
                    } else {
                        continuation = null;
                    }
                    libraryPage = new LibraryPage(continuation, arrayList2, false);
                } else {
                    libraryPage = new LibraryPage(null, list2, false);
                }
                return LibraryPage.copy$default(libraryPage, null, zStartsWith, 3);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x010b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x007e A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0084 A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0087  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x009d A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6 A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ce A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f4 A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x010d A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0125 A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x012f A[Catch: all -> 0x0137, TryCatch #0 {all -> 0x0137, blocks: (B:14:0x002c, B:34:0x007e, B:36:0x0084, B:39:0x008a, B:40:0x0097, B:42:0x009d, B:44:0x00a7, B:45:0x00ab, B:47:0x00b6, B:49:0x00c4, B:50:0x00c8, B:52:0x00ce, B:53:0x00d2, B:55:0x00da, B:57:0x00de, B:59:0x00e2, B:60:0x00ee, B:62:0x00f4, B:64:0x00fe, B:65:0x0102, B:67:0x010d, B:69:0x011b, B:70:0x011f, B:72:0x0125, B:73:0x0129, B:74:0x012f, B:75:0x0136, B:19:0x0038, B:25:0x0059, B:29:0x006b, B:22:0x0040), top: B:79:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x00a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code duplicated, block: B:90:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x011b A[SYNTHETIC] */
    /* JADX INFO: renamed from: libraryContinuation-0E7RQCE, reason: not valid java name */
    public final Object m1012libraryContinuation0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$libraryContinuation$1 youTube$libraryContinuation$1;
        TypeReference typeReferenceTypeOf;
        boolean z2;
        BrowseResponse.ContinuationContents continuationContents;
        BrowseResponse.ContinuationContents.GridContinuation gridContinuation;
        List list;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        int size;
        YTItem yTItemFromMusicResponsiveListItemRenderer;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        MusicShelfRenderer musicShelfRenderer;
        ArrayList arrayList3;
        Iterator it2;
        ArrayList arrayList4;
        int size2;
        YTItem yTItemFromMusicTwoRowItemRenderer;
        MusicTwoRowItemRenderer musicTwoRowItemRenderer;
        if (continuationImpl instanceof YouTube$libraryContinuation$1) {
            youTube$libraryContinuation$1 = (YouTube$libraryContinuation$1) continuationImpl;
            int i = youTube$libraryContinuation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$libraryContinuation$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$libraryContinuation$1 = new YouTube$libraryContinuation$1(this, continuationImpl);
            }
        } else {
            youTube$libraryContinuation$1 = new YouTube$libraryContinuation$1(this, continuationImpl);
        }
        YouTube$libraryContinuation$1 youTube$libraryContinuation$2 = youTube$libraryContinuation$1;
        Object objBrowse$default = youTube$libraryContinuation$2.result;
        int i2 = youTube$libraryContinuation$2.label;
        int i3 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$libraryContinuation$2.Z$0 = z;
                    youTube$libraryContinuation$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, null, null, str, true, youTube$libraryContinuation$2, 6);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    z = youTube$libraryContinuation$2.Z$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    z2 = youTube$libraryContinuation$2.Z$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                continuationContents = ((BrowseResponse) objBrowse$default).continuationContents;
                if (continuationContents != null) {
                    gridContinuation = continuationContents.gridContinuation;
                } else {
                    gridContinuation = null;
                }
                if (gridContinuation != null) {
                    List list2 = continuationContents.gridContinuation.items;
                    arrayList3 = new ArrayList();
                    it2 = list2.iterator();
                    while (it2.hasNext()) {
                        musicTwoRowItemRenderer = ((GridRenderer.Item) it2.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList3.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList4 = new ArrayList();
                    size2 = arrayList3.size();
                    while (i3 < size2) {
                        Object obj = arrayList3.get(i3);
                        i3++;
                        yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList4.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    List list3 = continuationContents.gridContinuation.continuations;
                    return new LibraryContinuationPage(list3 != null ? ContinuationKt.getContinuation(list3) : null, arrayList4);
                }
                if (continuationContents != null || (musicShelfRenderer = continuationContents.musicShelfContinuation) == null) {
                    list = null;
                } else {
                    list = musicShelfRenderer.contents;
                }
                list.getClass();
                arrayList = new ArrayList();
                it = list.iterator();
                while (it.hasNext()) {
                    musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it.next()).musicResponsiveListItemRenderer;
                    if (musicResponsiveListItemRenderer != null) {
                        arrayList.add(musicResponsiveListItemRenderer);
                    }
                }
                arrayList2 = new ArrayList();
                size = arrayList.size();
                while (i3 < size) {
                    Object obj2 = arrayList.get(i3);
                    i3++;
                    yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2, z2);
                    if (yTItemFromMusicResponsiveListItemRenderer != null) {
                        arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                    }
                }
                List list4 = continuationContents.musicShelfContinuation.continuations;
                return new LibraryContinuationPage(list4 != null ? ContinuationKt.getContinuation(list4) : null, arrayList2);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$libraryContinuation$2.Z$0 = z;
            youTube$libraryContinuation$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$libraryContinuation$2);
            if (objBrowse$default != coroutineSingletons) {
                z2 = z;
                if (objBrowse$default != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                continuationContents = ((BrowseResponse) objBrowse$default).continuationContents;
                if (continuationContents != null) {
                    gridContinuation = continuationContents.gridContinuation;
                } else {
                    gridContinuation = null;
                }
                if (gridContinuation != null) {
                    List list5 = continuationContents.gridContinuation.items;
                    arrayList3 = new ArrayList();
                    it2 = list5.iterator();
                    while (it2.hasNext()) {
                        musicTwoRowItemRenderer = ((GridRenderer.Item) it2.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList3.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList4 = new ArrayList();
                    size2 = arrayList3.size();
                    while (i3 < size2) {
                        Object obj3 = arrayList3.get(i3);
                        i3++;
                        yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj3);
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList4.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                    List list6 = continuationContents.gridContinuation.continuations;
                    return new LibraryContinuationPage(list6 != null ? ContinuationKt.getContinuation(list6) : null, arrayList4);
                }
                if (continuationContents != null) {
                    list = null;
                } else {
                    list = null;
                }
                list.getClass();
                arrayList = new ArrayList();
                it = list.iterator();
                while (it.hasNext()) {
                    musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it.next()).musicResponsiveListItemRenderer;
                    if (musicResponsiveListItemRenderer != null) {
                        arrayList.add(musicResponsiveListItemRenderer);
                    }
                }
                arrayList2 = new ArrayList();
                size = arrayList.size();
                while (i3 < size) {
                    Object obj4 = arrayList.get(i3);
                    i3++;
                    yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj4, z2);
                    if (yTItemFromMusicResponsiveListItemRenderer != null) {
                        arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                    }
                }
                List list7 = continuationContents.musicShelfContinuation.continuations;
                return new LibraryContinuationPage(list7 != null ? ContinuationKt.getContinuation(list7) : null, arrayList2);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:83:0x0148  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r12 == r11) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX INFO: renamed from: libraryPodcastChannels-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1013libraryPodcastChannelsIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$libraryPodcastChannels$1 youTube$libraryPodcastChannels$1;
        Object failure;
        TypeReference typeReferenceTypeOf;
        List<SectionListRenderer.Content> list;
        ?? arrayList;
        YTItem yTItemFromMusicMultiRowListItemRenderer;
        Tabs tabs;
        List list2;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        if (continuationImpl instanceof YouTube$libraryPodcastChannels$1) {
            youTube$libraryPodcastChannels$1 = (YouTube$libraryPodcastChannels$1) continuationImpl;
            int i = youTube$libraryPodcastChannels$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$libraryPodcastChannels$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$libraryPodcastChannels$1 = new YouTube$libraryPodcastChannels$1(this, continuationImpl);
            }
        } else {
            youTube$libraryPodcastChannels$1 = new YouTube$libraryPodcastChannels$1(this, continuationImpl);
        }
        YouTube$libraryPodcastChannels$1 youTube$libraryPodcastChannels$2 = youTube$libraryPodcastChannels$1;
        Object objBrowse$default = youTube$libraryPodcastChannels$2.result;
        int i2 = youTube$libraryPodcastChannels$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$libraryPodcastChannels$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_library_non_music_audio_channels_list", null, null, true, youTube$libraryPodcastChannels$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                EmptyList emptyList = EmptyList.INSTANCE;
                if (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list2 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list2)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null || (list = sectionListRenderer.contents) == null) {
                    list = emptyList;
                }
                ArrayList arrayList2 = new ArrayList();
                for (SectionListRenderer.Content content2 : list) {
                    GridRenderer gridRenderer = content2.gridRenderer;
                    if (gridRenderer != null) {
                        List list3 = gridRenderer.items;
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = list3.iterator();
                        while (it.hasNext()) {
                            MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                            if (musicTwoRowItemRenderer != null) {
                                arrayList3.add(musicTwoRowItemRenderer);
                            }
                        }
                        arrayList = new ArrayList();
                        int size = arrayList3.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = arrayList3.get(i3);
                            i3++;
                            YTItem yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                            if (yTItemFromMusicTwoRowItemRenderer != null) {
                                arrayList.add(yTItemFromMusicTwoRowItemRenderer);
                            }
                        }
                    } else {
                        MusicShelfRenderer musicShelfRenderer = content2.musicShelfRenderer;
                        if (musicShelfRenderer != null) {
                            List list4 = musicShelfRenderer.contents;
                            if (list4 != null) {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it2 = list4.iterator();
                                while (it2.hasNext()) {
                                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                                    if (musicResponsiveListItemRenderer != null) {
                                        arrayList4.add(musicResponsiveListItemRenderer);
                                    }
                                }
                                arrayList = new ArrayList();
                                int size2 = arrayList4.size();
                                int i4 = 0;
                                while (i4 < size2) {
                                    Object obj2 = arrayList4.get(i4);
                                    i4++;
                                    YTItem yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2, false);
                                    if (yTItemFromMusicResponsiveListItemRenderer != null) {
                                        arrayList.add(yTItemFromMusicResponsiveListItemRenderer);
                                    }
                                }
                            } else {
                                arrayList = emptyList;
                            }
                        } else {
                            MusicCarouselShelfRenderer musicCarouselShelfRenderer = content2.musicCarouselShelfRenderer;
                            if (musicCarouselShelfRenderer != null) {
                                List<MusicCarouselShelfRenderer.Content> list5 = musicCarouselShelfRenderer.contents;
                                ArrayList arrayList5 = new ArrayList();
                                for (MusicCarouselShelfRenderer.Content content3 : list5) {
                                    MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = content3.musicTwoRowItemRenderer;
                                    if (musicTwoRowItemRenderer2 == null || (yTItemFromMusicMultiRowListItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer2)) == null) {
                                        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = content3.musicMultiRowListItemRenderer;
                                        yTItemFromMusicMultiRowListItemRenderer = musicMultiRowListItemRenderer != null ? PodcastPage.Companion.fromMusicMultiRowListItemRenderer(musicMultiRowListItemRenderer, null) : null;
                                        if (yTItemFromMusicMultiRowListItemRenderer == null) {
                                            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = content3.musicResponsiveListItemRenderer;
                                            yTItemFromMusicMultiRowListItemRenderer = musicResponsiveListItemRenderer2 != null ? LibraryPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer2, false) : null;
                                        }
                                    }
                                    if (yTItemFromMusicMultiRowListItemRenderer != null) {
                                        arrayList5.add(yTItemFromMusicMultiRowListItemRenderer);
                                    }
                                }
                                arrayList = arrayList5;
                            } else {
                                arrayList = emptyList;
                            }
                        }
                    }
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
                }
                failure = new LibraryPage(null, arrayList2, false);
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                if (!(failure instanceof Result.Failure)) {
                    ConnectionPool connectionPool = Timber.Forest;
                    ((LibraryPage) failure).items.size();
                    connectionPool.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                return failure;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$libraryPodcastChannels$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$libraryPodcastChannels$2);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r12 == r11) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v28, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v32, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: libraryPodcastEpisodes-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1014libraryPodcastEpisodesIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$libraryPodcastEpisodes$1 youTube$libraryPodcastEpisodes$1;
        Object failure;
        TypeReference typeReferenceTypeOf;
        ?? arrayList;
        List list;
        Tabs tabs;
        List list2;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list3;
        if (continuationImpl instanceof YouTube$libraryPodcastEpisodes$1) {
            youTube$libraryPodcastEpisodes$1 = (YouTube$libraryPodcastEpisodes$1) continuationImpl;
            int i = youTube$libraryPodcastEpisodes$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$libraryPodcastEpisodes$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$libraryPodcastEpisodes$1 = new YouTube$libraryPodcastEpisodes$1(this, continuationImpl);
            }
        } else {
            youTube$libraryPodcastEpisodes$1 = new YouTube$libraryPodcastEpisodes$1(this, continuationImpl);
        }
        YouTube$libraryPodcastEpisodes$1 youTube$libraryPodcastEpisodes$2 = youTube$libraryPodcastEpisodes$1;
        Object objBrowse$default = youTube$libraryPodcastEpisodes$2.result;
        int i2 = youTube$libraryPodcastEpisodes$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$libraryPodcastEpisodes$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_library_non_music_audio_list", null, null, true, youTube$libraryPodcastEpisodes$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                SectionListRenderer.Content content2 = (contents == null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list2 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list2)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (sectionListRenderer = content.sectionListRenderer) == null || (list3 = sectionListRenderer.contents) == null) ? null : (SectionListRenderer.Content) CollectionsKt.firstOrNull(list3);
                if ((content2 != null ? content2.gridRenderer : null) != null) {
                    List list4 = content2.gridRenderer.items;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list4.iterator();
                    while (it.hasNext()) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList2.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList = new ArrayList();
                    int size = arrayList2.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        YTItem yTItemFromMusicTwoRowItemRenderer = LibraryPage.Companion.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                        if (yTItemFromMusicTwoRowItemRenderer != null) {
                            arrayList.add(yTItemFromMusicTwoRowItemRenderer);
                        }
                    }
                } else {
                    MusicShelfRenderer musicShelfRenderer = content2 != null ? content2.musicShelfRenderer : null;
                    EmptyList emptyList = EmptyList.INSTANCE;
                    if (musicShelfRenderer == null || (list = content2.musicShelfRenderer.contents) == null) {
                        arrayList = emptyList;
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                            if (musicResponsiveListItemRenderer != null) {
                                arrayList3.add(musicResponsiveListItemRenderer);
                            }
                        }
                        arrayList = new ArrayList();
                        int size2 = arrayList3.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj2 = arrayList3.get(i4);
                            i4++;
                            YTItem yTItemFromMusicResponsiveListItemRenderer = LibraryPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2, false);
                            if (yTItemFromMusicResponsiveListItemRenderer != null) {
                                arrayList.add(yTItemFromMusicResponsiveListItemRenderer);
                            }
                        }
                    }
                }
                failure = new LibraryPage(null, arrayList, false);
                if (Result.m1866exceptionOrNullimpl(failure) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                if (!(failure instanceof Result.Failure)) {
                    ConnectionPool connectionPool = Timber.Forest;
                    ((LibraryPage) failure).items.size();
                    connectionPool.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                return failure;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$libraryPodcastEpisodes$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$libraryPodcastEpisodes$2);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r4 == r7) goto L27;
     */
    /* JADX INFO: renamed from: likePlaylist-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1015likePlaylist0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$likePlaylist$1 youTube$likePlaylist$1;
        if (continuationImpl instanceof YouTube$likePlaylist$1) {
            youTube$likePlaylist$1 = (YouTube$likePlaylist$1) continuationImpl;
            int i = youTube$likePlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$likePlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$likePlaylist$1 = new YouTube$likePlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$likePlaylist$1 = new YouTube$likePlaylist$1(this, continuationImpl);
        }
        Object objUnlikePlaylist = youTube$likePlaylist$1.result;
        int i2 = youTube$likePlaylist$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objUnlikePlaylist);
                    return (HttpResponse) objUnlikePlaylist;
                }
                if (i2 == 2) {
                    ResultKt.throwOnFailure(objUnlikePlaylist);
                    return (HttpResponse) objUnlikePlaylist;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objUnlikePlaylist);
            InnerTube innerTube2 = innerTube;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (z) {
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$likePlaylist$1.label = 1;
                objUnlikePlaylist = innerTube2.likePlaylist(youTubeClient, str, youTube$likePlaylist$1);
                if (objUnlikePlaylist == coroutineSingletons) {
                }
                return (HttpResponse) objUnlikePlaylist;
            }
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient2 = YouTubeClient.WEB_REMIX;
            youTube$likePlaylist$1.label = 2;
            objUnlikePlaylist = innerTube2.unlikePlaylist(youTubeClient2, str, youTube$likePlaylist$1);
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r4 == r7) goto L27;
     */
    /* JADX INFO: renamed from: likeVideo-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1016likeVideo0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$likeVideo$1 youTube$likeVideo$1;
        if (continuationImpl instanceof YouTube$likeVideo$1) {
            youTube$likeVideo$1 = (YouTube$likeVideo$1) continuationImpl;
            int i = youTube$likeVideo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$likeVideo$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$likeVideo$1 = new YouTube$likeVideo$1(this, continuationImpl);
            }
        } else {
            youTube$likeVideo$1 = new YouTube$likeVideo$1(this, continuationImpl);
        }
        Object objUnlikeVideo = youTube$likeVideo$1.result;
        int i2 = youTube$likeVideo$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objUnlikeVideo);
                    return (HttpResponse) objUnlikeVideo;
                }
                if (i2 == 2) {
                    ResultKt.throwOnFailure(objUnlikeVideo);
                    return (HttpResponse) objUnlikeVideo;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objUnlikeVideo);
            InnerTube innerTube2 = innerTube;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (z) {
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$likeVideo$1.label = 1;
                objUnlikeVideo = innerTube2.likeVideo(youTubeClient, str, youTube$likeVideo$1);
                if (objUnlikeVideo == coroutineSingletons) {
                }
                return (HttpResponse) objUnlikeVideo;
            }
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient2 = YouTubeClient.WEB_REMIX;
            youTube$likeVideo$1.label = 2;
            objUnlikeVideo = innerTube2.unlikeVideo(youTubeClient2, str, youTube$likeVideo$1);
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r11 == r10) goto L29;
     */
    /* JADX INFO: renamed from: lyrics-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1017lyricsgIAlus(BrowseEndpoint browseEndpoint, ContinuationImpl continuationImpl) {
        YouTube$lyrics$1 youTube$lyrics$1;
        TypeReference typeReferenceTypeOf;
        SectionListRenderer sectionListRenderer;
        List list;
        Object next;
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer;
        Runs runs;
        List list2;
        if (continuationImpl instanceof YouTube$lyrics$1) {
            youTube$lyrics$1 = (YouTube$lyrics$1) continuationImpl;
            int i = youTube$lyrics$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$lyrics$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$lyrics$1 = new YouTube$lyrics$1(this, continuationImpl);
            }
        } else {
            youTube$lyrics$1 = new YouTube$lyrics$1(this, continuationImpl);
        }
        YouTube$lyrics$1 youTube$lyrics$2 = youTube$lyrics$1;
        Object objBrowse$default = youTube$lyrics$2.result;
        int i2 = youTube$lyrics$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    String str = browseEndpoint.browseId;
                    String str2 = browseEndpoint.params;
                    youTube$lyrics$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, str2, null, false, youTube$lyrics$2, 24);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents == null || (sectionListRenderer = contents.sectionListRenderer) == null || (list = sectionListRenderer.contents) == null) {
                    return null;
                }
                Iterator it = list.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (((SectionListRenderer.Content) next).musicDescriptionShelfRenderer == null);
                SectionListRenderer.Content content = (SectionListRenderer.Content) next;
                if (content == null || (musicDescriptionShelfRenderer = content.musicDescriptionShelfRenderer) == null || (runs = musicDescriptionShelfRenderer.description) == null || (list2 = runs.runs) == null) {
                    return null;
                }
                return CollectionsKt.joinToString$default(list2, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 3), 30);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$lyrics$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$lyrics$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r11 == r10) goto L29;
     */
    /* JADX INFO: renamed from: moodAndGenres-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1018moodAndGenresIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$moodAndGenres$1 youTube$moodAndGenres$1;
        TypeReference typeReferenceTypeOf;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        if (continuationImpl instanceof YouTube$moodAndGenres$1) {
            youTube$moodAndGenres$1 = (YouTube$moodAndGenres$1) continuationImpl;
            int i = youTube$moodAndGenres$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$moodAndGenres$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$moodAndGenres$1 = new YouTube$moodAndGenres$1(this, continuationImpl);
            }
        } else {
            youTube$moodAndGenres$1 = new YouTube$moodAndGenres$1(this, continuationImpl);
        }
        YouTube$moodAndGenres$1 youTube$moodAndGenres$2 = youTube$moodAndGenres$1;
        Object objBrowse$default = youTube$moodAndGenres$2.result;
        int i2 = youTube$moodAndGenres$2.label;
        List list2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$moodAndGenres$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_moods_and_genres", null, null, false, youTube$moodAndGenres$2, 28);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null) {
                    list2 = sectionListRenderer.contents;
                }
                list2.getClass();
                ArrayList arrayList = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    MoodAndGenres moodAndGenresFromSectionListRendererContent = MoodAndGenres.Companion.fromSectionListRendererContent((SectionListRenderer.Content) it.next());
                    if (moodAndGenresFromSectionListRendererContent != null) {
                        arrayList.add(moodAndGenresFromSectionListRendererContent);
                    }
                }
                return arrayList;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$moodAndGenres$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$moodAndGenres$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: moveSongPlaylist-BWLJW6A, reason: not valid java name */
    public final Object m1019moveSongPlaylistBWLJW6A(String str, String str2, String str3, ContinuationImpl continuationImpl) {
        YouTube$moveSongPlaylist$1 youTube$moveSongPlaylist$1;
        if (continuationImpl instanceof YouTube$moveSongPlaylist$1) {
            youTube$moveSongPlaylist$1 = (YouTube$moveSongPlaylist$1) continuationImpl;
            int i = youTube$moveSongPlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$moveSongPlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$moveSongPlaylist$1 = new YouTube$moveSongPlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$moveSongPlaylist$1 = new YouTube$moveSongPlaylist$1(this, continuationImpl);
        }
        YouTube$moveSongPlaylist$1 youTube$moveSongPlaylist$2 = youTube$moveSongPlaylist$1;
        Object objMoveSongPlaylist = youTube$moveSongPlaylist$2.result;
        int i2 = youTube$moveSongPlaylist$2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMoveSongPlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$moveSongPlaylist$2.label = 1;
                objMoveSongPlaylist = innerTube2.moveSongPlaylist(youTubeClient, str, str2, str3, youTube$moveSongPlaylist$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objMoveSongPlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objMoveSongPlaylist);
            }
            return (HttpResponse) objMoveSongPlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r11 == r10) goto L29;
     */
    /* JADX INFO: renamed from: musicHistory-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1020musicHistoryIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$musicHistory$1 youTube$musicHistory$1;
        TypeReference typeReferenceTypeOf;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        if (continuationImpl instanceof YouTube$musicHistory$1) {
            youTube$musicHistory$1 = (YouTube$musicHistory$1) continuationImpl;
            int i = youTube$musicHistory$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$musicHistory$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$musicHistory$1 = new YouTube$musicHistory$1(this, continuationImpl);
            }
        } else {
            youTube$musicHistory$1 = new YouTube$musicHistory$1(this, continuationImpl);
        }
        YouTube$musicHistory$1 youTube$musicHistory$2 = youTube$musicHistory$1;
        Object objBrowse$default = youTube$musicHistory$2.result;
        int i2 = youTube$musicHistory$2.label;
        ArrayList arrayList = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$musicHistory$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_history", null, null, true, youTube$musicHistory$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        MusicShelfRenderer musicShelfRenderer = ((SectionListRenderer.Content) it.next()).musicShelfRenderer;
                        HistoryPage.HistorySection historySectionFromMusicShelfRenderer = musicShelfRenderer != null ? HistoryPage.Companion.fromMusicShelfRenderer(musicShelfRenderer) : null;
                        if (historySectionFromMusicShelfRenderer != null) {
                            arrayList2.add(historySectionFromMusicShelfRenderer);
                        }
                    }
                    arrayList = arrayList2;
                }
                return new HistoryPage(arrayList);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$musicHistory$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$musicHistory$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0186 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:108:0x01a8 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:227:0x040b  */
    /* JADX WARN: Code duplicated, block: B:229:0x0413 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0436 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0439  */
    /* JADX WARN: Code duplicated, block: B:239:0x0448 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:240:0x044b  */
    /* JADX WARN: Code duplicated, block: B:242:0x044f A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:245:0x045c A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:247:0x0464 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:249:0x046e A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:250:0x0471  */
    /* JADX WARN: Code duplicated, block: B:294:0x052e A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:296:0x053a A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:302:0x054d A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:309:0x0562  */
    /* JADX WARN: Code duplicated, block: B:325:0x0588  */
    /* JADX WARN: Code duplicated, block: B:327:0x058c A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:330:0x059a A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:335:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:346:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:354:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:35:0x0094 A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:361:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:367:0x064d A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:379:0x042c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:382:0x041e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:390:0x051e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x0541 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:399:0x052c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:401:0x0557 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x0566 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x0547 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:410:0x0547 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:0x05b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:417:0x05b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:420:? A[LOOP:9: B:328:0x0594->B:420:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00e7 A[Catch: all -> 0x0038, LOOP:0: B:63:0x00e1->B:65:0x00e7, LOOP_END, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:82:0x012c A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0136 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x014c A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:14:0x0033, B:366:0x064a, B:20:0x0041, B:35:0x0094, B:37:0x009a, B:39:0x009e, B:41:0x00a5, B:43:0x00a9, B:45:0x00b1, B:47:0x00b5, B:49:0x00b9, B:51:0x00bd, B:53:0x00c1, B:56:0x00c8, B:58:0x00cc, B:60:0x00d0, B:62:0x00d4, B:63:0x00e1, B:65:0x00e7, B:66:0x00fa, B:67:0x00fd, B:69:0x0104, B:71:0x0108, B:73:0x010d, B:75:0x0111, B:77:0x0115, B:79:0x0119, B:80:0x011c, B:82:0x012c, B:84:0x0136, B:86:0x0140, B:88:0x014c, B:90:0x0150, B:92:0x0154, B:94:0x0158, B:96:0x015c, B:98:0x0177, B:101:0x0186, B:103:0x018a, B:105:0x018e, B:106:0x01a4, B:108:0x01a8, B:109:0x01af, B:111:0x01b8, B:113:0x01c0, B:115:0x01c4, B:117:0x01c8, B:119:0x01cc, B:120:0x01e2, B:122:0x01e6, B:124:0x01ea, B:125:0x0200, B:127:0x0204, B:129:0x0208, B:130:0x021e, B:132:0x0227, B:137:0x0233, B:138:0x0240, B:140:0x0246, B:142:0x0252, B:144:0x0256, B:147:0x025e, B:150:0x0281, B:152:0x028e, B:154:0x0293, B:156:0x0297, B:157:0x02a6, B:159:0x02ac, B:161:0x02b8, B:163:0x02bc, B:166:0x02c4, B:168:0x02e1, B:170:0x02f1, B:172:0x02f5, B:174:0x02f9, B:175:0x0309, B:177:0x030f, B:179:0x0317, B:181:0x031d, B:183:0x0321, B:185:0x0325, B:187:0x033f, B:189:0x0343, B:191:0x0347, B:193:0x034b, B:196:0x0352, B:198:0x0356, B:200:0x035a, B:202:0x035e, B:204:0x0362, B:207:0x036a, B:209:0x036e, B:211:0x0372, B:213:0x0376, B:215:0x0394, B:217:0x0398, B:219:0x039c, B:221:0x03a1, B:222:0x03ed, B:223:0x03f0, B:226:0x03fc, B:229:0x0413, B:231:0x042c, B:232:0x0431, B:235:0x0436, B:237:0x043b, B:239:0x0448, B:242:0x044f, B:243:0x0456, B:245:0x045c, B:247:0x0464, B:249:0x046e, B:252:0x0475, B:254:0x0479, B:255:0x047c, B:257:0x0489, B:259:0x048d, B:260:0x0492, B:262:0x0498, B:264:0x04a0, B:266:0x04a8, B:268:0x04ae, B:270:0x04b2, B:271:0x04c8, B:273:0x04cc, B:274:0x04d3, B:276:0x04de, B:278:0x04e2, B:280:0x04e6, B:282:0x04ea, B:284:0x04ee, B:285:0x0504, B:287:0x0517, B:288:0x051a, B:290:0x051e, B:291:0x0521, B:292:0x0522, B:294:0x052e, B:296:0x053a, B:297:0x053d, B:299:0x0541, B:300:0x0547, B:302:0x054d, B:304:0x0557, B:306:0x055b, B:308:0x055f, B:311:0x0566, B:313:0x056a, B:315:0x056e, B:317:0x0576, B:320:0x057b, B:322:0x057f, B:324:0x0583, B:327:0x058c, B:328:0x0594, B:330:0x059a, B:332:0x05a9, B:334:0x05ad, B:339:0x05b9, B:341:0x05bd, B:343:0x05c5, B:345:0x05c9, B:347:0x05d2, B:349:0x05d6, B:351:0x05da, B:353:0x05de, B:355:0x05e3, B:357:0x05f3, B:362:0x0600, B:363:0x0629, B:367:0x064d, B:368:0x0654, B:21:0x0045, B:27:0x0071, B:31:0x0083, B:24:0x0056), top: B:376:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:97:0x0175  */
    /* JADX WARN: Code duplicated, block: B:99:0x0182  */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0647, code lost:
    
        if (r0 == r15) goto L365;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.metrolist.innertube.models.Tabs] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.metrolist.innertube.models.SectionListRenderer] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v68, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v73, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r37v1, types: [java.lang.Throwable, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.util.List] */
    /* JADX INFO: renamed from: newEpisodes-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1021newEpisodesIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$newEpisodes$1 youTube$newEpisodes$1;
        Object objCreateFailure;
        TypeReference typeReferenceTypeOf;
        BrowseResponse.Contents contents;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        ArrayList arrayList;
        int i;
        int size;
        int i2;
        int i3;
        ?? r37;
        ?? r0;
        ?? r1;
        ArrayList arrayList2;
        int size2;
        int i4;
        MusicShelfRenderer musicShelfRenderer;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer;
        Iterator it;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        NavigationEndpoint navigationEndpoint;
        ?? r7;
        Runs runs;
        List list;
        Run run;
        String str;
        Runs runs2;
        ?? r8;
        ?? M1883parseTime;
        MusicCarouselShelfRenderer.Header header;
        ?? r9;
        ThumbnailRenderer thumbnailRenderer;
        String thumbnailUrl;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;
        Runs runs3;
        ListIterator listIterator;
        ?? r10;
        List list2;
        Run run2;
        String str2;
        Object objPrevious;
        Run run3;
        ?? M1883parseTime2;
        String str3;
        List list3;
        ArrayList arrayListSplitBySeparator;
        WatchEndpoint watchEndpoint;
        String str4;
        int i5;
        int i6;
        Tabs.Tab.TabRenderer.Content content;
        ?? r2;
        List list4;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer2;
        Runs runs4;
        List list5;
        List list6;
        List list7;
        SectionListRenderer sectionListRenderer;
        List list8;
        Object obj;
        int i7;
        int i8;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        MusicShelfRenderer musicShelfRenderer2;
        MusicCarouselShelfRenderer musicCarouselShelfRenderer2;
        int i9;
        int i10;
        int i11;
        Runs runs5;
        List list9;
        List list10;
        MusicShelfRenderer.Content content2;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2;
        ?? arrayList3;
        ?? arrayList4;
        Object obj2;
        Menu.MenuRenderer menuRenderer;
        List list11;
        ?? r14;
        ?? r13;
        Icon icon;
        Runs runs6;
        List list12;
        NavigationEndpoint navigationEndpoint2;
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        NavigationEndpoint navigationEndpoint3;
        BrowseEndpoint browseEndpoint2;
        String str5;
        Runs runs7;
        List list13;
        BrowseEndpoint browseEndpoint3;
        BrowseEndpoint browseEndpoint4;
        List list14;
        List list15;
        List list16;
        List list17;
        MusicCarouselShelfRenderer.Header header2;
        MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer3;
        Runs runs8;
        List list18;
        BrowseResponse.SecondaryContents secondaryContents;
        SectionListRenderer sectionListRenderer2;
        List list19;
        List list20;
        BrowseResponse.SecondaryContents secondaryContents2;
        SectionListRenderer sectionListRenderer3;
        List<SectionListRenderer.Content> list21;
        ArrayList arrayList5;
        List list22;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content3;
        SectionListRenderer sectionListRenderer4;
        List list23;
        if (continuationImpl instanceof YouTube$newEpisodes$1) {
            youTube$newEpisodes$1 = (YouTube$newEpisodes$1) continuationImpl;
            int i12 = youTube$newEpisodes$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                youTube$newEpisodes$1.label = i12 - Integer.MIN_VALUE;
            } else {
                youTube$newEpisodes$1 = new YouTube$newEpisodes$1(this, continuationImpl);
            }
        } else {
            youTube$newEpisodes$1 = new YouTube$newEpisodes$1(this, continuationImpl);
        }
        YouTube$newEpisodes$1 youTube$newEpisodes$2 = youTube$newEpisodes$1;
        Object objBrowse$default = youTube$newEpisodes$2.result;
        int i13 = youTube$newEpisodes$2.label;
        int i14 = 0;
        Throwable th = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i13 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$newEpisodes$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "VLRDPN", null, null, true, youTube$newEpisodes$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i13 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else if (i13 == 2) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    if (objBrowse$default != null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                    }
                    contents = ((BrowseResponse) objBrowse$default).contents;
                    if (contents != null) {
                        twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer;
                    } else {
                        twoColumnBrowseResultsRenderer = null;
                    }
                    arrayList = new ArrayList();
                    if (twoColumnBrowseResultsRenderer != null && (list22 = twoColumnBrowseResultsRenderer.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list22)) != null && (tabRenderer = tab.tabRenderer) != null && (content3 = tabRenderer.content) != null && (sectionListRenderer4 = content3.sectionListRenderer) != null && (list23 = sectionListRenderer4.contents) != null) {
                        arrayList.addAll(list23);
                    }
                    i = 10;
                    if (twoColumnBrowseResultsRenderer != null && (secondaryContents2 = twoColumnBrowseResultsRenderer.secondaryContents) != null && (sectionListRenderer3 = secondaryContents2.sectionListRenderer) != null && (list21 = sectionListRenderer3.contents) != null) {
                        arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list21, 10));
                        for (SectionListRenderer.Content content4 : list21) {
                            arrayList5.add(new SectionListRenderer.Content(content4.musicShelfRenderer, content4.musicPlaylistShelfRenderer));
                        }
                        arrayList.addAll(arrayList5);
                    }
                    ConnectionPool connectionPool = Timber.Forest;
                    arrayList.size();
                    if (twoColumnBrowseResultsRenderer != null && (list20 = twoColumnBrowseResultsRenderer.tabs) != null) {
                        list20.size();
                    }
                    if (twoColumnBrowseResultsRenderer != null && (secondaryContents = twoColumnBrowseResultsRenderer.secondaryContents) != null && (sectionListRenderer2 = secondaryContents.sectionListRenderer) != null && (list19 = sectionListRenderer2.contents) != null) {
                        list19.size();
                    }
                    connectionPool.getClass();
                    ConnectionPool.d(new Object[0]);
                    size = arrayList.size();
                    i2 = 0;
                    i3 = 0;
                    while (i3 < size) {
                        obj = arrayList.get(i3);
                        i7 = i3 + 1;
                        i8 = i2 + 1;
                        if (i2 >= 0) {
                            Throwable th2 = th;
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw th2;
                        }
                        SectionListRenderer.Content content5 = (SectionListRenderer.Content) obj;
                        ConnectionPool connectionPool2 = Timber.Forest;
                        MusicCarouselShelfRenderer musicCarouselShelfRenderer3 = content5.musicCarouselShelfRenderer;
                        musicPlaylistShelfRenderer = content5.musicPlaylistShelfRenderer;
                        musicShelfRenderer2 = content5.musicShelfRenderer;
                        connectionPool2.getClass();
                        ConnectionPool.d(new Object[i14]);
                        musicCarouselShelfRenderer2 = content5.musicCarouselShelfRenderer;
                        if (musicCarouselShelfRenderer2 != null) {
                            header2 = musicCarouselShelfRenderer2.header;
                            if (header2 == null && (musicCarouselShelfBasicHeaderRenderer3 = header2.musicCarouselShelfBasicHeaderRenderer) != null && (runs8 = musicCarouselShelfBasicHeaderRenderer3.title) != null && (list18 = runs8.runs) != null) {
                                CollectionsKt.joinToString$default(list18, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 20), 30);
                            }
                            musicCarouselShelfRenderer2.contents.size();
                            ConnectionPool.d(new Object[i14]);
                        } else {
                            th = th;
                        }
                        if (musicShelfRenderer2 == null) {
                            i9 = size;
                            i10 = i7;
                            i11 = i8;
                        } else {
                            runs5 = musicShelfRenderer2.title;
                            if (runs5 != null && (list17 = runs5.runs) != null) {
                                CollectionsKt.joinToString$default(list17, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 21), 30);
                            }
                            list9 = musicShelfRenderer2.contents;
                            if (list9 != null) {
                                Boxing.boxInt(list9.size());
                            }
                            ConnectionPool.d(new Object[i14]);
                            list10 = musicShelfRenderer2.contents;
                            if (list10 != null || (content2 = (MusicShelfRenderer.Content) CollectionsKt.firstOrNull(list10)) == null || (musicMultiRowListItemRenderer2 = content2.musicMultiRowListItemRenderer) == null) {
                                i9 = size;
                                i10 = i7;
                                i11 = i8;
                            } else {
                                Runs runs9 = musicMultiRowListItemRenderer2.subtitle;
                                if (runs9 != null && (list16 = runs9.runs) != null) {
                                    CollectionsKt.joinToString$default(list16, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 22), 30);
                                }
                                Runs runs10 = musicMultiRowListItemRenderer2.secondSubtitle;
                                if (runs10 != null && (list15 = runs10.runs) != null) {
                                    CollectionsKt.joinToString$default(list15, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 23), 30);
                                }
                                Runs runs11 = musicMultiRowListItemRenderer2.secondarySubtitle;
                                if (runs11 != null && (list14 = runs11.runs) != null) {
                                    CollectionsKt.joinToString$default(list14, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 24), 30);
                                }
                                ConnectionPool.d(new Object[i14]);
                                Runs runs12 = musicMultiRowListItemRenderer2.subtitle;
                                ?? r11 = runs12 != null ? runs12.runs : th;
                                if (r11 != 0) {
                                    arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r11, i));
                                    for (Run run4 : r11) {
                                        String str6 = run4.text;
                                        NavigationEndpoint navigationEndpoint4 = run4.navigationEndpoint;
                                        int i15 = size;
                                        arrayList3.add("text='" + str6 + "' nav=" + ((navigationEndpoint4 == null || (browseEndpoint4 = navigationEndpoint4.browseEndpoint) == null) ? th : browseEndpoint4.browseId));
                                        size = i15;
                                    }
                                } else {
                                    arrayList3 = th;
                                }
                                i9 = size;
                                Objects.toString(arrayList3);
                                ConnectionPool.d(new Object[0]);
                                Runs runs13 = musicMultiRowListItemRenderer2.secondSubtitle;
                                ?? r3 = runs13 != null ? runs13.runs : th;
                                ConnectionPool connectionPool3 = Timber.Forest;
                                if (r3 != 0) {
                                    arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, 10));
                                    Iterator it2 = r3.iterator();
                                    while (it2.hasNext()) {
                                        Run run5 = (Run) it2.next();
                                        String str7 = run5.text;
                                        NavigationEndpoint navigationEndpoint5 = run5.navigationEndpoint;
                                        Iterator it3 = it2;
                                        arrayList4.add("text='" + str7 + "' nav=" + ((navigationEndpoint5 == null || (browseEndpoint3 = navigationEndpoint5.browseEndpoint) == null) ? th : browseEndpoint3.browseId));
                                        it2 = it3;
                                    }
                                } else {
                                    arrayList4 = th;
                                }
                                Objects.toString(arrayList4);
                                connectionPool3.getClass();
                                ConnectionPool.d(new Object[0]);
                                Menu menu = musicMultiRowListItemRenderer2.menu;
                                if (menu == null || (menuRenderer = menu.menuRenderer) == null || (list11 = menuRenderer.items) == null) {
                                    i10 = i7;
                                    i11 = i8;
                                    obj2 = th;
                                } else {
                                    ArrayList arrayList6 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list11, 10));
                                    Iterator it4 = list11.iterator();
                                    int i16 = 0;
                                    while (it4.hasNext()) {
                                        Object next = it4.next();
                                        int i17 = i16 + 1;
                                        if (i16 < 0) {
                                            CollectionsKt__IterablesKt.throwIndexOverflow();
                                            throw th;
                                        }
                                        Menu.MenuRenderer.Item item = (Menu.MenuRenderer.Item) next;
                                        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer = item.menuNavigationItemRenderer;
                                        ?? JoinToString$default = (menuNavigationItemRenderer == null || (runs7 = menuNavigationItemRenderer.text) == null || (list13 = runs7.runs) == null) ? th : CollectionsKt.joinToString$default(list13, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 25), 30);
                                        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2 = item.menuNavigationItemRenderer;
                                        if (menuNavigationItemRenderer2 == null || (navigationEndpoint3 = menuNavigationItemRenderer2.navigationEndpoint) == null || (browseEndpoint2 = navigationEndpoint3.browseEndpoint) == null) {
                                            r14 = th;
                                        } else {
                                            str5 = browseEndpoint2.browseId;
                                        }
                                        if (menuNavigationItemRenderer2 == null || (navigationEndpoint2 = menuNavigationItemRenderer2.navigationEndpoint) == null || (browseEndpoint = navigationEndpoint2.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) {
                                            r14 = str5;
                                            r14 = str5;
                                            r14 = str5;
                                            r14 = str5;
                                            r14 = str5;
                                            r13 = th;
                                        } else {
                                            r14 = str5;
                                            r13 = browseEndpointContextMusicConfig.pageType;
                                        }
                                        Iterator it5 = it4;
                                        Menu.MenuRenderer.Item.MenuServiceItemRenderer menuServiceItemRenderer = item.menuServiceItemRenderer;
                                        ?? JoinToString$default2 = (menuServiceItemRenderer == null || (runs6 = menuServiceItemRenderer.text) == null || (list12 = runs6.runs) == null) ? th : CollectionsKt.joinToString$default(list12, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 26), 30);
                                        Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer = item.toggleMenuServiceItemRenderer;
                                        arrayList6.add("[" + i16 + "](navText='" + JoinToString$default + "' navId=" + r14 + " pageType=" + r13 + " svcText='" + JoinToString$default2 + "' toggleIcon=" + ((toggleMenuServiceRenderer == null || (icon = toggleMenuServiceRenderer.defaultIcon) == null) ? th : icon.iconType) + ")");
                                        i16 = i17;
                                        it4 = it5;
                                        i8 = i8;
                                        i7 = i7;
                                    }
                                    i10 = i7;
                                    i11 = i8;
                                    obj2 = arrayList6;
                                }
                                ConnectionPool connectionPool4 = Timber.Forest;
                                Objects.toString(obj2);
                                connectionPool4.getClass();
                                ConnectionPool.d(new Object[0]);
                            }
                        }
                        if (musicPlaylistShelfRenderer != null) {
                            musicPlaylistShelfRenderer.contents.size();
                            ConnectionPool.d(new Object[0]);
                        }
                        th = th;
                        size = i9;
                        i2 = i11;
                        i3 = i10;
                        i = 10;
                        i14 = 0;
                    }
                    r37 = th;
                    if (contents != null) {
                        r0 = contents.singleColumnBrowseResultsRenderer;
                    } else {
                        r0 = r37;
                    }
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    if (r0 != 0) {
                        list8 = r0.tabs;
                    } else {
                        r1 = r37;
                    }
                    if (r1 != 0) {
                        r1 = list8;
                        i5 = 0;
                        for (Object obj3 : r0.tabs) {
                            i6 = i5 + 1;
                            if (i5 >= 0) {
                                CollectionsKt__IterablesKt.throwIndexOverflow();
                                throw r37;
                            }
                            Tabs.Tab.TabRenderer tabRenderer2 = ((Tabs.Tab) obj3).tabRenderer;
                            String str8 = tabRenderer2.title;
                            content = tabRenderer2.content;
                            if (content != null) {
                                sectionListRenderer = content.sectionListRenderer;
                            } else {
                                r2 = r37;
                            }
                            if (r2 != 0 && (list7 = r2.contents) != null) {
                                r2 = sectionListRenderer;
                                list7.size();
                            }
                            r2 = sectionListRenderer;
                            r2 = sectionListRenderer;
                            Timber.Forest.getClass();
                            ConnectionPool.d(new Object[0]);
                            if (r2 == 0 && (list4 = r2.contents) != null) {
                                int i18 = 0;
                                for (Object obj4 : list4) {
                                    int i19 = i18 + 1;
                                    if (i18 < 0) {
                                        CollectionsKt__IterablesKt.throwIndexOverflow();
                                        throw r37;
                                    }
                                    SectionListRenderer.Content content6 = (SectionListRenderer.Content) obj4;
                                    MusicShelfRenderer musicShelfRenderer3 = content6.musicShelfRenderer;
                                    MusicCarouselShelfRenderer musicCarouselShelfRenderer4 = content6.musicCarouselShelfRenderer;
                                    if (musicShelfRenderer3 != null) {
                                        ConnectionPool connectionPool5 = Timber.Forest;
                                        Runs runs14 = musicShelfRenderer3.title;
                                        if (runs14 != null && (list6 = runs14.runs) != null) {
                                            CollectionsKt.joinToString$default(list6, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 27), 30);
                                        }
                                        List list24 = musicShelfRenderer3.contents;
                                        if (list24 != null) {
                                            Boxing.boxInt(list24.size());
                                        }
                                        connectionPool5.getClass();
                                        ConnectionPool.d(new Object[0]);
                                    }
                                    if (musicCarouselShelfRenderer4 != null) {
                                        MusicCarouselShelfRenderer.Header header3 = musicCarouselShelfRenderer4.header;
                                        if (header3 != null && (musicCarouselShelfBasicHeaderRenderer2 = header3.musicCarouselShelfBasicHeaderRenderer) != null && (runs4 = musicCarouselShelfBasicHeaderRenderer2.title) != null && (list5 = runs4.runs) != null) {
                                            CollectionsKt.joinToString$default(list5, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 28), 30);
                                        }
                                        ConnectionPool connectionPool6 = Timber.Forest;
                                        musicCarouselShelfRenderer4.contents.size();
                                        connectionPool6.getClass();
                                        ConnectionPool.d(new Object[0]);
                                    }
                                    i18 = i19;
                                }
                            }
                            i5 = i6;
                        }
                    }
                    r1 = list8;
                    arrayList2 = new ArrayList();
                    size2 = arrayList.size();
                    i4 = 0;
                    while (i4 < size2) {
                        Object obj5 = arrayList.get(i4);
                        i4++;
                        SectionListRenderer.Content content7 = (SectionListRenderer.Content) obj5;
                        musicShelfRenderer = content7.musicShelfRenderer;
                        if (musicShelfRenderer != null) {
                            newEpisodes_IoAF18A$lambda$0$processShelf(arrayList2, musicShelfRenderer);
                        }
                        musicCarouselShelfRenderer = content7.musicCarouselShelfRenderer;
                        if (musicCarouselShelfRenderer != null) {
                            it = musicCarouselShelfRenderer.contents.iterator();
                            while (it.hasNext()) {
                                musicMultiRowListItemRenderer = ((MusicCarouselShelfRenderer.Content) it.next()).musicMultiRowListItemRenderer;
                                if (musicMultiRowListItemRenderer == null) {
                                    navigationEndpoint = musicMultiRowListItemRenderer.onTap;
                                    if (navigationEndpoint != null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) {
                                        r7 = r37;
                                    } else {
                                        str4 = watchEndpoint.videoId;
                                    }
                                    if (r7 != 0) {
                                        r7 = str4;
                                        runs = musicMultiRowListItemRenderer.title;
                                        if (runs != null && (list = runs.runs) != null && (run = (Run) CollectionsKt.firstOrNull(list)) != null && (str = run.text) != null) {
                                            runs2 = musicMultiRowListItemRenderer.subtitle;
                                            if (runs2 != null || (list3 = runs2.runs) == null) {
                                                r8 = r37;
                                            } else {
                                                arrayListSplitBySeparator = CharsKt.splitBySeparator(list3);
                                            }
                                            if (r8 != 0) {
                                                r8 = arrayListSplitBySeparator;
                                                listIterator = r8.listIterator(r8.size());
                                                while (true) {
                                                    if (listIterator.hasPrevious()) {
                                                        r10 = r37;
                                                        break;
                                                    }
                                                    objPrevious = listIterator.previous();
                                                    run3 = (Run) CollectionsKt.firstOrNull((List) objPrevious);
                                                    if (run3 != null || (str3 = run3.text) == null) {
                                                        M1883parseTime2 = r37;
                                                    } else {
                                                        M1883parseTime2 = StringsKt__IndentKt.m1883parseTime(str3);
                                                    }
                                                    if (M1883parseTime2 != 0) {
                                                        r10 = objPrevious;
                                                        break;
                                                    }
                                                }
                                                list2 = (List) r10;
                                                if (list2 != null || (run2 = (Run) CollectionsKt.firstOrNull(list2)) == null || (str2 = run2.text) == null) {
                                                    r8 = arrayListSplitBySeparator;
                                                    M1883parseTime = r37;
                                                } else {
                                                    M1883parseTime = StringsKt__IndentKt.m1883parseTime(str2);
                                                }
                                            } else {
                                                r8 = arrayListSplitBySeparator;
                                                M1883parseTime = r37;
                                            }
                                            header = musicCarouselShelfRenderer.header;
                                            if (header != null || (musicCarouselShelfBasicHeaderRenderer = header.musicCarouselShelfBasicHeaderRenderer) == null || (runs3 = musicCarouselShelfBasicHeaderRenderer.title) == null) {
                                                r9 = r37;
                                            } else {
                                                r9 = runs3.runs;
                                            }
                                            List listExtractPodcastArtists = PodcastPage.Companion.extractPodcastArtists(musicMultiRowListItemRenderer, r9);
                                            String str9 = musicMultiRowListItemRenderer.onTap.watchEndpoint.videoId;
                                            thumbnailRenderer = musicMultiRowListItemRenderer.thumbnail;
                                            if (thumbnailRenderer != null || (thumbnailUrl = thumbnailRenderer.getThumbnailUrl()) == null) {
                                                thumbnailUrl = "";
                                            }
                                            arrayList2.add(new SongItem(str9, str, listExtractPodcastArtists, null, M1883parseTime, null, null, null, thumbnailUrl, false, null, null, null, null, null, true, null, 98016));
                                        }
                                    } else {
                                        r7 = str4;
                                    }
                                }
                            }
                        }
                    }
                    ConnectionPool connectionPool7 = Timber.Forest;
                    arrayList2.size();
                    connectionPool7.getClass();
                    ConnectionPool.d(new Object[0]);
                    App.C01391 c01391 = new App.C01391((Object) arrayList2, (Continuation) r37, (byte) 11);
                    youTube$newEpisodes$2.label = 3;
                    objBrowse$default = AwaitKt.coroutineScope(c01391, youTube$newEpisodes$2);
                } else {
                    if (i13 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                objCreateFailure = (List) objBrowse$default;
                if (Result.m1866exceptionOrNullimpl(objCreateFailure) != null) {
                    Timber.Forest.getClass();
                    ConnectionPool.e$1(new Object[0]);
                }
                return objCreateFailure;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$newEpisodes$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$newEpisodes$2);
            if (objBrowse$default != coroutineSingletons) {
                if (objBrowse$default != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents != null) {
                    twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer;
                } else {
                    twoColumnBrowseResultsRenderer = null;
                }
                arrayList = new ArrayList();
                if (twoColumnBrowseResultsRenderer != null) {
                    arrayList.addAll(list23);
                }
                i = 10;
                if (twoColumnBrowseResultsRenderer != null) {
                    arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list21, 10));
                    while (r5.hasNext()) {
                        arrayList5.add(new SectionListRenderer.Content(content4.musicShelfRenderer, content4.musicPlaylistShelfRenderer));
                    }
                    arrayList.addAll(arrayList5);
                }
                ConnectionPool connectionPool8 = Timber.Forest;
                arrayList.size();
                if (twoColumnBrowseResultsRenderer != null) {
                    list20.size();
                }
                if (twoColumnBrowseResultsRenderer != null) {
                    list19.size();
                }
                connectionPool8.getClass();
                ConnectionPool.d(new Object[0]);
                size = arrayList.size();
                i2 = 0;
                i3 = 0;
                while (i3 < size) {
                    obj = arrayList.get(i3);
                    i7 = i3 + 1;
                    i8 = i2 + 1;
                    if (i2 >= 0) {
                        Throwable th3 = th;
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw th3;
                    }
                    SectionListRenderer.Content content8 = (SectionListRenderer.Content) obj;
                    ConnectionPool connectionPool9 = Timber.Forest;
                    MusicCarouselShelfRenderer musicCarouselShelfRenderer5 = content8.musicCarouselShelfRenderer;
                    musicPlaylistShelfRenderer = content8.musicPlaylistShelfRenderer;
                    musicShelfRenderer2 = content8.musicShelfRenderer;
                    connectionPool9.getClass();
                    ConnectionPool.d(new Object[i14]);
                    musicCarouselShelfRenderer2 = content8.musicCarouselShelfRenderer;
                    if (musicCarouselShelfRenderer2 != null) {
                        header2 = musicCarouselShelfRenderer2.header;
                        if (header2 == null) {
                        }
                        musicCarouselShelfRenderer2.contents.size();
                        ConnectionPool.d(new Object[i14]);
                    } else {
                        th = th;
                    }
                    if (musicShelfRenderer2 == null) {
                        i9 = size;
                        i10 = i7;
                        i11 = i8;
                    } else {
                        runs5 = musicShelfRenderer2.title;
                        if (runs5 != null) {
                            CollectionsKt.joinToString$default(list17, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 21), 30);
                        }
                        list9 = musicShelfRenderer2.contents;
                        if (list9 != null) {
                            Boxing.boxInt(list9.size());
                        }
                        ConnectionPool.d(new Object[i14]);
                        list10 = musicShelfRenderer2.contents;
                        if (list10 != null) {
                            i9 = size;
                            i10 = i7;
                            i11 = i8;
                        } else {
                            i9 = size;
                            i10 = i7;
                            i11 = i8;
                        }
                    }
                    if (musicPlaylistShelfRenderer != null) {
                        musicPlaylistShelfRenderer.contents.size();
                        ConnectionPool.d(new Object[0]);
                    }
                    th = th;
                    size = i9;
                    i2 = i11;
                    i3 = i10;
                    i = 10;
                    i14 = 0;
                }
                r37 = th;
                if (contents != null) {
                    r0 = contents.singleColumnBrowseResultsRenderer;
                } else {
                    r0 = r37;
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                if (r0 != 0) {
                    list8 = r0.tabs;
                } else {
                    r1 = r37;
                }
                if (r1 != 0) {
                    r1 = list8;
                    i5 = 0;
                    while (r0.hasNext()) {
                        i6 = i5 + 1;
                        if (i5 >= 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw r37;
                        }
                        Tabs.Tab.TabRenderer tabRenderer3 = ((Tabs.Tab) obj3).tabRenderer;
                        String str10 = tabRenderer3.title;
                        content = tabRenderer3.content;
                        if (content != null) {
                            sectionListRenderer = content.sectionListRenderer;
                        } else {
                            r2 = r37;
                        }
                        if (r2 != 0) {
                            r2 = sectionListRenderer;
                            list7.size();
                        }
                        r2 = sectionListRenderer;
                        r2 = sectionListRenderer;
                        Timber.Forest.getClass();
                        ConnectionPool.d(new Object[0]);
                        if (r2 == 0) {
                        }
                        i5 = i6;
                    }
                }
                r1 = list8;
                arrayList2 = new ArrayList();
                size2 = arrayList.size();
                i4 = 0;
                while (i4 < size2) {
                    Object obj6 = arrayList.get(i4);
                    i4++;
                    SectionListRenderer.Content content9 = (SectionListRenderer.Content) obj6;
                    musicShelfRenderer = content9.musicShelfRenderer;
                    if (musicShelfRenderer != null) {
                        newEpisodes_IoAF18A$lambda$0$processShelf(arrayList2, musicShelfRenderer);
                    }
                    musicCarouselShelfRenderer = content9.musicCarouselShelfRenderer;
                    if (musicCarouselShelfRenderer != null) {
                        it = musicCarouselShelfRenderer.contents.iterator();
                        while (it.hasNext()) {
                            musicMultiRowListItemRenderer = ((MusicCarouselShelfRenderer.Content) it.next()).musicMultiRowListItemRenderer;
                            if (musicMultiRowListItemRenderer == null) {
                                navigationEndpoint = musicMultiRowListItemRenderer.onTap;
                                if (navigationEndpoint != null) {
                                    r7 = r37;
                                } else {
                                    r7 = r37;
                                }
                                if (r7 != 0) {
                                    r7 = str4;
                                    runs = musicMultiRowListItemRenderer.title;
                                    if (runs != null) {
                                        runs2 = musicMultiRowListItemRenderer.subtitle;
                                        if (runs2 != null) {
                                            r8 = r37;
                                        } else {
                                            r8 = r37;
                                        }
                                        if (r8 != 0) {
                                            r8 = arrayListSplitBySeparator;
                                            listIterator = r8.listIterator(r8.size());
                                            while (true) {
                                                if (listIterator.hasPrevious()) {
                                                    r10 = r37;
                                                    break;
                                                }
                                                objPrevious = listIterator.previous();
                                                run3 = (Run) CollectionsKt.firstOrNull((List) objPrevious);
                                                if (run3 != null) {
                                                    M1883parseTime2 = r37;
                                                } else {
                                                    M1883parseTime2 = r37;
                                                }
                                                if (M1883parseTime2 != 0) {
                                                    r10 = objPrevious;
                                                    break;
                                                }
                                            }
                                            list2 = (List) r10;
                                            if (list2 != null) {
                                                r8 = arrayListSplitBySeparator;
                                                M1883parseTime = r37;
                                            } else {
                                                r8 = arrayListSplitBySeparator;
                                                M1883parseTime = r37;
                                            }
                                        } else {
                                            r8 = arrayListSplitBySeparator;
                                            M1883parseTime = r37;
                                        }
                                        header = musicCarouselShelfRenderer.header;
                                        if (header != null) {
                                            r9 = r37;
                                        } else {
                                            r9 = r37;
                                        }
                                        List listExtractPodcastArtists2 = PodcastPage.Companion.extractPodcastArtists(musicMultiRowListItemRenderer, r9);
                                        String str11 = musicMultiRowListItemRenderer.onTap.watchEndpoint.videoId;
                                        thumbnailRenderer = musicMultiRowListItemRenderer.thumbnail;
                                        if (thumbnailRenderer != null) {
                                            thumbnailUrl = "";
                                        } else {
                                            thumbnailUrl = "";
                                        }
                                        arrayList2.add(new SongItem(str11, str, listExtractPodcastArtists2, null, M1883parseTime, null, null, null, thumbnailUrl, false, null, null, null, null, null, true, null, 98016));
                                    }
                                } else {
                                    r7 = str4;
                                }
                            }
                        }
                    }
                }
                ConnectionPool connectionPool10 = Timber.Forest;
                arrayList2.size();
                connectionPool10.getClass();
                ConnectionPool.d(new Object[0]);
                App.C01391 c01392 = new App.C01391((Object) arrayList2, (Continuation) r37, (byte) 11);
                youTube$newEpisodes$2.label = 3;
                objBrowse$default = AwaitKt.coroutineScope(c01392, youTube$newEpisodes$2);
            }
            return coroutineSingletons;
        } catch (Throwable th4) {
            objCreateFailure = ResultKt.createFailure(th4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x008f A[PHI: r0
      0x008f: PHI (r0v23 java.lang.String) = (r0v7 java.lang.String), (r0v9 java.lang.String), (r0v27 java.lang.String) binds: [B:51:0x00a6, B:67:0x00ca, B:40:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r13 == r10) goto L29;
     */
    /* JADX INFO: renamed from: newEpisodesPlaylistInfo-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1022newEpisodesPlaylistInfoIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$newEpisodesPlaylistInfo$1 youTube$newEpisodesPlaylistInfo$1;
        TypeReference typeReferenceTypeOf;
        String thumbnailUrl;
        String str;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        BrowseResponse.SecondaryContents secondaryContents;
        SectionListRenderer sectionListRenderer;
        List list;
        SectionListRenderer.Content content;
        MusicShelfRenderer musicShelfRenderer;
        List list2;
        MusicShelfRenderer.Content content2;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer2;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer2;
        Thumbnails thumbnails;
        List list3;
        Thumbnail thumbnail;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer3;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer3;
        String strJoinToString$default;
        BrowseResponse.Header.MusicVisualHeaderRenderer musicVisualHeaderRenderer2;
        Runs runs;
        List list4;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer;
        Runs runs2;
        List list5;
        BrowseResponse.Header.MusicImmersiveHeaderRenderer musicImmersiveHeaderRenderer2;
        ThumbnailRenderer thumbnailRenderer4;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer4;
        if (continuationImpl instanceof YouTube$newEpisodesPlaylistInfo$1) {
            youTube$newEpisodesPlaylistInfo$1 = (YouTube$newEpisodesPlaylistInfo$1) continuationImpl;
            int i = youTube$newEpisodesPlaylistInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$newEpisodesPlaylistInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$newEpisodesPlaylistInfo$1 = new YouTube$newEpisodesPlaylistInfo$1(this, continuationImpl);
            }
        } else {
            youTube$newEpisodesPlaylistInfo$1 = new YouTube$newEpisodesPlaylistInfo$1(this, continuationImpl);
        }
        YouTube$newEpisodesPlaylistInfo$1 youTube$newEpisodesPlaylistInfo$2 = youTube$newEpisodesPlaylistInfo$1;
        Object objBrowse$default = youTube$newEpisodesPlaylistInfo$2.result;
        int i2 = youTube$newEpisodesPlaylistInfo$2.label;
        String thumbnailUrl2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$newEpisodesPlaylistInfo$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "VLRDPN", null, null, true, youTube$newEpisodesPlaylistInfo$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.Header header = browseResponse.header;
                if (header == null || (musicImmersiveHeaderRenderer2 = header.musicImmersiveHeaderRenderer) == null || (thumbnailRenderer4 = musicImmersiveHeaderRenderer2.thumbnail) == null || (musicThumbnailRenderer4 = thumbnailRenderer4.musicThumbnailRenderer) == null || (thumbnailUrl = musicThumbnailRenderer4.getThumbnailUrl()) == null) {
                    thumbnailUrl = (header == null || (musicVisualHeaderRenderer = header.musicVisualHeaderRenderer) == null || (thumbnailRenderer3 = musicVisualHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer3 = thumbnailRenderer3.musicThumbnailRenderer) == null) ? null : musicThumbnailRenderer3.getThumbnailUrl();
                    if (thumbnailUrl != null) {
                        str = thumbnailUrl;
                    } else {
                        thumbnailUrl = (header == null || (musicDetailHeaderRenderer = header.musicDetailHeaderRenderer) == null || (thumbnailRenderer2 = musicDetailHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer2 = thumbnailRenderer2.croppedSquareThumbnailRenderer) == null || (thumbnails = musicThumbnailRenderer2.thumbnail) == null || (list3 = thumbnails.thumbnails) == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull(list3)) == null) ? null : thumbnail.url;
                        if (thumbnailUrl == null) {
                            BrowseResponse.Contents contents = browseResponse.contents;
                            if (contents != null && (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) != null && (secondaryContents = twoColumnBrowseResultsRenderer.secondaryContents) != null && (sectionListRenderer = secondaryContents.sectionListRenderer) != null && (list = sectionListRenderer.contents) != null && (content = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list)) != null && (musicShelfRenderer = content.musicShelfRenderer) != null && (list2 = musicShelfRenderer.contents) != null && (content2 = (MusicShelfRenderer.Content) CollectionsKt.firstOrNull(list2)) != null && (musicMultiRowListItemRenderer = content2.musicMultiRowListItemRenderer) != null && (thumbnailRenderer = musicMultiRowListItemRenderer.thumbnail) != null && (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) != null) {
                                thumbnailUrl2 = musicThumbnailRenderer.getThumbnailUrl();
                            }
                            str = thumbnailUrl2;
                        } else {
                            str = thumbnailUrl;
                        }
                    }
                } else {
                    str = thumbnailUrl;
                }
                if (header == null || (musicImmersiveHeaderRenderer = header.musicImmersiveHeaderRenderer) == null || (runs2 = musicImmersiveHeaderRenderer.title) == null || (list5 = runs2.runs) == null) {
                    strJoinToString$default = (header == null || (musicVisualHeaderRenderer2 = header.musicVisualHeaderRenderer) == null || (runs = musicVisualHeaderRenderer2.title) == null || (list4 = runs.runs) == null) ? "New Episodes" : CollectionsKt.joinToString$default(list4, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 5), 30);
                } else {
                    strJoinToString$default = CollectionsKt.joinToString$default(list5, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) 4), 30);
                }
                return new PlaylistItem("RDPN", strJoinToString$default, (Artist) null, (String) null, str, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$newEpisodesPlaylistInfo$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$newEpisodesPlaylistInfo$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX INFO: renamed from: newReleaseAlbums-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1023newReleaseAlbumsIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$newReleaseAlbums$1 youTube$newReleaseAlbums$1;
        TypeReference typeReferenceTypeOf;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        SectionListRenderer.Content content2;
        GridRenderer gridRenderer;
        List list3;
        if (continuationImpl instanceof YouTube$newReleaseAlbums$1) {
            youTube$newReleaseAlbums$1 = (YouTube$newReleaseAlbums$1) continuationImpl;
            int i = youTube$newReleaseAlbums$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$newReleaseAlbums$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$newReleaseAlbums$1 = new YouTube$newReleaseAlbums$1(this, continuationImpl);
            }
        } else {
            youTube$newReleaseAlbums$1 = new YouTube$newReleaseAlbums$1(this, continuationImpl);
        }
        YouTube$newReleaseAlbums$1 youTube$newReleaseAlbums$2 = youTube$newReleaseAlbums$1;
        Object objBrowse$default = youTube$newReleaseAlbums$2.result;
        int i2 = youTube$newReleaseAlbums$2.label;
        int i3 = 0;
        ArrayList arrayList = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$newReleaseAlbums$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, "FEmusic_new_releases_albums", null, null, false, youTube$newReleaseAlbums$2, 28);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null && (content2 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list2)) != null && (gridRenderer = content2.gridRenderer) != null && (list3 = gridRenderer.items) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        MusicTwoRowItemRenderer musicTwoRowItemRenderer = ((GridRenderer.Item) it.next()).musicTwoRowItemRenderer;
                        if (musicTwoRowItemRenderer != null) {
                            arrayList2.add(musicTwoRowItemRenderer);
                        }
                    }
                    arrayList = new ArrayList();
                    int size = arrayList2.size();
                    while (i3 < size) {
                        Object obj = arrayList2.get(i3);
                        i3++;
                        AlbumItem albumItemFromMusicTwoRowItemRenderer = NewReleaseAlbumPage.fromMusicTwoRowItemRenderer((MusicTwoRowItemRenderer) obj);
                        if (albumItemFromMusicTwoRowItemRenderer != null) {
                            arrayList.add(albumItemFromMusicTwoRowItemRenderer);
                        }
                    }
                }
                return arrayList == null ? EmptyList.INSTANCE : arrayList;
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$newReleaseAlbums$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$newReleaseAlbums$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0171  */
    /* JADX WARN: Code duplicated, block: B:102:0x0174 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:106:0x018b A[Catch: all -> 0x02db, LOOP:1: B:105:0x0189->B:106:0x018b, LOOP_END, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01a4 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01b9 A[Catch: all -> 0x02db, LOOP:2: B:108:0x01a1->B:113:0x01b9, LOOP_END, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:117:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:183:0x0299  */
    /* JADX WARN: Code duplicated, block: B:198:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:201:0x02c5 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:203:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d3 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:215:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x01b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d1 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00d5 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0141  */
    /* JADX WARN: Code duplicated, block: B:95:0x0153 A[Catch: all -> 0x02db, TryCatch #0 {all -> 0x02db, blocks: (B:15:0x003d, B:135:0x0207, B:137:0x0218, B:139:0x021c, B:141:0x0220, B:143:0x0224, B:145:0x022d, B:147:0x0231, B:149:0x0235, B:151:0x023a, B:153:0x0240, B:155:0x0244, B:157:0x0248, B:159:0x024c, B:161:0x0255, B:163:0x0259, B:165:0x025d, B:167:0x0262, B:20:0x0059, B:38:0x00c4, B:40:0x00cd, B:63:0x0100, B:66:0x0106, B:68:0x010a, B:70:0x010e, B:72:0x0112, B:74:0x011a, B:76:0x011e, B:78:0x0122, B:80:0x0126, B:82:0x012a, B:84:0x012e, B:86:0x0132, B:88:0x0136, B:90:0x013e, B:92:0x0142, B:93:0x014d, B:95:0x0153, B:97:0x015d, B:99:0x0163, B:102:0x0174, B:104:0x0179, B:106:0x018b, B:107:0x019b, B:110:0x01a4, B:115:0x01be, B:119:0x01cb, B:121:0x01d5, B:123:0x01d9, B:125:0x01dd, B:127:0x01e1, B:129:0x01e5, B:131:0x01e9, B:168:0x026e, B:170:0x0272, B:172:0x0276, B:174:0x027a, B:176:0x027e, B:178:0x0287, B:180:0x028b, B:182:0x028f, B:185:0x029f, B:187:0x02a3, B:189:0x02a7, B:191:0x02ab, B:193:0x02b4, B:195:0x02b8, B:197:0x02bc, B:199:0x02c1, B:201:0x02c5, B:204:0x02cf, B:113:0x01b9, B:42:0x00d1, B:44:0x00d5, B:46:0x00d9, B:48:0x00dd, B:50:0x00e1, B:52:0x00e9, B:54:0x00ed, B:56:0x00f1, B:58:0x00f5, B:60:0x00f9, B:62:0x00fd, B:205:0x02d3, B:206:0x02da, B:24:0x0066, B:30:0x009b, B:34:0x00ad, B:27:0x0070), top: B:210:0x002b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.metrolist.innertube.YouTube] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.metrolist.innertube.YouTube, com.metrolist.innertube.models.WatchEndpoint, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v20, types: [com.metrolist.innertube.models.PlaylistPanelRenderer] */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.reflect.KType] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.metrolist.innertube.models.BrowseEndpoint] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [com.metrolist.innertube.models.BrowseEndpoint] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [com.metrolist.innertube.models.BrowseEndpoint] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25, types: [com.metrolist.innertube.models.BrowseEndpoint] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX INFO: renamed from: next-0E7RQCE, reason: not valid java name */
    public final Object m1024next0E7RQCE(WatchEndpoint watchEndpoint, String str, ContinuationImpl continuationImpl) {
        YouTube$next$1 youTube$next$1;
        CoroutineSingletons coroutineSingletons;
        Object next;
        YouTube youTube;
        ?? TypeOf;
        Object objBodyNullable;
        ?? r0;
        WatchEndpoint watchEndpoint2;
        NextResponse.Contents contents;
        NextResponse.ContinuationContents continuationContents;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer;
        ?? r5;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        MusicQueueRenderer musicQueueRenderer;
        MusicQueueRenderer.Content content2;
        ?? r6;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer2;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer3;
        ?? r7;
        ArrayList arrayList;
        ArrayList arrayList2;
        int size;
        int i;
        int size2;
        int i2;
        int i3;
        Integer num;
        ?? r8;
        PlaylistPanelRenderer.Content content3;
        ?? r9;
        ?? r10;
        ?? r11;
        List list2;
        ?? continuation;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer2;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer2;
        List list3;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        NavigationEndpoint navigationEndpoint;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer3;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer3;
        List list4;
        Tabs.Tab tab3;
        Tabs.Tab.TabRenderer tabRenderer3;
        NavigationEndpoint navigationEndpoint2;
        AutomixPreviewVideoRenderer automixPreviewVideoRenderer;
        AutomixPreviewVideoRenderer.Content content4;
        AutomixPreviewVideoRenderer.Content.AutomixPlaylistVideoRenderer automixPlaylistVideoRenderer;
        NavigationEndpoint navigationEndpoint3;
        WatchEndpoint watchEndpoint3;
        Object obj;
        NextResponse nextResponse;
        ?? r12;
        ArrayList arrayList3;
        ?? r13;
        WatchEndpoint watchEndpoint4;
        Object obj2;
        PlaylistPanelVideoRenderer playlistPanelVideoRenderer;
        ?? r15;
        SongItem songItemFromPlaylistPanelVideoRenderer;
        Pair pair;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer4;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer4;
        List list5;
        Tabs.Tab tab4;
        Tabs.Tab.TabRenderer tabRenderer4;
        Tabs.Tab.TabRenderer.Content content5;
        MusicQueueRenderer musicQueueRenderer2;
        MusicQueueRenderer.Header header;
        MusicQueueRenderer.Header.MusicQueueHeaderRenderer musicQueueHeaderRenderer;
        Runs runs;
        List list6;
        Run run;
        PlaylistPanelRenderer playlistPanelRenderer;
        ?? r3;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer5;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer5;
        List list7;
        Tabs.Tab tab5;
        Tabs.Tab.TabRenderer tabRenderer5;
        NavigationEndpoint navigationEndpoint4;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer tabbedRenderer6;
        NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer.TabbedRenderer.WatchNextTabbedResultsRenderer watchNextTabbedResultsRenderer6;
        List list8;
        Tabs.Tab tab6;
        Tabs.Tab.TabRenderer tabRenderer6;
        NavigationEndpoint navigationEndpoint5;
        YouTube youTube2 = this;
        WatchEndpoint watchEndpoint5 = watchEndpoint;
        if (continuationImpl instanceof YouTube$next$1) {
            youTube$next$1 = (YouTube$next$1) continuationImpl;
            int i4 = youTube$next$1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                youTube$next$1.label = i4 - Integer.MIN_VALUE;
            } else {
                youTube$next$1 = new YouTube$next$1(youTube2, continuationImpl);
            }
        } else {
            youTube$next$1 = new YouTube$next$1(youTube2, continuationImpl);
        }
        YouTube$next$1 youTube$next$2 = youTube$next$1;
        Object obj3 = youTube$next$2.result;
        int i5 = youTube$next$2.label;
        ?? r14 = 0;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    String str2 = watchEndpoint5.videoId;
                    String str3 = watchEndpoint5.playlistId;
                    String str4 = watchEndpoint5.playlistSetVideoId;
                    Integer num2 = watchEndpoint5.index;
                    String str5 = watchEndpoint5.params;
                    youTube$next$2.L$0 = watchEndpoint5;
                    youTube$next$2.L$2 = youTube2;
                    youTube$next$2.label = 1;
                    coroutineSingletons = coroutineSingletons2;
                    next = innerTube2.next(youTubeClient, str2, str3, str4, num2, str5, str, youTube$next$2);
                    youTube = youTube2;
                    if (next == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i5 == 1) {
                    YouTube youTube3 = youTube$next$2.L$2;
                    watchEndpoint5 = youTube$next$2.L$0;
                    ResultKt.throwOnFailure(obj3);
                    next = obj3;
                    coroutineSingletons = coroutineSingletons2;
                    youTube = youTube3;
                } else {
                    if (i5 == 2) {
                        YouTube youTube4 = youTube$next$2.L$2;
                        watchEndpoint5 = youTube$next$2.L$0;
                        ResultKt.throwOnFailure(obj3);
                        objBodyNullable = obj3;
                        r14 = 0;
                        coroutineSingletons = coroutineSingletons2;
                        r0 = youTube4;
                        watchEndpoint2 = watchEndpoint5;
                        if (objBodyNullable != null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.NextResponse");
                        }
                        NextResponse nextResponse2 = (NextResponse) objBodyNullable;
                        contents = nextResponse2.contents;
                        continuationContents = nextResponse2.continuationContents;
                        if (continuationContents != null || (playlistPanelRenderer = continuationContents.playlistPanelContinuation) == null) {
                            r6 = playlistPanelRenderer;
                            singleColumnMusicWatchNextResultsRenderer = contents.singleColumnMusicWatchNextResultsRenderer;
                            if (singleColumnMusicWatchNextResultsRenderer != null || (tabbedRenderer = singleColumnMusicWatchNextResultsRenderer.tabbedRenderer) == null || (watchNextTabbedResultsRenderer = tabbedRenderer.watchNextTabbedResultsRenderer) == null || (list = watchNextTabbedResultsRenderer.tabs) == null || (tab = (Tabs.Tab) list.get(0)) == null || (tabRenderer = tab.tabRenderer) == null || (content = tabRenderer.content) == null || (musicQueueRenderer = content.musicQueueRenderer) == null || (content2 = musicQueueRenderer.content) == null) {
                                r5 = r14;
                            } else {
                                r5 = content2.playlistPanelRenderer;
                            }
                            r5.getClass();
                            r6 = r5;
                        }
                        r6 = playlistPanelRenderer;
                        singleColumnMusicWatchNextResultsRenderer2 = contents.singleColumnMusicWatchNextResultsRenderer;
                        singleColumnMusicWatchNextResultsRenderer3 = contents.singleColumnMusicWatchNextResultsRenderer;
                        if (singleColumnMusicWatchNextResultsRenderer2 != null || (tabbedRenderer4 = singleColumnMusicWatchNextResultsRenderer2.tabbedRenderer) == null || (watchNextTabbedResultsRenderer4 = tabbedRenderer4.watchNextTabbedResultsRenderer) == null || (list5 = watchNextTabbedResultsRenderer4.tabs) == null || (tab4 = (Tabs.Tab) list5.get(0)) == null || (tabRenderer4 = tab4.tabRenderer) == null || (content5 = tabRenderer4.content) == null || (musicQueueRenderer2 = content5.musicQueueRenderer) == null || (header = musicQueueRenderer2.header) == null || (musicQueueHeaderRenderer = header.musicQueueHeaderRenderer) == null || (runs = musicQueueHeaderRenderer.subtitle) == null || (list6 = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list6)) == null) {
                            r7 = r14;
                        } else {
                            r7 = run.text;
                        }
                        List<PlaylistPanelRenderer.Content> list9 = r6.contents;
                        arrayList = new ArrayList();
                        for (PlaylistPanelRenderer.Content content6 : list9) {
                            playlistPanelVideoRenderer = content6.playlistPanelVideoRenderer;
                            if (playlistPanelVideoRenderer != null || (songItemFromPlaylistPanelVideoRenderer = NextPage.fromPlaylistPanelVideoRenderer(playlistPanelVideoRenderer)) == null) {
                                r15 = r14;
                            } else {
                                pair = new Pair(songItemFromPlaylistPanelVideoRenderer, Boolean.valueOf(content6.playlistPanelVideoRenderer.selected));
                            }
                            if (r15 != 0) {
                                r15 = pair;
                                arrayList.add(r15);
                            } else {
                                r15 = pair;
                            }
                        }
                        arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                        size = arrayList.size();
                        i = 0;
                        while (i < size) {
                            Object obj4 = arrayList.get(i);
                            i++;
                            arrayList2.add((SongItem) ((Pair) obj4).first);
                        }
                        size2 = arrayList.size();
                        i2 = 0;
                        i3 = 0;
                        while (true) {
                            if (i2 < size2) {
                                i3 = -1;
                                break;
                            }
                            obj2 = arrayList.get(i2);
                            i2++;
                            if (((Boolean) ((Pair) obj2).second).booleanValue()) {
                                break;
                            }
                            i3++;
                        }
                        num = new Integer(i3);
                        if (num.intValue() != -1) {
                            r8 = num;
                        } else {
                            r8 = r14;
                        }
                        content3 = (PlaylistPanelRenderer.Content) CollectionsKt.lastOrNull(r6.contents);
                        if (content3 == null && (automixPreviewVideoRenderer = content3.automixPreviewVideoRenderer) != null && (content4 = automixPreviewVideoRenderer.content) != null && (automixPlaylistVideoRenderer = content4.automixPlaylistVideoRenderer) != null && (navigationEndpoint3 = automixPlaylistVideoRenderer.navigationEndpoint) != null && (watchEndpoint3 = navigationEndpoint3.watchPlaylistEndpoint) != null) {
                            youTube$next$2.L$0 = r14;
                            youTube$next$2.L$2 = r14;
                            youTube$next$2.L$4 = r7;
                            youTube$next$2.L$6 = arrayList2;
                            youTube$next$2.L$7 = r8;
                            youTube$next$2.L$8 = watchEndpoint3;
                            youTube$next$2.L$9 = nextResponse2;
                            youTube$next$2.label = 3;
                            Object objM1024next0E7RQCE = r0.m1024next0E7RQCE(watchEndpoint3, r14, youTube$next$2);
                            if (objM1024next0E7RQCE != coroutineSingletons) {
                                obj = objM1024next0E7RQCE;
                                nextResponse = nextResponse2;
                                r12 = r7;
                                arrayList3 = arrayList2;
                                r13 = r8;
                                watchEndpoint4 = watchEndpoint3;
                                r3 = r14;
                            }
                            return coroutineSingletons;
                        }
                        if (singleColumnMusicWatchNextResultsRenderer3 != null || (tabbedRenderer3 = singleColumnMusicWatchNextResultsRenderer3.tabbedRenderer) == null || (watchNextTabbedResultsRenderer3 = tabbedRenderer3.watchNextTabbedResultsRenderer) == null || (list4 = watchNextTabbedResultsRenderer3.tabs) == null || (tab3 = (Tabs.Tab) CollectionsKt.getOrNull(1, list4)) == null || (tabRenderer3 = tab3.tabRenderer) == null || (navigationEndpoint2 = tabRenderer3.endpoint) == null) {
                            r9 = r8;
                            r10 = r14;
                        } else {
                            ?? r17 = r8;
                            r10 = navigationEndpoint2.browseEndpoint;
                            r9 = r17;
                        }
                        if (singleColumnMusicWatchNextResultsRenderer3 != null || (tabbedRenderer2 = singleColumnMusicWatchNextResultsRenderer3.tabbedRenderer) == null || (watchNextTabbedResultsRenderer2 = tabbedRenderer2.watchNextTabbedResultsRenderer) == null || (list3 = watchNextTabbedResultsRenderer2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.getOrNull(2, list3)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (navigationEndpoint = tabRenderer2.endpoint) == null) {
                            r11 = r14;
                        } else {
                            r11 = navigationEndpoint.browseEndpoint;
                        }
                        list2 = r6.continuations;
                        if (list2 != null) {
                            continuation = ContinuationKt.getContinuation(list2);
                        } else {
                            continuation = r14;
                        }
                        return new NextResult(r7, arrayList2, r9, r10, r11, continuation, watchEndpoint2);
                    }
                    if (i5 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    nextResponse = youTube$next$2.L$9;
                    WatchEndpoint watchEndpoint6 = youTube$next$2.L$8;
                    Integer num3 = youTube$next$2.L$7;
                    arrayList3 = youTube$next$2.L$6;
                    String str6 = youTube$next$2.L$4;
                    ResultKt.throwOnFailure(obj3);
                    obj = ((Result) obj3).value;
                    r13 = num3;
                    r3 = 0;
                    r12 = str6;
                    watchEndpoint4 = watchEndpoint6;
                }
                ResultKt.throwOnFailure(obj);
                NextResult nextResult = (NextResult) obj;
                ArrayList arrayListPlus = CollectionsKt.plus((Iterable) nextResult.items, (Collection) arrayList3);
                NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer4 = nextResponse.contents.singleColumnMusicWatchNextResultsRenderer;
                ?? r16 = (singleColumnMusicWatchNextResultsRenderer4 == null || (tabbedRenderer6 = singleColumnMusicWatchNextResultsRenderer4.tabbedRenderer) == null || (watchNextTabbedResultsRenderer6 = tabbedRenderer6.watchNextTabbedResultsRenderer) == null || (list8 = watchNextTabbedResultsRenderer6.tabs) == null || (tab6 = (Tabs.Tab) CollectionsKt.getOrNull(1, list8)) == null || (tabRenderer6 = tab6.tabRenderer) == null || (navigationEndpoint5 = tabRenderer6.endpoint) == null) ? r3 : navigationEndpoint5.browseEndpoint;
                NextResponse.Contents.SingleColumnMusicWatchNextResultsRenderer singleColumnMusicWatchNextResultsRenderer5 = nextResponse.contents.singleColumnMusicWatchNextResultsRenderer;
                ?? r18 = (singleColumnMusicWatchNextResultsRenderer5 == null || (tabbedRenderer5 = singleColumnMusicWatchNextResultsRenderer5.tabbedRenderer) == null || (watchNextTabbedResultsRenderer5 = tabbedRenderer5.watchNextTabbedResultsRenderer) == null || (list7 = watchNextTabbedResultsRenderer5.tabs) == null || (tab5 = (Tabs.Tab) CollectionsKt.getOrNull(2, list7)) == null || (tabRenderer5 = tab5.tabRenderer) == null || (navigationEndpoint4 = tabRenderer5.endpoint) == null) ? r3 : navigationEndpoint4.browseEndpoint;
                String str7 = nextResult.continuation;
                watchEndpoint4.getClass();
                return new NextResult(r12, arrayListPlus, r13, r16, r18, str7, watchEndpoint4);
                TypeOf = Reflection.typeOf(NextResponse.class);
            } catch (Throwable unused) {
                TypeOf = r14;
            }
            HttpClientCall call = ((HttpResponse) next).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NextResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) TypeOf);
            youTube$next$2.L$0 = watchEndpoint5;
            youTube$next$2.L$2 = youTube;
            youTube$next$2.L$4 = r14;
            youTube$next$2.label = 2;
            objBodyNullable = call.bodyNullable(typeInfo, youTube$next$2);
            r0 = youTube;
            if (objBodyNullable != coroutineSingletons) {
                watchEndpoint2 = watchEndpoint5;
                if (objBodyNullable != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.NextResponse");
                }
                NextResponse nextResponse3 = (NextResponse) objBodyNullable;
                contents = nextResponse3.contents;
                continuationContents = nextResponse3.continuationContents;
                if (continuationContents != null) {
                    r6 = playlistPanelRenderer;
                    singleColumnMusicWatchNextResultsRenderer = contents.singleColumnMusicWatchNextResultsRenderer;
                    if (singleColumnMusicWatchNextResultsRenderer != null) {
                        r5 = r14;
                    } else {
                        r5 = r14;
                    }
                    r5.getClass();
                    r6 = r5;
                } else {
                    r6 = playlistPanelRenderer;
                    singleColumnMusicWatchNextResultsRenderer = contents.singleColumnMusicWatchNextResultsRenderer;
                    if (singleColumnMusicWatchNextResultsRenderer != null) {
                        r5 = r14;
                    } else {
                        r5 = r14;
                    }
                    r5.getClass();
                    r6 = r5;
                }
                r6 = playlistPanelRenderer;
                singleColumnMusicWatchNextResultsRenderer2 = contents.singleColumnMusicWatchNextResultsRenderer;
                singleColumnMusicWatchNextResultsRenderer3 = contents.singleColumnMusicWatchNextResultsRenderer;
                if (singleColumnMusicWatchNextResultsRenderer2 != null) {
                    r7 = r14;
                } else {
                    r7 = r14;
                }
                List<PlaylistPanelRenderer.Content> list10 = r6.contents;
                arrayList = new ArrayList();
                while (r7.hasNext()) {
                    playlistPanelVideoRenderer = content6.playlistPanelVideoRenderer;
                    if (playlistPanelVideoRenderer != null) {
                        r15 = r14;
                    } else {
                        r15 = r14;
                    }
                    if (r15 != 0) {
                        r15 = pair;
                        arrayList.add(r15);
                    } else {
                        r15 = pair;
                    }
                }
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
                size = arrayList.size();
                i = 0;
                while (i < size) {
                    Object obj5 = arrayList.get(i);
                    i++;
                    arrayList2.add((SongItem) ((Pair) obj5).first);
                }
                size2 = arrayList.size();
                i2 = 0;
                i3 = 0;
                while (true) {
                    if (i2 < size2) {
                        i3 = -1;
                        break;
                    }
                    obj2 = arrayList.get(i2);
                    i2++;
                    if (((Boolean) ((Pair) obj2).second).booleanValue()) {
                        break;
                        break;
                    }
                    i3++;
                }
                num = new Integer(i3);
                if (num.intValue() != -1) {
                    r8 = num;
                } else {
                    r8 = r14;
                }
                content3 = (PlaylistPanelRenderer.Content) CollectionsKt.lastOrNull(r6.contents);
                if (content3 == null) {
                }
                if (singleColumnMusicWatchNextResultsRenderer3 != null) {
                    r9 = r8;
                    r10 = r14;
                } else {
                    r9 = r8;
                    r10 = r14;
                }
                if (singleColumnMusicWatchNextResultsRenderer3 != null) {
                    r11 = r14;
                } else {
                    r11 = r14;
                }
                list2 = r6.continuations;
                if (list2 != null) {
                    continuation = ContinuationKt.getContinuation(list2);
                } else {
                    continuation = r14;
                }
                return new NextResult(r7, arrayList2, r9, r10, r11, continuation, watchEndpoint2);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0162 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0187  */
    /* JADX WARN: Code duplicated, block: B:116:0x018b  */
    /* JADX WARN: Code duplicated, block: B:117:0x018d A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x01a4 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:134:0x01af  */
    /* JADX WARN: Code duplicated, block: B:137:0x01be  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c0 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:141:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d8 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:148:0x01df  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e3 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:152:0x01e7 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:153:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:156:0x01f0 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0203  */
    /* JADX WARN: Code duplicated, block: B:167:0x0207 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0211 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:184:0x023a  */
    /* JADX WARN: Code duplicated, block: B:186:0x023e A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0242 A[PHI: r5
      0x0242: PHI (r5v7 com.metrolist.innertube.models.Artist) = 
      (r5v6 com.metrolist.innertube.models.Artist)
      (r5v33 com.metrolist.innertube.models.Artist)
      (r5v35 com.metrolist.innertube.models.Artist)
      (r5v37 com.metrolist.innertube.models.Artist)
      (r5v38 com.metrolist.innertube.models.Artist)
     binds: [B:115:0x0189, B:136:0x01bc, B:143:0x01d4, B:185:0x023c, B:186:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:189:0x0246 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:207:0x0273  */
    /* JADX WARN: Code duplicated, block: B:210:0x0279 A[Catch: all -> 0x05d5, TRY_ENTER, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0291 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x0293 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:232:0x02ae A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:234:0x02b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:235:0x02b4 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:238:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:240:0x02bf A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:262:0x0315  */
    /* JADX WARN: Code duplicated, block: B:264:0x0319 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:276:0x0335 A[PHI: r4
      0x0335: PHI (r4v69 java.lang.String) = (r4v33 java.lang.String), (r4v76 java.lang.String) binds: [B:290:0x0357, B:275:0x0333] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:277:0x0338 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:278:0x033a A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:289:0x0355  */
    /* JADX WARN: Code duplicated, block: B:291:0x0359  */
    /* JADX WARN: Code duplicated, block: B:293:0x035d A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:310:0x0388 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:311:0x038a A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:332:0x03bb A[Catch: all -> 0x05d5, TRY_ENTER, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a0 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:362:0x0409  */
    /* JADX WARN: Code duplicated, block: B:363:0x040b A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:376:0x042d A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:378:0x0438 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:381:0x043f  */
    /* JADX WARN: Code duplicated, block: B:388:0x044e A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:396:0x0468 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:405:0x047f  */
    /* JADX WARN: Code duplicated, block: B:407:0x0483 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:411:0x048b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:412:0x048d A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:415:0x0494  */
    /* JADX WARN: Code duplicated, block: B:417:0x0498 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:432:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:434:0x04c3 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:438:0x04cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:439:0x04cd A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:442:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:444:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:446:0x04db A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:448:0x04ea A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:451:0x04fc A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:453:0x0500 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:462:0x0517  */
    /* JADX WARN: Code duplicated, block: B:464:0x051b A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:468:0x0523 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:469:0x0525 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:472:0x052c  */
    /* JADX WARN: Code duplicated, block: B:474:0x0530 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:478:0x0538 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:479:0x053a A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:482:0x0541  */
    /* JADX WARN: Code duplicated, block: B:484:0x0545 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:499:0x056c  */
    /* JADX WARN: Code duplicated, block: B:501:0x0570 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:505:0x0578 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:506:0x057a A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:509:0x0581  */
    /* JADX WARN: Code duplicated, block: B:511:0x0585 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:515:0x058d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:516:0x058f A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:519:0x0596  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:521:0x059a  */
    /* JADX WARN: Code duplicated, block: B:523:0x059d  */
    /* JADX WARN: Code duplicated, block: B:525:0x05a0 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:527:0x05a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:528:0x05a8 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:529:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:531:0x05b1 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:541:0x05cd A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:562:0x04f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:0x04e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:0x0448 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00d9 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e8 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x011a A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0142 A[Catch: all -> 0x05d5, TryCatch #0 {all -> 0x05d5, blocks: (B:14:0x0035, B:34:0x00a0, B:36:0x00a8, B:38:0x00ac, B:40:0x00b0, B:42:0x00b8, B:44:0x00bc, B:46:0x00c0, B:48:0x00c4, B:50:0x00c8, B:53:0x00d3, B:63:0x00e8, B:69:0x00f6, B:71:0x00fa, B:73:0x00fe, B:75:0x0102, B:77:0x0106, B:101:0x0162, B:103:0x0166, B:105:0x016a, B:107:0x0172, B:109:0x017a, B:111:0x017e, B:113:0x0183, B:117:0x018d, B:119:0x0191, B:121:0x0195, B:123:0x0199, B:125:0x019d, B:135:0x01b1, B:138:0x01c0, B:140:0x01c4, B:142:0x01c9, B:145:0x01d8, B:147:0x01dc, B:150:0x01e3, B:152:0x01e7, B:154:0x01ec, B:156:0x01f0, B:158:0x01f4, B:160:0x01f8, B:162:0x01fc, B:164:0x0200, B:167:0x0207, B:189:0x0246, B:191:0x024a, B:193:0x024e, B:195:0x0252, B:197:0x025a, B:199:0x025e, B:201:0x0262, B:203:0x0266, B:205:0x026e, B:210:0x0279, B:212:0x027d, B:214:0x0281, B:216:0x0289, B:232:0x02ae, B:240:0x02bf, B:242:0x02c3, B:243:0x02cb, B:245:0x02d1, B:246:0x02db, B:248:0x02e1, B:250:0x02ed, B:252:0x02f6, B:254:0x02fe, B:259:0x030c, B:261:0x0310, B:264:0x0319, B:266:0x031d, B:268:0x0321, B:270:0x0325, B:272:0x0329, B:274:0x0331, B:293:0x035d, B:295:0x0361, B:297:0x0369, B:299:0x036d, B:301:0x0371, B:303:0x0379, B:305:0x037d, B:307:0x0381, B:332:0x03bb, B:334:0x03bf, B:336:0x03c7, B:338:0x03cb, B:340:0x03cf, B:341:0x03d3, B:343:0x03d9, B:345:0x03e4, B:347:0x03e8, B:349:0x03ed, B:353:0x03f6, B:355:0x03fa, B:357:0x03fe, B:359:0x0402, B:394:0x045b, B:396:0x0468, B:398:0x046c, B:400:0x0470, B:402:0x0474, B:404:0x0478, B:407:0x0483, B:409:0x0487, B:417:0x0498, B:419:0x049c, B:421:0x04a0, B:423:0x04a8, B:425:0x04ac, B:427:0x04b0, B:429:0x04b4, B:431:0x04b8, B:434:0x04c3, B:436:0x04c7, B:446:0x04db, B:448:0x04ea, B:450:0x04f8, B:453:0x0500, B:455:0x0504, B:457:0x0508, B:459:0x050c, B:461:0x0510, B:464:0x051b, B:466:0x051f, B:474:0x0530, B:476:0x0534, B:484:0x0545, B:486:0x0549, B:488:0x054d, B:490:0x0555, B:492:0x0559, B:494:0x055d, B:496:0x0561, B:498:0x0565, B:501:0x0570, B:503:0x0574, B:511:0x0585, B:513:0x0589, B:525:0x05a0, B:531:0x05b1, B:533:0x05b5, B:535:0x05b9, B:537:0x05bd, B:539:0x05c1, B:540:0x05c5, B:528:0x05a8, B:516:0x058f, B:518:0x0593, B:506:0x057a, B:508:0x057e, B:479:0x053a, B:481:0x053e, B:469:0x0525, B:471:0x0529, B:451:0x04fc, B:439:0x04cd, B:441:0x04d1, B:412:0x048d, B:414:0x0491, B:363:0x040b, B:365:0x040f, B:367:0x0413, B:369:0x041b, B:371:0x041f, B:373:0x0423, B:374:0x0427, B:376:0x042d, B:378:0x0438, B:380:0x043c, B:382:0x0441, B:386:0x044a, B:388:0x044e, B:390:0x0452, B:392:0x0456, B:311:0x038a, B:313:0x038e, B:315:0x0392, B:317:0x039a, B:319:0x039e, B:321:0x03a2, B:323:0x03aa, B:325:0x03ae, B:327:0x03b2, B:278:0x033a, B:280:0x033e, B:282:0x0342, B:284:0x0346, B:286:0x034a, B:288:0x0352, B:257:0x0307, B:235:0x02b4, B:237:0x02b8, B:221:0x0293, B:223:0x0297, B:225:0x029b, B:227:0x029f, B:229:0x02a7, B:169:0x0211, B:171:0x0215, B:173:0x0219, B:175:0x021d, B:177:0x0225, B:179:0x022d, B:181:0x0231, B:183:0x0236, B:186:0x023e, B:129:0x01a4, B:131:0x01a8, B:133:0x01ac, B:80:0x011a, B:82:0x011e, B:84:0x0122, B:86:0x0126, B:88:0x012a, B:90:0x012e, B:92:0x0142, B:94:0x0146, B:96:0x014a, B:98:0x014e, B:56:0x00d9, B:58:0x00dd, B:60:0x00e1, B:541:0x05cd, B:542:0x05d4, B:19:0x0045, B:25:0x0076, B:29:0x0089, B:22:0x004f), top: B:546:0x002d }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r3v20, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.util.ArrayList] */
    /* JADX INFO: renamed from: playlist-gIAlu-s, reason: not valid java name */
    public final Object m1025playlistgIAlus(String str, Continuation continuation) {
        YouTube$playlist$1 youTube$playlist$1;
        CoroutineSingletons coroutineSingletons;
        Object objBrowse$default;
        TypeReference typeReferenceTypeOf;
        String str2;
        BrowseResponse.Contents contents;
        BrowseResponse.Header header;
        SectionListRenderer.Content content;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        MusicEditablePlaylistDetailHeaderRenderer.Header header2;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer2;
        boolean z;
        String str3;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        Runs runs;
        List list;
        String strJoinToString$default;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer3;
        MusicEditablePlaylistDetailHeaderRenderer.Header header3;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer2;
        Runs runs2;
        List list2;
        Artist artistOwnerFromDetailSubtitle;
        Artist artist;
        String str4;
        String str5;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer;
        Runs runs3;
        List list3;
        Run run;
        Runs runs4;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer2;
        String str6;
        String str7;
        String str8;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer3;
        BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer;
        BrowseResponse.Header.MusicThumbnailRenderer musicThumbnailRenderer2;
        List list4;
        BrowseResponse.Header.MusicThumbnail musicThumbnail;
        WatchEndpoint watchEndpoint;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer4;
        List list5;
        BrowseResponse.Header.Buttons buttons;
        Menu.MenuRenderer menuRenderer;
        List list6;
        Menu.MenuRenderer.Item item;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint2;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer5;
        List list7;
        BrowseResponse.Header.Buttons buttons2;
        Menu.MenuRenderer menuRenderer2;
        List list8;
        Iterator it;
        Object next;
        Menu.MenuRenderer.Item item2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
        NavigationEndpoint navigationEndpoint2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
        String str9;
        Icon icon;
        SectionListRenderer.Content content2;
        List list9;
        MusicShelfRenderer musicShelfRenderer;
        SectionListRenderer.Content content3;
        List list10;
        MusicShelfRenderer musicShelfRenderer2;
        ?? arrayList;
        SectionListRenderer.Content content4;
        List list11;
        MusicShelfRenderer musicShelfRenderer3;
        List list12;
        MusicShelfRenderer musicShelfRenderer4;
        SectionListRenderer.Content content5;
        List list13;
        MusicShelfRenderer musicShelfRenderer5;
        List list14;
        MusicShelfRenderer musicShelfRenderer6;
        String continuation2;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        BrowseResponse.SecondaryContents secondaryContents;
        SectionListRenderer sectionListRenderer;
        List list15;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer2;
        Tabs tabs;
        List list16;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content6;
        SectionListRenderer sectionListRenderer2;
        List list17;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer3;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer4;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer2;
        BrowseResponse.SecondaryContents secondaryContents2;
        SectionListRenderer sectionListRenderer3;
        List list18;
        ArrayList items;
        int size;
        SongItem songItemFromMusicResponsiveListItemRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer5;
        Tabs tabs2;
        List list19;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content7;
        SectionListRenderer sectionListRenderer4;
        List list20;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer6;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer3;
        BrowseResponse.SecondaryContents secondaryContents3;
        SectionListRenderer sectionListRenderer5;
        List list21;
        List list22;
        MusicResponsiveHeaderRenderer.Button button;
        Menu.MenuRenderer menuRenderer3;
        List list23;
        Object next2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
        NavigationEndpoint navigationEndpoint3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5;
        Icon icon2;
        List list24;
        MusicResponsiveHeaderRenderer.Button button2;
        Menu.MenuRenderer menuRenderer4;
        List list25;
        Menu.MenuRenderer.Item item3;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer6;
        NavigationEndpoint navigationEndpoint4;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer3;
        Thumbnails thumbnails;
        List list26;
        Thumbnail thumbnail;
        List list27;
        Object objPrevious;
        Runs runs5;
        List list28;
        Run run2;
        FacepileWrapper facepileWrapper;
        AvatarStackViewModel avatarStackViewModel;
        List list29;
        AvatarStackViewModel.Avatar avatar;
        AvatarStackViewModel.AvatarViewModel avatarViewModel;
        AvatarStackViewModel.AvatarImage avatarImage;
        List list30;
        AvatarStackViewModel.ImageSource imageSource;
        List list31;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer3;
        Runs runs6;
        List list32;
        AvatarStackViewModel avatarStackViewModel2;
        BrowseResponse.Header.MusicHeaderRenderer musicHeaderRenderer6;
        Runs runs7;
        List list33;
        Run run3;
        BrowseEndpoint browseEndpoint;
        AvatarStackViewModel.AvatarText avatarText;
        String str10;
        AvatarStackViewModel.RendererContext rendererContext;
        String str11;
        AvatarStackViewModel.CommandContext commandContext;
        AvatarStackViewModel.OnTap onTap;
        AvatarStackViewModel.InnerTubeBrowseCommand innerTubeBrowseCommand;
        AvatarStackViewModel.BrowseEndpoint browseEndpoint2;
        FacepileWrapper facepileWrapper2;
        Runs runs8;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer4;
        MusicEditablePlaylistDetailHeaderRenderer.Header header4;
        MusicDetailHeaderRenderer musicDetailHeaderRenderer4;
        Runs runs9;
        Runs runs10;
        List list34;
        Run run4;
        BrowseEndpoint browseEndpoint3;
        DescriptionWrapper descriptionWrapper;
        MusicDescriptionShelfRenderer musicDescriptionShelfRenderer;
        Runs runs11;
        List list35;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer4;
        List list36;
        Tabs.Tab tab3;
        Tabs.Tab.TabRenderer tabRenderer3;
        Tabs.Tab.TabRenderer.Content content8;
        SectionListRenderer sectionListRenderer6;
        List list37;
        YouTube youTube = this;
        String str12 = str;
        if (continuation instanceof YouTube$playlist$1) {
            youTube$playlist$1 = (YouTube$playlist$1) continuation;
            int i = youTube$playlist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$playlist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$playlist$1 = new YouTube$playlist$1(youTube, continuation);
            }
        } else {
            youTube$playlist$1 = new YouTube$playlist$1(youTube, continuation);
        }
        YouTube$playlist$1 youTube$playlist$2 = youTube$playlist$1;
        Object obj = youTube$playlist$2.result;
        int i2 = youTube$playlist$2.label;
        int i3 = 0;
        ?? r13 = 0;
        ?? r14 = 0;
        String continuation3 = null;
        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineSingletons = coroutineSingletons2;
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    youTube$playlist$2.L$0 = str12;
                    youTube$playlist$2.L$1 = youTube;
                    youTube$playlist$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, YouTubeClient.WEB_REMIX, "VL" + str12, null, null, true, youTube$playlist$2, 12);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    youTube = youTube$playlist$2.L$1;
                    str12 = youTube$playlist$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    objBrowse$default = obj;
                    coroutineSingletons = coroutineSingletons2;
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    String str13 = youTube$playlist$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = str13;
                }
                if (obj != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) obj;
                contents = browseResponse.contents;
                header = browseResponse.header;
                if (contents != null || (twoColumnBrowseResultsRenderer4 = contents.twoColumnBrowseResultsRenderer) == null || (list36 = twoColumnBrowseResultsRenderer4.tabs) == null || (tab3 = (Tabs.Tab) CollectionsKt.firstOrNull(list36)) == null || (tabRenderer3 = tab3.tabRenderer) == null || (content8 = tabRenderer3.content) == null || (sectionListRenderer6 = content8.sectionListRenderer) == null || (list37 = sectionListRenderer6.contents) == null) {
                    content = null;
                } else {
                    content = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list37);
                }
                if (content != null || (musicResponsiveHeaderRenderer = content.musicResponsiveHeaderRenderer) == null) {
                    if (content != null || (musicEditablePlaylistDetailHeaderRenderer = content.musicEditablePlaylistDetailHeaderRenderer) == null || (header2 = musicEditablePlaylistDetailHeaderRenderer.header) == null) {
                        musicResponsiveHeaderRenderer = null;
                    } else {
                        musicResponsiveHeaderRenderer = header2.musicResponsiveHeaderRenderer;
                    }
                }
                if (content != null) {
                    musicEditablePlaylistDetailHeaderRenderer2 = content.musicEditablePlaylistDetailHeaderRenderer;
                } else {
                    musicEditablePlaylistDetailHeaderRenderer2 = null;
                }
                if (musicEditablePlaylistDetailHeaderRenderer2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (musicResponsiveHeaderRenderer != null || (descriptionWrapper = musicResponsiveHeaderRenderer.description) == null || (musicDescriptionShelfRenderer = descriptionWrapper.musicDescriptionShelfRenderer) == null || (runs11 = musicDescriptionShelfRenderer.description) == null || (list35 = runs11.runs) == null) {
                    if (content != null || (musicEditablePlaylistDetailHeaderRenderer3 = content.musicEditablePlaylistDetailHeaderRenderer) == null || (header3 = musicEditablePlaylistDetailHeaderRenderer3.header) == null || (musicDetailHeaderRenderer2 = header3.musicDetailHeaderRenderer) == null || (runs2 = musicDetailHeaderRenderer2.description) == null || (list2 = runs2.runs) == null) {
                        if (header != null || (musicDetailHeaderRenderer = header.musicDetailHeaderRenderer) == null || (runs = musicDetailHeaderRenderer.description) == null || (list = runs.runs) == null) {
                            str3 = null;
                        } else {
                            strJoinToString$default = CollectionsKt.joinToString$default(list, "", null, null, new YouTube$$ExternalSyntheticLambda2((byte) (r13 == true ? 1 : 0)), 30);
                        }
                        if (musicResponsiveHeaderRenderer != null || (runs10 = musicResponsiveHeaderRenderer.straplineTextOne) == null || (list34 = runs10.runs) == null || (run4 = (Run) CollectionsKt.firstOrNull(list34)) == null) {
                            artistOwnerFromDetailSubtitle = null;
                        } else {
                            String str14 = run4.text;
                            NavigationEndpoint navigationEndpoint5 = run4.navigationEndpoint;
                            artistOwnerFromDetailSubtitle = new Artist(str14, (navigationEndpoint5 == null || (browseEndpoint3 = navigationEndpoint5.browseEndpoint) == null) ? null : browseEndpoint3.browseId);
                        }
                        if (artistOwnerFromDetailSubtitle != null) {
                            artist = artistOwnerFromDetailSubtitle;
                        } else {
                            if (content != null || (musicEditablePlaylistDetailHeaderRenderer4 = content.musicEditablePlaylistDetailHeaderRenderer) == null || (header4 = musicEditablePlaylistDetailHeaderRenderer4.header) == null || (musicDetailHeaderRenderer4 = header4.musicDetailHeaderRenderer) == null || (runs9 = musicDetailHeaderRenderer4.subtitle) == null || (list31 = runs9.runs) == null) {
                                if (header != null || (musicDetailHeaderRenderer3 = header.musicDetailHeaderRenderer) == null || (runs6 = musicDetailHeaderRenderer3.subtitle) == null) {
                                    list31 = null;
                                } else {
                                    list31 = runs6.runs;
                                }
                            }
                            artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list31));
                            if (artistOwnerFromDetailSubtitle != null) {
                                artist = artistOwnerFromDetailSubtitle;
                            } else {
                                if (musicResponsiveHeaderRenderer != null || (runs8 = musicResponsiveHeaderRenderer.subtitle) == null) {
                                    list32 = null;
                                } else {
                                    list32 = runs8.runs;
                                }
                                artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list32));
                                if (artistOwnerFromDetailSubtitle != null) {
                                    artist = artistOwnerFromDetailSubtitle;
                                } else {
                                    if (musicResponsiveHeaderRenderer != null || (facepileWrapper2 = musicResponsiveHeaderRenderer.facepile) == null) {
                                        avatarStackViewModel2 = null;
                                    } else {
                                        avatarStackViewModel2 = facepileWrapper2.avatarStackViewModel;
                                    }
                                    if (avatarStackViewModel2 != null) {
                                        avatarText = avatarStackViewModel2.text;
                                        if (avatarText != null) {
                                            str10 = avatarText.content;
                                        } else {
                                            str10 = null;
                                        }
                                        rendererContext = avatarStackViewModel2.rendererContext;
                                        if (rendererContext != null || (commandContext = rendererContext.commandContext) == null || (onTap = commandContext.onTap) == null || (innerTubeBrowseCommand = onTap.innertubeCommand) == null || (browseEndpoint2 = innerTubeBrowseCommand.browseEndpoint) == null) {
                                            str11 = null;
                                        } else {
                                            str11 = browseEndpoint2.browseId;
                                        }
                                        if (str10 != null) {
                                            artist = new Artist(str10, str11);
                                        }
                                    }
                                    if (header != null || (musicHeaderRenderer6 = header.musicHeaderRenderer) == null || (runs7 = musicHeaderRenderer6.straplineTextOne) == null || (list33 = runs7.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list33)) == null) {
                                        artistOwnerFromDetailSubtitle = null;
                                    } else {
                                        String str15 = run3.text;
                                        NavigationEndpoint navigationEndpoint6 = run3.navigationEndpoint;
                                        artistOwnerFromDetailSubtitle = new Artist(str15, (navigationEndpoint6 == null || (browseEndpoint = navigationEndpoint6.browseEndpoint) == null) ? null : browseEndpoint.browseId);
                                    }
                                    if (artistOwnerFromDetailSubtitle == null) {
                                        artistOwnerFromDetailSubtitle = PlaylistPage.Companion.ownerFromDetailSubtitle(list31);
                                    }
                                    artist = artistOwnerFromDetailSubtitle;
                                }
                            }
                        }
                        if (musicResponsiveHeaderRenderer != null || (facepileWrapper = musicResponsiveHeaderRenderer.facepile) == null || (avatarStackViewModel = facepileWrapper.avatarStackViewModel) == null || (list29 = avatarStackViewModel.avatars) == null || (avatar = (AvatarStackViewModel.Avatar) CollectionsKt.firstOrNull(list29)) == null || (avatarViewModel = avatar.avatarViewModel) == null || (avatarImage = avatarViewModel.image) == null || (list30 = avatarImage.sources) == null || (imageSource = (AvatarStackViewModel.ImageSource) CollectionsKt.firstOrNull(list30)) == null) {
                            str4 = null;
                        } else {
                            str4 = imageSource.url;
                        }
                        if (musicResponsiveHeaderRenderer == null && (runs5 = musicResponsiveHeaderRenderer.title) != null && (list28 = runs5.runs) != null && (run2 = (Run) CollectionsKt.firstOrNull(list28)) != null && (str = run2.text) != null) {
                            str5 = str;
                        } else if (header != null || (musicHeaderRenderer = header.musicHeaderRenderer) == null || (runs3 = musicHeaderRenderer.title) == null || (list3 = runs3.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list3)) == null) {
                            str5 = "";
                        } else {
                            String str16 = run.text;
                            str5 = str16;
                        }
                        if (musicResponsiveHeaderRenderer != null || (runs4 = musicResponsiveHeaderRenderer.secondSubtitle) == null) {
                            if (header != null || (musicHeaderRenderer2 = header.musicHeaderRenderer) == null) {
                                runs4 = null;
                            } else {
                                runs4 = musicHeaderRenderer2.secondSubtitle;
                            }
                        }
                        if (runs4 != null || (list27 = runs4.runs) == null) {
                            str6 = null;
                        } else {
                            ListIterator listIterator = list27.listIterator(list27.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    objPrevious = null;
                                    break;
                                }
                                objPrevious = listIterator.previous();
                                String str17 = ((Run) objPrevious).text;
                                for (int i4 = 0; i4 < str17.length(); i4++) {
                                    if (Character.isDigit(str17.charAt(i4))) {
                                        if (!StringsKt.contains(str17, "view", true) && !StringsKt.contains(str17, "hour", true) && !StringsKt.contains(str17, "minute", true)) {
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                            Run run5 = (Run) objPrevious;
                            if (run5 != null) {
                                str6 = run5.text;
                            } else {
                                str6 = null;
                            }
                        }
                        if (musicResponsiveHeaderRenderer != null || (thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer3 = thumbnailRenderer.musicThumbnailRenderer) == null || (thumbnails = musicThumbnailRenderer3.thumbnail) == null || (list26 = thumbnails.thumbnails) == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull(list26)) == null || (str7 = thumbnail.url) == null) {
                            if (header != null || (musicHeaderRenderer3 = header.musicHeaderRenderer) == null || (musicThumbnailRenderer = musicHeaderRenderer3.thumbnail) == null || (musicThumbnailRenderer2 = musicThumbnailRenderer.musicThumbnailRenderer) == null || (list4 = musicThumbnailRenderer2.thumbnails) == null || (musicThumbnail = (BrowseResponse.Header.MusicThumbnail) CollectionsKt.lastOrNull(list4)) == null) {
                                str7 = null;
                            } else {
                                str7 = musicThumbnail.url;
                            }
                            if (str7 == null) {
                                str8 = "";
                            } else {
                                str8 = str7;
                            }
                        } else {
                            str8 = str7;
                        }
                        if (musicResponsiveHeaderRenderer == null && (list24 = musicResponsiveHeaderRenderer.buttons) != null && (button2 = (MusicResponsiveHeaderRenderer.Button) CollectionsKt.lastOrNull(list24)) != null && (menuRenderer4 = button2.menuRenderer) != null && (list25 = menuRenderer4.items) != null && (item3 = (Menu.MenuRenderer.Item) CollectionsKt.firstOrNull(list25)) != null && (menuNavigationItemRenderer6 = item3.menuNavigationItemRenderer) != null && (navigationEndpoint4 = menuNavigationItemRenderer6.navigationEndpoint) != null && (watchEndpoint = navigationEndpoint4.watchPlaylistEndpoint) != null) {
                            watchEndpoint = watchEndpoint;
                        } else if (header != null || (musicHeaderRenderer4 = header.musicHeaderRenderer) == null || (list5 = musicHeaderRenderer4.buttons) == null || (buttons = (BrowseResponse.Header.Buttons) CollectionsKt.lastOrNull(list5)) == null || (menuRenderer = buttons.menuRenderer) == null || (list6 = menuRenderer.items) == null || (item = (Menu.MenuRenderer.Item) CollectionsKt.firstOrNull(list6)) == null || (menuNavigationItemRenderer = item.menuNavigationItemRenderer) == null || (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) == null) {
                            watchEndpoint = null;
                        } else {
                            WatchEndpoint watchEndpoint3 = navigationEndpoint.watchPlaylistEndpoint;
                            watchEndpoint = watchEndpoint3;
                        }
                        if (musicResponsiveHeaderRenderer != null || (list22 = musicResponsiveHeaderRenderer.buttons) == null || (button = (MusicResponsiveHeaderRenderer.Button) CollectionsKt.getOrNull(2, list22)) == null || (menuRenderer3 = button.menuRenderer) == null || (list23 = menuRenderer3.items) == null) {
                            if (header != null && (musicHeaderRenderer5 = header.musicHeaderRenderer) != null && (list7 = musicHeaderRenderer5.buttons) != null && (buttons2 = (BrowseResponse.Header.Buttons) CollectionsKt.getOrNull(2, list7)) != null && (menuRenderer2 = buttons2.menuRenderer) != null && (list8 = menuRenderer2.items) != null) {
                                it = list8.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it.next();
                                    menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                                    if (menuNavigationItemRenderer3 != null || (icon = menuNavigationItemRenderer3.icon) == null) {
                                        str9 = null;
                                    } else {
                                        str9 = icon.iconType;
                                    }
                                } while (!Intrinsics.areEqual(str9, "MIX"));
                                item2 = (Menu.MenuRenderer.Item) next;
                                if (item2 == null && (menuNavigationItemRenderer2 = item2.menuNavigationItemRenderer) != null && (navigationEndpoint2 = menuNavigationItemRenderer2.navigationEndpoint) != null) {
                                    WatchEndpoint watchEndpoint4 = navigationEndpoint2.watchPlaylistEndpoint;
                                    watchEndpoint2 = watchEndpoint4;
                                }
                            }
                            watchEndpoint2 = null;
                        } else {
                            Iterator it2 = list23.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                                menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) next2).menuNavigationItemRenderer;
                            } while (!Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon2 = menuNavigationItemRenderer5.icon) == null) ? null : icon2.iconType, "MIX"));
                            Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next2;
                            if (item4 == null || (menuNavigationItemRenderer4 = item4.menuNavigationItemRenderer) == null || (navigationEndpoint3 = menuNavigationItemRenderer4.navigationEndpoint) == null || (watchEndpoint4 = navigationEndpoint3.watchPlaylistEndpoint) == null) {
                                if (header != null) {
                                    it = list8.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                                        if (menuNavigationItemRenderer3 != null) {
                                            str9 = null;
                                        } else {
                                            str9 = null;
                                        }
                                    } while (!Intrinsics.areEqual(str9, "MIX"));
                                    item2 = (Menu.MenuRenderer.Item) next;
                                    if (item2 == null) {
                                    }
                                }
                                watchEndpoint2 = null;
                            } else {
                                watchEndpoint2 = watchEndpoint4;
                            }
                        }
                        PlaylistItem playlistItem = new PlaylistItem(str2, str5, artist, str6, str8, (WatchEndpoint) null, watchEndpoint, watchEndpoint2, z, str3, str4, 512);
                        if (contents != null || (twoColumnBrowseResultsRenderer3 = contents.twoColumnBrowseResultsRenderer) == null || (secondaryContents3 = twoColumnBrowseResultsRenderer3.secondaryContents) == null || (sectionListRenderer5 = secondaryContents3.sectionListRenderer) == null || (list21 = sectionListRenderer5.contents) == null) {
                            content2 = null;
                        } else {
                            content2 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list21);
                        }
                        if (content2 != null || (musicPlaylistShelfRenderer6 = content2.musicPlaylistShelfRenderer) == null || (list9 = musicPlaylistShelfRenderer6.contents) == null) {
                            if (content2 != null || (musicShelfRenderer = content2.musicShelfRenderer) == null) {
                                list9 = null;
                            } else {
                                list9 = musicShelfRenderer.contents;
                            }
                        }
                        if (contents != null || (tabs2 = contents.singleColumnBrowseResultsRenderer) == null || (list19 = tabs2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(list19)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (content7 = tabRenderer2.content) == null || (sectionListRenderer4 = content7.sectionListRenderer) == null || (list20 = sectionListRenderer4.contents) == null) {
                            content3 = null;
                        } else {
                            content3 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list20);
                        }
                        if (content3 != null || (musicPlaylistShelfRenderer5 = content3.musicPlaylistShelfRenderer) == null || (list10 = musicPlaylistShelfRenderer5.contents) == null) {
                            if (content3 != null || (musicShelfRenderer2 = content3.musicShelfRenderer) == null) {
                                list10 = null;
                            } else {
                                list10 = musicShelfRenderer2.contents;
                            }
                        }
                        if (list9 == null) {
                            list9 = list10;
                        }
                        if (list9 != null) {
                            items = MusicShelfRendererKt.getItems(list9);
                            arrayList = new ArrayList();
                            size = items.size();
                            while (i3 < size) {
                                Object obj2 = items.get(i3);
                                i3++;
                                songItemFromMusicResponsiveListItemRenderer = PlaylistPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2);
                                if (songItemFromMusicResponsiveListItemRenderer != null) {
                                    arrayList.add(songItemFromMusicResponsiveListItemRenderer);
                                }
                            }
                        } else {
                            arrayList = EmptyList.INSTANCE;
                        }
                        if (contents != null || (twoColumnBrowseResultsRenderer2 = contents.twoColumnBrowseResultsRenderer) == null || (secondaryContents2 = twoColumnBrowseResultsRenderer2.secondaryContents) == null || (sectionListRenderer3 = secondaryContents2.sectionListRenderer) == null || (list18 = sectionListRenderer3.contents) == null) {
                            content4 = null;
                        } else {
                            content4 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list18);
                        }
                        if (content4 != null || (musicPlaylistShelfRenderer4 = content4.musicPlaylistShelfRenderer) == null || (list11 = musicPlaylistShelfRenderer4.contents) == null) {
                            if (content4 != null || (musicShelfRenderer3 = content4.musicShelfRenderer) == null) {
                                list11 = null;
                            } else {
                                list11 = musicShelfRenderer3.contents;
                            }
                        }
                        if (content4 != null || (musicPlaylistShelfRenderer3 = content4.musicPlaylistShelfRenderer) == null || (list12 = musicPlaylistShelfRenderer3.continuations) == null) {
                            if (content4 != null || (musicShelfRenderer4 = content4.musicShelfRenderer) == null) {
                                list12 = null;
                            } else {
                                list12 = musicShelfRenderer4.continuations;
                            }
                        }
                        if (contents != null || (tabs = contents.singleColumnBrowseResultsRenderer) == null || (list16 = tabs.tabs) == null || (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list16)) == null || (tabRenderer = tab.tabRenderer) == null || (content6 = tabRenderer.content) == null || (sectionListRenderer2 = content6.sectionListRenderer) == null || (list17 = sectionListRenderer2.contents) == null) {
                            content5 = null;
                        } else {
                            content5 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list17);
                        }
                        if (content5 != null || (musicPlaylistShelfRenderer2 = content5.musicPlaylistShelfRenderer) == null || (list13 = musicPlaylistShelfRenderer2.contents) == null) {
                            if (content5 != null || (musicShelfRenderer5 = content5.musicShelfRenderer) == null) {
                                list13 = null;
                            } else {
                                list13 = musicShelfRenderer5.contents;
                            }
                        }
                        if (content5 != null || (musicPlaylistShelfRenderer = content5.musicPlaylistShelfRenderer) == null || (list14 = musicPlaylistShelfRenderer.continuations) == null) {
                            if (content5 != null || (musicShelfRenderer6 = content5.musicShelfRenderer) == null) {
                                list14 = null;
                            } else {
                                list14 = musicShelfRenderer6.continuations;
                            }
                        }
                        if (list11 == null) {
                            list11 = list13;
                        }
                        if (list12 == null) {
                            list12 = list14;
                        }
                        if (list11 != null || (continuation2 = MusicShelfRendererKt.getContinuation(list11)) == null) {
                            if (list12 != null) {
                                continuation2 = ContinuationKt.getContinuation(list12);
                            } else {
                                continuation2 = null;
                            }
                        }
                        if (contents != null && (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) != null && (secondaryContents = twoColumnBrowseResultsRenderer.secondaryContents) != null && (sectionListRenderer = secondaryContents.sectionListRenderer) != null && (list15 = sectionListRenderer.continuations) != null) {
                            continuation3 = ContinuationKt.getContinuation(list15);
                        }
                        return new PlaylistPage(playlistItem, arrayList, continuation2, continuation3);
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(list2, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 29), 30);
                } else {
                    strJoinToString$default = CollectionsKt.joinToString$default(list35, "", null, null, new YouTube$$ExternalSyntheticLambda0(r14 == true ? 1 : 0), 30);
                }
                str3 = strJoinToString$default;
                if (musicResponsiveHeaderRenderer != null) {
                    artistOwnerFromDetailSubtitle = null;
                } else {
                    artistOwnerFromDetailSubtitle = null;
                }
                if (artistOwnerFromDetailSubtitle != null) {
                    artist = artistOwnerFromDetailSubtitle;
                } else {
                    if (content != null) {
                        if (header != null) {
                            list31 = null;
                        } else {
                            list31 = null;
                        }
                    } else if (header != null) {
                        list31 = null;
                    } else {
                        list31 = null;
                    }
                    artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list31));
                    if (artistOwnerFromDetailSubtitle != null) {
                        artist = artistOwnerFromDetailSubtitle;
                    } else {
                        if (musicResponsiveHeaderRenderer != null) {
                            list32 = null;
                        } else {
                            list32 = null;
                        }
                        artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list32));
                        if (artistOwnerFromDetailSubtitle != null) {
                            artist = artistOwnerFromDetailSubtitle;
                        } else {
                            if (musicResponsiveHeaderRenderer != null) {
                                avatarStackViewModel2 = null;
                            } else {
                                avatarStackViewModel2 = null;
                            }
                            if (avatarStackViewModel2 != null) {
                                avatarText = avatarStackViewModel2.text;
                                if (avatarText != null) {
                                    str10 = avatarText.content;
                                } else {
                                    str10 = null;
                                }
                                rendererContext = avatarStackViewModel2.rendererContext;
                                if (rendererContext != null) {
                                    str11 = null;
                                } else {
                                    str11 = null;
                                }
                                if (str10 != null) {
                                    artist = new Artist(str10, str11);
                                }
                            }
                            if (header != null) {
                                artistOwnerFromDetailSubtitle = null;
                            } else {
                                artistOwnerFromDetailSubtitle = null;
                            }
                            if (artistOwnerFromDetailSubtitle == null) {
                                artistOwnerFromDetailSubtitle = PlaylistPage.Companion.ownerFromDetailSubtitle(list31);
                            }
                            artist = artistOwnerFromDetailSubtitle;
                        }
                    }
                }
                if (musicResponsiveHeaderRenderer != null) {
                    str4 = null;
                } else {
                    str4 = null;
                }
                if (musicResponsiveHeaderRenderer == null) {
                    if (header != null) {
                    }
                    str5 = "";
                } else {
                    if (header != null) {
                    }
                    str5 = "";
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        runs4 = null;
                    } else {
                        runs4 = null;
                    }
                } else if (header != null) {
                    runs4 = null;
                } else {
                    runs4 = null;
                }
                if (runs4 != null) {
                    str6 = null;
                } else {
                    str6 = null;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        str7 = null;
                    } else {
                        str7 = null;
                    }
                    if (str7 == null) {
                        str8 = "";
                    } else {
                        str8 = str7;
                    }
                } else {
                    if (header != null) {
                        str7 = null;
                    } else {
                        str7 = null;
                    }
                    if (str7 == null) {
                        str8 = "";
                    } else {
                        str8 = str7;
                    }
                }
                if (musicResponsiveHeaderRenderer == null) {
                    if (header != null) {
                    }
                    watchEndpoint = null;
                } else {
                    if (header != null) {
                    }
                    watchEndpoint = null;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        it = list8.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                            if (menuNavigationItemRenderer3 != null) {
                                str9 = null;
                            } else {
                                str9 = null;
                            }
                        } while (!Intrinsics.areEqual(str9, "MIX"));
                        item2 = (Menu.MenuRenderer.Item) next;
                        if (item2 == null) {
                        }
                    }
                    watchEndpoint2 = null;
                } else {
                    if (header != null) {
                        it = list8.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                            if (menuNavigationItemRenderer3 != null) {
                                str9 = null;
                            } else {
                                str9 = null;
                            }
                        } while (!Intrinsics.areEqual(str9, "MIX"));
                        item2 = (Menu.MenuRenderer.Item) next;
                        if (item2 == null) {
                        }
                    }
                    watchEndpoint2 = null;
                }
                PlaylistItem playlistItem2 = new PlaylistItem(str2, str5, artist, str6, str8, (WatchEndpoint) null, watchEndpoint, watchEndpoint2, z, str3, str4, 512);
                if (contents != null) {
                    content2 = null;
                } else {
                    content2 = null;
                }
                if (content2 != null) {
                    if (content2 != null) {
                        list9 = null;
                    } else {
                        list9 = null;
                    }
                } else if (content2 != null) {
                    list9 = null;
                } else {
                    list9 = null;
                }
                if (contents != null) {
                    content3 = null;
                } else {
                    content3 = null;
                }
                if (content3 != null) {
                    if (content3 != null) {
                        list10 = null;
                    } else {
                        list10 = null;
                    }
                } else if (content3 != null) {
                    list10 = null;
                } else {
                    list10 = null;
                }
                if (list9 == null) {
                    list9 = list10;
                }
                if (list9 != null) {
                    items = MusicShelfRendererKt.getItems(list9);
                    arrayList = new ArrayList();
                    size = items.size();
                    while (i3 < size) {
                        Object obj3 = items.get(i3);
                        i3++;
                        songItemFromMusicResponsiveListItemRenderer = PlaylistPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj3);
                        if (songItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList.add(songItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                } else {
                    arrayList = EmptyList.INSTANCE;
                }
                if (contents != null) {
                    content4 = null;
                } else {
                    content4 = null;
                }
                if (content4 != null) {
                    if (content4 != null) {
                        list11 = null;
                    } else {
                        list11 = null;
                    }
                } else if (content4 != null) {
                    list11 = null;
                } else {
                    list11 = null;
                }
                if (content4 != null) {
                    if (content4 != null) {
                        list12 = null;
                    } else {
                        list12 = null;
                    }
                } else if (content4 != null) {
                    list12 = null;
                } else {
                    list12 = null;
                }
                if (contents != null) {
                    content5 = null;
                } else {
                    content5 = null;
                }
                if (content5 != null) {
                    if (content5 != null) {
                        list13 = null;
                    } else {
                        list13 = null;
                    }
                } else if (content5 != null) {
                    list13 = null;
                } else {
                    list13 = null;
                }
                if (content5 != null) {
                    if (content5 != null) {
                        list14 = null;
                    } else {
                        list14 = null;
                    }
                } else if (content5 != null) {
                    list14 = null;
                } else {
                    list14 = null;
                }
                if (list11 == null) {
                    list11 = list13;
                }
                if (list12 == null) {
                    list12 = list14;
                }
                if (list11 != null) {
                    if (list12 != null) {
                        continuation2 = ContinuationKt.getContinuation(list12);
                    } else {
                        continuation2 = null;
                    }
                } else if (list12 != null) {
                    continuation2 = ContinuationKt.getContinuation(list12);
                } else {
                    continuation2 = null;
                }
                if (contents != null) {
                    continuation3 = ContinuationKt.getContinuation(list15);
                }
                return new PlaylistPage(playlistItem2, arrayList, continuation2, continuation3);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$playlist$2.L$0 = str12;
            youTube$playlist$2.L$1 = youTube;
            youTube$playlist$2.label = 2;
            Object objBodyNullable = call.bodyNullable(typeInfo, youTube$playlist$2);
            if (objBodyNullable != coroutineSingletons) {
                obj = objBodyNullable;
                str2 = str12;
                if (obj != null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse2 = (BrowseResponse) obj;
                contents = browseResponse2.contents;
                header = browseResponse2.header;
                if (contents != null) {
                    content = null;
                } else {
                    content = null;
                }
                if (content != null) {
                    if (content != null) {
                        musicResponsiveHeaderRenderer = null;
                    } else {
                        musicResponsiveHeaderRenderer = null;
                    }
                } else if (content != null) {
                    musicResponsiveHeaderRenderer = null;
                } else {
                    musicResponsiveHeaderRenderer = null;
                }
                if (content != null) {
                    musicEditablePlaylistDetailHeaderRenderer2 = content.musicEditablePlaylistDetailHeaderRenderer;
                } else {
                    musicEditablePlaylistDetailHeaderRenderer2 = null;
                }
                if (musicEditablePlaylistDetailHeaderRenderer2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (content != null) {
                        if (header != null) {
                        }
                        str3 = null;
                    } else {
                        if (header != null) {
                        }
                        str3 = null;
                    }
                } else if (content != null) {
                    if (header != null) {
                    }
                    str3 = null;
                } else {
                    if (header != null) {
                    }
                    str3 = null;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    artistOwnerFromDetailSubtitle = null;
                } else {
                    artistOwnerFromDetailSubtitle = null;
                }
                if (artistOwnerFromDetailSubtitle != null) {
                    artist = artistOwnerFromDetailSubtitle;
                } else {
                    if (content != null) {
                        if (header != null) {
                            list31 = null;
                        } else {
                            list31 = null;
                        }
                    } else if (header != null) {
                        list31 = null;
                    } else {
                        list31 = null;
                    }
                    artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list31));
                    if (artistOwnerFromDetailSubtitle != null) {
                        artist = artistOwnerFromDetailSubtitle;
                    } else {
                        if (musicResponsiveHeaderRenderer != null) {
                            list32 = null;
                        } else {
                            list32 = null;
                        }
                        artistOwnerFromDetailSubtitle = (Artist) CollectionsKt.firstOrNull((List) PageHelper.extractArtists(list32));
                        if (artistOwnerFromDetailSubtitle != null) {
                            artist = artistOwnerFromDetailSubtitle;
                        } else {
                            if (musicResponsiveHeaderRenderer != null) {
                                avatarStackViewModel2 = null;
                            } else {
                                avatarStackViewModel2 = null;
                            }
                            if (avatarStackViewModel2 != null) {
                                avatarText = avatarStackViewModel2.text;
                                if (avatarText != null) {
                                    str10 = avatarText.content;
                                } else {
                                    str10 = null;
                                }
                                rendererContext = avatarStackViewModel2.rendererContext;
                                if (rendererContext != null) {
                                    str11 = null;
                                } else {
                                    str11 = null;
                                }
                                if (str10 != null) {
                                    artist = new Artist(str10, str11);
                                }
                            }
                            if (header != null) {
                                artistOwnerFromDetailSubtitle = null;
                            } else {
                                artistOwnerFromDetailSubtitle = null;
                            }
                            if (artistOwnerFromDetailSubtitle == null) {
                                artistOwnerFromDetailSubtitle = PlaylistPage.Companion.ownerFromDetailSubtitle(list31);
                            }
                            artist = artistOwnerFromDetailSubtitle;
                        }
                    }
                }
                if (musicResponsiveHeaderRenderer != null) {
                    str4 = null;
                } else {
                    str4 = null;
                }
                if (musicResponsiveHeaderRenderer == null) {
                    if (header != null) {
                    }
                    str5 = "";
                } else {
                    if (header != null) {
                    }
                    str5 = "";
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        runs4 = null;
                    } else {
                        runs4 = null;
                    }
                } else if (header != null) {
                    runs4 = null;
                } else {
                    runs4 = null;
                }
                if (runs4 != null) {
                    str6 = null;
                } else {
                    str6 = null;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        str7 = null;
                    } else {
                        str7 = null;
                    }
                    if (str7 == null) {
                        str8 = "";
                    } else {
                        str8 = str7;
                    }
                } else {
                    if (header != null) {
                        str7 = null;
                    } else {
                        str7 = null;
                    }
                    if (str7 == null) {
                        str8 = "";
                    } else {
                        str8 = str7;
                    }
                }
                if (musicResponsiveHeaderRenderer == null) {
                    if (header != null) {
                    }
                    watchEndpoint = null;
                } else {
                    if (header != null) {
                    }
                    watchEndpoint = null;
                }
                if (musicResponsiveHeaderRenderer != null) {
                    if (header != null) {
                        it = list8.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                            if (menuNavigationItemRenderer3 != null) {
                                str9 = null;
                            } else {
                                str9 = null;
                            }
                        } while (!Intrinsics.areEqual(str9, "MIX"));
                        item2 = (Menu.MenuRenderer.Item) next;
                        if (item2 == null) {
                        }
                    }
                    watchEndpoint2 = null;
                } else {
                    if (header != null) {
                        it = list8.iterator();
                        do {
                            if (it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            menuNavigationItemRenderer3 = ((Menu.MenuRenderer.Item) next).menuNavigationItemRenderer;
                            if (menuNavigationItemRenderer3 != null) {
                                str9 = null;
                            } else {
                                str9 = null;
                            }
                        } while (!Intrinsics.areEqual(str9, "MIX"));
                        item2 = (Menu.MenuRenderer.Item) next;
                        if (item2 == null) {
                        }
                    }
                    watchEndpoint2 = null;
                }
                PlaylistItem playlistItem3 = new PlaylistItem(str2, str5, artist, str6, str8, (WatchEndpoint) null, watchEndpoint, watchEndpoint2, z, str3, str4, 512);
                if (contents != null) {
                    content2 = null;
                } else {
                    content2 = null;
                }
                if (content2 != null) {
                    if (content2 != null) {
                        list9 = null;
                    } else {
                        list9 = null;
                    }
                } else if (content2 != null) {
                    list9 = null;
                } else {
                    list9 = null;
                }
                if (contents != null) {
                    content3 = null;
                } else {
                    content3 = null;
                }
                if (content3 != null) {
                    if (content3 != null) {
                        list10 = null;
                    } else {
                        list10 = null;
                    }
                } else if (content3 != null) {
                    list10 = null;
                } else {
                    list10 = null;
                }
                if (list9 == null) {
                    list9 = list10;
                }
                if (list9 != null) {
                    items = MusicShelfRendererKt.getItems(list9);
                    arrayList = new ArrayList();
                    size = items.size();
                    while (i3 < size) {
                        Object obj4 = items.get(i3);
                        i3++;
                        songItemFromMusicResponsiveListItemRenderer = PlaylistPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj4);
                        if (songItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList.add(songItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                } else {
                    arrayList = EmptyList.INSTANCE;
                }
                if (contents != null) {
                    content4 = null;
                } else {
                    content4 = null;
                }
                if (content4 != null) {
                    if (content4 != null) {
                        list11 = null;
                    } else {
                        list11 = null;
                    }
                } else if (content4 != null) {
                    list11 = null;
                } else {
                    list11 = null;
                }
                if (content4 != null) {
                    if (content4 != null) {
                        list12 = null;
                    } else {
                        list12 = null;
                    }
                } else if (content4 != null) {
                    list12 = null;
                } else {
                    list12 = null;
                }
                if (contents != null) {
                    content5 = null;
                } else {
                    content5 = null;
                }
                if (content5 != null) {
                    if (content5 != null) {
                        list13 = null;
                    } else {
                        list13 = null;
                    }
                } else if (content5 != null) {
                    list13 = null;
                } else {
                    list13 = null;
                }
                if (content5 != null) {
                    if (content5 != null) {
                        list14 = null;
                    } else {
                        list14 = null;
                    }
                } else if (content5 != null) {
                    list14 = null;
                } else {
                    list14 = null;
                }
                if (list11 == null) {
                    list11 = list13;
                }
                if (list12 == null) {
                    list12 = list14;
                }
                if (list11 != null) {
                    if (list12 != null) {
                        continuation2 = ContinuationKt.getContinuation(list12);
                    } else {
                        continuation2 = null;
                    }
                } else if (list12 != null) {
                    continuation2 = ContinuationKt.getContinuation(list12);
                } else {
                    continuation2 = null;
                }
                if (contents != null) {
                    continuation3 = ContinuationKt.getContinuation(list15);
                }
                return new PlaylistPage(playlistItem3, arrayList, continuation2, continuation3);
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            return ResultKt.createFailure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r12 == r11) goto L29;
     */
    /* JADX INFO: renamed from: playlistContinuation-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1026playlistContinuationgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$playlistContinuation$1 youTube$playlistContinuation$1;
        TypeReference typeReferenceTypeOf;
        Collection collectionFlatten;
        List list;
        List list2;
        String continuation;
        MusicShelfRenderer musicShelfRenderer;
        List list3;
        BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation;
        List list4;
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation;
        List list5;
        MusicShelfRenderer musicShelfRenderer2;
        BrowseResponse.ContinuationContents.MusicPlaylistShelfContinuation musicPlaylistShelfContinuation2;
        BrowseResponse.ContinuationContents.SectionListContinuation sectionListContinuation2;
        List<SectionListRenderer.Content> list6;
        List list7;
        if (continuationImpl instanceof YouTube$playlistContinuation$1) {
            youTube$playlistContinuation$1 = (YouTube$playlistContinuation$1) continuationImpl;
            int i = youTube$playlistContinuation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$playlistContinuation$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$playlistContinuation$1 = new YouTube$playlistContinuation$1(this, continuationImpl);
            }
        } else {
            youTube$playlistContinuation$1 = new YouTube$playlistContinuation$1(this, continuationImpl);
        }
        YouTube$playlistContinuation$1 youTube$playlistContinuation$2 = youTube$playlistContinuation$1;
        Object objBrowse$default = youTube$playlistContinuation$2.result;
        int i2 = youTube$playlistContinuation$2.label;
        int i3 = 0;
        String continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$playlistContinuation$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, null, null, str, true, youTube$playlistContinuation$2, 6);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse browseResponse = (BrowseResponse) objBrowse$default;
                BrowseResponse.ContinuationContents continuationContents = browseResponse.continuationContents;
                EmptyList emptyList = EmptyList.INSTANCE;
                if (continuationContents == null || (sectionListContinuation2 = continuationContents.sectionListContinuation) == null || (list6 = sectionListContinuation2.contents) == null) {
                    collectionFlatten = emptyList;
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (SectionListRenderer.Content content : list6) {
                        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = content.musicPlaylistShelfRenderer;
                        if (musicPlaylistShelfRenderer == null || (list7 = musicPlaylistShelfRenderer.contents) == null) {
                            MusicShelfRenderer musicShelfRenderer3 = content.musicShelfRenderer;
                            list7 = musicShelfRenderer3 != null ? musicShelfRenderer3.contents : null;
                        }
                        if (list7 != null) {
                            arrayList.add(list7);
                        }
                    }
                    collectionFlatten = CollectionsKt__IterablesKt.flatten(arrayList);
                }
                if (continuationContents == null || (musicPlaylistShelfContinuation2 = continuationContents.musicPlaylistShelfContinuation) == null || (list = musicPlaylistShelfContinuation2.contents) == null) {
                    list = emptyList;
                }
                if (continuationContents == null || (musicShelfRenderer2 = continuationContents.musicShelfContinuation) == null || (list2 = musicShelfRenderer2.contents) == null) {
                    list2 = emptyList;
                }
                List list8 = browseResponse.onResponseReceivedActions;
                if (list8 == null) {
                    list8 = emptyList;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list8.iterator();
                while (it.hasNext()) {
                    BrowseResponse.ResponseAction.ContinuationItems continuationItems = ((BrowseResponse.ResponseAction) it.next()).appendContinuationItemsAction;
                    List list9 = continuationItems != null ? continuationItems.continuationItems : null;
                    if (list9 == null) {
                        list9 = emptyList;
                    }
                    CollectionsKt__MutableCollectionsKt.addAll(list9, arrayList2);
                }
                ArrayList arrayListPlus = CollectionsKt.plus((Iterable) arrayList2, (Collection) CollectionsKt.plus((Iterable) list2, (Collection) CollectionsKt.plus((Iterable) list, collectionFlatten)));
                ArrayList arrayList3 = new ArrayList();
                int size = arrayListPlus.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayListPlus.get(i4);
                    i4++;
                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicShelfRenderer.Content) obj).musicResponsiveListItemRenderer;
                    if (musicResponsiveListItemRenderer != null) {
                        arrayList3.add(musicResponsiveListItemRenderer);
                    }
                }
                ArrayList arrayList4 = new ArrayList();
                int size2 = arrayList3.size();
                while (i3 < size2) {
                    Object obj2 = arrayList3.get(i3);
                    i3++;
                    SongItem songItemFromMusicResponsiveListItemRenderer = PlaylistPage.Companion.fromMusicResponsiveListItemRenderer((MusicResponsiveListItemRenderer) obj2);
                    if (songItemFromMusicResponsiveListItemRenderer != null) {
                        arrayList4.add(songItemFromMusicResponsiveListItemRenderer);
                    }
                }
                if (continuationContents == null || (sectionListContinuation = continuationContents.sectionListContinuation) == null || (list5 = sectionListContinuation.continuations) == null || (continuation = ContinuationKt.getContinuation(list5)) == null) {
                    continuation = (continuationContents == null || (musicPlaylistShelfContinuation = continuationContents.musicPlaylistShelfContinuation) == null || (list4 = musicPlaylistShelfContinuation.continuations) == null) ? null : ContinuationKt.getContinuation(list4);
                    if (continuation == null) {
                        if (continuationContents != null && (musicShelfRenderer = continuationContents.musicShelfContinuation) != null && (list3 = musicShelfRenderer.continuations) != null) {
                            continuation2 = ContinuationKt.getContinuation(list3);
                        }
                        continuation = continuation2 == null ? MusicShelfRendererKt.getContinuation(arrayList2) : continuation2;
                    }
                }
                return new PlaylistContinuationPage(continuation, arrayList4);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$playlistContinuation$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$playlistContinuation$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: podcast-gIAlu-s, reason: not valid java name */
    public final Object m1027podcastgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$podcast$1 youTube$podcast$1;
        if (continuationImpl instanceof YouTube$podcast$1) {
            youTube$podcast$1 = (YouTube$podcast$1) continuationImpl;
            int i = youTube$podcast$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$podcast$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$podcast$1 = new YouTube$podcast$1(this, continuationImpl);
            }
        } else {
            youTube$podcast$1 = new YouTube$podcast$1(this, continuationImpl);
        }
        Object obj = youTube$podcast$1.result;
        int i2 = youTube$podcast$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return ((Result) obj).value;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        youTube$podcast$1.label = 1;
        Object objM1028podcastWithDebug0E7RQCE = m1028podcastWithDebug0E7RQCE(str, youTube$podcast$1);
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objM1028podcastWithDebug0E7RQCE == obj2 ? obj2 : objM1028podcastWithDebug0E7RQCE;
    }

    /* JADX WARN: Code duplicated, block: B:164:0x021e  */
    /* JADX WARN: Code duplicated, block: B:319:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:373:0x0464  */
    /* JADX WARN: Code duplicated, block: B:472:0x0584  */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r0 == r14) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Iterable, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r5v29, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r6v55, types: [java.util.List] */
    /* JADX INFO: renamed from: podcastWithDebug-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1028podcastWithDebug0E7RQCE(String str, ContinuationImpl continuationImpl) {
        YouTube$podcastWithDebug$1 youTube$podcastWithDebug$1;
        String str2;
        TypeReference typeReferenceTypeOf;
        Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer;
        PageHelper.LibraryFeedbackTokens libraryFeedbackTokens;
        String str3;
        Artist artist;
        WatchEndpoint watchEndpoint;
        WatchEndpoint watchEndpoint2;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        Object next;
        MusicShelfRenderer musicShelfRenderer;
        List list3;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer;
        BrowseResponse.SecondaryContents secondaryContents;
        SectionListRenderer sectionListRenderer2;
        List list4;
        SectionListRenderer.Content content2;
        MusicShelfRenderer musicShelfRenderer2;
        List list5;
        String continuation;
        ArrayList arrayList;
        List list6;
        List list7;
        Tabs tabs2;
        List list8;
        Tabs.Tab tab2;
        Tabs.Tab.TabRenderer tabRenderer2;
        Tabs.Tab.TabRenderer.Content content3;
        SectionListRenderer sectionListRenderer3;
        List list9;
        Object next2;
        MusicShelfRenderer musicShelfRenderer3;
        SectionListRenderer sectionListRenderer4;
        List list10;
        SectionListRenderer.Content content4;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        SectionListRenderer sectionListRenderer5;
        List list11;
        SectionListRenderer.Content content5;
        MusicShelfRenderer musicShelfRenderer4;
        SectionListRenderer sectionListRenderer6;
        List list12;
        SectionListRenderer sectionListRenderer7;
        List list13;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer2;
        List list14;
        Object next3;
        Menu.MenuRenderer menuRenderer;
        List list15;
        Object next4;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer;
        NavigationEndpoint navigationEndpoint;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer2;
        Icon icon;
        List list16;
        Icon icon2;
        List list17;
        Object next5;
        Menu.MenuRenderer menuRenderer2;
        List list18;
        Menu.MenuRenderer.Item item;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer3;
        NavigationEndpoint navigationEndpoint2;
        Menu.MenuRenderer menuRenderer3;
        List list19;
        Menu.MenuRenderer.Item item2;
        Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer4;
        Icon icon3;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        Thumbnails thumbnails;
        List list20;
        Thumbnail thumbnail;
        Runs runs;
        List list21;
        Run run;
        Runs runs2;
        List list22;
        Run run2;
        BrowseEndpoint browseEndpoint;
        Runs runs3;
        List list23;
        Run run3;
        List list24;
        FeedbackEndpoint feedbackEndpoint;
        FeedbackEndpoint feedbackEndpoint2;
        List list25;
        ?? r5;
        DefaultServiceEndpoint defaultServiceEndpoint;
        DefaultServiceEndpoint.SubscribeEndpoint subscribeEndpoint;
        List list26;
        List list27;
        Object obj;
        Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer2;
        Icon icon4;
        ?? r6;
        List list28;
        DefaultServiceEndpoint.SubscribeEndpoint subscribeEndpoint2;
        FeedbackEndpoint feedbackEndpoint3;
        String str4;
        List list29;
        Icon icon5;
        Runs runs4;
        List list30;
        Tabs tabs3;
        List list31;
        Tabs.Tab tab3;
        Tabs.Tab.TabRenderer tabRenderer3;
        Tabs.Tab.TabRenderer.Content content6;
        SectionListRenderer sectionListRenderer8;
        List list32;
        SectionListRenderer.Content content7;
        BrowseResponse.TwoColumnBrowseResultsRenderer twoColumnBrowseResultsRenderer3;
        List list33;
        Tabs.Tab tab4;
        Tabs.Tab.TabRenderer tabRenderer4;
        Tabs.Tab.TabRenderer.Content content8;
        SectionListRenderer sectionListRenderer9;
        List list34;
        SectionListRenderer.Content content9;
        if (continuationImpl instanceof YouTube$podcastWithDebug$1) {
            youTube$podcastWithDebug$1 = (YouTube$podcastWithDebug$1) continuationImpl;
            int i = youTube$podcastWithDebug$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$podcastWithDebug$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$podcastWithDebug$1 = new YouTube$podcastWithDebug$1(this, continuationImpl);
            }
        } else {
            youTube$podcastWithDebug$1 = new YouTube$podcastWithDebug$1(this, continuationImpl);
        }
        YouTube$podcastWithDebug$1 youTube$podcastWithDebug$2 = youTube$podcastWithDebug$1;
        Object objBrowse$default = youTube$podcastWithDebug$2.result;
        int i2 = youTube$podcastWithDebug$2.label;
        boolean z = true;
        String continuation2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$podcastWithDebug$2.L$0 = str;
                    youTube$podcastWithDebug$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, null, null, true, youTube$podcastWithDebug$2, 12);
                    if (objBrowse$default != coroutineSingletons) {
                        str2 = str;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    str2 = youTube$podcastWithDebug$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    str2 = youTube$podcastWithDebug$2.L$0;
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                String str5 = str2;
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                ConnectionPool.d(new Object[0]);
                MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer = (contents == null || (twoColumnBrowseResultsRenderer3 = contents.twoColumnBrowseResultsRenderer) == null || (list33 = twoColumnBrowseResultsRenderer3.tabs) == null || (tab4 = (Tabs.Tab) CollectionsKt.firstOrNull(list33)) == null || (tabRenderer4 = tab4.tabRenderer) == null || (content8 = tabRenderer4.content) == null || (sectionListRenderer9 = content8.sectionListRenderer) == null || (list34 = sectionListRenderer9.contents) == null || (content9 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list34)) == null) ? null : content9.musicResponsiveHeaderRenderer;
                if (musicResponsiveHeaderRenderer == null) {
                    musicResponsiveHeaderRenderer = (contents == null || (tabs3 = contents.singleColumnBrowseResultsRenderer) == null || (list31 = tabs3.tabs) == null || (tab3 = (Tabs.Tab) CollectionsKt.firstOrNull(list31)) == null || (tabRenderer3 = tab3.tabRenderer) == null || (content6 = tabRenderer3.content) == null || (sectionListRenderer8 = content6.sectionListRenderer) == null || (list32 = sectionListRenderer8.contents) == null || (content7 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list32)) == null) ? null : content7.musicResponsiveHeaderRenderer;
                    ConnectionPool.d(new Object[0]);
                }
                if (musicResponsiveHeaderRenderer != null && (runs4 = musicResponsiveHeaderRenderer.title) != null && (list30 = runs4.runs) != null) {
                }
                ConnectionPool.d(new Object[0]);
                if (musicResponsiveHeaderRenderer != null && (list28 = musicResponsiveHeaderRenderer.buttons) != null) {
                    int i3 = 0;
                    for (Object obj2 : list28) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        MusicResponsiveHeaderRenderer.Button button = (MusicResponsiveHeaderRenderer.Button) obj2;
                        ConnectionPool connectionPool = Timber.Forest;
                        Menu.MenuRenderer menuRenderer4 = button.menuRenderer;
                        MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer = button.toggleButtonRenderer;
                        connectionPool.getClass();
                        ConnectionPool.d(new Object[0]);
                        Menu.MenuRenderer menuRenderer5 = button.menuRenderer;
                        if (menuRenderer5 != null && (list29 = menuRenderer5.items) != null) {
                            int i5 = 0;
                            for (Object obj3 : list29) {
                                int i6 = i5 + 1;
                                if (i5 < 0) {
                                    CollectionsKt__IterablesKt.throwIndexOverflow();
                                    throw null;
                                }
                                ConnectionPool connectionPool2 = Timber.Forest;
                                Menu.MenuRenderer.Item.ToggleMenuServiceRenderer toggleMenuServiceRenderer3 = ((Menu.MenuRenderer.Item) obj3).toggleMenuServiceItemRenderer;
                                connectionPool2.getClass();
                                ConnectionPool.d(new Object[0]);
                                if (Intrinsics.areEqual((toggleMenuServiceRenderer3 == null || (icon5 = toggleMenuServiceRenderer3.defaultIcon) == null) ? null : icon5.iconType, "SUBSCRIBE")) {
                                    DefaultServiceEndpoint.SubscribeEndpoint subscribeEndpoint3 = toggleMenuServiceRenderer3.defaultServiceEndpoint.subscribeEndpoint;
                                    Objects.toString(subscribeEndpoint3 != null ? subscribeEndpoint3.channelIds : null);
                                    ConnectionPool.d(new Object[0]);
                                }
                                i5 = i6;
                            }
                        }
                        if (toggleButtonRenderer != null) {
                            ConnectionPool connectionPool3 = Timber.Forest;
                            DefaultServiceEndpoint defaultServiceEndpoint2 = toggleButtonRenderer.defaultServiceEndpoint;
                            if (defaultServiceEndpoint2 != null && (feedbackEndpoint3 = defaultServiceEndpoint2.feedbackEndpoint) != null && (str4 = feedbackEndpoint3.feedbackToken) != null) {
                                StringsKt.take(30, str4);
                            }
                            DefaultServiceEndpoint defaultServiceEndpoint3 = toggleButtonRenderer.defaultServiceEndpoint;
                            Objects.toString((defaultServiceEndpoint3 == null || (subscribeEndpoint2 = defaultServiceEndpoint3.subscribeEndpoint) == null) ? null : subscribeEndpoint2.channelIds);
                            connectionPool3.getClass();
                            ConnectionPool.d(new Object[0]);
                        }
                        i3 = i4;
                    }
                }
                ?? arrayList2 = EmptyList.INSTANCE;
                if (musicResponsiveHeaderRenderer == null || (list27 = musicResponsiveHeaderRenderer.buttons) == null) {
                    toggleMenuServiceRenderer = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = list27.iterator();
                    while (it.hasNext()) {
                        Menu.MenuRenderer menuRenderer6 = ((MusicResponsiveHeaderRenderer.Button) it.next()).menuRenderer;
                        if (menuRenderer6 == null || (r6 = menuRenderer6.items) == 0) {
                            r6 = arrayList2;
                        }
                        CollectionsKt__MutableCollectionsKt.addAll(r6, arrayList3);
                    }
                    int size = arrayList3.size();
                    int i7 = 0;
                    do {
                        if (i7 >= size) {
                            obj = null;
                            break;
                        }
                        obj = arrayList3.get(i7);
                        i7++;
                        toggleMenuServiceRenderer2 = ((Menu.MenuRenderer.Item) obj).toggleMenuServiceItemRenderer;
                    } while (!Intrinsics.areEqual((toggleMenuServiceRenderer2 == null || (icon4 = toggleMenuServiceRenderer2.defaultIcon) == null) ? null : icon4.iconType, "SUBSCRIBE"));
                    Menu.MenuRenderer.Item item3 = (Menu.MenuRenderer.Item) obj;
                    if (item3 != null) {
                        toggleMenuServiceRenderer = item3.toggleMenuServiceItemRenderer;
                    } else {
                        toggleMenuServiceRenderer = null;
                    }
                }
                String str6 = (toggleMenuServiceRenderer == null || (defaultServiceEndpoint = toggleMenuServiceRenderer.defaultServiceEndpoint) == null || (subscribeEndpoint = defaultServiceEndpoint.subscribeEndpoint) == null || (list26 = subscribeEndpoint.channelIds) == null) ? null : (String) CollectionsKt.firstOrNull(list26);
                if (toggleMenuServiceRenderer == null || !toggleMenuServiceRenderer.isSelected) {
                    z = false;
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                if (musicResponsiveHeaderRenderer == null || (list25 = musicResponsiveHeaderRenderer.buttons) == null) {
                    libraryFeedbackTokens = null;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it2 = list25.iterator();
                    while (it2.hasNext()) {
                        Menu.MenuRenderer menuRenderer7 = ((MusicResponsiveHeaderRenderer.Button) it2.next()).menuRenderer;
                        if (menuRenderer7 == null || (r5 = menuRenderer7.items) == 0) {
                            r5 = arrayList2;
                        }
                        CollectionsKt__MutableCollectionsKt.addAll(r5, arrayList4);
                    }
                    libraryFeedbackTokens = PageHelper.extractLibraryTokensFromMenuItems(arrayList4);
                }
                if ((libraryFeedbackTokens != null ? libraryFeedbackTokens.addToken : null) == null) {
                    if ((libraryFeedbackTokens != null ? libraryFeedbackTokens.removeToken : null) == null && musicResponsiveHeaderRenderer != null && (list24 = musicResponsiveHeaderRenderer.buttons) != null) {
                        Iterator it3 = list24.iterator();
                        while (it3.hasNext()) {
                            MusicResponsiveHeaderRenderer.Button.ToggleButtonRenderer toggleButtonRenderer2 = ((MusicResponsiveHeaderRenderer.Button) it3.next()).toggleButtonRenderer;
                            if (toggleButtonRenderer2 != null) {
                                Icon icon6 = toggleButtonRenderer2.defaultIcon;
                                String str7 = icon6 != null ? icon6.iconType : null;
                                if (str7 != null && PageHelper.isLibraryIcon(str7)) {
                                    DefaultServiceEndpoint defaultServiceEndpoint4 = toggleButtonRenderer2.defaultServiceEndpoint;
                                    String str8 = (defaultServiceEndpoint4 == null || (feedbackEndpoint2 = defaultServiceEndpoint4.feedbackEndpoint) == null) ? null : feedbackEndpoint2.feedbackToken;
                                    ToggledServiceEndpoint toggledServiceEndpoint = toggleButtonRenderer2.toggledServiceEndpoint;
                                    String str9 = (toggledServiceEndpoint == null || (feedbackEndpoint = toggledServiceEndpoint.feedbackEndpoint) == null) ? null : feedbackEndpoint.feedbackToken;
                                    libraryFeedbackTokens = CollectionsKt.contains(PageHelper.LIBRARY_ADD_ICONS, str7) ? new PageHelper.LibraryFeedbackTokens(str8, str9) : new PageHelper.LibraryFeedbackTokens(str9, str8);
                                    Timber.Forest.getClass();
                                    ConnectionPool.d(new Object[0]);
                                }
                            }
                        }
                    }
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                if (musicResponsiveHeaderRenderer == null || (runs3 = musicResponsiveHeaderRenderer.title) == null || (list23 = runs3.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list23)) == null || (str3 = run3.text) == null) {
                    str3 = "";
                }
                String str10 = str3;
                if (musicResponsiveHeaderRenderer == null || (runs2 = musicResponsiveHeaderRenderer.straplineTextOne) == null || (list22 = runs2.runs) == null || (run2 = (Run) CollectionsKt.firstOrNull(list22)) == null) {
                    artist = null;
                } else {
                    String str11 = run2.text;
                    NavigationEndpoint navigationEndpoint3 = run2.navigationEndpoint;
                    artist = new Artist(str11, (navigationEndpoint3 == null || (browseEndpoint = navigationEndpoint3.browseEndpoint) == null) ? null : browseEndpoint.browseId);
                }
                String str12 = (musicResponsiveHeaderRenderer == null || (runs = musicResponsiveHeaderRenderer.secondSubtitle) == null || (list21 = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list21)) == null) ? null : run.text;
                String str13 = (musicResponsiveHeaderRenderer == null || (thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) == null || (thumbnails = musicThumbnailRenderer.thumbnail) == null || (list20 = thumbnails.thumbnails) == null || (thumbnail = (Thumbnail) CollectionsKt.lastOrNull(list20)) == null) ? null : thumbnail.url;
                if (musicResponsiveHeaderRenderer == null || (list17 = musicResponsiveHeaderRenderer.buttons) == null) {
                    watchEndpoint = null;
                } else {
                    Iterator it4 = list17.iterator();
                    do {
                        if (!it4.hasNext()) {
                            next5 = null;
                            break;
                        }
                        next5 = it4.next();
                        menuRenderer3 = ((MusicResponsiveHeaderRenderer.Button) next5).menuRenderer;
                    } while (!Intrinsics.areEqual((menuRenderer3 == null || (list19 = menuRenderer3.items) == null || (item2 = (Menu.MenuRenderer.Item) CollectionsKt.firstOrNull(list19)) == null || (menuNavigationItemRenderer4 = item2.menuNavigationItemRenderer) == null || (icon3 = menuNavigationItemRenderer4.icon) == null) ? null : icon3.iconType, "PLAY_ARROW"));
                    MusicResponsiveHeaderRenderer.Button button2 = (MusicResponsiveHeaderRenderer.Button) next5;
                    if (button2 == null || (menuRenderer2 = button2.menuRenderer) == null || (list18 = menuRenderer2.items) == null || (item = (Menu.MenuRenderer.Item) CollectionsKt.firstOrNull(list18)) == null || (menuNavigationItemRenderer3 = item.menuNavigationItemRenderer) == null || (navigationEndpoint2 = menuNavigationItemRenderer3.navigationEndpoint) == null) {
                        watchEndpoint = null;
                    } else {
                        watchEndpoint = navigationEndpoint2.watchPlaylistEndpoint;
                    }
                }
                if (musicResponsiveHeaderRenderer == null || (list14 = musicResponsiveHeaderRenderer.buttons) == null) {
                    watchEndpoint2 = null;
                } else {
                    Iterator it5 = list14.iterator();
                    loop7: while (true) {
                        if (!it5.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it5.next();
                        Menu.MenuRenderer menuRenderer8 = ((MusicResponsiveHeaderRenderer.Button) next3).menuRenderer;
                        if (menuRenderer8 != null && (list16 = menuRenderer8.items) != null && !list16.isEmpty()) {
                            Iterator it6 = list16.iterator();
                            while (it6.hasNext()) {
                                Menu.MenuRenderer.Item.MenuNavigationItemRenderer menuNavigationItemRenderer5 = ((Menu.MenuRenderer.Item) it6.next()).menuNavigationItemRenderer;
                                if (Intrinsics.areEqual((menuNavigationItemRenderer5 == null || (icon2 = menuNavigationItemRenderer5.icon) == null) ? null : icon2.iconType, "MUSIC_SHUFFLE")) {
                                    break loop7;
                                }
                            }
                        }
                    }
                    MusicResponsiveHeaderRenderer.Button button3 = (MusicResponsiveHeaderRenderer.Button) next3;
                    if (button3 == null || (menuRenderer = button3.menuRenderer) == null || (list15 = menuRenderer.items) == null) {
                        watchEndpoint2 = null;
                    } else {
                        Iterator it7 = list15.iterator();
                        do {
                            if (!it7.hasNext()) {
                                next4 = null;
                                break;
                            }
                            next4 = it7.next();
                            menuNavigationItemRenderer2 = ((Menu.MenuRenderer.Item) next4).menuNavigationItemRenderer;
                        } while (!Intrinsics.areEqual((menuNavigationItemRenderer2 == null || (icon = menuNavigationItemRenderer2.icon) == null) ? null : icon.iconType, "MUSIC_SHUFFLE"));
                        Menu.MenuRenderer.Item item4 = (Menu.MenuRenderer.Item) next4;
                        if (item4 == null || (menuNavigationItemRenderer = item4.menuNavigationItemRenderer) == null || (navigationEndpoint = menuNavigationItemRenderer.navigationEndpoint) == null) {
                            watchEndpoint2 = null;
                        } else {
                            watchEndpoint2 = navigationEndpoint.watchPlaylistEndpoint;
                        }
                    }
                }
                PodcastItem podcastItem = new PodcastItem(str5, str10, artist, str12, str13, watchEndpoint, watchEndpoint2, libraryFeedbackTokens != null ? libraryFeedbackTokens.addToken : null, libraryFeedbackTokens != null ? libraryFeedbackTokens.removeToken : null, str6);
                BrowseResponse.SecondaryContents secondaryContents2 = (contents == null || (twoColumnBrowseResultsRenderer2 = contents.twoColumnBrowseResultsRenderer) == null) ? null : twoColumnBrowseResultsRenderer2.secondaryContents;
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                ConnectionPool.d(new Object[0]);
                if (secondaryContents2 != null && (sectionListRenderer7 = secondaryContents2.sectionListRenderer) != null && (list13 = sectionListRenderer7.contents) != null) {
                    list13.size();
                }
                ConnectionPool.d(new Object[0]);
                if (secondaryContents2 != null && (sectionListRenderer6 = secondaryContents2.sectionListRenderer) != null && (list12 = sectionListRenderer6.contents) != null) {
                    int i8 = 0;
                    for (Object obj4 : list12) {
                        int i9 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt__IterablesKt.throwIndexOverflow();
                            throw null;
                        }
                        SectionListRenderer.Content content10 = (SectionListRenderer.Content) obj4;
                        ConnectionPool connectionPool4 = Timber.Forest;
                        MusicShelfRenderer musicShelfRenderer5 = content10.musicShelfRenderer;
                        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer2 = content10.musicPlaylistShelfRenderer;
                        connectionPool4.getClass();
                        ConnectionPool.d(new Object[0]);
                        MusicShelfRenderer musicShelfRenderer6 = content10.musicShelfRenderer;
                        if (musicShelfRenderer6 != null) {
                            List list35 = musicShelfRenderer6.contents;
                            if (list35 != null) {
                                list35.size();
                            }
                            ConnectionPool.d(new Object[0]);
                        }
                        if (musicPlaylistShelfRenderer2 != null) {
                            musicPlaylistShelfRenderer2.contents.size();
                            ConnectionPool.d(new Object[0]);
                        }
                        i8 = i9;
                    }
                }
                List list36 = (secondaryContents2 == null || (sectionListRenderer5 = secondaryContents2.sectionListRenderer) == null || (list11 = sectionListRenderer5.contents) == null || (content5 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list11)) == null || (musicShelfRenderer4 = content5.musicShelfRenderer) == null) ? null : musicShelfRenderer4.contents;
                if (list36 == null) {
                    list36 = (secondaryContents2 == null || (sectionListRenderer4 = secondaryContents2.sectionListRenderer) == null || (list10 = sectionListRenderer4.contents) == null || (content4 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list10)) == null || (musicPlaylistShelfRenderer = content4.musicPlaylistShelfRenderer) == null) ? null : musicPlaylistShelfRenderer.contents;
                    ConnectionPool connectionPool5 = Timber.Forest;
                    if (list36 != null) {
                        list36.size();
                    }
                    connectionPool5.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                if (list36 == null) {
                    if (contents == null || (tabs2 = contents.singleColumnBrowseResultsRenderer) == null || (list8 = tabs2.tabs) == null || (tab2 = (Tabs.Tab) CollectionsKt.firstOrNull(list8)) == null || (tabRenderer2 = tab2.tabRenderer) == null || (content3 = tabRenderer2.content) == null || (sectionListRenderer3 = content3.sectionListRenderer) == null || (list9 = sectionListRenderer3.contents) == null) {
                        list36 = null;
                    } else {
                        Iterator it8 = list9.iterator();
                        do {
                            if (!it8.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it8.next();
                        } while (((SectionListRenderer.Content) next2).musicShelfRenderer == null);
                        SectionListRenderer.Content content11 = (SectionListRenderer.Content) next2;
                        if (content11 == null || (musicShelfRenderer3 = content11.musicShelfRenderer) == null) {
                            list36 = null;
                        } else {
                            list36 = musicShelfRenderer3.contents;
                        }
                    }
                    ConnectionPool connectionPool6 = Timber.Forest;
                    if (list36 != null) {
                        list36.size();
                    }
                    connectionPool6.getClass();
                    ConnectionPool.d(new Object[0]);
                }
                ConnectionPool connectionPool7 = Timber.Forest;
                if (list36 != null) {
                    list36.size();
                }
                connectionPool7.getClass();
                ConnectionPool.d(new Object[0]);
                if (list36 != null) {
                    arrayList2 = new ArrayList();
                    Iterator it9 = list36.iterator();
                    while (it9.hasNext()) {
                        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = ((MusicShelfRenderer.Content) it9.next()).musicMultiRowListItemRenderer;
                        if (musicMultiRowListItemRenderer != null) {
                            arrayList2.add(musicMultiRowListItemRenderer);
                        }
                    }
                }
                ConnectionPool connectionPool8 = Timber.Forest;
                arrayList2.size();
                connectionPool8.getClass();
                ConnectionPool.d(new Object[0]);
                int i10 = 0;
                for (Object obj5 : CollectionsKt.take(arrayList2, 2)) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__IterablesKt.throwIndexOverflow();
                        throw null;
                    }
                    MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2 = (MusicMultiRowListItemRenderer) obj5;
                    ConnectionPool connectionPool9 = Timber.Forest;
                    Runs runs5 = musicMultiRowListItemRenderer2.title;
                    if (runs5 != null && (list7 = runs5.runs) != null) {
                    }
                    connectionPool9.getClass();
                    ConnectionPool.d(new Object[0]);
                    Runs runs6 = musicMultiRowListItemRenderer2.subtitle;
                    if (runs6 == null || (list6 = runs6.runs) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10));
                        Iterator it10 = list6.iterator();
                        while (it10.hasNext()) {
                            arrayList.add(((Run) it10.next()).text);
                        }
                    }
                    Objects.toString(arrayList);
                    ConnectionPool.d(new Object[0]);
                    Timber.Forest.getClass();
                    ConnectionPool.d(new Object[0]);
                    ThumbnailRenderer thumbnailRenderer2 = musicMultiRowListItemRenderer2.thumbnail;
                    if (thumbnailRenderer2 != null) {
                        thumbnailRenderer2.getThumbnailUrl();
                    }
                    ConnectionPool.d(new Object[0]);
                    i10 = i11;
                }
                ArrayList arrayList5 = new ArrayList();
                Iterator it11 = arrayList2.iterator();
                while (it11.hasNext()) {
                    EpisodeItem episodeItemFromMusicMultiRowListItemRenderer = PodcastPage.Companion.fromMusicMultiRowListItemRenderer((MusicMultiRowListItemRenderer) it11.next(), podcastItem);
                    if (episodeItemFromMusicMultiRowListItemRenderer != null) {
                        arrayList5.add(episodeItemFromMusicMultiRowListItemRenderer);
                    }
                }
                ConnectionPool connectionPool10 = Timber.Forest;
                arrayList5.size();
                connectionPool10.getClass();
                ConnectionPool.d(new Object[0]);
                if (contents != null && (twoColumnBrowseResultsRenderer = contents.twoColumnBrowseResultsRenderer) != null && (secondaryContents = twoColumnBrowseResultsRenderer.secondaryContents) != null && (sectionListRenderer2 = secondaryContents.sectionListRenderer) != null && (list4 = sectionListRenderer2.contents) != null && (content2 = (SectionListRenderer.Content) CollectionsKt.firstOrNull(list4)) != null && (musicShelfRenderer2 = content2.musicShelfRenderer) != null && (list5 = musicShelfRenderer2.continuations) != null && (continuation = ContinuationKt.getContinuation(list5)) != null) {
                    continuation2 = continuation;
                } else if (contents != null && (tabs = contents.singleColumnBrowseResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null) {
                    Iterator it12 = list2.iterator();
                    do {
                        if (!it12.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it12.next();
                    } while (((SectionListRenderer.Content) next).musicShelfRenderer == null);
                    SectionListRenderer.Content content12 = (SectionListRenderer.Content) next;
                    if (content12 != null && (musicShelfRenderer = content12.musicShelfRenderer) != null && (list3 = musicShelfRenderer.continuations) != null) {
                        continuation2 = ContinuationKt.getContinuation(list3);
                    }
                }
                return new PodcastPage(podcastItem, arrayList5, continuation2, z);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$podcastWithDebug$2.L$0 = str2;
            youTube$podcastWithDebug$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$podcastWithDebug$2);
        } catch (Throwable th) {
            return ResultKt.createFailure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r14 == r5) goto L30;
     */
    /* JADX INFO: renamed from: queue-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1029queue0E7RQCE(List list, String str, ContinuationImpl continuationImpl) {
        YouTube$queue$1 youTube$queue$1;
        TypeReference typeReferenceTypeOf;
        if (continuationImpl instanceof YouTube$queue$1) {
            youTube$queue$1 = (YouTube$queue$1) continuationImpl;
            int i = youTube$queue$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$queue$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$queue$1 = new YouTube$queue$1(this, continuationImpl);
            }
        } else {
            youTube$queue$1 = new YouTube$queue$1(this, continuationImpl);
        }
        Object objExecuteRequest$default = youTube$queue$1.result;
        int i2 = youTube$queue$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                    if (list != null) {
                        list.size();
                    }
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$queue$1.label = 1;
                    com.metrolist.innertubex.InnerTube innerTube3 = innerTube2.innerTubeX;
                    com.metrolist.innertubex.InnerTube.SessionSnapshot sessionSnapshot = innerTube3.sessionSnapshot();
                    objExecuteRequest$default = com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube3, "getQueue", new InnerTube$getQueue$2(innerTube3, youTubeClient, sessionSnapshot, sessionSnapshot.useLoginForBrowse, list, str, null), youTube$queue$1, 62);
                    if (objExecuteRequest$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                }
                if (objExecuteRequest$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.GetQueueResponse");
                }
                List list2 = ((GetQueueResponse) objExecuteRequest$default).queueDatas;
                ArrayList arrayList = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    PlaylistPanelVideoRenderer playlistPanelVideoRenderer = ((GetQueueResponse.QueueData) it.next()).content.playlistPanelVideoRenderer;
                    SongItem songItemFromPlaylistPanelVideoRenderer = playlistPanelVideoRenderer != null ? NextPage.fromPlaylistPanelVideoRenderer(playlistPanelVideoRenderer) : null;
                    if (songItemFromPlaylistPanelVideoRenderer != null) {
                        arrayList.add(songItemFromPlaylistPanelVideoRenderer);
                    }
                }
                return arrayList;
                typeReferenceTypeOf = Reflection.typeOf(GetQueueResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objExecuteRequest$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GetQueueResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$queue$1.label = 2;
            objExecuteRequest$default = call.bodyNullable(typeInfo, youTube$queue$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: registerPlayback-0E7RQCE, reason: not valid java name */
    public final Object m1030registerPlayback0E7RQCE(String str, ContinuationImpl continuationImpl) {
        YouTube$registerPlayback$1 youTube$registerPlayback$1;
        if (continuationImpl instanceof YouTube$registerPlayback$1) {
            youTube$registerPlayback$1 = (YouTube$registerPlayback$1) continuationImpl;
            int i = youTube$registerPlayback$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$registerPlayback$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$registerPlayback$1 = new YouTube$registerPlayback$1(this, continuationImpl);
            }
        } else {
            youTube$registerPlayback$1 = new YouTube$registerPlayback$1(this, continuationImpl);
        }
        Object objRegisterPlayback = youTube$registerPlayback$1.result;
        int i2 = youTube$registerPlayback$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRegisterPlayback);
                IntRange intRange = new IntRange(1, 16, 1);
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
                Iterator it = intRange.iterator();
                while (((IntProgressionIterator) it).hasNext) {
                    ((IntIterator) it).nextInt();
                    arrayList.add(new Character("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".charAt(Random.defaultRandom.nextInt(0, 64))));
                }
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "", null, null, null, 62);
                InnerTube innerTube2 = innerTube;
                youTube$registerPlayback$1.label = 1;
                YouTubeClient.INSTANCE.getClass();
                objRegisterPlayback = innerTube2.registerPlayback(YouTubeClient.WEB_REMIX, str, strJoinToString$default, youTube$registerPlayback$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objRegisterPlayback == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objRegisterPlayback);
            }
            return (HttpResponse) objRegisterPlayback;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r13 == r12) goto L29;
     */
    /* JADX INFO: renamed from: related-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1031relatedgIAlus(BrowseEndpoint browseEndpoint, ContinuationImpl continuationImpl) {
        YouTube$related$1 youTube$related$1;
        TypeReference typeReferenceTypeOf;
        SectionListRenderer sectionListRenderer;
        List list;
        List<MusicCarouselShelfRenderer.Content> list2;
        Object objFromMusicTwoRowItemRenderer;
        byte b;
        MusicResponsiveListItemRenderer.Overlay overlay;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs watchEndpointMusicSupportedConfigs;
        WatchEndpoint.WatchEndpointMusicSupportedConfigs.WatchEndpointMusicConfig watchEndpointMusicConfig;
        if (continuationImpl instanceof YouTube$related$1) {
            youTube$related$1 = (YouTube$related$1) continuationImpl;
            int i = youTube$related$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$related$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$related$1 = new YouTube$related$1(this, continuationImpl);
            }
        } else {
            youTube$related$1 = new YouTube$related$1(this, continuationImpl);
        }
        YouTube$related$1 youTube$related$2 = youTube$related$1;
        Object objBrowse$default = youTube$related$2.result;
        int i2 = youTube$related$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBrowse$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    String str = browseEndpoint.browseId;
                    youTube$related$2.label = 1;
                    objBrowse$default = InnerTube.browse$default(innerTube2, youTubeClient, str, null, null, false, youTube$related$2, 28);
                    if (objBrowse$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objBrowse$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objBrowse$default);
                }
                if (objBrowse$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.BrowseResponse");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                BrowseResponse.Contents contents = ((BrowseResponse) objBrowse$default).contents;
                if (contents != null && (sectionListRenderer = contents.sectionListRenderer) != null && (list = sectionListRenderer.contents) != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MusicCarouselShelfRenderer musicCarouselShelfRenderer = ((SectionListRenderer.Content) it.next()).musicCarouselShelfRenderer;
                        if (musicCarouselShelfRenderer != null && (list2 = musicCarouselShelfRenderer.contents) != null) {
                            for (MusicCarouselShelfRenderer.Content content2 : list2) {
                                MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = content2.musicResponsiveListItemRenderer;
                                if (musicResponsiveListItemRenderer == null || (objFromMusicTwoRowItemRenderer = RelatedPage.Companion.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer)) == null) {
                                    MusicTwoRowItemRenderer musicTwoRowItemRenderer = content2.musicTwoRowItemRenderer;
                                    objFromMusicTwoRowItemRenderer = musicTwoRowItemRenderer != null ? RelatedPage.Companion.fromMusicTwoRowItemRenderer(musicTwoRowItemRenderer) : null;
                                }
                                if (objFromMusicTwoRowItemRenderer == null) {
                                    b = -1;
                                } else if (objFromMusicTwoRowItemRenderer instanceof SongItem) {
                                    b = 0;
                                } else if (objFromMusicTwoRowItemRenderer instanceof AlbumItem) {
                                    b = 1;
                                } else if (objFromMusicTwoRowItemRenderer instanceof ArtistItem) {
                                    b = 2;
                                } else if (objFromMusicTwoRowItemRenderer instanceof PlaylistItem) {
                                    b = 3;
                                } else if (objFromMusicTwoRowItemRenderer instanceof PodcastItem) {
                                    b = 4;
                                } else {
                                    b = objFromMusicTwoRowItemRenderer instanceof EpisodeItem ? (byte) 5 : (byte) -2;
                                }
                                switch (b) {
                                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                                    case 4:
                                    case 5:
                                        break;
                                    case 0:
                                        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = content2.musicResponsiveListItemRenderer;
                                        if (Intrinsics.areEqual((musicResponsiveListItemRenderer2 == null || (overlay = musicResponsiveListItemRenderer2.overlay) == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null || (watchEndpointMusicSupportedConfigs = watchEndpoint.watchEndpointMusicSupportedConfigs) == null || (watchEndpointMusicConfig = watchEndpointMusicSupportedConfigs.watchEndpointMusicConfig) == null) ? null : watchEndpointMusicConfig.musicVideoType, "MUSIC_VIDEO_TYPE_ATV")) {
                                            arrayList.add(objFromMusicTwoRowItemRenderer);
                                        }
                                        break;
                                    case 1:
                                        arrayList2.add(objFromMusicTwoRowItemRenderer);
                                        break;
                                    case 2:
                                        arrayList3.add(objFromMusicTwoRowItemRenderer);
                                        break;
                                    case 3:
                                        arrayList4.add(objFromMusicTwoRowItemRenderer);
                                        break;
                                    default:
                                        throw new HttpException();
                                }
                            }
                        }
                    }
                }
                return new RelatedPage(arrayList, arrayList2, arrayList3, arrayList4);
                typeReferenceTypeOf = Reflection.typeOf(BrowseResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objBrowse$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$related$2.label = 2;
            objBrowse$default = call.bodyNullable(typeInfo, youTube$related$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: removeEpisodeFromSavedEpisodes-0E7RQCE, reason: not valid java name */
    public final Object m1032removeEpisodeFromSavedEpisodes0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        YouTube$removeEpisodeFromSavedEpisodes$1 youTube$removeEpisodeFromSavedEpisodes$1;
        if (continuationImpl instanceof YouTube$removeEpisodeFromSavedEpisodes$1) {
            youTube$removeEpisodeFromSavedEpisodes$1 = (YouTube$removeEpisodeFromSavedEpisodes$1) continuationImpl;
            int i = youTube$removeEpisodeFromSavedEpisodes$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$removeEpisodeFromSavedEpisodes$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$removeEpisodeFromSavedEpisodes$1 = new YouTube$removeEpisodeFromSavedEpisodes$1(this, continuationImpl);
            }
        } else {
            youTube$removeEpisodeFromSavedEpisodes$1 = new YouTube$removeEpisodeFromSavedEpisodes$1(this, continuationImpl);
        }
        YouTube$removeEpisodeFromSavedEpisodes$1 youTube$removeEpisodeFromSavedEpisodes$2 = youTube$removeEpisodeFromSavedEpisodes$1;
        Object objRemoveFromPlaylist = youTube$removeEpisodeFromSavedEpisodes$2.result;
        int i2 = youTube$removeEpisodeFromSavedEpisodes$2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRemoveFromPlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$removeEpisodeFromSavedEpisodes$2.label = 1;
                objRemoveFromPlaylist = innerTube2.removeFromPlaylist(youTubeClient, "SE", str, str2, youTube$removeEpisodeFromSavedEpisodes$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objRemoveFromPlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objRemoveFromPlaylist);
            }
            return (HttpResponse) objRemoveFromPlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX INFO: renamed from: removeFromPlaylist-BWLJW6A, reason: not valid java name */
    public final Object m1033removeFromPlaylistBWLJW6A(String str, String str2, String str3, ContinuationImpl continuationImpl) {
        YouTube$removeFromPlaylist$1 youTube$removeFromPlaylist$1;
        if (continuationImpl instanceof YouTube$removeFromPlaylist$1) {
            youTube$removeFromPlaylist$1 = (YouTube$removeFromPlaylist$1) continuationImpl;
            int i = youTube$removeFromPlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$removeFromPlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$removeFromPlaylist$1 = new YouTube$removeFromPlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$removeFromPlaylist$1 = new YouTube$removeFromPlaylist$1(this, continuationImpl);
        }
        YouTube$removeFromPlaylist$1 youTube$removeFromPlaylist$2 = youTube$removeFromPlaylist$1;
        Object objRemoveFromPlaylist = youTube$removeFromPlaylist$2.result;
        int i2 = youTube$removeFromPlaylist$2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRemoveFromPlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$removeFromPlaylist$2.label = 1;
                objRemoveFromPlaylist = innerTube2.removeFromPlaylist(youTubeClient, str, str2, str3, youTube$removeFromPlaylist$2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objRemoveFromPlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objRemoveFromPlaylist);
            }
            return (HttpResponse) objRemoveFromPlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r6 == r5) goto L36;
     */
    /* JADX INFO: renamed from: removeSongFromLibrary-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1034removeSongFromLibrarygIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$removeSongFromLibrary$1 youTube$removeSongFromLibrary$1;
        Object objM1024next0E7RQCE;
        Object next;
        Object objM1006feedbackgIAlus;
        if (continuationImpl instanceof YouTube$removeSongFromLibrary$1) {
            youTube$removeSongFromLibrary$1 = (YouTube$removeSongFromLibrary$1) continuationImpl;
            int i = youTube$removeSongFromLibrary$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$removeSongFromLibrary$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$removeSongFromLibrary$1 = new YouTube$removeSongFromLibrary$1(this, continuationImpl);
            }
        } else {
            youTube$removeSongFromLibrary$1 = new YouTube$removeSongFromLibrary$1(this, continuationImpl);
        }
        Object obj = youTube$removeSongFromLibrary$1.result;
        int i2 = youTube$removeSongFromLibrary$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                WatchEndpoint watchEndpoint = new WatchEndpoint(62, str, null, null);
                youTube$removeSongFromLibrary$1.L$0 = str;
                youTube$removeSongFromLibrary$1.L$1 = this;
                youTube$removeSongFromLibrary$1.label = 1;
                objM1024next0E7RQCE = m1024next0E7RQCE(watchEndpoint, null, youTube$removeSongFromLibrary$1);
                if (objM1024next0E7RQCE == coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                this = youTube$removeSongFromLibrary$1.L$1;
                str = youTube$removeSongFromLibrary$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM1024next0E7RQCE = ((Result) obj).value;
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1006feedbackgIAlus = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1006feedbackgIAlus);
            Boolean bool = (Boolean) objM1006feedbackgIAlus;
            bool.getClass();
            return bool;
            ResultKt.throwOnFailure(objM1024next0E7RQCE);
            Iterator it = ((NextResult) objM1024next0E7RQCE).items.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((SongItem) next).id, str));
            SongItem songItem = (SongItem) next;
            if (songItem == null) {
                throw new Exception("Song not found in next response");
            }
            String str2 = songItem.libraryRemoveToken;
            if (str2 == null) {
                throw new Exception("Remove from library token not available");
            }
            List listListOf = CollectionsKt__IterablesKt.listOf(str2);
            youTube$removeSongFromLibrary$1.L$0 = null;
            youTube$removeSongFromLibrary$1.L$1 = null;
            youTube$removeSongFromLibrary$1.label = 2;
            objM1006feedbackgIAlus = this.m1006feedbackgIAlus(listListOf, youTube$removeSongFromLibrary$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r6 == r4) goto L28;
     */
    /* JADX INFO: renamed from: removeThumbnailPlaylist-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1035removeThumbnailPlaylistgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$removeThumbnailPlaylist$1 youTube$removeThumbnailPlaylist$1;
        TypeReference typeReferenceTypeOf;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        MusicEditablePlaylistDetailHeaderRenderer.Header header;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        if (continuationImpl instanceof YouTube$removeThumbnailPlaylist$1) {
            youTube$removeThumbnailPlaylist$1 = (YouTube$removeThumbnailPlaylist$1) continuationImpl;
            int i = youTube$removeThumbnailPlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$removeThumbnailPlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$removeThumbnailPlaylist$1 = new YouTube$removeThumbnailPlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$removeThumbnailPlaylist$1 = new YouTube$removeThumbnailPlaylist$1(this, continuationImpl);
        }
        Object objRemovePlaylistThumbnail = youTube$removeThumbnailPlaylist$1.result;
        int i2 = youTube$removeThumbnailPlaylist$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objRemovePlaylistThumbnail);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$removeThumbnailPlaylist$1.label = 1;
                    objRemovePlaylistThumbnail = innerTube2.removePlaylistThumbnail(youTubeClient, str, youTube$removeThumbnailPlaylist$1);
                    if (objRemovePlaylistThumbnail == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objRemovePlaylistThumbnail);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objRemovePlaylistThumbnail);
                }
                if (objRemovePlaylistThumbnail == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.EditPlaylistResponse");
                }
                BrowseResponse.Header header2 = ((EditPlaylistResponse) objRemovePlaylistThumbnail).newHeader;
                if (header2 == null || (musicEditablePlaylistDetailHeaderRenderer = header2.musicEditablePlaylistDetailHeaderRenderer) == null || (header = musicEditablePlaylistDetailHeaderRenderer.header) == null || (musicResponsiveHeaderRenderer = header.musicResponsiveHeaderRenderer) == null || (thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) == null) {
                    return null;
                }
                return musicThumbnailRenderer.getThumbnailUrl();
                typeReferenceTypeOf = Reflection.typeOf(EditPlaylistResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objRemovePlaylistThumbnail).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(EditPlaylistResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$removeThumbnailPlaylist$1.label = 2;
            objRemovePlaylistThumbnail = call.bodyNullable(typeInfo, youTube$removeThumbnailPlaylist$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: renamePlaylist-0E7RQCE, reason: not valid java name */
    public final Object m1036renamePlaylist0E7RQCE(String str, String str2, ContinuationImpl continuationImpl) {
        YouTube$renamePlaylist$1 youTube$renamePlaylist$1;
        if (continuationImpl instanceof YouTube$renamePlaylist$1) {
            youTube$renamePlaylist$1 = (YouTube$renamePlaylist$1) continuationImpl;
            int i = youTube$renamePlaylist$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$renamePlaylist$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$renamePlaylist$1 = new YouTube$renamePlaylist$1(this, continuationImpl);
            }
        } else {
            youTube$renamePlaylist$1 = new YouTube$renamePlaylist$1(this, continuationImpl);
        }
        Object objRenamePlaylist = youTube$renamePlaylist$1.result;
        int i2 = youTube$renamePlaylist$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRenamePlaylist);
                InnerTube innerTube2 = innerTube;
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$renamePlaylist$1.label = 1;
                objRenamePlaylist = innerTube2.renamePlaylist(youTubeClient, str, str2, youTube$renamePlaylist$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objRenamePlaylist == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objRenamePlaylist);
            }
            return (HttpResponse) objRenamePlaylist;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object resolveArtistIds(List list, ContinuationImpl continuationImpl) {
        C00821 c00821;
        Artist artist;
        ArrayList arrayList;
        if (continuationImpl instanceof C00821) {
            c00821 = (C00821) continuationImpl;
            int i = c00821.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00821.label = i - Integer.MIN_VALUE;
            } else {
                c00821 = new C00821(continuationImpl);
            }
        } else {
            c00821 = new C00821(continuationImpl);
        }
        Object objCoroutineScope = c00821.result;
        int i2 = c00821.label;
        byte b = 1;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                YTItem yTItem = (YTItem) it.next();
                if (yTItem != null) {
                    int i3 = 0;
                    if (yTItem instanceof SongItem) {
                        List list2 = ((SongItem) yTItem).artists;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : list2) {
                            if (((Artist) obj).id == null) {
                                arrayList2.add(obj);
                            }
                        }
                        int size = arrayList2.size();
                        while (i3 < size) {
                            Object obj2 = arrayList2.get(i3);
                            i3++;
                            linkedHashSet.add(((Artist) obj2).name);
                        }
                    } else if (yTItem instanceof AlbumItem) {
                        List list3 = ((AlbumItem) yTItem).artists;
                        if (list3 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (Object obj3 : list3) {
                                if (((Artist) obj3).id == null) {
                                    arrayList3.add(obj3);
                                }
                            }
                            int size2 = arrayList3.size();
                            while (i3 < size2) {
                                Object obj4 = arrayList3.get(i3);
                                i3++;
                                linkedHashSet.add(((Artist) obj4).name);
                            }
                        }
                    } else if (yTItem instanceof PlaylistItem) {
                        Artist artist2 = ((PlaylistItem) yTItem).author;
                        if (artist2 != null && artist2.id == null) {
                            linkedHashSet.add(artist2.name);
                        }
                    } else if (yTItem instanceof EpisodeItem) {
                        Artist artist3 = ((EpisodeItem) yTItem).author;
                        if (artist3 != null && artist3.id == null) {
                            linkedHashSet.add(artist3.name);
                        }
                    } else if ((yTItem instanceof PodcastItem) && (artist = ((PodcastItem) yTItem).author) != null && artist.id == null) {
                        linkedHashSet.add(artist.name);
                    }
                }
            }
            if (linkedHashSet.isEmpty()) {
                return list;
            }
            YouTube$resolveArtistIdMap$9 youTube$resolveArtistIdMap$9 = new YouTube$resolveArtistIdMap$9(linkedHashSet, continuation, b);
            c00821.L$0 = list;
            c00821.label = 1;
            objCoroutineScope = AwaitKt.coroutineScope(youTube$resolveArtistIdMap$9, c00821);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objCoroutineScope == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            list = (List) c00821.L$0;
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        Map map = (Map) objCoroutineScope;
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Object objCopy$default : list) {
            if (objCopy$default != null) {
                if (objCopy$default instanceof SongItem) {
                    SongItem songItem = (SongItem) objCopy$default;
                    List list4 = songItem.artists;
                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10));
                    Iterator it2 = list4.iterator();
                    while (it2.hasNext()) {
                        arrayList5.add(resolveArtistIds$resolve((Artist) it2.next(), map));
                    }
                    objCopy$default = SongItem.copy$default(songItem, arrayList5, null, null, 131067);
                } else if (objCopy$default instanceof AlbumItem) {
                    AlbumItem albumItem = (AlbumItem) objCopy$default;
                    List list5 = albumItem.artists;
                    if (list5 != null) {
                        arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10));
                        Iterator it3 = list5.iterator();
                        while (it3.hasNext()) {
                            arrayList.add(resolveArtistIds$resolve((Artist) it3.next(), map));
                        }
                    } else {
                        arrayList = null;
                    }
                    objCopy$default = AlbumItem.copy$default(albumItem, arrayList);
                } else if (objCopy$default instanceof PlaylistItem) {
                    PlaylistItem playlistItem = (PlaylistItem) objCopy$default;
                    Artist artist4 = playlistItem.author;
                    objCopy$default = PlaylistItem.copy$default(playlistItem, artist4 != null ? resolveArtistIds$resolve(artist4, map) : null, null, 4091);
                } else if (objCopy$default instanceof EpisodeItem) {
                    EpisodeItem episodeItem = (EpisodeItem) objCopy$default;
                    Artist artist5 = episodeItem.author;
                    objCopy$default = EpisodeItem.copy$default(episodeItem, artist5 != null ? resolveArtistIds$resolve(artist5, map) : null);
                } else if (objCopy$default instanceof PodcastItem) {
                    PodcastItem podcastItem = (PodcastItem) objCopy$default;
                    Artist artist6 = podcastItem.author;
                    objCopy$default = PodcastItem.copy$default(podcastItem, artist6 != null ? resolveArtistIds$resolve(artist6, map) : null);
                }
            }
            arrayList4.add(objCopy$default);
        }
        return arrayList4;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        if (r4 == r7) goto L29;
     */
    /* JADX INFO: renamed from: savePodcast-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1037savePodcast0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$savePodcast$1 youTube$savePodcast$1;
        if (continuationImpl instanceof YouTube$savePodcast$1) {
            youTube$savePodcast$1 = (YouTube$savePodcast$1) continuationImpl;
            int i = youTube$savePodcast$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$savePodcast$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$savePodcast$1 = new YouTube$savePodcast$1(this, continuationImpl);
            }
        } else {
            youTube$savePodcast$1 = new YouTube$savePodcast$1(this, continuationImpl);
        }
        Object objUnlikePlaylist = youTube$savePodcast$1.result;
        int i2 = youTube$savePodcast$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objUnlikePlaylist);
                    return (HttpResponse) objUnlikePlaylist;
                }
                if (i2 == 2) {
                    ResultKt.throwOnFailure(objUnlikePlaylist);
                    return (HttpResponse) objUnlikePlaylist;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objUnlikePlaylist);
            String strRemovePrefix = StringsKt.removePrefix(str, "MPSP");
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            InnerTube innerTube2 = innerTube;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (z) {
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$savePodcast$1.label = 1;
                objUnlikePlaylist = innerTube2.likePlaylist(youTubeClient, strRemovePrefix, youTube$savePodcast$1);
                if (objUnlikePlaylist == coroutineSingletons) {
                }
                return (HttpResponse) objUnlikePlaylist;
            }
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient2 = YouTubeClient.WEB_REMIX;
            youTube$savePodcast$1.label = 2;
            objUnlikePlaylist = innerTube2.unlikePlaylist(youTubeClient2, strRemovePrefix, youTube$savePodcast$1);
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: savedPodcastShows-IoAF18A, reason: not valid java name */
    public final Serializable m1038savedPodcastShowsIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$savedPodcastShows$1 youTube$savedPodcastShows$1;
        Object objM1014libraryPodcastEpisodesIoAF18A;
        if (continuationImpl instanceof YouTube$savedPodcastShows$1) {
            youTube$savedPodcastShows$1 = (YouTube$savedPodcastShows$1) continuationImpl;
            int i = youTube$savedPodcastShows$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$savedPodcastShows$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$savedPodcastShows$1 = new YouTube$savedPodcastShows$1(this, continuationImpl);
            }
        } else {
            youTube$savedPodcastShows$1 = new YouTube$savedPodcastShows$1(this, continuationImpl);
        }
        Object obj = youTube$savedPodcastShows$1.result;
        int i2 = youTube$savedPodcastShows$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                youTube$savedPodcastShows$1.label = 1;
                objM1014libraryPodcastEpisodesIoAF18A = m1014libraryPodcastEpisodesIoAF18A(youTube$savedPodcastShows$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objM1014libraryPodcastEpisodesIoAF18A == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1014libraryPodcastEpisodesIoAF18A = ((Result) obj).value;
            }
            ResultKt.throwOnFailure(objM1014libraryPodcastEpisodesIoAF18A);
            List list = ((LibraryPage) objM1014libraryPodcastEpisodesIoAF18A).items;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof PodcastItem) {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
    
        if (r13 == r12) goto L31;
     */
    /* JADX INFO: renamed from: search-MVsJJCw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1039searchMVsJJCw(String str, String str2, boolean z, ContinuationImpl continuationImpl) {
        YouTube$search$1 youTube$search$1;
        boolean z2;
        TypeReference typeReferenceTypeOf;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List list2;
        String continuation;
        if (continuationImpl instanceof YouTube$search$1) {
            youTube$search$1 = (YouTube$search$1) continuationImpl;
            int i = youTube$search$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$search$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$search$1 = new YouTube$search$1(this, continuationImpl);
            }
        } else {
            youTube$search$1 = new YouTube$search$1(this, continuationImpl);
        }
        YouTube$search$1 youTube$search$2 = youTube$search$1;
        Object objSearch$default = youTube$search$2.result;
        int i2 = youTube$search$2.label;
        int i3 = 0;
        String str3 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objSearch$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$search$2.Z$0 = z;
                    youTube$search$2.label = 1;
                    objSearch$default = InnerTube.search$default(innerTube2, youTubeClient, str, str2, null, z, youTube$search$2, 8);
                    if (objSearch$default != coroutineSingletons) {
                        z2 = z;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    z2 = youTube$search$2.Z$0;
                    ResultKt.throwOnFailure(objSearch$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objSearch$default);
                }
                if (objSearch$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.SearchResponse");
                }
                ArrayList arrayList = new ArrayList();
                SearchResponse.Contents contents = ((SearchResponse) objSearch$default).contents;
                if (contents != null && (tabs = contents.tabbedSearchResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null) {
                    Iterator it = list2.iterator();
                    loop0: while (true) {
                        continuation = null;
                        while (true) {
                            if (!it.hasNext()) {
                                break loop0;
                            }
                            SectionListRenderer.Content content2 = (SectionListRenderer.Content) it.next();
                            MusicShelfRenderer musicShelfRenderer = content2.musicShelfRenderer;
                            List list3 = EmptyList.INSTANCE;
                            if (musicShelfRenderer != null) {
                                List list4 = musicShelfRenderer.contents;
                                if (list4 != null) {
                                    ArrayList items = MusicShelfRendererKt.getItems(list4);
                                    ArrayList arrayList2 = new ArrayList();
                                    int size = items.size();
                                    int i4 = 0;
                                    while (i4 < size) {
                                        Object obj = items.get(i4);
                                        i4++;
                                        YTItem yTItem = SearchPage.toYTItem((MusicResponsiveListItemRenderer) obj, list3);
                                        if (yTItem != null) {
                                            arrayList2.add(yTItem);
                                        }
                                    }
                                    list3 = arrayList2;
                                }
                                arrayList.addAll(list3);
                                if (continuation != null) {
                                    continue;
                                } else {
                                    List list5 = musicShelfRenderer.continuations;
                                    if (list5 != null) {
                                        continuation = ContinuationKt.getContinuation(list5);
                                    }
                                }
                            } else {
                                ItemSectionRenderer itemSectionRenderer = content2.itemSectionRenderer;
                                if (itemSectionRenderer != null) {
                                    List list6 = itemSectionRenderer.contents;
                                    if (list6 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        Iterator it2 = list6.iterator();
                                        while (it2.hasNext()) {
                                            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((ItemSectionRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                                            if (musicResponsiveListItemRenderer != null) {
                                                arrayList3.add(musicResponsiveListItemRenderer);
                                            }
                                        }
                                        ArrayList arrayList4 = new ArrayList();
                                        int size2 = arrayList3.size();
                                        int i5 = 0;
                                        while (i5 < size2) {
                                            Object obj2 = arrayList3.get(i5);
                                            i5++;
                                            YTItem yTItem2 = SearchPage.toYTItem((MusicResponsiveListItemRenderer) obj2, list3);
                                            if (yTItem2 != null) {
                                                arrayList4.add(yTItem2);
                                            }
                                        }
                                        list3 = arrayList4;
                                    }
                                    arrayList.addAll(list3);
                                }
                            }
                        }
                    }
                    str3 = continuation;
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList5 = new ArrayList();
                int size3 = arrayList.size();
                while (i3 < size3) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    if (hashSet.add(((YTItem) obj3).getId())) {
                        arrayList5.add(obj3);
                    }
                }
                return new SearchResult(arrayList5, str3);
                typeReferenceTypeOf = Reflection.typeOf(SearchResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objSearch$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$search$2.Z$0 = z2;
            youTube$search$2.label = 2;
            objSearch$default = call.bodyNullable(typeInfo, youTube$search$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r12 == r11) goto L31;
     */
    /* JADX INFO: renamed from: searchContinuation-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1040searchContinuation0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$searchContinuation$1 youTube$searchContinuation$1;
        boolean z2;
        TypeReference typeReferenceTypeOf;
        SearchResponse.ContinuationContents.MusicShelfContinuation musicShelfContinuation;
        List list;
        SearchResponse.ContinuationContents.MusicShelfContinuation musicShelfContinuation2;
        List list2;
        if (continuationImpl instanceof YouTube$searchContinuation$1) {
            youTube$searchContinuation$1 = (YouTube$searchContinuation$1) continuationImpl;
            int i = youTube$searchContinuation$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$searchContinuation$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$searchContinuation$1 = new YouTube$searchContinuation$1(this, continuationImpl);
            }
        } else {
            youTube$searchContinuation$1 = new YouTube$searchContinuation$1(this, continuationImpl);
        }
        YouTube$searchContinuation$1 youTube$searchContinuation$2 = youTube$searchContinuation$1;
        Object objSearch$default = youTube$searchContinuation$2.result;
        int i2 = youTube$searchContinuation$2.label;
        String continuation = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objSearch$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$searchContinuation$2.Z$0 = z;
                    youTube$searchContinuation$2.label = 1;
                    objSearch$default = InnerTube.search$default(innerTube2, youTubeClient, null, null, str, z, youTube$searchContinuation$2, 6);
                    if (objSearch$default != coroutineSingletons) {
                        z2 = z;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    z2 = youTube$searchContinuation$2.Z$0;
                    ResultKt.throwOnFailure(objSearch$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objSearch$default);
                }
                if (objSearch$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.SearchResponse");
                }
                SearchResponse.ContinuationContents continuationContents = ((SearchResponse) objSearch$default).continuationContents;
                List list3 = EmptyList.INSTANCE;
                if (continuationContents != null && (musicShelfContinuation2 = continuationContents.musicShelfContinuation) != null && (list2 = musicShelfContinuation2.contents) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        YTItem yTItem = SearchPage.toYTItem(((SearchResponse.ContinuationContents.MusicShelfContinuation.Content) it.next()).musicResponsiveListItemRenderer, list3);
                        if (yTItem != null) {
                            arrayList.add(yTItem);
                        }
                    }
                    list3 = arrayList;
                }
                if (!list3.isEmpty() && continuationContents != null && (musicShelfContinuation = continuationContents.musicShelfContinuation) != null && (list = musicShelfContinuation.continuations) != null) {
                    continuation = ContinuationKt.getContinuation(list);
                }
                return new SearchResult(list3, continuation);
                typeReferenceTypeOf = Reflection.typeOf(SearchResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objSearch$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$searchContinuation$2.Z$0 = z2;
            youTube$searchContinuation$2.label = 2;
            objSearch$default = call.bodyNullable(typeInfo, youTube$searchContinuation$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r13 == r5) goto L28;
     */
    /* JADX INFO: renamed from: searchSuggestions-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1041searchSuggestionsgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$searchSuggestions$1 youTube$searchSuggestions$1;
        TypeReference typeReferenceTypeOf;
        ArrayList arrayList;
        GetSearchSuggestionsResponse.Content content;
        SearchSuggestionsSectionRenderer searchSuggestionsSectionRenderer;
        List list;
        GetSearchSuggestionsResponse.Content content2;
        SearchSuggestionsSectionRenderer searchSuggestionsSectionRenderer2;
        List list2;
        Runs runs;
        List list3;
        if (continuationImpl instanceof YouTube$searchSuggestions$1) {
            youTube$searchSuggestions$1 = (YouTube$searchSuggestions$1) continuationImpl;
            int i = youTube$searchSuggestions$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$searchSuggestions$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$searchSuggestions$1 = new YouTube$searchSuggestions$1(this, continuationImpl);
            }
        } else {
            youTube$searchSuggestions$1 = new YouTube$searchSuggestions$1(this, continuationImpl);
        }
        Object objExecuteRequest$default = youTube$searchSuggestions$1.result;
        int i2 = youTube$searchSuggestions$1.label;
        List list4 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$searchSuggestions$1.label = 1;
                    com.metrolist.innertubex.InnerTube innerTube3 = innerTube2.innerTubeX;
                    objExecuteRequest$default = com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube3, "getSearchSuggestions", new InnerTube$getTranscript$2(innerTube3, youTubeClient, innerTube3.sessionSnapshot(), str, null, (byte) 1), youTube$searchSuggestions$1, 62);
                    if (objExecuteRequest$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                }
                if (objExecuteRequest$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.GetSearchSuggestionsResponse");
                }
                List list5 = ((GetSearchSuggestionsResponse) objExecuteRequest$default).contents;
                if (list5 == null || (content2 = (GetSearchSuggestionsResponse.Content) CollectionsKt.getOrNull(0, list5)) == null || (searchSuggestionsSectionRenderer2 = content2.searchSuggestionsSectionRenderer) == null || (list2 = searchSuggestionsSectionRenderer2.contents) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        SearchSuggestionsSectionRenderer.Content.SearchSuggestionRenderer searchSuggestionRenderer = ((SearchSuggestionsSectionRenderer.Content) it.next()).searchSuggestionRenderer;
                        String strJoinToString$default = (searchSuggestionRenderer == null || (runs = searchSuggestionRenderer.suggestion) == null || (list3 = runs.runs) == null) ? null : CollectionsKt.joinToString$default(list3, "", null, null, new YouTube$$ExternalSyntheticLambda0((byte) 19), 30);
                        if (strJoinToString$default != null) {
                            arrayList.add(strJoinToString$default);
                        }
                    }
                }
                List list6 = EmptyList.INSTANCE;
                List list7 = arrayList;
                if (arrayList == null) {
                    list7 = list6;
                }
                if (list5 != null && (content = (GetSearchSuggestionsResponse.Content) CollectionsKt.getOrNull(1, list5)) != null && (searchSuggestionsSectionRenderer = content.searchSuggestionsSectionRenderer) != null && (list = searchSuggestionsSectionRenderer.contents) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((SearchSuggestionsSectionRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                        YTItem yTItemFromMusicResponsiveListItemRenderer = musicResponsiveListItemRenderer != null ? SearchSuggestionPage.fromMusicResponsiveListItemRenderer(musicResponsiveListItemRenderer) : null;
                        if (yTItemFromMusicResponsiveListItemRenderer != null) {
                            arrayList2.add(yTItemFromMusicResponsiveListItemRenderer);
                        }
                    }
                    list4 = arrayList2;
                }
                if (list4 != null) {
                    list6 = list4;
                }
                return new SearchSuggestions(list7, list6);
                typeReferenceTypeOf = Reflection.typeOf(GetSearchSuggestionsResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objExecuteRequest$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GetSearchSuggestionsResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$searchSuggestions$1.label = 2;
            objExecuteRequest$default = call.bodyNullable(typeInfo, youTube$searchSuggestions$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        if (r1 == r15) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List, kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.Iterable] */
    /* JADX INFO: renamed from: searchSummary-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1042searchSummary0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$searchSummary$1 youTube$searchSummary$1;
        Object obj;
        boolean z2;
        TypeReference typeReferenceTypeOf;
        Tabs tabs;
        List list;
        Tabs.Tab tab;
        Tabs.Tab.TabRenderer tabRenderer;
        Tabs.Tab.TabRenderer.Content content;
        SectionListRenderer sectionListRenderer;
        List<SectionListRenderer.Content> list2;
        List listExtractArtists;
        ArrayList arrayList;
        String str2;
        MusicCardShelfRenderer.Header.MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer;
        Runs runs;
        List list3;
        Run run;
        Run run2;
        String str3;
        List list4;
        Run run3;
        YouTube youTube = this;
        if (continuationImpl instanceof YouTube$searchSummary$1) {
            youTube$searchSummary$1 = (YouTube$searchSummary$1) continuationImpl;
            int i = youTube$searchSummary$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$searchSummary$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$searchSummary$1 = new YouTube$searchSummary$1(youTube, continuationImpl);
            }
        } else {
            youTube$searchSummary$1 = new YouTube$searchSummary$1(youTube, continuationImpl);
        }
        YouTube$searchSummary$1 youTube$searchSummary$2 = youTube$searchSummary$1;
        Object objBodyNullable = youTube$searchSummary$2.result;
        int i2 = youTube$searchSummary$2.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objBodyNullable);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$searchSummary$2.L$1 = youTube;
                    youTube$searchSummary$2.Z$0 = z;
                    youTube$searchSummary$2.label = 1;
                    Object objSearch$default = InnerTube.search$default(innerTube2, youTubeClient, str, null, null, z, youTube$searchSummary$2, 12);
                    if (objSearch$default != coroutineSingletons) {
                        obj = objSearch$default;
                        z2 = z;
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    boolean z3 = youTube$searchSummary$2.Z$0;
                    YouTube youTube2 = youTube$searchSummary$2.L$1;
                    ResultKt.throwOnFailure(objBodyNullable);
                    z2 = z3;
                    youTube = youTube2;
                    obj = objBodyNullable;
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    youTube = youTube$searchSummary$2.L$1;
                    ResultKt.throwOnFailure(objBodyNullable);
                }
                if (objBodyNullable == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.SearchResponse");
                }
                ArrayList arrayList2 = new ArrayList();
                SearchResponse.Contents contents = ((SearchResponse) objBodyNullable).contents;
                if (contents != null && (tabs = contents.tabbedSearchResultsRenderer) != null && (list = tabs.tabs) != null && (tab = (Tabs.Tab) CollectionsKt.firstOrNull(list)) != null && (tabRenderer = tab.tabRenderer) != null && (content = tabRenderer.content) != null && (sectionListRenderer = content.sectionListRenderer) != null && (list2 = sectionListRenderer.contents) != null) {
                    for (SectionListRenderer.Content content2 : list2) {
                        MusicCardShelfRenderer musicCardShelfRenderer = content2.musicCardShelfRenderer;
                        MusicShelfRenderer musicShelfRenderer = content2.musicShelfRenderer;
                        ?? arrayList3 = EmptyList.INSTANCE;
                        if (musicCardShelfRenderer != null) {
                            BrowseEndpoint browseEndpoint = musicCardShelfRenderer.onTap.browseEndpoint;
                            if (browseEndpoint == null || !browseEndpoint.isArtistEndpoint()) {
                                Set set = PageHelper.LIBRARY_ADD_ICONS;
                                listExtractArtists = PageHelper.extractArtists(musicCardShelfRenderer.subtitle.runs);
                            } else {
                                List list5 = musicCardShelfRenderer.title.runs;
                                listExtractArtists = CollectionsKt__IterablesKt.listOfNotNull((list5 == null || (run2 = (Run) CollectionsKt.firstOrNull(list5)) == null || (str3 = run2.text) == null) ? null : new Artist(str3, musicCardShelfRenderer.onTap.browseEndpoint.browseId));
                            }
                            List listListOfNotNull = CollectionsKt__IterablesKt.listOfNotNull(SearchSummaryPage.Companion.fromMusicCardShelfRenderer(musicCardShelfRenderer));
                            List list6 = musicCardShelfRenderer.contents;
                            if (list6 != null) {
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it = list6.iterator();
                                while (it.hasNext()) {
                                    MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = ((MusicCardShelfRenderer.Content) it.next()).musicResponsiveListItemRenderer;
                                    if (musicResponsiveListItemRenderer != null) {
                                        arrayList4.add(musicResponsiveListItemRenderer);
                                    }
                                }
                                arrayList = new ArrayList();
                                int size = arrayList4.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj2 = arrayList4.get(i3);
                                    i3++;
                                    YTItem yTItem = SearchPage.toYTItem((MusicResponsiveListItemRenderer) obj2, listExtractArtists);
                                    if (yTItem != null) {
                                        arrayList.add(yTItem);
                                    }
                                }
                            } else {
                                arrayList = null;
                            }
                            ArrayList arrayListPlus = CollectionsKt.plus((Iterable) (arrayList == null ? arrayList3 : arrayList), (Collection) listListOfNotNull);
                            HashSet hashSet = new HashSet();
                            ArrayList arrayList5 = new ArrayList();
                            int size2 = arrayListPlus.size();
                            int i4 = 0;
                            while (i4 < size2) {
                                Object obj3 = arrayListPlus.get(i4);
                                i4++;
                                if (hashSet.add(((YTItem) obj3).getId())) {
                                    arrayList5.add(obj3);
                                }
                            }
                            if (!arrayList5.isEmpty()) {
                                MusicCardShelfRenderer.Header header = musicCardShelfRenderer.header;
                                if (header == null || (musicCardShelfHeaderBasicRenderer = header.musicCardShelfHeaderBasicRenderer) == null || (runs = musicCardShelfHeaderBasicRenderer.title) == null || (list3 = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list3)) == null || (str2 = run.text) == null) {
                                    str2 = "Top result";
                                }
                                arrayList2.add(new SearchSummary(str2, arrayList5));
                            }
                        } else if (musicShelfRenderer != null) {
                            List list7 = musicShelfRenderer.contents;
                            if (list7 != null) {
                                ArrayList items = MusicShelfRendererKt.getItems(list7);
                                ArrayList arrayList6 = new ArrayList();
                                int size3 = items.size();
                                int i5 = 0;
                                while (i5 < size3) {
                                    Object obj4 = items.get(i5);
                                    i5++;
                                    YTItem yTItem2 = SearchPage.toYTItem((MusicResponsiveListItemRenderer) obj4, arrayList3);
                                    if (yTItem2 != null) {
                                        arrayList6.add(yTItem2);
                                    }
                                }
                                HashSet hashSet2 = new HashSet();
                                arrayList3 = new ArrayList();
                                int size4 = arrayList6.size();
                                int i6 = 0;
                                while (i6 < size4) {
                                    Object obj5 = arrayList6.get(i6);
                                    i6++;
                                    if (hashSet2.add(((YTItem) obj5).getId())) {
                                        arrayList3.add(obj5);
                                    }
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                Runs runs2 = musicShelfRenderer.title;
                                String str4 = (runs2 == null || (list4 = runs2.runs) == null || (run3 = (Run) CollectionsKt.firstOrNull(list4)) == null) ? null : run3.text;
                                if (str4 != null) {
                                    arrayList2.add(new SearchSummary(str4, arrayList3));
                                } else {
                                    youTube.getClass();
                                    arrayList2.addAll(groupItemsByType(arrayList3));
                                }
                            }
                        } else {
                            ItemSectionRenderer itemSectionRenderer = content2.itemSectionRenderer;
                            if (itemSectionRenderer != null) {
                                List list8 = itemSectionRenderer.contents;
                                if (list8 != null) {
                                    ArrayList arrayList7 = new ArrayList();
                                    Iterator it2 = list8.iterator();
                                    while (it2.hasNext()) {
                                        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = ((ItemSectionRenderer.Content) it2.next()).musicResponsiveListItemRenderer;
                                        if (musicResponsiveListItemRenderer2 != null) {
                                            arrayList7.add(musicResponsiveListItemRenderer2);
                                        }
                                    }
                                    ArrayList arrayList8 = new ArrayList();
                                    int size5 = arrayList7.size();
                                    int i7 = 0;
                                    while (i7 < size5) {
                                        Object obj6 = arrayList7.get(i7);
                                        i7++;
                                        YTItem yTItem3 = SearchPage.toYTItem((MusicResponsiveListItemRenderer) obj6, arrayList3);
                                        if (yTItem3 != null) {
                                            arrayList8.add(yTItem3);
                                        }
                                    }
                                    HashSet hashSet3 = new HashSet();
                                    arrayList3 = new ArrayList();
                                    int size6 = arrayList8.size();
                                    int i8 = 0;
                                    while (i8 < size6) {
                                        Object obj7 = arrayList8.get(i8);
                                        i8++;
                                        if (hashSet3.add(((YTItem) obj7).getId())) {
                                            arrayList3.add(obj7);
                                        }
                                    }
                                }
                                if (!arrayList3.isEmpty()) {
                                    youTube.getClass();
                                    arrayList2.addAll(groupItemsByType(arrayList3));
                                }
                            }
                        }
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size7 = arrayList2.size();
                int i9 = 0;
                while (i9 < size7) {
                    Object obj8 = arrayList2.get(i9);
                    i9++;
                    String str5 = ((SearchSummary) obj8).title;
                    Object arrayList9 = linkedHashMap.get(str5);
                    if (arrayList9 == null) {
                        arrayList9 = new ArrayList();
                        linkedHashMap.put(str5, arrayList9);
                    }
                    ((List) arrayList9).add(obj8);
                }
                ArrayList arrayList10 = new ArrayList(linkedHashMap.size());
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str6 = (String) entry.getKey();
                    List list9 = (List) entry.getValue();
                    ArrayList arrayList11 = new ArrayList();
                    Iterator it3 = list9.iterator();
                    while (it3.hasNext()) {
                        CollectionsKt__MutableCollectionsKt.addAll(((SearchSummary) it3.next()).items, arrayList11);
                    }
                    HashSet hashSet4 = new HashSet();
                    ArrayList arrayList12 = new ArrayList();
                    int size8 = arrayList11.size();
                    int i10 = 0;
                    while (i10 < size8) {
                        Object obj9 = arrayList11.get(i10);
                        i10++;
                        if (hashSet4.add(((YTItem) obj9).getId())) {
                            arrayList12.add(obj9);
                        }
                    }
                    arrayList10.add(new SearchSummary(str6, arrayList12));
                }
                return new SearchSummaryPage(CollectionsKt.sortedWith(arrayList10, new ColorCutQuantizer.AnonymousClass1((byte) 7)));
                typeReferenceTypeOf = Reflection.typeOf(SearchResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) obj).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$searchSummary$2.L$1 = youTube;
            youTube$searchSummary$2.Z$0 = z2;
            youTube$searchSummary$2.label = 2;
            objBodyNullable = call.bodyNullable(typeInfo, youTube$searchSummary$2);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if (r4 == r3) goto L29;
     */
    /* JADX INFO: renamed from: subscribeChannel-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1043subscribeChannelBWLJW6A(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$subscribeChannel$1 youTube$subscribeChannel$1;
        if (continuationImpl instanceof YouTube$subscribeChannel$1) {
            youTube$subscribeChannel$1 = (YouTube$subscribeChannel$1) continuationImpl;
            int i = youTube$subscribeChannel$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$subscribeChannel$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$subscribeChannel$1 = new YouTube$subscribeChannel$1(this, continuationImpl);
            }
        } else {
            youTube$subscribeChannel$1 = new YouTube$subscribeChannel$1(this, continuationImpl);
        }
        Object objUnsubscribeChannel = youTube$subscribeChannel$1.result;
        int i2 = youTube$subscribeChannel$1.label;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objUnsubscribeChannel);
                    return (HttpResponse) objUnsubscribeChannel;
                }
                if (i2 == 2) {
                    ResultKt.throwOnFailure(objUnsubscribeChannel);
                    return (HttpResponse) objUnsubscribeChannel;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objUnsubscribeChannel);
            InnerTube innerTube2 = innerTube;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (z) {
                YouTubeClient.INSTANCE.getClass();
                YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                youTube$subscribeChannel$1.label = 1;
                objUnsubscribeChannel = innerTube2.subscribeChannel(youTubeClient, str, "EgIIAhgA", youTube$subscribeChannel$1);
                if (objUnsubscribeChannel == coroutineSingletons) {
                }
                return (HttpResponse) objUnsubscribeChannel;
            }
            YouTubeClient.INSTANCE.getClass();
            YouTubeClient youTubeClient2 = YouTubeClient.WEB_REMIX;
            youTube$subscribeChannel$1.label = 2;
            objUnsubscribeChannel = innerTube2.unsubscribeChannel(youTubeClient2, str, "EgIIAhgA", youTube$subscribeChannel$1);
            return coroutineSingletons;
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r4 == r7) goto L26;
     */
    /* JADX INFO: renamed from: toggleSongLibrary-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1044toggleSongLibrary0E7RQCE(String str, boolean z, ContinuationImpl continuationImpl) {
        YouTube$toggleSongLibrary$1 youTube$toggleSongLibrary$1;
        Object objM1034removeSongFromLibrarygIAlus;
        Object objM994addSongToLibrarygIAlus;
        boolean zBooleanValue;
        if (continuationImpl instanceof YouTube$toggleSongLibrary$1) {
            youTube$toggleSongLibrary$1 = (YouTube$toggleSongLibrary$1) continuationImpl;
            int i = youTube$toggleSongLibrary$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$toggleSongLibrary$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$toggleSongLibrary$1 = new YouTube$toggleSongLibrary$1(this, continuationImpl);
            }
        } else {
            youTube$toggleSongLibrary$1 = new YouTube$toggleSongLibrary$1(this, continuationImpl);
        }
        Object obj = youTube$toggleSongLibrary$1.result;
        int i2 = youTube$toggleSongLibrary$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (z) {
                    youTube$toggleSongLibrary$1.label = 1;
                    objM994addSongToLibrarygIAlus = m994addSongToLibrarygIAlus(str, youTube$toggleSongLibrary$1);
                    if (objM994addSongToLibrarygIAlus == coroutineSingletons) {
                    }
                    ResultKt.throwOnFailure(objM994addSongToLibrarygIAlus);
                    zBooleanValue = ((Boolean) objM994addSongToLibrarygIAlus).booleanValue();
                } else {
                    youTube$toggleSongLibrary$1.label = 2;
                    objM1034removeSongFromLibrarygIAlus = m1034removeSongFromLibrarygIAlus(str, youTube$toggleSongLibrary$1);
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                objM994addSongToLibrarygIAlus = ((Result) obj).value;
                ResultKt.throwOnFailure(objM994addSongToLibrarygIAlus);
                zBooleanValue = ((Boolean) objM994addSongToLibrarygIAlus).booleanValue();
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objM1034removeSongFromLibrarygIAlus = ((Result) obj).value;
                ResultKt.throwOnFailure(objM1034removeSongFromLibrarygIAlus);
                zBooleanValue = ((Boolean) objM1034removeSongFromLibrarygIAlus).booleanValue();
            }
            return Boolean.valueOf(zBooleanValue);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
    
        if (r12 == r4) goto L28;
     */
    /* JADX INFO: renamed from: transcript-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1045transcriptgIAlus(String str, ContinuationImpl continuationImpl) {
        YouTube$transcript$1 youTube$transcript$1;
        TypeReference typeReferenceTypeOf;
        GetTranscriptResponse.Action action;
        GetTranscriptResponse.Action.UpdateEngagementPanelAction updateEngagementPanelAction;
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content content;
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer transcriptRenderer;
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body body;
        GetTranscriptResponse.Action.UpdateEngagementPanelAction.Content.TranscriptRenderer.Body.TranscriptBodyRenderer transcriptBodyRenderer;
        List list;
        if (continuationImpl instanceof YouTube$transcript$1) {
            youTube$transcript$1 = (YouTube$transcript$1) continuationImpl;
            int i = youTube$transcript$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$transcript$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$transcript$1 = new YouTube$transcript$1(this, continuationImpl);
            }
        } else {
            youTube$transcript$1 = new YouTube$transcript$1(this, continuationImpl);
        }
        Object objExecuteRequest$default = youTube$transcript$1.result;
        int i2 = youTube$transcript$1.label;
        byte b = 2;
        String strJoinToString$default = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB;
                    youTube$transcript$1.label = 1;
                    com.metrolist.innertubex.InnerTube innerTube3 = innerTube2.innerTubeX;
                    objExecuteRequest$default = com.metrolist.innertubex.InnerTube.executeRequest$default(innerTube3, "getTranscript", new InnerTube$getTranscript$2(innerTube3, youTubeClient, innerTube3.sessionSnapshot(), str, null, (byte) 0), youTube$transcript$1, 62);
                    if (objExecuteRequest$default == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(objExecuteRequest$default);
                }
                if (objExecuteRequest$default == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.GetTranscriptResponse");
                }
                List list2 = ((GetTranscriptResponse) objExecuteRequest$default).actions;
                if (list2 != null && (action = (GetTranscriptResponse.Action) CollectionsKt.firstOrNull(list2)) != null && (updateEngagementPanelAction = action.updateEngagementPanelAction) != null && (content = updateEngagementPanelAction.content) != null && (transcriptRenderer = content.transcriptRenderer) != null && (body = transcriptRenderer.body) != null && (transcriptBodyRenderer = body.transcriptBodyRenderer) != null && (list = transcriptBodyRenderer.cueGroups) != null) {
                    strJoinToString$default = CollectionsKt.joinToString$default(list, "\n", null, null, new YouTube$$ExternalSyntheticLambda2(b), 30);
                }
                strJoinToString$default.getClass();
                return strJoinToString$default;
                typeReferenceTypeOf = Reflection.typeOf(GetTranscriptResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) objExecuteRequest$default).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GetTranscriptResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$transcript$1.label = 2;
            objExecuteRequest$default = call.bodyNullable(typeInfo, youTube$transcript$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r5 == r4) goto L28;
     */
    /* JADX INFO: renamed from: uploadCustomThumbnailLink-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Serializable m1046uploadCustomThumbnailLink0E7RQCE(String str, byte[] bArr, ContinuationImpl continuationImpl) {
        YouTube$uploadCustomThumbnailLink$1 youTube$uploadCustomThumbnailLink$1;
        TypeReference typeReferenceTypeOf;
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        MusicEditablePlaylistDetailHeaderRenderer.Header header;
        MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        ThumbnailRenderer thumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        if (continuationImpl instanceof YouTube$uploadCustomThumbnailLink$1) {
            youTube$uploadCustomThumbnailLink$1 = (YouTube$uploadCustomThumbnailLink$1) continuationImpl;
            int i = youTube$uploadCustomThumbnailLink$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$uploadCustomThumbnailLink$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$uploadCustomThumbnailLink$1 = new YouTube$uploadCustomThumbnailLink$1(this, continuationImpl);
            }
        } else {
            youTube$uploadCustomThumbnailLink$1 = new YouTube$uploadCustomThumbnailLink$1(this, continuationImpl);
        }
        Object playlistThumbnail = youTube$uploadCustomThumbnailLink$1.result;
        int i2 = youTube$uploadCustomThumbnailLink$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(playlistThumbnail);
                    InnerTube innerTube2 = innerTube;
                    YouTubeClient.INSTANCE.getClass();
                    YouTubeClient youTubeClient = YouTubeClient.WEB_REMIX;
                    youTube$uploadCustomThumbnailLink$1.label = 1;
                    playlistThumbnail = innerTube2.setPlaylistThumbnail(youTubeClient, str, bArr, youTube$uploadCustomThumbnailLink$1);
                    if (playlistThumbnail == coroutineSingletons) {
                    }
                    return coroutineSingletons;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(playlistThumbnail);
                } else {
                    if (i2 != 2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(playlistThumbnail);
                }
                if (playlistThumbnail == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.metrolist.innertube.models.response.EditPlaylistResponse");
                }
                BrowseResponse.Header header2 = ((EditPlaylistResponse) playlistThumbnail).newHeader;
                if (header2 == null || (musicEditablePlaylistDetailHeaderRenderer = header2.musicEditablePlaylistDetailHeaderRenderer) == null || (header = musicEditablePlaylistDetailHeaderRenderer.header) == null || (musicResponsiveHeaderRenderer = header.musicResponsiveHeaderRenderer) == null || (thumbnailRenderer = musicResponsiveHeaderRenderer.thumbnail) == null || (musicThumbnailRenderer = thumbnailRenderer.musicThumbnailRenderer) == null) {
                    return null;
                }
                return musicThumbnailRenderer.getThumbnailUrl();
                typeReferenceTypeOf = Reflection.typeOf(EditPlaylistResponse.class);
            } catch (Throwable unused) {
                typeReferenceTypeOf = null;
            }
            HttpClientCall call = ((HttpResponse) playlistThumbnail).getCall();
            ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(EditPlaylistResponse.class);
            TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
            youTube$uploadCustomThumbnailLink$1.label = 2;
            playlistThumbnail = call.bodyNullable(typeInfo, youTube$uploadCustomThumbnailLink$1);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: uploadSong-yxL6bBk, reason: not valid java name */
    public final Serializable m1047uploadSongyxL6bBk(String str, long j, Function0 function0, Function1 function1, ContinuationImpl continuationImpl) {
        YouTube$uploadSong$1 youTube$uploadSong$1;
        if (continuationImpl instanceof YouTube$uploadSong$1) {
            youTube$uploadSong$1 = (YouTube$uploadSong$1) continuationImpl;
            int i = youTube$uploadSong$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$uploadSong$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$uploadSong$1 = new YouTube$uploadSong$1(this, continuationImpl);
            }
        } else {
            youTube$uploadSong$1 = new YouTube$uploadSong$1(this, continuationImpl);
        }
        Object objWithContext = youTube$uploadSong$1.result;
        int i2 = youTube$uploadSong$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                if (1 > j || j >= 314572800) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                if (function1 != null) {
                    function1.invoke(new Float(CropImageView.DEFAULT_ASPECT_RATIO));
                }
                if (function1 != null) {
                    function1.invoke(new Float(0.05f));
                }
                InnerTube innerTube2 = innerTube;
                YouTube$$ExternalSyntheticLambda3 youTube$$ExternalSyntheticLambda3 = new YouTube$$ExternalSyntheticLambda3(function0, j, function1);
                youTube$uploadSong$1.L$2 = function1;
                youTube$uploadSong$1.label = 1;
                innerTube2.getClass();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                objWithContext = AwaitKt.withContext(DefaultIoScheduler.INSTANCE, new InnerTube$uploadSong$2(innerTube2, str, j, youTube$$ExternalSyntheticLambda3, null), youTube$uploadSong$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                function1 = youTube$uploadSong$1.L$2;
                ResultKt.throwOnFailure(objWithContext);
            }
            boolean zAreEqual = Intrinsics.areEqual(((HttpResponse) objWithContext).getHeaders().get("X-Goog-Upload-Status"), "final");
            if (zAreEqual && function1 != null) {
                function1.invoke(new Float(1.0f));
            }
            return Boolean.valueOf(zAreEqual);
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: visitorData-IoAF18A, reason: not valid java name */
    public final Serializable m1048visitorDataIoAF18A(ContinuationImpl continuationImpl) {
        YouTube$visitorData$1 youTube$visitorData$1;
        if (continuationImpl instanceof YouTube$visitorData$1) {
            youTube$visitorData$1 = (YouTube$visitorData$1) continuationImpl;
            int i = youTube$visitorData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                youTube$visitorData$1.label = i - Integer.MIN_VALUE;
            } else {
                youTube$visitorData$1 = new YouTube$visitorData$1(this, continuationImpl);
            }
        } else {
            youTube$visitorData$1 = new YouTube$visitorData$1(this, continuationImpl);
        }
        Object objFetchFreshVisitorData = youTube$visitorData$1.result;
        int i2 = youTube$visitorData$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFetchFreshVisitorData);
                InnerTube innerTube2 = innerTube;
                youTube$visitorData$1.label = 1;
                com.metrolist.innertubex.InnerTube innerTube3 = innerTube2.innerTubeX;
                objFetchFreshVisitorData = innerTube3.fetchFreshVisitorData(innerTube3.sessionSnapshot(), true, youTube$visitorData$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFetchFreshVisitorData == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objFetchFreshVisitorData);
            }
            if (objFetchFreshVisitorData != null) {
                return (String) objFetchFreshVisitorData;
            }
            throw new IllegalStateException("YouTube did not return visitor data");
        } catch (Throwable th) {
            return new Result.Failure(th);
        }
    }
}
