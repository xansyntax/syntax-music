package kotlinx.serialization.json;

import kotlin.ULong;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.json.internal.WriteModeKt;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonLiteralSerializer implements KSerializer {
    public static final JsonLiteralSerializer INSTANCE = new JsonLiteralSerializer();
    public static final PrimitiveSerialDescriptor descriptor = StringsKt__IndentKt.PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral");

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        JsonDecoder jsonDecoderAsJsonDecoder = CollectionsKt__IterablesKt.asJsonDecoder(decoder);
        JsonElement jsonElementDecodeJsonElement = jsonDecoderAsJsonDecoder.decodeJsonElement();
        if (jsonElementDecodeJsonElement instanceof JsonLiteral) {
            return (JsonLiteral) jsonElementDecodeJsonElement;
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()), null, null, jsonDecoderAsJsonDecoder.getJson().configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementDecodeJsonElement.toString(), -1).toString() : null));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Boolean bool;
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        jsonLiteral.getClass();
        String str = jsonLiteral.content;
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        if (jsonLiteral.isString) {
            encoder.encodeString(str);
            return;
        }
        SerialDescriptor serialDescriptor = jsonLiteral.coerceToInlineType;
        if (serialDescriptor != null) {
            encoder.encodeInline(serialDescriptor).encodeString(str);
            return;
        }
        Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(str);
        if (longOrNull != null) {
            encoder.encodeLong(longOrNull.longValue());
            return;
        }
        ULong uLongOrNull = Okio__OkioKt.toULongOrNull(str);
        if (uLongOrNull != null) {
            encoder.encodeInline(ULongSerializer.descriptor).encodeLong(uLongOrNull.data);
            return;
        }
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str);
        if (doubleOrNull != null) {
            encoder.encodeDouble(doubleOrNull.doubleValue());
            return;
        }
        if (str.equals("true")) {
            bool = Boolean.TRUE;
        } else {
            bool = str.equals("false") ? Boolean.FALSE : null;
        }
        if (bool != null) {
            encoder.encodeBoolean(bool.booleanValue());
        } else {
            encoder.encodeString(str);
        }
    }
}
