package com.metrolist.music.ui.screens.equalizer;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EqScreenKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ EQViewModel f$0;

    public /* synthetic */ EqScreenKt$$ExternalSyntheticLambda2(EQViewModel eQViewModel, byte b) {
        this.$r8$classId = b;
        this.f$0 = eQViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object value;
        Object value2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        EQViewModel eQViewModel = this.f$0;
        switch (b) {
            case 0:
                StateFlowImpl stateFlowImpl = eQViewModel._state;
                do {
                    value = stateFlowImpl.getValue();
                } while (!stateFlowImpl.compareAndSet(value, EQState.copy$default((EQState) value, null, null, null, null, 7)));
                break;
            default:
                StateFlowImpl stateFlowImpl2 = eQViewModel._state;
                do {
                    value2 = stateFlowImpl2.getValue();
                } while (!stateFlowImpl2.compareAndSet(value2, EQState.copy$default((EQState) value2, null, null, null, null, 7)));
                break;
        }
        return unit;
    }
}
