package io.ktor.client.plugins.cache.storage;

import io.ktor.utils.io.IODispatcher_jvmKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/io/files/Path;", "directory", "Lkotlinx/io/files/FileSystem;", "fileSystem", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "FileStorage", "(Lkotlinx/io/files/Path;Lkotlinx/io/files/FileSystem;Lkotlinx/coroutines/CoroutineDispatcher;)Lio/ktor/client/plugins/cache/storage/CacheStorage;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class FileStorageKt {
    public static final CacheStorage FileStorage(Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) {
        path.getClass();
        fileSystem.getClass();
        coroutineDispatcher.getClass();
        return new CachingCacheStorage(new FileCacheStorage(path, fileSystem, coroutineDispatcher));
    }

    public static /* synthetic */ CacheStorage FileStorage$default(Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            fileSystem = FileSystemJvmKt.SystemFileSystem;
        }
        if ((i & 4) != 0) {
            coroutineDispatcher = IODispatcher_jvmKt.ioDispatcher();
        }
        return FileStorage(path, fileSystem, coroutineDispatcher);
    }
}
