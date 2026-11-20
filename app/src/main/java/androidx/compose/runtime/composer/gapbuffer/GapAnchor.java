package androidx.compose.runtime.composer.gapbuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GapAnchor {
    public int location;

    public GapAnchor(int i) {
        this.location = i;
    }

    public final boolean getValid() {
        return this.location != Integer.MIN_VALUE;
    }

    public final String toString() {
        return super.toString() + "{ location = " + this.location + " }";
    }
}
