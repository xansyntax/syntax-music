package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000289B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0002`\u000b¢\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0015J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\"\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJh\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0002`\u000bHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0083\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b%\u0010\u0015J'\u0010.\u001a\u00020+2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b,\u0010-R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b2\u0010\u0015R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00103\u001a\u0004\b4\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b5\u0010\u0019R,\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0002`\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u00106\u001a\u0004\b7\u0010\u001c¨\u0006:"}, d2 = {"Lio/ktor/openapi/Xml;", "Lio/ktor/openapi/Extensible;", "", ContentDisposition.Parameters.Name, "namespace", "prefix", "", "attribute", "wrapped", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)Lio/ktor/openapi/Xml;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Xml;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "getNamespace", "getPrefix", "Ljava/lang/Boolean;", "getAttribute", "getWrapped", "Ljava/util/Map;", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Xml implements Extensible {
    private final Boolean attribute;
    private final Map<String, GenericElement> extensions;
    private final String name;
    private final String namespace;
    private final String prefix;
    private final Boolean wrapped;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {null, null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Xml$$ExternalSyntheticLambda0(0))};

    public /* synthetic */ Xml(int i, String str, String str2, String str3, Boolean bool, Boolean bool2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.name = null;
        } else {
            this.name = str;
        }
        if ((i & 2) == 0) {
            this.namespace = null;
        } else {
            this.namespace = str2;
        }
        if ((i & 4) == 0) {
            this.prefix = null;
        } else {
            this.prefix = str3;
        }
        if ((i & 8) == 0) {
            this.attribute = null;
        } else {
            this.attribute = bool;
        }
        if ((i & 16) == 0) {
            this.wrapped = null;
        } else {
            this.wrapped = bool2;
        }
        if ((i & 32) == 0) {
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
    public static /* synthetic */ Xml copy$default(Xml xml, String str, String str2, String str3, Boolean bool, Boolean bool2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = xml.name;
        }
        if ((i & 2) != 0) {
            str2 = xml.namespace;
        }
        if ((i & 4) != 0) {
            str3 = xml.prefix;
        }
        if ((i & 8) != 0) {
            bool = xml.attribute;
        }
        if ((i & 16) != 0) {
            bool2 = xml.wrapped;
        }
        if ((i & 32) != 0) {
            map = xml.extensions;
        }
        Boolean bool3 = bool2;
        Map map2 = map;
        return xml.copy(str, str2, str3, bool, bool3, map2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Xml self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.namespace != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.namespace);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.prefix != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.prefix);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.attribute != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.attribute);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.wrapped != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.wrapped);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getAttribute() {
        return this.attribute;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getWrapped() {
        return this.wrapped;
    }

    public final Map<String, GenericElement> component6() {
        return this.extensions;
    }

    public final Xml copy(String name, String namespace, String prefix, Boolean attribute, Boolean wrapped, Map<String, ? extends GenericElement> extensions) {
        return new Xml(name, namespace, prefix, attribute, wrapped, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Xml)) {
            return false;
        }
        Xml xml = (Xml) other;
        return Intrinsics.areEqual(this.name, xml.name) && Intrinsics.areEqual(this.namespace, xml.namespace) && Intrinsics.areEqual(this.prefix, xml.prefix) && Intrinsics.areEqual(this.attribute, xml.attribute) && Intrinsics.areEqual(this.wrapped, xml.wrapped) && Intrinsics.areEqual(this.extensions, xml.extensions);
    }

    public final Boolean getAttribute() {
        return this.attribute;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final Boolean getWrapped() {
        return this.wrapped;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.namespace;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.prefix;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.attribute;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.wrapped;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode5 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Xml(name=");
        sb.append(this.name);
        sb.append(", namespace=");
        sb.append(this.namespace);
        sb.append(", prefix=");
        sb.append(this.prefix);
        sb.append(", attribute=");
        sb.append(this.attribute);
        sb.append(", wrapped=");
        sb.append(this.wrapped);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Xml$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Xml;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Xml$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Xml;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Xml> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Xml.INSTANCE.generatedSerializer$ktor_openapi_schema(), new CombinedContext$$ExternalSyntheticLambda0((byte) 7));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Xml _init_$lambda$0(Xml xml, Map map) {
                xml.getClass();
                return Xml.copy$default(xml, null, null, null, null, null, map, 31, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Xml$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Xml() {
        this((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Map) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Xml(String str, String str2, String str3, Boolean bool, Boolean bool2, Map<String, ? extends GenericElement> map) {
        this.name = str;
        this.namespace = str2;
        this.prefix = str3;
        this.attribute = bool;
        this.wrapped = bool2;
        this.extensions = map;
    }

    public /* synthetic */ Xml(String str, String str2, String str3, Boolean bool, Boolean bool2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : map);
    }
}
