package androidx.compose.ui.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedScale implements ContentScale {
    @Override // androidx.compose.ui.layout.ContentScale
    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
    public final long mo597computeScaleFactorH7hwNQA(long j, long j2) {
        return (((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedScale) && Float.compare(1.0f, 1.0f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(1.0f);
    }

    public final String toString() {
        return "FixedScale(value=1.0)";
    }
}
