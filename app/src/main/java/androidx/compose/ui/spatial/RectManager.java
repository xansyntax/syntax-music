package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.GraphicsLayerOwnerLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RectManager {
    public final MutableRect cachedRect;
    public final MutableObjectList callbacks;
    public final RoomDatabase$$ExternalSyntheticLambda0 dispatchLambda;
    public PopupLayout$$ExternalSyntheticLambda5 dispatchToken;
    public final AndroidComposeView executeDelayed;
    public boolean isDirty;
    public boolean isFragmented;
    public boolean isScreenOrWindowDirty;
    public final IntObjectMap layoutNodes;
    public final StatusLine rects;
    public long scheduledDispatchDeadline;
    public final ThrottledCallbacks throttledCallbacks;

    public RectManager(MutableIntObjectMap mutableIntObjectMap, AndroidComposeView androidComposeView) {
        this.layoutNodes = mutableIntObjectMap;
        this.executeDelayed = androidComposeView;
        StatusLine statusLine = new StatusLine((byte) 6);
        statusLine.protocol = new long[192];
        statusLine.message = new long[192];
        this.rects = statusLine;
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList();
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new RoomDatabase$$ExternalSyntheticLambda0((byte) 17, this);
        this.cachedRect = new MutableRect();
    }

    public static boolean hasPositionalLayerTransformations(NodeCoordinator nodeCoordinator) {
        OwnedLayer ownedLayer = nodeCoordinator.layer;
        return (ownedLayer == null || ColorKt.m492isIdentity58bKbWc(((GraphicsLayerOwnerLayer) ownedLayer).m705getMatrixsQKQjiQ())) ? false : true;
    }

    /* JADX INFO: renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    public static long m719outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeChain nodeChain = layoutNode.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        long jM806plusqkQi6aY = 0;
        for (NodeCoordinator nodeCoordinator2 = (InnerNodeCoordinator) nodeChain.innerCoordinator; nodeCoordinator2 != null && nodeCoordinator2 != nodeCoordinator; nodeCoordinator2 = nodeCoordinator2.wrappedBy) {
            if (hasPositionalLayerTransformations(nodeCoordinator2)) {
                return 9223372034707292159L;
            }
            jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(jM806plusqkQi6aY, nodeCoordinator2.position);
        }
        return jM806plusqkQi6aY;
    }

    public static void resetHasPositionalLayerTransformationsForSubtreeIfNeeded(LayoutNode layoutNode) {
        if (!layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot || hasPositionalLayerTransformations((NodeCoordinator) layoutNode.nodes.outerCoordinator)) {
            return;
        }
        layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot = false;
        if (layoutNode.outerToInnerOffsetDirty) {
            layoutNode.outerToInnerOffset = m719outerToInnerOffsetBjo55l4(layoutNode);
            layoutNode.outerToInnerOffsetDirty = false;
        }
        if (IntOffset.m804equalsimpl0(layoutNode.outerToInnerOffset, 9223372034707292159L)) {
            return;
        }
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            resetHasPositionalLayerTransformationsForSubtreeIfNeeded((LayoutNode) objArr[i2]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0242  */
    /* JADX WARN: Code duplicated, block: B:103:0x024b A[LOOP:11: B:102:0x0249->B:103:0x024b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:106:0x0254 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0256 A[LOOP:9: B:95:0x0225->B:107:0x0256, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x025d A[ADDED_TO_REGION, LOOP:12: B:110:0x025d->B:111:0x025f, LOOP_START, PHI: r1
      0x025d: PHI (r1v8 androidx.compose.ui.spatial.ThrottledCallbacks$Entry) = 
      (r1v7 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
      (r1v9 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
     binds: [B:109:0x025b, B:111:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:111:0x025f A[LOOP:12: B:110:0x025d->B:111:0x025f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x026a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0207 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x0259 A[EDGE_INSN: B:136:0x0259->B:108:0x0259 BREAK  A[LOOP:9: B:95:0x0225->B:107:0x0256], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0259 A[EDGE_INSN: B:137:0x0259->B:108:0x0259 BREAK  A[LOOP:9: B:95:0x0225->B:107:0x0256], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x024e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x017f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0189 A[ADDED_TO_REGION, LOOP:7: B:73:0x0189->B:74:0x018b, LOOP_START, PHI: r3
      0x0189: PHI (r3v6 androidx.compose.ui.spatial.ThrottledCallbacks$Entry) = 
      (r3v5 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
      (r3v7 androidx.compose.ui.spatial.ThrottledCallbacks$Entry)
     binds: [B:72:0x0187, B:74:0x018b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x018b A[LOOP:7: B:73:0x0189->B:74:0x018b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x0211  */
    /* JADX WARN: Code duplicated, block: B:92:0x0219  */
    /* JADX WARN: Code duplicated, block: B:94:0x0224  */
    /* JADX WARN: Code duplicated, block: B:97:0x0231  */
    /* JADX WARN: Code duplicated, block: B:99:0x023c  */
    public final void dispatchCallbacks() {
        boolean z;
        long j;
        int i;
        long j2;
        long j3;
        int i2;
        long j4;
        Object[] objArr;
        long[] jArr;
        int length;
        ThrottledCallbacks.Entry entry;
        int i3;
        long j5;
        int i4;
        long j6;
        int i5;
        ThrottledCallbacks.Entry entry2;
        long[] jArr2;
        long[] jArr3;
        int i6;
        int i7;
        int i8;
        long j7;
        long j8;
        float[] fArr;
        ThrottledCallbacks.Entry entry3;
        long[] jArr4;
        long j9;
        long j10;
        PopupLayout$$ExternalSyntheticLambda5 popupLayout$$ExternalSyntheticLambda5 = this.dispatchToken;
        if (popupLayout$$ExternalSyntheticLambda5 != null) {
            this.executeDelayed.removeCallbacks(popupLayout$$ExternalSyntheticLambda5);
            this.dispatchToken = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.isDirty;
        boolean z3 = z2 || this.isScreenOrWindowDirty;
        StatusLine statusLine = this.rects;
        boolean z4 = true;
        ThrottledCallbacks throttledCallbacks = this.throttledCallbacks;
        if (z2) {
            this.isDirty = false;
            MutableObjectList mutableObjectList = this.callbacks;
            Object[] objArr2 = mutableObjectList.content;
            int i9 = mutableObjectList._size;
            for (int i10 = 0; i10 < i9; i10++) {
                ((Function0) objArr2[i10]).invoke();
            }
            long[] jArr5 = (long[]) statusLine.protocol;
            int i11 = statusLine.code;
            int i12 = 0;
            while (i12 < jArr5.length - 2 && i12 < i11) {
                long j11 = jArr5[i12 + 2];
                boolean z5 = z4;
                int i13 = i11;
                if ((((int) (j11 >> 60)) & 1) != 0) {
                    long j12 = jArr5[i12];
                    long j13 = jArr5[i12 + 1];
                    ThrottledCallbacks.Entry entry4 = (ThrottledCallbacks.Entry) throttledCallbacks.rectChangedMap.get(((int) j11) & 33554431);
                    while (entry4 != null) {
                        ThrottledCallbacks.Entry entry5 = entry4.next;
                        boolean z6 = z3;
                        long j14 = entry4.lastInvokeMillis;
                        boolean z7 = (jCurrentTimeMillis - j14 >= 0 || j14 == Long.MIN_VALUE) ? z5 : false;
                        entry4.topLeft = j12;
                        entry4.bottomRight = j13;
                        if (z7) {
                            entry4.lastInvokeMillis = jCurrentTimeMillis;
                            j9 = j12;
                            j10 = j13;
                            entry4.m723fire9b9wPM(j9, j10, throttledCallbacks.windowOffset, throttledCallbacks.screenOffset, throttledCallbacks.viewToWindowMatrix);
                        } else {
                            j9 = j12;
                            j10 = j13;
                        }
                        entry4 = entry5;
                        j12 = j9;
                        j13 = j10;
                        z3 = z6;
                    }
                }
                i12 += 3;
                z4 = z5;
                i11 = i13;
                z3 = z3;
            }
            z = z3;
            j = 0;
            long[] jArr6 = (long[]) statusLine.protocol;
            int i14 = statusLine.code;
            for (int i15 = 0; i15 < jArr6.length - 2 && i15 < i14; i15 += 3) {
                int i16 = i15 + 2;
                jArr6[i16] = jArr6[i16] & (-1152921504606846977L);
            }
        } else {
            z = z3;
            j = 0;
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            long j15 = throttledCallbacks.windowOffset;
            long j16 = throttledCallbacks.screenOffset;
            float[] fArr2 = throttledCallbacks.viewToWindowMatrix;
            MutableIntObjectMap mutableIntObjectMap = throttledCallbacks.rectChangedMap;
            j2 = 128;
            Object[] objArr3 = mutableIntObjectMap.values;
            long[] jArr7 = mutableIntObjectMap.metadata;
            int length2 = jArr7.length - 2;
            if (length2 >= 0) {
                int i17 = 0;
                int i18 = 8;
                j3 = 255;
                while (true) {
                    long j17 = j15;
                    long j18 = jArr7[i17];
                    int i19 = i18;
                    statusLine = statusLine;
                    if ((((~j18) << 7) & j18 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i20 = 8 - ((~(i17 - length2)) >>> 31);
                        long j19 = j18;
                        int i21 = 0;
                        while (i21 < i20) {
                            if ((j19 & 255) < 128) {
                                ThrottledCallbacks.Entry entry6 = (ThrottledCallbacks.Entry) objArr3[(i17 << 3) + i21];
                                while (entry6 != null) {
                                    throttledCallbacks.m721fireWY9HvpM(entry6, j17, j16, fArr2, jCurrentTimeMillis);
                                    entry6 = entry6.next;
                                    i19 = i19;
                                    jArr7 = jArr7;
                                }
                            }
                            long[] jArr8 = jArr7;
                            int i22 = i19;
                            j19 >>= i22;
                            i21++;
                            j17 = j17;
                            i19 = i22;
                            jArr7 = jArr8;
                        }
                        jArr4 = jArr7;
                        i = i19;
                        j15 = j17;
                        if (i20 != i) {
                            break;
                        }
                    } else {
                        jArr4 = jArr7;
                        i = i19;
                        j15 = j17;
                    }
                    if (i17 == length2) {
                        break;
                    }
                    i17++;
                    i18 = i;
                    statusLine = statusLine;
                    jArr7 = jArr4;
                }
            } else {
                i = 8;
            }
            if (z) {
                j7 = throttledCallbacks.windowOffset;
                j8 = throttledCallbacks.screenOffset;
                fArr = throttledCallbacks.viewToWindowMatrix;
                entry3 = throttledCallbacks.globalChangeEntries;
                if (entry3 != null) {
                    while (entry3 != null) {
                        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(entry3.node);
                        long jM720getOffsetFromRectListForBjo55l4 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode)).getRectManager().m720getOffsetFromRectListForBjo55l4(layoutNodeRequireLayoutNode);
                        entry3.topLeft = jM720getOffsetFromRectListForBjo55l4;
                        MeasurePassDelegate measurePassDelegate = layoutNodeRequireLayoutNode.layoutDelegate.measurePassDelegate;
                        entry3.bottomRight = (((long) (measurePassDelegate.width + ((int) (jM720getOffsetFromRectListForBjo55l4 >> 32)))) << 32) | (((long) (measurePassDelegate.height + ((int) (jM720getOffsetFromRectListForBjo55l4 & 4294967295L)))) & 4294967295L);
                        throttledCallbacks.m721fireWY9HvpM(entry3, j7, j8, fArr, jCurrentTimeMillis);
                        entry3 = entry3.next;
                    }
                }
            }
            if (this.isFragmented) {
                i2 = 0;
                this.isFragmented = false;
                StatusLine statusLine2 = statusLine;
                jArr2 = (long[]) statusLine2.protocol;
                int i23 = statusLine2.code;
                jArr3 = (long[]) statusLine2.message;
                i7 = 0;
                for (i6 = 0; i6 < jArr2.length - 2 && i7 < jArr3.length - 2 && i6 < i23; i6 += 3) {
                    i8 = i6 + 2;
                    if (jArr2[i8] != RectListKt.TombStone) {
                        jArr3[i7] = jArr2[i6];
                        jArr3[i7 + 1] = jArr2[i6 + 1];
                        jArr3[i7 + 2] = jArr2[i8];
                        i7 += 3;
                    }
                }
                statusLine2.code = i7;
                statusLine2.protocol = jArr3;
                statusLine2.message = jArr2;
            } else {
                i2 = 0;
            }
            j4 = throttledCallbacks.minDebounceDeadline;
            if (j4 <= jCurrentTimeMillis) {
                MutableIntObjectMap mutableIntObjectMap2 = throttledCallbacks.rectChangedMap;
                objArr = mutableIntObjectMap2.values;
                jArr = mutableIntObjectMap2.metadata;
                length = jArr.length - 2;
                if (length >= 0) {
                    i3 = i2;
                    while (true) {
                        j5 = jArr[i3];
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        } else {
                            i4 = 8 - ((~(i3 - length)) >>> 31);
                            j6 = j5;
                            for (i5 = i2; i5 < i4; i5++) {
                                if ((j6 & j3) < j2) {
                                    for (entry2 = (ThrottledCallbacks.Entry) objArr[(i3 << 3) + i5]; entry2 != null; entry2 = entry2.next) {
                                    }
                                }
                                j6 >>= i;
                            }
                            if (i4 == i) {
                                break;
                            } else if (i3 != length) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                entry = throttledCallbacks.globalChangeEntries;
                if (entry != null) {
                    while (entry != null) {
                        entry = entry.next;
                    }
                }
                j4 = -1;
                throttledCallbacks.minDebounceDeadline = -1L;
            }
            if (j4 > j) {
                scheduleDebounceCallback();
            }
        }
        i = 8;
        j2 = 128;
        j3 = 255;
        if (z) {
            j7 = throttledCallbacks.windowOffset;
            j8 = throttledCallbacks.screenOffset;
            fArr = throttledCallbacks.viewToWindowMatrix;
            entry3 = throttledCallbacks.globalChangeEntries;
            if (entry3 != null) {
                while (entry3 != null) {
                    LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(entry3.node);
                    long jM720getOffsetFromRectListForBjo55l5 = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode2)).getRectManager().m720getOffsetFromRectListForBjo55l4(layoutNodeRequireLayoutNode2);
                    entry3.topLeft = jM720getOffsetFromRectListForBjo55l5;
                    MeasurePassDelegate measurePassDelegate2 = layoutNodeRequireLayoutNode2.layoutDelegate.measurePassDelegate;
                    entry3.bottomRight = (((long) (measurePassDelegate2.width + ((int) (jM720getOffsetFromRectListForBjo55l5 >> 32)))) << 32) | (((long) (measurePassDelegate2.height + ((int) (jM720getOffsetFromRectListForBjo55l5 & 4294967295L)))) & 4294967295L);
                    throttledCallbacks.m721fireWY9HvpM(entry3, j7, j8, fArr, jCurrentTimeMillis);
                    entry3 = entry3.next;
                }
            }
        }
        if (this.isFragmented) {
            i2 = 0;
            this.isFragmented = false;
            StatusLine statusLine3 = statusLine;
            jArr2 = (long[]) statusLine3.protocol;
            int i24 = statusLine3.code;
            jArr3 = (long[]) statusLine3.message;
            i7 = 0;
            while (i6 < jArr2.length - 2) {
                i8 = i6 + 2;
                if (jArr2[i8] != RectListKt.TombStone) {
                    jArr3[i7] = jArr2[i6];
                    jArr3[i7 + 1] = jArr2[i6 + 1];
                    jArr3[i7 + 2] = jArr2[i8];
                    i7 += 3;
                }
            }
            statusLine3.code = i7;
            statusLine3.protocol = jArr3;
            statusLine3.message = jArr2;
        } else {
            i2 = 0;
        }
        j4 = throttledCallbacks.minDebounceDeadline;
        if (j4 <= jCurrentTimeMillis) {
            MutableIntObjectMap mutableIntObjectMap3 = throttledCallbacks.rectChangedMap;
            objArr = mutableIntObjectMap3.values;
            jArr = mutableIntObjectMap3.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                i3 = i2;
                while (true) {
                    j5 = jArr[i3];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        }
                        i3++;
                    } else {
                        i4 = 8 - ((~(i3 - length)) >>> 31);
                        j6 = j5;
                        while (i5 < i4) {
                            if ((j6 & j3) < j2) {
                                while (entry2 != null) {
                                }
                            }
                            j6 >>= i;
                        }
                        if (i4 == i) {
                            break;
                            break;
                        } else {
                            if (i3 != length) {
                                break;
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            entry = throttledCallbacks.globalChangeEntries;
            if (entry != null) {
                while (entry != null) {
                    entry = entry.next;
                }
            }
            j4 = -1;
            throttledCallbacks.minDebounceDeadline = -1L;
        }
        if (j4 > j) {
            scheduleDebounceCallback();
        }
    }

    /* JADX INFO: renamed from: getOffsetFromRectListFor-Bjo55l4, reason: not valid java name */
    public final long m720getOffsetFromRectListForBjo55l4(LayoutNode layoutNode) {
        if (layoutNode.rectListIndex == -4) {
            return 9223372034707292159L;
        }
        long j = ((long[]) this.rects.protocol)[indexInRectList(layoutNode)];
        return (((long) ((int) (j >> 32))) << 32) | (((long) ((int) j)) & 4294967295L);
    }

    public final int indexInRectList(LayoutNode layoutNode) {
        int i = layoutNode.rectListIndex;
        if (i != -4) {
            int i2 = layoutNode.semanticsId;
            StatusLine statusLine = this.rects;
            long[] jArr = (long[]) statusLine.protocol;
            if (i < 0 || i >= statusLine.code - 2 || (((int) jArr[i + 2]) & 33554431) != (i2 & 33554431)) {
                int i3 = i2 & 33554431;
                int i4 = statusLine.code;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4 - 2) {
                        i = -4;
                        break;
                    }
                    if ((((int) jArr[i5 + 2]) & 33554431) == i3) {
                        i = i5;
                        break;
                    }
                    i5 += 3;
                }
            }
        } else {
            i = -4;
            break;
        }
        if (i == -4) {
            InlineClassHelperKt.throwIllegalArgumentException("LayoutNode " + layoutNode.semanticsId + " not found in RectList");
        }
        layoutNode.rectListIndex = i;
        return i;
    }

    public final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot = true;
        NodeChain nodeChain = layoutNode.nodes;
        MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
        int measuredWidth = measurePassDelegate.getMeasuredWidth();
        float measuredHeight = measurePassDelegate.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.left = CropImageView.DEFAULT_ASPECT_RATIO;
        mutableRect.top = CropImageView.DEFAULT_ASPECT_RATIO;
        mutableRect.right = measuredWidth;
        mutableRect.bottom = measuredHeight;
        for (NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            LayoutNode layoutNode2 = nodeCoordinator.layoutNode;
            if (nodeCoordinator == ((NodeCoordinator) layoutNode2.nodes.outerCoordinator) && !layoutNode2.hasPositionalLayerTransformationsInOffsetFromRoot) {
                long jM720getOffsetFromRectListForBjo55l4 = m720getOffsetFromRectListForBjo55l4(layoutNode2);
                if (!IntOffset.m804equalsimpl0(jM720getOffsetFromRectListForBjo55l4, 9223372034707292159L)) {
                    mutableRect.m432translatek4lQ0M((((long) Float.floatToRawIntBits((int) (jM720getOffsetFromRectListForBjo55l4 >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (jM720getOffsetFromRectListForBjo55l4 & 4294967295L))) & 4294967295L));
                    break;
                }
            }
            OwnedLayer ownedLayer = nodeCoordinator.layer;
            if (ownedLayer != null) {
                float[] fArrM705getMatrixsQKQjiQ = ((GraphicsLayerOwnerLayer) ownedLayer).m705getMatrixsQKQjiQ();
                if (!ColorKt.m492isIdentity58bKbWc(fArrM705getMatrixsQKQjiQ)) {
                    Matrix.m509mapimpl(fArrM705getMatrixsQKQjiQ, mutableRect);
                }
            }
            long j = nodeCoordinator.position;
            mutableRect.m432translatek4lQ0M((4294967295L & ((long) Float.floatToRawIntBits((int) (j & 4294967295L)))) | (((long) Float.floatToRawIntBits((int) (j >> 32))) << 32));
        }
        int i = (int) mutableRect.left;
        int i2 = (int) mutableRect.top;
        int i3 = (int) mutableRect.right;
        int i4 = (int) mutableRect.bottom;
        int i5 = layoutNode.semanticsId;
        int i6 = layoutNode.rectListIndex;
        StatusLine statusLine = this.rects;
        if (i6 != -4) {
            int iIndexInRectList = indexInRectList(layoutNode);
            long[] jArr = (long[]) statusLine.protocol;
            jArr[iIndexInRectList] = (((long) i) << 32) | (((long) i2) & 4294967295L);
            jArr[iIndexInRectList + 1] = (4294967295L & ((long) i4)) | (((long) i3) << 32);
            int i7 = iIndexInRectList + 2;
            long j2 = jArr[i7];
            jArr[i7] = j2 | (((j2 >> 63) & 1) << 60);
        } else {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            layoutNode.rectListIndex = statusLine.insert(i5, i, i2, i3, i4, parent$ui != null ? parent$ui.semanticsId : -1, parent$ui != null ? indexInRectList(parent$ui) : -4, nodeChain.m662hasH91voCI$ui(1024), nodeChain.m662hasH91voCI$ui(16), this.throttledCallbacks.rectChangedMap.containsKey(i5));
        }
        layoutNode.rectInParentDirty = false;
        this.isDirty = true;
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i8 = mutableVector.size;
        for (int i9 = 0; i9 < i8; i9++) {
            LayoutNode layoutNode3 = (LayoutNode) objArr[i9];
            if (layoutNode3.isPlaced()) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode3);
            }
        }
    }

    public final void recalculateRectIfDirty(LayoutNode layoutNode) {
        long j;
        boolean zIsPlaced = layoutNode.isPlaced();
        NodeChain nodeChain = layoutNode.nodes;
        if (zIsPlaced && layoutNode.rectInParentDirty) {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            if (parent$ui == null || parent$ui.hasPositionalLayerTransformationsInOffsetFromRoot) {
                j = parent$ui == null ? 0L : 9223372034707292159L;
            } else {
                if (parent$ui.outerToInnerOffsetDirty) {
                    parent$ui.outerToInnerOffsetDirty = false;
                    parent$ui.outerToInnerOffset = m719outerToInnerOffsetBjo55l4(parent$ui);
                }
                j = parent$ui.outerToInnerOffset;
            }
            NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
            if (IntOffset.m804equalsimpl0(j, 9223372034707292159L) || hasPositionalLayerTransformations(nodeCoordinator)) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
            } else if (layoutNode.hasPositionalLayerTransformationsInOffsetFromRoot) {
                insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
                resetHasPositionalLayerTransformationsForSubtreeIfNeeded(layoutNode);
            } else {
                long jM806plusqkQi6aY = IntOffset.m806plusqkQi6aY(j, nodeCoordinator.position);
                MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
                int measuredWidth = measurePassDelegate.getMeasuredWidth();
                int measuredHeight = measurePassDelegate.getMeasuredHeight();
                int i = layoutNode.rectListIndex;
                StatusLine statusLine = this.rects;
                if (i != -4) {
                    int iIndexInRectList = indexInRectList(layoutNode);
                    if (parent$ui != null) {
                        int iIndexInRectList2 = indexInRectList(parent$ui);
                        long[] jArr = (long[]) statusLine.protocol;
                        long j2 = jArr[iIndexInRectList2];
                        int i2 = ((int) (j2 >> 32)) + ((int) (jM806plusqkQi6aY >> 32));
                        int i3 = ((int) j2) + ((int) (jM806plusqkQi6aY & 4294967295L));
                        long j3 = jArr[iIndexInRectList];
                        int i4 = i2 - ((int) (j3 >> 32));
                        int i5 = i3 - ((int) j3);
                        int i6 = iIndexInRectList + 2;
                        long j4 = jArr[i6];
                        jArr[iIndexInRectList] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
                        jArr[iIndexInRectList + 1] = (((long) (measuredWidth + i2)) << 32) | (((long) (measuredHeight + i3)) & 4294967295L);
                        jArr[i6] = j4 | (((j4 >> 63) & 1) << 60);
                        if (i4 != 0 || i5 != 0) {
                            statusLine.updateSubhierarchy(iIndexInRectList, i4, i5, j4);
                        }
                    } else {
                        int iIndexInRectList3 = indexInRectList(layoutNode);
                        int i7 = (int) (jM806plusqkQi6aY >> 32);
                        int i8 = (int) (jM806plusqkQi6aY & 4294967295L);
                        long[] jArr2 = (long[]) statusLine.protocol;
                        long j5 = jArr2[iIndexInRectList3];
                        jArr2[iIndexInRectList3] = (((long) i8) & 4294967295L) | (((long) i7) << 32);
                        jArr2[iIndexInRectList3 + 1] = (((long) (measuredHeight + i8)) & 4294967295L) | (((long) (measuredWidth + i7)) << 32);
                        int i9 = iIndexInRectList3 + 2;
                        long j6 = jArr2[i9];
                        jArr2[i9] = (((j6 >> 63) & 1) << 60) | j6;
                        int i10 = i7 - ((int) (j5 >> 32));
                        int i11 = i8 - ((int) j5);
                        if (i10 != 0 || i11 != 0) {
                            statusLine.updateSubhierarchy(iIndexInRectList3, i10, i11, j6);
                        }
                    }
                } else {
                    int i12 = layoutNode.semanticsId;
                    boolean zM662hasH91voCI$ui = nodeChain.m662hasH91voCI$ui(1024);
                    boolean zM662hasH91voCI$ui2 = nodeChain.m662hasH91voCI$ui(16);
                    boolean zContainsKey = this.throttledCallbacks.rectChangedMap.containsKey(i12);
                    if (parent$ui != null) {
                        int i13 = parent$ui.semanticsId;
                        int iIndexInRectList4 = indexInRectList(parent$ui);
                        int i14 = (int) (jM806plusqkQi6aY >> 32);
                        int i15 = (int) (jM806plusqkQi6aY & 4294967295L);
                        int i16 = i12 & 33554431;
                        long[] jArr3 = (long[]) statusLine.protocol;
                        if ((((int) jArr3[iIndexInRectList4 + 2]) & 33554431) != (33554431 & i13)) {
                            InlineClassHelperKt.throwIllegalArgumentException("Inserted child " + i16 + " without valid parent index or parent " + i13 + " not found");
                        }
                        long j7 = jArr3[iIndexInRectList4];
                        int i17 = ((int) (j7 >> 32)) + i14;
                        int i18 = ((int) j7) + i15;
                        layoutNode.rectListIndex = statusLine.insert(i16, i17, i18, i17 + measuredWidth, i18 + measuredHeight, i13, iIndexInRectList4, zM662hasH91voCI$ui, zM662hasH91voCI$ui2, zContainsKey);
                    } else {
                        int i19 = (int) (jM806plusqkQi6aY >> 32);
                        int i20 = (int) (jM806plusqkQi6aY & 4294967295L);
                        layoutNode.rectListIndex = statusLine.insert(i12, i19, i20, i19 + measuredWidth, i20 + measuredHeight, -1, -4, zM662hasH91voCI$ui, zM662hasH91voCI$ui2, zContainsKey);
                    }
                }
            }
            layoutNode.rectInParentDirty = false;
            this.isDirty = true;
            scheduleDebounceCallback();
        }
    }

    public final void remove(LayoutNode layoutNode) {
        if (layoutNode.rectListIndex != -4) {
            int iIndexInRectList = indexInRectList(layoutNode);
            long[] jArr = (long[]) this.rects.protocol;
            jArr[iIndexInRectList] = -1;
            jArr[iIndexInRectList + 1] = -1;
            jArr[iIndexInRectList + 2] = RectListKt.TombStone;
            layoutNode.rectListIndex = -4;
            layoutNode.rectInParentDirty = true;
            this.isDirty = true;
            this.isFragmented = true;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void scheduleDebounceCallback() {
        PopupLayout$$ExternalSyntheticLambda5 popupLayout$$ExternalSyntheticLambda5 = this.dispatchToken;
        boolean z = popupLayout$$ExternalSyntheticLambda5 != null;
        long j = this.throttledCallbacks.minDebounceDeadline;
        if (j >= 0 || !z) {
            if (this.scheduledDispatchDeadline == j && z) {
                return;
            }
            AndroidComposeView androidComposeView = this.executeDelayed;
            if (popupLayout$$ExternalSyntheticLambda5 != null) {
                androidComposeView.removeCallbacks(popupLayout$$ExternalSyntheticLambda5);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = Math.max(j, 16 + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            PopupLayout$$ExternalSyntheticLambda5 popupLayout$$ExternalSyntheticLambda6 = new PopupLayout$$ExternalSyntheticLambda5(this.dispatchLambda, (byte) 3);
            androidComposeView.postDelayed(popupLayout$$ExternalSyntheticLambda6, jMax - jCurrentTimeMillis);
            this.dispatchToken = popupLayout$$ExternalSyntheticLambda6;
        }
    }
}
