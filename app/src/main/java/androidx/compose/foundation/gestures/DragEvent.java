package androidx.compose.foundation.gestures;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragEvent {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DragCancelled extends DragEvent {
        public static final DragCancelled INSTANCE = new DragCancelled();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DragDelta extends DragEvent {
        public final long delta;
        public final boolean isIndirectPointerEvent;

        public DragDelta(long j, boolean z) {
            this.delta = j;
            this.isIndirectPointerEvent = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DragStarted extends DragEvent {
        public final long startPoint;

        public DragStarted(long j) {
            this.startPoint = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class DragStopped extends DragEvent {
        public final boolean isIndirectPointerEvent;
        public final long velocity;

        public DragStopped(long j, boolean z) {
            this.velocity = j;
            this.isIndirectPointerEvent = z;
        }
    }
}
