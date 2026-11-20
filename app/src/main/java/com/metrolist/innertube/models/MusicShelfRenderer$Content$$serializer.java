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
public final /* synthetic */ class MusicShelfRenderer$Content$$serializer implements GeneratedSerializer {
    public static final MusicShelfRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicShelfRenderer$Content$$serializer musicShelfRenderer$Content$$serializer = new MusicShelfRenderer$Content$$serializer();
        INSTANCE = musicShelfRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicShelfRenderer.Content", musicShelfRenderer$Content$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("musicResponsiveListItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("musicMultiRowListItemRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("continuationItemRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicResponsiveListItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(MusicMultiRowListItemRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(ContinuationItemRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        ContinuationItemRenderer continuationItemRenderer;
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, null);
            musicMultiRowListItemRenderer = (MusicMultiRowListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicMultiRowListItemRenderer$$serializer.INSTANCE, null);
            continuationItemRenderer = (ContinuationItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ContinuationItemRenderer$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            musicResponsiveListItemRenderer = null;
            ContinuationItemRenderer continuationItemRenderer2 = null;
            MusicMultiRowListItemRenderer musicMultiRowListItemRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, musicResponsiveListItemRenderer);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    musicMultiRowListItemRenderer2 = (MusicMultiRowListItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MusicMultiRowListItemRenderer$$serializer.INSTANCE, musicMultiRowListItemRenderer2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    continuationItemRenderer2 = (ContinuationItemRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ContinuationItemRenderer$$serializer.INSTANCE, continuationItemRenderer2);
                    i2 |= 4;
                }
            }
            continuationItemRenderer = continuationItemRenderer2;
            musicMultiRowListItemRenderer = musicMultiRowListItemRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicShelfRenderer.Content(i, musicResponsiveListItemRenderer, musicMultiRowListItemRenderer, continuationItemRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicShelfRenderer.Content content = (MusicShelfRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicResponsiveListItemRenderer$$serializer.INSTANCE, content.musicResponsiveListItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, MusicMultiRowListItemRenderer$$serializer.INSTANCE, content.musicMultiRowListItemRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, ContinuationItemRenderer$$serializer.INSTANCE, content.continuationItemRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
