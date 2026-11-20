package io.ktor.client.plugins.cache.storage;

import io.ktor.util.collections.ConcurrentSetKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FileCacheStorage$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ byte $r8$classId;

    public /* synthetic */ FileCacheStorage$$ExternalSyntheticLambda0(byte b) {
        this.$r8$classId = b;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return FileCacheStorage.readCache$lambda$0();
            case 1:
                return FileCacheStorage.deleteCache$lambda$0();
            case 2:
                return CacheStorage.Companion.Unlimited$lambda$0();
            case 3:
                return HttpCacheStorage.Unlimited$lambda$0();
            case 4:
                return ConcurrentSetKt.ConcurrentSet();
            case 5:
                return ConcurrentSetKt.ConcurrentSet();
            case 6:
                return ConcurrentSetKt.ConcurrentSet();
            default:
                return ConcurrentSetKt.ConcurrentSet();
        }
    }
}
