package androidx.media3.datasource.cache;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CachedContent {
    public final int id;
    public final String key;
    public DefaultContentMetadata metadata;
    public final TreeSet cachedSpans = new TreeSet();
    public final ArrayList lockedRanges = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Range {
        public final long length;
        public final long position;

        public Range(long j, long j2) {
            this.position = j;
            this.length = j2;
        }
    }

    public CachedContent(int i, String str, DefaultContentMetadata defaultContentMetadata) {
        this.id = i;
        this.key = str;
        this.metadata = defaultContentMetadata;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        return this.id == cachedContent.id && this.key.equals(cachedContent.key) && this.cachedSpans.equals(cachedContent.cachedSpans) && this.metadata.equals(cachedContent.metadata);
    }

    public final long getCachedBytesLength(long j, long j2) {
        UtilsKt.checkArgument(j >= 0);
        UtilsKt.checkArgument(j2 >= 0);
        SimpleCacheSpan span = getSpan(j, j2);
        long j3 = span.length;
        if (!span.isCached) {
            if (j3 == -1) {
                j3 = Long.MAX_VALUE;
            }
            return -Math.min(j3, j2);
        }
        long j4 = j + j2;
        long j5 = j4 >= 0 ? j4 : Long.MAX_VALUE;
        long jMax = span.position + j3;
        if (jMax < j5) {
            for (SimpleCacheSpan simpleCacheSpan : this.cachedSpans.tailSet(span, false)) {
                long j6 = simpleCacheSpan.position;
                if (j6 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j6 + simpleCacheSpan.length);
                if (jMax >= j5) {
                    break;
                }
            }
        }
        return Math.min(jMax - j, j2);
    }

    public final SimpleCacheSpan getSpan(long j, long j2) {
        long jMin = j2;
        SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(this.key, j, -1L, -9223372036854775807L, null);
        TreeSet treeSet = this.cachedSpans;
        SimpleCacheSpan simpleCacheSpan2 = (SimpleCacheSpan) treeSet.floor(simpleCacheSpan);
        if (simpleCacheSpan2 != null && simpleCacheSpan2.position + simpleCacheSpan2.length > j) {
            return simpleCacheSpan2;
        }
        SimpleCacheSpan simpleCacheSpan3 = (SimpleCacheSpan) treeSet.ceiling(simpleCacheSpan);
        if (simpleCacheSpan3 != null) {
            long j3 = simpleCacheSpan3.position - j;
            jMin = jMin == -1 ? j3 : Math.min(j3, jMin);
        }
        return new SimpleCacheSpan(this.key, j, jMin, -9223372036854775807L, null);
    }

    public final int hashCode() {
        return this.metadata.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.id * 31, 31, this.key);
    }

    public final boolean isFullyLocked(long j, long j2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.lockedRanges;
            if (i >= arrayList.size()) {
                return false;
            }
            Range range = (Range) arrayList.get(i);
            long j3 = range.position;
            long j4 = range.length;
            if (j4 == -1) {
                if (j >= j3) {
                    return true;
                }
            } else if (j2 != -1 && j3 <= j && j + j2 <= j3 + j4) {
                return true;
            }
            i++;
        }
    }
}
