package androidx.compose.ui.node;

import androidx.collection.MutableObjectList;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public boolean duringAlignmentLinesQuery;
    public GraphicsLayer lastExplicitLayer;
    public Function1 lastLayerBlock;
    public boolean layingOutChildren;
    public final LookaheadPassDelegate$$ExternalSyntheticLambda0 layoutChildrenBlock;
    public final LookaheadPassDelegate$$ExternalSyntheticLambda0 layoutModifierBlock;
    public final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    public Constraints lookaheadConstraints;
    public boolean measuredOnce;
    public boolean onNodePlacedCalled;
    public Object parentData;
    public final LookaheadPassDelegate$$ExternalSyntheticLambda0 performMeasureBlock;
    public boolean placedOnce;
    public boolean relayoutWithoutParentInProgress;
    public int previousPlaceOrder = Integer.MAX_VALUE;
    public int placeOrder = Integer.MAX_VALUE;
    public LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    public long lastPosition = 0;
    public PlacedState _placedState = PlacedState.IsNotPlaced;
    public final LookaheadAlignmentLines alignmentLines = new LookaheadAlignmentLines(this, (byte) 0);
    public final MutableVector _childDelegates = new MutableVector(new LookaheadPassDelegate[16]);
    public boolean childDelegatesDirty = true;
    public boolean parentDataDirty = true;
    public long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlacedState {
        public static final /* synthetic */ PlacedState[] $VALUES;
        public static final PlacedState IsNotPlaced;
        public static final PlacedState IsPlacedInApproach;
        public static final PlacedState IsPlacedInLookahead;

        static {
            PlacedState placedState = new PlacedState("IsPlacedInLookahead", 0);
            IsPlacedInLookahead = placedState;
            PlacedState placedState2 = new PlacedState("IsPlacedInApproach", 1);
            IsPlacedInApproach = placedState2;
            PlacedState placedState3 = new PlacedState("IsNotPlaced", 2);
            IsNotPlaced = placedState3;
            $VALUES = new PlacedState[]{placedState, placedState2, placedState3};
        }

        public static PlacedState valueOf(String str) {
            return (PlacedState) Enum.valueOf(PlacedState.class, str);
        }

        public static PlacedState[] values() {
            return (PlacedState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0] */
    public LookaheadPassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
        final byte b = 0;
        final byte b2 = 1;
        this.layoutChildrenBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ LookaheadPassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                byte b3 = b;
                Unit unit = Unit.INSTANCE;
                MutableObjectList mutableObjectList = null;
                placementScope = null;
                placementScope = null;
                Placeable.PlacementScope placementScope = null;
                LookaheadPassDelegate lookaheadPassDelegate = this.f$0;
                switch (b3) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.getClass();
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                lookaheadPassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr2[i4]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate3.getClass();
                            lookaheadPassDelegate3.alignmentLines.usedDuringParentLayout = false;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected lookahead delegate");
                            return null;
                        }
                        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i5 = ((MutableVector) objectListMutableList.objectList).size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i6);
                            LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) layoutNode2.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate2 != null) {
                                if (lookaheadDelegate2.isPlacingForAlignment) {
                                    if (mutableObjectList == null) {
                                        mutableObjectList = new MutableObjectList();
                                    }
                                    mutableObjectList.add(layoutNode2);
                                }
                                lookaheadDelegate2.isPlacingForAlignment = lookaheadDelegateImpl.isPlacingForAlignment;
                            }
                        }
                        lookaheadDelegateImpl.getMeasureResult$ui().placeChildren();
                        MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i7) {
                                MutableVector mutableVector3 = layoutNode.get_children$ui();
                                Object[] objArr3 = mutableVector3.content;
                                int i9 = mutableVector3.size;
                                for (int i10 = 0; i10 < i9; i10++) {
                                    LookaheadPassDelegate lookaheadPassDelegate4 = ((LayoutNode) objArr3[i10]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate4.getClass();
                                    int i11 = lookaheadPassDelegate4.previousPlaceOrder;
                                    int i12 = lookaheadPassDelegate4.placeOrder;
                                    if (i11 != i12 && i12 == Integer.MAX_VALUE) {
                                        lookaheadPassDelegate4.markNodeAndSubtreeAsNotPlaced$ui(true);
                                    }
                                }
                                MutableVector mutableVector4 = layoutNode.get_children$ui();
                                Object[] objArr4 = mutableVector4.content;
                                int i13 = mutableVector4.size;
                                for (int i14 = 0; i14 < i13; i14++) {
                                    LookaheadPassDelegate lookaheadPassDelegate5 = ((LayoutNode) objArr4[i14]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate5.getClass();
                                    LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate5.alignmentLines;
                                    lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                                }
                                return unit;
                            }
                            LayoutNode layoutNode3 = (LayoutNode) objectListMutableList2.get(i8);
                            boolean z = mutableObjectList != null && mutableObjectList.contains(layoutNode3);
                            LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) layoutNode3.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate3 != null) {
                                lookaheadDelegate3.isPlacingForAlignment = z;
                            }
                            i8++;
                        }
                        break;
                    case 1:
                        LookaheadDelegate lookaheadDelegate4 = lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate4.getClass();
                        lookaheadDelegate4.mo598measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        return unit;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        LookaheadDelegate lookaheadDelegate5 = layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate5.getClass();
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, lookaheadDelegate5, lookaheadPassDelegate.lastPosition);
                        return unit;
                }
            }
        };
        this.parentData = layoutNodeLayoutDelegate.measurePassDelegate.parentData;
        this.performMeasureBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ LookaheadPassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                MutableObjectList mutableObjectList = null;
                placementScope = null;
                placementScope = null;
                Placeable.PlacementScope placementScope = null;
                LookaheadPassDelegate lookaheadPassDelegate = this.f$0;
                switch (b3) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.getClass();
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                lookaheadPassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr2[i4]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate3.getClass();
                            lookaheadPassDelegate3.alignmentLines.usedDuringParentLayout = false;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected lookahead delegate");
                            return null;
                        }
                        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i5 = ((MutableVector) objectListMutableList.objectList).size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i6);
                            LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) layoutNode2.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate2 != null) {
                                if (lookaheadDelegate2.isPlacingForAlignment) {
                                    if (mutableObjectList == null) {
                                        mutableObjectList = new MutableObjectList();
                                    }
                                    mutableObjectList.add(layoutNode2);
                                }
                                lookaheadDelegate2.isPlacingForAlignment = lookaheadDelegateImpl.isPlacingForAlignment;
                            }
                        }
                        lookaheadDelegateImpl.getMeasureResult$ui().placeChildren();
                        MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i7) {
                                MutableVector mutableVector3 = layoutNode.get_children$ui();
                                Object[] objArr3 = mutableVector3.content;
                                int i9 = mutableVector3.size;
                                for (int i10 = 0; i10 < i9; i10++) {
                                    LookaheadPassDelegate lookaheadPassDelegate4 = ((LayoutNode) objArr3[i10]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate4.getClass();
                                    int i11 = lookaheadPassDelegate4.previousPlaceOrder;
                                    int i12 = lookaheadPassDelegate4.placeOrder;
                                    if (i11 != i12 && i12 == Integer.MAX_VALUE) {
                                        lookaheadPassDelegate4.markNodeAndSubtreeAsNotPlaced$ui(true);
                                    }
                                }
                                MutableVector mutableVector4 = layoutNode.get_children$ui();
                                Object[] objArr4 = mutableVector4.content;
                                int i13 = mutableVector4.size;
                                for (int i14 = 0; i14 < i13; i14++) {
                                    LookaheadPassDelegate lookaheadPassDelegate5 = ((LayoutNode) objArr4[i14]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate5.getClass();
                                    LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate5.alignmentLines;
                                    lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                                }
                                return unit;
                            }
                            LayoutNode layoutNode3 = (LayoutNode) objectListMutableList2.get(i8);
                            boolean z = mutableObjectList != null && mutableObjectList.contains(layoutNode3);
                            LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) layoutNode3.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate3 != null) {
                                lookaheadDelegate3.isPlacingForAlignment = z;
                            }
                            i8++;
                        }
                        break;
                    case 1:
                        LookaheadDelegate lookaheadDelegate4 = lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate4.getClass();
                        lookaheadDelegate4.mo598measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        return unit;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        LookaheadDelegate lookaheadDelegate5 = layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate5.getClass();
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, lookaheadDelegate5, lookaheadPassDelegate.lastPosition);
                        return unit;
                }
            }
        };
        final byte b3 = 2;
        this.layoutModifierBlock = new Function0(this) { // from class: androidx.compose.ui.node.LookaheadPassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ LookaheadPassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LookaheadDelegate lookaheadDelegate;
                byte b4 = b3;
                Unit unit = Unit.INSTANCE;
                MutableObjectList mutableObjectList = null;
                placementScope = null;
                placementScope = null;
                Placeable.PlacementScope placementScope = null;
                LookaheadPassDelegate lookaheadPassDelegate = this.f$0;
                switch (b4) {
                    case 0:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            LookaheadPassDelegate lookaheadPassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate2.getClass();
                            lookaheadPassDelegate2.previousPlaceOrder = lookaheadPassDelegate2.placeOrder;
                            lookaheadPassDelegate2.placeOrder = Integer.MAX_VALUE;
                            if (lookaheadPassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                lookaheadPassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            LookaheadPassDelegate lookaheadPassDelegate3 = ((LayoutNode) objArr2[i4]).layoutDelegate.lookaheadPassDelegate;
                            lookaheadPassDelegate3.getClass();
                            lookaheadPassDelegate3.alignmentLines.usedDuringParentLayout = false;
                        }
                        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
                        if (lookaheadDelegateImpl == null) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected lookahead delegate");
                            return null;
                        }
                        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i5 = ((MutableVector) objectListMutableList.objectList).size;
                        for (int i6 = 0; i6 < i5; i6++) {
                            LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i6);
                            LookaheadDelegate lookaheadDelegate2 = ((NodeCoordinator) layoutNode2.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate2 != null) {
                                if (lookaheadDelegate2.isPlacingForAlignment) {
                                    if (mutableObjectList == null) {
                                        mutableObjectList = new MutableObjectList();
                                    }
                                    mutableObjectList.add(layoutNode2);
                                }
                                lookaheadDelegate2.isPlacingForAlignment = lookaheadDelegateImpl.isPlacingForAlignment;
                            }
                        }
                        lookaheadDelegateImpl.getMeasureResult$ui().placeChildren();
                        MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                        int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= i7) {
                                MutableVector mutableVector3 = layoutNode.get_children$ui();
                                Object[] objArr3 = mutableVector3.content;
                                int i9 = mutableVector3.size;
                                for (int i10 = 0; i10 < i9; i10++) {
                                    LookaheadPassDelegate lookaheadPassDelegate4 = ((LayoutNode) objArr3[i10]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate4.getClass();
                                    int i11 = lookaheadPassDelegate4.previousPlaceOrder;
                                    int i12 = lookaheadPassDelegate4.placeOrder;
                                    if (i11 != i12 && i12 == Integer.MAX_VALUE) {
                                        lookaheadPassDelegate4.markNodeAndSubtreeAsNotPlaced$ui(true);
                                    }
                                }
                                MutableVector mutableVector4 = layoutNode.get_children$ui();
                                Object[] objArr4 = mutableVector4.content;
                                int i13 = mutableVector4.size;
                                for (int i14 = 0; i14 < i13; i14++) {
                                    LookaheadPassDelegate lookaheadPassDelegate5 = ((LayoutNode) objArr4[i14]).layoutDelegate.lookaheadPassDelegate;
                                    lookaheadPassDelegate5.getClass();
                                    LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate5.alignmentLines;
                                    lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                                }
                                return unit;
                            }
                            LayoutNode layoutNode3 = (LayoutNode) objectListMutableList2.get(i8);
                            boolean z = mutableObjectList != null && mutableObjectList.contains(layoutNode3);
                            LookaheadDelegate lookaheadDelegate3 = ((NodeCoordinator) layoutNode3.nodes.outerCoordinator).getLookaheadDelegate();
                            if (lookaheadDelegate3 != null) {
                                lookaheadDelegate3.isPlacingForAlignment = z;
                            }
                            i8++;
                        }
                        break;
                    case 1:
                        LookaheadDelegate lookaheadDelegate4 = lookaheadPassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate4.getClass();
                        lookaheadDelegate4.mo598measureBRTryo0(lookaheadPassDelegate.performMeasureConstraints);
                        return unit;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate3.layoutNode) || layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement) {
                            NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator != null) {
                                placementScope = nodeCoordinator.placementScope;
                            }
                        } else {
                            NodeCoordinator nodeCoordinator2 = layoutNodeLayoutDelegate3.getOuterCoordinator().wrappedBy;
                            if (nodeCoordinator2 != null && (lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.placementScope;
                            }
                        }
                        if (placementScope == null) {
                            placementScope = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate3.layoutNode)).getPlacementScope();
                        }
                        LookaheadDelegate lookaheadDelegate5 = layoutNodeLayoutDelegate3.getOuterCoordinator().getLookaheadDelegate();
                        lookaheadDelegate5.getClass();
                        Placeable.PlacementScope.m619place70tqf50$default(placementScope, lookaheadDelegate5, lookaheadPassDelegate.lastPosition);
                        return unit;
                }
            }
        };
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void forEachChildAlignmentLinesOwner(TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        MutableVector mutableVector = this.layoutNodeLayoutDelegate.layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LookaheadPassDelegate lookaheadPassDelegate = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            textKt$$ExternalSyntheticLambda2.invoke(lookaheadPassDelegate);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        LayoutNode.LayoutState layoutState = parent$ui != null ? parent$ui.layoutDelegate.layoutState : null;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.LookaheadMeasuring;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        if (layoutState == layoutState2) {
            lookaheadAlignmentLines.usedDuringParentMeasurement = true;
        } else {
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                lookaheadAlignmentLines.usedDuringParentLayout = true;
            }
        }
        this.duringAlignmentLinesQuery = true;
        LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        int i = lookaheadDelegate.get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final LookaheadAlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final InnerNodeCoordinator getInnerCoordinator() {
        return (InnerNodeCoordinator) this.layoutNodeLayoutDelegate.layoutNode.nodes.innerCoordinator;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredHeight() {
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredWidth() {
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.getMeasuredWidth();
    }

    public final boolean getNeedsToBePlacedInApproach() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        return HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode) || layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        LayoutNode parent$ui = this.layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        if (parent$ui == null || (layoutNodeLayoutDelegate = parent$ui.layoutDelegate) == null) {
            return null;
        }
        return layoutNodeLayoutDelegate.lookaheadPassDelegate;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measurable
    public final Object getParentData() {
        return this.parentData;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void layoutChildren() {
        this.layingOutChildren = true;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        lookaheadAlignmentLines.recalculateQueryOwner();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        boolean z = layoutNodeLayoutDelegate.lookaheadLayoutPending;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        if (z) {
            MutableVector mutableVector = layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode2.layoutDelegate;
                if (layoutNodeLayoutDelegate2.lookaheadMeasurePending && layoutNode2.getMeasuredByParentInLookahead$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                    LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate2.lookaheadPassDelegate;
                    lookaheadPassDelegate.getClass();
                    LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate2.lookaheadPassDelegate;
                    Constraints constraints = lookaheadPassDelegate2 != null ? lookaheadPassDelegate2.lookaheadConstraints : null;
                    constraints.getClass();
                    if (lookaheadPassDelegate.m658remeasureBRTryo0(constraints.value)) {
                        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, false, 7);
                    }
                }
            }
        }
        InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = getInnerCoordinator().lookaheadDelegate;
        lookaheadDelegateImpl.getClass();
        if (layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegateImpl.isPlacingForAlignment && layoutNodeLayoutDelegate.lookaheadLayoutPending)) {
            layoutNodeLayoutDelegate.lookaheadLayoutPending = false;
            LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
            layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode, snapshotObserver.onCommitAffectingLookahead, this.layoutChildrenBlock);
            layoutNodeLayoutDelegate.layoutState = layoutState;
            if (layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringPlacement && lookaheadDelegateImpl.isPlacingForAlignment) {
                requestLayout();
            }
            layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = false;
        }
        if (lookaheadAlignmentLines.usedDuringParentLayout) {
            lookaheadAlignmentLines.previousUsedDuringParentLayout = true;
        }
        if (lookaheadAlignmentLines.dirty && lookaheadAlignmentLines.getRequired$ui()) {
            lookaheadAlignmentLines.recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markNodeAndSubtreeAsNotPlaced$ui(boolean z) {
        if (z && getNeedsToBePlacedInApproach()) {
            return;
        }
        if (z || getNeedsToBePlacedInApproach()) {
            this._placedState = PlacedState.IsNotPlaced;
            MutableVector mutableVector = this.layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LookaheadPassDelegate lookaheadPassDelegate = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate.getClass();
                lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(true);
            }
        }
    }

    public final void markNodeAndSubtreeAsPlaced() {
        PlacedState placedState = this._placedState;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        boolean z = layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        PlacedState placedState2 = PlacedState.IsPlacedInLookahead;
        if (z) {
            this._placedState = PlacedState.IsPlacedInApproach;
        } else {
            this._placedState = placedState2;
        }
        if (placedState != placedState2 && layoutNodeLayoutDelegate.lookaheadMeasurePending) {
            LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
        }
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.layoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
                return;
            }
            if (lookaheadPassDelegate.placeOrder != Integer.MAX_VALUE) {
                lookaheadPassDelegate.markNodeAndSubtreeAsPlaced();
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode2);
            }
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.maxIntrinsicWidth(i);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo598measureBRTryo0(long j) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if ((parent$ui != null ? parent$ui.layoutDelegate.layoutState : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
            layoutNodeLayoutDelegate.detachedFromParentLookaheadPass = false;
        } else {
            LayoutNode parent$ui2 = layoutNode2.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                layoutNodeLayoutDelegate.detachedFromParentLookaheadPass = false;
            }
        }
        LayoutNode parent$ui3 = layoutNode2.getParent$ui();
        LayoutNode.UsageByParent usageByParent2 = LayoutNode.UsageByParent.NotUsed;
        if (parent$ui3 != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui3.layoutDelegate;
            if (this.measuredByParent != usageByParent2 && !layoutNode2.canMultiMeasure) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = layoutNodeLayoutDelegate2.layoutState.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(layoutNodeLayoutDelegate2.layoutState, "Measurable could be only measured from the parent's measure or layout block. Parents state is ");
                    return null;
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.measuredByParent = usageByParent;
        } else {
            this.measuredByParent = usageByParent2;
        }
        if (layoutNode2.intrinsicsUsageByParent == usageByParent2) {
            layoutNode2.clearSubtreeIntrinsicsUsage$ui();
        }
        m658remeasureBRTryo0(j);
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        onIntrinsicsQueried();
        LookaheadDelegate lookaheadDelegate = this.layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        lookaheadDelegate.getClass();
        return lookaheadDelegate.minIntrinsicWidth(i);
    }

    public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (layoutNodeLayoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement > 0) {
            MutableVector mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i2];
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                if ((layoutNodeLayoutDelegate2.lookaheadCoordinatesAccessedDuringPlacement || layoutNodeLayoutDelegate2.lookaheadCoordinatesAccessedDuringModifierPlacement) && !layoutNodeLayoutDelegate2.lookaheadLayoutPending) {
                    layoutNode.requestLookaheadRelayout$ui(false);
                }
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate2.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
            }
        }
    }

    public final void onIntrinsicsQueried() {
        LayoutNode.UsageByParent usageByParent;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode.requestLookaheadRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode parent$ui = layoutNode.getParent$ui();
        if (parent$ui == null || layoutNode.intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        int iOrdinal = parent$ui.layoutDelegate.layoutState.ordinal();
        if (iOrdinal != 0) {
            usageByParent = iOrdinal != 2 ? parent$ui.intrinsicsUsageByParent : LayoutNode.UsageByParent.InLayoutBlock;
        } else {
            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        }
        layoutNode.intrinsicsUsageByParent = usageByParent;
    }

    public final void onNodePlaced$ui() {
        LayoutNode.LayoutState layoutState;
        this.onNodePlacedCalled = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        PlacedState placedState = this._placedState;
        if ((placedState != PlacedState.IsPlacedInLookahead && !layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement) || (placedState != PlacedState.IsPlacedInApproach && layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement)) {
            markNodeAndSubtreeAsPlaced();
            if (this.relayoutWithoutParentInProgress && parent$ui != null) {
                parent$ui.requestLookaheadRelayout$ui(false);
            }
        }
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (!this.relayoutWithoutParentInProgress && ((layoutState = layoutNodeLayoutDelegate2.layoutState) == LayoutNode.LayoutState.LayingOut || layoutState == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (this.placeOrder != Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                int i = layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder;
                this.placeOrder = i;
                layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = i + 1;
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo602placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        m657placeSelfMLgxB_4$1(j, null, function1);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006f A[Catch: all -> 0x001b, TryCatch #0 {all -> 0x001b, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0013, B:9:0x0018, B:12:0x001e, B:14:0x0022, B:15:0x0027, B:17:0x0036, B:19:0x003a, B:22:0x0040, B:21:0x003e, B:23:0x0043, B:25:0x004d, B:30:0x0057, B:32:0x0085, B:31:0x006f), top: B:36:0x0007 }] */
    /* JADX INFO: renamed from: placeSelf-MLgxB_4$1, reason: not valid java name */
    public final void m657placeSelfMLgxB_4$1(long j, GraphicsLayer graphicsLayer, Function1 function1) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            LayoutNode parent$ui = layoutNode.getParent$ui();
            LayoutNode.LayoutState layoutState = parent$ui != null ? parent$ui.layoutDelegate.layoutState : null;
            LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.LookaheadLayingOut;
            if (layoutState == layoutState2) {
                layoutNodeLayoutDelegate.detachedFromParentLookaheadPlacement = false;
            }
            if (layoutNode2.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            layoutNodeLayoutDelegate.layoutState = layoutState2;
            boolean z = true;
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            if (!IntOffset.m804equalsimpl0(j, this.lastPosition)) {
                if (layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.lookaheadCoordinatesAccessedDuringPlacement) {
                    layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                }
                notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
            this.lastPosition = j;
            if (layoutNodeLayoutDelegate.lookaheadLayoutPending) {
                layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                this.alignmentLines.usedByModifierLayout = false;
                OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
                snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayoutModifierInLookahead, this.layoutModifierBlock);
            } else {
                if (this._placedState == PlacedState.IsNotPlaced) {
                    z = false;
                }
                if (z) {
                    LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
                    lookaheadDelegate.getClass();
                    lookaheadDelegate.m655placeSelfgyyYBs(IntOffset.m806plusqkQi6aY(j, lookaheadDelegate.apparentToRealOffset));
                    onNodePlaced$ui();
                } else {
                    layoutNodeLayoutDelegate.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                    this.alignmentLines.usedByModifierLayout = false;
                    OwnerSnapshotObserver snapshotObserver2 = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
                    snapshotObserver2.observer.observeReads(layoutNode2, snapshotObserver2.onCommitAffectingLayoutModifierInLookahead, this.layoutModifierBlock);
                }
            }
            this.lastLayerBlock = function1;
            this.lastExplicitLayer = graphicsLayer;
            layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.Idle;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m658remeasureBRTryo0(long j) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            if (layoutNode.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            LayoutNode parent$ui = layoutNode2.getParent$ui();
            layoutNode2.canMultiMeasure = layoutNode2.canMultiMeasure || (parent$ui != null && parent$ui.canMultiMeasure);
            if (!layoutNode2.layoutDelegate.lookaheadMeasurePending) {
                Constraints constraints = this.lookaheadConstraints;
                if (constraints == null ? false : Constraints.m778equalsimpl0(constraints.value, j)) {
                    Owner owner = layoutNode2.owner;
                    if (owner != null) {
                        ((AndroidComposeView) owner).forceMeasureTheSubtree(layoutNode2, true);
                    }
                    layoutNode2.resetSubtreeIntrinsicsUsage$ui();
                    return false;
                }
            }
            this.lookaheadConstraints = new Constraints(j);
            m618setMeasurementConstraintsBRTryo0(j);
            this.alignmentLines.usedByModifierMeasurement = false;
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LookaheadPassDelegate lookaheadPassDelegate = ((LayoutNode) objArr[i2]).layoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate.getClass();
                lookaheadPassDelegate.alignmentLines.usedDuringParentMeasurement = false;
            }
            long j2 = this.measuredOnce ? this.measuredSize : -9223372034707292160L;
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate == null) {
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }
            layoutNodeLayoutDelegate.m652performLookaheadMeasureBRTryo0$ui(j);
            m617setMeasuredSizeozmzZPI((((long) lookaheadDelegate.width) << 32) | (((long) lookaheadDelegate.height) & 4294967295L));
            return (((int) (j2 >> 32)) == lookaheadDelegate.width && ((int) (j2 & 4294967295L)) == lookaheadDelegate.height) ? false : true;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestLayout() {
        this.layoutNodeLayoutDelegate.layoutNode.requestLookaheadRelayout$ui(false);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestMeasure() {
        LayoutNode.requestLookaheadRemeasure$ui$default(this.layoutNodeLayoutDelegate.layoutNode, false, 7);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LookaheadDelegate lookaheadDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LookaheadDelegate lookaheadDelegate2 = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        if (Boolean.valueOf(z).equals(lookaheadDelegate2 != null ? Boolean.valueOf(lookaheadDelegate2.isPlacedUnderMotionFrameOfReference) : null) || (lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate()) == null) {
            return;
        }
        lookaheadDelegate.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo616placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) throws Throwable {
        m657placeSelfMLgxB_4$1(j, graphicsLayer, null);
    }
}
