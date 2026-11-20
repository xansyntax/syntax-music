package com.metrolist.innertube.models.response;

import com.metrolist.innertube.models.Thumbnails;
import com.metrolist.innertube.models.Thumbnails$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlayerResponse$VideoDetails$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$VideoDetails$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$VideoDetails$$serializer playerResponse$VideoDetails$$serializer = new PlayerResponse$VideoDetails$$serializer();
        INSTANCE = playerResponse$VideoDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.VideoDetails", playerResponse$VideoDetails$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("videoId", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("author", false);
        pluginGeneratedSerialDescriptor.addElement("channelId", false);
        pluginGeneratedSerialDescriptor.addElement("lengthSeconds", false);
        pluginGeneratedSerialDescriptor.addElement("musicVideoType", false);
        pluginGeneratedSerialDescriptor.addElement("viewCount", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), stringSerializer, stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), Thumbnails$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        int i;
        String str;
        String str2;
        Thumbnails thumbnails;
        String str3;
        String str4;
        String str5;
        String str6;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        char c = 2;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 7, Thumbnails$$serializer.INSTANCE, null);
            str3 = str11;
            str4 = str10;
            str5 = strDecodeStringElement2;
            str6 = strDecodeStringElement3;
            str2 = str9;
            str = str8;
            i = 255;
        } else {
            boolean z = true;
            int i3 = 0;
            strDecodeStringElement = null;
            String str12 = null;
            Thumbnails thumbnails2 = null;
            String str13 = null;
            String str14 = null;
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        c = 2;
                        break;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        i2 = 7;
                        c = 2;
                        break;
                    case 1:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str12);
                        i3 |= 2;
                        i2 = 7;
                        c = 2;
                        break;
                    case 2:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i3 |= 4;
                        c = 2;
                        i2 = 7;
                        break;
                    case 3:
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i3 |= 8;
                        c = 2;
                        break;
                    case 4:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 4);
                        i3 |= 16;
                        c = 2;
                        break;
                    case 5:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str14);
                        i3 |= 32;
                        c = 2;
                        break;
                    case 6:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str13);
                        i3 |= 64;
                        c = 2;
                        break;
                    case 7:
                        thumbnails2 = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, i2, Thumbnails$$serializer.INSTANCE, thumbnails2);
                        i3 |= 128;
                        c = 2;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            i = i3;
            str = str12;
            str2 = str7;
            thumbnails = thumbnails2;
            str3 = str13;
            str4 = str14;
            str5 = strDecodeStringElement4;
            str6 = strDecodeStringElement5;
        }
        String str15 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$VideoDetails(i, str15, str, str2, str5, str6, str4, str3, thumbnails);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$VideoDetails playerResponse$VideoDetails = (PlayerResponse$VideoDetails) obj;
        playerResponse$VideoDetails.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, playerResponse$VideoDetails.videoId);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, playerResponse$VideoDetails.title);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, playerResponse$VideoDetails.author);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 3, playerResponse$VideoDetails.channelId);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 4, playerResponse$VideoDetails.lengthSeconds);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, playerResponse$VideoDetails.musicVideoType);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, playerResponse$VideoDetails.viewCount);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 7, Thumbnails$$serializer.INSTANCE, playerResponse$VideoDetails.thumbnail);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
