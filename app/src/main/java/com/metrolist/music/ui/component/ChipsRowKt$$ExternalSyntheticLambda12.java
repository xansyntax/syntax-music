package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipsRowKt$$ExternalSyntheticLambda12 implements Function2 {
    public final /* synthetic */ byte $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ Function0 f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ ChipsRowKt$$ExternalSyntheticLambda12(int i, long j, String str, Function0 function0, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
        this.f$2 = j;
        this.f$3 = function0;
        this.f$4 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags = Stack.updateChangedFlags(this.f$4 | 1);
                long j = this.f$2;
                DialogKt.m1457AnimatedFilterChipFNF3uiM(iUpdateChangedFlags, j, (Composer) obj, (String) obj3, this.f$3, this.f$1);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(49);
                MenuKt.m1491ResizableIconButtonFU0evQE(this.f$4, (Modifier) obj3, this.f$2, this.f$1, this.f$3, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }

    public /* synthetic */ ChipsRowKt$$ExternalSyntheticLambda12(int i, Modifier modifier, long j, boolean z, Function0 function0, int i2) {
        this.f$4 = i;
        this.f$0 = modifier;
        this.f$2 = j;
        this.f$1 = z;
        this.f$3 = function0;
    }
}
