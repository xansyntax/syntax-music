package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableSet extends ImmutableCollection implements Set {
    public static final /* synthetic */ int $r8$clinit = 0;
    public transient ImmutableList asList;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder extends ImmutableCollection.ArrayBasedBuilder {
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public final /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            add$1(obj);
            return this;
        }

        public final void add$1(Object obj) {
            obj.getClass();
            add(obj);
        }

        public final ImmutableSet build() {
            int i = this.size;
            if (i == 0) {
                int i2 = ImmutableSet.$r8$clinit;
                return RegularImmutableSet.EMPTY;
            }
            Object[] objArr = this.contents;
            if (i != 1) {
                ImmutableSet immutableSetConstruct = ImmutableSet.construct(i, objArr);
                this.size = immutableSetConstruct.size();
                this.forceCopy = true;
                return immutableSetConstruct;
            }
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            int i3 = ImmutableSet.$r8$clinit;
            return new SingletonImmutableSet(obj);
        }
    }

    public static int chooseTableSize(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            UtilsKt.checkArgument("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static ImmutableSet construct(int i, Object... objArr) {
        if (i == 0) {
            return RegularImmutableSet.EMPTY;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new SingletonImmutableSet(obj);
        }
        int iChooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i2 = iChooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            if (obj2 == null) {
                PathKt$$ExternalSyntheticBUOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(i5, "at index "));
                return null;
            }
            int iHashCode = obj2.hashCode();
            int iSmear = Maps.smear(iHashCode);
            while (true) {
                int i6 = iSmear & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iSmear++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new SingletonImmutableSet(obj4);
        }
        if (chooseTableSize(i4) < iChooseTableSize / 2) {
            return construct(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSet(i3, i2, i4, objArr, objArr2);
    }

    public static ImmutableSet copyOf(Collection collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static ImmutableSet of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        UtilsKt.checkArgument("the total number of elements must fit in an int", objArr.length <= 2147483641);
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return construct(length, objArr2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList asList() {
        ImmutableList immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    public ImmutableList createAsList() {
        Object[] array = toArray(ImmutableCollection.EMPTY_ARRAY);
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        return ImmutableList.asImmutableList(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && (this instanceof RegularImmutableSet) && (((ImmutableSet) obj) instanceof RegularImmutableSet) && ((RegularImmutableSet) this).hashCode != obj.hashCode()) {
            return false;
        }
        return Maps.equalsImpl(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Maps.hashCodeImpl(this);
    }
}
