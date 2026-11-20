package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.SyncUtils;
import com.metrolist.music.utils.SyncUtils$special$$inlined$map$1;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/AutoPlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AutoPlaylistViewModel extends ViewModel {
    public final StateFlowImpl _isRefreshing;
    public final MusicDatabase database;
    public final ReadonlyStateFlow isRefreshing;
    public final ReadonlyStateFlow likedSongs;
    public final String playlist;
    public final SyncUtils syncUtils;

    public AutoPlaylistViewModel(Context context, SavedStateHandle savedStateHandle, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        musicDatabase.getClass();
        savedStateHandle.getClass();
        syncUtils.getClass();
        this.database = musicDatabase;
        this.syncUtils = syncUtils;
        Object obj = savedStateHandle.get("playlist");
        obj.getClass();
        this.playlist = (String) obj;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isRefreshing = stateFlowImplMutableStateFlow;
        this.isRefreshing = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        this.likedSongs = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new SyncUtils$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 29)), new AnchoredDraggableNode$drag$2((Continuation) null, (ViewModel) this, (byte) 1)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, EmptyList.INSTANCE);
    }
}
