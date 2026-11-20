package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0003%&$B'\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007B=\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012 \u0010\u0005\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u000f\u001a\u00020\u00002 \b\u0002\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\bHÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 R/\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u000e¨\u0006'"}, d2 = {"Lio/ktor/openapi/Security;", "", "", "", "", "requirements", "<init>", "(Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lio/ktor/openapi/Security;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Security;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getRequirements", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Security {
    private final List<Map<String, List<String>>> requirements;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Xml$$ExternalSyntheticLambda0(23))};

    public /* synthetic */ Security(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (i & 1)) {
            this.requirements = list;
        } else {
            EnumsKt.throwMissingFieldException(Security$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new HashSetSerializer(new HashMapSerializer(stringSerializer, new HashSetSerializer(stringSerializer, (byte) 1), (byte) 1), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Security copy$default(Security security, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = security.requirements;
        }
        return security.copy(list);
    }

    public final List<Map<String, List<String>>> component1() {
        return this.requirements;
    }

    public final Security copy(List<? extends Map<String, ? extends List<String>>> requirements) {
        requirements.getClass();
        return new Security(requirements);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Security) && Intrinsics.areEqual(this.requirements, ((Security) other).requirements);
    }

    public final List<Map<String, List<String>>> getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        return this.requirements.hashCode();
    }

    public String toString() {
        return "Security(requirements=" + this.requirements + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Security$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Security;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Security$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u000b¢\u0006\u0004\b\t\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0003J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0013\"\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0013\"\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019R,\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u000b0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u000b0\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lio/ktor/openapi/Security$Builder;", "", "<init>", "()V", "", "scheme", "", "scopes", "", "requirement", "(Ljava/lang/String;Ljava/util/List;)V", "", "schemes", "(Ljava/util/Map;)V", "optional", "basic", ContentDisposition.Parameters.Name, "apiKey", "(Ljava/lang/String;)V", "", "oauth2", "([Ljava/lang/String;)V", "openIdConnect", "Lio/ktor/openapi/Security;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Security;", "build", "", "_requirements", "Ljava/util/List;", "getRequirements", "()Ljava/util/List;", "requirements", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final List<Map<String, List<String>>> _requirements = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void requirement$default(Builder builder, String str, List list, int i, Object obj) {
            if ((i & 2) != 0) {
                list = EmptyList.INSTANCE;
            }
            builder.requirement(str, list);
        }

        public final void apiKey(String name) {
            name.getClass();
            requirement$default(this, name, null, 2, null);
        }

        public final void basic() {
            requirement$default(this, "basicAuth", null, 2, null);
        }

        public final Security build$ktor_openapi_schema() {
            return new Security(this._requirements);
        }

        public final List<Map<String, List<String>>> getRequirements() {
            return this._requirements;
        }

        public final void oauth2(String... scopes) {
            scopes.getClass();
            requirement("oauth2", ArraysKt.toList(scopes));
        }

        public final void openIdConnect(String... scopes) {
            scopes.getClass();
            requirement("openIdConnect", ArraysKt.toList(scopes));
        }

        public final void optional() {
            this._requirements.add(EmptyMap.INSTANCE);
        }

        public final void requirement(String scheme, List<String> scopes) {
            scheme.getClass();
            scopes.getClass();
            List<Map<String, List<String>>> list = this._requirements;
            Map<String, List<String>> mapSingletonMap = Collections.singletonMap(scheme, scopes);
            mapSingletonMap.getClass();
            list.add(mapSingletonMap);
        }

        public final void requirement(Map<String, ? extends List<String>> schemes) {
            schemes.getClass();
            this._requirements.add(schemes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Security(List<? extends Map<String, ? extends List<String>>> list) {
        list.getClass();
        this.requirements = list;
    }
}
