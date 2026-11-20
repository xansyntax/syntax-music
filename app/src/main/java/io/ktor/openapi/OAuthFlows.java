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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000256BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0002`\n¢\u0006\u0004\b\f\u0010\rBY\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\\\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0002`\nHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b#\u0010$J'\u0010-\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b+\u0010,R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b0\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b1\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b2\u0010\u0014R,\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0002`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b4\u0010\u0019¨\u00067"}, d2 = {"Lio/ktor/openapi/OAuthFlows;", "Lio/ktor/openapi/Extensible;", "Lio/ktor/openapi/OAuthFlow;", "implicit", "password", "clientCredentials", "authorizationCode", "", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/openapi/OAuthFlow;", "component2", "component3", "component4", "component5", "()Ljava/util/Map;", "copy", "(Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Lio/ktor/openapi/OAuthFlow;Ljava/util/Map;)Lio/ktor/openapi/OAuthFlows;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OAuthFlows;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/openapi/OAuthFlow;", "getImplicit", "getPassword", "getClientCredentials", "getAuthorizationCode", "Ljava/util/Map;", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class OAuthFlows implements Extensible {
    private final OAuthFlow authorizationCode;
    private final OAuthFlow clientCredentials;
    private final Map<String, GenericElement> extensions;
    private final OAuthFlow implicit;
    private final OAuthFlow password;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Link$$ExternalSyntheticLambda0(15))};

    public /* synthetic */ OAuthFlows(int i, OAuthFlow oAuthFlow, OAuthFlow oAuthFlow2, OAuthFlow oAuthFlow3, OAuthFlow oAuthFlow4, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.implicit = null;
        } else {
            this.implicit = oAuthFlow;
        }
        if ((i & 2) == 0) {
            this.password = null;
        } else {
            this.password = oAuthFlow2;
        }
        if ((i & 4) == 0) {
            this.clientCredentials = null;
        } else {
            this.clientCredentials = oAuthFlow3;
        }
        if ((i & 8) == 0) {
            this.authorizationCode = null;
        } else {
            this.authorizationCode = oAuthFlow4;
        }
        if ((i & 16) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OAuthFlows copy$default(OAuthFlows oAuthFlows, OAuthFlow oAuthFlow, OAuthFlow oAuthFlow2, OAuthFlow oAuthFlow3, OAuthFlow oAuthFlow4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            oAuthFlow = oAuthFlows.implicit;
        }
        if ((i & 2) != 0) {
            oAuthFlow2 = oAuthFlows.password;
        }
        if ((i & 4) != 0) {
            oAuthFlow3 = oAuthFlows.clientCredentials;
        }
        if ((i & 8) != 0) {
            oAuthFlow4 = oAuthFlows.authorizationCode;
        }
        if ((i & 16) != 0) {
            map = oAuthFlows.extensions;
        }
        Map map2 = map;
        OAuthFlow oAuthFlow5 = oAuthFlow3;
        return oAuthFlows.copy(oAuthFlow, oAuthFlow2, oAuthFlow5, oAuthFlow4, map2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(OAuthFlows self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.implicit != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, OAuthFlow.Companion.Serializer.INSTANCE, self.implicit);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.password != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, OAuthFlow.Companion.Serializer.INSTANCE, self.password);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.clientCredentials != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, OAuthFlow.Companion.Serializer.INSTANCE, self.clientCredentials);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.authorizationCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, OAuthFlow.Companion.Serializer.INSTANCE, self.authorizationCode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OAuthFlow getImplicit() {
        return this.implicit;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OAuthFlow getPassword() {
        return this.password;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OAuthFlow getClientCredentials() {
        return this.clientCredentials;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OAuthFlow getAuthorizationCode() {
        return this.authorizationCode;
    }

    public final Map<String, GenericElement> component5() {
        return this.extensions;
    }

    public final OAuthFlows copy(OAuthFlow implicit, OAuthFlow password, OAuthFlow clientCredentials, OAuthFlow authorizationCode, Map<String, ? extends GenericElement> extensions) {
        return new OAuthFlows(implicit, password, clientCredentials, authorizationCode, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OAuthFlows)) {
            return false;
        }
        OAuthFlows oAuthFlows = (OAuthFlows) other;
        return Intrinsics.areEqual(this.implicit, oAuthFlows.implicit) && Intrinsics.areEqual(this.password, oAuthFlows.password) && Intrinsics.areEqual(this.clientCredentials, oAuthFlows.clientCredentials) && Intrinsics.areEqual(this.authorizationCode, oAuthFlows.authorizationCode) && Intrinsics.areEqual(this.extensions, oAuthFlows.extensions);
    }

    public final OAuthFlow getAuthorizationCode() {
        return this.authorizationCode;
    }

    public final OAuthFlow getClientCredentials() {
        return this.clientCredentials;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final OAuthFlow getImplicit() {
        return this.implicit;
    }

    public final OAuthFlow getPassword() {
        return this.password;
    }

    public int hashCode() {
        OAuthFlow oAuthFlow = this.implicit;
        int iHashCode = (oAuthFlow == null ? 0 : oAuthFlow.hashCode()) * 31;
        OAuthFlow oAuthFlow2 = this.password;
        int iHashCode2 = (iHashCode + (oAuthFlow2 == null ? 0 : oAuthFlow2.hashCode())) * 31;
        OAuthFlow oAuthFlow3 = this.clientCredentials;
        int iHashCode3 = (iHashCode2 + (oAuthFlow3 == null ? 0 : oAuthFlow3.hashCode())) * 31;
        OAuthFlow oAuthFlow4 = this.authorizationCode;
        int iHashCode4 = (iHashCode3 + (oAuthFlow4 == null ? 0 : oAuthFlow4.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuthFlows(implicit=");
        sb.append(this.implicit);
        sb.append(", password=");
        sb.append(this.password);
        sb.append(", clientCredentials=");
        sb.append(this.clientCredentials);
        sb.append(", authorizationCode=");
        sb.append(this.authorizationCode);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/OAuthFlows$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OAuthFlows;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/OAuthFlows$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/OAuthFlows;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<OAuthFlows> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(OAuthFlows.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 26));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OAuthFlows _init_$lambda$0(OAuthFlows oAuthFlows, Map map) {
                oAuthFlows.getClass();
                return OAuthFlows.copy$default(oAuthFlows, null, null, null, null, map, 15, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return OAuthFlows$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public OAuthFlows() {
        this((OAuthFlow) null, (OAuthFlow) null, (OAuthFlow) null, (OAuthFlow) null, (Map) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OAuthFlows(OAuthFlow oAuthFlow, OAuthFlow oAuthFlow2, OAuthFlow oAuthFlow3, OAuthFlow oAuthFlow4, Map<String, ? extends GenericElement> map) {
        this.implicit = oAuthFlow;
        this.password = oAuthFlow2;
        this.clientCredentials = oAuthFlow3;
        this.authorizationCode = oAuthFlow4;
        this.extensions = map;
    }

    public /* synthetic */ OAuthFlows(OAuthFlow oAuthFlow, OAuthFlow oAuthFlow2, OAuthFlow oAuthFlow3, OAuthFlow oAuthFlow4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : oAuthFlow, (i & 2) != 0 ? null : oAuthFlow2, (i & 4) != 0 ? null : oAuthFlow3, (i & 8) != 0 ? null : oAuthFlow4, (i & 16) != 0 ? null : map);
    }
}
