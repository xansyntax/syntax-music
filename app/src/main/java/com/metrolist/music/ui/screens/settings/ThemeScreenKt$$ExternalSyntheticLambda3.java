package com.metrolist.music.ui.screens.settings;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThemeScreenKt$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ PaddingValuesImpl f$0;
    public final /* synthetic */ DarkMode f$1;
    public final /* synthetic */ Function1 f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ long f$5;
    public final /* synthetic */ Function1 f$6;

    public /* synthetic */ ThemeScreenKt$$ExternalSyntheticLambda3(PaddingValuesImpl paddingValuesImpl, DarkMode darkMode, Function1 function1, boolean z, Function1 function2, long j, Function1 function3, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = paddingValuesImpl;
        this.f$1 = darkMode;
        this.f$2 = function1;
        this.f$3 = z;
        this.f$4 = function2;
        this.f$5 = j;
        this.f$6 = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                ThemeScreenKt.m1511PortraitThemeLayoutV9fs2A(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(7);
                ThemeScreenKt.m1510LandscapeThemeLayoutV9fs2A(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
