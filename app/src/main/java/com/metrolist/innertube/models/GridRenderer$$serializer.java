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
public final /* synthetic */ class GridRenderer$$serializer implements GeneratedSerializer {
    public static final GridRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GridRenderer$$serializer gridRenderer$$serializer = new GridRenderer$$serializer();
        INSTANCE = gridRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.GridRenderer", gridRenderer$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("items", false);
        pluginGeneratedSerialDescriptor.addElement("continuations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = GridRenderer.$childSerializers;
        return new KSerializer[]{HexFormatKt.getNullable(GridRenderer$Header$$serializer.INSTANCE), lazyArr[1].getValue(), HexFormatKt.getNullable((KSerializer) lazyArr[2].getValue())};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        GridRenderer.Header header;
        int i;
        List list2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GridRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            header = (GridRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, GridRenderer$Header$$serializer.INSTANCE, null);
            list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            GridRenderer.Header header2 = null;
            List list4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    header2 = (GridRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, GridRenderer$Header$$serializer.INSTANCE, header2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list4);
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
        return new GridRenderer(i, header, list2, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GridRenderer gridRenderer = (GridRenderer) obj;
        gridRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GridRenderer.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, GridRenderer$Header$$serializer.INSTANCE, gridRenderer.header);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), gridRenderer.items);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), gridRenderer.continuations);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
