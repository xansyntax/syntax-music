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
public final /* synthetic */ class MusicResponsiveListItemRenderer$Overlay$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveListItemRenderer$Overlay$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveListItemRenderer$Overlay$$serializer musicResponsiveListItemRenderer$Overlay$$serializer = new MusicResponsiveListItemRenderer$Overlay$$serializer();
        INSTANCE = musicResponsiveListItemRenderer$Overlay$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveListItemRenderer.Overlay", musicResponsiveListItemRenderer$Overlay$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("musicItemThumbnailOverlayRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicItemThumbnailOverlayRenderer = (MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            musicItemThumbnailOverlayRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicItemThumbnailOverlayRenderer = (MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE, musicItemThumbnailOverlayRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveListItemRenderer.Overlay(i, musicItemThumbnailOverlayRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveListItemRenderer.Overlay overlay = (MusicResponsiveListItemRenderer.Overlay) obj;
        overlay.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE, overlay.musicItemThumbnailOverlayRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
