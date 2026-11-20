package io.ktor.openapi;

import coil3.network.HttpException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.HashSetSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00120\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lio/ktor/openapi/GenericElementList;", "Lio/ktor/openapi/GenericElement;", "", "element", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Ljava/util/List;Lkotlinx/serialization/KSerializer;)V", "", "isArray", "()Z", "items", "()Ljava/util/List;", "T", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlin/Pair;", "", "entries", "Ljava/util/List;", "getElement", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementList implements GenericElement {
    private final List<GenericElement> element;
    private final KSerializer elementSerializer;

    public /* synthetic */ GenericElementList(List list, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new HashSetSerializer(GenericElement.INSTANCE.serializer(), (byte) 1) : kSerializer);
    }

    @Override // io.ktor.openapi.GenericElement
    public <T> T deserialize(DeserializationStrategy serializer) {
        serializer.getClass();
        return (T) serializer.deserialize(new GenericElementListDecoder(this, null, 2, null));
    }

    @Override // io.ktor.openapi.GenericElement
    public List<Pair> entries() {
        GenericElementKt.serialError("Cannot get entries for a list");
        throw new HttpException();
    }

    @Override // io.ktor.openapi.GenericElement
    public KSerializer getElementSerializer() {
        return this.elementSerializer;
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isArray() {
        return true;
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isObject() {
        return super.isObject();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isString() {
        return super.isString();
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> items() {
        return getElement();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ GenericElement plus(GenericElement genericElement) {
        return super.plus(genericElement);
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> getElement() {
        return this.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GenericElementList(List<? extends GenericElement> list, KSerializer kSerializer) {
        list.getClass();
        kSerializer.getClass();
        this.element = list;
        this.elementSerializer = kSerializer;
    }
}
