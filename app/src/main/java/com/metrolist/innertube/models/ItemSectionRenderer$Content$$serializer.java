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
public final /* synthetic */ class ItemSectionRenderer$Content$$serializer implements GeneratedSerializer {
    public static final ItemSectionRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ItemSectionRenderer$Content$$serializer itemSectionRenderer$Content$$serializer = new ItemSectionRenderer$Content$$serializer();
        INSTANCE = itemSectionRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ItemSectionRenderer.Content", itemSectionRenderer$Content$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveListItemRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("musicShelfRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("musicPlaylistShelfRenderer", true);
        pluginGeneratedSerialDescriptor.addElement("gridRenderer", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicResponsiveListItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicPlaylistShelfRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(GridRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        GridRenderer gridRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        MusicShelfRenderer musicShelfRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, null);
            MusicShelfRenderer musicShelfRenderer2 = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, null);
            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer2 = (MusicPlaylistShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicPlaylistShelfRenderer$$serializer.INSTANCE, null);
            gridRenderer = (GridRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, GridRenderer$$serializer.INSTANCE, null);
            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer2;
            musicShelfRenderer = musicShelfRenderer2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            musicResponsiveListItemRenderer = null;
            GridRenderer gridRenderer2 = null;
            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer3 = null;
            MusicShelfRenderer musicShelfRenderer3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicShelfRenderer3 = (MusicShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, musicShelfRenderer3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    musicPlaylistShelfRenderer3 = (MusicPlaylistShelfRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, MusicPlaylistShelfRenderer$$serializer.INSTANCE, musicPlaylistShelfRenderer3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    gridRenderer2 = (GridRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, GridRenderer$$serializer.INSTANCE, gridRenderer2);
                    i2 |= 8;
                }
            }
            gridRenderer = gridRenderer2;
            musicPlaylistShelfRenderer = musicPlaylistShelfRenderer3;
            musicShelfRenderer = musicShelfRenderer3;
            i = i2;
        }
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer2 = musicResponsiveListItemRenderer;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ItemSectionRenderer.Content(i, musicResponsiveListItemRenderer2, musicShelfRenderer, musicPlaylistShelfRenderer, gridRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ItemSectionRenderer.Content content = (ItemSectionRenderer.Content) obj;
        content.getClass();
        GridRenderer gridRenderer = content.gridRenderer;
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = content.musicPlaylistShelfRenderer;
        MusicShelfRenderer musicShelfRenderer = content.musicShelfRenderer;
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = content.musicResponsiveListItemRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 0) || musicResponsiveListItemRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || musicShelfRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicShelfRenderer$$serializer.INSTANCE, musicShelfRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || musicPlaylistShelfRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, MusicPlaylistShelfRenderer$$serializer.INSTANCE, musicPlaylistShelfRenderer);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || gridRenderer != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, GridRenderer$$serializer.INSTANCE, gridRenderer);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
