package kotlin.time;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MonotonicTimeSource {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long zero = System.nanoTime();

    public static long read() {
        return System.nanoTime() - zero;
    }
}
