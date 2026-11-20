package androidx.compose.foundation.gestures.snapping;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SnapPosition {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Start implements SnapPosition {
        public static final Start INSTANCE = new Start();

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public final int position(int i, int i2) {
            return 0;
        }

        public final String toString() {
            return "Start";
        }
    }

    int position(int i, int i2);
}
