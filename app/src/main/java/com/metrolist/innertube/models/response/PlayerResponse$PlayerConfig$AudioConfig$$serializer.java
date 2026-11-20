package com.metrolist.innertube.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
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
public final /* synthetic */ class PlayerResponse$PlayerConfig$AudioConfig$$serializer implements GeneratedSerializer {
    public static final PlayerResponse$PlayerConfig$AudioConfig$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PlayerResponse$PlayerConfig$AudioConfig$$serializer playerResponse$PlayerConfig$AudioConfig$$serializer = new PlayerResponse$PlayerConfig$AudioConfig$$serializer();
        INSTANCE = playerResponse$PlayerConfig$AudioConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.PlayerResponse.PlayerConfig.AudioConfig", playerResponse$PlayerConfig$AudioConfig$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("loudnessDb", false);
        pluginGeneratedSerialDescriptor.addElement("perceptualLoudnessDb", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{HexFormatKt.getNullable(doubleSerializer), HexFormatKt.getNullable(doubleSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Double d;
        int i;
        Double d2;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
            d2 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, doubleSerializer, null);
            d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, doubleSerializer, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            d = null;
            Double d3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    d3 = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DoubleSerializer.INSTANCE, d3);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    d = (Double) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, DoubleSerializer.INSTANCE, d);
                    i2 |= 2;
                }
            }
            i = i2;
            d2 = d3;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new PlayerResponse$PlayerConfig$AudioConfig(i, d2, d);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        PlayerResponse$PlayerConfig$AudioConfig playerResponse$PlayerConfig$AudioConfig = (PlayerResponse$PlayerConfig$AudioConfig) obj;
        playerResponse$PlayerConfig$AudioConfig.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, doubleSerializer, playerResponse$PlayerConfig$AudioConfig.loudnessDb);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, doubleSerializer, playerResponse$PlayerConfig$AudioConfig.perceptualLoudnessDb);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
