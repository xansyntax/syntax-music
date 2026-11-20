package com.metrolist.innertube.models;

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
public final /* synthetic */ class ThumbnailRenderer$MusicThumbnailRenderer$$serializer implements GeneratedSerializer {
    public static final ThumbnailRenderer$MusicThumbnailRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ThumbnailRenderer$MusicThumbnailRenderer$$serializer thumbnailRenderer$MusicThumbnailRenderer$$serializer = new ThumbnailRenderer$MusicThumbnailRenderer$$serializer();
        INSTANCE = thumbnailRenderer$MusicThumbnailRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ThumbnailRenderer.MusicThumbnailRenderer", thumbnailRenderer$MusicThumbnailRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("thumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnailCrop", false);
        pluginGeneratedSerialDescriptor.addElement("thumbnailScale", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{Thumbnails$$serializer.INSTANCE, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Thumbnails thumbnails;
        String str;
        String str2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            thumbnails = null;
            String str3 = null;
            String str4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, thumbnails);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str4);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str3);
                    i2 |= 4;
                }
            }
            str = str3;
            str2 = str4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ThumbnailRenderer.MusicThumbnailRenderer(i, thumbnails, str2, str);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer = (ThumbnailRenderer.MusicThumbnailRenderer) obj;
        musicThumbnailRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, musicThumbnailRenderer.thumbnail);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, musicThumbnailRenderer.thumbnailCrop);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, musicThumbnailRenderer.thumbnailScale);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
