package androidx.compose.foundation.text.input.internal;

import android.view.autofill.AutofillValue;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.core.provider.CallbackWrapper;
import java.io.IOException;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ CoreTextFieldSemanticsModifierNode f$0;

    public /* synthetic */ CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.$r8$classId = (byte) 3;
        this.f$0 = coreTextFieldSemanticsModifierNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IOException {
        byte b = this.$r8$classId;
        boolean z = false;
        CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = this.f$0;
        switch (b) {
            case 0:
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = coreTextFieldSemanticsModifierNode.state.justAutofilled$delegate;
                Boolean bool = Boolean.TRUE;
                parcelableSnapshotMutableState.setValue(bool);
                coreTextFieldSemanticsModifierNode.state.autofillHighlightOn$delegate.setValue(bool);
                LegacyTextFieldState legacyTextFieldState = coreTextFieldSemanticsModifierNode.state;
                AutofillValue autofillValue = ((AndroidFillableData) obj).autofillValue;
                CharSequence textValue = autofillValue.isText() ? autofillValue.getTextValue() : null;
                textValue.getClass();
                CoreTextFieldSemanticsModifierNode.handleTextUpdateFromSemantics(legacyTextFieldState, (String) textValue, coreTextFieldSemanticsModifierNode.readOnly, coreTextFieldSemanticsModifierNode.enabled);
                return bool;
            case 1:
                List list = (List) obj;
                if (coreTextFieldSemanticsModifierNode.state.getLayoutResult() != null) {
                    TextLayoutResultProxy layoutResult = coreTextFieldSemanticsModifierNode.state.getLayoutResult();
                    layoutResult.getClass();
                    list.add(layoutResult.value);
                    z = true;
                }
                return Boolean.valueOf(z);
            case 2:
                CoreTextFieldSemanticsModifierNode.handleTextUpdateFromSemantics(coreTextFieldSemanticsModifierNode.state, ((AnnotatedString) obj).text, coreTextFieldSemanticsModifierNode.readOnly, coreTextFieldSemanticsModifierNode.enabled);
                return Boolean.TRUE;
            default:
                AnnotatedString annotatedString = (AnnotatedString) obj;
                if (!coreTextFieldSemanticsModifierNode.readOnly && coreTextFieldSemanticsModifierNode.enabled) {
                    TextInputSession textInputSession = coreTextFieldSemanticsModifierNode.state.inputSession;
                    if (textInputSession != null) {
                        List listListOf = CollectionsKt__IterablesKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)});
                        LegacyTextFieldState legacyTextFieldState2 = coreTextFieldSemanticsModifierNode.state;
                        CallbackWrapper callbackWrapper = legacyTextFieldState2.processor;
                        CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1 = legacyTextFieldState2.onValueChange;
                        TextFieldValue textFieldValueApply = callbackWrapper.apply(listListOf);
                        textInputSession.updateState(null, textFieldValueApply);
                        coreTextFieldKt$$ExternalSyntheticLambda1.invoke(textFieldValueApply);
                    } else {
                        TextFieldValue textFieldValue = coreTextFieldSemanticsModifierNode.value;
                        String str = textFieldValue.annotatedString.text;
                        long j = textFieldValue.selection;
                        int i = TextRange.$r8$clinit;
                        String string = StringsKt.replaceRange(str, (int) (j >> 32), (int) (j & 4294967295L), annotatedString).toString();
                        int length = annotatedString.text.length() + ((int) (coreTextFieldSemanticsModifierNode.value.selection >> 32));
                        coreTextFieldSemanticsModifierNode.state.onValueChange.invoke(new TextFieldValue(4, TextRangeKt.TextRange(length, length), string));
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
        }
    }

    public /* synthetic */ CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = coreTextFieldSemanticsModifierNode;
    }
}
