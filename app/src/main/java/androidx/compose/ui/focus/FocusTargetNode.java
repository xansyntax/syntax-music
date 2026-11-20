package androidx.compose.ui.focus;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsProviderModifierNode;
import androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.ComposedModifierKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.UnplacedAwareModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.emoji2.text.EmojiProcessor;
import coil3.size.SizeKt;
import com.google.common.math.IntMath;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusTargetNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, ObserverModifierNode, ModifierLocalModifierNode, UnplacedAwareModifierNode, DelegatableNode {
    public SaveableStateRegistry.Entry focusRestorationEntry;
    public final int focusability;
    public final boolean isInteropViewHost;
    public boolean isProcessingCustomEnter;
    public boolean isProcessingCustomExit;
    public final Function2 onFocusChange;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"androidx/compose/ui/focus/FocusTargetNode$FocusTargetElement", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FocusTargetElement extends ModifierNodeElement {
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            return new FocusTargetNode(0, null, 15);
        }

        public final boolean equals(Object obj) {
            return obj == this;
        }

        public final int hashCode() {
            return 1739042953;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(Modifier.Node node) {
        }
    }

    public FocusTargetNode(int i, Function2 function2, int i2) {
        i = (i2 & 1) != 0 ? 1 : i;
        boolean z = (i2 & 2) == 0;
        function2 = (i2 & 4) != 0 ? null : function2;
        this.isInteropViewHost = z;
        this.onFocusChange = function2;
        this.focusability = i;
    }

    /* JADX INFO: renamed from: assignFocus-3ESFkO8, reason: not valid java name */
    public final boolean m417assignFocus3ESFkO8(int i) {
        int iOrdinal = FocusTraversalKt.m427performCustomRequestFocusMxy_nc0(this, i).ordinal();
        if (iOrdinal == 0) {
            return FocusTraversalKt.performRequestFocus(this);
        }
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal == 2) {
            return true;
        }
        if (iOrdinal == 3) {
            return false;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final void dispatchFocusCallbacks$ui(FocusStateImpl focusStateImpl, FocusStateImpl focusStateImpl2) {
        NodeChain nodeChain;
        Function2 function2;
        FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
        FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
        if (!focusStateImpl.equals(focusStateImpl2) && (function2 = this.onFocusChange) != null) {
            function2.invoke(focusStateImpl, focusStateImpl2);
        }
        Modifier.Node node = this.node;
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = this.node;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 5120) != 0) {
                while (node2 != null) {
                    int i = node2.kindSet;
                    if ((i & 5120) != 0) {
                        if (node2 != node && (i & 1024) != 0) {
                            return;
                        }
                        if ((i & 4096) != 0) {
                            ?? Pop = node2;
                            ?? mutableVector = 0;
                            while (Pop != 0) {
                                if (Pop instanceof FocusEventModifierNode) {
                                    FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) Pop;
                                    if (activeFocusTargetNode == focusOwnerImpl.getActiveFocusTargetNode()) {
                                        focusEventModifierNode.onFocusEvent(focusStateImpl2);
                                    }
                                } else if ((Pop.kindSet & 4096) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node3 = ((DelegatingNode) Pop).delegate;
                                    int i2 = 0;
                                    Pop = Pop;
                                    mutableVector = mutableVector;
                                    while (node3 != null) {
                                        if ((node3.kindSet & 4096) != 0) {
                                            i2++;
                                            if (i2 == 1) {
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
                                        }
                                        node3 = node3.child;
                                        Pop = Pop;
                                        mutableVector = mutableVector;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                Pop = HitTestResultKt.pop(mutableVector);
                            }
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
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    public final FocusPropertiesImpl fetchFocusProperties$ui() {
        boolean z;
        NodeChain nodeChain;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        focusPropertiesImpl.canFocus = true;
        FocusRequester focusRequester = FocusRequester.Default;
        focusPropertiesImpl.next = focusRequester;
        focusPropertiesImpl.previous = focusRequester;
        focusPropertiesImpl.up = focusRequester;
        focusPropertiesImpl.down = focusRequester;
        focusPropertiesImpl.left = focusRequester;
        focusPropertiesImpl.right = focusRequester;
        focusPropertiesImpl.start = focusRequester;
        focusPropertiesImpl.end = focusRequester;
        focusPropertiesImpl.onEnter = new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 3);
        focusPropertiesImpl.onExit = new ComposedModifierKt$$ExternalSyntheticLambda0((byte) 4);
        focusPropertiesImpl.focusRect = FocusProperties.Companion.UnsetFocusRect;
        int i = this.focusability;
        if (i == 1) {
            z = true;
        } else if (i == 0) {
            z = !(((InputMode) ((InputModeManagerImpl) ((InputModeManager) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalInputModeManager))).inputMode$delegate.getValue()).value == 1);
        } else {
            if (i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unknown Focusability");
                return null;
            }
            z = false;
        }
        focusPropertiesImpl.canFocus = z;
        Modifier.Node node = this.node;
        if (!node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = this.node;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 3072) != 0) {
                while (node2 != null) {
                    int i2 = node2.kindSet;
                    if ((i2 & 3072) != 0) {
                        if (node2 != node && (i2 & 1024) != 0) {
                            break loop0;
                        }
                        if ((i2 & 2048) != 0) {
                            ?? mutableVector = 0;
                            ?? Pop = node2;
                            while (Pop != 0) {
                                if (Pop instanceof FocusPropertiesModifierNode) {
                                    ((FocusPropertiesModifierNode) Pop).applyFocusProperties(focusPropertiesImpl);
                                } else if ((Pop.kindSet & 2048) != 0 && (Pop instanceof DelegatingNode)) {
                                    Modifier.Node node3 = ((DelegatingNode) Pop).delegate;
                                    int i3 = 0;
                                    while (node3 != null) {
                                        if ((node3.kindSet & 2048) != 0) {
                                            i3++;
                                            if (i3 == 1) {
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
                                    if (i3 == 1) {
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
                    node2 = node2.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node2 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        return focusPropertiesImpl;
    }

    public final Rect fetchFocusRect$ui(LayoutCoordinates layoutCoordinates) {
        Rect rect = fetchFocusProperties$ui().focusRect;
        if (rect != FocusProperties.Companion.UnsetFocusRect) {
            return layoutCoordinates == null ? rect : rect.m446translatek4lQ0M(layoutCoordinates.mo605localPositionOfS_NoaFU(HitTestResultKt.requireLayoutCoordinates(this), 0L));
        }
        return layoutCoordinates != null ? layoutCoordinates.localBoundingBoxOf(HitTestResultKt.requireLayoutCoordinates(this), false) : IntMath.m896Recttz77jQw(0L, SizeKt.m876toSizeozmzZPI(HitTestResultKt.requireLayoutCoordinates(this).measuredSize));
    }

    public final LazyLayoutBeyondBoundsProviderModifierNode getBeyondBoundsLayoutParent() {
        NodeChain nodeChain;
        Object obj;
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = this.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8388640) != 0) {
                while (node != null) {
                    int i = node.kindSet;
                    if ((i & 8388640) != 0) {
                        if ((8388608 & i) != 0) {
                            if (!(node instanceof LazyLayoutBeyondBoundsProviderModifierNode)) {
                                if (node instanceof DelegatingNode) {
                                    node = null;
                                    for (Modifier.Node node2 = ((DelegatingNode) node).delegate; node2 != null; node2 = node2.child) {
                                        if (node2 instanceof LazyLayoutBeyondBoundsProviderModifierNode) {
                                            node = node2;
                                        }
                                    }
                                } else {
                                    node = null;
                                }
                            }
                            LazyLayoutBeyondBoundsProviderModifierNode lazyLayoutBeyondBoundsProviderModifierNode = (LazyLayoutBeyondBoundsProviderModifierNode) node;
                            if (lazyLayoutBeyondBoundsProviderModifierNode != null) {
                                return lazyLayoutBeyondBoundsProviderModifierNode;
                            }
                        } else if ((i & 32) == 0) {
                            continue;
                        } else {
                            if (node instanceof ModifierLocalModifierNode) {
                                obj = node;
                            } else if (node instanceof DelegatingNode) {
                                obj = null;
                                for (Modifier.Node node3 = ((DelegatingNode) node).delegate; node3 != null; node3 = node3.child) {
                                    if (node3 instanceof ModifierLocalModifierNode) {
                                        obj = node3;
                                    }
                                }
                            } else {
                                obj = null;
                            }
                            ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) obj;
                            if (modifierLocalModifierNode != null && modifierLocalModifierNode.getProvidedValues().contains$ui(RulerKt.ModifierLocalBeyondBoundsLayout)) {
                                return (LazyLayoutBeyondBoundsProviderModifierNode) modifierLocalModifierNode.getProvidedValues().get$ui();
                            }
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

    public final FocusStateImpl getFocusState$1() {
        FocusTargetNode activeFocusTargetNode;
        NodeChain nodeChain;
        boolean z = this.isAttached;
        FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
        if (!z || (activeFocusTargetNode = ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).getActiveFocusTargetNode()) == null) {
            return focusStateImpl;
        }
        if (this == activeFocusTargetNode) {
            return FocusStateImpl.Active;
        }
        if (activeFocusTargetNode.isAttached) {
            if (!activeFocusTargetNode.node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = activeFocusTargetNode.node.parent;
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
            while (layoutNodeRequireLayoutNode != null) {
                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                    while (node != null) {
                        if ((node.kindSet & 1024) != 0) {
                            Modifier.Node nodePop = node;
                            MutableVector mutableVector = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    if (this == ((FocusTargetNode) nodePop)) {
                                        return FocusStateImpl.ActiveParent;
                                    }
                                } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 1024) != 0) {
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
                        }
                        node = node.parent;
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
            }
        }
        return focusStateImpl;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void invalidateFocus$ui() {
        int iOrdinal = getFocusState$1().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return;
                }
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.observeReads(this, new Recomposer$$ExternalSyntheticLambda6((Object) ref$ObjectRef, (Object) this, (byte) 26));
        Object obj = ref$ObjectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            throw null;
        }
        if (((FocusProperties) obj).getCanFocus()) {
            return;
        }
        ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).m409clearFocusI7lrPNg(8, true, true);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        FocusOwnerImpl focusOwnerImpl;
        int iOrdinal = getFocusState$1().ordinal();
        if (iOrdinal == 0) {
            focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
            focusOwnerImpl.m409clearFocusI7lrPNg(8, true, false);
            if (this.isInteropViewHost) {
                focusOwnerImpl.platformFocusOwner.m689requestOwnerFocus7o62pno();
            }
            focusOwnerImpl.focusInvalidationManager.scheduleInvalidation$2();
        } else if (iOrdinal == 1) {
            FocusOwner focusOwner = ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this);
            if (focusTargetNodeFindActiveFocusNode != null && focusTargetNodeFindActiveFocusNode.isInteropViewHost) {
                FocusOwnerImpl focusOwnerImpl2 = (FocusOwnerImpl) focusOwner;
                focusOwnerImpl2.platformFocusOwner.m689requestOwnerFocus7o62pno();
                focusOwnerImpl2.focusInvalidationManager.scheduleInvalidation$2();
            }
        } else if (iOrdinal == 2) {
            focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
            focusOwnerImpl.m409clearFocusI7lrPNg(8, true, false);
            if (this.isInteropViewHost) {
                focusOwnerImpl.platformFocusOwner.m689requestOwnerFocus7o62pno();
            }
            focusOwnerImpl.focusInvalidationManager.scheduleInvalidation$2();
        } else if (iOrdinal != 3) {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return;
        }
        SaveableStateRegistry.Entry entry = this.focusRestorationEntry;
        if (entry != null) {
            ((EmojiProcessor) entry).unregister();
        }
        this.focusRestorationEntry = null;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        invalidateFocus$ui();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        if (getFocusState$1().isFocused()) {
            ((FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner()).m409clearFocusI7lrPNg(8, true, true);
        }
    }

    /* JADX INFO: renamed from: requestFocus-3ESFkO8, reason: not valid java name */
    public final boolean m418requestFocus3ESFkO8(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            return fetchFocusProperties$ui().canFocus ? m417assignFocus3ESFkO8(i) : FocusTraversalKt.m421findChildCorrespondingToFocusEnterOMvw8(this, i, new TimePickerKt$$ExternalSyntheticLambda36((byte) 5, i));
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
    }

    @Override // androidx.compose.ui.node.UnplacedAwareModifierNode
    public final void onUnplaced() {
    }
}
