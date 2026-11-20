package androidx.compose.foundation.text.modifiers;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextStringSimpleElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/modifiers/TextStringSimpleNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextStringSimpleElement extends ModifierNodeElement {
    public final FontFamily.Resolver fontFamilyResolver;
    public final int maxLines;
    public final int minLines;
    public final int overflow;
    public final boolean softWrap;
    public final TextStyle style;
    public final String text;

    public TextStringSimpleElement(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        TextStringSimpleNode textStringSimpleNode = new TextStringSimpleNode();
        textStringSimpleNode.text = this.text;
        textStringSimpleNode.style = this.style;
        textStringSimpleNode.fontFamilyResolver = this.fontFamilyResolver;
        textStringSimpleNode.overflow = this.overflow;
        textStringSimpleNode.softWrap = this.softWrap;
        textStringSimpleNode.maxLines = this.maxLines;
        textStringSimpleNode.minLines = this.minLines;
        return textStringSimpleNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return Intrinsics.areEqual(this.text, textStringSimpleElement.text) && Intrinsics.areEqual(this.style, textStringSimpleElement.style) && Intrinsics.areEqual(this.fontFamilyResolver, textStringSimpleElement.fontFamilyResolver) && this.overflow == textStringSimpleElement.overflow && this.softWrap == textStringSimpleElement.softWrap && this.maxLines == textStringSimpleElement.maxLines && this.minLines == textStringSimpleElement.minLines;
    }

    public final int hashCode() {
        return (((IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.overflow, (this.fontFamilyResolver.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.style, this.text.hashCode() * 31, 31)) * 31, 31), this.softWrap, 31) + this.maxLines) * 31) + this.minLines) * 31;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:16:0x003e  */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x009f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        boolean z;
        String str;
        String str2;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        FontFamily.Resolver resolver;
        FontFamily.Resolver resolver2;
        int i5;
        int i6;
        TextStringSimpleNode textStringSimpleNode = (TextStringSimpleNode) node;
        textStringSimpleNode.getClass();
        TextStyle textStyle = textStringSimpleNode.style;
        boolean z5 = false;
        boolean z6 = true;
        TextStyle textStyle2 = this.style;
        if (textStyle2 != textStyle) {
            if (!textStyle2.spanStyle.hasSameNonLayoutAttributes$ui_text(textStyle.spanStyle)) {
                z = true;
            }
            str = textStringSimpleNode.text;
            str2 = this.text;
            if (!Intrinsics.areEqual(str, str2)) {
                textStringSimpleNode.text = str2;
                textStringSimpleNode.textSubstitution = null;
                z5 = true;
            }
            z2 = !textStringSimpleNode.style.hasSameLayoutAffectingAttributes(textStyle2);
            textStringSimpleNode.style = textStyle2;
            i = textStringSimpleNode.minLines;
            i2 = this.minLines;
            if (i != i2) {
                textStringSimpleNode.minLines = i2;
                z2 = true;
            }
            i3 = textStringSimpleNode.maxLines;
            i4 = this.maxLines;
            if (i3 != i4) {
                textStringSimpleNode.maxLines = i4;
                z2 = true;
            }
            z3 = textStringSimpleNode.softWrap;
            z4 = this.softWrap;
            if (z3 != z4) {
                textStringSimpleNode.softWrap = z4;
                z2 = true;
            }
            resolver = textStringSimpleNode.fontFamilyResolver;
            resolver2 = this.fontFamilyResolver;
            if (!Intrinsics.areEqual(resolver, resolver2)) {
                textStringSimpleNode.fontFamilyResolver = resolver2;
                z2 = true;
            }
            i5 = textStringSimpleNode.overflow;
            i6 = this.overflow;
            if (i5 == i6) {
                z6 = z2;
            } else {
                textStringSimpleNode.overflow = i6;
            }
            if (z5 || z6) {
                ParagraphLayoutCache layoutCache = textStringSimpleNode.getLayoutCache();
                String str3 = textStringSimpleNode.text;
                TextStyle textStyle3 = textStringSimpleNode.style;
                FontFamily.Resolver resolver3 = textStringSimpleNode.fontFamilyResolver;
                int i7 = textStringSimpleNode.overflow;
                boolean z7 = textStringSimpleNode.softWrap;
                int i8 = textStringSimpleNode.maxLines;
                int i9 = textStringSimpleNode.minLines;
                layoutCache.text = str3;
                layoutCache.style = textStyle3;
                layoutCache.fontFamilyResolver = resolver3;
                layoutCache.overflow = i7;
                layoutCache.softWrap = z7;
                layoutCache.maxLines = i8;
                layoutCache.minLines = i9;
                layoutCache.historyFlag = (layoutCache.historyFlag << 2) | 2;
                layoutCache.markDirty();
            }
            if (textStringSimpleNode.isAttached) {
                if (z5 || (z && textStringSimpleNode.semanticsTextLayoutResult != null)) {
                    HitTestResultKt.invalidateSemantics(textStringSimpleNode);
                }
                if (z5 || z6) {
                    HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
                    HitTestResultKt.invalidateDraw(textStringSimpleNode);
                }
                if (z) {
                    HitTestResultKt.invalidateDraw(textStringSimpleNode);
                }
            }
            return;
        }
        textStyle2.getClass();
        z = false;
        str = textStringSimpleNode.text;
        str2 = this.text;
        if (!Intrinsics.areEqual(str, str2)) {
            textStringSimpleNode.text = str2;
            textStringSimpleNode.textSubstitution = null;
            z5 = true;
        }
        z2 = !textStringSimpleNode.style.hasSameLayoutAffectingAttributes(textStyle2);
        textStringSimpleNode.style = textStyle2;
        i = textStringSimpleNode.minLines;
        i2 = this.minLines;
        if (i != i2) {
            textStringSimpleNode.minLines = i2;
            z2 = true;
        }
        i3 = textStringSimpleNode.maxLines;
        i4 = this.maxLines;
        if (i3 != i4) {
            textStringSimpleNode.maxLines = i4;
            z2 = true;
        }
        z3 = textStringSimpleNode.softWrap;
        z4 = this.softWrap;
        if (z3 != z4) {
            textStringSimpleNode.softWrap = z4;
            z2 = true;
        }
        resolver = textStringSimpleNode.fontFamilyResolver;
        resolver2 = this.fontFamilyResolver;
        if (!Intrinsics.areEqual(resolver, resolver2)) {
            textStringSimpleNode.fontFamilyResolver = resolver2;
            z2 = true;
        }
        i5 = textStringSimpleNode.overflow;
        i6 = this.overflow;
        if (i5 == i6) {
            z6 = z2;
        } else {
            textStringSimpleNode.overflow = i6;
        }
        if (z5) {
            ParagraphLayoutCache layoutCache2 = textStringSimpleNode.getLayoutCache();
            String str4 = textStringSimpleNode.text;
            TextStyle textStyle4 = textStringSimpleNode.style;
            FontFamily.Resolver resolver4 = textStringSimpleNode.fontFamilyResolver;
            int i10 = textStringSimpleNode.overflow;
            boolean z8 = textStringSimpleNode.softWrap;
            int i11 = textStringSimpleNode.maxLines;
            int i12 = textStringSimpleNode.minLines;
            layoutCache2.text = str4;
            layoutCache2.style = textStyle4;
            layoutCache2.fontFamilyResolver = resolver4;
            layoutCache2.overflow = i10;
            layoutCache2.softWrap = z8;
            layoutCache2.maxLines = i11;
            layoutCache2.minLines = i12;
            layoutCache2.historyFlag = (layoutCache2.historyFlag << 2) | 2;
            layoutCache2.markDirty();
        } else {
            ParagraphLayoutCache layoutCache3 = textStringSimpleNode.getLayoutCache();
            String str5 = textStringSimpleNode.text;
            TextStyle textStyle5 = textStringSimpleNode.style;
            FontFamily.Resolver resolver5 = textStringSimpleNode.fontFamilyResolver;
            int i13 = textStringSimpleNode.overflow;
            boolean z9 = textStringSimpleNode.softWrap;
            int i14 = textStringSimpleNode.maxLines;
            int i15 = textStringSimpleNode.minLines;
            layoutCache3.text = str5;
            layoutCache3.style = textStyle5;
            layoutCache3.fontFamilyResolver = resolver5;
            layoutCache3.overflow = i13;
            layoutCache3.softWrap = z9;
            layoutCache3.maxLines = i14;
            layoutCache3.minLines = i15;
            layoutCache3.historyFlag = (layoutCache3.historyFlag << 2) | 2;
            layoutCache3.markDirty();
        }
        if (textStringSimpleNode.isAttached) {
            return;
        }
        if (z5) {
            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
        } else {
            HitTestResultKt.invalidateSemantics(textStringSimpleNode);
        }
        if (z5) {
            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        } else {
            HitTestResultKt.invalidateMeasurement(textStringSimpleNode);
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        }
        if (z) {
            HitTestResultKt.invalidateDraw(textStringSimpleNode);
        }
    }
}
