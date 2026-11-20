package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextUnitType {
    public final long type;

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m816equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m817toStringimpl(long j) {
        if (m816equalsimpl0(j, 0L)) {
            return "Unspecified";
        }
        if (m816equalsimpl0(j, 4294967296L)) {
            return "Sp";
        }
        return m816equalsimpl0(j, 8589934592L) ? "Em" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextUnitType) {
            return this.type == ((TextUnitType) obj).type;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.type);
    }

    public final String toString() {
        return m817toStringimpl(this.type);
    }
}
