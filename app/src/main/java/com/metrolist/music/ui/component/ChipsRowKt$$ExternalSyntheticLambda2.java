package com.metrolist.music.ui.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ChipsRowKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ChipsRowKt$$ExternalSyntheticLambda2(Function1 function1, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj = this.f$1;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                function1.invoke(obj);
                break;
            default:
                function1.invoke(obj);
                break;
        }
        return unit;
    }
}
