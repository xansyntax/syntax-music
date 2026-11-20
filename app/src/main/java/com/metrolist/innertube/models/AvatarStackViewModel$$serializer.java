package com.metrolist.innertube.models;

import io.ktor.http.ContentType;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AvatarStackViewModel$$serializer implements GeneratedSerializer {
    public static final AvatarStackViewModel$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AvatarStackViewModel$$serializer avatarStackViewModel$$serializer = new AvatarStackViewModel$$serializer();
        INSTANCE = avatarStackViewModel$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.AvatarStackViewModel", avatarStackViewModel$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("avatars", false);
        pluginGeneratedSerialDescriptor.addElement(ContentType.Text.TYPE, false);
        pluginGeneratedSerialDescriptor.addElement("rendererContext", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable((KSerializer) AvatarStackViewModel.$childSerializers[0].getValue()), HexFormatKt.getNullable(AvatarStackViewModel$AvatarText$$serializer.INSTANCE), HexFormatKt.getNullable(AvatarStackViewModel$RendererContext$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        AvatarStackViewModel.AvatarText avatarText;
        AvatarStackViewModel.RendererContext rendererContext;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = AvatarStackViewModel.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            avatarText = (AvatarStackViewModel.AvatarText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AvatarStackViewModel$AvatarText$$serializer.INSTANCE, null);
            rendererContext = (AvatarStackViewModel.RendererContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AvatarStackViewModel$RendererContext$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            AvatarStackViewModel.AvatarText avatarText2 = null;
            AvatarStackViewModel.RendererContext rendererContext2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    avatarText2 = (AvatarStackViewModel.AvatarText) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AvatarStackViewModel$AvatarText$$serializer.INSTANCE, avatarText2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    rendererContext2 = (AvatarStackViewModel.RendererContext) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AvatarStackViewModel$RendererContext$$serializer.INSTANCE, rendererContext2);
                    i2 |= 4;
                }
            }
            list = list2;
            avatarText = avatarText2;
            rendererContext = rendererContext2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AvatarStackViewModel(i, list, avatarText, rendererContext);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AvatarStackViewModel avatarStackViewModel = (AvatarStackViewModel) obj;
        avatarStackViewModel.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, (SerializationStrategy) AvatarStackViewModel.$childSerializers[0].getValue(), avatarStackViewModel.avatars);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, AvatarStackViewModel$AvatarText$$serializer.INSTANCE, avatarStackViewModel.text);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, AvatarStackViewModel$RendererContext$$serializer.INSTANCE, avatarStackViewModel.rendererContext);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
