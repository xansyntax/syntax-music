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
import androidx.compose.ui.unit.IntSize;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public boolean duringAlignmentLinesQuery;
    public boolean isPlaced;
    public boolean isPlacedByParent;
    public GraphicsLayer lastExplicitLayer;
    public Function1 lastLayerBlock;
    public float lastZIndex;
    public boolean layingOutChildren;
    public final MeasurePassDelegate$$ExternalSyntheticLambda0 layoutChildrenBlock;
    public final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    public boolean layoutPending;
    public boolean layoutPendingForAlignment;
    public boolean measurePending;
    public boolean measuredOnce;
    public boolean needsCoordinatesUpdate;
    public boolean onNodePlacedCalled;
    public Object parentData;
    public final MeasurePassDelegate$$ExternalSyntheticLambda0 performMeasureBlock;
    public final MeasurePassDelegate$$ExternalSyntheticLambda0 placeOuterCoordinatorBlock;
    public GraphicsLayer placeOuterCoordinatorLayer;
    public Function1 placeOuterCoordinatorLayerBlock;
    public float placeOuterCoordinatorZIndex;
    public boolean placedOnce;
    public boolean relayoutWithoutParentInProgress;
    public float zIndex;
    public int previousPlaceOrder = Integer.MAX_VALUE;
    public int placeOrder = Integer.MAX_VALUE;
    public LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    public long lastPosition = 0;
    public boolean parentDataDirty = true;
    public final LookaheadAlignmentLines alignmentLines = new LookaheadAlignmentLines(this, (byte) 1);
    public final MutableVector _childDelegates = new MutableVector(new MeasurePassDelegate[16]);
    public boolean childDelegatesDirty = true;
    public long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
    public long placeOuterCoordinatorPosition = 0;

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0] */
    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
        final byte b = 1;
        final byte b2 = 0;
        this.performMeasureBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ MeasurePassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                MeasurePassDelegate measurePassDelegate = this.f$0;
                switch (b3) {
                    case 0:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo598measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                measurePassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            ((LayoutNode) objArr2[i4]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i5 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i6 = 0; i6 < i5; i6++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i6)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i8 = 0; i8 < i7; i8++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i8)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i9 = mutableVector3.size;
                        for (int i10 = 0; i10 < i9; i10++) {
                            LayoutNode layoutNode2 = (LayoutNode) objArr3[i10];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode2.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode2.getPlaceOrder$ui()) {
                                layoutNode.onZSortedChildrenInvalidated$ui();
                                layoutNode.invalidateLayer$ui();
                                if (layoutNode2.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
                                        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate3.lookaheadPassDelegate;
                                        lookaheadPassDelegate.getClass();
                                        lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i11 = mutableVector4.size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i12]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                        }
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        Placeable.PlacementScope placementScope = nodeCoordinator != null ? nodeCoordinator.placementScope : ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        GraphicsLayer graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
                        if (graphicsLayer != null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator);
                            outerCoordinator.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, graphicsLayer);
                        } else if (function1 == null) {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator2);
                            outerCoordinator2.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, (Function1) null);
                        } else {
                            NodeCoordinator outerCoordinator3 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j3 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f3 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator3);
                            outerCoordinator3.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j3, outerCoordinator3.apparentToRealOffset), f3, function1);
                        }
                        break;
                }
                return unit;
            }
        };
        this.layoutChildrenBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ MeasurePassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                byte b3 = b;
                Unit unit = Unit.INSTANCE;
                MeasurePassDelegate measurePassDelegate = this.f$0;
                switch (b3) {
                    case 0:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo598measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                measurePassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            ((LayoutNode) objArr2[i4]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i5 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i6 = 0; i6 < i5; i6++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i6)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i8 = 0; i8 < i7; i8++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i8)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i9 = mutableVector3.size;
                        for (int i10 = 0; i10 < i9; i10++) {
                            LayoutNode layoutNode2 = (LayoutNode) objArr3[i10];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode2.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode2.getPlaceOrder$ui()) {
                                layoutNode.onZSortedChildrenInvalidated$ui();
                                layoutNode.invalidateLayer$ui();
                                if (layoutNode2.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
                                        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate3.lookaheadPassDelegate;
                                        lookaheadPassDelegate.getClass();
                                        lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i11 = mutableVector4.size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i12]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                        }
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        Placeable.PlacementScope placementScope = nodeCoordinator != null ? nodeCoordinator.placementScope : ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        GraphicsLayer graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
                        if (graphicsLayer != null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator);
                            outerCoordinator.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, graphicsLayer);
                        } else if (function1 == null) {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator2);
                            outerCoordinator2.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, (Function1) null);
                        } else {
                            NodeCoordinator outerCoordinator3 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j3 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f3 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator3);
                            outerCoordinator3.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j3, outerCoordinator3.apparentToRealOffset), f3, function1);
                        }
                        break;
                }
                return unit;
            }
        };
        final byte b3 = 2;
        this.placeOuterCoordinatorBlock = new Function0(this) { // from class: androidx.compose.ui.node.MeasurePassDelegate$$ExternalSyntheticLambda0
            public final /* synthetic */ MeasurePassDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws Throwable {
                byte b4 = b3;
                Unit unit = Unit.INSTANCE;
                MeasurePassDelegate measurePassDelegate = this.f$0;
                switch (b4) {
                    case 0:
                        measurePassDelegate.layoutNodeLayoutDelegate.getOuterCoordinator().mo598measureBRTryo0(measurePassDelegate.performMeasureConstraints);
                        break;
                    case 1:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = measurePassDelegate.layoutNodeLayoutDelegate;
                        layoutNodeLayoutDelegate2.nextChildPlaceOrder = 0;
                        LayoutNode layoutNode = layoutNodeLayoutDelegate2.layoutNode;
                        MutableVector mutableVector = layoutNode.get_children$ui();
                        Object[] objArr = mutableVector.content;
                        int i = mutableVector.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            MeasurePassDelegate measurePassDelegate2 = ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate;
                            measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                            measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                            measurePassDelegate2.isPlacedByParent = false;
                            if (measurePassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                measurePassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                            }
                        }
                        MutableVector mutableVector2 = layoutNode.get_children$ui();
                        Object[] objArr2 = mutableVector2.content;
                        int i3 = mutableVector2.size;
                        for (int i4 = 0; i4 < i3; i4++) {
                            ((LayoutNode) objArr2[i4]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentLayout = false;
                        }
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i5 = ((MutableVector) objectListMutableList.objectList).size;
                            for (int i6 = 0; i6 < i5; i6++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList.get(i6)).nodes.outerCoordinator).isPlacingForAlignment = true;
                            }
                        }
                        measurePassDelegate.getInnerCoordinator().getMeasureResult$ui().placeChildren();
                        if (measurePassDelegate.getInnerCoordinator().isPlacingForAlignment) {
                            MutableObjectList.ObjectListMutableList objectListMutableList2 = (MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui();
                            int i7 = ((MutableVector) objectListMutableList2.objectList).size;
                            for (int i8 = 0; i8 < i7; i8++) {
                                ((NodeCoordinator) ((LayoutNode) objectListMutableList2.get(i8)).nodes.outerCoordinator).isPlacingForAlignment = false;
                            }
                        }
                        MutableVector mutableVector3 = layoutNode.get_children$ui();
                        Object[] objArr3 = mutableVector3.content;
                        int i9 = mutableVector3.size;
                        for (int i10 = 0; i10 < i9; i10++) {
                            LayoutNode layoutNode2 = (LayoutNode) objArr3[i10];
                            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = layoutNode2.layoutDelegate;
                            if (layoutNodeLayoutDelegate3.measurePassDelegate.previousPlaceOrder != layoutNode2.getPlaceOrder$ui()) {
                                layoutNode.onZSortedChildrenInvalidated$ui();
                                layoutNode.invalidateLayer$ui();
                                if (layoutNode2.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                                    if (layoutNodeLayoutDelegate3.detachedFromParentLookaheadPlacement || HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
                                        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate3.lookaheadPassDelegate;
                                        lookaheadPassDelegate.getClass();
                                        lookaheadPassDelegate.markNodeAndSubtreeAsNotPlaced$ui(false);
                                    }
                                    layoutNodeLayoutDelegate3.measurePassDelegate.markSubtreeAsNotPlaced();
                                }
                            }
                        }
                        MutableVector mutableVector4 = layoutNode.get_children$ui();
                        Object[] objArr4 = mutableVector4.content;
                        int i11 = mutableVector4.size;
                        for (int i12 = 0; i12 < i11; i12++) {
                            LookaheadAlignmentLines lookaheadAlignmentLines = ((LayoutNode) objArr4[i12]).layoutDelegate.measurePassDelegate.alignmentLines;
                            lookaheadAlignmentLines.previousUsedDuringParentLayout = lookaheadAlignmentLines.usedDuringParentLayout;
                        }
                        break;
                    default:
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate4 = measurePassDelegate.layoutNodeLayoutDelegate;
                        NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator().wrappedBy;
                        Placeable.PlacementScope placementScope = nodeCoordinator != null ? nodeCoordinator.placementScope : ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate4.layoutNode)).getPlacementScope();
                        Function1 function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                        GraphicsLayer graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
                        if (graphicsLayer != null) {
                            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator);
                            outerCoordinator.mo616placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, graphicsLayer);
                        } else if (function1 == null) {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j2 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f2 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator2);
                            outerCoordinator2.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j2, outerCoordinator2.apparentToRealOffset), f2, (Function1) null);
                        } else {
                            NodeCoordinator outerCoordinator3 = layoutNodeLayoutDelegate4.getOuterCoordinator();
                            long j3 = measurePassDelegate.placeOuterCoordinatorPosition;
                            float f3 = measurePassDelegate.placeOuterCoordinatorZIndex;
                            placementScope.handleMotionFrameOfReferencePlacement(outerCoordinator3);
                            outerCoordinator3.mo602placeAtf8xVGno(IntOffset.m806plusqkQi6aY(j3, outerCoordinator3.apparentToRealOffset), f3, function1);
                        }
                        break;
                }
                return unit;
            }
        };
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void forEachChildAlignmentLinesOwner(TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2) {
        MutableVector mutableVector = this.layoutNodeLayoutDelegate.layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            textKt$$ExternalSyntheticLambda2.invoke(((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int get(AlignmentLine alignmentLine) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        LayoutNode.LayoutState layoutState = parent$ui != null ? parent$ui.layoutDelegate.layoutState : null;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Measuring;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        if (layoutState == layoutState2) {
            lookaheadAlignmentLines.usedDuringParentMeasurement = true;
        } else {
            LayoutNode parent$ui2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.layoutDelegate.layoutState : null) == LayoutNode.LayoutState.LayingOut) {
                lookaheadAlignmentLines.usedDuringParentLayout = true;
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = layoutNodeLayoutDelegate.getOuterCoordinator().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final LookaheadAlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    public final List getChildDelegates$ui() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        layoutNodeLayoutDelegate.layoutNode.updateChildrenIfDirty$ui();
        boolean z = this.childDelegatesDirty;
        MutableVector mutableVector = this._childDelegates;
        if (!z) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector mutableVector2 = layoutNode.get_children$ui();
        Object[] objArr = mutableVector2.content;
        int i = mutableVector2.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (mutableVector.size <= i2) {
                mutableVector.add(layoutNode2.layoutDelegate.measurePassDelegate);
            } else {
                MeasurePassDelegate measurePassDelegate = layoutNode2.layoutDelegate.measurePassDelegate;
                Object[] objArr2 = mutableVector.content;
                Object obj = objArr2[i2];
                objArr2[i2] = measurePassDelegate;
            }
        }
        mutableVector.removeRange(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size, mutableVector.size);
        this.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final InnerNodeCoordinator getInnerCoordinator() {
        return (InnerNodeCoordinator) this.layoutNodeLayoutDelegate.layoutNode.nodes.innerCoordinator;
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredHeight() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Placeable
    public final int getMeasuredWidth() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator().getMeasuredWidth();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        LayoutNode parent$ui = this.layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        if (parent$ui == null || (layoutNodeLayoutDelegate = parent$ui.layoutDelegate) == null) {
            return null;
        }
        return layoutNodeLayoutDelegate.measurePassDelegate;
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
    public final void layoutChildren() throws Throwable {
        boolean zM661remeasureBRTryo0;
        this.layingOutChildren = true;
        LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
        lookaheadAlignmentLines.recalculateQueryOwner();
        boolean z = this.layoutPending;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (z) {
            MutableVector mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i2];
                boolean measurePending$ui = layoutNode.getMeasurePending$ui();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                if (measurePending$ui && layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock) {
                    MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate2.measurePassDelegate;
                    Constraints constraints = measurePassDelegate.measuredOnce ? new Constraints(measurePassDelegate.measurementConstraints) : null;
                    if (constraints != null) {
                        if (layoutNode.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                            layoutNode.clearSubtreeIntrinsicsUsage$ui();
                        }
                        zM661remeasureBRTryo0 = layoutNodeLayoutDelegate2.measurePassDelegate.m661remeasureBRTryo0(constraints.value);
                    } else {
                        zM661remeasureBRTryo0 = false;
                    }
                    if (zM661remeasureBRTryo0) {
                        LayoutNode.requestRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
                    }
                }
            }
        }
        if (this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment && this.layoutPending)) {
            this.layoutPending = false;
            LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
            layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LayingOut;
            layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayout, this.layoutChildrenBlock);
            layoutNodeLayoutDelegate.layoutState = layoutState;
            this.layoutPendingForAlignment = false;
        }
        if (lookaheadAlignmentLines.usedDuringParentLayout) {
            lookaheadAlignmentLines.previousUsedDuringParentLayout = true;
        }
        if (lookaheadAlignmentLines.dirty && lookaheadAlignmentLines.getRequired$ui()) {
            lookaheadAlignmentLines.recalculate();
        }
        this.layingOutChildren = false;
    }

    public final void markNodeAndSubtreeAsPlaced$1() {
        boolean z = this.isPlaced;
        this.isPlaced = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        NodeChain nodeChain = layoutNode.nodes;
        if (!z) {
            ((InnerNodeCoordinator) nodeChain.innerCoordinator).onPlaced();
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().recalculateRectIfDirty(layoutNodeLayoutDelegate.layoutNode);
            if (layoutNode.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(layoutNode, true, 6);
            } else if (layoutNode.layoutDelegate.lookaheadMeasurePending) {
                LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, true, 6);
            }
        }
        NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
        for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            if (nodeCoordinator2.lastLayerDrawingWasSkipped) {
                nodeCoordinator2.invalidateLayer();
            }
        }
        MutableVector mutableVector = layoutNode.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.getPlaceOrder$ui() != Integer.MAX_VALUE) {
                layoutNode2.layoutDelegate.measurePassDelegate.markNodeAndSubtreeAsPlaced$1();
                LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode2);
            }
        }
    }

    public final void markSubtreeAsNotPlaced() {
        if (this.isPlaced) {
            this.isPlaced = false;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getRectManager().remove(layoutNode2);
            NodeChain nodeChain = layoutNode2.nodes;
            NodeCoordinator nodeCoordinator = ((InnerNodeCoordinator) nodeChain.innerCoordinator).wrapped;
            for (NodeCoordinator nodeCoordinator2 = (NodeCoordinator) nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                nodeCoordinator2.onUnplaced();
                nodeCoordinator2.releaseLayer();
            }
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.markSubtreeAsNotPlaced();
            }
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicHeight(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (!HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            onIntrinsicsQueried$1();
            return layoutNodeLayoutDelegate.getOuterCoordinator().maxIntrinsicHeight(i);
        }
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        return lookaheadPassDelegate.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int maxIntrinsicWidth(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (!HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            onIntrinsicsQueried$1();
            return layoutNodeLayoutDelegate.getOuterCoordinator().maxIntrinsicWidth(i);
        }
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        return lookaheadPassDelegate.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public final Placeable mo598measureBRTryo0(long j) throws Throwable {
        LayoutNode.UsageByParent usageByParent;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode.UsageByParent usageByParent2 = layoutNode.intrinsicsUsageByParent;
        LayoutNode.UsageByParent usageByParent3 = LayoutNode.UsageByParent.NotUsed;
        if (usageByParent2 == usageByParent3) {
            layoutNode.clearSubtreeIntrinsicsUsage$ui();
        }
        if (HitTestResultKt.isOutMostLookaheadRoot(layoutNode2)) {
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            lookaheadPassDelegate.getClass();
            lookaheadPassDelegate.measuredByParent = usageByParent3;
            lookaheadPassDelegate.mo598measureBRTryo0(j);
        }
        LayoutNode parent$ui = layoutNode2.getParent$ui();
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (this.measuredByParent != usageByParent3 && !layoutNode2.canMultiMeasure) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int iOrdinal = layoutNodeLayoutDelegate2.layoutState.ordinal();
            if (iOrdinal == 0) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (iOrdinal != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(layoutNodeLayoutDelegate2.layoutState, "Measurable could be only measured from the parent's measure or layout block. Parents state is ");
                    return null;
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.measuredByParent = usageByParent;
        } else {
            this.measuredByParent = usageByParent3;
        }
        m661remeasureBRTryo0(j);
        return this;
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicHeight(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (!HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            onIntrinsicsQueried$1();
            return layoutNodeLayoutDelegate.getOuterCoordinator().minIntrinsicHeight(i);
        }
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        return lookaheadPassDelegate.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public final int minIntrinsicWidth(int i) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (!HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
            onIntrinsicsQueried$1();
            return layoutNodeLayoutDelegate.getOuterCoordinator().minIntrinsicWidth(i);
        }
        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        lookaheadPassDelegate.getClass();
        return lookaheadPassDelegate.minIntrinsicWidth(i);
    }

    public final void onIntrinsicsQueried$1() {
        LayoutNode.UsageByParent usageByParent;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode.requestRemeasure$ui$default(layoutNodeLayoutDelegate.layoutNode, false, 7);
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

    public final void onNodePlaced$ui() throws Throwable {
        this.onNodePlacedCalled = true;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode parent$ui = layoutNodeLayoutDelegate.layoutNode.getParent$ui();
        float f = getInnerCoordinator().zIndex;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        NodeChain nodeChain = layoutNode.nodes;
        NodeCoordinator nodeCoordinator = (NodeCoordinator) nodeChain.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) nodeChain.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            nodeCoordinator.getClass();
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
            f += layoutModifierNodeCoordinator.zIndex;
            nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
        }
        if (f != this.zIndex) {
            this.zIndex = f;
            if (parent$ui != null) {
                parent$ui.onZSortedChildrenInvalidated$ui();
            }
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            }
        }
        if (!getInnerCoordinator().isPlacingForAlignment) {
            boolean z = this.isPlaced;
            if (!z || this.alignmentLines.getQueried$ui()) {
                markNodeAndSubtreeAsPlaced$1();
            }
            if (z) {
                ((InnerNodeCoordinator) layoutNode.nodes.innerCoordinator).onPlaced();
            } else {
                if (parent$ui != null) {
                    parent$ui.invalidateLayer$ui();
                }
                if (this.relayoutWithoutParentInProgress && parent$ui != null) {
                    parent$ui.requestRelayout$ui(false);
                }
            }
        }
        if (parent$ui != null) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui.layoutDelegate;
            if (!this.relayoutWithoutParentInProgress && layoutNodeLayoutDelegate2.layoutState == LayoutNode.LayoutState.LayingOut) {
                if (this.placeOrder != Integer.MAX_VALUE) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                int i = layoutNodeLayoutDelegate2.nextChildPlaceOrder;
                this.placeOrder = i;
                layoutNodeLayoutDelegate2.nextChildPlaceOrder = i + 1;
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo602placeAtf8xVGno(long j, float f, Function1 function1) throws Throwable {
        m660placeSelfMLgxB_4$2(j, f, function1, null);
    }

    /* JADX INFO: renamed from: placeOuterCoordinator-MLgxB_4, reason: not valid java name */
    public final void m659placeOuterCoordinatorMLgxB_4(long j, float f, Function1 function1, GraphicsLayer graphicsLayer) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        if (layoutNode.isDeactivated) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LayingOut;
        this.lastPosition = j;
        this.lastZIndex = f;
        this.lastLayerBlock = function1;
        this.lastExplicitLayer = graphicsLayer;
        this.onNodePlacedCalled = false;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
        if (this.layoutPending || !this.isPlaced) {
            this.alignmentLines.usedByModifierLayout = false;
            layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = function1;
            this.placeOuterCoordinatorPosition = j;
            this.placeOuterCoordinatorZIndex = f;
            this.placeOuterCoordinatorLayer = graphicsLayer;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) ownerRequireOwner).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingLayoutModifier, this.placeOuterCoordinatorBlock);
        } else {
            NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator();
            outerCoordinator.m673placeSelfMLgxB_4(IntOffset.m806plusqkQi6aY(j, outerCoordinator.apparentToRealOffset), f, function1, graphicsLayer);
            onNodePlaced$ui();
        }
        layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.Idle;
        if (layoutNodeLayoutDelegate.getOuterCoordinator().isPlacingForAlignment && (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement)) {
            requestLayout();
        }
        this.placedOnce = true;
    }

    /* JADX INFO: renamed from: placeSelf-MLgxB_4$2, reason: not valid java name */
    public final void m660placeSelfMLgxB_4$2(long j, float f, Function1 function1, GraphicsLayer graphicsLayer) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            this.isPlacedByParent = true;
            if (!IntOffset.m804equalsimpl0(j, this.lastPosition) || function1 != this.lastLayerBlock || this.needsCoordinatesUpdate) {
                if (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement || this.needsCoordinatesUpdate) {
                    this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }
            }
            LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = lookaheadPassDelegate.layoutNodeLayoutDelegate;
                if (lookaheadPassDelegate._placedState == LookaheadPassDelegate.PlacedState.IsNotPlaced && !HitTestResultKt.isOutMostLookaheadRoot(layoutNodeLayoutDelegate2.layoutNode)) {
                    layoutNodeLayoutDelegate2.detachedFromParentLookaheadPlacement = true;
                }
            }
            LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate2 != null && lookaheadPassDelegate2.getNeedsToBePlacedInApproach()) {
                NodeCoordinator nodeCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator().wrappedBy;
                Placeable.PlacementScope placementScope = nodeCoordinator != null ? nodeCoordinator.placementScope : ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getPlacementScope();
                LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                lookaheadPassDelegate3.getClass();
                LayoutNode parent$ui = layoutNode2.getParent$ui();
                if (parent$ui != null) {
                    parent$ui.layoutDelegate.nextChildLookaheadPlaceOrder = 0;
                }
                lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
                placementScope.place(lookaheadPassDelegate3, (int) (j >> 32), (int) (4294967295L & j), CropImageView.DEFAULT_ASPECT_RATIO);
            }
            LookaheadPassDelegate lookaheadPassDelegate4 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate4 != null && !lookaheadPassDelegate4.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            m659placeOuterCoordinatorMLgxB_4(j, f, function1, graphicsLayer);
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m661remeasureBRTryo0(long j) throws Throwable {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        try {
            if (layoutNode.isDeactivated) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(layoutNode2);
            LayoutNode parent$ui = layoutNode2.getParent$ui();
            boolean z = true;
            layoutNode2.canMultiMeasure = layoutNode2.canMultiMeasure || (parent$ui != null && parent$ui.canMultiMeasure);
            if (!layoutNode2.getMeasurePending$ui() && Constraints.m778equalsimpl0(this.measurementConstraints, j)) {
                ((AndroidComposeView) ownerRequireOwner).forceMeasureTheSubtree(layoutNode2, false);
                layoutNode2.resetSubtreeIntrinsicsUsage$ui();
                return false;
            }
            this.alignmentLines.usedByModifierMeasurement = false;
            MutableVector mutableVector = layoutNode2.get_children$ui();
            Object[] objArr = mutableVector.content;
            int i = mutableVector.size;
            for (int i2 = 0; i2 < i; i2++) {
                ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.alignmentLines.usedDuringParentMeasurement = false;
            }
            this.measuredOnce = true;
            long j2 = layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize;
            m618setMeasurementConstraintsBRTryo0(j);
            LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
            LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
            if (layoutState != layoutState2) {
                InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
            }
            this.performMeasureConstraints = j;
            LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
            layoutNodeLayoutDelegate.layoutState = layoutState3;
            this.measurePending = false;
            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode2)).getSnapshotObserver();
            snapshotObserver.observer.observeReads(layoutNode2, snapshotObserver.onCommitAffectingMeasure, this.performMeasureBlock);
            if (layoutNodeLayoutDelegate.layoutState == layoutState3) {
                this.layoutPending = true;
                this.layoutPendingForAlignment = true;
                layoutNodeLayoutDelegate.layoutState = layoutState2;
            }
            if (IntSize.m810equalsimpl0(layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize, j2) && layoutNodeLayoutDelegate.getOuterCoordinator().width == this.width && layoutNodeLayoutDelegate.getOuterCoordinator().height == this.height) {
                z = false;
            }
            m617setMeasuredSizeozmzZPI((((long) layoutNodeLayoutDelegate.getOuterCoordinator().height) & 4294967295L) | (((long) layoutNodeLayoutDelegate.getOuterCoordinator().width) << 32));
            return z;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw null;
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestLayout() {
        this.layoutNodeLayoutDelegate.layoutNode.requestRelayout$ui(false);
    }

    public final void requestLayoutIfCoordinatesAreUsedAndNotifyChildren() {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
        if (!layoutNode.isPlaced() || layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement <= 0) {
            return;
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode2.layoutDelegate;
        if ((layoutNodeLayoutDelegate2.coordinatesAccessedDuringPlacement || layoutNodeLayoutDelegate2.coordinatesAccessedDuringModifierPlacement) && !layoutNodeLayoutDelegate2.measurePassDelegate.layoutPending) {
            layoutNode2.requestRelayout$ui(false);
        }
        MutableVector mutableVector = layoutNode2.get_children$ui();
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((LayoutNode) objArr[i2]).layoutDelegate.measurePassDelegate.requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public final void requestMeasure() {
        LayoutNode.requestRemeasure$ui$default(this.layoutNodeLayoutDelegate.layoutNode, false, 7);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public final void updatePlacedUnderMotionFrameOfReference(boolean z) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNodeLayoutDelegate;
        if (z != layoutNodeLayoutDelegate.getOuterCoordinator().isPlacedUnderMotionFrameOfReference) {
            layoutNodeLayoutDelegate.getOuterCoordinator().isPlacedUnderMotionFrameOfReference = z;
            this.needsCoordinatesUpdate = true;
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public final void mo616placeAtf8xVGno(long j, float f, GraphicsLayer graphicsLayer) throws Throwable {
        m660placeSelfMLgxB_4$2(j, f, null, graphicsLayer);
    }
}
