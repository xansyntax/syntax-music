package com.google.common.collect;

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ByFunctionOrdering extends Ordering implements Serializable {
    public final Function function;
    public final Ordering ordering;

    public ByFunctionOrdering(Function function, Ordering ordering) {
        this.function = function;
        this.ordering = ordering;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Function function = this.function;
        return this.ordering.compare(function.apply(obj), function.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
    }

    public final int hashCode() {
        return Objects.hash(this.function, this.ordering);
    }

    public final String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
