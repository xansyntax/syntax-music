package com.metrolist.music.ui.menu;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LoadingScreenKt$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;

    public /* synthetic */ LoadingScreenKt$$ExternalSyntheticLambda4(byte b, int i) {
        this.$r8$classId = b;
        this.f$0 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        int i = this.f$0;
        switch (b) {
            case 0:
            default:
                return Float.valueOf(i / 100.0f);
            case 1:
                return new ParcelableSnapshotMutableIntState(i);
        }
    }
}
