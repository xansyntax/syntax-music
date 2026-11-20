package com.metrolist.music.ui.player;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressState {
    public final ParcelableSnapshotMutableLongState durationState;
    public final ParcelableSnapshotMutableLongState positionState;

    public ProgressState(ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2) {
        parcelableSnapshotMutableLongState.getClass();
        parcelableSnapshotMutableLongState2.getClass();
        this.positionState = parcelableSnapshotMutableLongState;
        this.durationState = parcelableSnapshotMutableLongState2;
    }

    public final float getProgress() {
        long longValue = this.durationState.getLongValue();
        return longValue > 0 ? UuidKt.coerceIn(this.positionState.getLongValue() / longValue, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : CropImageView.DEFAULT_ASPECT_RATIO;
    }
}
