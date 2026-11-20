package androidx.datastore.preferences.core;

import androidx.datastore.core.AtomicInt;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutablePreferences {
    public final AtomicInt frozen;
    public final LinkedHashMap preferencesMap;

    public MutablePreferences(LinkedHashMap linkedHashMap, boolean z) {
        this.preferencesMap = linkedHashMap;
        AtomicInt atomicInt = new AtomicInt();
        atomicInt.delegate = new AtomicBoolean(z);
        this.frozen = atomicInt;
    }

    public final Map asMap() {
        Pair pair;
        Set<Map.Entry> setEntrySet = this.preferencesMap.entrySet();
        int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
        if (iMapCapacity < 16) {
            iMapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                pair = new Pair(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(pair.first, pair.second);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public final void checkNotFrozen$datastore_preferences_core() {
        if (((AtomicBoolean) this.frozen.delegate).get()) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Do mutate preferences once returned to DataStore.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    public final boolean equals(Object obj) {
        boolean zAreEqual;
        if (obj instanceof MutablePreferences) {
            LinkedHashMap linkedHashMap = ((MutablePreferences) obj).preferencesMap;
            LinkedHashMap linkedHashMap2 = this.preferencesMap;
            if (linkedHashMap != linkedHashMap2) {
                if (linkedHashMap.size() == linkedHashMap2.size()) {
                    if (!linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            Object obj2 = linkedHashMap2.get(entry.getKey());
                            if (obj2 != null) {
                                Object value = entry.getValue();
                                if (!(value instanceof byte[])) {
                                    zAreEqual = Intrinsics.areEqual(value, obj2);
                                } else if ((obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2)) {
                                    zAreEqual = true;
                                } else {
                                    zAreEqual = false;
                                }
                            } else {
                                zAreEqual = false;
                            }
                            if (!zAreEqual) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final Object get(Preferences$Key preferences$Key) {
        preferences$Key.getClass();
        Object obj = this.preferencesMap.get(preferences$Key);
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int hashCode() {
        Iterator it = this.preferencesMap.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final void remove(Preferences$Key preferences$Key) {
        preferences$Key.getClass();
        checkNotFrozen$datastore_preferences_core();
        this.preferencesMap.remove(preferences$Key);
    }

    public final void set(Preferences$Key preferences$Key, Object obj) {
        preferences$Key.getClass();
        setUnchecked$datastore_preferences_core(preferences$Key, obj);
    }

    public final void setUnchecked$datastore_preferences_core(Preferences$Key preferences$Key, Object obj) {
        preferences$Key.getClass();
        checkNotFrozen$datastore_preferences_core();
        if (obj == null) {
            remove(preferences$Key);
            return;
        }
        boolean z = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.preferencesMap;
        if (z) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(CollectionsKt.toSet((Set) obj));
            setUnmodifiableSet.getClass();
            linkedHashMap.put(preferences$Key, setUnmodifiableSet);
        } else if (!(obj instanceof byte[])) {
            linkedHashMap.put(preferences$Key, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            linkedHashMap.put(preferences$Key, Arrays.copyOf(bArr, bArr.length));
        }
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", new RoomDatabase$$ExternalSyntheticLambda2((byte) 2), 24);
    }

    public /* synthetic */ MutablePreferences(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
