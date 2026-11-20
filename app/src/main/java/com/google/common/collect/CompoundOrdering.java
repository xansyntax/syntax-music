package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompoundOrdering extends Ordering implements Serializable {
    public final Comparator[] comparators;

    public CompoundOrdering(ByFunctionOrdering byFunctionOrdering, ByFunctionOrdering byFunctionOrdering2) {
        this.comparators = new Comparator[]{byFunctionOrdering, byFunctionOrdering2};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.comparators;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.comparators, ((CompoundOrdering) obj).comparators);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(new StringBuilder("Ordering.compound("), Arrays.toString(this.comparators), ")");
    }
}
