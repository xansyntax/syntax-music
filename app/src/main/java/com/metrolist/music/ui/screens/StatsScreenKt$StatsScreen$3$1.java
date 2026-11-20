package com.metrolist.music.ui.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.metrolist.music.viewmodels.StatsViewModel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsScreenKt$StatsScreen$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ State $indexChips$delegate;
    public final /* synthetic */ MutableState $prevIndexChips$delegate;
    public final /* synthetic */ MutableState $prevOptionOrdinal$delegate;
    public final /* synthetic */ State $selectedOption$delegate;
    public final /* synthetic */ MutableState $showTimeTransfer$delegate;
    public final /* synthetic */ StatsViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsScreenKt$StatsScreen$3$1(StatsViewModel statsViewModel, MutableState mutableState, MutableState mutableState2, State state, MutableState mutableState3, State state2, Continuation continuation) {
        super(2, continuation);
        this.$viewModel = statsViewModel;
        this.$showTimeTransfer$delegate = mutableState;
        this.$prevOptionOrdinal$delegate = mutableState2;
        this.$selectedOption$delegate = state;
        this.$prevIndexChips$delegate = mutableState3;
        this.$indexChips$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatsScreenKt$StatsScreen$3$1(this.$viewModel, this.$showTimeTransfer$delegate, this.$prevOptionOrdinal$delegate, this.$selectedOption$delegate, this.$prevIndexChips$delegate, this.$indexChips$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        StatsScreenKt$StatsScreen$3$1 statsScreenKt$StatsScreen$3$1 = (StatsScreenKt$StatsScreen$3$1) create((CoroutineScope) obj, (Continuation) obj2);
        Unit unit = Unit.INSTANCE;
        statsScreenKt$StatsScreen$3$1.invokeSuspend(unit);
        return unit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResultKt.throwOnFailure(obj);
        if (((Boolean) this.$showTimeTransfer$delegate.getValue()).booleanValue()) {
            MutableState mutableState = this.$prevOptionOrdinal$delegate;
            if (((OptionStats) mutableState.getValue()) == null) {
                mutableState.setValue((OptionStats) this.$selectedOption$delegate.getValue());
            }
            MutableState mutableState2 = this.$prevIndexChips$delegate;
            if (((Integer) mutableState2.getValue()) == null) {
                mutableState2.setValue(new Integer(((Number) this.$indexChips$delegate.getValue()).intValue()));
            }
            StatsViewModel statsViewModel = this.$viewModel;
            StateFlowImpl stateFlowImpl = statsViewModel.selectedOption;
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, OptionStats.CONTINUOUS);
            StateFlowImpl stateFlowImpl2 = statsViewModel.indexChips;
            Integer num = new Integer(5);
            stateFlowImpl2.getClass();
            stateFlowImpl2.updateState(null, num);
        }
        return Unit.INSTANCE;
    }
}
