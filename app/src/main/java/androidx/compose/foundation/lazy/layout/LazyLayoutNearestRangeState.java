package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State {
    public final short extraItemCount;
    public int lastFirstVisibleItem;
    public final byte slidingWindowSize;
    public final ParcelableSnapshotMutableState value$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutNearestRangeState(int i, int i2, int i3) {
        this.slidingWindowSize = i2;
        this.extraItemCount = i3;
        int i4 = (i / i2) * i2;
        this.value$delegate = new ParcelableSnapshotMutableState(UuidKt.until(Math.max(i4 - i3, 0), i4 + i2 + i3), NeverEqualPolicy.INSTANCE$3);
        this.lastFirstVisibleItem = i;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return (IntRange) this.value$delegate.getValue();
    }

    public final void update(int i) {
        if (i != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = i;
            byte b = this.slidingWindowSize;
            int i2 = (i / b) * b;
            short s = this.extraItemCount;
            this.value$delegate.setValue(UuidKt.until(Math.max(i2 - s, 0), i2 + b + s));
        }
    }
}
