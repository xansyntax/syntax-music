package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material3.BadgeKt$$ExternalSyntheticLambda4;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.collections.EmptyMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsProviderModifierNode extends Modifier.Node implements LayoutModifierNode {
    public static final LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsProviderModifierNode$Companion$emptyBeyondBoundsScope$1();
    public LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public Orientation orientation;
    public LazyLayoutBeyondBoundsState state;

    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m170hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (i != 5 && i != 6) {
            if (i == 3 || i == 4) {
                if (this.orientation != Orientation.Vertical) {
                }
            } else if (i != 1 && i != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Lazy list does not support beyond bounds layout for the specified direction");
                return false;
            }
            if (m171isForward4vf7U8o(i) ? interval.start > 0 : interval.end < this.state.getItemCount() - 1) {
                return true;
            }
        } else if (this.orientation != Orientation.Horizontal) {
            if (m171isForward4vf7U8o(i)) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    public final boolean m171isForward4vf7U8o(int i) {
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 5) {
            return false;
        }
        if (i == 6) {
            return true;
        }
        if (i == 3) {
            int iOrdinal = HitTestResultKt.requireLayoutNode(this).layoutDirection.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal == 1) {
                return true;
            }
            PathKt$$ExternalSyntheticBUOutline0.m$1();
            return false;
        }
        if (i != 4) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Lazy list does not support beyond bounds layout for the specified direction");
            return false;
        }
        int iOrdinal2 = HitTestResultKt.requireLayoutNode(this).layoutDirection.ordinal();
        if (iOrdinal2 == 0) {
            return true;
        }
        if (iOrdinal2 == 1) {
            return false;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo14measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo598measureBRTryo0 = measurable.mo598measureBRTryo0(j);
        return measureScope.layout(placeableMo598measureBRTryo0.width, placeableMo598measureBRTryo0.height, EmptyMap.INSTANCE, new BadgeKt$$ExternalSyntheticLambda4(placeableMo598measureBRTryo0, (byte) 11));
    }
}
