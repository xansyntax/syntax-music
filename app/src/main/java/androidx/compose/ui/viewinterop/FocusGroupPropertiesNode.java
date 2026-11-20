package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.CancelIndicatingFocusBoundaryScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    public ViewTreeObserver attachedViewTreeObserver;
    public final FocusGroupPropertiesNode$$ExternalSyntheticLambda0 onEnter;
    public final FocusGroupPropertiesNode$$ExternalSyntheticLambda0 onExit;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0] */
    public FocusGroupPropertiesNode() {
        final byte b = 0;
        this.onEnter = new Function1(this) { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0
            public final /* synthetic */ FocusGroupPropertiesNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b2 = b;
                Unit unit = Unit.INSTANCE;
                FocusGroupPropertiesNode focusGroupPropertiesNode = this.f$0;
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = (CancelIndicatingFocusBoundaryScope) obj;
                switch (b2) {
                    case 0:
                        View embeddedView = AndroidView_androidKt.getEmbeddedView(focusGroupPropertiesNode);
                        if (!embeddedView.isFocused() && !embeddedView.hasFocus()) {
                            FocusOwner focusOwner = ((AndroidComposeView) HitTestResultKt.requireOwner(focusGroupPropertiesNode)).getFocusOwner();
                            View viewRequireView = HitTestResultKt.requireView(focusGroupPropertiesNode);
                            Integer numM408toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(cancelIndicatingFocusBoundaryScope.requestedFocusDirection);
                            int[] iArr = new int[2];
                            viewRequireView.getLocationOnScreen(iArr);
                            int[] iArr2 = new int[2];
                            embeddedView.getLocationOnScreen(iArr2);
                            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) focusOwner).rootFocusNode);
                            Rect rect = null;
                            androidx.compose.ui.geometry.Rect rectFocusRect = focusTargetNodeFindActiveFocusNode != null ? FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode) : null;
                            if (rectFocusRect != null) {
                                int i = (int) rectFocusRect.left;
                                int i2 = iArr[0];
                                int i3 = iArr2[0];
                                int i4 = (int) rectFocusRect.top;
                                int i5 = iArr[1];
                                int i6 = iArr2[1];
                                rect = new Rect((i + i2) - i3, (i4 + i5) - i6, (((int) rectFocusRect.right) + i2) - i3, (((int) rectFocusRect.bottom) + i5) - i6);
                            }
                            if (!FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, numM408toAndroidFocusDirection3ESFkO8, rect)) {
                                cancelIndicatingFocusBoundaryScope.isCanceled = true;
                            }
                        }
                        break;
                    default:
                        AndroidView_androidKt.getEmbeddedView(focusGroupPropertiesNode);
                        break;
                }
                return unit;
            }
        };
        final byte b2 = 1;
        this.onExit = new Function1(this) { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$$ExternalSyntheticLambda0
            public final /* synthetic */ FocusGroupPropertiesNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte b3 = b2;
                Unit unit = Unit.INSTANCE;
                FocusGroupPropertiesNode focusGroupPropertiesNode = this.f$0;
                CancelIndicatingFocusBoundaryScope cancelIndicatingFocusBoundaryScope = (CancelIndicatingFocusBoundaryScope) obj;
                switch (b3) {
                    case 0:
                        View embeddedView = AndroidView_androidKt.getEmbeddedView(focusGroupPropertiesNode);
                        if (!embeddedView.isFocused() && !embeddedView.hasFocus()) {
                            FocusOwner focusOwner = ((AndroidComposeView) HitTestResultKt.requireOwner(focusGroupPropertiesNode)).getFocusOwner();
                            View viewRequireView = HitTestResultKt.requireView(focusGroupPropertiesNode);
                            Integer numM408toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m408toAndroidFocusDirection3ESFkO8(cancelIndicatingFocusBoundaryScope.requestedFocusDirection);
                            int[] iArr = new int[2];
                            viewRequireView.getLocationOnScreen(iArr);
                            int[] iArr2 = new int[2];
                            embeddedView.getLocationOnScreen(iArr2);
                            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(((FocusOwnerImpl) focusOwner).rootFocusNode);
                            Rect rect = null;
                            androidx.compose.ui.geometry.Rect rectFocusRect = focusTargetNodeFindActiveFocusNode != null ? FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode) : null;
                            if (rectFocusRect != null) {
                                int i = (int) rectFocusRect.left;
                                int i2 = iArr[0];
                                int i3 = iArr2[0];
                                int i4 = (int) rectFocusRect.top;
                                int i5 = iArr[1];
                                int i6 = iArr2[1];
                                rect = new Rect((i + i2) - i3, (i4 + i5) - i6, (((int) rectFocusRect.right) + i2) - i3, (((int) rectFocusRect.bottom) + i5) - i6);
                            }
                            if (!FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, numM408toAndroidFocusDirection3ESFkO8, rect)) {
                                cancelIndicatingFocusBoundaryScope.isCanceled = true;
                            }
                        }
                        break;
                    default:
                        AndroidView_androidKt.getEmbeddedView(focusGroupPropertiesNode);
                        break;
                }
                return unit;
            }
        };
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public final void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    public final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        boolean z;
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = this.node;
        if ((node.aggregateChildKindSet & 1024) != 0) {
            boolean z2 = false;
            for (Modifier.Node node2 = node.child; node2 != null; node2 = node2.child) {
                if ((node2.kindSet & 1024) != 0) {
                    Modifier.Node nodePop = node2;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodePop;
                            if (z2) {
                                return focusTargetNode;
                            }
                            z = false;
                            z2 = true;
                        } else {
                            z = true;
                        }
                        if (z && (nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                if ((node3.kindSet & 1024) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = node3;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (nodePop != null) {
                                            mutableVector.add(nodePop);
                                            nodePop = null;
                                        }
                                        mutableVector.add(node3);
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = HitTestResultKt.pop(mutableVector);
                    }
                }
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not find focus target of embedded view wrapper");
        return null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        ViewTreeObserver viewTreeObserver = HitTestResultKt.requireView(this).getViewTreeObserver();
        this.attachedViewTreeObserver = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        ViewTreeObserver viewTreeObserver = this.attachedViewTreeObserver;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.attachedViewTreeObserver = null;
        HitTestResultKt.requireView(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        boolean z;
        if (HitTestResultKt.requireLayoutNode(this).owner == null) {
            return;
        }
        View embeddedView = AndroidView_androidKt.getEmbeddedView(this);
        FocusOwner focusOwner = ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getFocusOwner();
        Owner ownerRequireOwner = HitTestResultKt.requireOwner(this);
        boolean z2 = true;
        if (view != null && !view.equals(ownerRequireOwner)) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    z = false;
                    break;
                } else {
                    if (parent == embeddedView.getParent()) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
            }
        } else {
            z = false;
            break;
        }
        if (view2 != null && !view2.equals(ownerRequireOwner)) {
            ViewParent parent2 = view2.getParent();
            while (true) {
                if (parent2 == null) {
                    z2 = false;
                    break;
                } else if (parent2 == embeddedView.getParent()) {
                    break;
                } else {
                    parent2 = parent2.getParent();
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (z && z2) {
            return;
        }
        if (z2) {
            FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
            if (focusTargetOfEmbeddedViewWrapper.getFocusState$1().getHasFocus()) {
                return;
            }
            FocusTraversalKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
            return;
        }
        if (z && getFocusTargetOfEmbeddedViewWrapper().getFocusState$1().isFocused()) {
            ((FocusOwnerImpl) focusOwner).m409clearFocusI7lrPNg(8, false, false);
        }
    }
}
