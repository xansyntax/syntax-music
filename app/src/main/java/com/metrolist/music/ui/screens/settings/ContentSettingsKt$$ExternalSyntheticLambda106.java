package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContentSettingsKt$$ExternalSyntheticLambda106 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ ContentSettingsKt$$ExternalSyntheticLambda106(Function1 function1, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = parcelableSnapshotMutableFloatState;
        this.f$2 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$1;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke(String.valueOf((int) parcelableSnapshotMutableFloatState.getFloatValue()));
                mutableState.setValue(Boolean.FALSE);
                break;
            case 1:
                function1.invoke(Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue()));
                mutableState.setValue(Boolean.FALSE);
                break;
            case 2:
                function1.invoke(Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue()));
                mutableState.setValue(Boolean.FALSE);
                break;
            default:
                function1.invoke(Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue()));
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
