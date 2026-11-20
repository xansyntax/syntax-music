package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.media3.common.util.TimedValueQueue;
import androidx.sqlite.SQLite;
import coil3.ImageLoader$Builder;
import com.metrolist.music.ui.component.AppNavigationKt$$ExternalSyntheticApiModelOutline0;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextLayout {
    public ImageLoader$Builder backingLayoutHelper;
    public TimedValueQueue backingWordIterator;
    public final int bottomPadding;
    public final boolean didExceedMaxLines;
    public final TextUtils.TruncateAt ellipsize;
    public final boolean includePadding;
    public final int lastLineExtra;
    public final Paint.FontMetricsInt lastLineFontMetrics;
    public final Layout layout;
    public final float leftPadding;
    public final int lineCount;
    public final LineHeightStyleSpan[] lineHeightSpans;
    public final Rect rect = new Rect();
    public final float rightPadding;
    public final TextPaint textPaint;
    public final int topPadding;

    /* JADX WARN: Code duplicated, block: B:122:0x021e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0220  */
    /* JADX WARN: Code duplicated, block: B:125:0x0225  */
    /* JADX WARN: Code duplicated, block: B:126:0x0227  */
    /* JADX WARN: Code duplicated, block: B:51:0x010c  */
    /* JADX WARN: Code duplicated, block: B:73:0x015f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0176  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a1 A[PHI: r14
      0x01a1: PHI (r14v7 int) = (r14v6 int), (r14v9 int) binds: [B:100:0x01b3, B:93:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r26v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [android.graphics.Paint$FontMetricsInt] */
    /* JADX WARN: Type inference failed for: r6v25 */
    public TextLayout(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, LayoutIntrinsics layoutIntrinsics) throws Throwable {
        int i9;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout layoutCreate;
        boolean z2;
        int i10;
        LineHeightStyleSpan[] lineHeightStyleSpanArr;
        int i11;
        int i12;
        int i13;
        long jVerticalPaddings;
        int i14;
        long j;
        char c;
        Throwable th;
        int i15;
        long jVerticalPaddings2;
        int i16;
        int i17;
        long jVerticalPaddings3;
        ?? r13;
        boolean zIsFallbackLineSpacingEnabled;
        int topPadding;
        boolean zIsFallbackLineSpacingEnabled2;
        int i18;
        ?? r6;
        boolean z3;
        ?? r15;
        int i19;
        this.textPaint = textPaint;
        this.ellipsize = truncateAt;
        this.includePadding = z;
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristic2 = TextLayout_androidKt.getTextDirectionHeuristic(i2);
        Layout.Alignment alignment = TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK;
        Layout.Alignment alignment2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? Layout.Alignment.ALIGN_NORMAL : TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK : TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK : Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        boolean z4 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, SkewXSpan.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics boringMetrics = layoutIntrinsics.getBoringMetrics();
            double d = f;
            int iCeil = (int) Math.ceil(d);
            if (boringMetrics == null || layoutIntrinsics.getMaxIntrinsicWidth() > f || z4) {
                i9 = i3;
                textDirectionHeuristic = textDirectionHeuristic2;
                layoutCreate = StaticLayoutFactory.create(charSequence, textPaint, iCeil, charSequence.length(), textDirectionHeuristic, alignment2, i9, truncateAt, (int) Math.ceil(d), i8, z, i4, i5, i6, i7);
                z2 = false;
            } else {
                if (iCeil < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("negative width");
                }
                if (iCeil < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("negative ellipsized width");
                }
                layoutCreate = Build.VERSION.SDK_INT >= 33 ? AppNavigationKt$$ExternalSyntheticApiModelOutline0.m(charSequence, textPaint, iCeil, alignment2, boringMetrics, z, truncateAt, iCeil) : new BoringLayout(charSequence, textPaint, iCeil, alignment2, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, boringMetrics, z, truncateAt, iCeil);
                i9 = i3;
                textDirectionHeuristic = textDirectionHeuristic2;
                z2 = true;
            }
            this.layout = layoutCreate;
            Trace.endSection();
            int iMin = Math.min(layoutCreate.getLineCount(), i9);
            this.lineCount = iMin;
            int i20 = iMin - 1;
            this.didExceedMaxLines = iMin >= i9 && (layoutCreate.getEllipsisCount(i20) > 0 || layoutCreate.getLineEnd(i20) != charSequence.length());
            if (layoutCreate.getText() instanceof Spanned) {
                CharSequence text = layoutCreate.getText();
                text.getClass();
                if (StaticLayoutFactory.hasSpan((Spanned) text, LineHeightStyleSpan.class) || layoutCreate.getText().length() <= 0) {
                    CharSequence text2 = layoutCreate.getText();
                    text2.getClass();
                    i10 = 0;
                    lineHeightStyleSpanArr = (LineHeightStyleSpan[]) ((Spanned) text2).getSpans(0, layoutCreate.getText().length(), LineHeightStyleSpan.class);
                } else {
                    lineHeightStyleSpanArr = null;
                    i10 = 0;
                }
            } else {
                lineHeightStyleSpanArr = null;
                i10 = 0;
            }
            this.lineHeightSpans = lineHeightStyleSpanArr;
            if (lineHeightStyleSpanArr == null) {
                i11 = 2;
                i12 = i10;
            } else {
                LineHeightStyleSpan lineHeightStyleSpan = lineHeightStyleSpanArr.length == 0 ? null : lineHeightStyleSpanArr[i10];
                if (lineHeightStyleSpan != null) {
                    if (lineHeightStyleSpan.trimFirstLineTop) {
                        i11 = 2;
                        i19 = lineHeightStyleSpan.mode == 2 ? 1 : i19;
                        i12 = i19;
                    } else {
                        i11 = 2;
                    }
                    i19 = i10;
                    i12 = i19;
                } else {
                    i11 = 2;
                    i12 = i10;
                }
            }
            if (lineHeightStyleSpanArr == null) {
                i13 = i10;
            } else {
                LineHeightStyleSpan lineHeightStyleSpan2 = lineHeightStyleSpanArr.length == 0 ? null : lineHeightStyleSpanArr[i10];
                if (lineHeightStyleSpan2 != null && lineHeightStyleSpan2.trimLastLineBottom && lineHeightStyleSpan2.mode == i11) {
                    i13 = 1;
                } else {
                    i13 = i10;
                }
            }
            if (i12 == 0 || i13 == 0) {
                jVerticalPaddings = TextLayout_androidKt.ZeroVerticalPadding;
                if (z) {
                    i14 = 33;
                } else {
                    if (z2) {
                        BoringLayout boringLayout = (BoringLayout) layoutCreate;
                        i14 = 33;
                        if (Build.VERSION.SDK_INT >= 33) {
                            zIsFallbackLineSpacingEnabled2 = BoringLayoutFactory33.isFallbackLineSpacingEnabled(boringLayout);
                        } else {
                            r13 = i10;
                        }
                    } else {
                        i14 = 33;
                        StaticLayout staticLayout = (StaticLayout) layoutCreate;
                        int i21 = Build.VERSION.SDK_INT;
                        if (i21 >= 33) {
                            zIsFallbackLineSpacingEnabled = BoringLayoutFactory33.isFallbackLineSpacingEnabled(staticLayout);
                        } else if (i21 >= 28) {
                            r13 = 1;
                        } else {
                            r13 = i10;
                        }
                    }
                    if (r13 == 0) {
                        r13 = zIsFallbackLineSpacingEnabled;
                        TextPaint paint = layoutCreate.getPaint();
                        CharSequence text3 = layoutCreate.getText();
                        th = null;
                        c = ' ';
                        Rect charSequenceBounds = StaticLayoutFactory.getCharSequenceBounds(paint, text3, layoutCreate.getLineStart(i10), layoutCreate.getLineEnd(i10));
                        int lineAscent = layoutCreate.getLineAscent(i10);
                        j = 4294967295L;
                        int i22 = charSequenceBounds.top;
                        if (i22 < lineAscent) {
                            r13 = zIsFallbackLineSpacingEnabled2;
                            topPadding = lineAscent - i22;
                        } else {
                            r13 = zIsFallbackLineSpacingEnabled2;
                            topPadding = layoutCreate.getTopPadding();
                        }
                        i15 = 1;
                        charSequenceBounds = iMin != 1 ? StaticLayoutFactory.getCharSequenceBounds(paint, text3, layoutCreate.getLineStart(i20), layoutCreate.getLineEnd(i20)) : charSequenceBounds;
                        int lineDescent = layoutCreate.getLineDescent(i20);
                        int i23 = charSequenceBounds.bottom;
                        int bottomPadding = i23 > lineDescent ? i23 - lineDescent : layoutCreate.getBottomPadding();
                        jVerticalPaddings2 = (topPadding == 0 && bottomPadding == 0) ? jVerticalPaddings2 : TextLayout_androidKt.VerticalPaddings(topPadding, bottomPadding);
                        if (i12 != 0) {
                            i16 = i10;
                        } else {
                            i16 = (int) (jVerticalPaddings2 >> c);
                        }
                        if (i13 != 0) {
                            i17 = i10;
                        } else {
                            i17 = (int) (jVerticalPaddings2 & j);
                        }
                        jVerticalPaddings3 = TextLayout_androidKt.VerticalPaddings(i16, i17);
                    }
                    jVerticalPaddings2 = jVerticalPaddings;
                    if (i12 != 0) {
                        i16 = i10;
                    } else {
                        i16 = (int) (jVerticalPaddings2 >> c);
                    }
                    if (i13 != 0) {
                        i17 = i10;
                    } else {
                        i17 = (int) (jVerticalPaddings2 & j);
                    }
                    jVerticalPaddings3 = TextLayout_androidKt.VerticalPaddings(i16, i17);
                }
                r13 = zIsFallbackLineSpacingEnabled;
                r13 = zIsFallbackLineSpacingEnabled2;
                th = null;
                c = ' ';
                j = 4294967295L;
                i15 = 1;
                jVerticalPaddings2 = jVerticalPaddings;
                if (i12 != 0) {
                    i16 = i10;
                } else {
                    i16 = (int) (jVerticalPaddings2 >> c);
                }
                if (i13 != 0) {
                    i17 = i10;
                } else {
                    i17 = (int) (jVerticalPaddings2 & j);
                }
                jVerticalPaddings3 = TextLayout_androidKt.VerticalPaddings(i16, i17);
            } else {
                jVerticalPaddings3 = TextLayout_androidKt.ZeroVerticalPadding;
                jVerticalPaddings = jVerticalPaddings3;
                th = null;
                c = ' ';
                j = 4294967295L;
                i15 = 1;
                i14 = 33;
            }
            if (lineHeightStyleSpanArr != null) {
                int length2 = lineHeightStyleSpanArr.length;
                int iMax = i10;
                int iMax2 = iMax;
                for (int i24 = iMax2; i24 < length2; i24++) {
                    LineHeightStyleSpan lineHeightStyleSpan3 = lineHeightStyleSpanArr[i24];
                    int i25 = lineHeightStyleSpan3.firstAscentDiff;
                    iMax = i25 < 0 ? Math.max(iMax, Math.abs(i25)) : iMax;
                    int i26 = lineHeightStyleSpan3.lastDescentDiff;
                    if (i26 < 0) {
                        iMax2 = Math.max(iMax, Math.abs(i26));
                    }
                }
                jVerticalPaddings = (iMax == 0 && iMax2 == 0) ? TextLayout_androidKt.ZeroVerticalPadding : TextLayout_androidKt.VerticalPaddings(iMax, iMax2);
            }
            this.topPadding = Math.max((int) (jVerticalPaddings3 >> c), (int) (jVerticalPaddings >> c));
            this.bottomPadding = Math.max((int) (jVerticalPaddings3 & j), (int) (jVerticalPaddings & j));
            TextPaint textPaint2 = this.textPaint;
            LineHeightStyleSpan[] lineHeightStyleSpanArr2 = this.lineHeightSpans;
            int i27 = this.lineCount - i15;
            Layout layout = this.layout;
            if (layout.getLineStart(i27) != layout.getLineEnd(i27) || lineHeightStyleSpanArr2 == null || lineHeightStyleSpanArr2.length == 0) {
                i18 = i10;
                r6 = th;
            } else {
                SpannableString spannableString = new SpannableString("\u200b");
                if (lineHeightStyleSpanArr2.length == 0) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
                    throw th;
                }
                LineHeightStyleSpan lineHeightStyleSpan4 = lineHeightStyleSpanArr2[i10];
                int length3 = spannableString.length();
                if (i27 == 0 || !(z3 = lineHeightStyleSpan4.trimLastLineBottom)) {
                    boolean z5 = lineHeightStyleSpan4.trimLastLineBottom;
                    z3 = z5 ? 1 : 0;
                    r15 = z5;
                } else {
                    r15 = i10;
                }
                spannableString.setSpan(new LineHeightStyleSpan(lineHeightStyleSpan4.lineHeight, length3, r15, z3, lineHeightStyleSpan4.topRatio, lineHeightStyleSpan4.mode), i10, spannableString.length(), i14);
                i18 = i10;
                StaticLayout staticLayoutCreate = StaticLayoutFactory.create(spannableString, textPaint2, Integer.MAX_VALUE, spannableString.length(), textDirectionHeuristic, LayoutCompat.DEFAULT_LAYOUT_ALIGNMENT, Integer.MAX_VALUE, null, Integer.MAX_VALUE, 0, this.includePadding, 0, 0, 0, 0);
                Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
                fontMetricsInt.ascent = staticLayoutCreate.getLineAscent(i18);
                fontMetricsInt.descent = staticLayoutCreate.getLineDescent(i18);
                fontMetricsInt.top = staticLayoutCreate.getLineTop(i18);
                fontMetricsInt.bottom = staticLayoutCreate.getLineBottom(i18);
                r6 = fontMetricsInt;
            }
            this.lastLineExtra = r6 != 0 ? ((Paint.FontMetricsInt) r6).bottom - ((int) getLineHeight(i20)) : i18;
            this.lastLineFontMetrics = r6;
            Layout layout2 = this.layout;
            this.leftPadding = SQLite.getEllipsizedLeftPadding(layout2, i20, layout2.getPaint());
            Layout layout3 = this.layout;
            this.rightPadding = SQLite.getEllipsizedRightPadding(layout3, i20, layout3.getPaint());
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final int getHeight() {
        boolean z = this.didExceedMaxLines;
        Layout layout = this.layout;
        return (z ? layout.getLineBottom(this.lineCount - 1) : layout.getHeight()) + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final float getHorizontalPadding(int i) {
        return i == this.lineCount + (-1) ? this.leftPadding + this.rightPadding : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final ImageLoader$Builder getLayoutHelper() {
        ImageLoader$Builder imageLoader$Builder = this.backingLayoutHelper;
        if (imageLoader$Builder != null) {
            return imageLoader$Builder;
        }
        ImageLoader$Builder imageLoader$Builder2 = new ImageLoader$Builder(this.layout);
        this.backingLayoutHelper = imageLoader$Builder2;
        return imageLoader$Builder2;
    }

    public final float getLineBottom(int i) {
        Paint.FontMetricsInt fontMetricsInt;
        int i2 = this.lineCount;
        int i3 = i2 - 1;
        Layout layout = this.layout;
        if (i != i3 || (fontMetricsInt = this.lastLineFontMetrics) == null) {
            return this.topPadding + layout.getLineBottom(i) + (i == i2 + (-1) ? this.bottomPadding : 0);
        }
        return layout.getLineBottom(i - 1) + fontMetricsInt.bottom;
    }

    public final int getLineEnd(int i) {
        ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
        Layout layout = this.layout;
        return (layout.getEllipsisCount(i) <= 0 || this.ellipsize != TextUtils.TruncateAt.END) ? layout.getLineEnd(i) : layout.getText().length();
    }

    public final int getLineForOffset(int i) {
        int i2 = this.lineCount;
        if (i2 <= 0) {
            return 0;
        }
        Layout layout = this.layout;
        if (i >= layout.getText().length()) {
            return i2 - 1;
        }
        if (i <= 0) {
            return 0;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int i3 = i2 - 1;
        return lineForOffset > i3 ? i3 : lineForOffset;
    }

    public final float getLineHeight(int i) {
        return getLineBottom(i) - getLineTop(i);
    }

    public final float getLineTop(int i) {
        return this.layout.getLineTop(i) + (i == 0 ? 0 : this.topPadding);
    }

    public final float getPrimaryHorizontal(int i, boolean z) {
        return getHorizontalPadding(getLineForOffset(i)) + getLayoutHelper().getHorizontalPosition(i, true, z);
    }

    public final float getSecondaryHorizontal(int i, boolean z) {
        return getHorizontalPadding(getLineForOffset(i)) + getLayoutHelper().getHorizontalPosition(i, false, z);
    }

    public final TimedValueQueue getWordIterator() {
        TimedValueQueue timedValueQueue = this.backingWordIterator;
        if (timedValueQueue != null) {
            return timedValueQueue;
        }
        Layout layout = this.layout;
        TimedValueQueue timedValueQueue2 = new TimedValueQueue(layout.getText(), layout.getText().length(), this.textPaint.getTextLocale());
        this.backingWordIterator = timedValueQueue2;
        return timedValueQueue2;
    }
}
