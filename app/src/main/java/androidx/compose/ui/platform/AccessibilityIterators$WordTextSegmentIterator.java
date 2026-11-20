package androidx.compose.ui.platform;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityIterators$WordTextSegmentIterator extends BaseMenuWrapper {
    public static AccessibilityIterators$WordTextSegmentIterator instance;
    public static AccessibilityIterators$WordTextSegmentIterator instance$1;
    public static AccessibilityIterators$WordTextSegmentIterator lineInstance;
    public final /* synthetic */ byte $r8$classId;
    public Object impl;
    public static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    public static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    public /* synthetic */ AccessibilityIterators$WordTextSegmentIterator(byte b) {
        this.$r8$classId = b;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] following(int i) {
        int lineForOffset;
        switch (this.$r8$classId) {
            case 0:
                if (getText().length() <= 0 || i >= getText().length()) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                while (!isLetterOrDigit(i) && (!isLetterOrDigit(i) || (i != 0 && isLetterOrDigit(i - 1)))) {
                    BreakIterator breakIterator = (BreakIterator) this.impl;
                    if (breakIterator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator.following(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
                int iFollowing = breakIterator2.following(i);
                if (iFollowing == -1 || !isEndBoundary$1(iFollowing)) {
                    return null;
                }
                return getRange(i, iFollowing);
            case 1:
                int length = getText().length();
                if (length <= 0 || i >= length) {
                    return null;
                }
                if (i < 0) {
                    i = 0;
                }
                do {
                    BreakIterator breakIterator3 = (BreakIterator) this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator3.isBoundary(i);
                    BreakIterator breakIterator4 = (BreakIterator) this.impl;
                    if (zIsBoundary) {
                        if (breakIterator4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("impl");
                            throw null;
                        }
                        int iFollowing2 = breakIterator4.following(i);
                        if (iFollowing2 == -1) {
                            return null;
                        }
                        return getRange(i, iFollowing2);
                    }
                    if (breakIterator4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator4.following(i);
                } while (i != -1);
                return null;
            default:
                if (getText().length() <= 0 || i >= getText().length()) {
                    return null;
                }
                TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
                ResolvedTextDirection resolvedTextDirection = DirectionStart;
                if (i < 0) {
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(0);
                } else {
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    int lineForOffset2 = textLayoutResult.multiParagraph.getLineForOffset(i);
                    lineForOffset = getLineEdgeIndex(lineForOffset2, resolvedTextDirection) == i ? lineForOffset2 : lineForOffset2 + 1;
                }
                TextLayoutResult textLayoutResult2 = (TextLayoutResult) this.impl;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                if (lineForOffset >= textLayoutResult2.multiParagraph.lineCount) {
                    return null;
                }
                return getRange(getLineEdgeIndex(lineForOffset, resolvedTextDirection), getLineEdgeIndex(lineForOffset, DirectionEnd) + 1);
        }
    }

    public int getLineEdgeIndex(int i, ResolvedTextDirection resolvedTextDirection) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        int lineStart = textLayoutResult.getLineStart(i);
        TextLayoutResult textLayoutResult2 = (TextLayoutResult) this.impl;
        if (textLayoutResult2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        ResolvedTextDirection paragraphDirection = textLayoutResult2.getParagraphDirection(lineStart);
        TextLayoutResult textLayoutResult3 = (TextLayoutResult) this.impl;
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

    public void initialize(String str) {
        switch (this.$r8$classId) {
            case 0:
                this.mContext = str;
                BreakIterator breakIterator = (BreakIterator) this.impl;
                if (breakIterator != null) {
                    breakIterator.setText(str);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
            default:
                this.mContext = str;
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 != null) {
                    breakIterator2.setText(str);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
        }
    }

    public boolean isEndBoundary$1(int i) {
        if (i <= 0 || !isLetterOrDigit(i - 1)) {
            return false;
        }
        return i == getText().length() || !isLetterOrDigit(i);
    }

    public boolean isLetterOrDigit(int i) {
        if (i < 0 || i >= getText().length()) {
            return false;
        }
        return Character.isLetterOrDigit(getText().codePointAt(i));
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final int[] preceding(int i) {
        int lineForOffset;
        switch (this.$r8$classId) {
            case 0:
                int length = getText().length();
                if (length <= 0 || i <= 0) {
                    return null;
                }
                if (i > length) {
                    i = length;
                }
                while (i > 0 && !isLetterOrDigit(i - 1) && !isEndBoundary$1(i)) {
                    BreakIterator breakIterator = (BreakIterator) this.impl;
                    if (breakIterator == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator.preceding(i);
                    if (i == -1) {
                        return null;
                    }
                }
                BreakIterator breakIterator2 = (BreakIterator) this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    throw null;
                }
                int iPreceding = breakIterator2.preceding(i);
                if (iPreceding == -1 || !isLetterOrDigit(iPreceding)) {
                    return null;
                }
                if (iPreceding == 0 || !isLetterOrDigit(iPreceding - 1)) {
                    return getRange(iPreceding, i);
                }
                return null;
            case 1:
                int length2 = getText().length();
                if (length2 <= 0 || i <= 0) {
                    return null;
                }
                if (i > length2) {
                    i = length2;
                }
                do {
                    BreakIterator breakIterator3 = (BreakIterator) this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    boolean zIsBoundary = breakIterator3.isBoundary(i);
                    BreakIterator breakIterator4 = (BreakIterator) this.impl;
                    if (zIsBoundary) {
                        if (breakIterator4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("impl");
                            throw null;
                        }
                        int iPreceding2 = breakIterator4.preceding(i);
                        if (iPreceding2 == -1) {
                            return null;
                        }
                        return getRange(iPreceding2, i);
                    }
                    if (breakIterator4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        throw null;
                    }
                    i = breakIterator4.preceding(i);
                } while (i != -1);
                return null;
            default:
                if (getText().length() <= 0 || i <= 0) {
                    return null;
                }
                int length3 = getText().length();
                TextLayoutResult textLayoutResult = (TextLayoutResult) this.impl;
                ResolvedTextDirection resolvedTextDirection = DirectionEnd;
                if (i > length3) {
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    lineForOffset = textLayoutResult.multiParagraph.getLineForOffset(getText().length());
                } else {
                    if (textLayoutResult == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                        throw null;
                    }
                    int lineForOffset2 = textLayoutResult.multiParagraph.getLineForOffset(i);
                    lineForOffset = getLineEdgeIndex(lineForOffset2, resolvedTextDirection) + 1 == i ? lineForOffset2 : lineForOffset2 - 1;
                }
                if (lineForOffset < 0) {
                    return null;
                }
                return getRange(getLineEdgeIndex(lineForOffset, DirectionStart), getLineEdgeIndex(lineForOffset, resolvedTextDirection) + 1);
        }
    }
}
