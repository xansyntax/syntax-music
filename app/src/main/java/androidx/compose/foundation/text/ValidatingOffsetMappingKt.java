package androidx.compose.foundation.text;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import okhttp3.internal.http2.Huffman;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ValidatingOffsetMappingKt {
    public static final Huffman.Node ValidatingEmptyOffsetMappingIdentity = new Huffman.Node(OffsetMapping.Companion.Identity, 0, 0);

    public static final TransformedText filterWithValidation(VisualTransformation visualTransformation, AnnotatedString annotatedString) {
        TransformedText transformedTextFilter = visualTransformation.filter(annotatedString);
        int length = annotatedString.text.length();
        AnnotatedString annotatedString2 = transformedTextFilter.text;
        OffsetMapping offsetMapping = transformedTextFilter.offsetMapping;
        int length2 = annotatedString2.text.length();
        int iMin = Math.min(length, 100);
        for (int i = 0; i < iMin; i++) {
            validateOriginalToTransformed(offsetMapping.originalToTransformed(i), length2, i);
        }
        validateOriginalToTransformed(offsetMapping.originalToTransformed(length), length2, length);
        int iMin2 = Math.min(length2, 100);
        for (int i2 = 0; i2 < iMin2; i2++) {
            validateTransformedToOriginal(offsetMapping.transformedToOriginal(i2), length, i2);
        }
        validateTransformedToOriginal(offsetMapping.transformedToOriginal(length2), length, length2);
        return new TransformedText(annotatedString2, new Huffman.Node(offsetMapping, annotatedString.text.length(), annotatedString2.text.length()));
    }

    public static final void validateOriginalToTransformed(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i3, "OffsetMapping.originalToTransformed returned invalid mapping: ", " -> ", i, " is not in range of transformed text [0, ");
        sbM3m.append(i2);
        sbM3m.append("]");
        InlineClassHelperKt.throwIllegalStateException(sbM3m.toString());
    }

    public static final void validateTransformedToOriginal(int i, int i2, int i3) {
        boolean z = false;
        if (i >= 0 && i <= i2) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i3, "OffsetMapping.transformedToOriginal returned invalid mapping: ", " -> ", i, " is not in range of original text [0, ");
        sbM3m.append(i2);
        sbM3m.append("]");
        InlineClassHelperKt.throwIllegalStateException(sbM3m.toString());
    }
}
