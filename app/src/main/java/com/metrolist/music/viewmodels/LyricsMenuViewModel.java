package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import coil3.ImageLoader$Builder;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.NetworkConnectivityObserver;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/LyricsMenuViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LyricsMenuViewModel extends ViewModel {
    public final StateFlowImpl _isNetworkAvailable;
    public final MusicDatabase database;
    public final StateFlowImpl isLoading;
    public final ReadonlyStateFlow isNetworkAvailable;
    public StandaloneCoroutine job;
    public final ImageLoader$Builder lyricsHelper;
    public final NetworkConnectivityObserver networkConnectivity;
    public final StateFlowImpl results;

    public LyricsMenuViewModel(ImageLoader$Builder imageLoader$Builder, MusicDatabase musicDatabase, NetworkConnectivityObserver networkConnectivityObserver) {
        boolean zIsCurrentlyConnected;
        musicDatabase.getClass();
        networkConnectivityObserver.getClass();
        this.lyricsHelper = imageLoader$Builder;
        this.database = musicDatabase;
        this.networkConnectivity = networkConnectivityObserver;
        this.results = StateFlowKt.MutableStateFlow(EmptyList.INSTANCE);
        Boolean bool = Boolean.FALSE;
        this.isLoading = StateFlowKt.MutableStateFlow(bool);
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this._isNetworkAvailable = stateFlowImplMutableStateFlow;
        this.isNetworkAvailable = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HazeSourceNode.AnonymousClass1(this, null, (byte) 3), 3);
        try {
            zIsCurrentlyConnected = networkConnectivityObserver.isCurrentlyConnected();
        } catch (Exception unused) {
            zIsCurrentlyConnected = true;
        }
        stateFlowImplMutableStateFlow.updateState(null, Boolean.valueOf(zIsCurrentlyConnected));
    }
}
