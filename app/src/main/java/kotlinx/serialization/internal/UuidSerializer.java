package kotlinx.serialization.internal;

import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UuidSerializer implements KSerializer {
    public static final UuidSerializer INSTANCE = new UuidSerializer();
    public static final PrimitiveSerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.uuid.Uuid", PrimitiveKind$INT.INSTANCE$8);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return CollectionsKt__IterablesKt.parse(decoder.decodeString());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Uuid uuid = (Uuid) obj;
        uuid.getClass();
        encoder.encodeString(uuid.toString());
    }
}
