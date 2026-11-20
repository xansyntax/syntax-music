package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/DisplayingDisappearingItemsNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class DisplayingDisappearingItemsElement extends ModifierNodeElement {
    public final LazyLayoutItemAnimator animator;

    public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
        this.animator = lazyLayoutItemAnimator;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        DisplayingDisappearingItemsNode displayingDisappearingItemsNode = new DisplayingDisappearingItemsNode();
        displayingDisappearingItemsNode.animator = this.animator;
        return displayingDisappearingItemsNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) obj).animator);
    }

    public final int hashCode() {
        return this.animator.hashCode();
    }

    public final String toString() {
        return "DisplayingDisappearingItemsElement(animator=" + this.animator + ")";
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        DisplayingDisappearingItemsNode displayingDisappearingItemsNode = (DisplayingDisappearingItemsNode) node;
        LazyLayoutItemAnimator lazyLayoutItemAnimator = displayingDisappearingItemsNode.animator;
        LazyLayoutItemAnimator lazyLayoutItemAnimator2 = this.animator;
        if (Intrinsics.areEqual(lazyLayoutItemAnimator, lazyLayoutItemAnimator2) || !displayingDisappearingItemsNode.node.isAttached) {
            return;
        }
        LazyLayoutItemAnimator lazyLayoutItemAnimator3 = displayingDisappearingItemsNode.animator;
        lazyLayoutItemAnimator3.releaseAnimations();
        lazyLayoutItemAnimator3.keyIndexMap = null;
        lazyLayoutItemAnimator3.firstVisibleIndex = -1;
        lazyLayoutItemAnimator2.displayingNode = displayingDisappearingItemsNode;
        displayingDisappearingItemsNode.animator = lazyLayoutItemAnimator2;
    }
}
