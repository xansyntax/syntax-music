package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie$$ExternalSyntheticLambda1;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
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
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002;<BG\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0002`\n¢\u0006\u0004\b\f\u0010\rBY\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\f\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\"\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJP\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0002`\nHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0083\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u0003HÖ\u0081\u0004¢\u0006\u0004\b%\u0010\u0016J'\u0010.\u001a\u00020+2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b,\u0010-R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b0\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b2\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b3\u0010\u0016R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0002`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00104\u001a\u0004\b5\u0010\u001bR \u0010\u0011\u001a\u00020\u00108\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u0011\u00106\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108¨\u0006="}, d2 = {"Lio/ktor/openapi/ApiKeySecurityScheme;", "Lio/ktor/openapi/SecurityScheme;", "Lio/ktor/openapi/Extensible;", "", ContentDisposition.Parameters.Name, "Lio/ktor/openapi/SecuritySchemeIn;", "in", "description", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Lio/ktor/openapi/SecuritySchemeIn;Ljava/lang/String;Ljava/util/Map;)V", "", "seen0", "Lio/ktor/openapi/SecuritySchemeType;", LinkHeader.Parameters.Type, "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lio/ktor/openapi/SecuritySchemeIn;Ljava/lang/String;Ljava/util/Map;Lio/ktor/openapi/SecuritySchemeType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()Lio/ktor/openapi/SecuritySchemeIn;", "component3", "component4", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Lio/ktor/openapi/SecuritySchemeIn;Ljava/lang/String;Ljava/util/Map;)Lio/ktor/openapi/ApiKeySecurityScheme;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/ApiKeySecurityScheme;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "Lio/ktor/openapi/SecuritySchemeIn;", "getIn", "getDescription", "Ljava/util/Map;", "getExtensions", "Lio/ktor/openapi/SecuritySchemeType;", "getType", "()Lio/ktor/openapi/SecuritySchemeType;", "getType$annotations", "()V", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class ApiKeySecurityScheme implements SecurityScheme, Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_DESCRIPTION = "API Key Authentication";
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final SecuritySchemeIn in;
    private final String name;
    private final SecuritySchemeType type;

    static {
        Cookie$$ExternalSyntheticLambda1 cookie$$ExternalSyntheticLambda1 = new Cookie$$ExternalSyntheticLambda1((byte) 20);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, cookie$$ExternalSyntheticLambda1), null, ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 21)), ResultKt.lazy(lazyThreadSafetyMode, new Cookie$$ExternalSyntheticLambda1((byte) 22))};
    }

    public /* synthetic */ ApiKeySecurityScheme(int i, String str, SecuritySchemeIn securitySchemeIn, String str2, Map map, SecuritySchemeType securitySchemeType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i & 2) == 0) {
            this.in = null;
        } else {
            this.in = securitySchemeIn;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 8) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map;
        }
        if ((i & 16) == 0) {
            this.type = SecuritySchemeType.API_KEY;
        } else {
            this.type = securitySchemeType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return SecuritySchemeIn.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return SecuritySchemeType.INSTANCE.serializer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiKeySecurityScheme copy$default(ApiKeySecurityScheme apiKeySecurityScheme, String str, SecuritySchemeIn securitySchemeIn, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apiKeySecurityScheme.name;
        }
        if ((i & 2) != 0) {
            securitySchemeIn = apiKeySecurityScheme.in;
        }
        if ((i & 4) != 0) {
            str2 = apiKeySecurityScheme.description;
        }
        if ((i & 8) != 0) {
            map = apiKeySecurityScheme.extensions;
        }
        return apiKeySecurityScheme.copy(str, securitySchemeIn, str2, map);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(ApiKeySecurityScheme self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.in != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.in);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.getExtensions() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.getExtensions());
        }
        output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getType());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SecuritySchemeIn getIn() {
        return this.in;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, GenericElement> component4() {
        return this.extensions;
    }

    public final ApiKeySecurityScheme copy(String name, SecuritySchemeIn in, String description, Map<String, ? extends GenericElement> extensions) {
        return new ApiKeySecurityScheme(name, in, description, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiKeySecurityScheme)) {
            return false;
        }
        ApiKeySecurityScheme apiKeySecurityScheme = (ApiKeySecurityScheme) other;
        return Intrinsics.areEqual(this.name, apiKeySecurityScheme.name) && this.in == apiKeySecurityScheme.in && Intrinsics.areEqual(this.description, apiKeySecurityScheme.description) && Intrinsics.areEqual(this.extensions, apiKeySecurityScheme.extensions);
    }

    @Override // io.ktor.openapi.SecurityScheme
    public String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final SecuritySchemeIn getIn() {
        return this.in;
    }

    public final String getName() {
        return this.name;
    }

    @Override // io.ktor.openapi.SecurityScheme
    public SecuritySchemeType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        SecuritySchemeIn securitySchemeIn = this.in;
        int iHashCode2 = (iHashCode + (securitySchemeIn == null ? 0 : securitySchemeIn.hashCode())) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ApiKeySecurityScheme(name=");
        sb.append(this.name);
        sb.append(", in=");
        sb.append(this.in);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/openapi/ApiKeySecurityScheme$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/ApiKeySecurityScheme;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "", "DEFAULT_DESCRIPTION", "Ljava/lang/String;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/ApiKeySecurityScheme$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/ApiKeySecurityScheme;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<ApiKeySecurityScheme> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(ApiKeySecurityScheme.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 16));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ApiKeySecurityScheme _init_$lambda$0(ApiKeySecurityScheme apiKeySecurityScheme, Map map) {
                apiKeySecurityScheme.getClass();
                return ApiKeySecurityScheme.copy$default(apiKeySecurityScheme, null, null, null, map, 7, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return ApiKeySecurityScheme$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public ApiKeySecurityScheme() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApiKeySecurityScheme(String str, SecuritySchemeIn securitySchemeIn, String str2, Map<String, ? extends GenericElement> map) {
        this.name = str;
        this.in = securitySchemeIn;
        this.description = str2;
        this.extensions = map;
        this.type = SecuritySchemeType.API_KEY;
    }

    public /* synthetic */ ApiKeySecurityScheme(String str, SecuritySchemeIn securitySchemeIn, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : securitySchemeIn, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : map);
    }
}
