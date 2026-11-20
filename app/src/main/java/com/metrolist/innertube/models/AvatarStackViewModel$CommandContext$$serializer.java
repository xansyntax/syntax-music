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
public final /* synthetic */ class AvatarStackViewModel$CommandContext$$serializer implements GeneratedSerializer {
    public static final AvatarStackViewModel$CommandContext$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AvatarStackViewModel$CommandContext$$serializer avatarStackViewModel$CommandContext$$serializer = new AvatarStackViewModel$CommandContext$$serializer();
        INSTANCE = avatarStackViewModel$CommandContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.AvatarStackViewModel.CommandContext", avatarStackViewModel$CommandContext$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("onTap", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(AvatarStackViewModel$OnTap$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AvatarStackViewModel.OnTap onTap;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            onTap = (AvatarStackViewModel.OnTap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$OnTap$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            onTap = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    onTap = (AvatarStackViewModel.OnTap) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$OnTap$$serializer.INSTANCE, onTap);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AvatarStackViewModel.CommandContext(i, onTap);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AvatarStackViewModel.CommandContext commandContext = (AvatarStackViewModel.CommandContext) obj;
        commandContext.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$OnTap$$serializer.INSTANCE, commandContext.onTap);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
