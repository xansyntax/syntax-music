package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.utils.io.KtorDsl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0003%&$B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u000e¨\u0006'"}, d2 = {"Lio/ktor/openapi/Headers;", "", "", "", "Lio/ktor/openapi/Header;", "headers", "<init>", "(Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/util/Map;", "copy", "(Ljava/util/Map;)Lio/ktor/openapi/Headers;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Headers;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/Map;", "getHeaders", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Headers {
    private final Map<String, Header> headers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Header$$ExternalSyntheticLambda0(16))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/openapi/Headers$Builder;", "", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;)V", "", ContentDisposition.Parameters.Name, "Lkotlin/Function1;", "Lio/ktor/openapi/Header$Builder;", "", "configure", "header", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Headers;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Headers;", "build", "Lio/ktor/openapi/JsonSchemaInference;", "", "Lio/ktor/openapi/Header;", "_headers", "Ljava/util/Map;", "", "getHeaders", "()Ljava/util/Map;", "headers", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final Map<String, Header> _headers;
        private final JsonSchemaInference schemaInference;

        public Builder(JsonSchemaInference jsonSchemaInference) {
            jsonSchemaInference.getClass();
            this.schemaInference = jsonSchemaInference;
            this._headers = new LinkedHashMap();
        }

        public final Headers build$ktor_openapi_schema() {
            return new Headers(this._headers);
        }

        public final Map<String, Header> getHeaders() {
            return this._headers;
        }

        public final void header(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Header.Builder builder = new Header.Builder(this.schemaInference);
            configure.invoke(builder);
            this._headers.put(name, builder.build$ktor_openapi_schema());
        }
    }

    public /* synthetic */ Headers(int i, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (i & 1)) {
            this.headers = map;
        } else {
            EnumsKt.throwMissingFieldException(Headers$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, Header.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Headers copy$default(Headers headers, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = headers.headers;
        }
        return headers.copy(map);
    }

    public final Map<String, Header> component1() {
        return this.headers;
    }

    public final Headers copy(Map<String, Header> headers) {
        headers.getClass();
        return new Headers(headers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Headers) && Intrinsics.areEqual(this.headers, ((Headers) other).headers);
    }

    public final Map<String, Header> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return Cookie$$ExternalSyntheticOutline0.m(new StringBuilder("Headers(headers="), (Map) this.headers, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Headers$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Headers;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Headers$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Headers(Map<String, Header> map) {
        map.getClass();
        this.headers = map;
    }
}
