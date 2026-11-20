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
public final /* synthetic */ class ItemSectionRenderer$$serializer implements GeneratedSerializer {
    public static final ItemSectionRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ItemSectionRenderer$$serializer itemSectionRenderer$$serializer = new ItemSectionRenderer$$serializer();
        INSTANCE = itemSectionRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ItemSectionRenderer", itemSectionRenderer$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("header", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable((KSerializer) ItemSectionRenderer.$childSerializers[0].getValue()), HexFormatKt.getNullable(ItemSectionRenderer$Header$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        ItemSectionRenderer.Header header;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ItemSectionRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            header = (ItemSectionRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ItemSectionRenderer$Header$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            ItemSectionRenderer.Header header2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    header2 = (ItemSectionRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, ItemSectionRenderer$Header$$serializer.INSTANCE, header2);
                    i2 |= 2;
                }
            }
            list = list2;
            header = header2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ItemSectionRenderer(i, list, header);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ItemSectionRenderer itemSectionRenderer = (ItemSectionRenderer) obj;
        itemSectionRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        SerializationStrategy serializationStrategy = (SerializationStrategy) ItemSectionRenderer.$childSerializers[0].getValue();
        List list = itemSectionRenderer.contents;
        ItemSectionRenderer.Header header = itemSectionRenderer.header;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, serializationStrategy, list);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || header != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, ItemSectionRenderer$Header$$serializer.INSTANCE, header);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
