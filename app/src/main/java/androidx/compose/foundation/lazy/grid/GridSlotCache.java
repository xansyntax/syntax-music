package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GridSlotCache {
    public long cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15);
    public float cachedDensity;
    public LazyGridSlots cachedSizes;
    public final Function2 calculation;

    public GridSlotCache(Function2 function2) {
        this.calculation = function2;
    }
}
