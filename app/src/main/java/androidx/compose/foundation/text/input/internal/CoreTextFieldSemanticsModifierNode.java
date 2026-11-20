package androidx.compose.foundation.text.input.internal;

import android.view.autofill.AutofillValue;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ListItemKt$$ExternalSyntheticLambda17;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import com.google.common.math.IntMath;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldSemanticsModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public boolean enabled;
    public FocusRequester focusRequester;
    public ImeOptions imeOptions;
    public boolean isPassword;
    public TextFieldSelectionManager manager;
    public OffsetMapping offsetMapping;
    public boolean readOnly;
    public LegacyTextFieldState state;
    public TransformedText transformedText;
    public TextFieldValue value;

    public static void handleTextUpdateFromSemantics(LegacyTextFieldState legacyTextFieldState, String str, boolean z, boolean z2) {
        if (z || !z2) {
            return;
        }
        TextInputSession textInputSession = legacyTextFieldState.inputSession;
        CoreTextFieldKt$$ExternalSyntheticLambda1 coreTextFieldKt$$ExternalSyntheticLambda1 = legacyTextFieldState.onValueChange;
        if (textInputSession == null) {
            int length = str.length();
            coreTextFieldKt$$ExternalSyntheticLambda1.invoke(new TextFieldValue(4, TextRangeKt.TextRange(length, length), str));
        } else {
            TextFieldValue textFieldValueApply = legacyTextFieldState.processor.apply(CollectionsKt__IterablesKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(str, 1)}));
            textInputSession.updateState(null, textFieldValueApply);
            coreTextFieldKt$$ExternalSyntheticLambda1.invoke(textFieldValueApply);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        boolean z = this.isPassword;
        AnnotatedString annotatedString = this.value.annotatedString;
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.InputText;
        KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
        KProperty kProperty = kPropertyArr2[19];
        semanticsPropertyKey.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey, annotatedString);
        AnnotatedString annotatedString2 = this.transformedText.text;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.EditableText;
        KProperty kProperty2 = kPropertyArr2[20];
        semanticsPropertyKey2.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey2, annotatedString2);
        long j = this.value.selection;
        SemanticsPropertyKey semanticsPropertyKey3 = SemanticsProperties.TextSelectionRange;
        KProperty kProperty3 = kPropertyArr2[21];
        TextRange textRange = new TextRange(j);
        semanticsPropertyKey3.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey3, textRange);
        SemanticsPropertiesKt.setContentDataType(semanticsPropertyReceiver, ContentDataType$Companion.Text);
        SemanticsPropertiesKt.setFillableData(semanticsPropertyReceiver, new AndroidFillableData(AutofillValue.forText(IntMath.trimToSafeLength(this.value.annotatedString))));
        boolean z2 = false;
        z2 = false;
        semanticsPropertyReceiver.set(SemanticsActions.OnFillData, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, z2 ? (byte) 1 : (byte) 0)));
        int i = this.imeOptions.keyboardType;
        if (i == 6) {
            ContentType.Companion.getClass();
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.Companion.EmailAddress);
        } else if (i == 7 || i == 8) {
            ContentType.Companion.getClass();
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.Companion.Password);
        } else if (i == 4) {
            ContentType.Companion.getClass();
            SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.Companion.PhoneNumber);
        }
        boolean z3 = this.enabled;
        Unit unit = Unit.INSTANCE;
        if (!z3) {
            semanticsPropertyReceiver.set(SemanticsProperties.Disabled, unit);
        }
        if (z) {
            semanticsPropertyReceiver.set(SemanticsProperties.Password, unit);
        }
        byte b = 1;
        if (this.enabled && !this.readOnly) {
            z2 = true;
        }
        SemanticsPropertyKey semanticsPropertyKey4 = SemanticsProperties.IsEditable;
        KProperty kProperty4 = kPropertyArr2[29];
        Boolean boolValueOf = Boolean.valueOf(z2);
        semanticsPropertyKey4.getClass();
        semanticsPropertyReceiver.set(semanticsPropertyKey4, boolValueOf);
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, b)));
        byte b2 = 2;
        if (z2) {
            semanticsPropertyReceiver.set(SemanticsActions.SetText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, b2)));
            semanticsPropertyReceiver.set(SemanticsActions.InsertTextAtCursor, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda2(this, semanticsPropertyReceiver)));
        }
        semanticsPropertyReceiver.set(SemanticsActions.SetSelection, new AccessibilityAction(null, new ListItemKt$$ExternalSyntheticLambda17(b, this)));
        int i2 = this.imeOptions.imeAction;
        CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0 coreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0 = new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 6);
        semanticsPropertyReceiver.set(SemanticsProperties.ImeAction, new ImeAction(i2));
        semanticsPropertyReceiver.set(SemanticsActions.OnImeAction, new AccessibilityAction(null, coreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0));
        semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 7)));
        semanticsPropertyReceiver.set(SemanticsActions.OnLongClick, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 1)));
        if (!TextRange.m741getCollapsedimpl(this.value.selection) && !z) {
            semanticsPropertyReceiver.set(SemanticsActions.CopyText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 2)));
            if (this.enabled && !this.readOnly) {
                semanticsPropertyReceiver.set(SemanticsActions.CutText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 3)));
            }
        }
        if (!this.enabled || this.readOnly) {
            return;
        }
        semanticsPropertyReceiver.set(SemanticsActions.PasteText, new AccessibilityAction(null, new CoreTextFieldSemanticsModifierNode$$ExternalSyntheticLambda0(this, (byte) 5)));
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }
}
