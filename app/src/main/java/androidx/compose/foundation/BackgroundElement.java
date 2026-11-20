package androidx.compose.foundation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.LinearGradient;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/BackgroundElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/BackgroundNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BackgroundElement extends ModifierNodeElement {
    public final Brush brush;
    public final long color;
    public final Shape shape;

    public BackgroundElement(long j, LinearGradient linearGradient, Shape shape, int i) {
        j = (i & 1) != 0 ? ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified) : j;
        linearGradient = (i & 2) != 0 ? null : linearGradient;
        this.color = j;
        this.brush = linearGradient;
        this.shape = shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        BackgroundNode backgroundNode = new BackgroundNode();
        backgroundNode.color = this.color;
        backgroundNode.brush = this.brush;
        backgroundNode.alpha = 1.0f;
        backgroundNode.shape = this.shape;
        backgroundNode.lastSize = 9205357640488583168L;
        return backgroundNode;
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && ULong.m1869equalsimpl0(this.color, backgroundElement.color) && Intrinsics.areEqual(this.brush, backgroundElement.brush) && Intrinsics.areEqual(this.shape, backgroundElement.shape);
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.color) * 31;
        Brush brush = this.brush;
        return this.shape.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(1.0f, (iHashCode + (brush != null ? brush.hashCode() : 0)) * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        BackgroundNode backgroundNode = (BackgroundNode) node;
        backgroundNode.color = this.color;
        backgroundNode.brush = this.brush;
        backgroundNode.alpha = 1.0f;
        Shape shape = backgroundNode.shape;
        Shape shape2 = this.shape;
        if (!Intrinsics.areEqual(shape, shape2)) {
            backgroundNode.shape = shape2;
            HitTestResultKt.invalidateSemantics(backgroundNode);
        }
        HitTestResultKt.invalidateDraw(backgroundNode);
    }
}
