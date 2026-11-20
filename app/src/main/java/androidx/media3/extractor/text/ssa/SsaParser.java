package androidx.media3.extractor.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import io.ktor.sse.ServerSentEventKt;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SsaParser implements SubtitleParser {
    public static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final SsaDialogueFormat dialogueFormatFromInitializationData;
    public final boolean haveInitializationData;
    public LinkedHashMap styles;
    public float screenWidth = -3.4028235E38f;
    public float screenHeight = -3.4028235E38f;
    public final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public SsaParser(List list) {
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            this.dialogueFormatFromInitializationData = null;
            return;
        }
        this.haveInitializationData = true;
        String strFromUtf8Bytes = Util.fromUtf8Bytes((byte[]) list.get(0));
        UtilsKt.checkArgument(strFromUtf8Bytes.startsWith("Format:"));
        SsaDialogueFormat ssaDialogueFormatFromFormatLine = SsaDialogueFormat.fromFormatLine(strFromUtf8Bytes);
        ssaDialogueFormatFromFormatLine.getClass();
        this.dialogueFormatFromInitializationData = ssaDialogueFormatFromFormatLine;
        parseHeader(new ParsableByteArray((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    public static int addCuePlacerholderByTime(long j, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i, Long.valueOf(j));
        arrayList2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i - 1)));
        return i;
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = Util.DEVICE_DEBUG_INFO;
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(strGroup) * 3600000000L);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        Charset charset;
        ParsableByteArray parsableByteArray;
        long j;
        int i3;
        int i4;
        float f;
        int i5;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i6;
        int i7;
        int i8;
        float f2;
        float f3;
        float f4;
        int i9;
        int i10;
        float f5;
        int i11;
        int i12;
        float f6;
        int i13;
        int alignment3;
        int i14;
        SsaParser ssaParser = this;
        long j2 = outputOptions.startTimeUs;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray2 = ssaParser.parsableByteArray;
        parsableByteArray2.reset(bArr, i + i2);
        parsableByteArray2.setPosition(i);
        Charset utfCharsetFromBom = parsableByteArray2.readUtfCharsetFromBom();
        if (utfCharsetFromBom == null) {
            utfCharsetFromBom = StandardCharsets.UTF_8;
        }
        boolean z = ssaParser.haveInitializationData;
        if (!z) {
            ssaParser.parseHeader(parsableByteArray2, utfCharsetFromBom);
        }
        SsaDialogueFormat ssaDialogueFormatFromFormatLine = z ? ssaParser.dialogueFormatFromInitializationData : null;
        while (true) {
            String line = parsableByteArray2.readLine(utfCharsetFromBom);
            if (line == null) {
                long j3 = j2;
                ArrayList arrayList3 = (j3 == -9223372036854775807L || !outputOptions.outputAllCues) ? null : new ArrayList();
                for (int i15 = 0; i15 < arrayList.size(); i15++) {
                    List list = (List) arrayList.get(i15);
                    if (!list.isEmpty() || i15 == 0) {
                        if (i15 == arrayList.size() - 1) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                            return;
                        }
                        long jLongValue = ((Long) arrayList2.get(i15)).longValue();
                        long jLongValue2 = ((Long) arrayList2.get(i15 + 1)).longValue();
                        CuesWithTiming cuesWithTiming = new CuesWithTiming(jLongValue, jLongValue2 - jLongValue, list);
                        if (j3 == -9223372036854775807L || jLongValue2 >= j3) {
                            consumer.accept(cuesWithTiming);
                        } else if (arrayList3 != null) {
                            arrayList3.add(cuesWithTiming);
                        }
                    }
                }
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    int i16 = 0;
                    while (i16 < size) {
                        Object obj = arrayList3.get(i16);
                        i16++;
                        consumer.accept((CuesWithTiming) obj);
                    }
                    return;
                }
                return;
            }
            if (line.startsWith("Format:")) {
                ssaDialogueFormatFromFormatLine = SsaDialogueFormat.fromFormatLine(line);
            } else {
                if (line.startsWith("Dialogue:")) {
                    if (ssaDialogueFormatFromFormatLine == null) {
                        Log.w("SsaParser", "Skipping dialogue line before complete format: ".concat(line));
                    } else {
                        int i17 = ssaDialogueFormatFromFormatLine.length;
                        UtilsKt.checkArgument(line.startsWith("Dialogue:"));
                        String strSubstring = line.substring(9);
                        int i18 = ssaDialogueFormatFromFormatLine.layerIndex;
                        String[] strArrSplit = strSubstring.split(",", i17);
                        if (strArrSplit.length != i17) {
                            Log.w("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(line));
                        } else {
                            if (i18 != -1) {
                                try {
                                    i3 = Integer.parseInt(strArrSplit[i18].trim());
                                } catch (RuntimeException unused) {
                                    Log.w("SsaParser", "Fail to parse layer: " + strArrSplit[i18]);
                                    i3 = 0;
                                }
                            } else {
                                i3 = 0;
                            }
                            long timecodeUs = parseTimecodeUs(strArrSplit[ssaDialogueFormatFromFormatLine.startTimeIndex]);
                            charset = utfCharsetFromBom;
                            if (timecodeUs == -9223372036854775807L) {
                                Log.w("SsaParser", "Skipping invalid timing: ".concat(line));
                                j = j2;
                                parsableByteArray = parsableByteArray2;
                            } else {
                                j = j2;
                                long timecodeUs2 = parseTimecodeUs(strArrSplit[ssaDialogueFormatFromFormatLine.endTimeIndex]);
                                if (timecodeUs2 == -9223372036854775807L || timecodeUs2 <= timecodeUs) {
                                    parsableByteArray = parsableByteArray2;
                                    Log.w("SsaParser", "Skipping invalid timing: ".concat(line));
                                } else {
                                    LinkedHashMap linkedHashMap = ssaParser.styles;
                                    SsaStyle ssaStyle = (linkedHashMap == null || (i14 = ssaDialogueFormatFromFormatLine.styleIndex) == -1) ? null : (SsaStyle) linkedHashMap.get(strArrSplit[i14].trim());
                                    String str = strArrSplit[ssaDialogueFormatFromFormatLine.textIndex];
                                    Matcher matcher = SsaStyle.Overrides.BRACES_PATTERN.matcher(str);
                                    PointF pointF = null;
                                    int i19 = -1;
                                    while (matcher.find()) {
                                        ParsableByteArray parsableByteArray3 = parsableByteArray2;
                                        String strGroup = matcher.group(1);
                                        strGroup.getClass();
                                        try {
                                            PointF position = SsaStyle.Overrides.parsePosition(strGroup);
                                            if (position != null) {
                                                pointF = position;
                                            }
                                        } catch (RuntimeException unused2) {
                                        }
                                        try {
                                            Matcher matcher2 = SsaStyle.Overrides.ALIGNMENT_OVERRIDE_PATTERN.matcher(strGroup);
                                            if (matcher2.find()) {
                                                String strGroup2 = matcher2.group(1);
                                                strGroup2.getClass();
                                                alignment3 = SsaStyle.parseAlignment(strGroup2);
                                            } else {
                                                alignment3 = -1;
                                            }
                                            if (alignment3 != -1) {
                                                i19 = alignment3;
                                            }
                                        } catch (RuntimeException unused3) {
                                        }
                                        parsableByteArray2 = parsableByteArray3;
                                    }
                                    parsableByteArray = parsableByteArray2;
                                    String strReplace = SsaStyle.Overrides.BRACES_PATTERN.matcher(str).replaceAll("").replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f7 = ssaParser.screenWidth;
                                    float f8 = ssaParser.screenHeight;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    if (ssaStyle != null) {
                                        boolean z2 = ssaStyle.italic;
                                        Integer num = ssaStyle.outlineColor;
                                        Integer num2 = ssaStyle.primaryColor;
                                        if (num2 != null) {
                                            i9 = 33;
                                            i10 = 0;
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        } else {
                                            i9 = 33;
                                            i10 = 0;
                                        }
                                        if (ssaStyle.borderStyle == 3 && num != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), i10, spannableString.length(), i9);
                                        }
                                        float f9 = ssaStyle.fontSize;
                                        if (f9 == -3.4028235E38f || f8 == -3.4028235E38f) {
                                            f5 = -3.4028235E38f;
                                            i11 = Integer.MIN_VALUE;
                                        } else {
                                            f5 = f9 / f8;
                                            i11 = 1;
                                        }
                                        boolean z3 = ssaStyle.bold;
                                        if (z3 && z2) {
                                            i12 = i11;
                                            f6 = f5;
                                            i13 = 33;
                                            i4 = 0;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i12 = i11;
                                            f6 = f5;
                                            i13 = 33;
                                            i4 = 0;
                                            if (z3) {
                                                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            } else if (z2 != 0) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                        }
                                        if (ssaStyle.underline) {
                                            spannableString.setSpan(new UnderlineSpan(), i4, spannableString.length(), i13);
                                        }
                                        if (ssaStyle.strikeout) {
                                            spannableString.setSpan(new StrikethroughSpan(), i4, spannableString.length(), i13);
                                        }
                                        i5 = i12;
                                        f = f6;
                                    } else {
                                        f7 = f7;
                                        f8 = f8;
                                        i4 = 0;
                                        f = -3.4028235E38f;
                                        i5 = Integer.MIN_VALUE;
                                    }
                                    if (i19 == -1) {
                                        i19 = ssaStyle != null ? ssaStyle.alignment : -1;
                                    }
                                    switch (i19) {
                                        case 0:
                                        default:
                                            Format$$ExternalSyntheticOutline0.m(i19, "Unknown alignment: ", "SsaParser");
                                        case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                                            alignment2 = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            alignment2 = alignment;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            alignment2 = alignment;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            alignment2 = alignment;
                                            break;
                                    }
                                    int i20 = Integer.MIN_VALUE;
                                    switch (i19) {
                                        case 0:
                                        default:
                                            Format$$ExternalSyntheticOutline0.m(i19, "Unknown alignment: ", "SsaParser");
                                        case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                                            i6 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i6 = i4;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i6 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i6 = 2;
                                            break;
                                    }
                                    switch (i19) {
                                        case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                                            break;
                                        case 0:
                                        default:
                                            Format$$ExternalSyntheticOutline0.m(i19, "Unknown alignment: ", "SsaParser");
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i20 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i20 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i20 = i4;
                                            break;
                                    }
                                    if (pointF == null || f8 == -3.4028235E38f || f7 == -3.4028235E38f) {
                                        float f10 = 0.95f;
                                        if (i6 != 0) {
                                            i7 = 1;
                                            if (i6 != 1) {
                                                i8 = 2;
                                                f2 = i6 != 2 ? -3.4028235E38f : 0.95f;
                                            } else {
                                                i8 = 2;
                                                f2 = 0.5f;
                                            }
                                        } else {
                                            i7 = 1;
                                            i8 = 2;
                                            f2 = 0.05f;
                                        }
                                        if (i20 == 0) {
                                            f10 = 0.05f;
                                        } else if (i20 == i7) {
                                            f10 = 0.5f;
                                        } else if (i20 != i8) {
                                            f10 = -3.4028235E38f;
                                        }
                                        f3 = f10;
                                        f4 = f2;
                                    } else {
                                        f4 = pointF.x / f7;
                                        f3 = pointF.y / f8;
                                    }
                                    Cue cue = new Cue(spannableString, alignment2, null, null, f3, i4, i20, f4, i6, i5, f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, i3);
                                    int iAddCuePlacerholderByTime = addCuePlacerholderByTime(timecodeUs2, arrayList2, arrayList);
                                    for (int iAddCuePlacerholderByTime2 = addCuePlacerholderByTime(timecodeUs, arrayList2, arrayList); iAddCuePlacerholderByTime2 < iAddCuePlacerholderByTime; iAddCuePlacerholderByTime2++) {
                                        ((List) arrayList.get(iAddCuePlacerholderByTime2)).add(cue);
                                    }
                                }
                            }
                        }
                    }
                    charset = utfCharsetFromBom;
                    j = j2;
                    parsableByteArray = parsableByteArray2;
                } else {
                    charset = utfCharsetFromBom;
                    j = j2;
                    parsableByteArray = parsableByteArray2;
                }
                ssaParser = this;
                utfCharsetFromBom = charset;
                j2 = j;
                ssaDialogueFormatFromFormatLine = ssaDialogueFormatFromFormatLine;
                parsableByteArray2 = parsableByteArray;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:170:0x02ea  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void parseHeader(ParsableByteArray parsableByteArray, Charset charset) {
        int i;
        SsaStyle ssaStyle;
        while (true) {
            String line = parsableByteArray.readLine(charset);
            if (line == null) {
                return;
            }
            int i2 = 0;
            int i3 = 91;
            if ("[Script Info]".equalsIgnoreCase(line)) {
                while (true) {
                    String line2 = parsableByteArray.readLine(charset);
                    if (line2 == null) {
                        break;
                    }
                    if (parsableByteArray.bytesLeft() != 0) {
                        int iPeekCodePointAndSize = parsableByteArray.peekCodePointAndSize(charset);
                        if ((iPeekCodePointAndSize != 0 ? StringsKt__IndentKt.checkedCast(iPeekCodePointAndSize >>> 8) : 1114112) == 91) {
                            break;
                        }
                    }
                    String[] strArrSplit = line2.split(ServerSentEventKt.COLON);
                    if (strArrSplit.length == 2) {
                        String lowerCase = LifecyclesKt.toLowerCase(strArrSplit[0].trim());
                        lowerCase.getClass();
                        if (lowerCase.equals("playresx")) {
                            this.screenWidth = Float.parseFloat(strArrSplit[1].trim());
                        } else if (lowerCase.equals("playresy")) {
                            try {
                                this.screenHeight = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(line)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                SsaStyle.Format format = null;
                while (true) {
                    String line3 = parsableByteArray.readLine(charset);
                    if (line3 != null) {
                        if (parsableByteArray.bytesLeft() != 0) {
                            int iPeekCodePointAndSize2 = parsableByteArray.peekCodePointAndSize(charset);
                            if ((iPeekCodePointAndSize2 != 0 ? StringsKt__IndentKt.checkedCast(iPeekCodePointAndSize2 >>> 8) : 1114112) == i3) {
                            }
                        }
                        int i4 = -1;
                        if (line3.startsWith("Format:")) {
                            String[] strArrSplit2 = TextUtils.split(line3.substring(7), ",");
                            int i5 = -1;
                            int i6 = -1;
                            int i7 = -1;
                            int i8 = -1;
                            int i9 = -1;
                            int i10 = -1;
                            int i11 = -1;
                            int i12 = -1;
                            int i13 = -1;
                            int i14 = -1;
                            for (int i15 = i2; i15 < strArrSplit2.length; i15++) {
                                String lowerCase2 = LifecyclesKt.toLowerCase(strArrSplit2[i15].trim());
                                lowerCase2.getClass();
                                switch (lowerCase2.hashCode()) {
                                    case -1178781136:
                                        i = lowerCase2.equals("italic") ? i2 : -1;
                                        break;
                                    case -1026963764:
                                        i = lowerCase2.equals("underline") ? 1 : -1;
                                        break;
                                    case -192095652:
                                        i = lowerCase2.equals("strikeout") ? 2 : -1;
                                        break;
                                    case -70925746:
                                        i = lowerCase2.equals("primarycolour") ? 3 : -1;
                                        break;
                                    case 3029637:
                                        i = lowerCase2.equals("bold") ? 4 : -1;
                                        break;
                                    case 3373707:
                                        i = lowerCase2.equals(ContentDisposition.Parameters.Name) ? 5 : -1;
                                        break;
                                    case 366554320:
                                        i = lowerCase2.equals("fontsize") ? 6 : -1;
                                        break;
                                    case 767321349:
                                        i = lowerCase2.equals("borderstyle") ? 7 : -1;
                                        break;
                                    case 1767875043:
                                        i = lowerCase2.equals("alignment") ? 8 : -1;
                                        break;
                                    case 1988365454:
                                        i = lowerCase2.equals("outlinecolour") ? 9 : -1;
                                        break;
                                    default:
                                        i = -1;
                                        break;
                                }
                                switch (i) {
                                    case 0:
                                        i11 = i15;
                                        break;
                                    case 1:
                                        i12 = i15;
                                        break;
                                    case 2:
                                        i13 = i15;
                                        break;
                                    case 3:
                                        i7 = i15;
                                        break;
                                    case 4:
                                        i10 = i15;
                                        break;
                                    case 5:
                                        i5 = i15;
                                        break;
                                    case 6:
                                        i9 = i15;
                                        break;
                                    case 7:
                                        i14 = i15;
                                        break;
                                    case 8:
                                        i6 = i15;
                                        break;
                                    case 9:
                                        i8 = i15;
                                        break;
                                }
                            }
                            format = i5 != -1 ? new SsaStyle.Format(i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, strArrSplit2.length) : null;
                        } else {
                            if (line3.startsWith("Style:")) {
                                if (format == null) {
                                    Log.w("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(line3));
                                } else {
                                    UtilsKt.checkArgument(line3.startsWith("Style:"));
                                    String[] strArrSplit3 = TextUtils.split(line3.substring(6), ",");
                                    int length = strArrSplit3.length;
                                    int i16 = format.length;
                                    if (length != i16) {
                                        int length2 = strArrSplit3.length;
                                        String str = Util.DEVICE_DEBUG_INFO;
                                        Locale locale = Locale.US;
                                        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i16, "Skipping malformed 'Style:' line (expected ", " values, found ", length2, "): '");
                                        sbM3m.append(line3);
                                        sbM3m.append("'");
                                        Log.w("SsaStyle", sbM3m.toString());
                                    } else {
                                        try {
                                            String strTrim = strArrSplit3[format.nameIndex].trim();
                                            int i17 = format.alignmentIndex;
                                            int alignment = i17 != -1 ? SsaStyle.parseAlignment(strArrSplit3[i17].trim()) : -1;
                                            int i18 = format.primaryColorIndex;
                                            Integer color = i18 != -1 ? SsaStyle.parseColor(strArrSplit3[i18].trim()) : null;
                                            int i19 = format.outlineColorIndex;
                                            Integer color2 = i19 != -1 ? SsaStyle.parseColor(strArrSplit3[i19].trim()) : null;
                                            int i20 = format.fontSizeIndex;
                                            float f = -3.4028235E38f;
                                            if (i20 != -1) {
                                                String strTrim2 = strArrSplit3[i20].trim();
                                                try {
                                                    f = Float.parseFloat(strTrim2);
                                                } catch (NumberFormatException e) {
                                                    Log.w("SsaStyle", "Failed to parse font size: '" + strTrim2 + "'", e);
                                                }
                                            }
                                            float f2 = f;
                                            int i21 = format.boldIndex;
                                            boolean z = i21 != -1 && SsaStyle.parseBooleanValue(strArrSplit3[i21].trim());
                                            int i22 = format.italicIndex;
                                            boolean z2 = i22 != -1 && SsaStyle.parseBooleanValue(strArrSplit3[i22].trim());
                                            int i23 = format.underlineIndex;
                                            boolean z3 = i23 != -1 && SsaStyle.parseBooleanValue(strArrSplit3[i23].trim());
                                            int i24 = format.strikeoutIndex;
                                            boolean z4 = i24 != -1 && SsaStyle.parseBooleanValue(strArrSplit3[i24].trim());
                                            int i25 = format.borderStyleIndex;
                                            if (i25 != -1) {
                                                String strTrim3 = strArrSplit3[i25].trim();
                                                try {
                                                    int i26 = Integer.parseInt(strTrim3.trim());
                                                    if (i26 == 1 || i26 == 3) {
                                                        i4 = i26;
                                                    } else {
                                                        Log.w("SsaStyle", "Ignoring unknown BorderStyle: " + strTrim3);
                                                    }
                                                } catch (NumberFormatException unused2) {
                                                }
                                            }
                                            ssaStyle = new SsaStyle(strTrim, alignment, color, color2, f2, z, z2, z3, z4, i4);
                                        } catch (RuntimeException e2) {
                                            Log.w("SsaStyle", "Skipping malformed 'Style:' line: '" + line3 + "'", e2);
                                            ssaStyle = null;
                                        }
                                        if (ssaStyle != null) {
                                            linkedHashMap.put(ssaStyle.name, ssaStyle);
                                        }
                                    }
                                    ssaStyle = null;
                                    if (ssaStyle != null) {
                                        linkedHashMap.put(ssaStyle.name, ssaStyle);
                                    }
                                }
                            }
                            i2 = 0;
                            i3 = 91;
                        }
                    }
                }
                this.styles = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(line)) {
                Log.i("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(line)) {
                return;
            }
        }
    }
}
