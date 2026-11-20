package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.Album;
import com.metrolist.innertube.models.Artist;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.innertube.models.WatchEndpoint;
import com.metrolist.innertube.pages.PlaylistPage;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.constants.SongSortType;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.AlbumEntity;
import com.metrolist.music.db.entities.ArtistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.db.entities.SongEntity;
import com.metrolist.music.utils.DataStoreKt$get$2;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/OnlinePlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class OnlinePlaylistViewModel extends ViewModel {
    public final StateFlowImpl _error;
    public final StateFlowImpl _isLoading;
    public final StateFlowImpl _isLoadingMore;
    public final Context context;
    public String continuation;
    public final MusicDatabase database;
    public final ReadonlyStateFlow dbPlaylist;
    public final ReadonlyStateFlow error;
    public final ReadonlyStateFlow isLoading;
    public final ReadonlyStateFlow isLoadingMore;
    public final boolean isPodcastPlaylist;
    public final String normalizedPlaylistId;
    public final StateFlowImpl playlist;
    public final String playlistId;
    public final StateFlowImpl playlistSongs;
    public StandaloneCoroutine proactiveLoadJob;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlinePlaylistViewModel$fetchPodcastPlaylist$1, reason: invalid class name */
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
            return OnlinePlaylistViewModel.this.fetchPodcastPlaylist(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlinePlaylistViewModel$fetchRegularPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02171 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02171(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlinePlaylistViewModel.this.fetchRegularPlaylist(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.OnlinePlaylistViewModel$loadLocalSavedEpisodes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02181 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02181(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnlinePlaylistViewModel.this.loadLocalSavedEpisodes(this);
        }
    }

    public OnlinePlaylistViewModel(Context context, SavedStateHandle savedStateHandle, MusicDatabase musicDatabase) {
        savedStateHandle.getClass();
        musicDatabase.getClass();
        this.context = context;
        this.database = musicDatabase;
        Object obj = savedStateHandle.get("playlistId");
        obj.getClass();
        String str = (String) obj;
        this.playlistId = str;
        String strRemovePrefix = StringsKt.removePrefix(str, "VL");
        this.normalizedPlaylistId = strRemovePrefix;
        this.isPodcastPlaylist = strRemovePrefix.equals("RDPN") || strRemovePrefix.equals("SE");
        this.playlist = StateFlowKt.MutableStateFlow(null);
        this.playlistSongs = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this._isLoading = stateFlowImplMutableStateFlow;
        this.isLoading = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._error = stateFlowImplMutableStateFlow2;
        this.error = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isLoadingMore = stateFlowImplMutableStateFlow3;
        this.isLoadingMore = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        this.dbPlaylist = StateFlowKt.stateIn(musicDatabase.$$delegate_0.playlistByBrowseId(str), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, null);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new ArtistViewModel.AnonymousClass1(this, null, (byte) 9), 2);
    }

    public final List applySongFilters(List list) {
        boolean zBooleanValue = ((Boolean) UtilsKt.get(UtilsKt.getDataStore(this.context), PreferenceKeysKt.HideVideoSongsKey, Boolean.FALSE)).booleanValue();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((SongItem) obj).id)) {
                arrayList.add(obj);
            }
        }
        return HexFormatKt.filterVideoSongs(arrayList, zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0114  */
    /* JADX WARN: Code duplicated, block: B:51:0x0119  */
    /* JADX WARN: Code duplicated, block: B:68:0x019b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (r1 == r12) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPodcastPlaylist(ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        Object objM1004episodesForLaterIoAF18A;
        Object objM1021newEpisodesIoAF18A;
        String str;
        boolean z;
        List list;
        String str2;
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
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        Unit unit = Unit.INSTANCE;
        StateFlowImpl stateFlowImpl = this._error;
        StateFlowImpl stateFlowImpl2 = this.playlistSongs;
        StateFlowImpl stateFlowImpl3 = this.playlist;
        StateFlowImpl stateFlowImpl4 = this._isLoading;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String str3 = this.normalizedPlaylistId;
            if (Intrinsics.areEqual(str3, "RDPN")) {
                YouTube youTube = YouTube.INSTANCE;
                anonymousClass1.label = 1;
                objM1021newEpisodesIoAF18A = youTube.m1021newEpisodesIoAF18A(anonymousClass1);
            } else {
                if (!Intrinsics.areEqual(str3, "SE")) {
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, "Unknown podcast playlist");
                    Boolean bool = Boolean.FALSE;
                    stateFlowImpl4.getClass();
                    stateFlowImpl4.updateState(null, bool);
                    return unit;
                }
                Timber.Forest.getClass();
                ConnectionPool.d(new Object[0]);
                YouTube youTube2 = YouTube.INSTANCE;
                anonymousClass1.label = 2;
                objM1004episodesForLaterIoAF18A = youTube2.m1004episodesForLaterIoAF18A(anonymousClass1);
                if (objM1004episodesForLaterIoAF18A != obj2) {
                    z = objM1004episodesForLaterIoAF18A instanceof Result.Failure;
                    if (z) {
                        objM1004episodesForLaterIoAF18A = null;
                    }
                    list = (List) objM1004episodesForLaterIoAF18A;
                    if (list == null) {
                        list = EmptyList.INSTANCE;
                    }
                    ConnectionPool connectionPool = Timber.Forest;
                    list.size();
                    connectionPool.getClass();
                    ConnectionPool.d(new Object[0]);
                    if (z) {
                    }
                    ConnectionPool.d(new Object[0]);
                    anonymousClass1.label = 3;
                    if (loadLocalSavedEpisodes(anonymousClass1) != obj2) {
                        return unit;
                    }
                }
            }
            return obj2;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            objM1021newEpisodesIoAF18A = ((Result) obj).value;
            if (!(objM1021newEpisodesIoAF18A instanceof Result.Failure)) {
                List list2 = (List) objM1021newEpisodesIoAF18A;
                String str4 = list2.size() + " episodes";
                SongItem songItem = (SongItem) CollectionsKt.firstOrNull(list2);
                PlaylistItem playlistItem = new PlaylistItem(this.playlistId, "New Episodes", (Artist) null, str4, (songItem == null || (str = songItem.thumbnail) == null) ? "" : str, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
                stateFlowImpl3.getClass();
                stateFlowImpl3.updateState(null, playlistItem);
                List listApplySongFilters = applySongFilters(list2);
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, listApplySongFilters);
                Boolean bool2 = Boolean.FALSE;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, bool2);
            }
            Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1021newEpisodesIoAF18A);
            if (thM1866exceptionOrNullimpl != null) {
                String message = thM1866exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "Failed to load new episodes";
                }
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, message);
                Boolean bool3 = Boolean.FALSE;
                stateFlowImpl4.getClass();
                stateFlowImpl4.updateState(null, bool3);
                thM1866exceptionOrNullimpl.printStackTrace();
                return unit;
            }
            return unit;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        objM1004episodesForLaterIoAF18A = ((Result) obj).value;
        z = objM1004episodesForLaterIoAF18A instanceof Result.Failure;
        if (z) {
            objM1004episodesForLaterIoAF18A = null;
        }
        list = (List) objM1004episodesForLaterIoAF18A;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        ConnectionPool connectionPool2 = Timber.Forest;
        list.size();
        connectionPool2.getClass();
        ConnectionPool.d(new Object[0]);
        if (!z || list.isEmpty()) {
            ConnectionPool.d(new Object[0]);
            anonymousClass1.label = 3;
            if (loadLocalSavedEpisodes(anonymousClass1) != obj2) {
                return obj2;
            }
            return unit;
        }
        String str5 = list.size() + " episodes";
        SongItem songItem2 = (SongItem) CollectionsKt.firstOrNull(list);
        PlaylistItem playlistItem2 = new PlaylistItem(this.playlistId, "Episodes for Later", (Artist) null, str5, (songItem2 == null || (str2 = songItem2.thumbnail) == null) ? "" : str2, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
        stateFlowImpl3.getClass();
        stateFlowImpl3.updateState(null, playlistItem2);
        List listApplySongFilters2 = applySongFilters(list);
        stateFlowImpl2.getClass();
        stateFlowImpl2.updateState(null, listApplySongFilters2);
        Boolean bool4 = Boolean.FALSE;
        stateFlowImpl4.getClass();
        stateFlowImpl4.updateState(null, bool4);
        return unit;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchRegularPlaylist(ContinuationImpl continuationImpl) {
        C02171 c02171;
        Object objM1025playlistgIAlus;
        if (continuationImpl instanceof C02171) {
            c02171 = (C02171) continuationImpl;
            int i = c02171.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02171.label = i - Integer.MIN_VALUE;
            } else {
                c02171 = new C02171(continuationImpl);
            }
        } else {
            c02171 = new C02171(continuationImpl);
        }
        Object obj = c02171.result;
        int i2 = c02171.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02171.label = 1;
            objM1025playlistgIAlus = youTube.m1025playlistgIAlus(this.playlistId, c02171);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1025playlistgIAlus == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1025playlistgIAlus = ((Result) obj).value;
        }
        boolean z = objM1025playlistgIAlus instanceof Result.Failure;
        StateFlowImpl stateFlowImpl = this._isLoading;
        if (!z) {
            PlaylistPage playlistPage = (PlaylistPage) objM1025playlistgIAlus;
            PlaylistItem playlistItem = playlistPage.playlist;
            StateFlowImpl stateFlowImpl2 = this.playlist;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, playlistItem);
            List listApplySongFilters = applySongFilters(playlistPage.songs);
            StateFlowImpl stateFlowImpl3 = this.playlistSongs;
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, listApplySongFilters);
            this.continuation = playlistPage.songsContinuation;
            Boolean bool = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
            if (this.continuation != null) {
                StandaloneCoroutine standaloneCoroutine = this.proactiveLoadJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel(null);
                }
                CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                this.proactiveLoadJob = AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$2(this, null), 2);
            }
        }
        Throwable thM1866exceptionOrNullimpl = Result.m1866exceptionOrNullimpl(objM1025playlistgIAlus);
        if (thM1866exceptionOrNullimpl != null) {
            String message = thM1866exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Failed to load playlist";
            }
            StateFlowImpl stateFlowImpl4 = this._error;
            stateFlowImpl4.getClass();
            stateFlowImpl4.updateState(null, message);
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool2);
            thM1866exceptionOrNullimpl.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object loadLocalSavedEpisodes(ContinuationImpl continuationImpl) {
        C02181 c02181;
        String str;
        if (continuationImpl instanceof C02181) {
            c02181 = (C02181) continuationImpl;
            int i = c02181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02181.label = i - Integer.MIN_VALUE;
            } else {
                c02181 = new C02181(continuationImpl);
            }
        } else {
            c02181 = new C02181(continuationImpl);
        }
        Object objFirstOrNull = c02181.result;
        int i2 = c02181.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            MusicDatabase musicDatabase = this.database;
            musicDatabase.getClass();
            Flow flowSavedPodcastEpisodes = musicDatabase.$$delegate_0.savedPodcastEpisodes(SongSortType.CREATE_DATE, true);
            c02181.label = 1;
            objFirstOrNull = StateFlowKt.firstOrNull(flowSavedPodcastEpisodes, c02181);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objFirstOrNull == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objFirstOrNull);
        }
        List<Song> list = (List) objFirstOrNull;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        ConnectionPool connectionPool = Timber.Forest;
        list.size();
        connectionPool.getClass();
        ConnectionPool.d(new Object[0]);
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__IterablesKt.throwIndexOverflow();
                throw null;
            }
            ConnectionPool connectionPool2 = Timber.Forest;
            SongEntity songEntity = ((Song) obj).song;
            String str2 = songEntity.id;
            Objects.toString(songEntity.inLibrary);
            connectionPool2.getClass();
            ConnectionPool.d(new Object[0]);
            i3 = i4;
        }
        boolean zIsEmpty = list.isEmpty();
        StateFlowImpl stateFlowImpl = this._isLoading;
        if (zIsEmpty) {
            Timber.Forest.getClass();
            ConnectionPool.d(new Object[0]);
            StateFlowImpl stateFlowImpl2 = this._error;
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, "No saved episodes");
            Boolean bool = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool);
        } else {
            int i5 = 10;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (Song song : list) {
                SongEntity songEntity2 = song.song;
                String str3 = songEntity2.id;
                String str4 = songEntity2.title;
                List<ArtistEntity> list2 = song.artists;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, i5));
                for (ArtistEntity artistEntity : list2) {
                    arrayList2.add(new Artist(artistEntity.id, artistEntity.name));
                }
                AlbumEntity albumEntity = song.album;
                Album album = albumEntity != null ? new Album(albumEntity.id, albumEntity.title) : null;
                Integer num = new Integer(songEntity2.duration);
                String str5 = songEntity2.thumbnailUrl;
                arrayList.add(new SongItem(str3, str4, arrayList2, album, num, null, null, null, str5 == null ? "" : str5, songEntity2.explicit, null, null, null, null, null, false, null, 129248));
                i5 = 10;
            }
            ConnectionPool connectionPool3 = Timber.Forest;
            arrayList.size();
            connectionPool3.getClass();
            ConnectionPool.d(new Object[0]);
            String str6 = arrayList.size() + " episodes";
            SongItem songItem = (SongItem) CollectionsKt.firstOrNull((List) arrayList);
            PlaylistItem playlistItem = new PlaylistItem(this.playlistId, "Episodes for Later", (Artist) null, str6, (songItem == null || (str = songItem.thumbnail) == null) ? "" : str, (WatchEndpoint) null, (WatchEndpoint) null, (WatchEndpoint) null, false, (String) null, (String) null, 3840);
            StateFlowImpl stateFlowImpl3 = this.playlist;
            stateFlowImpl3.getClass();
            stateFlowImpl3.updateState(null, playlistItem);
            List listApplySongFilters = applySongFilters(arrayList);
            listApplySongFilters.size();
            ConnectionPool.d(new Object[0]);
            StateFlowImpl stateFlowImpl4 = this.playlistSongs;
            stateFlowImpl4.getClass();
            stateFlowImpl4.updateState(null, listApplySongFilters);
            Boolean bool2 = Boolean.FALSE;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, bool2);
            ConnectionPool.d(new Object[0]);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        StandaloneCoroutine standaloneCoroutine = this.proactiveLoadJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
    }
}
