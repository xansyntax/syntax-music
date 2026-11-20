package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum Predicates$ObjectPredicate implements Predicate {
    ALWAYS_TRUE { // from class: com.google.common.base.Predicates$ObjectPredicate.1
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return true;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Predicates.alwaysTrue()";
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF9 { // from class: com.google.common.base.Predicates$ObjectPredicate.2
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return false;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Predicates.alwaysFalse()";
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF14 { // from class: com.google.common.base.Predicates$ObjectPredicate.3
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return obj == null;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Predicates.isNull()";
        }
    },
    /* JADX INFO: Fake field, exist only in values array */
    EF19 { // from class: com.google.common.base.Predicates$ObjectPredicate.4
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return obj != null;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "Predicates.notNull()";
        }
    }
}
