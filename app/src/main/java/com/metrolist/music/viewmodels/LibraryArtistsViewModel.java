package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.DataStoreKt$get$1;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LibraryArtistsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LibraryArtistsViewModel extends ViewModel {
    public final StateFlowImpl _searchQuery;
    public final ReadonlyStateFlow allArtists;
    public final ReadonlyStateFlow filteredArtists;
    public final ReadonlyStateFlow searchQuery;
    public final SyncUtils syncUtils;

    public LibraryArtistsViewModel(Context context, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        musicDatabase.getClass();
        syncUtils.getClass();
        this.syncUtils = syncUtils;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._searchQuery = stateFlowImplMutableStateFlow;
        ReadonlyStateFlow readonlyStateFlowAsStateFlow = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.searchQuery = readonlyStateFlowAsStateFlow;
        Flow flowDebounce = StateFlowKt.debounce(stateFlowImplMutableStateFlow, 300L);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        StateFlowKt.stateIn(flowDebounce, viewModelScope, startedLazily, "");
        Continuation continuation = null;
        ChannelFlowTransformLatest channelFlowTransformLatestTransformLatest = FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 8)), new PlaylistsViewModel$special$$inlined$flatMapLatest$1(continuation, musicDatabase, (byte) 2));
        CloseableCoroutineScope viewModelScope2 = ViewModelKt.getViewModelScope(this);
        EmptyList emptyList = EmptyList.INSTANCE;
        ReadonlyStateFlow readonlyStateFlowStateIn = StateFlowKt.stateIn(channelFlowTransformLatestTransformLatest, viewModelScope2, startedLazily, emptyList);
        this.allArtists = readonlyStateFlowStateIn;
        this.filteredArtists = StateFlowKt.stateIn(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(readonlyStateFlowStateIn, readonlyStateFlowAsStateFlow, new ArtistViewModel$isChannelSubscribed$1(3, continuation, (byte) 1), (byte) 0), ViewModelKt.getViewModelScope(this), startedLazily, emptyList);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), DefaultIoScheduler.INSTANCE, null, new DataStoreKt$get$1((Object) this, (Object) musicDatabase, continuation, (byte) 27), 2);
    }
}
