package androidx.graphics.shapes;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableCubic extends Cubic {
    public final void transformOnePoint(PointTransformer pointTransformer, int i) {
        float[] fArr = this.points;
        int i2 = i + 1;
        long jMo273transformXgqJiTY = pointTransformer.mo273transformXgqJiTY(fArr[i], fArr[i2]);
        fArr[i] = Float.intBitsToFloat((int) (jMo273transformXgqJiTY >> 32));
        fArr[i2] = Float.intBitsToFloat((int) (4294967295L & jMo273transformXgqJiTY));
    }
}
