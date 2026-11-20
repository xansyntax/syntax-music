package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LongPressResult {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Canceled extends LongPressResult {
        public static final Canceled INSTANCE = new Canceled();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Released extends LongPressResult {
        public final PointerInputChange finalUpChange;

        public Released(PointerInputChange pointerInputChange) {
            this.finalUpChange = pointerInputChange;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Success extends LongPressResult {
        public static final Success INSTANCE = new Success();
    }
}
