package coil3.memory;

import coil3.Image;
import com.google.common.math.IntMath;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MemoryCache$Value {
    public final Map extras;
    public final Image image;

    public MemoryCache$Value(Image image, Map map) {
        this.image = image;
        this.extras = IntMath.toImmutableMap(map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemoryCache$Value)) {
            return false;
        }
        MemoryCache$Value memoryCache$Value = (MemoryCache$Value) obj;
        return Intrinsics.areEqual(this.image, memoryCache$Value.image) && Intrinsics.areEqual(this.extras, memoryCache$Value.extras);
    }

    public final int hashCode() {
        return this.extras.hashCode() + (this.image.hashCode() * 31);
    }

    public final String toString() {
        return "Value(image=" + this.image + ", extras=" + this.extras + ")";
    }
}
