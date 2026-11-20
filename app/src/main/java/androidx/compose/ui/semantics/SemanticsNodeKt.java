package androidx.compose.ui.semantics;

import android.graphics.Region;
import android.os.Trace;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.IntRect;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsNodeKt {
    public static final Rect DefaultFakeNodeBounds = new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 10.0f, 10.0f);
    public static final SemanticsPropertyKey TestTagsAsResourceId = new SemanticsPropertyKey("TestTagsAsResourceId", false, new SaversKt$$ExternalSyntheticLambda0(2));
    public static final SemanticsPropertyKey AccessibilityClassName = new SemanticsPropertyKey("AccessibilityClassName", true, new Updater$$ExternalSyntheticLambda0((byte) 23));
    public static final SemanticsPropertyKey CredentialRequest = new SemanticsPropertyKey("CredentialRequest", false, new SaversKt$$ExternalSyntheticLambda0(3));

    /* JADX WARN: Code duplicated, block: B:35:0x0063 A[LOOP:0: B:4:0x000d->B:35:0x0063, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0066 A[EDGE_INSN: B:43:0x0066->B:36:0x0066 BREAK  A[LOOP:0: B:4:0x000d->B:35:0x0063], SYNTHETIC] */
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z) {
        Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
        Object obj = null;
        if ((node.aggregateChildKindSet & 8) != 0) {
            loop0: while (node != null) {
                if ((node.kindSet & 8) == 0) {
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                        break;
                    }
                    node = node.child;
                } else {
                    Modifier.Node nodePop = node;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof SemanticsModifierNode) {
                            obj = nodePop;
                            break loop0;
                        }
                        if ((nodePop.kindSet & 8) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                if ((node2.kindSet & 8) != 0) {
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
                        nodePop = HitTestResultKt.pop(mutableVector);
                    }
                    if ((node.aggregateChildKindSet & 8) != 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        }
        obj.getClass();
        Modifier.Node node3 = ((Modifier.Node) ((SemanticsModifierNode) obj)).node;
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration == null) {
            semanticsConfiguration = new SemanticsConfiguration();
        }
        return new SemanticsNode(node3, z, layoutNode, semanticsConfiguration);
    }

    public static final MutableIntObjectMap getAllUncoveredSemanticsNodesToIntObjectMap(SemanticsOwner semanticsOwner, Function1 function1) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
            LayoutNode layoutNode = unmergedRootSemanticsNode.layoutNode;
            if (layoutNode.isPlaced() && layoutNode.isAttached$1()) {
                Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
                MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(48);
                DrawResult drawResult = new DrawResult((byte) 28);
                drawResult.set(DatabaseDao_Impl.AnonymousClass17.roundToIntRect(boundsInRoot));
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(mutableIntObjectMap, new DrawResult((byte) 28), drawResult, unmergedRootSemanticsNode, unmergedRootSemanticsNode, function1, false);
                return mutableIntObjectMap;
            }
            MutableIntObjectMap mutableIntObjectMap2 = IntObjectMapKt.EmptyIntObjectMap;
            mutableIntObjectMap2.getClass();
            return mutableIntObjectMap2;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(MutableIntObjectMap mutableIntObjectMap, DrawResult drawResult, DrawResult drawResult2, SemanticsNode semanticsNode, SemanticsNode semanticsNode2, Function1 function1, boolean z) {
        boolean z2;
        DrawResult drawResult3 = drawResult;
        Region region = (Region) drawResult3.block;
        DrawResult drawResult4 = drawResult2;
        Region region2 = (Region) drawResult4.block;
        LayoutNode layoutNode = semanticsNode2.layoutNode;
        SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
        LayoutNode layoutNode2 = semanticsNode2.layoutNode;
        if (!layoutNode.isPlaced() || !layoutNode2.isAttached$1() || region2.isEmpty()) {
            if (semanticsNode2.isFake$ui()) {
                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, semanticsNode2, z);
                return;
            }
            return;
        }
        Rect touchBoundsInRoot = semanticsNode2.getTouchBoundsInRoot();
        if (touchBoundsInRoot.isEmpty()) {
            Object objFindSemanticsModifierNodeToGetBounds = semanticsNode2.findSemanticsModifierNodeToGetBounds();
            if (objFindSemanticsModifierNodeToGetBounds == null) {
                InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator;
                touchBoundsInRoot = RulerKt.findRootCoordinates(innerNodeCoordinator).localBoundingBoxOf(innerNodeCoordinator, false);
            } else {
                Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
                Object obj = semanticsConfiguration.props.get(SemanticsActions.OnClick);
                if (obj == null) {
                    obj = null;
                }
                touchBoundsInRoot = HitTestResultKt.effectiveBoundsInRoot(node, obj != null, false);
            }
        }
        IntRect intRectRoundToIntRect = DatabaseDao_Impl.AnonymousClass17.roundToIntRect(touchBoundsInRoot);
        drawResult3.set(intRectRoundToIntRect);
        if (z) {
            z2 = true;
        } else {
            if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                if (semanticsConfiguration.props.containsKey(SemanticsProperties.HideFromAccessibility)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (region.op(region2, Region.Op.INTERSECT)) {
            int i = semanticsNode2.id;
            if (i == semanticsNode.id) {
                i = -1;
            }
            android.graphics.Rect bounds = region.getBounds();
            mutableIntObjectMap.set(i, new AdjustedSemanticsNode(semanticsNode2, new IntRect(bounds.left, bounds.top, bounds.right, bounds.bottom), z2));
            List children$ui = semanticsNode2.getChildren$ui((4 & 1) != 0 ? !semanticsNode2.mergingEnabled : false, (4 & 2) == 0);
            int size = children$ui.size() - 1;
            while (-1 < size) {
                if (!((Boolean) function1.invoke(children$ui.get(size))).booleanValue()) {
                    getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap, drawResult3, drawResult4, semanticsNode, (SemanticsNode) children$ui.get(size), function1, z2);
                }
                size--;
                drawResult3 = drawResult;
                drawResult4 = drawResult2;
            }
            if (isImportantForAccessibility(semanticsNode2)) {
                region2.op(intRectRoundToIntRect.left, intRectRoundToIntRect.top, intRectRoundToIntRect.right, intRectRoundToIntRect.bottom, Region.Op.DIFFERENCE);
            }
        }
    }

    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(MutableIntObjectMap mutableIntObjectMap, SemanticsNode semanticsNode, SemanticsNode semanticsNode2, boolean z) {
        LayoutNode layoutNode;
        SemanticsNode parent = semanticsNode2.getParent();
        Rect boundsInRoot = (parent == null || (layoutNode = parent.layoutNode) == null || !layoutNode.isPlaced()) ? DefaultFakeNodeBounds : parent.getBoundsInRoot();
        int i = semanticsNode2.id;
        if (i == semanticsNode.id) {
            i = -1;
        }
        mutableIntObjectMap.set(i, new AdjustedSemanticsNode(semanticsNode2, DatabaseDao_Impl.AnonymousClass17.roundToIntRect(boundsInRoot), z));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:86:0x0176  */
    /* JADX WARN: Code duplicated, block: B:89:0x0181  */
    /* JADX WARN: Code duplicated, block: B:91:0x0191  */
    /* JADX WARN: Code duplicated, block: B:93:0x0197  */
    public static final void getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(MutableIntObjectMap mutableIntObjectMap, DrawResult drawResult, DrawResult drawResult2, SemanticsNode semanticsNode, SemanticsNode semanticsNode2, Function1 function1, boolean z) {
        boolean z2;
        boolean z3;
        int size;
        boolean z4;
        Rect rectEffectiveBoundsInRoot;
        boolean z5;
        Function1 function2 = function1;
        int i = semanticsNode.id;
        Region region = (Region) drawResult.block;
        DrawResult drawResult3 = drawResult2;
        Region region2 = (Region) drawResult3.block;
        LayoutNode layoutNode = semanticsNode2.layoutNode;
        LayoutNode layoutNode2 = semanticsNode2.layoutNode;
        SemanticsConfiguration semanticsConfiguration = semanticsNode2.unmergedConfig;
        int i2 = semanticsNode2.id;
        boolean z6 = (layoutNode.isPlaced() && layoutNode2.isAttached$1()) ? false : true;
        if (!region2.isEmpty() || i2 == i) {
            if (!z6 || semanticsNode2.isFake$ui()) {
                IntRect intRectRoundToIntRect = DatabaseDao_Impl.AnonymousClass17.roundToIntRect(semanticsNode2.getTouchBoundsInRoot());
                drawResult.set(intRectRoundToIntRect);
                if (i2 == i) {
                    i2 = -1;
                }
                if (!z) {
                    if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                        z2 = semanticsConfiguration.props.containsKey(SemanticsProperties.HideFromAccessibility);
                    }
                }
                if (!region.op(region2, Region.Op.INTERSECT)) {
                    boolean z7 = z2;
                    if (semanticsNode2.isFake$ui()) {
                        getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addFakeNode(mutableIntObjectMap, semanticsNode, semanticsNode2, z);
                        return;
                    } else {
                        if (i2 == -1) {
                            android.graphics.Rect bounds = region.getBounds();
                            mutableIntObjectMap.set(i2, new AdjustedSemanticsNode(semanticsNode2, new IntRect(bounds.left, bounds.top, bounds.right, bounds.bottom), z7));
                            return;
                        }
                        return;
                    }
                }
                android.graphics.Rect bounds2 = region.getBounds();
                mutableIntObjectMap.set(i2, new AdjustedSemanticsNode(semanticsNode2, new IntRect(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom), z2));
                List children$ui = semanticsNode2.getChildren$ui((4 & 1) != 0 ? !semanticsNode2.mergingEnabled : false, (4 & 2) == 0);
                if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                    SemanticsNode parent = semanticsNode2.getParent();
                    while (true) {
                        if (parent == null) {
                            parent = null;
                            break;
                        }
                        MutableScatterMap mutableScatterMap = parent.unmergedConfig.props;
                        if (mutableScatterMap.containsKey(SemanticsProperties.VerticalScrollAxisRange) || mutableScatterMap.containsKey(SemanticsProperties.HorizontalScrollAxisRange)) {
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                    if (parent == null) {
                        z4 = false;
                    } else {
                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode2.findCoordinatorToGetBounds$ui();
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                            nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                        } else {
                            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                            }
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
                            }
                        }
                        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui2 = parent.findCoordinatorToGetBounds$ui();
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                            nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                        } else {
                            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui2.getTail().isAttached) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                            }
                            if (nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                                nodeCoordinatorFindCoordinatorToGetBounds$ui2 = null;
                            }
                        }
                        if (nodeCoordinatorFindCoordinatorToGetBounds$ui == null || nodeCoordinatorFindCoordinatorToGetBounds$ui2 == null) {
                            z4 = false;
                        } else {
                            Rect rectLocalBoundingBoxOf = nodeCoordinatorFindCoordinatorToGetBounds$ui2.localBoundingBoxOf(nodeCoordinatorFindCoordinatorToGetBounds$ui, false);
                            z4 = !rectLocalBoundingBoxOf.equals(rectLocalBoundingBoxOf.intersect(IntMath.m896Recttz77jQw(0L, SizeKt.m876toSizeozmzZPI(nodeCoordinatorFindCoordinatorToGetBounds$ui2.measuredSize))));
                        }
                    }
                    if (z4) {
                        Object obj = null;
                        DrawResult drawResult4 = new DrawResult((byte) 28);
                        Object objFindSemanticsModifierNodeToGetBounds = semanticsNode2.findSemanticsModifierNodeToGetBounds();
                        if (objFindSemanticsModifierNodeToGetBounds == null) {
                            InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) layoutNode2.nodes.innerCoordinator;
                            rectEffectiveBoundsInRoot = RulerKt.findRootCoordinates(innerNodeCoordinator).localBoundingBoxOf(innerNodeCoordinator, false);
                        } else {
                            Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
                            Object obj2 = semanticsConfiguration.props.get(SemanticsActions.OnClick);
                            if (obj2 != null) {
                                obj = obj2;
                            }
                            rectEffectiveBoundsInRoot = HitTestResultKt.effectiveBoundsInRoot(node, obj != null, false);
                        }
                        drawResult4.set(DatabaseDao_Impl.AnonymousClass17.roundToIntRect(rectEffectiveBoundsInRoot));
                        int size2 = children$ui.size() - 1;
                        while (-1 < size2) {
                            if (((Boolean) function2.invoke(children$ui.get(size2))).booleanValue()) {
                                z5 = z2;
                            } else {
                                z5 = z2;
                                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$addDescendantsOfMergingNodePartiallyVisibleInScrollParent(mutableIntObjectMap, new DrawResult((byte) 28), drawResult4, semanticsNode, (SemanticsNode) children$ui.get(size2), function2, z5);
                            }
                            size2--;
                            z2 = z5;
                        }
                    } else {
                        z3 = z2;
                        size = children$ui.size() - 1;
                        while (-1 < size) {
                            if (((Boolean) function2.invoke(children$ui.get(size))).booleanValue()) {
                                getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(mutableIntObjectMap, drawResult, drawResult3, semanticsNode, (SemanticsNode) children$ui.get(size), function2, z3);
                            }
                            size--;
                            drawResult3 = drawResult2;
                            function2 = function1;
                            z3 = z3;
                        }
                    }
                } else {
                    z3 = z2;
                    size = children$ui.size() - 1;
                    while (-1 < size) {
                        if (((Boolean) function2.invoke(children$ui.get(size))).booleanValue()) {
                            getAllUncoveredSemanticsNodesToIntObjectMap$lambda$0$findAllSemanticNodesRecursive(mutableIntObjectMap, drawResult, drawResult3, semanticsNode, (SemanticsNode) children$ui.get(size), function2, z3);
                        }
                        size--;
                        drawResult3 = drawResult2;
                        function2 = function1;
                        z3 = z3;
                    }
                }
                if (isImportantForAccessibility(semanticsNode2)) {
                    region2.op(intRectRoundToIntRect.left, intRectRoundToIntRect.top, intRectRoundToIntRect.right, intRectRoundToIntRect.bottom, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final Object getOrNull(SemanticsConfiguration semanticsConfiguration, SemanticsPropertyKey semanticsPropertyKey) {
        Object obj = semanticsConfiguration.props.get(semanticsPropertyKey);
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public static final boolean isAccessibilityIgnoredLink(SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        return config.props.containsKey(SemanticsProperties.LinkTestMarker);
    }

    public static final boolean isHidden(SemanticsNode semanticsNode) {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = semanticsNode.findCoordinatorToGetBounds$ui();
        MutableScatterMap mutableScatterMap = semanticsNode.unmergedConfig.props;
        return (nodeCoordinatorFindCoordinatorToGetBounds$ui != null ? nodeCoordinatorFindCoordinatorToGetBounds$ui.isTransparent() : false) || mutableScatterMap.containsKey(SemanticsProperties.HideFromAccessibility) || mutableScatterMap.containsKey(SemanticsProperties.InvisibleToUser);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0059 A[LOOP:0: B:11:0x001d->B:24:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x005c A[SYNTHETIC] */
    public static final boolean isImportantForAccessibility(SemanticsNode semanticsNode) {
        if (!isHidden(semanticsNode)) {
            SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
            if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
                return true;
            }
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                int i4 = (i << 3) + i3;
                                Object obj = objArr[i4];
                                Object obj2 = objArr2[i4];
                                if (((SemanticsPropertyKey) obj).isImportantForAccessibility) {
                                    return true;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 == 8) {
                            if (i != length) {
                                i++;
                            }
                        }
                    } else if (i != length) {
                        i++;
                    }
                }
            }
        }
        return false;
    }
}
