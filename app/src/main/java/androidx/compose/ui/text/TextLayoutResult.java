package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Layout;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.common.util.TimedValueQueue;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResult {
    public final float firstBaseline;
    public final float lastBaseline;
    public final TextLayoutInput layoutInput;
    public final MultiParagraph multiParagraph;
    public final ArrayList placeholderRects;
    public final long size;

    public TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        boolean zIsEmpty = arrayList.isEmpty();
        float lineBaseline = CropImageView.DEFAULT_ASPECT_RATIO;
        this.firstBaseline = zIsEmpty ? 0.0f : ((ParagraphInfo) arrayList.get(0)).paragraph.getLineBaseline(0);
        if (!arrayList.isEmpty()) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last(arrayList);
            AndroidParagraph androidParagraph = paragraphInfo.paragraph;
            lineBaseline = androidParagraph.getLineBaseline(androidParagraph.layout.lineCount - 1) + paragraphInfo.top;
        }
        this.lastBaseline = lineBaseline;
        this.placeholderRects = multiParagraph.placeholderRects;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextLayoutResult) {
            TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
            if (Intrinsics.areEqual(this.layoutInput, textLayoutResult.layoutInput) && this.multiParagraph == textLayoutResult.multiParagraph && IntSize.m810equalsimpl0(this.size, textLayoutResult.size) && this.firstBaseline == textLayoutResult.firstBaseline && this.lastBaseline == textLayoutResult.lastBaseline && this.placeholderRects.equals(textLayoutResult.placeholderRects)) {
                return true;
            }
        }
        return false;
    }

    public final ResolvedTextDirection getBidiRunDirection(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        int length = ((AnnotatedString) multiParagraph.intrinsics.application).text.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == length ? arrayList.size() - 1 : TextRangeKt.findParagraphByIndex(i, arrayList));
        return paragraphInfo.paragraph.layout.layout.isRtlCharAt(paragraphInfo.toLocalIndex(i)) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    public final Rect getBoundingBox(int i) {
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        CharSequence charSequence = androidParagraph.charSequence;
        if (localIndex < 0 || localIndex >= charSequence.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + localIndex + ") is out of bounds [0," + charSequence.length() + ")");
        }
        TextLayout textLayout = androidParagraph.layout;
        int lineForOffset = textLayout.getLineForOffset(localIndex);
        float lineTop = textLayout.getLineTop(lineForOffset);
        float lineBottom = textLayout.getLineBottom(lineForOffset);
        Layout layout = textLayout.layout;
        boolean z = layout.getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = layout.isRtlCharAt(localIndex);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                primaryHorizontal = textLayout.getSecondaryHorizontal(localIndex, false);
                primaryHorizontal2 = textLayout.getSecondaryHorizontal(localIndex + 1, true);
            } else if (zIsRtlCharAt) {
                primaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
                primaryHorizontal2 = textLayout.getPrimaryHorizontal(localIndex + 1, true);
            } else {
                secondaryHorizontal = textLayout.getSecondaryHorizontal(localIndex, false);
                secondaryHorizontal2 = textLayout.getSecondaryHorizontal(localIndex + 1, true);
            }
            float f = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f;
        } else {
            secondaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
            secondaryHorizontal2 = textLayout.getPrimaryHorizontal(localIndex + 1, true);
        }
        RectF rectF = new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
        return paragraphInfo.toGlobal(new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom));
    }

    public final Rect getCursorRect(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        int length = ((AnnotatedString) multiParagraph.intrinsics.application).text.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == length ? arrayList.size() - 1 : TextRangeKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        TextLayout textLayout = androidParagraph.layout;
        int localIndex = paragraphInfo.toLocalIndex(i);
        CharSequence charSequence = androidParagraph.charSequence;
        if (localIndex < 0 || localIndex > charSequence.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + localIndex + ") is out of bounds [0," + charSequence.length() + "]");
        }
        float primaryHorizontal = textLayout.getPrimaryHorizontal(localIndex, false);
        int lineForOffset = textLayout.getLineForOffset(localIndex);
        return paragraphInfo.toGlobal(new Rect(primaryHorizontal, textLayout.getLineTop(lineForOffset), primaryHorizontal, textLayout.getLineBottom(lineForOffset)));
    }

    public final boolean getHasVisualOverflow() {
        long j = this.size;
        float f = (int) (j >> 32);
        MultiParagraph multiParagraph = this.multiParagraph;
        return f < multiParagraph.width || multiParagraph.didExceedMaxLines || ((float) ((int) (j & 4294967295L))) < multiParagraph.height;
    }

    public final float getLineLeft(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getLineLeft(i2) + (i2 == textLayout.lineCount + (-1) ? textLayout.leftPadding : CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final float getLineRight(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getLineRight(i2) + (i2 == textLayout.lineCount + (-1) ? textLayout.rightPadding : CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public final int getLineStart(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.layout.getLineStart(i - paragraphInfo.startLineIndex) + paragraphInfo.startIndex;
    }

    public final ResolvedTextDirection getParagraphDirection(int i) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        int length = ((AnnotatedString) multiParagraph.intrinsics.application).text.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == length ? arrayList.size() - 1 : TextRangeKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getParagraphDirection(textLayout.getLineForOffset(localIndex)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    public final AndroidPath getPathForRange(int i, int i2) {
        MultiParagraph multiParagraph = this.multiParagraph;
        AnnotatedString annotatedString = (AnnotatedString) multiParagraph.intrinsics.application;
        if (i < 0 || i > i2 || i2 > annotatedString.text.length()) {
            int length = annotatedString.text.length();
            StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "Start(", ") or End(", i2, ") is out of range [0..");
            sbM3m.append(length);
            sbM3m.append("), or start > end!");
            InlineClassHelperKt.throwIllegalArgumentException(sbM3m.toString());
        }
        if (i == i2) {
            return AndroidPath_androidKt.Path();
        }
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        TextRangeKt.m749findParagraphsByRangeSbBc2M(multiParagraph.paragraphInfoList, TextRangeKt.TextRange(i, i2), new MultiParagraph$$ExternalSyntheticLambda1(androidPathPath, i, i2, (byte) 0));
        return androidPathPath;
    }

    /* JADX INFO: renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m736getWordBoundaryjx7JFs(int i) {
        int iPrevBoundary;
        int iNextBoundary;
        int iNextBoundary2;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        int length = ((AnnotatedString) multiParagraph.intrinsics.application).text.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == length ? arrayList.size() - 1 : TextRangeKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        TimedValueQueue wordIterator = androidParagraph.layout.getWordIterator();
        if (wordIterator.isOnPunctuation(wordIterator.prevBoundary(localIndex))) {
            wordIterator.checkOffsetIsValid(localIndex);
            iPrevBoundary = localIndex;
            while (iPrevBoundary != -1 && (!wordIterator.isOnPunctuation(iPrevBoundary) || wordIterator.isAfterPunctuation(iPrevBoundary))) {
                iPrevBoundary = wordIterator.prevBoundary(iPrevBoundary);
            }
        } else {
            wordIterator.checkOffsetIsValid(localIndex);
            if (wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                iPrevBoundary = (!wordIterator.isBoundary(localIndex) || wordIterator.isAfterLetterOrDigitOrEmoji(localIndex)) ? wordIterator.prevBoundary(localIndex) : localIndex;
            } else {
                iPrevBoundary = wordIterator.isAfterLetterOrDigitOrEmoji(localIndex) ? wordIterator.prevBoundary(localIndex) : -1;
            }
        }
        if (iPrevBoundary == -1) {
            iPrevBoundary = localIndex;
        }
        if (wordIterator.isAfterPunctuation(wordIterator.nextBoundary(localIndex))) {
            wordIterator.checkOffsetIsValid(localIndex);
            iNextBoundary = localIndex;
            while (iNextBoundary != -1 && (wordIterator.isOnPunctuation(iNextBoundary) || !wordIterator.isAfterPunctuation(iNextBoundary))) {
                iNextBoundary = wordIterator.nextBoundary(iNextBoundary);
            }
        } else {
            wordIterator.checkOffsetIsValid(localIndex);
            if (wordIterator.isAfterLetterOrDigitOrEmoji(localIndex)) {
                if (!wordIterator.isBoundary(localIndex) || wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                    iNextBoundary2 = wordIterator.nextBoundary(localIndex);
                    iNextBoundary = iNextBoundary2;
                } else {
                    iNextBoundary = localIndex;
                }
            } else if (wordIterator.isOnLetterOrDigitOrEmoji(localIndex)) {
                iNextBoundary2 = wordIterator.nextBoundary(localIndex);
                iNextBoundary = iNextBoundary2;
            } else {
                iNextBoundary = -1;
            }
        }
        if (iNextBoundary != -1) {
            localIndex = iNextBoundary;
        }
        return paragraphInfo.m732toGlobalxdX6G0(TextRangeKt.TextRange(iPrevBoundary, localIndex), false);
    }

    public final int hashCode() {
        return this.placeholderRects.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.lastBaseline, IntIntPair$$ExternalSyntheticOutline0.m(this.firstBaseline, IntIntPair$$ExternalSyntheticOutline0.m((this.multiParagraph.hashCode() + (this.layoutInput.hashCode() * 31)) * 31, 31, this.size), 31), 31);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + IntSize.m811toStringimpl(this.size) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ")";
    }
}
