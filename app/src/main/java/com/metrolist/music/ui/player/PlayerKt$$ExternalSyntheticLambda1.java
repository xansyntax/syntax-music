package com.metrolist.music.ui.player;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$0;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda1(ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$0;
        switch (b) {
            case 0:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 1:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 2:
                parcelableSnapshotMutableFloatState.setFloatValue(UuidKt.coerceIn(parcelableSnapshotMutableFloatState.getFloatValue() + ((Float) obj).floatValue(), -300.0f, 300.0f));
                return unit;
            case 3:
                ((Density) obj).getClass();
                return new IntOffset(((long) MathKt.roundToInt(parcelableSnapshotMutableFloatState.getFloatValue())) << 32);
            case 4:
                parcelableSnapshotMutableFloatState.setFloatValue(((Number) ((Animatable) obj).getValue()).floatValue());
                return unit;
            case 5:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 6:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 7:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 8:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 9:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 10:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            case 11:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
            default:
                parcelableSnapshotMutableFloatState.setFloatValue(((Float) obj).floatValue());
                return unit;
        }
    }
}
