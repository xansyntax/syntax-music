package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002+*B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\tHÖ\u0081\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u000fJ'\u0010$\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u0012¨\u0006,"}, d2 = {"Lio/ktor/openapi/Tag;", "", "", ContentDisposition.Parameters.Name, "description", "Lio/ktor/openapi/ExternalDocs;", "externalDocs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/openapi/ExternalDocs;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/ExternalDocs;)Lio/ktor/openapi/Tag;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Tag;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "getDescription", "Lio/ktor/openapi/ExternalDocs;", "getExternalDocs", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Tag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final ExternalDocs externalDocs;
    private final String name;

    public /* synthetic */ Tag(int i, String str, String str2, ExternalDocs externalDocs, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(Tag$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.name = str;
        if ((i & 2) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 4) == 0) {
            this.externalDocs = null;
        } else {
            this.externalDocs = externalDocs;
        }
    }

    public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, ExternalDocs externalDocs, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tag.name;
        }
        if ((i & 2) != 0) {
            str2 = tag.description;
        }
        if ((i & 4) != 0) {
            externalDocs = tag.externalDocs;
        }
        return tag.copy(str, str2, externalDocs);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(Tag self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.externalDocs == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, ExternalDocs$$serializer.INSTANCE, self.externalDocs);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final Tag copy(String name, String description, ExternalDocs externalDocs) {
        name.getClass();
        return new Tag(name, description, externalDocs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) other;
        return Intrinsics.areEqual(this.name, tag.name) && Intrinsics.areEqual(this.description, tag.description) && Intrinsics.areEqual(this.externalDocs, tag.externalDocs);
    }

    public final String getDescription() {
        return this.description;
    }

    public final ExternalDocs getExternalDocs() {
        return this.externalDocs;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ExternalDocs externalDocs = this.externalDocs;
        return iHashCode2 + (externalDocs != null ? externalDocs.hashCode() : 0);
    }

    public String toString() {
        return "Tag(name=" + this.name + ", description=" + this.description + ", externalDocs=" + this.externalDocs + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Tag$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Tag;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Tag$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Tag(String str, String str2, ExternalDocs externalDocs) {
        str.getClass();
        this.name = str;
        this.description = str2;
        this.externalDocs = externalDocs;
    }

    public /* synthetic */ Tag(String str, String str2, ExternalDocs externalDocs, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : externalDocs);
    }
}
