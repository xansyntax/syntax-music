package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VorbisUtil$VorbisIdHeader {
    public final int bitrateMaximum;
    public final int bitrateNominal;
    public final int blockSize0;
    public final int blockSize1;
    public final short channels;
    public final byte[] data;
    public final int sampleRate;

    /* JADX WARN: Multi-variable type inference failed */
    public VorbisUtil$VorbisIdHeader(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.channels = i;
        this.sampleRate = i2;
        this.bitrateMaximum = i3;
        this.bitrateNominal = i4;
        this.blockSize0 = i5;
        this.blockSize1 = i6;
        this.data = bArr;
    }
}
