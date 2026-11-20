package com.metrolist.music.ui.player;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda29 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableLongState f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda29(ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        long longValue;
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.f$0;
        switch (b) {
            case 0:
                longValue = parcelableSnapshotMutableLongState.getLongValue();
                break;
            default:
                longValue = parcelableSnapshotMutableLongState.getLongValue();
                break;
        }
        return Long.valueOf(longValue);
    }
}
