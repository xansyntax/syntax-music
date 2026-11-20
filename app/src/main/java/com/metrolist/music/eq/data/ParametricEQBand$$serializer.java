package com.metrolist.music.eq.data;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.Lazy;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ParametricEQBand$$serializer implements GeneratedSerializer {
    public static final ParametricEQBand$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ParametricEQBand$$serializer parametricEQBand$$serializer = new ParametricEQBand$$serializer();
        INSTANCE = parametricEQBand$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.ParametricEQBand", parametricEQBand$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("frequency", false);
        pluginGeneratedSerialDescriptor.addElement("gain", false);
        pluginGeneratedSerialDescriptor.addElement("q", true);
        pluginGeneratedSerialDescriptor.addElement("filterType", true);
        pluginGeneratedSerialDescriptor.addElement("enabled", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ParametricEQBand.$childSerializers;
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{doubleSerializer, doubleSerializer, doubleSerializer, lazyArr[3].getValue(), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        FilterType filterType;
        boolean zDecodeBooleanElement;
        int i;
        double d;
        double d2;
        double d3;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ParametricEQBand.$childSerializers;
        Object obj = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            double dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
            double dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 1);
            double dDecodeDoubleElement3 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 2);
            filterType = (FilterType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
            i = 31;
            d = dDecodeDoubleElement2;
            d2 = dDecodeDoubleElement;
            d3 = dDecodeDoubleElement3;
        } else {
            boolean z = true;
            FilterType filterType2 = null;
            double dDecodeDoubleElement4 = 0.0d;
            double dDecodeDoubleElement5 = 0.0d;
            double dDecodeDoubleElement6 = 0.0d;
            boolean zDecodeBooleanElement2 = false;
            int i2 = 0;
            while (z) {
                obj = obj;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    dDecodeDoubleElement5 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    dDecodeDoubleElement4 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    dDecodeDoubleElement6 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 2);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    filterType2 = (FilterType) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), filterType2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return obj;
                    }
                    zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 4);
                    i2 |= 16;
                }
            }
            filterType = filterType2;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            i = i2;
            d = dDecodeDoubleElement4;
            d2 = dDecodeDoubleElement5;
            d3 = dDecodeDoubleElement6;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ParametricEQBand(i, d2, d, d3, filterType, zDecodeBooleanElement);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ParametricEQBand parametricEQBand = (ParametricEQBand) obj;
        parametricEQBand.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ParametricEQBand.$childSerializers;
        double d = parametricEQBand.frequency;
        boolean z = parametricEQBand.enabled;
        FilterType filterType = parametricEQBand.filterType;
        double d2 = parametricEQBand.q;
        compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 0, d);
        compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 1, parametricEQBand.gain);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || Double.compare(d2, 1.41d) != 0) {
            compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 2, d2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 3) || filterType != FilterType.PK) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, (SerializationStrategy) lazyArr[3].getValue(), filterType);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 4) || !z) {
            compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 4, z);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
