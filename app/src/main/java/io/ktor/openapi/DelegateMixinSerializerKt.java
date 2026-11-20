package io.ktor.openapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u0004*\u00020\u00002$\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00020\t0\bH\u0000¢\u0006\u0004\b\u0006\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/openapi/GenericElement;", "", "", "keys", "", "Lio/ktor/openapi/ElementKey;", "extract", "(Lio/ktor/openapi/GenericElement;Ljava/util/Collection;)Ljava/util/Map;", "", "Lkotlin/Pair;", "Lkotlin/Function1;", "", "reverseLookup", "(Lio/ktor/openapi/GenericElement;Ljava/util/List;)Ljava/util/Map;", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DelegateMixinSerializerKt {
    public static final Map<ElementKey, GenericElement> extract(GenericElement genericElement, List<? extends Pair> list) {
        Object next;
        genericElement.getClass();
        list.getClass();
        List<Pair> listEntries = genericElement.entries();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listEntries) {
            Pair pair = (Pair) obj;
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((Boolean) ((Function1) ((Pair) next).first).invoke(pair.first)).booleanValue());
            Pair pair2 = (Pair) next;
            Object property = pair2 != null ? new ElementKey.Property((String) pair2.second) : ElementKey.Root.INSTANCE;
            Object arrayList = linkedHashMap.get(property);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(property, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), GenericElementKt.GenericElement((Collection<? extends Pair>) entry.getValue()));
        }
        return linkedHashMap2;
    }

    public static final Map<ElementKey, GenericElement> extract(GenericElement genericElement, Collection<String> collection) {
        genericElement.getClass();
        collection.getClass();
        List<Pair> listEntries = genericElement.entries();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listEntries) {
            if (!collection.contains(((Pair) obj).first)) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put(ElementKey.Root.INSTANCE, GenericElementKt.GenericElement((Collection<? extends Pair>) arrayList));
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList2.get(i);
            i++;
            Pair pair = (Pair) obj2;
            String str = (String) pair.first;
            mapBuilder.put(new ElementKey.Property(str), (GenericElement) pair.second);
        }
        return mapBuilder.build();
    }
}
