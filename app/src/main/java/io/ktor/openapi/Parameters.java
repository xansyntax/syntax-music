package io.ktor.openapi;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.URLUtilsKt$$ExternalSyntheticLambda0;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0003%&$B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0007HÖ\u0081\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016HÖ\u0081\u0004¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010\r¨\u0006'"}, d2 = {"Lio/ktor/openapi/Parameters;", "", "", "Lio/ktor/openapi/Parameter;", "parameters", "<init>", "(Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/util/List;", "copy", "(Ljava/util/List;)Lio/ktor/openapi/Parameters;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/Parameters;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getParameters", "Companion", "Builder", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Parameters {
    private final List<Parameter> parameters;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Xml$$ExternalSyntheticLambda0(10))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0011\u0010\u0010J+\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0012\u0010\u0010J+\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0013\u0010\u0010J+\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lio/ktor/openapi/Parameters$Builder;", "", "Lio/ktor/openapi/JsonSchemaInference;", "schemaInference", "", "Lio/ktor/http/ContentType;", "defaultContentTypes", "<init>", "(Lio/ktor/openapi/JsonSchemaInference;Ljava/util/List;)V", "", ContentDisposition.Parameters.Name, "Lkotlin/Function1;", "Lio/ktor/openapi/Parameter$Builder;", "", "configure", "parameter", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "path", "query", "header", "cookie", "Lio/ktor/openapi/Parameters;", "build$ktor_openapi_schema", "()Lio/ktor/openapi/Parameters;", "build", "Lio/ktor/openapi/JsonSchemaInference;", "Ljava/util/List;", "", "Lio/ktor/openapi/Parameter;", "_parameters", "getParameters", "()Ljava/util/List;", "parameters", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        private final List<Parameter> _parameters;
        private final List<ContentType> defaultContentTypes;
        private final JsonSchemaInference schemaInference;

        public Builder(JsonSchemaInference jsonSchemaInference, List<ContentType> list) {
            jsonSchemaInference.getClass();
            list.getClass();
            this.schemaInference = jsonSchemaInference;
            this.defaultContentTypes = list;
            this._parameters = new ArrayList();
        }

        public static /* synthetic */ void cookie$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 26);
            }
            builder.cookie(str, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit cookie$lambda$0(Parameter.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void header$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 24);
            }
            builder.header(str, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit header$lambda$0(Parameter.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void path$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 23);
            }
            builder.path(str, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit path$lambda$0(Parameter.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void query$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = new URLUtilsKt$$ExternalSyntheticLambda0((byte) 25);
            }
            builder.query(str, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit query$lambda$0(Parameter.Builder builder) {
            builder.getClass();
            return Unit.INSTANCE;
        }

        public final Parameters build$ktor_openapi_schema() {
            return new Parameters(this._parameters);
        }

        public final void cookie(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Parameter.Builder builder = new Parameter.Builder(this.schemaInference, this.defaultContentTypes);
            builder.setName(name);
            builder.setIn(ParameterType.cookie);
            configure.invoke(builder);
            this._parameters.add(builder.build$ktor_openapi_schema());
        }

        public final List<Parameter> getParameters() {
            return this._parameters;
        }

        public final void header(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Parameter.Builder builder = new Parameter.Builder(this.schemaInference, this.defaultContentTypes);
            builder.setName(name);
            builder.setIn(ParameterType.header);
            configure.invoke(builder);
            this._parameters.add(builder.build$ktor_openapi_schema());
        }

        @Deprecated
        public final void parameter(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            List<Parameter> list = this._parameters;
            Parameter.Builder builder = new Parameter.Builder(this.schemaInference, this.defaultContentTypes);
            builder.setName(name);
            configure.invoke(builder);
            list.add(builder.build$ktor_openapi_schema());
        }

        public final void path(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Parameter.Builder builder = new Parameter.Builder(this.schemaInference, this.defaultContentTypes);
            builder.setName(name);
            builder.setIn(ParameterType.path);
            builder.setRequired(true);
            configure.invoke(builder);
            this._parameters.add(builder.build$ktor_openapi_schema());
        }

        public final void query(String name, Function1 configure) {
            name.getClass();
            configure.getClass();
            Parameter.Builder builder = new Parameter.Builder(this.schemaInference, this.defaultContentTypes);
            builder.setName(name);
            builder.setIn(ParameterType.query);
            configure.invoke(builder);
            this._parameters.add(builder.build$ktor_openapi_schema());
        }
    }

    public /* synthetic */ Parameters(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 == (i & 1)) {
            this.parameters = list;
        } else {
            EnumsKt.throwMissingFieldException(Parameters$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new HashSetSerializer(Parameter.Companion.Serializer.INSTANCE, (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Parameters copy$default(Parameters parameters, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = parameters.parameters;
        }
        return parameters.copy(list);
    }

    public final List<Parameter> component1() {
        return this.parameters;
    }

    public final Parameters copy(List<Parameter> parameters) {
        parameters.getClass();
        return new Parameters(parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Parameters) && Intrinsics.areEqual(this.parameters, ((Parameters) other).parameters);
    }

    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return this.parameters.hashCode();
    }

    public String toString() {
        return "Parameters(parameters=" + this.parameters + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/openapi/Parameters$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/Parameters;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Parameters$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Parameters(List<Parameter> list) {
        list.getClass();
        this.parameters = list;
    }
}
