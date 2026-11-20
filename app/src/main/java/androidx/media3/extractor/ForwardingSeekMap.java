package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingSeekMap implements SeekMap {
    public final SeekMap seekMap;

    public ForwardingSeekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long getDurationUs() {
        return this.seekMap.getDurationUs();
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        return this.seekMap.getSeekPoints(j);
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean isEstimated() {
        return this.seekMap.isEstimated();
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean isSeekable() {
        return this.seekMap.isSeekable();
    }
}
