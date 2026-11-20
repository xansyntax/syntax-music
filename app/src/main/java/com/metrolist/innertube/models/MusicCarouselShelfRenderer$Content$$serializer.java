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
public final /* synthetic */ class MusicCarouselShelfRenderer$Content$$serializer implements GeneratedSerializer {
    public static final MusicCarouselShelfRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicCarouselShelfRenderer$Content$$serializer musicCarouselShelfRenderer$Content$$serializer = new MusicCarouselShelfRenderer$Content$$serializer();
        INSTANCE = musicCarouselShelfRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicCarouselShelfRenderer.Content", musicCarouselShelfRenderer$Content$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("musicTwoRowItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveListItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicMultiRowListItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicNavigationButtonRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicTwoRowItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicResponsiveListItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicMultiRowListItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicNavigationButtonRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicTwoRowItemRenderer musicTwoRowItemRenderer;
        MusicNavigationButtonRenderer musicNavigationButtonRenderer;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicTwoRowItemRenderer = (MusicTwoRowItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicTwoRowItemRenderer$$serializer.INSTANCE, null);
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveListItemRenderer$$serializer.INSTANCE, null);
            MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2 = (MusicMultiRowListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicMultiRowListItemRenderer$$serializer.INSTANCE, null);
            musicNavigationButtonRenderer = (MusicNavigationButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicNavigationButtonRenderer$$serializer.INSTANCE, null);
            musicMultiRowListItemRenderer = musicMultiRowListItemRenderer2;
            musicResponsiveListItemRenderer = musicResponsiveListItemRenderer2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            musicTwoRowItemRenderer = null;
            MusicNavigationButtonRenderer musicNavigationButtonRenderer2 = null;
            MusicMultiRowListItemRenderer musicMultiRowListItemRenderer3 = null;
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicTwoRowItemRenderer = (MusicTwoRowItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicTwoRowItemRenderer$$serializer.INSTANCE, musicTwoRowItemRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicResponsiveListItemRenderer3 = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveListItemRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    musicMultiRowListItemRenderer3 = (MusicMultiRowListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicMultiRowListItemRenderer$$serializer.INSTANCE, musicMultiRowListItemRenderer3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicNavigationButtonRenderer2 = (MusicNavigationButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, MusicNavigationButtonRenderer$$serializer.INSTANCE, musicNavigationButtonRenderer2);
                    i2 |= 8;
                }
            }
            musicNavigationButtonRenderer = musicNavigationButtonRenderer2;
            musicMultiRowListItemRenderer = musicMultiRowListItemRenderer3;
            musicResponsiveListItemRenderer = musicResponsiveListItemRenderer3;
            i = i2;
        }
        MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = musicTwoRowItemRenderer;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicCarouselShelfRenderer.Content(i, musicTwoRowItemRenderer2, musicResponsiveListItemRenderer, musicMultiRowListItemRenderer, musicNavigationButtonRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicCarouselShelfRenderer.Content content = (MusicCarouselShelfRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicTwoRowItemRenderer$$serializer.INSTANCE, content.musicTwoRowItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicResponsiveListItemRenderer$$serializer.INSTANCE, content.musicResponsiveListItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicMultiRowListItemRenderer$$serializer.INSTANCE, content.musicMultiRowListItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, MusicNavigationButtonRenderer$$serializer.INSTANCE, content.musicNavigationButtonRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
