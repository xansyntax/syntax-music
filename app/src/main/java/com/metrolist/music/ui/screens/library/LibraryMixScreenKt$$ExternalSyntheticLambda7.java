package com.metrolist.music.ui.screens.library;

import androidx.compose.runtime.MutableState;
import androidx.navigation.NavHostController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LibraryMixScreenKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ LibraryMixScreenKt$$ExternalSyntheticLambda7(NavHostController navHostController, MutableState mutableState, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        MutableState mutableState = this.f$1;
        NavHostController navHostController = this.f$0;
        String str = (String) obj;
        switch (b) {
            case 0:
                str.getClass();
                mutableState.setValue(Boolean.FALSE);
                NavHostController.navigate$default(navHostController, "local_playlist/".concat(str));
                break;
            default:
                str.getClass();
                mutableState.setValue(Boolean.FALSE);
                NavHostController.navigate$default(navHostController, "local_playlist/".concat(str));
                break;
        }
        return unit;
    }
}
