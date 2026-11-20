package com.metrolist.music.ui.component;

import androidx.compose.foundation.pager.PagerLayoutIntervalContent;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TimeTransferKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ TimeTransferKt$$ExternalSyntheticLambda3(MutableState mutableState, MutableState mutableState2, Function0 function0, byte b) {
        this.$r8$classId = b;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
        this.f$2 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Function0 function0 = this.f$2;
        MutableState mutableState = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (b) {
            case 0:
                mutableState2.setValue(null);
                mutableState.setValue(null);
                function0.invoke();
                return Unit.INSTANCE;
            default:
                return new PagerLayoutIntervalContent((Function4) mutableState2.getValue(), (Function1) mutableState.getValue(), ((Number) function0.invoke()).intValue());
        }
    }
}
