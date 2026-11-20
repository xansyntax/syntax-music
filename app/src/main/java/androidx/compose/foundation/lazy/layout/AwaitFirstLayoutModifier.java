package androidx.compose.foundation.lazy.layout;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.spatial.ThrottledCallbacks;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferredImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier$Node;", "Node", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AwaitFirstLayoutModifier extends ModifierNodeElement {
    public Node attachedNode;
    public CompletableDeferredImpl lock;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Node extends Modifier.Node {
        public ThrottledCallbacks.Entry handle;

        public Node() {
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onAttach() {
            AwaitFirstLayoutModifier awaitFirstLayoutModifier = AwaitFirstLayoutModifier.this;
            awaitFirstLayoutModifier.attachedNode = this;
            if (awaitFirstLayoutModifier.lock != null) {
                this.handle = RulerKt.registerOnLayoutRectChanged(this, new BackHandlerKt$$ExternalSyntheticLambda2(this, awaitFirstLayoutModifier, (byte) 25));
            }
        }

        @Override // androidx.compose.ui.Modifier.Node
        public final void onDetach() {
            AwaitFirstLayoutModifier awaitFirstLayoutModifier = AwaitFirstLayoutModifier.this;
            if (awaitFirstLayoutModifier.attachedNode == this) {
                awaitFirstLayoutModifier.attachedNode = null;
            }
            ThrottledCallbacks.Entry entry = this.handle;
            if (entry != null) {
                entry.unregister();
            }
            this.handle = null;
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new Node();
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 234;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
    }

    public final Object waitForFirstLayout(ContinuationImpl continuationImpl) {
        CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = this.lock;
        if (completableDeferredImplCompletableDeferred$default == null) {
            completableDeferredImplCompletableDeferred$default = AwaitKt.CompletableDeferred$default();
            this.lock = completableDeferredImplCompletableDeferred$default;
            Node node = this.attachedNode;
            if (node != null && node.isAttached) {
                node.handle = RulerKt.registerOnLayoutRectChanged(node, new BackHandlerKt$$ExternalSyntheticLambda2(node, AwaitFirstLayoutModifier.this, (byte) 25));
            }
        }
        Object objAwaitInternal = completableDeferredImplCompletableDeferred$default.awaitInternal(continuationImpl);
        return objAwaitInternal == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitInternal : Unit.INSTANCE;
    }
}
