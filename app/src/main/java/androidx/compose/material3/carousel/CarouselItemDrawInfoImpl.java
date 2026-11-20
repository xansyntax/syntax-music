package androidx.compose.material3.carousel;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.geometry.Rect;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CarouselItemDrawInfoImpl {
    public final ParcelableSnapshotMutableFloatState sizeState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState minSizeState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState maxSizeState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState maskLeftState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState maskTopState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState maskRightState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public final ParcelableSnapshotMutableFloatState maskBottomState$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);
    public Rect cachedRect = Rect.Zero;

    public final Rect getMaskRect() {
        float floatValue = this.maskLeftState$delegate.getFloatValue();
        float floatValue2 = this.maskTopState$delegate.getFloatValue();
        float floatValue3 = this.maskRightState$delegate.getFloatValue();
        float floatValue4 = this.maskBottomState$delegate.getFloatValue();
        Rect rect = this.cachedRect;
        if (floatValue == rect.left && floatValue2 == rect.top && floatValue3 == rect.right && floatValue4 == rect.bottom) {
            return rect;
        }
        Rect rect2 = new Rect(floatValue, floatValue2, floatValue3, floatValue4);
        this.cachedRect = rect2;
        return rect2;
    }
}
