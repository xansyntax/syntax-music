package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReverseOrdering extends Ordering implements Serializable {
    public final Ordering forwardOrder;

    public ReverseOrdering(Ordering ordering) {
        this.forwardOrder = ordering;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.forwardOrder.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public final int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        return this.forwardOrder;
    }

    public final String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
