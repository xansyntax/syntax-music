package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.collection.ArraySetKt;
import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.media3.common.util.LongArray;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Node extends NodeParent {
    public NodeCoordinator coordinates;
    public boolean hasExited;
    public boolean isIn;
    public final Modifier.Node modifierNode;
    public PointerEvent pointerEvent;
    public final LongArray pointerIds;
    public final LongSparseArray relevantChanges;
    public boolean wasIn;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
        LongArray longArray = new LongArray();
        longArray.values = new long[2];
        this.pointerIds = longArray;
        this.relevantChanges = new LongSparseArray(2);
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX WARN: Code duplicated, block: B:174:0x0336  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v50, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v51 */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v54 */
    /* JADX WARN: Type inference failed for: r5v55 */
    /* JADX WARN: Type inference failed for: r5v56 */
    /* JADX WARN: Type inference failed for: r5v57 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final boolean buildCache(LongSparseArray longSparseArray, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        LongArray longArray;
        LongSparseArray longSparseArray2;
        Object obj;
        boolean z2;
        boolean z3;
        PointerEvent pointerEvent;
        int i;
        boolean z4;
        boolean zBuildCache = super.buildCache(longSparseArray, layoutCoordinates, internalPointerEvent, z);
        ?? Pop = this.modifierNode;
        boolean z5 = true;
        if (Pop.isAttached) {
            ?? mutableVector = 0;
            while (Pop != 0) {
                if (Pop instanceof PointerInputModifierNode) {
                    this.coordinates = HitTestResultKt.m646requireCoordinator64DMado((PointerInputModifierNode) Pop, 16);
                } else if ((Pop.kindSet & 16) != 0 && (Pop instanceof DelegatingNode)) {
                    Modifier.Node node = ((DelegatingNode) Pop).delegate;
                    int i2 = 0;
                    while (node != null) {
                        if ((node.kindSet & 16) != 0) {
                            i2++;
                            if (i2 == 1) {
                                Pop = Pop;
                                mutableVector = mutableVector;
                                mutableVector = mutableVector;
                                Pop = node;
                            } else {
                                if (mutableVector == 0) {
                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                }
                                if (Pop != 0) {
                                    mutableVector.add(Pop);
                                    Pop = 0;
                                }
                                mutableVector.add(node);
                            }
                        } else {
                            Pop = Pop;
                            mutableVector = mutableVector;
                        }
                        node = node.child;
                        Pop = Pop;
                        mutableVector = mutableVector;
                    }
                    if (i2 == 1) {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    } else {
                        Pop = Pop;
                        mutableVector = mutableVector;
                    }
                }
                Pop = HitTestResultKt.pop(mutableVector);
            }
            if (this.coordinates != null) {
                int size = longSparseArray.size();
                int i3 = 0;
                while (true) {
                    longArray = this.pointerIds;
                    longSparseArray2 = this.relevantChanges;
                    if (i3 >= size) {
                        break;
                    }
                    long jKeyAt = longSparseArray.keyAt(i3);
                    PointerInputChange pointerInputChange = (PointerInputChange) longSparseArray.valueAt(i3);
                    if (longArray.contains(jKeyAt)) {
                        boolean z6 = z5;
                        long j = pointerInputChange.previousPosition;
                        long j2 = pointerInputChange.position;
                        if ((((j & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0 && (((j2 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                            z4 = z6;
                            ArrayList arrayList = new ArrayList(pointerInputChange.getHistorical().size());
                            List historical = pointerInputChange.getHistorical();
                            int size2 = historical.size();
                            int i4 = 0;
                            while (i4 < size2) {
                                List list = historical;
                                HistoricalChange historicalChange = (HistoricalChange) historical.get(i4);
                                LongSparseArray longSparseArray3 = longSparseArray2;
                                long j3 = jKeyAt;
                                long j4 = historicalChange.position;
                                if ((((j4 & 9223372034707292159L) + 36028792732385279L) & (-9223372034707292160L)) == 0) {
                                    long j5 = historicalChange.uptimeMillis;
                                    NodeCoordinator nodeCoordinator = this.coordinates;
                                    nodeCoordinator.getClass();
                                    arrayList.add(new HistoricalChange(j5, nodeCoordinator.mo605localPositionOfS_NoaFU(layoutCoordinates, j4), historicalChange.scaleFactor, historicalChange.panOffset, historicalChange.originalEventPosition));
                                }
                                i4++;
                                size2 = size2;
                                historical = list;
                                longSparseArray2 = longSparseArray3;
                                jKeyAt = j3;
                                pointerInputChange = pointerInputChange;
                            }
                            LongSparseArray longSparseArray4 = longSparseArray2;
                            long j6 = jKeyAt;
                            NodeCoordinator nodeCoordinator2 = this.coordinates;
                            nodeCoordinator2.getClass();
                            long jMo605localPositionOfS_NoaFU = nodeCoordinator2.mo605localPositionOfS_NoaFU(layoutCoordinates, j);
                            NodeCoordinator nodeCoordinator3 = this.coordinates;
                            nodeCoordinator3.getClass();
                            PointerInputChange pointerInputChange2 = new PointerInputChange(pointerInputChange.id, pointerInputChange.uptimeMillis, nodeCoordinator3.mo605localPositionOfS_NoaFU(layoutCoordinates, j2), pointerInputChange.pressed, pointerInputChange.pressure, pointerInputChange.previousUptimeMillis, jMo605localPositionOfS_NoaFU, pointerInputChange.previousPressed, pointerInputChange.type, arrayList, pointerInputChange.scrollDelta, pointerInputChange.scaleFactor, pointerInputChange.panOffset, pointerInputChange.originalEventPosition);
                            PointerInputChange pointerInputChange3 = pointerInputChange.consumedDelegate;
                            if (pointerInputChange3 == null) {
                                pointerInputChange3 = pointerInputChange;
                            }
                            pointerInputChange2.consumedDelegate = pointerInputChange3;
                            PointerInputChange pointerInputChange4 = pointerInputChange.consumedDelegate;
                            if (pointerInputChange4 != null) {
                                pointerInputChange = pointerInputChange4;
                            }
                            pointerInputChange2.consumedDelegate = pointerInputChange;
                            longSparseArray4.put(j6, pointerInputChange2);
                        } else {
                            z4 = z6;
                        }
                    } else {
                        z4 = z5;
                    }
                    i3++;
                    z5 = z4;
                    size = size;
                    zBuildCache = zBuildCache;
                }
                boolean z7 = zBuildCache;
                boolean z8 = z5;
                if (longSparseArray2.size() == 0) {
                    longArray.size = 0;
                    this.children.clear();
                    return z8;
                }
                int i5 = longArray.size;
                while (true) {
                    i5--;
                    if (-1 >= i5) {
                        break;
                    }
                    long j7 = longArray.values[i5];
                    if (longSparseArray.garbage) {
                        int i6 = longSparseArray.size;
                        long[] jArr = longSparseArray.keys;
                        Object[] objArr = longSparseArray.values;
                        int i7 = 0;
                        for (int i8 = 0; i8 < i6; i8++) {
                            Object obj2 = objArr[i8];
                            if (obj2 != ArraySetKt.DELETED) {
                                if (i8 != i7) {
                                    jArr[i7] = jArr[i8];
                                    objArr[i7] = obj2;
                                    objArr[i8] = null;
                                }
                                i7++;
                            }
                        }
                        longSparseArray.garbage = false;
                        longSparseArray.size = i7;
                    }
                    if (ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j7) < 0 && i5 < (i = longArray.size)) {
                        int i9 = i - 1;
                        int i10 = i5;
                        while (i10 < i9) {
                            long[] jArr2 = longArray.values;
                            int i11 = i10 + 1;
                            jArr2[i10] = jArr2[i11];
                            i10 = i11;
                        }
                        longArray.size--;
                    }
                }
                ArrayList arrayList2 = new ArrayList(longSparseArray2.size());
                int size3 = longSparseArray2.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    arrayList2.add(longSparseArray2.valueAt(i12));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList2, internalPointerEvent);
                int size4 = arrayList2.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size4) {
                        obj = null;
                        break;
                    }
                    obj = arrayList2.get(i13);
                    if (internalPointerEvent.m586activeHoverEvent0FcD4WY(((PointerInputChange) obj).id)) {
                        break;
                    }
                    i13++;
                }
                PointerInputChange pointerInputChange5 = (PointerInputChange) obj;
                if (pointerInputChange5 != null) {
                    boolean z9 = pointerInputChange5.pressed;
                    if (z) {
                        z2 = false;
                        if (!this.isIn && (z9 || pointerInputChange5.previousPressed || internalPointerEvent.getActiveGesture() == PointerClassification.Pan)) {
                            NodeCoordinator nodeCoordinator4 = this.coordinates;
                            nodeCoordinator4.getClass();
                            long j8 = nodeCoordinator4.measuredSize;
                            long j9 = pointerInputChange5.position;
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (j9 >> 32));
                            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j9 & 4294967295L));
                            this.isIn = !((fIntBitsToFloat > ((float) ((int) (j8 >> 32))) ? z8 : false) | (fIntBitsToFloat < CropImageView.DEFAULT_ASPECT_RATIO ? z8 : false) | (fIntBitsToFloat2 < CropImageView.DEFAULT_ASPECT_RATIO ? z8 : false) | (fIntBitsToFloat2 > ((float) ((int) (j8 & 4294967295L))) ? z8 : false));
                        }
                    } else {
                        z2 = false;
                        this.isIn = false;
                    }
                    int i14 = pointerEvent2.type;
                    boolean z10 = (i14 == 10 || i14 == 11 || i14 == 12) ? z8 : z2;
                    boolean z11 = this.isIn;
                    boolean z12 = this.wasIn;
                    if (z11 != z12 && (i14 == 3 || i14 == 4 || i14 == 5 || z10)) {
                        pointerEvent2.type = z11 ? 4 : 5;
                    } else if (i14 == 4 && z12 && !this.hasExited) {
                        pointerEvent2.type = 3;
                    } else if (i14 == 5 && z11 && z9) {
                        pointerEvent2.type = 3;
                    }
                } else {
                    z2 = false;
                }
                if (!z7 && pointerEvent2.type == 3 && (pointerEvent = this.pointerEvent) != null) {
                    ?? r1 = pointerEvent.changes;
                    int size5 = r1.size();
                    ?? r4 = pointerEvent2.changes;
                    if (size5 != r4.size()) {
                        z3 = z8;
                        break;
                    }
                    int size6 = r4.size();
                    ?? r5 = z2;
                    while (true) {
                        if (r5 >= size6) {
                            z3 = z2;
                            break;
                        }
                        if (!Offset.m434equalsimpl0(((PointerInputChange) r1.get(r5)).position, ((PointerInputChange) r4.get(r5)).position)) {
                            z3 = z8;
                            break;
                        }
                        r5++;
                    }
                } else {
                    z3 = z8;
                    break;
                }
                this.pointerEvent = pointerEvent2;
                return z3;
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        MotionEvent motionEvent;
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List list = pointerEvent.changes;
        int size = list.size();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) list.get(i);
            boolean z2 = pointerInputChange.pressed;
            long j = pointerInputChange.id;
            boolean z3 = ((z2 || internalPointerEvent.m586activeHoverEvent0FcD4WY(j)) && (z2 || this.isIn)) ? false : true;
            boolean z4 = internalPointerEvent.getActiveGesture() == PointerClassification.Pan;
            PointerClassification activeGesture = internalPointerEvent.getActiveGesture();
            PointerClassification pointerClassification = PointerClassification.None;
            if (activeGesture == pointerClassification || ((motionEvent = (MotionEvent) internalPointerEvent.pointerInputEvent.mMetadataRepo) != null && internalPointerEvent.getActiveGesture() != pointerClassification && motionEvent.getActionMasked() == 1)) {
                z = false;
            }
            if (z3 && (z4 || !z)) {
                this.pointerIds.remove(j);
            }
            i++;
        }
        this.isIn = false;
        this.hasExited = pointerEvent.type == 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void dispatchCancel() {
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) objArr[i2]).dispatchCancel();
        }
        ?? Pop = this.modifierNode;
        ?? mutableVector2 = 0;
        while (Pop != 0) {
            if (Pop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) Pop).onCancelPointerInput();
            } else if ((Pop.kindSet & 16) != 0 && (Pop instanceof DelegatingNode)) {
                Modifier.Node node = ((DelegatingNode) Pop).delegate;
                int i3 = 0;
                mutableVector2 = mutableVector2;
                Pop = Pop;
                while (node != null) {
                    if ((node.kindSet & 16) != 0) {
                        i3++;
                        if (i3 == 1) {
                            mutableVector2 = mutableVector2;
                            Pop = node;
                        } else {
                            if (mutableVector2 == 0) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16]);
                            }
                            if (Pop != 0) {
                                mutableVector2.add(Pop);
                                Pop = 0;
                            }
                            mutableVector2.add(node);
                        }
                    }
                    node = node.child;
                    mutableVector2 = mutableVector2;
                    Pop = Pop;
                }
                if (i3 == 1) {
                }
            }
            Pop = HitTestResultKt.pop(mutableVector2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        LayoutNode layoutNode;
        LongSparseArray longSparseArray = this.relevantChanges;
        boolean z = false;
        z = false;
        z = false;
        if (longSparseArray.size() != 0) {
            Modifier.Node node = this.modifierNode;
            if (node.isAttached) {
                NodeCoordinator nodeCoordinator = node.coordinator;
                if ((nodeCoordinator == null || (layoutNode = nodeCoordinator.layoutNode) == null) ? false : layoutNode.isPlaced()) {
                    PointerEvent pointerEvent = this.pointerEvent;
                    pointerEvent.getClass();
                    NodeCoordinator nodeCoordinator2 = this.coordinates;
                    nodeCoordinator2.getClass();
                    long j = nodeCoordinator2.measuredSize;
                    ?? Pop = node;
                    ?? mutableVector = 0;
                    while (Pop != 0) {
                        if (Pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) Pop).mo27onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, j);
                        } else if ((Pop.kindSet & 16) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                            int i = 0;
                            while (node2 != null) {
                                if ((node2.kindSet & 16) != 0) {
                                    i++;
                                    if (i == 1) {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                        mutableVector = mutableVector;
                                        Pop = node2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Pop != 0) {
                                            mutableVector.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector.add(node2);
                                    }
                                } else {
                                    Pop = Pop;
                                    mutableVector = mutableVector;
                                }
                                node2 = node2.child;
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                            if (i == 1) {
                                Pop = Pop;
                                mutableVector = mutableVector;
                            } else {
                                Pop = Pop;
                                mutableVector = mutableVector;
                            }
                        }
                        Pop = HitTestResultKt.pop(mutableVector);
                    }
                    if (node.isAttached) {
                        MutableVector mutableVector2 = this.children;
                        Object[] objArr = mutableVector2.content;
                        int i2 = mutableVector2.size;
                        for (int i3 = 0; i3 < i2; i3++) {
                            ((Node) objArr[i3]).dispatchFinalEventPass(internalPointerEvent);
                        }
                    }
                    z = true;
                }
            }
        }
        cleanUpHits(internalPointerEvent);
        longSparseArray.clear();
        this.coordinates = null;
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final boolean dispatchMainEventPass(InternalPointerEvent internalPointerEvent, boolean z) {
        LayoutNode layoutNode;
        if (this.relevantChanges.size() == 0) {
            return false;
        }
        ?? Pop = this.modifierNode;
        if (Pop.isAttached) {
            NodeCoordinator nodeCoordinator = Pop.coordinator;
            if ((nodeCoordinator == null || (layoutNode = nodeCoordinator.layoutNode) == null) ? false : layoutNode.isPlaced()) {
                PointerEvent pointerEvent = this.pointerEvent;
                pointerEvent.getClass();
                NodeCoordinator nodeCoordinator2 = this.coordinates;
                nodeCoordinator2.getClass();
                long j = nodeCoordinator2.measuredSize;
                ?? Pop2 = Pop;
                ?? mutableVector = 0;
                while (Pop2 != 0) {
                    if (Pop2 instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) Pop2).mo27onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, j);
                    } else if ((Pop2.kindSet & 16) != 0 && (Pop2 instanceof DelegatingNode)) {
                        Modifier.Node node = ((DelegatingNode) Pop2).delegate;
                        int i = 0;
                        while (node != null) {
                            if ((node.kindSet & 16) != 0) {
                                i++;
                                if (i == 1) {
                                    Pop2 = Pop2;
                                    mutableVector = mutableVector;
                                    mutableVector = mutableVector;
                                    Pop2 = node;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Pop2 != 0) {
                                        mutableVector.add(Pop2);
                                        Pop2 = 0;
                                    }
                                    mutableVector.add(node);
                                }
                            } else {
                                Pop2 = Pop2;
                                mutableVector = mutableVector;
                            }
                            node = node.child;
                            Pop2 = Pop2;
                            mutableVector = mutableVector;
                        }
                        if (i == 1) {
                            Pop2 = Pop2;
                            mutableVector = mutableVector;
                        } else {
                            Pop2 = Pop2;
                            mutableVector = mutableVector;
                        }
                    }
                    Pop2 = HitTestResultKt.pop(mutableVector);
                }
                if (Pop.isAttached) {
                    MutableVector mutableVector2 = this.children;
                    Object[] objArr = mutableVector2.content;
                    int i2 = mutableVector2.size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        Node node2 = (Node) objArr[i3];
                        this.coordinates.getClass();
                        node2.dispatchMainEventPass(internalPointerEvent, z);
                    }
                }
                if (Pop.isAttached) {
                    ?? mutableVector3 = 0;
                    while (Pop != 0) {
                        if (Pop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) Pop).mo27onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, j);
                        } else if ((Pop.kindSet & 16) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node node3 = ((DelegatingNode) Pop).delegate;
                            int i4 = 0;
                            while (node3 != null) {
                                if ((node3.kindSet & 16) != 0) {
                                    i4++;
                                    if (i4 == 1) {
                                        Pop = Pop;
                                        mutableVector3 = mutableVector3;
                                        mutableVector3 = mutableVector3;
                                        Pop = node3;
                                    } else {
                                        if (mutableVector3 == 0) {
                                            mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (Pop != 0) {
                                            mutableVector3.add(Pop);
                                            Pop = 0;
                                        }
                                        mutableVector3.add(node3);
                                    }
                                } else {
                                    Pop = Pop;
                                    mutableVector3 = mutableVector3;
                                }
                                node3 = node3.child;
                                Pop = Pop;
                                mutableVector3 = mutableVector3;
                            }
                            if (i4 == 1) {
                                Pop = Pop;
                                mutableVector3 = mutableVector3;
                            } else {
                                Pop = Pop;
                                mutableVector3 = mutableVector3;
                            }
                        }
                        Pop = HitTestResultKt.pop(mutableVector3);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void removeInvalidPointerIdsAndChanges(long j, MutableObjectList mutableObjectList) {
        LongArray longArray = this.pointerIds;
        if (longArray.contains(j) && !mutableObjectList.contains(this)) {
            longArray.remove(j);
            this.relevantChanges.remove(j);
        }
        MutableVector mutableVector = this.children;
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) objArr[i2]).removeInvalidPointerIdsAndChanges(j, mutableObjectList);
        }
    }

    public final String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + this.children + ", pointerIds=" + this.pointerIds + ")";
    }
}
