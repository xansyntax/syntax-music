package kotlin.random;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.internal.jdk8.JDK8PlatformImplementations$ReflectSdkVersion;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Random {
    public static final AbstractPlatformRandom defaultRandom;

    static {
        Integer num = JDK8PlatformImplementations$ReflectSdkVersion.sdkVersion;
        defaultRandom = (num == null || num.intValue() >= 34) ? new PlatformThreadLocalRandom() : new FallbackThreadLocalRandom();
    }

    public int nextBits(int i) {
        return defaultRandom.nextBits(i);
    }

    public byte[] nextBytes(byte[] bArr, int i) {
        bArr.getClass();
        if (bArr.length < 0 || i < 0 || i > bArr.length) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m2m(i, "fromIndex (0) or toIndex (", ") are out of range: 0.."), bArr.length, '.'));
            return null;
        }
        if (i < 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m(i, "fromIndex (0) must be not greater than toIndex (", ")."));
            return null;
        }
        int i2 = i / 4;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int iNextInt = nextInt();
            bArr[i3] = (byte) iNextInt;
            bArr[i3 + 1] = (byte) (iNextInt >>> 8);
            bArr[i3 + 2] = (byte) (iNextInt >>> 16);
            bArr[i3 + 3] = (byte) (iNextInt >>> 24);
            i3 += 4;
        }
        int i5 = i - i3;
        int iNextBits = nextBits(i5 * 8);
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i3 + i6] = (byte) (iNextBits >>> (i6 * 8));
        }
        return bArr;
    }

    public int nextInt(int i, int i2) {
        int iNextInt;
        int i3;
        int iNextBits;
        if (i2 <= i) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) CollectionsKt__IterablesKt.boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)));
            return 0;
        }
        int i4 = i2 - i;
        if (i4 > 0 || i4 == Integer.MIN_VALUE) {
            if (((-i4) & i4) == i4) {
                iNextBits = nextBits(31 - Integer.numberOfLeadingZeros(i4));
            } else {
                do {
                    iNextInt = nextInt() >>> 1;
                    i3 = iNextInt % i4;
                } while ((i4 - 1) + (iNextInt - i3) < 0);
                iNextBits = i3;
            }
            return i + iNextBits;
        }
        while (true) {
            int iNextInt2 = nextInt();
            if (i <= iNextInt2 && iNextInt2 < i2) {
                return iNextInt2;
            }
        }
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public long nextLong$1(long j) {
        long jNextLong;
        long j2;
        int iNextInt;
        if (j <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) CollectionsKt__IterablesKt.boundsErrorMessage(0L, Long.valueOf(j)));
            return 0L;
        }
        if (j > 0) {
            if (((-j) & j) != j) {
                do {
                    jNextLong = nextLong() >>> 1;
                    j2 = jNextLong % j;
                } while ((j - 1) + (jNextLong - j2) < 0);
                return j2;
            }
            int i = (int) j;
            int i2 = (int) (j >>> 32);
            if (i != 0) {
                iNextInt = nextBits(31 - Integer.numberOfLeadingZeros(i));
            } else {
                if (i2 != 1) {
                    return (((long) nextBits(31 - Integer.numberOfLeadingZeros(i2))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                iNextInt = nextInt();
            }
            return ((long) iNextInt) & 4294967295L;
        }
        while (true) {
            long jNextLong2 = nextLong();
            if (0 <= jNextLong2 && jNextLong2 < j) {
                return jNextLong2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Default extends Random implements Serializable {
        private final void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        @Override // kotlin.random.Random
        public final void nextBytes(byte[] bArr) {
            bArr.getClass();
            AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
            abstractPlatformRandom.getClass();
            abstractPlatformRandom.getImpl().nextBytes(bArr);
        }

        @Override // kotlin.random.Random
        public final int nextInt(int i, int i2) {
            return Random.defaultRandom.nextInt(0, i2);
        }

        @Override // kotlin.random.Random
        public final long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        @Override // kotlin.random.Random
        public final long nextLong(long j) {
            throw null;
        }

        @Override // kotlin.random.Random
        public final long nextLong$1(long j) {
            return Random.defaultRandom.nextLong$1(j);
        }

        @Override // kotlin.random.Random
        public final int nextInt(int i) {
            return Random.defaultRandom.nextInt(i);
        }

        @Override // kotlin.random.Random
        public final byte[] nextBytes(byte[] bArr, int i) {
            bArr.getClass();
            Random.defaultRandom.nextBytes(bArr, i);
            return bArr;
        }
    }

    public long nextLong(long j) {
        return nextLong$1(j);
    }

    public int nextInt(int i) {
        return nextInt(0, i);
    }

    public int nextInt() {
        return defaultRandom.nextInt();
    }

    public void nextBytes(byte[] bArr) {
        bArr.getClass();
        nextBytes(bArr, bArr.length);
    }
}
