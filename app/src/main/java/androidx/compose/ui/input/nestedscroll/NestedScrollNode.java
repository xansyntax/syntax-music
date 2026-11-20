package androidx.compose.ui.input.nestedscroll;

import androidx.compose.material3.TextKt$$ExternalSyntheticLambda3;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Velocity;
import androidx.navigation.NavGraphNavigator$$ExternalSyntheticLambda0;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public NestedScrollConnection connection;
    public NestedScrollNode lastKnownParentNode;
    public NestedScrollDispatcher resolvedDispatcher;
    public final String traverseKey;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final CoroutineScope getNestedCoroutineScope() {
        NestedScrollNode parentNestedScrollNode$ui = getParentNestedScrollNode$ui();
        CoroutineScope nestedCoroutineScope = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.getNestedCoroutineScope() : null;
        return (nestedCoroutineScope == null || !AwaitKt.isActive(nestedCoroutineScope)) ? this.resolvedDispatcher.scope : nestedCoroutineScope;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui() {
        NodeChain nodeChain;
        TraversableNode traversableNode = null;
        if (!this.isAttached) {
            return null;
        }
        if (!this.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = this.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(this);
        loop0: while (layoutNodeRequireLayoutNode != null) {
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 262144) != 0) {
                while (node != null) {
                    if ((node.kindSet & 262144) != 0) {
                        Modifier.Node nodePop = node;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof TraversableNode) {
                                TraversableNode traversableNode2 = (TraversableNode) nodePop;
                                if (Intrinsics.areEqual(this.traverseKey, traversableNode2.getTraverseKey()) && NestedScrollNode.class == traversableNode2.getClass()) {
                                    traversableNode = traversableNode2;
                                    break loop0;
                                }
                            }
                            if ((nodePop.kindSet & 262144) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node node2 = ((DelegatingNode) nodePop).delegate; node2 != null; node2 = node2.child) {
                                    if ((node2.kindSet & 262144) != 0) {
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
        return (NestedScrollNode) traversableNode;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        NestedScrollDispatcher nestedScrollDispatcher = this.resolvedDispatcher;
        nestedScrollDispatcher.nestedScrollNode = this;
        nestedScrollDispatcher.lastKnownParentNode = null;
        this.lastKnownParentNode = null;
        nestedScrollDispatcher.calculateNestedScrollScope = new RoomDatabase$$ExternalSyntheticLambda0((byte) 9, this);
        nestedScrollDispatcher.scope = getCoroutineScope();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        TextKt$$ExternalSyntheticLambda3 textKt$$ExternalSyntheticLambda3 = NestedScrollNodeKt.CancelledNestedScope;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        HitTestResultKt.traverseAncestors(this, new NavGraphNavigator$$ExternalSyntheticLambda0(ref$ObjectRef, (byte) 3));
        NestedScrollNode nestedScrollNode = (NestedScrollNode) ((TraversableNode) ref$ObjectRef.element);
        this.lastKnownParentNode = nestedScrollNode;
        NestedScrollDispatcher nestedScrollDispatcher = this.resolvedDispatcher;
        nestedScrollDispatcher.lastKnownParentNode = nestedScrollNode;
        if (nestedScrollDispatcher.nestedScrollNode == this) {
            nestedScrollDispatcher.nestedScrollNode = null;
            nestedScrollDispatcher.scope = null;
            nestedScrollDispatcher.calculateNestedScrollScope = NestedScrollNodeKt.CancelledNestedScope;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final Object mo99onPostFlingRZ2iAVY(long j, long j2, Continuation continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i = nestedScrollNode$onPostFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, (ContinuationImpl) continuation);
        }
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$2 = nestedScrollNode$onPostFling$1;
        Object objMo99onPostFlingRZ2iAVY = nestedScrollNode$onPostFling$2.result;
        int i2 = nestedScrollNode$onPostFling$2.label;
        NestedScrollNode parentNestedScrollNode$ui = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
            NestedScrollConnection nestedScrollConnection = this.connection;
            nestedScrollNode$onPostFling$2.J$0 = j;
            nestedScrollNode$onPostFling$2.J$1 = j2;
            nestedScrollNode$onPostFling$2.label = 1;
            objMo99onPostFlingRZ2iAVY = nestedScrollConnection.mo99onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$2);
            if (objMo99onPostFlingRZ2iAVY != coroutineSingletons) {
                j3 = j;
                j4 = j2;
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            j4 = nestedScrollNode$onPostFling$2.J$1;
            j3 = nestedScrollNode$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j7 = nestedScrollNode$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo99onPostFlingRZ2iAVY);
        }
        j6 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        j5 = j7;
        return new Velocity(Velocity.m822plusAH228Gc(j5, j6));
        j5 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
        boolean z = this.isAttached;
        if (!z) {
            parentNestedScrollNode$ui = this.lastKnownParentNode;
        } else if (z) {
            parentNestedScrollNode$ui = getParentNestedScrollNode$ui();
        }
        if (parentNestedScrollNode$ui != null) {
            long jM822plusAH228Gc = Velocity.m822plusAH228Gc(j3, j5);
            long jM821minusAH228Gc = Velocity.m821minusAH228Gc(j4, j5);
            nestedScrollNode$onPostFling$2.J$0 = j5;
            nestedScrollNode$onPostFling$2.label = 2;
            objMo99onPostFlingRZ2iAVY = parentNestedScrollNode$ui.mo99onPostFlingRZ2iAVY(jM822plusAH228Gc, jM821minusAH228Gc, nestedScrollNode$onPostFling$2);
            if (objMo99onPostFlingRZ2iAVY != coroutineSingletons) {
                j7 = j5;
                j6 = ((Velocity) objMo99onPostFlingRZ2iAVY).packedValue;
                j5 = j7;
            }
            return coroutineSingletons;
        }
        j6 = 0;
        return new Velocity(Velocity.m822plusAH228Gc(j5, j6));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final long mo100onPostScrollDzOQY0M(int i, long j, long j2) {
        long jMo100onPostScrollDzOQY0M = this.connection.mo100onPostScrollDzOQY0M(i, j, j2);
        NestedScrollNode parentNestedScrollNode$ui = this.isAttached ? getParentNestedScrollNode$ui() : null;
        return Offset.m439plusMKHz9U(jMo100onPostScrollDzOQY0M, parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo100onPostScrollDzOQY0M(i, Offset.m439plusMKHz9U(j, jMo100onPostScrollDzOQY0M), Offset.m438minusMKHz9U(j2, jMo100onPostScrollDzOQY0M)) : 0L);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r9 == r5) goto L27;
     */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo326onPreFlingQWom1Mo(long j, Continuation continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        long j2;
        long j3;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            int i = nestedScrollNode$onPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, (ContinuationImpl) continuation);
            }
        } else {
            nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, (ContinuationImpl) continuation);
        }
        Object objMo326onPreFlingQWom1Mo = nestedScrollNode$onPreFling$1.result;
        int i2 = nestedScrollNode$onPreFling$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 != 0) {
            if (i2 == 1) {
                j = nestedScrollNode$onPreFling$1.J$0;
                ResultKt.throwOnFailure(objMo326onPreFlingQWom1Mo);
            } else {
                if (i2 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j3 = nestedScrollNode$onPreFling$1.J$0;
                ResultKt.throwOnFailure(objMo326onPreFlingQWom1Mo);
            }
            return new Velocity(Velocity.m822plusAH228Gc(j3, ((Velocity) objMo326onPreFlingQWom1Mo).packedValue));
        }
        ResultKt.throwOnFailure(objMo326onPreFlingQWom1Mo);
        NestedScrollNode parentNestedScrollNode$ui = this.isAttached ? getParentNestedScrollNode$ui() : null;
        if (parentNestedScrollNode$ui != null) {
            nestedScrollNode$onPreFling$1.J$0 = j;
            nestedScrollNode$onPreFling$1.label = 1;
            objMo326onPreFlingQWom1Mo = parentNestedScrollNode$ui.mo326onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
        } else {
            j2 = 0;
            NestedScrollConnection nestedScrollConnection = this.connection;
            long jM821minusAH228Gc = Velocity.m821minusAH228Gc(j, j2);
            nestedScrollNode$onPreFling$1.J$0 = j2;
            nestedScrollNode$onPreFling$1.label = 2;
            objMo326onPreFlingQWom1Mo = nestedScrollConnection.mo326onPreFlingQWom1Mo(jM821minusAH228Gc, nestedScrollNode$onPreFling$1);
            if (objMo326onPreFlingQWom1Mo != coroutineSingletons) {
                j3 = j2;
                return new Velocity(Velocity.m822plusAH228Gc(j3, ((Velocity) objMo326onPreFlingQWom1Mo).packedValue));
            }
        }
        return coroutineSingletons;
        j2 = ((Velocity) objMo326onPreFlingQWom1Mo).packedValue;
        NestedScrollConnection nestedScrollConnection2 = this.connection;
        long jM821minusAH228Gc2 = Velocity.m821minusAH228Gc(j, j2);
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        objMo326onPreFlingQWom1Mo = nestedScrollConnection2.mo326onPreFlingQWom1Mo(jM821minusAH228Gc2, nestedScrollNode$onPreFling$1);
        if (objMo326onPreFlingQWom1Mo != coroutineSingletons) {
            j3 = j2;
            return new Velocity(Velocity.m822plusAH228Gc(j3, ((Velocity) objMo326onPreFlingQWom1Mo).packedValue));
        }
        return coroutineSingletons;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final long mo178onPreScrollOzD1aCk(int i, long j) {
        NestedScrollNode parentNestedScrollNode$ui = this.isAttached ? getParentNestedScrollNode$ui() : null;
        long jMo178onPreScrollOzD1aCk = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo178onPreScrollOzD1aCk(i, j) : 0L;
        return Offset.m439plusMKHz9U(jMo178onPreScrollOzD1aCk, this.connection.mo178onPreScrollOzD1aCk(i, Offset.m438minusMKHz9U(j, jMo178onPreScrollOzD1aCk)));
    }
}
