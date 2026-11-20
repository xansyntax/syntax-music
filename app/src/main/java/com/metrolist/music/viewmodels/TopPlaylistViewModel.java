package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.datastore.core.DataStoreImpl$data$1$5;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.constants.MyTopFilter;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.UtilsKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/TopPlaylistViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TopPlaylistViewModel extends ViewModel {
    public final String top;
    public final StateFlowImpl topPeriod;
    public final ReadonlyStateFlow topSongs;

    public TopPlaylistViewModel(Context context, SavedStateHandle savedStateHandle, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        savedStateHandle.getClass();
        Object obj = savedStateHandle.get("top");
        obj.getClass();
        this.top = (String) obj;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(MyTopFilter.ALL_TIME);
        this.topPeriod = stateFlowImplMutableStateFlow;
        this.topSongs = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(stateFlowImplMutableStateFlow, StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 29)), new DataStoreImpl$data$1$5(3, null, (byte) 3), (byte) 0), new ArtistSongsViewModel$special$$inlined$flatMapLatest$1(null, musicDatabase, this, (byte) 1)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, EmptyList.INSTANCE);
    }
}
