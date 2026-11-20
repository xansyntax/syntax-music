package io.ktor.openapi;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/openapi/OpenApiInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/OpenApiInfo;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/OpenApiInfo;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/OpenApiInfo;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class OpenApiInfo$$serializer implements GeneratedSerializer {
    public static final OpenApiInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OpenApiInfo$$serializer openApiInfo$$serializer = new OpenApiInfo$$serializer();
        INSTANCE = openApiInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.openapi.OpenApiInfo", openApiInfo$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("termsOfService", true);
        pluginGeneratedSerialDescriptor.addElement("contact", true);
        pluginGeneratedSerialDescriptor.addElement("license", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OpenApiInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = OpenApiInfo.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(OpenApiInfo$Contact$$serializer.INSTANCE), HexFormatKt.getNullable(OpenApiInfo$License$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[6].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final OpenApiInfo deserialize(Decoder decoder) {
        Map map;
        String str;
        String str2;
        OpenApiInfo.License license;
        String str3;
        OpenApiInfo.Contact contact;
        int i;
        String str4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = OpenApiInfo.$childSerializers;
        int i2 = 0;
        String str5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            OpenApiInfo.Contact contact2 = (OpenApiInfo.Contact) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, OpenApiInfo$Contact$$serializer.INSTANCE, null);
            OpenApiInfo.License license2 = (OpenApiInfo.License) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, OpenApiInfo$License$$serializer.INSTANCE, null);
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            str2 = strDecodeStringElement;
            license = license2;
            str3 = str7;
            contact = contact2;
            str = str6;
            i = 127;
            str4 = strDecodeStringElement2;
        } else {
            int i3 = 1;
            int i4 = 0;
            Map map2 = null;
            String strDecodeStringElement3 = null;
            OpenApiInfo.License license3 = null;
            String str8 = null;
            OpenApiInfo.Contact contact3 = null;
            String strDecodeStringElement4 = null;
            while (i3 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        i3 = i2;
                        continue;
                    case 0:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i2);
                        i4 |= 1;
                        continue;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
                        i4 |= 4;
                        break;
                    case 3:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str8);
                        i4 |= 8;
                        break;
                    case 4:
                        contact3 = (OpenApiInfo.Contact) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, OpenApiInfo$Contact$$serializer.INSTANCE, contact3);
                        i4 |= 16;
                        break;
                    case 5:
                        license3 = (OpenApiInfo.License) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, OpenApiInfo$License$$serializer.INSTANCE, license3);
                        i4 |= 32;
                        break;
                    case 6:
                        map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), map2);
                        i4 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 0;
            }
            map = map2;
            str = str5;
            str2 = strDecodeStringElement3;
            license = license3;
            str3 = str8;
            contact = contact3;
            i = i4;
            str4 = strDecodeStringElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new OpenApiInfo(i, str2, str4, str, str3, contact, license, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OpenApiInfo value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        OpenApiInfo.write$Self$ktor_openapi_schema(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
