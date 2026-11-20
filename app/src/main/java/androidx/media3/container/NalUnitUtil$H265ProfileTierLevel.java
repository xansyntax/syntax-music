package androidx.media3.container;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NalUnitUtil$H265ProfileTierLevel {
    public final int[] constraintBytes;
    public final int generalLevelIdc;
    public final int generalProfileCompatibilityFlags;
    public final int generalProfileIdc;
    public final int generalProfileSpace;
    public final boolean generalTierFlag;

    public NalUnitUtil$H265ProfileTierLevel(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        this.generalProfileSpace = i;
        this.generalTierFlag = z;
        this.generalProfileIdc = i2;
        this.generalProfileCompatibilityFlags = i3;
        this.constraintBytes = iArr;
        this.generalLevelIdc = i4;
    }
}
