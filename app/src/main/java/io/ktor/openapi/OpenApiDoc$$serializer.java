package io.ktor.openapi;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/openapi/OpenApiDoc.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/OpenApiDoc;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/OpenApiDoc;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/OpenApiDoc;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class OpenApiDoc$$serializer implements GeneratedSerializer {
    public static final OpenApiDoc$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        OpenApiDoc$$serializer openApiDoc$$serializer = new OpenApiDoc$$serializer();
        INSTANCE = openApiDoc$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.openapi.OpenApiDoc", openApiDoc$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("openapi", true);
        pluginGeneratedSerialDescriptor.addElement("info", false);
        pluginGeneratedSerialDescriptor.addElement("servers", true);
        pluginGeneratedSerialDescriptor.addElement("paths", true);
        pluginGeneratedSerialDescriptor.addElement("webhooks", true);
        pluginGeneratedSerialDescriptor.addElement("components", true);
        pluginGeneratedSerialDescriptor.addElement("security", true);
        pluginGeneratedSerialDescriptor.addElement("tags", true);
        pluginGeneratedSerialDescriptor.addElement("externalDocs", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OpenApiDoc$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = OpenApiDoc.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, OpenApiInfo.Companion.Serializer.INSTANCE, HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), lazyArr[3].getValue(), HexFormatKt.getNullable((KSerializer) lazyArr[4].getValue()), HexFormatKt.getNullable(Components.Companion.Serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[6].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[7].getValue()), HexFormatKt.getNullable(ExternalDocs$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[9].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final OpenApiDoc deserialize(Decoder decoder) {
        Map map;
        Map map2;
        Map map3;
        List list;
        OpenApiInfo openApiInfo;
        List list2;
        List list3;
        int i;
        ExternalDocs externalDocs;
        Components components;
        String str;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = OpenApiDoc.$childSerializers;
        int i2 = 5;
        int i3 = 8;
        int i4 = 9;
        int i5 = 7;
        int i6 = 6;
        int i7 = 4;
        Components components2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            OpenApiInfo openApiInfo2 = (OpenApiInfo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, OpenApiInfo.Companion.Serializer.INSTANCE, null);
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            Map map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            Components components3 = (Components) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Components.Companion.Serializer.INSTANCE, null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            List list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), null);
            ExternalDocs externalDocs2 = (ExternalDocs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, ExternalDocs$$serializer.INSTANCE, null);
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            str = strDecodeStringElement;
            components = components3;
            externalDocs = externalDocs2;
            i = 1023;
            list3 = list6;
            list2 = list5;
            map3 = map4;
            map2 = map5;
            list = list4;
            openApiInfo = openApiInfo2;
        } else {
            int i8 = 3;
            int i9 = 2;
            boolean z = true;
            int i10 = 0;
            Map map6 = null;
            List list7 = null;
            List list8 = null;
            ExternalDocs externalDocs3 = null;
            String strDecodeStringElement2 = null;
            Map map7 = null;
            Map map8 = null;
            List list9 = null;
            OpenApiInfo openApiInfo3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 5;
                        i3 = 8;
                        i4 = 9;
                        i5 = 7;
                        i6 = 6;
                        i7 = 4;
                        i9 = 2;
                        i8 = 3;
                        break;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i10 |= 1;
                        i2 = 5;
                        i3 = 8;
                        i4 = 9;
                        i5 = 7;
                        i6 = 6;
                        i7 = 4;
                        i9 = 2;
                        i8 = 3;
                        break;
                    case 1:
                        openApiInfo3 = (OpenApiInfo) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, OpenApiInfo.Companion.Serializer.INSTANCE, openApiInfo3);
                        i10 |= 2;
                        i2 = 5;
                        i3 = 8;
                        i4 = 9;
                        i5 = 7;
                        i6 = 6;
                        i7 = 4;
                        i9 = 2;
                        i8 = 3;
                        break;
                    case 2:
                        list9 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i9, (DeserializationStrategy) lazyArr[i9].getValue(), list9);
                        i10 |= 4;
                        i2 = 5;
                        i3 = 8;
                        i4 = 9;
                        i5 = 7;
                        i7 = 4;
                        i8 = 3;
                        break;
                    case 3:
                        map7 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i8, (DeserializationStrategy) lazyArr[i8].getValue(), map7);
                        i10 |= 8;
                        i2 = 5;
                        i3 = 8;
                        i4 = 9;
                        i7 = 4;
                        break;
                    case 4:
                        int i11 = i7;
                        i10 |= 16;
                        map8 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i11, (DeserializationStrategy) lazyArr[i11].getValue(), map8);
                        i7 = i11;
                        i2 = 5;
                        i3 = 8;
                        break;
                    case 5:
                        components2 = (Components) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, Components.Companion.Serializer.INSTANCE, components2);
                        i10 |= 32;
                        i7 = i7;
                        break;
                    case 6:
                        list7 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), list7);
                        i10 |= 64;
                        i7 = i7;
                        break;
                    case 7:
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, (DeserializationStrategy) lazyArr[i5].getValue(), list8);
                        i10 |= 128;
                        i7 = i7;
                        break;
                    case 8:
                        externalDocs3 = (ExternalDocs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, ExternalDocs$$serializer.INSTANCE, externalDocs3);
                        i10 |= 256;
                        i7 = i7;
                        break;
                    case 9:
                        map6 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, (DeserializationStrategy) lazyArr[i4].getValue(), map6);
                        i10 |= 512;
                        i7 = i7;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            map = map6;
            map2 = map8;
            map3 = map7;
            list = list9;
            openApiInfo = openApiInfo3;
            list2 = list7;
            list3 = list8;
            i = i10;
            externalDocs = externalDocs3;
            components = components2;
            str = strDecodeStringElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new OpenApiDoc(i, str, openApiInfo, list, map3, map2, components, list2, list3, externalDocs, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, OpenApiDoc value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        OpenApiDoc.write$Self$ktor_openapi_schema(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
