package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NullableSerializer implements KSerializer {
    public final SerialDescriptorForNullable descriptor;
    public final KSerializer serializer;

    public NullableSerializer(KSerializer kSerializer) {
        kSerializer.getClass();
        this.serializer = kSerializer;
        this.descriptor = new SerialDescriptorForNullable(kSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return decoder.decodeNotNullMark() ? decoder.decodeSerializableValue(this.serializer) : decoder.decodeNull();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && NullableSerializer.class == obj.getClass() && Intrinsics.areEqual(this.serializer, ((NullableSerializer) obj).serializer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final int hashCode() {
        return this.serializer.hashCode();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        if (obj == null) {
            encoder.encodeNull();
        } else {
            encoder.encodeNotNullMark();
            encoder.encodeSerializableValue(this.serializer, obj);
        }
    }
}
