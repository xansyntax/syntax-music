package com.metrolist.music.ui.utils;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ShowOffsetDialogKt$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ParcelableSnapshotMutableIntState f$0;

    public /* synthetic */ ShowOffsetDialogKt$$ExternalSyntheticLambda1(ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState, byte b) {
        this.$r8$classId = b;
        this.f$0 = parcelableSnapshotMutableIntState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.f$0;
        switch (b) {
            case 0:
                return Stack.mutableStateOf$default(String.valueOf(parcelableSnapshotMutableIntState.getIntValue()));
            case 1:
                parcelableSnapshotMutableIntState.setIntValue(180);
                return unit;
            default:
                parcelableSnapshotMutableIntState.setIntValue(30);
                return unit;
        }
    }
}
