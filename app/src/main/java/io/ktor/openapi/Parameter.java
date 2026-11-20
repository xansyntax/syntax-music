package io.ktor.openapi;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
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
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\b\u0087\b\u0018\u0000 c2\u00020\u0001:\u0003cdeBê\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0018\u00010\r\u0012\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0002`\u001c¢\u0006\u0004\b\u001e\u0010\u001fBÓ\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0018\u00010\r\u0012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\r\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001e\u0010$J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010&J\u0010\u0010*\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0018\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b-\u0010.J-\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b/\u00100J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010&J\u0012\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b4\u00103J\u0012\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b5\u00103J\u0012\u00106\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b6\u00107J$\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b8\u00100J\"\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0002`\u001cHÆ\u0003¢\u0006\u0004\b9\u00100Jõ\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0018\u00010\r2\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0002`\u001cHÆ\u0001¢\u0006\u0004\b:\u0010;J\u001b\u0010>\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010<HÖ\u0083\u0004¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u00020 HÖ\u0081\u0004¢\u0006\u0004\b@\u0010AJ\u0011\u0010B\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\bB\u0010&J'\u0010K\u001a\u00020H2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020FH\u0001¢\u0006\u0004\bI\u0010JR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010L\u001a\u0004\bM\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010N\u001a\u0004\bO\u0010(R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010L\u001a\u0004\bP\u0010&R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010Q\u001a\u0004\bR\u0010+R\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010Q\u001a\u0004\bS\u0010+R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010T\u001a\u0004\bU\u0010.R4\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\t0\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0013\u0010V\u001a\u0004\bW\u00100R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010L\u001a\u0004\bX\u0010&R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0015\u0010Y\u001a\u0004\bZ\u00103R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010Y\u001a\u0004\b[\u00103R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010Y\u0012\u0004\b]\u0010^\u001a\u0004\b\\\u00103R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010_\u001a\u0004\b`\u00107R+\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u001b\u0010V\u001a\u0004\ba\u00100R,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0002`\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010V\u001a\u0004\bb\u00100¨\u0006f"}, d2 = {"Lio/ktor/openapi/Parameter;", "Lio/ktor/openapi/Extensible;", "", ContentDisposition.Parameters.Name, "Lio/ktor/openapi/ParameterType;", "in", "description", "", "required", "deprecated", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/JsonSchema;", "schema", "", "Lio/ktor/http/ContentType;", "Lkotlinx/serialization/Serializable;", "with", "Lio/ktor/openapi/ContentTypeSerializer;", "Lio/ktor/openapi/MediaType;", "content", "style", "explode", "allowReserved", "allowEmptyValue", "Lio/ktor/openapi/GenericElement;", "example", "Lio/ktor/openapi/ExampleObject;", "examples", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Lio/ktor/openapi/ParameterType;Ljava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/ktor/openapi/ParameterType;Ljava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Lio/ktor/openapi/ParameterType;", "component3", "component4", "()Z", "component5", "component6", "()Lio/ktor/openapi/ReferenceOr;", "component7", "()Ljava/util/Map;", "component8", "component9", "()Ljava/lang/Boolean;", "component10", "component11", "component12", "()Lio/ktor/openapi/GenericElement;", "component13", "component14", "copy", "(Ljava/lang/String;Lio/ktor/openapi/ParameterType;Ljava/lang/String;ZZLio/ktor/openapi/ReferenceOr;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lio/ktor/openapi/GenericElement;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/Parameter;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Parameter;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "Lio/ktor/openapi/ParameterType;", "getIn", "getDescription", "Z", "getRequired", "getDeprecated", "Lio/ktor/openapi/ReferenceOr;", "getSchema", "Ljava/util/Map;", "getContent", "getStyle", "Ljava/lang/Boolean;", "getExplode", "getAllowReserved", "getAllowEmptyValue", "getAllowEmptyValue$annotations", "()V", "Lio/ktor/openapi/GenericElement;", "getExample", "getExamples", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Parameter implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean allowEmptyValue;
    private final Boolean allowReserved;
    private final Map<ContentType, MediaType> content;
    private final boolean deprecated;
    private final String description;
    private final GenericElement example;
    private final Map<String, ReferenceOr<ExampleObject>> examples;
    private final Boolean explode;
    private final Map<String, GenericElement> extensions;
    private final ParameterType in;
    private final String name;
    private final boolean required;
    private final ReferenceOr<JsonSchema> schema;
    private final String style;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u00020\n*\u00020\u00042\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0015\u001a\u00020\n\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R$\u0010>\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR$\u0010G\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010%\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R$\u0010J\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR$\u0010S\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010K\u001a\u0004\bT\u0010M\"\u0004\bU\u0010OR$\u0010\u0018\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R4\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\\0D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010F\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR#\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020V0D8\u0006¢\u0006\f\n\u0004\bb\u0010F\u001a\u0004\bc\u0010_R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020e0d8F¢\u0006\u0006\u001a\u0004\bf\u0010_¨\u0006g"}, d2 = {"Lio/ktor/openapi/Parameter$Builder;", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "Lkotlin/Function1;", "Lio/ktor/openapi/MediaType$Builder;", "", "configure", "content", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Lio/ktor/http/ContentType;Lkotlin/jvm/functions/Function1;)V", "", "T", "", ContentDisposition.Parameters.Name, "value", "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/ExampleObject;", "example", "(Ljava/lang/String;Lio/ktor/openapi/ExampleObject;)V", "Lio/ktor/openapi/Parameter;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Parameter;", "build", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lio/ktor/openapi/ParameterType;", "in", "Lio/ktor/openapi/ParameterType;", "getIn", "()Lio/ktor/openapi/ParameterType;", "setIn", "(Lio/ktor/openapi/ParameterType;)V", "description", "getDescription", "setDescription", "", "required", "Z", "getRequired", "()Z", "setRequired", "(Z)V", "deprecated", "getDeprecated", "setDeprecated", "schema", "Lio/ktor/openapi/JsonSchema;", "getSchema", "()Lio/ktor/openapi/JsonSchema;", "setSchema", "(Lio/ktor/openapi/JsonSchema;)V", "", "_content", "Ljava/util/Map;", "style", "getStyle", "setStyle", "explode", "Ljava/lang/Boolean;", "getExplode", "()Ljava/lang/Boolean;", "setExplode", "(Ljava/lang/Boolean;)V", "allowReserved", "getAllowReserved", "setAllowReserved", "allowEmptyValue", "getAllowEmptyValue", "setAllowEmptyValue", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/GenericElement;", "getExample", "()Lio/ktor/openapi/GenericElement;", "setExample", "(Lio/ktor/openapi/GenericElement;)V", "Lio/ktor/openapi/ReferenceOr;", "examples", "getExamples", "()Ljava/util/Map;", "setExamples", "(Ljava/util/Map;)V", "extensions", "getExtensions", "", "Lio/ktor/openapi/MediaType;", "getContent", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements JsonSchemaInference {
        private final Map<ContentType, MediaType.Builder> _content;
        private Boolean allowEmptyValue;
        private Boolean allowReserved;
        private final List<ContentType> defaultContentTypes;
        private boolean deprecated;
        private String description;
        private GenericElement example;
        private Map<String, ReferenceOr<ExampleObject>> examples;
        private Boolean explode;
        private final Map<String, GenericElement> extensions;
        private ParameterType in;
        private String name;
        private boolean required;
        private JsonSchema schema;
        private final JsonSchemaInference schemaInference;
        private String style;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this._content = new LinkedHashMap();
            this.examples = new LinkedHashMap();
            this.extensions = new LinkedHashMap();
        }

        public static /* synthetic */ void invoke$default(Builder builder, ContentType contentType, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 22);
            }
            builder.invoke(contentType, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(MediaType.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Parameter build$ktor_openapi_schema() {
            String str = this.name;
            if (str == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Parameter name is required");
                return null;
            }
            str.getClass();
            ParameterType parameterType = this.in;
            String str2 = this.description;
            boolean z = this.required;
            boolean z2 = this.deprecated;
            JsonSchema jsonSchema = this.schema;
            ReferenceOr.Value valueM1792boximpl = jsonSchema != null ? ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(jsonSchema)) : null;
            Map<ContentType, MediaType.Builder> map = this._content;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ((MediaType.Builder) entry.getValue()).build$ktor_openapi_schema());
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap.isEmpty() ? null : linkedHashMap;
            String str3 = this.style;
            Boolean bool = this.explode;
            Boolean bool2 = this.allowReserved;
            Boolean bool3 = this.allowEmptyValue;
            GenericElement genericElement = this.example;
            Map<String, ReferenceOr<ExampleObject>> map2 = this.examples;
            if (map2.isEmpty()) {
                map2 = null;
            }
            Map<String, GenericElement> map3 = this.extensions;
            return new Parameter(str, parameterType, str2, z, z2, valueM1792boximpl, linkedHashMap2, str3, bool, bool2, bool3, genericElement, map2, map3.isEmpty() ? null : map3);
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

        public final Boolean getAllowEmptyValue() {
            return this.allowEmptyValue;
        }

        public final Boolean getAllowReserved() {
            return this.allowReserved;
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

        public final ParameterType getIn() {
            return this.in;
        }

        public final String getName() {
            return this.name;
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
            Map<ContentType, MediaType.Builder> map = this._content;
            MediaType.Builder builder = map.get(contentType);
            if (builder == null) {
                builder = new MediaType.Builder(this.schemaInference);
                map.put(contentType, builder);
            }
            function1.invoke(builder);
        }

        public final void setAllowEmptyValue(Boolean bool) {
            this.allowEmptyValue = bool;
        }

        public final void setAllowReserved(Boolean bool) {
            this.allowReserved = bool;
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

        public final void setIn(ParameterType parameterType) {
            this.in = parameterType;
        }

        public final void setName(String str) {
            this.name = str;
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
        Xml$$ExternalSyntheticLambda0 xml$$ExternalSyntheticLambda0 = new Xml$$ExternalSyntheticLambda0((byte) 3);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, xml$$ExternalSyntheticLambda0), null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 4)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 5)), null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 6)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 7)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 8))};
    }

    public /* synthetic */ Parameter(int i, String str, ParameterType parameterType, String str2, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str3, Boolean bool, Boolean bool2, Boolean bool3, GenericElement genericElement, Map map2, Map map3, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(Parameter$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.in = null;
        } else {
            this.in = parameterType;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 8) == 0) {
            this.required = false;
        } else {
            this.required = z;
        }
        if ((i & 16) == 0) {
            this.deprecated = false;
        } else {
            this.deprecated = z2;
        }
        if ((i & 32) == 0) {
            this.schema = null;
        } else {
            this.schema = referenceOr;
        }
        if ((i & 64) == 0) {
            this.content = null;
        } else {
            this.content = map;
        }
        if ((i & 128) == 0) {
            this.style = null;
        } else {
            this.style = str3;
        }
        if ((i & 256) == 0) {
            this.explode = null;
        } else {
            this.explode = bool;
        }
        if ((i & 512) == 0) {
            this.allowReserved = null;
        } else {
            this.allowReserved = bool2;
        }
        if ((i & 1024) == 0) {
            this.allowEmptyValue = null;
        } else {
            this.allowEmptyValue = bool3;
        }
        if ((i & 2048) == 0) {
            this.example = null;
        } else {
            this.example = genericElement;
        }
        if ((i & 4096) == 0) {
            this.examples = null;
        } else {
            this.examples = map2;
        }
        if ((i & 8192) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return ParameterType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ReferenceOr.Companion.Serializer(JsonSchema$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(ContentTypeSerializer.INSTANCE, MediaType.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(ExampleObject.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Parameter copy$default(Parameter parameter, String str, ParameterType parameterType, String str2, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str3, Boolean bool, Boolean bool2, Boolean bool3, GenericElement genericElement, Map map2, Map map3, int i, Object obj) {
        return parameter.copy((i & 1) != 0 ? parameter.name : str, (i & 2) != 0 ? parameter.in : parameterType, (i & 4) != 0 ? parameter.description : str2, (i & 8) != 0 ? parameter.required : z, (i & 16) != 0 ? parameter.deprecated : z2, (i & 32) != 0 ? parameter.schema : referenceOr, (i & 64) != 0 ? parameter.content : map, (i & 128) != 0 ? parameter.style : str3, (i & 256) != 0 ? parameter.explode : bool, (i & 512) != 0 ? parameter.allowReserved : bool2, (i & 1024) != 0 ? parameter.allowEmptyValue : bool3, (i & 2048) != 0 ? parameter.example : genericElement, (i & 4096) != 0 ? parameter.examples : map2, (i & 8192) != 0 ? parameter.extensions : map3);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Parameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.in != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.in);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.required) {
            output.encodeBooleanElement(serialDesc, 3, self.required);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.deprecated) {
            output.encodeBooleanElement(serialDesc, 4, self.deprecated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.schema != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.schema);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.style != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.style);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.explode != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, BooleanSerializer.INSTANCE, self.explode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.allowReserved != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.allowReserved);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.allowEmptyValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, BooleanSerializer.INSTANCE, self.allowEmptyValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.example != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.example);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.examples != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.examples);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 13) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 13, (SerializationStrategy) lazyArr[13].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getAllowReserved() {
        return this.allowReserved;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getAllowEmptyValue() {
        return this.allowEmptyValue;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final GenericElement getExample() {
        return this.example;
    }

    public final Map<String, ReferenceOr<ExampleObject>> component13() {
        return this.examples;
    }

    public final Map<String, GenericElement> component14() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ParameterType getIn() {
        return this.in;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDeprecated() {
        return this.deprecated;
    }

    public final ReferenceOr<JsonSchema> component6() {
        return this.schema;
    }

    public final Map<ContentType, MediaType> component7() {
        return this.content;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getExplode() {
        return this.explode;
    }

    public final Parameter copy(String name, ParameterType in, String description, boolean required, boolean deprecated, ReferenceOr<JsonSchema> schema, Map<ContentType, MediaType> content, String style, Boolean explode, Boolean allowReserved, Boolean allowEmptyValue, GenericElement example, Map<String, ? extends ReferenceOr<ExampleObject>> examples, Map<String, ? extends GenericElement> extensions) {
        name.getClass();
        return new Parameter(name, in, description, required, deprecated, schema, content, style, explode, allowReserved, allowEmptyValue, example, examples, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) other;
        return Intrinsics.areEqual(this.name, parameter.name) && this.in == parameter.in && Intrinsics.areEqual(this.description, parameter.description) && this.required == parameter.required && this.deprecated == parameter.deprecated && Intrinsics.areEqual(this.schema, parameter.schema) && Intrinsics.areEqual(this.content, parameter.content) && Intrinsics.areEqual(this.style, parameter.style) && Intrinsics.areEqual(this.explode, parameter.explode) && Intrinsics.areEqual(this.allowReserved, parameter.allowReserved) && Intrinsics.areEqual(this.allowEmptyValue, parameter.allowEmptyValue) && Intrinsics.areEqual(this.example, parameter.example) && Intrinsics.areEqual(this.examples, parameter.examples) && Intrinsics.areEqual(this.extensions, parameter.extensions);
    }

    public final Boolean getAllowEmptyValue() {
        return this.allowEmptyValue;
    }

    public final Boolean getAllowReserved() {
        return this.allowReserved;
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

    public final ParameterType getIn() {
        return this.in;
    }

    public final String getName() {
        return this.name;
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
        int iHashCode = this.name.hashCode() * 31;
        ParameterType parameterType = this.in;
        int iHashCode2 = (iHashCode + (parameterType == null ? 0 : parameterType.hashCode())) * 31;
        String str = this.description;
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31, this.required, 31), this.deprecated, 31);
        ReferenceOr<JsonSchema> referenceOr = this.schema;
        int iHashCode3 = (iM + (referenceOr == null ? 0 : referenceOr.hashCode())) * 31;
        Map<ContentType, MediaType> map = this.content;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.style;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.explode;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.allowReserved;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.allowEmptyValue;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        GenericElement genericElement = this.example;
        int iHashCode9 = (iHashCode8 + (genericElement == null ? 0 : genericElement.hashCode())) * 31;
        Map<String, ReferenceOr<ExampleObject>> map2 = this.examples;
        int iHashCode10 = (iHashCode9 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, GenericElement> map3 = this.extensions;
        return iHashCode10 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Parameter(name=");
        sb.append(this.name);
        sb.append(", in=");
        sb.append(this.in);
        sb.append(", description=");
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
        sb.append(", allowReserved=");
        sb.append(this.allowReserved);
        sb.append(", allowEmptyValue=");
        sb.append(this.allowEmptyValue);
        sb.append(", example=");
        sb.append(this.example);
        sb.append(", examples=");
        sb.append(this.examples);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Parameter$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Parameter;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Parameter$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Parameter;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Parameter> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Parameter.INSTANCE.generatedSerializer$ktor_openapi_schema(), new CombinedContext$$ExternalSyntheticLambda0((byte) 2));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Parameter _init_$lambda$0(Parameter parameter, Map map) {
                parameter.getClass();
                return Parameter.copy$default(parameter, null, null, null, false, false, null, null, null, null, null, null, null, null, map, 8191, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Parameter$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public static /* synthetic */ void getAllowEmptyValue$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Parameter(String str, ParameterType parameterType, String str2, boolean z, boolean z2, ReferenceOr<JsonSchema> referenceOr, Map<ContentType, MediaType> map, String str3, Boolean bool, Boolean bool2, Boolean bool3, GenericElement genericElement, Map<String, ? extends ReferenceOr<ExampleObject>> map2, Map<String, ? extends GenericElement> map3) {
        str.getClass();
        this.name = str;
        this.in = parameterType;
        this.description = str2;
        this.required = z;
        this.deprecated = z2;
        this.schema = referenceOr;
        this.content = map;
        this.style = str3;
        this.explode = bool;
        this.allowReserved = bool2;
        this.allowEmptyValue = bool3;
        this.example = genericElement;
        this.examples = map2;
        this.extensions = map3;
    }

    public /* synthetic */ Parameter(String str, ParameterType parameterType, String str2, boolean z, boolean z2, ReferenceOr referenceOr, Map map, String str3, Boolean bool, Boolean bool2, Boolean bool3, GenericElement genericElement, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : parameterType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false, (i & 32) != 0 ? null : referenceOr, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : bool2, (i & 1024) != 0 ? null : bool3, (i & 2048) != 0 ? null : genericElement, (i & 4096) != 0 ? null : map2, (i & 8192) != 0 ? null : map3);
    }
}
