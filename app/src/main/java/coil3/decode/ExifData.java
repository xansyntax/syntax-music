package coil3.decode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExifData {
    public static final ExifData NONE = new ExifData(false, 0);
    public final boolean isFlipped;
    public final int rotationDegrees;

    public ExifData(boolean z, int i) {
        this.isFlipped = z;
        this.rotationDegrees = i;
    }
}
