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
public final /* synthetic */ class GridRenderer$Item$$serializer implements GeneratedSerializer {
    public static final GridRenderer$Item$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GridRenderer$Item$$serializer gridRenderer$Item$$serializer = new GridRenderer$Item$$serializer();
        INSTANCE = gridRenderer$Item$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.GridRenderer.Item", gridRenderer$Item$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("musicNavigationButtonRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicTwoRowItemRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicNavigationButtonRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicTwoRowItemRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicNavigationButtonRenderer musicNavigationButtonRenderer;
        MusicTwoRowItemRenderer musicTwoRowItemRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicNavigationButtonRenderer = (MusicNavigationButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicNavigationButtonRenderer$$serializer.INSTANCE, null);
            musicTwoRowItemRenderer = (MusicTwoRowItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicTwoRowItemRenderer$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            musicNavigationButtonRenderer = null;
            MusicTwoRowItemRenderer musicTwoRowItemRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicNavigationButtonRenderer = (MusicNavigationButtonRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicNavigationButtonRenderer$$serializer.INSTANCE, musicNavigationButtonRenderer);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    musicTwoRowItemRenderer2 = (MusicTwoRowItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicTwoRowItemRenderer$$serializer.INSTANCE, musicTwoRowItemRenderer2);
                    i2 |= 2;
                }
            }
            musicTwoRowItemRenderer = musicTwoRowItemRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GridRenderer.Item(i, musicNavigationButtonRenderer, musicTwoRowItemRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GridRenderer.Item item = (GridRenderer.Item) obj;
        item.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicNavigationButtonRenderer$$serializer.INSTANCE, item.musicNavigationButtonRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicTwoRowItemRenderer$$serializer.INSTANCE, item.musicTwoRowItemRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
