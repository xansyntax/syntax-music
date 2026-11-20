package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ComparisonChain {
    public static final AnonymousClass1 ACTIVE = new AnonymousClass1();
    public static final InactiveComparisonChain LESS = new InactiveComparisonChain(-1);
    public static final InactiveComparisonChain GREATER = new InactiveComparisonChain(1);

    /* JADX INFO: renamed from: com.google.common.collect.ComparisonChain$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends ComparisonChain {
        public static ComparisonChain classify(int i) {
            if (i < 0) {
                return ComparisonChain.LESS;
            }
            return i > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class InactiveComparisonChain extends ComparisonChain {
        public final int result;

        public InactiveComparisonChain(int i) {
            this.result = i;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final int result() {
            return this.result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain compare(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain compare(int i, int i2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public final ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return this;
        }
    }

    public ComparisonChain compare(Object obj, Object obj2, Comparator comparator) {
        return AnonymousClass1.classify(comparator.compare(obj, obj2));
    }

    public ComparisonChain compareFalseFirst(boolean z, boolean z2) {
        return AnonymousClass1.classify(Boolean.compare(z, z2));
    }

    public ComparisonChain compareTrueFirst(boolean z, boolean z2) {
        return AnonymousClass1.classify(Boolean.compare(z2, z));
    }

    public int result() {
        return 0;
    }

    public ComparisonChain compare(int i, int i2) {
        return AnonymousClass1.classify(Integer.compare(i, i2));
    }
}
