package androidx.media3.common.util;

import android.app.Notification;
import android.app.Service;
import android.app.UiModeManager;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import coil3.size.SizeKt;
import coil3.util.FileSystemsKt;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.DoubleMath;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentType;
import io.ktor.websocket.ControlFramesKt;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.io.Closeable;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.math.MathKt;
import kotlin.text.StringsKt__IndentKt;
import okio.Path$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Util {
    public static final int[] CRC16_BYTES_MSBF;
    public static final int[] CRC32_BYTES_MSBF;
    public static final int[] CRC8_BYTES_MSBF;
    public static final String DEVICE_DEBUG_INFO;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final long[] EMPTY_LONG_ARRAY;
    public static final Pattern ESCAPED_CHARACTER_PATTERN;
    public static final Pattern ISM_PATH_PATTERN;
    public static final String[] additionalIsoLanguageReplacements;
    public static final String[] isoLegacyTagReplacements;
    public static HashMap languageTagReplacementMap;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api29 {
        public static void startForeground(Service service, int i, Notification notification, int i2, String str) {
            try {
                service.startForeground(i, notification, i2);
            } catch (RuntimeException e) {
                Log.e("Util", "The service must be declared with a foregroundServiceType that includes ".concat(str));
                throw e;
            }
        }
    }

    static {
        String str = Build.DEVICE;
        String str2 = Build.MANUFACTURER;
        DEVICE_DEBUG_INFO = str + ", " + Build.MODEL + ", " + str2 + ", " + Build.VERSION.SDK_INT;
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_LONG_ARRAY = new long[0];
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt ](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)?))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
        ISM_PATH_PATTERN = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        additionalIsoLanguageReplacements = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        isoLegacyTagReplacements = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        CRC32_BYTES_MSBF = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        CRC16_BYTES_MSBF = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        CRC8_BYTES_MSBF = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static int binarySearchCeil(long[] jArr, long j, boolean z) {
        int i;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        while (true) {
            i = iBinarySearch + 1;
            if (i >= jArr.length || jArr[i] != j) {
                break;
            }
            iBinarySearch = i;
        }
        return z ? iBinarySearch : i;
    }

    public static int binarySearchFloor(LongArray longArray, long j) {
        int i = longArray.size - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            if (longArray.get(i3) < j) {
                i2 = i3 + 1;
            } else {
                i = i3 - 1;
            }
        }
        int i4 = i + 1;
        if (i4 < longArray.size && longArray.get(i4) == j) {
            return i4;
        }
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int constrainValue(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    public static boolean contains(SparseArray sparseArray, int i) {
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static boolean contentEquals(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static int contentHashCode(SparseArray sparseArray) {
        if (Build.VERSION.SDK_INT >= 31) {
            return sparseArray.contentHashCode();
        }
        int iHashCode = 17;
        for (int i = 0; i < sparseArray.size(); i++) {
            iHashCode = Objects.hashCode(sparseArray.valueAt(i)) + ((sparseArray.keyAt(i) + (iHashCode * 31)) * 31);
        }
        return iHashCode;
    }

    public static Bundle convertToNullIfInvalid(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ClassLoader classLoader = Util.class.getClassLoader();
        classLoader.getClass();
        bundle.setClassLoader(classLoader);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (RuntimeException e) {
            Log.e("Util", "Ignoring invalid bundle", e);
            return null;
        }
    }

    public static int crc32(int i, int i2, int i3, byte[] bArr) {
        while (i < i2) {
            i3 = CRC32_BYTES_MSBF[((i3 >>> 24) ^ (bArr[i] & 255)) & 255] ^ (i3 << 8);
            i++;
        }
        return i3;
    }

    public static Handler createHandlerForCurrentLooper(MediaCodecVideoRenderer.OnFrameRenderedListener onFrameRenderedListener) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        return new Handler(looperMyLooper, onFrameRenderedListener);
    }

    public static Handler createHandlerForCurrentOrMainLooper(ListenerSet$$ExternalSyntheticLambda0 listenerSet$$ExternalSyntheticLambda0) {
        return new Handler(getCurrentOrMainLooper(), listenerSet$$ExternalSyntheticLambda0);
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, StandardCharsets.UTF_8);
    }

    public static int getApiLevelThatAudioFormatIntroducedAudioEncoding(int i) {
        switch (i) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case DictionaryEntry.PRONUNCIATION /* 12 */:
            case 15:
            case 16:
            case 17:
            case 18:
                return 28;
            case 13:
            case 19:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            default:
                return Integer.MAX_VALUE;
            case 14:
                return 25;
            case 20:
                return 30;
            case 21:
            case 22:
                return 31;
            case 30:
            case 31:
                return 34;
        }
    }

    public static int getAudioTrackChannelConfig(int i) {
        if (i == 10) {
            return Build.VERSION.SDK_INT >= 32 ? 737532 : 6396;
        }
        if (i == 16) {
            return Build.VERSION.SDK_INT >= 32 ? 205215996 : 0;
        }
        if (i == 24) {
            return Build.VERSION.SDK_INT >= 32 ? 67108860 : 0;
        }
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                switch (i) {
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        return 743676;
                    case 13:
                        return Build.VERSION.SDK_INT >= 32 ? 30136348 : 0;
                    case 14:
                        return Build.VERSION.SDK_INT >= 32 ? 202070268 : 0;
                    default:
                        return 0;
                }
        }
    }

    public static int getByteDepth(int i) {
        if (i != 2) {
            if (i == 3) {
                return 1;
            }
            if (i != 4) {
                if (i != 21) {
                    if (i != 22) {
                        if (i != 268435456) {
                            if (i != 1342177280) {
                                if (i != 1610612736) {
                                    if (i == 1879048192) {
                                        return 8;
                                    }
                                    Path$$ExternalSyntheticBUOutline0.m();
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public static Point getCurrentDisplayModeSize(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && isTv(context)) {
            String systemProperty = Build.VERSION.SDK_INT < 28 ? getSystemProperty("sys.display-size") : getSystemProperty("vendor.display-size");
            if (!TextUtils.isEmpty(systemProperty)) {
                try {
                    String[] strArrSplit = systemProperty.trim().split("x", -1);
                    if (strArrSplit.length == 2) {
                        int i = Integer.parseInt(strArrSplit[0]);
                        int i2 = Integer.parseInt(strArrSplit[1]);
                        if (i > 0 && i2 > 0) {
                            return new Point(i, i2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                Log.e("Util", "Invalid display size: " + systemProperty);
            }
            if ("Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
        return point;
    }

    public static Looper getCurrentOrMainLooper() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static int getErrorCodeForMediaDrmErrorCode(int i) {
        if (i == 2 || i == 4) {
            return 6005;
        }
        if (i == 10) {
            return 6004;
        }
        if (i == 7) {
            return 6005;
        }
        if (i == 8) {
            return 6003;
        }
        switch (i) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static int getErrorCodeFromPlatformDiagnosticsInfo(String str) {
        String[] strArrSplit;
        int length;
        int i = 0;
        if (str == null || (length = (strArrSplit = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = strArrSplit[length - 1];
        boolean z = length >= 3 && "neg".equals(strArrSplit[length - 2]);
        try {
            str2.getClass();
            i = Integer.parseInt(str2);
            if (z) {
                return -i;
            }
        } catch (NumberFormatException unused) {
        }
        return i;
    }

    public static long getMediaDurationForPlayoutDuration(long j, float f) {
        return f == 1.0f ? j : Math.round(j * ((double) f));
    }

    public static int getPcmEncoding(int i, ByteOrder byteOrder) {
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            if (byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
                return 2;
            }
            return WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
        }
        if (i == 24) {
            return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 21 : 1342177280;
        }
        if (i != 32) {
            return 0;
        }
        return byteOrder.equals(ByteOrder.LITTLE_ENDIAN) ? 22 : 1610612736;
    }

    public static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            Log.e("Util", "Failed to read system property ".concat(str), e);
            return null;
        }
    }

    public static String getTrackTypeString(int i) {
        switch (i) {
            case -2:
                return "none";
            case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return ContentType.Audio.TYPE;
            case 2:
                return ContentType.Video.TYPE;
            case 3:
                return ContentType.Text.TYPE;
            case 4:
                return ContentType.Image.TYPE;
            case 5:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                return i >= 10000 ? IntIntPair$$ExternalSyntheticOutline0.m(i, "custom (", ")") : "?";
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002a  */
    /* JADX WARN: Code duplicated, block: B:20:0x002e A[RETURN] */
    public static boolean handlePlayButtonAction(Player player) {
        boolean z = false;
        if (player == null) {
            return false;
        }
        int playbackState = player.getPlaybackState();
        if (playbackState != 1 || !player.isCommandAvailable(2)) {
            if (playbackState == 4 && player.isCommandAvailable(4)) {
                player.seekToDefaultPosition();
            }
            if (player.isCommandAvailable(1)) {
                return z;
            }
            player.play();
            return true;
        }
        player.prepare();
        z = true;
        if (player.isCommandAvailable(1)) {
            return z;
        }
        player.play();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x00e1 A[RETURN] */
    public static int inferContentTypeForUriAndMimeType(Uri uri, String str) {
        int i;
        if (str != null) {
            switch (str) {
                case "application/x-mpegURL":
                    return 2;
                case "application/vnd.ms-sstr+xml":
                    return 1;
                case "application/dash+xml":
                    return 0;
                case "application/x-rtsp":
                    return 3;
                default:
                    return 4;
            }
        }
        String scheme = uri.getScheme();
        if (scheme == null || (!LifecyclesKt.equalsIgnoreCase("rtsp", scheme) && !LifecyclesKt.equalsIgnoreCase("rtspt", scheme))) {
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment != null) {
                int iLastIndexOf = lastPathSegment.lastIndexOf(46);
                if (iLastIndexOf >= 0) {
                    String lowerCase = LifecyclesKt.toLowerCase(lastPathSegment.substring(iLastIndexOf + 1));
                    lowerCase.getClass();
                    switch (lowerCase.hashCode()) {
                        case 104579:
                            if (lowerCase.equals("ism")) {
                            }
                            break;
                        case 108321:
                            if (lowerCase.equals("mpd")) {
                            }
                            break;
                        case 3242057:
                            if (lowerCase.equals("isml")) {
                            }
                            break;
                        case 3299913:
                            if (lowerCase.equals("m3u8")) {
                            }
                            break;
                    }
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Switch insn not found in header
                        	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        */
                    /*
                        Method dump skipped, instruction units count: 286
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.Util.inferContentTypeForUriAndMimeType(android.net.Uri, java.lang.String):int");
                }

                public static boolean isEncodingHighResolutionPcm(int i) {
                    return i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4 || i == 1879048192;
                }

                public static boolean isEncodingLinearPcm(int i) {
                    return i == 3 || i == 2 || i == 268435456 || i == 21 || i == 1342177280 || i == 22 || i == 1610612736 || i == 4 || i == 1879048192;
                }

                public static boolean isFrameDropAllowedOnSurfaceInput(Context context) {
                    int i = Build.VERSION.SDK_INT;
                    if (i < 29 || context.getApplicationInfo().targetSdkVersion < 29) {
                        return true;
                    }
                    if (i == 30) {
                        String str = Build.MODEL;
                        if (LifecyclesKt.equalsIgnoreCase(str, "moto g(20)") || LifecyclesKt.equalsIgnoreCase(str, "rmx3231")) {
                            return true;
                        }
                    }
                    return i == 34 && LifecyclesKt.equalsIgnoreCase(Build.MODEL, "sm-x200");
                }

                public static boolean isTv(Context context) {
                    UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
                    return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
                }

                public static boolean maybeInflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
                    if (parsableByteArray.bytesLeft() > 0 && parsableByteArray.peekUnsignedByte() == 120 && parsableByteArray.bytesLeft() != 0) {
                        if (parsableByteArray2.data.length < parsableByteArray.bytesLeft()) {
                            parsableByteArray2.ensureCapacity(parsableByteArray.bytesLeft() * 2);
                        }
                        if (inflater == null) {
                            inflater = new Inflater();
                        }
                        inflater.setInput(parsableByteArray.data, parsableByteArray.position, parsableByteArray.bytesLeft());
                        int iInflate = 0;
                        while (true) {
                            try {
                                byte[] bArr = parsableByteArray2.data;
                                iInflate += inflater.inflate(bArr, iInflate, bArr.length - iInflate);
                                if (inflater.finished()) {
                                    parsableByteArray2.setLimit(iInflate);
                                    inflater.reset();
                                    return true;
                                }
                                if (!inflater.needsDictionary() && !inflater.needsInput()) {
                                    byte[] bArr2 = parsableByteArray2.data;
                                    if (iInflate == bArr2.length) {
                                        parsableByteArray2.ensureCapacity(bArr2.length * 2);
                                    }
                                }
                            } catch (DataFormatException unused) {
                            } catch (Throwable th) {
                                inflater.reset();
                                throw th;
                            }
                            inflater.reset();
                        }
                    }
                    return false;
                }

                public static void moveItems(ArrayList arrayList, int i, int i2, int i3) {
                    ArrayDeque arrayDeque = new ArrayDeque();
                    for (int i4 = (i2 - i) - 1; i4 >= 0; i4--) {
                        arrayDeque.addFirst(arrayList.remove(i + i4));
                    }
                    arrayList.addAll(Math.min(i3, arrayList.size()), arrayDeque);
                }

                public static long msToUs(long j) {
                    return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
                }

                public static String normalizeLanguageCode(String str) {
                    if (str == null) {
                        return null;
                    }
                    String strReplace = str.replace('_', '-');
                    if (!strReplace.isEmpty() && !strReplace.equals("und")) {
                        str = strReplace;
                    }
                    String lowerCase = LifecyclesKt.toLowerCase(str);
                    int i = 0;
                    String str2 = lowerCase.split("-", 2)[0];
                    HashMap map = languageTagReplacementMap;
                    if (map == null) {
                        String[] iSOLanguages = Locale.getISOLanguages();
                        int length = iSOLanguages.length;
                        String[] strArr = additionalIsoLanguageReplacements;
                        HashMap map2 = new HashMap(length + strArr.length);
                        for (String str3 : iSOLanguages) {
                            try {
                                String iSO3Language = new Locale(str3).getISO3Language();
                                if (!TextUtils.isEmpty(iSO3Language)) {
                                    map2.put(iSO3Language, str3);
                                }
                            } catch (MissingResourceException unused) {
                            }
                        }
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            map2.put(strArr[i2], strArr[i2 + 1]);
                        }
                        languageTagReplacementMap = map2;
                        map = map2;
                    }
                    String str4 = (String) map.get(str2);
                    if (str4 != null) {
                        lowerCase = str4.concat(lowerCase.substring(str2.length()));
                        str2 = str4;
                    }
                    if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
                        return lowerCase;
                    }
                    while (true) {
                        String[] strArr2 = isoLegacyTagReplacements;
                        if (i >= strArr2.length) {
                            return lowerCase;
                        }
                        if (lowerCase.startsWith(strArr2[i])) {
                            return strArr2[i + 1] + lowerCase.substring(strArr2[i].length());
                        }
                        i += 2;
                    }
                }

                public static Object[] nullSafeArrayCopy(int i, Object[] objArr) {
                    UtilsKt.checkArgument(i <= objArr.length);
                    return Arrays.copyOf(objArr, i);
                }

                public static int percentInt(long j, long j2) {
                    long jSaturatedMultiply = MathKt.saturatedMultiply(j, 100L);
                    return StringsKt__IndentKt.saturatedCast((jSaturatedMultiply == Long.MAX_VALUE || jSaturatedMultiply == Long.MIN_VALUE) ? j / (j2 / 100) : jSaturatedMultiply / j2);
                }

                public static void postOrRun(Handler handler, Runnable runnable) {
                    Looper looper = handler.getLooper();
                    if (looper.getThread().isAlive()) {
                        if (looper == Looper.myLooper()) {
                            runnable.run();
                        } else {
                            handler.post(runnable);
                        }
                    }
                }

                public static long sampleCountToDurationUs(int i, long j) {
                    return scaleLargeValue(j, 1000000L, i, RoundingMode.DOWN);
                }

                public static void scaleLargeTimestampsInPlace(long[] jArr, long j) {
                    long j2;
                    RoundingMode roundingMode = RoundingMode.DOWN;
                    int i = 0;
                    if (j >= 1000000 && j % 1000000 == 0) {
                        long jDivide = MathKt.divide(j, 1000000L, RoundingMode.UNNECESSARY);
                        while (i < jArr.length) {
                            jArr[i] = MathKt.divide(jArr[i], jDivide, roundingMode);
                            i++;
                        }
                        return;
                    }
                    if (j < 1000000 && 1000000 % j == 0) {
                        long jDivide2 = MathKt.divide(1000000L, j, RoundingMode.UNNECESSARY);
                        while (i < jArr.length) {
                            jArr[i] = MathKt.saturatedMultiply(jArr[i], jDivide2);
                            i++;
                        }
                        return;
                    }
                    int i2 = 0;
                    while (i2 < jArr.length) {
                        long j3 = jArr[i2];
                        if (j3 != 0) {
                            if (j >= j3 && j % j3 == 0) {
                                jArr[i2] = MathKt.divide(1000000L, MathKt.divide(j, j3, RoundingMode.UNNECESSARY), roundingMode);
                            } else if (j >= j3 || j3 % j != 0) {
                                j2 = j;
                                jArr[i2] = scaleLargeValueFallback(j3, 1000000L, j2, roundingMode);
                            } else {
                                jArr[i2] = MathKt.saturatedMultiply(1000000L, MathKt.divide(j3, j, RoundingMode.UNNECESSARY));
                            }
                            j2 = j;
                        } else {
                            j2 = j;
                        }
                        i2++;
                        j = j2;
                    }
                }

                public static long scaleLargeValue(long j, long j2, long j3, RoundingMode roundingMode) {
                    if (j == 0 || j2 == 0) {
                        return 0L;
                    }
                    if (j3 >= j2 && j3 % j2 == 0) {
                        return MathKt.divide(j, MathKt.divide(j3, j2, RoundingMode.UNNECESSARY), roundingMode);
                    }
                    if (j3 < j2 && j2 % j3 == 0) {
                        return MathKt.saturatedMultiply(j, MathKt.divide(j2, j3, RoundingMode.UNNECESSARY));
                    }
                    if (j3 < j || j3 % j != 0) {
                        return (j3 >= j || j % j3 != 0) ? scaleLargeValueFallback(j, j2, j3, roundingMode) : MathKt.saturatedMultiply(j2, MathKt.divide(j, j3, RoundingMode.UNNECESSARY));
                    }
                    return MathKt.divide(j2, MathKt.divide(j3, j, RoundingMode.UNNECESSARY), roundingMode);
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code duplicated, block: B:54:0x00de  */
                /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
                /* JADX WARN: Code duplicated, block: B:59:0x00f2  */
                /* JADX WARN: Code duplicated, block: B:63:0x00f8  */
                /* JADX WARN: Code duplicated, block: B:66:0x00fd  */
                /* JADX WARN: Code duplicated, block: B:68:0x00ff  */
                /* JADX WARN: Instruction removed from duplicated block: B:68:0x00ff, please report this as an issue */
                public static long scaleLargeValueFallback(long j, long j2, long j3, RoundingMode roundingMode) {
                    double dRint;
                    long j4;
                    boolean z;
                    long jSaturatedMultiply = MathKt.saturatedMultiply(j, j2);
                    if (jSaturatedMultiply != Long.MAX_VALUE && jSaturatedMultiply != Long.MIN_VALUE) {
                        return MathKt.divide(jSaturatedMultiply, j3, roundingMode);
                    }
                    long jGcd = MathKt.gcd(Math.abs(j2), Math.abs(j3));
                    RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
                    long jDivide = MathKt.divide(j2, jGcd, roundingMode2);
                    long jDivide2 = MathKt.divide(j3, jGcd, roundingMode2);
                    long jGcd2 = MathKt.gcd(Math.abs(j), Math.abs(jDivide2));
                    long jDivide3 = MathKt.divide(j, jGcd2, roundingMode2);
                    long jDivide4 = MathKt.divide(jDivide2, jGcd2, roundingMode2);
                    long jSaturatedMultiply2 = MathKt.saturatedMultiply(jDivide3, jDivide);
                    if (jSaturatedMultiply2 != Long.MAX_VALUE && jSaturatedMultiply2 != Long.MIN_VALUE) {
                        return MathKt.divide(jSaturatedMultiply2, jDivide4, roundingMode);
                    }
                    double d = jDivide3 * (jDivide / jDivide4);
                    if (d > 9.223372036854776E18d) {
                        return Long.MAX_VALUE;
                    }
                    if (d < -9.223372036854776E18d) {
                        return Long.MIN_VALUE;
                    }
                    int i = DoubleMath.$r8$clinit;
                    if (!SizeKt.isFinite(d)) {
                        throw new ArithmeticException("input is infinite or NaN");
                    }
                    switch (DoubleMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                        case 1:
                            FileSystemsKt.checkRoundingUnnecessary(DoubleMath.isMathematicalInteger(d));
                            dRint = d;
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 2:
                            if (d >= 0.0d || DoubleMath.isMathematicalInteger(d)) {
                                dRint = d;
                            } else {
                                j4 = ((long) d) - 1;
                                dRint = j4;
                            }
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 3:
                            if (d <= 0.0d || DoubleMath.isMathematicalInteger(d)) {
                                dRint = d;
                            } else {
                                j4 = ((long) d) + 1;
                                dRint = j4;
                            }
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 4:
                            dRint = d;
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 5:
                            if (DoubleMath.isMathematicalInteger(d)) {
                                dRint = d;
                            } else {
                                dRint = ((long) d) + ((long) (d > 0.0d ? 1 : -1));
                            }
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 6:
                            dRint = Math.rint(d);
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 7:
                            dRint = Math.rint(d);
                            if (Math.abs(d - dRint) == 0.5d) {
                                dRint = Math.copySign(0.5d, d) + d;
                            }
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        case 8:
                            dRint = Math.rint(d);
                            if (Math.abs(d - dRint) == 0.5d) {
                                dRint = d;
                            }
                            if ((-9.223372036854776E18d) - dRint < 1.0d) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (dRint < 9.223372036854776E18d)) {
                                return (long) dRint;
                            }
                            throw new ArithmeticException("rounded value is out of range for input " + d + " and rounding mode " + roundingMode);
                        default:
                            throw new AssertionError();
                    }
                }

                public static boolean shouldShowPlayButton(Player player, boolean z) {
                    return player == null || !player.getPlayWhenReady() || player.getPlaybackState() == 1 || player.getPlaybackState() == 4 || !(!z || player.getPlaybackSuppressionReason() == 0 || player.getPlaybackSuppressionReason() == 4);
                }

                public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
                    return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
                }

                public static String toFourccString(int i) {
                    return new String(new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i}, StandardCharsets.US_ASCII);
                }

                public static SettableFuture transformFutureAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
                    SettableFuture settableFuture = new SettableFuture();
                    byte b = 0;
                    Util$$ExternalSyntheticLambda0 util$$ExternalSyntheticLambda0 = new Util$$ExternalSyntheticLambda0(settableFuture, listenableFuture, b);
                    DirectExecutor directExecutor = DirectExecutor.INSTANCE;
                    settableFuture.addListener(util$$ExternalSyntheticLambda0, directExecutor);
                    listenableFuture.addListener(new Util$$ExternalSyntheticLambda1(listenableFuture, settableFuture, asyncFunction, b), directExecutor);
                    return settableFuture;
                }

                public static long usToMs(long j) {
                    return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
                }

                public static long constrainValue(long j, long j2, long j3) {
                    return Math.max(j2, Math.min(j, j3));
                }

                public static float constrainValue(float f, float f2, float f3) {
                    return Math.max(f2, Math.min(f, f3));
                }

                public static int binarySearchFloor(int[] iArr, int i, boolean z, boolean z2) {
                    int i2;
                    int i3;
                    int iBinarySearch = Arrays.binarySearch(iArr, i);
                    if (iBinarySearch < 0) {
                        i3 = -(iBinarySearch + 2);
                    } else {
                        while (true) {
                            i2 = iBinarySearch - 1;
                            if (i2 < 0 || iArr[i2] != i) {
                                break;
                            }
                            iBinarySearch = i2;
                        }
                        i3 = z ? iBinarySearch : i2;
                    }
                    return z2 ? Math.max(0, i3) : i3;
                }

                public static int binarySearchFloor(long[] jArr, long j, boolean z) {
                    int i;
                    int iBinarySearch = Arrays.binarySearch(jArr, j);
                    if (iBinarySearch < 0) {
                        i = -(iBinarySearch + 2);
                    } else {
                        while (true) {
                            int i2 = iBinarySearch - 1;
                            if (i2 < 0 || jArr[i2] != j) {
                                break;
                            }
                            iBinarySearch = i2;
                        }
                        i = iBinarySearch;
                    }
                    return z ? Math.max(0, i) : i;
                }
            }
