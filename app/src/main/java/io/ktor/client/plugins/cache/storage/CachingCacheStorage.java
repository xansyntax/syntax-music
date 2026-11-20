package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0010J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0018R&\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "<init>", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$clear$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {49}, m = "clear", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.clear(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {23}, m = "find", v = 1)
    public static final class C02381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02381(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.find(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {33}, m = "findAll", v = 1)
    public static final class C02391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02391(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.findAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$remove$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {39, 40}, m = "remove", v = 1)
    public static final class C02401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02401(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.remove(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$removeAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {44}, m = "removeAll", v = 1)
    public static final class C02411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02411(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.removeAll(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "CachingCacheStorage.kt", l = {17, 18}, m = "store", v = 1)
    public static final class C02421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C02421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CachingCacheStorage.this.store(null, null, this);
        }
    }

    public CachingCacheStorage(CacheStorage cacheStorage) {
        cacheStorage.getClass();
        this.delegate = cacheStorage;
        this.store = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object clear(Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            anonymousClass1.label = 1;
            Object objClear = cacheStorage.clear(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objClear == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.store.clear();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0089  */
    /* JADX WARN: Code duplicated, block: B:30:0x0097  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:? A[LOOP:0: B:22:0x0075->B:38:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[LOOP:1: B:28:0x0091->B:39:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation continuation) {
        C02381 c02381;
        Map<String, String> map2;
        Map map3;
        Url url2;
        CachedResponseData cachedResponseData;
        String key;
        if (continuation instanceof C02381) {
            c02381 = (C02381) continuation;
            int i = c02381.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02381.label = i - Integer.MIN_VALUE;
            } else {
                c02381 = new C02381(continuation);
            }
        } else {
            c02381 = new C02381(continuation);
        }
        Object obj = c02381.result;
        int i2 = c02381.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.store.containsKey(url)) {
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                CacheStorage cacheStorage = this.delegate;
                c02381.L$0 = url;
                c02381.L$1 = map;
                c02381.L$2 = concurrentMap;
                c02381.L$3 = url;
                c02381.label = 1;
                Object objFindAll = cacheStorage.findAll(url, c02381);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFindAll == coroutineSingletons) {
                    return coroutineSingletons;
                }
                map2 = map;
                map3 = concurrentMap;
                obj = objFindAll;
                url2 = url;
            }
            for (Object obj2 : (Set) MapsKt__MapsKt.getValue(this.store, url)) {
                cachedResponseData = (CachedResponseData) obj2;
                if (map.isEmpty()) {
                    return obj2;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    key = entry.getKey();
                    if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(key), entry.getValue())) {
                    }
                }
                return obj2;
            }
            return null;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        url = (Url) c02381.L$3;
        map3 = (Map) c02381.L$2;
        map2 = (Map) c02381.L$1;
        url2 = (Url) c02381.L$0;
        ResultKt.throwOnFailure(obj);
        map3.put(url, obj);
        url = url2;
        map = map2;
        while (r5.hasNext()) {
            cachedResponseData = (CachedResponseData) obj2;
            if (map.isEmpty()) {
                return obj2;
            }
            while (r0.hasNext()) {
                key = entry.getKey();
                if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(key), entry.getValue())) {
                }
            }
            return obj2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation continuation) {
        C02391 c02391;
        Map map;
        Url url2;
        if (continuation instanceof C02391) {
            c02391 = (C02391) continuation;
            int i = c02391.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02391.label = i - Integer.MIN_VALUE;
            } else {
                c02391 = new C02391(continuation);
            }
        } else {
            c02391 = new C02391(continuation);
        }
        Object objFindAll = c02391.result;
        int i2 = c02391.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFindAll);
            if (!this.store.containsKey(url)) {
                map = this.store;
                CacheStorage cacheStorage = this.delegate;
                c02391.L$0 = url;
                c02391.L$1 = map;
                c02391.L$2 = url;
                c02391.label = 1;
                objFindAll = cacheStorage.findAll(url, c02391);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objFindAll == coroutineSingletons) {
                    return coroutineSingletons;
                }
                url2 = url;
            }
            return MapsKt__MapsKt.getValue(this.store, url);
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        url = (Url) c02391.L$2;
        map = (Map) c02391.L$1;
        url2 = (Url) c02391.L$0;
        ResultKt.throwOnFailure(objFindAll);
        map.put(url, objFindAll);
        url = url2;
        return MapsKt__MapsKt.getValue(this.store, url);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, Map<String, String> map, Continuation continuation) {
        C02401 c02401;
        Url url2;
        Map map2;
        if (continuation instanceof C02401) {
            c02401 = (C02401) continuation;
            int i = c02401.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02401.label = i - Integer.MIN_VALUE;
            } else {
                c02401 = new C02401(continuation);
            }
        } else {
            c02401 = new C02401(continuation);
        }
        Object objFindAll = c02401.result;
        int i2 = c02401.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFindAll);
            CacheStorage cacheStorage = this.delegate;
            c02401.L$0 = url;
            c02401.L$1 = null;
            c02401.label = 1;
            if (cacheStorage.remove(url, map, c02401) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            url = (Url) c02401.L$0;
            ResultKt.throwOnFailure(objFindAll);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            url2 = (Url) c02401.L$3;
            map2 = (Map) c02401.L$2;
            ResultKt.throwOnFailure(objFindAll);
        }
        map2.put(url2, objFindAll);
        return Unit.INSTANCE;
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
        CacheStorage cacheStorage2 = this.delegate;
        c02401.L$0 = null;
        c02401.L$1 = null;
        c02401.L$2 = concurrentMap;
        c02401.L$3 = url;
        c02401.label = 2;
        objFindAll = cacheStorage2.findAll(url, c02401);
        if (objFindAll != coroutineSingletons) {
            url2 = url;
            map2 = concurrentMap;
            map2.put(url2, objFindAll);
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation continuation) {
        C02411 c02411;
        if (continuation instanceof C02411) {
            c02411 = (C02411) continuation;
            int i = c02411.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02411.label = i - Integer.MIN_VALUE;
            } else {
                c02411 = new C02411(continuation);
            }
        } else {
            c02411 = new C02411(continuation);
        }
        Object obj = c02411.result;
        int i2 = c02411.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CacheStorage cacheStorage = this.delegate;
            c02411.L$0 = url;
            c02411.label = 1;
            Object objRemoveAll = cacheStorage.removeAll(url, c02411);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objRemoveAll == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            url = (Url) c02411.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.store.remove(url);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation continuation) {
        C02421 c02421;
        Url url2;
        Map map;
        if (continuation instanceof C02421) {
            c02421 = (C02421) continuation;
            int i = c02421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02421.label = i - Integer.MIN_VALUE;
            } else {
                c02421 = new C02421(continuation);
            }
        } else {
            c02421 = new C02421(continuation);
        }
        Object objFindAll = c02421.result;
        int i2 = c02421.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFindAll);
            CacheStorage cacheStorage = this.delegate;
            c02421.L$0 = url;
            c02421.L$1 = null;
            c02421.label = 1;
            if (cacheStorage.store(url, cachedResponseData, c02421) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 == 1) {
            url = (Url) c02421.L$0;
            ResultKt.throwOnFailure(objFindAll);
        } else {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            url2 = (Url) c02421.L$3;
            map = (Map) c02421.L$2;
            ResultKt.throwOnFailure(objFindAll);
        }
        map.put(url2, objFindAll);
        return Unit.INSTANCE;
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
        CacheStorage cacheStorage2 = this.delegate;
        c02421.L$0 = null;
        c02421.L$1 = null;
        c02421.L$2 = concurrentMap;
        c02421.L$3 = url;
        c02421.label = 2;
        objFindAll = cacheStorage2.findAll(url, c02421);
        if (objFindAll != coroutineSingletons) {
            url2 = url;
            map = concurrentMap;
            map.put(url2, objFindAll);
            return Unit.INSTANCE;
        }
        return coroutineSingletons;
    }
}
