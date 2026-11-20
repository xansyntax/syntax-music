package androidx.media3.common.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Cue {
    public static final String FIELD_BITMAP_BYTES;
    public static final String FIELD_BITMAP_HEIGHT;
    public static final String FIELD_BITMAP_PARCELABLE;
    public static final String FIELD_CUSTOM_SPANS;
    public static final String FIELD_LINE;
    public static final String FIELD_LINE_ANCHOR;
    public static final String FIELD_LINE_TYPE;
    public static final String FIELD_MULTI_ROW_ALIGNMENT;
    public static final String FIELD_POSITION;
    public static final String FIELD_POSITION_ANCHOR;
    public static final String FIELD_SHEAR_DEGREES;
    public static final String FIELD_SIZE;
    public static final String FIELD_TEXT;
    public static final String FIELD_TEXT_ALIGNMENT;
    public static final String FIELD_TEXT_SIZE;
    public static final String FIELD_TEXT_SIZE_TYPE;
    public static final String FIELD_VERTICAL_TYPE;
    public static final String FIELD_WINDOW_COLOR;
    public static final String FIELD_WINDOW_COLOR_SET;
    public static final String FIELD_Z_INDEX;
    public final Bitmap bitmap;
    public final float bitmapHeight;
    public final float line;
    public final int lineAnchor;
    public final int lineType;
    public final Layout.Alignment multiRowAlignment;
    public final float position;
    public final int positionAnchor;
    public final float shearDegrees;
    public final float size;
    public final CharSequence text;
    public final Layout.Alignment textAlignment;
    public final float textSize;
    public final int textSizeType;
    public final int verticalType;
    public final int windowColor;
    public final boolean windowColorSet;
    public final int zIndex;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public float shearDegrees;
        public CharSequence text = null;
        public Bitmap bitmap = null;
        public Layout.Alignment textAlignment = null;
        public Layout.Alignment multiRowAlignment = null;
        public float line = -3.4028235E38f;
        public int lineType = Integer.MIN_VALUE;
        public int lineAnchor = Integer.MIN_VALUE;
        public float position = -3.4028235E38f;
        public int positionAnchor = Integer.MIN_VALUE;
        public int textSizeType = Integer.MIN_VALUE;
        public float textSize = -3.4028235E38f;
        public float size = -3.4028235E38f;
        public final float bitmapHeight = -3.4028235E38f;
        public final boolean windowColorSet = false;
        public final int windowColor = -16777216;
        public int verticalType = Integer.MIN_VALUE;

        public final Cue build() {
            return new Cue(this.text, this.textAlignment, this.multiRowAlignment, this.bitmap, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.textSizeType, this.textSize, this.size, this.bitmapHeight, this.windowColorSet, this.windowColor, this.verticalType, this.shearDegrees, 0);
        }
    }

    static {
        new Cue("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_TEXT = Integer.toString(0, 36);
        FIELD_CUSTOM_SPANS = Integer.toString(17, 36);
        FIELD_TEXT_ALIGNMENT = Integer.toString(1, 36);
        FIELD_MULTI_ROW_ALIGNMENT = Integer.toString(2, 36);
        FIELD_BITMAP_PARCELABLE = Integer.toString(3, 36);
        FIELD_BITMAP_BYTES = Integer.toString(18, 36);
        FIELD_LINE = Integer.toString(4, 36);
        FIELD_LINE_TYPE = Integer.toString(5, 36);
        FIELD_LINE_ANCHOR = Integer.toString(6, 36);
        FIELD_POSITION = Integer.toString(7, 36);
        FIELD_POSITION_ANCHOR = Integer.toString(8, 36);
        FIELD_TEXT_SIZE_TYPE = Integer.toString(9, 36);
        FIELD_TEXT_SIZE = Integer.toString(10, 36);
        FIELD_SIZE = Integer.toString(11, 36);
        FIELD_BITMAP_HEIGHT = Integer.toString(12, 36);
        FIELD_WINDOW_COLOR = Integer.toString(13, 36);
        FIELD_WINDOW_COLOR_SET = Integer.toString(14, 36);
        FIELD_VERTICAL_TYPE = Integer.toString(15, 36);
        FIELD_SHEAR_DEGREES = Integer.toString(16, 36);
        FIELD_Z_INDEX = Integer.toString(19, 36);
    }

    public Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6, int i7) {
        if (charSequence == null) {
            bitmap.getClass();
        } else {
            UtilsKt.checkArgument(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.text = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.text = charSequence.toString();
        } else {
            this.text = null;
        }
        this.textAlignment = alignment;
        this.multiRowAlignment = alignment2;
        this.bitmap = bitmap;
        this.line = f;
        this.lineType = i;
        this.lineAnchor = i2;
        this.position = f2;
        this.positionAnchor = i3;
        this.size = f4;
        this.bitmapHeight = f5;
        this.windowColorSet = z;
        this.windowColor = i5;
        this.textSizeType = i4;
        this.textSize = f3;
        this.verticalType = i6;
        this.shearDegrees = f6;
        this.zIndex = i7;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:60:0x0151  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31, types: [android.text.Spannable, android.text.SpannableString] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v3 */
    public static Cue fromBundle(Bundle bundle) {
        ?? r7;
        Bitmap bitmapDecodeByteArray;
        float f;
        int i;
        float f2;
        int i2;
        int i3;
        ?? charSequence = bundle.getCharSequence(FIELD_TEXT);
        boolean z = true;
        if (charSequence != 0) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUSTOM_SPANS);
            if (parcelableArrayList != null) {
                charSequence = SpannableString.valueOf(charSequence);
                int size = parcelableArrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = parcelableArrayList.get(i4);
                    i4++;
                    Bundle bundle2 = (Bundle) obj;
                    int i5 = bundle2.getInt(CustomSpanBundler.FIELD_START_INDEX);
                    int i6 = bundle2.getInt(CustomSpanBundler.FIELD_END_INDEX);
                    int i7 = bundle2.getInt(CustomSpanBundler.FIELD_FLAGS);
                    int i8 = bundle2.getInt(CustomSpanBundler.FIELD_TYPE, -1);
                    Bundle bundle3 = bundle2.getBundle(CustomSpanBundler.FIELD_PARAMS);
                    if (i8 == 1) {
                        bundle3.getClass();
                        String string = bundle3.getString(RubySpan.FIELD_TEXT);
                        string.getClass();
                        charSequence.setSpan(new RubySpan(string, bundle3.getInt(RubySpan.FIELD_POSITION)), i5, i6, i7);
                    } else if (i8 == 2) {
                        bundle3.getClass();
                        charSequence.setSpan(new TextEmphasisSpan(bundle3.getInt(TextEmphasisSpan.FIELD_MARK_SHAPE), bundle3.getInt(TextEmphasisSpan.FIELD_MARK_FILL), bundle3.getInt(TextEmphasisSpan.FIELD_POSITION)), i5, i6, i7);
                    } else if (i8 == 3) {
                        charSequence.setSpan(new HorizontalTextInVerticalContextSpan(), i5, i6, i7);
                    } else if (i8 == 4) {
                        bundle3.getClass();
                        String string2 = bundle3.getString(VoiceSpan.FIELD_NAME);
                        string2.getClass();
                        charSequence.setSpan(new VoiceSpan(string2), i5, i6, i7);
                    }
                }
            }
        } else {
            charSequence = 0;
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(FIELD_TEXT_ALIGNMENT);
        Layout.Alignment alignment2 = alignment != null ? alignment : null;
        Layout.Alignment alignment3 = (Layout.Alignment) bundle.getSerializable(FIELD_MULTI_ROW_ALIGNMENT);
        Layout.Alignment alignment4 = alignment3 != null ? alignment3 : null;
        Bitmap bitmap = (Bitmap) bundle.getParcelable(FIELD_BITMAP_PARCELABLE);
        if (bitmap != null) {
            r7 = 0;
            bitmapDecodeByteArray = bitmap;
        } else {
            byte[] byteArray = bundle.getByteArray(FIELD_BITMAP_BYTES);
            if (byteArray != null) {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                r7 = 0;
            } else {
                r7 = charSequence;
                bitmapDecodeByteArray = null;
            }
        }
        String str = FIELD_LINE;
        if (bundle.containsKey(str)) {
            String str2 = FIELD_LINE_TYPE;
            if (bundle.containsKey(str2)) {
                f = bundle.getFloat(str);
                i = bundle.getInt(str2);
            } else {
                f = -3.4028235E38f;
                i = Integer.MIN_VALUE;
            }
        } else {
            f = -3.4028235E38f;
            i = Integer.MIN_VALUE;
        }
        String str3 = FIELD_LINE_ANCHOR;
        int i9 = bundle.containsKey(str3) ? bundle.getInt(str3) : Integer.MIN_VALUE;
        String str4 = FIELD_POSITION;
        float f3 = bundle.containsKey(str4) ? bundle.getFloat(str4) : -3.4028235E38f;
        String str5 = FIELD_POSITION_ANCHOR;
        int i10 = bundle.containsKey(str5) ? bundle.getInt(str5) : Integer.MIN_VALUE;
        String str6 = FIELD_TEXT_SIZE;
        if (bundle.containsKey(str6)) {
            String str7 = FIELD_TEXT_SIZE_TYPE;
            if (bundle.containsKey(str7)) {
                f2 = bundle.getFloat(str6);
                i2 = bundle.getInt(str7);
            } else {
                f2 = -3.4028235E38f;
                i2 = Integer.MIN_VALUE;
            }
        } else {
            f2 = -3.4028235E38f;
            i2 = Integer.MIN_VALUE;
        }
        String str8 = FIELD_SIZE;
        float f4 = bundle.containsKey(str8) ? bundle.getFloat(str8) : -3.4028235E38f;
        String str9 = FIELD_BITMAP_HEIGHT;
        float f5 = bundle.containsKey(str9) ? bundle.getFloat(str9) : -3.4028235E38f;
        String str10 = FIELD_WINDOW_COLOR;
        if (bundle.containsKey(str10)) {
            i3 = bundle.getInt(str10);
        } else {
            i3 = -16777216;
            z = false;
        }
        int i11 = i3;
        boolean z2 = !bundle.getBoolean(FIELD_WINDOW_COLOR_SET, false) ? false : z;
        String str11 = FIELD_VERTICAL_TYPE;
        int i12 = bundle.containsKey(str11) ? bundle.getInt(str11) : Integer.MIN_VALUE;
        String str12 = FIELD_SHEAR_DEGREES;
        float f6 = bundle.containsKey(str12) ? bundle.getFloat(str12) : CropImageView.DEFAULT_ASPECT_RATIO;
        String str13 = FIELD_Z_INDEX;
        return new Cue(r7, alignment2, alignment4, bitmapDecodeByteArray, f, i, i9, f3, i10, i2, f2, f4, f5, z2, i11, i12, f6, bundle.containsKey(str13) ? bundle.getInt(str13) : 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Cue.class == obj.getClass()) {
            Cue cue = (Cue) obj;
            if (TextUtils.equals(this.text, cue.text) && this.textAlignment == cue.textAlignment && this.multiRowAlignment == cue.multiRowAlignment) {
                Bitmap bitmap = cue.bitmap;
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null ? !(bitmap == null || !bitmap2.sameAs(bitmap)) : bitmap == null) {
                    if (this.line == cue.line && this.lineType == cue.lineType && this.lineAnchor == cue.lineAnchor && this.position == cue.position && this.positionAnchor == cue.positionAnchor && this.size == cue.size && this.bitmapHeight == cue.bitmapHeight && this.windowColorSet == cue.windowColorSet && this.windowColor == cue.windowColor && this.textSizeType == cue.textSizeType && this.textSize == cue.textSize && this.verticalType == cue.verticalType && this.shearDegrees == cue.shearDegrees && this.zIndex == cue.zIndex) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.text, this.textAlignment, this.multiRowAlignment, this.bitmap, Float.valueOf(this.line), Integer.valueOf(this.lineType), Integer.valueOf(this.lineAnchor), Float.valueOf(this.position), Integer.valueOf(this.positionAnchor), Float.valueOf(this.size), Float.valueOf(this.bitmapHeight), Boolean.valueOf(this.windowColorSet), Integer.valueOf(this.windowColor), Integer.valueOf(this.textSizeType), Float.valueOf(this.textSize), Integer.valueOf(this.verticalType), Float.valueOf(this.shearDegrees), Integer.valueOf(this.zIndex));
    }

    public final Bundle toBundleWithoutBitmap() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.text;
        if (charSequence != null) {
            bundle.putCharSequence(FIELD_TEXT, charSequence);
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                String str = CustomSpanBundler.FIELD_START_INDEX;
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (RubySpan rubySpan : (RubySpan[]) spanned.getSpans(0, spanned.length(), RubySpan.class)) {
                    rubySpan.getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(RubySpan.FIELD_TEXT, rubySpan.rubyText);
                    bundle2.putInt(RubySpan.FIELD_POSITION, rubySpan.position);
                    arrayList.add(CustomSpanBundler.spanToBundle(spanned, rubySpan, 1, bundle2));
                }
                for (TextEmphasisSpan textEmphasisSpan : (TextEmphasisSpan[]) spanned.getSpans(0, spanned.length(), TextEmphasisSpan.class)) {
                    textEmphasisSpan.getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt(TextEmphasisSpan.FIELD_MARK_SHAPE, textEmphasisSpan.markShape);
                    bundle3.putInt(TextEmphasisSpan.FIELD_MARK_FILL, textEmphasisSpan.markFill);
                    bundle3.putInt(TextEmphasisSpan.FIELD_POSITION, textEmphasisSpan.position);
                    arrayList.add(CustomSpanBundler.spanToBundle(spanned, textEmphasisSpan, 2, bundle3));
                }
                for (HorizontalTextInVerticalContextSpan horizontalTextInVerticalContextSpan : (HorizontalTextInVerticalContextSpan[]) spanned.getSpans(0, spanned.length(), HorizontalTextInVerticalContextSpan.class)) {
                    arrayList.add(CustomSpanBundler.spanToBundle(spanned, horizontalTextInVerticalContextSpan, 3, null));
                }
                for (VoiceSpan voiceSpan : (VoiceSpan[]) spanned.getSpans(0, spanned.length(), VoiceSpan.class)) {
                    voiceSpan.getClass();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(VoiceSpan.FIELD_NAME, voiceSpan.name);
                    arrayList.add(CustomSpanBundler.spanToBundle(spanned, voiceSpan, 4, bundle4));
                }
                if (!arrayList.isEmpty()) {
                    bundle.putParcelableArrayList(FIELD_CUSTOM_SPANS, arrayList);
                }
            }
        }
        bundle.putSerializable(FIELD_TEXT_ALIGNMENT, this.textAlignment);
        bundle.putSerializable(FIELD_MULTI_ROW_ALIGNMENT, this.multiRowAlignment);
        bundle.putFloat(FIELD_LINE, this.line);
        bundle.putInt(FIELD_LINE_TYPE, this.lineType);
        bundle.putInt(FIELD_LINE_ANCHOR, this.lineAnchor);
        bundle.putFloat(FIELD_POSITION, this.position);
        bundle.putInt(FIELD_POSITION_ANCHOR, this.positionAnchor);
        bundle.putInt(FIELD_TEXT_SIZE_TYPE, this.textSizeType);
        bundle.putFloat(FIELD_TEXT_SIZE, this.textSize);
        bundle.putFloat(FIELD_SIZE, this.size);
        bundle.putFloat(FIELD_BITMAP_HEIGHT, this.bitmapHeight);
        bundle.putBoolean(FIELD_WINDOW_COLOR_SET, this.windowColorSet);
        bundle.putInt(FIELD_WINDOW_COLOR, this.windowColor);
        bundle.putInt(FIELD_VERTICAL_TYPE, this.verticalType);
        bundle.putFloat(FIELD_SHEAR_DEGREES, this.shearDegrees);
        bundle.putInt(FIELD_Z_INDEX, this.zIndex);
        return bundle;
    }
}
