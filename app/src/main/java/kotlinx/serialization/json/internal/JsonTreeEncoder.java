package kotlinx.serialization.json.internal;

import dagger.hilt.EntryPoints;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.websocket.PingPongKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.ListLikeDescriptor;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public class JsonTreeEncoder implements JsonEncoder, Encoder, CompositeEncoder {
    public final /* synthetic */ byte $r8$classId;
    public final JsonConfiguration configuration;
    public Object content;
    public final Json json;
    public final Function1 nodeConsumer;
    public String polymorphicDiscriminator;
    public String polymorphicSerialName;
    public final ArrayList tagStack;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JsonTreeEncoder(Json json, Function1 function1, byte b) {
        this(json, function1, 0);
        this.$r8$classId = b;
        function1.getClass();
        switch (b) {
            case 1:
                this(json, function1, 0);
                this.tagStack.add("primitive");
                break;
            case 2:
                this(json, function1, 0);
                this.content = new ArrayList();
                break;
            default:
                this.content = new LinkedHashMap();
                break;
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        JsonTreeEncoder jsonTreeEncoder;
        serialDescriptor.getClass();
        Function1 pingPongKt$$ExternalSyntheticLambda0 = CollectionsKt.lastOrNull(this.tagStack) == null ? this.nodeConsumer : new PingPongKt$$ExternalSyntheticLambda0((byte) 12, (Object) this);
        Okio__OkioKt kind = serialDescriptor.getKind();
        boolean zAreEqual = Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2);
        Json json = this.json;
        if (zAreEqual || (kind instanceof PolymorphicKind$OPEN)) {
            jsonTreeEncoder = new JsonTreeEncoder(json, pingPongKt$$ExternalSyntheticLambda0, (byte) 2);
        } else if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
            SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.serializersModule);
            Okio__OkioKt kind2 = serialDescriptorCarrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind$INT) || Intrinsics.areEqual(kind2, SerialKind$ENUM.INSTANCE)) {
                pingPongKt$$ExternalSyntheticLambda0.getClass();
                JsonTreeMapEncoder jsonTreeMapEncoder = new JsonTreeMapEncoder(json, pingPongKt$$ExternalSyntheticLambda0, (byte) 0);
                jsonTreeMapEncoder.isKey = true;
                jsonTreeEncoder = jsonTreeMapEncoder;
            } else {
                if (!json.configuration.allowStructuredMapKeys) {
                    throw WriteModeKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
                }
                jsonTreeEncoder = new JsonTreeEncoder(json, pingPongKt$$ExternalSyntheticLambda0, (byte) 2);
            }
        } else {
            jsonTreeEncoder = new JsonTreeEncoder(json, pingPongKt$$ExternalSyntheticLambda0, (byte) 0);
        }
        String str = this.polymorphicDiscriminator;
        if (str != null) {
            if (jsonTreeEncoder instanceof JsonTreeMapEncoder) {
                JsonTreeMapEncoder jsonTreeMapEncoder2 = (JsonTreeMapEncoder) jsonTreeEncoder;
                jsonTreeMapEncoder2.putElement("key", JsonElementKt.JsonPrimitive(str));
                String serialName = this.polymorphicSerialName;
                if (serialName == null) {
                    serialName = serialDescriptor.getSerialName();
                }
                jsonTreeMapEncoder2.putElement("value", JsonElementKt.JsonPrimitive(serialName));
            } else {
                String serialName2 = this.polymorphicSerialName;
                if (serialName2 == null) {
                    serialName2 = serialDescriptor.getSerialName();
                }
                jsonTreeEncoder.putElement(str, JsonElementKt.JsonPrimitive(serialName2));
            }
            this.polymorphicDiscriminator = null;
            this.polymorphicSerialName = null;
        }
        return jsonTreeEncoder;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        String str = (String) popTag();
        str.getClass();
        Boolean boolValueOf = Boolean.valueOf(z);
        InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
        putElement(str, new JsonLiteral(boolValueOf, false, null));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        serialDescriptor.getClass();
        String tag = getTag(serialDescriptor, i);
        Boolean boolValueOf = Boolean.valueOf(z);
        InlineClassDescriptor inlineClassDescriptor = JsonElementKt.jsonUnquotedLiteralDescriptor;
        putElement(tag, new JsonLiteral(boolValueOf, false, null));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Byte.valueOf(b)));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor serialDescriptor, int i, byte b) {
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(Byte.valueOf(b)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(String.valueOf(c)));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor serialDescriptor, int i, char c) {
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(String.valueOf(c)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        encodeTaggedDouble(popTag(), d);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor serialDescriptor, int i, double d) {
        serialDescriptor.getClass();
        encodeTaggedDouble(getTag(serialDescriptor, i), d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(serialDescriptor.getElementName(i)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        encodeTaggedFloat(f, popTag());
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor serialDescriptor, int i, float f) {
        encodeTaggedFloat(f, getTag(serialDescriptor, i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final Encoder encodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        if (CollectionsKt.lastOrNull(this.tagStack) == null) {
            return new JsonTreeEncoder(this.json, this.nodeConsumer, (byte) 1).encodeInline(serialDescriptor);
        }
        if (this.polymorphicDiscriminator != null) {
            this.polymorphicSerialName = serialDescriptor.getSerialName();
        }
        return encodeTaggedInline(popTag(), serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor serialDescriptor, int i) {
        return encodeTaggedInline(getTag(serialDescriptor, i), ((ListLikeDescriptor) serialDescriptor).getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Integer.valueOf(i)));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor serialDescriptor, int i, int i2) {
        serialDescriptor.getClass();
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(Integer.valueOf(i2)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Long.valueOf(j)));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        serialDescriptor.getClass();
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(Long.valueOf(j)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
        String str = (String) CollectionsKt.lastOrNull(this.tagStack);
        if (str == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            putElement(str, JsonNull.INSTANCE);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                serialDescriptor.getClass();
                serializationStrategy.getClass();
                if (obj != null || this.configuration.explicitNulls) {
                    encodeNullableSerializableElement$kotlinx$serialization$json$internal$AbstractJsonTreeEncoder(serialDescriptor, i, serializationStrategy, obj);
                }
                break;
            default:
                encodeNullableSerializableElement$kotlinx$serialization$json$internal$AbstractJsonTreeEncoder(serialDescriptor, i, serializationStrategy, obj);
                break;
        }
    }

    public final void encodeNullableSerializableElement$kotlinx$serialization$json$internal$AbstractJsonTreeEncoder(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        serialDescriptor.getClass();
        serializationStrategy.getClass();
        this.tagStack.add(getTag(serialDescriptor, i));
        if (serializationStrategy.getDescriptor().isNullable()) {
            encodeSerializableValue(serializationStrategy, obj);
        } else if (obj == null) {
            encodeNull();
        } else {
            encodeSerializableValue(serializationStrategy, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, Object obj) {
        serialDescriptor.getClass();
        serializationStrategy.getClass();
        this.tagStack.add(getTag(serialDescriptor, i));
        encodeSerializableValue(serializationStrategy, obj);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj) {
        String strClassDiscriminator;
        SerializationStrategy serializationStrategyFindPolymorphicSerializer;
        serializationStrategy.getClass();
        Object objLastOrNull = CollectionsKt.lastOrNull(this.tagStack);
        Json json = this.json;
        if (objLastOrNull == null) {
            SerialDescriptor serialDescriptorCarrierDescriptor = WriteModeKt.carrierDescriptor(serializationStrategy.getDescriptor(), json.serializersModule);
            if ((serialDescriptorCarrierDescriptor.getKind() instanceof PrimitiveKind$INT) || serialDescriptorCarrierDescriptor.getKind() == SerialKind$ENUM.INSTANCE) {
                new JsonTreeEncoder(json, this.nodeConsumer, (byte) 1).encodeSerializableValue(serializationStrategy, obj);
                return;
            }
        }
        boolean z = serializationStrategy instanceof AbstractPolymorphicSerializer;
        ClassDiscriminatorMode classDiscriminatorMode = json.configuration.classDiscriminatorMode;
        if (!z) {
            int iOrdinal = classDiscriminatorMode.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    Okio__OkioKt kind = serializationStrategy.getDescriptor().getKind();
                    strClassDiscriminator = (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$3)) ? WriteModeKt.classDiscriminator(serializationStrategy.getDescriptor(), json) : null;
                } else if (iOrdinal != 2) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return;
                }
            }
        } else if (classDiscriminatorMode != ClassDiscriminatorMode.NONE) {
        }
        if (z) {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
            if (obj == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m("Value for serializer ", abstractPolymorphicSerializer.getDescriptor(), " should always be non-null. Please report issue to the kotlinx.serialization tracker.");
                return;
            }
            serializationStrategyFindPolymorphicSerializer = EntryPoints.findPolymorphicSerializer(abstractPolymorphicSerializer, this, obj);
        } else {
            serializationStrategyFindPolymorphicSerializer = serializationStrategy;
        }
        if (strClassDiscriminator != null) {
            WriteModeKt.checkEncodingConflicts(json, serializationStrategy, serializationStrategyFindPolymorphicSerializer, strClassDiscriminator);
            WriteModeKt.checkKind(serializationStrategyFindPolymorphicSerializer.getDescriptor().getKind());
            String serialName = serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName();
            this.polymorphicDiscriminator = strClassDiscriminator;
            this.polymorphicSerialName = serialName;
        }
        serializationStrategyFindPolymorphicSerializer.serialize(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        String str = (String) popTag();
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Short.valueOf(s)));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor serialDescriptor, int i, short s) {
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(Short.valueOf(s)));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String str) {
        str.getClass();
        String str2 = (String) popTag();
        str2.getClass();
        putElement(str2, JsonElementKt.JsonPrimitive(str));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        serialDescriptor.getClass();
        str.getClass();
        putElement(getTag(serialDescriptor, i), JsonElementKt.JsonPrimitive(str));
    }

    public final void encodeTaggedDouble(Object obj, double d) {
        String str = (String) obj;
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Double.valueOf(d)));
        if (!this.configuration.allowSpecialFloatingPointValues && Math.abs(d) > Double.MAX_VALUE) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Double.valueOf(d), str);
        }
    }

    public final void encodeTaggedFloat(float f, Object obj) {
        String str = (String) obj;
        str.getClass();
        putElement(str, JsonElementKt.JsonPrimitive(Float.valueOf(f)));
        if (!this.configuration.allowSpecialFloatingPointValues && Math.abs(f) > Float.MAX_VALUE) {
            throw WriteModeKt.InvalidFloatingPointEncoded(Float.valueOf(f), str);
        }
    }

    public final Encoder encodeTaggedInline(Object obj, SerialDescriptor serialDescriptor) {
        String str = (String) obj;
        str.getClass();
        serialDescriptor.getClass();
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1(this, str);
        }
        if (serialDescriptor.isInline() && serialDescriptor.equals(JsonElementKt.jsonUnquotedLiteralDescriptor)) {
            return new AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1(this, str, serialDescriptor);
        }
        this.tagStack.add(str);
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        if (!this.tagStack.isEmpty()) {
            popTag();
        }
        this.nodeConsumer.invoke(getCurrent());
    }

    public JsonElement getCurrent() {
        switch (this.$r8$classId) {
            case 0:
                return new JsonObject((LinkedHashMap) this.content);
            case 1:
                JsonElement jsonElement = (JsonElement) this.content;
                if (jsonElement != null) {
                    return jsonElement;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?");
                return null;
            default:
                return new JsonArray((ArrayList) this.content);
        }
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json getJson() {
        return this.json;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final SerializersModule getSerializersModule() {
        return this.json.serializersModule;
    }

    public final String getTag(SerialDescriptor serialDescriptor, int i) {
        String strValueOf;
        serialDescriptor.getClass();
        byte b = this.$r8$classId;
        serialDescriptor.getClass();
        switch (b) {
            case 2:
                strValueOf = String.valueOf(i);
                break;
            default:
                WriteModeKt.namingStrategy(serialDescriptor, this.json);
                strValueOf = serialDescriptor.getElementName(i);
                break;
        }
        strValueOf.getClass();
        return strValueOf;
    }

    public final Object popTag() {
        ArrayList arrayList = this.tagStack;
        if (arrayList.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        return arrayList.remove(arrayList.size() - 1);
    }

    public void putElement(String str, JsonElement jsonElement) {
        byte b = this.$r8$classId;
        str.getClass();
        jsonElement.getClass();
        switch (b) {
            case 0:
                ((LinkedHashMap) this.content).put(str, jsonElement);
                break;
            case 1:
                if (str != "primitive") {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("This output can only consume primitives with 'primitive' tag");
                } else if (((JsonElement) this.content) != null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Primitive element was already recorded. Does call to .encodeXxx happen more than once?");
                } else {
                    this.content = jsonElement;
                    this.nodeConsumer.invoke(jsonElement);
                }
                break;
            default:
                ((ArrayList) this.content).add(Integer.parseInt(str), jsonElement);
                break;
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return this.configuration.encodeDefaults;
    }

    public JsonTreeEncoder(Json json, Function1 function1, int i) {
        this.tagStack = new ArrayList();
        this.json = json;
        this.nodeConsumer = function1;
        this.configuration = json.configuration;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeNotNullMark() {
    }
}
