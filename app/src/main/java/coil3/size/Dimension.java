package coil3.size;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Dimension {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Pixels implements Dimension {
        public final int px;

        public /* synthetic */ Pixels(int i) {
            this.px = i;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static void m859constructorimpl(int i) {
            if (i > 0) {
                return;
            }
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("px must be > 0.");
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Pixels) {
                return this.px == ((Pixels) obj).px;
            }
            return false;
        }

        public final int hashCode() {
            return Integer.hashCode(this.px);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m(this.px, "Pixels(px=", ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Undefined implements Dimension {
        public static final Undefined INSTANCE = new Undefined();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof Undefined);
        }

        public final int hashCode() {
            return -2093724603;
        }

        public final String toString() {
            return "Undefined";
        }
    }
}
