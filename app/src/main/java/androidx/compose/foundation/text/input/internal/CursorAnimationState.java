package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorAnimationState {
    public final boolean animate;
    public final AtomicReference animationJob = new AtomicReference(null);
    public final ParcelableSnapshotMutableFloatState cursorAlpha$delegate = new ParcelableSnapshotMutableFloatState(CropImageView.DEFAULT_ASPECT_RATIO);

    public CursorAnimationState(boolean z) {
        this.animate = z;
    }
}
