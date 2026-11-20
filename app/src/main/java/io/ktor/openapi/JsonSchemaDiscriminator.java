package io.ktor.openapi;

import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u000eJ'\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u000eR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0010¨\u0006)"}, d2 = {"Lio/ktor/openapi/JsonSchemaDiscriminator;", "", "", "propertyName", "", "mapping", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/util/Map;)Lio/ktor/openapi/JsonSchemaDiscriminator;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/JsonSchemaDiscriminator;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getPropertyName", "Ljava/util/Map;", "getMapping", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class JsonSchemaDiscriminator {
    private final Map<String, String> mapping;
    private final String propertyName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Link$$ExternalSyntheticLambda0(4))};

    public /* synthetic */ JsonSchemaDiscriminator(int i, String str, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(JsonSchemaDiscriminator$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.propertyName = str;
        if ((i & 2) == 0) {
            this.mapping = null;
        } else {
            this.mapping = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new HashMapSerializer(stringSerializer, stringSerializer, (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonSchemaDiscriminator copy$default(JsonSchemaDiscriminator jsonSchemaDiscriminator, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jsonSchemaDiscriminator.propertyName;
        }
        if ((i & 2) != 0) {
            map = jsonSchemaDiscriminator.mapping;
        }
        return jsonSchemaDiscriminator.copy(str, map);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(JsonSchemaDiscriminator self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.propertyName);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.mapping == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.mapping);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPropertyName() {
        return this.propertyName;
    }

    public final Map<String, String> component2() {
        return this.mapping;
    }

    public final JsonSchemaDiscriminator copy(String propertyName, Map<String, String> mapping) {
        propertyName.getClass();
        return new JsonSchemaDiscriminator(propertyName, mapping);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsonSchemaDiscriminator)) {
            return false;
        }
        JsonSchemaDiscriminator jsonSchemaDiscriminator = (JsonSchemaDiscriminator) other;
        return Intrinsics.areEqual(this.propertyName, jsonSchemaDiscriminator.propertyName) && Intrinsics.areEqual(this.mapping, jsonSchemaDiscriminator.mapping);
    }

    public final Map<String, String> getMapping() {
        return this.mapping;
    }

    public final String getPropertyName() {
        return this.propertyName;
    }

    public int hashCode() {
        int iHashCode = this.propertyName.hashCode() * 31;
        Map<String, String> map = this.mapping;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JsonSchemaDiscriminator(propertyName=");
        sb.append(this.propertyName);
        sb.append(", mapping=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.mapping, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/JsonSchemaDiscriminator$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/JsonSchemaDiscriminator;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return JsonSchemaDiscriminator$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public JsonSchemaDiscriminator(String str, Map<String, String> map) {
        str.getClass();
        this.propertyName = str;
        this.mapping = map;
    }

    public /* synthetic */ JsonSchemaDiscriminator(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map);
    }
}
