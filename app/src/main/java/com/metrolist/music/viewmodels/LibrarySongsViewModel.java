package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.playback.DownloadUtil;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StartedLazily;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LibrarySongsViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LibrarySongsViewModel extends ViewModel {
    public final StateFlowImpl _searchQuery;
    public final ReadonlyStateFlow allSongs;
    public final ReadonlyStateFlow debouncedSearchQuery;
    public final ReadonlyStateFlow searchQuery;
    public final SyncUtils syncUtils;

    public LibrarySongsViewModel(Context context, MusicDatabase musicDatabase, DownloadUtil downloadUtil, SyncUtils syncUtils) {
        musicDatabase.getClass();
        downloadUtil.getClass();
        syncUtils.getClass();
        this.syncUtils = syncUtils;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._searchQuery = stateFlowImplMutableStateFlow;
        this.searchQuery = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        Flow flowDebounce = StateFlowKt.debounce(stateFlowImplMutableStateFlow, 300L);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        StartedLazily startedLazily = SharingStarted.Companion.Lazily;
        this.debouncedSearchQuery = StateFlowKt.stateIn(flowDebounce, viewModelScope, startedLazily, "");
        this.allSongs = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 17)), new PlaylistsViewModel$special$$inlined$flatMapLatest$1(null, musicDatabase, (byte) 7)), ViewModelKt.getViewModelScope(this), startedLazily, EmptyList.INSTANCE);
    }
}
