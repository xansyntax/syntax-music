package androidx.compose.material3;

import androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda3;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.provider.CallbackWrapper;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarState {
    public static final CallbackWrapper Saver = SaverKt.listSaver(new ScrollState$$ExternalSyntheticLambda3(21), new TextKt$$ExternalSyntheticLambda0(13));
    public final ParcelableSnapshotMutableFloatState _heightOffset;
    public final ParcelableSnapshotMutableFloatState contentOffset$delegate;
    public float heightOffsetLimit;

    public TopAppBarState(float f, float f2, float f3) {
        this.heightOffsetLimit = f;
        this.contentOffset$delegate = new ParcelableSnapshotMutableFloatState(f3);
        this._heightOffset = new ParcelableSnapshotMutableFloatState(f2);
    }

    public final void setHeightOffset(float f) {
        this._heightOffset.setFloatValue(UuidKt.coerceIn(f, this.heightOffsetLimit, CropImageView.DEFAULT_ASPECT_RATIO));
    }
}
