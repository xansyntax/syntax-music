package androidx.media3.container;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NalUnitUtil$H265SpsData {
    public final int bitDepthChromaMinus8;
    public final int bitDepthLumaMinus8;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int decodedHeight;
    public final int decodedWidth;
    public final int height;
    public final int maxNumReorderPics;
    public final int maxSubLayersMinus1;
    public final float pixelWidthHeightRatio;
    public final NalUnitUtil$H265ProfileTierLevel profileTierLevel;
    public final int width;

    public NalUnitUtil$H265SpsData(int i, NalUnitUtil$H265ProfileTierLevel nalUnitUtil$H265ProfileTierLevel, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11) {
        this.maxSubLayersMinus1 = i;
        this.profileTierLevel = nalUnitUtil$H265ProfileTierLevel;
        this.bitDepthLumaMinus8 = i2;
        this.bitDepthChromaMinus8 = i3;
        this.width = i4;
        this.height = i5;
        this.pixelWidthHeightRatio = f;
        this.maxNumReorderPics = i8;
        this.colorSpace = i9;
        this.colorRange = i10;
        this.colorTransfer = i11;
        this.decodedWidth = i6;
        this.decodedHeight = i7;
    }
}
