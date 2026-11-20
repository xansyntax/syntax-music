package com.metrolist.music.ui.screens.settings.integrations;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LastFMSettingsKt$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ LastFMSettingsKt$$ExternalSyntheticLambda6(int i, ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = i;
        this.f$1 = parcelableSnapshotMutableIntState;
        this.f$2 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$1;
        int i = this.f$0;
        switch (b) {
            case 0:
                parcelableSnapshotMutableIntState.setIntValue(i);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 1:
                parcelableSnapshotMutableIntState.setIntValue(i);
                mutableState.setValue(Boolean.FALSE);
                break;
            case 2:
                parcelableSnapshotMutableIntState.setIntValue(i);
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                parcelableSnapshotMutableIntState.setIntValue(i);
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
