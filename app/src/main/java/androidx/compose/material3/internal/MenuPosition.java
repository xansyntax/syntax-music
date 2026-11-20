package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAbsoluteAlignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuPosition {
    public static final AnchorAlignmentOffsetPosition$Vertical bottomToAnchorTop;
    public static final WindowAlignmentMarginPosition$Vertical bottomToWindowBottom;
    public static final AnchorAlignmentOffsetPosition$Vertical centerToAnchorTop;
    public static final AnchorAlignmentOffsetPosition$Horizontal endToAnchorEnd;
    public static final WindowAlignmentMarginPosition$Horizontal leftToWindowLeft;
    public static final WindowAlignmentMarginPosition$Horizontal rightToWindowRight;
    public static final AnchorAlignmentOffsetPosition$Horizontal startToAnchorStart;
    public static final AnchorAlignmentOffsetPosition$Vertical topToAnchorBottom;
    public static final WindowAlignmentMarginPosition$Vertical topToWindowTop;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Horizontal {
        /* JADX INFO: renamed from: position-95KtPRI */
        int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Vertical {
        /* JADX INFO: renamed from: position-JVtK1S4 */
        int mo366positionJVtK1S4(IntRect intRect, long j, int i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical] */
    static {
        final BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        startToAnchorStart = new Horizontal(horizontal, horizontal) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;

            {
                this.menuAlignment = horizontal;
                this.anchorAlignment = horizontal;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                return intRect.left + iAlign + (-this.menuAlignment.align(0, i, layoutDirection));
            }

            public final String toString() {
                return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        final BiasAlignment.Horizontal horizontal2 = Alignment.Companion.End;
        new Horizontal(horizontal, horizontal2) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;

            {
                this.menuAlignment = horizontal;
                this.anchorAlignment = horizontal2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                return intRect.left + iAlign + (-this.menuAlignment.align(0, i, layoutDirection));
            }

            public final String toString() {
                return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        endToAnchorEnd = new Horizontal(horizontal2, horizontal2) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;

            {
                this.menuAlignment = horizontal2;
                this.anchorAlignment = horizontal2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                return intRect.left + iAlign + (-this.menuAlignment.align(0, i, layoutDirection));
            }

            public final String toString() {
                return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        new Horizontal(horizontal2, horizontal) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal
            public final BiasAlignment.Horizontal anchorAlignment;
            public final BiasAlignment.Horizontal menuAlignment;

            {
                this.menuAlignment = horizontal2;
                this.anchorAlignment = horizontal;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Horizontal)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Horizontal anchorAlignmentOffsetPosition$Horizontal = (AnchorAlignmentOffsetPosition$Horizontal) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Horizontal.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI, reason: not valid java name */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                int iAlign = this.anchorAlignment.align(0, intRect.getWidth(), layoutDirection);
                return intRect.left + iAlign + (-this.menuAlignment.align(0, i, layoutDirection));
            }

            public final String toString() {
                return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        final BiasAbsoluteAlignment.Horizontal horizontal3 = ZIndexModifierKt.Left;
        leftToWindowLeft = new Horizontal(horizontal3) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal
            public final BiasAbsoluteAlignment.Horizontal alignment;

            {
                this.alignment = horizontal3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Horizontal) && this.alignment.equals(((WindowAlignmentMarginPosition$Horizontal) obj).alignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.alignment.bias);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                return this.alignment.align(i, (int) (j >> 32), layoutDirection);
            }

            public final String toString() {
                return "Horizontal(alignment=" + this.alignment + ")";
            }
        };
        final BiasAbsoluteAlignment.Horizontal horizontal4 = ZIndexModifierKt.Right;
        rightToWindowRight = new Horizontal(horizontal4) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal
            public final BiasAbsoluteAlignment.Horizontal alignment;

            {
                this.alignment = horizontal4;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Horizontal) && this.alignment.equals(((WindowAlignmentMarginPosition$Horizontal) obj).alignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.alignment.bias);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
            /* JADX INFO: renamed from: position-95KtPRI */
            public final int mo365position95KtPRI(IntRect intRect, long j, int i, LayoutDirection layoutDirection) {
                return this.alignment.align(i, (int) (j >> 32), layoutDirection);
            }

            public final String toString() {
                return "Horizontal(alignment=" + this.alignment + ")";
            }
        };
        final BiasAlignment.Vertical vertical = Alignment.Companion.Top;
        final BiasAlignment.Vertical vertical2 = Alignment.Companion.Bottom;
        topToAnchorBottom = new Vertical(vertical, vertical2) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;

            {
                this.menuAlignment = vertical;
                this.anchorAlignment = vertical2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i));
            }

            public final String toString() {
                return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        new Vertical(vertical, vertical) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;

            {
                this.menuAlignment = vertical;
                this.anchorAlignment = vertical;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i));
            }

            public final String toString() {
                return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        bottomToAnchorTop = new Vertical(vertical2, vertical) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;

            {
                this.menuAlignment = vertical2;
                this.anchorAlignment = vertical;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i));
            }

            public final String toString() {
                return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        new Vertical(vertical2, vertical2) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;

            {
                this.menuAlignment = vertical2;
                this.anchorAlignment = vertical2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i));
            }

            public final String toString() {
                return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        final BiasAlignment.Vertical vertical3 = Alignment.Companion.CenterVertically;
        centerToAnchorTop = new Vertical(vertical3, vertical) { // from class: androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical
            public final BiasAlignment.Vertical anchorAlignment;
            public final BiasAlignment.Vertical menuAlignment;

            {
                this.menuAlignment = vertical3;
                this.anchorAlignment = vertical;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof AnchorAlignmentOffsetPosition$Vertical)) {
                    return false;
                }
                AnchorAlignmentOffsetPosition$Vertical anchorAlignmentOffsetPosition$Vertical = (AnchorAlignmentOffsetPosition$Vertical) obj;
                return this.menuAlignment.equals(anchorAlignmentOffsetPosition$Vertical.menuAlignment) && this.anchorAlignment.equals(anchorAlignmentOffsetPosition$Vertical.anchorAlignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.anchorAlignment.bias) + (Float.hashCode(this.menuAlignment.bias) * 31);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4, reason: not valid java name */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                int iAlign = this.anchorAlignment.align(0, intRect.getHeight());
                return intRect.top + iAlign + (-this.menuAlignment.align(0, i));
            }

            public final String toString() {
                return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ")";
            }
        };
        topToWindowTop = new Vertical(vertical) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical
            public final BiasAlignment.Vertical alignment;

            {
                this.alignment = vertical;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Vertical) && this.alignment.equals(((WindowAlignmentMarginPosition$Vertical) obj).alignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.alignment.bias);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4 */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                return this.alignment.align(i, (int) (j & 4294967295L));
            }

            public final String toString() {
                return "Vertical(alignment=" + this.alignment + ")";
            }
        };
        bottomToWindowBottom = new Vertical(vertical2) { // from class: androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical
            public final BiasAlignment.Vertical alignment;

            {
                this.alignment = vertical2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WindowAlignmentMarginPosition$Vertical) && this.alignment.equals(((WindowAlignmentMarginPosition$Vertical) obj).alignment);
            }

            public final int hashCode() {
                return Float.hashCode(this.alignment.bias);
            }

            @Override // androidx.compose.material3.internal.MenuPosition.Vertical
            /* JADX INFO: renamed from: position-JVtK1S4 */
            public final int mo366positionJVtK1S4(IntRect intRect, long j, int i) {
                return this.alignment.align(i, (int) (j & 4294967295L));
            }

            public final String toString() {
                return "Vertical(alignment=" + this.alignment + ")";
            }
        };
    }
}
