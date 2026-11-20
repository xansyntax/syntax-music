package com.metrolist.innertubex.models.response;

import com.metrolist.innertubex.models.Thumbnails;
import com.metrolist.innertubex.models.Thumbnails$$serializer;
import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
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
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.response.PlayerResponse.VideoDetails", playerResponse$VideoDetails$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("videoId", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("author", true);
        pluginGeneratedSerialDescriptor.addElement("channelId", true);
        pluginGeneratedSerialDescriptor.addElement("lengthSeconds", true);
        pluginGeneratedSerialDescriptor.addElement("musicVideoType", true);
        pluginGeneratedSerialDescriptor.addElement("viewCount", true);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", true);
        pluginGeneratedSerialDescriptor.addElement("isLiveContent", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(Thumbnails$$serializer.INSTANCE), HexFormatKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        String str2;
        int i;
        String str3;
        Boolean bool;
        String str4;
        Thumbnails thumbnails;
        String str5;
        String str6;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        char c = 3;
        String str7 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            String str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, Thumbnails$$serializer.INSTANCE, null);
            str5 = str13;
            str6 = str12;
            str4 = str10;
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, null);
            str3 = str11;
            str = str9;
            str2 = str8;
            i = 511;
        } else {
            boolean z = true;
            int i5 = 0;
            strDecodeStringElement = null;
            String str14 = null;
            Boolean bool2 = null;
            Thumbnails thumbnails2 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i5 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 1:
                        str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str18);
                        i5 |= 2;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        c = 3;
                        break;
                    case 2:
                        i5 |= 4;
                        str17 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str17);
                        i2 = 7;
                        i3 = 6;
                        c = 3;
                        break;
                    case 3:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i5 |= 8;
                        c = 3;
                        i2 = 7;
                        break;
                    case 4:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str14);
                        i5 |= 16;
                        c = 3;
                        break;
                    case 5:
                        str16 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i4, StringSerializer.INSTANCE, str16);
                        i5 |= 32;
                        c = 3;
                        break;
                    case 6:
                        str15 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str15);
                        i5 |= 64;
                        c = 3;
                        break;
                    case 7:
                        thumbnails2 = (Thumbnails) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, Thumbnails$$serializer.INSTANCE, thumbnails2);
                        i5 |= 128;
                        c = 3;
                        break;
                    case 8:
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool2);
                        i5 |= 256;
                        c = 3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            str = str17;
            str2 = str18;
            i = i5;
            str3 = str14;
            bool = bool2;
            str4 = str7;
            thumbnails = thumbnails2;
            str5 = str15;
            str6 = str16;
        }
        String str19 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse.VideoDetails(i, str19, str2, str, str4, str3, str6, str5, thumbnails, bool);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse.VideoDetails videoDetails = (PlayerResponse.VideoDetails) obj;
        videoDetails.getClass();
        Boolean bool = videoDetails.isLiveContent;
        Thumbnails thumbnails = videoDetails.thumbnail;
        String str = videoDetails.viewCount;
        String str2 = videoDetails.musicVideoType;
        String str3 = videoDetails.lengthSeconds;
        String str4 = videoDetails.channelId;
        String str5 = videoDetails.author;
        String str6 = videoDetails.title;
        String str7 = videoDetails.videoId;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(str7, "")) {
            compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str7);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str6 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str4 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || thumbnails != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, Thumbnails$$serializer.INSTANCE, thumbnails);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 8) || bool != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 8, BooleanSerializer.INSTANCE, bool);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
