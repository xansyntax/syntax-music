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
public final /* synthetic */ class MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer implements GeneratedSerializer {
    public static final MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer musicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer = new MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer();
        INSTANCE = musicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer", musicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("playNavigationEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(NavigationEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        NavigationEndpoint navigationEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            navigationEndpoint = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    navigationEndpoint = (NavigationEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$$serializer.INSTANCE, navigationEndpoint);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer(i, navigationEndpoint);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer = (MusicResponsiveListItemRenderer.Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer) obj;
        musicPlayButtonRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, NavigationEndpoint$$serializer.INSTANCE, musicPlayButtonRenderer.playNavigationEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
