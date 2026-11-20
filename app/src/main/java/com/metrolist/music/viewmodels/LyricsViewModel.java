package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/viewmodels/LyricsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class LyricsViewModel extends ViewModel {
    public static final Regex timestampRegex = new Regex("\\[\\d{1,2}:\\d{2}");
    public final StateFlowImpl _lines;
    public final StateFlowImpl _mergedLyricsList;
    public final ReadonlyStateFlow lines;
    public final ReadonlyStateFlow mergedLyricsList;
    public StandaloneCoroutine processJob;

    public LyricsViewModel() {
        EmptyList emptyList = EmptyList.INSTANCE;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._lines = stateFlowImplMutableStateFlow;
        this.lines = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(emptyList);
        this._mergedLyricsList = stateFlowImplMutableStateFlow2;
        this.mergedLyricsList = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
    }
}
