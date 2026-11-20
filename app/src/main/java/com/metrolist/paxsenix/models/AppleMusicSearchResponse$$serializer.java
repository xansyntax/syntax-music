package com.metrolist.paxsenix.models;

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
public final /* synthetic */ class AppleMusicSearchResponse$$serializer implements GeneratedSerializer {
    public static final AppleMusicSearchResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        AppleMusicSearchResponse$$serializer appleMusicSearchResponse$$serializer = new AppleMusicSearchResponse$$serializer();
        INSTANCE = appleMusicSearchResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.paxsenix.models.AppleMusicSearchResponse", appleMusicSearchResponse$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("results", false);
        pluginGeneratedSerialDescriptor.addElement("resources", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{AppleMusicResults$$serializer.INSTANCE, HexFormatKt.getNullable(AppleMusicResources$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        AppleMusicResults appleMusicResults;
        AppleMusicResources appleMusicResources;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            appleMusicResults = (AppleMusicResults) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AppleMusicResults$$serializer.INSTANCE, null);
            appleMusicResources = (AppleMusicResources) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AppleMusicResources$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            appleMusicResults = null;
            AppleMusicResources appleMusicResources2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    appleMusicResults = (AppleMusicResults) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, AppleMusicResults$$serializer.INSTANCE, appleMusicResults);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    appleMusicResources2 = (AppleMusicResources) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, AppleMusicResources$$serializer.INSTANCE, appleMusicResources2);
                    i2 |= 2;
                }
            }
            appleMusicResources = appleMusicResources2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new AppleMusicSearchResponse(i, appleMusicResults, appleMusicResources);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        AppleMusicSearchResponse appleMusicSearchResponse = (AppleMusicSearchResponse) obj;
        appleMusicSearchResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        AppleMusicResults$$serializer appleMusicResults$$serializer = AppleMusicResults$$serializer.INSTANCE;
        AppleMusicResults appleMusicResults = appleMusicSearchResponse.results;
        AppleMusicResources appleMusicResources = appleMusicSearchResponse.resources;
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, appleMusicResults$$serializer, appleMusicResults);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || appleMusicResources != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, AppleMusicResources$$serializer.INSTANCE, appleMusicResources);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
