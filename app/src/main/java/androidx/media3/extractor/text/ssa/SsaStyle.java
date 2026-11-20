package androidx.media3.extractor.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SsaStyle {
    public final int alignment;
    public final boolean bold;
    public final int borderStyle;
    public final float fontSize;
    public final boolean italic;
    public final String name;
    public final Integer outlineColor;
    public final Integer primaryColor;
    public final boolean strikeout;
    public final boolean underline;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Format {
        public final int alignmentIndex;
        public final int boldIndex;
        public final int borderStyleIndex;
        public final int fontSizeIndex;
        public final int italicIndex;
        public final int length;
        public final int nameIndex;
        public final int outlineColorIndex;
        public final int primaryColorIndex;
        public final int strikeoutIndex;
        public final int underlineIndex;

        public Format(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.nameIndex = i;
            this.alignmentIndex = i2;
            this.primaryColorIndex = i3;
            this.outlineColorIndex = i4;
            this.fontSizeIndex = i5;
            this.boldIndex = i6;
            this.italicIndex = i7;
            this.underlineIndex = i8;
            this.strikeoutIndex = i9;
            this.borderStyleIndex = i10;
            this.length = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Overrides {
        public static final Pattern ALIGNMENT_OVERRIDE_PATTERN;
        public static final Pattern BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        public static final Pattern MOVE_PATTERN;
        public static final Pattern POSITION_PATTERN;

        static {
            String str = Util.DEVICE_DEBUG_INFO;
            Locale locale = Locale.US;
            POSITION_PATTERN = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            MOVE_PATTERN = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
        }

        public static PointF parsePosition(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = POSITION_PATTERN.matcher(str);
            Matcher matcher2 = MOVE_PATTERN.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    Log.i("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            strGroup.getClass();
            float f = Float.parseFloat(strGroup.trim());
            strGroup2.getClass();
            return new PointF(f, Float.parseFloat(strGroup2.trim()));
        }
    }

    public SsaStyle(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.name = str;
        this.alignment = i;
        this.primaryColor = num;
        this.outlineColor = num2;
        this.fontSize = f;
        this.bold = z;
        this.italic = z2;
        this.underline = z3;
        this.strikeout = z4;
        this.borderStyle = i2;
    }

    public static int parseAlignment(String str) {
        boolean z;
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        Format$$ExternalSyntheticOutline0.m("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean parseBooleanValue(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            Log.w("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }

    public static Integer parseColor(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            UtilsKt.checkArgument(j <= 4294967295L);
            return Integer.valueOf(Color.argb(StringsKt__IndentKt.checkedCast(((j >> 24) & 255) ^ 255), StringsKt__IndentKt.checkedCast(j & 255), StringsKt__IndentKt.checkedCast((j >> 8) & 255), StringsKt__IndentKt.checkedCast((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            Log.w("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }
}
