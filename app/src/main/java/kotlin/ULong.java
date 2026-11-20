package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ULong implements Comparable {
    public final long data;

    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1869equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Intrinsics.compare(this.data ^ Long.MIN_VALUE, ((ULong) obj).data ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ULong) {
            return this.data == ((ULong) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.data);
    }

    public final String toString() {
        return ResultKt.ulongToString(10, this.data);
    }
}
