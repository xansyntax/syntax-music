package androidx.compose.ui.input.indirect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IndirectPointerEventPrimaryDirectionalMotionAxis {
    public final int value;

    public final boolean equals(Object obj) {
        if (obj instanceof IndirectPointerEventPrimaryDirectionalMotionAxis) {
            return this.value == ((IndirectPointerEventPrimaryDirectionalMotionAxis) obj).value;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.value, "IndirectPointerEventPrimaryDirectionalMotionAxis(value=", ")");
    }
}
