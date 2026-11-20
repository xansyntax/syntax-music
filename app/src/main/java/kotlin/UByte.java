package kotlin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UByte implements Comparable {
    public final byte data;

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1868toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(this.data & 255, ((UByte) obj).data & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UByte) {
            return this.data == ((UByte) obj).data;
        }
        return false;
    }

    public final int hashCode() {
        return Byte.hashCode(this.data);
    }

    public final String toString() {
        return m1868toStringimpl(this.data);
    }
}
