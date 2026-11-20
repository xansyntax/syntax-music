package androidx.compose.ui.focus;

import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        FocusTargetNode focusTargetNode = (FocusTargetNode) obj;
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) obj2;
        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode) && FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
            LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
            LayoutNode layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode2);
            if (!Intrinsics.areEqual(layoutNodeRequireLayoutNode, layoutNodeRequireLayoutNode2)) {
                Object[] objArr = new LayoutNode[16];
                int i = 0;
                while (layoutNodeRequireLayoutNode != null) {
                    int i2 = i + 1;
                    if (objArr.length < i2) {
                        int length = objArr.length;
                        Object[] objArr2 = new Object[Math.max(i2, length * 2)];
                        System.arraycopy(objArr, 0, objArr2, 0, length);
                        objArr = objArr2;
                    }
                    if (i != 0) {
                        System.arraycopy(objArr, 0, objArr, 0 + 1, i + 0);
                    }
                    objArr[0] = layoutNodeRequireLayoutNode;
                    i++;
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                }
                Object[] objArr3 = new LayoutNode[16];
                int i3 = 0;
                while (layoutNodeRequireLayoutNode2 != null) {
                    int i4 = i3 + 1;
                    if (objArr3.length < i4) {
                        int length2 = objArr3.length;
                        Object[] objArr4 = new Object[Math.max(i4, length2 * 2)];
                        System.arraycopy(objArr3, 0, objArr4, 0, length2);
                        objArr3 = objArr4;
                    }
                    if (i3 != 0) {
                        System.arraycopy(objArr3, 0, objArr3, 0 + 1, i3 + 0);
                    }
                    objArr3[0] = layoutNodeRequireLayoutNode2;
                    i3++;
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                }
                int iMin = Math.min(i - 1, i3 - 1);
                if (iMin >= 0) {
                    int i5 = 0;
                    while (Intrinsics.areEqual(objArr[i5], objArr3[i5])) {
                        if (i5 != iMin) {
                            i5++;
                        }
                    }
                    return Intrinsics.compare(((LayoutNode) objArr[i5]).getPlaceOrder$ui(), ((LayoutNode) objArr3[i5]).getPlaceOrder$ui());
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Could not find a common ancestor between the two FocusModifiers.");
                return 0;
            }
        } else {
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode)) {
                return -1;
            }
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                return 1;
            }
        }
        return 0;
    }
}
