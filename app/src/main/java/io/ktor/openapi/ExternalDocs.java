package io.ktor.openapi;

import androidx.media3.common.Format$$ExternalSyntheticOutline0;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%$B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0007HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\rJ'\u0010 \u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\r¨\u0006&"}, d2 = {"Lio/ktor/openapi/ExternalDocs;", "", "", "description", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/openapi/ExternalDocs;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/ExternalDocs;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getDescription", "getUrl", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class ExternalDocs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final String url;

    public /* synthetic */ ExternalDocs(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            EnumsKt.throwMissingFieldException(ExternalDocs$$serializer.INSTANCE.getDescriptor(), i, 2);
            throw null;
        }
        if ((i & 1) == 0) {
            this.description = null;
        } else {
            this.description = str;
        }
        this.url = str2;
    }

    public static /* synthetic */ ExternalDocs copy$default(ExternalDocs externalDocs, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalDocs.description;
        }
        if ((i & 2) != 0) {
            str2 = externalDocs.url;
        }
        return externalDocs.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(ExternalDocs self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.description);
        }
        output.encodeStringElement(serialDesc, 1, self.url);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ExternalDocs copy(String description, String url) {
        url.getClass();
        return new ExternalDocs(description, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExternalDocs)) {
            return false;
        }
        ExternalDocs externalDocs = (ExternalDocs) other;
        return Intrinsics.areEqual(this.description, externalDocs.description) && Intrinsics.areEqual(this.url, externalDocs.url);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.description;
        return this.url.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExternalDocs(description=");
        sb.append(this.description);
        sb.append(", url=");
        return Format$$ExternalSyntheticOutline0.m(sb, this.url, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/ExternalDocs$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/ExternalDocs;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return ExternalDocs$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public ExternalDocs(String str, String str2) {
        str2.getClass();
        this.description = str;
        this.url = str2;
    }

    public /* synthetic */ ExternalDocs(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2);
    }
}
