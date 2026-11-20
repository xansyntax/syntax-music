package io.ktor.util.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ \u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ)\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/util/collections/CopyOnWriteHashMap;", "", "K", "V", "<init>", "()V", "key", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "remove", "Lkotlin/Function1;", "producer", "computeIfAbsent", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ktor-utils"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CopyOnWriteHashMap<K, V> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current = EmptyMap.INSTANCE;

    public final V computeIfAbsent(K key, Function1 producer) {
        key.getClass();
        producer.getClass();
        while (true) {
            Map map = (Map) this.current;
            V v = (V) map.get(key);
            if (v != null) {
                return v;
            }
            HashMap map2 = new HashMap(map);
            V v2 = (V) producer.invoke(key);
            map2.put(key, v2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = current$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, map, map2)) {
                if (atomicReferenceFieldUpdater.get(this) != map) {
                }
            }
            return v2;
        }
    }

    public final V get(K key) {
        key.getClass();
        return (V) ((Map) this.current).get(key);
    }

    public final V put(K key, V value) {
        key.getClass();
        value.getClass();
        while (true) {
            Map map = (Map) this.current;
            if (map.get(key) == value) {
                return value;
            }
            HashMap map2 = new HashMap(map);
            V v = (V) map2.put(key, value);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = current$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, map, map2)) {
                if (atomicReferenceFieldUpdater.get(this) != map) {
                }
            }
            return v;
        }
    }

    public final V remove(K key) {
        key.getClass();
        while (true) {
            Map map = (Map) this.current;
            if (map.get(key) == null) {
                return null;
            }
            HashMap map2 = new HashMap(map);
            V v = (V) map2.remove(key);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = current$FU;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, map, map2)) {
                if (atomicReferenceFieldUpdater.get(this) != map) {
                }
            }
            return v;
        }
    }

    public final void set(K key, V value) {
        key.getClass();
        value.getClass();
        put(key, value);
    }
}
