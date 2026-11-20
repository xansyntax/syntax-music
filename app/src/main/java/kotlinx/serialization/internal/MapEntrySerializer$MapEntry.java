package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MapEntrySerializer$MapEntry implements Map.Entry, KMappedMarker {
    public final Object key;
    public final Object value;

    public MapEntrySerializer$MapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapEntrySerializer$MapEntry)) {
            return false;
        }
        MapEntrySerializer$MapEntry mapEntrySerializer$MapEntry = (MapEntrySerializer$MapEntry) obj;
        return Intrinsics.areEqual(this.key, mapEntrySerializer$MapEntry.key) && Intrinsics.areEqual(this.value, mapEntrySerializer$MapEntry.value);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.key;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.value;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final String toString() {
        return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
    }
}
