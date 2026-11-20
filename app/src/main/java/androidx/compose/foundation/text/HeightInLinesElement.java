package androidx.compose.foundation.text;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/text/HeightInLinesElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/HeightInLinesNode;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class HeightInLinesElement extends ModifierNodeElement {
    public final int maxLines;
    public final boolean minLines;
    public final TextStyle textStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public HeightInLinesElement(TextStyle textStyle, int i, int i2) {
        this.textStyle = textStyle;
        this.minLines = i;
        this.maxLines = i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        HeightInLinesNode heightInLinesNode = new HeightInLinesNode();
        heightInLinesNode.textStyle = this.textStyle;
        heightInLinesNode.minLines = this.minLines;
        heightInLinesNode.maxLines = this.maxLines;
        heightInLinesNode.precomputedMinLinesHeight = -1;
        heightInLinesNode.precomputedMaxLinesHeight = -1;
        return heightInLinesNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeightInLinesElement)) {
            return false;
        }
        HeightInLinesElement heightInLinesElement = (HeightInLinesElement) obj;
        return Intrinsics.areEqual(this.textStyle, heightInLinesElement.textStyle) && this.minLines == heightInLinesElement.minLines && this.maxLines == heightInLinesElement.maxLines;
    }

    public final int hashCode() {
        return (((this.textStyle.hashCode() * 31) + (this.minLines ? 1 : 0)) * 31) + this.maxLines;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        HeightInLinesNode heightInLinesNode = (HeightInLinesNode) node;
        TextStyle textStyle = heightInLinesNode.textStyle;
        TextStyle textStyle2 = this.textStyle;
        boolean zAreEqual = Intrinsics.areEqual(textStyle, textStyle2);
        boolean z = this.minLines;
        int i = this.maxLines;
        if (zAreEqual && heightInLinesNode.minLines == z && heightInLinesNode.maxLines == i) {
            return;
        }
        heightInLinesNode.textStyle = textStyle2;
        heightInLinesNode.minLines = z;
        heightInLinesNode.maxLines = i;
        heightInLinesNode.resolvedStyle = TextRangeKt.resolveDefaults(textStyle2, HitTestResultKt.requireLayoutNode(heightInLinesNode).layoutDirection);
        heightInLinesNode.dirty = true;
        HitTestResultKt.invalidateMeasurement(heightInLinesNode);
    }
}
