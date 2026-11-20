package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusRequester {
    public final MutableVector focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16]);
    public static final FocusRequester Default = new FocusRequester();
    public static final FocusRequester Cancel = new FocusRequester();
    public static final FocusRequester Redirect = new FocusRequester();

    /* JADX INFO: renamed from: requestFocus-3ESFkO8$default, reason: not valid java name */
    public static void m415requestFocus3ESFkO8$default(FocusRequester focusRequester) {
        focusRequester.getClass();
        if (focusRequester == Default) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
            return;
        }
        if (focusRequester == Cancel) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
            return;
        }
        MutableVector mutableVector = focusRequester.focusRequesterNodes;
        int i = mutableVector.size;
        if (i == 0) {
            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return;
        }
        Object[] objArr = mutableVector.content;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = (FocusRequesterModifierNode) objArr[i2];
            if (!((Modifier.Node) obj).node.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node = ((Modifier.Node) obj).node;
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                HitTestResultKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                mutableVector2.add(node2);
            }
            while (true) {
                int i3 = mutableVector2.size;
                if (i3 == 0) {
                    break;
                }
                Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(i3 - 1);
                if ((nodePop.aggregateChildKindSet & 1024) == 0) {
                    HitTestResultKt.addLayoutNodeChildren(mutableVector2, nodePop);
                } else {
                    while (nodePop != null) {
                        if ((nodePop.kindSet & 1024) != 0) {
                            MutableVector mutableVector3 = null;
                            while (nodePop != null) {
                                if (nodePop instanceof FocusTargetNode) {
                                    if (((FocusTargetNode) nodePop).m418requestFocus3ESFkO8(7)) {
                                        break;
                                    }
                                } else if ((nodePop.kindSet & 1024) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node node3 = ((DelegatingNode) nodePop).delegate; node3 != null; node3 = node3.child) {
                                        if ((node3.kindSet & 1024) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                nodePop = node3;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector3.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector3.add(node3);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                nodePop = HitTestResultKt.pop(mutableVector3);
                            }
                            break;
                        }
                        nodePop = nodePop.child;
                    }
                }
            }
        }
    }
}
