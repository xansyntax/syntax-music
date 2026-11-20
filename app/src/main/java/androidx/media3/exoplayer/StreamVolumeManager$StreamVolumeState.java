package androidx.media3.exoplayer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StreamVolumeManager$StreamVolumeState {
    public final int maxVolume;
    public final int minVolume;
    public final boolean muted;
    public final int streamType;
    public final int volume;

    public StreamVolumeManager$StreamVolumeState(boolean z, int i, int i2, int i3, int i4) {
        this.streamType = i;
        this.volume = i2;
        this.muted = z;
        this.minVolume = i3;
        this.maxVolume = i4;
    }
}
