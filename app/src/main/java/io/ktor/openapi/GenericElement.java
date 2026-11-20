package io.ktor.openapi;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.PrimitiveKind$INT;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J#\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00000\r0\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\fH&¢\u0006\u0004\b\u0011\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lio/ktor/openapi/GenericElement;", "", "", "isObject", "()Z", "isArray", "isString", "T", "Lkotlinx/serialization/DeserializationStrategy;", "serializer", "deserialize", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Pair;", "", "entries", "()Ljava/util/List;", "items", "other", "plus", "(Lio/ktor/openapi/GenericElement;)Lio/ktor/openapi/GenericElement;", "Lkotlinx/serialization/KSerializer;", "getElementSerializer", "()Lkotlinx/serialization/KSerializer;", "elementSerializer", "getElement", "()Ljava/lang/Object;", "element", "Companion", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = GenericElementSerializer.class)
public interface GenericElement {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\t\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/openapi/GenericElement$Companion;", "", "<init>", "()V", "Lio/ktor/openapi/GenericElement;", "orEmpty", "(Lio/ktor/openapi/GenericElement;)Lio/ktor/openapi/GenericElement;", "T", "Lkotlinx/serialization/KSerializer;", "serializer", "item", "encodeToElement", "(Lkotlinx/serialization/KSerializer;Ljava/lang/Object;)Lio/ktor/openapi/GenericElement;", "()Lkotlinx/serialization/KSerializer;", "EmptyObject", "Lio/ktor/openapi/GenericElement;", "getEmptyObject", "()Lio/ktor/openapi/GenericElement;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final GenericElement EmptyObject = new GenericElementMap(EmptyMap.INSTANCE, HexFormatKt.MapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer()));

        private Companion() {
        }

        public final <T> GenericElement encodeToElement(KSerializer serializer, T item) {
            serializer.getClass();
            GenericElementEncoder genericElementEncoderElementEncoder$ktor_openapi_schema = GenericElementEncoder.INSTANCE.elementEncoder$ktor_openapi_schema(serializer);
            genericElementEncoderElementEncoder$ktor_openapi_schema.encodeSerializableValue(serializer, item);
            return genericElementEncoderElementEncoder$ktor_openapi_schema.build();
        }

        public final GenericElement getEmptyObject() {
            return EmptyObject;
        }

        public final GenericElement orEmpty(GenericElement genericElement) {
            return genericElement == null ? EmptyObject : genericElement;
        }

        public final KSerializer serializer() {
            return new GenericElementSerializer();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isArray(GenericElement genericElement) {
            return GenericElement.super.isArray();
        }

        @Deprecated
        public static boolean isObject(GenericElement genericElement) {
            return GenericElement.super.isObject();
        }

        @Deprecated
        public static boolean isString(GenericElement genericElement) {
            return GenericElement.super.isString();
        }

        @Deprecated
        public static GenericElement plus(GenericElement genericElement, GenericElement genericElement2) {
            genericElement2.getClass();
            return GenericElement.super.plus(genericElement2);
        }
    }

    <T> T deserialize(DeserializationStrategy serializer);

    List<Pair> entries();

    Object getElement();

    KSerializer getElementSerializer();

    default boolean isArray() {
        return Intrinsics.areEqual(getElementSerializer().getDescriptor().getKind(), StructureKind$MAP.INSTANCE$2);
    }

    default boolean isObject() {
        return Intrinsics.areEqual(getElementSerializer().getDescriptor().getKind(), StructureKind$MAP.INSTANCE$3) || Intrinsics.areEqual(getElementSerializer().getDescriptor().getKind(), StructureKind$MAP.INSTANCE);
    }

    default boolean isString() {
        return Intrinsics.areEqual(getElementSerializer().getDescriptor().getKind(), PrimitiveKind$INT.INSTANCE$8);
    }

    List<GenericElement> items();

    /* JADX WARN: Multi-variable type inference failed */
    default GenericElement plus(GenericElement other) {
        other.getClass();
        return new GenericElementMap(MapsKt__MapsKt.toMap(CollectionsKt.plus((Iterable) other.entries(), (Collection) entries())), null, 2, 0 == true ? 1 : 0);
    }
}
