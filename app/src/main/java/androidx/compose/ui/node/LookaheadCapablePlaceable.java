package androidx.compose.ui.node;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OuterPlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.sqlite.SQLite;
import java.util.Arrays;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MotionReferencePlacementDelegate, OwnerScope, MeasureScope {
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingRuler = new ComposedModifierKt$$ExternalSyntheticLambda0(11);
    public static final ComposedModifierKt$$ExternalSyntheticLambda0 onCommitAffectingSingleRuler = new ComposedModifierKt$$ExternalSyntheticLambda0(12);
    public ResettableRulerScope _rulerScope;
    public MutableScatterMap _rulerScopes;
    public PlaceableResult cachedRulerPlaceableResult;
    public MutableScatterMap cachedRulerPlaceableResults;
    public boolean isPlacedUnderMotionFrameOfReference;
    public boolean isPlacingForAlignment;
    public boolean isShallowPlacing;
    public final OuterPlacementScope placementScope = new OuterPlacementScope(1, this);
    public Function1 providedRulers;
    public Function2 rulerProvider;
    public MutableScatterMap rulerReaders;
    public RulerTrackingMap rulerValues;
    public Function1 rulersLambda;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ResettableRulerScope implements Density {
        public boolean coordinatesAccessed;
        public MutableObjectList providedRulers;
        public final VerticalRuler requestedRuler;
        public long positionOnScreen = 9223372034707292159L;
        public long size = 0;

        public ResettableRulerScope(VerticalRuler verticalRuler) {
            this.requestedRuler = verticalRuler;
        }

        public final LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LookaheadCapablePlaceable lookaheadCapablePlaceable = LookaheadCapablePlaceable.this;
            LayoutCoordinates coordinates = lookaheadCapablePlaceable.getCoordinates();
            if (IntOffset.m804equalsimpl0(this.positionOnScreen, 9223372034707292159L)) {
                this.positionOnScreen = SQLite.m847roundk4lQ0M(coordinates.mo607localToScreenMKHz9U(0L));
                this.size = coordinates.mo603getSizeYbymL2g();
            }
            lookaheadCapablePlaceable.getLayoutNode().layoutDelegate.onCoordinatesUsed();
            return coordinates;
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public final float getFontScale() {
            return LookaheadCapablePlaceable.this.getFontScale();
        }

        public final void provides(VerticalRuler verticalRuler, float f) {
            LookaheadCapablePlaceable lookaheadCapablePlaceable = LookaheadCapablePlaceable.this;
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            if (rulerTrackingMap == null) {
                rulerTrackingMap = new RulerTrackingMap();
                lookaheadCapablePlaceable.rulerValues = rulerTrackingMap;
            }
            int iIndexOf = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap.rulers, verticalRuler);
            if (iIndexOf < 0) {
                int i = rulerTrackingMap.size;
                VerticalRuler[] verticalRulerArr = (VerticalRuler[]) rulerTrackingMap.rulers;
                if (i == verticalRulerArr.length) {
                    int i2 = i * 2;
                    rulerTrackingMap.rulers = (VerticalRuler[]) Arrays.copyOf(verticalRulerArr, i2);
                    rulerTrackingMap.values = Arrays.copyOf((float[]) rulerTrackingMap.values, i2);
                    rulerTrackingMap.accessFlags = Arrays.copyOf((byte[]) rulerTrackingMap.accessFlags, i2);
                }
                ((VerticalRuler[]) rulerTrackingMap.rulers)[i] = verticalRuler;
                ((byte[]) rulerTrackingMap.accessFlags)[i] = 3;
                ((float[]) rulerTrackingMap.values)[i] = f;
                rulerTrackingMap.size++;
            } else {
                float[] fArr = (float[]) rulerTrackingMap.values;
                if (fArr[iIndexOf] == f) {
                    byte[] bArr = (byte[]) rulerTrackingMap.accessFlags;
                    if (bArr[iIndexOf] == 2) {
                        bArr[iIndexOf] = 0;
                    }
                } else {
                    fArr[iIndexOf] = f;
                    ((byte[]) rulerTrackingMap.accessFlags)[iIndexOf] = 1;
                }
            }
            VerticalRuler verticalRuler2 = this.requestedRuler;
            if (verticalRuler2 == null || Intrinsics.areEqual(verticalRuler, verticalRuler2)) {
                return;
            }
            MutableObjectList mutableObjectList = this.providedRulers;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList(2);
                this.providedRulers = mutableObjectList;
            }
            if (mutableObjectList.contains(verticalRuler)) {
                return;
            }
            mutableObjectList.add(verticalRuler);
        }
    }

    public static void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        LookaheadAlignmentLines lookaheadAlignmentLines;
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrapped;
        LayoutNode layoutNode = nodeCoordinator.layoutNode;
        if (!Intrinsics.areEqual(nodeCoordinator2 != null ? nodeCoordinator2.layoutNode : null, layoutNode)) {
            layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = layoutNode.layoutDelegate.measurePassDelegate.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (lookaheadAlignmentLines = ((MeasurePassDelegate) parentAlignmentLinesOwner).alignmentLines) == null) {
            return;
        }
        lookaheadAlignmentLines.onAlignmentsChanged();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0108  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addRulerReader(LayoutNode layoutNode, VerticalRuler verticalRuler) {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        long j4;
        int i;
        char c2;
        long j5;
        long j6;
        int i2;
        int i3;
        int i4;
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                long j8 = 128;
                while (true) {
                    long j9 = jArr3[i6];
                    j2 = 255;
                    if ((((~j9) << c3) & j9 & j7) != j7) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j9 & 255) < j8) {
                                c2 = c3;
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) objArr[(i6 << 3) + i8];
                                j5 = j7;
                                Object[] objArr2 = mutableScatterSet.elements;
                                long[] jArr4 = mutableScatterSet.metadata;
                                int length2 = jArr4.length - 2;
                                if (length2 >= 0) {
                                    j6 = j8;
                                    int i9 = 0;
                                    int i10 = i5;
                                    while (true) {
                                        int i11 = length2;
                                        long j10 = jArr4[i9];
                                        jArr2 = jArr3;
                                        j4 = j9;
                                        if ((((~j10) << c2) & j10 & j5) != j5) {
                                            int i12 = 8 - ((~(i9 - i11)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j10 & 255) < j6) {
                                                    int i14 = (i9 << 3) + i13;
                                                    LayoutNode layoutNode2 = (LayoutNode) ((WeakReference) objArr2[i14]).get();
                                                    i3 = i13;
                                                    if (layoutNode2 != null) {
                                                        boolean zIsAttached$1 = layoutNode2.isAttached$1();
                                                        i4 = i8;
                                                        if (zIsAttached$1) {
                                                        }
                                                    } else {
                                                        i4 = i8;
                                                    }
                                                    mutableScatterSet.removeElementAt(i14);
                                                } else {
                                                    i3 = i13;
                                                    i4 = i8;
                                                }
                                                j10 >>= i10;
                                                i13 = i3 + 1;
                                                i8 = i4;
                                            }
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            i = i8;
                                        }
                                        length2 = i11;
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        jArr3 = jArr2;
                                        j9 = j4;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    j4 = j9;
                                    i = i8;
                                    j6 = j8;
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j4 = j9;
                                i = i8;
                                c2 = c3;
                                j5 = j7;
                                j6 = j8;
                                i2 = i5;
                            }
                            i5 = i2;
                            j9 = j4 >> i2;
                            c3 = c2;
                            j7 = j5;
                            j8 = j6;
                            i8 = i + 1;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                        if (i7 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                        c = c3;
                        j = j7;
                        j3 = j8;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    c3 = c;
                    j7 = j;
                    j8 = j3;
                    jArr3 = jArr;
                    i5 = 8;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 255;
                j3 = 128;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 255;
            j3 = 128;
        }
        MutableScatterMap mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            long[] jArr5 = mutableScatterMap2.metadata;
            int length3 = jArr5.length - 2;
            if (length3 >= 0) {
                int i15 = 0;
                while (true) {
                    long j11 = jArr5[i15];
                    if ((((~j11) << c) & j11 & j) != j) {
                        int i16 = 8 - ((~(i15 - length3)) >>> 31);
                        for (int i17 = 0; i17 < i16; i17++) {
                            if ((j11 & j2) < j3) {
                                int i18 = (i15 << 3) + i17;
                                if (((MutableScatterSet) mutableScatterMap2.values[i18]).isEmpty()) {
                                    mutableScatterMap2.removeValueAt(i18);
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i16 != 8) {
                            break;
                        }
                    }
                    if (i15 == length3) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
        }
        MutableScatterMap mutableScatterMap3 = this.rulerReaders;
        if (mutableScatterMap3 == null) {
            mutableScatterMap3 = new MutableScatterMap();
            this.rulerReaders = mutableScatterMap3;
        }
        Object mutableScatterSet2 = mutableScatterMap3.get(verticalRuler);
        if (mutableScatterSet2 == null) {
            mutableScatterSet2 = new MutableScatterSet();
            mutableScatterMap3.set(verticalRuler, mutableScatterSet2);
        }
        ((MutableScatterSet) mutableScatterSet2).plusAssign(new WeakReference(layoutNode));
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    public final void m653captureRulersOSxE8f4(final PlaceableResult placeableResult, final long j, final long j2) {
        boolean z;
        char c;
        long j3;
        long j4;
        long j5;
        LayoutNode layoutNode;
        boolean z2;
        int i;
        char c2;
        long j6;
        OwnerSnapshotObserver snapshotObserver;
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        RulerTrackingMap rulerTrackingMap2 = rulerTrackingMap;
        Owner owner = getLayoutNode().owner;
        if (owner != null && (snapshotObserver = ((AndroidComposeView) owner).getSnapshotObserver()) != null) {
            snapshotObserver.observer.observeReads(placeableResult, onCommitAffectingRuler, new Function0() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = this.f$0;
                    lookaheadCapablePlaceable.getRulerScope().coordinatesAccessed = false;
                    lookaheadCapablePlaceable.getRulerScope().positionOnScreen = j;
                    lookaheadCapablePlaceable.getRulerScope().size = j2;
                    Function1 rulers = placeableResult.result.getRulers();
                    if (rulers != null) {
                        rulers.invoke(lookaheadCapablePlaceable.getRulerScope());
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        boolean zIsLookingAhead = isLookingAhead();
        MutableScatterSet mutableScatterSet = (MutableScatterSet) rulerTrackingMap2.layoutNodes;
        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) rulerTrackingMap2.newRulers;
        int i2 = rulerTrackingMap2.size;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = ((byte[]) rulerTrackingMap2.accessFlags)[i3];
            if (b == 3) {
                VerticalRuler verticalRuler = ((VerticalRuler[]) rulerTrackingMap2.rulers)[i3];
                verticalRuler.getClass();
                mutableScatterSet2.plusAssign(verticalRuler);
            } else if (b != 0 && mutableScatterMap != null) {
                VerticalRuler verticalRuler2 = ((VerticalRuler[]) rulerTrackingMap2.rulers)[i3];
                verticalRuler2.getClass();
                MutableScatterSet mutableScatterSet3 = (MutableScatterSet) mutableScatterMap.remove(verticalRuler2);
                if (mutableScatterSet3 != null) {
                    mutableScatterSet.plusAssign(mutableScatterSet3);
                }
            }
        }
        int i4 = rulerTrackingMap2.size;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            byte[] bArr = (byte[]) rulerTrackingMap2.accessFlags;
            if (bArr[i6] == 2) {
                i5++;
            } else if (i5 > 0) {
                VerticalRuler[] verticalRulerArr = (VerticalRuler[]) rulerTrackingMap2.rulers;
                verticalRulerArr[i6 - i5] = verticalRulerArr[i6];
            }
            bArr[i6] = 2;
        }
        int i7 = rulerTrackingMap2.size;
        for (int i8 = i7 - i5; i8 < i7; i8++) {
            ((VerticalRuler[]) rulerTrackingMap2.rulers)[i8] = null;
        }
        rulerTrackingMap2.size -= i5;
        LookaheadCapablePlaceable parent = getParent();
        Object[] objArr = mutableScatterSet2.elements;
        long[] jArr = mutableScatterSet2.metadata;
        int length = jArr.length - 2;
        char c3 = 7;
        long j7 = -9187201950435737472L;
        int i9 = 8;
        if (length >= 0) {
            j4 = 128;
            int i10 = 0;
            while (true) {
                long j8 = jArr[i10];
                j5 = 255;
                if ((((~j8) << c3) & j8 & j7) != j7) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j8 & 255) < 128) {
                            c2 = c3;
                            VerticalRuler verticalRuler3 = (VerticalRuler) objArr[(i10 << 3) + i12];
                            j6 = j7;
                            LookaheadCapablePlaceable lookaheadCapablePlaceable = parent == null ? this : parent;
                            i = i9;
                            LookaheadCapablePlaceable lookaheadCapablePlaceable2 = lookaheadCapablePlaceable;
                            while (true) {
                                RulerTrackingMap rulerTrackingMap3 = lookaheadCapablePlaceable2.rulerValues;
                                if (rulerTrackingMap3 != null) {
                                    z2 = zIsLookingAhead;
                                    if (ArraysKt.contains((VerticalRuler[]) rulerTrackingMap3.rulers, verticalRuler3)) {
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                z2 = zIsLookingAhead;
                                LookaheadCapablePlaceable parent2 = lookaheadCapablePlaceable2.getParent();
                                if (parent2 == null) {
                                    break;
                                }
                                lookaheadCapablePlaceable2 = parent2;
                                zIsLookingAhead = z2;
                            }
                            MutableScatterMap mutableScatterMap2 = lookaheadCapablePlaceable2.rulerReaders;
                            MutableScatterSet mutableScatterSet4 = mutableScatterMap2 != null ? (MutableScatterSet) mutableScatterMap2.remove(verticalRuler3) : null;
                            if (mutableScatterSet4 != null) {
                                lookaheadCapablePlaceable.notifyRulerValueChange(mutableScatterSet4);
                            }
                        } else {
                            z2 = zIsLookingAhead;
                            i = i9;
                            c2 = c3;
                            j6 = j7;
                        }
                        j8 >>= i;
                        i12++;
                        c3 = c2;
                        j7 = j6;
                        i9 = i;
                        zIsLookingAhead = z2;
                    }
                    z = zIsLookingAhead;
                    c = c3;
                    j3 = j7;
                    if (i11 != i9) {
                        break;
                    }
                } else {
                    z = zIsLookingAhead;
                    c = c3;
                    j3 = j7;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                c3 = c;
                j7 = j3;
                zIsLookingAhead = z;
                i9 = 8;
            }
        } else {
            z = zIsLookingAhead;
            c = 7;
            j3 = -9187201950435737472L;
            j4 = 128;
            j5 = 255;
        }
        mutableScatterSet2.clear();
        Object[] objArr2 = mutableScatterSet.elements;
        long[] jArr2 = mutableScatterSet.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i13 = 0;
            while (true) {
                long j9 = jArr2[i13];
                if ((((~j9) << c) & j9 & j3) != j3) {
                    int i14 = 8 - ((~(i13 - length2)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((j9 & j5) < j4 && (layoutNode = (LayoutNode) ((WeakReference) objArr2[(i13 << 3) + i15]).get()) != null) {
                            if (z) {
                                layoutNode.requestLookaheadRelayout$ui(false);
                            } else {
                                layoutNode.requestRelayout$ui(false);
                            }
                        }
                        j9 >>= 8;
                    }
                    if (i14 != 8) {
                        break;
                    }
                }
                if (i13 == length2) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        mutableScatterSet.clear();
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0092  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00df  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:60:0x010c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0119  */
    /* JADX WARN: Code duplicated, block: B:65:0x011d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0138  */
    /* JADX WARN: Code duplicated, block: B:72:0x013f A[LOOP:2: B:47:0x00c2->B:72:0x013f, LOOP_END] */
    public final void captureRulersIfNeeded$ui(MeasureResult measureResult) {
        char c;
        long j;
        long j2;
        long jM847roundk4lQ0M;
        long jMo603getSizeYbymL2g;
        MutableScatterMap mutableScatterMap;
        Object[] objArr;
        Object[] objArr2;
        long[] jArr;
        int length;
        int i;
        long j3;
        int i2;
        long[] jArr2;
        Object[] objArr3;
        Object[] objArr4;
        int i3;
        int i4;
        long[] jArr3;
        Object[] objArr5;
        Object[] objArr6;
        int i5;
        ResettableRulerScope resettableRulerScope;
        VerticalRuler verticalRuler;
        boolean z;
        long j4;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1 rulers = measureResult.getRulers();
        Function2 rulerProvider = measureResult.getRulerProvider();
        Function1 function1IsRulerProvided = measureResult.isRulerProvided();
        long jMo603getSizeYbymL2g2 = 0;
        ResettableRulerScope resettableRulerScope2 = null;
        if (rulerProvider == null) {
            long jM847roundk4lQ0M2 = 9223372034707292159L;
            if (rulers == null) {
                resetProvidedRulers();
                this.rulersLambda = null;
                this.rulerProvider = null;
                this.providedRulers = null;
                ResettableRulerScope resettableRulerScope3 = this._rulerScope;
                if (resettableRulerScope3 != null) {
                    resettableRulerScope3.coordinatesAccessed = false;
                }
                if (resettableRulerScope3 != null) {
                    resettableRulerScope3.positionOnScreen = 9223372034707292159L;
                    return;
                }
                return;
            }
            this.rulerProvider = null;
            this.providedRulers = null;
            boolean z2 = this.rulersLambda != rulers;
            if (!z2 && getRulerScope().coordinatesAccessed) {
                LayoutCoordinates coordinates = getCoordinates();
                jM847roundk4lQ0M2 = SQLite.m847roundk4lQ0M(coordinates.mo607localToScreenMKHz9U(0L));
                jMo603getSizeYbymL2g2 = coordinates.mo603getSizeYbymL2g();
                z2 = (IntOffset.m804equalsimpl0(jM847roundk4lQ0M2, getRulerScope().positionOnScreen) && IntSize.m810equalsimpl0(jMo603getSizeYbymL2g2, getRulerScope().size)) ? false : true;
            }
            if (z2) {
                PlaceableResult placeableResult = this.cachedRulerPlaceableResult;
                if (placeableResult != null) {
                    placeableResult.result = measureResult;
                } else {
                    placeableResult = new PlaceableResult(measureResult, this, null);
                    this.cachedRulerPlaceableResult = placeableResult;
                }
                m653captureRulersOSxE8f4(placeableResult, jM847roundk4lQ0M2, jMo603getSizeYbymL2g2);
                this.rulersLambda = measureResult.getRulers();
                return;
            }
            return;
        }
        if (rulerProvider != this.rulerProvider || function1IsRulerProvided != this.providedRulers) {
            this.rulerProvider = rulerProvider;
            this.providedRulers = function1IsRulerProvided;
            resetProvidedRulers();
            return;
        }
        MutableScatterMap mutableScatterMap2 = this._rulerScopes;
        long j5 = -9187201950435737472L;
        int i6 = 8;
        if (mutableScatterMap2 != null) {
            Object[] objArr7 = mutableScatterMap2.values;
            long[] jArr4 = mutableScatterMap2.metadata;
            j = 128;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                c = 7;
                int i7 = 0;
                while (true) {
                    long j6 = jArr4[i7];
                    j2 = 255;
                    if ((((~j6) << 7) & j6 & j5) != j5) {
                        int i8 = 8 - ((~(i7 - length2)) >>> 31);
                        int i9 = 0;
                        while (i9 < i8) {
                            if ((j6 & 255) < 128) {
                                j4 = j5;
                                ResettableRulerScope resettableRulerScope4 = (ResettableRulerScope) objArr7[(i7 << 3) + i9];
                                if (resettableRulerScope4.coordinatesAccessed) {
                                    resettableRulerScope2 = resettableRulerScope4;
                                }
                            } else {
                                j4 = j5;
                            }
                            j6 >>= 8;
                            i9++;
                            j5 = j4;
                        }
                        j5 = j5;
                        if (i8 != 8) {
                            break;
                        }
                    } else {
                        j5 = j5;
                    }
                    if (i7 == length2) {
                        break;
                    }
                    i7++;
                    j5 = j5;
                }
            } else {
                c = 7;
            }
            if (resettableRulerScope2 != null) {
                return;
            }
            LayoutCoordinates coordinates2 = getCoordinates();
            jM847roundk4lQ0M = SQLite.m847roundk4lQ0M(coordinates2.mo607localToScreenMKHz9U(0L));
            jMo603getSizeYbymL2g = coordinates2.mo603getSizeYbymL2g();
            if ((!IntOffset.m804equalsimpl0(jM847roundk4lQ0M, resettableRulerScope2.positionOnScreen) && IntSize.m810equalsimpl0(jMo603getSizeYbymL2g, resettableRulerScope2.size)) || (mutableScatterMap = this._rulerScopes) == null) {
                return;
            }
            objArr = mutableScatterMap.keys;
            objArr2 = mutableScatterMap.values;
            jArr = mutableScatterMap.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                return;
            }
            i = 0;
            while (true) {
                j3 = jArr[i];
                i2 = i6;
                if ((((~j3) << c) & j3 & j5) != j5) {
                    i3 = 8 - ((~(i - length)) >>> 31);
                    i4 = 0;
                    while (i4 < i3) {
                        if ((j3 & j2) < j) {
                            int i10 = (i << 3) + i4;
                            Object obj = objArr[i10];
                            i5 = i2;
                            resettableRulerScope = (ResettableRulerScope) objArr2[i10];
                            verticalRuler = (VerticalRuler) obj;
                            jArr3 = jArr;
                            if (resettableRulerScope.coordinatesAccessed) {
                                objArr5 = objArr;
                                objArr6 = objArr2;
                                z = IntSize.m810equalsimpl0(resettableRulerScope.size, jMo603getSizeYbymL2g) || !IntOffset.m804equalsimpl0(resettableRulerScope.positionOnScreen, jM847roundk4lQ0M);
                                resettableRulerScope.size = jMo603getSizeYbymL2g;
                                resettableRulerScope.positionOnScreen = jM847roundk4lQ0M;
                                resettableRulerScope.coordinatesAccessed = false;
                                if (z) {
                                    resetSingleRulerRead(verticalRuler);
                                }
                            } else {
                                objArr5 = objArr;
                                objArr6 = objArr2;
                            }
                            resettableRulerScope.size = jMo603getSizeYbymL2g;
                            resettableRulerScope.positionOnScreen = jM847roundk4lQ0M;
                            resettableRulerScope.coordinatesAccessed = false;
                            if (z) {
                                resetSingleRulerRead(verticalRuler);
                            }
                        } else {
                            jArr3 = jArr;
                            objArr5 = objArr;
                            objArr6 = objArr2;
                            i5 = i2;
                        }
                        j3 >>= i5;
                        i4++;
                        objArr = objArr5;
                        jArr = jArr3;
                        i2 = i5;
                        objArr2 = objArr6;
                    }
                    jArr2 = jArr;
                    objArr3 = objArr;
                    objArr4 = objArr2;
                    if (i3 != i2) {
                        return;
                    }
                } else {
                    jArr2 = jArr;
                    objArr3 = objArr;
                    objArr4 = objArr2;
                }
                if (i != length) {
                    return;
                }
                i++;
                objArr = objArr3;
                i6 = i2;
                jArr = jArr2;
                objArr2 = objArr4;
            }
        } else {
            c = 7;
            j = 128;
        }
        j2 = 255;
        if (resettableRulerScope2 != null) {
            return;
        }
        LayoutCoordinates coordinates3 = getCoordinates();
        jM847roundk4lQ0M = SQLite.m847roundk4lQ0M(coordinates3.mo607localToScreenMKHz9U(0L));
        jMo603getSizeYbymL2g = coordinates3.mo603getSizeYbymL2g();
        if (!IntOffset.m804equalsimpl0(jM847roundk4lQ0M, resettableRulerScope2.positionOnScreen)) {
        }
        objArr = mutableScatterMap.keys;
        objArr2 = mutableScatterMap.values;
        jArr = mutableScatterMap.metadata;
        length = jArr.length - 2;
        if (length >= 0) {
            return;
        }
        i = 0;
        while (true) {
            j3 = jArr[i];
            i2 = i6;
            if ((((~j3) << c) & j3 & j5) != j5) {
                i3 = 8 - ((~(i - length)) >>> 31);
                i4 = 0;
                while (i4 < i3) {
                    if ((j3 & j2) < j) {
                        int i11 = (i << 3) + i4;
                        Object obj2 = objArr[i11];
                        i5 = i2;
                        resettableRulerScope = (ResettableRulerScope) objArr2[i11];
                        verticalRuler = (VerticalRuler) obj2;
                        jArr3 = jArr;
                        if (resettableRulerScope.coordinatesAccessed) {
                            objArr5 = objArr;
                            objArr6 = objArr2;
                            if (IntSize.m810equalsimpl0(resettableRulerScope.size, jMo603getSizeYbymL2g)) {
                            }
                            resettableRulerScope.size = jMo603getSizeYbymL2g;
                            resettableRulerScope.positionOnScreen = jM847roundk4lQ0M;
                            resettableRulerScope.coordinatesAccessed = false;
                            if (z) {
                                resetSingleRulerRead(verticalRuler);
                            }
                        } else {
                            objArr5 = objArr;
                            objArr6 = objArr2;
                        }
                        resettableRulerScope.size = jMo603getSizeYbymL2g;
                        resettableRulerScope.positionOnScreen = jM847roundk4lQ0M;
                        resettableRulerScope.coordinatesAccessed = false;
                        if (z) {
                            resetSingleRulerRead(verticalRuler);
                        }
                    } else {
                        jArr3 = jArr;
                        objArr5 = objArr;
                        objArr6 = objArr2;
                        i5 = i2;
                    }
                    j3 >>= i5;
                    i4++;
                    objArr = objArr5;
                    jArr = jArr3;
                    i2 = i5;
                    objArr2 = objArr6;
                }
                jArr2 = jArr;
                objArr3 = objArr;
                objArr4 = objArr2;
                if (i3 != i2) {
                    return;
                }
            } else {
                jArr2 = jArr;
                objArr3 = objArr;
                objArr4 = objArr2;
            }
            if (i != length) {
                return;
            }
            i++;
            objArr = objArr3;
            i6 = i2;
            jArr = jArr2;
            objArr2 = objArr4;
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        if (!getHasMeasureResult() || (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        boolean z = alignmentLine instanceof VerticalAlignmentLine;
        long j = this.apparentToRealOffset;
        return iCalculateAlignmentLine + ((int) (z ? j >> 32 : 4294967295L & j));
    }

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo654getPositionnOccac();

    public final ResettableRulerScope getRulerScope() {
        ResettableRulerScope resettableRulerScope = this._rulerScope;
        if (resettableRulerScope != null) {
            return resettableRulerScope;
        }
        ResettableRulerScope resettableRulerScope2 = new ResettableRulerScope(null);
        this._rulerScope = resettableRulerScope2;
        return resettableRulerScope2;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return getLayoutNode().isAttached$1();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(final int i, final int i2, final Map map, final Function1 function1, final Function1 function2) {
        if ((i & (-16777216)) != 0 || ((-16777216) & i2) != 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public final Map getAlignmentLines() {
                return map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getHeight() {
                return i2;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final Function1 getRulers() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getWidth() {
                return i;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final void placeChildren() {
                function2.invoke(this.placementScope);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void notifyRulerValueChange(MutableScatterSet mutableScatterSet) {
        LayoutNode layoutNode;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui(false);
                        } else {
                            layoutNode.requestRelayout$ui(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract void replace$ui();

    /* JADX WARN: Code duplicated, block: B:24:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0070 A[LOOP:1: B:13:0x003e->B:25:0x0070, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6 A[LOOP:3: B:33:0x0085->B:43:0x00b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0076 A[EDGE_INSN: B:48:0x0076->B:27:0x0076 BREAK  A[LOOP:1: B:13:0x003e->B:25:0x0070], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00bb A[EDGE_INSN: B:54:0x00bb->B:44:0x00bb BREAK  A[LOOP:3: B:33:0x0085->B:43:0x00b6], SYNTHETIC] */
    public final void resetProvidedRulers() {
        long j;
        MutableObjectList mutableObjectList;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap != null) {
            int i = rulerTrackingMap.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((VerticalRuler[]) rulerTrackingMap.rulers)[i2] = null;
                ((float[]) rulerTrackingMap.values)[i2] = Float.NaN;
                ((byte[]) rulerTrackingMap.accessFlags)[i2] = 0;
            }
            rulerTrackingMap.size = 0;
        }
        MutableScatterMap mutableScatterMap = this._rulerScopes;
        long j2 = 255;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i3 = 0;
                while (true) {
                    long j3 = jArr[i3];
                    j = 128;
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i3 != length) {
                            break;
                            break;
                        }
                        i3++;
                    } else {
                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                        for (int i5 = 0; i5 < i4; i5++) {
                            if ((j3 & 255) < 128 && (mutableObjectList = ((ResettableRulerScope) objArr[(i3 << 3) + i5]).providedRulers) != null) {
                                mutableObjectList.clear();
                            }
                            j3 >>= 8;
                        }
                        if (i4 != 8) {
                            break;
                        } else if (i3 != length) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            } else {
                j = 128;
            }
        } else {
            j = 128;
        }
        MutableScatterMap mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 == null) {
            return;
        }
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr2 = mutableScatterMap2.metadata;
        int length2 = jArr2.length - 2;
        if (length2 >= 0) {
            int i6 = 0;
            while (true) {
                long j4 = jArr2[i6];
                if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length2)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j4 & j2) < j) {
                            notifyRulerValueChange((MutableScatterSet) objArr2[(i6 << 3) + i8]);
                        }
                        j4 >>= 8;
                        i8++;
                        j2 = 255;
                    }
                    if (i7 != 8) {
                        break;
                    }
                    if (i6 != length2) {
                        break;
                    }
                    i6++;
                    j2 = 255;
                } else if (i6 != length2) {
                    break;
                    break;
                } else {
                    i6++;
                    j2 = 255;
                }
            }
        }
        mutableScatterMap2.clear();
    }

    public final void resetSingleRulerRead(VerticalRuler verticalRuler) {
        int iIndexOf;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap != null && (iIndexOf = ArraysKt.indexOf((VerticalRuler[]) rulerTrackingMap.rulers, verticalRuler)) >= 0) {
            VerticalRuler[] verticalRulerArr = (VerticalRuler[]) rulerTrackingMap.rulers;
            int i = iIndexOf + 1;
            ArraysKt.copyInto(iIndexOf, i, rulerTrackingMap.size, verticalRulerArr, verticalRulerArr);
            VerticalRuler[] verticalRulerArr2 = (VerticalRuler[]) rulerTrackingMap.rulers;
            int i2 = rulerTrackingMap.size;
            verticalRulerArr2[i2 - 1] = null;
            float[] fArr = (float[]) rulerTrackingMap.values;
            System.arraycopy(fArr, i, fArr, iIndexOf, i2 - i);
            byte[] bArr = (byte[]) rulerTrackingMap.accessFlags;
            ArraysKt.copyInto(iIndexOf, i, rulerTrackingMap.size, bArr, bArr);
            rulerTrackingMap.size--;
        }
        MutableScatterMap mutableScatterMap = this.rulerReaders;
        MutableScatterSet mutableScatterSet = mutableScatterMap != null ? (MutableScatterSet) mutableScatterMap.get(verticalRuler) : null;
        if (mutableScatterSet != null) {
            notifyRulerValueChange(mutableScatterSet);
            mutableScatterSet.clear();
        }
        MutableScatterMap mutableScatterMap2 = this._rulerScopes;
        ResettableRulerScope resettableRulerScope = mutableScatterMap2 != null ? (ResettableRulerScope) mutableScatterMap2.get(verticalRuler) : null;
        MutableObjectList mutableObjectList = resettableRulerScope != null ? resettableRulerScope.providedRulers : null;
        if (mutableObjectList != null) {
            while (mutableObjectList.isNotEmpty()) {
                resetSingleRulerRead((VerticalRuler) mutableObjectList.removeAt(mutableObjectList._size - 1));
            }
        }
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (Intrinsics.areEqual(layoutNode, getLayoutNode())) {
            this.isPlacedUnderMotionFrameOfReference = z;
            return;
        }
        if ((layoutNode != null ? layoutNode.layoutDelegate.layoutState : null) != LayoutNode.LayoutState.LayingOut) {
            if ((layoutNode != null ? layoutNode.layoutDelegate.layoutState : null) != LayoutNode.LayoutState.LookaheadLayingOut) {
                return;
            }
        }
        this.isPlacedUnderMotionFrameOfReference = z;
    }
}
