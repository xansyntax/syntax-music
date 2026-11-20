package com.metrolist.music.ui.component;

import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda72 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda72(boolean z, Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$1 = z;
        this.f$2 = obj;
        this.f$3 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        int i = this.f$3;
        Object obj3 = this.f$2;
        boolean z = this.f$1;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                MenuKt.ActiveCoverChip(z, (Modifier) obj3, (Composer) obj, Stack.updateChangedFlags(i | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                Icons$Filled.BackHandler(iUpdateChangedFlags, (Composer) obj, (Function0) obj3, z);
                break;
        }
        return unit;
    }
}
