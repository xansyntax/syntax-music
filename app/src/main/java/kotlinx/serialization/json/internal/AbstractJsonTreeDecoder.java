package kotlinx.serialization.json.internal;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.ListLikeDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonDecodingException;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractJsonTreeDecoder implements JsonDecoder, Decoder, CompositeDecoder {
    public final JsonConfiguration configuration;
    public boolean flag;
    public final Json json;
    public final String polymorphicDiscriminator;
    public final ArrayList tagStack = new ArrayList();

    public AbstractJsonTreeDecoder(Json json, String str) {
        this.json = json;
        this.polymorphicDiscriminator = str;
        this.configuration = json.configuration;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        JsonElement jsonElementCurrentObject = currentObject();
        Okio__OkioKt kind = serialDescriptor.getKind();
        boolean zAreEqual = Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2);
        Json json = this.json;
        if (zAreEqual || (kind instanceof PolymorphicKind$OPEN)) {
            String serialName = serialDescriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) jsonElementCurrentObject);
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
        }
        if (!Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
            String serialName2 = serialDescriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json, (JsonObject) jsonElementCurrentObject, this.polymorphicDiscriminator, 8);
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName2, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
        }
        SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.serializersModule);
        Okio__OkioKt kind2 = serialDescriptorCarrierDescriptor.getKind();
        if ((kind2 instanceof PrimitiveKind$INT) || Intrinsics.areEqual(kind2, SerialKind$ENUM.INSTANCE)) {
            String serialName3 = serialDescriptor.getSerialName();
            if (jsonElementCurrentObject instanceof JsonObject) {
                return new JsonTreeMapDecoder(json, (JsonObject) jsonElementCurrentObject);
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName3, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
        }
        if (!json.configuration.allowStructuredMapKeys) {
            throw WriteModeKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
        }
        String serialName4 = serialDescriptor.getSerialName();
        if (jsonElementCurrentObject instanceof JsonArray) {
            return new JsonTreeListDecoder(json, (JsonArray) jsonElementCurrentObject);
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName4, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
    }

    public abstract JsonElement currentElement(String str);

    public final JsonElement currentObject() {
        JsonElement jsonElementCurrentElement;
        String str = (String) CollectionsKt.lastOrNull(this.tagStack);
        return (str == null || (jsonElementCurrentElement = currentElement(str)) == null) ? getValue() : jsonElementCurrentElement;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean decodeBoolean() {
        return decodeTaggedBoolean(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeTaggedBoolean(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte decodeByte() {
        return decodeTaggedByte(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedByte(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char decodeChar() {
        return decodeTaggedChar(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedChar(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double decodeDouble() {
        return decodeTaggedDouble(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeTaggedDouble(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeEnum(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        String str = (String) popTag();
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        String serialName = serialDescriptor.getSerialName();
        boolean z = jsonElementCurrentElement instanceof JsonPrimitive;
        Json json = this.json;
        if (z) {
            return WriteModeKt.getJsonNameIndexOrThrow(serialDescriptor, json, ((JsonPrimitive) jsonElementCurrentElement).getContent(), "");
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName, renderTagStack(str), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float decodeFloat() {
        return decodeTaggedFloat(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedFloat(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Decoder decodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        if (CollectionsKt.lastOrNull(this.tagStack) != null) {
            return decodeTaggedInline(popTag(), serialDescriptor);
        }
        return new JsonPrimitiveDecoder(this.json, getValue(), this.polymorphicDiscriminator).decodeInline(serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder decodeInlineElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedInline(getTag(serialDescriptor, i), ((ListLikeDescriptor) serialDescriptor).getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int decodeInt() {
        return decodeTaggedInt(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeTaggedInt(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement decodeJsonElement() {
        return currentObject();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long decodeLong() {
        return decodeTaggedLong(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeTaggedLong(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        serialDescriptor.getClass();
        deserializationStrategy.getClass();
        this.tagStack.add(getTag(serialDescriptor, i));
        Object objDecodeSerializableValue = (deserializationStrategy.getDescriptor().isNullable() || decodeNotNullMark()) ? decodeSerializableValue(deserializationStrategy) : null;
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return objDecodeSerializableValue;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, Object obj) {
        serialDescriptor.getClass();
        deserializationStrategy.getClass();
        this.tagStack.add(getTag(serialDescriptor, i));
        deserializationStrategy.getClass();
        Object objDecodeSerializableValue = decodeSerializableValue(deserializationStrategy);
        if (!this.flag) {
            popTag();
        }
        this.flag = false;
        return objDecodeSerializableValue;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Object decodeSerializableValue(DeserializationStrategy deserializationStrategy) {
        deserializationStrategy.getClass();
        if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer)) {
            return deserializationStrategy.deserialize(this);
        }
        Json json = this.json;
        JsonConfiguration jsonConfiguration = json.configuration;
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) deserializationStrategy;
        String strClassDiscriminator = WriteModeKt.classDiscriminator(abstractPolymorphicSerializer.getDescriptor(), json);
        JsonElement jsonElementCurrentObject = currentObject();
        String serialName = abstractPolymorphicSerializer.getDescriptor().getSerialName();
        if (jsonElementCurrentObject instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) jsonElementCurrentObject;
            JsonElement jsonElement = (JsonElement) jsonObject.get(strClassDiscriminator);
            try {
                return WriteModeKt.readPolymorphicJson(json, strClassDiscriminator, jsonObject, EntryPoints.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, this, jsonElement != null ? JsonElementKt.getContentOrNull(JsonElementKt.getJsonPrimitive(jsonElement)) : null));
            } catch (SerializationException e) {
                String message = e.getMessage();
                message.getClass();
                throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, message, null, null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonObject.toString(), -1).toString() : null));
            }
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentObject.getClass()).getSimpleName() + " as the serialized body of " + serialName, renderTagStack(), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentObject.toString(), -1).toString() : null));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short decodeShort() {
        return decodeTaggedShort(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(SerialDescriptor serialDescriptor, int i) {
        return decodeTaggedShort(getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String decodeString() {
        return decodeTaggedString(popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeTaggedString(getTag(serialDescriptor, i));
    }

    public final boolean decodeTaggedBoolean(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of boolean", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
            if (booleanOrNull != null) {
                return booleanOrNull.booleanValue();
            }
            unparsedPrimitive(jsonPrimitive, "boolean", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "boolean", str);
            throw null;
        }
    }

    public final byte decodeTaggedByte(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of byte", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Byte bValueOf = (-128 > longImpl || longImpl > 127) ? null : Byte.valueOf((byte) longImpl);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            unparsedPrimitive(jsonPrimitive, "byte", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "byte", str);
            throw null;
        }
    }

    public final char decodeTaggedChar(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                return StringsKt.single(jsonPrimitive.getContent());
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(jsonPrimitive, "char", str);
                throw null;
            }
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of char", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
    }

    public final double decodeTaggedDouble(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        boolean z = jsonElementCurrentElement instanceof JsonPrimitive;
        Json json = this.json;
        if (!z) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of double", renderTagStack(str), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            double d = Double.parseDouble(jsonPrimitive.getContent());
            if (json.configuration.allowSpecialFloatingPointValues || Math.abs(d) <= Double.MAX_VALUE) {
                return d;
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, WriteModeKt.nonFiniteFpMessage(Double.valueOf(d), str), null, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(currentObject().toString(), -1).toString() : null));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "double", str);
            throw null;
        }
    }

    public final float decodeTaggedFloat(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        boolean z = jsonElementCurrentElement instanceof JsonPrimitive;
        Json json = this.json;
        if (!z) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of float", renderTagStack(str), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
            float f = Float.parseFloat(jsonPrimitive.getContent());
            if (json.configuration.allowSpecialFloatingPointValues || Math.abs(f) <= Float.MAX_VALUE) {
                return f;
            }
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, WriteModeKt.nonFiniteFpMessage(Float.valueOf(f), str), null, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(currentObject().toString(), -1).toString() : null));
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "float", str);
            throw null;
        }
    }

    public final Decoder decodeTaggedInline(Object obj, SerialDescriptor serialDescriptor) {
        String str = (String) obj;
        str.getClass();
        serialDescriptor.getClass();
        if (!StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            this.tagStack.add(str);
            return this;
        }
        JsonElement jsonElementCurrentElement = currentElement(str);
        String serialName = serialDescriptor.getSerialName();
        boolean z = jsonElementCurrentElement instanceof JsonPrimitive;
        Json json = this.json;
        if (z) {
            return new JsonDecoderForUnsignedTypes(WriteModeKt.StringJsonLexer(json, ((JsonPrimitive) jsonElementCurrentElement).getContent()), json);
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of " + serialName, renderTagStack(str), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
    }

    public final int decodeTaggedInt(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of int", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Integer numValueOf = (-2147483648L > longImpl || longImpl > 2147483647L) ? null : Integer.valueOf((int) longImpl);
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            unparsedPrimitive(jsonPrimitive, "int", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "int", str);
            throw null;
        }
    }

    public final long decodeTaggedLong(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (jsonElementCurrentElement instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
            try {
                return JsonElementKt.parseLongImpl(jsonPrimitive);
            } catch (IllegalArgumentException unused) {
                unparsedPrimitive(jsonPrimitive, "long", str);
                throw null;
            }
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of long", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
    }

    public final short decodeTaggedShort(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        if (!(jsonElementCurrentElement instanceof JsonPrimitive)) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of short", renderTagStack(str), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        try {
            long longImpl = JsonElementKt.parseLongImpl(jsonPrimitive);
            Short shValueOf = (-32768 > longImpl || longImpl > 32767) ? null : Short.valueOf((short) longImpl);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            unparsedPrimitive(jsonPrimitive, "short", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            unparsedPrimitive(jsonPrimitive, "short", str);
            throw null;
        }
    }

    public final String decodeTaggedString(Object obj) {
        String str = (String) obj;
        str.getClass();
        JsonElement jsonElementCurrentElement = currentElement(str);
        boolean z = jsonElementCurrentElement instanceof JsonPrimitive;
        Json json = this.json;
        if (!z) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonPrimitive.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementCurrentElement.getClass()).getSimpleName() + " as the serialized body of string", renderTagStack(str), null, json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementCurrentElement.toString(), -1).toString() : null));
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementCurrentElement;
        if (!(jsonPrimitive instanceof JsonLiteral)) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, IntIntPair$$ExternalSyntheticOutline0.m("Expected string value for a non-null key '", str, "', got null literal instead"), renderTagStack(str), "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.", json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(currentObject().toString(), -1).toString() : null));
        }
        JsonLiteral jsonLiteral = (JsonLiteral) jsonPrimitive;
        if (jsonLiteral.isString || json.configuration.isLenient) {
            return jsonLiteral.content;
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, IntIntPair$$ExternalSyntheticOutline0.m("String literal for value of key '", str, "' should be quoted"), renderTagStack(str), "Use 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(currentObject().toString(), -1).toString() : null));
    }

    public String elementName(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return serialDescriptor.getElementName(i);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule getSerializersModule() {
        return this.json.serializersModule;
    }

    public final String getTag(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        String strElementName = elementName(serialDescriptor, i);
        strElementName.getClass();
        return strElementName;
    }

    public abstract JsonElement getValue();

    public final Object popTag() {
        ArrayList arrayList = this.tagStack;
        Object objRemove = arrayList.remove(arrayList.size() - 1);
        this.flag = true;
        return objRemove;
    }

    public final String renderTagStack(String str) {
        str.getClass();
        return renderTagStack() + '.' + str;
    }

    public final void unparsedPrimitive(JsonPrimitive jsonPrimitive, String str, String str2) {
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Failed to parse literal '" + jsonPrimitive + "' as " + (StringsKt__StringsJVMKt.startsWith(str, "i", false) ? "an " : "a ").concat(str) + " value", renderTagStack(str2), null, this.json.configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(currentObject().toString(), -1).toString() : null));
    }

    public final String renderTagStack() {
        ArrayList arrayList = this.tagStack;
        return arrayList.isEmpty() ? "$" : CollectionsKt.joinToString$default(arrayList, ".", "$.", null, null, 60);
    }
}
