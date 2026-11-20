package io.ktor.openapi;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import io.ktor.http.ContentDisposition;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0004?@ABBc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010Bm\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0002`\rHÆ\u0003¢\u0006\u0004\b\u001f\u0010 Jp\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0002`\rHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u001b\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0083\u0004¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b*\u0010\u0017J'\u00103\u001a\u0002002\u0006\u0010+\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b5\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00104\u001a\u0004\b6\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b7\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\b8\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b:\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010;\u001a\u0004\b<\u0010\u001eR,\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0002`\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\b>\u0010 ¨\u0006C"}, d2 = {"Lio/ktor/openapi/OpenApiInfo;", "Lio/ktor/openapi/Extensible;", "", LinkHeader.Parameters.Title, "version", "description", "termsOfService", "Lio/ktor/openapi/OpenApiInfo$Contact;", "contact", "Lio/ktor/openapi/OpenApiInfo$License;", "license", "", "Lio/ktor/openapi/GenericElement;", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/OpenApiInfo$Contact;Lio/ktor/openapi/OpenApiInfo$License;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/OpenApiInfo$Contact;Lio/ktor/openapi/OpenApiInfo$License;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Lio/ktor/openapi/OpenApiInfo$Contact;", "component6", "()Lio/ktor/openapi/OpenApiInfo$License;", "component7", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/OpenApiInfo$Contact;Lio/ktor/openapi/OpenApiInfo$License;Ljava/util/Map;)Lio/ktor/openapi/OpenApiInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OpenApiInfo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getTitle", "getVersion", "getDescription", "getTermsOfService", "Lio/ktor/openapi/OpenApiInfo$Contact;", "getContact", "Lio/ktor/openapi/OpenApiInfo$License;", "getLicense", "Ljava/util/Map;", "getExtensions", "Companion", "Contact", "License", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class OpenApiInfo implements Extensible {
    private final Contact contact;
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final License license;
    private final String termsOfService;
    private final String title;
    private final String version;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {null, null, null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Link$$ExternalSyntheticLambda0(22))};

    public /* synthetic */ OpenApiInfo(int i, String str, String str2, String str3, String str4, Contact contact, License license, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(OpenApiInfo$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.title = str;
        this.version = str2;
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 8) == 0) {
            this.termsOfService = null;
        } else {
            this.termsOfService = str4;
        }
        if ((i & 16) == 0) {
            this.contact = new Contact((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        } else {
            this.contact = contact;
        }
        if ((i & 32) == 0) {
            this.license = null;
        } else {
            this.license = license;
        }
        if ((i & 64) == 0) {
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
    public static /* synthetic */ OpenApiInfo copy$default(OpenApiInfo openApiInfo, String str, String str2, String str3, String str4, Contact contact, License license, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openApiInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = openApiInfo.version;
        }
        if ((i & 4) != 0) {
            str3 = openApiInfo.description;
        }
        if ((i & 8) != 0) {
            str4 = openApiInfo.termsOfService;
        }
        if ((i & 16) != 0) {
            contact = openApiInfo.contact;
        }
        if ((i & 32) != 0) {
            license = openApiInfo.license;
        }
        if ((i & 64) != 0) {
            map = openApiInfo.extensions;
        }
        License license2 = license;
        Map map2 = map;
        Contact contact2 = contact;
        String str5 = str3;
        return openApiInfo.copy(str, str2, str5, str4, contact2, license2, map2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004e  */
    public static final /* synthetic */ void write$Self$ktor_openapi_schema(OpenApiInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.title);
        output.encodeStringElement(serialDesc, 1, self.version);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.termsOfService != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.termsOfService);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4)) {
            output.encodeNullableSerializableElement(serialDesc, 4, OpenApiInfo$Contact$$serializer.INSTANCE, self.contact);
        } else {
            if (!Intrinsics.areEqual(self.contact, new Contact((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null))) {
                output.encodeNullableSerializableElement(serialDesc, 4, OpenApiInfo$Contact$$serializer.INSTANCE, self.contact);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.license != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, OpenApiInfo$License$$serializer.INSTANCE, self.license);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTermsOfService() {
        return this.termsOfService;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Contact getContact() {
        return this.contact;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final License getLicense() {
        return this.license;
    }

    public final Map<String, GenericElement> component7() {
        return this.extensions;
    }

    public final OpenApiInfo copy(String title, String version, String description, String termsOfService, Contact contact, License license, Map<String, ? extends GenericElement> extensions) {
        title.getClass();
        version.getClass();
        return new OpenApiInfo(title, version, description, termsOfService, contact, license, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenApiInfo)) {
            return false;
        }
        OpenApiInfo openApiInfo = (OpenApiInfo) other;
        return Intrinsics.areEqual(this.title, openApiInfo.title) && Intrinsics.areEqual(this.version, openApiInfo.version) && Intrinsics.areEqual(this.description, openApiInfo.description) && Intrinsics.areEqual(this.termsOfService, openApiInfo.termsOfService) && Intrinsics.areEqual(this.contact, openApiInfo.contact) && Intrinsics.areEqual(this.license, openApiInfo.license) && Intrinsics.areEqual(this.extensions, openApiInfo.extensions);
    }

    public final Contact getContact() {
        return this.contact;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final License getLicense() {
        return this.license;
    }

    public final String getTermsOfService() {
        return this.termsOfService;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.version);
        String str = this.description;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.termsOfService;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Contact contact = this.contact;
        int iHashCode3 = (iHashCode2 + (contact == null ? 0 : contact.hashCode())) * 31;
        License license = this.license;
        int iHashCode4 = (iHashCode3 + (license == null ? 0 : license.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OpenApiInfo(title=");
        sb.append(this.title);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", termsOfService=");
        sb.append(this.termsOfService);
        sb.append(", contact=");
        sb.append(this.contact);
        sb.append(", license=");
        sb.append(this.license);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ4\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u000eJ'\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$Contact;", "", "", ContentDisposition.Parameters.Name, "url", "email", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/openapi/OpenApiInfo$Contact;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OpenApiInfo$Contact;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "getUrl", "getEmail", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Contact {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final String name;
        private final String url;

        public /* synthetic */ Contact(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.name = null;
            } else {
                this.name = str;
            }
            if ((i & 2) == 0) {
                this.url = null;
            } else {
                this.url = str2;
            }
            if ((i & 4) == 0) {
                this.email = null;
            } else {
                this.email = str3;
            }
        }

        public static /* synthetic */ Contact copy$default(Contact contact, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contact.name;
            }
            if ((i & 2) != 0) {
                str2 = contact.url;
            }
            if ((i & 4) != 0) {
                str3 = contact.email;
            }
            return contact.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$ktor_openapi_schema(Contact self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.url);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.email == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.email);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        public final Contact copy(String name, String url, String email) {
            return new Contact(name, url, email);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Contact)) {
                return false;
            }
            Contact contact = (Contact) other;
            return Intrinsics.areEqual(this.name, contact.name) && Intrinsics.areEqual(this.url, contact.url) && Intrinsics.areEqual(this.email, contact.email);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.url;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.email;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Contact(name=");
            sb.append(this.name);
            sb.append(", url=");
            sb.append(this.url);
            sb.append(", email=");
            return Format$$ExternalSyntheticOutline0.m(sb, this.email, ')');
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$Contact$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OpenApiInfo$Contact;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return OpenApiInfo$Contact$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public Contact() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public Contact(String str, String str2, String str3) {
            this.name = str;
            this.url = str2;
            this.email = str3;
        }

        public /* synthetic */ Contact(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ2\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u000eJ'\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$License;", "", "", ContentDisposition.Parameters.Name, "url", "identifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/ktor/openapi/OpenApiInfo$License;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/OpenApiInfo$License;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "getUrl", "getIdentifier", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @Serializable
    public static final /* data */ class License {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String identifier;
        private final String name;
        private final String url;

        public /* synthetic */ License(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(OpenApiInfo$License$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.name = str;
            if ((i & 2) == 0) {
                this.url = null;
            } else {
                this.url = str2;
            }
            if ((i & 4) == 0) {
                this.identifier = null;
            } else {
                this.identifier = str3;
            }
        }

        public static /* synthetic */ License copy$default(License license, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = license.name;
            }
            if ((i & 2) != 0) {
                str2 = license.url;
            }
            if ((i & 4) != 0) {
                str3 = license.identifier;
            }
            return license.copy(str, str2, str3);
        }

        public static final /* synthetic */ void write$Self$ktor_openapi_schema(License self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.name);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.url);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.identifier == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.identifier);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        public final License copy(String name, String url, String identifier) {
            name.getClass();
            return new License(name, url, identifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof License)) {
                return false;
            }
            License license = (License) other;
            return Intrinsics.areEqual(this.name, license.name) && Intrinsics.areEqual(this.url, license.url) && Intrinsics.areEqual(this.identifier, license.identifier);
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            String str = this.url;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.identifier;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("License(name=");
            sb.append(this.name);
            sb.append(", url=");
            sb.append(this.url);
            sb.append(", identifier=");
            return Format$$ExternalSyntheticOutline0.m(sb, this.identifier, ')');
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$License$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OpenApiInfo$License;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer serializer() {
                return OpenApiInfo$License$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public License(String str, String str2, String str3) {
            str.getClass();
            this.name = str;
            this.url = str2;
            this.identifier = str3;
        }

        public /* synthetic */ License(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/OpenApiInfo;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/OpenApiInfo$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/OpenApiInfo;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<OpenApiInfo> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(OpenApiInfo.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 28));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OpenApiInfo _init_$lambda$0(OpenApiInfo openApiInfo, Map map) {
                openApiInfo.getClass();
                return OpenApiInfo.copy$default(openApiInfo, null, null, null, null, null, null, map, 63, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return OpenApiInfo$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenApiInfo(String str, String str2, String str3, String str4, Contact contact, License license, Map<String, ? extends GenericElement> map) {
        str.getClass();
        str2.getClass();
        this.title = str;
        this.version = str2;
        this.description = str3;
        this.termsOfService = str4;
        this.contact = contact;
        this.license = license;
        this.extensions = map;
    }

    public /* synthetic */ OpenApiInfo(String str, String str2, String str3, String str4, Contact contact, License license, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? new Contact((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : contact, (i & 32) != 0 ? null : license, (i & 64) != 0 ? null : map);
    }
}
