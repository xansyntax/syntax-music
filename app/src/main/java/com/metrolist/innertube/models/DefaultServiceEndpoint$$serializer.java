package com.metrolist.innertube.models;

import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultServiceEndpoint$$serializer implements GeneratedSerializer {
    public static final DefaultServiceEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DefaultServiceEndpoint$$serializer defaultServiceEndpoint$$serializer = new DefaultServiceEndpoint$$serializer();
        INSTANCE = defaultServiceEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.DefaultServiceEndpoint", defaultServiceEndpoint$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement("subscribeEndpoint", false);
        pluginGeneratedSerialDescriptor.addElement("feedbackEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE), HexFormatKt.getNullable(FeedbackEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        DefaultServiceEndpoint.SubscribeEndpoint subscribeEndpoint;
        FeedbackEndpoint feedbackEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            subscribeEndpoint = (DefaultServiceEndpoint.SubscribeEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE, null);
            feedbackEndpoint = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FeedbackEndpoint$$serializer.INSTANCE, null);
            i = 3;
        } else {
            boolean z = true;
            i = 0;
            subscribeEndpoint = null;
            FeedbackEndpoint feedbackEndpoint2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    subscribeEndpoint = (DefaultServiceEndpoint.SubscribeEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE, subscribeEndpoint);
                    i |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    feedbackEndpoint2 = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, FeedbackEndpoint$$serializer.INSTANCE, feedbackEndpoint2);
                    i |= 2;
                }
            }
            feedbackEndpoint = feedbackEndpoint2;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(descriptor, i, 3);
            throw null;
        }
        DefaultServiceEndpoint defaultServiceEndpoint = new DefaultServiceEndpoint();
        defaultServiceEndpoint.subscribeEndpoint = subscribeEndpoint;
        defaultServiceEndpoint.feedbackEndpoint = feedbackEndpoint;
        return defaultServiceEndpoint;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        DefaultServiceEndpoint defaultServiceEndpoint = (DefaultServiceEndpoint) obj;
        defaultServiceEndpoint.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE, defaultServiceEndpoint.subscribeEndpoint);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 1, FeedbackEndpoint$$serializer.INSTANCE, defaultServiceEndpoint.feedbackEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
