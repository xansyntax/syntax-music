package androidx.compose.foundation.gestures;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollValue {
    public final long bits;

    public final boolean equals(Object obj) {
        if (obj instanceof ScrollValue) {
            return this.bits == ((ScrollValue) obj).bits;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.bits);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.bits, "ScrollValue(bits=", ")");
    }
}
