package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
public final /* synthetic */ class SectionListRenderer$Header$ChipCloudRenderer$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$Header$ChipCloudRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$Header$ChipCloudRenderer$$serializer sectionListRenderer$Header$ChipCloudRenderer$$serializer = new SectionListRenderer$Header$ChipCloudRenderer$$serializer();
        INSTANCE = sectionListRenderer$Header$ChipCloudRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer.Header.ChipCloudRenderer", sectionListRenderer$Header$ChipCloudRenderer$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("chips", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SectionListRenderer.Header.ChipCloudRenderer.$childSerializers[0].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SectionListRenderer.Header.ChipCloudRenderer.$childSerializers;
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 = 1;
                }
            }
            list = list2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer.Header.ChipCloudRenderer(i, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer.Header.ChipCloudRenderer chipCloudRenderer = (SectionListRenderer.Header.ChipCloudRenderer) obj;
        chipCloudRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, (SerializationStrategy) SectionListRenderer.Header.ChipCloudRenderer.$childSerializers[0].getValue(), chipCloudRenderer.chips);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
