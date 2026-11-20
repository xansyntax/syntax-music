package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PasswordVisualTransformation implements VisualTransformation {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof PasswordVisualTransformation);
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public final TransformedText filter(AnnotatedString annotatedString) {
        return new TransformedText(new AnnotatedString(StringsKt__StringsJVMKt.repeat(annotatedString.text.length(), String.valueOf((char) 8226))), OffsetMapping.Companion.Identity);
    }

    public final int hashCode() {
        return Character.hashCode((char) 8226);
    }
}
