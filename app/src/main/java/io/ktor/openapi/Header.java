package io.ktor.openapi;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0003RSTB¾\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\t0\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0007\u0018\u00010\n\u0012\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\u0002`\u0017¢\u0006\u0004\b\u0019\u0010\u001aB«\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0007\u0018\u00010\n\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\n\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0019\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b$\u0010#J\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b%\u0010&J-\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\t0\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010!J\u0012\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b,\u0010-J$\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0007\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b.\u0010(J\"\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\u0002`\u0017HÆ\u0003¢\u0006\u0004\b/\u0010(JÇ\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\t0\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0007\u0018\u00010\n2\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\u0002`\u0017HÆ\u0001¢\u0006\u0004\b0\u00101J\u001b\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102HÖ\u0083\u0004¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b6\u00107J\u0011\u00108\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b8\u0010!J'\u0010A\u001a\u00020>2\u0006\u00109\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0001¢\u0006\u0004\b?\u0010@R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010B\u001a\u0004\bC\u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010D\u001a\u0004\bE\u0010#R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010D\u001a\u0004\bF\u0010#R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010G\u001a\u0004\bH\u0010&R4\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\t0\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010I\u001a\u0004\bJ\u0010(R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010B\u001a\u0004\bK\u0010!R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010L\u001a\u0004\bM\u0010+R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010N\u001a\u0004\bO\u0010-R+\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0007\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010I\u001a\u0004\bP\u0010(R,\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\nj\u0002`\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010I\u001a\u0004\bQ\u0010(¨\u0006U"}, d2 = {"Lio/ktor/openapi/Header;", "Lio/ktor/openapi/Extensible;", "", "description", "", "required", "deprecated", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/JsonSchema;", "schema", "", "Lio/ktor/http/ContentType;", "Lkotlinx/serialization/Serializable;", "with", "Lio/ktor/openapi/ContentTypeSerializer;", "Lio/ktor/openapi/MediaType;", "content", "style", "explode", "Lio/ktor/openapi/GenericElement;", "example", "Lio/ktor/openapi/ExampleObject;", "examples", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "component3", "component4", "()Lio/ktor/openapi/ReferenceOr;", "component5", "()Ljava/util/Map;", "component6", "component7", "()Ljava/lang/Boolean;", "component8", "()Lio/ktor/openapi/GenericElement;", "component9", "component10", "copy", "(Ljava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/Header;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Header;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getDescription", "Z", "getRequired", "getDeprecated", "Lio/ktor/openapi/ReferenceOr;", "getSchema", "Ljava/util/Map;", "getContent", "getStyle", "Ljava/lang/Boolean;", "getExplode", "Lio/ktor/openapi/GenericElement;", "getExample", "getExamples", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Header implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<ContentType, MediaType> content;
    private final boolean deprecated;
    private final String description;
    private final GenericElement example;
    private final Map<String, ReferenceOr<ExampleObject>> examples;
    private final Boolean explode;
    private final Map<String, GenericElement> extensions;
    private final boolean required;
    private final ReferenceOr<JsonSchema> schema;
    private final String style;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J*\u0010\n\u001a\u00020\b*\u00020\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0011\u001a\u00020\b\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R$\u00100\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010!\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R$\u0010=\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\u0014\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR4\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130I068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u00109\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR#\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020C068\u0006¢\u0006\f\n\u0004\bO\u00109\u001a\u0004\bP\u0010LR\u001d\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002070Q8F¢\u0006\u0006\u001a\u0004\bR\u0010L¨\u0006T"}, d2 = {"Lio/ktor/openapi/Header$Builder;", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;)V", "Lio/ktor/http/ContentType;", "Lkotlin/Function1;", "Lio/ktor/openapi/MediaType$Builder;", "", "configure", "invoke", "(Lio/ktor/http/ContentType;Lkotlin/jvm/functions/Function1;)V", "", "T", "", ContentDisposition.Parameters.Name, "value", "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/ExampleObject;", "example", "(Ljava/lang/String;Lio/ktor/openapi/ExampleObject;)V", "Lio/ktor/openapi/Header;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Header;", "build", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonSchemaInference;", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "", "required", "Z", "getRequired", "()Z", "setRequired", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "schema", "Lio/ktor/openapi/JsonSchema;", "getSchema", "()Lio/ktor/openapi/JsonSchema;", "setSchema", "(Lio/ktor/openapi/JsonSchema;)V", "", "Lio/ktor/openapi/MediaType;", "_content", "Ljava/util/Map;", "style", "getStyle", "setStyle", "explode", "Ljava/lang/Boolean;", "getExplode", "()Ljava/lang/Boolean;", "setExplode", "(Ljava/lang/Boolean;)V", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/GenericElement;", "getExample", "()Lio/ktor/openapi/GenericElement;", "setExample", "(Lio/ktor/openapi/GenericElement;)V", "Lio/ktor/openapi/ReferenceOr;", "examples", "getExamples", "()Ljava/util/Map;", "setExamples", "(Ljava/util/Map;)V", "extensions", "getExtensions", "", "getContent", "content", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements JsonSchemaInference {
        private final Map<ContentType, MediaType> _content;
        private boolean deprecated;
        private String description;
        private GenericElement example;
        private Map<String, ReferenceOr<ExampleObject>> examples;
        private Boolean explode;
        private final Map<String, GenericElement> extensions;
        private boolean required;
        private JsonSchema schema;
        private final JsonSchemaInference schemaInference;
        private String style;

        public Builder(JsonSchemaInference jsonSchemaInference) {
            jsonSchemaInference.getClass();
            this.schemaInference = jsonSchemaInference;
            this._content = new LinkedHashMap();
            this.examples = new LinkedHashMap();
            this.extensions = new LinkedHashMap();
        }

        public static /* synthetic */ void invoke$default(Builder builder, ContentType contentType, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 20);
            }
            builder.invoke(contentType, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(MediaType.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Header build$ktor_openapi_schema() {
            String str = this.description;
            boolean z = this.required;
            boolean z2 = this.deprecated;
            JsonSchema jsonSchema = this.schema;
            ReferenceOr.Value valueM1792boximpl = jsonSchema != null ? ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(jsonSchema)) : null;
            Map<ContentType, MediaType> map = this._content;
            if (map.isEmpty()) {
                map = null;
            }
            String str2 = this.style;
            Boolean bool = this.explode;
            GenericElement genericElement = this.example;
            Map<String, ReferenceOr<ExampleObject>> map2 = this.examples;
            if (map2.isEmpty()) {
                map2 = null;
            }
            Map<String, GenericElement> map3 = this.extensions;
            return new Header(str, z, z2, valueM1792boximpl, map, str2, bool, genericElement, map2, map3.isEmpty() ? null : map3);
        }

        @Override // io.ktor.openapi.JsonSchemaInference
        public JsonSchema buildSchema(KType type) {
            type.getClass();
            return this.schemaInference.buildSchema(type);
        }

        public final void example(String name, ExampleObject example) {
            name.getClass();
            example.getClass();
            this.examples.put(name, ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(example)));
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
            return this._content;
        }

        public final boolean getDeprecated() {
            return this.deprecated;
        }

        public final String getDescription() {
            return this.description;
        }

        public final GenericElement getExample() {
            return this.example;
        }

        public final Map<String, ReferenceOr<ExampleObject>> getExamples() {
            return this.examples;
        }

        public final Boolean getExplode() {
            return this.explode;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final JsonSchema getSchema() {
            return this.schema;
        }

        public final String getStyle() {
            return this.style;
        }

        public final void invoke(ContentType contentType, Function1 function1) {
            contentType.getClass();
            function1.getClass();
            Map<ContentType, MediaType> map = this._content;
            MediaType.Builder builder = new MediaType.Builder(this.schemaInference);
            function1.invoke(builder);
            map.put(contentType, builder.build$ktor_openapi_schema());
        }

        public final void setDeprecated(boolean z) {
            this.deprecated = z;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final void setExample(GenericElement genericElement) {
            this.example = genericElement;
        }

        public final void setExamples(Map<String, ReferenceOr<ExampleObject>> map) {
            map.getClass();
            this.examples = map;
        }

        public final void setExplode(Boolean bool) {
            this.explode = bool;
        }

        public final void setRequired(boolean z) {
            this.required = z;
        }

        public final void setSchema(JsonSchema jsonSchema) {
            this.schema = jsonSchema;
        }

        public final void setStyle(String str) {
            this.style = str;
        }
    }

    static {
        Header$$ExternalSyntheticLambda0 header$$ExternalSyntheticLambda0 = new Header$$ExternalSyntheticLambda0((byte) 0);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, ResultKt.lazy(lazyThreadSafetyMode, header$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 12)), null, null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 13)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 14)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 15))};
    }

    public /* synthetic */ Header(int i, String str, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str2, Boolean bool, GenericElement genericElement, Map map2, Map map3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.description = null;
        } else {
            this.description = str;
        }
        if ((i & 2) == 0) {
            this.required = false;
        } else {
            this.required = z;
        }
        if ((i & 4) == 0) {
            this.deprecated = false;
        } else {
            this.deprecated = z2;
        }
        if ((i & 8) == 0) {
            this.schema = null;
        } else {
            this.schema = referenceOr;
        }
        if ((i & 16) == 0) {
            this.content = null;
        } else {
            this.content = map;
        }
        if ((i & 32) == 0) {
            this.style = null;
        } else {
            this.style = str2;
        }
        if ((i & 64) == 0) {
            this.explode = null;
        } else {
            this.explode = bool;
        }
        if ((i & 128) == 0) {
            this.example = null;
        } else {
            this.example = genericElement;
        }
        if ((i & 256) == 0) {
            this.examples = null;
        } else {
            this.examples = map2;
        }
        if ((i & 512) == 0) {
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
        return new HashMapSerializer(ContentTypeSerializer.INSTANCE, MediaType.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(ExampleObject.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Header copy$default(Header header, String str, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str2, Boolean bool, GenericElement genericElement, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = header.description;
        }
        if ((i & 2) != 0) {
            z = header.required;
        }
        if ((i & 4) != 0) {
            z2 = header.deprecated;
        }
        if ((i & 8) != 0) {
            referenceOr = header.schema;
        }
        if ((i & 16) != 0) {
            map = header.content;
        }
        if ((i & 32) != 0) {
            str2 = header.style;
        }
        if ((i & 64) != 0) {
            bool = header.explode;
        }
        if ((i & 128) != 0) {
            genericElement = header.example;
        }
        if ((i & 256) != 0) {
            map2 = header.examples;
        }
        if ((i & 512) != 0) {
            map3 = header.extensions;
        }
        Map map4 = map2;
        Map map5 = map3;
        Boolean bool2 = bool;
        GenericElement genericElement2 = genericElement;
        Map map6 = map;
        String str3 = str2;
        return header.copy(str, z, z2, referenceOr, map6, str3, bool2, genericElement2, map4, map5);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Header self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.required) {
            output.encodeBooleanElement(serialDesc, 1, self.required);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.deprecated) {
            output.encodeBooleanElement(serialDesc, 2, self.deprecated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.schema != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.schema);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.style != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.style);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.explode != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.explode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.example != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.example);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.examples != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.examples);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy) lazyArr[9].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, GenericElement> component10() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDeprecated() {
        return this.deprecated;
    }

    public final ReferenceOr<JsonSchema> component4() {
        return this.schema;
    }

    public final Map<ContentType, MediaType> component5() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getExplode() {
        return this.explode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GenericElement getExample() {
        return this.example;
    }

    public final Map<String, ReferenceOr<ExampleObject>> component9() {
        return this.examples;
    }

    public final Header copy(String description, boolean required, boolean deprecated, ReferenceOr<JsonSchema> schema, Map<ContentType, MediaType> content, String style, Boolean explode, GenericElement example, Map<String, ? extends ReferenceOr<ExampleObject>> examples, Map<String, ? extends GenericElement> extensions) {
        return new Header(description, required, deprecated, schema, content, style, explode, example, examples, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Header)) {
            return false;
        }
        Header header = (Header) other;
        return Intrinsics.areEqual(this.description, header.description) && this.required == header.required && this.deprecated == header.deprecated && Intrinsics.areEqual(this.schema, header.schema) && Intrinsics.areEqual(this.content, header.content) && Intrinsics.areEqual(this.style, header.style) && Intrinsics.areEqual(this.explode, header.explode) && Intrinsics.areEqual(this.example, header.example) && Intrinsics.areEqual(this.examples, header.examples) && Intrinsics.areEqual(this.extensions, header.extensions);
    }

    public final Map<ContentType, MediaType> getContent() {
        return this.content;
    }

    public final boolean getDeprecated() {
        return this.deprecated;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GenericElement getExample() {
        return this.example;
    }

    public final Map<String, ReferenceOr<ExampleObject>> getExamples() {
        return this.examples;
    }

    public final Boolean getExplode() {
        return this.explode;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final ReferenceOr<JsonSchema> getSchema() {
        return this.schema;
    }

    public final String getStyle() {
        return this.style;
    }

    public int hashCode() {
        String str = this.description;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((str == null ? 0 : str.hashCode()) * 31, this.required, 31), this.deprecated, 31);
        ReferenceOr<JsonSchema> referenceOr = this.schema;
        int iHashCode = (iM + (referenceOr == null ? 0 : referenceOr.hashCode())) * 31;
        Map<ContentType, MediaType> map = this.content;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.style;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.explode;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        GenericElement genericElement = this.example;
        int iHashCode5 = (iHashCode4 + (genericElement == null ? 0 : genericElement.hashCode())) * 31;
        Map<String, ReferenceOr<ExampleObject>> map2 = this.examples;
        int iHashCode6 = (iHashCode5 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, GenericElement> map3 = this.extensions;
        return iHashCode6 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Header(description=");
        sb.append(this.description);
        sb.append(", required=");
        sb.append(this.required);
        sb.append(", deprecated=");
        sb.append(this.deprecated);
        sb.append(", schema=");
        sb.append(this.schema);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", style=");
        sb.append(this.style);
        sb.append(", explode=");
        sb.append(this.explode);
        sb.append(", example=");
        sb.append(this.example);
        sb.append(", examples=");
        sb.append(this.examples);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Header$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Header;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Header$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Header;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Header> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Header.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 20));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Header _init_$lambda$0(Header header, Map map) {
                header.getClass();
                return Header.copy$default(header, null, false, false, null, null, null, null, null, null, map, 511, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Header$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Header() {
        this((String) null, false, false, (ReferenceOr) null, (Map) null, (String) null, (Boolean) null, (GenericElement) null, (Map) null, (Map) null, 1023, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Header(String str, boolean z, boolean z2, ReferenceOr<JsonSchema> referenceOr, Map<ContentType, MediaType> map, String str2, Boolean bool, GenericElement genericElement, Map<String, ? extends ReferenceOr<ExampleObject>> map2, Map<String, ? extends GenericElement> map3) {
        this.description = str;
        this.required = z;
        this.deprecated = z2;
        this.schema = referenceOr;
        this.content = map;
        this.style = str2;
        this.explode = bool;
        this.example = genericElement;
        this.examples = map2;
        this.extensions = map3;
    }

    public /* synthetic */ Header(String str, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str2, Boolean bool, GenericElement genericElement, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : referenceOr, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : genericElement, (i & 256) != 0 ? null : map2, (i & 512) != 0 ? null : map3);
    }
}
