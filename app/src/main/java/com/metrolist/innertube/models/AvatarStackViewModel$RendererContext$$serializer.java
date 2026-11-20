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
public final /* synthetic */ class AvatarStackViewModel$RendererContext$$serializer implements GeneratedSerializer {
    public static final AvatarStackViewModel$RendererContext$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AvatarStackViewModel$RendererContext$$serializer avatarStackViewModel$RendererContext$$serializer = new AvatarStackViewModel$RendererContext$$serializer();
        INSTANCE = avatarStackViewModel$RendererContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.AvatarStackViewModel.RendererContext", avatarStackViewModel$RendererContext$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("commandContext", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(AvatarStackViewModel$CommandContext$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AvatarStackViewModel.CommandContext commandContext;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            commandContext = (AvatarStackViewModel.CommandContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$CommandContext$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            commandContext = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    commandContext = (AvatarStackViewModel.CommandContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$CommandContext$$serializer.INSTANCE, commandContext);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AvatarStackViewModel.RendererContext(i, commandContext);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AvatarStackViewModel.RendererContext rendererContext = (AvatarStackViewModel.RendererContext) obj;
        rendererContext.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$CommandContext$$serializer.INSTANCE, rendererContext.commandContext);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
