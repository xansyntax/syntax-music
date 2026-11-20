package androidx.compose.foundation.text.modifiers;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextAnnotatedStringElement extends ModifierNodeElement {
    public final FontFamily.Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final Function1 onPlaceholderLayout;
    public final Function1 onShowTranslation;
    public final Function1 onTextLayout;
    public final int overflow;
    public final List placeholders;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;

    public TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function2, Function1 function3) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.placeholders = list;
        this.onPlaceholderLayout = function2;
        this.onShowTranslation = function3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        TextAnnotatedStringNode textAnnotatedStringNode = new TextAnnotatedStringNode();
        textAnnotatedStringNode.text = this.text;
        textAnnotatedStringNode.style = this.style;
        textAnnotatedStringNode.fontFamilyResolver = this.fontFamilyResolver;
        textAnnotatedStringNode.onTextLayout = this.onTextLayout;
        textAnnotatedStringNode.overflow = this.overflow;
        textAnnotatedStringNode.softWrap = this.softWrap;
        textAnnotatedStringNode.maxLines = this.maxLines;
        textAnnotatedStringNode.minLines = this.minLines;
        textAnnotatedStringNode.placeholders = this.placeholders;
        textAnnotatedStringNode.onPlaceholderLayout = this.onPlaceholderLayout;
        textAnnotatedStringNode.onShowTranslation = this.onShowTranslation;
        return textAnnotatedStringNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return Intrinsics.areEqual(this.text, textAnnotatedStringElement.text) && Intrinsics.areEqual(this.style, textAnnotatedStringElement.style) && Intrinsics.areEqual(this.placeholders, textAnnotatedStringElement.placeholders) && Intrinsics.areEqual(this.fontFamilyResolver, textAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == textAnnotatedStringElement.onTextLayout && this.onShowTranslation == textAnnotatedStringElement.onShowTranslation && this.overflow == textAnnotatedStringElement.overflow && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines && this.onPlaceholderLayout == textAnnotatedStringElement.onPlaceholderLayout;
    }

    public final int hashCode() {
        int iHashCode = (this.fontFamilyResolver.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.style, this.text.hashCode() * 31, 31)) * 31;
        Function1 function1 = this.onTextLayout;
        int iM = (((IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.overflow, (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31, 31), this.softWrap, 31) + this.maxLines) * 31) + this.minLines) * 31;
        List list = this.placeholders;
        int iHashCode2 = (iM + (list != null ? list.hashCode() : 0)) * 31;
        Function1 function2 = this.onPlaceholderLayout;
        int iHashCode3 = (iHashCode2 + (function2 != null ? function2.hashCode() : 0)) * 29791;
        Function1 function3 = this.onShowTranslation;
        return iHashCode3 + (function3 != null ? function3.hashCode() : 0);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x009d  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        AnnotatedString annotatedString;
        boolean zAreEqual;
        boolean z2;
        boolean z3;
        List list;
        List list2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        FontFamily.Resolver resolver;
        FontFamily.Resolver resolver2;
        int i5;
        int i6;
        Function1 function1;
        Function1 function2;
        Function1 function3;
        Function1 function4;
        Function1 function5;
        Function1 function6;
        TextAnnotatedStringNode textAnnotatedStringNode = (TextAnnotatedStringNode) node;
        TextStyle textStyle = textAnnotatedStringNode.style;
        boolean z6 = false;
        boolean z7 = true;
        TextStyle textStyle2 = this.style;
        if (textStyle2 != textStyle) {
            if (!textStyle2.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle)) {
                z = true;
            }
            String str = textAnnotatedStringNode.text.text;
            annotatedString = this.text;
            zAreEqual = Intrinsics.areEqual(str, annotatedString.text);
            boolean zAreEqual2 = Intrinsics.areEqual(textAnnotatedStringNode.text.annotations, annotatedString.annotations);
            if (zAreEqual || !zAreEqual2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                textAnnotatedStringNode.text = annotatedString;
            }
            if (!zAreEqual) {
                textAnnotatedStringNode.textSubstitution = null;
            }
            z3 = !textAnnotatedStringNode.style.hasSameLayoutAffectingAttributes(textStyle2);
            textAnnotatedStringNode.style = textStyle2;
            list = textAnnotatedStringNode.placeholders;
            list2 = this.placeholders;
            if (!Intrinsics.areEqual(list, list2)) {
                textAnnotatedStringNode.placeholders = list2;
                z3 = true;
            }
            i = textAnnotatedStringNode.minLines;
            i2 = this.minLines;
            if (i != i2) {
                textAnnotatedStringNode.minLines = i2;
                z3 = true;
            }
            i3 = textAnnotatedStringNode.maxLines;
            i4 = this.maxLines;
            if (i3 != i4) {
                textAnnotatedStringNode.maxLines = i4;
                z3 = true;
            }
            z4 = textAnnotatedStringNode.softWrap;
            z5 = this.softWrap;
            if (z4 != z5) {
                textAnnotatedStringNode.softWrap = z5;
                z3 = true;
            }
            resolver = textAnnotatedStringNode.fontFamilyResolver;
            resolver2 = this.fontFamilyResolver;
            if (!Intrinsics.areEqual(resolver, resolver2)) {
                textAnnotatedStringNode.fontFamilyResolver = resolver2;
                z3 = true;
            }
            i5 = textAnnotatedStringNode.overflow;
            i6 = this.overflow;
            if (i5 != i6) {
                textAnnotatedStringNode.overflow = i6;
                z3 = true;
            }
            function1 = textAnnotatedStringNode.onTextLayout;
            function2 = this.onTextLayout;
            if (function1 != function2) {
                textAnnotatedStringNode.onTextLayout = function2;
                z6 = true;
            }
            function3 = textAnnotatedStringNode.onPlaceholderLayout;
            function4 = this.onPlaceholderLayout;
            if (function3 != function4) {
                textAnnotatedStringNode.onPlaceholderLayout = function4;
                z6 = true;
            }
            function5 = textAnnotatedStringNode.onShowTranslation;
            function6 = this.onShowTranslation;
            if (function5 != function6) {
                textAnnotatedStringNode.onShowTranslation = function6;
            } else {
                z7 = z6;
            }
            if (z2 || z3 || z7) {
                textAnnotatedStringNode.getLayoutCache().m222updateJ2qo7bo(textAnnotatedStringNode.text, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, textAnnotatedStringNode.placeholders);
            }
            if (textAnnotatedStringNode.isAttached) {
                if (z2 || (z && textAnnotatedStringNode.semanticsTextLayoutResult != null)) {
                    HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
                }
                if (z2 || z3 || z7) {
                    HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
                    HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                }
                if (z) {
                    HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
                }
            }
            return;
        }
        textStyle2.getClass();
        z = false;
        String str2 = textAnnotatedStringNode.text.text;
        annotatedString = this.text;
        zAreEqual = Intrinsics.areEqual(str2, annotatedString.text);
        boolean zAreEqual3 = Intrinsics.areEqual(textAnnotatedStringNode.text.annotations, annotatedString.annotations);
        if (zAreEqual) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (z2) {
            textAnnotatedStringNode.text = annotatedString;
        }
        if (!zAreEqual) {
            textAnnotatedStringNode.textSubstitution = null;
        }
        z3 = !textAnnotatedStringNode.style.hasSameLayoutAffectingAttributes(textStyle2);
        textAnnotatedStringNode.style = textStyle2;
        list = textAnnotatedStringNode.placeholders;
        list2 = this.placeholders;
        if (!Intrinsics.areEqual(list, list2)) {
            textAnnotatedStringNode.placeholders = list2;
            z3 = true;
        }
        i = textAnnotatedStringNode.minLines;
        i2 = this.minLines;
        if (i != i2) {
            textAnnotatedStringNode.minLines = i2;
            z3 = true;
        }
        i3 = textAnnotatedStringNode.maxLines;
        i4 = this.maxLines;
        if (i3 != i4) {
            textAnnotatedStringNode.maxLines = i4;
            z3 = true;
        }
        z4 = textAnnotatedStringNode.softWrap;
        z5 = this.softWrap;
        if (z4 != z5) {
            textAnnotatedStringNode.softWrap = z5;
            z3 = true;
        }
        resolver = textAnnotatedStringNode.fontFamilyResolver;
        resolver2 = this.fontFamilyResolver;
        if (!Intrinsics.areEqual(resolver, resolver2)) {
            textAnnotatedStringNode.fontFamilyResolver = resolver2;
            z3 = true;
        }
        i5 = textAnnotatedStringNode.overflow;
        i6 = this.overflow;
        if (i5 != i6) {
            textAnnotatedStringNode.overflow = i6;
            z3 = true;
        }
        function1 = textAnnotatedStringNode.onTextLayout;
        function2 = this.onTextLayout;
        if (function1 != function2) {
            textAnnotatedStringNode.onTextLayout = function2;
            z6 = true;
        }
        function3 = textAnnotatedStringNode.onPlaceholderLayout;
        function4 = this.onPlaceholderLayout;
        if (function3 != function4) {
            textAnnotatedStringNode.onPlaceholderLayout = function4;
            z6 = true;
        }
        function5 = textAnnotatedStringNode.onShowTranslation;
        function6 = this.onShowTranslation;
        if (function5 != function6) {
            textAnnotatedStringNode.onShowTranslation = function6;
        } else {
            z7 = z6;
        }
        if (z2) {
            textAnnotatedStringNode.getLayoutCache().m222updateJ2qo7bo(textAnnotatedStringNode.text, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, textAnnotatedStringNode.placeholders);
        } else {
            textAnnotatedStringNode.getLayoutCache().m222updateJ2qo7bo(textAnnotatedStringNode.text, textAnnotatedStringNode.style, textAnnotatedStringNode.fontFamilyResolver, textAnnotatedStringNode.overflow, textAnnotatedStringNode.softWrap, textAnnotatedStringNode.maxLines, textAnnotatedStringNode.minLines, textAnnotatedStringNode.placeholders);
        }
        if (textAnnotatedStringNode.isAttached) {
            return;
        }
        if (z2) {
            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
        } else {
            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode);
        }
        if (z2) {
            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
        } else {
            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode);
            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
        }
        if (z) {
            HitTestResultKt.invalidateDraw(textAnnotatedStringNode);
        }
    }
}
