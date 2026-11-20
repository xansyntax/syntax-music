package kotlinx.serialization.encoding;

import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Encoder {
    default CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return beginStructure(serialDescriptor);
    }

    CompositeEncoder beginStructure(SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(SerialDescriptor serialDescriptor, int i);

    void encodeFloat(float f);

    Encoder encodeInline(SerialDescriptor serialDescriptor);

    void encodeInt(int i);

    void encodeLong(long j);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj);

    void encodeShort(short s);

    void encodeString(String str);

    SerializersModule getSerializersModule();
}
