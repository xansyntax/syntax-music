package kotlinx.serialization.internal;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class NoOpEncoder extends AbstractEncoder {
    public static final NoOpEncoder INSTANCE = new NoOpEncoder();
    public static final SerialModuleImpl serializersModule = SerializersModuleKt.EmptySerializersModule;

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeString(String str) {
        str.getClass();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public final void encodeValue(Object obj) {
        obj.getClass();
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final SerializersModule getSerializersModule() {
        return serializersModule;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeNull() {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
    }
}
