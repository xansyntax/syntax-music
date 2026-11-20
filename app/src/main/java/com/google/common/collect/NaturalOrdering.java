package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NaturalOrdering extends Ordering implements Serializable {
    public static final NaturalOrdering INSTANCE = new NaturalOrdering(0);
    public static final NaturalOrdering INSTANCE$1 = new NaturalOrdering(1);
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ NaturalOrdering(byte b) {
        this.$r8$classId = b;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                if (comparable3 == comparable4) {
                    return 0;
                }
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering reverse() {
        switch (this.$r8$classId) {
            case 0:
                return INSTANCE$1;
            default:
                return INSTANCE;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "Ordering.natural()";
            default:
                return "Ordering.natural().reverse()";
        }
    }
}
