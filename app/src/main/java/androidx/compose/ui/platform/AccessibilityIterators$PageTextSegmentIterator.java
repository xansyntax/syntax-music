package androidx.compose.ui.platform;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityIterators$PageTextSegmentIterator extends BaseMenuWrapper {
    public static AccessibilityIterators$PageTextSegmentIterator pageInstance;
    public TextLayoutResult layoutResult;
    public SemanticsNode node;
    public static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    public static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] following(int i) {
        int lineForVerticalPosition;
        if (getText().length() > 0 && i < getText().length()) {
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    throw null;
                }
                Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int iRound = Math.round(boundsInRoot.bottom - boundsInRoot.top);
                if (i <= 0) {
                    i = 0;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                int lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                float lineTop = textLayoutResult2.multiParagraph.getLineTop(lineForOffset) + iRound;
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                MultiParagraph multiParagraph = textLayoutResult3.multiParagraph;
                float lineTop2 = multiParagraph.getLineTop(multiParagraph.lineCount - 1);
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (lineTop < lineTop2) {
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForVerticalPosition = textLayoutResult4.multiParagraph.getLineForVerticalPosition(lineTop);
                } else {
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForVerticalPosition = textLayoutResult4.multiParagraph.lineCount;
                }
                return getRange(i, getLineEdgeIndex$1(lineForVerticalPosition - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }

    public final int getLineEdgeIndex$1(int i, ResolvedTextDirection resolvedTextDirection) {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        int lineStart = textLayoutResult.getLineStart(i);
        TextLayoutResult textLayoutResult2 = this.layoutResult;
        if (textLayoutResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        ResolvedTextDirection paragraphDirection = textLayoutResult2.getParagraphDirection(lineStart);
        TextLayoutResult textLayoutResult3 = this.layoutResult;
        if (resolvedTextDirection != paragraphDirection) {
            if (textLayoutResult3 != null) {
                return textLayoutResult3.getLineStart(i);
            }
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        if (textLayoutResult3 != null) {
            return textLayoutResult3.multiParagraph.getLineEnd(i, false) - 1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        throw null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] preceding(int i) {
        int lineForVerticalPosition;
        if (getText().length() > 0 && i > 0) {
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    throw null;
                }
                Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int iRound = Math.round(boundsInRoot.bottom - boundsInRoot.top);
                int length = getText().length();
                if (length <= i) {
                    i = length;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                int lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(i);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                float lineTop = textLayoutResult2.multiParagraph.getLineTop(lineForOffset) - iRound;
                if (lineTop > CropImageView.DEFAULT_ASPECT_RATIO) {
                    TextLayoutResult textLayoutResult3 = this.layoutResult;
                    if (textLayoutResult3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForVerticalPosition = textLayoutResult3.multiParagraph.getLineForVerticalPosition(lineTop);
                } else {
                    lineForVerticalPosition = 0;
                }
                if (i == getText().length() && lineForVerticalPosition < lineForOffset) {
                    lineForVerticalPosition++;
                }
                return getRange(getLineEdgeIndex$1(lineForVerticalPosition, DirectionStart), i);
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }
}
