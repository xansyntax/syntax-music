package androidx.compose.foundation.shape;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RoundedCornerShapeKt {
    public static final RoundedCornerShape CircleShape = RoundedCornerShape(50);

    public static final RoundedCornerShape RoundedCornerShape(int i) {
        PercentCornerSize percentCornerSize = new PercentCornerSize(i);
        return new RoundedCornerShape(percentCornerSize, percentCornerSize, percentCornerSize, percentCornerSize);
    }

    /* JADX INFO: renamed from: RoundedCornerShape-0680j_4, reason: not valid java name */
    public static final RoundedCornerShape m185RoundedCornerShape0680j_4(float f) {
        DpCornerSize dpCornerSize = new DpCornerSize(f);
        return new RoundedCornerShape(dpCornerSize, dpCornerSize, dpCornerSize, dpCornerSize);
    }
}
