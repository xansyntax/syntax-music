package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0003;<=B\u008e\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\t0\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0018\u00010\u0004\u0012\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004j\u0002`\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0018\u00010\u0004\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\t0\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ$\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\"\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b \u0010\u001dJ\u0099\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\t0\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00042\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0018\u00010\u00042\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004j\u0002`\u0011HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001b\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0083\u0004¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b*\u0010\u001bJ'\u00103\u001a\u0002002\u0006\u0010+\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u0010\u001bR+\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b7\u0010\u001dR4\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\t0\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b8\u0010\u001dR+\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b9\u0010\u001dR,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0004j\u0002`\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u00106\u001a\u0004\b:\u0010\u001d¨\u0006>"}, d2 = {"Lio/ktor/openapi/Response;", "Lio/ktor/openapi/Extensible;", "", "description", "", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Header;", "headers", "Lio/ktor/http/ContentType;", "Lkotlinx/serialization/Serializable;", "with", "Lio/ktor/openapi/ContentTypeSerializer;", "Lio/ktor/openapi/MediaType;", "content", "Lio/ktor/openapi/Link;", "links", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/Response;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Response;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getDescription", "Ljava/util/Map;", "getHeaders", "getContent", "getLinks", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Response implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<ContentType, MediaType> content;
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final Map<String, ReferenceOr<Header>> headers;
    private final Map<String, ReferenceOr<Link>> links;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000f\u0010\rJ*\u0010\u0010\u001a\u00020\n*\u00020\u00042\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\bH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u001a\u001a\u00020\n\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0096\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010%R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\"\u0010'\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020.0-8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002030-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00100R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00100R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002060-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00100R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000203088F¢\u0006\u0006\u001a\u0004\b9\u00102R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020:088F¢\u0006\u0006\u001a\u0004\b;\u00102R\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u000206088F¢\u0006\u0006\u001a\u0004\b<\u00102R(\u0010B\u001a\u0004\u0018\u00010\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\"8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lio/ktor/openapi/Response$Builder;", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "Lkotlin/Function1;", "Lio/ktor/openapi/Headers$Builder;", "", "configure", "headers", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/MediaType$Builder;", "content", "invoke", "(Lio/ktor/http/ContentType;Lkotlin/jvm/functions/Function1;)V", "", ContentDisposition.Parameters.Name, "Lio/ktor/openapi/Link$Builder;", "link", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "", "T", "value", "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/Response;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Response;", "build", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "", "Lio/ktor/openapi/GenericElement;", "extensions", "Ljava/util/Map;", "getExtensions", "()Ljava/util/Map;", "Lio/ktor/openapi/Header;", "_headers", "_content", "Lio/ktor/openapi/Link;", "_links", "", "getHeaders", "Lio/ktor/openapi/MediaType;", "getContent", "getLinks", "links", "getSchema", "()Lio/ktor/openapi/JsonSchema;", "setSchema", "(Lio/ktor/openapi/JsonSchema;)V", "schema", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements JsonSchemaInference {
        private final Map<ContentType, MediaType.Builder> _content;
        private final Map<String, Header> _headers;
        private final Map<String, Link> _links;
        private final List<ContentType> defaultContentTypes;
        private String description;
        private final Map<String, GenericElement> extensions;
        private final JsonSchemaInference schemaInference;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this.description = "";
            this.extensions = new LinkedHashMap();
            this._headers = new LinkedHashMap();
            this._content = new LinkedHashMap();
            this._links = new LinkedHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _set_schema_$lambda$0(JsonSchema jsonSchema, MediaType.Builder builder) {
            builder.getClass();
            builder.setSchema(jsonSchema);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void invoke$default(Builder builder, ContentType contentType, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 28);
            }
            builder.invoke(contentType, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(MediaType.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Response build$ktor_openapi_schema() {
            String str = this.description;
            Map<String, Header> map = this._headers;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl((Header) entry.getValue())));
            }
            if (linkedHashMap.isEmpty()) {
                linkedHashMap = null;
            }
            Map<ContentType, MediaType.Builder> map2 = this._content;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map2.size()));
            Iterator<T> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it2.next();
                linkedHashMap2.put(entry2.getKey(), ((MediaType.Builder) entry2.getValue()).build$ktor_openapi_schema());
            }
            if (linkedHashMap2.isEmpty()) {
                linkedHashMap2 = null;
            }
            Map<String, Link> map3 = this._links;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map3.size()));
            Iterator<T> it3 = map3.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry3 = (Map.Entry) it3.next();
                linkedHashMap3.put(entry3.getKey(), ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl((Link) entry3.getValue())));
            }
            if (linkedHashMap3.isEmpty()) {
                linkedHashMap3 = null;
            }
            Map<String, GenericElement> map4 = this.extensions;
            return new Response(str, linkedHashMap, linkedHashMap2, linkedHashMap3, map4.isEmpty() ? null : map4);
        }

        @Override // io.ktor.openapi.JsonSchemaInference
        public JsonSchema buildSchema(KType type) {
            type.getClass();
            return this.schemaInference.buildSchema(type);
        }

        public final void content(Function1 configure) {
            configure.getClass();
            for (ContentType contentType : this.defaultContentTypes) {
                Map<ContentType, MediaType.Builder> map = this._content;
                MediaType.Builder builder = map.get(contentType);
                if (builder == null) {
                    builder = new MediaType.Builder(this.schemaInference);
                    map.put(contentType, builder);
                }
                configure.invoke(builder);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> void extension(String name, T value) {
            GenericElement genericElementString;
            name.getClass();
            value.getClass();
            if (!StringsKt__StringsJVMKt.startsWith(name, "x-", false)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Extension name must start with 'x-'");
                return;
            }
            Map<String, GenericElement> extensions = getExtensions();
            if (value instanceof GenericElement) {
                genericElementString = (GenericElement) value;
            } else {
                if (!(value instanceof String)) {
                    Intrinsics.throwUndefinedForReified();
                    throw null;
                }
                genericElementString = new GenericElementString((String) value, null, 2, null);
            }
            extensions.put(name, genericElementString);
        }

        public final Map<ContentType, MediaType> getContent() {
            Map<ContentType, MediaType.Builder> map = this._content;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ((MediaType.Builder) entry.getValue()).build$ktor_openapi_schema());
            }
            return linkedHashMap;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final Map<String, Header> getHeaders() {
            return this._headers;
        }

        public final Map<String, Link> getLinks() {
            return this._links;
        }

        public final JsonSchema getSchema() {
            MediaType.Builder builder;
            ContentType contentType = (ContentType) CollectionsKt.firstOrNull((List) this.defaultContentTypes);
            if (contentType == null || (builder = this._content.get(contentType)) == null) {
                return null;
            }
            return builder.getSchema();
        }

        public final void headers(Function1 configure) {
            configure.getClass();
            Headers.Builder builder = new Headers.Builder(this.schemaInference);
            configure.invoke(builder);
            for (Map.Entry<String, Header> entry : builder.build$ktor_openapi_schema().getHeaders().entrySet()) {
                this._headers.put(entry.getKey(), entry.getValue());
            }
        }

        public final void invoke(ContentType contentType, Function1 function1) {
            contentType.getClass();
            function1.getClass();
            Map<ContentType, MediaType.Builder> map = this._content;
            MediaType.Builder builder = map.get(contentType);
            if (builder == null) {
                builder = new MediaType.Builder(this.schemaInference);
                map.put(contentType, builder);
            }
            function1.invoke(builder);
        }

        public final void link(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Map<String, Link> map = this._links;
            Link.Builder builder = new Link.Builder();
            configure.invoke(builder);
            map.put(name, builder.build$ktor_openapi_schema());
        }

        public final void setDescription(String str) {
            str.getClass();
            this.description = str;
        }

        public final void setSchema(JsonSchema jsonSchema) {
            content(new Response$Builder$$ExternalSyntheticLambda1(jsonSchema, (byte) 0));
        }
    }

    static {
        Xml$$ExternalSyntheticLambda0 xml$$ExternalSyntheticLambda0 = new Xml$$ExternalSyntheticLambda0((byte) 16);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, xml$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 17)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 18)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 19))};
    }

    public /* synthetic */ Response(int i, String str, Map map, Map map2, Map map3, Map map4, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(Response$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.description = str;
        if ((i & 2) == 0) {
            this.headers = null;
        } else {
            this.headers = map;
        }
        if ((i & 4) == 0) {
            this.content = null;
        } else {
            this.content = map2;
        }
        if ((i & 8) == 0) {
            this.links = null;
        } else {
            this.links = map3;
        }
        if ((i & 16) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Header.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(ContentTypeSerializer.INSTANCE, MediaType.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Link.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, String str, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = response.description;
        }
        if ((i & 2) != 0) {
            map = response.headers;
        }
        if ((i & 4) != 0) {
            map2 = response.content;
        }
        if ((i & 8) != 0) {
            map3 = response.links;
        }
        if ((i & 16) != 0) {
            map4 = response.extensions;
        }
        Map map5 = map4;
        Map map6 = map2;
        return response.copy(str, map, map6, map3, map5);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Response self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.description);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.headers != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.links != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.links);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, ReferenceOr<Header>> component2() {
        return this.headers;
    }

    public final Map<ContentType, MediaType> component3() {
        return this.content;
    }

    public final Map<String, ReferenceOr<Link>> component4() {
        return this.links;
    }

    public final Map<String, GenericElement> component5() {
        return this.extensions;
    }

    public final Response copy(String description, Map<String, ? extends ReferenceOr<Header>> headers, Map<ContentType, MediaType> content, Map<String, ? extends ReferenceOr<Link>> links, Map<String, ? extends GenericElement> extensions) {
        description.getClass();
        return new Response(description, headers, content, links, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return Intrinsics.areEqual(this.description, response.description) && Intrinsics.areEqual(this.headers, response.headers) && Intrinsics.areEqual(this.content, response.content) && Intrinsics.areEqual(this.links, response.links) && Intrinsics.areEqual(this.extensions, response.extensions);
    }

    public final Map<ContentType, MediaType> getContent() {
        return this.content;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final Map<String, ReferenceOr<Header>> getHeaders() {
        return this.headers;
    }

    public final Map<String, ReferenceOr<Link>> getLinks() {
        return this.links;
    }

    public int hashCode() {
        int iHashCode = this.description.hashCode() * 31;
        Map<String, ReferenceOr<Header>> map = this.headers;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<ContentType, MediaType> map2 = this.content;
        int iHashCode3 = (iHashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, ReferenceOr<Link>> map3 = this.links;
        int iHashCode4 = (iHashCode3 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, GenericElement> map4 = this.extensions;
        return iHashCode4 + (map4 != null ? map4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(description=");
        sb.append(this.description);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", links=");
        sb.append(this.links);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Response$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Response;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Response$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Response;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Response> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Response.INSTANCE.generatedSerializer$ktor_openapi_schema(), new CombinedContext$$ExternalSyntheticLambda0((byte) 5));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Response _init_$lambda$0(Response response, Map map) {
                response.getClass();
                return Response.copy$default(response, null, null, null, null, map, 15, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Response$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Response(String str, Map<String, ? extends ReferenceOr<Header>> map, Map<ContentType, MediaType> map2, Map<String, ? extends ReferenceOr<Link>> map3, Map<String, ? extends GenericElement> map4) {
        str.getClass();
        this.description = str;
        this.headers = map;
        this.content = map2;
        this.links = map3;
        this.extensions = map4;
    }

    public /* synthetic */ Response(String str, Map map, Map map2, Map map3, Map map4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) != 0 ? null : map3, (i & 16) != 0 ? null : map4);
    }
}
