package kotlinx.serialization.encoding;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    public static /* synthetic */ Object decodeSerializableValue$default(AbstractDecoder abstractDecoder, DeserializationStrategy deserializationStrategy, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
            return null;
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        return abstractDecoder.decodeSerializableValue(deserializationStrategy, obj);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return this;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Boolean) objDecodeValue).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean decodeBooleanElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeBoolean();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract byte decodeByte();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte decodeByteElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeByte();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Character) objDecodeValue).charValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char decodeCharElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeChar();
    }

    public int decodeCollectionSize(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return -1;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double decodeDoubleElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeDouble();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return ((Float) objDecodeValue).floatValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float decodeFloatElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeFloat();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder decodeInlineElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeInline(serialDescriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract int decodeInt();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int decodeIntElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeInt();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract long decodeLong();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long decodeLongElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeLong();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final <T> T decodeNullableSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, T t) {
        serialDescriptor.getClass();
        deserializationStrategy.getClass();
        return (deserializationStrategy.getDescriptor().isNullable() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializationStrategy, t) : (T) decodeNull();
    }

    public <T> T decodeNullableSerializableValue(DeserializationStrategy deserializationStrategy) {
        deserializationStrategy.getClass();
        return (deserializationStrategy.getDescriptor().isNullable() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializationStrategy) : (T) decodeNull();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public /* bridge */ boolean decodeSequentially() {
        return false;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public <T> T decodeSerializableElement(SerialDescriptor serialDescriptor, int i, DeserializationStrategy deserializationStrategy, T t) {
        serialDescriptor.getClass();
        deserializationStrategy.getClass();
        return (T) decodeSerializableValue(deserializationStrategy, t);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy deserializationStrategy) {
        deserializationStrategy.getClass();
        return (T) deserializationStrategy.deserialize(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public abstract short decodeShort();

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short decodeShortElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeShort();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        objDecodeValue.getClass();
        return (String) objDecodeValue;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String decodeStringElement(SerialDescriptor serialDescriptor, int i) {
        serialDescriptor.getClass();
        return decodeString();
    }

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor serialDescriptor) {
        serialDescriptor.getClass();
    }

    public <T> T decodeSerializableValue(DeserializationStrategy deserializationStrategy, T t) {
        deserializationStrategy.getClass();
        return (T) decodeSerializableValue(deserializationStrategy);
    }
}
