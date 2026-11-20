package com.metrolist.music.ui.screens.equalizer;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import com.metrolist.music.db.DatabaseDao_Impl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EqScreenKt$$ExternalSyntheticLambda11 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ManagedActivityResultLauncher f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ EqScreenKt$$ExternalSyntheticLambda11(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = managedActivityResultLauncher;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        ManagedActivityResultLauncher managedActivityResultLauncher = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.FALSE);
                managedActivityResultLauncher.launch("text/plain");
                break;
            default:
                mutableState.setValue(Boolean.FALSE);
                managedActivityResultLauncher.launch(DatabaseDao_Impl.AnonymousClass17.PickVisualMediaRequest$default());
                break;
        }
        return unit;
    }
}
