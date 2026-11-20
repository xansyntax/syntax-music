package com.metrolist.music.ui.screens;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.GapBuffer;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HomeScreenKt$$ExternalSyntheticLambda57 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ HomeScreenKt$$ExternalSyntheticLambda57(Object obj, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int size;
        byte b = this.$r8$classId;
        int i = this.f$1;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                size = ((((List) obj).size() + i) - 1) / i;
                break;
            default:
                size = ((TextLayoutResult) ((GapBuffer) obj).buffer).multiParagraph.getLineForOffset(i);
                break;
        }
        return Integer.valueOf(size);
    }
}
