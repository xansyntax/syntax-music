package androidx.media3.container;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Mp4TimestampData implements Metadata.Entry {
    public final long creationTimestampSeconds;
    public final long modificationTimestampSeconds;
    public final long timescale;

    public Mp4TimestampData(long j, long j2, long j3) {
        this.creationTimestampSeconds = j;
        this.modificationTimestampSeconds = j2;
        this.timescale = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.creationTimestampSeconds == mp4TimestampData.creationTimestampSeconds && this.modificationTimestampSeconds == mp4TimestampData.modificationTimestampSeconds && this.timescale == mp4TimestampData.timescale;
    }

    public final int hashCode() {
        return Long.hashCode(this.timescale) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(527, 31, this.creationTimestampSeconds), 31, this.modificationTimestampSeconds);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.creationTimestampSeconds + ", modification time=" + this.modificationTimestampSeconds + ", timescale=" + this.timescale;
    }
}
