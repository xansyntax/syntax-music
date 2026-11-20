package kotlin.time;

import io.ktor.client.utils.CIOKt;
import io.ktor.util.date.GMTDateParser;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Duration implements Comparable {
    public final long rawValue;
    public static final Path.Companion Companion = new Path.Companion(10);
    public static final long INFINITE = InstantKt.durationOfMillis(4611686018427387903L);
    public static final long NEG_INFINITE = InstantKt.durationOfMillis(-4611686018427387903L);
    public static final long INVALID = 9223372036854759646L;

    public /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    public static final long m1884addValuesMixedRangesUwyO8pc(long j, long j2) {
        long j3 = j2 / 1000000;
        long jAddMillisWithoutOverflow = InstantKt.addMillisWithoutOverflow(j, j3);
        if (-4611686018426L > jAddMillisWithoutOverflow || jAddMillisWithoutOverflow >= 4611686018427L) {
            return InstantKt.durationOfMillis(jAddMillisWithoutOverflow);
        }
        long j4 = ((jAddMillisWithoutOverflow * 1000000) + (j2 - (j3 * 1000000))) << 1;
        int i = DurationJvmKt.$r8$clinit;
        return j4;
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    public static final void m1885appendFractionalimpl(StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strPadStart = StringsKt.padStart(i3, String.valueOf(i2));
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strPadStart, 0, i6);
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1886compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return j < 0 ? -i : i;
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1887getInWholeMillisecondsimpl(long j) {
        return ((((int) j) & 1) != 1 || m1889isInfiniteimpl(j)) ? m1891toLongimpl(j, DurationUnit.MILLISECONDS) : j >> 1;
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1888getNanosecondsComponentimpl(long j) {
        if (m1889isInfiniteimpl(j)) {
            return 0;
        }
        return (int) ((((int) j) & 1) == 1 ? ((j >> 1) % 1000) * 1000000 : (j >> 1) % 1000000000);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1889isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1890plusLRDsOJo(long j, long j2) {
        int i = ((int) j) & 1;
        if (i != (((int) j2) & 1)) {
            return i == 1 ? m1884addValuesMixedRangesUwyO8pc(j >> 1, j2 >> 1) : m1884addValuesMixedRangesUwyO8pc(j2 >> 1, j >> 1);
        }
        if (i == 0) {
            long j3 = (j >> 1) + (j2 >> 1);
            if (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) {
                return InstantKt.durationOfMillis(j3 / 1000000);
            }
            long j4 = j3 << 1;
            int i2 = DurationJvmKt.$r8$clinit;
            return j4;
        }
        long jAddMillisWithoutOverflow = InstantKt.addMillisWithoutOverflow(j >> 1, j2 >> 1);
        if (jAddMillisWithoutOverflow == 9223372036854759646L) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Summing infinite durations of different signs yields an undefined result.");
            return 0L;
        }
        if (jAddMillisWithoutOverflow == 4611686018427387903L || jAddMillisWithoutOverflow == -4611686018427387903L) {
            return InstantKt.durationOfMillis(jAddMillisWithoutOverflow);
        }
        if (-4611686018426L > jAddMillisWithoutOverflow || jAddMillisWithoutOverflow >= 4611686018427L) {
            return InstantKt.durationOfMillis(UuidKt.coerceIn(jAddMillisWithoutOverflow, -4611686018427387903L, 4611686018427387903L));
        }
        long j5 = (jAddMillisWithoutOverflow * 1000000) << 1;
        int i3 = DurationJvmKt.$r8$clinit;
        return j5;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1891toLongimpl(long j, DurationUnit durationUnit) {
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return durationUnit.timeUnit.convert(j >> 1, ((((int) j) & 1) == 0 ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS).timeUnit);
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1892unaryMinusUwyO8pc(long j) {
        long j2 = ((-(j >> 1)) << 1) + ((long) (((int) j) & 1));
        int i = DurationJvmKt.$r8$clinit;
        return j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return m1886compareToLRDsOJo(this.rawValue, ((Duration) obj).rawValue);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Duration) {
            return this.rawValue == ((Duration) obj).rawValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.rawValue);
    }

    public final String toString() {
        long jM1892unaryMinusUwyO8pc = this.rawValue;
        if (jM1892unaryMinusUwyO8pc == 0) {
            return "0s";
        }
        if (jM1892unaryMinusUwyO8pc == INFINITE) {
            return "Infinity";
        }
        if (jM1892unaryMinusUwyO8pc == NEG_INFINITE) {
            return "-Infinity";
        }
        int i = 0;
        boolean z = jM1892unaryMinusUwyO8pc < 0;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('-');
        }
        if (jM1892unaryMinusUwyO8pc < 0) {
            jM1892unaryMinusUwyO8pc = m1892unaryMinusUwyO8pc(jM1892unaryMinusUwyO8pc);
        }
        long jM1891toLongimpl = m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.DAYS);
        int iM1891toLongimpl = m1889isInfiniteimpl(jM1892unaryMinusUwyO8pc) ? 0 : (int) (m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.HOURS) % 24);
        int iM1891toLongimpl2 = m1889isInfiniteimpl(jM1892unaryMinusUwyO8pc) ? 0 : (int) (m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.MINUTES) % 60);
        int iM1891toLongimpl3 = m1889isInfiniteimpl(jM1892unaryMinusUwyO8pc) ? 0 : (int) (m1891toLongimpl(jM1892unaryMinusUwyO8pc, DurationUnit.SECONDS) % 60);
        int iM1888getNanosecondsComponentimpl = m1888getNanosecondsComponentimpl(jM1892unaryMinusUwyO8pc);
        boolean z2 = jM1891toLongimpl != 0;
        boolean z3 = iM1891toLongimpl != 0;
        boolean z4 = iM1891toLongimpl2 != 0;
        boolean z5 = (iM1891toLongimpl3 == 0 && iM1888getNanosecondsComponentimpl == 0) ? false : true;
        if (z2) {
            sb.append(jM1891toLongimpl);
            sb.append(GMTDateParser.DAY_OF_MONTH);
            i = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1891toLongimpl);
            sb.append(GMTDateParser.HOURS);
            i = i2;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1891toLongimpl2);
            sb.append(GMTDateParser.MINUTES);
            i = i3;
        }
        if (z5) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM1891toLongimpl3 != 0 || z2 || z3 || z4) {
                m1885appendFractionalimpl(sb, iM1891toLongimpl3, iM1888getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM1888getNanosecondsComponentimpl >= 1000000) {
                m1885appendFractionalimpl(sb, iM1888getNanosecondsComponentimpl / 1000000, iM1888getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (iM1888getNanosecondsComponentimpl >= 1000) {
                m1885appendFractionalimpl(sb, iM1888getNanosecondsComponentimpl / CIOKt.DEFAULT_HTTP_POOL_SIZE, iM1888getNanosecondsComponentimpl % CIOKt.DEFAULT_HTTP_POOL_SIZE, 3, "us", false);
            } else {
                sb.append(iM1888getNanosecondsComponentimpl);
                sb.append("ns");
            }
            i = i4;
        }
        if (z && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
