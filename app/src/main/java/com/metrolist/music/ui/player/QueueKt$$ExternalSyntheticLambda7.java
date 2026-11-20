package com.metrolist.music.ui.player;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.metrolist.music.utils.DataStoreKt$rememberPreference$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda7 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda7(MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$1 = mutableState;
        this.f$0 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()) == MathKt.roundToInt(((Number) mutableState.getValue()).floatValue()));
            case 1:
                mutableState.setValue(Boolean.FALSE);
                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() - 180.0f);
                return unit;
            case 2:
                mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
                parcelableSnapshotMutableFloatState.setFloatValue(parcelableSnapshotMutableFloatState.getFloatValue() - 180.0f);
                return unit;
            default:
                return Boolean.valueOf(MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue()) == MathKt.roundToInt(((Number) mutableState.getValue()).floatValue()));
        }
    }

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda7(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, DataStoreKt$rememberPreference$1$1 dataStoreKt$rememberPreference$1$1, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableFloatState;
        this.f$1 = dataStoreKt$rememberPreference$1$1;
    }
}
