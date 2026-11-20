package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.DatabaseDao;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.db.entities.Playlist;
import com.metrolist.music.db.entities.PlaylistEntity;
import com.metrolist.music.db.entities.Song;
import com.metrolist.music.ui.screens.OptionStats;
import com.metrolist.music.utils.UtilsKt;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.sync.MutexImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/StatsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class StatsViewModel extends ViewModel {
    public final Context context;
    public final MusicDatabase database;
    public final ReadonlyStateFlow filteredAlbums;
    public final ReadonlyStateFlow filteredArtists;
    public final ReadonlyStateFlow filteredSongs;
    public final ReadonlyStateFlow firstEvent;
    public final StateFlowImpl indexChips;
    public final ReadonlyStateFlow monthlyMostPlaylist;
    public final ReadonlyStateFlow mostPlayedAlbums;
    public final ReadonlyStateFlow mostPlayedArtists;
    public final ReadonlyStateFlow mostPlayedSongs;
    public final ReadonlyStateFlow mostPlayedSongsStats;
    public final MutexImpl periodicMostPlaylistSyncMutex;
    public final ReadonlyStateFlow recapPlaylists;
    public final SnapshotStateList selectedArtists;
    public final StateFlowImpl selectedOption;
    public final ReadonlyStateFlow weeklyMostPlaylist;

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.StatsViewModel$syncMostPlaylist$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C02191 extends ContinuationImpl {
        public String L$0;
        public String L$1;
        public LocalDateTime L$3;
        public List L$4;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C02191(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatsViewModel.this.syncMostPlaylist(null, null, null, false, null, this);
        }
    }

    public StatsViewModel(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.context = context;
        this.database = musicDatabase;
        this.periodicMostPlaylistSyncMutex = new MutexImpl();
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(OptionStats.CONTINUOUS);
        this.selectedOption = stateFlowImplMutableStateFlow;
        final byte b = 0;
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(0);
        this.indexChips = stateFlowImplMutableStateFlow2;
        Flow flowDistinctUntilChanged = StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 25));
        Continuation continuation = null;
        final byte b2 = 1;
        ChannelFlowTransformLatest channelFlowTransformLatestTransformLatest = FlowKt__MergeKt.transformLatest(StateFlowKt.combine(stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow2, StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 26)), new StatsViewModel$mostPlayedSongs$2(4, null, (byte) 1)), new StatsViewModel$special$$inlined$flatMapLatest$1(b, this, continuation));
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        EmptyList emptyList = EmptyList.INSTANCE;
        ReadonlyStateFlow readonlyStateFlowStateIn = StateFlowKt.stateIn(channelFlowTransformLatestTransformLatest, viewModelScope, startedLazily, emptyList);
        this.mostPlayedSongsStats = readonlyStateFlowStateIn;
        this.mostPlayedSongs = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.combine(stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow2, StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 27)), new StatsViewModel$mostPlayedSongs$2(4, null, (byte) 0)), new StatsViewModel$special$$inlined$flatMapLatest$1(b2, this, continuation)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        byte b3 = 3;
        final byte b4 = 2;
        ReadonlyStateFlow readonlyStateFlowStateIn2 = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow2, new StatsViewModel$mostPlayedAlbums$1(3, null, (byte) 1), (byte) 0), new StatsViewModel$special$$inlined$flatMapLatest$1(b4, this, continuation)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.mostPlayedArtists = readonlyStateFlowStateIn2;
        ReadonlyStateFlow readonlyStateFlowStateIn3 = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow, stateFlowImplMutableStateFlow2, new StatsViewModel$mostPlayedAlbums$1(3, null, (byte) 0), (byte) 0), new StatsViewModel$special$$inlined$flatMapLatest$1(b3, this, continuation)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.mostPlayedAlbums = readonlyStateFlowStateIn3;
        DatabaseDao databaseDao = musicDatabase.$$delegate_0;
        this.firstEvent = StateFlowKt.stateIn(databaseDao.firstEvent(), ViewModelKt.getViewModelScope(this), startedLazily, null);
        this.selectedArtists = new SnapshotStateList();
        this.filteredSongs = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(readonlyStateFlowStateIn, Stack.snapshotFlow(new Function0(this) { // from class: com.metrolist.music.viewmodels.StatsViewModel$$ExternalSyntheticLambda0
            public final /* synthetic */ StatsViewModel f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b5 = b;
                StatsViewModel statsViewModel = this.f$0;
                switch (b5) {
                    case 0:
                        SnapshotStateList snapshotStateList = statsViewModel.selectedArtists;
                        snapshotStateList.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList).list;
                    case 1:
                        SnapshotStateList snapshotStateList2 = statsViewModel.selectedArtists;
                        snapshotStateList2.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList2).list;
                    default:
                        SnapshotStateList snapshotStateList3 = statsViewModel.selectedArtists;
                        snapshotStateList3.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList3).list;
                }
            }
        }), new StatsViewModel$filteredSongs$2(b3, continuation, b), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.filteredArtists = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(readonlyStateFlowStateIn2, Stack.snapshotFlow(new Function0(this) { // from class: com.metrolist.music.viewmodels.StatsViewModel$$ExternalSyntheticLambda0
            public final /* synthetic */ StatsViewModel f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b5 = b2;
                StatsViewModel statsViewModel = this.f$0;
                switch (b5) {
                    case 0:
                        SnapshotStateList snapshotStateList = statsViewModel.selectedArtists;
                        snapshotStateList.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList).list;
                    case 1:
                        SnapshotStateList snapshotStateList2 = statsViewModel.selectedArtists;
                        snapshotStateList2.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList2).list;
                    default:
                        SnapshotStateList snapshotStateList3 = statsViewModel.selectedArtists;
                        snapshotStateList3.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList3).list;
                }
            }
        }), new StatsViewModel$filteredSongs$2(b3, continuation, b3), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.filteredAlbums = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(readonlyStateFlowStateIn3, Stack.snapshotFlow(new Function0(this) { // from class: com.metrolist.music.viewmodels.StatsViewModel$$ExternalSyntheticLambda0
            public final /* synthetic */ StatsViewModel f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b5 = b4;
                StatsViewModel statsViewModel = this.f$0;
                switch (b5) {
                    case 0:
                        SnapshotStateList snapshotStateList = statsViewModel.selectedArtists;
                        snapshotStateList.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList).list;
                    case 1:
                        SnapshotStateList snapshotStateList2 = statsViewModel.selectedArtists;
                        snapshotStateList2.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList2).list;
                    default:
                        SnapshotStateList snapshotStateList3 = statsViewModel.selectedArtists;
                        snapshotStateList3.getClass();
                        return SnapshotId_jvmKt.getReadable(snapshotStateList3).list;
                }
            }
        }), new StatsViewModel$filteredSongs$2(b3, continuation, b4), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        this.weeklyMostPlaylist = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(flowDistinctUntilChanged, new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 4, this, continuation)), ViewModelKt.getViewModelScope(this), startedLazily, null);
        this.monthlyMostPlaylist = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(flowDistinctUntilChanged, new StatsViewModel$special$$inlined$flatMapLatest$1((byte) 5, this, continuation)), ViewModelKt.getViewModelScope(this), startedLazily, null);
        this.recapPlaylists = StateFlowKt.stateIn(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(databaseDao.playlistsByNameAsc(), (byte) 28)), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(b, this, continuation), 3);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(b2, this, continuation), 3);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:48:0x0102  */
    /* JADX WARN: Code duplicated, block: B:50:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x0109  */
    /* JADX WARN: Code duplicated, block: B:53:0x010c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0126  */
    /* JADX WARN: Code duplicated, block: B:57:0x0144  */
    /* JADX WARN: Code duplicated, block: B:58:0x014d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x018a A[LOOP:0: B:65:0x0184->B:67:0x018a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object syncMostPlaylist(String str, String str2, LocalDateTime localDateTime, boolean z, LocalDateTime localDateTime2, ContinuationImpl continuationImpl) {
        C02191 c02191;
        boolean z2;
        String str3;
        String str4;
        LocalDateTime localDateTime3;
        boolean z3;
        List list;
        String str5;
        String str6;
        Playlist playlist;
        PlaylistEntity playlistEntity;
        String str7;
        PlaylistEntity playlistEntity2;
        LocalDateTime localDateTime4;
        LocalDateTime localDateTime5;
        Playlist playlist2;
        ArrayList arrayList;
        Iterator it;
        LocalDateTime localDateTime6 = localDateTime2;
        if (continuationImpl instanceof C02191) {
            c02191 = (C02191) continuationImpl;
            int i = c02191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02191.label = i - Integer.MIN_VALUE;
            } else {
                c02191 = new C02191(continuationImpl);
            }
        } else {
            c02191 = new C02191(continuationImpl);
        }
        Object objFirst = c02191.result;
        int i2 = c02191.label;
        Unit unit = Unit.INSTANCE;
        MusicDatabase musicDatabase = this.database;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow flowMostPlayedSongs$default = DatabaseDao.mostPlayedSongs$default(musicDatabase, localDateTime, -1, localDateTime6, 4);
            c02191.L$0 = str;
            c02191.L$1 = str2;
            c02191.L$3 = localDateTime6;
            z2 = z;
            c02191.Z$0 = z2;
            c02191.label = 1;
            objFirst = StateFlowKt.first(flowMostPlayedSongs$default, c02191);
            if (objFirst != coroutineSingletons) {
                str3 = str2;
                str4 = str;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            boolean z4 = c02191.Z$0;
            LocalDateTime localDateTime7 = c02191.L$3;
            str3 = c02191.L$1;
            str4 = c02191.L$0;
            ResultKt.throwOnFailure(objFirst);
            z2 = z4;
            localDateTime6 = localDateTime7;
        } else {
            if (i2 == 2) {
                z3 = c02191.Z$0;
                list = c02191.L$4;
                LocalDateTime localDateTime8 = c02191.L$3;
                String str8 = c02191.L$1;
                String str9 = c02191.L$0;
                ResultKt.throwOnFailure(objFirst);
                localDateTime3 = localDateTime8;
                str6 = str8;
                str5 = str9;
                playlist = (Playlist) objFirst;
                if (playlist != null) {
                    playlistEntity = playlist.playlist;
                } else {
                    playlistEntity = null;
                }
                if (playlistEntity != null) {
                    localDateTime4 = playlistEntity.bookmarkedAt;
                    if (localDateTime4 == null) {
                        localDateTime5 = localDateTime3;
                    } else {
                        localDateTime5 = localDateTime4;
                    }
                    playlistEntity2 = PlaylistEntity.copy$default(playlistEntity, str6, null, localDateTime3, true, localDateTime5, null, null, null, null, null, false, 16269);
                    str7 = str5;
                } else {
                    LocalDateTime localDateTime9 = localDateTime3;
                    String str10 = str6;
                    str7 = str5;
                    playlistEntity2 = new PlaylistEntity(str7, str10, null, localDateTime9, true, localDateTime9, null, null, null, null, null, 16268);
                }
                if (playlistEntity == null) {
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.insert(playlistEntity2);
                } else {
                    musicDatabase.getClass();
                    musicDatabase.$$delegate_0.update(playlistEntity2);
                }
                musicDatabase.clearPlaylist(str7);
                Flow flowPlaylist = musicDatabase.$$delegate_0.playlist(str7);
                c02191.L$0 = null;
                c02191.L$1 = null;
                c02191.L$3 = null;
                c02191.L$4 = list;
                c02191.Z$0 = z3;
                c02191.label = 3;
                objFirst = StateFlowKt.first(flowPlaylist, c02191);
                if (objFirst != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i2 != 3) {
                if (i2 == 4) {
                    ResultKt.throwOnFailure(objFirst);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z3 = c02191.Z$0;
            list = c02191.L$4;
            ResultKt.throwOnFailure(objFirst);
        }
        playlist2 = (Playlist) objFirst;
        if (playlist2 != null) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair(((Song) it.next()).song.id, null));
            }
            c02191.L$0 = null;
            c02191.L$1 = null;
            c02191.L$3 = null;
            c02191.L$4 = null;
            c02191.Z$0 = z3;
            c02191.label = 4;
            if (musicDatabase.addSongsToPlaylist(playlist2, arrayList, false, c02191) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return unit;
        List list2 = (List) objFirst;
        if (z2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                if (!((Song) obj).song.isVideo) {
                    arrayList2.add(obj);
                }
            }
            list2 = arrayList2;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (hashSet.add(((Song) obj2).song.id)) {
                arrayList3.add(obj2);
            }
        }
        Flow flowPlaylist2 = musicDatabase.playlist(str4);
        c02191.L$0 = str4;
        c02191.L$1 = str3;
        c02191.L$3 = localDateTime6;
        c02191.L$4 = arrayList3;
        c02191.Z$0 = z2;
        c02191.label = 2;
        objFirst = StateFlowKt.first(flowPlaylist2, c02191);
        if (objFirst != coroutineSingletons) {
            localDateTime3 = localDateTime6;
            z3 = z2;
            list = arrayList3;
            str5 = str4;
            str6 = str3;
            playlist = (Playlist) objFirst;
            if (playlist != null) {
                playlistEntity = playlist.playlist;
            } else {
                playlistEntity = null;
            }
            if (playlistEntity != null) {
                localDateTime4 = playlistEntity.bookmarkedAt;
                if (localDateTime4 == null) {
                    localDateTime5 = localDateTime3;
                } else {
                    localDateTime5 = localDateTime4;
                }
                playlistEntity2 = PlaylistEntity.copy$default(playlistEntity, str6, null, localDateTime3, true, localDateTime5, null, null, null, null, null, false, 16269);
                str7 = str5;
            } else {
                LocalDateTime localDateTime10 = localDateTime3;
                String str11 = str6;
                str7 = str5;
                playlistEntity2 = new PlaylistEntity(str7, str11, null, localDateTime10, true, localDateTime10, null, null, null, null, null, 16268);
            }
            if (playlistEntity == null) {
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.insert(playlistEntity2);
            } else {
                musicDatabase.getClass();
                musicDatabase.$$delegate_0.update(playlistEntity2);
            }
            musicDatabase.clearPlaylist(str7);
            Flow flowPlaylist3 = musicDatabase.$$delegate_0.playlist(str7);
            c02191.L$0 = null;
            c02191.L$1 = null;
            c02191.L$3 = null;
            c02191.L$4 = list;
            c02191.Z$0 = z3;
            c02191.label = 3;
            objFirst = StateFlowKt.first(flowPlaylist3, c02191);
            if (objFirst != coroutineSingletons) {
                playlist2 = (Playlist) objFirst;
                if (playlist2 != null) {
                    arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Pair(((Song) it.next()).song.id, null));
                    }
                    c02191.L$0 = null;
                    c02191.L$1 = null;
                    c02191.L$3 = null;
                    c02191.L$4 = null;
                    c02191.Z$0 = z3;
                    c02191.label = 4;
                    if (musicDatabase.addSongsToPlaylist(playlist2, arrayList, false, c02191) == coroutineSingletons) {
                    }
                }
                return unit;
            }
        }
        return coroutineSingletons;
    }

    /* JADX INFO: renamed from: com.metrolist.music.viewmodels.StatsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ StatsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(byte b, StatsViewModel statsViewModel, Continuation continuation) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = statsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            StatsViewModel statsViewModel = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1((byte) 0, statsViewModel, continuation);
                default:
                    return new AnonymousClass1((byte) 1, statsViewModel, continuation);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
                default:
                    ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
                    break;
            }
            return coroutineSingletons;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            StatsViewModel statsViewModel = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            byte b2 = 1;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z) {
                        if (!z) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlow = statsViewModel.mostPlayedArtists;
                    C00121 c00121 = new C00121(statsViewModel, (byte) 0);
                    this.label = true;
                    if (readonlyStateFlow.$$delegate_0.collect(c00121, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
                default:
                    boolean z2 = this.label;
                    if (z2) {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ReadonlyStateFlow readonlyStateFlow2 = statsViewModel.mostPlayedAlbums;
                    C00121 c00122 = new C00121(statsViewModel, b2);
                    this.label = true;
                    if (readonlyStateFlow2.$$delegate_0.collect(c00122, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                    return null;
            }
        }

        /* JADX INFO: renamed from: com.metrolist.music.viewmodels.StatsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        public final class C00121 implements FlowCollector {
            public final /* synthetic */ byte $r8$classId;
            public final /* synthetic */ StatsViewModel this$0;

            public /* synthetic */ C00121(StatsViewModel statsViewModel, byte b) {
                this.$r8$classId = b;
                this.this$0 = statsViewModel;
            }

            /* JADX WARN: Code duplicated, block: B:43:0x00d6  */
            /* JADX WARN: Code duplicated, block: B:63:0x015a  */
            /* JADX WARN: Code duplicated, block: B:65:0x0173  */
            /* JADX WARN: Code duplicated, block: B:68:0x0179  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008b -> B:27:0x008f). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0171 -> B:66:0x0175). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            public final java.lang.Object emit(java.util.List r12, kotlin.coroutines.Continuation r13) {
                /*
                    Method dump skipped, instruction units count: 398
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.metrolist.music.viewmodels.StatsViewModel.AnonymousClass1.C00121.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                switch (this.$r8$classId) {
                    case 0:
                        break;
                }
                return emit((List) obj, continuation);
            }
        }
    }
}
