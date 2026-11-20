package com.metrolist.music.viewmodels;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/viewmodels/ChartsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ChartsViewModel extends ViewModel {
    public final StateFlowImpl _chartsPage;
    public final StateFlowImpl _error;
    public final StateFlowImpl _isLoading;
    public final ReadonlyStateFlow chartsPage;
    public final ReadonlyStateFlow isLoading;

    public ChartsViewModel() {
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._chartsPage = stateFlowImplMutableStateFlow;
        this.chartsPage = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isLoading = stateFlowImplMutableStateFlow2;
        this.isLoading = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        this._error = StateFlowKt.MutableStateFlow(null);
    }
}
