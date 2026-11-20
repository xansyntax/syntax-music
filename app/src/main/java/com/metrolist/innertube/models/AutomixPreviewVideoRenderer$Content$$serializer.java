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
public final /* synthetic */ class AutomixPreviewVideoRenderer$Content$$serializer implements GeneratedSerializer {
    public static final AutomixPreviewVideoRenderer$Content$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AutomixPreviewVideoRenderer$Content$$serializer automixPreviewVideoRenderer$Content$$serializer = new AutomixPreviewVideoRenderer$Content$$serializer();
        INSTANCE = automixPreviewVideoRenderer$Content$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.AutomixPreviewVideoRenderer.Content", automixPreviewVideoRenderer$Content$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("automixPlaylistVideoRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AutomixPreviewVideoRenderer.Content.AutomixPlaylistVideoRenderer automixPlaylistVideoRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            automixPlaylistVideoRenderer = (AutomixPreviewVideoRenderer.Content.AutomixPlaylistVideoRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            automixPlaylistVideoRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    automixPlaylistVideoRenderer = (AutomixPreviewVideoRenderer.Content.AutomixPlaylistVideoRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE, automixPlaylistVideoRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AutomixPreviewVideoRenderer.Content(i, automixPlaylistVideoRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AutomixPreviewVideoRenderer.Content content = (AutomixPreviewVideoRenderer.Content) obj;
        content.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, AutomixPreviewVideoRenderer$Content$AutomixPlaylistVideoRenderer$$serializer.INSTANCE, content.automixPlaylistVideoRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
