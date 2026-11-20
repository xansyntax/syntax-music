package androidx.compose.ui.text;

import android.text.Layout;
import android.text.TextUtils;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil3.ImageLoader$Builder;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraph {
    public final boolean didExceedMaxLines;
    public final float height;
    public final ImageLoader$Builder intrinsics;
    public final int lineCount;
    public final int maxLines;
    public final ArrayList paragraphInfoList;
    public final ArrayList placeholderRects;
    public final float width;

    public MultiParagraph(ImageLoader$Builder imageLoader$Builder, long j, int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int iM783getMaxHeightimpl;
        int i5;
        this.intrinsics = imageLoader$Builder;
        this.maxLines = i;
        if (Constraints.m786getMinWidthimpl(j) != 0 || Constraints.m785getMinHeightimpl(j) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) imageLoader$Builder.extras;
        int size = arrayList2.size();
        float f = 0.0f;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= size) {
                i3 = 0;
                z = false;
                break;
            }
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) arrayList2.get(i6);
            AndroidParagraphIntrinsics androidParagraphIntrinsics = paragraphIntrinsicInfo.intrinsics;
            int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
            if (Constraints.m779getHasBoundedHeightimpl(j)) {
                i4 = i6;
                iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j) - ((int) Math.ceil(f));
                if (iM783getMaxHeightimpl < 0) {
                    iM783getMaxHeightimpl = 0;
                }
            } else {
                i4 = i6;
                iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
            }
            i3 = 0;
            AndroidParagraph androidParagraph = new AndroidParagraph(androidParagraphIntrinsics, this.maxLines - i7, i2, ConstraintsKt.Constraints$default(0, iM784getMaxWidthimpl, 0, iM783getMaxHeightimpl, 5));
            float f2 = androidParagraph.resolvedLineHeight + f;
            TextLayout textLayout = androidParagraph.layout;
            int i8 = i7 + textLayout.lineCount;
            arrayList.add(new ParagraphInfo(androidParagraph, paragraphIntrinsicInfo.startIndex, paragraphIntrinsicInfo.endIndex, i7, i8, f, f2));
            if (!textLayout.didExceedMaxLines) {
                if (i8 == this.maxLines) {
                    i5 = i4;
                    if (i5 != CollectionsKt__IterablesKt.getLastIndex((ArrayList) this.intrinsics.extras)) {
                    }
                } else {
                    i5 = i4;
                }
                i6 = i5 + 1;
                i7 = i8;
                f = f2;
            }
            z = true;
            i7 = i8;
            f = f2;
            break;
        }
        this.height = f;
        this.lineCount = i7;
        this.didExceedMaxLines = z;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m784getMaxWidthimpl(j);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i9 = i3; i9 < size2; i9++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i9);
            List list = paragraphInfo.paragraph.placeholderRects;
            ArrayList arrayList4 = new ArrayList(list.size());
            int size3 = list.size();
            for (int i10 = i3; i10 < size3; i10++) {
                Rect rect = (Rect) list.get(i10);
                arrayList4.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList4, arrayList3);
        }
        if (arrayList3.size() < ((List) this.intrinsics.defaults).size()) {
            int size4 = ((List) this.intrinsics.defaults).size() - arrayList3.size();
            ArrayList arrayList5 = new ArrayList(size4);
            for (int i11 = i3; i11 < size4; i11++) {
                arrayList5.add(null);
            }
            arrayList3 = CollectionsKt.plus((Iterable) arrayList5, (Collection) arrayList3);
        }
        this.placeholderRects = arrayList3;
    }

    /* JADX INFO: renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final void m728fillBoundingBoxes8ffj60Q(long j, float[] fArr) {
        requireIndexInRange(TextRange.m744getMinimpl(j));
        requireIndexInRangeInclusiveEnd(TextRange.m743getMaximpl(j));
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        TextRangeKt.m749findParagraphsByRangeSbBc2M(this.paragraphInfoList, j, new MultiParagraph$$ExternalSyntheticLambda0(j, fArr, ref$IntRef, new Ref$FloatRef()));
    }

    public final float getLineBottom(int i) {
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.getLineBottom(i - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    public final int getLineEnd(int i, boolean z) {
        int lineEnd;
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        if (z) {
            Layout layout = textLayout.layout;
            ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
            if (layout.getEllipsisCount(i2) <= 0 || textLayout.ellipsize != TextUtils.TruncateAt.END) {
                ImageLoader$Builder layoutHelper = textLayout.getLayoutHelper();
                Layout layout2 = (Layout) layoutHelper.application;
                lineEnd = layoutHelper.lineEndToVisibleEnd(layout2.getLineEnd(i2), layout2.getLineStart(i2));
            } else {
                lineEnd = layout.getEllipsisStart(i2) + layout.getLineStart(i2);
            }
        } else {
            lineEnd = textLayout.getLineEnd(i2);
        }
        return lineEnd + paragraphInfo.startIndex;
    }

    public final int getLineForOffset(int i) {
        int iFindParagraphByIndex;
        int length = ((AnnotatedString) this.intrinsics.application).text.length();
        ArrayList arrayList = this.paragraphInfoList;
        if (i >= length) {
            iFindParagraphByIndex = arrayList.size() - 1;
        } else {
            iFindParagraphByIndex = i < 0 ? 0 : TextRangeKt.findParagraphByIndex(i, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByIndex);
        return paragraphInfo.paragraph.layout.getLineForOffset(paragraphInfo.toLocalIndex(i)) + paragraphInfo.startLineIndex;
    }

    public final int getLineForVerticalPosition(float f) {
        int lineForVertical;
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByY(arrayList, f));
        int i = paragraphInfo.endIndex - paragraphInfo.startIndex;
        int i2 = paragraphInfo.startLineIndex;
        if (i == 0) {
            return i2;
        }
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        float f2 = f - paragraphInfo.top;
        TextLayout textLayout = androidParagraph.layout;
        int i3 = (int) (f2 - CropImageView.DEFAULT_ASPECT_RATIO);
        int i4 = textLayout.lineCount;
        if (i4 <= 0) {
            lineForVertical = 0;
        } else {
            lineForVertical = textLayout.layout.getLineForVertical(i3 - textLayout.topPadding);
            int i5 = i4 - 1;
            if (lineForVertical > i5) {
                lineForVertical = i5;
            }
        }
        return lineForVertical + i2;
    }

    public final float getLineTop(int i) {
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.getLineTop(i - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m729getOffsetForPositionk4lQ0M(long j) {
        int offsetForHorizontal;
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(TextRangeKt.findParagraphByY(arrayList, fIntBitsToFloat));
        int i2 = paragraphInfo.endIndex;
        int i3 = paragraphInfo.startIndex;
        if (i2 - i3 == 0) {
            return i3;
        }
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat(i) - paragraphInfo.top;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L);
        TextLayout textLayout = androidParagraph.layout;
        int iIntBitsToFloat = (int) (Float.intBitsToFloat((int) (4294967295L & jFloatToRawIntBits)) - CropImageView.DEFAULT_ASPECT_RATIO);
        Layout layout = textLayout.layout;
        int lineForVertical = layout.getLineForVertical(iIntBitsToFloat - textLayout.topPadding);
        if (lineForVertical >= textLayout.lineCount) {
            offsetForHorizontal = layout.getText().length();
        } else {
            offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (textLayout.getHorizontalPadding(lineForVertical) * (-1.0f)) + Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)));
        }
        return offsetForHorizontal + i3;
    }

    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m730getRangeForRect86BmAI(Rect rect, int i, ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0) {
        long jM732toGlobalxdX6G0;
        long j;
        float f = rect.top;
        ArrayList arrayList = this.paragraphInfoList;
        int iFindParagraphByY = TextRangeKt.findParagraphByY(arrayList, f);
        float f2 = ((ParagraphInfo) arrayList.get(iFindParagraphByY)).bottom;
        float f3 = rect.bottom;
        if (f2 >= f3 || iFindParagraphByY == arrayList.size() - 1) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByY);
            return paragraphInfo.m732toGlobalxdX6G0(paragraphInfo.paragraph.m724getRangeForRect86BmAI(paragraphInfo.toLocal(rect), i, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0), true);
        }
        int iFindParagraphByY2 = TextRangeKt.findParagraphByY(arrayList, f3);
        long jM732toGlobalxdX6G1 = TextRange.Zero;
        while (true) {
            jM732toGlobalxdX6G0 = TextRange.Zero;
            if (!TextRange.m740equalsimpl0(jM732toGlobalxdX6G1, jM732toGlobalxdX6G0) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = (ParagraphInfo) arrayList.get(iFindParagraphByY);
            jM732toGlobalxdX6G1 = paragraphInfo2.m732toGlobalxdX6G0(paragraphInfo2.paragraph.m724getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), i, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0), true);
            iFindParagraphByY++;
        }
        if (TextRange.m740equalsimpl0(jM732toGlobalxdX6G1, jM732toGlobalxdX6G0)) {
            return jM732toGlobalxdX6G0;
        }
        while (true) {
            j = TextRange.Zero;
            if (!TextRange.m740equalsimpl0(jM732toGlobalxdX6G0, j) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = (ParagraphInfo) arrayList.get(iFindParagraphByY2);
            jM732toGlobalxdX6G0 = paragraphInfo3.m732toGlobalxdX6G0(paragraphInfo3.paragraph.m724getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), i, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0), true);
            iFindParagraphByY2--;
        }
        return TextRange.m740equalsimpl0(jM732toGlobalxdX6G0, j) ? jM732toGlobalxdX6G1 : TextRangeKt.TextRange((int) (jM732toGlobalxdX6G1 >> 32), (int) (4294967295L & jM732toGlobalxdX6G0));
    }

    /* JADX INFO: renamed from: paint-LG529CI, reason: not valid java name */
    public final void m731paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        canvas.save();
        ArrayList arrayList = this.paragraphInfoList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i);
            paragraphInfo.paragraph.m725paintLG529CI(canvas, j, shadow, textDecoration, drawStyle);
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, paragraphInfo.paragraph.resolvedLineHeight);
        }
        canvas.restore();
    }

    public final void requireIndexInRange(int i) {
        AnnotatedString annotatedString = (AnnotatedString) this.intrinsics.application;
        if (i < 0 || i >= annotatedString.text.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + i + ") is out of bounds [0, " + annotatedString.text.length() + ")");
        }
    }

    public final void requireIndexInRangeInclusiveEnd(int i) {
        AnnotatedString annotatedString = (AnnotatedString) this.intrinsics.application;
        if (i < 0 || i > annotatedString.text.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("offset(" + i + ") is out of bounds [0, " + annotatedString.text.length() + "]");
        }
    }

    public final void requireLineIndexInRange(int i) {
        boolean z = false;
        int i2 = this.lineCount;
        if (i >= 0 && i < i2) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("lineIndex(" + i + ") is out of bounds [0, " + i2 + ")");
    }
}
