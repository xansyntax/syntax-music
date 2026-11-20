package androidx.media3.exoplayer.trackselection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AdaptiveTrackSelection$AdaptationCheckpoint {
    public final long allocatedBandwidth;
    public final long totalBandwidth;

    public AdaptiveTrackSelection$AdaptationCheckpoint(long j, long j2) {
        this.totalBandwidth = j;
        this.allocatedBandwidth = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptiveTrackSelection$AdaptationCheckpoint)) {
            return false;
        }
        AdaptiveTrackSelection$AdaptationCheckpoint adaptiveTrackSelection$AdaptationCheckpoint = (AdaptiveTrackSelection$AdaptationCheckpoint) obj;
        return this.totalBandwidth == adaptiveTrackSelection$AdaptationCheckpoint.totalBandwidth && this.allocatedBandwidth == adaptiveTrackSelection$AdaptationCheckpoint.allocatedBandwidth;
    }

    public final int hashCode() {
        return (((int) this.totalBandwidth) * 31) + ((int) this.allocatedBandwidth);
    }
}
