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
public final /* synthetic */ class AvatarStackViewModel$Avatar$$serializer implements GeneratedSerializer {
    public static final AvatarStackViewModel$Avatar$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AvatarStackViewModel$Avatar$$serializer avatarStackViewModel$Avatar$$serializer = new AvatarStackViewModel$Avatar$$serializer();
        INSTANCE = avatarStackViewModel$Avatar$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.AvatarStackViewModel.Avatar", avatarStackViewModel$Avatar$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("avatarViewModel", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AvatarStackViewModel.AvatarViewModel avatarViewModel;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            avatarViewModel = (AvatarStackViewModel.AvatarViewModel) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            avatarViewModel = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    avatarViewModel = (AvatarStackViewModel.AvatarViewModel) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE, avatarViewModel);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AvatarStackViewModel.Avatar(i, avatarViewModel);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AvatarStackViewModel.Avatar avatar = (AvatarStackViewModel.Avatar) obj;
        avatar.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, AvatarStackViewModel$AvatarViewModel$$serializer.INSTANCE, avatar.avatarViewModel);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
