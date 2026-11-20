package com.metrolist.music.ui.player;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.metrolist.music.playback.CastConnectionHandler;
import com.metrolist.music.playback.PlayerConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MiniPlayerKt$$ExternalSyntheticLambda20 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ PlayerConnection f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ State f$5;

    public /* synthetic */ MiniPlayerKt$$ExternalSyntheticLambda20(boolean z, PlayerConnection playerConnection, boolean z2, CastConnectionHandler castConnectionHandler, int i, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = playerConnection;
        this.f$2 = z2;
        this.f$4 = i;
        this.f$5 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        State state = this.f$5;
        int i = this.f$4;
        boolean z = this.f$2;
        PlayerConnection playerConnection = this.f$1;
        boolean z2 = this.f$0;
        switch (b) {
            case 0:
                if (z2) {
                    playerConnection.toggleMute();
                } else if (z) {
                    ((Boolean) state.getValue()).booleanValue();
                } else if (i != 4) {
                    playerConnection.togglePlayPause();
                } else {
                    playerConnection.getPlayerSafe().seekTo(0, 0L, false);
                    playerConnection.getPlayerSafe().setPlayWhenReady(true);
                }
                break;
            default:
                if (z2) {
                    playerConnection.toggleMute();
                } else if (z) {
                    ((Boolean) state.getValue()).booleanValue();
                } else if (i != 4) {
                    playerConnection.togglePlayPause();
                } else {
                    playerConnection.getPlayerSafe().seekTo(0, 0L, false);
                    playerConnection.getPlayerSafe().setPlayWhenReady(true);
                }
                break;
        }
        return unit;
    }
}
