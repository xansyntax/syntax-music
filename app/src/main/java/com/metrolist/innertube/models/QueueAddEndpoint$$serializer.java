package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
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
public final /* synthetic */ class QueueAddEndpoint$$serializer implements GeneratedSerializer {
    public static final QueueAddEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        QueueAddEndpoint$$serializer queueAddEndpoint$$serializer = new QueueAddEndpoint$$serializer();
        INSTANCE = queueAddEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.QueueAddEndpoint", queueAddEndpoint$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("queueInsertPosition", false);
        pluginGeneratedSerialDescriptor.addElement("queueTarget", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, QueueAddEndpoint$QueueTarget$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        String strDecodeStringElement;
        QueueAddEndpoint.QueueTarget queueTarget;
        int i;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
            queueTarget = (QueueAddEndpoint.QueueTarget) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, QueueAddEndpoint$QueueTarget$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            strDecodeStringElement = null;
            QueueAddEndpoint.QueueTarget queueTarget2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    queueTarget2 = (QueueAddEndpoint.QueueTarget) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 1, QueueAddEndpoint$QueueTarget$$serializer.INSTANCE, queueTarget2);
                    i2 |= 2;
                }
            }
            queueTarget = queueTarget2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new QueueAddEndpoint(i, strDecodeStringElement, queueTarget);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        QueueAddEndpoint queueAddEndpoint = (QueueAddEndpoint) obj;
        queueAddEndpoint.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(serialDescriptor, 0, queueAddEndpoint.queueInsertPosition);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 1, QueueAddEndpoint$QueueTarget$$serializer.INSTANCE, queueAddEndpoint.queueTarget);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
