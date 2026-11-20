package androidx.compose.ui.text;

import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.LineHeightSpan;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.android.AndroidLayoutApi34;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.TextAndroidCanvas;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinderApi29;
import androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinderUnderApi29;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.provider.CallbackWrapper;
import coil3.ImageLoader$Builder;
import coil3.network.NetworkFetcher;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph {
    public final CharSequence charSequence;
    public final long constraints;
    public final TextLayout layout;
    public final int maxLines;
    public final AndroidParagraphIntrinsics paragraphIntrinsics;
    public final List placeholderRects;
    public final float resolvedLineHeight;

    /* JADX WARN: Code duplicated, block: B:101:0x0148  */
    /* JADX WARN: Code duplicated, block: B:102:0x014b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0162  */
    /* JADX WARN: Code duplicated, block: B:107:0x016d  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:141:0x0232  */
    /* JADX WARN: Code duplicated, block: B:142:0x0235  */
    /* JADX WARN: Code duplicated, block: B:144:0x024f  */
    /* JADX WARN: Code duplicated, block: B:146:0x0269  */
    /* JADX WARN: Code duplicated, block: B:148:0x026d A[LOOP:1: B:147:0x026b->B:148:0x026d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x0296  */
    /* JADX WARN: Code duplicated, block: B:152:0x029a  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:156:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:157:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:160:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:162:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:166:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:167:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:169:0x02f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:190:0x0347  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:62:0x00df  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:73:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:75:0x0101 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0103  */
    /* JADX WARN: Code duplicated, block: B:79:0x010a  */
    /* JADX WARN: Code duplicated, block: B:80:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x010f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0113  */
    /* JADX WARN: Code duplicated, block: B:84:0x0115  */
    /* JADX WARN: Code duplicated, block: B:86:0x0118  */
    /* JADX WARN: Code duplicated, block: B:89:0x011f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0129  */
    /* JADX WARN: Code duplicated, block: B:95:0x0135  */
    /* JADX WARN: Code duplicated, block: B:97:0x0138  */
    /* JADX WARN: Code duplicated, block: B:99:0x0145  */
    /* JADX WARN: Instruction removed from duplicated block: B:146:0x0269, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i2, long j) throws Throwable {
        int i3;
        Throwable th;
        ParagraphStyle paragraphStyle;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Object obj;
        char c;
        TextUtils.TruncateAt truncateAt;
        TextUtils.TruncateAt truncateAt2;
        TextLayout textLayoutConstructTextLayout;
        int i14;
        AndroidParagraph androidParagraph;
        int i15;
        int i16;
        int i17;
        Layout layout;
        Spanned spanned;
        ShaderBrushSpan[] shaderBrushSpanArr;
        Object[] objArr;
        CharSequence charSequence;
        Spanned spanned2;
        Object[] spans;
        ArrayList arrayList;
        int length;
        int i18;
        List list;
        int spanEnd;
        int lineForOffset;
        boolean z;
        boolean z2;
        boolean z3;
        int i19;
        int i20;
        CharSequence charSequence2 = androidParagraphIntrinsics.charSequence;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i;
        this.constraints = j;
        if (Constraints.m785getMinHeightimpl(j) != 0 || Constraints.m786getMinWidthimpl(j) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        int i21 = 1;
        if (i < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLines should be greater than 0");
        }
        Spanned spanned3 = charSequence2 instanceof Spanned ? (Spanned) charSequence2 : null;
        if (spanned3 != null) {
            spanned3.nextSpanTransition(-1, spanned3.length(), LineHeightSpan.class);
            spanned3.length();
        }
        TextStyle textStyle = androidParagraphIntrinsics.style;
        if (i2 == 2) {
            i3 = 0;
            if (!TextUnit.m812equalsimpl0(textStyle.spanStyle.letterSpacing, IntMath.getSp(0))) {
                th = null;
                if (!TextUnit.m812equalsimpl0(textStyle.spanStyle.letterSpacing, IntMath.pack(0L, Float.NaN)) && (i20 = textStyle.paragraphStyle.textAlign) != 0 && i20 != 5 && i20 != 4 && charSequence2.length() != 0) {
                    Spannable spannableString = charSequence2 instanceof Spannable ? (Spannable) charSequence2 : null;
                    spannableString = spannableString == null ? new SpannableString(charSequence2) : spannableString;
                    if (!StaticLayoutFactory.hasSpan(spannableString, IndentationFixSpan.class)) {
                        spannableString.setSpan(new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1, 33);
                    }
                    charSequence2 = spannableString;
                }
            }
            CharSequence charSequence3 = charSequence2;
            this.charSequence = charSequence3;
            paragraphStyle = textStyle.paragraphStyle;
            SpanStyle spanStyle = textStyle.spanStyle;
            i4 = paragraphStyle.textAlign;
            if (i4 == 1) {
                i5 = 3;
            } else if (i4 == 2) {
                i5 = 4;
            } else if (i4 == 3) {
                i5 = 2;
            } else if (i4 == 5 && i4 == 6) {
                i5 = 1;
            } else {
                i5 = i3;
            }
            if (i4 == 4) {
                i6 = 1;
            } else {
                i6 = i3;
            }
            if (paragraphStyle.hyphens == 2) {
                i7 = i3;
            } else if (Build.VERSION.SDK_INT <= 32) {
                i7 = 2;
            } else {
                i7 = 4;
            }
            int i22 = paragraphStyle.lineBreak;
            i8 = i22 & 255;
            if (i8 != 1) {
                i9 = i3;
            } else if (i8 == 2) {
                i9 = 1;
            } else if (i8 == 3) {
                i9 = 2;
            } else {
                i9 = i3;
            }
            i10 = (i22 >> 8) & 255;
            if (i10 != 1) {
                i11 = i3;
            } else if (i10 == 2) {
                i11 = 1;
            } else if (i10 == 3) {
                i11 = 2;
            } else if (i10 == 4) {
                i11 = 3;
            } else {
                i11 = i3;
            }
            i12 = (i22 >> 16) & 255;
            if (i12 == 1 && i12 == 2) {
                i13 = 1;
            } else {
                i13 = i3;
            }
            if (i2 == 2) {
                if (i2 == 5) {
                    truncateAt = TextUtils.TruncateAt.MIDDLE;
                } else if (i2 == 4) {
                    truncateAt = TextUtils.TruncateAt.START;
                } else {
                    obj = th;
                    c = ' ';
                }
                i11 = i11;
                i5 = i5;
                truncateAt2 = truncateAt;
                c = ' ';
                i21 = 1;
                textLayoutConstructTextLayout = constructTextLayout(i5, i6, truncateAt2, i, i7, i9, i11, i13, charSequence3);
                Layout layout2 = textLayoutConstructTextLayout.layout;
                i14 = i5;
                if (Build.VERSION.SDK_INT < 35 || androidParagraphIntrinsics.textPaint.getLetterSpacing() == CropImageView.DEFAULT_ASPECT_RATIO || (!(i2 == 4 || i2 == 5) || layout2.getEllipsisCount(0) <= 0)) {
                    androidParagraph = this;
                    i15 = i;
                    i16 = i14;
                    i17 = 2;
                } else {
                    int ellipsisStart = layout2.getEllipsisStart(0);
                    int ellipsisCount = layout2.getEllipsisCount(0) + ellipsisStart;
                    CharSequence charSequenceSubSequence = charSequence3.subSequence(0, ellipsisStart);
                    CharSequence charSequenceSubSequence2 = charSequence3.subSequence(ellipsisCount, charSequence3.length());
                    CharSequence[] charSequenceArr = new CharSequence[3];
                    charSequenceArr[0] = charSequenceSubSequence;
                    charSequenceArr[i21] = "…";
                    i17 = 2;
                    charSequenceArr[2] = charSequenceSubSequence2;
                    AndroidParagraph androidParagraph2 = this;
                    i15 = i;
                    i16 = i14;
                    textLayoutConstructTextLayout = androidParagraph2.constructTextLayout(i16, i6, truncateAt2, i15, i7, i9, i11, i13, TextUtils.concat(charSequenceArr));
                    androidParagraph = androidParagraph2;
                }
                int i23 = textLayoutConstructTextLayout.lineCount;
                if (i2 == i17 || textLayoutConstructTextLayout.getHeight() <= Constraints.m783getMaxHeightimpl(j) || i15 <= i21) {
                    androidParagraph.layout = textLayoutConstructTextLayout;
                } else {
                    int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
                    for (int i24 = 0; i24 < i23; i24++) {
                        if (textLayoutConstructTextLayout.getLineBottom(i24) > iM783getMaxHeightimpl) {
                            i23 = i24;
                            break;
                        }
                    }
                    if (i23 >= 0 && i23 != androidParagraph.maxLines) {
                        textLayoutConstructTextLayout = androidParagraph.constructTextLayout(i16, i6, truncateAt2, i23 < 1 ? 1 : i23, i7, i9, i11, i13, androidParagraph.charSequence);
                    }
                    androidParagraph.layout = textLayoutConstructTextLayout;
                }
                layout = textLayoutConstructTextLayout.layout;
                androidParagraph.resolvedLineHeight = textLayoutConstructTextLayout.getHeight();
                textLayoutConstructTextLayout.getHeight();
                androidParagraph.paragraphIntrinsics.textPaint.m764setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
                if (layout.getText() instanceof Spanned) {
                    CharSequence text = layout.getText();
                    text.getClass();
                    spanned = (Spanned) text;
                    if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                        CharSequence text2 = layout.getText();
                        text2.getClass();
                        shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text2).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                    } else {
                        objArr = th;
                    }
                } else {
                    objArr = th;
                }
                if (objArr != 0) {
                    objArr = shaderBrushSpanArr;
                    for (ShaderBrushSpan shaderBrushSpan : objArr) {
                        shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                    }
                }
                objArr = shaderBrushSpanArr;
                charSequence = androidParagraph.charSequence;
                if (charSequence instanceof Spanned) {
                    spanned2 = (Spanned) charSequence;
                    spans = spanned2.getSpans(0, charSequence.length(), PlaceholderSpan.class);
                    arrayList = new ArrayList(spans.length);
                    length = spans.length;
                    i18 = 0;
                    while (i18 < length) {
                        PlaceholderSpan placeholderSpan = (PlaceholderSpan) spans[i18];
                        int spanStart = spanned2.getSpanStart(placeholderSpan);
                        spanEnd = spanned2.getSpanEnd(placeholderSpan);
                        lineForOffset = androidParagraph.layout.getLineForOffset(spanStart);
                        if (lineForOffset >= androidParagraph.maxLines) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                            z2 = false;
                        } else if (spanEnd > androidParagraph.layout.layout.getEllipsisStart(lineForOffset) + androidParagraph.layout.layout.getLineStart(lineForOffset)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2 && !z3) {
                            if (!z) {
                                boolean z4 = androidParagraph.layout.layout.getParagraphDirection(lineForOffset) == 1;
                                boolean zIsRtlCharAt = androidParagraph.layout.layout.isRtlCharAt(spanStart);
                                if (z4 && !zIsRtlCharAt) {
                                    androidParagraph.layout.getPrimaryHorizontal(spanStart, false);
                                    placeholderSpan.getWidthPx();
                                    throw th;
                                }
                                if (z4 && zIsRtlCharAt) {
                                    androidParagraph.layout.getSecondaryHorizontal(spanStart, false);
                                    placeholderSpan.getWidthPx();
                                    throw th;
                                }
                                TextLayout textLayout = androidParagraph.layout;
                                if (zIsRtlCharAt) {
                                    textLayout.getPrimaryHorizontal(spanStart, false);
                                    placeholderSpan.getWidthPx();
                                    throw th;
                                }
                                textLayout.getSecondaryHorizontal(spanStart, false);
                                placeholderSpan.getWidthPx();
                                throw th;
                            }
                        }
                        arrayList.add(th);
                        i18++;
                        th = th;
                    }
                    list = arrayList;
                } else {
                    list = EmptyList.INSTANCE;
                }
                androidParagraph.placeholderRects = list;
            }
            c = ' ';
            obj = TextUtils.TruncateAt.END;
            truncateAt2 = obj;
            textLayoutConstructTextLayout = constructTextLayout(i5, i6, truncateAt2, i, i7, i9, i11, i13, charSequence3);
            Layout layout3 = textLayoutConstructTextLayout.layout;
            i14 = i5;
            if (Build.VERSION.SDK_INT < 35) {
                androidParagraph = this;
                i15 = i;
                i16 = i14;
                i17 = 2;
            } else {
                androidParagraph = this;
                i15 = i;
                i16 = i14;
                i17 = 2;
            }
            int i25 = textLayoutConstructTextLayout.lineCount;
            if (i2 == i17) {
                androidParagraph.layout = textLayoutConstructTextLayout;
            } else {
                androidParagraph.layout = textLayoutConstructTextLayout;
            }
            layout = textLayoutConstructTextLayout.layout;
            androidParagraph.resolvedLineHeight = textLayoutConstructTextLayout.getHeight();
            textLayoutConstructTextLayout.getHeight();
            androidParagraph.paragraphIntrinsics.textPaint.m764setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
            if (layout.getText() instanceof Spanned) {
                objArr = th;
            } else {
                CharSequence text3 = layout.getText();
                text3.getClass();
                spanned = (Spanned) text3;
                if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                    CharSequence text4 = layout.getText();
                    text4.getClass();
                    shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text4).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                } else {
                    objArr = th;
                }
            }
            if (objArr != 0) {
                objArr = shaderBrushSpanArr;
                while (i19 < r2) {
                    shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                }
            }
            objArr = shaderBrushSpanArr;
            charSequence = androidParagraph.charSequence;
            if (charSequence instanceof Spanned) {
                list = EmptyList.INSTANCE;
            } else {
                spanned2 = (Spanned) charSequence;
                spans = spanned2.getSpans(0, charSequence.length(), PlaceholderSpan.class);
                arrayList = new ArrayList(spans.length);
                length = spans.length;
                i18 = 0;
                while (i18 < length) {
                    PlaceholderSpan placeholderSpan2 = (PlaceholderSpan) spans[i18];
                    int spanStart2 = spanned2.getSpanStart(placeholderSpan2);
                    spanEnd = spanned2.getSpanEnd(placeholderSpan2);
                    lineForOffset = androidParagraph.layout.getLineForOffset(spanStart2);
                    if (lineForOffset >= androidParagraph.maxLines) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                        z2 = false;
                    } else if (spanEnd > androidParagraph.layout.layout.getEllipsisStart(lineForOffset) + androidParagraph.layout.layout.getLineStart(lineForOffset)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2) {
                    }
                    arrayList.add(th);
                    i18++;
                    th = th;
                }
                list = arrayList;
            }
            androidParagraph.placeholderRects = list;
        }
        i3 = 0;
        th = null;
        CharSequence charSequence4 = charSequence2;
        this.charSequence = charSequence4;
        paragraphStyle = textStyle.paragraphStyle;
        SpanStyle spanStyle2 = textStyle.spanStyle;
        i4 = paragraphStyle.textAlign;
        if (i4 == 1) {
            i5 = 3;
        } else if (i4 == 2) {
            i5 = 4;
        } else if (i4 == 3) {
            i5 = 2;
        } else if (i4 == 5) {
            i5 = i3;
        } else {
            i5 = 1;
        }
        if (i4 == 4) {
            i6 = 1;
        } else {
            i6 = i3;
        }
        if (paragraphStyle.hyphens == 2) {
            i7 = i3;
        } else if (Build.VERSION.SDK_INT <= 32) {
            i7 = 2;
        } else {
            i7 = 4;
        }
        int i26 = paragraphStyle.lineBreak;
        i8 = i26 & 255;
        if (i8 != 1) {
            i9 = i3;
        } else if (i8 == 2) {
            i9 = 1;
        } else if (i8 == 3) {
            i9 = 2;
        } else {
            i9 = i3;
        }
        i10 = (i26 >> 8) & 255;
        if (i10 != 1) {
            i11 = i3;
        } else if (i10 == 2) {
            i11 = 1;
        } else if (i10 == 3) {
            i11 = 2;
        } else if (i10 == 4) {
            i11 = 3;
        } else {
            i11 = i3;
        }
        i12 = (i26 >> 16) & 255;
        if (i12 == 1) {
            i13 = i3;
        } else {
            i13 = 1;
        }
        if (i2 == 2) {
            if (i2 == 5) {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
            } else if (i2 == 4) {
                truncateAt = TextUtils.TruncateAt.START;
            } else {
                obj = th;
                c = ' ';
            }
            i11 = i11;
            i5 = i5;
            truncateAt2 = truncateAt;
            c = ' ';
            i21 = 1;
            textLayoutConstructTextLayout = constructTextLayout(i5, i6, truncateAt2, i, i7, i9, i11, i13, charSequence4);
            Layout layout4 = textLayoutConstructTextLayout.layout;
            i14 = i5;
            if (Build.VERSION.SDK_INT < 35) {
                androidParagraph = this;
                i15 = i;
                i16 = i14;
                i17 = 2;
            } else {
                androidParagraph = this;
                i15 = i;
                i16 = i14;
                i17 = 2;
            }
            int i27 = textLayoutConstructTextLayout.lineCount;
            if (i2 == i17) {
                androidParagraph.layout = textLayoutConstructTextLayout;
            } else {
                androidParagraph.layout = textLayoutConstructTextLayout;
            }
            layout = textLayoutConstructTextLayout.layout;
            androidParagraph.resolvedLineHeight = textLayoutConstructTextLayout.getHeight();
            textLayoutConstructTextLayout.getHeight();
            androidParagraph.paragraphIntrinsics.textPaint.m764setBrush12SF9DM(spanStyle2.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle2.textForegroundStyle.getAlpha());
            if (layout.getText() instanceof Spanned) {
                objArr = th;
            } else {
                CharSequence text5 = layout.getText();
                text5.getClass();
                spanned = (Spanned) text5;
                if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                    CharSequence text6 = layout.getText();
                    text6.getClass();
                    shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text6).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                } else {
                    objArr = th;
                }
            }
            if (objArr != 0) {
                objArr = shaderBrushSpanArr;
                while (i19 < r2) {
                    shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                }
            }
            objArr = shaderBrushSpanArr;
            charSequence = androidParagraph.charSequence;
            if (charSequence instanceof Spanned) {
                list = EmptyList.INSTANCE;
            } else {
                spanned2 = (Spanned) charSequence;
                spans = spanned2.getSpans(0, charSequence.length(), PlaceholderSpan.class);
                arrayList = new ArrayList(spans.length);
                length = spans.length;
                i18 = 0;
                while (i18 < length) {
                    PlaceholderSpan placeholderSpan3 = (PlaceholderSpan) spans[i18];
                    int spanStart3 = spanned2.getSpanStart(placeholderSpan3);
                    spanEnd = spanned2.getSpanEnd(placeholderSpan3);
                    lineForOffset = androidParagraph.layout.getLineForOffset(spanStart3);
                    if (lineForOffset >= androidParagraph.maxLines) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                        z2 = false;
                    } else if (spanEnd > androidParagraph.layout.layout.getEllipsisStart(lineForOffset) + androidParagraph.layout.layout.getLineStart(lineForOffset)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2) {
                    }
                    arrayList.add(th);
                    i18++;
                    th = th;
                }
                list = arrayList;
            }
            androidParagraph.placeholderRects = list;
        }
        c = ' ';
        obj = TextUtils.TruncateAt.END;
        truncateAt2 = obj;
        textLayoutConstructTextLayout = constructTextLayout(i5, i6, truncateAt2, i, i7, i9, i11, i13, charSequence4);
        Layout layout5 = textLayoutConstructTextLayout.layout;
        i14 = i5;
        if (Build.VERSION.SDK_INT < 35) {
            androidParagraph = this;
            i15 = i;
            i16 = i14;
            i17 = 2;
        } else {
            androidParagraph = this;
            i15 = i;
            i16 = i14;
            i17 = 2;
        }
        int i28 = textLayoutConstructTextLayout.lineCount;
        if (i2 == i17) {
            androidParagraph.layout = textLayoutConstructTextLayout;
        } else {
            androidParagraph.layout = textLayoutConstructTextLayout;
        }
        layout = textLayoutConstructTextLayout.layout;
        androidParagraph.resolvedLineHeight = textLayoutConstructTextLayout.getHeight();
        textLayoutConstructTextLayout.getHeight();
        androidParagraph.paragraphIntrinsics.textPaint.m764setBrush12SF9DM(spanStyle2.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle2.textForegroundStyle.getAlpha());
        if (layout.getText() instanceof Spanned) {
            objArr = th;
        } else {
            CharSequence text7 = layout.getText();
            text7.getClass();
            spanned = (Spanned) text7;
            if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                CharSequence text8 = layout.getText();
                text8.getClass();
                shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text8).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
            } else {
                objArr = th;
            }
        }
        if (objArr != 0) {
            objArr = shaderBrushSpanArr;
            while (i19 < r2) {
                shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.resolvedLineHeight)) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
            }
        }
        objArr = shaderBrushSpanArr;
        charSequence = androidParagraph.charSequence;
        if (charSequence instanceof Spanned) {
            list = EmptyList.INSTANCE;
        } else {
            spanned2 = (Spanned) charSequence;
            spans = spanned2.getSpans(0, charSequence.length(), PlaceholderSpan.class);
            arrayList = new ArrayList(spans.length);
            length = spans.length;
            i18 = 0;
            while (i18 < length) {
                PlaceholderSpan placeholderSpan4 = (PlaceholderSpan) spans[i18];
                int spanStart4 = spanned2.getSpanStart(placeholderSpan4);
                spanEnd = spanned2.getSpanEnd(placeholderSpan4);
                lineForOffset = androidParagraph.layout.getLineForOffset(spanStart4);
                if (lineForOffset >= androidParagraph.maxLines) {
                    z = true;
                } else {
                    z = false;
                }
                if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                    z2 = false;
                } else if (spanEnd > androidParagraph.layout.layout.getEllipsisStart(lineForOffset) + androidParagraph.layout.layout.getLineStart(lineForOffset)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2) {
                }
                arrayList.add(th);
                i18++;
                th = th;
            }
            list = arrayList;
        }
        androidParagraph.placeholderRects = list;
    }

    public final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        PlatformParagraphStyle platformParagraphStyle;
        float width = getWidth();
        AndroidParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        AndroidTextPaint androidTextPaint = androidParagraphIntrinsics.textPaint;
        int i8 = androidParagraphIntrinsics.textDirectionHeuristic;
        LayoutIntrinsics layoutIntrinsics = androidParagraphIntrinsics.layoutIntrinsics;
        TextStyle textStyle = androidParagraphIntrinsics.style;
        AndroidParagraphHelper_androidKt$NoopSpan$1 androidParagraphHelper_androidKt$NoopSpan$1 = AndroidParagraphHelper_androidKt.NoopSpan;
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        return new TextLayout(charSequence, width, androidTextPaint, i, truncateAt, i8, (platformTextStyle == null || (platformParagraphStyle = platformTextStyle.paragraphStyle) == null) ? false : platformParagraphStyle.includeFontPadding, i3, i5, i6, i7, i4, i2, layoutIntrinsics);
    }

    public final float getLineBaseline(int i) {
        TextLayout textLayout = this.layout;
        Paint.FontMetricsInt fontMetricsInt = textLayout.lastLineFontMetrics;
        return textLayout.topPadding + ((i != textLayout.lineCount + (-1) || fontMetricsInt == null) ? textLayout.layout.getLineBaseline(i) : textLayout.getLineTop(i) - fontMetricsInt.ascent) + CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m724getRangeForRect86BmAI(Rect rect, int i, ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0) {
        SegmentFinder graphemeClusterSegmentFinderApi29;
        int i2;
        int[] rangeForRect$ui_text;
        RectF androidRectF = ColorKt.toAndroidRectF(rect);
        int i3 = (i != 0 && i == 1) ? 1 : 0;
        ComposerKt$$ExternalSyntheticLambda0 composerKt$$ExternalSyntheticLambda0 = new ComposerKt$$ExternalSyntheticLambda0((byte) 28, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0);
        TextLayout textLayout = this.layout;
        Layout layout = textLayout.layout;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 34) {
            rangeForRect$ui_text = AndroidLayoutApi34.getRangeForRect$ui_text(textLayout, androidRectF, i3, composerKt$$ExternalSyntheticLambda0);
        } else {
            ImageLoader$Builder layoutHelper = textLayout.getLayoutHelper();
            if (i3 == 1) {
                graphemeClusterSegmentFinderApi29 = new CallbackWrapper(layout.getText(), textLayout.getWordIterator(), (byte) 12);
            } else {
                CharSequence text = layout.getText();
                graphemeClusterSegmentFinderApi29 = i4 >= 29 ? new GraphemeClusterSegmentFinderApi29(text, textLayout.textPaint) : new GraphemeClusterSegmentFinderUnderApi29(text);
            }
            SegmentFinder segmentFinder = graphemeClusterSegmentFinderApi29;
            int lineForVertical = layout.getLineForVertical((int) androidRectF.top);
            if (androidRectF.top <= textLayout.getLineBottom(lineForVertical) || (lineForVertical = lineForVertical + 1) < textLayout.lineCount) {
                int i5 = lineForVertical;
                int lineForVertical2 = layout.getLineForVertical((int) androidRectF.bottom);
                if (lineForVertical2 != 0 || androidRectF.bottom >= textLayout.getLineTop(0)) {
                    int startOrEndOffsetForRectWithinLine = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i5, androidRectF, segmentFinder, composerKt$$ExternalSyntheticLambda0, true);
                    while (true) {
                        i2 = i5;
                        if (startOrEndOffsetForRectWithinLine != -1 || i2 >= lineForVertical2) {
                            break;
                        }
                        i5 = i2 + 1;
                        startOrEndOffsetForRectWithinLine = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i5, androidRectF, segmentFinder, composerKt$$ExternalSyntheticLambda0, true);
                    }
                    if (startOrEndOffsetForRectWithinLine == -1) {
                        rangeForRect$ui_text = null;
                    } else {
                        int i6 = lineForVertical2;
                        int startOrEndOffsetForRectWithinLine2 = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i6, androidRectF, segmentFinder, composerKt$$ExternalSyntheticLambda0, false);
                        while (startOrEndOffsetForRectWithinLine2 == -1 && i2 < i6) {
                            i6--;
                            startOrEndOffsetForRectWithinLine2 = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i6, androidRectF, segmentFinder, composerKt$$ExternalSyntheticLambda0, false);
                        }
                        if (startOrEndOffsetForRectWithinLine2 == -1) {
                            rangeForRect$ui_text = null;
                        } else {
                            rangeForRect$ui_text = new int[]{segmentFinder.previousStartBoundary(startOrEndOffsetForRectWithinLine + 1), segmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
                        }
                    }
                } else {
                    rangeForRect$ui_text = null;
                }
            } else {
                rangeForRect$ui_text = null;
            }
        }
        return rangeForRect$ui_text == null ? TextRange.Zero : TextRangeKt.TextRange(rangeForRect$ui_text[0], rangeForRect$ui_text[1]);
    }

    public final float getWidth() {
        return Constraints.m784getMaxWidthimpl(this.constraints);
    }

    public final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        TextLayout textLayout = this.layout;
        if (textLayout.didExceedMaxLines) {
            nativeCanvas.save();
            nativeCanvas.clipRect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, getWidth(), this.resolvedLineHeight);
        }
        int i = textLayout.topPadding;
        if (nativeCanvas.getClipBounds(textLayout.rect)) {
            if (i != 0) {
                nativeCanvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, i);
            }
            ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
            Object textAndroidCanvas = threadLocal.get();
            if (textAndroidCanvas == null) {
                textAndroidCanvas = new TextAndroidCanvas();
                threadLocal.set(textAndroidCanvas);
            }
            TextAndroidCanvas textAndroidCanvas2 = (TextAndroidCanvas) textAndroidCanvas;
            textAndroidCanvas2._nativeCanvas = nativeCanvas;
            try {
                textLayout.layout.draw(textAndroidCanvas2);
                textAndroidCanvas2._nativeCanvas = null;
                if (i != 0) {
                    nativeCanvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, (-1.0f) * i);
                }
            } catch (Throwable th) {
                textAndroidCanvas2._nativeCanvas = null;
                throw th;
            }
        }
        if (textLayout.didExceedMaxLines) {
            nativeCanvas.restore();
        }
    }

    /* JADX INFO: renamed from: paint-LG529CI, reason: not valid java name */
    public final void m725paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        AndroidTextPaint androidTextPaint = this.paragraphIntrinsics.textPaint;
        byte b = androidTextPaint.backingBlendMode;
        androidTextPaint.m765setColor8_81llA(j);
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.m763setBlendModes9anfk8(3);
        NetworkFetcher.AnonymousClass2 anonymousClass2 = new NetworkFetcher.AnonymousClass2(1, this, AndroidParagraph.class, "paint", "paint(Landroidx/compose/ui/graphics/Canvas;)V", 0, (byte) 5);
        if (CropImageView.DEFAULT_ASPECT_RATIO == CropImageView.DEFAULT_ASPECT_RATIO) {
            anonymousClass2.invoke(canvas);
        } else {
            canvas.save();
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            anonymousClass2.invoke(canvas);
            canvas.restore();
        }
        androidTextPaint.m763setBlendModes9anfk8(b);
    }

    /* JADX INFO: renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m726painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        AndroidTextPaint androidTextPaint = this.paragraphIntrinsics.textPaint;
        byte b = androidTextPaint.backingBlendMode;
        androidTextPaint.m764setBrush12SF9DM(brush, (((long) Float.floatToRawIntBits(getWidth())) << 32) | (((long) Float.floatToRawIntBits(this.resolvedLineHeight)) & 4294967295L), f);
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.m763setBlendModes9anfk8(3);
        NetworkFetcher.AnonymousClass2 anonymousClass2 = new NetworkFetcher.AnonymousClass2(1, this, AndroidParagraph.class, "paint", "paint(Landroidx/compose/ui/graphics/Canvas;)V", 0, (byte) 6);
        if (CropImageView.DEFAULT_ASPECT_RATIO == CropImageView.DEFAULT_ASPECT_RATIO) {
            anonymousClass2.invoke(canvas);
        } else {
            canvas.save();
            canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
            anonymousClass2.invoke(canvas);
            canvas.restore();
        }
        androidTextPaint.m763setBlendModes9anfk8(b);
    }
}
