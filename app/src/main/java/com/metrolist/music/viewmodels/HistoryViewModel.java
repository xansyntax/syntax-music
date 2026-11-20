package com.metrolist.music.viewmodels;

import android.content.Context;
import androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.viewmodel.internal.CloseableCoroutineScope;
import com.metrolist.music.constants.HistorySource;
import com.metrolist.music.db.MusicDatabase;
import com.metrolist.music.utils.UtilsKt;
import dev.chrisbanes.haze.HazeSourceNode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import kotlin.Metadata;
import kotlin.collections.EmptyMap;
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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/viewmodels/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class HistoryViewModel extends ViewModel {
    public final MusicDatabase database;
    public final ReadonlyStateFlow events;
    public final StateFlowImpl historyPage;
    public final StateFlowImpl historySource;
    public final LocalDate lastMonday;
    public final LocalDate thisMonday;
    public final LocalDate today;

    public HistoryViewModel(Context context, MusicDatabase musicDatabase) {
        musicDatabase.getClass();
        this.database = musicDatabase;
        this.historySource = StateFlowKt.MutableStateFlow(HistorySource.LOCAL);
        LocalDate localDateNow = LocalDate.now();
        this.today = localDateNow;
        LocalDate localDateWith = localDateNow.with((TemporalAdjuster) DayOfWeek.MONDAY);
        this.thisMonday = localDateWith;
        this.lastMonday = localDateWith.minusDays(7L);
        this.historyPage = StateFlowKt.MutableStateFlow(null);
        this.events = StateFlowKt.stateIn(FlowKt__MergeKt.transformLatest(StateFlowKt.distinctUntilChanged(new HomeViewModel$special$$inlined$map$1(UtilsKt.getDataStore(context).getData(), (byte) 3)), new AnchoredDraggableNode$drag$2((Continuation) null, (ViewModel) this, (byte) 2)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.Lazily, EmptyMap.INSTANCE);
        fetchRemoteHistory();
    }

    public final void fetchRemoteHistory() {
        CloseableCoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        AwaitKt.launch$default(viewModelScope, DefaultIoScheduler.INSTANCE, null, new HazeSourceNode.AnonymousClass1(this, null, (byte) 1), 2);
    }
}
