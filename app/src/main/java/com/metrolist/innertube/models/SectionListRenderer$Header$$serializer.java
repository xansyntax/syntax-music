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
public final /* synthetic */ class SectionListRenderer$Header$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$Header$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$Header$$serializer sectionListRenderer$Header$$serializer = new SectionListRenderer$Header$$serializer();
        INSTANCE = sectionListRenderer$Header$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer.Header", sectionListRenderer$Header$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("chipCloudRenderer", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        SectionListRenderer.Header.ChipCloudRenderer chipCloudRenderer;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            chipCloudRenderer = (SectionListRenderer.Header.ChipCloudRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            chipCloudRenderer = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    chipCloudRenderer = (SectionListRenderer.Header.ChipCloudRenderer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE, chipCloudRenderer);
                    i2 = 1;
                }
            }
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer.Header(i, chipCloudRenderer);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer.Header header = (SectionListRenderer.Header) obj;
        header.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE, header.chipCloudRenderer);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
