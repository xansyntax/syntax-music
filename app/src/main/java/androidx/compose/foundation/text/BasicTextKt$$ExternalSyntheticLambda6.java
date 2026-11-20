package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BasicTextKt$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ TextLinkScope f$0;

    public /* synthetic */ BasicTextKt$$ExternalSyntheticLambda6(TextLinkScope textLinkScope, byte b) {
        this.$r8$classId = b;
        this.f$0 = textLinkScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TextLayoutInput textLayoutInput;
        byte b = this.$r8$classId;
        byte b2 = 2;
        TextLinkScope textLinkScope = this.f$0;
        switch (b) {
            case 0:
                return Boolean.valueOf(textLinkScope != null ? ((Boolean) new BasicTextKt$$ExternalSyntheticLambda6(textLinkScope, b2).invoke()).booleanValue() : false);
            case 1:
                return Boolean.valueOf(textLinkScope != null ? ((Boolean) new BasicTextKt$$ExternalSyntheticLambda6(textLinkScope, b2).invoke()).booleanValue() : false);
            default:
                AnnotatedString annotatedString = textLinkScope.text;
                TextLayoutResult textLayoutResult = (TextLayoutResult) textLinkScope.textLayoutResult$delegate.getValue();
                return Boolean.valueOf(Intrinsics.areEqual(annotatedString, (textLayoutResult == null || (textLayoutInput = textLayoutResult.layoutInput) == null) ? null : textLayoutInput.text));
        }
    }
}
