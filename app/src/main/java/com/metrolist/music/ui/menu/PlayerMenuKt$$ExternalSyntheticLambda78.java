package com.metrolist.music.ui.menu;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda78 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState f$1;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda78(Function0 function0, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = parcelableSnapshotMutableFloatState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = this.f$1;
        Function0 function0 = this.f$0;
        float fFloatValue = ((Float) obj).floatValue();
        switch (b) {
            case 0:
                parcelableSnapshotMutableFloatState.setFloatValue(fFloatValue);
                function0.invoke();
                break;
            default:
                parcelableSnapshotMutableFloatState.setFloatValue(fFloatValue);
                function0.invoke();
                break;
        }
        return unit;
    }
}
