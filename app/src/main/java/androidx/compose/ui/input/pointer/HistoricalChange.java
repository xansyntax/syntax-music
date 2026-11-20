package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HistoricalChange {
    public final long originalEventPosition;
    public final long panOffset;
    public final long position;
    public final float scaleFactor;
    public final long uptimeMillis;

    public HistoricalChange(long j, long j2, float f, long j3) {
        this.uptimeMillis = j;
        this.position = j2;
        this.scaleFactor = f;
        this.panOffset = j3;
        this.originalEventPosition = 0L;
    }

    public final String toString() {
        return "HistoricalChange(uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m441toStringimpl(this.position) + ", scaleFactor=" + this.scaleFactor + ", panOffset=" + Offset.m441toStringimpl(this.panOffset) + ")";
    }

    public HistoricalChange(long j, long j2, float f, long j3, long j4) {
        this(j, j2, f, j3);
        this.originalEventPosition = j4;
    }
}
