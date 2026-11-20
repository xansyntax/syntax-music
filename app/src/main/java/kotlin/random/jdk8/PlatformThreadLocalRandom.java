package kotlin.random.jdk8;

import java.util.concurrent.ThreadLocalRandom;
import kotlin.random.AbstractPlatformRandom;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.Random
    public final int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(0, i2);
    }

    @Override // kotlin.random.Random
    public final long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // kotlin.random.Random
    public final long nextLong$1(long j) {
        return ThreadLocalRandom.current().nextLong(0L, j);
    }
}
