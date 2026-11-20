package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0003TUVBÏ\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012&\b\u0002\u0010\u0011\u001a \u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\tj\u0002`\u0010\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019BÓ\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012 \u0010\u0011\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\t\u0018\u00010\u0006\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b#\u0010$J\"\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003¢\u0006\u0004\b%\u0010&J$\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b'\u0010&J\u0012\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b(\u0010)J.\u0010*\u001a \u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\tj\u0002`\u0010\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b*\u0010$J\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b+\u0010$J\u0012\u0010,\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b,\u0010-J\u001e\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b.\u0010&JÚ\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2&\b\u0002\u0010\u0011\u001a \u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\tj\u0002`\u0010\u0018\u00010\u00062\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b/\u00100J\u001b\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101HÖ\u0083\u0004¢\u0006\u0004\b4\u00105J\u0011\u00106\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b6\u00107J\u0011\u00108\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b8\u0010 J'\u0010A\u001a\u00020>2\u0006\u00109\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0001¢\u0006\u0004\b?\u0010@R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010B\u0012\u0004\bD\u0010E\u001a\u0004\bC\u0010 R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010F\u001a\u0004\bG\u0010\"R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010H\u001a\u0004\bI\u0010$R)\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010J\u001a\u0004\bK\u0010&R+\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010J\u001a\u0004\bL\u0010&R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010M\u001a\u0004\bN\u0010)R5\u0010\u0011\u001a \u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\tj\u0002`\u0010\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010H\u001a\u0004\bO\u0010$R\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010H\u001a\u0004\bP\u0010$R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010Q\u001a\u0004\bR\u0010-R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010J\u001a\u0004\bS\u0010&¨\u0006W"}, d2 = {"Lio/ktor/openapi/OpenApiDoc;", "Lio/ktor/openapi/Extensible;", "", "openapi", "Lio/ktor/openapi/OpenApiInfo;", "info", "", "Lio/ktor/openapi/Server;", "servers", "", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/PathItem;", "paths", "webhooks", "Lio/ktor/openapi/Components;", "components", "Lio/ktor/openapi/SecurityRequirement;", "security", "Lio/ktor/openapi/Tag;", "tags", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "Lio/ktor/openapi/GenericElement;", "extensions", "<init>", "(Ljava/lang/String;Lio/ktor/openapi/OpenApiInfo;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lio/ktor/openapi/Components;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ExternalDocs;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/ktor/openapi/OpenApiInfo;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lio/ktor/openapi/Components;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ExternalDocs;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Lio/ktor/openapi/OpenApiInfo;", "component3", "()Ljava/util/List;", "component4", "()Ljava/util/Map;", "component5", "component6", "()Lio/ktor/openapi/Components;", "component7", "component8", "component9", "()Lio/ktor/openapi/ExternalDocs;", "component10", "copy", "(Ljava/lang/String;Lio/ktor/openapi/OpenApiInfo;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lio/ktor/openapi/Components;Ljava/util/List;Ljava/util/List;Lio/ktor/openapi/ExternalDocs;Ljava/util/Map;)Lio/ktor/openapi/OpenApiDoc;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OpenApiDoc;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getOpenapi", "getOpenapi$annotations", "()V", "Lio/ktor/openapi/OpenApiInfo;", "getInfo", "Ljava/util/List;", "getServers", "Ljava/util/Map;", "getPaths", "getWebhooks", "Lio/ktor/openapi/Components;", "getComponents", "getSecurity", "getTags", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class OpenApiDoc implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPENAPI_VERSION = "3.1.1";
    private final Components components;
    private final Map<String, GenericElement> extensions;
    private final ExternalDocs externalDocs;
    private final OpenApiInfo info;
    private final String openapi;
    private final Map<String, ReferenceOr<PathItem>> paths;
    private final List<Map<String, List<String>>> security;
    private final List<Server> servers;
    private final List<Tag> tags;
    private final Map<String, ReferenceOr<PathItem>> webhooks;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0016\u001a\u00020\u0006\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00106\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u000205048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010=R,\u0010B\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0A0@0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010=R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020;0A8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020>0A8F¢\u0006\u0006\u001a\u0004\bE\u0010DR)\u0010H\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0A0@0A8F¢\u0006\u0006\u001a\u0004\bG\u0010D¨\u0006I"}, d2 = {"Lio/ktor/openapi/OpenApiDoc$Builder;", "Lio/ktor/openapi/OpenApiDocDsl;", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/openapi/Servers$Builder;", "", "configure", "servers", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Security$Builder;", "security", "", ContentDisposition.Parameters.Name, "description", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "tag", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;)V", "", "T", "value", "extension", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/openapi/OpenApiDoc;", "build", "()Lio/ktor/openapi/OpenApiDoc;", "openapiVersion", "Ljava/lang/String;", "getOpenapiVersion", "()Ljava/lang/String;", "setOpenapiVersion", "(Ljava/lang/String;)V", "Lio/ktor/openapi/OpenApiInfo;", "info", "Lio/ktor/openapi/OpenApiInfo;", "getInfo", "()Lio/ktor/openapi/OpenApiInfo;", "setInfo", "(Lio/ktor/openapi/OpenApiInfo;)V", "Lio/ktor/openapi/Components;", "components", "Lio/ktor/openapi/Components;", "getComponents", "()Lio/ktor/openapi/Components;", "setComponents", "(Lio/ktor/openapi/Components;)V", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "()Lio/ktor/openapi/ExternalDocs;", "setExternalDocs", "(Lio/ktor/openapi/ExternalDocs;)V", "", "Lio/ktor/openapi/GenericElement;", "extensions", "Ljava/util/Map;", "getExtensions", "()Ljava/util/Map;", "", "Lio/ktor/openapi/Server;", "_servers", "Ljava/util/List;", "Lio/ktor/openapi/Tag;", "_tags", "", "", "_securityRequirements", "getServers", "()Ljava/util/List;", "getTags", "tags", "getSecurityRequirements", "securityRequirements", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder implements OpenApiDocDsl {
        private Components components;
        private ExternalDocs externalDocs;
        private String openapiVersion = OpenApiDoc.OPENAPI_VERSION;
        private OpenApiInfo info = new OpenApiInfo("Untitled API", "1.0.0", (String) null, (String) null, (OpenApiInfo.Contact) null, (OpenApiInfo.License) null, (Map) null, 124, (DefaultConstructorMarker) null);
        private final Map<String, GenericElement> extensions = new LinkedHashMap();
        private final List<Server> _servers = new ArrayList();
        private final List<Tag> _tags = new ArrayList();
        private final List<Map<String, List<String>>> _securityRequirements = new ArrayList();

        public final OpenApiDoc build() {
            String openapiVersion = getOpenapiVersion();
            OpenApiInfo info = getInfo();
            List<Server> list = this._servers;
            List<Server> list2 = list.isEmpty() ? null : list;
            Components components = getComponents();
            List<Map<String, List<String>>> list3 = this._securityRequirements;
            List<Map<String, List<String>>> list4 = list3.isEmpty() ? null : list3;
            List<Tag> list5 = this._tags;
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list5) {
                if (hashSet.add(((Tag) obj).getName())) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            ExternalDocs externalDocs = getExternalDocs();
            Map<String, GenericElement> extensions = getExtensions();
            Map<String, GenericElement> map = extensions.isEmpty() ? null : extensions;
            EmptyMap emptyMap = EmptyMap.INSTANCE;
            return new OpenApiDoc(openapiVersion, info, list2, emptyMap, emptyMap, components, list4, arrayList, externalDocs, map);
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

        @Override // io.ktor.openapi.OpenApiDocDsl
        public Components getComponents() {
            return this.components;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public ExternalDocs getExternalDocs() {
            return this.externalDocs;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public OpenApiInfo getInfo() {
            return this.info;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public String getOpenapiVersion() {
            return this.openapiVersion;
        }

        public final List<Map<String, List<String>>> getSecurityRequirements() {
            return this._securityRequirements;
        }

        public final List<Server> getServers() {
            return this._servers;
        }

        public final List<Tag> getTags() {
            return this._tags;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void security(Function1 configure) {
            configure.getClass();
            Security.Builder builder = new Security.Builder();
            configure.invoke(builder);
            Iterator<T> it = builder.build$ktor_openapi_schema().getRequirements().iterator();
            while (it.hasNext()) {
                this._securityRequirements.add((Map) it.next());
            }
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void servers(Function1 configure) {
            configure.getClass();
            Servers.Builder builder = new Servers.Builder();
            configure.invoke(builder);
            Iterator<T> it = builder.build$ktor_openapi_schema().getServers().iterator();
            while (it.hasNext()) {
                this._servers.add((Server) it.next());
            }
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void setComponents(Components components) {
            this.components = components;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void setExternalDocs(ExternalDocs externalDocs) {
            this.externalDocs = externalDocs;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void setInfo(OpenApiInfo openApiInfo) {
            openApiInfo.getClass();
            this.info = openApiInfo;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void setOpenapiVersion(String str) {
            str.getClass();
            this.openapiVersion = str;
        }

        @Override // io.ktor.openapi.OpenApiDocDsl
        public void tag(String name, String description, ExternalDocs externalDocs) {
            name.getClass();
            this._tags.add(new Tag(name, description, externalDocs));
        }
    }

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 16);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 17)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 18)), null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 19)), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 20)), null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 21))};
    }

    public /* synthetic */ OpenApiDoc(int i, String str, OpenApiInfo openApiInfo, List list, Map map, Map map2, Components components, List list2, List list3, ExternalDocs externalDocs, Map map3, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            EnumsKt.throwMissingFieldException(OpenApiDoc$$serializer.INSTANCE.getDescriptor(), i, 2);
            throw null;
        }
        this.openapi = (i & 1) == 0 ? OPENAPI_VERSION : str;
        this.info = openApiInfo;
        if ((i & 4) == 0) {
            this.servers = null;
        } else {
            this.servers = list;
        }
        if ((i & 8) == 0) {
            this.paths = EmptyMap.INSTANCE;
        } else {
            this.paths = map;
        }
        if ((i & 16) == 0) {
            this.webhooks = null;
        } else {
            this.webhooks = map2;
        }
        if ((i & 32) == 0) {
            this.components = null;
        } else {
            this.components = components;
        }
        if ((i & 64) == 0) {
            this.security = null;
        } else {
            this.security = list2;
        }
        if ((i & 128) == 0) {
            this.tags = null;
        } else {
            this.tags = list3;
        }
        if ((i & 256) == 0) {
            this.externalDocs = null;
        } else {
            this.externalDocs = externalDocs;
        }
        if ((i & 512) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(Server.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(PathItem.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(PathItem.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new HashSetSerializer(new HashMapSerializer(stringSerializer, new HashSetSerializer(stringSerializer, (byte) 1), (byte) 1), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashSetSerializer(Tag$$serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenApiDoc copy$default(OpenApiDoc openApiDoc, String str, OpenApiInfo openApiInfo, List list, Map map, Map map2, Components components, List list2, List list3, ExternalDocs externalDocs, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openApiDoc.openapi;
        }
        if ((i & 2) != 0) {
            openApiInfo = openApiDoc.info;
        }
        if ((i & 4) != 0) {
            list = openApiDoc.servers;
        }
        if ((i & 8) != 0) {
            map = openApiDoc.paths;
        }
        if ((i & 16) != 0) {
            map2 = openApiDoc.webhooks;
        }
        if ((i & 32) != 0) {
            components = openApiDoc.components;
        }
        if ((i & 64) != 0) {
            list2 = openApiDoc.security;
        }
        if ((i & 128) != 0) {
            list3 = openApiDoc.tags;
        }
        if ((i & 256) != 0) {
            externalDocs = openApiDoc.externalDocs;
        }
        if ((i & 512) != 0) {
            map3 = openApiDoc.extensions;
        }
        ExternalDocs externalDocs2 = externalDocs;
        Map map4 = map3;
        List list4 = list2;
        List list5 = list3;
        Map map5 = map2;
        Components components2 = components;
        return openApiDoc.copy(str, openApiInfo, list, map, map5, components2, list4, list5, externalDocs2, map4);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(OpenApiDoc self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.openapi);
        output.encodeSerializableElement(serialDesc, 1, OpenApiInfo.Companion.Serializer.INSTANCE, self.info);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.servers != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.servers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.paths, EmptyMap.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.paths);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.webhooks != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.webhooks);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.components != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, Components.Companion.Serializer.INSTANCE, self.components);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.security != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.security);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.tags != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.tags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.externalDocs != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, ExternalDocs$$serializer.INSTANCE, self.externalDocs);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy) lazyArr[9].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOpenapi() {
        return this.openapi;
    }

    public final Map<String, GenericElement> component10() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OpenApiInfo getInfo() {
        return this.info;
    }

    public final List<Server> component3() {
        return this.servers;
    }

    public final Map<String, ReferenceOr<PathItem>> component4() {
        return this.paths;
    }

    public final Map<String, ReferenceOr<PathItem>> component5() {
        return this.webhooks;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Components getComponents() {
        return this.components;
    }

    public final List<Map<String, List<String>>> component7() {
        return this.security;
    }

    public final List<Tag> component8() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final OpenApiDoc copy(String openapi, OpenApiInfo info, List<Server> servers, Map<String, ? extends ReferenceOr<PathItem>> paths, Map<String, ? extends ReferenceOr<PathItem>> webhooks, Components components, List<? extends Map<String, ? extends List<String>>> security, List<Tag> tags, ExternalDocs externalDocs, Map<String, ? extends GenericElement> extensions) {
        openapi.getClass();
        info.getClass();
        paths.getClass();
        return new OpenApiDoc(openapi, info, servers, paths, webhooks, components, security, tags, externalDocs, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenApiDoc)) {
            return false;
        }
        OpenApiDoc openApiDoc = (OpenApiDoc) other;
        return Intrinsics.areEqual(this.openapi, openApiDoc.openapi) && Intrinsics.areEqual(this.info, openApiDoc.info) && Intrinsics.areEqual(this.servers, openApiDoc.servers) && Intrinsics.areEqual(this.paths, openApiDoc.paths) && Intrinsics.areEqual(this.webhooks, openApiDoc.webhooks) && Intrinsics.areEqual(this.components, openApiDoc.components) && Intrinsics.areEqual(this.security, openApiDoc.security) && Intrinsics.areEqual(this.tags, openApiDoc.tags) && Intrinsics.areEqual(this.externalDocs, openApiDoc.externalDocs) && Intrinsics.areEqual(this.extensions, openApiDoc.extensions);
    }

    public final Components getComponents() {
        return this.components;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final OpenApiInfo getInfo() {
        return this.info;
    }

    public final String getOpenapi() {
        return this.openapi;
    }

    public final Map<String, ReferenceOr<PathItem>> getPaths() {
        return this.paths;
    }

    public final List<Map<String, List<String>>> getSecurity() {
        return this.security;
    }

    public final List<Server> getServers() {
        return this.servers;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final Map<String, ReferenceOr<PathItem>> getWebhooks() {
        return this.webhooks;
    }

    public int hashCode() {
        int iHashCode = (this.info.hashCode() + (this.openapi.hashCode() * 31)) * 31;
        List<Server> list = this.servers;
        int iHashCode2 = (this.paths.hashCode() + ((iHashCode + (list == null ? 0 : list.hashCode())) * 31)) * 31;
        Map<String, ReferenceOr<PathItem>> map = this.webhooks;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Components components = this.components;
        int iHashCode4 = (iHashCode3 + (components == null ? 0 : components.hashCode())) * 31;
        List<Map<String, List<String>>> list2 = this.security;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Tag> list3 = this.tags;
        int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        ExternalDocs externalDocs = this.externalDocs;
        int iHashCode7 = (iHashCode6 + (externalDocs == null ? 0 : externalDocs.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode7 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenApiDoc(openapi=");
        sb.append(this.openapi);
        sb.append(", info=");
        sb.append(this.info);
        sb.append(", servers=");
        sb.append(this.servers);
        sb.append(", paths=");
        sb.append(this.paths);
        sb.append(", webhooks=");
        sb.append(this.webhooks);
        sb.append(", components=");
        sb.append(this.components);
        sb.append(", security=");
        sb.append(this.security);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", externalDocs=");
        sb.append(this.externalDocs);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0000¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/openapi/OpenApiDoc$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/openapi/OpenApiDoc$Builder;", "", "configure", "Lio/ktor/openapi/OpenApiDoc;", "build", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/openapi/OpenApiDoc;", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer$ktor_openapi_schema", "generatedSerializer", "", "OPENAPI_VERSION", "Ljava/lang/String;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/OpenApiDoc$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/OpenApiDoc;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<OpenApiDoc> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(OpenApiDoc.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 27));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OpenApiDoc _init_$lambda$0(OpenApiDoc openApiDoc, Map map) {
                openApiDoc.getClass();
                return OpenApiDoc.copy$default(openApiDoc, null, null, null, null, null, null, null, null, null, map, 511, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OpenApiDoc build(Function1 configure) {
            configure.getClass();
            Builder builder = new Builder();
            configure.invoke(builder);
            return builder.build();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return OpenApiDoc$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getOpenapi$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenApiDoc(String str, OpenApiInfo openApiInfo, List<Server> list, Map<String, ? extends ReferenceOr<PathItem>> map, Map<String, ? extends ReferenceOr<PathItem>> map2, Components components, List<? extends Map<String, ? extends List<String>>> list2, List<Tag> list3, ExternalDocs externalDocs, Map<String, ? extends GenericElement> map3) {
        str.getClass();
        openApiInfo.getClass();
        map.getClass();
        this.openapi = str;
        this.info = openApiInfo;
        this.servers = list;
        this.paths = map;
        this.webhooks = map2;
        this.components = components;
        this.security = list2;
        this.tags = list3;
        this.externalDocs = externalDocs;
        this.extensions = map3;
    }

    public /* synthetic */ OpenApiDoc(String str, OpenApiInfo openApiInfo, List list, Map map, Map map2, Components components, List list2, List list3, ExternalDocs externalDocs, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OPENAPI_VERSION : str, openApiInfo, (i & 4) != 0 ? null : list, (i & 8) != 0 ? EmptyMap.INSTANCE : map, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : components, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : list3, (i & 256) != 0 ? null : externalDocs, (i & 512) != 0 ? null : map3);
    }
}
