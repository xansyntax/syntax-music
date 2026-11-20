package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DynamicValueHolder implements ValueHolder {
    public final ParcelableSnapshotMutableState state;

    public DynamicValueHolder(ParcelableSnapshotMutableState parcelableSnapshotMutableState) {
        this.state = parcelableSnapshotMutableState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DynamicValueHolder) && this.state == ((DynamicValueHolder) obj).state;
    }

    public final int hashCode() {
        return this.state.hashCode();
    }

    @Override // androidx.compose.runtime.ValueHolder
    public final Object readValue(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
        return this.state.getValue();
    }

    public final String toString() {
        return "DynamicValueHolder(state=" + this.state + ")";
    }
}
