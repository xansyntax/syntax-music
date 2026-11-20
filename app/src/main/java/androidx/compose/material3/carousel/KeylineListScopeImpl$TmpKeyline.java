package androidx.compose.material3.carousel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class KeylineListScopeImpl$TmpKeyline {
    public final boolean isAnchor;
    public final float size;

    public KeylineListScopeImpl$TmpKeyline(float f, boolean z) {
        this.size = f;
        this.isAnchor = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeylineListScopeImpl$TmpKeyline)) {
            return false;
        }
        KeylineListScopeImpl$TmpKeyline keylineListScopeImpl$TmpKeyline = (KeylineListScopeImpl$TmpKeyline) obj;
        return Float.compare(this.size, keylineListScopeImpl$TmpKeyline.size) == 0 && this.isAnchor == keylineListScopeImpl$TmpKeyline.isAnchor;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isAnchor) + (Float.hashCode(this.size) * 31);
    }

    public final String toString() {
        return "TmpKeyline(size=" + this.size + ", isAnchor=" + this.isAnchor + ")";
    }
}
