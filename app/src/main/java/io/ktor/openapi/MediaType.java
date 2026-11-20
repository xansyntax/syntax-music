package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 52\u00020\u0001:\u0003567Bk\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fBs\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u0005\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\"\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0002`\fHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0018Jt\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00052\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0002`\fHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u00020\u0006HÖ\u0081\u0004¢\u0006\u0004\b$\u0010%J'\u0010.\u001a\u00020+2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b,\u0010-R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b0\u0010\u0016R+\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u0010\u0018R%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b3\u0010\u0018R,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0002`\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b4\u0010\u0018¨\u00068"}, d2 = {"Lio/ktor/openapi/MediaType;", "Lio/ktor/openapi/Extensible;", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/JsonSchema;", "schema", "", "", "Lio/ktor/openapi/ExampleObject;", "examples", "Lio/ktor/openapi/Encoding;", "encoding", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/openapi/ReferenceOr;", "component2", "()Ljava/util/Map;", "component3", "component4", "copy", "(Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/MediaType;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/MediaType;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/openapi/ReferenceOr;", "getSchema", "Ljava/util/Map;", "getExamples", "getEncoding", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class MediaType implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<ContentType, MediaType> Text;
    private final Map<String, Encoding> encoding;
    private final Map<String, ReferenceOr<ExampleObject>> examples;
    private final Map<String, GenericElement> extensions;
    private final ReferenceOr<JsonSchema> schema;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\nJ\u001d\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u0012\u001a\u00020\t\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R#\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0)8F¢\u0006\u0006\u001a\u0004\b-\u0010+R#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020.0$8\u0006¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010+¨\u00061"}, d2 = {"Lio/ktor/openapi/MediaType$Builder;", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;)V", "", ContentDisposition.Parameters.Name, "Lio/ktor/openapi/ExampleObject;", "example", "", "(Ljava/lang/String;Lio/ktor/openapi/ExampleObject;)V", "propertyName", "Lio/ktor/openapi/Encoding;", "encoding", "(Ljava/lang/String;Lio/ktor/openapi/Encoding;)V", "", "T", "value", "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/MediaType;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/MediaType;", "build", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonSchemaInference;", "schema", "Lio/ktor/openapi/JsonSchema;", "getSchema", "()Lio/ktor/openapi/JsonSchema;", "setSchema", "(Lio/ktor/openapi/JsonSchema;)V", "", "Lio/ktor/openapi/ReferenceOr;", "_examples", "Ljava/util/Map;", "_encoding", "", "getExamples", "()Ljava/util/Map;", "examples", "getEncoding", "Lio/ktor/openapi/GenericElement;", "extensions", "getExtensions", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements JsonSchemaInference {
        private final Map<String, Encoding> _encoding;
        private final Map<String, ReferenceOr<ExampleObject>> _examples;
        private final Map<String, GenericElement> extensions;
        private JsonSchema schema;
        private final JsonSchemaInference schemaInference;

        public Builder(JsonSchemaInference jsonSchemaInference) {
            jsonSchemaInference.getClass();
            this.schemaInference = jsonSchemaInference;
            this._examples = new LinkedHashMap();
            this._encoding = new LinkedHashMap();
            this.extensions = new LinkedHashMap();
        }

        public final MediaType build$ktor_openapi_schema() {
            JsonSchema jsonSchema = this.schema;
            ReferenceOr.Value valueM1792boximpl = jsonSchema != null ? ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(jsonSchema)) : null;
            Map<String, ReferenceOr<ExampleObject>> map = this._examples;
            if (map.isEmpty()) {
                map = null;
            }
            Map<String, Encoding> map2 = this._encoding;
            if (map2.isEmpty()) {
                map2 = null;
            }
            Map<String, GenericElement> map3 = this.extensions;
            return new MediaType(valueM1792boximpl, map, map2, map3.isEmpty() ? null : map3);
        }

        @Override // io.ktor.openapi.JsonSchemaInference
        public JsonSchema buildSchema(KType type) {
            type.getClass();
            return this.schemaInference.buildSchema(type);
        }

        public final void encoding(String propertyName, Encoding encoding) {
            propertyName.getClass();
            encoding.getClass();
            this._encoding.put(propertyName, encoding);
        }

        public final void example(String name, ExampleObject example) {
            name.getClass();
            example.getClass();
            this._examples.put(name, ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(example)));
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

        public final Map<String, Encoding> getEncoding() {
            return this._encoding;
        }

        public final Map<String, ReferenceOr<ExampleObject>> getExamples() {
            return this._examples;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final JsonSchema getSchema() {
            return this.schema;
        }

        public final void setSchema(JsonSchema jsonSchema) {
            this.schema = jsonSchema;
        }
    }

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 7);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 8)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 9)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 10))};
        Map<ContentType, MediaType> mapSingletonMap = Collections.singletonMap(ContentType.Text.INSTANCE.getPlain(), new MediaType((ReferenceOr) null, (Map) null, (Map) null, (Map) null, 15, (DefaultConstructorMarker) null));
        mapSingletonMap.getClass();
        Text = mapSingletonMap;
    }

    public /* synthetic */ MediaType(int i, ReferenceOr referenceOr, Map map, Map map2, Map map3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.schema = null;
        } else {
            this.schema = referenceOr;
        }
        if ((i & 2) == 0) {
            this.examples = null;
        } else {
            this.examples = map;
        }
        if ((i & 4) == 0) {
            this.encoding = null;
        } else {
            this.encoding = map2;
        }
        if ((i & 8) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(ExampleObject.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, Encoding.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaType copy$default(MediaType mediaType, ReferenceOr referenceOr, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            referenceOr = mediaType.schema;
        }
        if ((i & 2) != 0) {
            map = mediaType.examples;
        }
        if ((i & 4) != 0) {
            map2 = mediaType.encoding;
        }
        if ((i & 8) != 0) {
            map3 = mediaType.extensions;
        }
        return mediaType.copy(referenceOr, map, map2, map3);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(MediaType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.schema != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.schema);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.examples != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.examples);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.encoding != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.encoding);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.getExtensions());
    }

    public final ReferenceOr<JsonSchema> component1() {
        return this.schema;
    }

    public final Map<String, ReferenceOr<ExampleObject>> component2() {
        return this.examples;
    }

    public final Map<String, Encoding> component3() {
        return this.encoding;
    }

    public final Map<String, GenericElement> component4() {
        return this.extensions;
    }

    public final MediaType copy(ReferenceOr<JsonSchema> schema, Map<String, ? extends ReferenceOr<ExampleObject>> examples, Map<String, Encoding> encoding, Map<String, ? extends GenericElement> extensions) {
        return new MediaType(schema, examples, encoding, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) other;
        return Intrinsics.areEqual(this.schema, mediaType.schema) && Intrinsics.areEqual(this.examples, mediaType.examples) && Intrinsics.areEqual(this.encoding, mediaType.encoding) && Intrinsics.areEqual(this.extensions, mediaType.extensions);
    }

    public final Map<String, Encoding> getEncoding() {
        return this.encoding;
    }

    public final Map<String, ReferenceOr<ExampleObject>> getExamples() {
        return this.examples;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final ReferenceOr<JsonSchema> getSchema() {
        return this.schema;
    }

    public int hashCode() {
        ReferenceOr<JsonSchema> referenceOr = this.schema;
        int iHashCode = (referenceOr == null ? 0 : referenceOr.hashCode()) * 31;
        Map<String, ReferenceOr<ExampleObject>> map = this.examples;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Encoding> map2 = this.encoding;
        int iHashCode3 = (iHashCode2 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, GenericElement> map3 = this.extensions;
        return iHashCode3 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaType(schema=");
        sb.append(this.schema);
        sb.append(", examples=");
        sb.append(this.examples);
        sb.append(", encoding=");
        sb.append(this.encoding);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/openapi/MediaType$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/MediaType;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "", "Lio/ktor/http/ContentType;", "Text", "Ljava/util/Map;", "getText", "()Ljava/util/Map;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/MediaType$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/MediaType;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<MediaType> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(MediaType.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 23));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final MediaType _init_$lambda$0(MediaType mediaType, Map map) {
                mediaType.getClass();
                return MediaType.copy$default(mediaType, null, null, null, map, 7, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return MediaType$$serializer.INSTANCE;
        }

        public final Map<ContentType, MediaType> getText() {
            return MediaType.Text;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public MediaType() {
        this((ReferenceOr) null, (Map) null, (Map) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaType(ReferenceOr<JsonSchema> referenceOr, Map<String, ? extends ReferenceOr<ExampleObject>> map, Map<String, Encoding> map2, Map<String, ? extends GenericElement> map3) {
        this.schema = referenceOr;
        this.examples = map;
        this.encoding = map2;
        this.extensions = map3;
    }

    public /* synthetic */ MediaType(ReferenceOr referenceOr, Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : referenceOr, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2, (i & 8) != 0 ? null : map3);
    }
}
