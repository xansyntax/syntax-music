package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import com.metrolist.music.ui.screens.settings.integrations.LastFMSettingsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SettingsSleepTimerDialogKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Function0 f$1;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ SettingsSleepTimerDialogKt$$ExternalSyntheticLambda8(String str, String str2, Function1 function1, Function0 function0, int i) {
        this.f$0 = str;
        this.f$3 = str2;
        this.f$2 = function1;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                SettingsSleepTimerDialogKt.SleepTimerTimePickerDialog(Stack.updateChangedFlags(49), (Composer) obj, this.f$0, this.f$3, this.f$1, this.f$2);
                break;
            default:
                ((Integer) obj2).getClass();
                LastFMSettingsKt.TemplateFieldDialog(Stack.updateChangedFlags(3073), (Composer) obj, this.f$0, this.f$3, this.f$1, this.f$2);
                break;
        }
        return unit;
    }

    public /* synthetic */ SettingsSleepTimerDialogKt$$ExternalSyntheticLambda8(String str, Function0 function0, Function1 function1, String str2, int i) {
        this.f$0 = str;
        this.f$1 = function0;
        this.f$2 = function1;
        this.f$3 = str2;
    }
}
