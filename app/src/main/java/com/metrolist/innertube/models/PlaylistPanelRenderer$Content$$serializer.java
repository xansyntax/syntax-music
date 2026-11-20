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
public final /* synthetic */ class PlaylistPanelRenderer$Content$$serializer implements GeneratedSerializer {
    public static final PlaylistPanelRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlaylistPanelRenderer$Content$$serializer playlistPanelRenderer$Content$$serializer = new PlaylistPanelRenderer$Content$$serializer();
        INSTANCE = playlistPanelRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.PlaylistPanelRenderer.Content", playlistPanelRenderer$Content$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("playlistPanelVideoRenderer", false);
        pluginGeneratedSerialDescriptor.addElement("automixPreviewVideoRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(PlaylistPanelVideoRenderer$$serializer.INSTANCE), HexFormatKt.getNullable(AutomixPreviewVideoRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        PlaylistPanelVideoRenderer playlistPanelVideoRenderer;
        AutomixPreviewVideoRenderer automixPreviewVideoRenderer;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            playlistPanelVideoRenderer = (PlaylistPanelVideoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlaylistPanelVideoRenderer$$serializer.INSTANCE, null);
            automixPreviewVideoRenderer = (AutomixPreviewVideoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AutomixPreviewVideoRenderer$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            playlistPanelVideoRenderer = null;
            AutomixPreviewVideoRenderer automixPreviewVideoRenderer2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    playlistPanelVideoRenderer = (PlaylistPanelVideoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, PlaylistPanelVideoRenderer$$serializer.INSTANCE, playlistPanelVideoRenderer);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    automixPreviewVideoRenderer2 = (AutomixPreviewVideoRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AutomixPreviewVideoRenderer$$serializer.INSTANCE, automixPreviewVideoRenderer2);
                    i2 |= 2;
                }
            }
            automixPreviewVideoRenderer = automixPreviewVideoRenderer2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlaylistPanelRenderer.Content(i, playlistPanelVideoRenderer, automixPreviewVideoRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlaylistPanelRenderer.Content content = (PlaylistPanelRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, PlaylistPanelVideoRenderer$$serializer.INSTANCE, content.playlistPanelVideoRenderer);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, AutomixPreviewVideoRenderer$$serializer.INSTANCE, content.automixPreviewVideoRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
