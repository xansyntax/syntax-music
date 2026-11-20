package androidx.collection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1constructorimpl(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof IntIntPair) {
            return this.packedValue == ((IntIntPair) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        long j = this.packedValue;
        sb.append((int) (j >> 32));
        sb.append(", ");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, (int) (j & 4294967295L), ')');
    }
}
