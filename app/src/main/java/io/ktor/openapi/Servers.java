package io.ktor.openapi;

import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0003%&$B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0007HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010\r¨\u0006'"}, d2 = {"Lio/ktor/openapi/Servers;", "", "", "Lio/ktor/openapi/Server;", "servers", "<init>", "(Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lio/ktor/openapi/Servers;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Servers;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getServers", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Servers {
    private final List<Server> servers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Xml$$ExternalSyntheticLambda0(27))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/openapi/Servers$Builder;", "", "<init>", "()V", "", "url", "Lkotlin/Function1;", "Lio/ktor/openapi/Server$Builder;", "", "configure", "server", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/openapi/Servers;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Servers;", "build", "", "Lio/ktor/openapi/Server;", "_servers", "Ljava/util/List;", "", "getServers", "()Ljava/util/List;", "servers", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final List<Server> _servers = new ArrayList();

        public static /* synthetic */ void server$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = new InstantKt$$ExternalSyntheticLambda0((byte) 3);
            }
            builder.server(str, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit server$lambda$0(Server.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Servers build$ktor_openapi_schema() {
            return new Servers(this._servers);
        }

        public final List<Server> getServers() {
            return this._servers;
        }

        public final void server(String url, Function1 configure) {
            url.getClass();
            configure.getClass();
            List<Server> list = this._servers;
            Server.Builder builder = new Server.Builder();
            builder.setUrl(url);
            configure.invoke(builder);
            list.add(builder.build$ktor_openapi_schema());
        }
    }

    public /* synthetic */ Servers(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (i & 1)) {
            this.servers = list;
        } else {
            EnumsKt.throwMissingFieldException(Servers$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(Server.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Servers copy$default(Servers servers, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = servers.servers;
        }
        return servers.copy(list);
    }

    public final List<Server> component1() {
        return this.servers;
    }

    public final Servers copy(List<Server> servers) {
        servers.getClass();
        return new Servers(servers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Servers) && Intrinsics.areEqual(this.servers, ((Servers) other).servers);
    }

    public final List<Server> getServers() {
        return this.servers;
    }

    public int hashCode() {
        return this.servers.hashCode();
    }

    public String toString() {
        return "Servers(servers=" + this.servers + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Servers$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Servers;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Servers$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Servers(List<Server> list) {
        list.getClass();
        this.servers = list;
    }
}
