package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda0;
import coil3.Extras;
import coil3.util.LifecyclesKt;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.UIntArray;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVectorBuilder extends AbstractMutableList implements Collection, KMutableCollection {
    public EndOfChain ownership = new EndOfChain();
    public Object[] root;
    public int rootShift;
    public int size;
    public Object[] tail;
    public AbstractPersistentList vector;
    public Object[] vectorRoot;
    public Object[] vectorTail;

    public PersistentVectorBuilder(AbstractPersistentList abstractPersistentList, Object[] objArr, Object[] objArr2, int i) {
        this.vector = abstractPersistentList;
        this.vectorRoot = objArr;
        this.vectorTail = objArr2;
        this.rootShift = i;
        this.root = objArr;
        this.tail = objArr2;
        this.size = abstractPersistentList.getSize();
    }

    public static void copyToBuffer(Object[] objArr, int i, Iterator it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        LifecyclesKt.checkPositionIndex$runtime(i, getSize());
        if (i == getSize()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iRootSize$1 = rootSize$1();
        if (i >= iRootSize$1) {
            insertIntoTail(i - iRootSize$1, obj, this.root);
            return;
        }
        Extras.Key key = new Extras.Key(null);
        Object[] objArr = this.root;
        objArr.getClass();
        insertIntoTail(0, key.f9default, insertIntoRoot$1(objArr, this.rootShift, i, obj, key));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        Collection collection2;
        Object[] objArrMutableBuffer;
        LifecyclesKt.checkPositionIndex$runtime(i, this.size);
        if (i == this.size) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i2 = (i >> 5) << 5;
        int size = ((collection.size() + (this.size - i2)) - 1) / 32;
        if (size == 0) {
            int i3 = i & 31;
            int size2 = ((collection.size() + i) - 1) & 31;
            Object[] objArr = this.tail;
            Object[] objArrMakeMutable = makeMutable(objArr);
            ArraysKt.copyInto(size2 + 1, i3, tailSize(), objArr, objArrMakeMutable);
            copyToBuffer(objArrMakeMutable, i3, collection.iterator());
            this.tail = objArrMakeMutable;
            this.size = collection.size() + this.size;
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iTailSize = tailSize();
        int size3 = collection.size() + this.size;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (i >= rootSize$1()) {
            objArrMutableBuffer = mutableBuffer();
            collection2 = collection;
            splitToBuffers(collection2, i, this.tail, iTailSize, objArr2, size, objArrMutableBuffer);
            objArr2 = objArr2;
        } else {
            collection2 = collection;
            Object[] objArr3 = this.tail;
            if (size3 > iTailSize) {
                int i4 = size3 - iTailSize;
                Object[] objArrMakeMutableShiftingRight = makeMutableShiftingRight(i4, objArr3);
                insertIntoRoot(collection2, i, i4, objArr2, size, objArrMakeMutableShiftingRight);
                objArr2 = objArr2;
                objArrMutableBuffer = objArrMakeMutableShiftingRight;
            } else {
                objArrMutableBuffer = mutableBuffer();
                int i5 = iTailSize - size3;
                ArraysKt.copyInto(0, i5, iTailSize, objArr3, objArrMutableBuffer);
                int i6 = 32 - i5;
                Object[] objArrMakeMutableShiftingRight2 = makeMutableShiftingRight(i6, this.tail);
                int i7 = size - 1;
                objArr2[i7] = objArrMakeMutableShiftingRight2;
                insertIntoRoot(collection2, i, i6, objArr2, i7, objArrMakeMutableShiftingRight2);
                collection2 = collection2;
            }
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i2, objArr2);
        this.tail = objArrMutableBuffer;
        this.size = collection2.size() + this.size;
        return true;
    }

    public final AbstractPersistentList build() {
        AbstractPersistentList persistentVector;
        Object[] objArr = this.root;
        if (objArr == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new EndOfChain();
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                persistentVector = objArr2.length == 0 ? SmallPersistentVector.EMPTY : new SmallPersistentVector(Arrays.copyOf(objArr2, this.size));
            } else {
                persistentVector = new PersistentVector(objArr, objArr2, this.size, this.rootShift);
            }
        }
        this.vector = persistentVector;
        return persistentVector;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object[] objArr;
        LifecyclesKt.checkElementIndex$runtime(i, getSize());
        if (rootSize$1() <= i) {
            objArr = this.tail;
        } else {
            Object[] objArr2 = this.root;
            objArr2.getClass();
            for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
                Object[] objArr3 = objArr2[MathKt.indexSegment(i, i2)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    public final int getModCount$runtime() {
        return ((AbstractList) this).modCount;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final void insertIntoRoot(Collection collection, int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.root == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("root is null");
            return;
        }
        int i4 = i >> 5;
        AbstractListIterator abstractListIteratorLeafBufferIterator = leafBufferIterator(rootSize$1() >> 5);
        int i5 = i3;
        Object[] objArrMakeMutableShiftingRight = objArr2;
        while (abstractListIteratorLeafBufferIterator.index - 1 != i4) {
            Object[] objArr3 = (Object[]) abstractListIteratorLeafBufferIterator.previous();
            ArraysKt.copyInto(0, 32 - i2, 32, objArr3, objArrMakeMutableShiftingRight);
            objArrMakeMutableShiftingRight = makeMutableShiftingRight(i2, objArr3);
            i5--;
            objArr[i5] = objArrMakeMutableShiftingRight;
        }
        Object[] objArr4 = (Object[]) abstractListIteratorLeafBufferIterator.previous();
        int iRootSize$1 = i3 - (((rootSize$1() >> 5) - 1) - i4);
        if (iRootSize$1 < i3) {
            objArr2 = objArr[iRootSize$1];
            objArr2.getClass();
        }
        splitToBuffers(collection, i, objArr4, 32, objArr, iRootSize$1, objArr2);
    }

    public final Object[] insertIntoRoot$1(Object[] objArr, int i, int i2, Object obj, Extras.Key key) {
        Object obj2;
        int iIndexSegment = MathKt.indexSegment(i2, i);
        if (i == 0) {
            key.f9default = objArr[31];
            Object[] objArrMakeMutable = makeMutable(objArr);
            ArraysKt.copyInto(iIndexSegment + 1, iIndexSegment, 31, objArr, objArrMakeMutable);
            objArrMakeMutable[iIndexSegment] = obj;
            return objArrMakeMutable;
        }
        Object[] objArrMakeMutable2 = makeMutable(objArr);
        int i3 = i - 5;
        Object obj3 = objArrMakeMutable2[iIndexSegment];
        obj3.getClass();
        objArrMakeMutable2[iIndexSegment] = insertIntoRoot$1((Object[]) obj3, i3, i2, obj, key);
        while (true) {
            iIndexSegment++;
            if (iIndexSegment >= 32 || (obj2 = objArrMakeMutable2[iIndexSegment]) == null) {
                break;
            }
            objArrMakeMutable2[iIndexSegment] = insertIntoRoot$1((Object[]) obj2, i3, 0, key.f9default, key);
        }
        return objArrMakeMutable2;
    }

    public final void insertIntoTail(int i, Object obj, Object[] objArr) {
        int iTailSize = tailSize();
        Object[] objArrMakeMutable = makeMutable(this.tail);
        Object[] objArr2 = this.tail;
        if (iTailSize >= 32) {
            Object obj2 = objArr2[31];
            ArraysKt.copyInto(i + 1, i, 31, objArr2, objArrMakeMutable);
            objArrMakeMutable[i] = obj;
            pushFilledTail(objArr, objArrMakeMutable, mutableBufferWith(obj2));
            return;
        }
        ArraysKt.copyInto(i + 1, i, iTailSize, objArr2, objArrMakeMutable);
        objArrMakeMutable[i] = obj;
        this.root = objArr;
        this.tail = objArrMakeMutable;
        this.size++;
    }

    public final boolean isMutable(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.ownership;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final AbstractListIterator leafBufferIterator(int i) {
        Object[] objArr = this.root;
        if (objArr == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Invalid root");
            return null;
        }
        int iRootSize$1 = rootSize$1() >> 5;
        LifecyclesKt.checkPositionIndex$runtime(i, iRootSize$1);
        int i2 = this.rootShift;
        return i2 == 0 ? new BufferIterator(i, objArr) : new TrieIterator(objArr, i, iRootSize$1, i2 / 5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        LifecyclesKt.checkPositionIndex$runtime(i, this.size);
        return new PersistentVectorMutableIterator(this, i);
    }

    public final Object[] makeMutable(Object[] objArr) {
        if (objArr == null) {
            return mutableBuffer();
        }
        if (isMutable(objArr)) {
            return objArr;
        }
        Object[] objArrMutableBuffer = mutableBuffer();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        ArraysKt.copyInto$default(0, length, 6, objArr, objArrMutableBuffer);
        return objArrMutableBuffer;
    }

    public final Object[] makeMutableShiftingRight(int i, Object[] objArr) {
        if (isMutable(objArr)) {
            ArraysKt.copyInto(i, 0, 32 - i, objArr, objArr);
            return objArr;
        }
        Object[] objArrMutableBuffer = mutableBuffer();
        ArraysKt.copyInto(i, 0, 32 - i, objArr, objArrMutableBuffer);
        return objArrMutableBuffer;
    }

    public final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] nullifyAfter(Object[] objArr, int i, int i2) {
        if (i2 < 0) {
            PreconditionsKt.throwIllegalArgumentException("shift should be positive");
        }
        if (i2 == 0) {
            return objArr;
        }
        int iIndexSegment = MathKt.indexSegment(i, i2);
        Object obj = objArr[iIndexSegment];
        obj.getClass();
        Object objNullifyAfter = nullifyAfter((Object[]) obj, i, i2 - 5);
        if (iIndexSegment < 31) {
            int i3 = iIndexSegment + 1;
            if (objArr[i3] != null) {
                if (isMutable(objArr)) {
                    Arrays.fill(objArr, i3, 32, (Object) null);
                }
                Object[] objArrMutableBuffer = mutableBuffer();
                ArraysKt.copyInto(0, 0, i3, objArr, objArrMutableBuffer);
                objArr = objArrMutableBuffer;
            }
        }
        if (objNullifyAfter == objArr[iIndexSegment]) {
            return objArr;
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArrMakeMutable[iIndexSegment] = objNullifyAfter;
        return objArrMakeMutable;
    }

    public final Object[] pullLastBuffer$1(Object[] objArr, int i, int i2, Extras.Key key) {
        Object[] objArrPullLastBuffer$1;
        int iIndexSegment = MathKt.indexSegment(i2 - 1, i);
        if (i == 5) {
            key.f9default = objArr[iIndexSegment];
            objArrPullLastBuffer$1 = null;
        } else {
            Object obj = objArr[iIndexSegment];
            obj.getClass();
            objArrPullLastBuffer$1 = pullLastBuffer$1((Object[]) obj, i - 5, i2, key);
        }
        if (objArrPullLastBuffer$1 == null && iIndexSegment == 0) {
            return null;
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArrMakeMutable[iIndexSegment] = objArrPullLastBuffer$1;
        return objArrMakeMutable;
    }

    public final void pullLastBufferFromRoot(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            this.root = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = i;
            this.rootShift = i2;
            return;
        }
        Extras.Key key = new Extras.Key(null);
        objArr.getClass();
        Object[] objArrPullLastBuffer$1 = pullLastBuffer$1(objArr, i2, i, key);
        objArrPullLastBuffer$1.getClass();
        Object obj = key.f9default;
        obj.getClass();
        this.tail = (Object[]) obj;
        this.size = i;
        if (objArrPullLastBuffer$1[1] == null) {
            this.root = (Object[]) objArrPullLastBuffer$1[0];
            this.rootShift = i2 - 5;
        } else {
            this.root = objArrPullLastBuffer$1;
            this.rootShift = i2;
        }
    }

    public final Object[] pushBuffers(Object[] objArr, int i, int i2, Iterator it) {
        if (!it.hasNext()) {
            PreconditionsKt.throwIllegalArgumentException("invalid buffersIterator");
        }
        if (!(i2 >= 0)) {
            PreconditionsKt.throwIllegalArgumentException("negative shift");
        }
        if (i2 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        int iIndexSegment = MathKt.indexSegment(i, i2);
        int i3 = i2 - 5;
        objArrMakeMutable[iIndexSegment] = pushBuffers((Object[]) objArrMakeMutable[iIndexSegment], i, i3, it);
        while (true) {
            iIndexSegment++;
            if (iIndexSegment >= 32 || !it.hasNext()) {
                break;
            }
            objArrMakeMutable[iIndexSegment] = pushBuffers((Object[]) objArrMakeMutable[iIndexSegment], 0, i3, it);
        }
        return objArrMakeMutable;
    }

    public final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int i, Object[][] objArr2) {
        UIntArray.Iterator iterator = new UIntArray.Iterator(objArr2);
        int i2 = i >> 5;
        int i3 = this.rootShift;
        Object[] objArrPushBuffers = i2 < (1 << i3) ? pushBuffers(objArr, i, i3, iterator) : makeMutable(objArr);
        while (iterator.hasNext()) {
            this.rootShift += 5;
            objArrPushBuffers = mutableBufferWith(objArrPushBuffers);
            int i4 = this.rootShift;
            pushBuffers(objArrPushBuffers, 1 << i4, i4, iterator);
        }
        return objArrPushBuffers;
    }

    public final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.size;
        int i2 = i >> 5;
        int i3 = this.rootShift;
        if (i2 > (1 << i3)) {
            this.root = pushTail(this.rootShift + 5, mutableBufferWith(objArr), objArr2);
            this.tail = objArr3;
            this.rootShift += 5;
            this.size++;
            return;
        }
        if (objArr == null) {
            this.root = objArr2;
            this.tail = objArr3;
            this.size = i + 1;
        } else {
            this.root = pushTail(i3, objArr, objArr2);
            this.tail = objArr3;
            this.size++;
        }
    }

    public final Object[] pushTail(int i, Object[] objArr, Object[] objArr2) {
        int iIndexSegment = MathKt.indexSegment(getSize() - 1, i);
        Object[] objArrMakeMutable = makeMutable(objArr);
        if (i == 5) {
            objArrMakeMutable[iIndexSegment] = objArr2;
            return objArrMakeMutable;
        }
        objArrMakeMutable[iIndexSegment] = pushTail(i - 5, (Object[]) objArrMakeMutable[iIndexSegment], objArr2);
        return objArrMakeMutable;
    }

    public final int recyclableRemoveAll(Function1 function1, Object[] objArr, int i, int i2, Extras.Key key, ArrayList arrayList, ArrayList arrayList2) {
        if (isMutable(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = key.f9default;
        obj.getClass();
        Object[] objArr2 = (Object[]) obj;
        Object[] objArrMutableBuffer = objArr2;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj2 = objArr[i3];
            if (!((Boolean) function1.invoke(obj2)).booleanValue()) {
                if (i2 == 32) {
                    objArrMutableBuffer = !arrayList.isEmpty() ? (Object[]) arrayList.remove(arrayList.size() - 1) : mutableBuffer();
                    i2 = 0;
                }
                objArrMutableBuffer[i2] = obj2;
                i2++;
            }
        }
        key.f9default = objArrMutableBuffer;
        if (objArr2 != objArrMutableBuffer) {
            arrayList2.add(objArr2);
        }
        return i2;
    }

    public final int removeAll(Function1 function1, Object[] objArr, int i, Extras.Key key) {
        Object[] objArrMakeMutable = objArr;
        int i2 = i;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z) {
                    objArrMakeMutable = makeMutable(objArr);
                    z = true;
                    i2 = i3;
                }
            } else if (z) {
                objArrMakeMutable[i2] = obj;
                i2++;
            }
        }
        key.f9default = objArrMakeMutable;
        return i2;
    }

    public final int removeAllFromTail(Function1 function1, int i, Extras.Key key) {
        int iRemoveAll = removeAll(function1, this.tail, i, key);
        Object obj = key.f9default;
        if (iRemoveAll == i) {
            return i;
        }
        obj.getClass();
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, iRemoveAll, i, (Object) null);
        this.tail = objArr;
        this.size -= i - iRemoveAll;
        return iRemoveAll;
    }

    public final boolean removeAllWithPredicate(Function1 function1) {
        int i;
        Function1 function2 = function1;
        int iTailSize = tailSize();
        Object[] objArrNullifyAfter = null;
        Extras.Key key = new Extras.Key(null);
        boolean z = false;
        if (this.root != null) {
            AbstractListIterator abstractListIteratorLeafBufferIterator = leafBufferIterator(0);
            int iRemoveAll = 32;
            while (iRemoveAll == 32 && abstractListIteratorLeafBufferIterator.hasNext()) {
                iRemoveAll = removeAll(function2, (Object[]) abstractListIteratorLeafBufferIterator.next(), 32, key);
            }
            if (iRemoveAll == 32) {
                int iRemoveAllFromTail = removeAllFromTail(function2, iTailSize, key);
                if (iRemoveAllFromTail == 0) {
                    pullLastBufferFromRoot(this.root, this.size, this.rootShift);
                }
                if (iRemoveAllFromTail != iTailSize) {
                }
            } else {
                int i2 = (abstractListIteratorLeafBufferIterator.index - 1) << 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int iRecyclableRemoveAll = iRemoveAll;
                while (abstractListIteratorLeafBufferIterator.hasNext()) {
                    iRecyclableRemoveAll = recyclableRemoveAll(function2, (Object[]) abstractListIteratorLeafBufferIterator.next(), 32, iRecyclableRemoveAll, key, arrayList2, arrayList);
                    function2 = function1;
                }
                int iRecyclableRemoveAll2 = recyclableRemoveAll(function1, this.tail, iTailSize, iRecyclableRemoveAll, key, arrayList2, arrayList);
                Object obj = key.f9default;
                obj.getClass();
                Object[] objArr = (Object[]) obj;
                Arrays.fill(objArr, iRecyclableRemoveAll2, 32, (Object) null);
                boolean zIsEmpty = arrayList.isEmpty();
                Object[] objArrPushBuffers = this.root;
                if (zIsEmpty) {
                    objArrPushBuffers.getClass();
                } else {
                    objArrPushBuffers = pushBuffers(objArrPushBuffers, i2, this.rootShift, arrayList.iterator());
                }
                int size = i2 + (arrayList.size() << 5);
                if ((size & 31) != 0) {
                    PreconditionsKt.throwIllegalArgumentException("invalid size");
                }
                if (size == 0) {
                    this.rootShift = 0;
                } else {
                    int i3 = size - 1;
                    while (true) {
                        i = this.rootShift;
                        if ((i3 >> i) != 0) {
                            break;
                        }
                        this.rootShift = i - 5;
                        Object[] objArr2 = objArrPushBuffers[0];
                        objArr2.getClass();
                        objArrPushBuffers = objArr2;
                    }
                    objArrNullifyAfter = nullifyAfter(objArrPushBuffers, i3, i);
                }
                this.root = objArrNullifyAfter;
                this.tail = objArr;
                this.size = size + iRecyclableRemoveAll2;
            }
            z = true;
        } else if (removeAllFromTail(function2, iTailSize, key) != iTailSize) {
            z = true;
        }
        if (z) {
            ((AbstractList) this).modCount++;
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        LifecyclesKt.checkElementIndex$runtime(i, getSize());
        ((AbstractList) this).modCount++;
        int iRootSize$1 = rootSize$1();
        if (i >= iRootSize$1) {
            return removeFromTailAt(this.root, iRootSize$1, this.rootShift, i - iRootSize$1);
        }
        Extras.Key key = new Extras.Key(this.tail[0]);
        Object[] objArr = this.root;
        objArr.getClass();
        removeFromTailAt(removeFromRootAt$1(objArr, this.rootShift, i, key), iRootSize$1, this.rootShift, 0);
        return key.f9default;
    }

    public final Object[] removeFromRootAt$1(Object[] objArr, int i, int i2, Extras.Key key) {
        int iIndexSegment = MathKt.indexSegment(i2, i);
        if (i == 0) {
            Object obj = objArr[iIndexSegment];
            Object[] objArrMakeMutable = makeMutable(objArr);
            ArraysKt.copyInto(iIndexSegment, iIndexSegment + 1, 32, objArr, objArrMakeMutable);
            objArrMakeMutable[31] = key.f9default;
            key.f9default = obj;
            return objArrMakeMutable;
        }
        int iIndexSegment2 = objArr[31] == null ? MathKt.indexSegment(rootSize$1() - 1, i) : 31;
        Object[] objArrMakeMutable2 = makeMutable(objArr);
        int i3 = i - 5;
        int i4 = iIndexSegment + 1;
        if (i4 <= iIndexSegment2) {
            while (true) {
                Object obj2 = objArrMakeMutable2[iIndexSegment2];
                obj2.getClass();
                objArrMakeMutable2[iIndexSegment2] = removeFromRootAt$1((Object[]) obj2, i3, 0, key);
                if (iIndexSegment2 == i4) {
                    break;
                }
                iIndexSegment2--;
            }
        }
        Object obj3 = objArrMakeMutable2[iIndexSegment];
        obj3.getClass();
        objArrMakeMutable2[iIndexSegment] = removeFromRootAt$1((Object[]) obj3, i3, i2, key);
        return objArrMakeMutable2;
    }

    public final Object removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        int i4 = this.size - i;
        Object[] objArr2 = this.tail;
        if (i4 == 1) {
            Object obj = objArr2[0];
            pullLastBufferFromRoot(objArr, i, i2);
            return obj;
        }
        Object obj2 = objArr2[i3];
        Object[] objArrMakeMutable = makeMutable(objArr2);
        ArraysKt.copyInto(i3, i3 + 1, i4, objArr2, objArrMakeMutable);
        objArrMakeMutable[i4 - 1] = null;
        this.root = objArr;
        this.tail = objArrMakeMutable;
        this.size = (i + i4) - 1;
        this.rootShift = i2;
        return obj2;
    }

    public final int rootSize$1() {
        int i = this.size;
        if (i <= 32) {
            return 0;
        }
        return (i - 1) & (-32);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        LifecyclesKt.checkElementIndex$runtime(i, getSize());
        if (rootSize$1() > i) {
            Extras.Key key = new Extras.Key(null);
            Object[] objArr = this.root;
            objArr.getClass();
            this.root = setInRoot(objArr, this.rootShift, i, obj, key);
            return key.f9default;
        }
        Object[] objArrMakeMutable = makeMutable(this.tail);
        if (objArrMakeMutable != this.tail) {
            ((AbstractList) this).modCount++;
        }
        int i2 = i & 31;
        Object obj2 = objArrMakeMutable[i2];
        objArrMakeMutable[i2] = obj;
        this.tail = objArrMakeMutable;
        return obj2;
    }

    public final Object[] setInRoot(Object[] objArr, int i, int i2, Object obj, Extras.Key key) {
        int iIndexSegment = MathKt.indexSegment(i2, i);
        Object[] objArrMakeMutable = makeMutable(objArr);
        if (i != 0) {
            Object obj2 = objArrMakeMutable[iIndexSegment];
            obj2.getClass();
            objArrMakeMutable[iIndexSegment] = setInRoot((Object[]) obj2, i - 5, i2, obj, key);
            return objArrMakeMutable;
        }
        if (objArrMakeMutable != objArr) {
            ((AbstractList) this).modCount++;
        }
        key.f9default = objArrMakeMutable[iIndexSegment];
        objArrMakeMutable[iIndexSegment] = obj;
        return objArrMakeMutable;
    }

    public final void splitToBuffers(Collection collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] objArrMutableBuffer;
        if (i3 < 1) {
            PreconditionsKt.throwIllegalArgumentException("requires at least one nullBuffer");
        }
        Object[] objArrMakeMutable = makeMutable(objArr);
        objArr2[0] = objArrMakeMutable;
        int i4 = i & 31;
        int size = ((collection.size() + i) - 1) & 31;
        int i5 = (i2 - i4) + size;
        if (i5 < 32) {
            ArraysKt.copyInto(size + 1, i4, i2, objArrMakeMutable, objArr3);
        } else {
            int i6 = i5 - 31;
            if (i3 == 1) {
                objArrMutableBuffer = objArrMakeMutable;
            } else {
                objArrMutableBuffer = mutableBuffer();
                i3--;
                objArr2[i3] = objArrMutableBuffer;
            }
            int i7 = i2 - i6;
            ArraysKt.copyInto(0, i7, i2, objArrMakeMutable, objArr3);
            ArraysKt.copyInto(size + 1, i4, i7, objArrMakeMutable, objArrMutableBuffer);
            objArr3 = objArrMutableBuffer;
        }
        Iterator it = collection.iterator();
        copyToBuffer(objArrMakeMutable, i4, it);
        for (int i8 = 1; i8 < i3; i8++) {
            Object[] objArrMutableBuffer2 = mutableBuffer();
            copyToBuffer(objArrMutableBuffer2, 0, it);
            objArr2[i8] = objArrMutableBuffer2;
        }
        copyToBuffer(objArr3, 0, it);
    }

    public final int tailSize() {
        int i = this.size;
        return i <= 32 ? i : i - ((i - 1) & (-32));
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        return removeAllWithPredicate(new SnapshotStateList$$ExternalSyntheticLambda0(collection, (byte) 2));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iTailSize = tailSize();
        if (iTailSize < 32) {
            Object[] objArrMakeMutable = makeMutable(this.tail);
            objArrMakeMutable[iTailSize] = obj;
            this.tail = objArrMakeMutable;
            this.size = getSize() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iTailSize = tailSize();
        Iterator it = collection.iterator();
        if (32 - iTailSize >= collection.size()) {
            Object[] objArrMakeMutable = makeMutable(this.tail);
            copyToBuffer(objArrMakeMutable, iTailSize, it);
            this.tail = objArrMakeMutable;
            this.size = collection.size() + this.size;
            return true;
        }
        int size = ((collection.size() + iTailSize) - 1) / 32;
        Object[][] objArr = new Object[size][];
        Object[] objArrMakeMutable2 = makeMutable(this.tail);
        copyToBuffer(objArrMakeMutable2, iTailSize, it);
        objArr[0] = objArrMakeMutable2;
        for (int i = 1; i < size; i++) {
            Object[] objArrMutableBuffer = mutableBuffer();
            copyToBuffer(objArrMutableBuffer, 0, it);
            objArr[i] = objArrMutableBuffer;
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize$1(), objArr);
        Object[] objArrMutableBuffer2 = mutableBuffer();
        copyToBuffer(objArrMutableBuffer2, 0, it);
        this.tail = objArrMutableBuffer2;
        this.size = collection.size() + this.size;
        return true;
    }
}
