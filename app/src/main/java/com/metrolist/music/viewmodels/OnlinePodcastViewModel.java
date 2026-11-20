package com.metrolist.music.viewmodels;

import androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.SyncUtils;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/OnlinePodcastViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class OnlinePodcastViewModel extends ViewModel {
    public final StateFlowImpl _error;
    public final StateFlowImpl _isLoading;
    public final MusicDatabase database;
    public final StateFlowImpl episodes;
    public final ReadonlyStateFlow error;
    public final ReadonlyStateFlow isLoading;
    public final ReadonlyStateFlow libraryPodcast;
    public final StateFlowImpl podcast;
    public final String podcastId;
    public final SyncUtils syncUtils;

    public OnlinePodcastViewModel(SavedStateHandle savedStateHandle, MusicDatabase musicDatabase, SyncUtils syncUtils) {
        savedStateHandle.getClass();
        musicDatabase.getClass();
        syncUtils.getClass();
        this.database = musicDatabase;
        this.syncUtils = syncUtils;
        Object obj = savedStateHandle.get("podcastId");
        obj.getClass();
        String str = (String) obj;
        this.podcastId = str;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.podcast = stateFlowImplMutableStateFlow;
        this.episodes = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this.libraryPodcast = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(stateFlowImplMutableStateFlow, new AnchoredDraggableNode$drag$2((Continuation) null, (ViewModel) this, (byte) 3)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, null);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this._isLoading = stateFlowImplMutableStateFlow2;
        this.isLoading = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._error = stateFlowImplMutableStateFlow3;
        this.error = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        ConnectionPool connectionPool = Timber.Forest;
        "ViewModel init with podcastId: ".concat(str);
        connectionPool.getClass();
        ConnectionPool.d(new Object[0]);
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new HazeSourceNode.AnonymousClass1(this, null, (byte) 5), 2);
    }
}
