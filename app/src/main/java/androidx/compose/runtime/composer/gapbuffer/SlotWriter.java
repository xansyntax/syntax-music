package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapRememberObserverHolder;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.LifecyclesKt;
import coil3.util.UtilsKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SlotWriter {
    public ArrayList anchors;
    public MutableIntObjectMap calledByMap;
    public boolean closed;
    public int currentGroup;
    public int currentGroupEnd;
    public int currentSlot;
    public int currentSlotEnd;
    public MutableIntObjectMap deferredSlotWrites;
    public final IntStack endStack;
    public int groupGapLen;
    public int groupGapStart;
    public int[] groups;
    public int insertCount;
    public int nodeCount;
    public final IntStack nodeCountStack;
    public int parent;
    public MutableIntList pendingRecalculateMarks;
    public Object[] slots;
    public int slotsGapLen;
    public int slotsGapOwner;
    public int slotsGapStart;
    public HashMap sourceInformationMap;
    public final IntStack startStack;
    public final SlotTable table;

    public SlotWriter(SlotTable slotTable) {
        this.table = slotTable;
        int[] iArr = slotTable.groups;
        this.groups = iArr;
        Object[] objArr = slotTable.slots;
        this.slots = objArr;
        this.anchors = slotTable.anchors;
        this.sourceInformationMap = slotTable.sourceInformationMap;
        this.calledByMap = slotTable.calledByMap;
        int i = slotTable.groupsSize;
        this.groupGapStart = i;
        this.groupGapLen = (iArr.length / 5) - i;
        int i2 = slotTable.slotsSize;
        this.slotsGapStart = i2;
        this.slotsGapLen = objArr.length - i2;
        this.slotsGapOwner = i;
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.currentGroupEnd = i;
        this.parent = -1;
    }

    public static int dataIndexToDataAnchor(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public static void markGroup$default(SlotWriter slotWriter) {
        int i = slotWriter.parent;
        int iGroupIndexToAddress = slotWriter.groupIndexToAddress(i);
        int[] iArr = slotWriter.groups;
        int i2 = (iGroupIndexToAddress * 5) + 1;
        int i3 = iArr[i2];
        if ((i3 & 134217728) != 0) {
            return;
        }
        int i4 = (i3 & (-134217729)) | 134217728;
        iArr[i2] = i4;
        if ((67108864 & i4) != 0) {
            return;
        }
        slotWriter.updateContainsMark(slotWriter.parent(i, iArr));
    }

    public final void advanceBy(int i) {
        if (i < 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }
        if (this.insertCount > 0) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.currentGroup + i;
        int i3 = this.parent;
        if (i2 < i3 || i2 > this.currentGroupEnd) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + i3 + "-" + this.currentGroupEnd + ")");
        }
        this.currentGroup = i2;
        int iDataIndex = dataIndex(groupIndexToAddress(i2), this.groups);
        this.currentSlot = iDataIndex;
        this.currentSlotEnd = iDataIndex;
    }

    public final GapAnchor anchor(int i) {
        ArrayList arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, i, getSize$runtime());
        if (iSearch >= 0) {
            return (GapAnchor) arrayList.get(iSearch);
        }
        if (i > this.groupGapStart) {
            i = -(getSize$runtime() - i);
        }
        GapAnchor gapAnchor = new GapAnchor(i);
        arrayList.add(-(iSearch + 1), gapAnchor);
        return gapAnchor;
    }

    public final int anchorIndex(GapAnchor gapAnchor) {
        int i = gapAnchor.location;
        return i < 0 ? getSize$runtime() + i : i;
    }

    public final void beginInsert() {
        int i = this.insertCount;
        this.insertCount = i + 1;
        if (i == 0) {
            this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
        }
    }

    public final void close(boolean z) {
        this.closed = true;
        if (z && this.startStack.tos == 0) {
            moveGroupGapTo(getSize$runtime());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            int i = this.slotsGapStart;
            Arrays.fill(this.slots, i, this.slotsGapLen + i, (Object) null);
            recalculateMarks();
        }
        int[] iArr = this.groups;
        int i2 = this.groupGapStart;
        Object[] objArr = this.slots;
        int i3 = this.slotsGapStart;
        ArrayList arrayList = this.anchors;
        HashMap map = this.sourceInformationMap;
        MutableIntObjectMap mutableIntObjectMap = this.calledByMap;
        SlotTable slotTable = this.table;
        if (!slotTable.writer) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        slotTable.writer = false;
        slotTable.groups = iArr;
        slotTable.groupsSize = i2;
        slotTable.slots = objArr;
        slotTable.slotsSize = i3;
        slotTable.anchors = arrayList;
        slotTable.sourceInformationMap = map;
        slotTable.calledByMap = mutableIntObjectMap;
    }

    public final int dataIndex(int i, int[] iArr) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        int i2 = iArr[(i * 5) + 4];
        return i2 < 0 ? (this.slots.length - this.slotsGapLen) + i2 + 1 : i2;
    }

    public final int dataIndexToDataAddress(int i) {
        return (this.slotsGapLen * (i < this.slotsGapStart ? 0 : 1)) + i;
    }

    public final void endGroup() {
        MutableObjectList mutableObjectList;
        boolean z = this.insertCount > 0;
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int i3 = this.parent;
        int iGroupIndexToAddress = groupIndexToAddress(i3);
        int i4 = this.nodeCount;
        int i5 = i - i3;
        int i6 = iGroupIndexToAddress * 5;
        int i7 = i6 + 1;
        boolean z2 = (this.groups[i7] & 1073741824) != 0;
        IntStack intStack = this.nodeCountStack;
        if (z) {
            MutableIntObjectMap mutableIntObjectMap = this.deferredSlotWrites;
            if (mutableIntObjectMap != null && (mutableObjectList = (MutableObjectList) mutableIntObjectMap.get(i3)) != null) {
                Object[] objArr = mutableObjectList.content;
                int i8 = mutableObjectList._size;
                for (int i9 = 0; i9 < i8; i9++) {
                    rawUpdate(objArr[i9]);
                }
            }
            int[] iArr = this.groups;
            iArr[i6 + 3] = i5;
            SlotTableKt.updateNodeCount(iGroupIndexToAddress, i4, iArr);
            int iPop = intStack.pop();
            if (z2) {
                i4 = 1;
            }
            this.nodeCount = iPop + i4;
            int iParent = parent(i3, this.groups);
            this.parent = iParent;
            int size$runtime = iParent < 0 ? getSize$runtime() : groupIndexToAddress(iParent + 1);
            int iDataIndex = size$runtime >= 0 ? dataIndex(size$runtime, this.groups) : 0;
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            return;
        }
        if (i != i2) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }
        int[] iArr2 = this.groups;
        int i10 = i6 + 3;
        int i11 = iArr2[i10];
        int i12 = iArr2[i7] & 67108863;
        iArr2[i10] = i5;
        SlotTableKt.updateNodeCount(iGroupIndexToAddress, i4, iArr2);
        int iPop2 = this.startStack.pop();
        this.currentGroupEnd = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.parent = iPop2;
        int iParent2 = parent(i3, this.groups);
        int iPop3 = intStack.pop();
        this.nodeCount = iPop3;
        if (iParent2 == iPop2) {
            this.nodeCount = iPop3 + (z2 ? 0 : i4 - i12);
            return;
        }
        int i13 = i5 - i11;
        int i14 = z2 ? 0 : i4 - i12;
        if (i13 != 0 || i14 != 0) {
            while (iParent2 != 0 && iParent2 != iPop2 && (i14 != 0 || i13 != 0)) {
                int iGroupIndexToAddress2 = groupIndexToAddress(iParent2);
                if (i13 != 0) {
                    int[] iArr3 = this.groups;
                    int i15 = (iGroupIndexToAddress2 * 5) + 3;
                    iArr3[i15] = iArr3[i15] + i13;
                }
                if (i14 != 0) {
                    int[] iArr4 = this.groups;
                    SlotTableKt.updateNodeCount(iGroupIndexToAddress2, (iArr4[(iGroupIndexToAddress2 * 5) + 1] & 67108863) + i14, iArr4);
                }
                int[] iArr5 = this.groups;
                if ((iArr5[(iGroupIndexToAddress2 * 5) + 1] & 1073741824) != 0) {
                    i14 = 0;
                }
                iParent2 = parent(iParent2, iArr5);
            }
        }
        this.nodeCount += i14;
    }

    public final void endInsert() {
        if (this.insertCount <= 0) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }
        int i = this.insertCount - 1;
        this.insertCount = i;
        if (i == 0) {
            if (this.nodeCountStack.tos != this.startStack.tos) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }
            this.currentGroupEnd = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        }
    }

    public final void ensureStarted(int i) {
        boolean z = false;
        if (!(this.insertCount <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }
        int i2 = this.parent;
        if (i2 != i) {
            if (i >= i2 && i < this.currentGroupEnd) {
                z = true;
            }
            if (!z) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + i + " must be a subgroup of the group at " + i2);
            }
            int i3 = this.currentGroup;
            int i4 = this.currentSlot;
            int i5 = this.currentSlotEnd;
            this.currentGroup = i;
            startGroup();
            this.currentGroup = i3;
            this.currentSlot = i4;
            this.currentSlotEnd = i5;
        }
    }

    public final void fixParentAnchorsFor(int i, int i2, int i3) {
        if (i >= this.groupGapStart) {
            i = -((getSize$runtime() - i) + 2);
        }
        while (i3 < i2) {
            this.groups[(groupIndexToAddress(i3) * 5) + 2] = i;
            int i4 = this.groups[(groupIndexToAddress(i3) * 5) + 3] + i3;
            fixParentAnchorsFor(i3, i4, i3 + 1);
            i3 = i4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0098  */
    public final void forAllDataInRememberOrder(int i, Function2 function2) {
        int i2;
        int i3;
        int i4;
        int iParent = parent(i, this.groups);
        int size$runtime = getSize$runtime();
        int iGroupSize = groupSize(i) + i;
        int i5 = i;
        MutableIntSet mutableIntSet = null;
        MutableIntList mutableIntList = null;
        while (i5 < iGroupSize) {
            int iDataIndex = dataIndex(groupIndexToAddress(i5), this.groups);
            int i6 = i5 + 1;
            int iDataIndex2 = dataIndex(groupIndexToAddress(i6), this.groups);
            while (iDataIndex < iDataIndex2) {
                Object obj = this.slots[dataIndexToDataAddress(iDataIndex)];
                if (obj instanceof RememberObserverHolder) {
                    RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                    GapRememberObserverHolder gapRememberObserverHolder = rememberObserverHolder instanceof GapRememberObserverHolder ? (GapRememberObserverHolder) rememberObserverHolder : null;
                    if (gapRememberObserverHolder == null) {
                        ComposerKt.composeRuntimeError("Inconsistent composition");
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
                        return;
                    }
                    int i7 = gapRememberObserverHolder.afterGroupIndex;
                    if (i7 >= 0) {
                        int iGroupSize2 = groupSize(i5) + i5;
                        int i8 = i6;
                        int i9 = 0;
                        while (i8 < iGroupSize2 && i9 < i7) {
                            int iGroupIndexToAddress = groupIndexToAddress(i8);
                            int i10 = iParent;
                            int[] iArr = this.groups;
                            int i11 = iGroupIndexToAddress * 5;
                            i8 = iArr[i11 + 3] + i8;
                            if (i8 < iGroupSize2 && (iArr[i11 + 1] & 536870912) == 0) {
                                i9++;
                            }
                            iParent = i10;
                        }
                        i4 = iParent;
                        if (mutableIntSet == null) {
                            int[] iArr2 = IntSetKt.EmptyIntArray;
                            mutableIntSet = new MutableIntSet();
                        }
                        if (mutableIntList == null) {
                            mutableIntList = new MutableIntList();
                        }
                        mutableIntSet.add(i8);
                        mutableIntList.add(i8);
                        mutableIntList.add(iDataIndex);
                    } else {
                        i4 = iParent;
                        function2.invoke(Integer.valueOf(iDataIndex), obj);
                    }
                } else {
                    i4 = iParent;
                    function2.invoke(Integer.valueOf(iDataIndex), obj);
                }
                iDataIndex++;
                iParent = i4;
            }
            int i12 = iParent;
            iParent = i6 < size$runtime ? parent(i6, this.groups) : -1;
            if (iParent != i5) {
                int iParent2 = i12;
                while (true) {
                    if (mutableIntList == null || mutableIntSet == null || !mutableIntSet.remove(i5)) {
                        i2 = size$runtime;
                    } else {
                        int i13 = mutableIntList._size;
                        int i14 = i13 / 2;
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < i14) {
                            int i17 = i15 * 2;
                            int i18 = size$runtime;
                            int i19 = mutableIntList.get(i17);
                            if (i19 == i5) {
                                int i20 = mutableIntList.get(i17 + 1);
                                function2.invoke(Integer.valueOf(i20), this.slots[dataIndexToDataAddress(i20)]);
                            } else if (i17 != i16) {
                                int i21 = i16 + 1;
                                mutableIntList.set(i16, i19);
                                i16 += 2;
                                mutableIntList.set(i21, mutableIntList.get(i17 + 1));
                            } else {
                                i16 += 2;
                            }
                            i15++;
                            function2 = function2;
                            size$runtime = i18;
                        }
                        i2 = size$runtime;
                        if (i16 != i13) {
                            if (i16 < 0 || i16 > (i3 = mutableIntList._size) || i13 < 0 || i13 > i3) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
                                return;
                            }
                            if (i13 < i16) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The end index must be < start index");
                                return;
                            } else if (i13 != i16) {
                                if (i13 < i3) {
                                    int[] iArr3 = mutableIntList.content;
                                    ArraysKt.copyInto(i16, i13, i3, iArr3, iArr3);
                                }
                                mutableIntList._size -= i13 - i16;
                            }
                        }
                    }
                    if (i5 == i || iParent2 == iParent) {
                        break;
                    }
                    i5 = iParent2;
                    size$runtime = i2;
                    iParent2 = parent(iParent2, this.groups);
                    function2 = function2;
                }
            } else {
                i2 = size$runtime;
            }
            i5 = i6;
            size$runtime = i2;
        }
    }

    public final int getCapacity() {
        return this.groups.length / 5;
    }

    public final int getSize$runtime() {
        return getCapacity() - this.groupGapLen;
    }

    public final Object groupAux(int i) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        int i2 = (iGroupIndexToAddress * 5) + 1;
        if ((iArr[i2] & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) == 0) {
            return Composer.Companion.Empty;
        }
        return this.slots[Integer.bitCount(iArr[i2] >> 29) + dataIndex(iGroupIndexToAddress, iArr)];
    }

    public final int groupIndexToAddress(int i) {
        return (this.groupGapLen * (i < this.groupGapStart ? 0 : 1)) + i;
    }

    public final int groupKey(int i) {
        return this.groups[groupIndexToAddress(i) * 5];
    }

    public final Object groupObjectKey(int i) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        int i2 = iGroupIndexToAddress * 5;
        int i3 = iArr[i2 + 1];
        if ((536870912 & i3) == 0) {
            return null;
        }
        return this.slots[Integer.bitCount(i3 >> 30) + iArr[i2 + 4]];
    }

    public final int groupSize(int i) {
        return this.groups[(groupIndexToAddress(i) * 5) + 3];
    }

    public final boolean indexInGroup(int i, int i2) {
        int capacity;
        int iGroupSize;
        if (i2 == this.parent) {
            capacity = this.currentGroupEnd;
        } else {
            IntStack intStack = this.startStack;
            if (i2 > intStack.peekOr(0)) {
                iGroupSize = groupSize(i2);
            } else {
                int[] iArr = intStack.slots;
                int iMin = Math.min(iArr.length, intStack.tos);
                int i3 = 0;
                while (true) {
                    if (i3 >= iMin) {
                        i3 = -1;
                        break;
                    }
                    if (iArr[i3] == i2) {
                        break;
                    }
                    i3++;
                }
                if (i3 < 0) {
                    iGroupSize = groupSize(i2);
                } else {
                    capacity = (getCapacity() - this.groupGapLen) - this.endStack.slots[i3];
                }
            }
            capacity = iGroupSize + i2;
        }
        return i > i2 && i < capacity;
    }

    public final void insertGroups(int i) {
        if (i > 0) {
            int i2 = this.currentGroup;
            moveGroupGapTo(i2);
            int i3 = this.groupGapStart;
            int i4 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i5 = length - i4;
            if (i4 < i) {
                int iMax = Math.max(Math.max(length * 2, i5 + i), 32);
                int[] iArr2 = new int[iMax * 5];
                int i6 = iMax - i5;
                ArraysKt.copyInto(0, 0, i3 * 5, iArr, iArr2);
                ArraysKt.copyInto((i3 + i6) * 5, (i4 + i3) * 5, length * 5, iArr, iArr2);
                this.groups = iArr2;
                i4 = i6;
                iArr = iArr2;
            }
            int i7 = this.currentGroupEnd;
            if (i7 >= i3) {
                this.currentGroupEnd = i7 + i;
            }
            int i8 = i3 + i;
            this.groupGapStart = i8;
            this.groupGapLen = i4 - i;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(i5 > 0 ? dataIndex(groupIndexToAddress(i2 + i), iArr) : 0, this.slotsGapOwner >= i3 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i9 = i3; i9 < i8; i9++) {
                this.groups[(i9 * 5) + 4] = iDataIndexToDataAnchor;
            }
            int i10 = this.slotsGapOwner;
            if (i10 >= i3) {
                this.slotsGapOwner = i10 + i;
            }
        }
    }

    public final void insertSlots(int i, int i2) {
        if (i > 0) {
            moveSlotGapTo(this.currentSlot, i2);
            int i3 = this.slotsGapStart;
            int i4 = this.slotsGapLen;
            if (i4 < i) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i5 = length - i4;
                int iMax = Math.max(Math.max(length * 2, i5 + i), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i6 = 0; i6 < iMax; i6++) {
                    objArr2[i6] = null;
                }
                int i7 = iMax - i5;
                int i8 = i4 + i3;
                System.arraycopy(objArr, 0, objArr2, 0, i3);
                System.arraycopy(objArr, i8, objArr2, i3 + i7, length - i8);
                this.slots = objArr2;
                i4 = i7;
            }
            int i9 = this.currentSlotEnd;
            if (i9 >= i3) {
                this.currentSlotEnd = i9 + i;
            }
            this.slotsGapStart = i3 + i;
            this.slotsGapLen = i4 - i;
        }
    }

    public final boolean isNode(int i) {
        return (this.groups[(groupIndexToAddress(i) * 5) + 1] & 1073741824) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void moveFrom(SlotTable slotTable, int i) {
        if (this.insertCount <= 0) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        boolean z = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (i == 0 && this.currentGroup == 0 && this.table.groupsSize == 0) {
            int[] iArr = slotTable.groups;
            int i2 = iArr[(i * 5) + 3];
            int i3 = slotTable.groupsSize;
            if (i2 == i3) {
                int[] iArr2 = this.groups;
                Object[] objArr3 = this.slots;
                ArrayList arrayList = this.anchors;
                HashMap map = this.sourceInformationMap;
                MutableIntObjectMap mutableIntObjectMap = this.calledByMap;
                Object[] objArr4 = slotTable.slots;
                int i4 = slotTable.slotsSize;
                HashMap map2 = slotTable.sourceInformationMap;
                MutableIntObjectMap mutableIntObjectMap2 = slotTable.calledByMap;
                this.groups = iArr;
                this.slots = objArr4;
                this.anchors = slotTable.anchors;
                this.groupGapStart = i3;
                this.groupGapLen = (iArr.length / 5) - i3;
                this.slotsGapStart = i4;
                this.slotsGapLen = objArr4.length - i4;
                this.slotsGapOwner = i3;
                this.sourceInformationMap = map2;
                this.calledByMap = mutableIntObjectMap2;
                slotTable.groups = iArr2;
                slotTable.groupsSize = objArr2 == true ? 1 : 0;
                slotTable.slots = objArr3;
                slotTable.slotsSize = objArr == true ? 1 : 0;
                slotTable.anchors = arrayList;
                slotTable.sourceInformationMap = map;
                slotTable.calledByMap = mutableIntObjectMap;
                return;
            }
        }
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        try {
            UtilsKt.moveGroup(slotWriterOpenWriter, i, this, true, true, false);
            boolean z2 = true;
        } finally {
            slotWriterOpenWriter.close(z);
        }
    }

    public final void moveGroupGapTo(int i) {
        GapAnchor gapAnchor;
        int i2;
        GapAnchor gapAnchor2;
        int i3;
        int i4;
        int i5 = this.groupGapLen;
        int i6 = this.groupGapStart;
        if (i6 != i) {
            if (!this.anchors.isEmpty()) {
                int capacity = getCapacity() - this.groupGapLen;
                ArrayList arrayList = this.anchors;
                if (i6 < i) {
                    for (int iLocationOf = SlotTableKt.locationOf(arrayList, i6, capacity); iLocationOf < this.anchors.size() && (i3 = (gapAnchor2 = (GapAnchor) this.anchors.get(iLocationOf)).location) < 0 && (i4 = i3 + capacity) < i; iLocationOf++) {
                        gapAnchor2.location = i4;
                    }
                } else {
                    for (int iLocationOf2 = SlotTableKt.locationOf(arrayList, i, capacity); iLocationOf2 < this.anchors.size() && (i2 = (gapAnchor = (GapAnchor) this.anchors.get(iLocationOf2)).location) >= 0; iLocationOf2++) {
                        gapAnchor.location = -(capacity - i2);
                    }
                }
            }
            if (i5 > 0) {
                int[] iArr = this.groups;
                int i7 = i * 5;
                int i8 = i5 * 5;
                int i9 = i6 * 5;
                if (i < i6) {
                    ArraysKt.copyInto(i8 + i7, i7, i9, iArr, iArr);
                } else {
                    ArraysKt.copyInto(i9, i9 + i8, i7 + i8, iArr, iArr);
                }
            }
            if (i < i6) {
                i6 = i + i5;
            }
            int capacity2 = getCapacity();
            if (i6 >= capacity2) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }
            while (i6 < capacity2) {
                int i10 = (i6 * 5) + 2;
                int i11 = this.groups[i10];
                int size$runtime = i11 > -2 ? i11 : (getSize$runtime() + i11) - (-2);
                if (size$runtime >= i) {
                    size$runtime = -((getSize$runtime() - size$runtime) - (-2));
                }
                if (size$runtime != i11) {
                    this.groups[i10] = size$runtime;
                }
                i6++;
                if (i6 == i) {
                    i6 += i5;
                }
            }
        }
        this.groupGapStart = i;
    }

    public final void moveSlotGapTo(int i, int i2) {
        int i3 = this.slotsGapLen;
        int i4 = this.slotsGapStart;
        int i5 = this.slotsGapOwner;
        if (i4 != i) {
            Object[] objArr = this.slots;
            if (i < i4) {
                System.arraycopy(objArr, i, objArr, i + i3, i4 - i);
            } else {
                int i6 = i4 + i3;
                System.arraycopy(objArr, i6, objArr, i4, (i + i3) - i6);
            }
        }
        int iMin = Math.min(i2 + 1, getSize$runtime());
        if (i5 != iMin) {
            int length = this.slots.length - i3;
            if (iMin < i5) {
                int iGroupIndexToAddress = groupIndexToAddress(iMin);
                int iGroupIndexToAddress2 = groupIndexToAddress(i5);
                int i7 = this.groupGapStart;
                while (iGroupIndexToAddress < iGroupIndexToAddress2) {
                    int i8 = (iGroupIndexToAddress * 5) + 4;
                    int i9 = this.groups[i8];
                    if (i9 < 0) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }
                    this.groups[i8] = -((length - i9) + 1);
                    iGroupIndexToAddress++;
                    if (iGroupIndexToAddress == i7) {
                        iGroupIndexToAddress += this.groupGapLen;
                    }
                }
            } else {
                int iGroupIndexToAddress3 = groupIndexToAddress(i5);
                int iGroupIndexToAddress4 = groupIndexToAddress(iMin);
                while (iGroupIndexToAddress3 < iGroupIndexToAddress4) {
                    int i10 = (iGroupIndexToAddress3 * 5) + 4;
                    int i11 = this.groups[i10];
                    if (i11 >= 0) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }
                    this.groups[i10] = i11 + length + 1;
                    iGroupIndexToAddress3++;
                    if (iGroupIndexToAddress3 == this.groupGapStart) {
                        iGroupIndexToAddress3 += this.groupGapLen;
                    }
                }
            }
            this.slotsGapOwner = iMin;
        }
        this.slotsGapStart = i;
    }

    public final Object node(int i) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if ((iArr[(iGroupIndexToAddress * 5) + 1] & 1073741824) != 0) {
            return this.slots[dataIndexToDataAddress(dataIndex(iGroupIndexToAddress, iArr))];
        }
        return null;
    }

    public final int parent(int i, int[] iArr) {
        int i2 = iArr[(groupIndexToAddress(i) * 5) + 2];
        return i2 > -2 ? i2 : (getSize$runtime() + i2) - (-2);
    }

    public final Object rawUpdate(Object obj) {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i = this.currentSlot;
        this.currentSlot = i + 1;
        Object obj2 = objArr[dataIndexToDataAddress(i)];
        if (this.currentSlot > this.currentSlotEnd) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }
        this.slots[dataIndexToDataAddress(this.currentSlot - 1)] = obj;
        return obj2;
    }

    public final void recalculateMarks() {
        int i;
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (mutableIntList._size != 0) {
                int iM888takeMaximpl = LifecyclesKt.m888takeMaximpl(mutableIntList);
                int iGroupIndexToAddress = groupIndexToAddress(iM888takeMaximpl);
                int iGroupSize = iM888takeMaximpl + 1;
                int iGroupSize2 = groupSize(iM888takeMaximpl) + iM888takeMaximpl;
                while (true) {
                    if (iGroupSize >= iGroupSize2) {
                        i = 0;
                        break;
                    } else {
                        if ((this.groups[(groupIndexToAddress(iGroupSize) * 5) + 1] & 201326592) != 0) {
                            i = 1;
                            break;
                        }
                        iGroupSize += groupSize(iGroupSize);
                    }
                }
                int[] iArr = this.groups;
                int i2 = (iGroupIndexToAddress * 5) + 1;
                int i3 = iArr[i2];
                if (((67108864 & i3) != 0 ? 1 : 0) != i) {
                    iArr[i2] = (i << 26) | ((-67108865) & i3);
                    int iParent = parent(iM888takeMaximpl, iArr);
                    if (iParent >= 0) {
                        LifecyclesKt.m884addimpl(mutableIntList, iParent);
                    }
                }
            }
        }
    }

    public final boolean removeGroup() {
        if (this.insertCount != 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }
        int i = this.currentGroup;
        int i2 = this.currentSlot;
        int iDataIndex = dataIndex(groupIndexToAddress(i), this.groups);
        int iSkipGroup = skipGroup();
        sourceInformationOf$runtime(this.parent);
        MutableIntList mutableIntList = this.pendingRecalculateMarks;
        if (mutableIntList != null) {
            while (true) {
                int i3 = mutableIntList._size;
                if (i3 == 0) {
                    break;
                }
                if (i3 == 0) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1("IntList is empty.");
                    return false;
                }
                if (mutableIntList.content[0] < i) {
                    break;
                }
                LifecyclesKt.m888takeMaximpl(mutableIntList);
            }
        }
        boolean zRemoveGroups = removeGroups(i, this.currentGroup - i);
        removeSlots(iDataIndex, this.currentSlot - iDataIndex, i - 1);
        this.currentGroup = i;
        this.currentSlot = i2;
        this.nodeCount -= iSkipGroup;
        return zRemoveGroups;
    }

    public final boolean removeGroups(int i, int i2) {
        boolean z = false;
        if (i2 > 0) {
            ArrayList arrayList = this.anchors;
            moveGroupGapTo(i);
            if (!arrayList.isEmpty()) {
                HashMap map = this.sourceInformationMap;
                int i3 = i + i2;
                int iLocationOf = SlotTableKt.locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
                if (iLocationOf >= this.anchors.size()) {
                    iLocationOf--;
                }
                int i4 = iLocationOf + 1;
                int i5 = 0;
                while (iLocationOf >= 0) {
                    GapAnchor gapAnchor = (GapAnchor) this.anchors.get(iLocationOf);
                    int iAnchorIndex = anchorIndex(gapAnchor);
                    if (iAnchorIndex < i) {
                        break;
                    }
                    if (iAnchorIndex < i3) {
                        gapAnchor.location = Integer.MIN_VALUE;
                        if (map != null) {
                        }
                        if (i5 == 0) {
                            i5 = iLocationOf + 1;
                        }
                        i4 = iLocationOf;
                    }
                    iLocationOf--;
                }
                z = i4 < i5;
                if (z) {
                    this.anchors.subList(i4, i5).clear();
                }
            }
            this.groupGapStart = i;
            this.groupGapLen += i2;
            int i6 = this.slotsGapOwner;
            if (i6 > i) {
                this.slotsGapOwner = Math.max(i, i6 - i2);
            }
            int i7 = this.currentGroupEnd;
            if (i7 >= this.groupGapStart) {
                this.currentGroupEnd = i7 - i2;
            }
            int i8 = this.parent;
            if (i8 >= 0 && (this.groups[(groupIndexToAddress(i8) * 5) + 1] & 67108864) != 0) {
                updateContainsMark(i8);
            }
        }
        return z;
    }

    public final void removeSlots(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.slotsGapLen;
            int i5 = i + i2;
            moveSlotGapTo(i5, i3);
            this.slotsGapStart = i;
            this.slotsGapLen = i4 + i2;
            Arrays.fill(this.slots, i, i5, (Object) null);
            int i6 = this.currentSlotEnd;
            if (i6 >= i) {
                this.currentSlotEnd = i6 - i2;
            }
        }
    }

    public final Object set(int i, int i2, Object obj) {
        int iSlotIndex = slotIndex(groupIndexToAddress(i), this.groups);
        int iDataIndex = dataIndex(groupIndexToAddress(i + 1), this.groups);
        int i3 = iSlotIndex + i2;
        if (i3 < iSlotIndex || i3 >= iDataIndex) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + i2 + " for group " + i);
        }
        int iDataIndexToDataAddress = dataIndexToDataAddress(i3);
        Object[] objArr = this.slots;
        Object obj2 = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = obj;
        return obj2;
    }

    public final int skipGroup() {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int i = this.currentGroup;
        int[] iArr = this.groups;
        int i2 = iGroupIndexToAddress * 5;
        int i3 = iArr[i2 + 3] + i;
        this.currentGroup = i3;
        this.currentSlot = dataIndex(groupIndexToAddress(i3), iArr);
        int i4 = this.groups[i2 + 1];
        if ((1073741824 & i4) != 0) {
            return 1;
        }
        return i4 & 67108863;
    }

    public final void skipToGroupEnd() {
        int i = this.currentGroupEnd;
        this.currentGroup = i;
        this.currentSlot = dataIndex(groupIndexToAddress(i), this.groups);
    }

    public final int slotIndex(int i, int[] iArr) {
        if (i >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        int iSlotAnchor = SlotTableKt.slotAnchor(i, iArr);
        return iSlotAnchor < 0 ? (this.slots.length - this.slotsGapLen) + iSlotAnchor + 1 : iSlotAnchor;
    }

    public final GapGroupSourceInformation sourceInformationOf$runtime(int i) {
        GapAnchor gapAnchorTryAnchor$runtime;
        HashMap map = this.sourceInformationMap;
        if (map == null || (gapAnchorTryAnchor$runtime = tryAnchor$runtime(i)) == null) {
            return null;
        }
        return (GapGroupSourceInformation) map.get(gapAnchorTryAnchor$runtime);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startGroup(int i, Object obj, boolean z, Object obj2) {
        int i2;
        int i3 = this.parent;
        Object[] objArr = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objArr == true) {
            int i4 = this.currentGroup;
            int iDataIndex = dataIndex(groupIndexToAddress(i4), this.groups);
            insertGroups(1);
            this.currentSlot = iDataIndex;
            this.currentSlotEnd = iDataIndex;
            int iGroupIndexToAddress = groupIndexToAddress(i4);
            int i5 = obj != neverEqualPolicy ? 1 : 0;
            int i6 = (z || obj2 == neverEqualPolicy) ? 0 : 1;
            int iDataIndexToDataAnchor = dataIndexToDataAnchor(iDataIndex, this.slotsGapStart, this.slotsGapLen, this.slots.length);
            if (iDataIndexToDataAnchor >= 0 && this.slotsGapOwner < i4) {
                iDataIndexToDataAnchor = -(((this.slots.length - this.slotsGapLen) - iDataIndexToDataAnchor) + 1);
            }
            int[] iArr = this.groups;
            int i7 = this.parent;
            int i8 = iGroupIndexToAddress * 5;
            iArr[i8] = i;
            iArr[i8 + 1] = ((z ? 1 : 0) << 30) | (i5 << 29) | (i6 << 28);
            iArr[i8 + 2] = i7;
            iArr[i8 + 3] = 0;
            iArr[i8 + 4] = iDataIndexToDataAnchor;
            int i9 = (z ? 1 : 0) + i5 + i6;
            if (i9 > 0) {
                insertSlots(i9, i4);
                Object[] objArr2 = this.slots;
                int i10 = this.currentSlot;
                if (z) {
                    objArr2[i10] = obj2;
                    i10++;
                }
                if (i5 != 0) {
                    objArr2[i10] = obj;
                    i10++;
                }
                if (i6 != 0) {
                    objArr2[i10] = obj2;
                    i10++;
                }
                this.currentSlot = i10;
            }
            this.nodeCount = 0;
            i2 = i4 + 1;
            this.parent = i4;
            this.currentGroup = i2;
            if (i3 >= 0) {
                sourceInformationOf$runtime(i3);
            }
        } else {
            this.startStack.push(i3);
            this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
            int i11 = this.currentGroup;
            int iGroupIndexToAddress2 = groupIndexToAddress(i11);
            if (!Intrinsics.areEqual(obj2, neverEqualPolicy)) {
                if (z) {
                    updateNodeOfGroup(this.currentGroup, obj2);
                } else {
                    updateAux(obj2);
                }
            }
            this.currentSlot = slotIndex(iGroupIndexToAddress2, this.groups);
            this.currentSlotEnd = dataIndex(groupIndexToAddress(this.currentGroup + 1), this.groups);
            int[] iArr2 = this.groups;
            int i12 = iGroupIndexToAddress2 * 5;
            this.nodeCount = iArr2[i12 + 1] & 67108863;
            this.parent = i11;
            this.currentGroup = i11 + 1;
            i2 = i11 + iArr2[i12 + 3];
        }
        this.currentGroupEnd = i2;
    }

    public final String toString() {
        int i = this.currentGroup;
        int i2 = this.currentGroupEnd;
        int size$runtime = getSize$runtime();
        int i3 = this.groupGapStart;
        int i4 = this.groupGapLen + i3;
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(i, "SlotWriter(current = ", " end=", i2, " size = ");
        sbM3m.append(size$runtime);
        sbM3m.append(" gap=");
        sbM3m.append(i3);
        sbM3m.append("-");
        return Fragment$5$$ExternalSyntheticOutline0.m(sbM3m, i4, ")");
    }

    public final GapAnchor tryAnchor$runtime(int i) {
        ArrayList arrayList;
        int iSearch;
        if (i < 0 || i >= getSize$runtime() || (iSearch = SlotTableKt.search((arrayList = this.anchors), i, getSize$runtime())) < 0) {
            return null;
        }
        return (GapAnchor) arrayList.get(iSearch);
    }

    public final void updateAux(Object obj) {
        int iGroupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int i = (iGroupIndexToAddress * 5) + 1;
        if ((this.groups[i] & WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE) == 0) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }
        Object[] objArr = this.slots;
        int[] iArr = this.groups;
        objArr[dataIndexToDataAddress(Integer.bitCount(iArr[i] >> 29) + dataIndex(iGroupIndexToAddress, iArr))] = obj;
    }

    public final void updateContainsMark(int i) {
        if (i >= 0) {
            MutableIntList mutableIntList = this.pendingRecalculateMarks;
            if (mutableIntList == null) {
                mutableIntList = new MutableIntList();
                this.pendingRecalculateMarks = mutableIntList;
            }
            LifecyclesKt.m884addimpl(mutableIntList, i);
        }
    }

    public final void updateNodeOfGroup(int i, Object obj) {
        int iGroupIndexToAddress = groupIndexToAddress(i);
        int[] iArr = this.groups;
        if (iGroupIndexToAddress >= iArr.length || (iArr[(iGroupIndexToAddress * 5) + 1] & 1073741824) == 0) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + i + " that was not created with as a node group");
        }
        this.slots[dataIndexToDataAddress(dataIndex(iGroupIndexToAddress, this.groups))] = obj;
    }

    public final void startGroup() {
        if (this.insertCount != 0) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        startGroup(0, neverEqualPolicy, false, neverEqualPolicy);
    }
}
