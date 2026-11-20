package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda0;
import coil3.Extras;
import coil3.util.LifecyclesKt;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVector extends AbstractPersistentList {
    public final Object[] root;
    public final int rootShift;
    public final int size;
    public final Object[] tail;

    public PersistentVector(Object[] objArr, Object[] objArr2, int i, int i2) {
        this.root = objArr;
        this.tail = objArr2;
        this.size = i;
        this.rootShift = i2;
        if (!(getSize() > 32)) {
            PreconditionsKt.throwIllegalArgumentException("Trie-based persistent vector should have at least 33 elements, got " + getSize());
        }
        int length = objArr2.length;
    }

    public static Object[] insertIntoRoot(Object[] objArr, int i, int i2, Object obj, Extras.Key key) {
        int iIndexSegment = MathKt.indexSegment(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iIndexSegment == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            ArraysKt.copyInto(iIndexSegment + 1, iIndexSegment, 31, objArr, objArrCopyOf);
            key.f9default = objArr[31];
            objArrCopyOf[iIndexSegment] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        Object obj2 = objArr[iIndexSegment];
        obj2.getClass();
        objArrCopyOf2[iIndexSegment] = insertIntoRoot((Object[]) obj2, i3, i2, obj, key);
        while (true) {
            iIndexSegment++;
            if (iIndexSegment >= 32 || objArrCopyOf2[iIndexSegment] == null) {
                break;
            }
            Object obj3 = objArr[iIndexSegment];
            obj3.getClass();
            objArrCopyOf2[iIndexSegment] = insertIntoRoot((Object[]) obj3, i3, 0, key.f9default, key);
        }
        return objArrCopyOf2;
    }

    public static Object[] pullLastBuffer(Object[] objArr, int i, int i2, Extras.Key key) {
        Object[] objArrPullLastBuffer;
        int iIndexSegment = MathKt.indexSegment(i2, i);
        if (i == 5) {
            key.f9default = objArr[iIndexSegment];
            objArrPullLastBuffer = null;
        } else {
            Object obj = objArr[iIndexSegment];
            obj.getClass();
            objArrPullLastBuffer = pullLastBuffer((Object[]) obj, i - 5, i2, key);
        }
        if (objArrPullLastBuffer == null && iIndexSegment == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        objArrCopyOf[iIndexSegment] = objArrPullLastBuffer;
        return objArrCopyOf;
    }

    public static Object[] setInRoot(int i, int i2, Object obj, Object[] objArr) {
        int iIndexSegment = MathKt.indexSegment(i2, i);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        if (i == 0) {
            objArrCopyOf[iIndexSegment] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iIndexSegment];
        obj2.getClass();
        objArrCopyOf[iIndexSegment] = setInRoot(i - 5, i2, obj, (Object[]) obj2);
        return objArrCopyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List
    public final AbstractPersistentList add(int i, Object obj) {
        int i2 = this.size;
        LifecyclesKt.checkPositionIndex$runtime(i, i2);
        if (i == i2) {
            return add(obj);
        }
        int iRootSize = rootSize();
        Object[] objArr = this.root;
        if (i >= iRootSize) {
            return insertIntoTail(i - iRootSize, obj, objArr);
        }
        Extras.Key key = new Extras.Key(null);
        return insertIntoTail(0, key.f9default, insertIntoRoot(objArr, this.rootShift, i, obj, key));
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr;
        LifecyclesKt.checkElementIndex$runtime(i, getSize());
        if (rootSize() <= i) {
            objArr = this.tail;
        } else {
            Object[] objArr2 = this.root;
            for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
                Object[] objArr3 = objArr2[MathKt.indexSegment(i, i2)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.size;
    }

    public final PersistentVector insertIntoTail(int i, Object obj, Object[] objArr) {
        int iRootSize = rootSize();
        int i2 = this.size;
        int i3 = i2 - iRootSize;
        Object[] objArr2 = this.tail;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        if (i3 < 32) {
            ArraysKt.copyInto(i + 1, i, i3, objArr2, objArrCopyOf);
            objArrCopyOf[i] = obj;
            return new PersistentVector(objArr, objArrCopyOf, i2 + 1, this.rootShift);
        }
        Object obj2 = objArr2[31];
        ArraysKt.copyInto(i + 1, i, i3 - 1, objArr2, objArrCopyOf);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return pushFilledTail(objArr, objArrCopyOf, objArr3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        LifecyclesKt.checkPositionIndex$runtime(i, this.size);
        return new PersistentVectorIterator(i, this.size, (this.rootShift / 5) + 1, this.root, this.tail);
    }

    public final PersistentVector pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.size;
        int i2 = i >> 5;
        int i3 = this.rootShift;
        if (i2 <= (1 << i3)) {
            return new PersistentVector(pushTail(i3, objArr, objArr2), objArr3, i + 1, i3);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i4 = i3 + 5;
        return new PersistentVector(pushTail(i4, objArr4, objArr2), objArr3, i + 1, i4);
    }

    public final Object[] pushTail(int i, Object[] objArr, Object[] objArr2) {
        int iIndexSegment = MathKt.indexSegment(getSize() - 1, i);
        Object[] objArrCopyOf = objArr != null ? Arrays.copyOf(objArr, 32) : new Object[32];
        if (i == 5) {
            objArrCopyOf[iIndexSegment] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iIndexSegment] = pushTail(i - 5, (Object[]) objArrCopyOf[iIndexSegment], objArr2);
        return objArrCopyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final AbstractPersistentList removeAll(SnapshotStateList$$ExternalSyntheticLambda0 snapshotStateList$$ExternalSyntheticLambda0) {
        PersistentVectorBuilder persistentVectorBuilder = new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
        persistentVectorBuilder.removeAllWithPredicate(snapshotStateList$$ExternalSyntheticLambda0);
        return persistentVectorBuilder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final AbstractPersistentList removeAt(int i) {
        LifecyclesKt.checkElementIndex$runtime(i, getSize());
        int iRootSize = rootSize();
        int i2 = this.rootShift;
        Object[] objArr = this.root;
        return i >= iRootSize ? removeFromTailAt(objArr, iRootSize, i2, i - iRootSize) : removeFromTailAt(removeFromRootAt(objArr, i2, i, new Extras.Key(this.tail[0])), iRootSize, i2, 0);
    }

    public final Object[] removeFromRootAt(Object[] objArr, int i, int i2, Extras.Key key) {
        int iIndexSegment = MathKt.indexSegment(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iIndexSegment == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            ArraysKt.copyInto(iIndexSegment, iIndexSegment + 1, 32, objArr, objArrCopyOf);
            objArrCopyOf[31] = key.f9default;
            key.f9default = objArr[iIndexSegment];
            return objArrCopyOf;
        }
        int iIndexSegment2 = objArr[31] == null ? MathKt.indexSegment(rootSize() - 1, i) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        int i4 = iIndexSegment + 1;
        if (i4 <= iIndexSegment2) {
            while (true) {
                Object obj = objArrCopyOf2[iIndexSegment2];
                obj.getClass();
                objArrCopyOf2[iIndexSegment2] = removeFromRootAt((Object[]) obj, i3, 0, key);
                if (iIndexSegment2 == i4) {
                    break;
                }
                iIndexSegment2--;
            }
        }
        Object obj2 = objArrCopyOf2[iIndexSegment];
        obj2.getClass();
        objArrCopyOf2[iIndexSegment] = removeFromRootAt((Object[]) obj2, i3, i2, key);
        return objArrCopyOf2;
    }

    public final AbstractPersistentList removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        int i4 = this.size - i;
        if (i4 != 1) {
            Object[] objArr2 = this.tail;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            int i5 = i4 - 1;
            if (i3 < i5) {
                ArraysKt.copyInto(i3, i3 + 1, i4, objArr2, objArrCopyOf);
            }
            objArrCopyOf[i5] = null;
            return new PersistentVector(objArr, objArrCopyOf, (i + i4) - 1, i2);
        }
        if (i2 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
            }
            return new SmallPersistentVector(objArr);
        }
        Extras.Key key = new Extras.Key(null);
        Object[] objArrPullLastBuffer = pullLastBuffer(objArr, i2, i - 1, key);
        objArrPullLastBuffer.getClass();
        Object obj = key.f9default;
        obj.getClass();
        Object[] objArr3 = (Object[]) obj;
        if (objArrPullLastBuffer[1] != null) {
            return new PersistentVector(objArrPullLastBuffer, objArr3, i, i2);
        }
        Object obj2 = objArrPullLastBuffer[0];
        obj2.getClass();
        return new PersistentVector((Object[]) obj2, objArr3, i, i2 - 5);
    }

    public final int rootSize() {
        return (this.size - 1) & (-32);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, kotlin.collections.AbstractList, java.util.List
    public final AbstractPersistentList set(int i, Object obj) {
        int i2 = this.size;
        LifecyclesKt.checkElementIndex$runtime(i, i2);
        int iRootSize = rootSize();
        Object[] objArr = this.root;
        Object[] objArr2 = this.tail;
        int i3 = this.rootShift;
        if (iRootSize > i) {
            return new PersistentVector(setInRoot(i3, i, obj, objArr), objArr2, i2, i3);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        objArrCopyOf[i & 31] = obj;
        return new PersistentVector(objArr, objArrCopyOf, i2, i3);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List
    public final AbstractPersistentList add(Object obj) {
        int iRootSize = rootSize();
        int i = this.size;
        int i2 = i - iRootSize;
        Object[] objArr = this.root;
        Object[] objArr2 = this.tail;
        if (i2 < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            objArrCopyOf[i2] = obj;
            return new PersistentVector(objArr, objArrCopyOf, i + 1, this.rootShift);
        }
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj;
        return pushFilledTail(objArr, objArr2, objArr3);
    }
}
