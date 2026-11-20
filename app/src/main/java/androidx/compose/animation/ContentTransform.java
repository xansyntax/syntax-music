package androidx.compose.animation;

import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ContentTransform {
    public final ExitTransitionImpl initialContentExit;
    public final SizeTransformImpl sizeTransform;
    public final EnterTransitionImpl targetContentEnter;
    public final ParcelableSnapshotMutableFloatState targetContentZIndex$delegate;

    public ContentTransform(EnterTransitionImpl enterTransitionImpl, ExitTransitionImpl exitTransitionImpl, float f, SizeTransformImpl sizeTransformImpl) {
        this.targetContentEnter = enterTransitionImpl;
        this.initialContentExit = exitTransitionImpl;
        this.targetContentZIndex$delegate = new ParcelableSnapshotMutableFloatState(f);
        this.sizeTransform = sizeTransformImpl;
    }
}
