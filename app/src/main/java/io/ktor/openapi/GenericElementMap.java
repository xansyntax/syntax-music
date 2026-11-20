package io.ktor.openapi;

import coil3.network.HttpException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00120\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lio/ktor/openapi/GenericElementMap;", "Lio/ktor/openapi/GenericElement;", "", "", "element", "Lkotlinx/serialization/KSerializer;", "elementSerializer", "<init>", "(Ljava/util/Map;Lkotlinx/serialization/KSerializer;)V", "", "isObject", "()Z", "T", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "entries", "()Ljava/util/List;", "items", "Ljava/util/Map;", "getElement", "()Ljava/util/Map;", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GenericElementMap implements GenericElement {
    private final Map<String, GenericElement> element;
    private final KSerializer elementSerializer;

    public /* synthetic */ GenericElementMap(Map map, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? new HashMapSerializer(StringSerializer.INSTANCE, GenericElement.INSTANCE.serializer(), (byte) 1) : kSerializer);
    }

    @Override // io.ktor.openapi.GenericElement
    public <T> T deserialize(DeserializationStrategy serializer) {
        serializer.getClass();
        Okio__OkioKt kind = serializer.getDescriptor().getKind();
        if (Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$1) || Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE$3)) {
            return (T) serializer.deserialize(new GenericElementClassDecoder(getElement(), null, 2, null));
        }
        if (!Intrinsics.areEqual(kind, StructureKind$MAP.INSTANCE)) {
            GenericElementKt.serialError("Cannot deserialize map to " + serializer.getDescriptor().getSerialName());
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2();
            return null;
        }
        Set<Map.Entry<String, GenericElement>> setEntrySet = getElement().entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        return (T) serializer.deserialize(new GenericElementMapDecoder(arrayList, null, 2, null));
    }

    @Override // io.ktor.openapi.GenericElement
    public List<Pair> entries() {
        Set<Map.Entry<String, GenericElement>> setEntrySet = getElement().entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Pair(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    @Override // io.ktor.openapi.GenericElement
    public KSerializer getElementSerializer() {
        return this.elementSerializer;
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isArray() {
        return super.isArray();
    }

    @Override // io.ktor.openapi.GenericElement
    public boolean isObject() {
        return true;
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ boolean isString() {
        return super.isString();
    }

    @Override // io.ktor.openapi.GenericElement
    public List<GenericElement> items() {
        GenericElementKt.serialError("Cannot get items for a map");
        throw new HttpException();
    }

    @Override // io.ktor.openapi.GenericElement
    public /* bridge */ GenericElement plus(GenericElement genericElement) {
        return super.plus(genericElement);
    }

    @Override // io.ktor.openapi.GenericElement
    public Map<String, GenericElement> getElement() {
        return this.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GenericElementMap(Map<String, ? extends GenericElement> map, KSerializer kSerializer) {
        map.getClass();
        kSerializer.getClass();
        this.element = map;
        this.elementSerializer = kSerializer;
    }
}
