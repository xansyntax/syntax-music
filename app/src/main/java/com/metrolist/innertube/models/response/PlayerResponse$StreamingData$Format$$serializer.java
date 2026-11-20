package com.metrolist.innertube.models.response;

import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$StreamingData$Format$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$StreamingData$Format$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$StreamingData$Format$$serializer playerResponse$StreamingData$Format$$serializer = new PlayerResponse$StreamingData$Format$$serializer();
        INSTANCE = playerResponse$StreamingData$Format$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.StreamingData.Format", playerResponse$StreamingData$Format$$serializer, 20);
        pluginGeneratedSerialDescriptor.addElement("itag", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("mimeType", false);
        pluginGeneratedSerialDescriptor.addElement("bitrate", false);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        pluginGeneratedSerialDescriptor.addElement("contentLength", false);
        pluginGeneratedSerialDescriptor.addElement("quality", false);
        pluginGeneratedSerialDescriptor.addElement("fps", false);
        pluginGeneratedSerialDescriptor.addElement("qualityLabel", false);
        pluginGeneratedSerialDescriptor.addElement("averageBitrate", false);
        pluginGeneratedSerialDescriptor.addElement("audioQuality", false);
        pluginGeneratedSerialDescriptor.addElement("approxDurationMs", false);
        pluginGeneratedSerialDescriptor.addElement("audioSampleRate", false);
        pluginGeneratedSerialDescriptor.addElement("audioChannels", false);
        pluginGeneratedSerialDescriptor.addElement("loudnessDb", false);
        pluginGeneratedSerialDescriptor.addElement("lastModified", false);
        pluginGeneratedSerialDescriptor.addElement("signatureCipher", false);
        pluginGeneratedSerialDescriptor.addElement("cipher", false);
        pluginGeneratedSerialDescriptor.addElement("audioTrack", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer nullable = HexFormatKt.getNullable(stringSerializer);
        KSerializer nullable2 = HexFormatKt.getNullable(intSerializer);
        KSerializer nullable3 = HexFormatKt.getNullable(intSerializer);
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, nullable, stringSerializer, intSerializer, nullable2, nullable3, HexFormatKt.getNullable(longSerializer), stringSerializer, HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(DoubleSerializer.INSTANCE), HexFormatKt.getNullable(longSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String str;
        Long l;
        Integer num;
        String str2;
        String str3;
        String str4;
        Long l2;
        Integer num2;
        String str5;
        int i;
        PlayerResponse$StreamingData$Format.AudioTrack audioTrack;
        Integer num3;
        Integer num4;
        Integer num5;
        int i2;
        String str6;
        String str7;
        Double d;
        Integer num6;
        String str8;
        int i3;
        int i4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        String str9 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            int iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            int iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            Integer num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, intSerializer, null);
            Integer num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, intSerializer, null);
            LongSerializer longSerializer = LongSerializer.INSTANCE;
            Long l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, longSerializer, null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
            Integer num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, intSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
            Integer num10 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, intSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, stringSerializer, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, stringSerializer, null);
            Integer num11 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, intSerializer, null);
            Integer num12 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, intSerializer, null);
            Double d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, DoubleSerializer.INSTANCE, null);
            Long l4 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, longSerializer, null);
            String str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, stringSerializer, null);
            str = str10;
            str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 18, stringSerializer, null);
            i2 = iDecodeIntElement2;
            num4 = num7;
            num3 = num9;
            str7 = strDecodeStringElement;
            audioTrack = (PlayerResponse$StreamingData$Format.AudioTrack) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 19, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, null);
            i = 1048575;
            l = l4;
            str5 = str14;
            str2 = str11;
            str8 = strDecodeStringElement2;
            l2 = l3;
            num5 = num8;
            d = d2;
            num = num12;
            num6 = num11;
            str3 = str13;
            str4 = str12;
            num2 = num10;
            i3 = iDecodeIntElement;
        } else {
            int i5 = 19;
            boolean z = true;
            int iDecodeIntElement3 = 0;
            int i6 = 0;
            int iDecodeIntElement4 = 0;
            Integer num13 = null;
            Double d3 = null;
            String str15 = null;
            Long l5 = null;
            Integer num14 = null;
            String str16 = null;
            Integer num15 = null;
            String str17 = null;
            PlayerResponse$StreamingData$Format.AudioTrack audioTrack2 = null;
            Integer num16 = null;
            Integer num17 = null;
            String strDecodeStringElement3 = null;
            String str18 = null;
            String str19 = null;
            String strDecodeStringElement4 = null;
            Long l6 = null;
            Integer num18 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 0:
                        i6 |= 1;
                        iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        i5 = 19;
                        break;
                    case 1:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str18);
                        i6 |= 2;
                        num17 = num17;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 2:
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 3:
                        iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 3);
                        i6 |= 8;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 4:
                        num17 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, num17);
                        i6 |= 16;
                        num18 = num18;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 5:
                        num18 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num18);
                        i6 |= 32;
                        str15 = str15;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 6:
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        d3 = d3;
                        l6 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l6);
                        i6 |= 64;
                        d3 = d3;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 7:
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 7);
                        i6 |= 128;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 8:
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num16 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num16);
                        i6 |= 256;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 9:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num13 = num13;
                        str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str19);
                        i6 |= 512;
                        num13 = num13;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 10:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num15 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num15);
                        i6 |= 1024;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 11:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str9);
                        i6 |= 2048;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case DictionaryEntry.PRONUNCIATION /* 12 */:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str16);
                        i6 |= 4096;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 13:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num13 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 13, IntSerializer.INSTANCE, num13);
                        i6 |= 8192;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 14:
                        iDecodeIntElement3 = iDecodeIntElement3;
                        num14 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, num14);
                        i6 |= 16384;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 15:
                        d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 15, DoubleSerializer.INSTANCE, d3);
                        i4 = 32768;
                        i6 |= i4;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 16:
                        l5 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 16, LongSerializer.INSTANCE, l5);
                        i4 = 65536;
                        i6 |= i4;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 17:
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str17);
                        i4 = 131072;
                        i6 |= i4;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 18:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str15);
                        i4 = 262144;
                        i6 |= i4;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        i5 = 19;
                        break;
                    case 19:
                        audioTrack2 = (PlayerResponse$StreamingData$Format.AudioTrack) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i5, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, audioTrack2);
                        i6 |= 524288;
                        iDecodeIntElement3 = iDecodeIntElement3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str18;
            l = l5;
            num = num14;
            str2 = str19;
            str3 = str16;
            str4 = str9;
            l2 = l6;
            num2 = num15;
            str5 = str17;
            i = i6;
            audioTrack = audioTrack2;
            num3 = num16;
            num4 = num17;
            num5 = num18;
            i2 = iDecodeIntElement4;
            str6 = str15;
            str7 = strDecodeStringElement3;
            d = d3;
            num6 = num13;
            str8 = strDecodeStringElement4;
            i3 = iDecodeIntElement3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$StreamingData$Format(i, i3, str, str7, i2, num4, num5, l2, str8, num3, str2, num2, str4, str3, num6, num, d, l, str5, str6, audioTrack);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$StreamingData$Format playerResponse$StreamingData$Format = (PlayerResponse$StreamingData$Format) obj;
        playerResponse$StreamingData$Format.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, playerResponse$StreamingData$Format.itag);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, playerResponse$StreamingData$Format.url);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, playerResponse$StreamingData$Format.mimeType);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 3, playerResponse$StreamingData$Format.bitrate);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, intSerializer, playerResponse$StreamingData$Format.width);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, intSerializer, playerResponse$StreamingData$Format.height);
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, longSerializer, playerResponse$StreamingData$Format.contentLength);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 7, playerResponse$StreamingData$Format.quality);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, intSerializer, playerResponse$StreamingData$Format.fps);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, playerResponse$StreamingData$Format.qualityLabel);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 10, intSerializer, playerResponse$StreamingData$Format.averageBitrate);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 11, stringSerializer, playerResponse$StreamingData$Format.audioQuality);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 12, stringSerializer, playerResponse$StreamingData$Format.approxDurationMs);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 13, intSerializer, playerResponse$StreamingData$Format.audioSampleRate);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 14, intSerializer, playerResponse$StreamingData$Format.audioChannels);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 15, DoubleSerializer.INSTANCE, playerResponse$StreamingData$Format.loudnessDb);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 16, longSerializer, playerResponse$StreamingData$Format.lastModified);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 17, stringSerializer, playerResponse$StreamingData$Format.signatureCipher);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 18, stringSerializer, playerResponse$StreamingData$Format.cipher);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 19, PlayerResponse$StreamingData$Format$AudioTrack$$serializer.INSTANCE, playerResponse$StreamingData$Format.audioTrack);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
