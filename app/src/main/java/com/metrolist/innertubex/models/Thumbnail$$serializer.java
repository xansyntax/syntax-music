package com.metrolist.innertubex.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
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
public final /* synthetic */ class Thumbnail$$serializer implements GeneratedSerializer {
    public static final Thumbnail$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Thumbnail$$serializer thumbnail$$serializer = new Thumbnail$$serializer();
        INSTANCE = thumbnail$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.models.Thumbnail", thumbnail$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("width", true);
        pluginGeneratedSerialDescriptor.addElement("height", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, HexFormatKt.getNullable(intSerializer), HexFormatKt.getNullable(intSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        Integer num;
        Integer num2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, intSerializer, null);
            num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, intSerializer, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            Integer num3 = null;
            Integer num4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num4);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num3);
                    i2 |= 4;
                }
            }
            num = num3;
            num2 = num4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new Thumbnail(i, strDecodeStringElement, num2, num);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Thumbnail thumbnail = (Thumbnail) obj;
        thumbnail.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = thumbnail.url;
        Integer num = thumbnail.height;
        Integer num2 = thumbnail.width;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || num2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, num2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || num != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, num);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
