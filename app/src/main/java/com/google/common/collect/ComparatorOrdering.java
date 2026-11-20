package com.google.common.collect;

import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda1;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ComparatorOrdering extends Ordering implements Serializable {
    public final LayoutNode$$ExternalSyntheticLambda1 comparator;

    public ComparatorOrdering(LayoutNode$$ExternalSyntheticLambda1 layoutNode$$ExternalSyntheticLambda1) {
        this.comparator = layoutNode$$ExternalSyntheticLambda1;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ComparatorOrdering) && this.comparator == ((ComparatorOrdering) obj).comparator;
    }

    public final int hashCode() {
        return this.comparator.hashCode();
    }

    public final String toString() {
        return this.comparator.toString();
    }
}
