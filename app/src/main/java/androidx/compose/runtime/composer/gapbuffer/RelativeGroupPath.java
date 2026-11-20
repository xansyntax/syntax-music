package androidx.compose.runtime.composer.gapbuffer;

import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RelativeGroupPath extends SQLite {
    public final int index;
    public final SQLite parent;

    public RelativeGroupPath(SQLite sQLite, int i) {
        this.parent = sQLite;
        this.index = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RelativeGroupPath)) {
            return false;
        }
        RelativeGroupPath relativeGroupPath = (RelativeGroupPath) obj;
        return relativeGroupPath.parent.equals(this.parent) && relativeGroupPath.index == this.index;
    }

    public final int hashCode() {
        return this.parent.hashCode() + (this.index * 31);
    }
}
