package androidx.compose.ui.unit;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Dp implements Comparable {
    public final float value;

    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m795compareTo0680j_4(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return 0;
        }
        return Float.compare(f, f2);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m796equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m797toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return m795compareTo0680j_4(this.value, ((Dp) obj).value);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Dp) {
            return Float.compare(this.value, ((Dp) obj).value) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.value);
    }

    public final String toString() {
        return m797toStringimpl(this.value);
    }
}
