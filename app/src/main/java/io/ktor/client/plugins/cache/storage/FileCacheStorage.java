package io.ktor.client.plugins.cache.storage;

import dagger.hilt.EntryPoints;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.HexExtensionsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.io.InputStreamSource;
import kotlinx.io.JvmCoreKt;
import kotlinx.io.OutputStreamSink;
import kotlinx.io.RealSink;
import kotlinx.io.RealSource;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.Path;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path$$ExternalSyntheticBUOutline0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0096@¢\u0006\u0004\b\u0019\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u001a\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0082H¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010$\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b%\u0010&J8\u0010*\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00152\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0(0'H\u0082H¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b,\u0010&J&\u0010.\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0082@¢\u0006\u0004\b.\u0010/J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010$\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b0\u0010&J\u001f\u00104\u001a\u00020\u000e2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u00105J\u0017\u0010%\u001a\u00020\f2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b%\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010:R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010;R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Lkotlinx/io/files/Path;", "directoryPath", "Lkotlinx/io/files/FileSystem;", "fileSystem", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Lkotlinx/io/files/Path;Lkotlinx/io/files/FileSystem;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlin/Function0;", "block", "withReadAccess", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "(Lio/ktor/http/Url;)Ljava/lang/String;", "urlHex", "readCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "transform", "updateCache", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCache", "caches", "writeCacheUnsafe", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readCacheUnsafe", "Lkotlinx/io/Sink;", "sink", "cache", "writeCache", "(Lkotlinx/io/Sink;Lio/ktor/client/plugins/cache/storage/CachedResponseData;)V", "Lkotlinx/io/Source;", "source", "(Lkotlinx/io/Source;)Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/io/files/Path;", "Lkotlinx/io/files/FileSystem;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlinx/coroutines/sync/Mutex;", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "accessGate", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/channels/Channel;", "readersDrained", "Lkotlinx/coroutines/channels/Channel;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class FileCacheStorage implements CacheStorage {
    static final /* synthetic */ AtomicIntegerFieldUpdater activeReaders$FU = AtomicIntegerFieldUpdater.newUpdater(FileCacheStorage.class, "activeReaders");
    private final Mutex accessGate;
    volatile /* synthetic */ int activeReaders;
    private final Path directoryPath;
    private final CoroutineDispatcher dispatcher;
    private final FileSystem fileSystem;
    private final ConcurrentMap<String, Mutex> mutexes;
    private final Channel readersDrained;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$clear$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$clear$2", f = "FileStorage.kt", l = {259, 100}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0059 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:7:0x001a, B:19:0x0055, B:21:0x0059, B:24:0x006e, B:25:0x0080, B:27:0x0089, B:28:0x008f, B:30:0x0097, B:32:0x00a1, B:33:0x00bf), top: B:40:0x001a, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0089 A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #1 {all -> 0x001e, blocks: (B:7:0x001a, B:19:0x0055, B:21:0x0059, B:24:0x006e, B:25:0x0080, B:27:0x0089, B:28:0x008f, B:30:0x0097, B:32:0x00a1, B:33:0x00bf), top: B:40:0x001a, inners: #0 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x006d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:19:0x0055->B:45:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:46:0x00bf A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            FileCacheStorage fileCacheStorage;
            int i;
            Mutex mutex2;
            FileCacheStorage fileCacheStorage2;
            int i2;
            int i3;
            ListIterator listIterator;
            ListBuilder.Itr itr;
            Path path;
            Channel channel;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = FileCacheStorage.this.accessGate;
                FileCacheStorage fileCacheStorage3 = FileCacheStorage.this;
                this.L$0 = mutex;
                this.L$1 = fileCacheStorage3;
                this.I$0 = 0;
                this.label = 1;
                if (mutex.lock(this) != coroutineSingletons) {
                    fileCacheStorage = fileCacheStorage3;
                    i = 0;
                }
                return coroutineSingletons;
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i3 = this.I$1;
                i2 = this.I$0;
                fileCacheStorage2 = (FileCacheStorage) this.L$1;
                mutex2 = (Mutex) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    while (fileCacheStorage2.activeReaders > 0) {
                        channel = fileCacheStorage2.readersDrained;
                        this.L$0 = mutex2;
                        this.L$1 = fileCacheStorage2;
                        this.I$0 = i2;
                        this.I$1 = i3;
                        this.label = 2;
                        if (channel.receive(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    listIterator = ((okio.Path.Companion) fileCacheStorage2.fileSystem).list(fileCacheStorage2.directoryPath).listIterator(0);
                    while (true) {
                        itr = (ListBuilder.Itr) listIterator;
                        if (itr.hasNext()) {
                            fileCacheStorage2.mutexes.clear();
                            mutex2.unlock(null);
                            return Unit.INSTANCE;
                        }
                        path = (Path) itr.next();
                        try {
                            FileSystem.delete$default(fileCacheStorage2.fileSystem, path);
                        } catch (Exception unused) {
                            Logger logger = HttpCacheKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled(logger)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to delete cache file: ");
                                String name = path.file.getName();
                                name.getClass();
                                sb.append(name);
                                logger.trace(sb.toString());
                            }
                        }
                        mutex2.unlock(null);
                        throw th;
                    }
                } catch (Throwable th) {
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = this.I$0;
            fileCacheStorage = (FileCacheStorage) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2 = mutex;
            fileCacheStorage2 = fileCacheStorage;
            i2 = i;
            i3 = 0;
            while (fileCacheStorage2.activeReaders > 0) {
                channel = fileCacheStorage2.readersDrained;
                this.L$0 = mutex2;
                this.L$1 = fileCacheStorage2;
                this.I$0 = i2;
                this.I$1 = i3;
                this.label = 2;
                if (channel.receive(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            listIterator = ((okio.Path.Companion) fileCacheStorage2.fileSystem).list(fileCacheStorage2.directoryPath).listIterator(0);
            while (true) {
                itr = (ListBuilder.Itr) listIterator;
                if (itr.hasNext()) {
                    fileCacheStorage2.mutexes.clear();
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                path = (Path) itr.next();
                FileSystem.delete$default(fileCacheStorage2.fileSystem, path);
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$deleteCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileStorage.kt", l = {259}, m = "deleteCache", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.deleteCache(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$find$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$find$2", f = "FileStorage.kt", l = {260, 74}, m = "invokeSuspend", v = 1)
    public static final class C02432 extends SuspendLambda implements Function2 {
        final /* synthetic */ Url $url;
        final /* synthetic */ Map<String, String> $varyKeys;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02432(Url url, Map<String, String> map, Continuation continuation) {
            super(2, continuation);
            this.$url = url;
            this.$varyKeys = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02432(this.$url, this.$varyKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x009e A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0018, B:24:0x0090, B:25:0x0098, B:27:0x009e, B:30:0x00ac, B:31:0x00b4, B:33:0x00ba, B:37:0x00dc), top: B:53:0x0018 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00ac A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0018, B:24:0x0090, B:25:0x0098, B:27:0x009e, B:30:0x00ac, B:31:0x00b4, B:33:0x00ba, B:37:0x00dc), top: B:53:0x0018 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00ba A[Catch: all -> 0x001d, TryCatch #1 {all -> 0x001d, blocks: (B:7:0x0018, B:24:0x0090, B:25:0x0098, B:27:0x009e, B:30:0x00ac, B:31:0x00b4, B:33:0x00ba, B:37:0x00dc), top: B:53:0x0018 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:57:0x00db A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:59:0x00ab A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:60:0x00da A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:1: B:31:0x00b4->B:61:?, LOOP_END, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FileCacheStorage fileCacheStorage;
            Url url;
            Mutex mutex;
            FileCacheStorage fileCacheStorage2;
            Map<String, String> map;
            int i;
            FileCacheStorage fileCacheStorage3;
            CachedResponseData cachedResponseData;
            Iterator<Map.Entry<String, String>> it;
            Map.Entry<String, String> next;
            int i2 = this.label;
            Unit unit = Unit.INSTANCE;
            Object obj2 = null;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        fileCacheStorage = FileCacheStorage.this;
                        url = this.$url;
                        Map<String, String> map2 = this.$varyKeys;
                        Mutex mutex2 = fileCacheStorage.accessGate;
                        this.L$0 = fileCacheStorage;
                        this.L$1 = fileCacheStorage;
                        this.L$2 = url;
                        this.L$3 = map2;
                        this.L$4 = mutex2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (mutex2.lock(this) != coroutineSingletons) {
                            mutex = mutex2;
                            fileCacheStorage2 = fileCacheStorage;
                            map = map2;
                            i = 0;
                        }
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        map = (Map) this.L$1;
                        fileCacheStorage3 = (FileCacheStorage) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            loop0: for (Object obj3 : (Set) obj) {
                                cachedResponseData = (CachedResponseData) obj3;
                                if (map.isEmpty()) {
                                    it = map.entrySet().iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(next.getKey()), next.getValue())) {
                                            }
                                        }
                                    }
                                }
                                obj2 = obj3;
                            }
                            CachedResponseData cachedResponseData2 = (CachedResponseData) obj2;
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            return cachedResponseData2;
                        } catch (Throwable th) {
                            th = th;
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            throw th;
                        }
                    }
                    int i3 = this.I$0;
                    mutex = (Mutex) this.L$4;
                    Map<String, String> map3 = (Map) this.L$3;
                    url = (Url) this.L$2;
                    FileCacheStorage fileCacheStorage4 = (FileCacheStorage) this.L$1;
                    FileCacheStorage fileCacheStorage5 = (FileCacheStorage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i3;
                    map = map3;
                    fileCacheStorage2 = fileCacheStorage4;
                    fileCacheStorage = fileCacheStorage5;
                    String strKey = fileCacheStorage2.key(url);
                    this.L$0 = fileCacheStorage;
                    this.L$1 = map;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 2;
                    obj = fileCacheStorage2.readCache(strKey, this);
                    if (obj != coroutineSingletons) {
                        fileCacheStorage3 = fileCacheStorage;
                        loop0: while (r12.hasNext()) {
                            cachedResponseData = (CachedResponseData) obj3;
                            if (map.isEmpty()) {
                                it = map.entrySet().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        next = it.next();
                                        if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(next.getKey()), next.getValue())) {
                                        }
                                    }
                                }
                            }
                            obj2 = obj3;
                        }
                        CachedResponseData cachedResponseData3 = (CachedResponseData) obj2;
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                            fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                        }
                        return cachedResponseData3;
                    }
                    return coroutineSingletons;
                } catch (Throwable th2) {
                    th = th2;
                    fileCacheStorage3 = fileCacheStorage;
                    if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                        fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                    }
                    throw th;
                }
                FileCacheStorage.activeReaders$FU.incrementAndGet(fileCacheStorage);
                mutex.unlock(null);
            } catch (Throwable th3) {
                mutex.unlock(null);
                throw th3;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$2", f = "FileStorage.kt", l = {260, 68}, m = "invokeSuspend", v = 1)
    public static final class C02442 extends SuspendLambda implements Function2 {
        final /* synthetic */ Url $url;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02442(Url url, Continuation continuation) {
            super(2, continuation);
            this.$url = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02442(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x008c  */
        /* JADX WARN: Code duplicated, block: B:33:0x009e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FileCacheStorage fileCacheStorage;
            Url url;
            Mutex mutex;
            int i;
            FileCacheStorage fileCacheStorage2;
            FileCacheStorage fileCacheStorage3;
            int i2 = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        fileCacheStorage = FileCacheStorage.this;
                        url = this.$url;
                        Mutex mutex2 = fileCacheStorage.accessGate;
                        this.L$0 = fileCacheStorage;
                        this.L$1 = fileCacheStorage;
                        this.L$2 = url;
                        this.L$3 = mutex2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (mutex2.lock(this) != coroutineSingletons) {
                            mutex = mutex2;
                            i = 0;
                            fileCacheStorage2 = fileCacheStorage;
                        }
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        fileCacheStorage3 = (FileCacheStorage) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Set set = CollectionsKt.toSet((Iterable) obj);
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            return set;
                        } catch (Throwable th) {
                            th = th;
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            throw th;
                        }
                    }
                    i = this.I$0;
                    mutex = (Mutex) this.L$3;
                    url = (Url) this.L$2;
                    FileCacheStorage fileCacheStorage4 = (FileCacheStorage) this.L$1;
                    FileCacheStorage fileCacheStorage5 = (FileCacheStorage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    fileCacheStorage2 = fileCacheStorage4;
                    fileCacheStorage = fileCacheStorage5;
                    String strKey = fileCacheStorage2.key(url);
                    this.L$0 = fileCacheStorage;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 2;
                    obj = fileCacheStorage2.readCache(strKey, this);
                    if (obj != coroutineSingletons) {
                        fileCacheStorage3 = fileCacheStorage;
                        Set set2 = CollectionsKt.toSet((Iterable) obj);
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                            fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                        }
                        return set2;
                    }
                    return coroutineSingletons;
                } catch (Throwable th2) {
                    th = th2;
                    fileCacheStorage3 = fileCacheStorage;
                    if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                        fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                    }
                    throw th;
                }
                FileCacheStorage.activeReaders$FU.incrementAndGet(fileCacheStorage);
                mutex.unlock(null);
            } catch (Throwable th3) {
                mutex.unlock(null);
                throw th3;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileStorage.kt", l = {259, 129}, m = "readCache", v = 1)
    public static final class C02451 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02451(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCache(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileStorage.kt", l = {179}, m = "readCacheUnsafe", v = 1)
    public static final class C02461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02461(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.readCacheUnsafe(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$readCacheUnsafe$2", f = "FileStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class C02472 extends SuspendLambda implements Function2 {
        final /* synthetic */ Path $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02472(Path path, Continuation continuation) {
            super(2, continuation);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02472(this.$path, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02472) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            FileSystem fileSystem = FileCacheStorage.this.fileSystem;
            Path path = this.$path;
            ((okio.Path.Companion) fileSystem).getClass();
            path.getClass();
            FileInputStream fileInputStream = new FileInputStream(path.file);
            int i = JvmCoreKt.$r8$clinit;
            RealSource realSource = new RealSource(new InputStreamSource(fileInputStream));
            FileCacheStorage fileCacheStorage = FileCacheStorage.this;
            try {
                int i2 = realSource.readInt();
                SetBuilder setBuilder = new SetBuilder();
                for (int i3 = 0; i3 < i2; i3++) {
                    setBuilder.add(fileCacheStorage.readCache(realSource));
                }
                SetBuilder setBuilderBuild = CharsKt.build(setBuilder);
                StringsKt__IndentKt.closeFinally(realSource, null);
                return setBuilderBuild;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(realSource, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$remove$2", f = "FileStorage.kt", l = {260, 274, 277, 278}, m = "invokeSuspend", v = 1)
    public static final class C02482 extends SuspendLambda implements Function2 {
        final /* synthetic */ Url $url;
        final /* synthetic */ Map<String, String> $varyKeys;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02482(Url url, Map<String, String> map, Continuation continuation) {
            super(2, continuation);
            this.$url = url;
            this.$varyKeys = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02482(this.$url, this.$varyKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02482) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x016a  */
        /* JADX WARN: Code duplicated, block: B:43:0x0182 A[Catch: all -> 0x019d, TryCatch #3 {all -> 0x019d, blocks: (B:40:0x016f, B:41:0x017c, B:43:0x0182, B:45:0x0196, B:50:0x01a1), top: B:77:0x016f }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0196 A[Catch: all -> 0x019d, TryCatch #3 {all -> 0x019d, blocks: (B:40:0x016f, B:41:0x017c, B:43:0x0182, B:45:0x0196, B:50:0x01a1), top: B:77:0x016f }] */
        /* JADX WARN: Code duplicated, block: B:53:0x01c6  */
        /* JADX WARN: Code duplicated, block: B:57:0x01d3  */
        /* JADX WARN: Code duplicated, block: B:67:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:85:0x0199 A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r15v1, types: [io.ktor.client.plugins.cache.storage.FileCacheStorage, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r15v13 */
        /* JADX WARN: Type inference failed for: r15v14 */
        /* JADX WARN: Type inference failed for: r15v2 */
        /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r18v0 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [io.ktor.client.plugins.cache.storage.FileCacheStorage, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r15;
            FileCacheStorage fileCacheStorage;
            Url url;
            Map<String, String> map;
            Mutex mutex;
            int i;
            FileCacheStorage fileCacheStorage2;
            int i2;
            Mutex mutex2;
            int i3;
            Map<String, String> map2;
            FileCacheStorage fileCacheStorage3;
            String str;
            int i4;
            int i5;
            Object cacheUnsafe;
            Map<String, String> map3;
            ?? r14;
            Object obj2;
            ArrayList arrayList;
            Iterator it;
            ?? r2;
            Object obj3;
            Object next;
            int i6 = this.label;
            Unit unit = Unit.INSTANCE;
            int i7 = 0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    try {
                        if (i6 == 0) {
                            ResultKt.throwOnFailure(obj);
                            fileCacheStorage = FileCacheStorage.this;
                            url = this.$url;
                            map = this.$varyKeys;
                            Mutex mutex3 = fileCacheStorage.accessGate;
                            this.L$0 = fileCacheStorage;
                            this.L$1 = fileCacheStorage;
                            this.L$2 = url;
                            this.L$3 = map;
                            this.L$4 = mutex3;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.label = 1;
                            if (mutex3.lock(this) != coroutineSingletons) {
                                mutex = mutex3;
                                i = 0;
                                fileCacheStorage2 = fileCacheStorage;
                            }
                            return coroutineSingletons;
                        }
                        if (i6 != 1) {
                            if (i6 == 2) {
                                int i8 = this.I$3;
                                int i9 = this.I$2;
                                int i10 = this.I$1;
                                int i11 = this.I$0;
                                Mutex mutex4 = (Mutex) this.L$7;
                                str = (String) this.L$4;
                                fileCacheStorage3 = (FileCacheStorage) this.L$3;
                                map2 = (Map) this.L$1;
                                FileCacheStorage fileCacheStorage4 = (FileCacheStorage) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                i3 = i8;
                                mutex2 = mutex4;
                                i2 = i11;
                                i5 = i10;
                                i4 = i9;
                                r15 = fileCacheStorage4;
                                try {
                                    this.L$0 = r15;
                                    this.L$1 = map2;
                                    this.L$2 = null;
                                    this.L$3 = fileCacheStorage3;
                                    this.L$4 = str;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.L$7 = mutex2;
                                    this.I$0 = i2;
                                    this.I$1 = i5;
                                    this.I$2 = i4;
                                    this.I$3 = i3;
                                    this.I$4 = 0;
                                    this.label = 3;
                                    cacheUnsafe = fileCacheStorage3.readCacheUnsafe(str, this);
                                    if (cacheUnsafe != coroutineSingletons) {
                                        ?? r18 = r15;
                                        map3 = map2;
                                        r14 = r18;
                                        arrayList = new ArrayList();
                                        it = ((Set) cacheUnsafe).iterator();
                                        while (it.hasNext()) {
                                            next = it.next();
                                            Iterator it2 = it;
                                            if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), map3)) {
                                                arrayList.add(next);
                                            }
                                            it = it2;
                                        }
                                        this.L$0 = r14;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = mutex2;
                                        this.L$7 = null;
                                        this.I$0 = i2;
                                        this.I$1 = i5;
                                        this.I$2 = i4;
                                        this.I$3 = i3;
                                        this.I$4 = i7;
                                        this.label = 4;
                                        if (fileCacheStorage3.writeCacheUnsafe(str, arrayList, this) != coroutineSingletons) {
                                            r2 = r14;
                                            obj3 = null;
                                        }
                                    }
                                    return coroutineSingletons;
                                } catch (Throwable th) {
                                    th = th;
                                    obj2 = null;
                                    mutex2.unlock(obj2);
                                    throw th;
                                }
                            }
                            if (i6 == 3) {
                                i7 = this.I$4;
                                int i12 = this.I$3;
                                int i13 = this.I$2;
                                int i14 = this.I$1;
                                int i15 = this.I$0;
                                Mutex mutex5 = (Mutex) this.L$7;
                                String str2 = (String) this.L$4;
                                FileCacheStorage fileCacheStorage5 = (FileCacheStorage) this.L$3;
                                Map<String, String> map4 = (Map) this.L$1;
                                FileCacheStorage fileCacheStorage6 = (FileCacheStorage) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    i3 = i12;
                                    mutex2 = mutex5;
                                    i5 = i14;
                                    map3 = map4;
                                    fileCacheStorage3 = fileCacheStorage5;
                                    str = str2;
                                    i2 = i15;
                                    i4 = i13;
                                    cacheUnsafe = obj;
                                    r14 = fileCacheStorage6;
                                    try {
                                        arrayList = new ArrayList();
                                        it = ((Set) cacheUnsafe).iterator();
                                        while (it.hasNext()) {
                                            next = it.next();
                                            Iterator it3 = it;
                                            if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), map3)) {
                                                arrayList.add(next);
                                            }
                                            it = it3;
                                        }
                                        this.L$0 = r14;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = mutex2;
                                        this.L$7 = null;
                                        this.I$0 = i2;
                                        this.I$1 = i5;
                                        this.I$2 = i4;
                                        this.I$3 = i3;
                                        this.I$4 = i7;
                                        this.label = 4;
                                        if (fileCacheStorage3.writeCacheUnsafe(str, arrayList, this) != coroutineSingletons) {
                                            r2 = r14;
                                            obj3 = null;
                                        }
                                        return coroutineSingletons;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj2 = null;
                                        mutex2.unlock(obj2);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = null;
                                    mutex2 = mutex5;
                                }
                            } else {
                                if (i6 != 4) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                mutex2 = (Mutex) this.L$6;
                                FileCacheStorage fileCacheStorage7 = (FileCacheStorage) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    obj3 = null;
                                    r2 = fileCacheStorage7;
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj2 = null;
                                }
                            }
                            mutex2.unlock(obj2);
                            throw th;
                        }
                        i = this.I$0;
                        mutex = (Mutex) this.L$4;
                        map = (Map) this.L$3;
                        url = (Url) this.L$2;
                        fileCacheStorage = (FileCacheStorage) this.L$1;
                        FileCacheStorage fileCacheStorage8 = (FileCacheStorage) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        fileCacheStorage2 = fileCacheStorage8;
                        mutex2.unlock(obj3);
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(r2) == 0) {
                            ((FileCacheStorage) r2).readersDrained.mo1712trySendJP2dKIU(unit);
                        }
                        return unit;
                        FileCacheStorage.activeReaders$FU.incrementAndGet(fileCacheStorage2);
                        mutex.unlock(null);
                        String strKey = fileCacheStorage.key(url);
                        Mutex mutex6 = (Mutex) fileCacheStorage.mutexes.computeIfAbsent(strKey, FileCacheStorage$updateCache$mutex$1.INSTANCE);
                        this.L$0 = fileCacheStorage2;
                        this.L$1 = map;
                        this.L$2 = null;
                        this.L$3 = fileCacheStorage;
                        this.L$4 = strKey;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = mutex6;
                        this.I$0 = i;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.I$3 = 0;
                        this.label = 2;
                        if (mutex6.lock(this) != coroutineSingletons) {
                            i2 = i;
                            mutex2 = mutex6;
                            i3 = 0;
                            map2 = map;
                            fileCacheStorage3 = fileCacheStorage;
                            str = strKey;
                            i4 = 0;
                            i5 = 0;
                            r15 = fileCacheStorage2;
                            this.L$0 = r15;
                            this.L$1 = map2;
                            this.L$2 = null;
                            this.L$3 = fileCacheStorage3;
                            this.L$4 = str;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = mutex2;
                            this.I$0 = i2;
                            this.I$1 = i5;
                            this.I$2 = i4;
                            this.I$3 = i3;
                            this.I$4 = 0;
                            this.label = 3;
                            cacheUnsafe = fileCacheStorage3.readCacheUnsafe(str, this);
                            if (cacheUnsafe != coroutineSingletons) {
                                ?? r19 = r15;
                                map3 = map2;
                                r14 = r19;
                                arrayList = new ArrayList();
                                it = ((Set) cacheUnsafe).iterator();
                                while (it.hasNext()) {
                                    next = it.next();
                                    Iterator it4 = it;
                                    if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), map3)) {
                                        arrayList.add(next);
                                    }
                                    it = it4;
                                }
                                this.L$0 = r14;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = mutex2;
                                this.L$7 = null;
                                this.I$0 = i2;
                                this.I$1 = i5;
                                this.I$2 = i4;
                                this.I$3 = i3;
                                this.I$4 = i7;
                                this.label = 4;
                                if (fileCacheStorage3.writeCacheUnsafe(str, arrayList, this) != coroutineSingletons) {
                                    r2 = r14;
                                    obj3 = null;
                                    mutex2.unlock(obj3);
                                    if (FileCacheStorage.activeReaders$FU.decrementAndGet(r2) == 0) {
                                        ((FileCacheStorage) r2).readersDrained.mo1712trySendJP2dKIU(unit);
                                    }
                                    return unit;
                                }
                            }
                        }
                        return coroutineSingletons;
                    } catch (Throwable th5) {
                        mutex.unlock(null);
                        throw th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r15 = 4;
                    if (FileCacheStorage.activeReaders$FU.decrementAndGet(r15) == 0) {
                        ((FileCacheStorage) r15).readersDrained.mo1712trySendJP2dKIU(unit);
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                if (FileCacheStorage.activeReaders$FU.decrementAndGet(r15) == 0) {
                    ((FileCacheStorage) r15).readersDrained.mo1712trySendJP2dKIU(unit);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$removeAll$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$removeAll$2", f = "FileStorage.kt", l = {260, 93}, m = "invokeSuspend", v = 1)
    public static final class C02492 extends SuspendLambda implements Function2 {
        final /* synthetic */ Url $url;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02492(Url url, Continuation continuation) {
            super(2, continuation);
            this.$url = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02492(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02492) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x008a  */
        /* JADX WARN: Code duplicated, block: B:32:0x009c  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FileCacheStorage fileCacheStorage;
            Url url;
            Mutex mutex;
            int i;
            FileCacheStorage fileCacheStorage2;
            FileCacheStorage fileCacheStorage3;
            int i2 = this.label;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        fileCacheStorage = FileCacheStorage.this;
                        url = this.$url;
                        Mutex mutex2 = fileCacheStorage.accessGate;
                        this.L$0 = fileCacheStorage;
                        this.L$1 = fileCacheStorage;
                        this.L$2 = url;
                        this.L$3 = mutex2;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (mutex2.lock(this) != coroutineSingletons) {
                            mutex = mutex2;
                            i = 0;
                            fileCacheStorage2 = fileCacheStorage;
                        }
                        return coroutineSingletons;
                    }
                    if (i2 != 1) {
                        if (i2 != 2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        fileCacheStorage3 = (FileCacheStorage) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            return unit;
                        } catch (Throwable th) {
                            th = th;
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                                fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            throw th;
                        }
                    }
                    i = this.I$0;
                    mutex = (Mutex) this.L$3;
                    url = (Url) this.L$2;
                    FileCacheStorage fileCacheStorage4 = (FileCacheStorage) this.L$1;
                    FileCacheStorage fileCacheStorage5 = (FileCacheStorage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    fileCacheStorage2 = fileCacheStorage4;
                    fileCacheStorage = fileCacheStorage5;
                    String strKey = fileCacheStorage2.key(url);
                    this.L$0 = fileCacheStorage;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 2;
                    if (fileCacheStorage2.deleteCache(strKey, this) != coroutineSingletons) {
                        fileCacheStorage3 = fileCacheStorage;
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                            fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                        }
                        return unit;
                    }
                    return coroutineSingletons;
                } catch (Throwable th2) {
                    th = th2;
                    fileCacheStorage3 = fileCacheStorage;
                    if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage3) == 0) {
                        fileCacheStorage3.readersDrained.mo1712trySendJP2dKIU(unit);
                    }
                    throw th;
                }
                FileCacheStorage.activeReaders$FU.incrementAndGet(fileCacheStorage);
                mutex.unlock(null);
            } catch (Throwable th3) {
                mutex.unlock(null);
                throw th3;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileStorage.kt", l = {260, 274, 277, 278}, m = "invokeSuspend", v = 1)
    public static final class C02502 extends SuspendLambda implements Function2 {
        final /* synthetic */ CachedResponseData $data;
        final /* synthetic */ Url $url;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02502(Url url, CachedResponseData cachedResponseData, Continuation continuation) {
            super(2, continuation);
            this.$url = url;
            this.$data = cachedResponseData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02502(this.$url, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02502) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x01a5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:0x0170  */
        /* JADX WARN: Code duplicated, block: B:47:0x01a2 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #8 {all -> 0x01ab, blocks: (B:45:0x0198, B:47:0x01a2), top: B:102:0x0198 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:62:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:64:0x01f7  */
        /* JADX WARN: Code duplicated, block: B:82:0x0219  */
        /* JADX WARN: Code duplicated, block: B:89:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Unit unit;
            FileCacheStorage fileCacheStorage;
            FileCacheStorage fileCacheStorage2;
            Url url;
            CachedResponseData cachedResponseData;
            Mutex mutex;
            int i;
            int i2;
            Mutex mutex2;
            int i3;
            CachedResponseData cachedResponseData2;
            FileCacheStorage fileCacheStorage3;
            String str;
            int i4;
            int i5;
            FileCacheStorage fileCacheStorage4;
            Object cacheUnsafe;
            CachedResponseData cachedResponseData3;
            FileCacheStorage fileCacheStorage5;
            Object obj2;
            ArrayList arrayList;
            Iterator it;
            Unit unit2;
            ArrayList arrayListPlus;
            Object obj3;
            Unit unit3;
            Object next;
            int i6 = this.label;
            Unit unit4 = Unit.INSTANCE;
            int i7 = 0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj);
                        fileCacheStorage2 = FileCacheStorage.this;
                        url = this.$url;
                        cachedResponseData = this.$data;
                        Mutex mutex3 = fileCacheStorage2.accessGate;
                        this.L$0 = fileCacheStorage2;
                        this.L$1 = fileCacheStorage2;
                        this.L$2 = url;
                        this.L$3 = cachedResponseData;
                        this.L$4 = mutex3;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (mutex3.lock(this) != coroutineSingletons) {
                            mutex = mutex3;
                            i = 0;
                            fileCacheStorage = fileCacheStorage2;
                        }
                        return coroutineSingletons;
                    }
                    if (i6 != 1) {
                        if (i6 == 2) {
                            int i8 = this.I$3;
                            int i9 = this.I$2;
                            int i10 = this.I$1;
                            int i11 = this.I$0;
                            Mutex mutex4 = (Mutex) this.L$7;
                            str = (String) this.L$4;
                            fileCacheStorage3 = (FileCacheStorage) this.L$3;
                            cachedResponseData2 = (CachedResponseData) this.L$1;
                            fileCacheStorage = (FileCacheStorage) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            i3 = i8;
                            mutex2 = mutex4;
                            i2 = i11;
                            i5 = i10;
                            i4 = i9;
                            try {
                                this.L$0 = fileCacheStorage;
                                this.L$1 = cachedResponseData2;
                                this.L$2 = null;
                                this.L$3 = fileCacheStorage3;
                                this.L$4 = str;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = mutex2;
                                this.I$0 = i2;
                                this.I$1 = i5;
                                this.I$2 = i4;
                                this.I$3 = i3;
                                this.I$4 = 0;
                                this.label = 3;
                                cacheUnsafe = fileCacheStorage3.readCacheUnsafe(str, this);
                                if (cacheUnsafe != coroutineSingletons) {
                                    FileCacheStorage fileCacheStorage6 = fileCacheStorage;
                                    cachedResponseData3 = cachedResponseData2;
                                    fileCacheStorage5 = fileCacheStorage6;
                                    arrayList = new ArrayList();
                                    it = ((Set) cacheUnsafe).iterator();
                                    while (it.hasNext()) {
                                        next = it.next();
                                        Iterator it2 = it;
                                        unit3 = unit4;
                                        if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), cachedResponseData3.getVaryKeys())) {
                                            arrayList.add(next);
                                        }
                                        it = it2;
                                        unit4 = unit3;
                                    }
                                    unit2 = unit4;
                                    arrayListPlus = CollectionsKt.plus(cachedResponseData3, arrayList);
                                    this.L$0 = fileCacheStorage5;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = mutex2;
                                    this.L$7 = null;
                                    this.I$0 = i2;
                                    this.I$1 = i5;
                                    this.I$2 = i4;
                                    this.I$3 = i3;
                                    this.I$4 = i7;
                                    this.label = 4;
                                    if (fileCacheStorage3.writeCacheUnsafe(str, arrayListPlus, this) != coroutineSingletons) {
                                        fileCacheStorage4 = fileCacheStorage5;
                                        obj3 = null;
                                    }
                                }
                                return coroutineSingletons;
                            } catch (Throwable th) {
                                th = th;
                                unit = unit4;
                                fileCacheStorage4 = fileCacheStorage;
                                obj2 = null;
                                mutex2.unlock(obj2);
                                throw th;
                            }
                        }
                        if (i6 == 3) {
                            i7 = this.I$4;
                            int i12 = this.I$3;
                            int i13 = this.I$2;
                            int i14 = this.I$1;
                            int i15 = this.I$0;
                            Mutex mutex5 = (Mutex) this.L$7;
                            String str2 = (String) this.L$4;
                            FileCacheStorage fileCacheStorage7 = (FileCacheStorage) this.L$3;
                            CachedResponseData cachedResponseData4 = (CachedResponseData) this.L$1;
                            fileCacheStorage5 = (FileCacheStorage) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                i3 = i12;
                                mutex2 = mutex5;
                                i5 = i14;
                                cachedResponseData3 = cachedResponseData4;
                                fileCacheStorage3 = fileCacheStorage7;
                                str = str2;
                                i2 = i15;
                                i4 = i13;
                                cacheUnsafe = obj;
                                try {
                                    arrayList = new ArrayList();
                                    it = ((Set) cacheUnsafe).iterator();
                                    while (it.hasNext()) {
                                        try {
                                            next = it.next();
                                            Iterator it3 = it;
                                            unit3 = unit4;
                                            try {
                                                if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), cachedResponseData3.getVaryKeys())) {
                                                    arrayList.add(next);
                                                }
                                                it = it3;
                                                unit4 = unit3;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileCacheStorage4 = fileCacheStorage5;
                                                unit = unit3;
                                                obj2 = null;
                                                mutex2.unlock(obj2);
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            unit3 = unit4;
                                        }
                                    }
                                    unit2 = unit4;
                                    try {
                                        arrayListPlus = CollectionsKt.plus(cachedResponseData3, arrayList);
                                        this.L$0 = fileCacheStorage5;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = mutex2;
                                        this.L$7 = null;
                                        this.I$0 = i2;
                                        this.I$1 = i5;
                                        this.I$2 = i4;
                                        this.I$3 = i3;
                                        this.I$4 = i7;
                                        this.label = 4;
                                        if (fileCacheStorage3.writeCacheUnsafe(str, arrayListPlus, this) != coroutineSingletons) {
                                            fileCacheStorage4 = fileCacheStorage5;
                                            obj3 = null;
                                        }
                                        return coroutineSingletons;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        unit = unit2;
                                        fileCacheStorage4 = fileCacheStorage5;
                                        obj2 = null;
                                        mutex2.unlock(obj2);
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    unit = unit4;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                unit = unit4;
                                obj2 = null;
                                mutex2 = mutex5;
                                fileCacheStorage4 = fileCacheStorage5;
                                mutex2.unlock(obj2);
                                throw th;
                            }
                        } else {
                            if (i6 != 4) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            mutex2 = (Mutex) this.L$6;
                            fileCacheStorage4 = (FileCacheStorage) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                unit2 = unit4;
                                obj3 = null;
                            } catch (Throwable th7) {
                                th = th7;
                                unit = unit4;
                                obj2 = null;
                                mutex2.unlock(obj2);
                                throw th;
                            }
                        }
                        try {
                            mutex2.unlock(obj2);
                            throw th;
                        } catch (Throwable th8) {
                            th = th8;
                            fileCacheStorage = fileCacheStorage4;
                            if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage) == 0) {
                                fileCacheStorage.readersDrained.mo1712trySendJP2dKIU(unit);
                            }
                            throw th;
                        }
                    }
                    i = this.I$0;
                    mutex = (Mutex) this.L$4;
                    cachedResponseData = (CachedResponseData) this.L$3;
                    url = (Url) this.L$2;
                    fileCacheStorage2 = (FileCacheStorage) this.L$1;
                    FileCacheStorage fileCacheStorage8 = (FileCacheStorage) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    fileCacheStorage = fileCacheStorage8;
                    try {
                        mutex2.unlock(obj3);
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage4) == 0) {
                            return unit2;
                        }
                        Unit unit5 = unit2;
                        fileCacheStorage4.readersDrained.mo1712trySendJP2dKIU(unit5);
                        return unit5;
                    } catch (Throwable th9) {
                        th = th9;
                        unit = unit2;
                        fileCacheStorage = fileCacheStorage4;
                        if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage) == 0) {
                            fileCacheStorage.readersDrained.mo1712trySendJP2dKIU(unit);
                        }
                        throw th;
                    }
                    FileCacheStorage.activeReaders$FU.incrementAndGet(fileCacheStorage);
                    mutex.unlock(null);
                    String strKey = fileCacheStorage2.key(url);
                    Mutex mutex6 = (Mutex) fileCacheStorage2.mutexes.computeIfAbsent(strKey, FileCacheStorage$updateCache$mutex$1.INSTANCE);
                    this.L$0 = fileCacheStorage;
                    this.L$1 = cachedResponseData;
                    this.L$2 = null;
                    this.L$3 = fileCacheStorage2;
                    this.L$4 = strKey;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.L$7 = mutex6;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.I$2 = 0;
                    this.I$3 = 0;
                    this.label = 2;
                    if (mutex6.lock(this) != coroutineSingletons) {
                        i2 = i;
                        mutex2 = mutex6;
                        i3 = 0;
                        cachedResponseData2 = cachedResponseData;
                        fileCacheStorage3 = fileCacheStorage2;
                        str = strKey;
                        i4 = 0;
                        i5 = 0;
                        this.L$0 = fileCacheStorage;
                        this.L$1 = cachedResponseData2;
                        this.L$2 = null;
                        this.L$3 = fileCacheStorage3;
                        this.L$4 = str;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = mutex2;
                        this.I$0 = i2;
                        this.I$1 = i5;
                        this.I$2 = i4;
                        this.I$3 = i3;
                        this.I$4 = 0;
                        this.label = 3;
                        cacheUnsafe = fileCacheStorage3.readCacheUnsafe(str, this);
                        if (cacheUnsafe != coroutineSingletons) {
                            FileCacheStorage fileCacheStorage9 = fileCacheStorage;
                            cachedResponseData3 = cachedResponseData2;
                            fileCacheStorage5 = fileCacheStorage9;
                            arrayList = new ArrayList();
                            it = ((Set) cacheUnsafe).iterator();
                            while (it.hasNext()) {
                                next = it.next();
                                Iterator it4 = it;
                                unit3 = unit4;
                                if (!Intrinsics.areEqual(((CachedResponseData) next).getVaryKeys(), cachedResponseData3.getVaryKeys())) {
                                    arrayList.add(next);
                                }
                                it = it4;
                                unit4 = unit3;
                            }
                            unit2 = unit4;
                            arrayListPlus = CollectionsKt.plus(cachedResponseData3, arrayList);
                            this.L$0 = fileCacheStorage5;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = mutex2;
                            this.L$7 = null;
                            this.I$0 = i2;
                            this.I$1 = i5;
                            this.I$2 = i4;
                            this.I$3 = i3;
                            this.I$4 = i7;
                            this.label = 4;
                            if (fileCacheStorage3.writeCacheUnsafe(str, arrayListPlus, this) != coroutineSingletons) {
                                fileCacheStorage4 = fileCacheStorage5;
                                obj3 = null;
                                mutex2.unlock(obj3);
                                if (FileCacheStorage.activeReaders$FU.decrementAndGet(fileCacheStorage4) == 0) {
                                    return unit2;
                                }
                                Unit unit6 = unit2;
                                fileCacheStorage4.readersDrained.mo1712trySendJP2dKIU(unit6);
                                return unit6;
                            }
                        }
                    }
                    return coroutineSingletons;
                } catch (Throwable th10) {
                    mutex.unlock(null);
                    throw th10;
                }
            } catch (Throwable th11) {
                th = th11;
                unit = unit4;
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage", f = "FileStorage.kt", l = {159}, m = "writeCacheUnsafe", v = 1)
    public static final class C02511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C02511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileCacheStorage.this.writeCacheUnsafe(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCacheUnsafe$2", f = "FileStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    public static final class C02522 extends SuspendLambda implements Function2 {
        final /* synthetic */ List<CachedResponseData> $caches;
        final /* synthetic */ String $urlHex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02522(String str, List<CachedResponseData> list, Continuation continuation) {
            super(2, continuation);
            this.$urlHex = str;
            this.$caches = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FileCacheStorage.this.new C02522(this.$urlHex, this.$caches, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            if (this.label != 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Path Path = CollectionsKt__IterablesKt.Path(FileCacheStorage.this.directoryPath, this.$urlHex);
            ((okio.Path.Companion) FileCacheStorage.this.fileSystem).getClass();
            FileOutputStream fileOutputStream = new FileOutputStream(Path.file, false);
            int i = JvmCoreKt.$r8$clinit;
            RealSink realSink = new RealSink(new OutputStreamSink(fileOutputStream));
            List<CachedResponseData> list = this.$caches;
            FileCacheStorage fileCacheStorage = FileCacheStorage.this;
            try {
                realSink.writeInt(list.size());
                Iterator<CachedResponseData> it = list.iterator();
                while (it.hasNext()) {
                    fileCacheStorage.writeCache(realSink, it.next());
                }
                StringsKt__IndentKt.closeFinally(realSink, null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    StringsKt__IndentKt.closeFinally(realSink, th);
                    throw th2;
                }
            }
        }
    }

    public FileCacheStorage(Path path, FileSystem fileSystem, CoroutineDispatcher coroutineDispatcher) throws IOException {
        path.getClass();
        fileSystem.getClass();
        coroutineDispatcher.getClass();
        this.directoryPath = path;
        this.fileSystem = fileSystem;
        this.dispatcher = coroutineDispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, null);
        this.accessGate = new MutexImpl();
        this.activeReaders = 0;
        this.readersDrained = EntryPoints.Channel$default(-1, 6, null);
        File file = path.file;
        if (file.mkdirs() || !file.isFile()) {
            return;
        }
        Path$$ExternalSyntheticBUOutline0.m(path, "Path already exists and it's a file: ");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object deleteCache(String str, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Mutex mutexComputeIfAbsent;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        byte b = 1;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexComputeIfAbsent = this.mutexes.computeIfAbsent(str, new FileCacheStorage$$ExternalSyntheticLambda0(b));
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = null;
            anonymousClass1.L$2 = mutexComputeIfAbsent;
            anonymousClass1.I$0 = 0;
            anonymousClass1.label = 1;
            Object objLock = mutexComputeIfAbsent.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Mutex mutex = (Mutex) anonymousClass1.L$2;
            String str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutexComputeIfAbsent = mutex;
            str = str2;
        }
        try {
            Path Path = CollectionsKt__IterablesKt.Path(this.directoryPath, str);
            ((okio.Path.Companion) this.fileSystem).getClass();
            if (Path.file.exists()) {
                try {
                    FileSystem.delete$default(this.fileSystem, Path);
                } catch (Exception e) {
                    Logger logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Exception during cache deletion in a file: ".concat(ResultKt.stackTraceToString(e)));
                    }
                }
            }
            mutexComputeIfAbsent.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutexComputeIfAbsent.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex deleteCache$lambda$0() {
        return new MutexImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        return HexExtensionsKt.toHexString$default(CryptoKt.sha256(StringsKt__StringsJVMKt.encodeToByteArray(url.getUrlString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CachedResponseData readCache(Source source) throws EOFException {
        String lineStrict$default = Utf8Kt.readLineStrict$default(source);
        HttpStatusCode httpStatusCode = new HttpStatusCode(source.readInt(), Utf8Kt.readLineStrict$default(source));
        HttpProtocolVersion httpProtocolVersion = HttpProtocolVersion.INSTANCE.parse(Utf8Kt.readLineStrict$default(source));
        int i = source.readInt();
        int i2 = 0;
        HeadersBuilder headersBuilder = new HeadersBuilder(i2, 1, null);
        for (int i3 = 0; i3 < i; i3++) {
            headersBuilder.append(Utf8Kt.readLineStrict$default(source), Utf8Kt.readLineStrict$default(source));
        }
        GMTDate GMTDate = DateJvmKt.GMTDate(Long.valueOf(source.readLong()));
        GMTDate GMTDate2 = DateJvmKt.GMTDate(Long.valueOf(source.readLong()));
        GMTDate GMTDate3 = DateJvmKt.GMTDate(Long.valueOf(source.readLong()));
        int i4 = source.readInt();
        MapBuilder mapBuilder = new MapBuilder();
        while (i2 < i4) {
            String lowerCase = Utf8Kt.readLineStrict$default(source).toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            mapBuilder.put(lowerCase, Utf8Kt.readLineStrict$default(source));
            i2++;
        }
        MapBuilder mapBuilderBuild = mapBuilder.build();
        byte[] bArr = new byte[source.readInt()];
        ByteReadPacketKt.readFully$default(source, bArr, 0, 0, 6, null);
        return new CachedResponseData(URLUtilsKt.Url(lineStrict$default), httpStatusCode, GMTDate, GMTDate2, httpProtocolVersion, GMTDate3, headersBuilder.build(), mapBuilderBuild, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mutex readCache$lambda$0() {
        return new MutexImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readCacheUnsafe(String str, Continuation continuation) {
        C02461 c02461;
        if (continuation instanceof C02461) {
            c02461 = (C02461) continuation;
            int i = c02461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02461.label = i - Integer.MIN_VALUE;
            } else {
                c02461 = new C02461(continuation);
            }
        } else {
            c02461 = new C02461(continuation);
        }
        Object objWithContext = c02461.result;
        int i2 = c02461.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                Path Path = CollectionsKt__IterablesKt.Path(this.directoryPath, str);
                ((okio.Path.Companion) this.fileSystem).getClass();
                if (Path.file.exists()) {
                    CoroutineDispatcher coroutineDispatcher = this.dispatcher;
                    C02472 c02472 = new C02472(Path, null);
                    c02461.L$0 = null;
                    c02461.L$1 = null;
                    c02461.label = 1;
                    objWithContext = AwaitKt.withContext(coroutineDispatcher, c02472, c02461);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return EmptySet.INSTANCE;
            }
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
            return (Set) objWithContext;
        } catch (Exception e) {
            Logger logger = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Exception during cache lookup in a file: ".concat(ResultKt.stackTraceToString(e)));
            }
        }
    }

    private final Object updateCache(String str, Function1 function1, Continuation continuation) {
        Mutex mutex = (Mutex) this.mutexes.computeIfAbsent(str, FileCacheStorage$updateCache$mutex$1.INSTANCE);
        mutex.lock(continuation);
        try {
            writeCacheUnsafe(str, (List) function1.invoke((Set) readCacheUnsafe(str, null)), null);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    private final <T> Object withReadAccess(Function0 function0, Continuation continuation) {
        Unit unit = Unit.INSTANCE;
        Mutex mutex = this.accessGate;
        mutex.lock(continuation);
        try {
            activeReaders$FU.incrementAndGet(this);
            mutex.unlock(null);
            try {
                return function0.invoke();
            } finally {
                if (activeReaders$FU.decrementAndGet(this) == 0) {
                    this.readersDrained.mo1712trySendJP2dKIU(unit);
                }
            }
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeCache(Sink sink, CachedResponseData cache) {
        StringBuilder sb = new StringBuilder();
        sb.append(cache.getUrl());
        sb.append('\n');
        String string = sb.toString();
        Utf8Kt.writeString(sink, string, 0, string.length());
        sink.writeInt(cache.getStatusCode().getValue());
        String str = cache.getStatusCode().getDescription() + '\n';
        Utf8Kt.writeString(sink, str, 0, str.length());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cache.getVersion());
        sb2.append('\n');
        String string2 = sb2.toString();
        Utf8Kt.writeString(sink, string2, 0, string2.length());
        List<Pair> listFlattenEntries = StringValuesKt.flattenEntries(cache.getHeaders());
        sink.writeInt(listFlattenEntries.size());
        for (Pair pair : listFlattenEntries) {
            String str2 = (String) pair.first;
            String str3 = (String) pair.second;
            String str4 = str2 + '\n';
            Utf8Kt.writeString(sink, str4, 0, str4.length());
            String str5 = str3 + '\n';
            Utf8Kt.writeString(sink, str5, 0, str5.length());
        }
        sink.writeLong(cache.getRequestTime().getTimestamp());
        sink.writeLong(cache.getResponseTime().getTimestamp());
        sink.writeLong(cache.getExpires().getTimestamp());
        sink.writeInt(cache.getVaryKeys().size());
        for (Map.Entry<String, String> entry : cache.getVaryKeys().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String str6 = key + '\n';
            Utf8Kt.writeString(sink, str6, 0, str6.length());
            String str7 = value + '\n';
            Utf8Kt.writeString(sink, str7, 0, str7.length());
        }
        sink.writeInt(cache.getBody().length);
        BytePacketBuilderKt.writeFully$default(sink, cache.getBody(), 0, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object writeCacheUnsafe(String str, List<CachedResponseData> list, Continuation continuation) {
        C02511 c02511;
        if (continuation instanceof C02511) {
            c02511 = (C02511) continuation;
            int i = c02511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02511.label = i - Integer.MIN_VALUE;
            } else {
                c02511 = new C02511(continuation);
            }
        } else {
            c02511 = new C02511(continuation);
        }
        Object obj = c02511.result;
        int i2 = c02511.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcher = this.dispatcher;
                C02522 c02522 = new C02522(str, list, null);
                c02511.L$0 = null;
                c02511.L$1 = null;
                c02511.label = 1;
                Object objWithContext = AwaitKt.withContext(coroutineDispatcher, c02522, c02511);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objWithContext == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                AwaitKt.ensureActive(c02511.getContext());
            }
            Logger logger = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Exception during saving a cache to a file: ".concat(ResultKt.stackTraceToString(e)));
            }
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object clear(Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(this.dispatcher, new AnonymousClass2(null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation continuation) {
        return AwaitKt.withContext(this.dispatcher, new C02432(url, map, null), continuation);
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation continuation) {
        return AwaitKt.withContext(this.dispatcher, new C02442(url, null), continuation);
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, Map<String, String> map, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(this.dispatcher, new C02482(url, map, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(this.dispatcher, new C02492(url, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation continuation) {
        Object objWithContext = AwaitKt.withContext(this.dispatcher, new C02502(url, cachedResponseData, null), continuation);
        return objWithContext == CoroutineSingletons.COROUTINE_SUSPENDED ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object readCache(String str, Continuation continuation) throws Throwable {
        C02451 c02451;
        Mutex mutexComputeIfAbsent;
        int i;
        Mutex mutex;
        if (continuation instanceof C02451) {
            c02451 = (C02451) continuation;
            int i2 = c02451.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c02451.label = i2 - Integer.MIN_VALUE;
            } else {
                c02451 = new C02451(continuation);
            }
        } else {
            c02451 = new C02451(continuation);
        }
        Object obj = c02451.result;
        int i3 = c02451.label;
        byte b = 0;
        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutexComputeIfAbsent = this.mutexes.computeIfAbsent(str, new FileCacheStorage$$ExternalSyntheticLambda0(b));
                c02451.L$0 = str;
                c02451.L$1 = null;
                c02451.L$2 = mutexComputeIfAbsent;
                c02451.I$0 = 0;
                c02451.label = 1;
                if (mutexComputeIfAbsent.lock(c02451) != obj2) {
                    i = 0;
                }
                return obj2;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex = (Mutex) c02451.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    Set set = (Set) obj;
                    mutex.unlock(null);
                    return set;
                } catch (Throwable th) {
                    th = th;
                    mutex.unlock(null);
                    throw th;
                }
            }
            int i4 = c02451.I$0;
            Mutex mutex2 = (Mutex) c02451.L$2;
            String str2 = (String) c02451.L$0;
            ResultKt.throwOnFailure(obj);
            mutexComputeIfAbsent = mutex2;
            i = i4;
            str = str2;
            c02451.L$0 = null;
            c02451.L$1 = null;
            c02451.L$2 = mutexComputeIfAbsent;
            c02451.I$0 = i;
            c02451.I$1 = 0;
            c02451.label = 2;
            Object cacheUnsafe = readCacheUnsafe(str, c02451);
            if (cacheUnsafe != obj2) {
                Mutex mutex3 = mutexComputeIfAbsent;
                obj = cacheUnsafe;
                mutex = mutex3;
                Set set2 = (Set) obj;
                mutex.unlock(null);
                return set2;
            }
            return obj2;
        } catch (Throwable th2) {
            th = th2;
            mutex = mutexComputeIfAbsent;
            mutex.unlock(null);
            throw th;
        }
    }
}
