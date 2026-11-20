package androidx.compose.ui.text.style;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TextAlign {
    public final int value;

    public /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m773boximpl(int i) {
        return new TextAlign(i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m774toStringimpl(int i) {
        if (i == 1) {
            return "Left";
        }
        if (i == 2) {
            return "Right";
        }
        if (i == 3) {
            return "Center";
        }
        if (i == 4) {
            return "Justify";
        }
        if (i == 5) {
            return "Start";
        }
        if (i == 6) {
            return "End";
        }
        return i == 0 ? "Unspecified" : "Invalid";
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TextAlign) {
            return this.value == ((TextAlign) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return m774toStringimpl(this.value);
    }
}
