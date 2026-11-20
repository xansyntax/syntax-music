package com.metrolist.music.ui.component;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$0;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda9(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$0;
        switch (b) {
            case 0:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 1:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 2:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                layoutCoordinates.getClass();
                parcelableSnapshotMutableIntState.setIntValue((int) (layoutCoordinates.mo603getSizeYbymL2g() >> 32));
                break;
            case 3:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 4:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 5:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 6:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 7:
                parcelableSnapshotMutableIntState.setIntValue(((Integer) obj).intValue());
                break;
            case 8:
                parcelableSnapshotMutableIntState.setIntValue((int) ((Float) obj).floatValue());
                break;
            default:
                parcelableSnapshotMutableIntState.setIntValue((int) ((Float) obj).floatValue());
                break;
        }
        return unit;
    }
}
