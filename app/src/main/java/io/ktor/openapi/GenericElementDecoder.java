package io.ktor.openapi;

import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.modules.SerializersModule;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H$¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\t\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0014H\u0096\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0017H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u001aH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u00020 H\u0096\u0080\u0004¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020#H\u0096\u0080\u0004¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020(2\u0006\u0010'\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0004H\u0004¢\u0006\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u00102R\u0015\u00106\u001a\u0002038&X¦\u0084\b¢\u0006\u0006\u001a\u0004\b4\u00105R\u0013\u00108\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b7\u0010\u0006¨\u00069"}, d2 = {"Lio/ktor/openapi/GenericElementDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "<init>", "()V", "Lio/ktor/openapi/GenericElement;", "asElement", "()Lio/ktor/openapi/GenericElement;", "getCurrentElement", "", "decodeBoolean", "()Z", "", "decodeByte", "()B", "", "decodeShort", "()S", "", "decodeInt", "()I", "", "decodeLong", "()J", "", "decodeFloat", "()F", "", "decodeDouble", "()D", "", "decodeChar", "()C", "", "decodeString", "()Ljava/lang/String;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "enumDescriptor", "decodeEnum", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "descriptor", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "element", "createNestedDecoder", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lio/ktor/openapi/GenericElement;)Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "I", "getIndex", "setIndex", "(I)V", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "getCurrent", "current", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class GenericElementDecoder extends AbstractDecoder {
    private int index;

    public abstract GenericElement asElement();

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        descriptor.getClass();
        return this.index == 0 ? this : createNestedDecoder(descriptor, getCurrentElement());
    }

    public final CompositeDecoder createNestedDecoder(SerialDescriptor descriptor, GenericElement element) {
        descriptor.getClass();
        element.getClass();
        Okio__OkioKt kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$3)) {
            return new GenericElementClassDecoder(MapsKt__MapsKt.toMap(element.entries()), getSerializersModule());
        }
        if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
            return new GenericElementMapDecoder(element.entries(), getSerializersModule());
        }
        return Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$2) ? new GenericElementListDecoder(element, getSerializersModule()) : this;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return ((Boolean) getCurrentElement().deserialize(BooleanSerializer.INSTANCE)).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        return ((Number) getCurrentElement().deserialize(ByteSerializer.INSTANCE)).byteValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        return ((Character) getCurrentElement().deserialize(CharSerializer.INSTANCE)).charValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        return ((Number) getCurrentElement().deserialize(DoubleSerializer.INSTANCE)).doubleValue();
    }

    public abstract /* synthetic */ int decodeElementIndex(SerialDescriptor serialDescriptor);

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        enumDescriptor.getClass();
        return enumDescriptor.getElementIndex(decodeString());
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        return ((Number) getCurrentElement().deserialize(FloatSerializer.INSTANCE)).floatValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        return ((Number) getCurrentElement().deserialize(IntSerializer.INSTANCE)).intValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return ((Number) getCurrentElement().deserialize(LongSerializer.INSTANCE)).longValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        return ((Number) getCurrentElement().deserialize(ShortSerializer.INSTANCE)).shortValue();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        return (String) getCurrentElement().deserialize(StringSerializer.INSTANCE);
    }

    public final GenericElement getCurrent() {
        if (this.index > 0) {
            return getCurrentElement();
        }
        return null;
    }

    public abstract GenericElement getCurrentElement();

    public final int getIndex() {
        return this.index;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public abstract SerializersModule getSerializersModule();

    public final void setIndex(int i) {
        this.index = i;
    }
}
