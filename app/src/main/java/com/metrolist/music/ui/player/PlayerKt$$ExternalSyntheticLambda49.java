package com.metrolist.music.ui.player;

import androidx.compose.material3.ExposedDropdownMenuAnchorType;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerKt$$ExternalSyntheticLambda49 implements Function0 {
    public final /* synthetic */ byte $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda49(MutableState mutableState, Function1 function1, boolean z) {
        this.f$1 = mutableState;
        this.f$2 = function1;
        this.f$0 = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        Function1 function1 = this.f$2;
        boolean z = this.f$0;
        switch (b) {
            case 0:
                if (z) {
                    Long l = (Long) mutableState.getValue();
                    if (l != null) {
                        function1.invoke(Long.valueOf(l.longValue()));
                    }
                    mutableState.setValue(null);
                }
                break;
            case 1:
                mutableState.setValue(new ExposedDropdownMenuAnchorType());
                function1.invoke(Boolean.valueOf(!z));
                break;
            default:
                if (!z) {
                    mutableState.setValue(Boolean.TRUE);
                } else {
                    function1.invoke(Boolean.FALSE);
                }
                break;
        }
        return unit;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda49(boolean z, MutableState mutableState, Function1 function1) {
        this.f$0 = z;
        this.f$1 = mutableState;
        this.f$2 = function1;
    }

    public /* synthetic */ PlayerKt$$ExternalSyntheticLambda49(boolean z, Function1 function1, MutableState mutableState) {
        this.f$0 = z;
        this.f$2 = function1;
        this.f$1 = mutableState;
    }
}
