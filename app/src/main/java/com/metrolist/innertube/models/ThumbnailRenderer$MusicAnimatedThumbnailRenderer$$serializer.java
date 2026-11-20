package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer implements GeneratedSerializer {
    public static final ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer thumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer = new ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer();
        INSTANCE = thumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ThumbnailRenderer.MusicAnimatedThumbnailRenderer", thumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("animatedThumbnail", false);
        pluginGeneratedSerialDescriptor.addElement("backupRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{Thumbnails$$serializer.INSTANCE, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Thumbnails thumbnails;
        ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, null);
            musicThumbnailRenderer = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            thumbnails = null;
            ThumbnailRenderer.MusicThumbnailRenderer musicThumbnailRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    thumbnails = (Thumbnails) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, thumbnails);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicThumbnailRenderer2 = (ThumbnailRenderer.MusicThumbnailRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE, musicThumbnailRenderer2);
                    i2 |= 2;
                }
            }
            musicThumbnailRenderer = musicThumbnailRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ThumbnailRenderer.MusicAnimatedThumbnailRenderer(i, thumbnails, musicThumbnailRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ThumbnailRenderer.MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer = (ThumbnailRenderer.MusicAnimatedThumbnailRenderer) obj;
        musicAnimatedThumbnailRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, Thumbnails$$serializer.INSTANCE, musicAnimatedThumbnailRenderer.animatedThumbnail);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE, musicAnimatedThumbnailRenderer.backupRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
