package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DefaultDraggableAnchors;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableUninitializedException extends Throwable {
    public final String message;

    public AnchoredDraggableUninitializedException(boolean z, boolean z2, DefaultDraggableAnchors defaultDraggableAnchors, Object obj) {
        this.message = "AnchoredDraggableState was not initialized correctly. isLookingAhead=" + z + ",didLookahead=" + z2 + ",anchors=" + defaultDraggableAnchors + ",targetValue=" + obj;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.message;
    }
}
