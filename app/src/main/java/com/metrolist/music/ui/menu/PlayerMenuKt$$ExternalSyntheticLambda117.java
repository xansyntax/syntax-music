package com.metrolist.music.ui.menu;

import com.metrolist.music.listentogether.ListenTogetherManager;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda117 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ListenTogetherManager f$0;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda117(ListenTogetherManager listenTogetherManager, byte b) {
        this.$r8$classId = b;
        this.f$0 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ListenTogetherManager listenTogetherManager = this.f$0;
        switch (b) {
            case 0:
                listenTogetherManager.connect();
                return unit;
            case 1:
                return Boolean.valueOf(listenTogetherManager.client.isInRoom() && !listenTogetherManager.isHost());
            case 2:
                listenTogetherManager.disconnect();
                return unit;
            case 3:
                listenTogetherManager.forceReconnect();
                return unit;
            case 4:
                listenTogetherManager.connect();
                return unit;
            case 5:
                listenTogetherManager.disconnect();
                return unit;
            case 6:
                listenTogetherManager.forceReconnect();
                return unit;
            case 7:
                listenTogetherManager.leaveRoom();
                return unit;
            default:
                StateFlowImpl stateFlowImpl = listenTogetherManager.client._logs;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, EmptyList.INSTANCE);
                return unit;
        }
    }
}
