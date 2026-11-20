package kotlin.time;

import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class TimeSource$Monotonic$ValueTimeMark implements Comparable {
    public final long reading;

    /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
    public static long m1894elapsedNowUwyO8pc(long j) {
        return (1 | (j - 1)) == Long.MAX_VALUE ? Duration.m1892unaryMinusUwyO8pc(InstantKt.infinityOfSign(j)) : InstantKt.saturatingFiniteDiff(MonotonicTimeSource.read(), j);
    }

    /* JADX INFO: renamed from: minus-6eNON_k, reason: not valid java name */
    public static final long m1895minus6eNON_k(long j, long j2) {
        int i = MonotonicTimeSource.$r8$clinit;
        if (((j2 - 1) | 1) != Long.MAX_VALUE) {
            return (1 | (j - 1)) == Long.MAX_VALUE ? InstantKt.infinityOfSign(j) : InstantKt.saturatingFiniteDiff(j, j2);
        }
        if (j != j2) {
            return Duration.m1892unaryMinusUwyO8pc(InstantKt.infinityOfSign(j2));
        }
        Path.Companion companion = Duration.Companion;
        return 0L;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        TimeSource$Monotonic$ValueTimeMark timeSource$Monotonic$ValueTimeMark = (TimeSource$Monotonic$ValueTimeMark) obj;
        timeSource$Monotonic$ValueTimeMark.getClass();
        return Duration.m1886compareToLRDsOJo(m1895minus6eNON_k(this.reading, timeSource$Monotonic$ValueTimeMark.reading), 0L);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TimeSource$Monotonic$ValueTimeMark) {
            return this.reading == ((TimeSource$Monotonic$ValueTimeMark) obj).reading;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.reading);
    }

    public final String toString() {
        return "ValueTimeMark(reading=" + this.reading + ')';
    }
}
