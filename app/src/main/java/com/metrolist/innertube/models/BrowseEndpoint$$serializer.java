package com.metrolist.innertube.models;

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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BrowseEndpoint$$serializer implements GeneratedSerializer {
    public static final BrowseEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        BrowseEndpoint$$serializer browseEndpoint$$serializer = new BrowseEndpoint$$serializer();
        INSTANCE = browseEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.BrowseEndpoint", browseEndpoint$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("browseId", false);
        pluginGeneratedSerialDescriptor.addElement("params", true);
        pluginGeneratedSerialDescriptor.addElement("browseEndpointContextSupportedConfigs", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, HexFormatKt.getNullable(stringSerializer), HexFormatKt.getNullable(BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        String str;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            browseEndpointContextSupportedConfigs = (BrowseEndpoint.BrowseEndpointContextSupportedConfigs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE, null);
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2 = null;
            String str2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    browseEndpointContextSupportedConfigs2 = (BrowseEndpoint.BrowseEndpointContextSupportedConfigs) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE, browseEndpointContextSupportedConfigs2);
                    i2 |= 4;
                }
            }
            browseEndpointContextSupportedConfigs = browseEndpointContextSupportedConfigs2;
            str = str2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new BrowseEndpoint(i, strDecodeStringElement, str, browseEndpointContextSupportedConfigs);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        BrowseEndpoint browseEndpoint = (BrowseEndpoint) obj;
        browseEndpoint.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        String str = browseEndpoint.browseId;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs;
        String str2 = browseEndpoint.params;
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, str);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 1) || str2 != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str2);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(serialDescriptor, 2) || browseEndpointContextSupportedConfigs != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 2, BrowseEndpoint$BrowseEndpointContextSupportedConfigs$$serializer.INSTANCE, browseEndpointContextSupportedConfigs);
        }
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
