package androidx.compose.foundation;

import android.view.View;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MagnifierElement extends ModifierNodeElement {
    public final TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 onSizeChanged;
    public final PlatformMagnifierFactory platformMagnifierFactory;
    public final AppBarKt$$ExternalSyntheticLambda8 sourceCenter;

    public MagnifierElement(AppBarKt$$ExternalSyntheticLambda8 appBarKt$$ExternalSyntheticLambda8, TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4 textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = appBarKt$$ExternalSyntheticLambda8;
        this.onSizeChanged = textFieldSelectionManager_androidKt$$ExternalSyntheticLambda4;
        this.platformMagnifierFactory = platformMagnifierFactory;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new MagnifierNode(this.sourceCenter, this.onSizeChanged, this.platformMagnifierFactory);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return this.platformMagnifierFactory.hashCode() + ((this.onSizeChanged.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Float.NaN, this.sourceCenter.hashCode() * 961, 31), true, 31), 31, 9205357640488583168L), 31), 31), true, 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        MagnifierNode magnifierNode = (MagnifierNode) node;
        float f = magnifierNode.zoom;
        long j = magnifierNode.size;
        float f2 = magnifierNode.cornerRadius;
        boolean z = magnifierNode.useTextDefault;
        float f3 = magnifierNode.elevation;
        boolean z2 = magnifierNode.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory = magnifierNode.platformMagnifierFactory;
        View view = magnifierNode.view;
        Density density = magnifierNode.density;
        magnifierNode.sourceCenter = this.sourceCenter;
        magnifierNode.zoom = Float.NaN;
        magnifierNode.useTextDefault = true;
        magnifierNode.size = 9205357640488583168L;
        magnifierNode.cornerRadius = Float.NaN;
        magnifierNode.elevation = Float.NaN;
        magnifierNode.clippingEnabled = true;
        magnifierNode.onSizeChanged = this.onSizeChanged;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        magnifierNode.platformMagnifierFactory = platformMagnifierFactory2;
        View viewRequireView = HitTestResultKt.requireView(magnifierNode);
        Density density2 = HitTestResultKt.requireLayoutNode(magnifierNode).density;
        if (magnifierNode.magnifier != null) {
            SemanticsPropertyKey semanticsPropertyKey = Magnifier_androidKt.MagnifierPositionInRoot;
            if (((!Float.isNaN(Float.NaN) || !Float.isNaN(f)) && Float.NaN != f && !platformMagnifierFactory2.getCanUpdateZoom()) || 9205357640488583168L != j || !Dp.m796equalsimpl0(Float.NaN, f2) || !Dp.m796equalsimpl0(Float.NaN, f3) || true != z || true != z2 || !platformMagnifierFactory2.equals(platformMagnifierFactory) || !viewRequireView.equals(view) || !Intrinsics.areEqual(density2, density)) {
                magnifierNode.recreateMagnifier();
            }
        }
        magnifierNode.updateMagnifier();
    }
}
