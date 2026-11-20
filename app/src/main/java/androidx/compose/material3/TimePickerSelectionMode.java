package androidx.compose.material3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TimePickerSelectionMode {
    public final int value;

    public final boolean equals(Object obj) {
        if (obj instanceof TimePickerSelectionMode) {
            return this.value == ((TimePickerSelectionMode) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        int i = this.value;
        if (i == 0) {
            return "Hour";
        }
        return i == 1 ? "Minute" : "";
    }
}
