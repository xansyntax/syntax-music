package androidx.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Averages {
    public long applyTimeNanos;
    public long measureTimeNanos;
    public int nestedPrefetchCount;
    public long pauseTimeNanos;
    public long resumeTimeNanos;

    public static long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        return (j / 4) + ((j2 / 4) * 3);
    }
}
