package com.metrolist.music.lyrics;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
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
public final /* synthetic */ class LyricsMetadata$$serializer implements GeneratedSerializer {
    public static final LyricsMetadata$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricsMetadata$$serializer lyricsMetadata$$serializer = new LyricsMetadata$$serializer();
        INSTANCE = lyricsMetadata$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.LyricsMetadata", lyricsMetadata$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("agents", true);
        pluginGeneratedSerialDescriptor.addElement("songParts", true);
        pluginGeneratedSerialDescriptor.addElement("songWriters", true);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, true);
        pluginGeneratedSerialDescriptor.addElement("language", true);
        pluginGeneratedSerialDescriptor.addElement("totalDuration", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = LyricsMetadata.$childSerializers;
        KSerializer nullable = HexFormatKt.getNullable((KSerializer) lazyArr[0].getValue());
        KSerializer nullable2 = HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue());
        KSerializer nullable3 = HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue());
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{nullable, nullable2, nullable3, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        List list2;
        Map map;
        String str;
        String str2;
        String str3;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsMetadata.$childSerializers;
        int i2 = 5;
        int i3 = 0;
        List list3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Map map2 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            List list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            List list5 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            list = list5;
            map = map2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            str2 = str4;
            str3 = str5;
            i = 63;
            list2 = list4;
        } else {
            int i4 = 1;
            int i5 = 0;
            List list6 = null;
            Map map3 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            while (i4 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        i4 = i3;
                        i2 = 5;
                        break;
                    case 0:
                        int i6 = i3;
                        map3 = (Map) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i6, (DeserializationStrategy) lazyArr[i6].getValue(), map3);
                        i5 |= 1;
                        i3 = i6;
                        i2 = 5;
                        break;
                    case 1:
                        list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                        i5 |= 2;
                        i3 = i3;
                        break;
                    case 2:
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list6);
                        i5 |= 4;
                        i3 = i3;
                        break;
                    case 3:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str7);
                        i5 |= 8;
                        i3 = i3;
                        break;
                    case 4:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str8);
                        i5 |= 16;
                        i3 = i3;
                        break;
                    case 5:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str6);
                        i5 |= 32;
                        i3 = i3;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
            }
            list = list6;
            list2 = list3;
            map = map3;
            str = str6;
            str2 = str7;
            str3 = str8;
            i = i5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricsMetadata(i, map, list2, list, str2, str3, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricsMetadata lyricsMetadata = (LyricsMetadata) obj;
        lyricsMetadata.getClass();
        String str = lyricsMetadata.totalDuration;
        String str2 = lyricsMetadata.language;
        String str3 = lyricsMetadata.title;
        List list = lyricsMetadata.songWriters;
        List list2 = lyricsMetadata.songParts;
        Map map = lyricsMetadata.agents;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsMetadata.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || map != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) lazyArr[0].getValue(), map);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || list2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), list2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
