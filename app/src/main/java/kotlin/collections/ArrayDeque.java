package kotlin.collections;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArrayDeque extends AbstractMutableList {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData;
    public int head;
    public int size;

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else {
            if (i <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Illegal Capacity: "));
                throw null;
            }
            objArr = new Object[i];
        }
        this.elementData = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
            return;
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        registerModification();
        ensureCapacity$1(this.size + 1);
        int iPositiveMod = positiveMod(this.head + i);
        int i3 = this.size;
        if (i < ((i3 + 1) >> 1)) {
            int length = iPositiveMod == 0 ? this.elementData.length - 1 : iPositiveMod - 1;
            int i4 = this.head;
            int length2 = i4 == 0 ? this.elementData.length - 1 : i4 - 1;
            Object[] objArr = this.elementData;
            if (length >= i4) {
                objArr[length2] = objArr[i4];
                ArraysKt.copyInto(i4, i4 + 1, length + 1, objArr, objArr);
            } else {
                ArraysKt.copyInto(i4 - 1, i4, objArr.length, objArr, objArr);
                Object[] objArr2 = this.elementData;
                objArr2[objArr2.length - 1] = objArr2[0];
                ArraysKt.copyInto(0, 1, length + 1, objArr2, objArr2);
            }
            this.elementData[length] = obj;
            this.head = length2;
        } else {
            int iPositiveMod2 = positiveMod(i3 + this.head);
            Object[] objArr3 = this.elementData;
            if (iPositiveMod < iPositiveMod2) {
                ArraysKt.copyInto(iPositiveMod + 1, iPositiveMod, iPositiveMod2, objArr3, objArr3);
            } else {
                ArraysKt.copyInto(1, 0, iPositiveMod2, objArr3, objArr3);
                Object[] objArr4 = this.elementData;
                objArr4[0] = objArr4[objArr4.length - 1];
                ArraysKt.copyInto(iPositiveMod + 1, iPositiveMod, objArr4.length - 1, objArr4, objArr4);
            }
            this.elementData[iPositiveMod] = obj;
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        int i2 = this.size;
        if (i < 0 || i > i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
            return false;
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.size) {
            return addAll(collection);
        }
        registerModification();
        ensureCapacity$1(collection.size() + this.size);
        int iPositiveMod = positiveMod(this.size + this.head);
        int iPositiveMod2 = positiveMod(this.head + i);
        int size = collection.size();
        if (i >= ((this.size + 1) >> 1)) {
            int i3 = iPositiveMod2 + size;
            Object[] objArr = this.elementData;
            if (iPositiveMod2 < iPositiveMod) {
                int i4 = size + iPositiveMod;
                if (i4 <= objArr.length) {
                    ArraysKt.copyInto(i3, iPositiveMod2, iPositiveMod, objArr, objArr);
                } else if (i3 >= objArr.length) {
                    ArraysKt.copyInto(i3 - objArr.length, iPositiveMod2, iPositiveMod, objArr, objArr);
                } else {
                    int length = iPositiveMod - (i4 - objArr.length);
                    ArraysKt.copyInto(0, length, iPositiveMod, objArr, objArr);
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(i3, iPositiveMod2, length, objArr2, objArr2);
                }
            } else {
                ArraysKt.copyInto(size, 0, iPositiveMod, objArr, objArr);
                Object[] objArr3 = this.elementData;
                if (i3 >= objArr3.length) {
                    ArraysKt.copyInto(i3 - objArr3.length, iPositiveMod2, objArr3.length, objArr3, objArr3);
                } else {
                    ArraysKt.copyInto(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(i3, iPositiveMod2, objArr4.length - size, objArr4, objArr4);
                }
            }
            copyCollectionElements(iPositiveMod2, collection);
            return true;
        }
        int i5 = this.head;
        int length2 = i5 - size;
        Object[] objArr5 = this.elementData;
        if (iPositiveMod2 < i5) {
            ArraysKt.copyInto(length2, i5, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.elementData;
            if (size >= iPositiveMod2) {
                ArraysKt.copyInto(objArr6.length - size, 0, iPositiveMod2, objArr6, objArr6);
            } else {
                ArraysKt.copyInto(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.elementData;
                ArraysKt.copyInto(0, size, iPositiveMod2, objArr7, objArr7);
            }
        } else if (length2 >= 0) {
            ArraysKt.copyInto(length2, i5, iPositiveMod2, objArr5, objArr5);
        } else {
            length2 += objArr5.length;
            int i6 = iPositiveMod2 - i5;
            int length3 = objArr5.length - length2;
            if (length3 >= i6) {
                ArraysKt.copyInto(length2, i5, iPositiveMod2, objArr5, objArr5);
            } else {
                ArraysKt.copyInto(length2, i5, i5 + length3, objArr5, objArr5);
                Object[] objArr8 = this.elementData;
                ArraysKt.copyInto(0, this.head + length3, iPositiveMod2, objArr8, objArr8);
            }
        }
        this.head = length2;
        copyCollectionElements(negativeMod(iPositiveMod2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        registerModification();
        ensureCapacity$1(this.size + 1);
        int length = this.head;
        if (length == 0) {
            length = this.elementData.length;
        }
        int i = length - 1;
        this.head = i;
        this.elementData[i] = obj;
        this.size++;
    }

    public final void addLast(Object obj) {
        registerModification();
        ensureCapacity$1(this.size + 1);
        this.elementData[positiveMod(this.size + this.head)] = obj;
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.size + this.head));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void copyCollectionElements(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = collection.size() + this.size;
    }

    public final void ensureCapacity$1(int i) {
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Deque is too big.");
            return;
        }
        Object[] objArr = this.elementData;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            if (i < 10) {
                i = 10;
            }
            this.elementData = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        ArraysKt.copyInto(0, this.head, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.elementData;
        int length2 = objArr3.length;
        int i3 = this.head;
        ArraysKt.copyInto(length2 - i3, 0, i3, objArr3, objArr2);
        this.head = 0;
        this.elementData = objArr2;
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.elementData[this.head];
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1("ArrayDeque is empty.");
        return null;
    }

    public final Object firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.head];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.size;
        if (i >= 0 && i < i2) {
            return this.elementData[positiveMod(this.head + i)];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
        return null;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final int incremented(int i) {
        if (i == this.elementData.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iPositiveMod = positiveMod(this.size + this.head);
        int length = this.head;
        if (length < iPositiveMod) {
            while (length < iPositiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[length])) {
                    i = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (isEmpty() || (length = this.head) < iPositiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (Intrinsics.areEqual(obj, this.elementData[length])) {
                i = this.head;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iPositiveMod; i2++) {
            if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                length = i2 + this.elementData.length;
                i = this.head;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final Object last() {
        if (isEmpty()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("ArrayDeque is empty.");
            return null;
        }
        return this.elementData[positiveMod((getSize() - 1) + this.head)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr;
        int length;
        int i;
        int iPositiveMod = positiveMod(this.size + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            length = iPositiveMod - 1;
            if (i2 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
            return -1;
        }
        if (!isEmpty() && this.head >= iPositiveMod) {
            do {
                iPositiveMod--;
                objArr = this.elementData;
                if (-1 >= iPositiveMod) {
                    length = objArr.length - 1;
                    int i3 = this.head;
                    if (i3 <= length) {
                        while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        i = this.head;
                    }
                }
                return length - i;
            } while (!Intrinsics.areEqual(obj, objArr[iPositiveMod]));
            length = iPositiveMod + this.elementData.length;
            i = this.head;
            return length - i;
        }
        return -1;
    }

    public final Object lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[positiveMod((getSize() - 1) + this.head)];
    }

    public final int negativeMod(int i) {
        return i < 0 ? i + this.elementData.length : i;
    }

    public final void nullifyNonEmpty(int i, int i2) {
        Object[] objArr = this.elementData;
        if (i < i2) {
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Arrays.fill(objArr, i, objArr.length, (Object) null);
            Arrays.fill(this.elementData, 0, i2, (Object) null);
        }
    }

    public final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void registerModification() {
        ((java.util.AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iPositiveMod;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.size + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (true) {
                    objArr = this.elementData;
                    if (i >= iPositiveMod2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    }
                    i++;
                }
                Arrays.fill(objArr, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object removeAt(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
            return null;
        }
        if (i == getSize() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        registerModification();
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        int i3 = this.size >> 1;
        int i4 = this.head;
        if (i < i3) {
            if (iPositiveMod >= i4) {
                ArraysKt.copyInto(i4 + 1, i4, iPositiveMod, objArr, objArr);
            } else {
                ArraysKt.copyInto(1, 0, iPositiveMod, objArr, objArr);
                Object[] objArr2 = this.elementData;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.head;
                ArraysKt.copyInto(i5 + 1, i5, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.elementData;
            int i6 = this.head;
            objArr3[i6] = null;
            this.head = incremented(i6);
        } else {
            int iPositiveMod2 = positiveMod((getSize() - 1) + i4);
            Object[] objArr4 = this.elementData;
            if (iPositiveMod <= iPositiveMod2) {
                ArraysKt.copyInto(iPositiveMod, iPositiveMod + 1, iPositiveMod2 + 1, objArr4, objArr4);
            } else {
                ArraysKt.copyInto(iPositiveMod, iPositiveMod + 1, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.elementData;
                objArr5[objArr5.length - 1] = objArr5[0];
                ArraysKt.copyInto(0, 1, iPositiveMod2 + 1, objArr5, objArr5);
            }
            this.elementData[iPositiveMod2] = null;
        }
        this.size--;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("ArrayDeque is empty.");
            return null;
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i = this.head;
        Object obj = objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("ArrayDeque is empty.");
            return null;
        }
        registerModification();
        int iPositiveMod = positiveMod((getSize() - 1) + this.head);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        objArr[iPositiveMod] = null;
        this.size--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        StringsKt__IndentKt.checkRangeIndexes$kotlin_stdlib(i, i2, this.size);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.size) {
            clear();
            return;
        }
        if (i3 == 1) {
            removeAt(i);
            return;
        }
        registerModification();
        int i4 = this.size - i2;
        int i5 = this.head;
        int i6 = this.head;
        if (i < i4) {
            int iPositiveMod = positiveMod((i - 1) + i5);
            int iPositiveMod2 = positiveMod((i2 - 1) + i6);
            while (i > 0) {
                int i7 = iPositiveMod + 1;
                int iMin = Math.min(i, Math.min(i7, iPositiveMod2 + 1));
                Object[] objArr = this.elementData;
                int i8 = iPositiveMod2 - iMin;
                int i9 = iPositiveMod - iMin;
                ArraysKt.copyInto(i8 + 1, i9 + 1, i7, objArr, objArr);
                iPositiveMod = negativeMod(i9);
                iPositiveMod2 = negativeMod(i8);
                i -= iMin;
            }
            int iPositiveMod3 = positiveMod(this.head + i3);
            nullifyNonEmpty(this.head, iPositiveMod3);
            this.head = iPositiveMod3;
        } else {
            int iPositiveMod4 = positiveMod(i5 + i2);
            int iPositiveMod5 = positiveMod(i6 + i);
            int i10 = this.size;
            while (true) {
                i10 -= i2;
                if (i10 <= 0) {
                    break;
                }
                Object[] objArr2 = this.elementData;
                i2 = Math.min(i10, Math.min(objArr2.length - iPositiveMod4, objArr2.length - iPositiveMod5));
                Object[] objArr3 = this.elementData;
                int i11 = iPositiveMod4 + i2;
                ArraysKt.copyInto(iPositiveMod5, iPositiveMod4, i11, objArr3, objArr3);
                iPositiveMod4 = positiveMod(i11);
                iPositiveMod5 = positiveMod(iPositiveMod5 + i2);
            }
            int iPositiveMod6 = positiveMod(this.size + this.head);
            nullifyNonEmpty(negativeMod(iPositiveMod6 - i3), iPositiveMod6);
        }
        this.size -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iPositiveMod;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.size + this.head);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (true) {
                    objArr = this.elementData;
                    if (i >= iPositiveMod2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(objArr, iPositiveMod, iPositiveMod2, (Object) null);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(iPositiveMod - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m(Fragment$5$$ExternalSyntheticOutline0.m(i, i2, "index: ", ", size: "));
            return null;
        }
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[iPositiveMod];
        objArr[iPositiveMod] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.size;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        int iPositiveMod = positiveMod(this.size + this.head);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            ArraysKt.copyInto$default(i2, iPositiveMod, 2, this.elementData, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(0, this.head, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.elementData;
            ArraysKt.copyInto(objArr3.length - this.head, 0, iPositiveMod, objArr3, objArr);
        }
        int i3 = this.size;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity$1(collection.size() + this.size);
        copyCollectionElements(positiveMod(this.size + this.head), collection);
        return true;
    }
}
