package com.metrolist.music.ui.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Icon$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Icon f$0;

    public /* synthetic */ Icon$$ExternalSyntheticLambda0(Icon icon, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = icon;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Icon icon = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                icon.Explicit(Stack.updateChangedFlags(7), composer);
                break;
            case 1:
                icon.Favorite(Stack.updateChangedFlags(7), composer);
                break;
            default:
                icon.Library(Stack.updateChangedFlags(7), composer);
                break;
        }
        return unit;
    }
}
