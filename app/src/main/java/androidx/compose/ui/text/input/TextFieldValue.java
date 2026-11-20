package androidx.compose.ui.text.input;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.core.provider.CallbackWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldValue {
    public static final CallbackWrapper Saver = new CallbackWrapper(new SaversKt$$ExternalSyntheticLambda5(12), new SaversKt$$ExternalSyntheticLambda6((byte) 15), 7);
    public final AnnotatedString annotatedString;
    public final TextRange composition;
    public final long selection;

    public TextFieldValue(AnnotatedString annotatedString, long j, TextRange textRange) {
        TextRange textRange2;
        this.annotatedString = annotatedString;
        this.selection = TextRangeKt.m747coerceIn8ffj60Q(annotatedString.text.length(), j);
        if (textRange != null) {
            textRange2 = new TextRange(TextRangeKt.m747coerceIn8ffj60Q(annotatedString.text.length(), textRange.packedValue));
        } else {
            textRange2 = null;
        }
        this.composition = textRange2;
    }

    /* JADX INFO: renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static TextFieldValue m762copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j, int i) {
        if ((i & 1) != 0) {
            annotatedString = textFieldValue.annotatedString;
        }
        if ((i & 2) != 0) {
            j = textFieldValue.selection;
        }
        TextRange textRange = (i & 4) != 0 ? textFieldValue.composition : null;
        textFieldValue.getClass();
        return new TextFieldValue(annotatedString, j, textRange);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return TextRange.m740equalsimpl0(this.selection, textFieldValue.selection) && Intrinsics.areEqual(this.composition, textFieldValue.composition) && Intrinsics.areEqual(this.annotatedString, textFieldValue.annotatedString);
    }

    public final int hashCode() {
        int iHashCode = this.annotatedString.hashCode() * 31;
        int i = TextRange.$r8$clinit;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(iHashCode, 31, this.selection);
        TextRange textRange = this.composition;
        return iM + (textRange != null ? Long.hashCode(textRange.packedValue) : 0);
    }

    public final String toString() {
        return "TextFieldValue(text='" + ((Object) this.annotatedString) + "', selection=" + TextRange.m746toStringimpl(this.selection) + ", composition=" + this.composition + ")";
    }

    public TextFieldValue(int i, long j, String str) {
        this(new AnnotatedString((i & 1) != 0 ? "" : str), (i & 2) != 0 ? TextRange.Zero : j, (TextRange) null);
    }
}
