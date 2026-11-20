package io.ktor.openapi;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/openapi/Encoding.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/Encoding;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/Encoding;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/Encoding;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class Encoding$$serializer implements GeneratedSerializer {
    public static final Encoding$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Encoding$$serializer encoding$$serializer = new Encoding$$serializer();
        INSTANCE = encoding$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.openapi.Encoding", encoding$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("contentType", false);
        pluginGeneratedSerialDescriptor.addElement("headers", true);
        pluginGeneratedSerialDescriptor.addElement("style", true);
        pluginGeneratedSerialDescriptor.addElement("explode", true);
        pluginGeneratedSerialDescriptor.addElement("allowReserved", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Encoding$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = Encoding.$childSerializers;
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue());
        KSerializer nullable2 = HexFormatKt.getNullable(StringSerializer.INSTANCE);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{ContentTypeSerializer.INSTANCE, nullable, nullable2, HexFormatKt.getNullable(booleanSerializer), HexFormatKt.getNullable(booleanSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[5].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Encoding deserialize(Decoder decoder) {
        Map map;
        Map map2;
        ContentType contentType;
        Boolean bool;
        Boolean bool2;
        String str;
        int i;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = Encoding.$childSerializers;
        int i2 = 3;
        boolean z = false;
        Map map3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ContentType contentType2 = (ContentType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ContentTypeSerializer.INSTANCE, null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, booleanSerializer, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, booleanSerializer, null);
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            contentType = contentType2;
            bool = bool3;
            bool2 = bool4;
            str = str2;
            i = 63;
            map2 = map4;
        } else {
            boolean z2 = true;
            int i3 = 0;
            Map map5 = null;
            ContentType contentType3 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            String str3 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = z;
                        i2 = 3;
                        break;
                    case 0:
                        contentType3 = (ContentType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, ContentTypeSerializer.INSTANCE, contentType3);
                        i3 |= 1;
                        z = false;
                        i2 = 3;
                        break;
                    case 1:
                        map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), map3);
                        i3 |= 2;
                        z = false;
                        break;
                    case 2:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str3);
                        i3 |= 4;
                        z = false;
                        break;
                    case 3:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 8;
                        z = false;
                        break;
                    case 4:
                        bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 16;
                        z = false;
                        break;
                    case 5:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), map5);
                        i3 |= 32;
                        z = false;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            map = map5;
            map2 = map3;
            contentType = contentType3;
            bool = bool5;
            bool2 = bool6;
            str = str3;
            i = i3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Encoding(i, contentType, map2, str, bool, bool2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Encoding value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Encoding.write$Self$ktor_openapi_schema(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
