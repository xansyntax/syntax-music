package kotlin.time;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LongParser {
    public static final LongParser iso = new LongParser(4611686018427387903L, true);
    public final long lastDigitMax;
    public final long overflowThreshold;

    public LongParser(long j, boolean z) {
        this.overflowThreshold = j / 10;
        this.lastDigitMax = j % 10;
    }
}
