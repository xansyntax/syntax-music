package io.ktor.openapi;

import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.StructureKind$MAP;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eR,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u000f8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0004R\u001b\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0084\b¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/openapi/SecuritySchemeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/openapi/SecurityScheme;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/SecurityScheme;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/SecurityScheme;", "", "Lio/ktor/openapi/SecuritySchemeType;", "serializers", "Ljava/util/Map;", "getSerializers$annotations", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SecuritySchemeSerializer implements KSerializer {
    public static final SecuritySchemeSerializer INSTANCE = new SecuritySchemeSerializer();
    private static final SerialDescriptor descriptor;
    private static final Map<SecuritySchemeType, KSerializer> serializers;

    static {
        SecuritySchemeType securitySchemeType = SecuritySchemeType.HTTP;
        KSerializer kSerializerSerializer = HttpSecurityScheme.INSTANCE.serializer();
        kSerializerSerializer.getClass();
        Pair pair = new Pair(securitySchemeType, kSerializerSerializer);
        SecuritySchemeType securitySchemeType2 = SecuritySchemeType.API_KEY;
        KSerializer kSerializerSerializer2 = ApiKeySecurityScheme.INSTANCE.serializer();
        kSerializerSerializer2.getClass();
        Pair pair2 = new Pair(securitySchemeType2, kSerializerSerializer2);
        SecuritySchemeType securitySchemeType3 = SecuritySchemeType.OAUTH2;
        KSerializer kSerializerSerializer3 = OAuth2SecurityScheme.INSTANCE.serializer();
        kSerializerSerializer3.getClass();
        Pair pair3 = new Pair(securitySchemeType3, kSerializerSerializer3);
        SecuritySchemeType securitySchemeType4 = SecuritySchemeType.OPEN_ID_CONNECT;
        KSerializer kSerializerSerializer4 = OpenIdConnectSecurityScheme.INSTANCE.serializer();
        kSerializerSerializer4.getClass();
        serializers = MapsKt__MapsKt.mapOf(pair, pair2, pair3, new Pair(securitySchemeType4, kSerializerSerializer4));
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[0];
        if (StringsKt.isBlank("SecurityScheme")) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Blank serial names are prohibited");
            return;
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder("SecurityScheme");
        descriptor$lambda$0(classSerialDescriptorBuilder);
        descriptor = new SerialDescriptorImpl("SecurityScheme", StructureKind$MAP.INSTANCE$1, classSerialDescriptorBuilder.elementNames.size(), ArraysKt.toList(serialDescriptorArr), classSerialDescriptorBuilder);
    }

    private SecuritySchemeSerializer() {
    }

    private static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        classSerialDescriptorBuilder.getClass();
        classSerialDescriptorBuilder.element(LinkHeader.Parameters.Type, SecuritySchemeType.INSTANCE.serializer().getDescriptor());
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SecurityScheme deserialize(Decoder decoder) {
        Object next;
        decoder.getClass();
        decoder.getSerializersModule();
        GenericElement genericElement = (GenericElement) decoder.decodeSerializableValue(GenericElement.INSTANCE.serializer());
        Iterator<T> it = genericElement.entries().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Pair) next).first, LinkHeader.Parameters.Type));
        Pair pair = (Pair) next;
        if (pair == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("SecurityScheme is missing 'type' field");
            return null;
        }
        SecuritySchemeType securitySchemeType = (SecuritySchemeType) ((GenericElement) pair.second).deserialize(SecuritySchemeType.INSTANCE.serializer());
        KSerializer kSerializer = serializers.get(securitySchemeType);
        if (kSerializer != null) {
            return (SecurityScheme) genericElement.deserialize(kSerializer);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(securitySchemeType, "Unknown security scheme type: ");
        return null;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SecurityScheme value) {
        encoder.getClass();
        value.getClass();
        KSerializer kSerializer = serializers.get(value.getType());
        if (kSerializer != null) {
            kSerializer.serialize(encoder, value);
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m((Object) value.getType(), "Unknown security scheme type: ");
        }
    }

    private static /* synthetic */ void getSerializers$annotations() {
    }
}
