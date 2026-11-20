package io.ktor.openapi;

import io.ktor.http.ContentType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a$\u0010\u0006\u001a\u00020\u0001\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0006\u001a\u00020\u0001\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\bH\u0086\b¢\u0006\u0004\b\u0006\u0010\u000b\u001a'\u0010\u0006\u001a\u00020\u00012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r0\f¢\u0006\u0004\b\u0006\u0010\u000f\u001a\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"T", "Lio/ktor/openapi/GenericElement;", "asA", "(Lio/ktor/openapi/GenericElement;)Ljava/lang/Object;", "", "value", "GenericElement", "(Ljava/lang/Object;)Lio/ktor/openapi/GenericElement;", "", "", "map", "(Ljava/util/Map;)Lio/ktor/openapi/GenericElement;", "", "Lkotlin/Pair;", "entries", "(Ljava/util/Collection;)Lio/ktor/openapi/GenericElement;", ContentType.Message.TYPE, "", "serialError", "(Ljava/lang/String;)Ljava/lang/Void;", "ktor-openapi-schema"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class GenericElementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final GenericElement GenericElement(Collection<? extends Pair> collection) {
        collection.getClass();
        if (!collection.isEmpty()) {
            Collection<? extends Pair> collection2 = collection;
            if (!collection2.isEmpty()) {
                Iterator<T> it = collection2.iterator();
                while (it.hasNext()) {
                    if (!(((Pair) it.next()).second instanceof JsonGenericElement)) {
                    }
                }
            }
            Object obj = ((Pair) CollectionsKt.first(collection2)).second;
            obj.getClass();
            JsonGenericElement jsonGenericElement = (JsonGenericElement) obj;
            int iMapCapacity = MapsKt__MapsKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10));
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
            for (Pair pair : collection2) {
                String str = (String) pair.first;
                GenericElement genericElement = (GenericElement) pair.second;
                genericElement.getClass();
                linkedHashMap.put(str, ((JsonGenericElement) genericElement).getElement());
            }
            return new JsonGenericElement(new JsonObject(linkedHashMap), jsonGenericElement.getJson(), jsonGenericElement.getElementSerializer());
        }
        return new GenericElementMap(MapsKt__MapsKt.toMap(collection), null, 2, 0 == true ? 1 : 0);
    }

    public static final <T> T asA(GenericElement genericElement) {
        genericElement.getClass();
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void serialError(String str) {
        throw new SerializationException(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> GenericElement GenericElement(T t) {
        t.getClass();
        if (t instanceof GenericElement) {
            return (GenericElement) t;
        }
        if (t instanceof String) {
            return new GenericElementString((String) t, null, 2, null);
        }
        Intrinsics.throwUndefinedForReified();
        throw null;
    }

    public static final <T> GenericElement GenericElement(Map<String, ? extends T> map) {
        GenericElement genericElementString;
        map.getClass();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (value instanceof GenericElement) {
                genericElementString = (GenericElement) value;
            } else {
                if (!(value instanceof String)) {
                    Intrinsics.throwUndefinedForReified();
                    throw null;
                }
                genericElementString = new GenericElementString((String) value, null, 2, null);
            }
            arrayList.add(new Pair(key, genericElementString));
        }
        return GenericElement((Collection<? extends Pair>) arrayList);
    }
}
