package com.metrolist.music.ui.screens;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stack;
import androidx.navigation.NavHostController;
import com.metrolist.music.ui.screens.recognition.RecognitionScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ListenTogetherScreenKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ NavHostController f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ListenTogetherScreenKt$$ExternalSyntheticLambda0(NavHostController navHostController, boolean z, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = navHostController;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        boolean z = this.f$1;
        NavHostController navHostController = this.f$0;
        Composer composer = (Composer) obj;
        ((Integer) obj2).getClass();
        switch (b) {
            case 0:
                ListenTogetherScreenKt.ListenTogetherScreen(navHostController, z, composer, Stack.updateChangedFlags(49));
                break;
            case 1:
                ListenTogetherScreenKt.ListenTogetherScreen(navHostController, z, composer, Stack.updateChangedFlags(49));
                break;
            default:
                RecognitionScreenKt.RecognitionScreen(navHostController, z, composer, Stack.updateChangedFlags(1));
                break;
        }
        return unit;
    }
}
