package io.ktor.openapi;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.ContentDisposition;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/openapi/Parameter.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/openapi/Parameter;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/openapi/Parameter;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/openapi/Parameter;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-openapi-schema"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class Parameter$$serializer implements GeneratedSerializer {
    public static final Parameter$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Parameter$$serializer parameter$$serializer = new Parameter$$serializer();
        INSTANCE = parameter$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.openapi.Parameter", parameter$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("in", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("required", true);
        pluginGeneratedSerialDescriptor.addElement("deprecated", true);
        pluginGeneratedSerialDescriptor.addElement("schema", true);
        pluginGeneratedSerialDescriptor.addElement("content", true);
        pluginGeneratedSerialDescriptor.addElement("style", true);
        pluginGeneratedSerialDescriptor.addElement("explode", true);
        pluginGeneratedSerialDescriptor.addElement("allowReserved", true);
        pluginGeneratedSerialDescriptor.addElement("allowEmptyValue", true);
        pluginGeneratedSerialDescriptor.addElement("example", true);
        pluginGeneratedSerialDescriptor.addElement("examples", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Parameter$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = Parameter.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue());
        KSerializer nullable2 = HexFormatKt.getNullable(stringSerializer);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, nullable, nullable2, booleanSerializer, booleanSerializer, HexFormatKt.getNullable((KSerializer) lazyArr[5].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[6].getValue()), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(booleanSerializer), HexFormatKt.getNullable(booleanSerializer), HexFormatKt.getNullable(booleanSerializer), HexFormatKt.getNullable((KSerializer) lazyArr[11].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[12].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[13].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Parameter deserialize(Decoder decoder) {
        Boolean bool;
        GenericElement genericElement;
        Map map;
        Map map2;
        Boolean bool2;
        String str;
        Map map3;
        Boolean bool3;
        String str2;
        ParameterType parameterType;
        ReferenceOr referenceOr;
        int i;
        String str3;
        boolean z;
        boolean z2;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = Parameter.$childSerializers;
        int i2 = 9;
        int i3 = 7;
        int i4 = 8;
        int i5 = 6;
        ReferenceOr referenceOr2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            ParameterType parameterType2 = (ParameterType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
            ReferenceOr referenceOr3 = (ReferenceOr) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (DeserializationStrategy) lazyArr[5].getValue(), null);
            Map map4 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, booleanSerializer, null);
            Boolean bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, booleanSerializer, null);
            Boolean bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, booleanSerializer, null);
            GenericElement genericElement2 = (GenericElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), null);
            bool2 = bool6;
            map = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), null);
            str3 = strDecodeStringElement;
            referenceOr = referenceOr3;
            bool = bool5;
            str2 = str5;
            z = zDecodeBooleanElement;
            bool3 = bool4;
            z2 = zDecodeBooleanElement2;
            str = str4;
            parameterType = parameterType2;
            map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, (DeserializationStrategy) lazyArr[13].getValue(), null);
            i = 16383;
            map2 = map4;
            genericElement = genericElement2;
        } else {
            int i6 = 13;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            boolean z3 = true;
            GenericElement genericElement3 = null;
            Map map5 = null;
            Boolean bool7 = null;
            Map map6 = null;
            Boolean bool8 = null;
            String str6 = null;
            String strDecodeStringElement2 = null;
            String str7 = null;
            ParameterType parameterType3 = null;
            Map map7 = null;
            int i7 = 5;
            int i8 = 0;
            Boolean bool9 = null;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z3 = false;
                        i2 = 9;
                        i3 = 7;
                        i4 = 8;
                        i6 = 13;
                        i5 = 6;
                        i7 = 5;
                        break;
                    case 0:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i2 = 9;
                        i3 = 7;
                        i4 = 8;
                        i6 = 13;
                        i5 = 6;
                        i7 = 5;
                        break;
                    case 1:
                        parameterType3 = (ParameterType) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), parameterType3);
                        i8 |= 2;
                        i2 = 9;
                        i3 = 7;
                        i4 = 8;
                        i6 = 13;
                        i5 = 6;
                        i7 = 5;
                        break;
                    case 2:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i8 |= 4;
                        i2 = 9;
                        i3 = 7;
                        i4 = 8;
                        i6 = 13;
                        i5 = 6;
                        i7 = 5;
                        break;
                    case 3:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i8 |= 8;
                        i2 = 9;
                        i3 = 7;
                        i6 = 13;
                        i5 = 6;
                        i7 = 5;
                        break;
                    case 4:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i8 |= 16;
                        i2 = 9;
                        i3 = 7;
                        i6 = 13;
                        i5 = 6;
                        break;
                    case 5:
                        referenceOr2 = (ReferenceOr) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i7, (DeserializationStrategy) lazyArr[i7].getValue(), referenceOr2);
                        i8 |= 32;
                        i2 = 9;
                        i3 = 7;
                        i6 = 13;
                        i5 = 6;
                        break;
                    case 6:
                        int i9 = i5;
                        i8 |= 64;
                        map7 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i9, (DeserializationStrategy) lazyArr[i9].getValue(), map7);
                        i5 = i9;
                        i2 = 9;
                        i3 = 7;
                        i6 = 13;
                        break;
                    case 7:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str6);
                        i8 |= 128;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case 8:
                        bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, BooleanSerializer.INSTANCE, bool8);
                        i8 |= 256;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case 9:
                        bool9 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, BooleanSerializer.INSTANCE, bool9);
                        i8 |= 512;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case 10:
                        bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, BooleanSerializer.INSTANCE, bool7);
                        i8 |= 1024;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case 11:
                        genericElement3 = (GenericElement) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), genericElement3);
                        i8 |= 2048;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        map5 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), map5);
                        i8 |= 4096;
                        i5 = i5;
                        i6 = 13;
                        break;
                    case 13:
                        map6 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), map6);
                        i8 |= 8192;
                        i5 = i5;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            bool = bool9;
            genericElement = genericElement3;
            map = map5;
            map2 = map7;
            bool2 = bool7;
            str = str7;
            map3 = map6;
            bool3 = bool8;
            str2 = str6;
            parameterType = parameterType3;
            referenceOr = referenceOr2;
            i = i8;
            str3 = strDecodeStringElement2;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Parameter(i, str3, parameterType, str, z, z2, referenceOr, map2, str2, bool3, bool, bool2, genericElement, map, map3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Parameter value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Parameter.write$Self$ktor_openapi_schema(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
