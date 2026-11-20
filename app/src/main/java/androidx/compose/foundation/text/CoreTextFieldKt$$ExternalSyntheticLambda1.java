package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ LegacyTextFieldState f$0;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda1(LegacyTextFieldState legacyTextFieldState, byte b) {
        this.$r8$classId = b;
        this.f$0 = legacyTextFieldState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        LegacyTextFieldState legacyTextFieldState = this.f$0;
        switch (b) {
            case 0:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.decorationBoxCoordinates = layoutCoordinates;
                }
                return unit;
            case 1:
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState.justAutofilled$delegate;
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                String str = textFieldValue.annotatedString.text;
                AnnotatedString annotatedString = legacyTextFieldState.untransformedText;
                if (!Intrinsics.areEqual(str, annotatedString != null ? annotatedString.text : null)) {
                    legacyTextFieldState.handleState$delegate.setValue(HandleState.None);
                    if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                    } else {
                        legacyTextFieldState.autofillHighlightOn$delegate.setValue(Boolean.FALSE);
                    }
                }
                long j = TextRange.Zero;
                legacyTextFieldState.m199setSelectionPreviewHighlightRange5zctL8(j);
                legacyTextFieldState.m198setDeletionPreviewHighlightRange5zctL8(j);
                legacyTextFieldState.onValueChangeOriginal.invoke(textFieldValue);
                legacyTextFieldState.recomposeScope.invalidate();
                return unit;
            case 2:
                legacyTextFieldState.keyboardActionRunner.m197runActionKlQnJC8(((ImeAction) obj).value);
                return unit;
            case 3:
                return Boolean.valueOf(legacyTextFieldState.keyboardActionRunner.m197runActionKlQnJC8(((ImeAction) obj).value));
            default:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                legacyTextFieldState.isInTouchMode$delegate.setValue(bool);
                return unit;
        }
    }
}
