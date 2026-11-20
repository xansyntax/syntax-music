package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppearanceSettingsKt$$ExternalSyntheticLambda50 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ float f$0;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ AppearanceSettingsKt$$ExternalSyntheticLambda50(float f, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = f;
        this.f$1 = parcelableSnapshotMutableFloatState;
        this.f$2 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$1;
        float f = this.f$0;
        switch (b) {
            case 0:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 1:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 2:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 3:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 4:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 5:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 6:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                parcelableSnapshotMutableFloatState.setFloatValue(f);
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
