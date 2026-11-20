package androidx.compose.ui.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutInput {
    public final long constraints;
    public final Density density;
    public final FontFamily.Resolver fontFamilyResolver;
    public final LayoutDirection layoutDirection;
    public final int maxLines;
    public final int overflow;
    public final List placeholders;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i;
        this.softWrap = z;
        this.overflow = i2;
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.fontFamilyResolver = resolver;
        this.constraints = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return Intrinsics.areEqual(this.text, textLayoutInput.text) && Intrinsics.areEqual(this.style, textLayoutInput.style) && Intrinsics.areEqual(this.placeholders, textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && this.overflow == textLayoutInput.overflow && Intrinsics.areEqual(this.density, textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual(this.fontFamilyResolver, textLayoutInput.fontFamilyResolver) && Constraints.m778equalsimpl0(this.constraints, textLayoutInput.constraints);
    }

    public final int hashCode() {
        return Long.hashCode(this.constraints) + ((this.fontFamilyResolver.hashCode() + ((this.layoutDirection.hashCode() + ((this.density.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.overflow, IntIntPair$$ExternalSyntheticOutline0.m((Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.style, this.text.hashCode() * 31, 31), 31, this.placeholders) + this.maxLines) * 31, this.softWrap, 31), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        int i = this.overflow;
        if (i == 1) {
            str = "Clip";
        } else if (i == 2) {
            str = "Ellipsis";
        } else if (i == 5) {
            str = "MiddleEllipsis";
        } else if (i == 3) {
            str = "Visible";
        } else {
            str = i == 4 ? "StartEllipsis" : "Invalid";
        }
        return "TextLayoutInput(text=" + ((Object) this.text) + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + str + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m788toStringimpl(this.constraints) + ")";
    }
}
