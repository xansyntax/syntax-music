package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CacheEntry {
    public final KSerializer serializer;

    public CacheEntry(KSerializer kSerializer) {
        this.serializer = kSerializer;
    }
}
