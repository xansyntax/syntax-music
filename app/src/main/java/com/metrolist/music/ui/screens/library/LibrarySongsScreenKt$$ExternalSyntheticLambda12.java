package com.metrolist.music.ui.screens.library;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibrarySongsScreenKt$$ExternalSyntheticLambda12 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$0;

    public /* synthetic */ LibrarySongsScreenKt$$ExternalSyntheticLambda12(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        float floatValue;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$0;
        switch (b) {
            case 0:
                floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                break;
            case 1:
                floatValue = parcelableSnapshotMutableFloatState.getFloatValue();
                break;
            case 2:
                parcelableSnapshotMutableFloatState.setFloatValue(1.3f);
                return unit;
            case 3:
                parcelableSnapshotMutableFloatState.setFloatValue(24.0f);
                return unit;
            case 4:
                parcelableSnapshotMutableFloatState.setFloatValue(0.73f);
                return unit;
            default:
                parcelableSnapshotMutableFloatState.setFloatValue(0.5f);
                return unit;
        }
        return Float.valueOf(floatValue);
    }
}
