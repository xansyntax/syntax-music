package io.ktor.http.parsing;

import androidx.compose.material3.SwipeToDismissBoxState;
import androidx.compose.material3.SwipeToDismissBoxValue;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.metrolist.music.ui.screens.settings.DarkMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ParserDslKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ParserDslKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.$r8$classId = (byte) 2;
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.f$0;
        switch (b) {
            case 0:
                return ParserDslKt.maybe$lambda$0(function1);
            case 1:
                function1.invoke(Boolean.FALSE);
                return unit;
            case 2:
                return new SwipeToDismissBoxState(SwipeToDismissBoxValue.Settled, function1);
            case 3:
                function1.invoke(-1);
                return unit;
            case 4:
                function1.invoke(-1);
                return unit;
            case 5:
                function1.invoke(Boolean.TRUE);
                return unit;
            case 6:
                function1.invoke(Boolean.FALSE);
                return unit;
            case 7:
                function1.invoke(Boolean.TRUE);
                return unit;
            case 8:
                function1.invoke(Boolean.FALSE);
                return unit;
            case 9:
                function1.invoke("csv");
                return unit;
            case 10:
                function1.invoke("m3u");
                return unit;
            case 11:
                function1.invoke("");
                return unit;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                function1.invoke("");
                return unit;
            case 13:
                function1.invoke(null);
                return unit;
            default:
                function1.invoke(DarkMode.AUTO);
                return unit;
        }
    }

    public /* synthetic */ ParserDslKt$$ExternalSyntheticLambda0(Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = function1;
    }
}
