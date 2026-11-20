package kotlin.time;

import com.google.common.base.Splitter;
import io.ktor.client.utils.CIOKt;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class InstantKt {
    public static final int[] POWERS_OF_TEN = {1, 10, 100, CIOKt.DEFAULT_HTTP_POOL_SIZE, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    public static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    public static final int[] colonsInIsoOffsetString = {3, 6};
    public static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    public static final long addMillisWithoutOverflow(long j, long j2) {
        if (j != 4611686018427387903L && j != -4611686018427387903L) {
            return (j2 == 4611686018427387903L || j2 == -4611686018427387903L) ? j2 : UuidKt.coerceIn(j + j2, -4611686018427387903L, 4611686018427387903L);
        }
        if ((-4611686018427387903L >= j2 || j2 >= 4611686018427387903L) && (j2 ^ j) < 0) {
            return 9223372036854759646L;
        }
        return j;
    }

    public static final long convertDurationUnitToMilliseconds(long j, DurationUnit durationUnit) {
        long j2;
        int iOrdinal = durationUnit.ordinal();
        if (iOrdinal == 2) {
            j2 = 1;
        } else if (iOrdinal == 3) {
            j2 = 1000;
        } else if (iOrdinal == 4) {
            j2 = 60000;
        } else if (iOrdinal == 5) {
            j2 = 3600000;
        } else {
            if (iOrdinal != 6) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(durationUnit, "Wrong unit for millisMultiplier: ");
                return 0L;
            }
            j2 = 86400000;
        }
        if (j == 0) {
            return 0L;
        }
        if (j == 1) {
            if (j2 <= 4611686018427387903L) {
                return j2;
            }
        } else if (j2 != 1) {
            int iNumberOfLeadingZeros = (128 - Long.numberOfLeadingZeros(j)) - Long.numberOfLeadingZeros(j2);
            if (iNumberOfLeadingZeros < 63) {
                return j * j2;
            }
            if (iNumberOfLeadingZeros <= 63) {
                long j3 = j * j2;
                if (j3 <= 4611686018427387903L) {
                    return j3;
                }
            }
        } else if (j <= 4611686018427387903L) {
            return j;
        }
        return 4611686018427387903L;
    }

    public static final long durationOfMillis(long j) {
        long j2 = (j << 1) + 1;
        Duration.Companion.getClass();
        int i = DurationJvmKt.$r8$clinit;
        return j2;
    }

    public static final void formatIso$lambda$0$appendTwoDigits(StringBuilder sb, StringBuilder sb2, int i) {
        if (i < 10) {
            sb.append('0');
        }
        sb2.append(i);
    }

    public static final long infinityOfSign(long j) {
        if (j < 0) {
            Path.Companion companion = Duration.Companion;
            return Duration.NEG_INFINITE;
        }
        Path.Companion companion2 = Duration.Companion;
        return Duration.INFINITE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x017e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0199 A[LOOP:7: B:106:0x0197->B:107:0x0199, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:117:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:137:0x0221  */
    /* JADX WARN: Code duplicated, block: B:139:0x0225  */
    /* JADX WARN: Code duplicated, block: B:141:0x0229  */
    /* JADX WARN: Code duplicated, block: B:143:0x022d  */
    /* JADX WARN: Code duplicated, block: B:144:0x022f  */
    /* JADX WARN: Code duplicated, block: B:145:0x0232  */
    /* JADX WARN: Code duplicated, block: B:146:0x0235  */
    /* JADX WARN: Code duplicated, block: B:148:0x0238  */
    /* JADX WARN: Code duplicated, block: B:149:0x023a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0249 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:156:0x024b  */
    /* JADX WARN: Code duplicated, block: B:159:0x0257 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x0259  */
    /* JADX WARN: Code duplicated, block: B:162:0x026c  */
    /* JADX WARN: Code duplicated, block: B:194:0x029a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x029a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0213 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0282 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x027a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:211:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0155 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x0192 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0091  */
    /* JADX WARN: Code duplicated, block: B:77:0x0112  */
    /* JADX WARN: Code duplicated, block: B:81:0x011c  */
    /* JADX WARN: Code duplicated, block: B:87:0x012d  */
    /* JADX WARN: Code duplicated, block: B:89:0x013d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0145  */
    /* JADX WARN: Code duplicated, block: B:96:0x015c A[LOOP:5: B:95:0x015a->B:96:0x015c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x0172  */
    public static long parseDuration$default(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        int i5;
        int i6;
        int i7;
        long j2;
        char cCharAt;
        DurationUnit durationUnit;
        char cCharAt2;
        DurationUnit durationUnit2;
        long jAddMillisWithoutOverflow;
        int i8;
        int iMin;
        int i9;
        int i10;
        int i11;
        int iMin2;
        int i12;
        int i13;
        int i14;
        int i15;
        double d;
        long jRoundToLong;
        char cCharAt3;
        int i16;
        char cCharAt4;
        char cCharAt5;
        char cCharAt6;
        int i17;
        int i18;
        char cCharAt7;
        if (str.length() == 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("The string is empty");
            return 0L;
        }
        char cCharAt8 = str.charAt(0);
        int i19 = 1;
        char c = '-';
        char c2 = '+';
        if (cCharAt8 != '+') {
            i2 = cCharAt8 != '-' ? 0 : 1;
            i = i2;
        } else {
            i = 0;
            i2 = 1;
        }
        if (str.length() <= i2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("No components");
            return 0L;
        }
        if (str.charAt(i2) != 'P') {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
            return 0L;
        }
        int i20 = i2 + 1;
        if (i20 == str.length()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
            return 0L;
        }
        int i21 = 0;
        DurationUnit durationUnit3 = null;
        long jConvertDurationUnitToMilliseconds = 0;
        long j3 = 0;
        while (i20 < str.length()) {
            char cCharAt9 = str.charAt(i20);
            if (cCharAt9 != 'T') {
                LongParser longParser = LongParser.iso;
                int i22 = i19;
                char cCharAt10 = str.charAt(i20);
                if (cCharAt10 != c2) {
                    if (cCharAt10 != c) {
                        i3 = i20;
                    } else {
                        i3 = i20 + 1;
                        i4 = -1;
                    }
                    while (i3 < str.length() && str.charAt(i3) == '0') {
                        i3++;
                    }
                    j = 0;
                    while (true) {
                        if (i3 < str.length()) {
                            cCharAt6 = str.charAt(i3);
                            i5 = i20;
                            if ('0' > cCharAt6 && cCharAt6 < ':') {
                                i17 = cCharAt6 - '0';
                                i18 = i;
                                long j4 = longParser.overflowThreshold;
                                if (j > j4 || (j == j4 && i17 > longParser.lastDigitMax)) {
                                    i6 = i18;
                                    while (i3 < str.length() && '0' <= (cCharAt7 = str.charAt(i3)) && cCharAt7 < ':') {
                                        i3++;
                                    }
                                    if (i3 != str.length()) {
                                        if (i3 != i5 + ((cCharAt9 == '+' || cCharAt9 == '-') ? i22 : 0)) {
                                            j = 4611686018427387903L;
                                        }
                                    }
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                j = (j << 3) + (j << i22) + ((long) i17);
                                i3++;
                                i20 = i5;
                                longParser = longParser;
                                i = i18;
                            }
                            j2 = j;
                            cCharAt = str.charAt(i3);
                            durationUnit = DurationUnit.SECONDS;
                            if (cCharAt == '.') {
                                i8 = i3 + 1;
                                iMin = Math.min(i3 + 7, str.length());
                                i10 = 0;
                                for (i9 = i8; i9 < iMin; i9++) {
                                    cCharAt5 = str.charAt(i9);
                                    if ('0' <= cCharAt5 || cCharAt5 >= ':') {
                                        for (i11 = 0; i11 < 6 - (i9 - i8); i11++) {
                                            i10 = (i10 << 1) + (i10 << 3);
                                        }
                                        iMin2 = Math.min(i9 + 9, str.length());
                                        i12 = i9;
                                        i13 = 0;
                                        while (true) {
                                            if (i12 < iMin2) {
                                                i16 = iMin2;
                                                cCharAt4 = str.charAt(i12);
                                                i14 = i12;
                                                if ('0' > cCharAt4 && cCharAt4 < ':') {
                                                    i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                                    i12 = i14 + 1;
                                                    iMin2 = i16;
                                                }
                                            } else {
                                                i14 = i12;
                                            }
                                        }
                                        for (i15 = 0; i15 < 9 - (i14 - i9); i15++) {
                                            i13 = (i13 << 1) + (i13 << 3);
                                        }
                                        i3 = i14;
                                        while (i3 < str.length() && '0' <= (cCharAt3 = str.charAt(i3)) && cCharAt3 < ':') {
                                            i3++;
                                        }
                                        if (i3 != i8 || i3 == str.length() || str.charAt(i3) != 'S') {
                                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                            return 0L;
                                        }
                                        long j5 = (((long) i10) * 1000000000) + ((long) i13);
                                        long j6 = i4;
                                        double d2 = j5;
                                        switch (durationUnit) {
                                            case NANOSECONDS:
                                                d = 1.0E-15d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case MICROSECONDS:
                                                d = 1.0E-12d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case MILLISECONDS:
                                                d = 1.0E-9d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case SECONDS:
                                                d = 1.0E-6d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case MINUTES:
                                                d = 6.0E-5d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case HOURS:
                                                d = 0.0036d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            case DAYS:
                                                d = 0.0864d;
                                                jRoundToLong = MathKt.roundToLong(d2 * d);
                                                break;
                                            default:
                                                _UtilJvmKt$$ExternalSyntheticLambda0.m$3(durationUnit, "Unknown unit: ");
                                                jRoundToLong = 0;
                                                break;
                                        }
                                        j3 = jRoundToLong * j6;
                                    } else {
                                        i10 = (cCharAt5 - '0') + (i10 << 3) + (i10 << 1);
                                    }
                                }
                                while (i11 < 6 - (i9 - i8)) {
                                    i10 = (i10 << 1) + (i10 << 3);
                                }
                                iMin2 = Math.min(i9 + 9, str.length());
                                i12 = i9;
                                i13 = 0;
                                while (true) {
                                    if (i12 < iMin2) {
                                        i16 = iMin2;
                                        cCharAt4 = str.charAt(i12);
                                        i14 = i12;
                                        if ('0' > cCharAt4) {
                                        }
                                    } else {
                                        i14 = i12;
                                    }
                                    i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                    i12 = i14 + 1;
                                    iMin2 = i16;
                                }
                                while (i15 < 9 - (i14 - i9)) {
                                    i13 = (i13 << 1) + (i13 << 3);
                                }
                                i3 = i14;
                                while (i3 < str.length()) {
                                    i3++;
                                }
                                if (i3 != i8) {
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            cCharAt2 = str.charAt(i3);
                            durationUnit2 = DurationUnit.DAYS;
                            if (cCharAt2 == 'D') {
                                durationUnit = durationUnit2;
                            } else if (cCharAt2 == 'H') {
                                durationUnit = DurationUnit.HOURS;
                            } else if (cCharAt2 == 'M') {
                                durationUnit = DurationUnit.MINUTES;
                            } else if (cCharAt2 != 'S') {
                                durationUnit = null;
                            }
                            if (durationUnit == null) {
                                throw new IllegalArgumentException("Unknown duration unit short name: " + str.charAt(i3));
                            }
                            if (durationUnit3 == null && durationUnit3.compareTo(durationUnit) <= 0) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Unexpected order of duration components");
                                return 0L;
                            }
                            if (durationUnit == durationUnit2) {
                                if (i21 != 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jConvertDurationUnitToMilliseconds = convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4);
                            } else {
                                if (i21 == 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jAddMillisWithoutOverflow = addMillisWithoutOverflow(jConvertDurationUnitToMilliseconds, convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4));
                                if (jAddMillisWithoutOverflow == 9223372036854759646L) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jConvertDurationUnitToMilliseconds = jAddMillisWithoutOverflow;
                            }
                            i20 = i3 + 1;
                            durationUnit3 = durationUnit;
                            i19 = i22;
                            i = i6;
                            c = '-';
                            c2 = '+';
                        } else {
                            i5 = i20;
                        }
                        i6 = i;
                        if (i3 == str.length()) {
                            if (cCharAt9 != '+' || cCharAt9 == '-') {
                                i7 = i22;
                            } else {
                                i7 = 0;
                            }
                            if (i3 == i5 + i7) {
                            }
                            j2 = j;
                            cCharAt = str.charAt(i3);
                            durationUnit = DurationUnit.SECONDS;
                            if (cCharAt == '.') {
                                i8 = i3 + 1;
                                iMin = Math.min(i3 + 7, str.length());
                                i10 = 0;
                                while (i9 < iMin) {
                                    cCharAt5 = str.charAt(i9);
                                    if ('0' <= cCharAt5) {
                                    }
                                    while (i11 < 6 - (i9 - i8)) {
                                        i10 = (i10 << 1) + (i10 << 3);
                                    }
                                    iMin2 = Math.min(i9 + 9, str.length());
                                    i12 = i9;
                                    i13 = 0;
                                    while (true) {
                                        if (i12 < iMin2) {
                                            i16 = iMin2;
                                            cCharAt4 = str.charAt(i12);
                                            i14 = i12;
                                            if ('0' > cCharAt4) {
                                            }
                                        } else {
                                            i14 = i12;
                                        }
                                        i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                        i12 = i14 + 1;
                                        iMin2 = i16;
                                    }
                                    while (i15 < 9 - (i14 - i9)) {
                                        i13 = (i13 << 1) + (i13 << 3);
                                    }
                                    i3 = i14;
                                    while (i3 < str.length()) {
                                        i3++;
                                    }
                                    if (i3 != i8) {
                                    }
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                while (i11 < 6 - (i9 - i8)) {
                                    i10 = (i10 << 1) + (i10 << 3);
                                }
                                iMin2 = Math.min(i9 + 9, str.length());
                                i12 = i9;
                                i13 = 0;
                                while (true) {
                                    if (i12 < iMin2) {
                                        i16 = iMin2;
                                        cCharAt4 = str.charAt(i12);
                                        i14 = i12;
                                        if ('0' > cCharAt4) {
                                        }
                                    } else {
                                        i14 = i12;
                                    }
                                    i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                    i12 = i14 + 1;
                                    iMin2 = i16;
                                }
                                while (i15 < 9 - (i14 - i9)) {
                                    i13 = (i13 << 1) + (i13 << 3);
                                }
                                i3 = i14;
                                while (i3 < str.length()) {
                                    i3++;
                                }
                                if (i3 != i8) {
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            cCharAt2 = str.charAt(i3);
                            durationUnit2 = DurationUnit.DAYS;
                            if (cCharAt2 == 'D') {
                                durationUnit = durationUnit2;
                            } else if (cCharAt2 == 'H') {
                                durationUnit = DurationUnit.HOURS;
                            } else if (cCharAt2 == 'M') {
                                durationUnit = DurationUnit.MINUTES;
                            } else if (cCharAt2 != 'S') {
                                durationUnit = null;
                            }
                            if (durationUnit == null) {
                                throw new IllegalArgumentException("Unknown duration unit short name: " + str.charAt(i3));
                            }
                            if (durationUnit3 == null) {
                            }
                            if (durationUnit == durationUnit2) {
                                if (i21 != 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jConvertDurationUnitToMilliseconds = convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4);
                            } else {
                                if (i21 == 0) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jAddMillisWithoutOverflow = addMillisWithoutOverflow(jConvertDurationUnitToMilliseconds, convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4));
                                if (jAddMillisWithoutOverflow == 9223372036854759646L) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                    return 0L;
                                }
                                jConvertDurationUnitToMilliseconds = jAddMillisWithoutOverflow;
                            }
                            i20 = i3 + 1;
                            durationUnit3 = durationUnit;
                            i19 = i22;
                            i = i6;
                            c = '-';
                            c2 = '+';
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                        return 0L;
                    }
                }
                i3 = i20 + 1;
                i4 = i22;
                while (i3 < str.length()) {
                    i3++;
                }
                j = 0;
                while (true) {
                    if (i3 < str.length()) {
                        cCharAt6 = str.charAt(i3);
                        i5 = i20;
                        if ('0' > cCharAt6) {
                        }
                    } else {
                        i5 = i20;
                    }
                    i6 = i;
                    if (i3 == str.length()) {
                        if (cCharAt9 != '+') {
                            i7 = i22;
                        } else {
                            i7 = i22;
                        }
                        if (i3 == i5 + i7) {
                        }
                        j2 = j;
                        cCharAt = str.charAt(i3);
                        durationUnit = DurationUnit.SECONDS;
                        if (cCharAt == '.') {
                            i8 = i3 + 1;
                            iMin = Math.min(i3 + 7, str.length());
                            i10 = 0;
                            while (i9 < iMin) {
                                cCharAt5 = str.charAt(i9);
                                if ('0' <= cCharAt5) {
                                }
                                while (i11 < 6 - (i9 - i8)) {
                                    i10 = (i10 << 1) + (i10 << 3);
                                }
                                iMin2 = Math.min(i9 + 9, str.length());
                                i12 = i9;
                                i13 = 0;
                                while (true) {
                                    if (i12 < iMin2) {
                                        i16 = iMin2;
                                        cCharAt4 = str.charAt(i12);
                                        i14 = i12;
                                        if ('0' > cCharAt4) {
                                        }
                                    } else {
                                        i14 = i12;
                                    }
                                    i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                    i12 = i14 + 1;
                                    iMin2 = i16;
                                }
                                while (i15 < 9 - (i14 - i9)) {
                                    i13 = (i13 << 1) + (i13 << 3);
                                }
                                i3 = i14;
                                while (i3 < str.length()) {
                                    i3++;
                                }
                                if (i3 != i8) {
                                }
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            while (i11 < 6 - (i9 - i8)) {
                                i10 = (i10 << 1) + (i10 << 3);
                            }
                            iMin2 = Math.min(i9 + 9, str.length());
                            i12 = i9;
                            i13 = 0;
                            while (true) {
                                if (i12 < iMin2) {
                                    i16 = iMin2;
                                    cCharAt4 = str.charAt(i12);
                                    i14 = i12;
                                    if ('0' > cCharAt4) {
                                    }
                                } else {
                                    i14 = i12;
                                }
                                i13 = (cCharAt4 - '0') + (i13 << 3) + (i13 << 1);
                                i12 = i14 + 1;
                                iMin2 = i16;
                            }
                            while (i15 < 9 - (i14 - i9)) {
                                i13 = (i13 << 1) + (i13 << 3);
                            }
                            i3 = i14;
                            while (i3 < str.length()) {
                                i3++;
                            }
                            if (i3 != i8) {
                            }
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                            return 0L;
                        }
                        cCharAt2 = str.charAt(i3);
                        durationUnit2 = DurationUnit.DAYS;
                        if (cCharAt2 == 'D') {
                            durationUnit = durationUnit2;
                        } else if (cCharAt2 == 'H') {
                            durationUnit = DurationUnit.HOURS;
                        } else if (cCharAt2 == 'M') {
                            durationUnit = DurationUnit.MINUTES;
                        } else if (cCharAt2 != 'S') {
                            durationUnit = null;
                        }
                        if (durationUnit == null) {
                            throw new IllegalArgumentException("Unknown duration unit short name: " + str.charAt(i3));
                        }
                        if (durationUnit3 == null) {
                        }
                        if (durationUnit == durationUnit2) {
                            if (i21 != 0) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            jConvertDurationUnitToMilliseconds = convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4);
                        } else {
                            if (i21 == 0) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            jAddMillisWithoutOverflow = addMillisWithoutOverflow(jConvertDurationUnitToMilliseconds, convertDurationUnitToMilliseconds(j2, durationUnit) * ((long) i4));
                            if (jAddMillisWithoutOverflow == 9223372036854759646L) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                                return 0L;
                            }
                            jConvertDurationUnitToMilliseconds = jAddMillisWithoutOverflow;
                        }
                        i20 = i3 + 1;
                        durationUnit3 = durationUnit;
                        i19 = i22;
                        i = i6;
                        c = '-';
                        c2 = '+';
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                    return 0L;
                    j = (j << 3) + (j << i22) + ((long) i17);
                    i3++;
                    i20 = i5;
                    longParser = longParser;
                    i = i18;
                }
            } else {
                if (i21 != 0 || (i20 = i20 + 1) == str.length()) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("");
                    return 0L;
                }
                i21 = i19;
            }
        }
        int i23 = i;
        long jM1890plusLRDsOJo = Duration.m1890plusLRDsOJo(toDuration(jConvertDurationUnitToMilliseconds, DurationUnit.MILLISECONDS), toDuration(j3, DurationUnit.NANOSECONDS));
        return (i23 == 0 || jM1890plusLRDsOJo == Duration.INVALID) ? jM1890plusLRDsOJo : Duration.m1892unaryMinusUwyO8pc(jM1890plusLRDsOJo);
    }

    public static final Splitter parseIso$expect(String str, String str2, int i, Function1 function1) {
        char cCharAt = str.charAt(i);
        if (((Boolean) function1.invoke(Character.valueOf(cCharAt))).booleanValue()) {
            return null;
        }
        return parseIso$parseFailure(str, "Expected " + str2 + ", but got '" + cCharAt + "' at position " + i);
    }

    public static final Splitter parseIso$parseFailure(String str, String str2) {
        return new Splitter(str2 + " when parsing an Instant from \"" + truncateForErrorMessage(64, str) + '\"', str, (byte) 11);
    }

    public static final int parseIso$twoDigitNumber(int i, String str) {
        return (str.charAt(i + 1) - '0') + ((str.charAt(i) - '0') * 10);
    }

    public static final long saturatingFiniteDiff(long j, long j2) {
        long j3 = j - j2;
        long j4 = (j3 ^ j) & (~(j3 ^ j2));
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        if (j4 >= 0) {
            return toDuration(j3, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.m1892unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        long j5 = (j / 1000000) - (j2 / 1000000);
        long j6 = (j % 1000000) - (j2 % 1000000);
        Path.Companion companion = Duration.Companion;
        return Duration.m1890plusLRDsOJo(toDuration(j5, durationUnit2), toDuration(j6, durationUnit));
    }

    public static final long toDuration(long j, DurationUnit durationUnit) {
        TimeUnit timeUnit = durationUnit.timeUnit;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if ((-jConvert) <= j && j <= jConvert) {
            long jConvert2 = timeUnit2.convert(j, timeUnit);
            Path.Companion companion = Duration.Companion;
            long j2 = jConvert2 << 1;
            int i = DurationJvmKt.$r8$clinit;
            return j2;
        }
        if (durationUnit.compareTo(DurationUnit.MILLISECONDS) < 0) {
            return durationOfMillis(UuidKt.coerceIn(TimeUnit.MILLISECONDS.convert(j, timeUnit), -4611686018427387903L, 4611686018427387903L));
        }
        long jSignum = Long.signum(j);
        if (j < -9223372036854775807L) {
            j = -9223372036854775807L;
        }
        return durationOfMillis(convertDurationUnitToMilliseconds(Math.abs(j), durationUnit) * jSignum);
    }

    public static final String truncateForErrorMessage(int i, String str) {
        if (str.length() <= i) {
            return str.toString();
        }
        return str.subSequence(0, i).toString() + "...";
    }

    public static final long toDuration(int i, DurationUnit durationUnit) {
        if (durationUnit.compareTo(DurationUnit.SECONDS) <= 0) {
            long jConvert = TimeUnit.NANOSECONDS.convert(i, durationUnit.timeUnit);
            Path.Companion companion = Duration.Companion;
            long j = jConvert << 1;
            int i2 = DurationJvmKt.$r8$clinit;
            return j;
        }
        return toDuration(i, durationUnit);
    }
}
