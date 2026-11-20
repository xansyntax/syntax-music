package kotlin.random;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {
    public final FallbackThreadLocalRandom$implStorage$1 implStorage = new FallbackThreadLocalRandom$implStorage$1((byte) 0);

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        Object obj = this.implStorage.get();
        obj.getClass();
        return (java.util.Random) obj;
    }
}
