package androidx.compose.ui.hapticfeedback;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HapticFeedbackType {
    public final byte value;

    public final boolean equals(Object obj) {
        if (obj instanceof HapticFeedbackType) {
            return this.value == ((HapticFeedbackType) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        byte b = this.value;
        if (b == 16) {
            return "Confirm";
        }
        if (b == 6) {
            return "ContextClick";
        }
        if (b == 13) {
            return "GestureEnd";
        }
        if (b == 23) {
            return "GestureThresholdActivate";
        }
        if (b == 3) {
            return "KeyboardTap";
        }
        if (b == 0) {
            return "LongPress";
        }
        if (b == 17) {
            return "Reject";
        }
        if (b == 27) {
            return "SegmentFrequentTick";
        }
        if (b == 26) {
            return "SegmentTick";
        }
        if (b == 9) {
            return "TextHandleMove";
        }
        if (b == 22) {
            return "ToggleOff";
        }
        if (b == 21) {
            return "ToggleOn";
        }
        return b == 1 ? "VirtualKey" : "Invalid";
    }
}
