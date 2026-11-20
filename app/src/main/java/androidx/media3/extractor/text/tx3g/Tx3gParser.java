package androidx.media3.extractor.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Tx3gParser implements SubtitleParser {
    public final int calculatedVideoTrackHeight;
    public final boolean customVerticalPlacement;
    public final int defaultColorRgba;
    public final int defaultFontFace;
    public final String defaultFontFamily;
    public final float defaultVerticalPlacement;
    public final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gParser(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.defaultFontFace = 0;
            this.defaultColorRgba = -1;
            this.defaultFontFamily = "sans-serif";
            this.customVerticalPlacement = false;
            this.defaultVerticalPlacement = 0.85f;
            this.calculatedVideoTrackHeight = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.defaultFontFace = bArr[24];
        this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.defaultFontFamily = "Serif".equals(new String(bArr, 43, bArr.length - 43, StandardCharsets.UTF_8)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.calculatedVideoTrackHeight = i;
        boolean z = (bArr[0] & 32) != 0;
        this.customVerticalPlacement = z;
        if (z) {
            this.defaultVerticalPlacement = Util.constrainValue(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, CropImageView.DEFAULT_ASPECT_RATIO, 0.95f);
        } else {
            this.defaultVerticalPlacement = 0.85f;
        }
    }

    public static void attachColor(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    public static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        String string;
        int i3;
        ParsableByteArray parsableByteArray = this.parsableByteArray;
        parsableByteArray.reset(bArr, i + i2);
        parsableByteArray.setPosition(i);
        int i4 = 1;
        int i5 = 0;
        int i6 = 2;
        UtilsKt.checkArgument(parsableByteArray.bytesLeft() >= 2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        if (unsignedShort == 0) {
            string = "";
        } else {
            int i7 = parsableByteArray.position;
            Charset utfCharsetFromBom = parsableByteArray.readUtfCharsetFromBom();
            int i8 = unsignedShort - (parsableByteArray.position - i7);
            if (utfCharsetFromBom == null) {
                utfCharsetFromBom = StandardCharsets.UTF_8;
            }
            string = parsableByteArray.readString(i8, utfCharsetFromBom);
        }
        if (string.isEmpty()) {
            ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
            consumer.accept(new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, RegularImmutableList.EMPTY));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), 16711680);
        attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), 16711680);
        int length = spannableStringBuilder.length();
        String str = this.defaultFontFamily;
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fConstrainValue = this.defaultVerticalPlacement;
        while (parsableByteArray.bytesLeft() >= 8) {
            int i9 = parsableByteArray.position;
            int i10 = parsableByteArray.readInt();
            int i11 = parsableByteArray.readInt();
            if (i11 == 1937013100) {
                UtilsKt.checkArgument(parsableByteArray.bytesLeft() >= i6 ? i4 : i5);
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                int i12 = i5;
                while (i12 < unsignedShort2) {
                    UtilsKt.checkArgument(parsableByteArray.bytesLeft() >= 12 ? i4 : i5);
                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    parsableByteArray.skipBytes(i6);
                    int i13 = i12;
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(i4);
                    int i14 = parsableByteArray.readInt();
                    if (unsignedShort4 > spannableStringBuilder.length()) {
                        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(unsignedShort4, "Truncating styl end (", ") to cueText.length() (");
                        sbM2m.append(spannableStringBuilder.length());
                        sbM2m.append(").");
                        Log.w("Tx3gParser", sbM2m.toString());
                        unsignedShort4 = spannableStringBuilder.length();
                    }
                    if (unsignedShort3 >= unsignedShort4) {
                        Log.w("Tx3gParser", IntIntPair$$ExternalSyntheticOutline0.m(unsignedShort3, "Ignoring styl with start (", ") >= end (", unsignedShort4, ")."));
                    } else {
                        int i15 = unsignedShort4;
                        attachFontFace(spannableStringBuilder, unsignedByte, this.defaultFontFace, unsignedShort3, i15, 0);
                        attachColor(spannableStringBuilder, i14, this.defaultColorRgba, unsignedShort3, i15, 0);
                    }
                    i12 = i13 + 1;
                    i4 = 1;
                    i5 = 0;
                    i6 = 2;
                }
                i3 = i6;
            } else if (i11 == 1952608120 && this.customVerticalPlacement) {
                i3 = 2;
                UtilsKt.checkArgument(parsableByteArray.bytesLeft() >= 2);
                fConstrainValue = Util.constrainValue(parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, CropImageView.DEFAULT_ASPECT_RATIO, 0.95f);
            } else {
                i3 = 2;
            }
            parsableByteArray.setPosition(i9 + i10);
            i6 = i3;
            i4 = 1;
            i5 = 0;
        }
        consumer.accept(new CuesWithTiming(-9223372036854775807L, -9223372036854775807L, ImmutableList.of((Object) new Cue(spannableStringBuilder, null, null, null, fConstrainValue, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0))));
    }
}
