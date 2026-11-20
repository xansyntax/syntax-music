package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPointerIconType implements PointerIcon {
    public final short type;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPointerIconType(int i) {
        this.type = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AndroidPointerIconType.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        return this.type == ((AndroidPointerIconType) obj).type;
    }

    public final int hashCode() {
        return this.type;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m((int) this.type, "AndroidPointerIcon(type=", ")");
    }
}
