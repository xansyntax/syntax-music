package io.ktor.openapi;

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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0087\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000289B;\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000b\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0002`\tHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u0005HÖ\u0081\u0004¢\u0006\u0004\b#\u0010\u0017J'\u0010,\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u0017R,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0002`\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b2\u0010\u0019R \u0010\u0010\u001a\u00020\u000f8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u0010\u00103\u0012\u0004\b6\u00107\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lio/ktor/openapi/OAuth2SecurityScheme;", "Lio/ktor/openapi/SecurityScheme;", "Lio/ktor/openapi/Extensible;", "Lio/ktor/openapi/OAuthFlows;", "flows", "", "description", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Lio/ktor/openapi/OAuthFlows;Ljava/lang/String;Ljava/util/Map;)V", "", "seen0", "Lio/ktor/openapi/SecuritySchemeType;", LinkHeader.Parameters.Type, "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILio/ktor/openapi/OAuthFlows;Ljava/lang/String;Ljava/util/Map;Lio/ktor/openapi/SecuritySchemeType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/openapi/OAuthFlows;", "component2", "()Ljava/lang/String;", "component3", "()Ljava/util/Map;", "copy", "(Lio/ktor/openapi/OAuthFlows;Ljava/lang/String;Ljava/util/Map;)Lio/ktor/openapi/OAuth2SecurityScheme;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OAuth2SecurityScheme;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/openapi/OAuthFlows;", "getFlows", "Ljava/lang/String;", "getDescription", "Ljava/util/Map;", "getExtensions", "Lio/ktor/openapi/SecuritySchemeType;", "getType", "()Lio/ktor/openapi/SecuritySchemeType;", "getType$annotations", "()V", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class OAuth2SecurityScheme implements SecurityScheme, Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_DESCRIPTION = "OAuth2 Authentication";
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final OAuthFlows flows;
    private final SecuritySchemeType type;

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 11);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 12))};
    }

    public /* synthetic */ OAuth2SecurityScheme(int i, OAuthFlows oAuthFlows, String str, Map map, SecuritySchemeType securitySchemeType, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.flows = null;
        } else {
            this.flows = oAuthFlows;
        }
        if ((i & 2) == 0) {
            this.description = null;
        } else {
            this.description = str;
        }
        if ((i & 4) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map;
        }
        if ((i & 8) == 0) {
            this.type = SecuritySchemeType.OAUTH2;
        } else {
            this.type = securitySchemeType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return SecuritySchemeType.INSTANCE.serializer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OAuth2SecurityScheme copy$default(OAuth2SecurityScheme oAuth2SecurityScheme, OAuthFlows oAuthFlows, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            oAuthFlows = oAuth2SecurityScheme.flows;
        }
        if ((i & 2) != 0) {
            str = oAuth2SecurityScheme.description;
        }
        if ((i & 4) != 0) {
            map = oAuth2SecurityScheme.extensions;
        }
        return oAuth2SecurityScheme.copy(oAuthFlows, str, map);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(OAuth2SecurityScheme self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.flows != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, OAuthFlows.Companion.Serializer.INSTANCE, self.flows);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.getExtensions() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.getExtensions());
        }
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.getType());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OAuthFlows getFlows() {
        return this.flows;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, GenericElement> component3() {
        return this.extensions;
    }

    public final OAuth2SecurityScheme copy(OAuthFlows flows, String description, Map<String, ? extends GenericElement> extensions) {
        return new OAuth2SecurityScheme(flows, description, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OAuth2SecurityScheme)) {
            return false;
        }
        OAuth2SecurityScheme oAuth2SecurityScheme = (OAuth2SecurityScheme) other;
        return Intrinsics.areEqual(this.flows, oAuth2SecurityScheme.flows) && Intrinsics.areEqual(this.description, oAuth2SecurityScheme.description) && Intrinsics.areEqual(this.extensions, oAuth2SecurityScheme.extensions);
    }

    @Override // io.ktor.openapi.SecurityScheme
    public String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final OAuthFlows getFlows() {
        return this.flows;
    }

    @Override // io.ktor.openapi.SecurityScheme
    public SecuritySchemeType getType() {
        return this.type;
    }

    public int hashCode() {
        OAuthFlows oAuthFlows = this.flows;
        int iHashCode = (oAuthFlows == null ? 0 : oAuthFlows.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuth2SecurityScheme(flows=");
        sb.append(this.flows);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/openapi/OAuth2SecurityScheme$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OAuth2SecurityScheme;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "", "DEFAULT_DESCRIPTION", "Ljava/lang/String;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/OAuth2SecurityScheme$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/OAuth2SecurityScheme;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<OAuth2SecurityScheme> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(OAuth2SecurityScheme.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 24));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OAuth2SecurityScheme _init_$lambda$0(OAuth2SecurityScheme oAuth2SecurityScheme, Map map) {
                oAuth2SecurityScheme.getClass();
                return OAuth2SecurityScheme.copy$default(oAuth2SecurityScheme, null, null, map, 3, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return OAuth2SecurityScheme$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public OAuth2SecurityScheme() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAuth2SecurityScheme(OAuthFlows oAuthFlows, String str, Map<String, ? extends GenericElement> map) {
        this.flows = oAuthFlows;
        this.description = str;
        this.extensions = map;
        this.type = SecuritySchemeType.OAUTH2;
    }

    public /* synthetic */ OAuth2SecurityScheme(OAuthFlows oAuthFlows, String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : oAuthFlows, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : map);
    }
}
