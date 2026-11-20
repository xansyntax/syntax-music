package io.ktor.openapi;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind$CONTEXTUAL;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lio/ktor/openapi/AdditionalProperties;", "", "Companion", "Allowed", "PSchema", "Lio/ktor/openapi/AdditionalProperties$Allowed;", "Lio/ktor/openapi/AdditionalProperties$PSchema;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public interface AdditionalProperties {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fHÖ\u0081\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0088\u0001\u0004\u0092\u0001\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/AdditionalProperties$PSchema;", "Lio/ktor/openapi/AdditionalProperties;", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/JsonSchema;", "value", "constructor-impl", "(Lio/ktor/openapi/ReferenceOr;)Lio/ktor/openapi/ReferenceOr;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/openapi/ReferenceOr;", "getValue", "()Lio/ktor/openapi/ReferenceOr;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PSchema implements AdditionalProperties {
        private final ReferenceOr<JsonSchema> value;

        private /* synthetic */ PSchema(ReferenceOr referenceOr) {
            this.value = referenceOr;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ PSchema m1740boximpl(ReferenceOr referenceOr) {
            return new PSchema(referenceOr);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ReferenceOr<? extends JsonSchema> m1741constructorimpl(ReferenceOr<JsonSchema> referenceOr) {
            referenceOr.getClass();
            return referenceOr;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m1742equalsimpl(ReferenceOr<? extends JsonSchema> referenceOr, Object obj) {
            return (obj instanceof PSchema) && Intrinsics.areEqual(referenceOr, ((PSchema) obj).getValue());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1743equalsimpl0(ReferenceOr<? extends JsonSchema> referenceOr, ReferenceOr<? extends JsonSchema> referenceOr2) {
            return Intrinsics.areEqual(referenceOr, referenceOr2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m1744hashCodeimpl(ReferenceOr<? extends JsonSchema> referenceOr) {
            return referenceOr.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m1745toStringimpl(ReferenceOr<? extends JsonSchema> referenceOr) {
            return "PSchema(value=" + referenceOr + ')';
        }

        public boolean equals(Object other) {
            return m1742equalsimpl(this.value, other);
        }

        public final ReferenceOr<JsonSchema> getValue() {
            return this.value;
        }

        public int hashCode() {
            return m1744hashCodeimpl(this.value);
        }

        public String toString() {
            return m1745toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ ReferenceOr getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/openapi/AdditionalProperties$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/AdditionalProperties;", "serializer", "()Lkotlinx/serialization/KSerializer;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0084\b¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/ktor/openapi/AdditionalProperties$Companion$Serializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/AdditionalProperties;", "<init>", "()V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/AdditionalProperties;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/AdditionalProperties;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer implements KSerializer {
            public static final Serializer INSTANCE = new Serializer();
            private static final SerialDescriptor descriptor = StringsKt__IndentKt.buildSerialDescriptor$default("io.ktor.openapi.AdditionalProperties", SerialKind$CONTEXTUAL.INSTANCE, new SerialDescriptor[0]);

            private Serializer() {
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public AdditionalProperties deserialize(Decoder decoder) {
                decoder.getClass();
                decoder.getSerializersModule();
                GenericElement genericElement = (GenericElement) decoder.decodeSerializableValue(GenericElement.INSTANCE.serializer());
                if (!genericElement.isObject()) {
                    return Allowed.m1733boximpl(Allowed.m1734constructorimpl(((Boolean) genericElement.deserialize(BooleanSerializer.INSTANCE)).booleanValue()));
                }
                decoder.getSerializersModule();
                return PSchema.m1740boximpl(PSchema.m1741constructorimpl((ReferenceOr) genericElement.deserialize(ReferenceOr.INSTANCE.serializer(JsonSchema.INSTANCE.serializer()))));
            }

            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public SerialDescriptor getDescriptor() {
                return descriptor;
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public void serialize(Encoder encoder, AdditionalProperties value) {
                encoder.getClass();
                value.getClass();
                if (value instanceof Allowed) {
                    encoder.encodeBoolean(((Allowed) value).m1739unboximpl());
                } else if (value instanceof PSchema) {
                    encoder.encodeSerializableValue(ReferenceOr.INSTANCE.serializer(JsonSchema.INSTANCE.serializer()), ((PSchema) value).getValue());
                } else {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                }
            }

            public static /* synthetic */ void getDescriptor$annotations() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0083\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nHÖ\u0081\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0013"}, d2 = {"Lio/ktor/openapi/AdditionalProperties$Allowed;", "Lio/ktor/openapi/AdditionalProperties;", "", "value", "constructor-impl", "(Z)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Z", "getValue", "()Z", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Allowed implements AdditionalProperties {
        private final boolean value;

        private /* synthetic */ Allowed(boolean z) {
            this.value = z;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Allowed m1733boximpl(boolean z) {
            return new Allowed(z);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m1735equalsimpl(boolean z, Object obj) {
            return (obj instanceof Allowed) && z == ((Allowed) obj).m1739unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1736equalsimpl0(boolean z, boolean z2) {
            return z == z2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m1737hashCodeimpl(boolean z) {
            return Boolean.hashCode(z);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m1738toStringimpl(boolean z) {
            return "Allowed(value=" + z + ')';
        }

        public boolean equals(Object other) {
            return m1735equalsimpl(this.value, other);
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return m1737hashCodeimpl(this.value);
        }

        public String toString() {
            return m1738toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ boolean m1739unboximpl() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static boolean m1734constructorimpl(boolean z) {
            return z;
        }
    }
}
