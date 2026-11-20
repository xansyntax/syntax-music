package com.metrolist.music.ui.screens.search;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1 implements Function0 {
    public final /* synthetic */ Function1 $onQueryChange;
    public final /* synthetic */ String $query;
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ OnlineSearchScreenKt$OnlineSearchScreen$3$1$7$2$1(byte b, String str, Function1 function1) {
        this.$r8$classId = b;
        this.$onQueryChange = function1;
        this.$query = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        String str = this.$query;
        Function1 function1 = this.$onQueryChange;
        switch (b) {
            case 0:
                int length = str.length();
                function1.invoke(new TextFieldValue(4, TextRangeKt.TextRange(length, length), str));
                break;
            default:
                function1.invoke(str);
                break;
        }
        return unit;
    }
}
