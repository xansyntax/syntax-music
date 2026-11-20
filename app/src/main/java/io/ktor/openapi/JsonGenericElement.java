package io.ktor.openapi;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.JsonPrimitiveDecoder;
import kotlinx.serialization.json.internal.JsonTreeDecoder;
import kotlinx.serialization.json.internal.JsonTreeListDecoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/openapi/JsonGenericElement;", "Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/json/JsonElement;", "element", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/KSerializer;)V", "", "isObject", "()Z", "isArray", "isString", "T", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "", "entries", "()Ljava/util/List;", "items", "other", "plus", "(Lio/ktor/openapi/GenericElement;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/json/JsonElement;", "getElement", "()Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/json/Json;", "getJson$ktor_openapi_schema", "()Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonGenericElement implements GenericElement {
    private final JsonElement element;
    private final KSerializer elementSerializer;
    private final Json json;

    public /* synthetic */ JsonGenericElement(JsonElement jsonElement, Json json, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonElement, (i & 2) != 0 ? Json.Default : json, (i & 4) != 0 ? JsonElement.INSTANCE.serializer() : kSerializer);
    }

    @Override // io.ktor.openapi.GenericElement
    public <T> T deserialize(DeserializationStrategy serializer) {
        Decoder jsonPrimitiveDecoder;
        serializer.getClass();
        Json json = this.json;
        JsonElement element = getElement();
        json.getClass();
        element.getClass();
        String str = null;
        if (element instanceof JsonObject) {
            jsonPrimitiveDecoder = new JsonTreeDecoder(json, (JsonObject) element, str, 12);
        } else if (element instanceof JsonArray) {
            jsonPrimitiveDecoder = new JsonTreeListDecoder(json, (JsonArray) element);
        } else {
            if (!(element instanceof JsonLiteral) && !element.equals(JsonNull.INSTANCE)) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return null;
            }
            jsonPrimitiveDecoder = new JsonPrimitiveDecoder(json, (JsonPrimitive) element, null);
        }
        return (T) jsonPrimitiveDecoder.decodeSerializableValue(serializer);
    }

    @Override // io.ktor.openapi.GenericElement
    public List<Pair> entries() {
        if (!(getElement() instanceof JsonObject)) {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) getElement(), (Object) " is not an object");
            return null;
        }
        Set<Map.Entry> setEntrySet = ((JsonObject) getElement()).content.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new Pair((String) entry.getKey(), new JsonGenericElement((JsonElement) entry.getValue(), this.json, getElementSerializer())));
        }
        return arrayList;
    }

    @Override // io.ktor.openapi.GenericElement
    public KSerializer getElementSerializer() {
        return this.elementSerializer;
    }

    /* JADX INFO: renamed from: getJson$ktor_openapi_schema, reason: from getter */
    public final Json getJson() {
        return this.json;
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isArray() {
        return getElement() instanceof JsonArray;
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isObject() {
        return getElement() instanceof JsonObject;
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isString() {
        return (getElement() instanceof JsonPrimitive) && ((JsonPrimitive) getElement()).isString();
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> items() {
        if (!(getElement() instanceof JsonArray)) {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) getElement(), (Object) " is not an array");
            return null;
        }
        Iterable iterable = (Iterable) getElement();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new JsonGenericElement((JsonElement) it.next(), this.json, getElementSerializer()));
        }
        return arrayList;
    }

    @Override // io.ktor.openapi.GenericElement
    public GenericElement plus(GenericElement other) {
        other.getClass();
        if (!(getElement() instanceof JsonObject)) {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) getElement(), (Object) " is not an object");
            return null;
        }
        if (!(other instanceof JsonGenericElement)) {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) other, (Object) " is not a JSON element");
            return null;
        }
        JsonGenericElement jsonGenericElement = (JsonGenericElement) other;
        JsonElement element = jsonGenericElement.getElement();
        if (element instanceof JsonObject) {
            return new JsonGenericElement(new JsonObject(MapsKt__MapsKt.plus((Map) getElement(), (Map) jsonGenericElement.getElement())), this.json, getElementSerializer());
        }
        if (element instanceof JsonNull) {
            return this;
        }
        throw new IllegalArgumentException(jsonGenericElement.getElement() + " is not an object");
    }

    @Override // io.ktor.openapi.GenericElement
    public JsonElement getElement() {
        return this.element;
    }

    public JsonGenericElement(JsonElement jsonElement, Json json, KSerializer kSerializer) {
        jsonElement.getClass();
        json.getClass();
        kSerializer.getClass();
        this.element = jsonElement;
        this.json = json;
        this.elementSerializer = kSerializer;
    }
}
