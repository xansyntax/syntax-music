package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UShort implements Comparable {
    public final short data;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(this.data & 65535, ((UShort) obj).data & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UShort) {
            return this.data == ((UShort) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return Short.hashCode(this.data);
    }

    public final String toString() {
        return String.valueOf(this.data & 65535);
    }
}
