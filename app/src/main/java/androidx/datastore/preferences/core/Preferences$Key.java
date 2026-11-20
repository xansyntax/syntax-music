package androidx.datastore.preferences.core;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Preferences$Key {
    public final String name;

    public Preferences$Key(String str) {
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Preferences$Key)) {
            return false;
        }
        return this.name.equals(((Preferences$Key) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return this.name;
    }
}
