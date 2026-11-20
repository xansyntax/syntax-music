package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class UShortSerializer implements KSerializer {
    public static final UShortSerializer INSTANCE = new UShortSerializer();
    public static final InlineClassDescriptor descriptor = EnumsKt.InlinePrimitiveDescriptor("kotlin.UShort", ShortSerializer.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        return new UShort(decoder.decodeInline(descriptor).decodeShort());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        encoder.encodeInline(descriptor).encodeShort(((UShort) obj).data);
    }
}
