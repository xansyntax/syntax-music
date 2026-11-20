package dagger.internal;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DoubleCheck implements Provider {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance;
    public volatile Provider provider;

    public static Provider provider(Provider provider) {
        if (provider instanceof DoubleCheck) {
            return provider;
        }
        DoubleCheck doubleCheck = new DoubleCheck();
        doubleCheck.instance = UNINITIALIZED;
        doubleCheck.provider = provider;
        return doubleCheck;
    }

    @Override // dagger.internal.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.instance;
        Object obj3 = UNINITIALIZED;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            obj = this.instance;
            if (obj == obj3) {
                obj = this.provider.get();
                Object obj4 = this.instance;
                if (obj4 != obj3 && obj4 != obj) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                }
                this.instance = obj;
                this.provider = null;
            }
        }
        return obj;
    }
}
