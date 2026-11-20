package androidx.compose.ui;

import androidx.compose.foundation.BackgroundNode;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.input.pointer.PointerInputResetException;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Modifier {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Element extends Modifier {
        @Override // androidx.compose.ui.Modifier
        default boolean all(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.compose.ui.Modifier
        default Object foldIn(Object obj, Function2 function2) {
            return function2.invoke(obj, this);
        }
    }

    boolean all(Function1 function1);

    Object foldIn(Object obj, Function2 function2);

    default Modifier then(Modifier modifier) {
        return modifier == Companion.$$INSTANCE ? this : new CombinedModifier(this, modifier);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Node implements DelegatableNode {
        public Node child;
        public NodeCoordinator coordinator;
        public Recomposer$$ExternalSyntheticLambda6 detachedListener;
        public boolean insertedNodeAwaitingAttachForInvalidation;
        public boolean isAttached;
        public int kindSet;
        public boolean onAttachRunExpected;
        public boolean onDetachRunExpected;
        public ObserverNodeOwnerScope ownerScope;
        public Node parent;
        public ContextScope scope;
        public boolean updatedNodeAwaitingAttachForInvalidation;
        public Node node = this;
        public int aggregateChildKindSet = -1;

        public final CoroutineScope getCoroutineScope() {
            ContextScope contextScope = this.scope;
            if (contextScope != null) {
                return contextScope;
            }
            ContextScope contextScopeCoroutineScope = AwaitKt.CoroutineScope(((AndroidComposeView) HitTestResultKt.requireOwner(this)).getCoroutineContext().plus(new JobImpl((Job) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getCoroutineContext().get(Job.Key.$$INSTANCE))));
            this.scope = contextScopeCoroutineScope;
            return contextScopeCoroutineScope;
        }

        public boolean getShouldAutoInvalidate() {
            return !(this instanceof BackgroundNode);
        }

        public void markAsAttached$ui() {
            if (this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("node attached multiple times");
            }
            if (this.coordinator == null) {
                InlineClassHelperKt.throwIllegalStateException("attach invoked on a node without a coordinator");
            }
            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void markAsDetached$ui() {
            if (!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("Cannot detach a node that is not attached");
            }
            if (this.onAttachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (this.onDetachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.isAttached = false;
            ContextScope contextScope = this.scope;
            if (contextScope != null) {
                AwaitKt.cancel(contextScope, new PointerInputResetException("The Modifier.Node was detached", (byte) 0));
                this.scope = null;
            }
        }

        public void reset$ui() {
            if (!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("reset() called on an unattached node");
            }
            onReset();
        }

        public void runAttachLifecycle$ui() {
            if (!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.onAttachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui() {
            if (!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("node detached multiple times");
            }
            if (this.coordinator == null) {
                InlineClassHelperKt.throwIllegalStateException("detach invoked on a node without a coordinator");
            }
            if (!this.onDetachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.onDetachRunExpected = false;
            Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = this.detachedListener;
            if (recomposer$$ExternalSyntheticLambda6 != null) {
                recomposer$$ExternalSyntheticLambda6.invoke();
            }
            onDetach();
        }

        public void setAsDelegateTo$ui(Node node) {
            this.node = node;
        }

        public void updateCoordinator$ui(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Companion implements Modifier {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Override // androidx.compose.ui.Modifier
        public final boolean all(Function1 function1) {
            return true;
        }

        public final String toString() {
            return "Modifier";
        }

        @Override // androidx.compose.ui.Modifier
        public final Modifier then(Modifier modifier) {
            return modifier;
        }

        @Override // androidx.compose.ui.Modifier
        public final Object foldIn(Object obj, Function2 function2) {
            return obj;
        }
    }
}
