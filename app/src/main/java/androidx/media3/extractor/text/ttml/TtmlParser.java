package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import android.text.TextUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.material3.FabPlacement;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import coil3.ImageLoader$Builder;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets$2;
import com.google.common.collect.SingletonImmutableSet;
import com.metrolist.music.db.DatabaseDao_Impl;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TtmlParser implements SubtitleParser {
    public final XmlPullParserFactory xmlParserFactory;
    public static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern PIXEL_COORDINATES = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    public static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    public static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class FrameAndTickRate {
        public final float effectiveFrameRate;
        public final int subFrameRate;
        public final int tickRate;

        public FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            PathKt$$ExternalSyntheticBUOutline0.m("Couldn't create XmlPullParserFactory instance", (Throwable) e);
            throw null;
        }
    }

    public static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    public static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals(ContentType.Image.TYPE) || str.equals("data") || str.equals("information");
    }

    public static int parseCellRows(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return 15;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
        boolean z = true;
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            int i2 = Integer.parseInt(strGroup2);
            if (i == 0 || i2 == 0) {
                z = false;
            }
            UtilsKt.checkArgument("Invalid cell resolution %s %s", i, i2, z);
            return i2;
        } catch (NumberFormatException unused) {
            Log.w("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
    }

    public static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String str2 = Util.DEVICE_DEBUG_INFO;
        String[] strArrSplit = str.split("\\s+", -1);
        int length = strArrSplit.length;
        Pattern pattern = FONT_SIZE;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException(Fragment$5$$ExternalSyntheticOutline0.m(new StringBuilder("Invalid number of entries for fontSize: "), strArrSplit.length, "."));
            }
            matcher = pattern.matcher(strArrSplit[1]);
            Log.w("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(IntIntPair$$ExternalSyntheticOutline0.m("Invalid expression for fontSize: '", str, "'."));
        }
        String strGroup = matcher.group(3);
        strGroup.getClass();
        switch (strGroup) {
            case "%":
                ttmlStyle.fontSizeUnit = 3;
                break;
            case "em":
                ttmlStyle.fontSizeUnit = 2;
                break;
            case "px":
                ttmlStyle.fontSizeUnit = 1;
                break;
            default:
                throw new SubtitleDecoderException(IntIntPair$$ExternalSyntheticOutline0.m("Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        strGroup2.getClass();
        ttmlStyle.fontSize = Float.parseFloat(strGroup2);
    }

    public static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String str = Util.DEVICE_DEBUG_INFO;
            String[] strArrSplit = attributeValue2.split(ServerSentEventKt.SPACE, -1);
            UtilsKt.checkArgument("frameRateMultiplier doesn't have 2 parts", strArrSplit.length == 2);
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i2 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i * f, i2, i3);
    }

    /* JADX WARN: Failed to calculate best type for var: r11v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v8 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v9 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r12v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v5 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v2 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v4 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v24 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v25 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v30 ??, new type: float
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: float
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public static void parseHeader(org.xmlpull.v1.XmlPullParser r20, java.util.HashMap r21, int r22, androidx.compose.material3.FabPlacement r23, java.util.HashMap r24, java.util.HashMap r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.parseHeader(org.xmlpull.v1.XmlPullParser, java.util.HashMap, int, androidx.compose.material3.FabPlacement, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x003c  */
    public static TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, HashMap map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j;
        String[] strArrSplit;
        int attributeCount = xmlPullParser.getAttributeCount();
        String[] strArr = null;
        TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, null);
        String strSubstring = null;
        String str = "";
        long timeExpression = -9223372036854775807L;
        long timeExpression2 = -9223372036854775807L;
        long timeExpression3 = -9223372036854775807L;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.getClass();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    timeExpression3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    timeExpression2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    timeExpression = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String strTrim = attributeValue.trim();
                    if (strTrim.isEmpty()) {
                        strArrSplit = new String[0];
                    } else {
                        String str2 = Util.DEVICE_DEBUG_INFO;
                        strArrSplit = strTrim.split("\\s+", -1);
                    }
                    if (strArrSplit.length > 0) {
                        strArr = strArrSplit;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j2 = ttmlNode.startTimeUs;
            if (j2 != -9223372036854775807L) {
                if (timeExpression != -9223372036854775807L) {
                    timeExpression += j2;
                }
                if (timeExpression2 != -9223372036854775807L) {
                    timeExpression2 += j2;
                }
            }
        }
        if (timeExpression2 != -9223372036854775807L) {
            j = timeExpression2;
        } else {
            if (timeExpression3 != -9223372036854775807L) {
                timeExpression2 = timeExpression + timeExpression3;
            } else if (ttmlNode != null) {
                long j3 = ttmlNode.endTimeUs;
                if (j3 != -9223372036854775807L) {
                    j = j3;
                }
            }
            j = timeExpression2;
        }
        return new TtmlNode(xmlPullParser.getName(), null, timeExpression, j, styleAttributes, strArr, str, strSubstring, ttmlNode);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:120:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:152:0x0231  */
    /* JADX WARN: Code duplicated, block: B:154:0x0249  */
    /* JADX WARN: Code duplicated, block: B:160:0x0257  */
    /* JADX WARN: Code duplicated, block: B:163:0x0265  */
    /* JADX WARN: Code duplicated, block: B:168:0x0285  */
    /* JADX WARN: Code duplicated, block: B:170:0x0291  */
    /* JADX WARN: Code duplicated, block: B:171:0x0296  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:177:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:180:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:184:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:185:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:188:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:190:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:193:0x02df  */
    /* JADX WARN: Code duplicated, block: B:196:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:198:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:199:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:6:0x001e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0126  */
    public static TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        byte b;
        int i;
        Sets$2 sets$2Intersection;
        Sets$2 sets$2Intersection2;
        Sets$2 sets$2Intersection3;
        Sets$2.AnonymousClass1 it;
        Object next;
        String str;
        int iHashCode;
        Sets$2.AnonymousClass1 it2;
        Object next2;
        String str2;
        int iHashCode2;
        int i2;
        TextEmphasis textEmphasis;
        String str3;
        int iHashCode3;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleCreateIfNull = ttmlStyle;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            String attributeName = xmlPullParser.getAttributeName(i3);
            attributeName.getClass();
            switch (attributeName) {
                case "fontStyle":
                    b = 0;
                    break;
                case "extent":
                    b = 1;
                    break;
                case "fontFamily":
                    b = 2;
                    break;
                case "textAlign":
                    b = 3;
                    break;
                case "origin":
                    b = 4;
                    break;
                case "textDecoration":
                    b = 5;
                    break;
                case "fontWeight":
                    b = 6;
                    break;
                case "id":
                    b = 7;
                    break;
                case "ruby":
                    b = 8;
                    break;
                case "color":
                    b = 9;
                    break;
                case "shear":
                    b = 10;
                    break;
                case "textCombine":
                    b = 11;
                    break;
                case "fontSize":
                    b = 12;
                    break;
                case "textEmphasis":
                    b = 13;
                    break;
                case "rubyPosition":
                    b = 14;
                    break;
                case "backgroundColor":
                    b = 15;
                    break;
                case "multiRowAlign":
                    b = 16;
                    break;
                default:
                    b = -1;
                    break;
            }
            Layout.Alignment alignment = null;
            switch (b) {
                case 0:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    ttmlStyleCreateIfNull.italic = "italic".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case 1:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    ttmlStyleCreateIfNull.extent = attributeValue;
                    break;
                case 2:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    ttmlStyleCreateIfNull.fontFamily = attributeValue;
                    break;
                case 3:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    String lowerCase = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase.getClass();
                    switch (lowerCase) {
                        case "center":
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case "end":
                        case "right":
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case "left":
                        case "start":
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                    }
                    ttmlStyleCreateIfNull.textAlign = alignment;
                    break;
                case 4:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    ttmlStyleCreateIfNull.origin = attributeValue;
                    break;
                case 5:
                    String lowerCase2 = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase2.getClass();
                    switch (lowerCase2) {
                        case "nounderline":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.underline = 0;
                            break;
                        case "underline":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.underline = 1;
                            break;
                        case "nolinethrough":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.linethrough = 0;
                            break;
                        case "linethrough":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.linethrough = 1;
                            break;
                    }
                    break;
                case 6:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    ttmlStyleCreateIfNull.bold = "bold".equalsIgnoreCase(attributeValue) ? 1 : 0;
                    break;
                case 7:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        ttmlStyleCreateIfNull.id = attributeValue;
                    }
                    break;
                case 8:
                    String lowerCase3 = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase3.getClass();
                    switch (lowerCase3) {
                        case "baseContainer":
                        case "base":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.rubyType = 2;
                            break;
                        case "container":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.rubyType = 1;
                            break;
                        case "delimiter":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.rubyType = 4;
                            break;
                        case "textContainer":
                        case "text":
                            ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                            ttmlStyleCreateIfNull.rubyType = 3;
                            break;
                    }
                    break;
                case 9:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    try {
                        ttmlStyleCreateIfNull.fontColor = ColorParser.parseColorInternal(attributeValue, false);
                        ttmlStyleCreateIfNull.hasFontColor = true;
                    } catch (IllegalArgumentException unused) {
                        Format$$ExternalSyntheticOutline0.m("Failed parsing color value: ", attributeValue, "TtmlParser");
                    }
                    break;
                case 10:
                    TtmlStyle ttmlStyleCreateIfNull2 = createIfNull(ttmlStyleCreateIfNull);
                    Matcher matcher = SIGNED_PERCENTAGE.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher.matches()) {
                        try {
                            String strGroup = matcher.group(1);
                            strGroup.getClass();
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup)));
                        } catch (NumberFormatException e) {
                            Log.w("TtmlParser", "Failed to parse shear: " + attributeValue, e);
                        }
                    } else {
                        Format$$ExternalSyntheticOutline0.m("Invalid value for shear: ", attributeValue, "TtmlParser");
                    }
                    ttmlStyleCreateIfNull2.shearPercentage = fMin;
                    ttmlStyleCreateIfNull = ttmlStyleCreateIfNull2;
                    break;
                case 11:
                    String lowerCase4 = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase4.getClass();
                    if (lowerCase4.equals("all")) {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        ttmlStyleCreateIfNull.textCombine = 1;
                    } else if (lowerCase4.equals("none")) {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        ttmlStyleCreateIfNull.textCombine = 0;
                    }
                    break;
                case DictionaryEntry.PRONUNCIATION /* 12 */:
                    try {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        parseFontSize(attributeValue, ttmlStyleCreateIfNull);
                    } catch (SubtitleDecoderException unused2) {
                        Format$$ExternalSyntheticOutline0.m("Failed parsing fontSize value: ", attributeValue, "TtmlParser");
                    }
                    break;
                case 13:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    Pattern pattern = TextEmphasis.WHITESPACE_PATTERN;
                    if (attributeValue == null) {
                        textEmphasis = null;
                    } else {
                        String lowerCase5 = LifecyclesKt.toLowerCase(attributeValue.trim());
                        if (lowerCase5.isEmpty()) {
                            textEmphasis = null;
                        } else {
                            String[] strArrSplit = TextUtils.split(lowerCase5, TextEmphasis.WHITESPACE_PATTERN);
                            int length = strArrSplit.length;
                            ImmutableSet immutableSetConstruct = length != 0 ? length != 1 ? ImmutableSet.construct(strArrSplit.length, (Object[]) strArrSplit.clone()) : new SingletonImmutableSet(strArrSplit[0]) : RegularImmutableSet.EMPTY;
                            Sets$2.AnonymousClass1 it3 = Maps.intersection(TextEmphasis.POSITION_VALUES, immutableSetConstruct).iterator();
                            String str4 = (String) (it3.hasNext() ? it3.next() : "outside");
                            int iHashCode4 = str4.hashCode();
                            if (iHashCode4 != -1392885889) {
                                if (iHashCode4 != -1106037339) {
                                    if (iHashCode4 == 92734940 && str4.equals("after")) {
                                        i = 2;
                                    }
                                } else if (str4.equals("outside")) {
                                    i = -2;
                                }
                                sets$2Intersection = Maps.intersection(TextEmphasis.SINGLE_STYLE_VALUES, immutableSetConstruct);
                                if (sets$2Intersection.isEmpty()) {
                                    sets$2Intersection2 = Maps.intersection(TextEmphasis.MARK_FILL_VALUES, immutableSetConstruct);
                                    sets$2Intersection3 = Maps.intersection(TextEmphasis.MARK_SHAPE_VALUES, immutableSetConstruct);
                                    if (sets$2Intersection2.isEmpty() || !sets$2Intersection3.isEmpty()) {
                                        it = sets$2Intersection2.iterator();
                                        if (it.hasNext()) {
                                            next = it.next();
                                        } else {
                                            next = "filled";
                                        }
                                        str = (String) next;
                                        iHashCode = str.hashCode();
                                        if (iHashCode != -1274499742) {
                                            int i4 = (iHashCode != 3417674 && str.equals("open")) ? 2 : 1;
                                            it2 = sets$2Intersection3.iterator();
                                            if (it2.hasNext()) {
                                                next2 = it2.next();
                                            } else {
                                                next2 = "circle";
                                            }
                                            str2 = (String) next2;
                                            iHashCode2 = str2.hashCode();
                                            if (iHashCode2 != -1360216880) {
                                                if (iHashCode2 != -905816648) {
                                                    if (iHashCode2 == 99657 && str2.equals("dot")) {
                                                        i2 = 2;
                                                    }
                                                } else if (str2.equals("sesame")) {
                                                    i2 = 3;
                                                }
                                                textEmphasis = new TextEmphasis(i2, i4, i);
                                            } else {
                                                str2.equals("circle");
                                            }
                                            i2 = 1;
                                            textEmphasis = new TextEmphasis(i2, i4, i);
                                        } else {
                                            str.equals("filled");
                                        }
                                        it2 = sets$2Intersection3.iterator();
                                        if (it2.hasNext()) {
                                            next2 = it2.next();
                                        } else {
                                            next2 = "circle";
                                        }
                                        str2 = (String) next2;
                                        iHashCode2 = str2.hashCode();
                                        if (iHashCode2 != -1360216880) {
                                            if (iHashCode2 != -905816648) {
                                                if (iHashCode2 == 99657) {
                                                    i2 = 2;
                                                }
                                            } else if (str2.equals("sesame")) {
                                                i2 = 3;
                                            }
                                            textEmphasis = new TextEmphasis(i2, i4, i);
                                        } else {
                                            str2.equals("circle");
                                        }
                                        i2 = 1;
                                        textEmphasis = new TextEmphasis(i2, i4, i);
                                    } else {
                                        textEmphasis = new TextEmphasis(-1, 0, i);
                                    }
                                } else {
                                    str3 = (String) new Sets$2.AnonymousClass1(sets$2Intersection.val$set1, sets$2Intersection.val$set2).next();
                                    iHashCode3 = str3.hashCode();
                                    if (iHashCode3 != 3005871) {
                                        int i5 = (iHashCode3 != 3387192 && str3.equals("none")) ? 0 : -1;
                                        textEmphasis = new TextEmphasis(i5, 0, i);
                                    } else {
                                        str3.equals("auto");
                                    }
                                    textEmphasis = new TextEmphasis(i5, 0, i);
                                }
                            } else {
                                str4.equals("before");
                            }
                            i = 1;
                            sets$2Intersection = Maps.intersection(TextEmphasis.SINGLE_STYLE_VALUES, immutableSetConstruct);
                            if (sets$2Intersection.isEmpty()) {
                                str3 = (String) new Sets$2.AnonymousClass1(sets$2Intersection.val$set1, sets$2Intersection.val$set2).next();
                                iHashCode3 = str3.hashCode();
                                if (iHashCode3 != 3005871) {
                                    if (iHashCode3 != 3387192) {
                                    }
                                    textEmphasis = new TextEmphasis(i5, 0, i);
                                } else {
                                    str3.equals("auto");
                                }
                                textEmphasis = new TextEmphasis(i5, 0, i);
                            } else {
                                sets$2Intersection2 = Maps.intersection(TextEmphasis.MARK_FILL_VALUES, immutableSetConstruct);
                                sets$2Intersection3 = Maps.intersection(TextEmphasis.MARK_SHAPE_VALUES, immutableSetConstruct);
                                if (sets$2Intersection2.isEmpty()) {
                                    it = sets$2Intersection2.iterator();
                                    if (it.hasNext()) {
                                        next = it.next();
                                    } else {
                                        next = "filled";
                                    }
                                    str = (String) next;
                                    iHashCode = str.hashCode();
                                    if (iHashCode != -1274499742) {
                                        if (iHashCode != 3417674) {
                                        }
                                        it2 = sets$2Intersection3.iterator();
                                        if (it2.hasNext()) {
                                            next2 = it2.next();
                                        } else {
                                            next2 = "circle";
                                        }
                                        str2 = (String) next2;
                                        iHashCode2 = str2.hashCode();
                                        if (iHashCode2 != -1360216880) {
                                            if (iHashCode2 != -905816648) {
                                                if (iHashCode2 == 99657) {
                                                    i2 = 2;
                                                }
                                            } else if (str2.equals("sesame")) {
                                                i2 = 3;
                                            }
                                            textEmphasis = new TextEmphasis(i2, i4, i);
                                        } else {
                                            str2.equals("circle");
                                        }
                                        i2 = 1;
                                        textEmphasis = new TextEmphasis(i2, i4, i);
                                    } else {
                                        str.equals("filled");
                                    }
                                    it2 = sets$2Intersection3.iterator();
                                    if (it2.hasNext()) {
                                        next2 = it2.next();
                                    } else {
                                        next2 = "circle";
                                    }
                                    str2 = (String) next2;
                                    iHashCode2 = str2.hashCode();
                                    if (iHashCode2 != -1360216880) {
                                        if (iHashCode2 != -905816648) {
                                            if (iHashCode2 == 99657) {
                                                i2 = 2;
                                            }
                                        } else if (str2.equals("sesame")) {
                                            i2 = 3;
                                        }
                                        textEmphasis = new TextEmphasis(i2, i4, i);
                                    } else {
                                        str2.equals("circle");
                                    }
                                    i2 = 1;
                                    textEmphasis = new TextEmphasis(i2, i4, i);
                                } else {
                                    it = sets$2Intersection2.iterator();
                                    if (it.hasNext()) {
                                        next = it.next();
                                    } else {
                                        next = "filled";
                                    }
                                    str = (String) next;
                                    iHashCode = str.hashCode();
                                    if (iHashCode != -1274499742) {
                                        if (iHashCode != 3417674) {
                                        }
                                        it2 = sets$2Intersection3.iterator();
                                        if (it2.hasNext()) {
                                            next2 = it2.next();
                                        } else {
                                            next2 = "circle";
                                        }
                                        str2 = (String) next2;
                                        iHashCode2 = str2.hashCode();
                                        if (iHashCode2 != -1360216880) {
                                            if (iHashCode2 != -905816648) {
                                                if (iHashCode2 == 99657) {
                                                    i2 = 2;
                                                }
                                            } else if (str2.equals("sesame")) {
                                                i2 = 3;
                                            }
                                            textEmphasis = new TextEmphasis(i2, i4, i);
                                        } else {
                                            str2.equals("circle");
                                        }
                                        i2 = 1;
                                        textEmphasis = new TextEmphasis(i2, i4, i);
                                    } else {
                                        str.equals("filled");
                                    }
                                    it2 = sets$2Intersection3.iterator();
                                    if (it2.hasNext()) {
                                        next2 = it2.next();
                                    } else {
                                        next2 = "circle";
                                    }
                                    str2 = (String) next2;
                                    iHashCode2 = str2.hashCode();
                                    if (iHashCode2 != -1360216880) {
                                        if (iHashCode2 != -905816648) {
                                            if (iHashCode2 == 99657) {
                                                i2 = 2;
                                            }
                                        } else if (str2.equals("sesame")) {
                                            i2 = 3;
                                        }
                                        textEmphasis = new TextEmphasis(i2, i4, i);
                                    } else {
                                        str2.equals("circle");
                                    }
                                    i2 = 1;
                                    textEmphasis = new TextEmphasis(i2, i4, i);
                                }
                            }
                        }
                    }
                    ttmlStyleCreateIfNull.textEmphasis = textEmphasis;
                    break;
                case 14:
                    String lowerCase6 = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase6.getClass();
                    if (lowerCase6.equals("before")) {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        ttmlStyleCreateIfNull.rubyPosition = 1;
                    } else if (lowerCase6.equals("after")) {
                        ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                        ttmlStyleCreateIfNull.rubyPosition = 2;
                    }
                    break;
                case 15:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    try {
                        ttmlStyleCreateIfNull.backgroundColor = ColorParser.parseColorInternal(attributeValue, false);
                        ttmlStyleCreateIfNull.hasBackgroundColor = true;
                    } catch (IllegalArgumentException unused3) {
                        Format$$ExternalSyntheticOutline0.m("Failed parsing background value: ", attributeValue, "TtmlParser");
                    }
                    break;
                case 16:
                    ttmlStyleCreateIfNull = createIfNull(ttmlStyleCreateIfNull);
                    String lowerCase7 = LifecyclesKt.toLowerCase(attributeValue);
                    lowerCase7.getClass();
                    switch (lowerCase7) {
                        case "center":
                            alignment = Layout.Alignment.ALIGN_CENTER;
                            break;
                        case "end":
                        case "right":
                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                            break;
                        case "left":
                        case "start":
                            alignment = Layout.Alignment.ALIGN_NORMAL;
                            break;
                    }
                    ttmlStyleCreateIfNull.multiRowAlign = alignment;
                    break;
            }
        }
        return ttmlStyleCreateIfNull;
    }

    public static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d;
        double d2;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            double d3 = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            double d4 = d3 + (Long.parseLong(strGroup2) * 60);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d5 = d4 + Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d6 = d5 + (strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d);
            String strGroup5 = matcher.group(5);
            double d7 = d6 + (strGroup5 != null ? Long.parseLong(strGroup5) / frameAndTickRate.effectiveFrameRate : 0.0d);
            String strGroup6 = matcher.group(6);
            return (long) ((d7 + (strGroup6 != null ? (Long.parseLong(strGroup6) / ((double) frameAndTickRate.subFrameRate)) / ((double) frameAndTickRate.effectiveFrameRate) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException(Fragment$5$$ExternalSyntheticOutline0.m("Malformed time expression: ", str));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d8 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        switch (strGroup8) {
            case "f":
                d = frameAndTickRate.effectiveFrameRate;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            case "h":
                d2 = 3600.0d;
                break;
            case "m":
                d2 = 60.0d;
                break;
            case "t":
                d = frameAndTickRate.tickRate;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            case "ms":
                d = 1000.0d;
                d8 /= d;
                return (long) (d8 * 1000000.0d);
            default:
                return (long) (d8 * 1000000.0d);
        }
        d8 *= d2;
        return (long) (d8 * 1000000.0d);
    }

    public static FabPlacement parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = GlUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.w("TtmlParser", "Ignoring non-pixel tts extent: ".concat(attributeValue));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            return new FabPlacement(i, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            Log.w("TtmlParser", "Ignoring malformed tts extent: ".concat(attributeValue));
            return null;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        DatabaseDao_Impl.AnonymousClass17.toCuesWithTiming(parseToLegacySubtitle(bArr, i, i2), outputOptions, consumer);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final Subtitle parseToLegacySubtitle(byte[] bArr, int i, int i2) {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            FabPlacement ttsExtent = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRates = DEFAULT_FRAME_AND_TICK_RATE;
            int i3 = 0;
            int cellRows = 15;
            ImageLoader$Builder imageLoader$Builder = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i3 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRates = parseFrameAndTickRates(xmlPullParserNewPullParser);
                            cellRows = parseCellRows(xmlPullParserNewPullParser);
                            ttsExtent = parseTtsExtent(xmlPullParserNewPullParser);
                        }
                        FrameAndTickRate frameAndTickRate = frameAndTickRates;
                        FabPlacement fabPlacement = ttsExtent;
                        int i4 = cellRows;
                        if (isSupportedTag(name)) {
                            if ("head".equals(name)) {
                                parseHeader(xmlPullParserNewPullParser, map, i4, fabPlacement, map2, map3);
                            } else {
                                try {
                                    TtmlNode node = parseNode(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(node);
                                    if (ttmlNode != null) {
                                        ArrayList arrayList = ttmlNode.children;
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            ttmlNode.children = arrayList;
                                        }
                                        arrayList.add(node);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.w("TtmlParser", "Suppressing parser error", e);
                                    i3++;
                                }
                            }
                            cellRows = i4;
                            ttsExtent = fabPlacement;
                            frameAndTickRates = frameAndTickRate;
                        } else {
                            Log.i("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        }
                        i3++;
                        cellRows = i4;
                        ttsExtent = fabPlacement;
                        frameAndTickRates = frameAndTickRate;
                    } else if (eventType == 4) {
                        ttmlNode.getClass();
                        TtmlNode ttmlNodeBuildTextNode = TtmlNode.buildTextNode(xmlPullParserNewPullParser.getText());
                        ArrayList arrayList2 = ttmlNode.children;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            ttmlNode.children = arrayList2;
                        }
                        arrayList2.add(ttmlNodeBuildTextNode);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.peek();
                            ttmlNode2.getClass();
                            imageLoader$Builder = new ImageLoader$Builder(ttmlNode2, map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i3++;
                } else if (eventType == 3) {
                    i3--;
                }
                xmlPullParserNewPullParser.next();
            }
            imageLoader$Builder.getClass();
            return imageLoader$Builder;
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new IllegalStateException("Unable to decode source", e3);
        }
    }
}
