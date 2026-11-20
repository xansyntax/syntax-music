package com.metrolist.music.ui.screens.equalizer;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.metrolist.music.eq.EqualizerService;
import com.metrolist.music.eq.data.EQProfileRepository;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/metrolist/music/ui/screens/equalizer/EQViewModel;", "Landroidx/lifecycle/ViewModel;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class EQViewModel extends ViewModel {
    public final StateFlowImpl _state;
    public final EQProfileRepository eqProfileRepository;
    public final EqualizerService equalizerService;
    public final ReadonlyStateFlow state;

    public EQViewModel(EQProfileRepository eQProfileRepository, EqualizerService equalizerService) {
        eQProfileRepository.getClass();
        equalizerService.getClass();
        this.eqProfileRepository = eQProfileRepository;
        this.equalizerService = equalizerService;
        Continuation continuation = null;
        StateFlowImpl stateFlowImplMutableStateFlow = StateFlowKt.MutableStateFlow(new EQState(null, null, null, EmptyList.INSTANCE));
        this._state = stateFlowImplMutableStateFlow;
        this.state = StateFlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EQViewModel$loadProfiles$1(this, continuation, (byte) 0), 3);
        AwaitKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EQViewModel$loadProfiles$1(this, continuation, (byte) 1), 3);
    }
}
