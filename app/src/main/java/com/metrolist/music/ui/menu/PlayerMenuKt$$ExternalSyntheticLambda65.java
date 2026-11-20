package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerMenuKt$$ExternalSyntheticLambda65 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ PlayerMenuKt$$ExternalSyntheticLambda65(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        MutableState mutableState2 = this.f$1;
        MutableState mutableState3 = this.f$0;
        switch (b) {
            case 0:
                if (!((Boolean) mutableState3.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.TRUE);
                } else {
                    mutableState.setValue(Boolean.TRUE);
                }
                break;
            case 1:
                mutableState3.setValue("weekdays_weekends");
                if (!((Boolean) mutableState2.getValue()).booleanValue() && !((Boolean) mutableState.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.TRUE);
                }
                break;
            case 2:
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    Job job = (Job) mutableState2.getValue();
                    if (job != null) {
                        job.cancel(null);
                    }
                    mutableState3.setValue(Boolean.FALSE);
                }
                mutableState.setValue(Boolean.FALSE);
                break;
            case 3:
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    Job job2 = (Job) mutableState2.getValue();
                    if (job2 != null) {
                        job2.cancel(null);
                    }
                    mutableState3.setValue(Boolean.FALSE);
                }
                mutableState.setValue(Boolean.FALSE);
                break;
            case 4:
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    Job job3 = (Job) mutableState2.getValue();
                    if (job3 != null) {
                        job3.cancel(null);
                    }
                    mutableState3.setValue(Boolean.FALSE);
                }
                mutableState.setValue(Boolean.FALSE);
                break;
            case 5:
                if (((Boolean) mutableState3.getValue()).booleanValue()) {
                    Job job4 = (Job) mutableState2.getValue();
                    if (job4 != null) {
                        job4.cancel(null);
                    }
                    mutableState3.setValue(Boolean.FALSE);
                }
                mutableState.setValue(Boolean.FALSE);
                break;
            case 6:
                if (!((Boolean) mutableState3.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(null);
                }
                break;
            case 7:
                if (!((Boolean) mutableState3.getValue()).booleanValue()) {
                    mutableState2.setValue(Boolean.FALSE);
                    mutableState.setValue(null);
                }
                break;
            default:
                mutableState2.setValue(StringsKt.trim((String) mutableState3.getValue()).toString());
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
