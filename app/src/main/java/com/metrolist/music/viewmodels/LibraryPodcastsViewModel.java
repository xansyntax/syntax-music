package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.ArtistItem;
import com.metrolist.innertube.models.PlaylistItem;
import com.metrolist.innertube.pages.LibraryPage;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.PodcastRefreshTrigger;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okhttp3.ConnectionPool;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LibraryPodcastsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LibraryPodcastsViewModel extends ViewModel {
    public final StateFlowImpl _apiPodcastChannels;
    public final StateFlowImpl _rdpnPlaylist;
    public final StateFlowImpl _sePlaylist;
    public final MusicDatabase database;
    public final ReadonlyStateFlow downloadedEpisodes;
    public final ReadonlyStateFlow podcastChannels;
    public final ReadonlyStateFlow rdpnPlaylist;
    public final ReadonlyStateFlow savedEpisodes;
    public final ReadonlyStateFlow sePlaylist;
    public final ReadonlyStateFlow subscribedChannels;
    public final SyncUtils syncUtils;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryPodcastsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ LibraryPodcastsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(byte b, LibraryPodcastsViewModel libraryPodcastsViewModel, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = libraryPodcastsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            LibraryPodcastsViewModel libraryPodcastsViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1((byte) 0, libraryPodcastsViewModel, continuation);
                case 1:
                    return new AnonymousClass1((byte) 1, libraryPodcastsViewModel, continuation);
                case 2:
                    return new AnonymousClass1((byte) 2, libraryPodcastsViewModel, continuation);
                case 3:
                    return new AnonymousClass1((byte) 3, libraryPodcastsViewModel, continuation);
                case 4:
                    return new AnonymousClass1((byte) 4, libraryPodcastsViewModel, continuation);
                default:
                    return new AnonymousClass1((byte) 5, libraryPodcastsViewModel, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 1:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 2:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 3:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                case 4:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    return CoroutineSingletons.COROUTINE_SUSPENDED;
                default:
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            LibraryPodcastsViewModel libraryPodcastsViewModel = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return libraryPodcastsViewModel.fetchSePlaylist(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 1:
                    boolean z2 = this.label;
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return libraryPodcastsViewModel.fetchPodcastChannels(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z2) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 2:
                    boolean z3 = this.label;
                    if (!z3) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return libraryPodcastsViewModel.fetchRdpnPlaylist(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 3:
                    boolean z4 = this.label;
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        SyncUtils syncUtils = libraryPodcastsViewModel.syncUtils;
                        this.label = true;
                        return syncUtils.syncPodcastSubscriptionsSuspend(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z4) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                case 4:
                    boolean z5 = this.label;
                    if (z5) {
                        if (!z5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ReadonlySharedFlow readonlySharedFlow = PodcastRefreshTrigger.refreshFlow;
                    ArtistViewModel.AnonymousClass1.AnonymousClass2 anonymousClass2 = new ArtistViewModel.AnonymousClass1.AnonymousClass2((byte) 10, libraryPodcastsViewModel);
                    this.label = true;
                    if (readonlySharedFlow.$$delegate_0.collect(anonymousClass2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                default:
                    boolean z6 = this.label;
                    if (!z6) {
                        ResultKt.throwOnFailure(obj);
                        this.label = true;
                        return libraryPodcastsViewModel.fetchPodcastChannels(this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z6) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryPodcastsViewModel$fetchPodcastChannels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02131 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02131(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibraryPodcastsViewModel.this.fetchPodcastChannels(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryPodcastsViewModel$fetchRdpnPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02141 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02141(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibraryPodcastsViewModel.this.fetchRdpnPlaylist(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryPodcastsViewModel$fetchSePlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02151 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02151(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibraryPodcastsViewModel.this.fetchSePlaylist(this);
        }
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.LibraryPodcastsViewModel$refreshAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02161 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public C02161(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LibraryPodcastsViewModel.this.refreshAll(this);
        }
    }

    public LibraryPodcastsViewModel(Context context, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        musicDatabase.getClass();
        syncUtils.getClass();
        this.database = musicDatabase;
        this.syncUtils = syncUtils;
        DatabaseDao databaseDao = musicDatabase.$$delegate_0;
        Flow flowSubscribedPodcasts = databaseDao.subscribedPodcasts();
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Eagerly;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.subscribedChannels = StateFlowKt.stateIn(flowSubscribedPodcasts, viewModelScope, startedLazily, emptyList);
        Continuation continuation = null;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._sePlaylist = stateFlowImplMutableStateFlow;
        this.sePlaylist = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._rdpnPlaylist = stateFlowImplMutableStateFlow2;
        this.rdpnPlaylist = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(emptyList);
        this._apiPodcastChannels = stateFlowImplMutableStateFlow3;
        this.podcastChannels = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow3, databaseDao.bookmarkedPodcastChannels(), new StatsViewModel$filteredSongs$2(3, null, (byte) 1), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.downloadedEpisodes = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 15)), new LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1((byte) 0, this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, emptyList);
        this.savedEpisodes = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 16)), new LibraryPodcastsViewModel$special$$inlined$flatMapLatest$1((byte) 1, this, null)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
        AwaitKt.launch$default(viewModelScope2, defaultIoScheduler, null, new AnonymousClass1((byte) 0, this, continuation), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1((byte) 1, this, continuation), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1((byte) 2, this, continuation), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1((byte) 3, this, continuation), 2);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), defaultIoScheduler, null, new AnonymousClass1((byte) 4, this, continuation), 2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchPodcastChannels(ContinuationImpl continuationImpl) {
        C02131 c02131;
        Object objM1013libraryPodcastChannelsIoAF18A;
        if (continuationImpl instanceof C02131) {
            c02131 = (C02131) continuationImpl;
            int i = c02131.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02131.label = i - Integer.MIN_VALUE;
            } else {
                c02131 = new C02131(continuationImpl);
            }
        } else {
            c02131 = new C02131(continuationImpl);
        }
        Object obj = c02131.result;
        int i2 = c02131.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02131.label = 1;
            objM1013libraryPodcastChannelsIoAF18A = youTube.m1013libraryPodcastChannelsIoAF18A(c02131);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1013libraryPodcastChannelsIoAF18A == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1013libraryPodcastChannelsIoAF18A = ((Result) obj).value;
        }
        if (!(objM1013libraryPodcastChannelsIoAF18A instanceof Result.Failure)) {
            List list = ((LibraryPage) objM1013libraryPodcastChannelsIoAF18A).items;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof ArtistItem) {
                    arrayList.add(obj2);
                }
            }
            StateFlowImpl stateFlowImpl = this._apiPodcastChannels;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, arrayList);
            ConnectionPool connectionPool = Timber.Forest;
            arrayList.size();
            connectionPool.getClass();
            ConnectionPool.d(new Object[0]);
        }
        if (Result.m1866exceptionOrNullimpl(objM1013libraryPodcastChannelsIoAF18A) != null) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchRdpnPlaylist(ContinuationImpl continuationImpl) {
        C02141 c02141;
        Object objM1022newEpisodesPlaylistInfoIoAF18A;
        if (continuationImpl instanceof C02141) {
            c02141 = (C02141) continuationImpl;
            int i = c02141.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02141.label = i - Integer.MIN_VALUE;
            } else {
                c02141 = new C02141(continuationImpl);
            }
        } else {
            c02141 = new C02141(continuationImpl);
        }
        Object obj = c02141.result;
        int i2 = c02141.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02141.label = 1;
            objM1022newEpisodesPlaylistInfoIoAF18A = youTube.m1022newEpisodesPlaylistInfoIoAF18A(c02141);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1022newEpisodesPlaylistInfoIoAF18A == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1022newEpisodesPlaylistInfoIoAF18A = ((Result) obj).value;
        }
        if (!(objM1022newEpisodesPlaylistInfoIoAF18A instanceof Result.Failure)) {
            PlaylistItem playlistItem = (PlaylistItem) objM1022newEpisodesPlaylistInfoIoAF18A;
            this._rdpnPlaylist.setValue(playlistItem);
            ConnectionPool connectionPool = Timber.Forest;
            String str = playlistItem.title;
            connectionPool.getClass();
            ConnectionPool.d(new Object[0]);
        }
        if (Result.m1866exceptionOrNullimpl(objM1022newEpisodesPlaylistInfoIoAF18A) != null) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r9 == r5) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchSePlaylist(ContinuationImpl continuationImpl) {
        C02151 c02151;
        Object objM1011library0E7RQCE;
        Object objCompletedPlaylist;
        if (continuationImpl instanceof C02151) {
            c02151 = (C02151) continuationImpl;
            int i = c02151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02151.label = i - Integer.MIN_VALUE;
            } else {
                c02151 = new C02151(continuationImpl);
            }
        } else {
            c02151 = new C02151(continuationImpl);
        }
        Object obj = c02151.result;
        int i2 = c02151.label;
        Object obj2 = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            c02151.label = 1;
            objM1011library0E7RQCE = YouTube.INSTANCE.m1011library0E7RQCE("FEmusic_liked_playlists", 0, c02151);
            if (objM1011library0E7RQCE != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            objM1011library0E7RQCE = ((Result) obj).value;
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objCompletedPlaylist = ((Result) obj).value;
        }
        if (!(objCompletedPlaylist instanceof Result.Failure)) {
            List list = ((LibraryPage) objCompletedPlaylist).items;
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (obj3 instanceof PlaylistItem) {
                    arrayList.add(obj3);
                }
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj4 = arrayList.get(i3);
                i3++;
                if (Intrinsics.areEqual(((PlaylistItem) obj4).id, "SE")) {
                    obj2 = obj4;
                    break;
                }
            }
            this._sePlaylist.setValue(obj2);
        }
        if (Result.m1866exceptionOrNullimpl(objCompletedPlaylist) != null) {
            Timber.Forest.getClass();
            ConnectionPool.e$1(new Object[0]);
        }
        return Unit.INSTANCE;
        c02151.label = 2;
        objCompletedPlaylist = StringsKt__IndentKt.completedPlaylist(objM1011library0E7RQCE, c02151);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
    
        if (r2.syncEpisodesForLaterSuspend(r0) == r8) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshAll(ContinuationImpl continuationImpl) {
        C02161 c02161;
        if (continuationImpl instanceof C02161) {
            c02161 = (C02161) continuationImpl;
            int i = c02161.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02161.label = i - Integer.MIN_VALUE;
            } else {
                c02161 = new C02161(continuationImpl);
            }
        } else {
            c02161 = new C02161(continuationImpl);
        }
        Object obj = c02161.result;
        int i2 = c02161.label;
        SyncUtils syncUtils = this.syncUtils;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c02161.label = 1;
            if (fetchSePlaylist(c02161) != obj2) {
            }
            return obj2;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 == 2) {
                ResultKt.throwOnFailure(obj);
                c02161.label = 3;
                if (fetchRdpnPlaylist(c02161) != obj2) {
                    c02161.label = 4;
                    if (syncUtils.syncPodcastSubscriptionsSuspend(c02161) != obj2) {
                        c02161.label = 5;
                    }
                }
                return obj2;
            }
            if (i2 == 3) {
                ResultKt.throwOnFailure(obj);
                c02161.label = 4;
                if (syncUtils.syncPodcastSubscriptionsSuspend(c02161) != obj2) {
                    c02161.label = 5;
                }
                return obj2;
            }
            if (i2 == 4) {
                ResultKt.throwOnFailure(obj);
                c02161.label = 5;
            } else {
                if (i2 != 5) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        return Unit.INSTANCE;
        c02161.label = 2;
        if (fetchPodcastChannels(c02161) != obj2) {
            c02161.label = 3;
            if (fetchRdpnPlaylist(c02161) != obj2) {
                c02161.label = 4;
                if (syncUtils.syncPodcastSubscriptionsSuspend(c02161) != obj2) {
                    c02161.label = 5;
                }
            }
        }
        return obj2;
    }
}
