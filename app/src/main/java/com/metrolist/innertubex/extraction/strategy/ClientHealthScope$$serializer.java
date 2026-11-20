package com.metrolist.innertubex.extraction.strategy;

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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ClientHealthScope$$serializer implements GeneratedSerializer {
    public static final ClientHealthScope$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ClientHealthScope$$serializer clientHealthScope$$serializer = new ClientHealthScope$$serializer();
        INSTANCE = clientHealthScope$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertubex.extraction.strategy.ClientHealthScope", clientHealthScope$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("content", false);
        pluginGeneratedSerialDescriptor.addElement("authenticated", false);
        pluginGeneratedSerialDescriptor.addElement("wantVideo", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        return new KSerializer[]{ClientHealthScope.$childSerializers[0].getValue(), booleanSerializer, booleanSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        ClientHealthContent clientHealthContent;
        boolean zDecodeBooleanElement;
        boolean zDecodeBooleanElement2;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = ClientHealthScope.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            clientHealthContent = (ClientHealthContent) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
            zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
            i = 7;
        } else {
            boolean z = true;
            boolean zDecodeBooleanElement3 = false;
            boolean zDecodeBooleanElement4 = false;
            int i2 = 0;
            ClientHealthContent clientHealthContent2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    clientHealthContent2 = (ClientHealthContent) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), clientHealthContent2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    zDecodeBooleanElement3 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 1);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    zDecodeBooleanElement4 = compositeDecoderBeginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i2 |= 4;
                }
            }
            clientHealthContent = clientHealthContent2;
            zDecodeBooleanElement = zDecodeBooleanElement3;
            zDecodeBooleanElement2 = zDecodeBooleanElement4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new ClientHealthScope(i, clientHealthContent, zDecodeBooleanElement, zDecodeBooleanElement2);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ClientHealthScope clientHealthScope = (ClientHealthScope) obj;
        clientHealthScope.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, (SerializationStrategy) ClientHealthScope.$childSerializers[0].getValue(), clientHealthScope.content);
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 1, clientHealthScope.authenticated);
        compositeEncoderBeginStructure.encodeBooleanElement(serialDescriptor, 2, clientHealthScope.wantVideo);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
