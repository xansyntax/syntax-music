package androidx.compose.ui.input.pointer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PointerKeyboardModifiers {
    public final int packedValue;

    public final boolean equals(Object obj) {
        if (obj instanceof PointerKeyboardModifiers) {
            return this.packedValue == ((PointerKeyboardModifiers) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.packedValue);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.packedValue, "PointerKeyboardModifiers(packedValue=", ")");
    }
}
