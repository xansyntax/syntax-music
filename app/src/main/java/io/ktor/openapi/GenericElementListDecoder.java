package io.ktor.openapi;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\tR\u001b\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/openapi/GenericElementListDecoder;", "Lio/ktor/openapi/GenericElementDecoder;", "Lio/ktor/openapi/GenericElement;", "listElement", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lio/ktor/openapi/GenericElement;Lkotlinx/serialization/modules/SerializersModule;)V", "asElement", "()Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeCollectionSize", "getCurrentElement", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "", "elements", "Ljava/util/List;", "getElements$ktor_openapi_schema", "()Ljava/util/List;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementListDecoder extends GenericElementDecoder {
    private final List<GenericElement> elements;
    private final SerializersModule serializersModule;

    public GenericElementListDecoder(GenericElement genericElement, SerializersModule serializersModule) {
        genericElement.getClass();
        serializersModule.getClass();
        this.serializersModule = serializersModule;
        this.elements = genericElement.items();
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement asElement() {
        return new GenericElementList(this.elements, null, 2, null);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(SerialDescriptor descriptor) {
        descriptor.getClass();
        return this.elements.size();
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        descriptor.getClass();
        if (getIndex() >= this.elements.size()) {
            return -1;
        }
        int index = getIndex();
        setIndex(index + 1);
        return index;
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement getCurrentElement() {
        int index = getIndex() - 1;
        if (index >= 0 && index < this.elements.size()) {
            return this.elements.get(index);
        }
        StringBuilder sbM2m = IntIntPair$$ExternalSyntheticOutline0.m2m(index, "Index ", " out of bounds for list of size ");
        sbM2m.append(this.elements.size());
        throw new SerializationException(sbM2m.toString());
    }

    public final List<GenericElement> getElements$ktor_openapi_schema() {
        return this.elements;
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public GenericElementListDecoder(GenericElement genericElement, SerializersModule serializersModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(genericElement, (i & 2) != 0 ? SerializersModuleKt.EmptySerializersModule : serializersModule);
    }
}
