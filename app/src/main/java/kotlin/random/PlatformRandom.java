package kotlin.random;

import java.io.Serializable;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    public final SecureRandom impl;

    public PlatformRandom(SecureRandom secureRandom) {
        this.impl = secureRandom;
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random getImpl() {
        return this.impl;
    }
}
