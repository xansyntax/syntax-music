package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AppNavigationKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ LensController f$2;
    public final /* synthetic */ Function2 f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Function0 f$6;
    public final /* synthetic */ Function0 f$7;
    public final /* synthetic */ int f$8;

    public /* synthetic */ AppNavigationKt$$ExternalSyntheticLambda8(List list, int i, LensController lensController, Function2 function2, boolean z, boolean z2, Function0 function0, Function0 function1, int i2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = i;
        this.f$2 = lensController;
        this.f$3 = function2;
        this.f$4 = z;
        this.f$5 = z2;
        this.f$6 = function0;
        this.f$7 = function1;
        this.f$8 = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$8;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                AppNavigationKt.PillNavBar(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i | 1);
                AppNavigationKt.GlassLensBar(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
