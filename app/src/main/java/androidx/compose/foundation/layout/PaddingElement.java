package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PaddingElement extends ModifierNodeElement {
    public final float bottom;
    public final float end;
    public final Function1 inspectorInfo;
    public final float start;
    public final float top;

    public PaddingElement(float f, float f2, float f3, float f4, Function1 function1) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.inspectorInfo = function1;
        boolean z = true;
        boolean z2 = (f >= CropImageView.DEFAULT_ASPECT_RATIO || Float.isNaN(f)) & (f2 >= CropImageView.DEFAULT_ASPECT_RATIO || Float.isNaN(f2)) & (f3 >= CropImageView.DEFAULT_ASPECT_RATIO || Float.isNaN(f3));
        if (f4 < CropImageView.DEFAULT_ASPECT_RATIO && !Float.isNaN(f4)) {
            z = false;
        }
        if (!z2 || !z) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        PaddingNode paddingNode = new PaddingNode();
        paddingNode.start = this.start;
        paddingNode.top = this.top;
        paddingNode.end = this.end;
        paddingNode.bottom = this.bottom;
        paddingNode.rtlAware = true;
        return paddingNode;
    }

    public final boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && Dp.m796equalsimpl0(this.start, paddingElement.start) && Dp.m796equalsimpl0(this.top, paddingElement.top) && Dp.m796equalsimpl0(this.end, paddingElement.end) && Dp.m796equalsimpl0(this.bottom, paddingElement.bottom);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + IntIntPair$$ExternalSyntheticOutline0.m(this.bottom, IntIntPair$$ExternalSyntheticOutline0.m(this.end, IntIntPair$$ExternalSyntheticOutline0.m(this.top, Float.hashCode(this.start) * 31, 31), 31), 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        PaddingNode paddingNode = (PaddingNode) node;
        paddingNode.start = this.start;
        paddingNode.top = this.top;
        paddingNode.end = this.end;
        paddingNode.bottom = this.bottom;
        paddingNode.rtlAware = true;
    }
}
