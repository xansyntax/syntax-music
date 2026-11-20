package io.ktor.openapi;

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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fBe\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017Jh\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0002`\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\"\u0010\u0013J'\u0010+\u001a\u00020(2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0001¢\u0006\u0004\b)\u0010*R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u0013R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b/\u0010\u0013R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u0010\u0017R,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0002`\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b2\u0010\u0017¨\u00065"}, d2 = {"Lio/ktor/openapi/OAuthFlow;", "Lio/ktor/openapi/Extensible;", "", "authorizationUrl", "tokenUrl", "refreshUrl", "", "scopes", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/util/Map;", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lio/ktor/openapi/OAuthFlow;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OAuthFlow;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getAuthorizationUrl", "getTokenUrl", "getRefreshUrl", "Ljava/util/Map;", "getScopes", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class OAuthFlow implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_SCOPE_DESCRIPTION = "OAuth2 scope";
    private final String authorizationUrl;
    private final Map<String, GenericElement> extensions;
    private final String refreshUrl;
    private final Map<String, String> scopes;
    private final String tokenUrl;

    static {
        Link$$ExternalSyntheticLambda0 link$$ExternalSyntheticLambda0 = new Link$$ExternalSyntheticLambda0((byte) 13);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, ResultKt.lazy(lazyThreadSafetyMode, link$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Link$$ExternalSyntheticLambda0((byte) 14))};
    }

    public /* synthetic */ OAuthFlow(int i, String str, String str2, String str3, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.authorizationUrl = null;
        } else {
            this.authorizationUrl = str;
        }
        if ((i & 2) == 0) {
            this.tokenUrl = null;
        } else {
            this.tokenUrl = str2;
        }
        if ((i & 4) == 0) {
            this.refreshUrl = null;
        } else {
            this.refreshUrl = str3;
        }
        if ((i & 8) == 0) {
            this.scopes = null;
        } else {
            this.scopes = map;
        }
        if ((i & 16) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new HashMapSerializer(stringSerializer, stringSerializer, (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OAuthFlow copy$default(OAuthFlow oAuthFlow, String str, String str2, String str3, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oAuthFlow.authorizationUrl;
        }
        if ((i & 2) != 0) {
            str2 = oAuthFlow.tokenUrl;
        }
        if ((i & 4) != 0) {
            str3 = oAuthFlow.refreshUrl;
        }
        if ((i & 8) != 0) {
            map = oAuthFlow.scopes;
        }
        if ((i & 16) != 0) {
            map2 = oAuthFlow.extensions;
        }
        Map map3 = map2;
        String str4 = str3;
        return oAuthFlow.copy(str, str2, str4, map, map3);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(OAuthFlow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.authorizationUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.authorizationUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.tokenUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.tokenUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.refreshUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.refreshUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.scopes != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.scopes);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTokenUrl() {
        return this.tokenUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRefreshUrl() {
        return this.refreshUrl;
    }

    public final Map<String, String> component4() {
        return this.scopes;
    }

    public final Map<String, GenericElement> component5() {
        return this.extensions;
    }

    public final OAuthFlow copy(String authorizationUrl, String tokenUrl, String refreshUrl, Map<String, String> scopes, Map<String, ? extends GenericElement> extensions) {
        return new OAuthFlow(authorizationUrl, tokenUrl, refreshUrl, scopes, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OAuthFlow)) {
            return false;
        }
        OAuthFlow oAuthFlow = (OAuthFlow) other;
        return Intrinsics.areEqual(this.authorizationUrl, oAuthFlow.authorizationUrl) && Intrinsics.areEqual(this.tokenUrl, oAuthFlow.tokenUrl) && Intrinsics.areEqual(this.refreshUrl, oAuthFlow.refreshUrl) && Intrinsics.areEqual(this.scopes, oAuthFlow.scopes) && Intrinsics.areEqual(this.extensions, oAuthFlow.extensions);
    }

    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final String getRefreshUrl() {
        return this.refreshUrl;
    }

    public final Map<String, String> getScopes() {
        return this.scopes;
    }

    public final String getTokenUrl() {
        return this.tokenUrl;
    }

    public int hashCode() {
        String str = this.authorizationUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tokenUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.refreshUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.scopes;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuthFlow(authorizationUrl=");
        sb.append(this.authorizationUrl);
        sb.append(", tokenUrl=");
        sb.append(this.tokenUrl);
        sb.append(", refreshUrl=");
        sb.append(this.refreshUrl);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lio/ktor/openapi/OAuthFlow$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OAuthFlow;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "", "DEFAULT_SCOPE_DESCRIPTION", "Ljava/lang/String;", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/OAuthFlow$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/OAuthFlow;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<OAuthFlow> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(OAuthFlow.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 25));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OAuthFlow _init_$lambda$0(OAuthFlow oAuthFlow, Map map) {
                oAuthFlow.getClass();
                return OAuthFlow.copy$default(oAuthFlow, null, null, null, null, map, 15, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return OAuthFlow$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public OAuthFlow() {
        this((String) null, (String) null, (String) null, (Map) null, (Map) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAuthFlow(String str, String str2, String str3, Map<String, String> map, Map<String, ? extends GenericElement> map2) {
        this.authorizationUrl = str;
        this.tokenUrl = str2;
        this.refreshUrl = str3;
        this.scopes = map;
        this.extensions = map2;
    }

    public /* synthetic */ OAuthFlow(String str, String str2, String str3, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2);
    }
}
