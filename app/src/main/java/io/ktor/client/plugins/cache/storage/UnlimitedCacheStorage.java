package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/client/plugins/cache/storage/UnlimitedCacheStorage;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "<init>", "()V", "Lio/ktor/http/Url;", "url", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "value", "", "store", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/HttpCacheEntry;)V", "", "", "varyKeys", "find", "(Lio/ktor/http/Url;Ljava/util/Map;)Lio/ktor/client/plugins/cache/HttpCacheEntry;", "", "findByUrl", "(Lio/ktor/http/Url;)Ljava/util/Set;", "", "remove$ktor_client_core", "(Lio/ktor/http/Url;Ljava/util/Map;)Ljava/lang/Boolean;", "remove", "Lio/ktor/util/collections/ConcurrentMap;", "", "Lio/ktor/util/collections/ConcurrentMap;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnlimitedCacheStorage extends HttpCacheStorage {
    private final ConcurrentMap<Url, Set<HttpCacheEntry>> store = new ConcurrentMap<>(0, 1, null);

    private static final boolean remove$lambda$0(Map map, HttpCacheEntry httpCacheEntry) {
        httpCacheEntry.getClass();
        if (map.size() != httpCacheEntry.getVaryKeys().size()) {
            return false;
        }
        if (map.isEmpty()) {
            return true;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!Intrinsics.areEqual(httpCacheEntry.getVaryKeys().get(str), (String) entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public HttpCacheEntry find(Url url, Map<String, String> varyKeys) {
        Object next;
        Map.Entry<String, String> next2;
        String key;
        url.getClass();
        varyKeys.getClass();
        Iterator<T> it = this.store.computeIfAbsent(url, new FileCacheStorage$$ExternalSyntheticLambda0((byte) 5)).iterator();
        while (it.hasNext()) {
            next = it.next();
            HttpCacheEntry httpCacheEntry = (HttpCacheEntry) next;
            if (!varyKeys.isEmpty()) {
                Iterator<Map.Entry<String, String>> it2 = varyKeys.entrySet().iterator();
                do {
                    if (it2.hasNext()) {
                        next2 = it2.next();
                        key = next2.getKey();
                    }
                } while (Intrinsics.areEqual(httpCacheEntry.getVaryKeys().get(key), next2.getValue()));
            }
            return (HttpCacheEntry) next;
        }
        next = null;
        return (HttpCacheEntry) next;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public Set<HttpCacheEntry> findByUrl(Url url) {
        url.getClass();
        Set<HttpCacheEntry> set = this.store.get(url);
        return set == null ? EmptySet.INSTANCE : set;
    }

    public final Boolean remove$ktor_client_core(Url url, Map<String, String> varyKeys) {
        url.getClass();
        varyKeys.getClass();
        Set<HttpCacheEntry> set = this.store.get(url);
        if (set == null) {
            return null;
        }
        Iterator<T> it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (remove$lambda$0(varyKeys, (HttpCacheEntry) it.next())) {
                it.remove();
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public void store(Url url, HttpCacheEntry value) {
        url.getClass();
        value.getClass();
        Set<HttpCacheEntry> setComputeIfAbsent = this.store.computeIfAbsent(url, new FileCacheStorage$$ExternalSyntheticLambda0((byte) 4));
        if (setComputeIfAbsent.add(value)) {
            return;
        }
        setComputeIfAbsent.remove(value);
        setComputeIfAbsent.add(value);
    }
}
