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
public final /* synthetic */ class SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer sectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer = new SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer();
        INSTANCE = sectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer.Header.ChipCloudRenderer.Chip", sectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("chipCloudChipRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer chipCloudChipRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            chipCloudChipRenderer = (SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            chipCloudChipRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    chipCloudChipRenderer = (SectionListRenderer.Header.ChipCloudRenderer.Chip.ChipCloudChipRenderer) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE, chipCloudChipRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer.Header.ChipCloudRenderer.Chip(i, chipCloudChipRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer.Header.ChipCloudRenderer.Chip chip = (SectionListRenderer.Header.ChipCloudRenderer.Chip) obj;
        chip.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE, chip.chipCloudChipRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
