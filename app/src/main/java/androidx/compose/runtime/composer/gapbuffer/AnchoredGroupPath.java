package androidx.compose.runtime.composer.gapbuffer;

import androidx.sqlite.SQLite;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredGroupPath extends SQLite {
    public final int group;

    public AnchoredGroupPath(int i) {
        this.group = i;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AnchoredGroupPath) && ((AnchoredGroupPath) obj).group == this.group;
    }

    public final int hashCode() {
        return this.group * 31;
    }
}
