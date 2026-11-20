package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.io.TextStreamsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    public boolean hasLookaheadOccurred;
    public final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        this.scope = animatedVisibilityScopeImpl;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMaxIntrinsicHeight = ((Measurable) list.get(0)).maxIntrinsicHeight(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iMaxIntrinsicHeight2 = ((Measurable) list.get(i2)).maxIntrinsicHeight(i);
                if (iMaxIntrinsicHeight2 > iMaxIntrinsicHeight) {
                    iMaxIntrinsicHeight = iMaxIntrinsicHeight2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMaxIntrinsicWidth = ((Measurable) list.get(0)).maxIntrinsicWidth(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iMaxIntrinsicWidth2 = ((Measurable) list.get(i2)).maxIntrinsicWidth(i);
                if (iMaxIntrinsicWidth2 > iMaxIntrinsicWidth) {
                    iMaxIntrinsicWidth = iMaxIntrinsicWidth2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size; i++) {
            Placeable placeableMo598measureBRTryo0 = ((Measurable) list.get(i)).mo598measureBRTryo0(j);
            iMax = Math.max(iMax, placeableMo598measureBRTryo0.width);
            iMax2 = Math.max(iMax2, placeableMo598measureBRTryo0.height);
            arrayList.add(placeableMo598measureBRTryo0);
        }
        boolean zIsLookingAhead = measureScope.isLookingAhead();
        AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = this.scope;
        if (zIsLookingAhead) {
            this.hasLookaheadOccurred = true;
            animatedVisibilityScopeImpl.targetSize.setValue(new IntSize((((long) iMax2) & 4294967295L) | (((long) iMax) << 32)));
        } else if (!this.hasLookaheadOccurred) {
            animatedVisibilityScopeImpl.targetSize.setValue(new IntSize((((long) iMax2) & 4294967295L) | (((long) iMax) << 32)));
        }
        return measureScope.layout(iMax, iMax2, EmptyMap.INSTANCE, new TextStreamsKt$$ExternalSyntheticLambda0(arrayList, (byte) 1));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMinIntrinsicHeight = ((Measurable) list.get(0)).minIntrinsicHeight(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iMinIntrinsicHeight2 = ((Measurable) list.get(i2)).minIntrinsicHeight(i);
                if (iMinIntrinsicHeight2 > iMinIntrinsicHeight) {
                    iMinIntrinsicHeight = iMinIntrinsicHeight2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        if (list.isEmpty()) {
            return 0;
        }
        int iMinIntrinsicWidth = ((Measurable) list.get(0)).minIntrinsicWidth(i);
        int i2 = 1;
        int size = list.size() - 1;
        if (1 <= size) {
            while (true) {
                int iMinIntrinsicWidth2 = ((Measurable) list.get(i2)).minIntrinsicWidth(i);
                if (iMinIntrinsicWidth2 > iMinIntrinsicWidth) {
                    iMinIntrinsicWidth = iMinIntrinsicWidth2;
                }
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return iMinIntrinsicWidth;
    }
}
