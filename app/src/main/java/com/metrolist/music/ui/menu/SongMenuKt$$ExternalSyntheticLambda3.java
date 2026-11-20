package com.metrolist.music.ui.menu;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SongMenuKt$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ SongMenuKt$$ExternalSyntheticLambda3(Function0 function0, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = function0;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        Function0 function0 = this.f$0;
        switch (b) {
            case 0:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            case 1:
                mutableState.setValue(Boolean.FALSE);
                if (function0 != null) {
                    function0.invoke();
                }
                break;
            case 2:
                mutableState.setValue(Boolean.FALSE);
                if (function0 != null) {
                    function0.invoke();
                }
                break;
            case 3:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            case 4:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            case 5:
                mutableState.setValue(Boolean.FALSE);
                function0.invoke();
                break;
            default:
                function0.invoke();
                mutableState.setValue(Boolean.FALSE);
                break;
        }
        return unit;
    }
}
