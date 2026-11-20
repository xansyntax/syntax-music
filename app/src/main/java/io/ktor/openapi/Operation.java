package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
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
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0003]^_Bû\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u000f\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0004\u0012\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000fj\u0002`\u001a¢\u0006\u0004\b\u001c\u0010\u001dBñ\u0001\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u0004\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012 \u0010\u0016\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u000f\u0018\u00010\u0004\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0004\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001c\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010$J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010$J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b+\u0010&J\u0018\u0010,\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b,\u0010-J$\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b2\u00103J*\u00104\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u000f\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b4\u0010&J\u0018\u00105\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b5\u0010&J\"\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000fj\u0002`\u001aHÆ\u0003¢\u0006\u0004\b6\u0010/J\u0084\u0002\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u000f\u0018\u00010\u00042\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00042\u001a\b\u0002\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000fj\u0002`\u001aHÆ\u0001¢\u0006\u0004\b7\u00108J\u001b\u0010;\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u000109HÖ\u0083\u0004¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u00020\u001eHÖ\u0081\u0004¢\u0006\u0004\b=\u0010>J\u0011\u0010?\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b?\u0010$J'\u0010H\u001a\u00020E2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bF\u0010GR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010I\u001a\u0004\bJ\u0010$R\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010K\u001a\u0004\bL\u0010&R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010I\u001a\u0004\bM\u0010$R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010I\u001a\u0004\bN\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010O\u001a\u0004\bP\u0010*R%\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010K\u001a\u0004\bQ\u0010&R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010R\u001a\u0004\bS\u0010-R+\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010T\u001a\u0004\bU\u0010/R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010V\u001a\u0004\bW\u00101R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010X\u001a\u0004\bY\u00103R1\u0010\u0016\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u000f\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010K\u001a\u0004\bZ\u0010&R\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010K\u001a\u0004\b[\u0010&R,\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000fj\u0002`\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010T\u001a\u0004\b\\\u0010/¨\u0006`"}, d2 = {"Lio/ktor/openapi/Operation;", "Lio/ktor/openapi/Extensible;", "", "operationId", "", "tags", "summary", "description", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Parameter;", "parameters", "Lio/ktor/openapi/RequestBody;", "requestBody", "", "Lio/ktor/openapi/Callback;", "callbacks", "Lio/ktor/openapi/Responses;", "responses", "", "deprecated", "security", "Lio/ktor/openapi/Server;", "servers", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Lio/ktor/openapi/Responses;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Lio/ktor/openapi/Responses;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "()Lio/ktor/openapi/ExternalDocs;", "component6", "component7", "()Lio/ktor/openapi/ReferenceOr;", "component8", "()Ljava/util/Map;", "component9", "()Lio/ktor/openapi/Responses;", "component10", "()Ljava/lang/Boolean;", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;Ljava/util/List;Lio/ktor/openapi/ReferenceOr;Ljava/util/Map;Lio/ktor/openapi/Responses;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lio/ktor/openapi/Operation;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Operation;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getOperationId", "Ljava/util/List;", "getTags", "getSummary", "getDescription", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "getParameters", "Lio/ktor/openapi/ReferenceOr;", "getRequestBody", "Ljava/util/Map;", "getCallbacks", "Lio/ktor/openapi/Responses;", "getResponses", "Ljava/lang/Boolean;", "getDeprecated", "getSecurity", "getServers", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Operation implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, ReferenceOr<Callback>> callbacks;
    private final Boolean deprecated;
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final ExternalDocs externalDocs;
    private final String operationId;
    private final List<ReferenceOr<Parameter>> parameters;
    private final ReferenceOr<RequestBody> requestBody;
    private final Responses responses;
    private final List<Map<String, List<String>>> security;
    private final List<Server> servers;
    private final String summary;
    private final List<String> tags;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000bJ!\u0010\u000f\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0014\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u0014\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u001c\u0010\u0010J!\u0010\u001e\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u001e\u0010\u0010J,\u0010\"\u001a\u00020\n\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u001f2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\"\u0010#J\u000f\u0010'\u001a\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u0018\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0096\u0001¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010-R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010.R$\u0010/\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u000bR$\u00104\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u0010\u000bR$\u00107\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00100\u001a\u0004\b8\u00102\"\u0004\b9\u0010\u000bR$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\b0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010.R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020J0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010.R\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020O0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010.R,\u0010R\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030Q0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010.R&\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160T0S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR$\u0010\u0012\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R.\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020]0S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010V\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0\u00038F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020J0\u00038F¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010L8F¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020O0\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010dR)\u0010k\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030Q0\u00038F¢\u0006\u0006\u001a\u0004\bj\u0010dR#\u0010m\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160T0Q8F¢\u0006\u0006\u001a\u0004\bl\u0010`¨\u0006n"}, d2 = {"Lio/ktor/openapi/Operation$Builder;", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "", "tag", "", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lio/ktor/openapi/Parameters$Builder;", "configure", "parameters", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/RequestBody$Builder;", "requestBody", "Lio/ktor/openapi/Responses$Builder;", "responses", "key", "Lio/ktor/openapi/Callback;", "value", "callback-Fy7AELE", "(Ljava/lang/String;Ljava/util/Map;)V", "callback", "Lio/ktor/openapi/Servers$Builder;", "servers", "Lio/ktor/openapi/Security$Builder;", "security", "", "T", ContentDisposition.Parameters.Name, "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/Operation;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Operation;", "build", "Lkotlin/reflect/KType;", LinkHeader.Parameters.Type, "Lio/ktor/openapi/JsonSchema;", "buildSchema", "(Lkotlin/reflect/KType;)Lio/ktor/openapi/JsonSchema;", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "summary", "Ljava/lang/String;", "getSummary", "()Ljava/lang/String;", "setSummary", "description", "getDescription", "setDescription", "operationId", "getOperationId", "setOperationId", "", "deprecated", "Ljava/lang/Boolean;", "getDeprecated", "()Ljava/lang/Boolean;", "setDeprecated", "(Ljava/lang/Boolean;)V", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "()Lio/ktor/openapi/ExternalDocs;", "setExternalDocs", "(Lio/ktor/openapi/ExternalDocs;)V", "", "_tags", "Lio/ktor/openapi/Parameter;", "_parameters", "Lio/ktor/openapi/Responses;", "_responses", "Lio/ktor/openapi/Responses;", "Lio/ktor/openapi/Server;", "_servers", "", "_securityRequirements", "", "Lio/ktor/openapi/ReferenceOr;", "_callbacks", "Ljava/util/Map;", "Lio/ktor/openapi/RequestBody;", "Lio/ktor/openapi/RequestBody;", "getRequestBody", "()Lio/ktor/openapi/RequestBody;", "setRequestBody", "(Lio/ktor/openapi/RequestBody;)V", "Lio/ktor/openapi/GenericElement;", "extensions", "getExtensions", "()Ljava/util/Map;", "setExtensions", "(Ljava/util/Map;)V", "getTags", "()Ljava/util/List;", "tags", "getParameters", "getResponses", "()Lio/ktor/openapi/Responses;", "getServers", "getSecurityRequirements", "securityRequirements", "getCallbacks", "callbacks", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements JsonSchemaInference {
        private final Map<String, ReferenceOr<Callback>> _callbacks;
        private final List<Parameter> _parameters;
        private Responses _responses;
        private final List<Map<String, List<String>>> _securityRequirements;
        private final List<Server> _servers;
        private final List<String> _tags;
        private final List<ContentType> defaultContentTypes;
        private Boolean deprecated;
        private String description;
        private Map<String, GenericElement> extensions;
        private ExternalDocs externalDocs;
        private String operationId;
        private RequestBody requestBody;
        private final JsonSchemaInference schemaInference;
        private String summary;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this.summary = "";
            this._tags = new ArrayList();
            this._parameters = new ArrayList();
            this._servers = new ArrayList();
            this._securityRequirements = new ArrayList();
            this._callbacks = new LinkedHashMap();
            this.extensions = new LinkedHashMap();
        }

        public final Operation build$ktor_openapi_schema() {
            List listDistinct = CollectionsKt.distinct(this._tags);
            List list = listDistinct.isEmpty() ? null : listDistinct;
            String str = this.summary;
            String str2 = this.description;
            ExternalDocs externalDocs = this.externalDocs;
            String str3 = this.operationId;
            List<Parameter> list2 = this._parameters;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl((Parameter) it.next())));
            }
            ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
            RequestBody requestBody = this.requestBody;
            ReferenceOr.Value valueM1792boximpl = requestBody != null ? ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(requestBody)) : null;
            Responses responses = this._responses;
            Map<String, ReferenceOr<Callback>> map = this._callbacks;
            Map<String, ReferenceOr<Callback>> map2 = map.isEmpty() ? null : map;
            Boolean bool = this.deprecated;
            List<Map<String, List<String>>> list3 = this._securityRequirements.isEmpty() ? null : this._securityRequirements;
            List<Server> list4 = this._servers.isEmpty() ? null : this._servers;
            Map<String, GenericElement> map3 = this.extensions;
            return new Operation(str3, list, str, str2, externalDocs, arrayList2, valueM1792boximpl, map2, responses, bool, list3, list4, map3.isEmpty() ? null : map3);
        }

        @Override // io.ktor.openapi.JsonSchemaInference
        public JsonSchema buildSchema(KType type) {
            type.getClass();
            return this.schemaInference.buildSchema(type);
        }

        /* JADX INFO: renamed from: callback-Fy7AELE, reason: not valid java name */
        public final void m1788callbackFy7AELE(String key, Map<String, ? extends PathItem> value) {
            key.getClass();
            value.getClass();
            this._callbacks.put(key, ReferenceOr.Value.m1792boximpl(ReferenceOr.Value.m1793constructorimpl(Callback.m1749boximpl(value))));
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

        public final Map<String, ReferenceOr<Callback>> getCallbacks() {
            return this._callbacks;
        }

        public final Boolean getDeprecated() {
            return this.deprecated;
        }

        public final String getDescription() {
            return this.description;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final ExternalDocs getExternalDocs() {
            return this.externalDocs;
        }

        public final String getOperationId() {
            return this.operationId;
        }

        public final List<Parameter> getParameters() {
            return this._parameters;
        }

        public final RequestBody getRequestBody() {
            return this.requestBody;
        }

        /* JADX INFO: renamed from: getResponses, reason: from getter */
        public final Responses get_responses() {
            return this._responses;
        }

        public final List<Map<String, List<String>>> getSecurityRequirements() {
            return this._securityRequirements;
        }

        public final List<Server> getServers() {
            return this._servers;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final List<String> getTags() {
            return this._tags;
        }

        public final void parameters(Function1 configure) {
            configure.getClass();
            Parameters.Builder builder = new Parameters.Builder(this.schemaInference, this.defaultContentTypes);
            configure.invoke(builder);
            Iterator<T> it = builder.build$ktor_openapi_schema().getParameters().iterator();
            while (it.hasNext()) {
                this._parameters.add((Parameter) it.next());
            }
        }

        public final void requestBody(Function1 configure) {
            configure.getClass();
            RequestBody.Builder builder = new RequestBody.Builder(this.schemaInference, this.defaultContentTypes);
            configure.invoke(builder);
            this.requestBody = builder.build$ktor_openapi_schema();
        }

        public final void responses(Function1 configure) {
            configure.getClass();
            Responses.Builder builder = new Responses.Builder(this.schemaInference, this.defaultContentTypes);
            configure.invoke(builder);
            this._responses = builder.build$ktor_openapi_schema();
        }

        public final void security(Function1 configure) {
            configure.getClass();
            Security.Builder builder = new Security.Builder();
            configure.invoke(builder);
            Iterator<T> it = builder.build$ktor_openapi_schema().getRequirements().iterator();
            while (it.hasNext()) {
                this._securityRequirements.add((Map) it.next());
            }
        }

        public final void servers(Function1 configure) {
            configure.getClass();
            Servers.Builder builder = new Servers.Builder();
            configure.invoke(builder);
            Iterator<T> it = builder.build$ktor_openapi_schema().getServers().iterator();
            while (it.hasNext()) {
                this._servers.add((Server) it.next());
            }
        }

        public final void setDeprecated(Boolean bool) {
            this.deprecated = bool;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final void setExtensions(Map<String, GenericElement> map) {
            map.getClass();
            this.extensions = map;
        }

        public final void setExternalDocs(ExternalDocs externalDocs) {
            this.externalDocs = externalDocs;
        }

        public final void setOperationId(String str) {
            this.operationId = str;
        }

        public final void setRequestBody(RequestBody requestBody) {
            this.requestBody = requestBody;
        }

        public final void setSummary(String str) {
            this.summary = str;
        }

        public final void tag(String tag) {
            tag.getClass();
            this._tags.add(tag);
        }
    }

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 25);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 26)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 27)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 28)), null, null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 29)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 1)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 2))};
    }

    public /* synthetic */ Operation(String str, List list, String str2, String str3, ExternalDocs externalDocs, List list2, ReferenceOr referenceOr, Map map, Responses responses, Boolean bool, List list3, List list4, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : externalDocs, (i & 32) != 0 ? null : list2, (i & 64) != 0 ? null : referenceOr, (i & 128) != 0 ? null : map, (i & 256) != 0 ? null : responses, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? null : list3, (i & 2048) != 0 ? null : list4, (i & 4096) != 0 ? null : map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(StringSerializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(Parameter.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ReferenceOr.Companion.Serializer(RequestBody.Companion.Serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Callback$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new HashSetSerializer(new HashMapSerializer(stringSerializer, new HashSetSerializer(stringSerializer, (byte) 1), (byte) 1), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashSetSerializer(Server.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Operation copy$default(Operation operation, String str, List list, String str2, String str3, ExternalDocs externalDocs, List list2, ReferenceOr referenceOr, Map map, Responses responses, Boolean bool, List list3, List list4, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = operation.operationId;
        }
        return operation.copy(str, (i & 2) != 0 ? operation.tags : list, (i & 4) != 0 ? operation.summary : str2, (i & 8) != 0 ? operation.description : str3, (i & 16) != 0 ? operation.externalDocs : externalDocs, (i & 32) != 0 ? operation.parameters : list2, (i & 64) != 0 ? operation.requestBody : referenceOr, (i & 128) != 0 ? operation.callbacks : map, (i & 256) != 0 ? operation.responses : responses, (i & 512) != 0 ? operation.deprecated : bool, (i & 1024) != 0 ? operation.security : list3, (i & 2048) != 0 ? operation.servers : list4, (i & 4096) != 0 ? operation.extensions : map2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Operation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.operationId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.operationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tags != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.tags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.summary != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.summary);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.externalDocs != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ExternalDocs$$serializer.INSTANCE, self.externalDocs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.parameters != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.parameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.requestBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.requestBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.callbacks != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.callbacks);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.responses != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, Responses.Companion.Serializer.INSTANCE, self.responses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.deprecated != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, BooleanSerializer.INSTANCE, self.deprecated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.security != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.security);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.servers != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.servers);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOperationId() {
        return this.operationId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getDeprecated() {
        return this.deprecated;
    }

    public final List<Map<String, List<String>>> component11() {
        return this.security;
    }

    public final List<Server> component12() {
        return this.servers;
    }

    public final Map<String, GenericElement> component13() {
        return this.extensions;
    }

    public final List<String> component2() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final List<ReferenceOr<Parameter>> component6() {
        return this.parameters;
    }

    public final ReferenceOr<RequestBody> component7() {
        return this.requestBody;
    }

    public final Map<String, ReferenceOr<Callback>> component8() {
        return this.callbacks;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Responses getResponses() {
        return this.responses;
    }

    public final Operation copy(String operationId, List<String> tags, String summary, String description, ExternalDocs externalDocs, List<? extends ReferenceOr<Parameter>> parameters, ReferenceOr<RequestBody> requestBody, Map<String, ? extends ReferenceOr<Callback>> callbacks, Responses responses, Boolean deprecated, List<? extends Map<String, ? extends List<String>>> security, List<Server> servers, Map<String, ? extends GenericElement> extensions) {
        return new Operation(operationId, tags, summary, description, externalDocs, parameters, requestBody, callbacks, responses, deprecated, security, servers, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Operation)) {
            return false;
        }
        Operation operation = (Operation) other;
        return Intrinsics.areEqual(this.operationId, operation.operationId) && Intrinsics.areEqual(this.tags, operation.tags) && Intrinsics.areEqual(this.summary, operation.summary) && Intrinsics.areEqual(this.description, operation.description) && Intrinsics.areEqual(this.externalDocs, operation.externalDocs) && Intrinsics.areEqual(this.parameters, operation.parameters) && Intrinsics.areEqual(this.requestBody, operation.requestBody) && Intrinsics.areEqual(this.callbacks, operation.callbacks) && Intrinsics.areEqual(this.responses, operation.responses) && Intrinsics.areEqual(this.deprecated, operation.deprecated) && Intrinsics.areEqual(this.security, operation.security) && Intrinsics.areEqual(this.servers, operation.servers) && Intrinsics.areEqual(this.extensions, operation.extensions);
    }

    public final Map<String, ReferenceOr<Callback>> getCallbacks() {
        return this.callbacks;
    }

    public final Boolean getDeprecated() {
        return this.deprecated;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final List<ReferenceOr<Parameter>> getParameters() {
        return this.parameters;
    }

    public final ReferenceOr<RequestBody> getRequestBody() {
        return this.requestBody;
    }

    public final Responses getResponses() {
        return this.responses;
    }

    public final List<Map<String, List<String>>> getSecurity() {
        return this.security;
    }

    public final List<Server> getServers() {
        return this.servers;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        String str = this.operationId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.tags;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.summary;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ExternalDocs externalDocs = this.externalDocs;
        int iHashCode5 = (iHashCode4 + (externalDocs == null ? 0 : externalDocs.hashCode())) * 31;
        List<ReferenceOr<Parameter>> list2 = this.parameters;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        ReferenceOr<RequestBody> referenceOr = this.requestBody;
        int iHashCode7 = (iHashCode6 + (referenceOr == null ? 0 : referenceOr.hashCode())) * 31;
        Map<String, ReferenceOr<Callback>> map = this.callbacks;
        int iHashCode8 = (iHashCode7 + (map == null ? 0 : map.hashCode())) * 31;
        Responses responses = this.responses;
        int iHashCode9 = (iHashCode8 + (responses == null ? 0 : responses.hashCode())) * 31;
        Boolean bool = this.deprecated;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<Map<String, List<String>>> list3 = this.security;
        int iHashCode11 = (iHashCode10 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Server> list4 = this.servers;
        int iHashCode12 = (iHashCode11 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode12 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Operation(operationId=");
        sb.append(this.operationId);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", summary=");
        sb.append(this.summary);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", externalDocs=");
        sb.append(this.externalDocs);
        sb.append(", parameters=");
        sb.append(this.parameters);
        sb.append(", requestBody=");
        sb.append(this.requestBody);
        sb.append(", callbacks=");
        sb.append(this.callbacks);
        sb.append(", responses=");
        sb.append(this.responses);
        sb.append(", deprecated=");
        sb.append(this.deprecated);
        sb.append(", security=");
        sb.append(this.security);
        sb.append(", servers=");
        sb.append(this.servers);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/ktor/openapi/Operation$Companion;", "", "<init>", "()V", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "Lkotlin/Function1;", "Lio/ktor/openapi/Operation$Builder;", "", "configure", "Lio/ktor/openapi/Operation;", "build", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;Lkotlin/jvm/functions/Function1;)Lio/ktor/openapi/Operation;", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer$ktor_openapi_schema", "generatedSerializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Operation$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Operation;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Operation> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Operation.INSTANCE.generatedSerializer$ktor_openapi_schema(), new CombinedContext$$ExternalSyntheticLambda0((byte) 1));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Operation _init_$lambda$0(Operation operation, Map map) {
                operation.getClass();
                return Operation.copy$default(operation, null, null, null, null, null, null, null, null, null, null, null, null, map, 4095, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Operation build$default(Companion companion, JsonSchemaInference jsonSchemaInference, List list, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonSchemaInference = KotlinxSerializerJsonSchemaInference.INSTANCE.getDefault();
            }
            if ((i & 2) != 0) {
                list = CollectionsKt__IterablesKt.listOf(ContentType.Application.INSTANCE.getJson());
            }
            return companion.build(jsonSchemaInference, list, function1);
        }

        public final Operation build(JsonSchemaInference schemaInference, List<ContentType> defaultContentTypes, Function1 configure) {
            schemaInference.getClass();
            defaultContentTypes.getClass();
            configure.getClass();
            if (defaultContentTypes.isEmpty()) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Default content types must not be empty");
                return null;
            }
            Builder builder = new Builder(schemaInference, defaultContentTypes);
            configure.invoke(builder);
            return builder.build$ktor_openapi_schema();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Operation$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Operation(int i, String str, List list, String str2, String str3, ExternalDocs externalDocs, List list2, ReferenceOr referenceOr, Map map, Responses responses, Boolean bool, List list3, List list4, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.operationId = null;
        } else {
            this.operationId = str;
        }
        if ((i & 2) == 0) {
            this.tags = null;
        } else {
            this.tags = list;
        }
        if ((i & 4) == 0) {
            this.summary = null;
        } else {
            this.summary = str2;
        }
        if ((i & 8) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 16) == 0) {
            this.externalDocs = null;
        } else {
            this.externalDocs = externalDocs;
        }
        if ((i & 32) == 0) {
            this.parameters = null;
        } else {
            this.parameters = list2;
        }
        if ((i & 64) == 0) {
            this.requestBody = null;
        } else {
            this.requestBody = referenceOr;
        }
        if ((i & 128) == 0) {
            this.callbacks = null;
        } else {
            this.callbacks = map;
        }
        if ((i & 256) == 0) {
            this.responses = null;
        } else {
            this.responses = responses;
        }
        if ((i & 512) == 0) {
            this.deprecated = null;
        } else {
            this.deprecated = bool;
        }
        if ((i & 1024) == 0) {
            this.security = null;
        } else {
            this.security = list3;
        }
        if ((i & 2048) == 0) {
            this.servers = null;
        } else {
            this.servers = list4;
        }
        if ((i & 4096) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Operation(String str, List<String> list, String str2, String str3, ExternalDocs externalDocs, List<? extends ReferenceOr<Parameter>> list2, ReferenceOr<RequestBody> referenceOr, Map<String, ? extends ReferenceOr<Callback>> map, Responses responses, Boolean bool, List<? extends Map<String, ? extends List<String>>> list3, List<Server> list4, Map<String, ? extends GenericElement> map2) {
        this.operationId = str;
        this.tags = list;
        this.summary = str2;
        this.description = str3;
        this.externalDocs = externalDocs;
        this.parameters = list2;
        this.requestBody = referenceOr;
        this.callbacks = map;
        this.responses = responses;
        this.deprecated = bool;
        this.security = list3;
        this.servers = list4;
        this.extensions = map2;
    }

    public Operation() {
        this((String) null, (List) null, (String) null, (String) null, (ExternalDocs) null, (List) null, (ReferenceOr) null, (Map) null, (Responses) null, (Boolean) null, (List) null, (List) null, (Map) null, 8191, (DefaultConstructorMarker) null);
    }
}
