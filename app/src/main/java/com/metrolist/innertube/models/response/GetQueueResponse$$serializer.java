package com.metrolist.innertube.models.response;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Lazy;
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
public final /* synthetic */ class GetQueueResponse$$serializer implements GeneratedSerializer {
    public static final GetQueueResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        GetQueueResponse$$serializer getQueueResponse$$serializer = new GetQueueResponse$$serializer();
        INSTANCE = getQueueResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.response.GetQueueResponse", getQueueResponse$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("queueDatas", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{GetQueueResponse.$childSerializers[0].getValue()};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        List list;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Lazy[] lazyArr = GetQueueResponse.$childSerializers;
        int i = 1;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                    i2 = 1;
                }
            }
            list = list2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new GetQueueResponse(i, list);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        GetQueueResponse getQueueResponse = (GetQueueResponse) obj;
        getQueueResponse.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 0, (SerializationStrategy) GetQueueResponse.$childSerializers[0].getValue(), getQueueResponse.queueDatas);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
