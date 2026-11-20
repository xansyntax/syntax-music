package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NodeCoordinator$Companion$PointerInputSource$1 implements NodeCoordinator.HitTestSource {
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* JADX INFO: renamed from: childHitTest-qzLsGqo */
    public final void mo638childHitTestqzLsGqo(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z) {
        layoutNode.m648hitTest6fMxITs$ui(j, hitTestResult, i, z);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* JADX INFO: renamed from: entityType-OLwlOKw */
    public final int mo639entityTypeOLwlOKw() {
        return 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.ui.Modifier$Node] */
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
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        ?? mutableVector = 0;
        while (true) {
            int i = 0;
            if (node == 0) {
                return false;
            }
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents();
            } else if ((node.kindSet & 16) != 0 && (node instanceof DelegatingNode)) {
                Modifier.Node node2 = ((DelegatingNode) node).delegate;
                mutableVector = mutableVector;
                node = node;
                while (node2 != null) {
                    if ((node2.kindSet & 16) != 0) {
                        i++;
                        if (i == 1) {
                            mutableVector = mutableVector;
                            node = node2;
                        } else {
                            if (mutableVector == 0) {
                                mutableVector = new MutableVector(new Modifier.Node[16]);
                            }
                            if (node != 0) {
                                mutableVector.add(node);
                                node = 0;
                            }
                            mutableVector.add(node2);
                        }
                    }
                    node2 = node2.child;
                    mutableVector = mutableVector;
                    node = node;
                }
                if (i == 1) {
                }
            }
            node = HitTestResultKt.pop(mutableVector);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v4 */
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean shareWithSiblings(HitTestResult hitTestResult, LayoutNode layoutNode) {
        NodeCoordinator nodeCoordinator = (NodeCoordinator) layoutNode.nodes.outerCoordinator;
        nodeCoordinator.getClass();
        Modifier.Node nodeHeadNode = nodeCoordinator.headNode(NodeKindKt.m678getIncludeSelfInTraversalH91voCI(16));
        if (nodeHeadNode != null && nodeHeadNode.isAttached) {
            if (!nodeHeadNode.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
            }
            Modifier.Node node = nodeHeadNode.node;
            if ((node.aggregateChildKindSet & 16) != 0) {
                while (node != null) {
                    if ((node.kindSet & 16) != 0) {
                        ?? Pop = node;
                        ?? mutableVector = 0;
                        while (Pop != 0) {
                            if (Pop instanceof PointerInputModifierNode) {
                                if (((PointerInputModifierNode) Pop).sharePointerInputWithSiblings()) {
                                    hitTestResult.hitDepth = hitTestResult.values._size - 1;
                                    return true;
                                }
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
                    }
                    node = node.child;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean shouldHitTestChildren(LayoutNode layoutNode) {
        return true;
    }
}
