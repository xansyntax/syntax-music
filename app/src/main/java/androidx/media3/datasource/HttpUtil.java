package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpUtil {
    public static final Pattern CONTENT_RANGE_WITH_START_AND_END = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    public static final Pattern CONTENT_RANGE_WITH_SIZE = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String buildRangeRequestHeader(long j, long j2) {
        if (j == 0 && j2 == -1) {
            return null;
        }
        StringBuilder sbM = Fragment$5$$ExternalSyntheticOutline0.m(j, "bytes=", "-");
        if (j2 != -1) {
            sbM.append((j + j2) - 1);
        }
        return sbM.toString();
    }

    public static long getDocumentSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = CONTENT_RANGE_WITH_SIZE.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Long.parseLong(strGroup);
    }
}
