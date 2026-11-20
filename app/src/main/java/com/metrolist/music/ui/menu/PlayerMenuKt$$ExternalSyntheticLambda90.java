package com.metrolist.music.ui.menu;

import com.metrolist.music.listentogether.ListenTogetherClient;
import com.metrolist.music.listentogether.ListenTogetherManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda90 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ListenTogetherManager f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda90(ListenTogetherManager listenTogetherManager, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = listenTogetherManager;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function0 function0 = this.f$1;
        ListenTogetherManager listenTogetherManager = this.f$0;
        switch (b) {
            case 0:
                ListenTogetherClient listenTogetherClient = listenTogetherManager.client;
                if (!listenTogetherClient.isInRoom() || listenTogetherManager.isHost()) {
                    Timber.Forest.tag("ListenTogetherManager");
                    listenTogetherClient.isInRoom();
                    listenTogetherManager.isHost();
                    ConnectionPool.d(new Object[0]);
                } else {
                    Timber.Forest.tag("ListenTogetherManager");
                    ConnectionPool.d(new Object[0]);
                    listenTogetherClient.requestSync();
                }
                function0.invoke();
                break;
            default:
                listenTogetherManager.leaveRoom();
                function0.invoke();
                break;
        }
        return unit;
    }
}
