package com.metrolist.music.ui.screens.settings;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThemeScreenKt$$ExternalSyntheticLambda6 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ DarkMode f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ ThemeScreenKt$$ExternalSyntheticLambda6(DarkMode darkMode, boolean z, long j, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = darkMode;
        this.f$1 = z;
        this.f$2 = j;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        switch (b) {
            case 0:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                ThemeScreenKt.m1513ThemeMockupXOJAsU(this.f$0, this.f$1, this.f$2, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                ThemeScreenKt.m1514ThemeMockupPortraitXOJAsU(this.f$0, this.f$1, this.f$2, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
