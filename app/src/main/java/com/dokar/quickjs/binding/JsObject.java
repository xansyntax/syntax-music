package com.dokar.quickjs.binding;

import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0096\u0082\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0081\u0004J\u0014\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0096\u0081\u0004J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0083\u0004J\n\u0010\u0011\u001a\u00020\bH\u0096\u0081\u0004R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00140\u0013X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013X\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0019\u001a\u00020\u000bX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001dX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/dokar/quickjs/binding/JsObject;", "", "", "", "map", "<init>", "(Ljava/util/Map;)V", "equals", "", "other", "hashCode", "", "containsKey", "key", "containsValue", "value", "get", "isEmpty", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", ContentDisposition.Parameters.Size, "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "quickjs-kt:quickjs_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class JsObject implements Map<String, Object>, KMappedMarker {
    private final Map<String, Object> map;

    public JsObject(Map<String, ? extends Object> map) {
        map.getClass();
        this.map = map;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object compute(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfAbsent(String str, Function<? super String, ? extends Object> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object computeIfPresent(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.map.containsKey((String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof JsObject) && Intrinsics.areEqual(this.map, ((JsObject) other).map);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return this.map.get((String) obj);
    }

    public final Set<Map.Entry<String, Object>> getEntries() {
        return this.map.entrySet();
    }

    public final Set<String> getKeys() {
        return this.map.keySet();
    }

    public final int getSize() {
        return this.map.size();
    }

    public final Collection<Object> getValues() {
        return this.map.values();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object merge(String str, Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends Object> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object putIfAbsent(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object replace(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public final Collection<Object> values() {
        return this.map.values();
    }

    /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
    public final Object compute2(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
    public final Object computeIfAbsent2(String str, Function<? super String, ? extends Object> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
    public final Object computeIfPresent2(String str, BiFunction<? super String, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public final Object merge2(String str, Object obj, BiFunction<? super Object, ? super Object, ? extends Object> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public final Object put2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
    public final Object putIfAbsent2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public final Object replace2(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public final boolean replace2(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(String key) {
        key.getClass();
        return this.map.containsKey(key);
    }

    public final Object get(String key) {
        key.getClass();
        return this.map.get(key);
    }
}
