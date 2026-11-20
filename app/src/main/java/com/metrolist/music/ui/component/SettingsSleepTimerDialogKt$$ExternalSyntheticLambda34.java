package com.metrolist.music.ui.component;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ int f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ SettingsSleepTimerDialogKt$$ExternalSyntheticLambda34(int i, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = i;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ArrayList arrayListPlus;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        int i = this.f$0;
        switch (b) {
            case 0:
                if (((List) mutableState.getValue()).contains(Integer.valueOf(i))) {
                    arrayListPlus = CollectionsKt.minus((List) mutableState.getValue(), Integer.valueOf(i));
                } else {
                    arrayListPlus = CollectionsKt.plus(Integer.valueOf(i), (List) mutableState.getValue());
                }
                mutableState.setValue(arrayListPlus);
                break;
            case 1:
                mutableState.setValue("day_start_" + i);
                break;
            default:
                mutableState.setValue("day_end_" + i);
                break;
        }
        return unit;
    }
}
