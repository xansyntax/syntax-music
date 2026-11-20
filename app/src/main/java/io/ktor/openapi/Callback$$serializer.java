package io.ktor.openapi;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"io/ktor/openapi/Callback.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/Callback;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize-ppcp4YM", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/util/Map;", "deserialize", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize-Fy7AELE", "(Lkotlinx/serialization/encoding/Encoder;Ljava/util/Map;)V", "serialize", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class Callback$$serializer implements GeneratedSerializer {
    public static final Callback$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Callback$$serializer callback$$serializer = new Callback$$serializer();
        INSTANCE = callback$$serializer;
        InlineClassDescriptor inlineClassDescriptor = new InlineClassDescriptor("io.ktor.openapi.Callback", callback$$serializer);
        inlineClassDescriptor.addElement("value", false);
        descriptor = inlineClassDescriptor;
    }

    private Callback$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Callback.$childSerializers[0].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Callback.m1749boximpl(m1756deserializeppcp4YM(decoder));
    }

    /* JADX INFO: renamed from: deserialize-ppcp4YM, reason: not valid java name */
    public final Map<String, ? extends PathItem> m1756deserializeppcp4YM(Decoder decoder) {
        decoder.getClass();
        return Callback.m1750constructorimpl((Map) decoder.decodeInline(descriptor).decodeSerializableValue(new HashMapSerializer(StringSerializer.INSTANCE, PathItem.Companion.Serializer.INSTANCE, (byte) 1)));
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m1757serializeFy7AELE(encoder, ((Callback) obj).getValue());
    }

    /* JADX INFO: renamed from: serialize-Fy7AELE, reason: not valid java name */
    public final void m1757serializeFy7AELE(Encoder encoder, Map<String, ? extends PathItem> value) {
        encoder.getClass();
        value.getClass();
        Encoder encoderEncodeInline = encoder.encodeInline(descriptor);
        if (encoderEncodeInline == null) {
            return;
        }
        encoderEncodeInline.encodeSerializableValue(new HashMapSerializer(StringSerializer.INSTANCE, PathItem.Companion.Serializer.INSTANCE, (byte) 1), value);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
