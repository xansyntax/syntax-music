package androidx.compose.ui.platform;

import androidx.compose.ui.unit.IntSize;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DerivedSize {
    public static final DerivedSize Zero = new DerivedSize(0, 0);
    public final long dpSize;
    public final long pxSize;

    public DerivedSize(long j, long j2) {
        this.pxSize = j;
        this.dpSize = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DerivedSize) {
            DerivedSize derivedSize = (DerivedSize) obj;
            return IntSize.m810equalsimpl0(this.pxSize, derivedSize.pxSize) && this.dpSize == derivedSize.dpSize;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.dpSize) + (Long.hashCode(this.pxSize) * 31);
    }
}
