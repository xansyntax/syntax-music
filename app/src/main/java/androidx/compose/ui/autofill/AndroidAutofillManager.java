package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.view.autofill.AutofillId;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.size.SizeKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutofillManager extends AutofillManager implements FocusListener {
    public final MutableIntSet currentlyDisplayedIDs;
    public final String packageName;
    public boolean pendingAutofillCommit;
    public final WeakCache platformAutofillManager;
    public final RectManager rectManager;
    public final Rect reusableRect = new Rect();
    public final AutofillId rootAutofillId;
    public final SemanticsOwner semanticsOwner;
    public final AndroidComposeView view;

    public AndroidAutofillManager(WeakCache weakCache, SemanticsOwner semanticsOwner, AndroidComposeView androidComposeView, RectManager rectManager, String str) {
        this.platformAutofillManager = weakCache;
        this.semanticsOwner = semanticsOwner;
        this.view = androidComposeView;
        this.rectManager = rectManager;
        this.packageName = str;
        androidComposeView.setImportantForAutofill(1);
        AutofillId autofillId = androidComposeView.getAutofillId();
        if (autofillId == null) {
            throw Fragment$5$$ExternalSyntheticOutline0.m$2("Required value was null.");
        }
        this.rootAutofillId = autofillId;
        this.currentlyDisplayedIDs = new MutableIntSet();
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public final void onFocusChanged(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        LayoutNode layoutNodeRequireLayoutNode;
        SemanticsConfiguration semanticsConfiguration;
        LayoutNode layoutNodeRequireLayoutNode2;
        SemanticsConfiguration semanticsConfiguration2;
        AndroidComposeView androidComposeView = this.view;
        WeakCache weakCache = this.platformAutofillManager;
        if (focusTargetNode != null && (layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode)) != null && (semanticsConfiguration2 = layoutNodeRequireLayoutNode2.getSemanticsConfiguration()) != null && SizeKt.isAutofillable(semanticsConfiguration2)) {
            weakCache.getPlatformAndroidManager().notifyViewExited(androidComposeView, layoutNodeRequireLayoutNode2.semanticsId);
        }
        if (focusTargetNode2 == null || (layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode2)) == null || (semanticsConfiguration = layoutNodeRequireLayoutNode.getSemanticsConfiguration()) == null || !SizeKt.isAutofillable(semanticsConfiguration)) {
            return;
        }
        int i = layoutNodeRequireLayoutNode.semanticsId;
        RectManager rectManager = this.rectManager;
        LayoutNode layoutNode = (LayoutNode) rectManager.layoutNodes.get(i);
        if (layoutNode == null || layoutNode.rectListIndex == -4) {
            return;
        }
        StatusLine statusLine = rectManager.rects;
        int iIndexInRectList = rectManager.indexInRectList(layoutNode);
        long[] jArr = (long[]) statusLine.protocol;
        long j = jArr[iIndexInRectList];
        long j2 = jArr[iIndexInRectList + 1];
        weakCache.getPlatformAndroidManager().notifyViewEntered(androidComposeView, i, new Rect((int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2));
    }
}
