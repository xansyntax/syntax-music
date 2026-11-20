package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RegularImmutableBiMap extends ImmutableBiMap {
    public static final RegularImmutableBiMap EMPTY = new RegularImmutableBiMap();
    public final transient Object[] alternatingKeysAndValues;
    public final transient RegularImmutableBiMap inverse;
    public final transient Object keyHashTable;
    public final transient boolean keyOffset;
    public final transient int size;

    public RegularImmutableBiMap(int i, Object[] objArr) {
        this.alternatingKeysAndValues = objArr;
        this.size = i;
        this.keyOffset = false;
        int iChooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        Object objCreateHashTable = RegularImmutableMap.createHashTable(objArr, i, iChooseTableSize, 0);
        if (objCreateHashTable instanceof Object[]) {
            throw ((ImmutableMap$Builder$DuplicateKey) ((Object[]) objCreateHashTable)[2]).exception();
        }
        this.keyHashTable = objCreateHashTable;
        Object objCreateHashTable2 = RegularImmutableMap.createHashTable(objArr, i, iChooseTableSize, 1);
        if (objCreateHashTable2 instanceof Object[]) {
            throw ((ImmutableMap$Builder$DuplicateKey) ((Object[]) objCreateHashTable2)[2]).exception();
        }
        this.inverse = new RegularImmutableBiMap(objCreateHashTable2, objArr, i, this);
    }

    @Override // java.util.Map
    public final RegularImmutableMap.EntrySet entrySet() {
        boolean z = this.keyOffset;
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, z ? 1 : 0, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset ? 1 : 0, obj);
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final RegularImmutableMap.KeySet keySet() {
        boolean z = this.keyOffset;
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, z ? 1 : 0, this.size));
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    public RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = false;
        this.size = 0;
        this.inverse = this;
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i, RegularImmutableBiMap regularImmutableBiMap) {
        this.keyHashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.keyOffset = true;
        this.size = i;
        this.inverse = regularImmutableBiMap;
    }
}
