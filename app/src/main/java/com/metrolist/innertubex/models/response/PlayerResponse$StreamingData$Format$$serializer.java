package com.metrolist.innertubex.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonNames;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$StreamingData$Format$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$StreamingData$Format$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$StreamingData$Format$$serializer playerResponse$StreamingData$Format$$serializer = new PlayerResponse$StreamingData$Format$$serializer();
        INSTANCE = playerResponse$StreamingData$Format$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.StreamingData.Format", playerResponse$StreamingData$Format$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("itag", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("mimeType", true);
        pluginGeneratedSerialDescriptor.addElement("bitrate", true);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        pluginGeneratedSerialDescriptor.addElement("contentLength", true);
        pluginGeneratedSerialDescriptor.addElement("quality", true);
        pluginGeneratedSerialDescriptor.addElement("audioQuality", true);
        pluginGeneratedSerialDescriptor.addElement("approxDurationMs", true);
        pluginGeneratedSerialDescriptor.addElement("audioSampleRate", true);
        pluginGeneratedSerialDescriptor.addElement("audioChannels", true);
        pluginGeneratedSerialDescriptor.addElement("loudnessDb", true);
        pluginGeneratedSerialDescriptor.addElement("lastModified", true);
        pluginGeneratedSerialDescriptor.addElement("xtags", true);
        pluginGeneratedSerialDescriptor.addElement("audioTrack", true);
        pluginGeneratedSerialDescriptor.addElement("isDrc", true);
        pluginGeneratedSerialDescriptor.addElement("signatureCipher", true);
        final String[] strArr = {"signature_cipher"};
        pluginGeneratedSerialDescriptor.pushAnnotation(new JsonNames() { // from class: com.metrolist.innertubex.models.response.PlayerResponse$StreamingData$Format$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0
            @Override // java.lang.annotation.Annotation
            public final /* synthetic */ Class annotationType() {
                return JsonNames.class;
            }

            @Override // java.lang.annotation.Annotation
            public final boolean equals(Object obj) {
                return (obj instanceof JsonNames) && Arrays.equals(strArr, ((JsonNames) obj).names());
            }

            @Override // java.lang.annotation.Annotation
            public final int hashCode() {
                return Arrays.hashCode(strArr) ^ 397397176;
            }

            @Override // kotlinx.serialization.json.JsonNames
            public final /* synthetic */ String[] names() {
                return strArr;
            }

            @Override // java.lang.annotation.Annotation
            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("@kotlinx.serialization.json.JsonNames(names=", Arrays.toString(strArr), ")");
            }
        });
        pluginGeneratedSerialDescriptor.addElement("cipher", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, HexFormatKt.getNullable(stringSerializer), stringSerializer, intSerializer, HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(LongSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(DoubleSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE), BooleanSerializer.INSTANCE, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        Double d;
        String str5;
        Integer num;
        Integer num2;
        String str6;
        int i;
        String str7;
        Integer num3;
        Integer num4;
        boolean z;
        String str8;
        Long l;
        String str9;
        PlayerResponse.StreamingData.Format.AudioTrack audioTrack;
        int i2;
        int i3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Double d2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, intSerializer, null);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, intSerializer, null);
            Long l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            Integer num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, intSerializer, null);
            Integer num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, intSerializer, null);
            Double d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, stringSerializer, null);
            String str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, stringSerializer, null);
            PlayerResponse.StreamingData.Format.AudioTrack audioTrack2 = (PlayerResponse.StreamingData.Format.AudioTrack) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, null);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 16);
            str3 = str10;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, stringSerializer, null);
            z = zDecodeBooleanElement;
            str9 = str12;
            str8 = strDecodeStringElement;
            str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 18, stringSerializer, null);
            i = 524287;
            str6 = str14;
            l = l2;
            str = str13;
            str5 = str11;
            num2 = num7;
            num4 = num6;
            i2 = iDecodeIntElement2;
            audioTrack = audioTrack2;
            str4 = str15;
            d = d3;
            num3 = num5;
            num = num8;
            i3 = iDecodeIntElement;
        } else {
            int i4 = 18;
            boolean z2 = true;
            int iDecodeIntElement3 = 0;
            int i5 = 0;
            boolean zDecodeBooleanElement2 = false;
            int iDecodeIntElement4 = 0;
            PlayerResponse.StreamingData.Format.AudioTrack audioTrack3 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            Integer num9 = null;
            Integer num10 = null;
            String str20 = null;
            String str21 = null;
            Integer num11 = null;
            String strDecodeStringElement2 = null;
            String str22 = null;
            Long l3 = null;
            String str23 = null;
            Integer num12 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 0:
                        i5 |= 1;
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        i4 = 18;
                        break;
                    case 1:
                        str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str22);
                        i5 |= 2;
                        num12 = num12;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 2:
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 3:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
                        i5 |= 8;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 4:
                        num11 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num11);
                        i5 |= 16;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 5:
                        num12 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num12);
                        i5 |= 32;
                        l3 = l3;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 6:
                        l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l3);
                        i5 |= 64;
                        str16 = str16;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 7:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        audioTrack3 = audioTrack3;
                        str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str23);
                        i5 |= 128;
                        audioTrack3 = audioTrack3;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 8:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str16);
                        i5 |= 256;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 9:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str17);
                        i5 |= 512;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 10:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num10 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num10);
                        i5 |= 1024;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 11:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num9);
                        i5 |= 2048;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, d2);
                        i5 |= 4096;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 13:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str20);
                        i5 |= 8192;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 14:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str19);
                        i5 |= 16384;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 15:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        audioTrack3 = (PlayerResponse.StreamingData.Format.AudioTrack) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, audioTrack3);
                        i5 |= 32768;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 16:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 16);
                        i5 |= 65536;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 17:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str18);
                        i5 |= 131072;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i4 = 18;
                        break;
                    case 18:
                        str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str21);
                        i5 |= 262144;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str17;
            str2 = str18;
            str3 = str22;
            str4 = str19;
            d = d2;
            str5 = str23;
            num = num9;
            num2 = num10;
            str6 = str20;
            i = i5;
            str7 = str21;
            num3 = num11;
            num4 = num12;
            z = zDecodeBooleanElement2;
            str8 = strDecodeStringElement2;
            l = l3;
            str9 = str16;
            audioTrack = audioTrack3;
            i2 = iDecodeIntElement4;
            i3 = iDecodeIntElement3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.StreamingData.Format(i, i3, str3, str8, i2, num3, num4, l, str5, str9, str, num2, num, d, str6, str4, audioTrack, z, str2, str7);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.StreamingData.Format format = (PlayerResponse.StreamingData.Format) obj;
        format.getClass();
        String str = format.cipher;
        String str2 = format.signatureCipher;
        boolean z = format.isDrc;
        PlayerResponse.StreamingData.Format.AudioTrack audioTrack = format.audioTrack;
        String str3 = format.xtags;
        String str4 = format.lastModified;
        Double d = format.loudnessDb;
        Integer num = format.audioChannels;
        Integer num2 = format.audioSampleRate;
        String str5 = format.approxDurationMs;
        String str6 = format.audioQuality;
        String str7 = format.quality;
        Long l = format.contentLength;
        Integer num3 = format.height;
        Integer num4 = format.width;
        int i = format.bitrate;
        String str8 = format.mimeType;
        String str9 = format.url;
        int i2 = format.itag;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        int i3 = 0;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0)) {
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, i3, i2);
        } else if (i2 != -1) {
            i3 = 0;
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, i3, i2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str9 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str9);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(str8, "")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, str8);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || i != 0) {
            compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 3, i);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || num4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || num3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || l != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || str7 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str7);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || str6 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str6);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 9) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 10) || num2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 11) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 11, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 12) || d != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 12, DoubleSerializer.INSTANCE, d);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 13) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 14) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 15) || audioTrack != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 15, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, audioTrack);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 16) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 16, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 17) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 18) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
