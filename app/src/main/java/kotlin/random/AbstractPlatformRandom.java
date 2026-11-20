package kotlin.random;

import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractPlatformRandom extends Random {
    public java.util.Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        threadLocalRandomCurrent.getClass();
        return threadLocalRandomCurrent;
    }

    @Override // kotlin.random.Random
    public final int nextBits(int i) {
        return (getImpl().nextInt() >>> (32 - i)) & ((-i) >> 31);
    }

    @Override // kotlin.random.Random
    public final void nextBytes(byte[] bArr) {
        bArr.getClass();
        getImpl().nextBytes(bArr);
    }

    @Override // kotlin.random.Random
    public final int nextInt() {
        return getImpl().nextInt();
    }

    @Override // kotlin.random.Random
    public final long nextLong() {
        return getImpl().nextLong();
    }

    @Override // kotlin.random.Random
    public final int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
