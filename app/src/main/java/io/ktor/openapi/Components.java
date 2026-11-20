package io.ktor.openapi;

import io.ktor.http.Cookie$$ExternalSyntheticLambda1;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
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
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 V2\u00020\u0001:\u0002VWBç\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u0002\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0006\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0002j\u0002`\u001c¢\u0006\u0004\b\u001e\u0010\u001fBß\u0002\b\u0010\u0012\u0006\u0010!\u001a\u00020 \u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0002\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0002\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u0002\u0012\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0006\u0018\u00010\u0002\u0012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b\u001e\u0010$J\r\u0010&\u001a\u00020%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020%¢\u0006\u0004\b(\u0010'J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010*J$\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010*J$\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010*J$\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010*J$\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010*J$\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010*J$\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010*J$\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010*J$\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010*J$\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010*J$\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010*J\"\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0002j\u0002`\u001cHÆ\u0003¢\u0006\u0004\b5\u0010*Jð\u0002\u00106\u001a\u00020\u00002\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u00022\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0006\u0018\u00010\u00022\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0002j\u0002`\u001cHÆ\u0001¢\u0006\u0004\b6\u00107J\u001b\u0010:\u001a\u00020%2\b\u00109\u001a\u0004\u0018\u000108HÖ\u0083\u0004¢\u0006\u0004\b:\u0010;J\u0011\u0010<\u001a\u00020 HÖ\u0081\u0004¢\u0006\u0004\b<\u0010=J\u0011\u0010>\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b>\u0010?J'\u0010H\u001a\u00020E2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bF\u0010GR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010I\u001a\u0004\bJ\u0010*R+\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010I\u001a\u0004\bK\u0010*R+\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010I\u001a\u0004\bL\u0010*R+\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010I\u001a\u0004\bM\u0010*R+\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010I\u001a\u0004\bN\u0010*R+\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010I\u001a\u0004\bO\u0010*R+\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010I\u001a\u0004\bP\u0010*R+\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010I\u001a\u0004\bQ\u0010*R+\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010I\u001a\u0004\bR\u0010*R+\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010I\u001a\u0004\bS\u0010*R+\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0006\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010I\u001a\u0004\bT\u0010*R,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0002j\u0002`\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010I\u001a\u0004\bU\u0010*¨\u0006X"}, d2 = {"Lio/ktor/openapi/Components;", "Lio/ktor/openapi/Extensible;", "", "", "Lio/ktor/openapi/JsonSchema;", "schemas", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Response;", "responses", "Lio/ktor/openapi/Parameter;", "parameters", "Lio/ktor/openapi/ExampleObject;", "examples", "Lio/ktor/openapi/RequestBody;", "requestBodies", "Lio/ktor/openapi/Header;", "headers", "Lio/ktor/openapi/SecurityScheme;", "securitySchemes", "Lio/ktor/openapi/Link;", "links", "Lio/ktor/openapi/Callback;", "callbacks", "Lio/ktor/openapi/PathItem;", "pathItems", "Lio/ktor/openapi/Server;", "servers", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "", "isEmpty", "()Z", "isNotEmpty", "component1", "()Ljava/util/Map;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/Components;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Components;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/Map;", "getSchemas", "getResponses", "getParameters", "getExamples", "getRequestBodies", "getHeaders", "getSecuritySchemes", "getLinks", "getCallbacks", "getPathItems", "getServers", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Components implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, ReferenceOr<Callback>> callbacks;
    private final Map<String, ReferenceOr<ExampleObject>> examples;
    private final Map<String, GenericElement> extensions;
    private final Map<String, ReferenceOr<Header>> headers;
    private final Map<String, ReferenceOr<Link>> links;
    private final Map<String, ReferenceOr<Parameter>> parameters;
    private final Map<String, ReferenceOr<PathItem>> pathItems;
    private final Map<String, ReferenceOr<RequestBody>> requestBodies;
    private final Map<String, ReferenceOr<Response>> responses;
    private final Map<String, JsonSchema> schemas;
    private final Map<String, ReferenceOr<SecurityScheme>> securitySchemes;
    private final Map<String, ReferenceOr<Server>> servers;

    static {
        Cookie$$ExternalSyntheticLambda1 cookie$$ExternalSyntheticLambda1 = new Cookie$$ExternalSyntheticLambda1((byte) 24);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, cookie$$ExternalSyntheticLambda1), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 29)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 1)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 2)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 3)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 4)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 5)), ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 6)), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 25)), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 26)), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 27)), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 28))};
    }

    public /* synthetic */ Components(int i, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, Map map11, Map map12, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.schemas = null;
        } else {
            this.schemas = map;
        }
        if ((i & 2) == 0) {
            this.responses = null;
        } else {
            this.responses = map2;
        }
        if ((i & 4) == 0) {
            this.parameters = null;
        } else {
            this.parameters = map3;
        }
        if ((i & 8) == 0) {
            this.examples = null;
        } else {
            this.examples = map4;
        }
        if ((i & 16) == 0) {
            this.requestBodies = null;
        } else {
            this.requestBodies = map5;
        }
        if ((i & 32) == 0) {
            this.headers = null;
        } else {
            this.headers = map6;
        }
        if ((i & 64) == 0) {
            this.securitySchemes = null;
        } else {
            this.securitySchemes = map7;
        }
        if ((i & 128) == 0) {
            this.links = null;
        } else {
            this.links = map8;
        }
        if ((i & 256) == 0) {
            this.callbacks = null;
        } else {
            this.callbacks = map9;
        }
        if ((i & 512) == 0) {
            this.pathItems = null;
        } else {
            this.pathItems = map10;
        }
        if ((i & 1024) == 0) {
            this.servers = null;
        } else {
            this.servers = map11;
        }
        if ((i & 2048) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, JsonSchema$$serializer.INSTANCE, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Response.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Parameter.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$10() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(ExampleObject.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(RequestBody.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Header.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(SecuritySchemeSerializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Link.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Callback$$serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(PathItem.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$9() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Server.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Components copy$default(Components components, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, Map map11, Map map12, int i, Object obj) {
        if ((i & 1) != 0) {
            map = components.schemas;
        }
        if ((i & 2) != 0) {
            map2 = components.responses;
        }
        if ((i & 4) != 0) {
            map3 = components.parameters;
        }
        if ((i & 8) != 0) {
            map4 = components.examples;
        }
        if ((i & 16) != 0) {
            map5 = components.requestBodies;
        }
        if ((i & 32) != 0) {
            map6 = components.headers;
        }
        if ((i & 64) != 0) {
            map7 = components.securitySchemes;
        }
        if ((i & 128) != 0) {
            map8 = components.links;
        }
        if ((i & 256) != 0) {
            map9 = components.callbacks;
        }
        if ((i & 512) != 0) {
            map10 = components.pathItems;
        }
        if ((i & 1024) != 0) {
            map11 = components.servers;
        }
        if ((i & 2048) != 0) {
            map12 = components.extensions;
        }
        Map map13 = map11;
        Map map14 = map12;
        Map map15 = map9;
        Map map16 = map10;
        Map map17 = map7;
        Map map18 = map8;
        Map map19 = map5;
        Map map20 = map6;
        return components.copy(map, map2, map3, map4, map19, map20, map17, map18, map15, map16, map13, map14);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Components self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.schemas != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.schemas);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.responses != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.responses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.parameters != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.parameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.examples != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.examples);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.requestBodies != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.requestBodies);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.headers != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.securitySchemes != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.securitySchemes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.links != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.links);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.callbacks != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.callbacks);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.pathItems != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy) lazyArr[9].getValue(), self.pathItems);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.servers != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.servers);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.getExtensions());
    }

    public final Map<String, JsonSchema> component1() {
        return this.schemas;
    }

    public final Map<String, ReferenceOr<PathItem>> component10() {
        return this.pathItems;
    }

    public final Map<String, ReferenceOr<Server>> component11() {
        return this.servers;
    }

    public final Map<String, GenericElement> component12() {
        return this.extensions;
    }

    public final Map<String, ReferenceOr<Response>> component2() {
        return this.responses;
    }

    public final Map<String, ReferenceOr<Parameter>> component3() {
        return this.parameters;
    }

    public final Map<String, ReferenceOr<ExampleObject>> component4() {
        return this.examples;
    }

    public final Map<String, ReferenceOr<RequestBody>> component5() {
        return this.requestBodies;
    }

    public final Map<String, ReferenceOr<Header>> component6() {
        return this.headers;
    }

    public final Map<String, ReferenceOr<SecurityScheme>> component7() {
        return this.securitySchemes;
    }

    public final Map<String, ReferenceOr<Link>> component8() {
        return this.links;
    }

    public final Map<String, ReferenceOr<Callback>> component9() {
        return this.callbacks;
    }

    public final Components copy(Map<String, JsonSchema> schemas, Map<String, ? extends ReferenceOr<Response>> responses, Map<String, ? extends ReferenceOr<Parameter>> parameters, Map<String, ? extends ReferenceOr<ExampleObject>> examples, Map<String, ? extends ReferenceOr<RequestBody>> requestBodies, Map<String, ? extends ReferenceOr<Header>> headers, Map<String, ? extends ReferenceOr<? extends SecurityScheme>> securitySchemes, Map<String, ? extends ReferenceOr<Link>> links, Map<String, ? extends ReferenceOr<Callback>> callbacks, Map<String, ? extends ReferenceOr<PathItem>> pathItems, Map<String, ? extends ReferenceOr<Server>> servers, Map<String, ? extends GenericElement> extensions) {
        return new Components(schemas, responses, parameters, examples, requestBodies, headers, securitySchemes, links, callbacks, pathItems, servers, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Components)) {
            return false;
        }
        Components components = (Components) other;
        return Intrinsics.areEqual(this.schemas, components.schemas) && Intrinsics.areEqual(this.responses, components.responses) && Intrinsics.areEqual(this.parameters, components.parameters) && Intrinsics.areEqual(this.examples, components.examples) && Intrinsics.areEqual(this.requestBodies, components.requestBodies) && Intrinsics.areEqual(this.headers, components.headers) && Intrinsics.areEqual(this.securitySchemes, components.securitySchemes) && Intrinsics.areEqual(this.links, components.links) && Intrinsics.areEqual(this.callbacks, components.callbacks) && Intrinsics.areEqual(this.pathItems, components.pathItems) && Intrinsics.areEqual(this.servers, components.servers) && Intrinsics.areEqual(this.extensions, components.extensions);
    }

    public final Map<String, ReferenceOr<Callback>> getCallbacks() {
        return this.callbacks;
    }

    public final Map<String, ReferenceOr<ExampleObject>> getExamples() {
        return this.examples;
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

    public final Map<String, ReferenceOr<Parameter>> getParameters() {
        return this.parameters;
    }

    public final Map<String, ReferenceOr<PathItem>> getPathItems() {
        return this.pathItems;
    }

    public final Map<String, ReferenceOr<RequestBody>> getRequestBodies() {
        return this.requestBodies;
    }

    public final Map<String, ReferenceOr<Response>> getResponses() {
        return this.responses;
    }

    public final Map<String, JsonSchema> getSchemas() {
        return this.schemas;
    }

    public final Map<String, ReferenceOr<SecurityScheme>> getSecuritySchemes() {
        return this.securitySchemes;
    }

    public final Map<String, ReferenceOr<Server>> getServers() {
        return this.servers;
    }

    public int hashCode() {
        Map<String, JsonSchema> map = this.schemas;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, ReferenceOr<Response>> map2 = this.responses;
        int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, ReferenceOr<Parameter>> map3 = this.parameters;
        int iHashCode3 = (iHashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
        Map<String, ReferenceOr<ExampleObject>> map4 = this.examples;
        int iHashCode4 = (iHashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, ReferenceOr<RequestBody>> map5 = this.requestBodies;
        int iHashCode5 = (iHashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<String, ReferenceOr<Header>> map6 = this.headers;
        int iHashCode6 = (iHashCode5 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Map<String, ReferenceOr<SecurityScheme>> map7 = this.securitySchemes;
        int iHashCode7 = (iHashCode6 + (map7 == null ? 0 : map7.hashCode())) * 31;
        Map<String, ReferenceOr<Link>> map8 = this.links;
        int iHashCode8 = (iHashCode7 + (map8 == null ? 0 : map8.hashCode())) * 31;
        Map<String, ReferenceOr<Callback>> map9 = this.callbacks;
        int iHashCode9 = (iHashCode8 + (map9 == null ? 0 : map9.hashCode())) * 31;
        Map<String, ReferenceOr<PathItem>> map10 = this.pathItems;
        int iHashCode10 = (iHashCode9 + (map10 == null ? 0 : map10.hashCode())) * 31;
        Map<String, ReferenceOr<Server>> map11 = this.servers;
        int iHashCode11 = (iHashCode10 + (map11 == null ? 0 : map11.hashCode())) * 31;
        Map<String, GenericElement> map12 = this.extensions;
        return iHashCode11 + (map12 != null ? map12.hashCode() : 0);
    }

    public final boolean isEmpty() {
        Map<String, JsonSchema> map = this.schemas;
        if (map != null && !map.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Response>> map2 = this.responses;
        if (map2 != null && !map2.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Parameter>> map3 = this.parameters;
        if (map3 != null && !map3.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<ExampleObject>> map4 = this.examples;
        if (map4 != null && !map4.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<RequestBody>> map5 = this.requestBodies;
        if (map5 != null && !map5.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Header>> map6 = this.headers;
        if (map6 != null && !map6.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<SecurityScheme>> map7 = this.securitySchemes;
        if (map7 != null && !map7.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Link>> map8 = this.links;
        if (map8 != null && !map8.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Callback>> map9 = this.callbacks;
        if (map9 != null && !map9.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<PathItem>> map10 = this.pathItems;
        if (map10 != null && !map10.isEmpty()) {
            return false;
        }
        Map<String, ReferenceOr<Server>> map11 = this.servers;
        if (map11 != null && !map11.isEmpty()) {
            return false;
        }
        Map<String, GenericElement> extensions = getExtensions();
        return extensions == null || extensions.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Components(schemas=");
        sb.append(this.schemas);
        sb.append(", responses=");
        sb.append(this.responses);
        sb.append(", parameters=");
        sb.append(this.parameters);
        sb.append(", examples=");
        sb.append(this.examples);
        sb.append(", requestBodies=");
        sb.append(this.requestBodies);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", securitySchemes=");
        sb.append(this.securitySchemes);
        sb.append(", links=");
        sb.append(this.links);
        sb.append(", callbacks=");
        sb.append(this.callbacks);
        sb.append(", pathItems=");
        sb.append(this.pathItems);
        sb.append(", servers=");
        sb.append(this.servers);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Components$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Components;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Components$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Components;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Components> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Components.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 17));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Components _init_$lambda$0(Components components, Map map) {
                components.getClass();
                return Components.copy$default(components, null, null, null, null, null, null, null, null, null, null, null, map, 2047, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Components$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Components() {
        this((Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, (Map) null, 4095, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Components(Map<String, JsonSchema> map, Map<String, ? extends ReferenceOr<Response>> map2, Map<String, ? extends ReferenceOr<Parameter>> map3, Map<String, ? extends ReferenceOr<ExampleObject>> map4, Map<String, ? extends ReferenceOr<RequestBody>> map5, Map<String, ? extends ReferenceOr<Header>> map6, Map<String, ? extends ReferenceOr<? extends SecurityScheme>> map7, Map<String, ? extends ReferenceOr<Link>> map8, Map<String, ? extends ReferenceOr<Callback>> map9, Map<String, ? extends ReferenceOr<PathItem>> map10, Map<String, ? extends ReferenceOr<Server>> map11, Map<String, ? extends GenericElement> map12) {
        this.schemas = map;
        this.responses = map2;
        this.parameters = map3;
        this.examples = map4;
        this.requestBodies = map5;
        this.headers = map6;
        this.securitySchemes = map7;
        this.links = map8;
        this.callbacks = map9;
        this.pathItems = map10;
        this.servers = map11;
        this.extensions = map12;
    }

    public /* synthetic */ Components(Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, Map map11, Map map12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3, (i & 8) != 0 ? null : map4, (i & 16) != 0 ? null : map5, (i & 32) != 0 ? null : map6, (i & 64) != 0 ? null : map7, (i & 128) != 0 ? null : map8, (i & 256) != 0 ? null : map9, (i & 512) != 0 ? null : map10, (i & 1024) != 0 ? null : map11, (i & 2048) != 0 ? null : map12);
    }
}
