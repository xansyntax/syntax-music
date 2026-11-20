package kotlinx.serialization.json.internal;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecodingException;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    public boolean forceNull;
    public final SerialDescriptor polyDescriptor;
    public int position;
    public final JsonObject value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(json, str);
        json.getClass();
        this.value = jsonObject;
        this.polyDescriptor = serialDescriptor;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        SerialDescriptor serialDescriptor2 = this.polyDescriptor;
        if (serialDescriptor != serialDescriptor2) {
            return super.beginStructure(serialDescriptor);
        }
        JsonElement jsonElementCurrentObject = currentObject();
        String serialName = serialDescriptor2.getSerialName();
        boolean z = jsonElementCurrentObject instanceof JsonObject;
        Json json = this.json;
        if (z) {
            return new JsonTreeDecoder(json, (JsonObject) jsonElementCurrentObject, this.polymorphicDiscriminator, serialDescriptor2);
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement currentElement(String str) {
        str.getClass();
        return (JsonElement) MapsKt__MapsKt.getValue(getValue(), str);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        while (this.position < serialDescriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String tag = getTag(serialDescriptor, i);
            int i2 = this.position - 1;
            this.forceNull = false;
            if (!getValue().containsKey(tag)) {
                boolean z = (this.json.configuration.explicitNulls || serialDescriptor.isElementOptional(i2) || !serialDescriptor.getElementDescriptor(i2).isNullable()) ? false : true;
                this.forceNull = z;
                if (z) {
                }
            }
            return i2;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public String elementName(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        Json json = this.json;
        WriteModeKt.namingStrategy(serialDescriptor, json);
        String elementName = serialDescriptor.getElementName(i);
        if (this.configuration.useAlternativeNames && !getValue().content.keySet().contains(elementName)) {
            ConnectionPool connectionPool = json._schemaCache;
            Url$$ExternalSyntheticLambda1 url$$ExternalSyntheticLambda1 = new Url$$ExternalSyntheticLambda1(serialDescriptor, json, (byte) 6);
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) connectionPool.delegate;
            Map map = (Map) concurrentHashMap.get(serialDescriptor);
            Object obj = null;
            JsonPath.Tombstone tombstone = WriteModeKt.JsonDeserializationNamesKey;
            Object objInvoke = map != null ? map.get(tombstone) : null;
            if (objInvoke == null) {
                objInvoke = null;
            }
            if (objInvoke == null) {
                objInvoke = url$$ExternalSyntheticLambda1.invoke();
                Object concurrentHashMap2 = concurrentHashMap.get(serialDescriptor);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(serialDescriptor, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(tombstone, objInvoke);
            }
            Map map2 = (Map) objInvoke;
            for (Object obj2 : getValue().content.keySet()) {
                Integer num = (Integer) map2.get((String) obj2);
                if (num != null && num.intValue() == i) {
                    obj = obj2;
                    break;
                }
            }
            String str = (String) obj;
            if (str != null) {
                return str;
            }
        }
        return elementName;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
        Set setPlus;
        serialDescriptor.getClass();
        Json json = this.json;
        if (WriteModeKt.ignoreUnknownKeys(serialDescriptor, json) || (serialDescriptor.getKind() instanceof PolymorphicKind$OPEN)) {
            return;
        }
        WriteModeKt.namingStrategy(serialDescriptor, json);
        if (this.configuration.useAlternativeNames) {
            Set setCachedSerialNames = EnumsKt.cachedSerialNames(serialDescriptor);
            Map map = (Map) ((ConcurrentHashMap) json._schemaCache.delegate).get(serialDescriptor);
            Object obj = map != null ? map.get(WriteModeKt.JsonDeserializationNamesKey) : null;
            if (obj == null) {
                obj = null;
            }
            Map map2 = (Map) obj;
            Set setKeySet = map2 != null ? map2.keySet() : null;
            if (setKeySet == null) {
                setKeySet = EmptySet.INSTANCE;
            }
            setPlus = SetsKt.plus(setCachedSerialNames, (Iterable) setKeySet);
        } else {
            setPlus = EnumsKt.cachedSerialNames(serialDescriptor);
        }
        for (String str : getValue().content.keySet()) {
            if (!setPlus.contains(str) && !Intrinsics.areEqual(str, this.polymorphicDiscriminator)) {
                throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, Format$$ExternalSyntheticOutline0.m('\'', "Encountered an unknown key '", str), renderTagStack(), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.", json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(getValue().toString(), -1).toString() : null));
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonObject getValue() {
        return this.value;
    }

    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, int i) {
        this(json, jsonObject, (i & 4) != 0 ? null : str, (SerialDescriptor) null);
    }
}
