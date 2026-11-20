package com.metrolist.music.ui.component;

import com.metrolist.music.ui.screens.Screens;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppNavigationKt$$ExternalSyntheticLambda14 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Function2 f$2;
    public final /* synthetic */ Screens f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda14(boolean z, boolean z2, Function2 function2, Screens screens, int i, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = z;
        this.f$1 = z2;
        this.f$2 = function2;
        this.f$3 = screens;
        this.f$4 = i;
        this.f$5 = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$5;
        int i2 = this.f$4;
        Screens screens = this.f$3;
        Function2 function2 = this.f$2;
        boolean z = this.f$1;
        boolean z2 = this.f$0;
        switch (b) {
            case 0:
                if (!z2 && !z) {
                    function2.invoke(screens, Boolean.valueOf(i2 == i));
                }
                break;
            default:
                if (!z2 && !z) {
                    function2.invoke(screens, Boolean.valueOf(i2 == i));
                }
                break;
        }
        return unit;
    }
}
