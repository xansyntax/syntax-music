package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerState;
import androidx.compose.material3.TimePickerStateImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlarmSettingsKt$$ExternalSyntheticLambda24 implements Function3 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TimePickerState f$0;

    public /* synthetic */ AlarmSettingsKt$$ExternalSyntheticLambda24(TimePickerStateImpl timePickerStateImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = timePickerStateImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ColumnScopeInstance columnScopeInstance = (ColumnScopeInstance) obj;
        Composer composer = (Composer) obj2;
        int iIntValue = ((Integer) obj3).intValue();
        switch (b) {
            case 0:
                columnScopeInstance.getClass();
                GapComposer gapComposer = (GapComposer) composer;
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TimePickerKt.m354TimePickermT9BvqQ(this.f$0, null, null, 0, gapComposer, 0);
                }
                break;
            default:
                columnScopeInstance.getClass();
                GapComposer gapComposer2 = (GapComposer) composer;
                if (!gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TimePickerKt.m354TimePickermT9BvqQ(this.f$0, null, null, 0, gapComposer2, 0);
                }
                break;
        }
        return unit;
    }
}
