package androidx.compose.ui.text.style;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BaselineShift {
    public final float multiplier;

    public /* synthetic */ BaselineShift(float f) {
        this.multiplier = f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof BaselineShift) {
            return Float.compare(this.multiplier, ((BaselineShift) obj).multiplier) == 0;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.multiplier);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("BaselineShift(multiplier=", this.multiplier, ")");
    }
}
