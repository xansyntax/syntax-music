package io.ktor.openapi;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/openapi/GenericElementClassDecoder;", "Lio/ktor/openapi/GenericElementDecoder;", "", "", "Lio/ktor/openapi/GenericElement;", "map", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Ljava/util/Map;Lkotlinx/serialization/modules/SerializersModule;)V", "asElement", "()Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "", "decodeNotNullMark", "()Z", "getCurrentElement", "Lkotlinx/serialization/encoding/CompositeDecoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/CompositeDecoder;", "Ljava/util/Map;", "getMap$ktor_openapi_schema", "()Ljava/util/Map;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentElementName", "Ljava/lang/String;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementClassDecoder extends GenericElementDecoder {
    private String currentElementName;
    private final Map<String, GenericElement> map;
    private final SerializersModule serializersModule;

    /* JADX WARN: Multi-variable type inference failed */
    public GenericElementClassDecoder(Map<String, ? extends GenericElement> map, SerializersModule serializersModule) {
        map.getClass();
        serializersModule.getClass();
        this.map = map;
        this.serializersModule = serializersModule;
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement asElement() {
        return new GenericElementMap(this.map, null, 2, null);
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        descriptor.getClass();
        String str = this.currentElementName;
        if (str == null) {
            return this;
        }
        return !this.map.containsKey(str) ? new GenericElementMapDecoder(EmptyList.INSTANCE, getSerializersModule()) : createNestedDecoder(descriptor, getCurrentElement());
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        descriptor.getClass();
        if (getIndex() >= descriptor.getElementsCount()) {
            return -1;
        }
        while (getIndex() < descriptor.getElementsCount()) {
            String elementName = descriptor.getElementName(getIndex());
            int index = getIndex();
            setIndex(index + 1);
            if (this.map.containsKey(elementName)) {
                this.currentElementName = elementName;
                return index;
            }
            if (!descriptor.isElementOptional(index)) {
                return -1;
            }
        }
        return -1;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        String str = this.currentElementName;
        if (str != null) {
            return this.map.containsKey(str);
        }
        return false;
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement getCurrentElement() {
        String str = this.currentElementName;
        if (str == null) {
            throw new SerializationException("No current element - decoder in invalid state");
        }
        GenericElement genericElement = this.map.get(str);
        if (genericElement != null) {
            return genericElement;
        }
        throw new SerializationException(IntIntPair$$ExternalSyntheticOutline0.m("Element '", str, "' not found in map"));
    }

    public final Map<String, GenericElement> getMap$ktor_openapi_schema() {
        return this.map;
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public GenericElementClassDecoder(Map map, SerializersModule serializersModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? SerializersModuleKt.EmptySerializersModule : serializersModule);
    }
}
