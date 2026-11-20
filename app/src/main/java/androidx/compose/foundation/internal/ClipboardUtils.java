package androidx.compose.foundation.internal;

import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.SpannableString;
import android.util.Base64;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.ULong;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ClipboardUtils {
    public static final StackTraceElement[] EmptyStackTraceElements = new StackTraceElement[0];

    /* JADX WARN: Code duplicated, block: B:36:0x00c2  */
    public static final ClipEntry toClipEntry(AnnotatedString annotatedString) {
        byte b;
        List list = annotatedString.spanStylesOrNull;
        EmptyList emptyList = EmptyList.INSTANCE;
        List list2 = list == null ? emptyList : list;
        CharSequence charSequence = annotatedString.text;
        if (!list2.isEmpty()) {
            SpannableString spannableString = new SpannableString(charSequence);
            DecodeHelper decodeHelper = new DecodeHelper();
            decodeHelper.parcel = Parcel.obtain();
            if (list == null) {
                list = emptyList;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                AnnotatedString.Range range = (AnnotatedString.Range) list.get(i);
                SpanStyle spanStyle = (SpanStyle) range.item;
                int i2 = range.start;
                int i3 = range.end;
                decodeHelper.parcel.recycle();
                decodeHelper.parcel = Parcel.obtain();
                TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
                long j = spanStyle.background;
                long j2 = spanStyle.letterSpacing;
                int i4 = i;
                long j3 = spanStyle.fontSize;
                List list3 = list;
                int i5 = size;
                long jMo768getColor0d7_KjU = textForegroundStyle.mo768getColor0d7_KjU();
                Rgb rgb = ColorSpaces.Unspecified;
                if (!ULong.m1869equalsimpl0(jMo768getColor0d7_KjU, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb))) {
                    decodeHelper.encode((byte) 1);
                    decodeHelper.parcel.writeLong(spanStyle.textForegroundStyle.mo768getColor0d7_KjU());
                }
                SpannableString spannableString2 = spannableString;
                if (!TextUnit.m812equalsimpl0(j3, IntMath.pack(0L, Float.NaN))) {
                    decodeHelper.encode((byte) 2);
                    decodeHelper.m111encodeR2X_6o(j3);
                }
                FontWeight fontWeight = spanStyle.fontWeight;
                if (fontWeight != null) {
                    decodeHelper.encode((byte) 3);
                    decodeHelper.parcel.writeInt(fontWeight.weight);
                }
                FontStyle fontStyle = spanStyle.fontStyle;
                if (fontStyle != null) {
                    int i6 = fontStyle.value;
                    decodeHelper.encode((byte) 4);
                    decodeHelper.encode((i6 != 0 && i6 == 1) ? (byte) 1 : (byte) 0);
                }
                FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
                if (fontSynthesis != null) {
                    int i7 = fontSynthesis.value;
                    decodeHelper.encode((byte) 5);
                    if (i7 == 0) {
                        b = 0;
                    } else if (i7 == 65535) {
                        b = 1;
                    } else if (i7 == 1) {
                        b = 2;
                    } else if (i7 == 2) {
                        b = 3;
                    } else {
                        b = 0;
                    }
                    decodeHelper.encode(b);
                }
                String str = spanStyle.fontFeatureSettings;
                if (str != null) {
                    decodeHelper.encode((byte) 6);
                    decodeHelper.parcel.writeString(str);
                }
                if (!TextUnit.m812equalsimpl0(j2, IntMath.pack(0L, Float.NaN))) {
                    decodeHelper.encode((byte) 7);
                    decodeHelper.m111encodeR2X_6o(j2);
                }
                BaselineShift baselineShift = spanStyle.baselineShift;
                if (baselineShift != null) {
                    float f = baselineShift.multiplier;
                    decodeHelper.encode((byte) 8);
                    decodeHelper.encode(f);
                }
                TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
                if (textGeometricTransform != null) {
                    decodeHelper.encode((byte) 9);
                    decodeHelper.encode(textGeometricTransform.scaleX);
                    decodeHelper.encode(textGeometricTransform.skewX);
                }
                if (!ULong.m1869equalsimpl0(j, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb))) {
                    decodeHelper.encode((byte) 10);
                    decodeHelper.parcel.writeLong(j);
                }
                TextDecoration textDecoration = spanStyle.textDecoration;
                if (textDecoration != null) {
                    decodeHelper.encode((byte) 11);
                    decodeHelper.parcel.writeInt(textDecoration.mask);
                }
                Shadow shadow = spanStyle.shadow;
                if (shadow != null) {
                    decodeHelper.encode((byte) 12);
                    decodeHelper.parcel.writeLong(shadow.color);
                    long j4 = shadow.offset;
                    decodeHelper.encode(Float.intBitsToFloat((int) (j4 >> 32)));
                    decodeHelper.encode(Float.intBitsToFloat((int) (j4 & 4294967295L)));
                    decodeHelper.encode(shadow.blurRadius);
                }
                spannableString2.setSpan(new Annotation("androidx.compose.text.SpanStyle", Base64.encodeToString(decodeHelper.parcel.marshall(), 0)), i2, i3, 33);
                i = i4 + 1;
                spannableString = spannableString2;
                list = list3;
                size = i5;
            }
            charSequence = spannableString;
        }
        return new ClipEntry(ClipData.newPlainText("plain text", charSequence));
    }
}
