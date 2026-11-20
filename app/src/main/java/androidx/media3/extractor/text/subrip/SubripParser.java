package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SubripParser implements SubtitleParser {
    public static final Pattern SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");
    public static final Pattern SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder textBuilder = new StringBuilder();
    public final ArrayList tags = new ArrayList();
    public final ParsableByteArray parsableByteArray = new ParsableByteArray();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:30:0x0088  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cc  */
    public static Cue buildCue(Spanned spanned, String str) {
        int i;
        int i2;
        float f;
        if (str == null) {
            return new Cue(spanned, null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (!str.equals("{\\an1}")) {
                    i = 1;
                } else {
                    i = 0;
                }
                break;
            case -685620679:
                str.equals("{\\an2}");
                i = 1;
                break;
            case -685620648:
                if (!str.equals("{\\an3}")) {
                    i = 1;
                } else {
                    i = 2;
                }
                break;
            case -685620617:
                if (!str.equals("{\\an4}")) {
                    i = 1;
                } else {
                    i = 0;
                }
                break;
            case -685620586:
                str.equals("{\\an5}");
                i = 1;
                break;
            case -685620555:
                if (!str.equals("{\\an6}")) {
                    i = 1;
                } else {
                    i = 2;
                }
                break;
            case -685620524:
                if (!str.equals("{\\an7}")) {
                    i = 1;
                } else {
                    i = 0;
                }
                break;
            case -685620493:
                str.equals("{\\an8}");
                i = 1;
                break;
            case -685620462:
                if (!str.equals("{\\an9}")) {
                    i = 1;
                } else {
                    i = 2;
                }
                break;
            default:
                i = 1;
                break;
        }
        switch (str.hashCode()) {
            case -685620710:
                if (!str.equals("{\\an1}")) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                break;
            case -685620679:
                if (!str.equals("{\\an2}")) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                break;
            case -685620648:
                if (!str.equals("{\\an3}")) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                break;
            case -685620617:
                str.equals("{\\an4}");
                i2 = 1;
                break;
            case -685620586:
                str.equals("{\\an5}");
                i2 = 1;
                break;
            case -685620555:
                str.equals("{\\an6}");
                i2 = 1;
                break;
            case -685620524:
                if (!str.equals("{\\an7}")) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                break;
            case -685620493:
                if (!str.equals("{\\an8}")) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                break;
            case -685620462:
                if (!str.equals("{\\an9}")) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                break;
            default:
                i2 = 1;
                break;
        }
        float f2 = 0.92f;
        if (i == 0) {
            f = 0.08f;
        } else if (i == 1) {
            f = 0.5f;
        } else {
            if (i != 2) {
                Path$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            f = 0.92f;
        }
        if (i2 == 0) {
            f2 = 0.08f;
        } else if (i2 == 1) {
            f2 = 0.5f;
        } else if (i2 != 2) {
            Path$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        return new Cue(spanned, null, null, null, f2, 0, i2, f, i, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, CropImageView.DEFAULT_ASPECT_RATIO, 0);
    }

    public static long parseTimecode(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j2 = (Long.parseLong(strGroup2) * 60000) + j;
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j3 = (Long.parseLong(strGroup3) * 1000) + j2;
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        String str;
        SubripParser subripParser = this;
        long j = outputOptions.startTimeUs;
        ParsableByteArray parsableByteArray = subripParser.parsableByteArray;
        parsableByteArray.reset(bArr, i + i2);
        parsableByteArray.setPosition(i);
        Charset utfCharsetFromBom = parsableByteArray.readUtfCharsetFromBom();
        if (utfCharsetFromBom == null) {
            utfCharsetFromBom = StandardCharsets.UTF_8;
        }
        long j2 = -9223372036854775807L;
        ArrayList arrayList = (j == -9223372036854775807L || !outputOptions.outputAllCues) ? null : new ArrayList();
        while (true) {
            String line = parsableByteArray.readLine(utfCharsetFromBom);
            if (line == null) {
                break;
            }
            if (!line.isEmpty()) {
                try {
                    Integer.parseInt(line);
                    String line2 = parsableByteArray.readLine(utfCharsetFromBom);
                    if (line2 == null) {
                        Log.w("SubripParser", "Unexpected end");
                        break;
                    }
                    Matcher matcher = SUBRIP_TIMING_LINE.matcher(line2);
                    if (matcher.matches()) {
                        long timecode = parseTimecode(matcher, 1);
                        long timecode2 = parseTimecode(matcher, 6);
                        StringBuilder sb = subripParser.textBuilder;
                        sb.setLength(0);
                        long j3 = j2;
                        ArrayList arrayList2 = subripParser.tags;
                        arrayList2.clear();
                        for (String line3 = parsableByteArray.readLine(utfCharsetFromBom); !TextUtils.isEmpty(line3); line3 = parsableByteArray.readLine(utfCharsetFromBom)) {
                            if (sb.length() > 0) {
                                sb.append("<br>");
                            }
                            String strTrim = line3.trim();
                            StringBuilder sb2 = new StringBuilder(strTrim);
                            Matcher matcher2 = SUBRIP_TAG_PATTERN.matcher(strTrim);
                            int i3 = 0;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList2.add(strGroup);
                                int iStart = matcher2.start() - i3;
                                int length = strGroup.length();
                                sb2.replace(iStart, iStart + length, "");
                                i3 += length;
                                j = j;
                            }
                            sb.append(sb2.toString());
                        }
                        long j4 = j;
                        Spanned spannedFromHtml = Html.fromHtml(sb.toString());
                        int i4 = 0;
                        while (true) {
                            if (i4 >= arrayList2.size()) {
                                str = null;
                                break;
                            }
                            str = (String) arrayList2.get(i4);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        if (j4 == j3 || timecode2 >= j4) {
                            consumer.accept(new CuesWithTiming(timecode, timecode2 - timecode, ImmutableList.of((Object) buildCue(spannedFromHtml, str))));
                        } else if (arrayList != null) {
                            arrayList.add(new CuesWithTiming(timecode, timecode2 - timecode, ImmutableList.of((Object) buildCue(spannedFromHtml, str))));
                        }
                        subripParser = this;
                        j2 = j3;
                        j = j4;
                    } else {
                        Log.w("SubripParser", "Skipping invalid timing: ".concat(line2));
                        subripParser = this;
                    }
                } catch (NumberFormatException unused) {
                    Log.w("SubripParser", "Skipping invalid index: ".concat(line));
                }
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                consumer.accept((CuesWithTiming) obj);
            }
        }
    }
}
