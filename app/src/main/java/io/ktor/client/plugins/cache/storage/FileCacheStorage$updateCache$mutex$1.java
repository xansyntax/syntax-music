package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class FileCacheStorage$updateCache$mutex$1 implements Function0 {
    public static final FileCacheStorage$updateCache$mutex$1 INSTANCE = new FileCacheStorage$updateCache$mutex$1();

    @Override // kotlin.jvm.functions.Function0
    public final Mutex invoke() {
        return new MutexImpl();
    }
}
