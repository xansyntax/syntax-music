package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MapEntry implements Map.Entry, KMappedMarker {
    public final /* synthetic */ byte $r8$classId;
    public final Object key;
    public final Object value;

    public /* synthetic */ MapEntry(Object obj, Object obj2, byte b) {
        this.$r8$classId = b;
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        switch (this.$r8$classId) {
            case 1:
                Map.Entry entry = obj instanceof Map.Entry ? (Map.Entry) obj : null;
                return entry != null && Intrinsics.areEqual(entry.getKey(), this.key) && Intrinsics.areEqual(entry.getValue(), getValue());
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        switch (this.$r8$classId) {
            case 1:
                Object obj = this.key;
                int iHashCode = obj != null ? obj.hashCode() : 0;
                Object value = getValue();
                return iHashCode ^ (value != null ? value.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 1:
                return this.key + "=" + getValue();
            default:
                return super.toString();
        }
    }
}
