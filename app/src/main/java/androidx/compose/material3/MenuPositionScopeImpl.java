package androidx.compose.material3;

import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuPositionScopeImpl {
    public final IntRect anchorBounds;
    public final LayoutDirection layoutDirection;
    public final long menuSize;
    public final long windowSize;

    public MenuPositionScopeImpl(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        this.anchorBounds = intRect;
        this.windowSize = j;
        this.menuSize = j2;
        this.layoutDirection = layoutDirection;
    }
}
