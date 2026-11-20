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

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ThumbnailRenderer$$serializer implements GeneratedSerializer {
    public static final ThumbnailRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ThumbnailRenderer$$serializer thumbnailRenderer$$serializer = new ThumbnailRenderer$$serializer();
        INSTANCE = thumbnailRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ThumbnailRenderer", thumbnailRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("musicThumbnailRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicAnimatedThumbnailRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("croppedSquareThumbnailRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        ThumbnailRenderer$MusicThumbnailRenderer$$serializer thumbnailRenderer$MusicThumbnailRenderer$$serializer = ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(thumbnailRenderer$MusicThumbnailRenderer$$serializer), HexFormatKt.getNullable(ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(thumbnailRenderer$MusicThumbnailRenderer$$serializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        int i;
        ThumbnailRenderer.MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThumbnailRenderer$MusicThumbnailRenderer$$serializer thumbnailRenderer$MusicThumbnailRenderer$$serializer = ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE;
            musicThumbnailRenderer2 = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, thumbnailRenderer$MusicThumbnailRenderer$$serializer, null);
            musicAnimatedThumbnailRenderer = (ThumbnailRenderer.MusicAnimatedThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE, null);
            musicThumbnailRenderer = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, thumbnailRenderer$MusicThumbnailRenderer$$serializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            musicThumbnailRenderer = null;
            ThumbnailRenderer.MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer2 = null;
            ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicThumbnailRenderer3 = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE, musicThumbnailRenderer3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicAnimatedThumbnailRenderer2 = (ThumbnailRenderer.MusicAnimatedThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE, musicAnimatedThumbnailRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicThumbnailRenderer = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE, musicThumbnailRenderer);
                    i2 |= 4;
                }
            }
            i = i2;
            musicAnimatedThumbnailRenderer = musicAnimatedThumbnailRenderer2;
            musicThumbnailRenderer2 = musicThumbnailRenderer3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ThumbnailRenderer(i, musicThumbnailRenderer2, musicAnimatedThumbnailRenderer, musicThumbnailRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ThumbnailRenderer thumbnailRenderer = (ThumbnailRenderer) obj;
        thumbnailRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        ThumbnailRenderer$MusicThumbnailRenderer$$serializer thumbnailRenderer$MusicThumbnailRenderer$$serializer = ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, thumbnailRenderer$MusicThumbnailRenderer$$serializer, thumbnailRenderer.musicThumbnailRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE, thumbnailRenderer.musicAnimatedThumbnailRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, thumbnailRenderer$MusicThumbnailRenderer$$serializer, thumbnailRenderer.croppedSquareThumbnailRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
