package io.ktor.openapi;

import io.ktor.http.ContentType;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
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
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0003TUVBÅ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000e\u0012\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0002`\u0016¢\u0006\u0004\b\u0018\u0010\u0019B»\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000e\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0018\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b$\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b%\u0010#J\u0012\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b&\u0010#J\u0012\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010#J\u0012\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b(\u0010#J\u0012\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b)\u0010#J\u0012\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b*\u0010#J\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b+\u0010,J\u001e\u0010-\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b-\u0010,J\"\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0002`\u0016HÆ\u0003¢\u0006\u0004\b.\u0010/JÎ\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000e2\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0002`\u0016HÆ\u0001¢\u0006\u0004\b0\u00101J\u001b\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u000102HÖ\u0083\u0004¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b7\u00108J\u0011\u00109\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b9\u0010 J'\u0010B\u001a\u00020?2\u0006\u0010:\u001a\u00020\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0001¢\u0006\u0004\b@\u0010AR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010C\u001a\u0004\bD\u0010 R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010C\u001a\u0004\bE\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010F\u001a\u0004\bG\u0010#R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010F\u001a\u0004\bH\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010F\u001a\u0004\bI\u0010#R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010F\u001a\u0004\bJ\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010F\u001a\u0004\bK\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010F\u001a\u0004\bL\u0010#R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010F\u001a\u0004\bM\u0010#R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010F\u001a\u0004\bN\u0010#R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010O\u001a\u0004\bP\u0010,R%\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u0010O\u001a\u0004\bQ\u0010,R,\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\u0002`\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010R\u001a\u0004\bS\u0010/¨\u0006W"}, d2 = {"Lio/ktor/openapi/PathItem;", "Lio/ktor/openapi/Extensible;", "", "summary", "description", "Lio/ktor/openapi/Operation;", "put", "post", "delete", "options", "get", "head", "patch", "trace", "", "Lio/ktor/openapi/Server;", "servers", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Parameter;", "parameters", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/openapi/Operation;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "()Ljava/util/List;", "component12", "component13", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Lio/ktor/openapi/Operation;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lio/ktor/openapi/PathItem;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/PathItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getSummary", "getDescription", "Lio/ktor/openapi/Operation;", "getPut", "getPost", "getDelete", "getOptions", "getGet", "getHead", "getPatch", "getTrace", "Ljava/util/List;", "getServers", "getParameters", "Ljava/util/Map;", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class PathItem implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Operation delete;
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final Operation get;
    private final Operation head;
    private final Operation options;
    private final List<ReferenceOr<Parameter>> parameters;
    private final Operation patch;
    private final Operation post;
    private final Operation put;
    private final List<Server> servers;
    private final String summary;
    private final Operation trace;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0014\u0010\u0012J!\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0015\u0010\u0012J!\u0010\u0016\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0016\u0010\u0012J!\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0017\u0010\u0012J!\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0018\u0010\u0012J!\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u0019\u0010\u0012J!\u0010\u001a\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u001b\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u001c\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u001c\u0010\u0012J\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010,R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010,R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010,R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010,R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010,R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010!R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010!R.\u00104\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u000203028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020.0\u00048F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002000\u00048F¢\u0006\u0006\u001a\u0004\b<\u0010;¨\u0006="}, d2 = {"Lio/ktor/openapi/PathItem$Builder;", "", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "Lkotlin/Function1;", "Lio/ktor/openapi/Operation$Builder;", "", "configure", "Lio/ktor/openapi/Operation;", "buildOperation", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/openapi/Operation;", "Lio/ktor/openapi/Parameters$Builder;", "parameters", "(Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Servers$Builder;", "servers", "delete", "options", "get", "head", "patch", "trace", "put", "post", "Lio/ktor/openapi/PathItem;", "build", "()Lio/ktor/openapi/PathItem;", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "", "summary", "Ljava/lang/String;", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "Lio/ktor/openapi/Operation;", "", "Lio/ktor/openapi/Parameter;", "_parameters", "Lio/ktor/openapi/Server;", "_servers", "", "Lio/ktor/openapi/GenericElement;", "extensions", "Ljava/util/Map;", "getExtensions", "()Ljava/util/Map;", "setExtensions", "(Ljava/util/Map;)V", "getParameters", "()Ljava/util/List;", "getServers", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final List<Parameter> _parameters;
        private final List<Server> _servers;
        private final List<ContentType> defaultContentTypes;
        private Operation delete;
        private String description;
        private Map<String, GenericElement> extensions;
        private Operation get;
        private Operation head;
        private Operation options;
        private Operation patch;
        private Operation post;
        private Operation put;
        private final JsonSchemaInference schemaInference;
        private String summary;
        private Operation trace;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this._parameters = new ArrayList();
            this._servers = new ArrayList();
            this.extensions = new LinkedHashMap();
        }

        private final Operation buildOperation(Function1 configure) {
            Operation.Builder builder = new Operation.Builder(this.schemaInference, this.defaultContentTypes);
            configure.invoke(builder);
            return builder.build$ktor_openapi_schema();
        }

        public final PathItem build() {
            String str = this.summary;
            String str2 = this.description;
            Operation operation = this.put;
            Operation operation2 = this.post;
            Operation operation3 = this.delete;
            Operation operation4 = this.options;
            Operation operation5 = this.get;
            Operation operation6 = this.head;
            Operation operation7 = this.patch;
            Operation operation8 = this.trace;
            List<Server> list = this._servers;
            if (list.isEmpty()) {
                list = null;
            }
            List<Parameter> list2 = this._parameters;
            ReferenceOr.Companion companion = ReferenceOr.INSTANCE;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(companion.value((Parameter) it.next()));
            }
            ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
            Map<String, GenericElement> map = this.extensions;
            return new PathItem(str, str2, operation, operation2, operation3, operation4, operation5, operation6, operation7, operation8, list, arrayList2, map.isEmpty() ? null : map);
        }

        public final void delete(Function1 configure) {
            configure.getClass();
            this.delete = buildOperation(configure);
        }

        public final void get(Function1 configure) {
            configure.getClass();
            this.get = buildOperation(configure);
        }

        public final String getDescription() {
            return this.description;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final List<Parameter> getParameters() {
            return this._parameters;
        }

        public final List<Server> getServers() {
            return this._servers;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final void head(Function1 configure) {
            configure.getClass();
            this.head = buildOperation(configure);
        }

        public final void options(Function1 configure) {
            configure.getClass();
            this.options = buildOperation(configure);
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

        public final void patch(Function1 configure) {
            configure.getClass();
            this.patch = buildOperation(configure);
        }

        public final void post(Function1 configure) {
            configure.getClass();
            this.post = buildOperation(configure);
        }

        public final void put(Function1 configure) {
            configure.getClass();
            this.put = buildOperation(configure);
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

        public final void setDescription(String str) {
            this.description = str;
        }

        public final void setExtensions(Map<String, GenericElement> map) {
            map.getClass();
            this.extensions = map;
        }

        public final void setSummary(String str) {
            this.summary = str;
        }

        public final void trace(Function1 configure) {
            configure.getClass();
            this.trace = buildOperation(configure);
        }
    }

    static {
        Xml$$ExternalSyntheticLambda0 xml$$ExternalSyntheticLambda0 = new Xml$$ExternalSyntheticLambda0((byte) 11);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, xml$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 12)), ResultKt.lazy(lazyThreadSafetyMode, new Xml$$ExternalSyntheticLambda0((byte) 13))};
    }

    public /* synthetic */ PathItem(String str, String str2, Operation operation, Operation operation2, Operation operation3, Operation operation4, Operation operation5, Operation operation6, Operation operation7, Operation operation8, List list, List list2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : operation, (i & 8) != 0 ? null : operation2, (i & 16) != 0 ? null : operation3, (i & 32) != 0 ? null : operation4, (i & 64) != 0 ? null : operation5, (i & 128) != 0 ? null : operation6, (i & 256) != 0 ? null : operation7, (i & 512) != 0 ? null : operation8, (i & 1024) != 0 ? null : list, (i & 2048) != 0 ? null : list2, (i & 4096) != 0 ? null : map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(Server.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashSetSerializer(new ReferenceOr.Companion.Serializer(Parameter.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PathItem copy$default(PathItem pathItem, String str, String str2, Operation operation, Operation operation2, Operation operation3, Operation operation4, Operation operation5, Operation operation6, Operation operation7, Operation operation8, List list, List list2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pathItem.summary;
        }
        return pathItem.copy(str, (i & 2) != 0 ? pathItem.description : str2, (i & 4) != 0 ? pathItem.put : operation, (i & 8) != 0 ? pathItem.post : operation2, (i & 16) != 0 ? pathItem.delete : operation3, (i & 32) != 0 ? pathItem.options : operation4, (i & 64) != 0 ? pathItem.get : operation5, (i & 128) != 0 ? pathItem.head : operation6, (i & 256) != 0 ? pathItem.patch : operation7, (i & 512) != 0 ? pathItem.trace : operation8, (i & 1024) != 0 ? pathItem.servers : list, (i & 2048) != 0 ? pathItem.parameters : list2, (i & 4096) != 0 ? pathItem.extensions : map);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(PathItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.summary != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.summary);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.put != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, Operation.Companion.Serializer.INSTANCE, self.put);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.post != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, Operation.Companion.Serializer.INSTANCE, self.post);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.delete != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, Operation.Companion.Serializer.INSTANCE, self.delete);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.options != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, Operation.Companion.Serializer.INSTANCE, self.options);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.get != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, Operation.Companion.Serializer.INSTANCE, self.get);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.head != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, Operation.Companion.Serializer.INSTANCE, self.head);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.patch != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, Operation.Companion.Serializer.INSTANCE, self.patch);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.trace != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, Operation.Companion.Serializer.INSTANCE, self.trace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.servers != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.servers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.parameters != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.parameters);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Operation getTrace() {
        return this.trace;
    }

    public final List<Server> component11() {
        return this.servers;
    }

    public final List<ReferenceOr<Parameter>> component12() {
        return this.parameters;
    }

    public final Map<String, GenericElement> component13() {
        return this.extensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Operation getPut() {
        return this.put;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Operation getPost() {
        return this.post;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Operation getDelete() {
        return this.delete;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Operation getOptions() {
        return this.options;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Operation getGet() {
        return this.get;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Operation getHead() {
        return this.head;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Operation getPatch() {
        return this.patch;
    }

    public final PathItem copy(String summary, String description, Operation put, Operation post, Operation delete, Operation options, Operation get, Operation head, Operation patch, Operation trace, List<Server> servers, List<? extends ReferenceOr<Parameter>> parameters, Map<String, ? extends GenericElement> extensions) {
        return new PathItem(summary, description, put, post, delete, options, get, head, patch, trace, servers, parameters, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PathItem)) {
            return false;
        }
        PathItem pathItem = (PathItem) other;
        return Intrinsics.areEqual(this.summary, pathItem.summary) && Intrinsics.areEqual(this.description, pathItem.description) && Intrinsics.areEqual(this.put, pathItem.put) && Intrinsics.areEqual(this.post, pathItem.post) && Intrinsics.areEqual(this.delete, pathItem.delete) && Intrinsics.areEqual(this.options, pathItem.options) && Intrinsics.areEqual(this.get, pathItem.get) && Intrinsics.areEqual(this.head, pathItem.head) && Intrinsics.areEqual(this.patch, pathItem.patch) && Intrinsics.areEqual(this.trace, pathItem.trace) && Intrinsics.areEqual(this.servers, pathItem.servers) && Intrinsics.areEqual(this.parameters, pathItem.parameters) && Intrinsics.areEqual(this.extensions, pathItem.extensions);
    }

    public final Operation getDelete() {
        return this.delete;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final Operation getGet() {
        return this.get;
    }

    public final Operation getHead() {
        return this.head;
    }

    public final Operation getOptions() {
        return this.options;
    }

    public final List<ReferenceOr<Parameter>> getParameters() {
        return this.parameters;
    }

    public final Operation getPatch() {
        return this.patch;
    }

    public final Operation getPost() {
        return this.post;
    }

    public final Operation getPut() {
        return this.put;
    }

    public final List<Server> getServers() {
        return this.servers;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Operation getTrace() {
        return this.trace;
    }

    public int hashCode() {
        String str = this.summary;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Operation operation = this.put;
        int iHashCode3 = (iHashCode2 + (operation == null ? 0 : operation.hashCode())) * 31;
        Operation operation2 = this.post;
        int iHashCode4 = (iHashCode3 + (operation2 == null ? 0 : operation2.hashCode())) * 31;
        Operation operation3 = this.delete;
        int iHashCode5 = (iHashCode4 + (operation3 == null ? 0 : operation3.hashCode())) * 31;
        Operation operation4 = this.options;
        int iHashCode6 = (iHashCode5 + (operation4 == null ? 0 : operation4.hashCode())) * 31;
        Operation operation5 = this.get;
        int iHashCode7 = (iHashCode6 + (operation5 == null ? 0 : operation5.hashCode())) * 31;
        Operation operation6 = this.head;
        int iHashCode8 = (iHashCode7 + (operation6 == null ? 0 : operation6.hashCode())) * 31;
        Operation operation7 = this.patch;
        int iHashCode9 = (iHashCode8 + (operation7 == null ? 0 : operation7.hashCode())) * 31;
        Operation operation8 = this.trace;
        int iHashCode10 = (iHashCode9 + (operation8 == null ? 0 : operation8.hashCode())) * 31;
        List<Server> list = this.servers;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        List<ReferenceOr<Parameter>> list2 = this.parameters;
        int iHashCode12 = (iHashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode12 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PathItem(summary=");
        sb.append(this.summary);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", put=");
        sb.append(this.put);
        sb.append(", post=");
        sb.append(this.post);
        sb.append(", delete=");
        sb.append(this.delete);
        sb.append(", options=");
        sb.append(this.options);
        sb.append(", get=");
        sb.append(this.get);
        sb.append(", head=");
        sb.append(this.head);
        sb.append(", patch=");
        sb.append(this.patch);
        sb.append(", trace=");
        sb.append(this.trace);
        sb.append(", servers=");
        sb.append(this.servers);
        sb.append(", parameters=");
        sb.append(this.parameters);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/PathItem$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/PathItem;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/PathItem$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/PathItem;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<PathItem> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(PathItem.INSTANCE.generatedSerializer$ktor_openapi_schema(), new CombinedContext$$ExternalSyntheticLambda0((byte) 3));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PathItem _init_$lambda$0(PathItem pathItem, Map map) {
                pathItem.getClass();
                return PathItem.copy$default(pathItem, null, null, null, null, null, null, null, null, null, null, null, null, map, 4095, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return PathItem$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PathItem(int i, String str, String str2, Operation operation, Operation operation2, Operation operation3, Operation operation4, Operation operation5, Operation operation6, Operation operation7, Operation operation8, List list, List list2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.summary = null;
        } else {
            this.summary = str;
        }
        if ((i & 2) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 4) == 0) {
            this.put = null;
        } else {
            this.put = operation;
        }
        if ((i & 8) == 0) {
            this.post = null;
        } else {
            this.post = operation2;
        }
        if ((i & 16) == 0) {
            this.delete = null;
        } else {
            this.delete = operation3;
        }
        if ((i & 32) == 0) {
            this.options = null;
        } else {
            this.options = operation4;
        }
        if ((i & 64) == 0) {
            this.get = null;
        } else {
            this.get = operation5;
        }
        if ((i & 128) == 0) {
            this.head = null;
        } else {
            this.head = operation6;
        }
        if ((i & 256) == 0) {
            this.patch = null;
        } else {
            this.patch = operation7;
        }
        if ((i & 512) == 0) {
            this.trace = null;
        } else {
            this.trace = operation8;
        }
        if ((i & 1024) == 0) {
            this.servers = null;
        } else {
            this.servers = list;
        }
        if ((i & 2048) == 0) {
            this.parameters = null;
        } else {
            this.parameters = list2;
        }
        if ((i & 4096) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PathItem(String str, String str2, Operation operation, Operation operation2, Operation operation3, Operation operation4, Operation operation5, Operation operation6, Operation operation7, Operation operation8, List<Server> list, List<? extends ReferenceOr<Parameter>> list2, Map<String, ? extends GenericElement> map) {
        this.summary = str;
        this.description = str2;
        this.put = operation;
        this.post = operation2;
        this.delete = operation3;
        this.options = operation4;
        this.get = operation5;
        this.head = operation6;
        this.patch = operation7;
        this.trace = operation8;
        this.servers = list;
        this.parameters = list2;
        this.extensions = map;
    }

    public PathItem() {
        this((String) null, (String) null, (Operation) null, (Operation) null, (Operation) null, (Operation) null, (Operation) null, (Operation) null, (Operation) null, (Operation) null, (List) null, (List) null, (Map) null, 8191, (DefaultConstructorMarker) null);
    }
}
