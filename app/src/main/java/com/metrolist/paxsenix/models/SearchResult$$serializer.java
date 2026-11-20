package com.metrolist.paxsenix.models;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SearchResult$$serializer implements GeneratedSerializer {
    public static final SearchResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SearchResult$$serializer searchResult$$serializer = new SearchResult$$serializer();
        INSTANCE = searchResult$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.SearchResult", searchResult$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("songName", true);
        pluginGeneratedSerialDescriptor.addElement("trackName", true);
        pluginGeneratedSerialDescriptor.addElement("artistName", true);
        pluginGeneratedSerialDescriptor.addElement("albumName", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("artwork", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        String str5;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 0;
        String str6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, null);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            num = num2;
            str3 = str9;
            str4 = str10;
            str5 = str8;
            str = str7;
            i = 127;
        } else {
            int i3 = 1;
            int i4 = 0;
            strDecodeStringElement = null;
            String str11 = null;
            Integer num3 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            while (i3 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        i3 = i2;
                        continue;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i2);
                        i4 |= 1;
                        continue;
                    case 1:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str6);
                        i4 |= 2;
                        break;
                    case 2:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str14);
                        i4 |= 4;
                        break;
                    case 3:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str12);
                        i4 |= 8;
                        break;
                    case 4:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str13);
                        i4 |= 16;
                        break;
                    case 5:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num3);
                        i4 |= 32;
                        break;
                    case 6:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str11);
                        i4 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 0;
            }
            str = str6;
            str2 = str11;
            num = num3;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            i = i4;
        }
        String str15 = strDecodeStringElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SearchResult(i, str15, str, str5, str3, str4, num, str2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SearchResult searchResult = (SearchResult) obj;
        searchResult.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = searchResult.id;
        String str2 = searchResult.artwork;
        Integer num = searchResult.duration;
        String str3 = searchResult.albumName;
        String str4 = searchResult.artistName;
        String str5 = searchResult.trackName;
        String str6 = searchResult.songName;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
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
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
