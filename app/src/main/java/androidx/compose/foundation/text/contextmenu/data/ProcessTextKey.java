package androidx.compose.foundation.text.contextmenu.data;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessTextKey {
    public final int id;

    public ProcessTextKey(int i) {
        this.id = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ProcessTextKey) {
            return this.id == ((ProcessTextKey) obj).id;
        }
        return false;
    }

    public final int hashCode() {
        return this.id;
    }
}
