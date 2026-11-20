package androidx.media3.extractor.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.VoiceSpan;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentDisposition;
import io.ktor.sse.ServerSentEventKt;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WebvttCueParser {
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*+)?$");
    public static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    public static final Map DEFAULT_BACKGROUND_COLORS;
    public static final Map DEFAULT_TEXT_COLORS;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Element {
        public static final LayoutNode$$ExternalSyntheticLambda1 BY_START_POSITION_ASC = new LayoutNode$$ExternalSyntheticLambda1((byte) 21);
        public final int endPosition;
        public final StartTag startTag;

        public Element(StartTag startTag, int i) {
            this.startTag = startTag;
            this.endPosition = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StartTag {
        public final Set classes;
        public final String name;
        public final int position;
        public final String voice;

        public StartTag(String str, int i, String str2, Set set) {
            this.position = i;
            this.name = str;
            this.voice = str2;
            this.classes = set;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StyleMatch implements Comparable {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int i, WebvttCssStyle webvttCssStyle) {
            this.score = i;
            this.style = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return Integer.compare(this.score, ((StyleMatch) obj).score);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class WebvttCueInfoBuilder {
        public CharSequence text;
        public long startTimeUs = 0;
        public long endTimeUs = 0;
        public int textAlignment = 2;
        public float line = -3.4028235E38f;
        public boolean lineType = true;
        public int lineAnchor = 0;
        public float position = -3.4028235E38f;
        public int positionAnchor = Integer.MIN_VALUE;
        public float size = 1.0f;
        public int verticalType = Integer.MIN_VALUE;

        /* JADX WARN: Code duplicated, block: B:20:0x0032  */
        /* JADX WARN: Code duplicated, block: B:21:0x0034  */
        /* JADX WARN: Code duplicated, block: B:29:0x0050  */
        /* JADX WARN: Code duplicated, block: B:31:0x0056  */
        /* JADX WARN: Code duplicated, block: B:39:0x006c  */
        public final Cue.Builder toCueBuilder() {
            Layout.Alignment alignment;
            float f = this.position;
            float f2 = -3.4028235E38f;
            if (f == -3.4028235E38f) {
                int i = this.textAlignment;
                if (i != 4) {
                    f = i != 5 ? 0.5f : 1.0f;
                } else {
                    f = 0.0f;
                }
            }
            int i2 = this.positionAnchor;
            if (i2 == Integer.MIN_VALUE) {
                int i3 = this.textAlignment;
                if (i3 == 1) {
                    i2 = 0;
                } else if (i3 == 3) {
                    i2 = 2;
                } else if (i3 == 4) {
                    i2 = 0;
                } else if (i3 != 5) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
            }
            Cue.Builder builder = new Cue.Builder();
            int i4 = this.textAlignment;
            if (i4 == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 == 2) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            } else if (i4 == 3) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i4 == 4) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i4 != 5) {
                Format$$ExternalSyntheticOutline0.m(i4, "Unknown textAlignment: ", "WebvttCueParser");
                alignment = null;
            } else {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            builder.textAlignment = alignment;
            float f3 = this.line;
            boolean z = this.lineType;
            if (f3 != -3.4028235E38f && !z && (f3 < CropImageView.DEFAULT_ASPECT_RATIO || f3 > 1.0f)) {
                f2 = 1.0f;
            } else if (f3 != -3.4028235E38f) {
                f2 = f3;
            } else if (!z) {
                f2 = 1.0f;
            }
            builder.line = f2;
            builder.lineType = z ? 1 : 0;
            builder.lineAnchor = this.lineAnchor;
            builder.position = f;
            builder.positionAnchor = i2;
            float f4 = this.size;
            if (i2 == 0) {
                f = 1.0f - f;
            } else if (i2 == 1) {
                f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
            } else if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(String.valueOf(i2));
                return null;
            }
            builder.size = Math.min(f4, f);
            builder.verticalType = this.verticalType;
            CharSequence charSequence = this.text;
            if (charSequence != null) {
                builder.text = charSequence;
                builder.bitmap = null;
            }
            return builder;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_TEXT_COLORS = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        DEFAULT_BACKGROUND_COLORS = Collections.unmodifiableMap(map2);
    }

    public static void applySpansForTag(String str, StartTag startTag, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i;
        int i2;
        int i3;
        int i4 = startTag.position;
        int length = spannableStringBuilder.length();
        String str2 = startTag.name;
        str2.getClass();
        int i5 = -1;
        switch (str2) {
            case "":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i4, length, 33);
                break;
            case "c":
                for (String str3 : startTag.classes) {
                    Map map = DEFAULT_TEXT_COLORS;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i4, length, 33);
                    } else {
                        Map map2 = DEFAULT_BACKGROUND_COLORS;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i4, length, 33);
                        }
                    }
                }
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, length, 33);
                break;
            case "v":
                spannableStringBuilder.setSpan(new VoiceSpan(startTag.voice), i4, length, 33);
                break;
            case "ruby":
                int rubyPosition = getRubyPosition(list2, str, startTag);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, Element.BY_START_POSITION_ASC);
                int i6 = startTag.position;
                int i7 = 0;
                int length2 = 0;
                while (i7 < arrayList.size()) {
                    if ("rt".equals(((Element) arrayList.get(i7)).startTag.name)) {
                        Element element = (Element) arrayList.get(i7);
                        int rubyPosition2 = getRubyPosition(list2, str, element.startTag);
                        if (rubyPosition2 == i5) {
                            rubyPosition2 = rubyPosition != i5 ? rubyPosition : 1;
                        }
                        int i8 = element.startTag.position - length2;
                        int i9 = element.endPosition - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i8, i9);
                        spannableStringBuilder.delete(i8, i9);
                        spannableStringBuilder.setSpan(new RubySpan(charSequenceSubSequence.toString(), rubyPosition2), i6, i8, 33);
                        length2 = charSequenceSubSequence.length() + length2;
                        i6 = i8;
                    }
                    i7++;
                    i5 = -1;
                }
                break;
            default:
                return;
        }
        ArrayList applicableStyles = getApplicableStyles(list2, str, startTag);
        for (int i10 = 0; i10 < applicableStyles.size(); i10++) {
            WebvttCssStyle webvttCssStyle = ((StyleMatch) applicableStyles.get(i10)).style;
            int i11 = webvttCssStyle.bold;
            if (i11 == -1 && webvttCssStyle.italic == -1) {
                i = -1;
            } else {
                i = (webvttCssStyle.italic == 1 ? (char) 2 : (char) 0) | (i11 == 1 ? (char) 1 : (char) 0);
            }
            if (i != -1) {
                int i12 = webvttCssStyle.bold;
                if (i12 == -1 && webvttCssStyle.italic == -1) {
                    i3 = -1;
                    i2 = 1;
                } else {
                    i2 = 1;
                    i3 = (i12 == 1 ? 1 : 0) | (webvttCssStyle.italic == 1 ? 2 : 0);
                }
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new StyleSpan(i3), i4, length);
            } else {
                i2 = 1;
            }
            if (webvttCssStyle.linethrough == i2) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i4, length, 33);
            }
            if (webvttCssStyle.underline == i2) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, length, 33);
            }
            if (webvttCssStyle.hasFontColor) {
                if (!webvttCssStyle.hasFontColor) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Font color not defined");
                    return;
                }
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.fontColor), i4, length);
            }
            if (webvttCssStyle.hasBackgroundColor) {
                if (!webvttCssStyle.hasBackgroundColor) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Background color not defined.");
                    return;
                }
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.backgroundColor), i4, length);
            }
            if (webvttCssStyle.fontFamily != null) {
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.fontFamily), i4, length);
            }
            int i13 = webvttCssStyle.fontSizeUnit;
            if (i13 == 1) {
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.fontSize, true), i4, length);
            } else if (i13 == 2) {
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.fontSize), i4, length);
            } else if (i13 == 3) {
                DatabaseDao_Impl.AnonymousClass17.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.fontSize / 100.0f), i4, length);
            }
            if (webvttCssStyle.combineUpright) {
                spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i4, length, 33);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static ArrayList getApplicableStyles(List list, String str, StartTag startTag) {
        ?? r4;
        int size;
        boolean zIsEmpty;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle) list.get(i);
            String str2 = startTag.name;
            Set set = startTag.classes;
            String str3 = startTag.voice;
            if (webvttCssStyle.targetId.isEmpty() && webvttCssStyle.targetTag.isEmpty() && webvttCssStyle.targetClasses.isEmpty() && webvttCssStyle.targetVoice.isEmpty()) {
                zIsEmpty = TextUtils.isEmpty(str2);
            } else {
                int iUpdateScoreForMatch = WebvttCssStyle.updateScoreForMatch(WebvttCssStyle.updateScoreForMatch(WebvttCssStyle.updateScoreForMatch(0, 1073741824, webvttCssStyle.targetId, str), 2, webvttCssStyle.targetTag, str2), 4, webvttCssStyle.targetVoice, str3);
                if (iUpdateScoreForMatch == -1 || !set.containsAll(webvttCssStyle.targetClasses)) {
                    r4 = 0;
                } else {
                    size = iUpdateScoreForMatch + (webvttCssStyle.targetClasses.size() * 4);
                }
            }
            if (r4 > 0) {
                r4 = size;
                r4 = zIsEmpty;
                arrayList.add(new StyleMatch(r4, webvttCssStyle));
            } else {
                r4 = size;
                r4 = zIsEmpty;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int getRubyPosition(List list, String str, StartTag startTag) {
        ArrayList applicableStyles = getApplicableStyles(list, str, startTag);
        for (int i = 0; i < applicableStyles.size(); i++) {
            int i2 = ((StyleMatch) applicableStyles.get(i)).style.rubyPosition;
            if (i2 != -1) {
                return i2;
            }
        }
        return -1;
    }

    public static WebvttCueInfo parseCue(String str, Matcher matcher, ParsableByteArray parsableByteArray, ArrayList arrayList) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            webvttCueInfoBuilder.startTimeUs = WebvttParserUtil.parseTimestampUs(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            webvttCueInfoBuilder.endTimeUs = WebvttParserUtil.parseTimestampUs(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            parseCueSettingsList(strGroup3, webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            String line = parsableByteArray.readLine(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(line)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line.trim());
                line = parsableByteArray.readLine(StandardCharsets.UTF_8);
            }
            webvttCueInfoBuilder.text = parseCueText(str, sb.toString(), arrayList);
            return new WebvttCueInfo(webvttCueInfoBuilder.toCueBuilder().build(), webvttCueInfoBuilder.startTimeUs, webvttCueInfoBuilder.endTimeUs);
        } catch (IllegalArgumentException unused) {
            Log.w("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void parseCueSettingsList(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int i;
        int i2;
        int i3;
        Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                if ("line".equals(strGroup)) {
                    parseLineAttribute(strGroup2, webvttCueInfoBuilder);
                } else {
                    if ("align".equals(strGroup)) {
                        switch (strGroup2) {
                            case "center":
                            case "middle":
                                i = 2;
                                break;
                            case "end":
                                i = 3;
                                break;
                            case "left":
                                i = 4;
                                break;
                            case "right":
                                i = 5;
                                break;
                            case "start":
                                i = 1;
                                break;
                            default:
                                Log.w("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                                i = 2;
                                break;
                        }
                        webvttCueInfoBuilder.textAlignment = i;
                    } else if ("position".equals(strGroup)) {
                        int iIndexOf = strGroup2.indexOf(44);
                        if (iIndexOf != -1) {
                            String strSubstring = strGroup2.substring(iIndexOf + 1);
                            switch (strSubstring) {
                                case "line-left":
                                case "start":
                                    i2 = 0;
                                    break;
                                case "center":
                                case "middle":
                                    i2 = 1;
                                    break;
                                case "line-right":
                                case "end":
                                    i2 = 2;
                                    break;
                                default:
                                    Log.w("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                                    i2 = Integer.MIN_VALUE;
                                    break;
                            }
                            webvttCueInfoBuilder.positionAnchor = i2;
                            strGroup2 = strGroup2.substring(0, iIndexOf);
                        }
                        webvttCueInfoBuilder.position = WebvttParserUtil.parsePercentage(strGroup2);
                    } else if (ContentDisposition.Parameters.Size.equals(strGroup)) {
                        webvttCueInfoBuilder.size = WebvttParserUtil.parsePercentage(strGroup2);
                    } else if ("vertical".equals(strGroup)) {
                        if (strGroup2.equals("lr")) {
                            i3 = 2;
                        } else if (strGroup2.equals("rl")) {
                            i3 = 1;
                        } else {
                            Log.w("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i3 = Integer.MIN_VALUE;
                        }
                        webvttCueInfoBuilder.verticalType = i3;
                    } else {
                        Log.w("WebvttCueParser", "Unknown cue setting " + strGroup + ServerSentEventKt.COLON + strGroup2);
                    }
                }
            } catch (NumberFormatException unused) {
                Log.w("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString parseCueText(String str, String str2, List list) {
        char c;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String strTrim = "";
            if (i >= str2.length()) {
                while (!arrayDeque.isEmpty()) {
                    applySpansForTag(str, (StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                applySpansForTag(str, new StartTag("", 0, "", Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char cCharAt = str2.charAt(i);
            if (cCharAt == '&') {
                i++;
                int iIndexOf = str2.indexOf(59, i);
                int iIndexOf2 = str2.indexOf(32, i);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(i, iIndexOf);
                    switch (strSubstring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            Log.w("WebvttCueParser", "ignoring unsupported entity: '&" + strSubstring + ";'");
                            break;
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) ServerSentEventKt.SPACE);
                    }
                    i = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i++;
            } else {
                int length = i + 1;
                if (length < str2.length()) {
                    boolean z = str2.charAt(length) == '/';
                    int iIndexOf3 = str2.indexOf(62, length);
                    length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                    int i2 = length - 2;
                    boolean z2 = str2.charAt(i2) == '/';
                    int i3 = i + (z ? 2 : 1);
                    if (!z2) {
                        i2 = length - 1;
                    }
                    String strSubstring2 = str2.substring(i3, i2);
                    if (!strSubstring2.trim().isEmpty()) {
                        String strTrim2 = strSubstring2.trim();
                        UtilsKt.checkArgument(!strTrim2.isEmpty());
                        String str3 = Util.DEVICE_DEBUG_INFO;
                        String str4 = strTrim2.split("[ \\.]", 2)[0];
                        str4.getClass();
                        switch (str4) {
                            case "b":
                            case "c":
                            case "i":
                            case "u":
                            case "v":
                            case "rt":
                            case "lang":
                            case "ruby":
                                if (!z) {
                                    if (!z2) {
                                        int length2 = spannableStringBuilder.length();
                                        String strTrim3 = strSubstring2.trim();
                                        UtilsKt.checkArgument(!strTrim3.isEmpty());
                                        int iIndexOf4 = strTrim3.indexOf(ServerSentEventKt.SPACE);
                                        if (iIndexOf4 == -1) {
                                            c = 0;
                                        } else {
                                            strTrim = strTrim3.substring(iIndexOf4).trim();
                                            c = 0;
                                            strTrim3 = strTrim3.substring(0, iIndexOf4);
                                        }
                                        String[] strArrSplit = strTrim3.split("\\.", -1);
                                        String str5 = strArrSplit[c];
                                        HashSet hashSet = new HashSet();
                                        for (int i4 = 1; i4 < strArrSplit.length; i4++) {
                                            hashSet.add(strArrSplit[i4]);
                                        }
                                        arrayDeque.push(new StartTag(str5, length2, strTrim, hashSet));
                                    }
                                    break;
                                } else {
                                    while (!arrayDeque.isEmpty()) {
                                        StartTag startTag = (StartTag) arrayDeque.pop();
                                        applySpansForTag(str, startTag, arrayList, spannableStringBuilder, list);
                                        if (arrayDeque.isEmpty()) {
                                            arrayList.clear();
                                        } else {
                                            arrayList.add(new Element(startTag, spannableStringBuilder.length()));
                                        }
                                        if (startTag.name.equals(str4)) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                }
                i = length;
            }
        }
    }

    public static void parseLineAttribute(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            String strSubstring = str.substring(iIndexOf + 1);
            int i = 2;
            switch (strSubstring) {
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i = 0;
                    break;
                default:
                    Log.w("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                    i = Integer.MIN_VALUE;
                    break;
            }
            webvttCueInfoBuilder.lineAnchor = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.line = WebvttParserUtil.parsePercentage(str);
            webvttCueInfoBuilder.lineType = false;
        } else {
            webvttCueInfoBuilder.line = Integer.parseInt(str);
            webvttCueInfoBuilder.lineType = true;
        }
    }
}
