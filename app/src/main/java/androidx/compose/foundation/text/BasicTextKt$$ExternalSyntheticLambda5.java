package androidx.compose.foundation.text;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BasicTextKt$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextLinkScope f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ BasicTextKt$$ExternalSyntheticLambda5(TextLinkScope textLinkScope, Function1 function1, byte b) {
        this.$r8$classId = b;
        this.f$0 = textLinkScope;
        this.f$1 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Function1 function1 = this.f$1;
        TextLinkScope textLinkScope = this.f$0;
        switch (b) {
            case 0:
                TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
                if (textLinkScope != null) {
                    textLinkScope.textLayoutResult$delegate.setValue(textLayoutResult);
                }
                if (function1 != null) {
                    function1.invoke(textLayoutResult);
                }
                return Unit.INSTANCE;
            default:
                textLinkScope.annotators.add(function1);
                return new BackHandlerKt$BackHandler$lambda$4$0$$inlined$onDispose$1(textLinkScope, function1, (byte) 9);
        }
    }
}
