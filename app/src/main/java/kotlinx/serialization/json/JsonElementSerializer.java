package kotlinx.serialization.json;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind$OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonElementSerializer implements KSerializer {
    public static final JsonElementSerializer INSTANCE = new JsonElementSerializer();
    public static final SerialDescriptorImpl descriptor = StringsKt__IndentKt.buildSerialDescriptor("kotlinx.serialization.json.JsonElement", PolymorphicKind$OPEN.INSTANCE$1, new SerialDescriptor[0], new InstantKt$$ExternalSyntheticLambda0((byte) 28));

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return CollectionsKt__IterablesKt.asJsonDecoder(decoder).decodeJsonElement();
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        JsonElement jsonElement = (JsonElement) obj;
        jsonElement.getClass();
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        if (jsonElement instanceof JsonPrimitive) {
            encoder.encodeSerializableValue(JsonPrimitiveSerializer.INSTANCE, jsonElement);
            return;
        }
        if (jsonElement instanceof JsonObject) {
            encoder.encodeSerializableValue(JsonObjectSerializer.INSTANCE, jsonElement);
        } else if (jsonElement instanceof JsonArray) {
            encoder.encodeSerializableValue(JsonArraySerializer.INSTANCE, jsonElement);
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$1();
        }
    }
}
