package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ItemsKt$$ExternalSyntheticLambda78 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Function3 f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ boolean f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Modifier f$7;

    public /* synthetic */ ItemsKt$$ExternalSyntheticLambda78(String str, String str2, Function3 function3, String str3, boolean z, boolean z2, Modifier modifier, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = function3;
        this.f$3 = str3;
        this.f$4 = z;
        this.f$5 = z2;
        this.f$7 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                MenuKt.LocalSongsGrid(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$7, (Composer) obj, iUpdateChangedFlags);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(1);
                MenuKt.LocalAlbumsGrid(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$7, (Composer) obj, iUpdateChangedFlags2);
                break;
        }
        return unit;
    }
}
