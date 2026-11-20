package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MaintainWindowPositionPopupPositionProvider implements PopupPositionProvider {
    public final ProvidableModifierLocal popupPositionProvider;
    public LayoutDirection previousLayoutDirection;
    public IntSize previousPopupContentSize;
    public IntOffset previousPosition;
    public IntSize previousWindowSize;

    public MaintainWindowPositionPopupPositionProvider(ProvidableModifierLocal providableModifierLocal) {
        this.popupPositionProvider = providableModifierLocal;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public final long mo210calculatePositionllwVHH4(long j, long j2, IntRect intRect, LayoutDirection layoutDirection) {
        IntOffset intOffset = this.previousPosition;
        if (intOffset != null) {
            IntSize intSize = this.previousWindowSize;
            if ((intSize == null ? false : IntSize.m810equalsimpl0(intSize.packedValue, j)) && this.previousLayoutDirection == layoutDirection) {
                IntSize intSize2 = this.previousPopupContentSize;
                if (intSize2 != null ? IntSize.m810equalsimpl0(intSize2.packedValue, j2) : false) {
                    return intOffset.packedValue;
                }
            }
        }
        long jMo210calculatePositionllwVHH4 = this.popupPositionProvider.mo210calculatePositionllwVHH4(j, j2, intRect, layoutDirection);
        this.previousWindowSize = new IntSize(j);
        this.previousLayoutDirection = layoutDirection;
        this.previousPopupContentSize = new IntSize(j2);
        this.previousPosition = new IntOffset(jMo210calculatePositionllwVHH4);
        return jMo210calculatePositionllwVHH4;
    }
}
