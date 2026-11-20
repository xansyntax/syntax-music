package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000b*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\f\r\u000bJ\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0001\u0010\u00052\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00000\u0006H\u0016¢\u0006\u0004\b\n\u0010\t\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lio/ktor/openapi/ReferenceOr;", "A", "", "valueOrNull", "()Ljava/lang/Object;", "B", "Lkotlin/Function1;", "mappingFunction", "mapValue", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/openapi/ReferenceOr;", "mapToReference", "Companion", "Reference", "Value", "Lio/ktor/openapi/ReferenceOr$Reference;", "Lio/ktor/openapi/ReferenceOr$Value;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public interface ReferenceOr<A> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <A, B> ReferenceOr<B> mapToReference(ReferenceOr<? extends A> referenceOr, Function1 function1) {
            function1.getClass();
            return ReferenceOr.super.mapToReference(function1);
        }

        @Deprecated
        public static <A, B> ReferenceOr<B> mapValue(ReferenceOr<? extends A> referenceOr, Function1 function1) {
            function1.getClass();
            return ReferenceOr.super.mapValue(function1);
        }

        @Deprecated
        public static <A> A valueOrNull(ReferenceOr<? extends A> referenceOr) {
            return (A) ReferenceOr.super.valueOrNull();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default <B> ReferenceOr<B> mapToReference(Function1 mappingFunction) {
        mappingFunction.getClass();
        if (this instanceof Reference) {
            return this;
        }
        if (this instanceof Value) {
            return (ReferenceOr) mappingFunction.invoke(((Value) this).getValue());
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    default <B> ReferenceOr<B> mapValue(Function1 mappingFunction) {
        mappingFunction.getClass();
        if (this instanceof Reference) {
            return this;
        }
        if (this instanceof Value) {
            return Value.m1792boximpl(Value.m1793constructorimpl(mappingFunction.invoke(((Value) this).getValue())));
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    default A valueOrNull() {
        if (this instanceof Reference) {
            return null;
        }
        if (this instanceof Value) {
            return (A) ((Value) this).getValue();
        }
        PathKt$$ExternalSyntheticBUOutline0.m$1();
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0083\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u0006\u0010\f¨\u0006\u001a"}, d2 = {"Lio/ktor/openapi/ReferenceOr$Reference;", "Lio/ktor/openapi/ReferenceOr;", "", "", "ref", "", "isDynamic", "<init>", "(Ljava/lang/String;Z)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "copy", "(Ljava/lang/String;Z)Lio/ktor/openapi/ReferenceOr$Reference;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getRef", "Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Reference implements ReferenceOr {
        private final boolean isDynamic;
        private final String ref;

        public Reference(String str, boolean z) {
            str.getClass();
            this.ref = str;
            this.isDynamic = z;
        }

        public static /* synthetic */ Reference copy$default(Reference reference, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reference.ref;
            }
            if ((i & 2) != 0) {
                z = reference.isDynamic;
            }
            return reference.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRef() {
            return this.ref;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsDynamic() {
            return this.isDynamic;
        }

        public final Reference copy(String ref, boolean isDynamic) {
            ref.getClass();
            return new Reference(ref, isDynamic);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reference)) {
                return false;
            }
            Reference reference = (Reference) other;
            return Intrinsics.areEqual(this.ref, reference.ref) && this.isDynamic == reference.isDynamic;
        }

        public final String getRef() {
            return this.ref;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isDynamic) + (this.ref.hashCode() * 31);
        }

        public final boolean isDynamic() {
            return this.isDynamic;
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ <B> ReferenceOr<B> mapToReference(Function1 function1) {
            return super.mapToReference(function1);
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ <B> ReferenceOr<B> mapValue(Function1 function1) {
            return super.mapValue(function1);
        }

        public String toString() {
            return "Reference(ref=" + this.ref + ", isDynamic=" + this.isDynamic + ')';
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ Void valueOrNull() {
            return (Void) super.valueOrNull();
        }

        public /* synthetic */ Reference(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\u000eJ-\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u000f\"\u0004\b\u0001\u0010\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013¨\u0006\u0019"}, d2 = {"Lio/ktor/openapi/ReferenceOr$Companion;", "", "<init>", "()V", "", ContentDisposition.Parameters.Name, "", "dynamic", "Lio/ktor/openapi/ReferenceOr$Reference;", "schema", "(Ljava/lang/String;Z)Lio/ktor/openapi/ReferenceOr$Reference;", "A", "value", "Lio/ktor/openapi/ReferenceOr;", "(Ljava/lang/Object;)Lio/ktor/openapi/ReferenceOr;", "Lkotlinx/serialization/KSerializer;", "typeSerial0", "serializer", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Ljava/lang/String;", "responses", "parameters", "requestBodies", "pathItems", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String parameters = "#/components/parameters/";
        private static final String pathItems = "#/components/pathItems/";
        private static final String requestBodies = "#/components/requestBodies/";
        private static final String responses = "#/components/responses/";
        private static final String schema = "#/components/schemas/";

        private Companion() {
        }

        public static /* synthetic */ Reference schema$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.schema(str, z);
        }

        public final Reference schema(String name, boolean dynamic) {
            name.getClass();
            return new Reference(schema.concat(name), dynamic);
        }

        public final <A> KSerializer serializer(KSerializer typeSerial0) {
            typeSerial0.getClass();
            return new Serializer(typeSerial0);
        }

        public final <A> ReferenceOr<A> value(A value) {
            return Value.m1792boximpl(Value.m1793constructorimpl(value));
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R!\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0084\b¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lio/ktor/openapi/ReferenceOr$Companion$Serializer;", "T", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/ReferenceOr;", "dataSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/ReferenceOr;)V", "Lio/ktor/openapi/ReferenceOr$Reference;", "encodeReference", "(Lio/ktor/openapi/ReferenceOr$Reference;Lkotlinx/serialization/encoding/Encoder;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/ReferenceOr;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "refDescriptor", "dynamicRefDescriptor", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer<T> implements KSerializer {
            private final KSerializer dataSerializer;
            private final SerialDescriptor descriptor;
            private final SerialDescriptor dynamicRefDescriptor;
            private final SerialDescriptor refDescriptor;

            public Serializer(KSerializer kSerializer) {
                StructureKind$MAP structureKind$MAP = StructureKind$MAP.INSTANCE$1;
                kSerializer.getClass();
                this.dataSerializer = kSerializer;
                this.descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("io.ktor.openapi.ReferenceOr", SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0]);
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
                if (StringsKt.isBlank("io.ktor.openapi.ReferenceOr.ref")) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
                    throw null;
                }
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("io.ktor.openapi.ReferenceOr.ref");
                refDescriptor$lambda$0(classSerialDescriptorBuilder);
                this.refDescriptor = new SerialDescriptorImpl("io.ktor.openapi.ReferenceOr.ref", structureKind$MAP, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
                SerialDescriptor[] serialDescriptorArr2 = new SerialDescriptor[0];
                if (StringsKt.isBlank("io.ktor.openapi.ReferenceOr.dynamicRef")) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
                    throw null;
                }
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder2 = new ClassSerialDescriptorBuilder("io.ktor.openapi.ReferenceOr.dynamicRef");
                dynamicRefDescriptor$lambda$0(classSerialDescriptorBuilder2);
                this.dynamicRefDescriptor = new SerialDescriptorImpl("io.ktor.openapi.ReferenceOr.dynamicRef", structureKind$MAP, classSerialDescriptorBuilder2.elementNames.size(), ArraysKt.toList(serialDescriptorArr2), classSerialDescriptorBuilder2);
            }

            private static final Unit dynamicRefDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                classSerialDescriptorBuilder.getClass();
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                classSerialDescriptorBuilder.element("$dynamicRef", StringSerializer.descriptor);
                return Unit.INSTANCE;
            }

            private final void encodeReference(Reference value, Encoder encoder) {
                if (value.isDynamic()) {
                    SerialDescriptor serialDescriptor = this.dynamicRefDescriptor;
                    CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
                    compositeEncoderBeginStructure.encodeStringElement(this.dynamicRefDescriptor, 0, value.getRef());
                    compositeEncoderBeginStructure.endStructure(serialDescriptor);
                    return;
                }
                SerialDescriptor serialDescriptor2 = this.refDescriptor;
                CompositeEncoder compositeEncoderBeginStructure2 = encoder.beginStructure(serialDescriptor2);
                compositeEncoderBeginStructure2.encodeStringElement(this.refDescriptor, 0, value.getRef());
                compositeEncoderBeginStructure2.endStructure(serialDescriptor2);
            }

            private static final Unit refDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
                classSerialDescriptorBuilder.getClass();
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                classSerialDescriptorBuilder.element("$ref", StringSerializer.descriptor);
                return Unit.INSTANCE;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public ReferenceOr<T> deserialize(Decoder decoder) {
                decoder.getClass();
                decoder.getSerializersModule();
                GenericElement genericElement = (GenericElement) decoder.decodeSerializableValue(GenericElement.INSTANCE.serializer());
                if (!genericElement.isObject()) {
                    return Value.m1792boximpl(Value.m1793constructorimpl(genericElement.deserialize(this.dataSerializer)));
                }
                Map map = MapsKt__MapsKt.toMap(genericElement.entries());
                if (map.containsKey("$ref")) {
                    Object obj = map.get("$ref");
                    obj.getClass();
                    return new Reference((String) ((GenericElement) obj).deserialize(StringSerializer.INSTANCE), false, 2, null);
                }
                if (!map.containsKey("$dynamicRef")) {
                    return Value.m1792boximpl(Value.m1793constructorimpl(genericElement.deserialize(this.dataSerializer)));
                }
                Object obj2 = map.get("$dynamicRef");
                obj2.getClass();
                return new Reference((String) ((GenericElement) obj2).deserialize(StringSerializer.INSTANCE), true);
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor getDescriptor() {
                return this.descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void serialize(Encoder encoder, ReferenceOr<? extends T> value) {
                encoder.getClass();
                value.getClass();
                if (value instanceof Value) {
                    encoder.encodeSerializableValue(this.dataSerializer, ((Value) value).getValue());
                } else if (value instanceof Reference) {
                    encodeReference((Reference) value, encoder);
                } else {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                }
            }

            public static /* synthetic */ void getDescriptor$annotations() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0083\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u00020\u000bHÖ\u0081\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00028\u0001¨\u0006\u0014"}, d2 = {"Lio/ktor/openapi/ReferenceOr$Value;", "A", "Lio/ktor/openapi/ReferenceOr;", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Value<A> implements ReferenceOr<A> {
        private final A value;

        /* JADX WARN: Multi-variable type inference failed */
        private /* synthetic */ Value(Object obj) {
            this.value = obj;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Value m1792boximpl(Object obj) {
            return new Value(obj);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m1794equalsimpl(Object obj, Object obj2) {
            return (obj2 instanceof Value) && Intrinsics.areEqual(obj, ((Value) obj2).getValue());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1795equalsimpl0(Object obj, Object obj2) {
            return Intrinsics.areEqual(obj, obj2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m1796hashCodeimpl(Object obj) {
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        /* JADX INFO: renamed from: mapToReference-impl, reason: not valid java name */
        public static <B> ReferenceOr<B> m1797mapToReferenceimpl(Object obj, Function1 function1) {
            function1.getClass();
            return m1792boximpl(obj).mapToReference(function1);
        }

        /* JADX INFO: renamed from: mapValue-impl, reason: not valid java name */
        public static <B> ReferenceOr<B> m1798mapValueimpl(Object obj, Function1 function1) {
            function1.getClass();
            return m1792boximpl(obj).mapValue(function1);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m1799toStringimpl(Object obj) {
            return "Value(value=" + obj + ')';
        }

        /* JADX INFO: renamed from: valueOrNull-impl, reason: not valid java name */
        public static A m1800valueOrNullimpl(Object obj) {
            return (A) m1792boximpl(obj).valueOrNull();
        }

        public boolean equals(Object other) {
            return m1794equalsimpl(this.value, other);
        }

        public final A getValue() {
            return this.value;
        }

        public int hashCode() {
            return m1796hashCodeimpl(this.value);
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ <B> ReferenceOr<B> mapToReference(Function1 function1) {
            return super.mapToReference(function1);
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ <B> ReferenceOr<B> mapValue(Function1 function1) {
            return super.mapValue(function1);
        }

        public String toString() {
            return m1799toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ Object getValue() {
            return this.value;
        }

        @Override // io.ktor.openapi.ReferenceOr
        public /* bridge */ A valueOrNull() {
            return (A) super.valueOrNull();
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static <A> Object m1793constructorimpl(A a) {
            return a;
        }
    }
}
