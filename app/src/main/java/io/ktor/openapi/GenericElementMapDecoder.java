package io.ktor.openapi;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0012R,\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/openapi/GenericElementMapDecoder;", "Lio/ktor/openapi/GenericElementDecoder;", "", "Lkotlin/Pair;", "", "Lio/ktor/openapi/GenericElement;", "entries", "Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Ljava/util/List;Lkotlinx/serialization/modules/SerializersModule;)V", "asElement", "()Lio/ktor/openapi/GenericElement;", "getCurrentElement", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "decodeElementIndex", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeCollectionSize", "Ljava/util/List;", "getEntries$ktor_openapi_schema", "()Ljava/util/List;", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementMapDecoder extends GenericElementDecoder {
    private final List<Pair> entries;
    private final SerializersModule serializersModule;

    /* JADX WARN: Multi-variable type inference failed */
    public GenericElementMapDecoder(List<? extends Pair> list, SerializersModule serializersModule) {
        list.getClass();
        serializersModule.getClass();
        this.entries = list;
        this.serializersModule = serializersModule;
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement asElement() {
        return GenericElementKt.GenericElement((Collection<? extends Pair>) this.entries);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeCollectionSize(SerialDescriptor descriptor) {
        descriptor.getClass();
        return this.entries.size() * 2;
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        descriptor.getClass();
        if (getIndex() >= this.entries.size() * 2) {
            return -1;
        }
        int index = getIndex();
        setIndex(index + 1);
        return index;
    }

    @Override // io.ktor.openapi.GenericElementDecoder
    public GenericElement getCurrentElement() {
        int index = getIndex() - 1;
        boolean z = index % 2 == 0;
        Pair pair = this.entries.get(index / 2);
        return z ? new GenericElementString((String) pair.first, null, 2, null) : (GenericElement) pair.second;
    }

    public final List<Pair> getEntries$ktor_openapi_schema() {
        return this.entries;
    }

    @Override // io.ktor.openapi.GenericElementDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public GenericElementMapDecoder(List list, SerializersModule serializersModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? SerializersModuleKt.EmptySerializersModule : serializersModule);
    }
}
