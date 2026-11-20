package androidx.media3.container;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NalUnitUtil$H265RepFormat {
    public final int bitDepthChromaMinus8;
    public final int bitDepthLumaMinus8;
    public final int chromaFormatIdc;
    public final int height;
    public final int width;

    public NalUnitUtil$H265RepFormat(int i, int i2, int i3, int i4, int i5) {
        this.chromaFormatIdc = i;
        this.bitDepthLumaMinus8 = i2;
        this.bitDepthChromaMinus8 = i3;
        this.width = i4;
        this.height = i5;
    }
}
