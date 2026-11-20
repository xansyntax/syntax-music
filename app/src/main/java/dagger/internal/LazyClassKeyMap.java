package dagger.internal;

import com.google.common.collect.RegularImmutableMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LazyClassKeyMap implements Map {
    public final RegularImmutableMap delegate;

    public LazyClassKeyMap(RegularImmutableMap regularImmutableMap) {
        this.delegate = regularImmutableMap;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (obj instanceof Class) {
            return this.delegate.containsKey(((Class) obj).getName());
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Key must be a class");
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of entrySet(). Consider @ClassKey instead.");
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj instanceof Class) {
            return this.delegate.get(((Class) obj).getName());
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Key must be a class");
        return null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        throw new UnsupportedOperationException("Maps created with @LazyClassKey do not support usage of keySet(). Consider @ClassKey instead.");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Dagger map bindings are immutable");
    }

    @Override // java.util.Map
    public final int size() {
        return this.delegate.size;
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.delegate.values();
    }
}
