package com.metrolist.music.ui.screens;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherScreenKt$$ExternalSyntheticLambda54 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ ListenTogetherScreenKt$$ExternalSyntheticLambda54(List list, Function1 function1, Function1 function2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = function1;
        this.f$2 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.f$2;
        Function1 function2 = this.f$1;
        List list = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                ListenTogetherScreenKt.PendingJoinRequestsSection(list, function2, function1, composer, Stack.updateChangedFlags(1));
                break;
            default:
                ListenTogetherScreenKt.PendingSuggestionsSection(list, function2, function1, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }
}
