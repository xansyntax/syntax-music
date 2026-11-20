package com.google.common.collect;

import coil3.util.UtilsKt;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableMultiset extends ImmutableMultiset {
    public static final RegularImmutableMultiset EMPTY;
    public final transient ObjectCountHashMap contents;
    public transient ElementSet elementSet;
    public final transient int size;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ElementSet extends IndexedImmutableSet {
        public ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Object get(int i) {
            ObjectCountHashMap objectCountHashMap = RegularImmutableMultiset.this.contents;
            UtilsKt.checkElementIndex(i, objectCountHashMap.size);
            return objectCountHashMap.keys[i];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return RegularImmutableMultiset.this.contents.size;
        }
    }

    static {
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
        objectCountHashMap.init(3);
        EMPTY = new RegularImmutableMultiset(objectCountHashMap);
    }

    public RegularImmutableMultiset(ObjectCountHashMap objectCountHashMap) {
        this.contents = objectCountHashMap;
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = objectCountHashMap.size;
            if (i >= i2) {
                this.size = StringsKt__IndentKt.saturatedCast(j);
                return;
            } else {
                UtilsKt.checkElementIndex(i, i2);
                j += (long) objectCountHashMap.values[i];
                i++;
            }
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.size;
    }
}
