package coil3.memory;

import com.google.common.math.IntMath;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryCache$Key {
    public final Map extras;
    public final String key;

    public MemoryCache$Key(String str, Map map) {
        this.key = str;
        this.extras = IntMath.toImmutableMap(map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryCache$Key)) {
            return false;
        }
        MemoryCache$Key memoryCache$Key = (MemoryCache$Key) obj;
        return Intrinsics.areEqual(this.key, memoryCache$Key.key) && Intrinsics.areEqual(this.extras, memoryCache$Key.extras);
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.key.hashCode() * 31);
    }

    public final String toString() {
        return "Key(key=" + this.key + ", extras=" + this.extras + ")";
    }
}
