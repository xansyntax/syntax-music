package com.metrolist.innertube.models;

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
public final /* synthetic */ class SectionListRenderer$$serializer implements GeneratedSerializer {
    public static final SectionListRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SectionListRenderer$$serializer sectionListRenderer$$serializer = new SectionListRenderer$$serializer();
        INSTANCE = sectionListRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.SectionListRenderer", sectionListRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("continuations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = SectionListRenderer.$childSerializers;
        return new KSerializer[]{HexFormatKt.getNullable(SectionListRenderer$Header$$serializer.INSTANCE), HexFormatKt.getNullable((KSerializer) lazyArr[1].getValue()), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        SectionListRenderer.Header header;
        int i;
        List list2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SectionListRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            header = (SectionListRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$$serializer.INSTANCE, null);
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            SectionListRenderer.Header header2 = null;
            List list4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    header2 = (SectionListRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$$serializer.INSTANCE, header2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list4 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list4);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list3 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list3);
                    i2 |= 4;
                }
            }
            list = list3;
            header = header2;
            i = i2;
            list2 = list4;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new SectionListRenderer(i, header, list2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        SectionListRenderer sectionListRenderer = (SectionListRenderer) obj;
        sectionListRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = SectionListRenderer.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, SectionListRenderer$Header$$serializer.INSTANCE, sectionListRenderer.header);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), sectionListRenderer.contents);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), sectionListRenderer.continuations);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
