package com.google.common.collect;

import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableList extends ImmutableList {
    public static final RegularImmutableList EMPTY = new RegularImmutableList(0, new Object[0]);
    public final transient Object[] array;
    public final transient int size;

    public RegularImmutableList(int i, Object[] objArr) {
        this.array = objArr;
        this.size = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int copyIntoArray(int i, Object[] objArr) {
        Object[] objArr2 = this.array;
        int i2 = this.size;
        System.arraycopy(objArr2, 0, objArr, i, i2);
        return i + i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        UtilsKt.checkElementIndex(i, this.size);
        Object obj = this.array[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayEnd() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }
}
