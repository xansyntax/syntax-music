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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MusicCarouselShelfRenderer$$serializer implements GeneratedSerializer {
    public static final MusicCarouselShelfRenderer$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MusicCarouselShelfRenderer$$serializer musicCarouselShelfRenderer$$serializer = new MusicCarouselShelfRenderer$$serializer();
        INSTANCE = musicCarouselShelfRenderer$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.MusicCarouselShelfRenderer", musicCarouselShelfRenderer$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("header", false);
        pluginGeneratedSerialDescriptor.addElement("contents", false);
        pluginGeneratedSerialDescriptor.addElement("itemSize", false);
        pluginGeneratedSerialDescriptor.addElement("numItemsPerColumn", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(MusicCarouselShelfRenderer$Header$$serializer.INSTANCE), MusicCarouselShelfRenderer.$childSerializers[1].getValue(), StringSerializer.INSTANCE, HexFormatKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        MusicCarouselShelfRenderer.Header header;
        Integer num;
        String str;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicCarouselShelfRenderer.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            MusicCarouselShelfRenderer.Header header2 = (MusicCarouselShelfRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$Header$$serializer.INSTANCE, null);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
            list = list2;
            header = header2;
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, null);
            str = strDecodeStringElement;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            List list3 = null;
            MusicCarouselShelfRenderer.Header header3 = null;
            Integer num2 = null;
            String strDecodeStringElement2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    header3 = (MusicCarouselShelfRenderer.Header) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$Header$$serializer.INSTANCE, header3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num2);
                    i2 |= 8;
                }
            }
            list = list3;
            header = header3;
            num = num2;
            str = strDecodeStringElement2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new MusicCarouselShelfRenderer(i, header, list, str, num);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        MusicCarouselShelfRenderer musicCarouselShelfRenderer = (MusicCarouselShelfRenderer) obj;
        musicCarouselShelfRenderer.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = MusicCarouselShelfRenderer.$childSerializers;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, MusicCarouselShelfRenderer$Header$$serializer.INSTANCE, musicCarouselShelfRenderer.header);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), musicCarouselShelfRenderer.contents);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 2, musicCarouselShelfRenderer.itemSize);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, musicCarouselShelfRenderer.numItemsPerColumn);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
