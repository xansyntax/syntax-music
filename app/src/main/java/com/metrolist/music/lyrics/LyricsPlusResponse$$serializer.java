package com.metrolist.music.lyrics;

import io.ktor.http.LinkHeader;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
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
public final /* synthetic */ class LyricsPlusResponse$$serializer implements GeneratedSerializer {
    public static final LyricsPlusResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LyricsPlusResponse$$serializer lyricsPlusResponse$$serializer = new LyricsPlusResponse$$serializer();
        INSTANCE = lyricsPlusResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.lyrics.LyricsPlusResponse", lyricsPlusResponse$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(LinkHeader.Parameters.Type, true);
        pluginGeneratedSerialDescriptor.addElement("metadata", true);
        pluginGeneratedSerialDescriptor.addElement("lyrics", true);
        pluginGeneratedSerialDescriptor.addElement("cached", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = LyricsPlusResponse.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(LyricsMetadata$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue()), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        String str;
        int i;
        LyricsMetadata lyricsMetadata;
        String str2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsPlusResponse.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
            LyricsMetadata lyricsMetadata2 = (LyricsMetadata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
            i = 15;
            lyricsMetadata = lyricsMetadata2;
            str2 = str3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            String str4 = null;
            LyricsMetadata lyricsMetadata3 = null;
            String str5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str5);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    lyricsMetadata3 = (LyricsMetadata) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, lyricsMetadata3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str4);
                    i2 |= 8;
                }
            }
            list = list2;
            str = str4;
            i = i2;
            lyricsMetadata = lyricsMetadata3;
            str2 = str5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new LyricsPlusResponse(i, str2, lyricsMetadata, list, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        LyricsPlusResponse lyricsPlusResponse = (LyricsPlusResponse) obj;
        lyricsPlusResponse.getClass();
        String str = lyricsPlusResponse.cached;
        List list = lyricsPlusResponse.lyrics;
        LyricsMetadata lyricsMetadata = lyricsPlusResponse.metadata;
        String str2 = lyricsPlusResponse.type;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = LyricsPlusResponse.$childSerializers;
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || lyricsMetadata != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, LyricsMetadata$$serializer.INSTANCE, lyricsMetadata);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || list != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), list);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || str != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
