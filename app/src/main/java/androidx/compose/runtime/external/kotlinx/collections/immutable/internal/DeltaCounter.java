package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeltaCounter {
    public int count;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DeltaCounter) && this.count == ((DeltaCounter) obj).count;
    }

    public final int hashCode() {
        return Integer.hashCode(this.count);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.count, "DeltaCounter(count=", ")");
    }
}
