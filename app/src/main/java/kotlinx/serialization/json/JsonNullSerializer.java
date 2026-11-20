package kotlinx.serialization.json;

import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialKind$ENUM;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class JsonNullSerializer implements KSerializer {
    public static final JsonNullSerializer INSTANCE = new JsonNullSerializer();
    public static final SerialDescriptorImpl descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("kotlinx.serialization.json.JsonNull", SerialKind$ENUM.INSTANCE, new SerialDescriptor[0]);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        CollectionsKt__IterablesKt.asJsonDecoder(decoder);
        if (decoder.decodeNotNullMark()) {
            throw new JsonDecodingException(WriteModeKt.formatDecodingException(-1, "Expected 'null' literal", null, null, null));
        }
        decoder.decodeNull();
        return JsonNull.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ((JsonNull) obj).getClass();
        CollectionsKt__IterablesKt.asJsonEncoder(encoder);
        encoder.encodeNull();
    }
}
