package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.random.FallbackThreadLocalRandom$implStorage$1;
import okhttp3.internal._UtilJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DateFormattingKt {
    public static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    public static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final FallbackThreadLocalRandom$implStorage$1 STANDARD_DATE_FORMAT = new FallbackThreadLocalRandom$implStorage$1((byte) 2);

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = strArr;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[strArr.length];
    }

    public static final Date toHttpDateOrNull(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) STANDARD_DATE_FORMAT.get()).parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        String[] strArr = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = BROWSER_COMPATIBLE_DATE_FORMATS;
                    DateFormat simpleDateFormat = dateFormatArr[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
                        simpleDateFormat.setTimeZone(_UtilJvmKt.UTC);
                        dateFormatArr[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
