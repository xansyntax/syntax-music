package androidx.media3.datasource.cache;

import android.util.SparseArray;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.util.Util;
import com.materialkolor.quantize.QuantizerWu;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleCacheSpan implements Comparable {
    public static final Pattern CACHE_FILE_PATTERN_V1 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    public static final Pattern CACHE_FILE_PATTERN_V2 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    public static final Pattern CACHE_FILE_PATTERN_V3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public SimpleCacheSpan(String str, long j, long j2, long j3, File file) {
        this.key = str;
        this.position = j;
        this.length = j2;
        this.isCached = file != null;
        this.file = file;
        this.lastTouchTimestamp = j3;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009f A[PHI: r2
      0x009f: PHI (r2v15 java.util.regex.Matcher) = (r2v10 java.util.regex.Matcher), (r2v8 java.util.regex.Matcher) binds: [B:26:0x0095, B:22:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    public static SimpleCacheSpan createCacheEntry(File file, long j, long j2, QuantizerWu quantizerWu) {
        File file2;
        long j3;
        String strGroup;
        File cacheFile;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            String name2 = file.getName();
            Matcher matcher = CACHE_FILE_PATTERN_V2.matcher(name2);
            if (matcher.matches()) {
                strGroup = matcher.group(1);
                strGroup.getClass();
                String str = Util.DEVICE_DEBUG_INFO;
                int length = strGroup.length();
                int iEnd = 0;
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    if (strGroup.charAt(i2) == '%') {
                        i++;
                    }
                }
                if (i != 0) {
                    int i3 = length - (i * 2);
                    StringBuilder sb = new StringBuilder(i3);
                    Matcher matcher2 = Util.ESCAPED_CHARACTER_PATTERN.matcher(strGroup);
                    while (i > 0 && matcher2.find()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        char c = (char) Integer.parseInt(strGroup2, 16);
                        sb.append((CharSequence) strGroup, iEnd, matcher2.start());
                        sb.append(c);
                        iEnd = matcher2.end();
                        i--;
                    }
                    if (iEnd < length) {
                        sb.append((CharSequence) strGroup, iEnd, length);
                    }
                    if (sb.length() != i3) {
                        strGroup = null;
                    } else {
                        strGroup = sb.toString();
                    }
                }
            } else {
                matcher = CACHE_FILE_PATTERN_V1.matcher(name2);
                if (matcher.matches()) {
                    strGroup = matcher.group(1);
                    strGroup.getClass();
                } else {
                    strGroup = null;
                }
            }
            if (strGroup == null) {
                cacheFile = null;
            } else {
                File parentFile = file.getParentFile();
                parentFile.getClass();
                int i4 = quantizerWu.getOrAdd(strGroup).id;
                String strGroup3 = matcher.group(2);
                strGroup3.getClass();
                long j4 = Long.parseLong(strGroup3);
                String strGroup4 = matcher.group(3);
                strGroup4.getClass();
                cacheFile = getCacheFile(parentFile, i4, j4, Long.parseLong(strGroup4));
                if (!file.renameTo(cacheFile)) {
                    cacheFile = null;
                }
            }
            if (cacheFile != null) {
                file2 = cacheFile;
                name = cacheFile.getName();
            }
            return null;
        }
        file2 = file;
        Matcher matcher3 = CACHE_FILE_PATTERN_V3.matcher(name);
        if (matcher3.matches()) {
            String strGroup5 = matcher3.group(1);
            strGroup5.getClass();
            String str2 = (String) ((SparseArray) quantizerWu.momentsR).get(Integer.parseInt(strGroup5));
            if (str2 != null) {
                long length2 = j == -1 ? file2.length() : j;
                if (length2 != 0) {
                    String strGroup6 = matcher3.group(2);
                    strGroup6.getClass();
                    long j5 = Long.parseLong(strGroup6);
                    if (j2 == -9223372036854775807L) {
                        String strGroup7 = matcher3.group(3);
                        strGroup7.getClass();
                        j3 = Long.parseLong(strGroup7);
                    } else {
                        j3 = j2;
                    }
                    return new SimpleCacheSpan(str2, j5, length2, j3, file2);
                }
            }
        }
        return null;
    }

    public static File getCacheFile(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(".");
        sb.append(j);
        sb.append(".");
        return new File(file, IntIntPair$$ExternalSyntheticOutline0.m(sb, j2, ".v3.exo"));
    }

    @Override // java.lang.Comparable
    public final int compareTo(SimpleCacheSpan simpleCacheSpan) {
        String str = simpleCacheSpan.key;
        String str2 = this.key;
        if (!str2.equals(str)) {
            return str2.compareTo(simpleCacheSpan.key);
        }
        long j = this.position - simpleCacheSpan.position;
        if (j == 0) {
            return 0;
        }
        return j < 0 ? -1 : 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.position);
        sb.append(", ");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.length, "]");
    }
}
