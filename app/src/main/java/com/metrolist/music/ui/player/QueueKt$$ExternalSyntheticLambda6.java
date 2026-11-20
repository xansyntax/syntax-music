package com.metrolist.music.ui.player;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class QueueKt$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ QueueKt$$ExternalSyntheticLambda6(List list, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.FALSE);
                list.clear();
                break;
            case 1:
                mutableState.setValue(Boolean.FALSE);
                list.clear();
                break;
            case 2:
                mutableState.setValue(Boolean.FALSE);
                list.clear();
                break;
            case 3:
                mutableState.setValue(Boolean.FALSE);
                list.clear();
                break;
            default:
                mutableState.setValue(Boolean.FALSE);
                list.clear();
                break;
        }
        return unit;
    }
}
