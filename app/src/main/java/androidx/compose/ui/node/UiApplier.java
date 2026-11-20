package androidx.compose.ui.node;

import android.view.View;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.viewinterop.ViewFactoryHolder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UiApplier implements Applier {
    public Object current;
    public final Object root;
    public final ArrayList stack = new ArrayList();

    public UiApplier(LayoutNode layoutNode) {
        this.root = layoutNode;
        this.current = layoutNode;
    }

    public final void clear() {
        this.stack.clear();
        this.current = this.root;
        ((LayoutNode) this.root).removeAll$ui();
    }

    @Override // androidx.compose.runtime.Applier
    public final void down(Object obj) {
        this.stack.add(this.current);
        this.current = obj;
    }

    @Override // androidx.compose.runtime.Applier
    public final Object getCurrent() {
        return this.current;
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertBottomUp(int i, Object obj) {
        ((LayoutNode) this.current).insertAt$ui(i, (LayoutNode) obj);
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertTopDown(int i, Object obj) {
    }

    @Override // androidx.compose.runtime.Applier
    public final void move(int i, int i2, int i3) {
        ((LayoutNode) this.current).move$ui(i, i2, i3);
    }

    @Override // androidx.compose.runtime.Applier
    public final void onEndChanges() {
        Owner owner = ((LayoutNode) this.root).owner;
        if (owner != null) {
            ((AndroidComposeView) owner).onEndApplyChanges();
        }
    }

    @Override // androidx.compose.runtime.Applier
    public final void remove(int i, int i2) {
        ((LayoutNode) this.current).removeAt$ui(i, i2);
    }

    @Override // androidx.compose.runtime.Applier
    public final void reuse() {
        RectManager rectManager;
        AndroidAutofillManager androidAutofillManagerM694getAutofillManager;
        RectManager rectManager2;
        LayoutNode layoutNode = (LayoutNode) this.current;
        NodeChain nodeChain = layoutNode.nodes;
        if (!layoutNode.isAttached$1()) {
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }
        ViewFactoryHolder viewFactoryHolder = layoutNode.interopViewFactoryHolder;
        if (viewFactoryHolder != null) {
            View view = viewFactoryHolder.view;
            if (view.getParent() != viewFactoryHolder) {
                viewFactoryHolder.addView(view);
            } else {
                viewFactoryHolder.reset.invoke();
            }
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = layoutNode.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.markActiveNodesAsReused(false);
        }
        layoutNode.isCurrentlyCalculatingSemanticsConfiguration = false;
        if (layoutNode.isDeactivated) {
            layoutNode.isDeactivated = false;
        } else {
            Modifier.Node node = (TailModifierNode) nodeChain.tail;
            for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
                if (node2.isAttached) {
                    node2.reset$ui();
                }
            }
            for (Modifier.Node node3 = node; node3 != null; node3 = node3.parent) {
                if (node3.isAttached) {
                    node3.runDetachLifecycle$ui();
                }
            }
            while (node != null) {
                if (node.isAttached) {
                    node.markAsDetached$ui();
                }
                node = node.parent;
            }
        }
        int i = layoutNode.semanticsId;
        Owner owner = layoutNode.owner;
        if (owner != null && (rectManager2 = ((AndroidComposeView) owner).getRectManager()) != null) {
            rectManager2.remove(layoutNode);
        }
        layoutNode.semanticsId = SemanticsModifierKt.lastIdentifier.addAndGet(1);
        Owner owner2 = layoutNode.owner;
        if (owner2 != null) {
            AndroidComposeView androidComposeView = (AndroidComposeView) owner2;
            androidComposeView.getLayoutNodes().remove(i);
            androidComposeView.getLayoutNodes().set(layoutNode.semanticsId, layoutNode);
        }
        for (Modifier.Node node4 = (Modifier.Node) nodeChain.head; node4 != null; node4 = node4.child) {
            node4.markAsAttached$ui();
        }
        nodeChain.runAttachLifecycle();
        if (nodeChain.m662hasH91voCI$ui(8)) {
            layoutNode.invalidateSemantics$ui();
        }
        LayoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode);
        Owner owner3 = layoutNode.owner;
        if (owner3 != null && (androidAutofillManagerM694getAutofillManager = ((AndroidComposeView) owner3).m694getAutofillManager()) != null) {
            AndroidComposeView androidComposeView2 = androidAutofillManagerM694getAutofillManager.view;
            WeakCache weakCache = androidAutofillManagerM694getAutofillManager.platformAutofillManager;
            MutableIntSet mutableIntSet = androidAutofillManagerM694getAutofillManager.currentlyDisplayedIDs;
            if (mutableIntSet.remove(i)) {
                weakCache.notifyViewVisibilityChanged(androidComposeView2, i, false);
            }
            SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.props.contains(SemanticsProperties.ContentType)) {
                mutableIntSet.add(layoutNode.semanticsId);
                weakCache.notifyViewVisibilityChanged(androidComposeView2, layoutNode.semanticsId, true);
            }
        }
        Owner owner4 = layoutNode.owner;
        if (owner4 == null || (rectManager = ((AndroidComposeView) owner4).getRectManager()) == null) {
            return;
        }
        rectManager.recalculateRectIfDirty(layoutNode);
    }

    @Override // androidx.compose.runtime.Applier
    public final void up() {
        this.current = Stack.m388popimpl(this.stack);
    }
}
