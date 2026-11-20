package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import com.metrolist.music.ui.component.MenuState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda30 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ Function0 f$4;
    public final /* synthetic */ MenuState f$5;
    public final /* synthetic */ Modifier f$6;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda30(String str, List list, int i, int i2, Function0 function0, MenuState menuState, Modifier modifier, int i3, byte b) {
        this.$r8$classId = b;
        this.f$0 = str;
        this.f$1 = list;
        this.f$2 = i;
        this.f$3 = i2;
        this.f$4 = function0;
        this.f$5 = menuState;
        this.f$6 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(24577);
                TopPlaylistScreenKt.TopPlaylistHeader(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags);
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(24577);
                TopPlaylistScreenKt.AutoPlaylistHeader(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags2);
                break;
            case 2:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(24577);
                TopPlaylistScreenKt.AutoPlaylistHeader(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags3);
                break;
            default:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(24577);
                TopPlaylistScreenKt.TopPlaylistHeader(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (Composer) obj, iUpdateChangedFlags4);
                break;
        }
        return unit;
    }
}
