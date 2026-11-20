package kotlinx.serialization.json;

import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonPrimitiveSerializer implements KSerializer {
    public static final JsonPrimitiveSerializer INSTANCE = new JsonPrimitiveSerializer();
    public static final SerialDescriptorImpl descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind$INT.INSTANCE$8, new SerialDescriptor[0]);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        JsonDecoder jsonDecoderAsJsonDecoder = CollectionsKt__IterablesKt.asJsonDecoder(decoder);
        JsonElement jsonElementDecodeJsonElement = jsonDecoderAsJsonDecoder.decodeJsonElement();
        if (jsonElementDecodeJsonElement instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementDecodeJsonElement;
        }
        throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()), null, null, jsonDecoderAsJsonDecoder.getJson().configuration.exceptionsWithDebugInfo ? WriteModeKt.minify(jsonElementDecodeJsonElement.toString(), -1).toString() : null));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        jsonPrimitive.getClass();
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        if (jsonPrimitive instanceof JsonNull) {
            encoder.encodeSerializableValue(JsonNullSerializer.INSTANCE, JsonNull.INSTANCE);
        } else {
            encoder.encodeSerializableValue(JsonLiteralSerializer.INSTANCE, (JsonLiteral) jsonPrimitive);
        }
    }
}
