package androidx.compose.runtime.tooling;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectLocation {
    public final Integer dataOffset;
    public final int group;

    public ObjectLocation(int i, Integer num) {
        this.group = i;
        this.dataOffset = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectLocation)) {
            return false;
        }
        ObjectLocation objectLocation = (ObjectLocation) obj;
        return this.group == objectLocation.group && Intrinsics.areEqual(this.dataOffset, objectLocation.dataOffset);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.group) * 31;
        Integer num = this.dataOffset;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "ObjectLocation(group=" + this.group + ", dataOffset=" + this.dataOffset + ")";
    }
}
