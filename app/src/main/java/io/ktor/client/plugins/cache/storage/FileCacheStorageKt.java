package io.ktor.client.plugins.cache.storage;

import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/io/File;", "directory", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "FileStorage", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileCacheStorageKt {
    @Deprecated
    public static final CacheStorage FileStorage(File file, CoroutineDispatcher coroutineDispatcher) {
        file.getClass();
        coroutineDispatcher.getClass();
        String path = file.getPath();
        path.getClass();
        char c = PathsJvmKt.SystemPathSeparator;
        return FileStorageKt.FileStorage$default(new Path(new File(path)), null, coroutineDispatcher, 2, null);
    }

    public static CacheStorage FileStorage$default(File file, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            coroutineDispatcher = DefaultIoScheduler.INSTANCE;
        }
        return FileStorage(file, coroutineDispatcher);
    }
}
