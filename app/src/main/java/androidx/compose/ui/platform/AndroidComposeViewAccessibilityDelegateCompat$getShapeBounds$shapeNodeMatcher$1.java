package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1 implements SemanticsPropertyReceiver {
    public final /* synthetic */ Shape $shape;
    public boolean hasMatchedShape;

    public AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1(Shape shape) {
        this.$shape = shape;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void set(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        if (obj == this.$shape) {
            this.hasMatchedShape = true;
        }
    }
}
