package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AspectRatioNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AspectRatioElement extends ModifierNodeElement {
    public final float aspectRatio;

    public AspectRatioElement(float f) {
        this.aspectRatio = f;
        if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("aspectRatio " + f + " must be > 0");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        AspectRatioNode aspectRatioNode = new AspectRatioNode();
        aspectRatioNode.aspectRatio = this.aspectRatio;
        return aspectRatioNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioElement aspectRatioElement = obj instanceof AspectRatioElement ? (AspectRatioElement) obj : null;
        if (aspectRatioElement == null || this.aspectRatio != aspectRatioElement.aspectRatio) {
            return false;
        }
        ((AspectRatioElement) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (Float.hashCode(this.aspectRatio) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        ((AspectRatioNode) node).aspectRatio = this.aspectRatio;
    }
}
