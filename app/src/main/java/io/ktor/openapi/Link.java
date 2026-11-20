package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0003>?@B{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u0007¢\u0006\u0004\b\u000e\u0010\u000fBy\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0084\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u001b\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0083\u0004¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00020\u0010HÖ\u0081\u0004¢\u0006\u0004\b'\u0010(J\u0011\u0010)\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b)\u0010\u0016J'\u00102\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b0\u00101R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b5\u0010\u0016R)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u00078\u0006¢\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b9\u0010\u001bR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b:\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\b<\u0010\u001eR,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0002`\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b=\u0010\u0019¨\u0006A"}, d2 = {"Lio/ktor/openapi/Link;", "Lio/ktor/openapi/Extensible;", "", "operationRef", "operationId", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "parameters", "requestBody", "description", "Lio/ktor/openapi/Server;", "server", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/Server;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/Server;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "()Lio/ktor/openapi/GenericElement;", "component5", "component6", "()Lio/ktor/openapi/Server;", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Lio/ktor/openapi/Server;Ljava/util/Map;)Lio/ktor/openapi/Link;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Link;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getOperationRef", "getOperationId", "Ljava/util/Map;", "getParameters", "Lio/ktor/openapi/GenericElement;", "getRequestBody", "getDescription", "Lio/ktor/openapi/Server;", "getServer", "getExtensions", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Link implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final String operationId;
    private final String operationRef;
    private final Map<String, GenericElement> parameters;
    private final GenericElement requestBody;
    private final Server server;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000b\u001a\u00020\b\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u00198\u0006¢\u0006\f\n\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001e¨\u00061"}, d2 = {"Lio/ktor/openapi/Link$Builder;", "", "<init>", "()V", "T", "", ContentDisposition.Parameters.Name, "value", "", "parameter", "(Ljava/lang/String;Ljava/lang/Object;)V", "extension", "Lio/ktor/openapi/Link;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Link;", "build", "operationRef", "Ljava/lang/String;", "getOperationRef", "()Ljava/lang/String;", "setOperationRef", "(Ljava/lang/String;)V", "operationId", "getOperationId", "setOperationId", "", "Lio/ktor/openapi/GenericElement;", "parameters", "Ljava/util/Map;", "getParameters", "()Ljava/util/Map;", "requestBody", "Lio/ktor/openapi/GenericElement;", "getRequestBody", "()Lio/ktor/openapi/GenericElement;", "setRequestBody", "(Lio/ktor/openapi/GenericElement;)V", "description", "getDescription", "setDescription", "Lio/ktor/openapi/Server;", "server", "Lio/ktor/openapi/Server;", "getServer", "()Lio/ktor/openapi/Server;", "setServer", "(Lio/ktor/openapi/Server;)V", "extensions", "getExtensions", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private String description;
        private String operationId;
        private String operationRef;
        private GenericElement requestBody;
        private Server server;
        private final Map<String, GenericElement> parameters = new LinkedHashMap();
        private final Map<String, GenericElement> extensions = new LinkedHashMap();

        public final Link build$ktor_openapi_schema() {
            String str = this.operationRef;
            if (str == null && this.operationId == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Either operationRef or operationId must be specified");
                return null;
            }
            String str2 = this.operationId;
            Map<String, GenericElement> map = this.parameters;
            if (map.isEmpty()) {
                map = null;
            }
            GenericElement genericElement = this.requestBody;
            String str3 = this.description;
            Server server = this.server;
            Map<String, GenericElement> map2 = this.extensions;
            return new Link(str, str2, map, genericElement, str3, server, map2.isEmpty() ? null : map2);
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

        public final String getDescription() {
            return this.description;
        }

        public final Map<String, GenericElement> getExtensions() {
            return this.extensions;
        }

        public final String getOperationId() {
            return this.operationId;
        }

        public final String getOperationRef() {
            return this.operationRef;
        }

        public final Map<String, GenericElement> getParameters() {
            return this.parameters;
        }

        public final GenericElement getRequestBody() {
            return this.requestBody;
        }

        public final Server getServer() {
            return this.server;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> void parameter(String name, T value) {
            GenericElement genericElementString;
            name.getClass();
            value.getClass();
            Map<String, GenericElement> parameters = getParameters();
            if (value instanceof GenericElement) {
                genericElementString = (GenericElement) value;
            } else {
                if (!(value instanceof String)) {
                    Intrinsics.throwUndefinedForReified();
                    throw null;
                }
                genericElementString = new GenericElementString((String) value, null, 2, null);
            }
            parameters.put(name, genericElementString);
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final void setOperationId(String str) {
            this.operationId = str;
        }

        public final void setOperationRef(String str) {
            this.operationRef = str;
        }

        public final void setRequestBody(GenericElement genericElement) {
            this.requestBody = genericElement;
        }

        public final void setServer(Server server) {
            this.server = server;
        }
    }

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 0);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 5)), null, null, ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 6))};
    }

    public /* synthetic */ Link(int i, String str, String str2, Map map, GenericElement genericElement, String str3, Server server, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.operationRef = null;
        } else {
            this.operationRef = str;
        }
        if ((i & 2) == 0) {
            this.operationId = null;
        } else {
            this.operationId = str2;
        }
        if ((i & 4) == 0) {
            this.parameters = null;
        } else {
            this.parameters = map;
        }
        if ((i & 8) == 0) {
            this.requestBody = null;
        } else {
            this.requestBody = genericElement;
        }
        if ((i & 16) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 32) == 0) {
            this.server = null;
        } else {
            this.server = server;
        }
        if ((i & 64) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Link copy$default(Link link, String str, String str2, Map map, GenericElement genericElement, String str3, Server server, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = link.operationRef;
        }
        if ((i & 2) != 0) {
            str2 = link.operationId;
        }
        if ((i & 4) != 0) {
            map = link.parameters;
        }
        if ((i & 8) != 0) {
            genericElement = link.requestBody;
        }
        if ((i & 16) != 0) {
            str3 = link.description;
        }
        if ((i & 32) != 0) {
            server = link.server;
        }
        if ((i & 64) != 0) {
            map2 = link.extensions;
        }
        Server server2 = server;
        Map map3 = map2;
        String str4 = str3;
        Map map4 = map;
        return link.copy(str, str2, map4, genericElement, str4, server2, map3);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Link self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.operationRef != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.operationRef);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.operationId != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.operationId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.parameters != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.parameters);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.requestBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.requestBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.server != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, Server.Companion.Serializer.INSTANCE, self.server);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOperationRef() {
        return this.operationRef;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOperationId() {
        return this.operationId;
    }

    public final Map<String, GenericElement> component3() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GenericElement getRequestBody() {
        return this.requestBody;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Server getServer() {
        return this.server;
    }

    public final Map<String, GenericElement> component7() {
        return this.extensions;
    }

    public final Link copy(String operationRef, String operationId, Map<String, ? extends GenericElement> parameters, GenericElement requestBody, String description, Server server, Map<String, ? extends GenericElement> extensions) {
        return new Link(operationRef, operationId, parameters, requestBody, description, server, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Link)) {
            return false;
        }
        Link link = (Link) other;
        return Intrinsics.areEqual(this.operationRef, link.operationRef) && Intrinsics.areEqual(this.operationId, link.operationId) && Intrinsics.areEqual(this.parameters, link.parameters) && Intrinsics.areEqual(this.requestBody, link.requestBody) && Intrinsics.areEqual(this.description, link.description) && Intrinsics.areEqual(this.server, link.server) && Intrinsics.areEqual(this.extensions, link.extensions);
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getOperationRef() {
        return this.operationRef;
    }

    public final Map<String, GenericElement> getParameters() {
        return this.parameters;
    }

    public final GenericElement getRequestBody() {
        return this.requestBody;
    }

    public final Server getServer() {
        return this.server;
    }

    public int hashCode() {
        String str = this.operationRef;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.operationId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, GenericElement> map = this.parameters;
        int iHashCode3 = (iHashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        GenericElement genericElement = this.requestBody;
        int iHashCode4 = (iHashCode3 + (genericElement == null ? 0 : genericElement.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Server server = this.server;
        int iHashCode6 = (iHashCode5 + (server == null ? 0 : server.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Link(operationRef=");
        sb.append(this.operationRef);
        sb.append(", operationId=");
        sb.append(this.operationId);
        sb.append(", parameters=");
        sb.append(this.parameters);
        sb.append(", requestBody=");
        sb.append(this.requestBody);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", server=");
        sb.append(this.server);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Link$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Link;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Link$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Link;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Link> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Link.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 22));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Link _init_$lambda$0(Link link, Map map) {
                link.getClass();
                return Link.copy$default(link, null, null, null, null, null, null, map, 63, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Link$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Link() {
        this((String) null, (String) null, (Map) null, (GenericElement) null, (String) null, (Server) null, (Map) null, 127, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Link(String str, String str2, Map<String, ? extends GenericElement> map, GenericElement genericElement, String str3, Server server, Map<String, ? extends GenericElement> map2) {
        this.operationRef = str;
        this.operationId = str2;
        this.parameters = map;
        this.requestBody = genericElement;
        this.description = str3;
        this.server = server;
        this.extensions = map2;
    }

    public /* synthetic */ Link(String str, String str2, Map map, GenericElement genericElement, String str3, Server server, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : genericElement, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : server, (i & 64) != 0 ? null : map2);
    }
}
