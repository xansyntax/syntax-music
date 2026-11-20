package io.ktor.openapi;

import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0003012BS\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0002`\n¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0005\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\f\u0010\u0011J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\\\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00052\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0002`\nHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b \u0010!J'\u0010*\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0001¢\u0006\u0004\b(\u0010)R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010\u0013R+\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010\u0015R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0002`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b/\u0010\u0015¨\u00063"}, d2 = {"Lio/ktor/openapi/Responses;", "Lio/ktor/openapi/Extensible;", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Response;", "default", "", "", "responses", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/openapi/ReferenceOr;", "component2", "()Ljava/util/Map;", "component3", "copy", "(Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/Responses;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Responses;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/openapi/ReferenceOr;", "getDefault", "Ljava/util/Map;", "getResponses", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Responses implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ReferenceOr<Response> default;
    private final Map<String, GenericElement> extensions;
    private final Map<Integer, ReferenceOr<Response>> responses;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0012\u001a\u00020\r*\u00020\u00112\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001eR$\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0'8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0'8F¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006."}, d2 = {"Lio/ktor/openapi/Responses$Builder;", "", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "", "statusCode", "Lkotlin/Function1;", "Lio/ktor/openapi/Response$Builder;", "", "configure", "response", "(ILkotlin/jvm/functions/Function1;)V", "Lio/ktor/http/HttpStatusCode;", "invoke", "(Lio/ktor/http/HttpStatusCode;Lkotlin/jvm/functions/Function1;)V", "default", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Responses;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Responses;", "build", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "", "_responses", "Ljava/util/Map;", "", "Lio/ktor/openapi/GenericElement;", "_extensions", "Lio/ktor/openapi/Response$Builder;", "getDefault", "()Lio/ktor/openapi/Response$Builder;", "setDefault", "(Lio/ktor/openapi/Response$Builder;)V", "", "Lio/ktor/openapi/Response;", "getResponses", "()Ljava/util/Map;", "responses", "getExtensions", "extensions", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final Map<String, GenericElement> _extensions;
        private final Map<Integer, Response.Builder> _responses;
        private Response.Builder default;
        private final List<ContentType> defaultContentTypes;
        private final JsonSchemaInference schemaInference;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this._responses = new LinkedHashMap();
            this._extensions = new LinkedHashMap();
        }

        public static /* synthetic */ void invoke$default(Builder builder, HttpStatusCode httpStatusCode, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 29);
            }
            builder.invoke(httpStatusCode, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(Response.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Responses build$ktor_openapi_schema() {
            Response.Builder builder = this.default;
            ReferenceOr.Value valueM1792boximpl = builder != null ? ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(builder.build$ktor_openapi_schema())) : null;
            Map<Integer, Response.Builder> map = this._responses;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(((Response.Builder) entry.getValue()).build$ktor_openapi_schema())));
            }
            if (linkedHashMap.isEmpty()) {
                linkedHashMap = null;
            }
            Map<String, GenericElement> map2 = this._extensions;
            return new Responses(valueM1792boximpl, linkedHashMap, map2.isEmpty() ? null : map2);
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final void m1808default(Function1 configure) {
            configure.getClass();
            Object obj = this.default;
            if (obj != null) {
                obj.getClass();
                configure.invoke(obj);
            } else {
                Response.Builder builder = new Response.Builder(this.schemaInference, this.defaultContentTypes);
                configure.invoke(builder);
                this.default = builder;
            }
        }

        public final Response.Builder getDefault() {
            return this.default;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this._extensions;
        }

        public final Map<Integer, Response> getResponses() {
            Map<Integer, Response.Builder> map = this._responses;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ((Response.Builder) entry.getValue()).build$ktor_openapi_schema());
            }
            return linkedHashMap;
        }

        public final void invoke(HttpStatusCode httpStatusCode, Function1 function1) {
            httpStatusCode.getClass();
            function1.getClass();
            response(httpStatusCode.getValue(), function1);
        }

        public final void response(int statusCode, Function1 configure) {
            configure.getClass();
            Map<Integer, Response.Builder> map = this._responses;
            Integer numValueOf = Integer.valueOf(statusCode);
            Response.Builder builder = map.get(numValueOf);
            if (builder == null) {
                builder = new Response.Builder(this.schemaInference, this.defaultContentTypes);
                map.put(numValueOf, builder);
            }
            configure.invoke(builder);
        }

        public final void setDefault(Response.Builder builder) {
            this.default = builder;
        }
    }

    static {
        Xml$$ExternalSyntheticLambda0 xml$$ExternalSyntheticLambda0 = new Xml$$ExternalSyntheticLambda0((byte) 20);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, xml$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 21)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 22))};
    }

    public /* synthetic */ Responses(int i, ReferenceOr referenceOr, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.default = null;
        } else {
            this.default = referenceOr;
        }
        if ((i & 2) == 0) {
            this.responses = null;
        } else {
            this.responses = map;
        }
        if ((i & 4) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ReferenceOr.Companion.Serializer(Response.Companion.Serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(IntSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Response.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Responses copy$default(Responses responses, ReferenceOr referenceOr, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            referenceOr = responses.default;
        }
        if ((i & 2) != 0) {
            map = responses.responses;
        }
        if ((i & 4) != 0) {
            map2 = responses.extensions;
        }
        return responses.copy(referenceOr, map, map2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Responses self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.default != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.default);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.responses != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.responses);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.getExtensions());
    }

    public final ReferenceOr<Response> component1() {
        return this.default;
    }

    public final Map<Integer, ReferenceOr<Response>> component2() {
        return this.responses;
    }

    public final Map<String, GenericElement> component3() {
        return this.extensions;
    }

    public final Responses copy(ReferenceOr<Response> referenceOr, Map<Integer, ? extends ReferenceOr<Response>> responses, Map<String, ? extends GenericElement> extensions) {
        return new Responses(referenceOr, responses, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Responses)) {
            return false;
        }
        Responses responses = (Responses) other;
        return Intrinsics.areEqual(this.default, responses.default) && Intrinsics.areEqual(this.responses, responses.responses) && Intrinsics.areEqual(this.extensions, responses.extensions);
    }

    public final ReferenceOr<Response> getDefault() {
        return this.default;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final Map<Integer, ReferenceOr<Response>> getResponses() {
        return this.responses;
    }

    public int hashCode() {
        ReferenceOr<Response> referenceOr = this.default;
        int iHashCode = (referenceOr == null ? 0 : referenceOr.hashCode()) * 31;
        Map<Integer, ReferenceOr<Response>> map = this.responses;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Responses(default=");
        sb.append(this.default);
        sb.append(", responses=");
        sb.append(this.responses);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Responses$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Responses;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002>\u0012\u0004\u0012\u00020\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u0002`\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0002`\n0\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/openapi/Responses$Companion$Serializer;", "Lio/ktor/openapi/DoublePropertyMixinSerializer;", "Lio/ktor/openapi/Responses;", "", "", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Response;", "Lio/ktor/openapi/ResponsesByStatusCode;", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends DoublePropertyMixinSerializer<Responses, Map<Integer, ? extends ReferenceOr<? extends Response>>, Map<String, ? extends GenericElement>> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Responses.INSTANCE.generatedSerializer$ktor_openapi_schema(), new PropertyReference1Impl() { // from class: io.ktor.openapi.Responses.Companion.Serializer.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((Responses) obj).getResponses();
                    }
                }, HexFormatKt.getNullable(new HashMapSerializer(IntSerializer.INSTANCE, ReferenceOr.INSTANCE.serializer(Response.INSTANCE.serializer()), (byte) 1)), new InstantKt$$ExternalSyntheticLambda0((byte) 1), new PropertyReference1Impl() { // from class: io.ktor.openapi.Responses.Companion.Serializer.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((Responses) obj).getExtensions();
                    }
                }, HexFormatKt.getNullable(new HashMapSerializer(StringSerializer.INSTANCE, GenericElement.INSTANCE.serializer(), (byte) 1)), new InstantKt$$ExternalSyntheticLambda0((byte) 2), new Responses$Companion$Serializer$$ExternalSyntheticLambda2((byte) 0));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean _init_$lambda$0(String str) {
                str.getClass();
                return StringsKt__StringsJVMKt.toIntOrNull(10, str) != null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean _init_$lambda$1(String str) {
                str.getClass();
                return StringsKt__StringsJVMKt.startsWith(str, "x-", false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Responses _init_$lambda$2(Responses responses, Map map, Map map2) {
                responses.getClass();
                return Responses.copy$default(responses, null, map, map2, 1, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Responses$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Responses() {
        this((ReferenceOr) null, (Map) null, (Map) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Responses(ReferenceOr<Response> referenceOr, Map<Integer, ? extends ReferenceOr<Response>> map, Map<String, ? extends GenericElement> map2) {
        this.default = referenceOr;
        this.responses = map;
        this.extensions = map2;
    }

    public /* synthetic */ Responses(ReferenceOr referenceOr, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : referenceOr, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2);
    }
}
