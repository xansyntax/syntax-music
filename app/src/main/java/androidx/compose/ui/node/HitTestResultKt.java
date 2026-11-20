package androidx.compose.ui.node;

import android.view.View;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.spatial.RectManager;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeTraversableNodeKeys;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class HitTestResultKt {
    public static final DepthSortedSetKt$DepthComparator$1 DepthComparator = new DepthSortedSetKt$DepthComparator$1(0);

    public static final long DistanceAndFlags(float f, boolean z, boolean z2) {
        return (((z ? 1L : 0L) | (z2 ? 2L : 0L)) & 4294967295L) | (((long) Float.floatToRawIntBits(f)) << 32);
    }

    public static final void addLayoutNodeChildren(MutableVector mutableVector, Modifier.Node node) {
        MutableVector mutableVector2 = requireLayoutNode(node).get_children$ui();
        int i = mutableVector2.size - 1;
        Object[] objArr = mutableVector2.content;
        if (i < objArr.length) {
            while (i >= 0) {
                mutableVector.add((Modifier.Node) ((LayoutNode) objArr[i]).nodes.head);
                i--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((node.kindSet & 2) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node node2 = ((DelegatingNode) node).delegate;
                while (node2 != 0) {
                    if (node2 instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) node2;
                    }
                    node2 = (!(node2 instanceof DelegatingNode) || (node2.kindSet & 2) == 0) ? node2.child : ((DelegatingNode) node2).delegate;
                }
            }
        }
        return null;
    }

    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (child == null) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = (Integer) lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
        } else {
            int i = child.get(alignmentLine);
            if (i != Integer.MIN_VALUE) {
                boolean z = lookaheadCapablePlaceable.isShallowPlacing;
                boolean z2 = lookaheadCapablePlaceable.isPlacingForAlignment;
                child.isShallowPlacing = true;
                lookaheadCapablePlaceable.isPlacingForAlignment = true;
                lookaheadCapablePlaceable.replace$ui();
                child.isShallowPlacing = z;
                lookaheadCapablePlaceable.isPlacingForAlignment = z2;
                return i + ((int) (alignmentLine instanceof HorizontalAlignmentLine ? child.mo654getPositionnOccac() & 4294967295L : child.mo654getPositionnOccac() >> 32));
            }
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: compareTo-9YPOF3E, reason: not valid java name */
    public static final int m641compareTo9YPOF3E(long j, long j2) {
        boolean zM644isInLayerimpl = m644isInLayerimpl(j);
        if (zM644isInLayerimpl != m644isInLayerimpl(j2)) {
            return zM644isInLayerimpl ? -1 : 1;
        }
        int iSignum = (int) Math.signum(m642getDistanceimpl(j) - m642getDistanceimpl(j2));
        if (Math.min(m642getDistanceimpl(j), m642getDistanceimpl(j2)) >= CropImageView.DEFAULT_ASPECT_RATIO && m643isInExpandedBoundsimpl(j) != m643isInExpandedBoundsimpl(j2)) {
            return m643isInExpandedBoundsimpl(j) ? -1 : 1;
        }
        return iSignum;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object currentValueOf(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, ProvidableCompositionLocal providableCompositionLocal) {
        if (!((Modifier.Node) compositionLocalConsumerModifierNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.");
        }
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) requireLayoutNode(compositionLocalConsumerModifierNode).compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        return Stack.read(persistentCompositionLocalHashMap, providableCompositionLocal);
    }

    public static final Rect effectiveBoundsInRoot(Modifier.Node node, boolean z, boolean z2) {
        if (!node.node.isAttached) {
            return Rect.Zero;
        }
        if (z) {
            return m646requireCoordinator64DMado(node, 8).touchBoundsInRoot();
        }
        NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado = m646requireCoordinator64DMado(node, 8);
        return RulerKt.findRootCoordinates(nodeCoordinatorM646requireCoordinator64DMado).localBoundingBoxOf(nodeCoordinatorM646requireCoordinator64DMado, z2);
    }

    public static final TraversableNode findNearestAncestor(HazeEffectNode hazeEffectNode) {
        NodeChain nodeChain;
        if (!hazeEffectNode.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = hazeEffectNode.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(hazeEffectNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node != null) {
                    if ((node.kindSet & 262144) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) nodePop;
                                if (HazeTraversableNodeKeys.Source.equals(traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
                            }
                            if ((nodePop.kindSet & 262144) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = node2;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodePop != null) {
                                                mutableVector.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector.add(node2);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = pop(mutableVector);
                        }
                    }
                    node = node.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return null;
    }

    public static final ArrayList getChildrenOfVirtualChildren(IntrinsicMeasureScope intrinsicMeasureScope) {
        intrinsicMeasureScope.getClass();
        LayoutNode layoutNode = ((LookaheadCapablePlaceable) intrinsicMeasureScope).getLayoutNode();
        boolean zIsInLookaheadPass = isInLookaheadPass(layoutNode);
        MutableObjectList.ObjectListMutableList objectListMutableList = (MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui();
        MutableVector mutableVector = (MutableVector) objectListMutableList.objectList;
        ArrayList arrayList = new ArrayList(mutableVector.size);
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objectListMutableList.get(i2);
            arrayList.add(zIsInLookaheadPass ? layoutNode2.getChildLookaheadMeasurables$ui() : layoutNode2.getChildMeasurables$ui());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getDistance-impl, reason: not valid java name */
    public static final float m642getDistanceimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void invalidateDraw(DrawModifierNode drawModifierNode) {
        if (((Modifier.Node) drawModifierNode).node.isAttached) {
            m646requireCoordinator64DMado(drawModifierNode, 1).invalidateLayer();
        }
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui();
    }

    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui();
    }

    /* JADX INFO: renamed from: isInExpandedBounds-impl, reason: not valid java name */
    public static final boolean m643isInExpandedBoundsimpl(long j) {
        return (j & 2) != 0;
    }

    /* JADX INFO: renamed from: isInLayer-impl, reason: not valid java name */
    public static final boolean m644isInLayerimpl(long j) {
        return (j & 1) != 0;
    }

    public static final boolean isInLookaheadPass(LayoutNode layoutNode) {
        int iOrdinal = layoutNode.layoutDelegate.layoutState.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return false;
                        }
                        LayoutNode parent$ui = layoutNode.getParent$ui();
                        if (parent$ui != null) {
                            return isInLookaheadPass(parent$ui);
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("no parent for idle node");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean isOutMostLookaheadRoot(LayoutNode layoutNode) {
        if (layoutNode.lookaheadRoot == null) {
            return false;
        }
        LayoutNode parent$ui = layoutNode.getParent$ui();
        return (parent$ui != null ? parent$ui.lookaheadRoot : null) == null || layoutNode.layoutDelegate.detachedFromParentLookaheadPass;
    }

    /* JADX INFO: renamed from: nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m645nextUntilhw7D004(DelegatableNode delegatableNode, int i) {
        Modifier.Node node = ((Modifier.Node) delegatableNode).node.child;
        if (node == null || (node.aggregateChildKindSet & i) == 0) {
            return null;
        }
        while (node != null) {
            int i2 = node.kindSet;
            if ((i2 & 2) != 0) {
                return null;
            }
            if ((i2 & i) != 0) {
                return node;
            }
            node = node.child;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void observeReads(Modifier.Node node, Function0 function0) {
        ObserverNodeOwnerScope observerNodeOwnerScope = node.ownerScope;
        if (observerNodeOwnerScope == null) {
            observerNodeOwnerScope = new ObserverNodeOwnerScope((ObserverModifierNode) node);
            node.ownerScope = observerNodeOwnerScope;
        }
        OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) requireOwner(node)).getSnapshotObserver();
        snapshotObserver.observer.observeReads(observerNodeOwnerScope, ObserverNodeOwnerScope.OnObserveReadsChanged, function0);
    }

    public static long pack$ui(int i, int i2, int i3, int i4) {
        return (((long) (i2 & 32767)) << 15) | ((long) (i & 32767)) | (((long) (i3 & 32767)) << 30) | (((long) (i4 & 32767)) << 45) | Long.MIN_VALUE;
    }

    public static final Modifier.Node pop(MutableVector mutableVector) {
        int i;
        if (mutableVector == null || (i = mutableVector.size) == 0) {
            return null;
        }
        return (Modifier.Node) mutableVector.removeAt(i - 1);
    }

    public static final void requestAutofill(DelegatableNode delegatableNode) {
        AndroidAutofillManager autofillManager;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        if (layoutNodeRequireLayoutNode.isCurrentlyCalculatingSemanticsConfiguration || (autofillManager = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode)).m694getAutofillManager()) == null) {
            return;
        }
        android.graphics.Rect rect = autofillManager.reusableRect;
        RectManager rectManager = autofillManager.rectManager;
        LayoutNode layoutNode = (LayoutNode) rectManager.layoutNodes.get(layoutNodeRequireLayoutNode.semanticsId);
        if (layoutNode == null || layoutNode.rectListIndex == -4) {
            return;
        }
        StatusLine statusLine = rectManager.rects;
        int iIndexInRectList = rectManager.indexInRectList(layoutNode);
        long[] jArr = (long[]) statusLine.protocol;
        long j = jArr[iIndexInRectList];
        long j2 = jArr[iIndexInRectList + 1];
        rect.set((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
        autofillManager.platformAutofillManager.getPlatformAndroidManager().requestAutofill(autofillManager.view, layoutNodeRequireLayoutNode.semanticsId, rect);
    }

    /* JADX INFO: renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m646requireCoordinator64DMado(DelegatableNode delegatableNode, int i) {
        NodeCoordinator nodeCoordinator = ((Modifier.Node) delegatableNode).node.coordinator;
        nodeCoordinator.getClass();
        if (nodeCoordinator.getTail() != delegatableNode || !NodeKindKt.m678getIncludeSelfInTraversalH91voCI(i)) {
            return nodeCoordinator;
        }
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrapped;
        nodeCoordinator2.getClass();
        return nodeCoordinator2;
    }

    public static final NodeCoordinator requireLayoutCoordinates(DelegatableNode delegatableNode) {
        if (!((Modifier.Node) delegatableNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado = m646requireCoordinator64DMado(delegatableNode, 2);
        if (!nodeCoordinatorM646requireCoordinator64DMado.getTail().isAttached) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return nodeCoordinatorM646requireCoordinator64DMado;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator nodeCoordinator = ((Modifier.Node) delegatableNode).node.coordinator;
        if (nodeCoordinator != null) {
            return nodeCoordinator.layoutNode;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).owner;
        if (owner != null) {
            return owner;
        }
        throw Fragment$5$$ExternalSyntheticOutline0.m$2("This node does not have an owner.");
    }

    public static final View requireView(DelegatableNode delegatableNode) {
        if (!((Modifier.Node) delegatableNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get View because the Modifier node is not currently attached.");
        }
        return (View) LayoutNodeKt.requireOwner(requireLayoutNode(delegatableNode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.TraversableNode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static final void traverseAncestors(TraversableNode traversableNode, Function1 function1) {
        NodeChain nodeChain;
        Modifier.Node node = (Modifier.Node) traversableNode;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = node.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(traversableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node2 != null) {
                    if ((node2.kindSet & 262144) != 0) {
                        ?? Pop = node2;
                        ?? mutableVector = 0;
                        while (Pop != 0) {
                            boolean zBooleanValue = true;
                            if (Pop instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) Pop;
                                if (Intrinsics.areEqual(traversableNode.getTraverseKey(), traversableNode2.getTraverseKey()) && traversableNode.getClass() == traversableNode2.getClass()) {
                                    zBooleanValue = ((Boolean) function1.invoke(traversableNode2)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else if ((Pop.kindSet & 262144) != 0 && (Pop instanceof DelegatingNode)) {
                                Modifier.Node node3 = ((DelegatingNode) Pop).delegate;
                                int i = 0;
                                while (node3 != null) {
                                    if ((node3.kindSet & 262144) != 0) {
                                        i++;
                                        if (i == 1) {
                                            Pop = Pop;
                                            mutableVector = mutableVector;
                                            mutableVector = mutableVector;
                                            Pop = node3;
                                        } else {
                                            if (mutableVector == 0) {
                                                mutableVector = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (Pop != 0) {
                                                mutableVector.add(Pop);
                                                Pop = 0;
                                            }
                                            mutableVector.add(node3);
                                        }
                                    } else {
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    node3 = node3.child;
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
                            Pop = pop(mutableVector);
                        }
                    }
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.ui.node.TraversableNode, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void traverseDescendants(TraversableNode traversableNode, Function1 function1) {
        Modifier.Node node = (Modifier.Node) traversableNode;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node2 = node.node;
        Modifier.Node node3 = node2.child;
        if (node3 == null) {
            addLayoutNodeChildren(mutableVector, node2);
        } else {
            mutableVector.add(node3);
        }
        while (true) {
            int i = mutableVector.size;
            if (i == 0) {
                return;
            }
            Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(i - 1);
            if ((node4.aggregateChildKindSet & 262144) != 0) {
                Modifier.Node node5 = node4;
                while (true) {
                    if (node5 != null && node5.isAttached) {
                        if ((node5.kindSet & 262144) != 0) {
                            ?? Pop = node5;
                            ?? mutableVector2 = 0;
                            while (Pop != 0) {
                                if (Pop instanceof TraversableNode) {
                                    TraversableNode traversableNode2 = (TraversableNode) Pop;
                                    TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = (Intrinsics.areEqual(traversableNode.getTraverseKey(), traversableNode2.getTraverseKey()) && traversableNode.getClass() == traversableNode2.getClass()) ? (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(traversableNode2) : TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                    if (traversableNode$Companion$TraverseDescendantsAction != TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                        if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((Pop.kindSet & 262144) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node6 = ((DelegatingNode) Pop).delegate;
                                    int i2 = 0;
                                    Pop = Pop;
                                    mutableVector2 = mutableVector2;
                                    while (node6 != null) {
                                        if ((node6.kindSet & 262144) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector2 = mutableVector2;
                                                Pop = node6;
                                            } else {
                                                if (mutableVector2 == 0) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector2.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector2.add(node6);
                                            }
                                        }
                                        node6 = node6.child;
                                        Pop = Pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Pop = pop(mutableVector2);
                            }
                        }
                        node5 = node5.child;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1 function1) {
        NodeChain nodeChain;
        if (!((Modifier.Node) delegatableNode).node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = ((Modifier.Node) delegatableNode).node.parent;
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node != null) {
                    if ((node.kindSet & 262144) != 0) {
                        ?? Pop = node;
                        ?? mutableVector = 0;
                        while (Pop != 0) {
                            if (Pop instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) Pop;
                                if (!(obj.equals(traversableNode.getTraverseKey()) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                }
                            } else if ((Pop.kindSet & 262144) != 0 && (Pop instanceof DelegatingNode)) {
                                Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                                int i = 0;
                                while (node2 != null) {
                                    if ((node2.kindSet & 262144) != 0) {
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
                            Pop = pop(mutableVector);
                        }
                    }
                    node = node.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v8 */
    public static final void traverseDescendants(Modifier.Node node, String str, Function1 function1) {
        TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction;
        if (!node.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
        Modifier.Node node2 = node.node;
        Modifier.Node node3 = node2.child;
        if (node3 == null) {
            addLayoutNodeChildren(mutableVector, node2);
        } else {
            mutableVector.add(node3);
        }
        while (true) {
            int i = mutableVector.size;
            if (i == 0) {
                return;
            }
            Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(i - 1);
            if ((node4.aggregateChildKindSet & 262144) != 0) {
                Modifier.Node node5 = node4;
                while (true) {
                    if (node5 != null && node5.isAttached) {
                        if ((node5.kindSet & 262144) != 0) {
                            ?? Pop = node5;
                            ?? mutableVector2 = 0;
                            while (Pop != 0) {
                                if (Pop instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) Pop;
                                    if (str.equals(traversableNode.getTraverseKey())) {
                                        traversableNode$Companion$TraverseDescendantsAction = (TraversableNode$Companion$TraverseDescendantsAction) function1.invoke(traversableNode);
                                    } else {
                                        traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                                    }
                                    if (traversableNode$Companion$TraverseDescendantsAction != TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal) {
                                        if (traversableNode$Companion$TraverseDescendantsAction == TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((Pop.kindSet & 262144) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node6 = ((DelegatingNode) Pop).delegate;
                                    int i2 = 0;
                                    Pop = Pop;
                                    mutableVector2 = mutableVector2;
                                    while (node6 != null) {
                                        if ((node6.kindSet & 262144) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                mutableVector2 = mutableVector2;
                                                Pop = node6;
                                            } else {
                                                if (mutableVector2 == 0) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (Pop != 0) {
                                                    mutableVector2.add(Pop);
                                                    Pop = 0;
                                                }
                                                mutableVector2.add(node6);
                                            }
                                        }
                                        node6 = node6.child;
                                        Pop = Pop;
                                        mutableVector2 = mutableVector2;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Pop = pop(mutableVector2);
                            }
                        }
                        node5 = node5.child;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node4);
        }
    }
}
