package androidx.compose.ui.text.android;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import coil3.ImageLoader$Builder;
import com.yalantis.ucrop.view.CropImageView;
import java.text.Bidi;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StaticLayoutFactory {
    public static final LayoutNode$$ExternalSyntheticLambda1 IntRangeComparator = new LayoutNode$$ExternalSyntheticLambda1((byte) 6);

    public static StaticLayout create(CharSequence charSequence, TextPaint textPaint, int i, int i2, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i3, TextUtils.TruncateAt truncateAt, int i4, int i5, boolean z, int i6, int i7, int i8, int i9) {
        if (i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid start value");
        }
        int length = charSequence.length();
        if (i2 < 0 || i2 > length) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid end value");
        }
        if (i3 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid maxLines value");
        }
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid width value");
        }
        if (i4 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid ellipsizedWidth value");
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, i2, textPaint, i);
        builderObtain.setTextDirection(textDirectionHeuristic);
        builderObtain.setAlignment(alignment);
        builderObtain.setMaxLines(i3);
        builderObtain.setEllipsize(truncateAt);
        builderObtain.setEllipsizedWidth(i4);
        builderObtain.setLineSpacing(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        builderObtain.setIncludePad(z);
        builderObtain.setBreakStrategy(i6);
        builderObtain.setHyphenationFrequency(i9);
        builderObtain.setIndents(null, null);
        builderObtain.setJustificationMode(i5);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(builderObtain);
        }
        if (i10 >= 33) {
            BoringLayoutFactory33.setLineBreakConfig(builderObtain, i7, i8);
        }
        if (i10 >= 35) {
            StaticLayoutFactory35.disableUseBoundsForWidth(builderObtain);
        }
        return builderObtain.build();
    }

    public static final Rect getCharSequenceBounds(TextPaint textPaint, CharSequence charSequence, int i, int i2) {
        int i3 = i;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.nextSpanTransition(i3 - 1, i2, MetricAffectingSpan.class) != i2) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i3 < i2) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i3, i2, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i3, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        Paint29.getTextBounds(textPaint2, charSequence, i3, iNextSpanTransition, rect2);
                    } else {
                        textPaint2.getTextBounds(charSequence.toString(), i3, iNextSpanTransition, rect2);
                    }
                    rect.right = rect2.width() + rect.right;
                    rect.top = Math.min(rect.top, rect2.top);
                    rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    i3 = iNextSpanTransition;
                }
                return rect;
            }
        }
        Rect rect3 = new Rect();
        if (Build.VERSION.SDK_INT >= 29) {
            Paint29.getTextBounds(textPaint, charSequence, i3, i2, rect3);
            return rect3;
        }
        textPaint.getTextBounds(charSequence.toString(), i3, i2, rect3);
        return rect3;
    }

    public static final float getCharacterRightBounds(int i, int i2, float[] fArr) {
        return fArr[((i - i2) * 2) + 1];
    }

    public static final int getLineForOffset(Layout layout, int i, boolean z) {
        if (i <= 0) {
            return 0;
        }
        if (i >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int lineStart = layout.getLineStart(lineForOffset);
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (lineStart == i || lineEnd == i) {
            if (lineStart == i) {
                if (z) {
                    return lineForOffset - 1;
                }
            } else if (!z) {
                return lineForOffset + 1;
            }
        }
        return lineForOffset;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x025e A[EDGE_INSN: B:144:0x025e->B:171:0x02ba BREAK  A[LOOP:5: B:154:0x027a->B:206:0x027a]] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a6  */
    public static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, ImageLoader$Builder imageLoader$Builder, int i, RectF rectF, SegmentFinder segmentFinder, ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0, boolean z) {
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr;
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr2;
        int i2;
        int iNextEndBoundary;
        int i3;
        int i4;
        int iPreviousStartBoundary;
        Bidi bidiCreateLineBidi;
        float f;
        float f2;
        float f3;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        int i5 = (lineEnd - lineStart) * 2;
        float[] fArr = new float[i5];
        Layout layout2 = textLayout.layout;
        int lineStart2 = layout2.getLineStart(i);
        int lineEnd2 = textLayout.getLineEnd(i);
        if (i5 < (lineEnd2 - lineStart2) * 2) {
            InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        RelativeScroller relativeScroller = new RelativeScroller(textLayout);
        boolean z2 = false;
        boolean z3 = layout2.getParagraphDirection(i) == 1;
        int i6 = 0;
        while (lineStart2 < lineEnd2) {
            boolean zIsRtlCharAt = layout2.isRtlCharAt(lineStart2);
            if (z3 && !zIsRtlCharAt) {
                f = relativeScroller.get(lineStart2, z2, z2, true);
                f3 = relativeScroller.get(lineStart2 + 1, true, true, true);
            } else if (z3 && zIsRtlCharAt) {
                f3 = relativeScroller.get(lineStart2, false, false, false);
                f = relativeScroller.get(lineStart2 + 1, true, true, false);
            } else {
                if (zIsRtlCharAt) {
                    f2 = relativeScroller.get(lineStart2, false, false, true);
                    f = relativeScroller.get(lineStart2 + 1, true, true, true);
                } else {
                    f = relativeScroller.get(lineStart2, false, false, false);
                    f2 = relativeScroller.get(lineStart2 + 1, true, true, false);
                }
                f3 = f2;
            }
            fArr[i6] = f;
            fArr[i6 + 1] = f3;
            i6 += 2;
            lineStart2++;
            z3 = z3;
            z2 = false;
        }
        Layout layout3 = (Layout) imageLoader$Builder.application;
        int lineStart3 = layout3.getLineStart(i);
        int lineEnd3 = layout3.getLineEnd(i);
        int paragraphForOffset = imageLoader$Builder.getParagraphForOffset(lineStart3, false);
        int paragraphStart = imageLoader$Builder.getParagraphStart(paragraphForOffset);
        int i7 = lineStart3 - paragraphStart;
        int i8 = lineEnd3 - paragraphStart;
        Bidi bidiAnalyzeBidi = imageLoader$Builder.analyzeBidi(paragraphForOffset);
        if (bidiAnalyzeBidi == null || (bidiCreateLineBidi = bidiAnalyzeBidi.createLineBidi(i7, i8)) == null) {
            layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[]{new LayoutHelper$BidiRun(lineStart3, layout3.isRtlCharAt(lineStart3), lineEnd3)};
        } else {
            int runCount = bidiCreateLineBidi.getRunCount();
            layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[runCount];
            int i9 = 0;
            while (i9 < runCount) {
                int i10 = runCount;
                layoutHelper$BidiRunArr[i9] = new LayoutHelper$BidiRun(bidiCreateLineBidi.getRunStart(i9) + lineStart3, bidiCreateLineBidi.getRunLevel(i9) % 2 == 1, bidiCreateLineBidi.getRunLimit(i9) + lineStart3);
                i9++;
                runCount = i10;
            }
        }
        IntProgression intRange = z ? new IntRange(0, layoutHelper$BidiRunArr.length - 1, 1) : new IntProgression(layoutHelper$BidiRunArr.length - 1, 0, -1);
        int i11 = intRange.first;
        int i12 = intRange.last;
        int i13 = intRange.step;
        if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
            return -1;
        }
        while (true) {
            LayoutHelper$BidiRun layoutHelper$BidiRun = layoutHelper$BidiRunArr[i11];
            boolean z4 = layoutHelper$BidiRun.isRtl;
            int iNextStartBoundary = layoutHelper$BidiRun.start;
            int iPreviousEndBoundary = layoutHelper$BidiRun.end;
            float f4 = z4 ? fArr[((iPreviousEndBoundary - 1) - lineStart) * 2] : fArr[(iNextStartBoundary - lineStart) * 2];
            float characterRightBounds = z4 ? getCharacterRightBounds(iNextStartBoundary, lineStart, fArr) : getCharacterRightBounds(iPreviousEndBoundary - 1, lineStart, fArr);
            float f5 = rectF.left;
            int i14 = i13;
            if (!z) {
                layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                if (characterRightBounds < f5) {
                    iPreviousEndBoundary = -1;
                    break;
                }
                float f6 = rectF.right;
                if (f4 <= f6) {
                    if ((z4 || f6 < characterRightBounds) && (!z4 || f5 > f4)) {
                        int i15 = iPreviousEndBoundary;
                        int i16 = iNextStartBoundary;
                        while (i15 - i16 > 1) {
                            int i17 = (i15 + i16) / 2;
                            float f7 = fArr[(i17 - lineStart) * 2];
                            int i18 = i15;
                            if ((z4 || f7 <= rectF.right) && (!z4 || f7 >= rectF.left)) {
                                i15 = i18;
                                i16 = i17;
                            } else {
                                i15 = i17;
                            }
                        }
                        i2 = z4 ? i15 : i16;
                    } else {
                        i2 = iPreviousEndBoundary - 1;
                    }
                    int iPreviousStartBoundary2 = segmentFinder.previousStartBoundary(i2 + 1);
                    if (iPreviousStartBoundary2 == -1 || (iNextEndBoundary = segmentFinder.nextEndBoundary(iPreviousStartBoundary2)) <= iNextStartBoundary) {
                        iPreviousEndBoundary = -1;
                        break;
                    }
                    if (iPreviousStartBoundary2 < iNextStartBoundary) {
                        iPreviousStartBoundary2 = iNextStartBoundary;
                    }
                    if (iNextEndBoundary <= iPreviousEndBoundary) {
                        iPreviousEndBoundary = iNextEndBoundary;
                    }
                    RectF rectF2 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, lineTop, CropImageView.DEFAULT_ASPECT_RATIO, lineBottom);
                    int iPreviousStartBoundary3 = iPreviousStartBoundary2;
                    while (true) {
                        rectF2.left = z4 ? fArr[((iPreviousEndBoundary - 1) - lineStart) * 2] : fArr[(iPreviousStartBoundary3 - lineStart) * 2];
                        rectF2.right = z4 ? getCharacterRightBounds(iPreviousStartBoundary3, lineStart, fArr) : getCharacterRightBounds(iPreviousEndBoundary - 1, lineStart, fArr);
                        if (((Boolean) composerKt$$ExternalSyntheticLambda0.invoke(rectF2, rectF)).booleanValue()) {
                            break;
                        }
                        iPreviousEndBoundary = segmentFinder.previousEndBoundary(iPreviousEndBoundary);
                        if (iPreviousEndBoundary == -1 || iPreviousEndBoundary <= iNextStartBoundary) {
                            iPreviousEndBoundary = -1;
                            break;
                        }
                        iPreviousStartBoundary3 = segmentFinder.previousStartBoundary(iPreviousEndBoundary);
                        if (iPreviousStartBoundary3 < iNextStartBoundary) {
                            iPreviousStartBoundary3 = iNextStartBoundary;
                        }
                    }
                } else {
                    iPreviousEndBoundary = -1;
                    break;
                }
                iNextStartBoundary = iPreviousEndBoundary;
            } else {
                if (characterRightBounds < f5) {
                    layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                    iNextStartBoundary = -1;
                    break;
                }
                float f8 = rectF.right;
                if (f4 <= f8) {
                    if ((z4 || f5 > f4) && (!z4 || f8 < characterRightBounds)) {
                        int i19 = iPreviousEndBoundary;
                        int i20 = iNextStartBoundary;
                        while (true) {
                            i3 = i19;
                            if (i19 - i20 <= 1) {
                                break;
                            }
                            int i21 = (i3 + i20) / 2;
                            float f9 = fArr[(i21 - lineStart) * 2];
                            if ((z4 || f9 <= rectF.left) && (!z4 || f9 >= rectF.right)) {
                                i19 = i3;
                                i20 = i21;
                            } else {
                                i19 = i21;
                            }
                        }
                        i4 = z4 ? i3 : i20;
                    } else {
                        i4 = iNextStartBoundary;
                    }
                    int iNextEndBoundary2 = segmentFinder.nextEndBoundary(i4);
                    if (iNextEndBoundary2 != -1 && (iPreviousStartBoundary = segmentFinder.previousStartBoundary(iNextEndBoundary2)) < iPreviousEndBoundary) {
                        if (iPreviousStartBoundary >= iNextStartBoundary) {
                            iNextStartBoundary = iPreviousStartBoundary;
                        }
                        if (iNextEndBoundary2 > iPreviousEndBoundary) {
                            iNextEndBoundary2 = iPreviousEndBoundary;
                        }
                        layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                        RectF rectF3 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, lineTop, CropImageView.DEFAULT_ASPECT_RATIO, lineBottom);
                        int iNextEndBoundary3 = iNextEndBoundary2;
                        while (true) {
                            rectF3.left = z4 ? fArr[((iNextEndBoundary3 - 1) - lineStart) * 2] : fArr[(iNextStartBoundary - lineStart) * 2];
                            rectF3.right = z4 ? getCharacterRightBounds(iNextStartBoundary, lineStart, fArr) : getCharacterRightBounds(iNextEndBoundary3 - 1, lineStart, fArr);
                            if (((Boolean) composerKt$$ExternalSyntheticLambda0.invoke(rectF3, rectF)).booleanValue()) {
                                break;
                            }
                            iNextStartBoundary = segmentFinder.nextStartBoundary(iNextStartBoundary);
                            if (iNextStartBoundary != -1 && iNextStartBoundary < iPreviousEndBoundary) {
                                iNextEndBoundary3 = segmentFinder.nextEndBoundary(iNextStartBoundary);
                                if (iNextEndBoundary3 > iPreviousEndBoundary) {
                                    iNextEndBoundary3 = iPreviousEndBoundary;
                                }
                            }
                        }
                    } else {
                        layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                    }
                    iNextStartBoundary = -1;
                    break;
                } else {
                    layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                    iNextStartBoundary = -1;
                    break;
                }
            }
            if (iNextStartBoundary >= 0) {
                return iNextStartBoundary;
            }
            if (i11 == i12) {
                return -1;
            }
            i11 += i14;
            i13 = i14;
            layoutHelper$BidiRunArr = layoutHelper$BidiRunArr2;
        }
    }

    public static final boolean hasSpan(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }
}
