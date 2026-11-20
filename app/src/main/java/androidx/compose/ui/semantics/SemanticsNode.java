package androidx.compose.ui.semantics;

import androidx.collection.MutableScatterMap;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNode {
    public SemanticsNode fakeNodeParent;
    public final int id;
    public final LayoutNode layoutNode;
    public final boolean mergingEnabled;
    public final Modifier.Node outerSemanticsNode;
    public final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.semanticsId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
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
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final Rect boundsInImportantForBoundsAncestor(NodeCoordinator nodeCoordinator) {
        ?? Pop;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.Zero;
        }
        Modifier.Node node = (Modifier.Node) parent.layoutNode.nodes.head;
        if ((node.aggregateChildKindSet & 8) == 0) {
            Pop = 0;
            break;
        }
        loop0: while (true) {
            if (node != null) {
                if ((node.kindSet & 8) != 0) {
                    Pop = node;
                    ?? mutableVector = 0;
                    while (Pop != 0) {
                        if (Pop instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) Pop).isImportantForBounds()) {
                                break loop0;
                            }
                        } else if ((Pop.kindSet & 8) != 0 && (Pop instanceof DelegatingNode)) {
                            Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                            int i = 0;
                            while (node2 != null) {
                                if ((node2.kindSet & 8) != 0) {
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
                }
                if ((node.aggregateChildKindSet & 8) != 0) {
                    node = node.child;
                }
            }
            Pop = 0;
            break;
        }
        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) Pop;
        NodeCoordinator nodeCoordinatorM646requireCoordinator64DMado = semanticsModifierNode != null ? HitTestResultKt.m646requireCoordinator64DMado(semanticsModifierNode, 8) : null;
        return nodeCoordinatorM646requireCoordinator64DMado == null ? parent.boundsInImportantForBoundsAncestor(nodeCoordinator) : nodeCoordinatorM646requireCoordinator64DMado.localBoundingBoxOf(nodeCoordinator, true);
    }

    /* JADX INFO: renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    public final SemanticsNode m716fakeSemanticsNodeypyhhiA(Role role, Function1 function1) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = false;
        semanticsConfiguration.isClearingSemantics = false;
        function1.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(true, this.id + (role != null ? 1000000000 : 2000000000)), semanticsConfiguration);
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    public final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, ArrayList arrayList) {
        MutableVector zSortedChildren = layoutNode.getZSortedChildren();
        Object[] objArr = zSortedChildren.content;
        int i = zSortedChildren.size;
        for (int i2 = 0; i2 < i; i2++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i2];
            if (layoutNode2.isAttached$1() && !layoutNode2.isDeactivated) {
                if (layoutNode2.nodes.m662hasH91voCI$ui(8)) {
                    arrayList.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                } else {
                    fillOneLayerOfSemanticsWrappers(layoutNode2, arrayList);
                }
            }
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui() {
        if (!isFake$ui()) {
            SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
            return semanticsModifierNodeFindSemanticsModifierNodeToGetBounds != null ? HitTestResultKt.m646requireCoordinator64DMado(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds, 8) : (InnerNodeCoordinator) this.layoutNode.nodes.innerCoordinator;
        }
        SemanticsNode parent = getParent();
        if (parent != null) {
            return parent.findCoordinatorToGetBounds$ui();
        }
        return null;
    }

    public final void findOneLayerOfMergingSemanticsNodes(ArrayList arrayList, ArrayList arrayList2) {
        unmergedChildren$ui(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(size2);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                arrayList2.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(arrayList, arrayList2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        ?? Pop;
        boolean z;
        ?? r0;
        boolean z2 = this.unmergedConfig.isMergingSemanticsOfDescendants;
        ?? r4 = 0;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        LayoutNode layoutNode = this.layoutNode;
        if (!z2) {
            Modifier.Node node = (Modifier.Node) layoutNode.nodes.head;
            if ((node.aggregateChildKindSet & 8) != 0) {
                loop3: while (node != null) {
                    if ((node.kindSet & 8) != 0) {
                        Pop = node;
                        ?? mutableVector = 0;
                        while (true) {
                            if (Pop != 0) {
                                if (Pop instanceof SemanticsModifierNode) {
                                    if (((SemanticsModifierNode) Pop).isImportantForBounds()) {
                                        r4 = Pop;
                                    }
                                } else if ((Pop.kindSet & 8) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node2 = ((DelegatingNode) Pop).delegate;
                                    int i = 0;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 8) != 0) {
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
                        }
                    }
                    if ((node.aggregateChildKindSet & 8) == 0) {
                        break;
                    }
                    node = node.child;
                }
            }
        } else {
            Modifier.Node node3 = (Modifier.Node) layoutNode.nodes.head;
            if ((node3.aggregateChildKindSet & 8) != 0) {
                Pop = 0;
                while (node3 != null) {
                    if ((node3.kindSet & 8) != 0) {
                        Modifier.Node nodePop = node3;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof SemanticsModifierNode) {
                                SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) nodePop;
                                if (semanticsModifierNode.isImportantForBounds()) {
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        r0 = Pop;
                                        r0 = Pop;
                                        return semanticsModifierNode;
                                    }
                                    if (Pop == 0) {
                                        r0 = semanticsModifierNode;
                                    }
                                }
                                r0 = Pop;
                                z = false;
                                Pop = r0;
                            } else {
                                z = true;
                            }
                            if (z) {
                                Pop = Pop;
                                if ((nodePop.kindSet & 8) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node node4 = ((DelegatingNode) nodePop).delegate; node4 != null; node4 = node4.child) {
                                        if ((node4.kindSet & 8) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                nodePop = node4;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector2.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector2.add(node4);
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                            } else {
                                Pop = Pop;
                            }
                            nodePop = HitTestResultKt.pop(mutableVector2);
                        }
                    }
                    if ((node3.aggregateChildKindSet & 8) == 0) {
                        break;
                    }
                    node3 = node3.child;
                    Pop = Pop;
                }
                r4 = Pop;
            }
        }
        return (SemanticsModifierNode) r4;
    }

    public final Rect getBoundsInRoot() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return RulerKt.findRootCoordinates(nodeCoordinatorFindCoordinatorToGetBounds$ui).localBoundingBoxOf(nodeCoordinatorFindCoordinatorToGetBounds$ui, true);
            }
        }
        return Rect.Zero;
    }

    public final Rect getBoundsInWindow() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui = findCoordinatorToGetBounds$ui();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui.getTail().isAttached) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui != null) {
                return RulerKt.boundsInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui, true);
            }
        }
        return Rect.Zero;
    }

    public final List getChildren$ui(boolean z, boolean z2) {
        if (!z && this.unmergedConfig.isClearingSemantics) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        if (!isMergingSemanticsOfDescendants()) {
            return unmergedChildren$ui(arrayList, z2);
        }
        ArrayList arrayList2 = new ArrayList();
        findOneLayerOfMergingSemanticsNodes(arrayList, arrayList2);
        return arrayList2;
    }

    public final SemanticsConfiguration getConfig() {
        boolean zIsMergingSemanticsOfDescendants = isMergingSemanticsOfDescendants();
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        if (!zIsMergingSemanticsOfDescendants) {
            return semanticsConfiguration;
        }
        SemanticsConfiguration semanticsConfiguration2 = new SemanticsConfiguration();
        semanticsConfiguration2.isMergingSemanticsOfDescendants = semanticsConfiguration.isMergingSemanticsOfDescendants;
        semanticsConfiguration2.isClearingSemantics = semanticsConfiguration.isClearingSemantics;
        semanticsConfiguration2.props.putAll(semanticsConfiguration.props);
        mergeConfig(new ArrayList(), semanticsConfiguration2);
        return semanticsConfiguration2;
    }

    public final SemanticsNode getParent() {
        LayoutNode parent$ui;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode layoutNode = this.layoutNode;
        boolean z = this.mergingEnabled;
        if (!z) {
            parent$ui = null;
            break;
        }
        parent$ui = layoutNode.getParent$ui();
        while (true) {
            if (parent$ui == null) {
                parent$ui = null;
                break;
            }
            SemanticsConfiguration semanticsConfiguration = parent$ui.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                break;
            }
            parent$ui = parent$ui.getParent$ui();
        }
        if (parent$ui == null) {
            for (LayoutNode parent$ui2 = layoutNode.getParent$ui(); parent$ui2 != null; parent$ui2 = parent$ui2.getParent$ui()) {
                if (parent$ui2.nodes.m662hasH91voCI$ui(8)) {
                    parent$ui = parent$ui2;
                }
            }
            parent$ui = null;
        }
        if (parent$ui == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(parent$ui, z);
    }

    public final Rect getTouchBoundsInRoot() {
        Object objFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        if (objFindSemanticsModifierNodeToGetBounds == null) {
            return ((InnerNodeCoordinator) this.layoutNode.nodes.innerCoordinator).touchBoundsInRoot();
        }
        Modifier.Node node = ((Modifier.Node) objFindSemanticsModifierNodeToGetBounds).node;
        Object obj = this.unmergedConfig.props.get(SemanticsActions.OnClick);
        if (obj == null) {
            obj = null;
        }
        return HitTestResultKt.effectiveBoundsInRoot(node, obj != null, true);
    }

    public final boolean isFake$ui() {
        return this.fakeNodeParent != null;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants;
    }

    public final void mergeConfig(ArrayList arrayList, SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics) {
            return;
        }
        unmergedChildren$ui(arrayList, false);
        int size = arrayList.size();
        for (int size2 = arrayList.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(size2);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(arrayList, semanticsConfiguration);
            }
        }
    }

    public final List unmergedChildren$ui(ArrayList arrayList, boolean z) {
        if (isFake$ui()) {
            return EmptyList.INSTANCE;
        }
        fillOneLayerOfSemanticsWrappers(this.layoutNode, arrayList);
        if (z) {
            SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
            MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
            Object obj = mutableScatterMap.get(SemanticsProperties.Role);
            if (obj == null) {
                obj = null;
            }
            Role role = (Role) obj;
            if (role != null && semanticsConfiguration.isMergingSemanticsOfDescendants && !arrayList.isEmpty()) {
                arrayList.add(m716fakeSemanticsNodeypyhhiA(role, new DiskLruCache$$ExternalSyntheticLambda0((byte) 5, role)));
            }
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
            if (mutableScatterMap.containsKey(semanticsPropertyKey) && !arrayList.isEmpty() && semanticsConfiguration.isMergingSemanticsOfDescendants) {
                Object obj2 = mutableScatterMap.get(semanticsPropertyKey);
                if (obj2 == null) {
                    obj2 = null;
                }
                List list = (List) obj2;
                String str = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
                if (str != null) {
                    arrayList.add(0, m716fakeSemanticsNodeypyhhiA(null, new IconKt$$ExternalSyntheticLambda1(str, (byte) 11)));
                }
            }
        }
        return arrayList;
    }
}
