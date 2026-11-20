package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.NoOpEncoder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public /* bridge */ CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return super.beginCollection(serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        encodeValue(Boolean.valueOf(z));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor serialDescriptor, int i, boolean z) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeBoolean(z);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        encodeValue(Byte.valueOf(b));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor serialDescriptor, int i, byte b) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeValue(Character.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor serialDescriptor, int i, char c) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        encodeValue(Double.valueOf(d));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor serialDescriptor, int i, double d) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeDouble(d);
        }
    }

    public boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        encodeValue(Float.valueOf(f));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor serialDescriptor, int i, float f) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return encodeElement(serialDescriptor, i) ? encodeInline(serialDescriptor.getElementDescriptor(i)) : NoOpEncoder.INSTANCE;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor serialDescriptor, int i, int i2) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeInt(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        encodeValue(Long.valueOf(j));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor serialDescriptor, int i, long j) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeLong(j);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, T t) {
        serialDescriptor.getClass();
        serializationStrategy.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeNullableSerializableValue(serializationStrategy, t);
        }
    }

    public <T> void encodeNullableSerializableValue(SerializationStrategy serializationStrategy, T t) {
        serializationStrategy.getClass();
        if (serializationStrategy.getDescriptor().isNullable()) {
            encodeSerializableValue(serializationStrategy, t);
        } else if (t == null) {
            encodeNull();
        } else {
            encodeNotNullMark();
            encodeSerializableValue(serializationStrategy, t);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public <T> void encodeSerializableElement(SerialDescriptor serialDescriptor, int i, SerializationStrategy serializationStrategy, T t) {
        serialDescriptor.getClass();
        serializationStrategy.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeSerializableValue(serializationStrategy, t);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy serializationStrategy, T t) {
        serializationStrategy.getClass();
        serializationStrategy.serialize(this, t);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        encodeValue(Short.valueOf(s));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor serialDescriptor, int i, short s) {
        serialDescriptor.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeShort(s);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String str) {
        str.getClass();
        encodeValue(str);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor serialDescriptor, int i, String str) {
        serialDescriptor.getClass();
        str.getClass();
        if (encodeElement(serialDescriptor, i)) {
            encodeString(str);
        }
    }

    public void encodeValue(Object obj) {
        obj.getClass();
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(obj.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public /* bridge */ void encodeNotNullMark() {
    }
}
