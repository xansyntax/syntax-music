package androidx.collection;

import androidx.collection.internal.Lock;
import coil3.network.NetworkHeaders;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class LruCache {
    public int hitCount;
    public final Lock lock;
    public final NetworkHeaders.Builder map;
    public final byte maxSize;
    public int missCount;
    public int size;

    /* JADX WARN: Multi-variable type inference failed */
    public LruCache(int i) {
        this.maxSize = i;
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("maxSize <= 0");
            throw null;
        }
        this.map = new NetworkHeaders.Builder((byte) 1);
        this.lock = new Lock((byte) 0);
    }

    public Object create(Object obj) {
        return null;
    }

    public void entryRemoved(Object obj, Object obj2, Object obj3) {
        obj.getClass();
    }

    public final Object get(Object obj) {
        Object objPut;
        synchronized (this.lock) {
            Object obj2 = this.map.data.get(obj);
            if (obj2 != null) {
                this.hitCount++;
                return obj2;
            }
            this.missCount++;
            Object objCreate = create(obj);
            if (objCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    objPut = this.map.data.put(obj, objCreate);
                    if (objPut != null) {
                        this.map.data.put(obj, objPut);
                    } else {
                        this.size++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objPut != null) {
                entryRemoved(obj, objCreate, objPut);
                return objPut;
            }
            trimToSize(this.maxSize);
            return objCreate;
        }
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        obj.getClass();
        obj2.getClass();
        synchronized (this.lock) {
            this.size++;
            objPut = this.map.data.put(obj, obj2);
            if (objPut != null) {
                this.size--;
            }
        }
        if (objPut != null) {
            entryRemoved(obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final Object remove(Object obj) {
        Object objRemove;
        synchronized (this.lock) {
            objRemove = this.map.data.remove(obj);
            if (objRemove != null) {
                this.size--;
            }
        }
        if (objRemove != null) {
            entryRemoved(obj, objRemove, null);
        }
        return objRemove;
    }

    public final String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + ((int) this.maxSize) + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void trimToSize(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (this.size < 0 || (this.map.data.isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size > i && !this.map.data.isEmpty()) {
                        Set setEntrySet = this.map.data.entrySet();
                        setEntrySet.getClass();
                        Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(setEntrySet);
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        NetworkHeaders.Builder builder = this.map;
                        key.getClass();
                        builder.data.remove(key);
                        int i2 = this.size;
                        value.getClass();
                        this.size = i2 - 1;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }
}
