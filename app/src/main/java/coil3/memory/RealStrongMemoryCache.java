package coil3.memory;

import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import coil3.Image;
import com.metrolist.innertubex.InnerTube;
import io.ktor.client.HttpClient;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RealStrongMemoryCache {
    public final Object cache;
    public long initialMaxSize;
    public final Object weakMemoryCache;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InternalValue {
        public final Map extras;
        public final Image image;
        public final long size;

        public InternalValue(Image image, Map map, long j) {
            this.image = image;
            this.extras = map;
            this.size = j;
        }
    }

    public RealStrongMemoryCache(long j, PriorityQueue priorityQueue) {
        this.initialMaxSize = j;
        this.weakMemoryCache = priorityQueue;
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = new RealStrongMemoryCache$cache$1();
        realStrongMemoryCache$cache$1.this$0 = this;
        realStrongMemoryCache$cache$1.map = new LinkedHashMap(0, 0.75f, true);
        realStrongMemoryCache$cache$1.maxSize = j;
        if (j > 0) {
            this.cache = realStrongMemoryCache$cache$1;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("maxSize <= 0");
            throw null;
        }
    }

    /* JADX INFO: renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public void m857addPositionUv8p0NA(long j, long j2) {
        ((VelocityTracker1D) this.weakMemoryCache).addDataPoint(j, Float.intBitsToFloat((int) (j2 >> 32)));
        ((VelocityTracker1D) this.cache).addDataPoint(j, Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }

    public void set(MemoryCache$Key memoryCache$Key, Image image, Map map, long j) {
        RealStrongMemoryCache$cache$1 realStrongMemoryCache$cache$1 = (RealStrongMemoryCache$cache$1) this.cache;
        long j2 = realStrongMemoryCache$cache$1.maxSize;
        LinkedHashMap linkedHashMap = (LinkedHashMap) realStrongMemoryCache$cache$1.map;
        if (j > j2) {
            Object objRemove = linkedHashMap.remove(memoryCache$Key);
            if (objRemove != null) {
                realStrongMemoryCache$cache$1.size = realStrongMemoryCache$cache$1.getSize() - realStrongMemoryCache$cache$1.safeSizeOf(memoryCache$Key, objRemove);
                realStrongMemoryCache$cache$1.entryRemoved(memoryCache$Key, objRemove, null);
            }
            ((PriorityQueue) this.weakMemoryCache).set(memoryCache$Key, image, map, j);
            return;
        }
        InternalValue internalValue = new InternalValue(image, map, j);
        Object objPut = linkedHashMap.put(memoryCache$Key, internalValue);
        realStrongMemoryCache$cache$1.size = realStrongMemoryCache$cache$1.safeSizeOf(memoryCache$Key, internalValue) + realStrongMemoryCache$cache$1.getSize();
        if (objPut != null) {
            realStrongMemoryCache$cache$1.size = realStrongMemoryCache$cache$1.getSize() - realStrongMemoryCache$cache$1.safeSizeOf(memoryCache$Key, objPut);
            realStrongMemoryCache$cache$1.entryRemoved(memoryCache$Key, objPut, internalValue);
        }
        realStrongMemoryCache$cache$1.trimToSize(realStrongMemoryCache$cache$1.maxSize);
    }

    public RealStrongMemoryCache(InnerTube innerTube, HttpClient httpClient, long j) {
        innerTube.getClass();
        httpClient.getClass();
        this.weakMemoryCache = innerTube;
        this.cache = httpClient;
        this.initialMaxSize = j;
    }

    public RealStrongMemoryCache() {
        this.weakMemoryCache = new VelocityTracker1D();
        this.cache = new VelocityTracker1D();
    }
}
