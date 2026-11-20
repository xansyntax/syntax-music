package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListScrollPosition {
    public final /* synthetic */ byte $r8$classId;
    public boolean hadFirstNotEmptyLayout;
    public final ParcelableSnapshotMutableIntState index$delegate;
    public Object lastKnownFirstItemKey;
    public final LazyLayoutNearestRangeState nearestRangeState;
    public final ParcelableSnapshotMutableIntState scrollOffset$delegate;

    public LazyListScrollPosition(int i, int i2, byte b) {
        this.$r8$classId = b;
        switch (b) {
            case 1:
                this.index$delegate = new ParcelableSnapshotMutableIntState(i);
                this.scrollOffset$delegate = new ParcelableSnapshotMutableIntState(i2);
                this.nearestRangeState = new LazyLayoutNearestRangeState(i, 90, 200);
                break;
            default:
                this.index$delegate = new ParcelableSnapshotMutableIntState(i);
                this.scrollOffset$delegate = new ParcelableSnapshotMutableIntState(i2);
                this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
                break;
        }
    }

    public final void update(int i, int i2) {
        byte b = this.$r8$classId;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = this.scrollOffset$delegate;
        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = this.nearestRangeState;
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2 = this.index$delegate;
        switch (b) {
            case 0:
                if (i < CropImageView.DEFAULT_ASPECT_RATIO) {
                    InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative (" + i + ")");
                }
                parcelableSnapshotMutableIntState2.setIntValue(i);
                lazyLayoutNearestRangeState.update(i);
                parcelableSnapshotMutableIntState.setIntValue(i2);
                break;
            default:
                if (i < CropImageView.DEFAULT_ASPECT_RATIO) {
                    InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative");
                }
                parcelableSnapshotMutableIntState2.setIntValue(i);
                lazyLayoutNearestRangeState.update(i);
                parcelableSnapshotMutableIntState.setIntValue(i2);
                break;
        }
    }
}
