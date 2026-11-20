package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusInvalidationManager;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import io.ktor.utils.io.ByteChannelKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class NodeKindKt {
    public static final MutableObjectIntMap classToKindSetMap;

    static {
        MutableObjectIntMap mutableObjectIntMap = ObjectIntMapKt.EmptyObjectIntMap;
        classToKindSetMap = new MutableObjectIntMap();
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (!(node instanceof DelegatingNode)) {
            autoInvalidateNodeSelf(node, i & node.kindSet, i2);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int i3 = delegatingNode.selfKindSet;
        autoInvalidateNodeSelf(node, i3 & i, i2);
        int i4 = (~i3) & i;
        for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
            autoInvalidateNodeIncludingDelegates(node2, i4, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((i & 2) != 0 && (node instanceof LayoutModifierNode)) {
                HitTestResultKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    HitTestResultKt.m646requireCoordinator64DMado(node, 2).onRelease();
                }
            }
            if ((i & 128) != 0 && i2 != 2) {
                HitTestResultKt.requireLayoutNode(node).invalidateMeasurements$ui();
            }
            if ((4194304 & i) != 0 && i2 != 2) {
                HitTestResultKt.requireLayoutNode(node).requestRelayout$ui(false);
            }
            if ((i & 256) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                if (i2 == 1) {
                    LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode.setGloballyPositionedObservers(layoutNodeRequireLayoutNode.globallyPositionedObservers + 1);
                } else if (i2 == 2) {
                    LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(node);
                    layoutNodeRequireLayoutNode2.setGloballyPositionedObservers(layoutNodeRequireLayoutNode2.globallyPositionedObservers - 1);
                }
                if (i2 != 2) {
                    LayoutNode layoutNodeRequireLayoutNode3 = HitTestResultKt.requireLayoutNode(node);
                    if (layoutNodeRequireLayoutNode3.globallyPositionedObservers != 0 && !layoutNodeRequireLayoutNode3.getLayoutPending$ui() && !layoutNodeRequireLayoutNode3.getMeasurePending$ui() && !layoutNodeRequireLayoutNode3.needsOnGloballyPositionedDispatch) {
                        AndroidComposeView androidComposeView = (AndroidComposeView) LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode3);
                        WeakCache weakCache = (WeakCache) androidComposeView.measureAndLayoutDelegate.createdAtMillis;
                        if (layoutNodeRequireLayoutNode3.globallyPositionedObservers > 0) {
                            ((MutableVector) weakCache.values).add(layoutNodeRequireLayoutNode3);
                            layoutNodeRequireLayoutNode3.needsOnGloballyPositionedDispatch = true;
                        }
                        androidComposeView.scheduleMeasureAndLayout(null);
                    }
                }
            }
            if ((i & 4) != 0 && (node instanceof DrawModifierNode)) {
                HitTestResultKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((i & 8) != 0 && (node instanceof SemanticsModifierNode)) {
                HitTestResultKt.requireLayoutNode(node).isSemanticsInvalidated = true;
            }
            if ((i & 64) != 0 && (node instanceof ParentDataModifierNode)) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = HitTestResultKt.requireLayoutNode((ParentDataModifierNode) node).layoutDelegate;
                layoutNodeLayoutDelegate.measurePassDelegate.parentDataDirty = true;
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.parentDataDirty = true;
                }
            }
            if ((i & 2048) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                CanFocusChecker.canFocusValue = null;
                focusPropertiesModifierNode.applyFocusProperties(CanFocusChecker.INSTANCE);
                if (CanFocusChecker.canFocusValue != null) {
                    Modifier.Node node2 = (Modifier.Node) focusPropertiesModifierNode;
                    if (!node2.node.isAttached) {
                        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                    }
                    MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
                    Modifier.Node node3 = node2.node;
                    Modifier.Node node4 = node3.child;
                    if (node4 == null) {
                        HitTestResultKt.addLayoutNodeChildren(mutableVector, node3);
                    } else {
                        mutableVector.add(node4);
                    }
                    while (true) {
                        int i3 = mutableVector.size;
                        if (i3 == 0) {
                            break;
                        }
                        Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(i3 - 1);
                        if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                            HitTestResultKt.addLayoutNodeChildren(mutableVector, nodePop);
                        } else {
                            while (nodePop != null) {
                                if ((nodePop.kindSet & 1024) != 0) {
                                    MutableVector mutableVector2 = null;
                                    while (nodePop != null) {
                                        if (nodePop instanceof FocusTargetNode) {
                                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                                            FocusInvalidationManager focusInvalidationManager = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNode)).getFocusOwner()).focusInvalidationManager;
                                            if (focusInvalidationManager.focusTargetNodes.add(focusTargetNode)) {
                                                focusInvalidationManager.scheduleInvalidation$2();
                                            }
                                        } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                            int i4 = 0;
                                            for (Modifier.Node node5 = ((DelegatingNode) nodePop).delegate; node5 != null; node5 = node5.child) {
                                                if ((node5.kindSet & 1024) != 0) {
                                                    i4++;
                                                    if (i4 == 1) {
                                                        nodePop = node5;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (nodePop != null) {
                                                            mutableVector2.add(nodePop);
                                                            nodePop = null;
                                                        }
                                                        mutableVector2.add(node5);
                                                    }
                                                }
                                            }
                                            if (i4 == 1) {
                                            }
                                        }
                                        nodePop = HitTestResultKt.pop(mutableVector2);
                                    }
                                    break;
                                }
                                nodePop = nodePop.child;
                            }
                        }
                    }
                }
            }
            if ((i & 4096) != 0 && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) node;
                FocusInvalidationManager focusInvalidationManager2 = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusEventModifierNode)).getFocusOwner()).focusInvalidationManager;
                if (focusInvalidationManager2.focusEventNodes.add(focusEventModifierNode)) {
                    focusInvalidationManager2.scheduleInvalidation$2();
                }
            }
            if ((i & 2097152) != 0 && (node instanceof IndirectPointerInputModifierNode) && i2 == 2) {
                ((IndirectPointerInputModifierNode) node).onCancelIndirectPointerInput();
            }
        }
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        int i = node.kindSet;
        if (i != 0) {
            return i;
        }
        Class<?> cls = node.getClass();
        MutableObjectIntMap mutableObjectIntMap = classToKindSetMap;
        int iFindKeyIndex = mutableObjectIntMap.findKeyIndex(cls);
        if (iFindKeyIndex >= 0) {
            return mutableObjectIntMap.values[iFindKeyIndex];
        }
        int i2 = node instanceof LayoutModifierNode ? 3 : 1;
        if (node instanceof DrawModifierNode) {
            i2 |= 4;
        }
        if (node instanceof SemanticsModifierNode) {
            i2 |= 8;
        }
        if (node instanceof PointerInputModifierNode) {
            i2 |= 16;
        }
        if (node instanceof ModifierLocalModifierNode) {
            i2 |= 32;
        }
        if (node instanceof ParentDataModifierNode) {
            i2 |= 64;
        }
        if (node instanceof LayoutAwareModifierNode) {
            i2 |= 4194432;
        } else if (node instanceof MeasuredSizeAwareModifierNode) {
            i2 |= 128;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            i2 |= 256;
        }
        if (node instanceof FocusTargetNode) {
            i2 |= 1024;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            i2 |= 2048;
        }
        if (node instanceof FocusEventModifierNode) {
            i2 |= 4096;
        }
        if (node instanceof KeyInputModifierNode) {
            i2 |= 8192;
        }
        if (node instanceof AndroidComposeView.RootModifierNode) {
            i2 |= 16384;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            i2 |= 32768;
        }
        if (node instanceof TraversableNode) {
            i2 |= 262144;
        }
        if (node instanceof BringIntoViewModifierNode) {
            i2 |= 524288;
        }
        if (node instanceof UnplacedAwareModifierNode) {
            i2 |= ByteChannelKt.CHANNEL_MAX_SIZE;
        }
        if (node instanceof IndirectPointerInputModifierNode) {
            i2 |= 2097152;
        }
        if (node instanceof LazyLayoutBeyondBoundsProviderModifierNode) {
            i2 |= 8388608;
        }
        mutableObjectIntMap.set(i2, cls);
        return i2;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int iCalculateNodeKindSetFromIncludingDelegates = delegatingNode.selfKindSet;
        for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
            iCalculateNodeKindSetFromIncludingDelegates |= calculateNodeKindSetFromIncludingDelegates(node2);
        }
        return iCalculateNodeKindSetFromIncludingDelegates;
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m678getIncludeSelfInTraversalH91voCI(int i) {
        return ((i & 128) != 0) | ((i & 4194304) != 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int i = element instanceof LayoutModifier ? 3 : 1;
        if (element instanceof DrawModifier) {
            i |= 4;
        }
        if (element instanceof SemanticsModifier) {
            i |= 8;
        }
        if (element instanceof PointerInteropFilter) {
            i |= 16;
        }
        if (element instanceof ParentDataModifier) {
            i |= 64;
        }
        return element instanceof BringIntoViewModifierNode ? 524288 | i : i;
    }
}
