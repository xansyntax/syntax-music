package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    public final Alignment handleReferencePoint;
    public final OffsetProvider positionProvider;
    public long prevPosition = 0;

    public HandlePositionProvider(Alignment alignment, OffsetProvider offsetProvider) {
        this.handleReferencePoint = alignment;
        this.positionProvider = offsetProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public final long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        long jMo194provideF1C5BW0 = this.positionProvider.mo194provideF1C5BW0();
        if ((9223372034707292159L & jMo194provideF1C5BW0) == 9205357640488583168L) {
            jMo194provideF1C5BW0 = this.prevPosition;
        }
        this.prevPosition = jMo194provideF1C5BW0;
        return IntOffset.m806plusqkQi6aY(IntOffset.m806plusqkQi6aY(intRect.m809getTopLeftnOccac(), SQLite.m847roundk4lQ0M(jMo194provideF1C5BW0)), this.handleReferencePoint.mo397alignKFBX0sM(j2, 0L, layoutDirection));
    }
}
