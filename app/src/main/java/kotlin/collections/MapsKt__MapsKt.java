package kotlin.collections;

import dagger.hilt.EntryPoints;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MapsKt__MapsKt extends EntryPoints {
    public static Object getValue(Map map, Object obj) {
        map.getClass();
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map mapOf(Pair... pairArr) {
        if (pairArr.length <= 0) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final Map optimizeReadOnlyMap(LinkedHashMap linkedHashMap) {
        int size = linkedHashMap.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return linkedHashMap;
        }
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }

    public static LinkedHashMap plus(Map map, Map map2) {
        map.getClass();
        map2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final void putAll(HashMap map, Pair[] pairArr) {
        for (Pair pair : pairArr) {
            map.put(pair.first, pair.second);
        }
    }

    public static Map toMap(Iterable iterable) {
        iterable.getClass();
        if (!(iterable instanceof Collection)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                linkedHashMap.put(pair.first, pair.second);
            }
            return optimizeReadOnlyMap(linkedHashMap);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size == 1) {
            return mapOf((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity(collection.size()));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            Pair pair2 = (Pair) it2.next();
            linkedHashMap2.put(pair2.first, pair2.second);
        }
        return linkedHashMap2;
    }

    public static LinkedHashMap toMutableMap(Map map) {
        map.getClass();
        return new LinkedHashMap(map);
    }

    public static Map mapOf(Pair pair) {
        pair.getClass();
        Map mapSingletonMap = Collections.singletonMap(pair.first, pair.second);
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }

    public static Map toMap(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}
