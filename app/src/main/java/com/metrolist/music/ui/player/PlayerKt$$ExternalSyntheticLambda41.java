package com.metrolist.music.ui.player;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import com.google.common.math.IntMath;
import com.metrolist.music.playback.PlayerConnection;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda41 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerConnection f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda41(PlayerConnection playerConnection, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        PlayerConnection playerConnection = this.f$0;
        switch (b) {
            case 0:
                IntMath.toggleRepeatMode(playerConnection.getPlayerSafe());
                return unit;
            case 1:
                playerConnection.seekToNext();
                return unit;
            case 2:
                playerConnection.service.toggleLike();
                return unit;
            case 3:
                playerConnection.seekToNext();
                return unit;
            case 4:
                StateFlowImpl stateFlowImpl = playerConnection.service.automixItems;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, EmptyList.INSTANCE);
                playerConnection.getPlayerSafe().stop();
                playerConnection.getPlayerSafe().clearMediaItems();
                return unit;
            default:
                return new ParcelableSnapshotMutableLongState(playerConnection.getPlayerSafe().getCurrentPosition());
        }
    }
}
