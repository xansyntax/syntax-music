package coil3;

import com.google.common.math.IntMath;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Extras {
    public static final Extras EMPTY = new Extras(IntMath.toImmutableMap(new LinkedHashMap()));
    public final Map data;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Key {

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public Object f9default;
    }

    public Extras(Map map) {
        this.data = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Extras) && Intrinsics.areEqual(this.data, ((Extras) obj).data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final String toString() {
        return "Extras(data=" + this.data + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public final LinkedHashMap data;

        public Builder(Extras extras) {
            this.data = MapsKt__MapsKt.toMutableMap(extras.data);
        }

        public final void set(Key key, Object obj) {
            this.data.put(key, obj);
        }

        public Builder() {
            this.data = new LinkedHashMap();
        }
    }
}
