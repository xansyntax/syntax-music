package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UInt implements Comparable {
    public final int data;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Intrinsics.compare(this.data ^ Integer.MIN_VALUE, ((UInt) obj).data ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UInt) {
            return this.data == ((UInt) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.data);
    }

    public final String toString() {
        return String.valueOf(((long) this.data) & 4294967295L);
    }
}
