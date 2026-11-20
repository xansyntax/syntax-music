package androidx.compose.ui.input;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InputMode {
    public final int value;

    public final boolean equals(Object obj) {
        if (obj instanceof InputMode) {
            return this.value == ((InputMode) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        int i = this.value;
        if (i == 1) {
            return "Touch";
        }
        return i == 2 ? "Keyboard" : "Error";
    }
}
