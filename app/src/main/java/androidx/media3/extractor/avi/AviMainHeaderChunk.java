package androidx.media3.extractor.avi;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AviMainHeaderChunk implements AviChunk {
    public final int flags;
    public final int frameDurationUs;
    public final int totalFrames;

    public AviMainHeaderChunk(int i, int i2, int i3) {
        this.frameDurationUs = i;
        this.flags = i2;
        this.totalFrames = i3;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1751742049;
    }
}
