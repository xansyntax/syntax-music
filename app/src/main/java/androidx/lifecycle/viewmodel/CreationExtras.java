package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CreationExtras {
    public final LinkedHashMap extras = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Empty extends CreationExtras {
        public static final Empty INSTANCE = new Empty();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Key {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CreationExtras) {
            return this.extras.equals(((CreationExtras) obj).extras);
        }
        return false;
    }

    public Object get(Key key) {
        return null;
    }

    public final int hashCode() {
        return this.extras.hashCode();
    }

    public final String toString() {
        return "CreationExtras(extras=" + this.extras + ")";
    }
}
