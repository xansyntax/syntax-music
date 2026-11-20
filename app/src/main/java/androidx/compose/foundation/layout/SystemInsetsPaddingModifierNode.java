package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SystemInsetsPaddingModifierNode extends InsetsPaddingModifierNode {
    public Function1 insetsGetter;
    public WindowInsetsHolder windowInsetsHolder;

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode, androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        View viewRequireView = HitTestResultKt.requireView(this);
        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
        WindowInsetsHolder orCreateFor = OffsetKt.getOrCreateFor(viewRequireView);
        orCreateFor.incrementAccessors(viewRequireView);
        WindowInsets windowInsets = (WindowInsets) this.insetsGetter.invoke(orCreateFor);
        if (!Intrinsics.areEqual(windowInsets, this.insets)) {
            this.insets = windowInsets;
            insetsInvalidated();
        }
        this.windowInsetsHolder = orCreateFor;
        super.onAttach();
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode, androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        View viewRequireView = HitTestResultKt.requireView(this);
        WindowInsetsHolder windowInsetsHolder = this.windowInsetsHolder;
        if (windowInsetsHolder != null) {
            int i = windowInsetsHolder.accessCount - 1;
            windowInsetsHolder.accessCount = i;
            if (i == 0) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewRequireView, null);
                WindowInsetsAnimationCompat.setCallback(viewRequireView, null);
                viewRequireView.removeOnAttachStateChangeListener(windowInsetsHolder.insetsListener);
            }
        }
        super.onDetach();
    }
}
