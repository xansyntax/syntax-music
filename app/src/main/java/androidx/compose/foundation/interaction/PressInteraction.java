package androidx.compose.foundation.interaction;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Cancel implements PressInteraction {
        public final Press press;

        public Cancel(Press press) {
            this.press = press;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Press implements PressInteraction {
        public final long pressPosition;

        public Press(long j) {
            this.pressPosition = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Release implements PressInteraction {
        public final Press press;

        public Release(Press press) {
            this.press = press;
        }
    }
}
