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
public final /* synthetic */ class CachedItem$Album$$serializer implements GeneratedSerializer {
    public static final CachedItem$Album$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CachedItem$Album$$serializer cachedItem$Album$$serializer = new CachedItem$Album$$serializer();
        INSTANCE = cachedItem$Album$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("album", cachedItem$Album$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Title, false);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("explicit", true);
        pluginGeneratedSerialDescriptor.addElement("artists", true);
        pluginGeneratedSerialDescriptor.addElement("year", true);
        pluginGeneratedSerialDescriptor.addElement("browseId", true);
        pluginGeneratedSerialDescriptor.addElement("playlistId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = CachedItem.Album.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BooleanSerializer.INSTANCE, lazyArr[4].getValue(), HexFormatKt.getNullable(IntSerializer.INSTANCE), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        int i;
        Integer num;
        String str;
        String str2;
        String str3;
        boolean z;
        String str4;
        String str5;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedItem.Album.$childSerializers;
        int i2 = 1;
        int i3 = 0;
        Integer num2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 1);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 3);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), null);
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            list = list2;
            str = strDecodeStringElement;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
            str3 = str6;
            num = num3;
            z = zDecodeBooleanElement;
            str4 = strDecodeStringElement3;
            i = 255;
            str5 = strDecodeStringElement2;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            List list3 = null;
            String strDecodeStringElement4 = null;
            String str7 = null;
            String str8 = null;
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
                        num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num2);
                        i3 |= 32;
                        break;
                    case 6:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str8);
                        i3 |= 64;
                        break;
                    case 7:
                        str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str7);
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
            num = num2;
            str = strDecodeStringElement4;
            str2 = str7;
            str3 = str8;
            z = zDecodeBooleanElement2;
            str4 = strDecodeStringElement5;
            str5 = strDecodeStringElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new CachedItem.Album(i, str, str5, str4, z, list, num, str3, str2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        CachedItem.Album album = (CachedItem.Album) obj;
        album.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = CachedItem.Album.$childSerializers;
        String str = album.id;
        String str2 = album.playlistId;
        String str3 = album.browseId;
        Integer num = album.year;
        List list = album.artists;
        boolean z = album.explicit;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 1, album.title);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, album.thumbnail);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 3, z);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 4, (SerializationStrategy) lazyArr[4].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 5) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, num);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 6) || str3 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str3);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 7) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str2);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
