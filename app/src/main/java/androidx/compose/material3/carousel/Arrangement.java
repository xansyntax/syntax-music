package androidx.compose.material3.carousel;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Arrangement {
    public final int largeCount;
    public final float largeSize;
    public final int mediumCount;
    public final float mediumSize;
    public final int priority;
    public final int smallCount;
    public final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float cost(float f) {
        float f2 = this.smallSize;
        float f3 = this.largeSize;
        int i = this.smallCount;
        int i2 = this.largeCount;
        if (i2 > 0 && i > 0 && this.mediumCount > 0) {
            float f4 = this.mediumSize;
            if (f3 <= f4 || f4 <= f2) {
                return Float.MAX_VALUE;
            }
        } else if (i2 > 0 && i > 0 && f3 <= f2) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f - f3) * this.priority;
    }
}
