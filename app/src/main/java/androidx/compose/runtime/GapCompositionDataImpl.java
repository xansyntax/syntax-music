package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GapCompositionDataImpl implements CompositionData {
    public final Composition composition;

    public GapCompositionDataImpl(Composition composition) {
        this.composition = composition;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GapCompositionDataImpl) {
            return this.composition.equals(((GapCompositionDataImpl) obj).composition);
        }
        return false;
    }

    public final int hashCode() {
        return this.composition.hashCode() * 31;
    }
}
