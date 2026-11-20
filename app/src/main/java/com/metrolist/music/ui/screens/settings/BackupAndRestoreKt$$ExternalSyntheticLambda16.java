package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackupAndRestoreKt$$ExternalSyntheticLambda16 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;
    public final /* synthetic */ MutableState f$3;

    public /* synthetic */ BackupAndRestoreKt$$ExternalSyntheticLambda16(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
        this.f$3 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$3;
        MutableState mutableState2 = this.f$2;
        MutableState mutableState3 = this.f$1;
        MutableState mutableState4 = this.f$0;
        switch (b) {
            case 0:
                Boolean bool = Boolean.FALSE;
                mutableState4.setValue(bool);
                mutableState3.setValue(null);
                mutableState2.setValue(null);
                mutableState.setValue(bool);
                break;
            default:
                Boolean bool2 = Boolean.FALSE;
                mutableState4.setValue(bool2);
                mutableState3.setValue(null);
                mutableState2.setValue(null);
                mutableState.setValue(bool2);
                break;
        }
        return unit;
    }
}
