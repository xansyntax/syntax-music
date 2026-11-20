package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import android.view.inputmethod.ExtractedText;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextInclusionStrategy$Companion;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HandwritingGesture_androidKt {
    public static final boolean containsInclusive(Rect rect, float f, float f2) {
        float f3 = rect.left;
        if (f > rect.right || f3 > f) {
            return false;
        }
        return f2 <= rect.bottom && rect.top <= f2;
    }

    /* JADX INFO: renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m214getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : CropImageView.DEFAULT_ASPECT_RATIO;
        int i = (int) (4294967295L & j);
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Float.intBitsToFloat(i));
        if (Float.intBitsToFloat(i) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Float.intBitsToFloat(i) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin) {
            return -1;
        }
        int i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) < (-handwritingGestureLineMargin) || Float.intBitsToFloat(i2) > multiParagraph.width + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m215getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        long jMo609screenToLocalMKHz9U;
        int iM214getLineForHandwritingGestured4ec7I;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            MultiParagraph multiParagraph = layoutResult.value.multiParagraph;
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates != null && (iM214getLineForHandwritingGestured4ec7I = m214getLineForHandwritingGestured4ec7I(multiParagraph, (jMo609screenToLocalMKHz9U = layoutCoordinates.mo609screenToLocalMKHz9U(j)), viewConfiguration)) != -1) {
                return multiParagraph.m729getOffsetForPositionk4lQ0M(Offset.m433copydBAh8RU$default(jMo609screenToLocalMKHz9U, (multiParagraph.getLineBottom(iM214getLineForHandwritingGestured4ec7I) + multiParagraph.getLineTop(iM214getLineForHandwritingGestured4ec7I)) / 2.0f, 1));
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m216getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        MultiParagraph multiParagraph = layoutResult != null ? layoutResult.value.multiParagraph : null;
        LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
        return (multiParagraph == null || layoutCoordinates == null) ? TextRange.Zero : multiParagraph.m730getRangeForRect86BmAI(rect.m446translatek4lQ0M(layoutCoordinates.mo609screenToLocalMKHz9U(0L)), i, TextInclusionStrategy$Companion.ContainsCenter);
    }

    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m217getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i) {
        long jM216getRangeForScreenRectOH9lIzo = m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i);
        if (TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo)) {
            return TextRange.Zero;
        }
        long jM216getRangeForScreenRectOH9lIzo2 = m216getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i);
        if (TextRange.m741getCollapsedimpl(jM216getRangeForScreenRectOH9lIzo2)) {
            return TextRange.Zero;
        }
        int i2 = (int) (jM216getRangeForScreenRectOH9lIzo >> 32);
        int i3 = (int) (jM216getRangeForScreenRectOH9lIzo2 & 4294967295L);
        return TextRangeKt.TextRange(Math.min(i2, i2), Math.max(i3, i3));
    }

    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        int lineForOffset = multiParagraph.getLineForOffset(i);
        return i == textLayoutResult.getLineStart(lineForOffset) || i == multiParagraph.getLineEnd(lineForOffset, false) ? textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i) : textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    public static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    public static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    public static final boolean isWhitespaceExceptNewline(int i) {
        int type;
        return (!isWhitespace(i) || (type = Character.getType(i)) == 14 || type == 13 || i == 10) ? false : true;
    }

    public static final Modifier legacyTextInputAdapter(Modifier modifier, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return modifier.then(new LegacyAdaptingPlatformTextInputModifier(androidLegacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager));
    }

    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        ExtractedText extractedText = new ExtractedText();
        String str = textFieldValue.annotatedString.text;
        extractedText.text = str;
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = str.length();
        extractedText.partialStartOffset = -1;
        long j = textFieldValue.selection;
        extractedText.selectionStart = TextRange.m744getMinimpl(j);
        extractedText.selectionEnd = TextRange.m743getMaximpl(j);
        extractedText.flags = !StringsKt.contains$default(textFieldValue.annotatedString.text, '\n') ? 1 : 0;
        return extractedText;
    }

    public static final long toOffset(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L);
    }
}
