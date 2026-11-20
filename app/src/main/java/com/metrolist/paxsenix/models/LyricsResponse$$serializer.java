package com.metrolist.paxsenix.models;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LyricsResponse$$serializer implements GeneratedSerializer {
    public static final LyricsResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricsResponse$$serializer lyricsResponse$$serializer = new LyricsResponse$$serializer();
        INSTANCE = lyricsResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.LyricsResponse", lyricsResponse$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        pluginGeneratedSerialDescriptor.addElement("metadata", true);
        pluginGeneratedSerialDescriptor.addElement("content", true);
        pluginGeneratedSerialDescriptor.addElement("elrc", true);
        pluginGeneratedSerialDescriptor.addElement("elrcMultiPerson", true);
        pluginGeneratedSerialDescriptor.addElement("ttmlContent", true);
        pluginGeneratedSerialDescriptor.addElement("plain", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = LyricsResponse.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(LyricsMetadata$$serializer.INSTANCE), lazyArr[2].getValue(), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String str;
        LyricsMetadata lyricsMetadata;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsResponse.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        boolean z = true;
        String str6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            LyricsMetadata lyricsMetadata2 = (LyricsMetadata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            String str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            String str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
            String str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
            list = list2;
            str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
            i = 127;
            str4 = str10;
            str5 = str8;
            str2 = str9;
            lyricsMetadata = lyricsMetadata2;
            str = str7;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list3 = null;
            LyricsMetadata lyricsMetadata3 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                        z2 = false;
                        i2 = 6;
                        i3 = 5;
                        continue;
                    case 0:
                        str14 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str14);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                        break;
                    case 1:
                        lyricsMetadata3 = (LyricsMetadata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, lyricsMetadata3);
                        i4 |= 2;
                        z = true;
                        i2 = 6;
                        continue;
                    case 2:
                        list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list3);
                        i4 |= 4;
                        break;
                    case 3:
                        str13 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str13);
                        i4 |= 8;
                        break;
                    case 4:
                        str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i4 |= 16;
                        break;
                    case 5:
                        str12 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i3, StringSerializer.INSTANCE, str12);
                        i4 |= 32;
                        break;
                    case 6:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str11);
                        i4 |= 64;
                        break;
                    default:
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                }
                z = true;
            }
            list = list3;
            str = str14;
            lyricsMetadata = lyricsMetadata3;
            str2 = str6;
            str3 = str11;
            i = i4;
            str4 = str12;
            str5 = str13;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricsResponse(i, str, lyricsMetadata, list, str5, str2, str4, str3);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricsResponse lyricsResponse = (LyricsResponse) obj;
        lyricsResponse.getClass();
        String str = lyricsResponse.plain;
        String str2 = lyricsResponse.ttmlContent;
        String str3 = lyricsResponse.elrcMultiPerson;
        String str4 = lyricsResponse.elrc;
        List list = lyricsResponse.content;
        LyricsMetadata lyricsMetadata = lyricsResponse.metadata;
        String str5 = lyricsResponse.type;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsResponse.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str5 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || lyricsMetadata != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, lyricsMetadata);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(list, EmptyList.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), list);
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
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
