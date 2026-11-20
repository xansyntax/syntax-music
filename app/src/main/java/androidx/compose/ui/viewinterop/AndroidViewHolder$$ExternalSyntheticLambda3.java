package androidx.compose.ui.viewinterop;

import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidViewsHandler;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidViewHolder$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ ViewFactoryHolder f$0;
    public final /* synthetic */ LayoutNode f$1;

    public /* synthetic */ AndroidViewHolder$$ExternalSyntheticLambda3(ViewFactoryHolder viewFactoryHolder, LayoutNode layoutNode, byte b) {
        this.$r8$classId = b;
        this.f$0 = viewFactoryHolder;
        this.f$1 = layoutNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WindowInsets windowInsets;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        final LayoutNode layoutNode = this.f$1;
        ViewFactoryHolder viewFactoryHolder = this.f$0;
        switch (b) {
            case 0:
                View view = viewFactoryHolder.view;
                Owner owner = (Owner) obj;
                final AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    final AndroidViewsHandler androidViewsHandler$ui = androidComposeView.getAndroidViewsHandler$ui();
                    androidViewsHandler$ui.getClass();
                    androidViewsHandler$ui.getHolderToLayoutNode().put(viewFactoryHolder, layoutNode);
                    androidViewsHandler$ui.addView(viewFactoryHolder);
                    androidViewsHandler$ui.getLayoutNodeToHolder().put(layoutNode, viewFactoryHolder);
                    viewFactoryHolder.setImportantForAccessibility(1);
                    ViewCompat.setAccessibilityDelegate(viewFactoryHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
                        /* JADX WARN: Code duplicated, block: B:19:0x004a  */
                        @Override // androidx.core.view.AccessibilityDelegateCompat
                        public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                            AndroidComposeView androidComposeView2 = androidComposeView;
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = androidComposeView2.composeAccessibilityDelegate;
                            if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui()) {
                                accessibilityNodeInfo.setVisibleToUser(false);
                            }
                            LayoutNode layoutNode2 = layoutNode;
                            LayoutNode parent$ui = layoutNode2.getParent$ui();
                            while (true) {
                                if (parent$ui == null) {
                                    parent$ui = null;
                                    break;
                                } else if (parent$ui.nodes.m662hasH91voCI$ui(8)) {
                                    break;
                                } else {
                                    parent$ui = parent$ui.getParent$ui();
                                }
                            }
                            Integer numValueOf = parent$ui != null ? Integer.valueOf(parent$ui.semanticsId) : null;
                            if (numValueOf != null) {
                                if (numValueOf.intValue() == androidComposeView2.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
                                    numValueOf = -1;
                                }
                            } else {
                                numValueOf = -1;
                            }
                            int iIntValue = numValueOf.intValue();
                            accessibilityNodeInfoCompat.mParentVirtualDescendantId = iIntValue;
                            AndroidComposeView androidComposeView3 = androidComposeView;
                            accessibilityNodeInfo.setParent(androidComposeView3, iIntValue);
                            int i = layoutNode2.semanticsId;
                            int orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i, -1);
                            AndroidViewsHandler androidViewsHandler = androidViewsHandler$ui;
                            if (orDefault != -1) {
                                AndroidViewHolder androidViewHolderSemanticsIdToView = InvertMatrixKt.semanticsIdToView(androidViewsHandler, orDefault);
                                if (androidViewHolderSemanticsIdToView != null) {
                                    accessibilityNodeInfo.setTraversalBefore(androidViewHolderSemanticsIdToView);
                                } else {
                                    accessibilityNodeInfo.setTraversalBefore(androidComposeView3, orDefault);
                                }
                                androidComposeView2.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfo, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal);
                            }
                            int orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i, -1);
                            if (orDefault2 != -1) {
                                AndroidViewHolder androidViewHolderSemanticsIdToView2 = InvertMatrixKt.semanticsIdToView(androidViewsHandler, orDefault2);
                                if (androidViewHolderSemanticsIdToView2 != null) {
                                    accessibilityNodeInfo.setTraversalAfter(androidViewHolderSemanticsIdToView2);
                                } else {
                                    accessibilityNodeInfo.setTraversalAfter(androidComposeView3, orDefault2);
                                }
                                androidComposeView2.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfo, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalAfterVal);
                            }
                        }
                    });
                }
                if (view.getParent() != viewFactoryHolder) {
                    viewFactoryHolder.addView(view);
                }
                break;
            case 1:
                AndroidView_androidKt.layoutAccordingTo(viewFactoryHolder, layoutNode);
                ((AndroidComposeView) viewFactoryHolder.owner).isPendingInteropViewLayoutChangeDispatch = true;
                int[] iArr = viewFactoryHolder.position;
                int i = iArr[0];
                int i2 = iArr[1];
                View view2 = viewFactoryHolder.view;
                view2.getLocationOnScreen(iArr);
                long j = viewFactoryHolder.size;
                long jMo603getSizeYbymL2g = ((LayoutCoordinates) obj).mo603getSizeYbymL2g();
                viewFactoryHolder.size = jMo603getSizeYbymL2g;
                WindowInsetsCompat windowInsetsCompat = viewFactoryHolder.insets;
                if (windowInsetsCompat != null && ((i != iArr[0] || i2 != iArr[1] || !IntSize.m810equalsimpl0(j, jMo603getSizeYbymL2g)) && (windowInsets = viewFactoryHolder.insetToLayoutPosition(windowInsetsCompat).toWindowInsets()) != null)) {
                    view2.dispatchApplyWindowInsets(windowInsets);
                }
                break;
            default:
                AndroidView_androidKt.layoutAccordingTo(viewFactoryHolder, layoutNode);
                break;
        }
        return unit;
    }
}
