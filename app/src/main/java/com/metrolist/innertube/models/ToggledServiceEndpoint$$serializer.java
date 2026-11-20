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
public final /* synthetic */ class ToggledServiceEndpoint$$serializer implements GeneratedSerializer {
    public static final ToggledServiceEndpoint$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ToggledServiceEndpoint$$serializer toggledServiceEndpoint$$serializer = new ToggledServiceEndpoint$$serializer();
        INSTANCE = toggledServiceEndpoint$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.metrolist.innertube.models.ToggledServiceEndpoint", toggledServiceEndpoint$$serializer, 1);
        pluginGeneratedSerialDescriptor.addElement("feedbackEndpoint", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{HexFormatKt.getNullable(FeedbackEndpoint$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int i;
        FeedbackEndpoint feedbackEndpoint;
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            feedbackEndpoint = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FeedbackEndpoint$$serializer.INSTANCE, null);
            i = 1;
        } else {
            boolean z = true;
            i = 0;
            feedbackEndpoint = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        PathKt$$ExternalSyntheticBUOutline0.m(iDecodeElementIndex);
                        return null;
                    }
                    feedbackEndpoint = (FeedbackEndpoint) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, FeedbackEndpoint$$serializer.INSTANCE, feedbackEndpoint);
                    i = 1;
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        if (1 != i) {
            EnumsKt.throwMissingFieldException(descriptor, i, 1);
            throw null;
        }
        ToggledServiceEndpoint toggledServiceEndpoint = new ToggledServiceEndpoint();
        toggledServiceEndpoint.feedbackEndpoint = feedbackEndpoint;
        return toggledServiceEndpoint;
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        ToggledServiceEndpoint toggledServiceEndpoint = (ToggledServiceEndpoint) obj;
        toggledServiceEndpoint.getClass();
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        compositeEncoderBeginStructure.encodeNullableSerializableElement(serialDescriptor, 0, FeedbackEndpoint$$serializer.INSTANCE, toggledServiceEndpoint.feedbackEndpoint);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
