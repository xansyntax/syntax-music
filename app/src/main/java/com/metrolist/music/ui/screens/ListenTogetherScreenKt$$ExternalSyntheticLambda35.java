package com.metrolist.music.ui.screens;

import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.ListenTogetherClient$blockUser$3;
import com.metrolist.music.listentogether.ListenTogetherManager;
import com.metrolist.music.listentogether.LogLevel;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherScreenKt$$ExternalSyntheticLambda35 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ListenTogetherManager f$0;

    public /* synthetic */ ListenTogetherScreenKt$$ExternalSyntheticLambda35(ListenTogetherManager listenTogetherManager, byte b) {
        this.$r8$classId = b;
        this.f$0 = listenTogetherManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ListenTogetherManager listenTogetherManager = this.f$0;
        String str = (String) obj;
        switch (b) {
            case 0:
                str.getClass();
                listenTogetherManager.client.approveJoin(str);
                break;
            case 1:
                str.getClass();
                listenTogetherManager.client.rejectJoin(str, "Rejected by host");
                break;
            case 2:
                str.getClass();
                if (listenTogetherManager.isHost()) {
                    listenTogetherManager.client.approveSuggestion(str);
                }
                break;
            case 3:
                str.getClass();
                listenTogetherManager.client.rejectSuggestion(str, "Rejected by host");
                break;
            default:
                str.getClass();
                ListenTogetherClient listenTogetherClient = listenTogetherManager.client;
                StateFlowImpl stateFlowImpl = listenTogetherClient._blockedUsernames;
                Set mutableSet = CollectionsKt.toMutableSet((Iterable) stateFlowImpl.getValue());
                mutableSet.remove(str);
                stateFlowImpl.updateState(null, mutableSet);
                AwaitKt.launch$default(listenTogetherClient.scope, null, null, new ListenTogetherClient$blockUser$3(listenTogetherClient, null, (byte) 7), 3);
                listenTogetherClient.log(LogLevel.INFO, "User unblocked", str);
                break;
        }
        return unit;
    }
}
