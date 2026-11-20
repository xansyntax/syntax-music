package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0096@¢\u0006\u0004\b\u0013\u0010\u000fJ\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/cache/storage/UnlimitedStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "data", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/collections/ConcurrentMap;", "", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnlimitedStorage implements CacheStorage {
    private final ConcurrentMap<Url, Set<CachedResponseData>> store = new ConcurrentMap<>(0, 1, null);

    private static final boolean remove$lambda$0(Map map, CachedResponseData cachedResponseData) {
        cachedResponseData.getClass();
        if (map.size() != cachedResponseData.getVaryKeys().size()) {
            return false;
        }
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(str), (String) entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object clear(Continuation continuation) {
        this.store.clear();
        return Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object find(Url url, Map<String, String> map, Continuation continuation) {
        for (Object obj : this.store.computeIfAbsent(url, new FileCacheStorage$$ExternalSyntheticLambda0((byte) 6))) {
            CachedResponseData cachedResponseData = (CachedResponseData) obj;
            if (map.isEmpty()) {
                return obj;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(key), entry.getValue())) {
                }
            }
            return obj;
        }
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object findAll(Url url, Continuation continuation) {
        Set<CachedResponseData> set = this.store.get(url);
        return set == null ? EmptySet.INSTANCE : set;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object remove(Url url, Map<String, String> map, Continuation continuation) {
        Set<CachedResponseData> set = this.store.get(url);
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (remove$lambda$0(map, (CachedResponseData) it.next())) {
                    it.remove();
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object removeAll(Url url, Continuation continuation) {
        this.store.remove(url);
        return Unit.INSTANCE;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation continuation) {
        Set<CachedResponseData> setComputeIfAbsent = this.store.computeIfAbsent(url, new FileCacheStorage$$ExternalSyntheticLambda0((byte) 7));
        if (!setComputeIfAbsent.add(cachedResponseData)) {
            setComputeIfAbsent.remove(cachedResponseData);
            setComputeIfAbsent.add(cachedResponseData);
        }
        return Unit.INSTANCE;
    }
}
