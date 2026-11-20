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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000256BS\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0002`\t¢\u0006\u0004\b\u000b\u0010\fBY\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\\\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0002`\tHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u00020\rHÖ\u0081\u0004¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b#\u0010\u0013J'\u0010,\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0001¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u0013R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b/\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b2\u0010\u0013R,\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bj\u0002`\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u0010\u0019¨\u00067"}, d2 = {"Lio/ktor/openapi/ExampleObject;", "Lio/ktor/openapi/Extensible;", "", "summary", "description", "Lio/ktor/openapi/GenericElement;", "value", "externalValue", "", "Lio/ktor/openapi/ExtensionProperties;", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Ljava/util/Map;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/openapi/GenericElement;", "component4", "component5", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/openapi/GenericElement;Ljava/lang/String;Ljava/util/Map;)Lio/ktor/openapi/ExampleObject;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_openapi_schema", "(Lio/ktor/openapi/ExampleObject;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getSummary", "getDescription", "Lio/ktor/openapi/GenericElement;", "getValue", "getExternalValue", "Ljava/util/Map;", "getExtensions", "Companion", "$serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable(with = Companion.Serializer.class)
public final /* data */ class ExampleObject implements Extensible {
    private static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final Map<String, GenericElement> extensions;
    private final String externalValue;
    private final String summary;
    private final GenericElement value;

    static {
        Header$$ExternalSyntheticLambda0 header$$ExternalSyntheticLambda0 = new Header$$ExternalSyntheticLambda0((byte) 9);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, ResultKt.lazy(lazyThreadSafetyMode, header$$ExternalSyntheticLambda0), null, ResultKt.lazy(lazyThreadSafetyMode, new Header$$ExternalSyntheticLambda0((byte) 10))};
    }

    public /* synthetic */ ExampleObject(int i, String str, String str2, GenericElement genericElement, String str3, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.summary = null;
        } else {
            this.summary = str;
        }
        if ((i & 2) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 4) == 0) {
            this.value = null;
        } else {
            this.value = genericElement;
        }
        if ((i & 8) == 0) {
            this.externalValue = null;
        } else {
            this.externalValue = str3;
        }
        if ((i & 16) == 0) {
            this.extensions = null;
        } else {
            this.extensions = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new GenericElementSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new HashMapSerializer(StringSerializer.INSTANCE, new GenericElementSerializer(), (byte) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExampleObject copy$default(ExampleObject exampleObject, String str, String str2, GenericElement genericElement, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = exampleObject.summary;
        }
        if ((i & 2) != 0) {
            str2 = exampleObject.description;
        }
        if ((i & 4) != 0) {
            genericElement = exampleObject.value;
        }
        if ((i & 8) != 0) {
            str3 = exampleObject.externalValue;
        }
        if ((i & 16) != 0) {
            map = exampleObject.extensions;
        }
        Map map2 = map;
        GenericElement genericElement2 = genericElement;
        return exampleObject.copy(str, str2, genericElement2, str3, map2);
    }

    public static final /* synthetic */ void write$Self$ktor_openapi_schema(ExampleObject self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.summary != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.summary);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.value != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.value);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.externalValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.externalValue);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.getExtensions() == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.getExtensions());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GenericElement getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExternalValue() {
        return this.externalValue;
    }

    public final Map<String, GenericElement> component5() {
        return this.extensions;
    }

    public final ExampleObject copy(String summary, String description, GenericElement value, String externalValue, Map<String, ? extends GenericElement> extensions) {
        return new ExampleObject(summary, description, value, externalValue, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExampleObject)) {
            return false;
        }
        ExampleObject exampleObject = (ExampleObject) other;
        return Intrinsics.areEqual(this.summary, exampleObject.summary) && Intrinsics.areEqual(this.description, exampleObject.description) && Intrinsics.areEqual(this.value, exampleObject.value) && Intrinsics.areEqual(this.externalValue, exampleObject.externalValue) && Intrinsics.areEqual(this.extensions, exampleObject.extensions);
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // io.ktor.openapi.Extensible
    public Map<String, GenericElement> getExtensions() {
        return this.extensions;
    }

    public final String getExternalValue() {
        return this.externalValue;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final GenericElement getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.summary;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        GenericElement genericElement = this.value;
        int iHashCode3 = (iHashCode2 + (genericElement == null ? 0 : genericElement.hashCode())) * 31;
        String str3 = this.externalValue;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, GenericElement> map = this.extensions;
        return iHashCode4 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ExampleObject(summary=");
        sb.append(this.summary);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", externalValue=");
        sb.append(this.externalValue);
        sb.append(", extensions=");
        return Cookie$$ExternalSyntheticOutline0.m(sb, (Map) this.extensions, ')');
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Lio/ktor/openapi/ExampleObject$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/ExampleObject;", "generatedSerializer$ktor_openapi_schema", "()Lkotlinx/serialization/KSerializer;", "generatedSerializer", "serializer", "Serializer", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/openapi/ExampleObject$Companion$Serializer;", "Lio/ktor/openapi/ExtensibleMixinSerializer;", "Lio/ktor/openapi/ExampleObject;", "<init>", "()V", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Serializer extends ExtensibleMixinSerializer<ExampleObject> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(ExampleObject.INSTANCE.generatedSerializer$ktor_openapi_schema(), new HttpParserKt$$ExternalSyntheticLambda0((byte) 19));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ExampleObject _init_$lambda$0(ExampleObject exampleObject, Map map) {
                exampleObject.getClass();
                return ExampleObject.copy$default(exampleObject, null, null, null, null, map, 15, null);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer generatedSerializer$ktor_openapi_schema() {
            return ExampleObject$$serializer.INSTANCE;
        }

        public final KSerializer serializer() {
            return Serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public ExampleObject() {
        this((String) null, (String) null, (GenericElement) null, (String) null, (Map) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExampleObject(String str, String str2, GenericElement genericElement, String str3, Map<String, ? extends GenericElement> map) {
        this.summary = str;
        this.description = str2;
        this.value = genericElement;
        this.externalValue = str3;
        this.extensions = map;
    }

    public /* synthetic */ ExampleObject(String str, String str2, GenericElement genericElement, String str3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : genericElement, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : map);
    }
}
