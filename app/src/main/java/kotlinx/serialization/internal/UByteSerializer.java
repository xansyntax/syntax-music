package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UByteSerializer implements KSerializer {
    public static final UByteSerializer INSTANCE = new UByteSerializer();
    public static final InlineClassDescriptor descriptor = EnumsKt.InlinePrimitiveDescriptor("kotlin.UByte", ByteSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return new UByte(decoder.decodeInline(descriptor).decodeByte());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeInline(descriptor).encodeByte(((UByte) obj).data);
    }
}
