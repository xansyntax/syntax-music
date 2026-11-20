package com.metrolist.music.db.entities;

import com.yalantis.ucrop.util.ImageHeaderParser;
import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CachedItem$Song$$serializer implements GeneratedSerializer {
    public static final CachedItem$Song$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedItem$Song$$serializer cachedItem$Song$$serializer = new CachedItem$Song$$serializer();
        INSTANCE = cachedItem$Song$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("song", cachedItem$Song$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("explicit", true);
        pluginGeneratedSerialDescriptor.addElement("artists", true);
        pluginGeneratedSerialDescriptor.addElement("album", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("videoId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = CachedItem.Song.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE, lazyArr[4].getValue(), HexFormatKt.getNullable(CachedAlbum$$serializer.INSTANCE), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        int i;
        CachedAlbum cachedAlbum;
        String str;
        String str2;
        Integer num;
        boolean z;
        String str3;
        String str4;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedItem.Song.$childSerializers;
        int i2 = 1;
        int i3 = 0;
        CachedAlbum cachedAlbum2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            CachedAlbum cachedAlbum3 = (CachedAlbum) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, null);
            list = list2;
            str = strDecodeStringElement;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            num = num2;
            cachedAlbum = cachedAlbum3;
            z = zDecodeBooleanElement;
            str3 = strDecodeStringElement3;
            i = 255;
            str4 = strDecodeStringElement2;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            List list3 = null;
            String strDecodeStringElement4 = null;
            String str5 = null;
            Integer num3 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        continue;
                    case 0:
                        i3 |= 1;
                        strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                        continue;
                    case 1:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, i2);
                        i3 |= 2;
                        continue;
                    case 2:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    case 3:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i3 |= 8;
                        break;
                    case 4:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), list3);
                        i3 |= 16;
                        break;
                    case 5:
                        cachedAlbum2 = (CachedAlbum) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, cachedAlbum2);
                        i3 |= 32;
                        break;
                    case 6:
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num3);
                        i3 |= 64;
                        break;
                    case 7:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str5);
                        i3 |= 128;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                i2 = 1;
            }
            list = list3;
            i = i3;
            cachedAlbum = cachedAlbum2;
            str = strDecodeStringElement4;
            str2 = str5;
            num = num3;
            z = zDecodeBooleanElement2;
            str3 = strDecodeStringElement5;
            str4 = strDecodeStringElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedItem.Song(i, str, str4, str3, z, list, cachedAlbum, num, str2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedItem.Song song = (CachedItem.Song) obj;
        song.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedItem.Song.$childSerializers;
        String str = song.id;
        String str2 = song.videoId;
        Integer num = song.duration;
        CachedAlbum cachedAlbum = song.album;
        List list = song.artists;
        boolean z = song.explicit;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, song.title);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, song.thumbnail);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || cachedAlbum != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, CachedAlbum$$serializer.INSTANCE, cachedAlbum);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
