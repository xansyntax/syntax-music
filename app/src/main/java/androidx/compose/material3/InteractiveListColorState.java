package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InteractiveListColorState {
    public final boolean dragged;
    public final boolean enabled;

    public InteractiveListColorState(boolean z, boolean z2) {
        this.enabled = z;
        this.dragged = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InteractiveListColorState)) {
            return false;
        }
        InteractiveListColorState interactiveListColorState = (InteractiveListColorState) obj;
        return this.enabled == interactiveListColorState.enabled && this.dragged == interactiveListColorState.dragged;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.dragged) + IntIntPair$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.enabled) * 31, false, 31);
    }

    public final String toString() {
        return "InteractiveListColorState(enabled=" + this.enabled + ", selected=false, dragged=" + this.dragged + ")";
    }
}
