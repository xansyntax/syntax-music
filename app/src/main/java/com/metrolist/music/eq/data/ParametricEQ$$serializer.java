package com.metrolist.music.eq.data;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ParametricEQ$$serializer implements GeneratedSerializer {
    public static final ParametricEQ$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ParametricEQ$$serializer parametricEQ$$serializer = new ParametricEQ$$serializer();
        INSTANCE = parametricEQ$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.music.eq.data.ParametricEQ", parametricEQ$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("preamp", false);
        pluginGeneratedSerialDescriptor.addElement("bands", false);
        pluginGeneratedSerialDescriptor.addElement("metadata", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        Lazy[] lazyArr = ParametricEQ.$childSerializers;
        return new KSerializer[]{DoubleSerializer.INSTANCE, lazyArr[1].getValue(), lazyArr[2].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Map map;
        List list;
        int i;
        double d;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ParametricEQ.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            double dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
            List list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), null);
            list = list2;
            i = 7;
            d = dDecodeDoubleElement;
        } else {
            boolean z = true;
            Map map2 = null;
            double dDecodeDoubleElement2 = 0.0d;
            int i2 = 0;
            List list3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), map2);
                    i2 |= 4;
                }
            }
            map = map2;
            list = list3;
            i = i2;
            d = dDecodeDoubleElement2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ParametricEQ(i, d, list, map);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ParametricEQ parametricEQ = (ParametricEQ) obj;
        parametricEQ.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ParametricEQ.$childSerializers;
        double d = parametricEQ.preamp;
        Map map = parametricEQ.metadata;
        compositeEncoderBeginStructure.encodeDoubleElement(serialDescriptor, 0, d);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, (SerializationStrategy) lazyArr[1].getValue(), parametricEQ.bands);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(map, EmptyMap.INSTANCE)) {
            compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 2, (SerializationStrategy) lazyArr[2].getValue(), map);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
