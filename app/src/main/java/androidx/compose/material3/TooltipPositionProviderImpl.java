package androidx.compose.material3;

import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TooltipPositionProviderImpl implements PopupPositionProvider {
    public final int tooltipAnchorSpacing;
    public final long windowContainerSize;

    public TooltipPositionProviderImpl(int i, long j) {
        this.tooltipAnchorSpacing = i;
        this.windowContainerSize = j;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        int i = (int) (j2 >> 32);
        int width = ((intRect.getWidth() - i) / 2) + intRect.left;
        long j3 = this.windowContainerSize;
        int iCoerceIn = UuidKt.coerceIn(width, 0, Math.max(0, ((int) (j3 >> 32)) - i));
        int i2 = (int) (j2 & 4294967295L);
        int i3 = intRect.top - i2;
        int i4 = this.tooltipAnchorSpacing;
        int i5 = i3 - i4;
        if (i5 < 0) {
            i5 = intRect.bottom + i4;
        }
        return (((long) iCoerceIn) << 32) | (((long) UuidKt.coerceIn(i5, 0, Math.max(0, ((int) (j3 & 4294967295L)) - i2))) & 4294967295L);
    }
}
