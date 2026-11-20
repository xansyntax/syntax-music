package androidx.compose.ui.semantics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LiveRegionMode {
    public final boolean value;

    public final boolean equals(Object obj) {
        if (obj instanceof LiveRegionMode) {
            return this.value == ((LiveRegionMode) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value ? 1 : 0);
    }

    public final String toString() {
        boolean z = this.value;
        if (z) {
            return z ? "Assertive" : "Unknown";
        }
        return "Polite";
    }
}
