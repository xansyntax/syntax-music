package com.metrolist.music.ui.screens.playlist;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TopPlaylistScreenKt$$ExternalSyntheticLambda12 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ TopPlaylistScreenKt$$ExternalSyntheticLambda12(List list, MutableState mutableState, MutableState mutableState2, byte b) {
        this.$r8$classId = b;
        this.f$0 = list;
        this.f$1 = mutableState;
        this.f$2 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$2;
        MutableState mutableState2 = this.f$1;
        List list = this.f$0;
        switch (b) {
            case 0:
                mutableState2.setValue(Boolean.FALSE);
                list.clear();
                mutableState.setValue(null);
                break;
            case 1:
                mutableState2.setValue(Boolean.FALSE);
                list.clear();
                mutableState.setValue(null);
                break;
            default:
                mutableState2.setValue(Boolean.FALSE);
                list.clear();
                mutableState.setValue(null);
                break;
        }
        return unit;
    }
}
