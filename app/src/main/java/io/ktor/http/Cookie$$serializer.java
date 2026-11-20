package io.ktor.http;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDate$$serializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0086\u0080\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0086\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/http/Cookie.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/http/Cookie;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/http/Cookie;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/http/Cookie;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Deprecated
public final /* synthetic */ class Cookie$$serializer implements GeneratedSerializer {
    public static final Cookie$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Cookie$$serializer cookie$$serializer = new Cookie$$serializer();
        INSTANCE = cookie$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.http.Cookie", cookie$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("encoding", true);
        pluginGeneratedSerialDescriptor.addElement("maxAge", true);
        pluginGeneratedSerialDescriptor.addElement("expires", true);
        pluginGeneratedSerialDescriptor.addElement("domain", true);
        pluginGeneratedSerialDescriptor.addElement("path", true);
        pluginGeneratedSerialDescriptor.addElement("secure", true);
        pluginGeneratedSerialDescriptor.addElement("httpOnly", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Cookie$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = Cookie.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, lazyArr[2].getValue(), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(GMTDate$$serializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), booleanSerializer, booleanSerializer, lazyArr[9].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Cookie deserialize(Decoder decoder) {
        Map map;
        CookieEncoding cookieEncoding;
        int i;
        GMTDate gMTDate;
        Integer num;
        String str;
        String str2;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        decoder.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = Cookie.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        char c = 4;
        String str5 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            CookieEncoding cookieEncoding2 = (CookieEncoding) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, null);
            GMTDate gMTDate2 = (GMTDate) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), null);
            str3 = strDecodeStringElement;
            z = zDecodeBooleanElement;
            str2 = str7;
            str = str6;
            num = num2;
            z2 = zDecodeBooleanElement2;
            gMTDate = gMTDate2;
            i = 1023;
            cookieEncoding = cookieEncoding2;
            str4 = strDecodeStringElement2;
        } else {
            boolean z3 = true;
            int i4 = 0;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            Map map2 = null;
            GMTDate gMTDate3 = null;
            Integer num3 = null;
            String str8 = null;
            String strDecodeStringElement3 = null;
            CookieEncoding cookieEncoding3 = null;
            String strDecodeStringElement4 = null;
            while (z3) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z3 = false;
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 0:
                        i4 |= 1;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 1:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 2:
                        cookieEncoding3 = (CookieEncoding) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), cookieEncoding3);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 6;
                        c = 4;
                        break;
                    case 3:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num3);
                        i4 |= 8;
                        i2 = 7;
                        c = 4;
                        break;
                    case 4:
                        gMTDate3 = (GMTDate) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$$serializer.INSTANCE, gMTDate3);
                        i4 |= 16;
                        c = 4;
                        i2 = 7;
                        break;
                    case 5:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str8);
                        i4 |= 32;
                        c = 4;
                        break;
                    case 6:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str5);
                        i4 |= 64;
                        c = 4;
                        break;
                    case 7:
                        zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, i2);
                        i4 |= 128;
                        c = 4;
                        break;
                    case 8:
                        zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i4 |= 256;
                        c = 4;
                        break;
                    case 9:
                        map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 9, (DeserializationStrategy) lazyArr[9].getValue(), map2);
                        i4 |= 512;
                        c = 4;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            map = map2;
            cookieEncoding = cookieEncoding3;
            i = i4;
            gMTDate = gMTDate3;
            num = num3;
            str = str8;
            str2 = str5;
            str3 = strDecodeStringElement3;
            z = zDecodeBooleanElement3;
            z2 = zDecodeBooleanElement4;
            str4 = strDecodeStringElement4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Cookie(i, str3, str4, cookieEncoding, num, gMTDate, str, str2, z, z2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Cookie value) {
        encoder.getClass();
        value.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Cookie.write$Self$ktor_http(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return EnumsKt.EMPTY_SERIALIZER_ARRAY;
    }
}
