package io.ktor.openapi;

import io.ktor.http.ContentType;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002?@Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011Bu\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\"\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b \u0010\u001aJx\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0002`\u000eHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0083\u0004¢\u0006\u0004\b%\u0010&J\u0011\u0010'\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b'\u0010(J\u0011\u0010)\u001a\u00020\u0005HÖ\u0081\u0004¢\u0006\u0004\b)\u0010\u001cJ'\u00102\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b0\u00101R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u00103\u0012\u0004\b5\u00106\u001a\u0004\b4\u0010\u0018R+\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b8\u0010\u001aR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\b:\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010;\u001a\u0004\b<\u0010\u001eR\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\b=\u0010\u001eR,\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004j\u0002`\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u00107\u001a\u0004\b>\u0010\u001a¨\u0006A"}, d2 = {"Lio/ktor/openapi/Encoding;", "Lio/ktor/openapi/Extensible;", "Lio/ktor/http/ContentType;", "contentType", "", "", "Lio/ktor/openapi/ReferenceOr;", "Lio/ktor/openapi/Header;", "headers", "style", "", "explode", "allowReserved", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Lio/ktor/http/ContentType;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILio/ktor/http/ContentType;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Lio/ktor/http/ContentType;", "component2", "()Ljava/util/Map;", "component3", "()Ljava/lang/String;", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "copy", "(Lio/ktor/http/ContentType;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Map;)Lio/ktor/openapi/Encoding;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Encoding;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lio/ktor/http/ContentType;", "getContentType", "getContentType$annotations", "()V", "Ljava/util/Map;", "getHeaders", "Ljava/lang/String;", "getStyle", "Ljava/lang/Boolean;", "getExplode", "getAllowReserved", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class Encoding implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean allowReserved;
    private final ContentType contentType;
    private final Boolean explode;
    private final Map<String, GenericElement> extensions;
    private final Map<String, ReferenceOr<Header>> headers;
    private final String style;

    static {
        Header$$ExternalSyntheticLambda0 header$$ExternalSyntheticLambda0 = new Header$$ExternalSyntheticLambda0((byte) 7);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, header$$ExternalSyntheticLambda0), null, null, null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 8))};
    }

    public /* synthetic */ Encoding(int i, ContentType contentType, Map map, String str, Boolean bool, Boolean bool2, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(Encoding$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.contentType = contentType;
        if ((i & 2) == 0) {
            this.headers = null;
        } else {
            this.headers = map;
        }
        if ((i & 4) == 0) {
            this.style = null;
        } else {
            this.style = str;
        }
        if ((i & 8) == 0) {
            this.explode = null;
        } else {
            this.explode = bool;
        }
        if ((i & 16) == 0) {
            this.allowReserved = null;
        } else {
            this.allowReserved = bool2;
        }
        if ((i & 32) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new ReferenceOr.Companion.Serializer(Header.Companion.Serializer.INSTANCE), (byte) 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Encoding copy$default(Encoding encoding, ContentType contentType, Map map, String str, Boolean bool, Boolean bool2, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            contentType = encoding.contentType;
        }
        if ((i & 2) != 0) {
            map = encoding.headers;
        }
        if ((i & 4) != 0) {
            str = encoding.style;
        }
        if ((i & 8) != 0) {
            bool = encoding.explode;
        }
        if ((i & 16) != 0) {
            bool2 = encoding.allowReserved;
        }
        if ((i & 32) != 0) {
            map2 = encoding.extensions;
        }
        Boolean bool3 = bool2;
        Map map3 = map2;
        return encoding.copy(contentType, map, str, bool, bool3, map3);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Encoding self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, ContentTypeSerializer.INSTANCE, self.contentType);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.headers != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.style != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.style);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.explode != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.explode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.allowReserved != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.allowReserved);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContentType getContentType() {
        return this.contentType;
    }

    public final Map<String, ReferenceOr<Header>> component2() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getExplode() {
        return this.explode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getAllowReserved() {
        return this.allowReserved;
    }

    public final Map<String, GenericElement> component6() {
        return this.extensions;
    }

    public final Encoding copy(ContentType contentType, Map<String, ? extends ReferenceOr<Header>> headers, String style, Boolean explode, Boolean allowReserved, Map<String, ? extends GenericElement> extensions) {
        contentType.getClass();
        return new Encoding(contentType, headers, style, explode, allowReserved, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Encoding)) {
            return false;
        }
        Encoding encoding = (Encoding) other;
        return Intrinsics.areEqual(this.contentType, encoding.contentType) && Intrinsics.areEqual(this.headers, encoding.headers) && Intrinsics.areEqual(this.style, encoding.style) && Intrinsics.areEqual(this.explode, encoding.explode) && Intrinsics.areEqual(this.allowReserved, encoding.allowReserved) && Intrinsics.areEqual(this.extensions, encoding.extensions);
    }

    public final Boolean getAllowReserved() {
        return this.allowReserved;
    }

    public final ContentType getContentType() {
        return this.contentType;
    }

    public final Boolean getExplode() {
        return this.explode;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final Map<String, ReferenceOr<Header>> getHeaders() {
        return this.headers;
    }

    public final String getStyle() {
        return this.style;
    }

    public int hashCode() {
        int iHashCode = this.contentType.hashCode() * 31;
        Map<String, ReferenceOr<Header>> map = this.headers;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.style;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.explode;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.allowReserved;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Map<String, GenericElement> map2 = this.extensions;
        return iHashCode5 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Encoding(contentType=");
        sb.append(this.contentType);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", style=");
        sb.append(this.style);
        sb.append(", explode=");
        sb.append(this.explode);
        sb.append(", allowReserved=");
        sb.append(this.allowReserved);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/Encoding$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Encoding;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/Encoding$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/Encoding;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<Encoding> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(Encoding.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 18));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Encoding _init_$lambda$0(Encoding encoding, Map map) {
                encoding.getClass();
                return Encoding.copy$default(encoding, null, null, null, null, null, map, 31, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return Encoding$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Serializable(with = ContentTypeSerializer.class)
    public static /* synthetic */ void getContentType$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Encoding(ContentType contentType, Map<String, ? extends ReferenceOr<Header>> map, String str, Boolean bool, Boolean bool2, Map<String, ? extends GenericElement> map2) {
        contentType.getClass();
        this.contentType = contentType;
        this.headers = map;
        this.style = str;
        this.explode = bool;
        this.allowReserved = bool2;
        this.extensions = map2;
    }

    public /* synthetic */ Encoding(ContentType contentType, Map map, String str, Boolean bool, Boolean bool2, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contentType, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : map2);
    }
}
