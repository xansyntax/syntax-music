package com.metrolist.music.ui.player;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.SleepTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda15 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PlayerConnection f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$2;
    public final /* synthetic */ MutableState f$3;
    public final /* synthetic */ MutableState f$4;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda15(PlayerConnection playerConnection, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = playerConnection;
        this.f$1 = mutableState;
        this.f$2 = parcelableSnapshotMutableFloatState;
        this.f$3 = mutableState2;
        this.f$4 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$4;
        MutableState mutableState2 = this.f$3;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$2;
        MutableState mutableState3 = this.f$1;
        PlayerConnection playerConnection = this.f$0;
        switch (b) {
            case 0:
                mutableState3.setValue(Boolean.FALSE);
                SleepTimer sleepTimer = playerConnection.service.sleepTimer;
                if (sleepTimer != null) {
                    sleepTimer.start(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()), ((Boolean) mutableState2.getValue()).booleanValue(), ((Boolean) mutableState.getValue()).booleanValue());
                }
                break;
            default:
                mutableState3.setValue(Boolean.FALSE);
                SleepTimer sleepTimer2 = playerConnection.service.sleepTimer;
                if (sleepTimer2 != null) {
                    sleepTimer2.start(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()), ((Boolean) mutableState2.getValue()).booleanValue(), ((Boolean) mutableState.getValue()).booleanValue());
                }
                break;
        }
        return unit;
    }
}
